package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes11.dex */
public class db extends MSFServlet {
    static IPatchRedirector $redirector_;

    public db() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SignatureServlet", 2, "onReceive cmd=" + intent.getStringExtra("cmd"));
        }
        if (fromServiceMsg.isSuccess()) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            bArr = new byte[length];
            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        } else {
            bArr = null;
        }
        new Bundle().putByteArray("data", bArr);
        SignatureHandler signatureHandler = (SignatureHandler) ((QQAppInterface) super.getAppRuntime()).getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
        if (signatureHandler != null) {
            signatureHandler.onReceive(intent, fromServiceMsg, bArr);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SignatureServlet", 2, "onReceive exit");
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        String stringExtra = intent.getStringExtra("cmd");
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        long longExtra = intent.getLongExtra("timeout", 30000L);
        if (!TextUtils.isEmpty(stringExtra) && byteArrayExtra != null) {
            packet.setSSOCommand(stringExtra);
            packet.setTimeout(longExtra);
            byte[] bArr = new byte[byteArrayExtra.length + 4];
            PkgTools.dWord2Byte(bArr, 0, byteArrayExtra.length + 4);
            PkgTools.copyData(bArr, 4, byteArrayExtra, byteArrayExtra.length);
            packet.putSendData(bArr);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SignatureServlet", 2, "onSend exit cmd=" + stringExtra);
        }
    }
}
