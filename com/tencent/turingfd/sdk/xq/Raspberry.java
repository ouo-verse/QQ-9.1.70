package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Raspberry<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public T f383057a;

    /* renamed from: b, reason: collision with root package name */
    public long f383058b;

    /* renamed from: c, reason: collision with root package name */
    public long f383059c;

    public Raspberry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public synchronized void a(T t16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, t16, Long.valueOf(j3));
        } else {
            if (t16 == null) {
                return;
            }
            this.f383057a = t16;
            this.f383058b = System.currentTimeMillis();
            this.f383059c = j3;
        }
    }

    public synchronized T a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        T t16 = this.f383057a;
        if (t16 == null) {
            return null;
        }
        long j3 = this.f383059c;
        if (j3 < 0) {
            return t16;
        }
        if (j3 != 0 && Math.abs(System.currentTimeMillis() - this.f383058b) <= this.f383059c) {
            return this.f383057a;
        }
        this.f383057a = null;
        return null;
    }
}
