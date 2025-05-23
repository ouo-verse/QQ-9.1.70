package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface Hydra {

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Hydra$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cdo {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final int f382843a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f382844b;

        public Cdo(int i3, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) bArr);
                return;
            }
            if (i3 != 0 && (i3 > -1000 || i3 < -9999)) {
                i3 = -9999;
            }
            this.f382843a = i3;
            this.f382844b = bArr;
        }
    }
}
