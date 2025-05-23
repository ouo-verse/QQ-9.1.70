package mp3;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.ReqHead;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.SdkInfo;
import com.tencent.tmassistant.common.jce.Ticket;
import com.tencent.tmassistant.common.jce.TicketWtLogin;
import com.tencent.tmassistantbase.network.PostHttpRequest;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class a extends PostHttpRequest {
    public int a(JceStruct jceStruct) {
        Request request;
        try {
            request = ProtocolPackage.buildRequest(jceStruct);
        } catch (Throwable unused) {
            request = null;
        }
        if (request == null) {
            return -1;
        }
        SdkInfo sdkInfo = new SdkInfo();
        sdkInfo.versionCode = 1;
        sdkInfo.versionName = com.tencent.open.adapter.a.f().d();
        sdkInfo.name = "AppNews";
        sdkInfo.channel = "";
        sdkInfo.builderNum = "";
        request.head.sdkInfo = sdkInfo;
        TicketWtLogin ticketWtLogin = new TicketWtLogin();
        ticketWtLogin.uin = com.tencent.open.adapter.a.f().l();
        ticketWtLogin.A2 = com.tencent.open.adapter.a.f().a().getBytes();
        Ticket ticket = new Ticket();
        ticket.value = ProtocolPackage.jceStructToUTF8Byte(ticketWtLogin);
        ticket.type = (byte) 1;
        ReqHead reqHead = request.head;
        reqHead.ticket = ticket;
        int i3 = reqHead.requestId;
        sendRequest(ProtocolPackage.buildPostData(request));
        return i3;
    }
}
