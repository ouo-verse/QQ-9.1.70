package com.tencent.creatorad.servlet;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends MSFServlet {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (intent != null && fromServiceMsg != null) {
            if (QLog.isColorLevel()) {
                QLog.d("CreatorAdServlet", 2, "onReceive cmd=" + intent.getStringExtra("cmd") + ",success=" + fromServiceMsg.isSuccess());
            }
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (serviceCmd == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                boolean isSuccess = fromServiceMsg.isSuccess();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("resp:");
                sb5.append(serviceCmd);
                sb5.append(" is ");
                if (isSuccess) {
                    str = "";
                } else {
                    str = "not";
                }
                sb5.append(str);
                sb5.append(" success");
                QLog.d("CreatorAdServlet", 2, sb5.toString());
            }
            if (serviceCmd.equals("trpc.creator.reader.CreatorReader.SsoGetShareAD")) {
                b.b().c(intent, fromServiceMsg);
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        String stringExtra = intent.getStringExtra("cmd");
        long longExtra = intent.getLongExtra("timeout", 10000L);
        packet.setSSOCommand(stringExtra);
        packet.setTimeout(longExtra);
        packet.putSendData(byteArrayExtra);
        if (QLog.isColorLevel()) {
            QLog.d("CreatorAdServlet", 2, "onSend exit cmd=" + stringExtra);
        }
    }
}
