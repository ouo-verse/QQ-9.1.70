package com.tencent.qqmini.sdk.widget.media.danmu;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DecelerateAccelerateInterpolator implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        return (((float) Math.tan((((f16 * 2.0f) - 1.0f) / 4.0f) * 3.141592653589793d)) / 2.0f) + 0.5f;
    }
}
