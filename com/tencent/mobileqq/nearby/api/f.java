package com.tencent.mobileqq.nearby.api;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class f extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public String[] getPreferSSOCommands() {
        return null;
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        ToServiceMsg toServiceMsg;
        if (intent != null) {
            toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            fromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
        } else {
            toServiceMsg = new ToServiceMsg("", fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd());
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("NearbyServlet", 4, "onReceive: " + fromServiceMsg.getServiceCmd());
        }
        ((INearbyAppInterface) getAppRuntime()).receiveToService(toServiceMsg, fromServiceMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        ToServiceMsg toServiceMsg;
        if (intent == null || (toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName())) == null) {
            return;
        }
        packet.setSSOCommand(toServiceMsg.getServiceCmd());
        packet.putSendData(toServiceMsg.getWupBuffer());
        packet.setTimeout(toServiceMsg.getTimeout());
        packet.setAttributes(toServiceMsg.getAttributes());
        if (!toServiceMsg.isNeedCallback()) {
            packet.setNoResponse();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("NearbyServlet", 4, "send: " + toServiceMsg.getServiceCmd());
        }
    }
}
