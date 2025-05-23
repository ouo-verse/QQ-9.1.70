package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;

/* compiled from: P */
/* loaded from: classes.dex */
public class VelocityMatrix {
    private static String TAG = "VelocityMatrix";
    float mDRotate;
    float mDScaleX;
    float mDScaleY;
    float mDTranslateX;
    float mDTranslateY;
    float mRotate;

    public void applyTransform(float f16, float f17, int i3, int i16, float[] fArr) {
        float f18 = fArr[0];
        float f19 = fArr[1];
        float f26 = (f17 - 0.5f) * 2.0f;
        float f27 = f18 + this.mDTranslateX;
        float f28 = f19 + this.mDTranslateY;
        float f29 = f27 + (this.mDScaleX * (f16 - 0.5f) * 2.0f);
        float f36 = f28 + (this.mDScaleY * f26);
        float radians = (float) Math.toRadians(this.mRotate);
        float radians2 = (float) Math.toRadians(this.mDRotate);
        double d16 = radians;
        double d17 = i16 * f26;
        float sin = f29 + (((float) ((((-i3) * r7) * Math.sin(d16)) - (Math.cos(d16) * d17))) * radians2);
        float cos = f36 + (radians2 * ((float) (((i3 * r7) * Math.cos(d16)) - (d17 * Math.sin(d16)))));
        fArr[0] = sin;
        fArr[1] = cos;
    }

    public void clear() {
        this.mDRotate = 0.0f;
        this.mDTranslateY = 0.0f;
        this.mDTranslateX = 0.0f;
        this.mDScaleY = 0.0f;
        this.mDScaleX = 0.0f;
    }

    public void setRotationVelocity(SplineSet splineSet, float f16) {
        if (splineSet != null) {
            this.mDRotate = splineSet.getSlope(f16);
            this.mRotate = splineSet.get(f16);
        }
    }

    public void setScaleVelocity(SplineSet splineSet, SplineSet splineSet2, float f16) {
        if (splineSet != null) {
            this.mDScaleX = splineSet.getSlope(f16);
        }
        if (splineSet2 != null) {
            this.mDScaleY = splineSet2.getSlope(f16);
        }
    }

    public void setTranslationVelocity(SplineSet splineSet, SplineSet splineSet2, float f16) {
        if (splineSet != null) {
            this.mDTranslateX = splineSet.getSlope(f16);
        }
        if (splineSet2 != null) {
            this.mDTranslateY = splineSet2.getSlope(f16);
        }
    }

    public void setRotationVelocity(KeyCycleOscillator keyCycleOscillator, float f16) {
        if (keyCycleOscillator != null) {
            this.mDRotate = keyCycleOscillator.getSlope(f16);
        }
    }

    public void setScaleVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f16) {
        if (keyCycleOscillator == null && keyCycleOscillator2 == null) {
            return;
        }
        if (keyCycleOscillator == null) {
            this.mDScaleX = keyCycleOscillator.getSlope(f16);
        }
        if (keyCycleOscillator2 == null) {
            this.mDScaleY = keyCycleOscillator2.getSlope(f16);
        }
    }

    public void setTranslationVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f16) {
        if (keyCycleOscillator != null) {
            this.mDTranslateX = keyCycleOscillator.getSlope(f16);
        }
        if (keyCycleOscillator2 != null) {
            this.mDTranslateY = keyCycleOscillator2.getSlope(f16);
        }
    }
}
