package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f383229c;

    /* renamed from: a, reason: collision with root package name */
    public int f383230a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f383231b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13416);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f383229c = new byte[0];
        }
    }

    public b(int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) bArr);
        } else {
            this.f383230a = i3;
            this.f383231b = bArr;
        }
    }

    public static b a(int i3) {
        return new b(i3, f383229c);
    }
}
