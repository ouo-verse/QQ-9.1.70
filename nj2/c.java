package nj2;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.qqvideoedit.edit.manager.VideoDataBaseServiceHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static String f420243a = "QQVideoEditSendService";

    /* renamed from: b, reason: collision with root package name */
    public static volatile int f420244b;

    public static void a(ToServiceMsg toServiceMsg, String str, Class<? extends MSFServlet> cls) {
        String serviceCmd = toServiceMsg.getServiceCmd();
        boolean z16 = true;
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setEncodeName("utf-8");
        int i3 = f420244b;
        f420244b = i3 + 1;
        uniPacket.setRequestId(i3);
        VideoDataBaseServiceHandler videoDataBaseServiceHandler = (VideoDataBaseServiceHandler) com.tencent.mobileqq.qqvideoedit.a.a().getBusinessHandler(str);
        if (videoDataBaseServiceHandler.F2(toServiceMsg, uniPacket)) {
            toServiceMsg.putWupBuffer(uniPacket.encode());
        } else {
            z16 = false;
        }
        if (z16) {
            NewIntent newIntent = new NewIntent(com.tencent.mobileqq.qqvideoedit.a.c(), cls);
            newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
            newIntent.putExtra("receive_handler", str);
            com.tencent.mobileqq.qqvideoedit.a.a().startServlet(newIntent);
            toServiceMsg.extraData.putLong("sendtimekey", System.currentTimeMillis());
            return;
        }
        try {
            videoDataBaseServiceHandler.onReceive(toServiceMsg, new FromServiceMsg(com.tencent.mobileqq.qqvideoedit.a.b().getCurrentAccountUin(), serviceCmd), null);
        } catch (Exception e16) {
            e16.printStackTrace();
            mj2.a.c(f420243a, videoDataBaseServiceHandler.getClass().getSimpleName() + " onReceive error,", e16);
        }
    }
}
