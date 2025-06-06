package com.airbnb.lottie.animation.keyframe;

import android.graphics.Color;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;

/* compiled from: P */
/* loaded from: classes.dex */
public class DropShadowKeyframeAnimation implements BaseKeyframeAnimation.AnimationListener {
    private static final double DEG_TO_RAD = 0.017453292519943295d;
    private final BaseKeyframeAnimation<Integer, Integer> color;
    private final BaseKeyframeAnimation<Float, Float> direction;
    private final BaseKeyframeAnimation<Float, Float> distance;
    private boolean isDirty = true;
    private final BaseKeyframeAnimation.AnimationListener listener;
    private final BaseKeyframeAnimation<Float, Float> opacity;
    private final BaseKeyframeAnimation<Float, Float> radius;

    public DropShadowKeyframeAnimation(BaseKeyframeAnimation.AnimationListener animationListener, BaseLayer baseLayer, DropShadowEffect dropShadowEffect) {
        this.listener = animationListener;
        BaseKeyframeAnimation<Integer, Integer> createAnimation = dropShadowEffect.getColor().createAnimation();
        this.color = createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation);
        BaseKeyframeAnimation<Float, Float> createAnimation2 = dropShadowEffect.getOpacity().createAnimation();
        this.opacity = createAnimation2;
        createAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation2);
        BaseKeyframeAnimation<Float, Float> createAnimation3 = dropShadowEffect.getDirection().createAnimation();
        this.direction = createAnimation3;
        createAnimation3.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation3);
        BaseKeyframeAnimation<Float, Float> createAnimation4 = dropShadowEffect.getDistance().createAnimation();
        this.distance = createAnimation4;
        createAnimation4.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation4);
        BaseKeyframeAnimation<Float, Float> createAnimation5 = dropShadowEffect.getRadius().createAnimation();
        this.radius = createAnimation5;
        createAnimation5.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation5);
    }

    public void applyTo(Paint paint) {
        if (!this.isDirty) {
            return;
        }
        this.isDirty = false;
        double floatValue = this.direction.getValue().floatValue() * 0.017453292519943295d;
        float floatValue2 = this.distance.getValue().floatValue();
        float sin = ((float) Math.sin(floatValue)) * floatValue2;
        float cos = ((float) Math.cos(floatValue + 3.141592653589793d)) * floatValue2;
        int intValue = this.color.getValue().intValue();
        paint.setShadowLayer(this.radius.getValue().floatValue(), sin, cos, Color.argb(Math.round(this.opacity.getValue().floatValue()), Color.red(intValue), Color.green(intValue), Color.blue(intValue)));
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.isDirty = true;
        this.listener.onValueChanged();
    }

    public void setColorCallback(@Nullable LottieValueCallback<Integer> lottieValueCallback) {
        this.color.setValueCallback(lottieValueCallback);
    }

    public void setDirectionCallback(@Nullable LottieValueCallback<Float> lottieValueCallback) {
        this.direction.setValueCallback(lottieValueCallback);
    }

    public void setDistanceCallback(@Nullable LottieValueCallback<Float> lottieValueCallback) {
        this.distance.setValueCallback(lottieValueCallback);
    }

    public void setOpacityCallback(@Nullable final LottieValueCallback<Float> lottieValueCallback) {
        if (lottieValueCallback == null) {
            this.opacity.setValueCallback(null);
        } else {
            this.opacity.setValueCallback(new LottieValueCallback<Float>() { // from class: com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.airbnb.lottie.value.LottieValueCallback
                @Nullable
                public Float getValue(LottieFrameInfo<Float> lottieFrameInfo) {
                    Float f16 = (Float) lottieValueCallback.getValue(lottieFrameInfo);
                    if (f16 == null) {
                        return null;
                    }
                    return Float.valueOf(f16.floatValue() * 2.55f);
                }
            });
        }
    }

    public void setRadiusCallback(@Nullable LottieValueCallback<Float> lottieValueCallback) {
        this.radius.setValueCallback(lottieValueCallback);
    }
}
