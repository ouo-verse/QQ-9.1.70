package com.tencent.ams.mosaic.jsengine.animation.timefunction;

import android.view.animation.Interpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements TimingFunction {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Interpolator f70768a;

    @Override // com.tencent.ams.mosaic.jsengine.animation.timefunction.TimingFunction
    public float getInterpolation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
        }
        Interpolator interpolator = this.f70768a;
        if (interpolator == null) {
            return f16;
        }
        return interpolator.getInterpolation(f16);
    }
}
