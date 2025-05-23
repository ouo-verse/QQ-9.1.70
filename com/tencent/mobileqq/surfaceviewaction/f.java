package com.tencent.mobileqq.surfaceviewaction;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public float f291217a;

    /* renamed from: b, reason: collision with root package name */
    public float f291218b;

    public f(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f291217a = f16;
            this.f291218b = f17;
        }
    }
}
