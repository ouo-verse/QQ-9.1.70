package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f375700a;

    /* renamed from: b, reason: collision with root package name */
    public final String f375701b;

    /* renamed from: c, reason: collision with root package name */
    public final long f375702c;

    /* renamed from: d, reason: collision with root package name */
    public final long f375703d;

    /* renamed from: e, reason: collision with root package name */
    public final int f375704e;

    public Taurus(int i3, String str, long j3, long j16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16));
            return;
        }
        this.f375700a = i3;
        this.f375701b = str;
        this.f375702c = j3;
        this.f375703d = j16;
        this.f375704e = i16;
    }

    public Taurus(int i3) {
        this(i3, null, System.currentTimeMillis(), 0L, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, i3);
    }
}
