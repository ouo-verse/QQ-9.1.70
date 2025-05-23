package com.tencent.mobileqq.unifiedebug;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes19.dex */
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
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UnifiedDebugReportServlet", 2, "onReceive");
        }
        if (fromServiceMsg.isSuccess()) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            bArr = new byte[length];
            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        } else {
            bArr = null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(WadlProxyConsts.EXTRA_RESULT_CODE, fromServiceMsg.getResultCode());
        bundle.putString(WadlProxyConsts.EXTRA_CMD, intent.getStringExtra(WadlProxyConsts.EXTRA_CMD));
        bundle.putByteArray("extra_data", bArr);
        notifyObserver(intent, 0, fromServiceMsg.isSuccess(), bundle, null);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UnifiedDebugReportServlet", 2, "onSend");
        }
        String stringExtra = intent.getStringExtra(WadlProxyConsts.EXTRA_CMD);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("extra_data");
        packet.setSSOCommand(stringExtra);
        if (byteArrayExtra != null) {
            byte[] bArr = new byte[byteArrayExtra.length + 4];
            PkgTools.dWord2Byte(bArr, 0, byteArrayExtra.length + 4);
            PkgTools.copyData(bArr, 4, byteArrayExtra, byteArrayExtra.length);
            packet.putSendData(bArr);
        }
    }
}
