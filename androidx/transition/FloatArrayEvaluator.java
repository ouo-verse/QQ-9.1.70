package androidx.transition;

import android.animation.TypeEvaluator;

/* compiled from: P */
/* loaded from: classes.dex */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] mArray;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatArrayEvaluator(float[] fArr) {
        this.mArray = fArr;
    }

    @Override // android.animation.TypeEvaluator
    public float[] evaluate(float f16, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.mArray;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i3 = 0; i3 < fArr3.length; i3++) {
            float f17 = fArr[i3];
            fArr3[i3] = f17 + ((fArr2[i3] - f17) * f16);
        }
        return fArr3;
    }
}
