package com.tencent.mobileqq.qqlive;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import dt3.g;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a() {
        return g.a("QQLivePostProguardPkgNameUtil", d.class);
    }
}
