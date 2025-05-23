package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Quarenden {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f383040d;

    /* renamed from: a, reason: collision with root package name */
    public long f383041a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f383042b;

    /* renamed from: c, reason: collision with root package name */
    public Rambutan f383043c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12466);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f383040d = new byte[0];
        }
    }

    public Quarenden(long j3, byte[] bArr, Rambutan rambutan) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), bArr, rambutan);
            return;
        }
        this.f383041a = j3;
        this.f383042b = bArr;
        this.f383043c = rambutan;
    }

    public static Quarenden a(long j3, Rambutan rambutan) {
        rambutan.f383044a = j3;
        return new Quarenden(j3, f383040d, rambutan);
    }
}
