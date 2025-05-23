package com.tencent.mobileqq.miniapp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class e<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<T> f246812a;

    public e(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) t16);
        } else {
            this.f246812a = new WeakReference<>(t16);
        }
    }

    public abstract void a(T t16, boolean z16, d dVar);
}
