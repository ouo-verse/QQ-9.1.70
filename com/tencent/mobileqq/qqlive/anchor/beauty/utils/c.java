package com.tencent.mobileqq.qqlive.anchor.beauty.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private long f270552a;

    /* renamed from: b, reason: collision with root package name */
    private long f270553b;

    /* renamed from: c, reason: collision with root package name */
    private long f270554c;

    /* renamed from: d, reason: collision with root package name */
    private long f270555d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f270556e;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f270552a = -1L;
        }
    }

    public long a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, j3)).longValue();
        }
        if (this.f270552a == -1) {
            this.f270552a = j3;
        }
        if (this.f270556e) {
            this.f270555d += j3 - this.f270553b;
            this.f270553b = j3;
            return this.f270554c;
        }
        this.f270553b = j3;
        long j16 = (j3 - this.f270552a) - this.f270555d;
        this.f270554c = j16;
        return j16;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f270552a = -1L;
        this.f270553b = 0L;
        this.f270554c = 0L;
        this.f270555d = 0L;
        this.f270556e = false;
    }
}
