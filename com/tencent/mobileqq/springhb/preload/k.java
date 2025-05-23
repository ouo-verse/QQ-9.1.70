package com.tencent.mobileqq.springhb.preload;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k extends com.tencent.biz.m {
    static IPatchRedirector $redirector_;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.biz.m, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpringHb_Preload_SpringHbPreloadServlet", 2, "[onReceive] ,success=" + fromServiceMsg.isSuccess() + ", retCode=" + fromServiceMsg.getResultCode());
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
        bundle.putString("cmd", fromServiceMsg.getServiceCmd());
        bundle.putInt("act_type", intent.getIntExtra("act_type", 0));
        bundle.putByteArray("data", bArr);
        notifyObserver(intent, 0, fromServiceMsg.isSuccess(), bundle, null);
    }

    @Override // com.tencent.biz.m, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        long longExtra = intent.getLongExtra("timeout", 30000L);
        int intExtra = intent.getIntExtra("act_type", 0);
        if (intExtra == 0) {
            QLog.i("SpringHb_Preload_SpringHbPreloadServlet", 1, "use sys cmd+++++++++++++");
            packet.setSSOCommand("trpc.gamecenter.sys_predownload_svr.SysPredownloadSvr.SsoNYGetPreload");
        } else if (intExtra == 1) {
            packet.setSSOCommand("trpc.redpacket.predownload.Predownload.SsoNYGetPreload");
            QLog.i("SpringHb_Preload_SpringHbPreloadServlet", 1, "use easter cmd+++++++++++++");
        }
        packet.setTimeout(longExtra);
        packet.putSendData(byteArrayExtra);
        if (QLog.isColorLevel()) {
            QLog.d("SpringHb_Preload_SpringHbPreloadServlet", 2, "[onSend] ");
        }
    }
}
