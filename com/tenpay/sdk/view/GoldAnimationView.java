package com.tenpay.sdk.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GoldAnimationView extends View implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
    private ValueAnimator animator;
    private float dotAngle;
    private int dotMaxDistance;
    private int dotNum;
    private int dotRadius;
    private Drawable goldDrawable;
    private int goldNum;
    private boolean isDotAnimation;
    private Paint paint;
    private float rate;

    public GoldAnimationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Drawable background = getBackground();
        this.goldDrawable = background;
        background.setBounds(0, 0, background.getIntrinsicWidth(), this.goldDrawable.getIntrinsicHeight());
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.goldDrawable == null) {
            return;
        }
        canvas.save();
        canvas.translate((getWidth() / 2.0f) - (this.goldDrawable.getIntrinsicWidth() / 2.0f), 0.0f);
        this.goldDrawable.draw(canvas);
        canvas.restore();
        if (this.isDotAnimation) {
            for (int i3 = 0; i3 < this.dotNum; i3++) {
                float f16 = i3;
                float width = (float) (((getWidth() / 2.0f) - (this.dotRadius / 4.3f)) + (this.dotMaxDistance * Math.cos(this.dotAngle * f16) * this.rate));
                double height = getHeight();
                double sin = this.dotMaxDistance * Math.sin(this.dotAngle * f16);
                float f17 = this.rate;
                canvas.drawCircle(width, (float) (height - (sin * f17)), this.dotRadius * (1.0f - f17), this.paint);
            }
            return;
        }
        canvas.save();
        canvas.translate((getWidth() / 2.0f) - (this.goldDrawable.getIntrinsicWidth() / 2.0f), this.rate * getHeight());
        this.goldDrawable.draw(canvas);
        canvas.restore();
    }

    public void init(Drawable drawable, int i3, int i16, int i17, int i18, long j3) {
        this.goldDrawable = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.goldDrawable.getIntrinsicHeight());
        this.dotNum = i16;
        this.dotRadius = i17;
        this.dotMaxDistance = i18;
        this.dotAngle = (float) (3.141592653589793d / (i16 - 1));
        this.goldNum = i3;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(Color.parseColor("#F6C52B"));
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(j3);
        this.animator = duration;
        duration.setInterpolator(new LinearInterpolator());
        this.animator.addUpdateListener(this);
        this.animator.addListener(this);
        this.animator.setRepeatCount(i3 - 1);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator, boolean z16) {
        onAnimationEnd(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.rate = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public void start() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator == null) {
            return;
        }
        if (valueAnimator.isRunning()) {
            this.animator.end();
        }
        this.isDotAnimation = false;
        this.animator.addListener(this);
        this.animator.setRepeatCount(this.goldNum - 1);
        this.animator.start();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.isDotAnimation) {
            return;
        }
        this.isDotAnimation = true;
        this.animator.removeListener(this);
        this.animator.setRepeatCount(0);
        this.animator.start();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator, boolean z16) {
        onAnimationStart(animator);
    }

    public GoldAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Drawable background = getBackground();
        this.goldDrawable = background;
        background.setBounds(0, 0, background.getIntrinsicWidth(), this.goldDrawable.getIntrinsicHeight());
    }

    public GoldAnimationView(Context context) {
        super(context);
        Drawable background = getBackground();
        this.goldDrawable = background;
        background.setBounds(0, 0, background.getIntrinsicWidth(), this.goldDrawable.getIntrinsicHeight());
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
    }
}
