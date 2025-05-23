package com.tencent.mobileqq.location.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f241281a;

    /* renamed from: b, reason: collision with root package name */
    public final long f241282b;

    /* renamed from: c, reason: collision with root package name */
    public final long f241283c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f241284d;

    public b(int i3, long j3, long j16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), bArr);
            return;
        }
        this.f241281a = i3;
        this.f241282b = j3;
        this.f241283c = j16;
        this.f241284d = bArr;
    }
}
