package com.tencent.mobileqq.msf.core.quicksend;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f249854a;

    /* renamed from: b, reason: collision with root package name */
    public long f249855b;

    /* renamed from: c, reason: collision with root package name */
    public int f249856c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f249857d;

    public a(long j3, long j16, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.f249854a = j3;
        this.f249855b = j16;
        this.f249856c = i3;
        this.f249857d = z16;
    }
}
