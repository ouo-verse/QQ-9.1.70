package com.tencent.av.business.servlet;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a extends MSFServlet {
    protected abstract void a(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg);

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        ToServiceMsg toServiceMsg = new ToServiceMsg("", fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd());
        if (intent != null) {
            toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            fromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onReceive toMsg cmd: ");
            if (toServiceMsg != null) {
                str = toServiceMsg.getServiceCmd();
            } else {
                str = null;
            }
            sb5.append(str);
            QLog.i("BaseServlet", 2, sb5.toString());
        }
        a(fromServiceMsg, toServiceMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        ToServiceMsg toServiceMsg;
        if (intent == null || (toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName())) == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BaseServlet", 2, "onSend msg cmd: " + toServiceMsg.getServiceCmd());
        }
        if (packet != null) {
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
