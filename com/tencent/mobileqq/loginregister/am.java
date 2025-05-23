package com.tencent.mobileqq.loginregister;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class am extends f {
    static IPatchRedirector $redirector_;

    public am() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.f, com.tencent.mobileqq.loginregister.s
    public boolean b(AppRuntime appRuntime, Class<?> cls, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 2, this, appRuntime, cls, Long.valueOf(j3))).booleanValue();
    }
}
