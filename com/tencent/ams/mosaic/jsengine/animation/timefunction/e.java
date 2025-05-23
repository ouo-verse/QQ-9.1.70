package com.tencent.ams.mosaic.jsengine.animation.timefunction;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e implements TimingFunction {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Interpolator f70772a;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f70772a = new LinearInterpolator();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.timefunction.TimingFunction
    public float getInterpolation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
        }
        return this.f70772a.getInterpolation(f16);
    }
}
