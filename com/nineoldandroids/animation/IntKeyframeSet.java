package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class IntKeyframeSet extends KeyframeSet {
    private int deltaValue;
    private boolean firstTime;
    private int firstValue;
    private int lastValue;

    public IntKeyframeSet(Keyframe.IntKeyframe... intKeyframeArr) {
        super(intKeyframeArr);
        this.firstTime = true;
    }

    public int getIntValue(float f16) {
        int i3 = this.mNumKeyframes;
        if (i3 == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((Keyframe.IntKeyframe) this.mKeyframes.get(0)).getIntValue();
                int intValue = ((Keyframe.IntKeyframe) this.mKeyframes.get(1)).getIntValue();
                this.lastValue = intValue;
                this.deltaValue = intValue - this.firstValue;
            }
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                f16 = interpolator.getInterpolation(f16);
            }
            TypeEvaluator typeEvaluator = this.mEvaluator;
            if (typeEvaluator == null) {
                return this.firstValue + ((int) (f16 * this.deltaValue));
            }
            return ((Number) typeEvaluator.evaluate(f16, Integer.valueOf(this.firstValue), Integer.valueOf(this.lastValue))).intValue();
        }
        if (f16 <= 0.0f) {
            Keyframe.IntKeyframe intKeyframe = (Keyframe.IntKeyframe) this.mKeyframes.get(0);
            Keyframe.IntKeyframe intKeyframe2 = (Keyframe.IntKeyframe) this.mKeyframes.get(1);
            int intValue2 = intKeyframe.getIntValue();
            int intValue3 = intKeyframe2.getIntValue();
            float fraction = intKeyframe.getFraction();
            float fraction2 = intKeyframe2.getFraction();
            Interpolator interpolator2 = intKeyframe2.getInterpolator();
            if (interpolator2 != null) {
                f16 = interpolator2.getInterpolation(f16);
            }
            float f17 = (f16 - fraction) / (fraction2 - fraction);
            TypeEvaluator typeEvaluator2 = this.mEvaluator;
            if (typeEvaluator2 == null) {
                return intValue2 + ((int) (f17 * (intValue3 - intValue2)));
            }
            return ((Number) typeEvaluator2.evaluate(f17, Integer.valueOf(intValue2), Integer.valueOf(intValue3))).intValue();
        }
        if (f16 >= 1.0f) {
            Keyframe.IntKeyframe intKeyframe3 = (Keyframe.IntKeyframe) this.mKeyframes.get(i3 - 2);
            Keyframe.IntKeyframe intKeyframe4 = (Keyframe.IntKeyframe) this.mKeyframes.get(this.mNumKeyframes - 1);
            int intValue4 = intKeyframe3.getIntValue();
            int intValue5 = intKeyframe4.getIntValue();
            float fraction3 = intKeyframe3.getFraction();
            float fraction4 = intKeyframe4.getFraction();
            Interpolator interpolator3 = intKeyframe4.getInterpolator();
            if (interpolator3 != null) {
                f16 = interpolator3.getInterpolation(f16);
            }
            float f18 = (f16 - fraction3) / (fraction4 - fraction3);
            TypeEvaluator typeEvaluator3 = this.mEvaluator;
            if (typeEvaluator3 == null) {
                return intValue4 + ((int) (f18 * (intValue5 - intValue4)));
            }
            return ((Number) typeEvaluator3.evaluate(f18, Integer.valueOf(intValue4), Integer.valueOf(intValue5))).intValue();
        }
        Keyframe.IntKeyframe intKeyframe5 = (Keyframe.IntKeyframe) this.mKeyframes.get(0);
        int i16 = 1;
        while (true) {
            int i17 = this.mNumKeyframes;
            if (i16 >= i17) {
                return ((Number) this.mKeyframes.get(i17 - 1).getValue()).intValue();
            }
            Keyframe.IntKeyframe intKeyframe6 = (Keyframe.IntKeyframe) this.mKeyframes.get(i16);
            if (f16 < intKeyframe6.getFraction()) {
                Interpolator interpolator4 = intKeyframe6.getInterpolator();
                if (interpolator4 != null) {
                    f16 = interpolator4.getInterpolation(f16);
                }
                float fraction5 = (f16 - intKeyframe5.getFraction()) / (intKeyframe6.getFraction() - intKeyframe5.getFraction());
                int intValue6 = intKeyframe5.getIntValue();
                int intValue7 = intKeyframe6.getIntValue();
                TypeEvaluator typeEvaluator4 = this.mEvaluator;
                if (typeEvaluator4 == null) {
                    return intValue6 + ((int) (fraction5 * (intValue7 - intValue6)));
                }
                return ((Number) typeEvaluator4.evaluate(fraction5, Integer.valueOf(intValue6), Integer.valueOf(intValue7))).intValue();
            }
            i16++;
            intKeyframe5 = intKeyframe6;
        }
    }

    @Override // com.nineoldandroids.animation.KeyframeSet
    public Object getValue(float f16) {
        return Integer.valueOf(getIntValue(f16));
    }

    @Override // com.nineoldandroids.animation.KeyframeSet
    /* renamed from: clone */
    public IntKeyframeSet m74clone() {
        ArrayList<Keyframe> arrayList = this.mKeyframes;
        int size = arrayList.size();
        Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[size];
        for (int i3 = 0; i3 < size; i3++) {
            intKeyframeArr[i3] = (Keyframe.IntKeyframe) arrayList.get(i3).m73clone();
        }
        return new IntKeyframeSet(intKeyframeArr);
    }
}
