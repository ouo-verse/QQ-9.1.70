package com.tencent.mobileqq.zootopia.sso;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (intent != null) {
            ToServiceMsg toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            if (toServiceMsg != null) {
                packet.setSSOCommand(toServiceMsg.getServiceCmd());
                packet.putSendData(toServiceMsg.getWupBuffer());
                packet.setTimeout(toServiceMsg.getTimeout());
                packet.setAttributes(toServiceMsg.getAttributes());
                if (QLog.isDevelopLevel()) {
                    QLog.i(MSFServlet.TAG, 4, "send, cmd[" + toServiceMsg.getServiceCmd() + "]");
                    return;
                }
                return;
            }
            QLog.e(MSFServlet.TAG, 1, "[onSend] toMsg is null");
            return;
        }
        QLog.e(MSFServlet.TAG, 1, "[onSend] request is null");
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
            QLog.i(MSFServlet.TAG, 4, "onReceive, cmd[" + fromServiceMsg.getServiceCmd() + "]");
        }
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (appInterface != null && toServiceMsg != null) {
            appInterface.receiveToService(toServiceMsg, fromServiceMsg);
        } else {
            QLog.e(MSFServlet.TAG, 1, "[onReceive] appInterface is null!");
        }
    }
}
