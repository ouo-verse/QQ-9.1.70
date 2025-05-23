package com.tencent.mobileqq.lyric.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final long f243137a;

    /* renamed from: b, reason: collision with root package name */
    public final long f243138b;

    /* renamed from: c, reason: collision with root package name */
    public final int f243139c;

    /* renamed from: d, reason: collision with root package name */
    public final int f243140d;

    public a(long j3, long j16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f243137a = j3;
        this.f243138b = j16;
        this.f243139c = i3;
        this.f243140d = i16;
    }
}
