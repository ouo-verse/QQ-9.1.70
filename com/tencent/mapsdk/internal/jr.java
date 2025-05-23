package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class jr implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f16) {
        double d16 = f16;
        double d17 = d16 * d16;
        double d18 = d17 * d17;
        return (float) (d18 * d18);
    }
}
