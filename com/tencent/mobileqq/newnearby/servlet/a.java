package com.tencent.mobileqq.newnearby.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        packet.setSSOCommand(intent.getStringExtra("cmd"));
        packet.putSendData(fh.b(byteArrayExtra));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
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
    }
}
