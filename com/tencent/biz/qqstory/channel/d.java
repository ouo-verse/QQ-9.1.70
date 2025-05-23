package com.tencent.biz.qqstory.channel;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class d extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (fromServiceMsg.isSuccess()) {
            bArr = fh.a(fromServiceMsg.getWupBuffer());
            extras.putInt("data_error_code", 0);
        } else {
            extras.putString("data_error_msg", fromServiceMsg.getBusinessFailMsg());
            extras.putInt("data_error_code", fromServiceMsg.getBusinessFailCode());
            bArr = null;
        }
        QQStoryContext.h().c().g(extras, bArr);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        packet.setSSOCommand(intent.getStringExtra("cmd"));
        packet.putSendData(fh.b(byteArrayExtra));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        packet.autoResend = intent.getBooleanExtra("support_retry", false);
    }
}
