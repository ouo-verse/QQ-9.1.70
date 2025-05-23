package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class js implements Interpolator {
    public js() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f16) {
        float f17 = f16 - 1.0f;
        return (float) Math.sqrt(1.0f - (f17 * f17));
    }

    js(byte b16) {
    }
}
