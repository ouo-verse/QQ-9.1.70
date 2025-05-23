package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class h {
    public static Scope a(ImplicitContextKeyed implicitContextKeyed) {
        IPatchRedirector iPatchRedirector = ImplicitContextKeyed.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Scope) iPatchRedirector.redirect((short) 1, (Object) implicitContextKeyed);
        }
        return e.k().with(implicitContextKeyed).makeCurrent();
    }
}
