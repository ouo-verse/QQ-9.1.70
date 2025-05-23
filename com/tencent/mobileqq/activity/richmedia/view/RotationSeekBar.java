package com.tencent.mobileqq.activity.richmedia.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SeekBar;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RotationSeekBar extends SeekBar {
    private static final Interpolator C = new AccelerateDecelerateInterpolator();

    /* renamed from: m, reason: collision with root package name */
    private static float f186077m = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float[] f186078d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f186079e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f186080f;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f186081h;

    /* renamed from: i, reason: collision with root package name */
    private ValueAnimator f186082i;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RotationSeekBar.super.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RotationSeekBar.super.setSecondaryProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public RotationSeekBar(Context context) {
        super(context);
        this.f186078d = null;
        this.f186079e = null;
        this.f186080f = false;
        e();
    }

    private int c(float f16) {
        d();
        return Math.round(f16 * f186077m);
    }

    private float d() {
        if (f186077m == -1.0f) {
            f186077m = getContext().getResources().getDisplayMetrics().density;
        }
        return f186077m;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f186081h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f186082i;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f186078d != null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (this.f186079e == null) {
                Paint paint = new Paint();
                this.f186079e = paint;
                paint.setStyle(Paint.Style.FILL);
                this.f186079e.setColor(getResources().getColor(R.color.f158017al3));
            }
            int c16 = c(2.0f);
            int i3 = measuredHeight / 2;
            for (float f16 : this.f186078d) {
                if (f16 > 0.0f && f16 < 1.0f) {
                    canvas.save();
                    canvas.translate(f16 * measuredWidth, i3);
                    canvas.drawCircle(0.0f, 0.0f, c16, this.f186079e);
                    canvas.restore();
                }
            }
        }
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setAnimateEnable(boolean z16) {
        this.f186080f = z16;
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i3) {
        if (!this.f186080f) {
            super.setProgress(i3);
            return;
        }
        ValueAnimator valueAnimator = this.f186081h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f186081h;
        if (valueAnimator2 == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(getProgress(), i3);
            this.f186081h = ofInt;
            ofInt.setInterpolator(C);
            this.f186081h.addUpdateListener(new a());
        } else {
            valueAnimator2.setIntValues(getProgress(), i3);
        }
        this.f186081h.start();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setSecondaryProgress(int i3) {
        if (!this.f186080f) {
            super.setSecondaryProgress(i3);
            return;
        }
        ValueAnimator valueAnimator = this.f186082i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f186082i;
        if (valueAnimator2 == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(getProgress(), i3);
            this.f186082i = ofInt;
            ofInt.setInterpolator(C);
            this.f186082i.addUpdateListener(new b());
        } else {
            valueAnimator2.setIntValues(getProgress(), i3);
        }
        this.f186082i.start();
    }

    public RotationSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f186078d = null;
        this.f186079e = null;
        this.f186080f = false;
        e();
    }

    public RotationSeekBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f186078d = null;
        this.f186079e = null;
        this.f186080f = false;
        e();
    }

    void e() {
    }
}
