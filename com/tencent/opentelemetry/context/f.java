package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class f<T> {
    public static <T> ContextKey<T> a(String str) {
        IPatchRedirector iPatchRedirector = ContextKey.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ContextKey) iPatchRedirector.redirect((short) 1, (Object) str);
        }
        return new DefaultContextKey(str);
    }
}
