package com.tencent.mobileqq.servlet;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneMsfPushAckRequest;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes35.dex */
public class n extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (intent == null) {
            return;
        }
        long longExtra = intent.getLongExtra("timestamp", 0L);
        byte[] encode = new QZoneMsfPushAckRequest(intent.getLongExtra("hostuin", 0L), longExtra, intent.getStringExtra("refer"), intent.getLongExtra("flag", 0L), intent.getStringExtra("mark")).encode();
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setTimeout(60000L);
        packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + QZoneMsfPushAckRequest.CMD_STRING);
        packet.putSendData(encode);
        QLog.d("MessageSvc.WNSQzone.Push", 2, "\u53d1\u9001push ack \u65f6\u95f4:" + longExtra);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
    }
}
