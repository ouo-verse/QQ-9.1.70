package com.tencent.util;

import android.view.animation.Interpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ViscousFluidInterpolator implements Interpolator {
    static IPatchRedirector $redirector_;

    public ViscousFluidInterpolator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
        }
        return AnimateUtils.viscousFluid(f16);
    }
}
