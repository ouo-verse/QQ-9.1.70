package com.tencent.biz.qui.quishimmer;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import he0.b;
import java.util.Observable;
import java.util.Observer;
import ud0.d;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QUIShimmerController {
    public static final float CIRCLE_CENTER_X_DEFAULT = -364.0f;
    public static final float CIRCLE_CENTER_Y_DEFAULT = -542.0f;
    private static final String TAG = "QUIShimmerController";
    private String mBusinessTag;

    @Nullable
    private ValueAnimator mValueAnimator;
    private int animationToken = com.tencent.mobileqq.R.anim.f154986ut;
    private int animationTimes = 20;
    private float mCircleCenterX = -364.0f;
    private float mCircleCenterY = -542.0f;
    private float mStartX = 0.0f;
    private float mStartY = 0.0f;
    private float mEndX = 1000.0f;
    private float mEndY = 1000.0f;
    private int animatorRepeatCount = -1;
    private final TargetRadiusObservable targetRadiusObservable = new TargetRadiusObservable();
    private final ValueAnimator.AnimatorUpdateListener mUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qui.quishimmer.a
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            QUIShimmerController.this.lambda$new$0(valueAnimator);
        }
    };

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class TargetRadiusObservable extends Observable {
        public TargetRadiusObservable() {
        }

        public void postTargetRadius(Float f16) {
            setChanged();
            notifyObservers(f16);
        }
    }

    public QUIShimmerController(String str) {
        if (TextUtils.isEmpty(str)) {
            d.g(TAG, d.f438811e, "businessTag is empty");
            this.mBusinessTag = "default";
        } else {
            this.mBusinessTag = str;
        }
        d.g(TAG, d.f438811e, "controller for " + this.mBusinessTag);
        initAnimator();
    }

    private float getTargetRadius(ValueAnimator valueAnimator) {
        if (valueAnimator == null) {
            return 1.0f;
        }
        float sqrt = ((float) Math.sqrt(Math.pow(this.mStartX - this.mCircleCenterX, 2.0d) + Math.pow(this.mStartY - this.mCircleCenterY, 2.0d))) * 0.605f;
        float sqrt2 = (sqrt + ((((float) Math.sqrt(Math.pow(this.mEndX - this.mCircleCenterX, 2.0d) + Math.pow(this.mEndY - this.mCircleCenterY, 2.0d))) - sqrt) * ((Float) valueAnimator.getAnimatedValue()).floatValue())) / 0.605f;
        if (sqrt2 <= 1.0f) {
            return 1.0f;
        }
        return sqrt2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ValueAnimator valueAnimator) {
        TargetRadiusObservable targetRadiusObservable = this.targetRadiusObservable;
        if (targetRadiusObservable != null) {
            targetRadiusObservable.postTargetRadius(Float.valueOf(getTargetRadius(valueAnimator)));
        }
    }

    public void addObserver(Observer observer) {
        TargetRadiusObservable targetRadiusObservable = this.targetRadiusObservable;
        if (targetRadiusObservable != null && observer != null) {
            targetRadiusObservable.addObserver(observer);
        }
    }

    public void clearAllTargetObserver() {
        this.targetRadiusObservable.deleteObservers();
    }

    public void initAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mValueAnimator = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.setRepeatMode(1);
        this.mValueAnimator.setRepeatCount(this.animatorRepeatCount);
        b.m(this.mValueAnimator, this.animationToken, this.animationTimes);
        this.mValueAnimator.addUpdateListener(this.mUpdateListener);
    }

    public boolean isShimmerStarted() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            return true;
        }
        return false;
    }

    public void removeObserver(Observer observer) {
        TargetRadiusObservable targetRadiusObservable = this.targetRadiusObservable;
        if (targetRadiusObservable != null && observer != null) {
            targetRadiusObservable.deleteObserver(observer);
        }
    }

    public QUIShimmerController setAnimationToken(int i3, int i16) {
        this.animationToken = i3;
        if (i16 > 0) {
            this.animationTimes = i16;
        }
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            b.m(valueAnimator, i3, this.animationTimes);
        }
        return this;
    }

    public void setAnimatorRepeatCount(int i3) {
        this.animatorRepeatCount = i3;
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(i3);
        }
    }

    public QUIShimmerController setEndPoint(float f16, float f17) {
        this.mEndX = f16;
        this.mEndY = f17;
        return this;
    }

    public QUIShimmerController setStartPoint(float f16, float f17) {
        this.mStartX = f16;
        this.mStartY = f17;
        return this;
    }

    public QUIShimmerController startShimmer() {
        if (this.mValueAnimator == null) {
            initAnimator();
        }
        if (!this.mValueAnimator.isRunning()) {
            this.mValueAnimator.start();
        }
        return this;
    }

    public void stopShimmer() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mValueAnimator.cancel();
        }
    }
}
