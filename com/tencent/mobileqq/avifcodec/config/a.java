package com.tencent.mobileqq.avifcodec.config;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.avifcodec.api.IAvifConfigServiceApi;
import com.tencent.mobileqq.avifcodec.api.impl.AvifConfigServiceApiImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import x91.b;

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

    private b a() {
        IAvifConfigServiceApi iAvifConfigServiceApi = (IAvifConfigServiceApi) QRoute.api(IAvifConfigServiceApi.class);
        if (iAvifConfigServiceApi instanceof AvifConfigServiceApiImpl) {
            return (AvifConfigServiceApiImpl) iAvifConfigServiceApi;
        }
        return null;
    }

    private void b(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        int length = fromServiceMsg.getWupBuffer().length - 4;
        if (fromServiceMsg.isSuccess() && length > 0) {
            bArr = new byte[length];
            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        } else {
            bArr = null;
        }
        b a16 = a();
        if (a16 != null) {
            a16.onReceiveAvifConfig(bArr);
        }
    }

    private void c(Packet packet, Bundle bundle) {
        packet.setServantName("trpc.qqrtc.sharpsvrconfig.UniversalConfigSSO");
        packet.setFuncName("SsoGetUniversalConfig");
        packet.setSSOCommand("trpc.qqrtc.sharpsvrconfig.UniversalConfigSSO.SsoGetUniversalConfig");
        packet.addAttribute(BaseConstants.ATTRIBUTE_NEED_REMIND_SLOW_NETWORK, Boolean.TRUE);
        packet.setTimeout(10000L);
        packet.putSendData(fh.b(bundle.getByteArray("vMsg")));
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg == null) {
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        QLog.i("AvifConfigServlet", 1, "onReceive, cmd[" + serviceCmd + "]");
        if ("trpc.qqrtc.sharpsvrconfig.UniversalConfigSSO.SsoGetUniversalConfig".equalsIgnoreCase(serviceCmd)) {
            b(intent, fromServiceMsg);
            return;
        }
        QLog.w("AvifConfigServlet", 1, " onReceive cannot deal, cmd:=" + serviceCmd);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        int i3 = extras.getInt("reqType", -1);
        QLog.i("AvifConfigServlet", 1, "onSend, reqType[" + i3 + "]");
        if (i3 != 1) {
            QLog.w("AvifConfigServlet", 1, " reqType " + i3 + " not support");
            return;
        }
        c(packet, extras);
    }
}
