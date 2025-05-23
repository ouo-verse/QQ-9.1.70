package com.tencent.qimei.t;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.uin.U;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @com.tencent.qimei.p.b
    public static boolean s(String str) {
        return U.c(str);
    }
}
