package com.qwallet.activity.sso;

import android.content.Intent;
import com.qwallet.activity.QWalletAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e extends MSFServlet {

    /* renamed from: d, reason: collision with root package name */
    public static final String f41398d = "com.qwallet.activity.sso.e";

    /* renamed from: e, reason: collision with root package name */
    protected static QWalletAppInterface f41399e;

    public static void a(QWalletAppInterface qWalletAppInterface) {
        f41399e = qWalletAppInterface;
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int intExtra = intent.getIntExtra("id", 0);
        f41399e.getQWalletProtocolById(intExtra).q(intent.getIntExtra(QCircleQualityReporter.KEY_ID, -1), fromServiceMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        try {
            int intExtra = intent.getIntExtra("id", 0);
            ToServiceMsg toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getName());
            String serviceCmd = toServiceMsg.getServiceCmd();
            f41399e.getQWalletProtocolById(intExtra).j(toServiceMsg, packet);
            packet.setSSOCommand(serviceCmd);
            packet.setTimeout(15000L);
            if (!toServiceMsg.isNeedCallback()) {
                packet.setNoResponse();
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.i(f41398d, 2, "onSend exception");
            }
        }
    }
}
