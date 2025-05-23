package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Dew {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f375590c;

    /* renamed from: a, reason: collision with root package name */
    public int f375591a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f375592b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62552);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f375590c = new byte[0];
        }
    }

    public Dew(int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) bArr);
        } else {
            this.f375591a = i3;
            this.f375592b = bArr;
        }
    }

    public static Dew a(int i3) {
        return new Dew(i3, f375590c);
    }
}
