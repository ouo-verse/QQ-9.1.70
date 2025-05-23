package com.tencent.biz;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes2.dex */
public class m extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        if (QLog.isColorLevel()) {
            QLog.i(MSFServlet.TAG, 2, "onReceive");
        }
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (fromServiceMsg.isSuccess()) {
            bArr = fh.a(fromServiceMsg.getWupBuffer());
        } else {
            extras.putString("data_error_msg", fromServiceMsg.getBusinessFailMsg());
            extras.putInt("data_error_code", fromServiceMsg.getBusinessFailCode());
            bArr = null;
        }
        extras.putByteArray("data", bArr);
        notifyObserver(intent, 0, fromServiceMsg.isSuccess(), extras, null);
        if (QLog.isColorLevel()) {
            QLog.i(MSFServlet.TAG, 2, "onReceive exit");
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (QLog.isColorLevel()) {
            QLog.i(MSFServlet.TAG, 2, "onSend");
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        packet.setSSOCommand(intent.getStringExtra("cmd"));
        packet.putSendData(fh.b(byteArrayExtra));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        if (QLog.isColorLevel()) {
            QLog.i(MSFServlet.TAG, 2, "onSend exit");
        }
    }
}
