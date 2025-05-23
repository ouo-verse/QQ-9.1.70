package com.tencent.mobileqq.Doraemon.impl.commonModule;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AppInfoError extends Error {
    static IPatchRedirector $redirector_;
    public int type;

    public AppInfoError(int i3, String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
        } else {
            this.type = i3;
        }
    }
}
