package mqq.app.api.impl;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SSOEasyServlet extends MSFServlet {
    private static final String TAG = "SSOEasyServlet";

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        ToServiceMsg toServiceMsg;
        if (intent != null) {
            toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            fromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
        } else {
            toServiceMsg = new ToServiceMsg("", fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd());
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(ToServiceMsg.class.getSimpleName(), toServiceMsg);
        bundle.putParcelable(FromServiceMsg.class.getSimpleName(), fromServiceMsg);
        notifyObserver(intent, 0, fromServiceMsg.isSuccess(), bundle, null);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        ToServiceMsg toServiceMsg;
        if (intent != null && (toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName())) != null) {
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
