package com.tencent.mobileqq.jsp;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes15.dex */
public class am extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static long f238847d;

    /* renamed from: e, reason: collision with root package name */
    public static long f238848e;

    /* renamed from: f, reason: collision with root package name */
    public static long f238849f;

    /* renamed from: h, reason: collision with root package name */
    public static long f238850h;

    public am() {
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
        f238849f = System.currentTimeMillis();
        if (QLog.isDevelopLevel()) {
            QLog.d("WebSSOAgentServlet", 2, "onReceive");
        }
        if (fromServiceMsg.isSuccess()) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            bArr = new byte[length];
            com.tencent.mobileqq.webview.util.c.b(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        } else {
            bArr = null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(WadlProxyConsts.EXTRA_RESULT_CODE, fromServiceMsg.getResultCode());
        bundle.putString("extra_result_err_msg", fromServiceMsg.getBusinessFailMsg());
        bundle.putString(WadlProxyConsts.EXTRA_CMD, intent.getStringExtra(WadlProxyConsts.EXTRA_CMD));
        bundle.putString("extra_callbackid", intent.getStringExtra("extra_callbackid"));
        bundle.putByteArray("extra_data", bArr);
        notifyObserver(intent, 0, fromServiceMsg.isSuccess(), bundle, null);
        ToServiceMsg toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
        if ((getAppRuntime() instanceof AppInterface) && toServiceMsg != null) {
            fromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
            ((AppInterface) getAppRuntime()).receiveToService(toServiceMsg, fromServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("WebSSOAgentServlet", 2, "onSend");
        }
        String stringExtra = intent.getStringExtra(WadlProxyConsts.EXTRA_CMD);
        if (stringExtra == null) {
            ToServiceMsg toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            if (toServiceMsg != null) {
                packet.setSSOCommand(toServiceMsg.getServiceCmd());
                packet.putSendData(toServiceMsg.getWupBuffer());
                packet.setTimeout(toServiceMsg.getTimeout());
                packet.setAttributes(toServiceMsg.getAttributes());
                if (!toServiceMsg.isNeedCallback()) {
                    packet.setNoResponse();
                    return;
                }
                return;
            }
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("extra_data");
        packet.setSSOCommand(stringExtra);
        long longExtra = intent.getLongExtra("extra_timeout", -1L);
        if (longExtra > 0) {
            packet.setTimeout(longExtra);
        }
        if (byteArrayExtra != null) {
            byte[] bArr = new byte[byteArrayExtra.length + 4];
            com.tencent.mobileqq.webview.util.c.c(bArr, 0, byteArrayExtra.length + 4);
            com.tencent.mobileqq.webview.util.c.a(bArr, 4, byteArrayExtra, byteArrayExtra.length);
            packet.putSendData(bArr);
        }
        f238848e = System.currentTimeMillis();
    }
}
