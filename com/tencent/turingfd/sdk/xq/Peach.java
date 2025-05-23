package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public abstract class Peach<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public volatile T f382983a;

    public Peach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract T a();

    public final T b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        T t16 = this.f382983a;
        if (t16 == null) {
            synchronized (this) {
                t16 = this.f382983a;
                if (t16 == null) {
                    t16 = a();
                    this.f382983a = t16;
                }
            }
        }
        return t16;
    }
}
