package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Grape {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final long f382793a;

    /* renamed from: b, reason: collision with root package name */
    public int f382794b;

    /* renamed from: c, reason: collision with root package name */
    public int f382795c;

    /* renamed from: d, reason: collision with root package name */
    public int f382796d;

    /* renamed from: e, reason: collision with root package name */
    public long f382797e;

    /* renamed from: f, reason: collision with root package name */
    public long f382798f;

    public Grape() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382794b = -1;
        this.f382795c = -1;
        this.f382796d = 0;
        this.f382797e = -1L;
        this.f382798f = -1L;
        this.f382793a = System.currentTimeMillis();
    }
}
