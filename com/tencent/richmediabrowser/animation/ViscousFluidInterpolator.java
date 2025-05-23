package com.tencent.richmediabrowser.animation;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ViscousFluidInterpolator implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        return AnimateUtils.viscousFluid(f16);
    }
}
