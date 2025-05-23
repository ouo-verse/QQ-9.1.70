package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Haw {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f382807a;

    /* renamed from: b, reason: collision with root package name */
    public final String f382808b;

    /* renamed from: c, reason: collision with root package name */
    public final long f382809c;

    /* renamed from: d, reason: collision with root package name */
    public final long f382810d;

    /* renamed from: e, reason: collision with root package name */
    public final int f382811e;

    /* renamed from: f, reason: collision with root package name */
    public final String f382812f;

    public Haw(int i3, String str, long j3, long j16, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), str2);
            return;
        }
        this.f382807a = i3;
        this.f382808b = str;
        this.f382809c = j3;
        this.f382810d = j16;
        this.f382811e = i16;
        this.f382812f = str2;
    }

    public Haw(int i3) {
        this(i3, null, System.currentTimeMillis(), 0L, 0, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, i3);
    }
}
