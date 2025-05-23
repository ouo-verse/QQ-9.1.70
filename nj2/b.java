package nj2;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qqvideoedit.edit.manager.VideoDataBaseServiceHandler;
import com.tencent.mobileqq.qqvideoedit.edit.manager.VideoDataServiceHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        ToServiceMsg toServiceMsg;
        String name = VideoDataServiceHandler.class.getName();
        if (intent != null) {
            toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            if (!TextUtils.isEmpty(intent.getStringExtra("receive_handler"))) {
                name = intent.getStringExtra("receive_handler");
            }
            fromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
        } else {
            toServiceMsg = new ToServiceMsg("", fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd());
        }
        mj2.a.a("QQVideoEditMsfServlet", "onReceive... handler:" + name);
        VideoDataBaseServiceHandler videoDataBaseServiceHandler = (VideoDataBaseServiceHandler) com.tencent.mobileqq.qqvideoedit.a.a().getBusinessHandler(name);
        videoDataBaseServiceHandler.onReceive(toServiceMsg, fromServiceMsg, videoDataBaseServiceHandler.D2(toServiceMsg, fromServiceMsg));
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (intent != null) {
            ToServiceMsg toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            mj2.a.a("QQVideoEditMsfServlet", " onSend runhw:" + toServiceMsg);
            if (toServiceMsg != null) {
                packet.setSSOCommand(toServiceMsg.getServiceCmd());
                packet.putSendData(toServiceMsg.getWupBuffer());
                packet.setTimeout(toServiceMsg.getTimeout());
                packet.setAttributes(toServiceMsg.getAttributes());
                if (!toServiceMsg.isNeedCallback()) {
                    packet.setNoResponse();
                }
            }
        }
    }
}
