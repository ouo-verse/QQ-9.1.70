package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class bUA8L {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f382158a;

    /* renamed from: b, reason: collision with root package name */
    public final String f382159b;

    /* renamed from: c, reason: collision with root package name */
    public final long f382160c;

    /* renamed from: d, reason: collision with root package name */
    public final long f382161d;

    /* renamed from: e, reason: collision with root package name */
    public final int f382162e;

    /* renamed from: f, reason: collision with root package name */
    public final String f382163f;

    /* renamed from: g, reason: collision with root package name */
    public long f382164g;

    /* renamed from: h, reason: collision with root package name */
    public long f382165h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f382166i;

    public bUA8L(int i3, String str, long j3, long j16, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), str2);
            return;
        }
        this.f382164g = 0L;
        this.f382165h = 0L;
        this.f382166i = false;
        this.f382158a = i3;
        this.f382159b = str;
        this.f382160c = j3;
        this.f382161d = j16;
        this.f382162e = i16;
        this.f382163f = str2;
    }

    public bUA8L(int i3) {
        this(i3, null, System.currentTimeMillis(), 0L, 0, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, i3);
    }
}
