package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f383232e;

    /* renamed from: a, reason: collision with root package name */
    public final int f383233a;

    /* renamed from: b, reason: collision with root package name */
    public final int f383234b;

    /* renamed from: c, reason: collision with root package name */
    public final int f383235c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f383236d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13430);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f383232e = new byte[0];
        }
    }

    public c(int i3, byte[] bArr, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), bArr, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f383233a = i3;
        this.f383236d = bArr;
        this.f383234b = i16;
        this.f383235c = i17;
    }

    public static c a(int i3) {
        return new c(i3, f383232e, 0, 0);
    }

    public static c a(byte[] bArr) {
        return new c(0, bArr, 0, 0);
    }
}
