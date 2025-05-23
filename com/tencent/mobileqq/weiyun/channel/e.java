package com.tencent.mobileqq.weiyun.channel;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class e extends MSFServlet {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void a(ToServiceMsg toServiceMsg) {
        if (toServiceMsg.getWupBuffer() != null) {
            long length = toServiceMsg.getWupBuffer().length;
            int i3 = (int) length;
            byte[] bArr = new byte[i3 + 4];
            PkgTools.dWord2Byte(bArr, 0, length + 4);
            PkgTools.copyData(bArr, 4, toServiceMsg.getWupBuffer(), i3);
            toServiceMsg.putWupBuffer(bArr);
        }
    }

    private static void b(FromServiceMsg fromServiceMsg) {
        int length;
        if (fromServiceMsg.getWupBuffer() == null || (length = fromServiceMsg.getWupBuffer().length - 4) < 0) {
            return;
        }
        byte[] bArr = new byte[length];
        PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        fromServiceMsg.putWupBuffer(bArr);
    }

    @Override // mqq.app.MSFServlet
    public String[] getPreferSSOCommands() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new String[]{"WeiyunV2Svc.TransCmd"};
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        ToServiceMsg toServiceMsg;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        b(fromServiceMsg);
        if (intent == null) {
            toServiceMsg = new ToServiceMsg("", fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd());
        } else {
            toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            fromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
        }
        d.a().b(toServiceMsg, fromServiceMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        if (intent == null) {
            QLog.e("WyServlet", 1, "onSend : req is null");
            return;
        }
        ToServiceMsg toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
        if (toServiceMsg != null) {
            if (QLog.isColorLevel()) {
                QLog.d("WyServlet", 1, "onSend : cmd[" + toServiceMsg.getServiceCmd() + "]");
            }
            a(toServiceMsg);
            packet.setSSOCommand("WeiyunV2Svc.TransCmd");
            packet.putSendData(toServiceMsg.getWupBuffer());
            packet.setTimeout(toServiceMsg.getTimeout());
            packet.setAttributes(toServiceMsg.getAttributes());
            if (!toServiceMsg.isNeedCallback()) {
                packet.setNoResponse();
                return;
            }
            return;
        }
        QLog.e("WyServlet", 1, "onSend : toMsg is null");
    }
}
