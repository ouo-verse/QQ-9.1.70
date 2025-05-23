package ir;

import android.animation.TimeInterpolator;

/* compiled from: P */
/* loaded from: classes38.dex */
public class n implements TimeInterpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        return (float) ((Math.pow(2.0d, (-10.0f) * f16) * Math.sin(((f16 - 0.175f) * 6.283185307179586d) / 0.7f)) + 1.0d);
    }
}
