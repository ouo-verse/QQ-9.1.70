package android.support.v4.widget;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        if (f16 >= 1.0f) {
            return 1.0f;
        }
        if (f16 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int min = Math.min((int) ((fArr.length - 1) * f16), fArr.length - 2);
        float f17 = this.mStepSize;
        float f18 = (f16 - (min * f17)) / f17;
        float[] fArr2 = this.mValues;
        float f19 = fArr2[min];
        return f19 + (f18 * (fArr2[min + 1] - f19));
    }
}
