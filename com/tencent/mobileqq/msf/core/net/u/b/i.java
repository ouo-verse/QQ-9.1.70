package com.tencent.mobileqq.msf.core.net.u.b;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i implements d {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f249417a = "UdpOutboundCommandFilte";

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final i f249418a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17716);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f249418a = new i(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ i(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    @Override // com.tencent.mobileqq.msf.core.net.u.b.d
    public ToServiceMsg a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
        }
        if (toServiceMsg == null) {
            return null;
        }
        if (b(toServiceMsg)) {
            return toServiceMsg;
        }
        QLog.d(f249417a, 1, "[filter] message deprecated, cmd: ", toServiceMsg.getServiceCmd(), ", ssoSeq: ", Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
        return null;
    }

    public boolean b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg)).booleanValue();
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        if (!TextUtils.isEmpty(serviceCmd) && (serviceCmd.equals(BaseConstants.CMD_MSG_PBSENDMSG) || serviceCmd.equals("MsgProxy.SendMsg"))) {
            return true;
        }
        return false;
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static i a() {
        return b.f249418a;
    }
}
