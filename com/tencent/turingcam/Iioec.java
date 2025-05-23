package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Iioec {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f381858e;

    /* renamed from: a, reason: collision with root package name */
    public final int f381859a;

    /* renamed from: b, reason: collision with root package name */
    public final int f381860b;

    /* renamed from: c, reason: collision with root package name */
    public final int f381861c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f381862d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11329);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f381858e = new byte[0];
        }
    }

    public Iioec(int i3, byte[] bArr, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), bArr, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f381859a = i3;
        this.f381862d = bArr;
        this.f381860b = i16;
        this.f381861c = i17;
    }
}
