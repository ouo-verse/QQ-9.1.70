package com.tencent.ams.mosaic.jsengine.animation.timefunction;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements TimingFunction {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Interpolator f70769a;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f70769a = new AccelerateDecelerateInterpolator();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.timefunction.TimingFunction
    public float getInterpolation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
        }
        return this.f70769a.getInterpolation(f16);
    }
}
