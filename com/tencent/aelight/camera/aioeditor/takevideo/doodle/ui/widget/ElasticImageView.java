package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import hd0.c;
import xr.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ElasticImageView extends ImageView {
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public ValueAnimator L;
    public ValueAnimator M;
    public boolean N;
    public float P;
    public float Q;
    public boolean R;
    private Matrix S;
    private Matrix T;

    /* renamed from: d, reason: collision with root package name */
    public float f68684d;

    /* renamed from: e, reason: collision with root package name */
    public float f68685e;

    /* renamed from: f, reason: collision with root package name */
    public float f68686f;

    /* renamed from: h, reason: collision with root package name */
    public final long f68687h;

    /* renamed from: i, reason: collision with root package name */
    public float f68688i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f68689m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends a.d {
        a() {
        }

        @Override // xr.a.c
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ElasticImageView.this.f68688i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ElasticImageView elasticImageView = ElasticImageView.this;
            elasticImageView.h(elasticImageView.f68688i);
            c.a("ElasticImageView", "updateAnimator:" + ElasticImageView.this.f68688i);
            ElasticImageView.super.invalidate();
        }
    }

    public ElasticImageView(Context context) {
        super(context);
        this.f68684d = 1.0f;
        this.f68685e = 1.0f;
        this.f68686f = 1.0f;
        this.f68687h = 100L;
        this.f68688i = 1.0f;
        this.N = false;
        this.P = 1.0f;
        this.Q = 1.0f;
        this.R = true;
        d();
    }

    private ValueAnimator c(float f16, float f17, long j3) {
        return xr.a.a(j3, f16, f17, new a());
    }

    private void d() {
        setScaleType(ImageView.ScaleType.MATRIX);
        this.T = new Matrix(getImageMatrix());
        this.S = new Matrix();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        if (r2 < r3) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e() {
        float f16;
        float f17;
        float f18;
        int i3;
        boolean z16 = getDrawable() != null;
        this.f68689m = z16;
        if (z16) {
            int intrinsicWidth = getDrawable().getIntrinsicWidth();
            int intrinsicHeight = getDrawable().getIntrinsicHeight();
            float f19 = 1.0f;
            if (this.N) {
                if (intrinsicWidth < intrinsicHeight) {
                    this.Q = intrinsicWidth / intrinsicHeight;
                    this.P = 1.0f;
                    intrinsicHeight = intrinsicWidth;
                } else if (intrinsicWidth > intrinsicHeight) {
                    this.P = intrinsicHeight / intrinsicWidth;
                    this.Q = 1.0f;
                    intrinsicWidth = intrinsicHeight;
                } else {
                    this.P = 1.0f;
                    this.Q = 1.0f;
                }
            }
            int i16 = this.E;
            if (intrinsicWidth > i16 || intrinsicHeight > (i3 = this.F)) {
                int i17 = intrinsicWidth - i16;
                int i18 = this.F;
                int i19 = intrinsicHeight - i18;
                if (i17 <= 0 || i19 <= 0) {
                    if (i17 > 0) {
                        f16 = i16;
                        f17 = intrinsicWidth;
                    } else if (i19 > 0) {
                        f16 = i18;
                        f17 = intrinsicHeight;
                    }
                    f19 = f16 / f17;
                } else {
                    float f26 = i16 / intrinsicWidth;
                    f19 = i18 / intrinsicHeight;
                    if (f26 < f19) {
                        f19 = f26;
                    }
                }
            } else {
                f18 = i16 / intrinsicWidth;
                f19 = i3 / intrinsicHeight;
            }
            f18 = f19;
            c.a("ElasticImageView", "drawableWidth:" + intrinsicWidth + ",drawableHeight:" + intrinsicHeight + ",AvaliableWidth:" + this.E + ",AvaliableHeight:" + this.F + ",scaleValue:" + f18);
            this.f68684d = f18;
            this.f68685e = 0.9f * f18;
            this.f68686f = f18 * 0.5f;
            this.I = (int) (((float) this.G) - ((((float) intrinsicWidth) / this.P) / 2.0f));
            this.J = (int) (((float) this.H) - ((((float) intrinsicHeight) / this.Q) / 2.0f));
        }
    }

    private void f() {
        ValueAnimator valueAnimator = this.L;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.L.cancel();
        }
        ValueAnimator valueAnimator2 = this.M;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            ValueAnimator c16 = c(this.f68688i, this.f68684d, 100L);
            this.M = c16;
            c16.start();
        }
    }

    private void g() {
        ValueAnimator valueAnimator = this.M;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.M.cancel();
        }
        ValueAnimator valueAnimator2 = this.L;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            ValueAnimator c16 = c(this.f68688i, this.f68686f, 100L);
            this.L = c16;
            c16.start();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.C = i3;
        this.D = i16;
        this.G = ((i3 - getPaddingLeft()) - getPaddingRight()) / 2;
        int paddingTop = ((i16 - getPaddingTop()) - getPaddingBottom()) / 2;
        this.H = paddingTop;
        this.K = paddingTop * 2;
        this.E = this.G * 2;
        this.F = paddingTop * 2;
        c.a("ElasticImageView", "ImageViewWidth:" + this.C + ",ImageViewHeight:" + this.D + ",centerX:" + this.G + ",centerY:" + this.H + ",AvaliableWidth:" + this.E + ",AvaliableHeight:" + this.F);
        e();
        float f16 = this.f68684d;
        this.f68688i = f16;
        h(f16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (r3 != 3) goto L27;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f68689m && this.R) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (x16 >= 0.0f && x16 <= getWidth() && y16 >= 0.0f && y16 <= getHeight()) {
                            g();
                        } else {
                            f();
                        }
                    }
                }
                f();
            } else {
                e();
                this.f68688i = this.f68685e;
                g();
            }
        }
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        e();
        float f16 = this.f68684d;
        this.f68688i = f16;
        h(f16);
    }

    public void setIsNeedAdjustDrawableToSquare(boolean z16) {
        this.N = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(float f16) {
        if (f16 <= 0.0f) {
            return;
        }
        c.a("ElasticImageView", "updateMatrix:" + f16);
        this.S.set(this.T);
        this.S.postTranslate((float) this.I, (float) this.J);
        this.S.postScale(this.P, this.Q, (float) this.G, (float) this.H);
        this.S.postScale(f16, f16, this.G, this.H);
        super.setImageMatrix(this.S);
    }

    public ElasticImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f68684d = 1.0f;
        this.f68685e = 1.0f;
        this.f68686f = 1.0f;
        this.f68687h = 100L;
        this.f68688i = 1.0f;
        this.N = false;
        this.P = 1.0f;
        this.Q = 1.0f;
        this.R = true;
        d();
    }
}
