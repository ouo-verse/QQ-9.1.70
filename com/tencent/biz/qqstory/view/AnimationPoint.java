package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;

/* loaded from: classes5.dex */
public class AnimationPoint extends View {
    protected boolean C;
    protected int D;
    protected int E;
    AccelerateDecelerateInterpolator F;
    protected int G;
    protected Animation.AnimationListener H;
    protected Handler I;
    protected boolean J;
    private Runnable K;

    /* renamed from: d, reason: collision with root package name */
    protected long f94481d;

    /* renamed from: e, reason: collision with root package name */
    protected long f94482e;

    /* renamed from: f, reason: collision with root package name */
    protected int f94483f;

    /* renamed from: h, reason: collision with root package name */
    protected long f94484h;

    /* renamed from: i, reason: collision with root package name */
    protected long f94485i;

    /* renamed from: m, reason: collision with root package name */
    protected Paint f94486m;

    public AnimationPoint(Context context) {
        this(context, null);
    }

    protected float a(long j3) {
        float f16;
        long j16;
        long j17 = this.f94485i;
        long j18 = j3 % j17;
        if (j18 < (j17 * 16) / 100) {
            f16 = ((float) j18) * 1.0f;
            j16 = (j17 * 16) / 100;
        } else {
            if (j18 < (60 * j17) / 100) {
                return 1.0f;
            }
            f16 = ((float) (j17 - j18)) * 1.0f;
            j16 = (j17 * 40) / 100;
        }
        return f16 / ((float) j16);
    }

    protected int b(long j3) {
        int i3;
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = this.F;
        long j16 = this.f94485i;
        float interpolation = accelerateDecelerateInterpolator.getInterpolation(((float) (j3 % j16)) / ((float) j16));
        if (this.C) {
            i3 = this.E;
        } else {
            i3 = this.D;
        }
        int i16 = i3 - (this.f94483f * 2);
        if (j3 > this.f94485i) {
            this.G = this.f94483f + ((int) (i16 * interpolation));
        } else {
            this.G = (this.f94483f + i16) - ((int) (i16 * interpolation));
        }
        return this.G;
    }

    protected float c(long j3) {
        float f16;
        long j16;
        long j17 = this.f94485i;
        long j18 = j3 % j17;
        if (j18 < (j17 * 16) / 100) {
            return 0.0f;
        }
        if (j18 < (24 * j17) / 100) {
            f16 = ((float) (j18 - ((16 * j17) / 100))) * 0.4f;
            j16 = (j17 * 8) / 100;
        } else {
            if (j18 >= (j17 * 60) / 100) {
                return 0.0f;
            }
            f16 = ((float) (((60 * j17) / 100) - j18)) * 0.4f;
            j16 = (j17 * 36) / 100;
        }
        return f16 / ((float) j16);
    }

    protected int d(long j3) {
        if (j3 < this.f94485i) {
            return this.G + (this.f94483f / 2);
        }
        return this.G - (this.f94483f / 2);
    }

    protected float e(long j3) {
        float f16;
        long j16;
        long j17 = this.f94485i;
        long j18 = j3 % j17;
        if (j18 < (j17 * 24) / 100) {
            return 0.0f;
        }
        if (j18 < (36 * j17) / 100) {
            f16 = ((float) (j18 - ((24 * j17) / 100))) * 0.2f;
            j16 = (j17 * 12) / 100;
        } else {
            if (j18 >= (j17 * 60) / 100) {
                return 0.0f;
            }
            f16 = ((float) (((60 * j17) / 100) - j18)) * 0.2f;
            j16 = (j17 * 24) / 100;
        }
        return f16 / ((float) j16);
    }

    protected int f(long j3) {
        if (j3 < this.f94485i) {
            return this.G + this.f94483f;
        }
        return this.G - this.f94483f;
    }

    public void g() {
        this.J = false;
        this.f94484h = SystemClock.uptimeMillis();
        this.D = super.getWidth();
        this.E = super.getHeight();
        Animation.AnimationListener animationListener = this.H;
        if (animationListener != null) {
            animationListener.onAnimationStart(null);
        }
        this.I.post(this.K);
    }

    public void h() {
        this.I.removeCallbacks(this.K);
        this.J = true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        this.D = super.getWidth();
        int height = super.getHeight();
        this.E = height;
        int i16 = this.D / 2;
        int i17 = height / 2;
        long uptimeMillis = (SystemClock.uptimeMillis() - this.f94484h) % this.f94481d;
        int b16 = b(uptimeMillis);
        int d16 = d(uptimeMillis);
        int f16 = f(uptimeMillis);
        float a16 = a(uptimeMillis);
        float c16 = c(uptimeMillis);
        float e16 = e(uptimeMillis);
        if (this.f94483f == 0) {
            if (this.C) {
                i3 = this.D;
            } else {
                i3 = this.E;
            }
            this.f94483f = i3 / 2;
        }
        if (e16 != 0.0f) {
            this.f94486m.setAlpha((int) (e16 * 255.0f));
            if (this.C) {
                canvas.drawCircle(i16, f16, this.f94483f, this.f94486m);
            } else {
                canvas.drawCircle(f16, i17, this.f94483f, this.f94486m);
            }
        }
        if (c16 != 0.0f) {
            this.f94486m.setAlpha((int) (c16 * 255.0f));
            if (this.C) {
                canvas.drawCircle(i16, d16, this.f94483f, this.f94486m);
            } else {
                canvas.drawCircle(d16, i17, this.f94483f, this.f94486m);
            }
        }
        if (a16 != 0.0f) {
            this.f94486m.setAlpha((int) (a16 * 255.0f));
            if (this.C) {
                canvas.drawCircle(i16, b16, this.f94483f, this.f94486m);
            } else {
                canvas.drawCircle(b16, i17, this.f94483f, this.f94486m);
            }
        }
    }

    public void setDuration(long j3) {
        this.f94482e = j3;
    }

    public void setIsVertical(boolean z16) {
        this.C = z16;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            int i3 = layoutParams.width;
            layoutParams.width = layoutParams.height;
            layoutParams.height = i3;
            setLayoutParams(layoutParams);
        }
    }

    public void setLoopTime(long j3) {
        this.f94481d = j3;
        this.f94485i = j3 / 2;
    }

    public void setOnAnimationListener(Animation.AnimationListener animationListener) {
        this.H = animationListener;
    }

    public void setRadius(int i3) {
        this.f94483f = i3;
    }

    public AnimationPoint(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnimationPoint(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = false;
        this.I = new Handler(Looper.getMainLooper());
        this.J = false;
        this.K = new Runnable() { // from class: com.tencent.biz.qqstory.view.AnimationPoint.1
            @Override // java.lang.Runnable
            public void run() {
                if (AnimationPoint.this.J) {
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                AnimationPoint animationPoint = AnimationPoint.this;
                long j3 = uptimeMillis - animationPoint.f94484h;
                long j16 = animationPoint.f94482e;
                if (j3 >= j16 && j16 >= 0) {
                    Animation.AnimationListener animationListener = animationPoint.H;
                    if (animationListener != null) {
                        animationListener.onAnimationEnd(null);
                    }
                } else {
                    animationPoint.I.postDelayed(this, 30L);
                }
                AnimationPoint.this.invalidate();
            }
        };
        Paint paint = new Paint();
        this.f94486m = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f94486m.setColor(-1);
        this.f94485i = 1000L;
        this.f94481d = 1000 * 2;
        this.f94482e = 2000L;
        this.F = new AccelerateDecelerateInterpolator();
    }
}
