package com.tencent.common.danmaku.tool;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private long f99790a;

    /* renamed from: b, reason: collision with root package name */
    private long f99791b;

    public e(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
        } else {
            this.f99791b = j3;
            this.f99790a = j3;
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (e) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new e(this.f99791b);
    }

    public void b(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            this.f99791b = ((float) this.f99791b) * f16;
        }
    }

    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.f99791b;
    }
}
