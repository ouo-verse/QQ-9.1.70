package com.tencent.biz.qui.quishimmer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import he0.b;
import java.util.Objects;
import ud0.d;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class QUIShimmerDrawable extends Drawable {
    private static final String TAG = "QUIShimmerDrawable";
    private int animationTimes;
    private int animationToken;
    private final Paint colorPaint;
    private int[] location;
    private String mBusinessTag;
    private float mCircleCenterX;
    private float mCircleCenterY;
    private final Rect mDrawRect;

    @Nullable
    private QUIShimmer mQUIShimmer;
    private final Paint mShimmerPaint;
    private boolean mShimmingAuto;
    private float mTargetRadius;
    private final ValueAnimator.AnimatorUpdateListener mUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qui.quishimmer.QUIShimmerDrawable.1
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (QUIShimmerDrawable.this.mShimmingAuto) {
                QUIShimmerDrawable.this.invalidateSelf();
            } else {
                d.g(QUIShimmerDrawable.this.mBusinessTag, d.f438811e, "can't shimming auto, but the animator is start");
            }
        }
    };

    @Nullable
    private ValueAnimator mValueAnimator;

    public QUIShimmerDrawable() {
        Paint paint = new Paint();
        this.mShimmerPaint = paint;
        Paint paint2 = new Paint();
        this.colorPaint = paint2;
        this.mDrawRect = new Rect();
        this.mBusinessTag = "QUIShimmerDrawable/default";
        this.location = new int[2];
        this.mCircleCenterX = -364.0f;
        this.mCircleCenterY = -542.0f;
        this.mTargetRadius = 1.0f;
        this.mShimmingAuto = true;
        this.animationToken = com.tencent.mobileqq.R.anim.f154986ut;
        this.animationTimes = 20;
        paint.setAntiAlias(true);
        paint2.setAntiAlias(true);
    }

    private void drawRadial(@NonNull Canvas canvas, float f16) {
        updateShader(f16);
        canvas.drawRect(this.mDrawRect, this.mShimmerPaint);
    }

    private void updateShader(float f16) {
        RadialGradient radialGradient;
        float f17;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (width != 0 && height != 0 && this.mQUIShimmer != null) {
            if (this.mShimmingAuto) {
                float sqrt = ((float) Math.sqrt(Math.pow(this.location[0] - this.mCircleCenterX, 2.0d) + Math.pow(this.location[1] - this.mCircleCenterY, 2.0d))) * 0.605f;
                float sqrt2 = (sqrt + ((((float) Math.sqrt(Math.pow((this.location[0] - this.mCircleCenterX) + width, 2.0d) + Math.pow((this.location[1] - this.mCircleCenterY) + height, 2.0d))) - sqrt) * f16)) / 0.605f;
                if (sqrt2 > 1.0f) {
                    f17 = sqrt2;
                } else {
                    f17 = 1.0f;
                }
                float f18 = this.mCircleCenterX;
                int[] iArr = this.location;
                float f19 = f18 - iArr[0];
                float f26 = this.mCircleCenterY - iArr[1];
                QUIShimmer qUIShimmer = this.mQUIShimmer;
                radialGradient = new RadialGradient(f19, f26, f17, qUIShimmer.colors, qUIShimmer.positions, Shader.TileMode.CLAMP);
            } else {
                float f27 = this.mCircleCenterX;
                int[] iArr2 = this.location;
                float f28 = f27 - iArr2[0];
                float f29 = this.mCircleCenterY - iArr2[1];
                float f36 = this.mTargetRadius;
                QUIShimmer qUIShimmer2 = this.mQUIShimmer;
                radialGradient = new RadialGradient(f28, f29, f36, qUIShimmer2.colors, qUIShimmer2.positions, Shader.TileMode.CLAMP);
            }
            this.mShimmerPaint.setShader(radialGradient);
        }
    }

    private void updateValueAnimator() {
        boolean z16;
        if (this.mQUIShimmer == null) {
            return;
        }
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            z16 = valueAnimator.isStarted();
            this.mValueAnimator.cancel();
            this.mValueAnimator.removeAllUpdateListeners();
        } else {
            z16 = false;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mValueAnimator = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        ValueAnimator valueAnimator2 = this.mValueAnimator;
        Objects.requireNonNull(this.mQUIShimmer);
        valueAnimator2.setRepeatMode(1);
        this.mValueAnimator.setRepeatCount(this.mQUIShimmer.repeatCount);
        b.m(this.mValueAnimator, this.animationToken, this.animationTimes);
        this.mValueAnimator.addUpdateListener(this.mUpdateListener);
        if (z16) {
            this.mValueAnimator.start();
        }
    }

    public boolean canShimmingAuto() {
        return this.mShimmingAuto;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float f16;
        if (this.mQUIShimmer != null && this.mShimmerPaint.getShader() != null) {
            ValueAnimator valueAnimator = this.mValueAnimator;
            if (valueAnimator != null) {
                f16 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else {
                f16 = 0.0f;
            }
            drawRadial(canvas, f16);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Nullable
    public QUIShimmer getShimmer() {
        return this.mQUIShimmer;
    }

    public boolean isShimmerRunning() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return true;
        }
        return false;
    }

    public boolean isShimmerStarted() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            return true;
        }
        return false;
    }

    public void maybeStartShimmer() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null && !valueAnimator.isStarted() && this.mQUIShimmer != null && getCallback() != null) {
            this.mValueAnimator.start();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDrawRect.set(rect);
        updateShader(1.0f);
    }

    public void setAnimationToken(int i3, int i16) {
        this.animationToken = i3;
        if (i16 > 0) {
            this.animationTimes = i16;
        }
    }

    public void setBusinessTag(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mBusinessTag = "QUIShimmerDrawable/default";
        }
    }

    public void setLocation(int[] iArr) {
        if (iArr != null && iArr.length >= 2) {
            this.location = iArr;
        }
    }

    public void setShimmer(@Nullable QUIShimmer qUIShimmer) {
        this.mQUIShimmer = qUIShimmer;
        if (qUIShimmer != null) {
            this.mShimmerPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        } else {
            d.g(this.mBusinessTag, d.f438811e, "mQUIShimmer is null");
        }
        updateShader(1.0f);
        updateValueAnimator();
        invalidateSelf();
    }

    public void shouldShimmingAuto(boolean z16) {
        this.mShimmingAuto = z16;
    }

    public void startShimmer() {
        if (this.mValueAnimator != null && !isShimmerStarted() && getCallback() != null) {
            this.mValueAnimator.start();
        }
    }

    public void stopShimmer() {
        if (this.mValueAnimator != null && isShimmerStarted()) {
            this.mValueAnimator.cancel();
        }
    }

    public void updateAnimatorRepeatCount(int i3) {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(i3);
        }
    }

    public void updateColors(int i3, int i16, int i17, int i18) {
        QUIShimmer qUIShimmer = this.mQUIShimmer;
        if (qUIShimmer != null) {
            qUIShimmer.updateColors(i3, i16, i17, i18);
        }
    }

    public void updateRadius(float f16) {
        this.mTargetRadius = f16;
    }

    public void updateXfermode(PorterDuff.Mode mode) {
        if (this.mQUIShimmer != null) {
            this.mShimmerPaint.setXfermode(new PorterDuffXfermode(mode));
        } else {
            d.g(this.mBusinessTag, d.f438811e, "updateXfermode mQUIShimmer is null");
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
