package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

/* loaded from: classes.dex */
public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {
    private final PointF point;
    private final PointF pointWithCallbackValues;
    private final BaseKeyframeAnimation<Float, Float> xAnimation;

    @Nullable
    protected LottieValueCallback<Float> xValueCallback;
    private final BaseKeyframeAnimation<Float, Float> yAnimation;

    @Nullable
    protected LottieValueCallback<Float> yValueCallback;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.point = new PointF();
        this.pointWithCallbackValues = new PointF();
        this.xAnimation = baseKeyframeAnimation;
        this.yAnimation = baseKeyframeAnimation2;
        setProgress(getProgress());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void setProgress(float f16) {
        this.xAnimation.setProgress(f16);
        this.yAnimation.setProgress(f16);
        this.point.set(this.xAnimation.getValue().floatValue(), this.yAnimation.getValue().floatValue());
        for (int i3 = 0; i3 < this.listeners.size(); i3++) {
            this.listeners.get(i3).onValueChanged();
        }
    }

    public void setXValueCallback(@Nullable LottieValueCallback<Float> lottieValueCallback) {
        LottieValueCallback<Float> lottieValueCallback2 = this.xValueCallback;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation(null);
        }
        this.xValueCallback = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }

    public void setYValueCallback(@Nullable LottieValueCallback<Float> lottieValueCallback) {
        LottieValueCallback<Float> lottieValueCallback2 = this.yValueCallback;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation(null);
        }
        this.yValueCallback = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue() {
        return getValue((Keyframe<PointF>) null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue(Keyframe<PointF> keyframe, float f16) {
        Float f17;
        Keyframe<Float> currentKeyframe;
        Keyframe<Float> currentKeyframe2;
        Float f18 = null;
        if (this.xValueCallback == null || (currentKeyframe2 = this.xAnimation.getCurrentKeyframe()) == null) {
            f17 = null;
        } else {
            float interpolatedCurrentKeyframeProgress = this.xAnimation.getInterpolatedCurrentKeyframeProgress();
            Float f19 = currentKeyframe2.endFrame;
            LottieValueCallback<Float> lottieValueCallback = this.xValueCallback;
            float f26 = currentKeyframe2.startFrame;
            f17 = lottieValueCallback.getValueInternal(f26, f19 == null ? f26 : f19.floatValue(), currentKeyframe2.startValue, currentKeyframe2.endValue, f16, f16, interpolatedCurrentKeyframeProgress);
        }
        if (this.yValueCallback != null && (currentKeyframe = this.yAnimation.getCurrentKeyframe()) != null) {
            float interpolatedCurrentKeyframeProgress2 = this.yAnimation.getInterpolatedCurrentKeyframeProgress();
            Float f27 = currentKeyframe.endFrame;
            LottieValueCallback<Float> lottieValueCallback2 = this.yValueCallback;
            float f28 = currentKeyframe.startFrame;
            f18 = lottieValueCallback2.getValueInternal(f28, f27 == null ? f28 : f27.floatValue(), currentKeyframe.startValue, currentKeyframe.endValue, f16, f16, interpolatedCurrentKeyframeProgress2);
        }
        if (f17 == null) {
            this.pointWithCallbackValues.set(this.point.x, 0.0f);
        } else {
            this.pointWithCallbackValues.set(f17.floatValue(), 0.0f);
        }
        if (f18 == null) {
            PointF pointF = this.pointWithCallbackValues;
            pointF.set(pointF.x, this.point.y);
        } else {
            PointF pointF2 = this.pointWithCallbackValues;
            pointF2.set(pointF2.x, f18.floatValue());
        }
        return this.pointWithCallbackValues;
    }
}
