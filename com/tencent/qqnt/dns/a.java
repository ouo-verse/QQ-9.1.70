package com.tencent.qqnt.dns;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes24.dex */
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if ("ConfigPushSvc.GetIpDirect".equals(fromServiceMsg.getServiceCmd())) {
            b a16 = NtDnsManager.f355947a.a();
            if (a16 instanceof c) {
                ((c) a16).u(fromServiceMsg, false);
                if (QLog.isColorLevel()) {
                    QLog.i("IPDomainGet", 2, "onReceive response resultCode:" + fromServiceMsg.getResultCode() + " log:" + fromServiceMsg.getStringForLog());
                    return;
                }
                return;
            }
            QLog.e("IPDomainGet", 1, "otherProcess:" + MobileQQ.sProcessId + " get ip domain");
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("IPDomainGet", 2, "IPDomainGet onSend() ");
        }
        packet.setSSOCommand("ConfigPushSvc.GetIpDirect");
        packet.setTimeout(15000L);
    }
}
