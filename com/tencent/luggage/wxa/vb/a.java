package com.tencent.luggage.wxa.vb;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        if (f16 < 0.5f) {
            float f17 = f16 * 2.0f;
            return 0.5f * f17 * f17 * f17 * f17 * f17;
        }
        float f18 = 1;
        float f19 = ((f16 - 0.5f) * 2) - f18;
        return (0.5f * f19 * f19 * f19 * f19 * f19) + f18;
    }
}
