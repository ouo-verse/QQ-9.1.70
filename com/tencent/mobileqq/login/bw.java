package com.tencent.mobileqq.login;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class bw extends l {
    static IPatchRedirector $redirector_;

    public bw(int i3, boolean z16, boolean z17) {
        super(6, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            this.f242202c = z16;
            this.f242203d = z17;
        }
    }
}
