package com.tencent.mobileqq.comment;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f201735a;

    /* renamed from: b, reason: collision with root package name */
    public long f201736b;

    /* renamed from: c, reason: collision with root package name */
    public int f201737c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f201738d;

    /* renamed from: e, reason: collision with root package name */
    public long f201739e;

    /* renamed from: f, reason: collision with root package name */
    public long f201740f;

    public a(long j3, long j16, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.f201736b = j3;
        this.f201735a = j16;
        this.f201737c = i3;
        this.f201738d = z16;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar.f201735a != this.f201735a || aVar.f201736b != this.f201736b) {
            return false;
        }
        return true;
    }
}
