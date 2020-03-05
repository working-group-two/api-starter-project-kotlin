package example

import com.wgtwo.api.auth.v0.RightServiceGrpc
import com.wgtwo.api.common.Environment
import com.wgtwo.api.events.v0.EventsServiceGrpc
import com.wgtwo.api.messaging.v0.VoicemailMediaServiceGrpc
import com.wgtwo.api.rest.ApiClient
import com.wgtwo.api.rest.handler.SubscriptionProfileApi
import com.wgtwo.api.util.auth.Clients
import com.wgtwo.api.util.auth.OperatorToken
import io.omnicate.messaging.protobuf.MessageCoreGrpc

// grpc clients
private val channel = Clients.createChannel(Environment.PROD)
private val credentials = OperatorToken("CLIENT_ID", "CLIENT_SECRET")
private val voicemailStub = VoicemailMediaServiceGrpc.newBlockingStub(channel).withCallCredentials(credentials)
private val eventsStub = EventsServiceGrpc.newStub(channel).withCallCredentials(credentials)
private val messagingStub = MessageCoreGrpc.newBlockingStub(channel).withCallCredentials(credentials)
private val rightsStub = RightServiceGrpc.newBlockingStub(channel).withCallCredentials(credentials)

// rest clients (this will be replaced by grpc at some point)
private val subscriptionProfileApi = SubscriptionProfileApi(ApiClient().apply {
    setUsername("CLIENT_ID")
    setPassword("CLIENT_SECRET")
})

fun main() {
    println("Hello, World!")
}
