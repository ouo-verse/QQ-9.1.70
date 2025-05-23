package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ju implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f16) {
        double pow;
        double d16 = f16 / 0.5d;
        if (d16 < 1.0d) {
            pow = Math.pow(d16, 3.0d);
        } else {
            pow = Math.pow(d16 - 2.0d, 3.0d) + 2.0d;
        }
        return (float) (pow * 0.5d);
    }
}
