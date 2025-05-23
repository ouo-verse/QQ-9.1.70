package com.tencent.mobileqq.app;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SecMsgServlet extends MSFServlet {
    static IPatchRedirector $redirector_ = null;
    private static final String CMD_PREFIX = "secmsg.";
    public static final String EXTRA_CMD = "cmd";
    public static final String EXTRA_DATA = "data";
    public static final String EXTRA_TIMEOUT = "timeout";
    private static final String TAG = "SecMsgServlet";

    public SecMsgServlet() {
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
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onReceive cmd=" + intent.getStringExtra("cmd"));
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
            QLog.d(TAG, 2, "onSend cmd=" + intent.getStringExtra("cmd"));
        }
        String stringExtra = intent.getStringExtra("cmd");
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        long longExtra = intent.getLongExtra("timeout", 30000L);
        packet.setSSOCommand(CMD_PREFIX + stringExtra);
        packet.setTimeout(longExtra);
        if (byteArrayExtra != null) {
            byte[] bArr = new byte[byteArrayExtra.length + 4];
            PkgTools.dWord2Byte(bArr, 0, byteArrayExtra.length + 4);
            PkgTools.copyData(bArr, 4, byteArrayExtra, byteArrayExtra.length);
            packet.putSendData(bArr);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onSend exit");
        }
    }
}
