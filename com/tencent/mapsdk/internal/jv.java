package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class jv implements Interpolator {
    public jv() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f16) {
        return f16 * f16;
    }

    jv(byte b16) {
    }
}
