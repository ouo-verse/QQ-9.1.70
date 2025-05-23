package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class KeyframeSet {
    TypeEvaluator mEvaluator;
    Keyframe mFirstKeyframe;
    Interpolator mInterpolator;
    ArrayList<Keyframe> mKeyframes;
    Keyframe mLastKeyframe;
    int mNumKeyframes;

    public KeyframeSet(Keyframe... keyframeArr) {
        this.mNumKeyframes = keyframeArr.length;
        ArrayList<Keyframe> arrayList = new ArrayList<>();
        this.mKeyframes = arrayList;
        arrayList.addAll(Arrays.asList(keyframeArr));
        this.mFirstKeyframe = this.mKeyframes.get(0);
        Keyframe keyframe = this.mKeyframes.get(this.mNumKeyframes - 1);
        this.mLastKeyframe = keyframe;
        this.mInterpolator = keyframe.getInterpolator();
    }

    public static KeyframeSet ofFloat(float... fArr) {
        int length = fArr.length;
        Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[Math.max(length, 2)];
        if (length == 1) {
            floatKeyframeArr[0] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(0.0f);
            floatKeyframeArr[1] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(1.0f, fArr[0]);
        } else {
            floatKeyframeArr[0] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(0.0f, fArr[0]);
            for (int i3 = 1; i3 < length; i3++) {
                floatKeyframeArr[i3] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(i3 / (length - 1), fArr[i3]);
            }
        }
        return new FloatKeyframeSet(floatKeyframeArr);
    }

    public static KeyframeSet ofInt(int... iArr) {
        int length = iArr.length;
        Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[Math.max(length, 2)];
        if (length == 1) {
            intKeyframeArr[0] = (Keyframe.IntKeyframe) Keyframe.ofInt(0.0f);
            intKeyframeArr[1] = (Keyframe.IntKeyframe) Keyframe.ofInt(1.0f, iArr[0]);
        } else {
            intKeyframeArr[0] = (Keyframe.IntKeyframe) Keyframe.ofInt(0.0f, iArr[0]);
            for (int i3 = 1; i3 < length; i3++) {
                intKeyframeArr[i3] = (Keyframe.IntKeyframe) Keyframe.ofInt(i3 / (length - 1), iArr[i3]);
            }
        }
        return new IntKeyframeSet(intKeyframeArr);
    }

    public static KeyframeSet ofKeyframe(Keyframe... keyframeArr) {
        int length = keyframeArr.length;
        int i3 = 0;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        for (Keyframe keyframe : keyframeArr) {
            if (keyframe instanceof Keyframe.FloatKeyframe) {
                z16 = true;
            } else if (keyframe instanceof Keyframe.IntKeyframe) {
                z17 = true;
            } else {
                z18 = true;
            }
        }
        if (z16 && !z17 && !z18) {
            Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[length];
            while (i3 < length) {
                floatKeyframeArr[i3] = (Keyframe.FloatKeyframe) keyframeArr[i3];
                i3++;
            }
            return new FloatKeyframeSet(floatKeyframeArr);
        }
        if (z17 && !z16 && !z18) {
            Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[length];
            while (i3 < length) {
                intKeyframeArr[i3] = (Keyframe.IntKeyframe) keyframeArr[i3];
                i3++;
            }
            return new IntKeyframeSet(intKeyframeArr);
        }
        return new KeyframeSet(keyframeArr);
    }

    public static KeyframeSet ofObject(Object... objArr) {
        int length = objArr.length;
        Keyframe.ObjectKeyframe[] objectKeyframeArr = new Keyframe.ObjectKeyframe[Math.max(length, 2)];
        if (length == 1) {
            objectKeyframeArr[0] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(0.0f);
            objectKeyframeArr[1] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(1.0f, objArr[0]);
        } else {
            objectKeyframeArr[0] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(0.0f, objArr[0]);
            for (int i3 = 1; i3 < length; i3++) {
                objectKeyframeArr[i3] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(i3 / (length - 1), objArr[i3]);
            }
        }
        return new KeyframeSet(objectKeyframeArr);
    }

    public Object getValue(float f16) {
        int i3 = this.mNumKeyframes;
        if (i3 == 2) {
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                f16 = interpolator.getInterpolation(f16);
            }
            return this.mEvaluator.evaluate(f16, this.mFirstKeyframe.getValue(), this.mLastKeyframe.getValue());
        }
        int i16 = 1;
        if (f16 <= 0.0f) {
            Keyframe keyframe = this.mKeyframes.get(1);
            Interpolator interpolator2 = keyframe.getInterpolator();
            if (interpolator2 != null) {
                f16 = interpolator2.getInterpolation(f16);
            }
            float fraction = this.mFirstKeyframe.getFraction();
            return this.mEvaluator.evaluate((f16 - fraction) / (keyframe.getFraction() - fraction), this.mFirstKeyframe.getValue(), keyframe.getValue());
        }
        if (f16 >= 1.0f) {
            Keyframe keyframe2 = this.mKeyframes.get(i3 - 2);
            Interpolator interpolator3 = this.mLastKeyframe.getInterpolator();
            if (interpolator3 != null) {
                f16 = interpolator3.getInterpolation(f16);
            }
            float fraction2 = keyframe2.getFraction();
            return this.mEvaluator.evaluate((f16 - fraction2) / (this.mLastKeyframe.getFraction() - fraction2), keyframe2.getValue(), this.mLastKeyframe.getValue());
        }
        Keyframe keyframe3 = this.mFirstKeyframe;
        while (i16 < this.mNumKeyframes) {
            Keyframe keyframe4 = this.mKeyframes.get(i16);
            if (f16 < keyframe4.getFraction()) {
                Interpolator interpolator4 = keyframe4.getInterpolator();
                if (interpolator4 != null) {
                    f16 = interpolator4.getInterpolation(f16);
                }
                float fraction3 = keyframe3.getFraction();
                return this.mEvaluator.evaluate((f16 - fraction3) / (keyframe4.getFraction() - fraction3), keyframe3.getValue(), keyframe4.getValue());
            }
            i16++;
            keyframe3 = keyframe4;
        }
        return this.mLastKeyframe.getValue();
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        this.mEvaluator = typeEvaluator;
    }

    public String toString() {
        String str = " ";
        for (int i3 = 0; i3 < this.mNumKeyframes; i3++) {
            str = String.valueOf(str) + this.mKeyframes.get(i3).getValue() + "  ";
        }
        return str;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public KeyframeSet m74clone() {
        ArrayList<Keyframe> arrayList = this.mKeyframes;
        int size = arrayList.size();
        Keyframe[] keyframeArr = new Keyframe[size];
        for (int i3 = 0; i3 < size; i3++) {
            keyframeArr[i3] = arrayList.get(i3).m73clone();
        }
        return new KeyframeSet(keyframeArr);
    }
}
