package com.tencent.turingface.sdk.mfa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface m {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final int f382540a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f382541b;

        public a(int i3, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) bArr);
                return;
            }
            if (i3 != 0 && (i3 > -1000 || i3 < -9999)) {
                i3 = -9999;
            }
            this.f382540a = i3;
            this.f382541b = bArr;
        }
    }
}
