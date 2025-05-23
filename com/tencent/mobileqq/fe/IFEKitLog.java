package com.tencent.mobileqq.fe;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class IFEKitLog {
    static IPatchRedirector $redirector_;

    public IFEKitLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void d(String str, int i3, String str2);

    public abstract void e(String str, int i3, String str2);

    public abstract void i(String str, int i3, String str2);

    public abstract void v(String str, int i3, String str2);

    public abstract void w(String str, int i3, String str2);
}
