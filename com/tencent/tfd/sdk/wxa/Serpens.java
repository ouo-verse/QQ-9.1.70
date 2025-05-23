package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Serpens {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final long f375688a;

    /* renamed from: b, reason: collision with root package name */
    public int f375689b;

    /* renamed from: c, reason: collision with root package name */
    public int f375690c;

    /* renamed from: d, reason: collision with root package name */
    public int f375691d;

    /* renamed from: e, reason: collision with root package name */
    public long f375692e;

    /* renamed from: f, reason: collision with root package name */
    public long f375693f;

    public Serpens() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f375689b = -1;
        this.f375690c = -1;
        this.f375691d = 0;
        this.f375692e = -1L;
        this.f375693f = -1L;
        this.f375688a = System.currentTimeMillis();
    }
}
