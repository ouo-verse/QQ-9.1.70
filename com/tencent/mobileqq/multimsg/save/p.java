package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f251731a;

    /* renamed from: b, reason: collision with root package name */
    public int f251732b;

    /* renamed from: c, reason: collision with root package name */
    public int f251733c;

    /* renamed from: d, reason: collision with root package name */
    public int f251734d;

    /* renamed from: e, reason: collision with root package name */
    public String f251735e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f251736f;

    public p(long j3, int i3, int i16, int i17, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str, Boolean.valueOf(z16));
            return;
        }
        this.f251731a = j3;
        this.f251732b = i3;
        this.f251733c = i16;
        this.f251734d = i17;
        this.f251735e = str;
        this.f251736f = z16;
    }
}
