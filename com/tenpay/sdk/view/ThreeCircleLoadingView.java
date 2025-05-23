package com.tenpay.sdk.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.widget.f;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ThreeCircleLoadingView extends View {
    private float baseRadius;
    private float circleDistance;
    private int color;
    private boolean hasEnd;
    private int leftShrink;
    private float mFactor;
    private int mHeight;
    Paint mPaint;
    private float mRadius;
    private float mValue;
    private int mWidth;
    private int number;
    private int rightEnlarge;
    private ValueAnimator valueAnimator;

    public ThreeCircleLoadingView(Context context) {
        this(context, null);
    }

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(this.color);
        this.mPaint.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnimation() {
        this.hasEnd = false;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.valueAnimator = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tenpay.sdk.view.ThreeCircleLoadingView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ThreeCircleLoadingView.this.valueAnimator != null) {
                    ThreeCircleLoadingView threeCircleLoadingView = ThreeCircleLoadingView.this;
                    threeCircleLoadingView.mValue = ((Float) threeCircleLoadingView.valueAnimator.getAnimatedValue()).floatValue();
                    ThreeCircleLoadingView.this.invalidate();
                }
            }
        });
        this.valueAnimator.setDuration(300L);
        this.valueAnimator.start();
        this.valueAnimator.addListener(new f() { // from class: com.tenpay.sdk.view.ThreeCircleLoadingView.2
            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ThreeCircleLoadingView.this.number++;
                ThreeCircleLoadingView threeCircleLoadingView = ThreeCircleLoadingView.this;
                threeCircleLoadingView.leftShrink = (threeCircleLoadingView.leftShrink + 1) % 3;
                ThreeCircleLoadingView threeCircleLoadingView2 = ThreeCircleLoadingView.this;
                threeCircleLoadingView2.rightEnlarge = (threeCircleLoadingView2.rightEnlarge + 1) % 3;
                ThreeCircleLoadingView.this.valueAnimator = null;
                if (!ThreeCircleLoadingView.this.hasEnd) {
                    ThreeCircleLoadingView.this.startAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    public void endAnimation() {
        this.hasEnd = true;
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(this.mWidth / 2, this.mHeight / 2);
        this.mPaint.setStyle(Paint.Style.FILL);
        for (int i3 = 0; i3 < 3; i3++) {
            if (this.leftShrink == -1 && this.rightEnlarge == -1) {
                if (i3 == 0) {
                    canvas.drawCircle((i3 - 1) * this.circleDistance, 0.0f, this.baseRadius * this.mFactor, this.mPaint);
                    this.leftShrink = 0;
                    this.rightEnlarge = 1;
                } else {
                    canvas.drawCircle((i3 - 1) * this.circleDistance, 0.0f, this.baseRadius, this.mPaint);
                }
            }
            int i16 = this.leftShrink;
            if (i16 != -1) {
                if (i16 == i3) {
                    float f16 = (i3 - 1) * this.circleDistance;
                    float f17 = this.baseRadius;
                    float f18 = this.mFactor;
                    canvas.drawCircle(f16, 0.0f, (f17 * f18) - (((f17 * f18) - this.mRadius) * this.mValue), this.mPaint);
                } else if (this.rightEnlarge == i3) {
                    float f19 = (i3 - 1) * this.circleDistance;
                    float f26 = this.baseRadius;
                    canvas.drawCircle(f19, 0.0f, f26 + (((this.mFactor * f26) - this.mRadius) * this.mValue), this.mPaint);
                } else {
                    canvas.drawCircle((i3 - 1) * this.circleDistance, 0.0f, this.baseRadius, this.mPaint);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode != 1073741824) {
            size = (size * 1) / 2;
        }
        if (mode2 != 1073741824) {
            size2 = (size2 * 1) / 2;
        }
        this.mWidth = size;
        this.mHeight = size2;
        this.mRadius = this.baseRadius;
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
    }

    public void setVisibilityAndAnimation(boolean z16) {
        if (z16) {
            ValueAnimator valueAnimator = this.valueAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                return;
            }
            this.hasEnd = false;
            this.leftShrink = -1;
            this.rightEnlarge = -1;
            startAnimation();
            setVisibility(0);
            return;
        }
        setVisibility(8);
        endAnimation();
    }

    public ThreeCircleLoadingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreeCircleLoadingView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.number = 0;
        this.hasEnd = true;
        this.baseRadius = 10.0f;
        this.circleDistance = 54.0f;
        this.mFactor = 1.5f;
        this.leftShrink = -1;
        this.rightEnlarge = -1;
        this.color = Color.parseColor("#fbd49d");
        init();
    }
}
