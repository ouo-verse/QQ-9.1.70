package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Durian {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f375600e;

    /* renamed from: a, reason: collision with root package name */
    public final int f375601a;

    /* renamed from: b, reason: collision with root package name */
    public final int f375602b;

    /* renamed from: c, reason: collision with root package name */
    public final int f375603c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f375604d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62560);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f375600e = new byte[0];
        }
    }

    public Durian(int i3, byte[] bArr, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), bArr, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f375601a = i3;
        this.f375604d = bArr;
        this.f375602b = i16;
        this.f375603c = i17;
    }

    public static Durian a(int i3) {
        return new Durian(i3, f375600e, 0, 0);
    }

    public static Durian a(byte[] bArr) {
        return new Durian(0, bArr, 0, 0);
    }
}
