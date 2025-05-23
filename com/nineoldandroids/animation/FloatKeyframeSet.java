package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class FloatKeyframeSet extends KeyframeSet {
    private float deltaValue;
    private boolean firstTime;
    private float firstValue;
    private float lastValue;

    public FloatKeyframeSet(Keyframe.FloatKeyframe... floatKeyframeArr) {
        super(floatKeyframeArr);
        this.firstTime = true;
    }

    public float getFloatValue(float f16) {
        int i3 = this.mNumKeyframes;
        if (i3 == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((Keyframe.FloatKeyframe) this.mKeyframes.get(0)).getFloatValue();
                float floatValue = ((Keyframe.FloatKeyframe) this.mKeyframes.get(1)).getFloatValue();
                this.lastValue = floatValue;
                this.deltaValue = floatValue - this.firstValue;
            }
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                f16 = interpolator.getInterpolation(f16);
            }
            TypeEvaluator typeEvaluator = this.mEvaluator;
            if (typeEvaluator == null) {
                return this.firstValue + (f16 * this.deltaValue);
            }
            return ((Number) typeEvaluator.evaluate(f16, Float.valueOf(this.firstValue), Float.valueOf(this.lastValue))).floatValue();
        }
        if (f16 <= 0.0f) {
            Keyframe.FloatKeyframe floatKeyframe = (Keyframe.FloatKeyframe) this.mKeyframes.get(0);
            Keyframe.FloatKeyframe floatKeyframe2 = (Keyframe.FloatKeyframe) this.mKeyframes.get(1);
            float floatValue2 = floatKeyframe.getFloatValue();
            float floatValue3 = floatKeyframe2.getFloatValue();
            float fraction = floatKeyframe.getFraction();
            float fraction2 = floatKeyframe2.getFraction();
            Interpolator interpolator2 = floatKeyframe2.getInterpolator();
            if (interpolator2 != null) {
                f16 = interpolator2.getInterpolation(f16);
            }
            float f17 = (f16 - fraction) / (fraction2 - fraction);
            TypeEvaluator typeEvaluator2 = this.mEvaluator;
            if (typeEvaluator2 == null) {
                return floatValue2 + (f17 * (floatValue3 - floatValue2));
            }
            return ((Number) typeEvaluator2.evaluate(f17, Float.valueOf(floatValue2), Float.valueOf(floatValue3))).floatValue();
        }
        if (f16 >= 1.0f) {
            Keyframe.FloatKeyframe floatKeyframe3 = (Keyframe.FloatKeyframe) this.mKeyframes.get(i3 - 2);
            Keyframe.FloatKeyframe floatKeyframe4 = (Keyframe.FloatKeyframe) this.mKeyframes.get(this.mNumKeyframes - 1);
            float floatValue4 = floatKeyframe3.getFloatValue();
            float floatValue5 = floatKeyframe4.getFloatValue();
            float fraction3 = floatKeyframe3.getFraction();
            float fraction4 = floatKeyframe4.getFraction();
            Interpolator interpolator3 = floatKeyframe4.getInterpolator();
            if (interpolator3 != null) {
                f16 = interpolator3.getInterpolation(f16);
            }
            float f18 = (f16 - fraction3) / (fraction4 - fraction3);
            TypeEvaluator typeEvaluator3 = this.mEvaluator;
            if (typeEvaluator3 == null) {
                return floatValue4 + (f18 * (floatValue5 - floatValue4));
            }
            return ((Number) typeEvaluator3.evaluate(f18, Float.valueOf(floatValue4), Float.valueOf(floatValue5))).floatValue();
        }
        Keyframe.FloatKeyframe floatKeyframe5 = (Keyframe.FloatKeyframe) this.mKeyframes.get(0);
        int i16 = 1;
        while (true) {
            int i17 = this.mNumKeyframes;
            if (i16 >= i17) {
                return ((Number) this.mKeyframes.get(i17 - 1).getValue()).floatValue();
            }
            Keyframe.FloatKeyframe floatKeyframe6 = (Keyframe.FloatKeyframe) this.mKeyframes.get(i16);
            if (f16 < floatKeyframe6.getFraction()) {
                Interpolator interpolator4 = floatKeyframe6.getInterpolator();
                if (interpolator4 != null) {
                    f16 = interpolator4.getInterpolation(f16);
                }
                float fraction5 = (f16 - floatKeyframe5.getFraction()) / (floatKeyframe6.getFraction() - floatKeyframe5.getFraction());
                float floatValue6 = floatKeyframe5.getFloatValue();
                float floatValue7 = floatKeyframe6.getFloatValue();
                TypeEvaluator typeEvaluator4 = this.mEvaluator;
                if (typeEvaluator4 == null) {
                    return floatValue6 + (fraction5 * (floatValue7 - floatValue6));
                }
                return ((Number) typeEvaluator4.evaluate(fraction5, Float.valueOf(floatValue6), Float.valueOf(floatValue7))).floatValue();
            }
            i16++;
            floatKeyframe5 = floatKeyframe6;
        }
    }

    @Override // com.nineoldandroids.animation.KeyframeSet
    public Object getValue(float f16) {
        return Float.valueOf(getFloatValue(f16));
    }

    @Override // com.nineoldandroids.animation.KeyframeSet
    /* renamed from: clone */
    public FloatKeyframeSet m74clone() {
        ArrayList<Keyframe> arrayList = this.mKeyframes;
        int size = arrayList.size();
        Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[size];
        for (int i3 = 0; i3 < size; i3++) {
            floatKeyframeArr[i3] = (Keyframe.FloatKeyframe) arrayList.get(i3).m73clone();
        }
        return new FloatKeyframeSet(floatKeyframeArr);
    }
}
