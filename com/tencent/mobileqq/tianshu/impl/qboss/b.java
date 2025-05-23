package com.tencent.mobileqq.tianshu.impl.qboss;

import NS_MOBILE_QBOSS_PROTO.MobileQbossReportExceptionRsp;
import android.content.Intent;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends MSFServlet {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg != null) {
            i3 = fromServiceMsg.getResultCode();
        } else {
            i3 = -1;
        }
        if (i3 == 1000 && fromServiceMsg != null) {
            MobileQbossReportExceptionRsp a16 = a.a(fromServiceMsg.getWupBuffer());
            if (a16 != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QbossErrorReportServlet", 2, "report qboss success state = " + a16.iRet);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QbossErrorReportServlet", 2, "report qboss exception fail, decode result is null");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QbossErrorReportServlet", 2, "QZONE_GET_QBOSS_DATA fail, resultCode=" + i3);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        a aVar = new a(intent.getLongExtra("uin", 0L), intent.getIntExtra("appId", 0), intent.getIntExtra(MiniAppGetGameTaskTicketServlet.KEY_TASKID, 0), intent.getIntExtra("code", 0), intent.getStringExtra("message"));
        byte[] encode = aVar.encode();
        if (encode == null) {
            QLog.e("QbossErrorReportServlet", 1, "onSend request encode result is null.cmd=" + aVar.uniKey());
            encode = new byte[4];
        }
        packet.setTimeout(60000L);
        packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + aVar.uniKey());
        packet.putSendData(encode);
    }
}
