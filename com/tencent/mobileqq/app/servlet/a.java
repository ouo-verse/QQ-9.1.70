package com.tencent.mobileqq.app.servlet;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.handler.TroopEnterEffectsHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes11.dex */
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
        long j3;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            j3 = System.currentTimeMillis();
            QLog.d("TroopExtensionServlet", 2, "onReceive cmd=" + intent.getStringExtra("cmd") + ",success=" + fromServiceMsg.isSuccess());
        } else {
            j3 = 0;
        }
        if (fromServiceMsg.isSuccess()) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            bArr = new byte[length];
            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        } else {
            bArr = null;
        }
        new TroopEnterEffectsHandler((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).D2(intent, fromServiceMsg, bArr);
        if (QLog.isColorLevel()) {
            QLog.d("TroopExtensionServlet", 2, "onReceive exit|cost: " + (System.currentTimeMillis() - j3));
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
        if (!TextUtils.isEmpty(stringExtra)) {
            packet.setSSOCommand(stringExtra);
            packet.setTimeout(longExtra);
            if (byteArrayExtra != null) {
                byte[] bArr = new byte[byteArrayExtra.length + 4];
                PkgTools.dWord2Byte(bArr, 0, byteArrayExtra.length + 4);
                PkgTools.copyData(bArr, 4, byteArrayExtra, byteArrayExtra.length);
                packet.putSendData(bArr);
            } else {
                byte[] bArr2 = new byte[4];
                PkgTools.dWord2Byte(bArr2, 0, 4L);
                packet.putSendData(bArr2);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopExtensionServlet", 2, "onSend exit cmd=" + stringExtra);
        }
    }
}
