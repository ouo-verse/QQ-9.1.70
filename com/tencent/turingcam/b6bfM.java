package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b6bfM<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public T f382155a;

    /* renamed from: b, reason: collision with root package name */
    public long f382156b;

    /* renamed from: c, reason: collision with root package name */
    public long f382157c;

    public b6bfM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public synchronized T a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        T t16 = this.f382155a;
        if (t16 == null) {
            return null;
        }
        long j3 = this.f382157c;
        if (j3 < 0) {
            return t16;
        }
        if (j3 != 0 && Math.abs(System.currentTimeMillis() - this.f382156b) <= this.f382157c) {
            return this.f382155a;
        }
        this.f382155a = null;
        return null;
    }
}
