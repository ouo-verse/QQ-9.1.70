package com.tencent.qav.observer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends FilterableObservable {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f342411e;

    /* renamed from: f, reason: collision with root package name */
    private static b f342412f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39996);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f342411e = new Object();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b f() {
        if (f342412f == null) {
            synchronized (f342411e) {
                if (f342412f == null) {
                    f342412f = new b();
                }
            }
        }
        return f342412f;
    }

    @Override // com.tencent.qav.observer.FilterableObservable
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.b();
            f342412f = null;
        }
    }
}
