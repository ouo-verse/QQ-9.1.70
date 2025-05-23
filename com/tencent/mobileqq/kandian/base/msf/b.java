package com.tencent.mobileqq.kandian.base.msf;

import android.content.Intent;
import com.tencent.mobileqq.transfile.ProtoServlet;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        ToServiceMsg toServiceMsg;
        if (intent != null) {
            toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            fromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
        } else {
            toServiceMsg = new ToServiceMsg("", fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd());
        }
        com.tencent.mobileqq.kandian.base.utils.a.a(fromServiceMsg);
        if (getAppRuntime() != null) {
            ReadInJoyMSFService.f().h(fromServiceMsg.isSuccess(), toServiceMsg, fromServiceMsg, null);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (intent != null) {
            ToServiceMsg toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            com.tencent.mobileqq.kandian.base.utils.a.b(toServiceMsg);
            if (toServiceMsg != null) {
                packet.setSSOCommand(toServiceMsg.getServiceCmd());
                packet.putSendData(toServiceMsg.getWupBuffer());
                packet.setTimeout(toServiceMsg.getTimeout());
                packet.setAttributes(toServiceMsg.getAttributes());
                packet.setQuickSend(intent.getBooleanExtra(ProtoServlet.QUICK_SEND_ENABLE, false), intent.getIntExtra(ProtoServlet.QUICK_SEND_STRATEGY, 0));
                packet.autoResend = toServiceMsg.isFastResendEnabled();
                if (toServiceMsg.isNeedCallback()) {
                    return;
                }
                packet.setNoResponse();
            }
        }
    }
}
