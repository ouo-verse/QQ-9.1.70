package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppOpenChannelAbstractServlet extends MiniAppAbstractServlet {
    private static final String CMD_STRING = "LightAppSvc.mini_webapp.OpenChannel";
    private static final String TAG = "MiniAppOpenChannelAbstractServlet";

    public MiniAppOpenChannelAbstractServlet() {
        this.observerId = 1054;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        if (fromServiceMsg != null) {
            try {
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5 + "onReceive error");
                notifyObserver(intent, 1054, false, bundle, MiniAppObserver.class);
            }
            if (fromServiceMsg.isSuccess()) {
                bundle.putByteArray("responsedata", fh.a(fromServiceMsg.getWupBuffer()));
                notifyObserver(intent, 1054, true, bundle, MiniAppObserver.class);
                doReport(intent, fromServiceMsg);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onReceive. rsp = " + fromServiceMsg);
        }
        notifyObserver(intent, 1054, false, bundle, MiniAppObserver.class);
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_data");
        if (byteArrayExtra == null) {
            byteArrayExtra = new byte[4];
        }
        packet.setSSOCommand(CMD_STRING);
        packet.putSendData(fh.b(byteArrayExtra));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
