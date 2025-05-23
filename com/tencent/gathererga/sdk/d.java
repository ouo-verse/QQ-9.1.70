package com.tencent.gathererga.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d extends com.tencent.gathererga.core.internal.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final d f108341d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56154);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f108341d = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static <T> T e(Class<T> cls) {
        return (T) f108341d.a(cls);
    }

    public static <T> void f(Class<T> cls, Class<?> cls2) {
        f108341d.d(cls, cls2);
    }

    @Override // com.tencent.gathererga.core.internal.a
    protected Object c(Class<?> cls, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls, obj);
        }
        return obj;
    }
}
