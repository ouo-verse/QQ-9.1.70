package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ImageAnimationView extends View {
    private Rect C;
    float D;
    float E;
    float F;
    float G;
    private Animation.AnimationListener H;
    boolean I;
    Paint J;
    Interpolator K;
    private Rect L;
    private RectF M;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f315720d;

    /* renamed from: e, reason: collision with root package name */
    private long f315721e;

    /* renamed from: f, reason: collision with root package name */
    long f315722f;

    /* renamed from: h, reason: collision with root package name */
    private Rect f315723h;

    /* renamed from: i, reason: collision with root package name */
    private Rect f315724i;

    /* renamed from: m, reason: collision with root package name */
    private Rect f315725m;

    public ImageAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315721e = 1000L;
        this.f315722f = 0L;
        this.I = false;
        this.J = new Paint(6);
        this.L = new Rect();
        this.M = new RectF();
    }

    public void a(Bitmap bitmap, Rect rect, Rect rect2, Rect rect3, Rect rect4, long j3) {
        this.f315720d = bitmap;
        this.f315723h = rect;
        this.f315724i = rect2;
        this.f315725m = rect3;
        this.C = rect4;
        this.f315721e = j3;
    }

    public void b() {
        this.f315722f = System.currentTimeMillis();
        Animation.AnimationListener animationListener = this.H;
        if (animationListener != null) {
            animationListener.onAnimationStart(null);
        }
        this.I = true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f315722f > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f315722f;
            float f16 = ((float) currentTimeMillis) / ((float) this.f315721e);
            Interpolator interpolator = this.K;
            if (interpolator != null) {
                f16 = interpolator.getInterpolation(f16);
            }
            float f17 = 1.0f - f16;
            if (currentTimeMillis <= this.f315721e && this.I) {
                Rect rect = this.f315723h;
                Rect rect2 = this.f315724i;
                float f18 = (rect.top * f17) + (rect2.top * f16);
                this.D = f18;
                float f19 = (rect.bottom * f17) + (rect2.bottom * f16);
                this.E = f19;
                float f26 = (rect.left * f17) + (rect2.left * f16);
                this.F = f26;
                float f27 = (rect.right * f17) + (rect2.right * f16);
                this.G = f27;
                this.L.set((int) f26, (int) f18, (int) f27, (int) f19);
                Rect rect3 = this.f315725m;
                Rect rect4 = this.C;
                float f28 = (rect3.top * f17) + (rect4.top * f16);
                this.D = f28;
                float f29 = (rect3.bottom * f17) + (rect4.bottom * f16);
                this.E = f29;
                float f36 = (rect3.left * f17) + (rect4.left * f16);
                this.F = f36;
                float f37 = (rect3.right * f17) + (rect4.right * f16);
                this.G = f37;
                this.M.set(f36, f28, f37, f29);
            } else if (this.I) {
                this.I = false;
                this.H.onAnimationEnd(null);
            }
            canvas.drawBitmap(this.f315720d, this.L, this.M, this.J);
            invalidate();
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.H = animationListener;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.K = interpolator;
    }
}
