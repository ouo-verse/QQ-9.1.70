package com.tencent.od;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import dt3.g;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a() {
        return g.a("NowPostProguardPkgNameUtil", a.class);
    }
}
