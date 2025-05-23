package com.tencent.cache.core.manager.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public float f98752a;

    /* renamed from: b, reason: collision with root package name */
    public float f98753b;

    /* renamed from: c, reason: collision with root package name */
    public int f98754c;

    public a(int i3, int i16, int i17) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f98754c = i3;
        if (i3 == 0) {
            f16 = 0.0f;
        } else {
            f16 = i16 / i3;
        }
        this.f98752a = f16;
        this.f98753b = i16 != 0 ? i17 / i16 : 0.0f;
    }
}
