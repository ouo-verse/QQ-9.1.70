package com.tencent.relation.common.servlet;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class d extends MSFServlet {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void a(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr);

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            bArr = new byte[length];
            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        } else {
            bArr = null;
        }
        a(intent, fromServiceMsg, bArr);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        if (intent != null && packet != null) {
            String stringExtra = intent.getStringExtra("cmd");
            byte[] byteArrayExtra = intent.getByteArrayExtra("data");
            long longExtra = intent.getLongExtra("timeout", 30000L);
            packet.setSSOCommand(stringExtra);
            packet.setTimeout(longExtra);
            if (byteArrayExtra == null) {
                bArr = new byte[4];
                PkgTools.dWord2Byte(bArr, 0, 4L);
            } else {
                byte[] bArr2 = new byte[byteArrayExtra.length + 4];
                PkgTools.dWord2Byte(bArr2, 0, byteArrayExtra.length + 4);
                PkgTools.copyData(bArr2, 4, byteArrayExtra, byteArrayExtra.length);
                bArr = bArr2;
            }
            packet.putSendData(bArr);
        }
    }
}
