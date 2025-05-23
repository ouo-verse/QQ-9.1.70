package com.tencent.mobileqq.msf.core.net.u.b;

import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g implements d {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f249416a = "RetryFilter";

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.u.b.d
    public ToServiceMsg a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg);
        }
        if (toServiceMsg == null) {
            return null;
        }
        Integer num = (Integer) toServiceMsg.getAttribute(MsfConstants.ATTR_UDP_RETRY_COUNT);
        if (num == null) {
            num = 0;
        }
        Integer valueOf = Integer.valueOf(num.intValue() + 1);
        QLog.d(f249416a, 1, "[filter] retry: ", num, ", max: ", Integer.valueOf(com.tencent.mobileqq.msf.core.x.d.W0()), com.tencent.mobileqq.msf.core.z.a.b(toServiceMsg));
        toServiceMsg.addAttribute(MsfConstants.ATTR_UDP_RETRY_COUNT, valueOf);
        if (valueOf.intValue() > com.tencent.mobileqq.msf.core.x.d.W0()) {
            QLog.d(f249416a, 1, "[filter] stop retry: ", com.tencent.mobileqq.msf.core.z.a.b(toServiceMsg));
            return null;
        }
        return toServiceMsg;
    }
}
