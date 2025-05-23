package com.tencent.mobileqq.msf.core.f0;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a a(MsfCore msfCore, boolean z16) {
        if (z16) {
            return new com.tencent.mobileqq.msf.core.f0.c.b(msfCore);
        }
        return new com.tencent.mobileqq.msf.core.f0.d.a();
    }
}
