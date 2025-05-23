package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ShaderAnimLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    float f316236d;

    /* renamed from: e, reason: collision with root package name */
    boolean f316237e;

    /* renamed from: f, reason: collision with root package name */
    private Animation f316238f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f316239h;

    /* renamed from: i, reason: collision with root package name */
    private Path f316240i;

    /* renamed from: m, reason: collision with root package name */
    private Animation.AnimationListener f316241m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends Animation {
        a() {
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f16, Transformation transformation) {
            ShaderAnimLayout shaderAnimLayout = ShaderAnimLayout.this;
            if (shaderAnimLayout.f316237e) {
                shaderAnimLayout.f316236d = 1.0f - f16;
            } else {
                shaderAnimLayout.f316236d = f16;
            }
            shaderAnimLayout.invalidate();
        }
    }

    public ShaderAnimLayout(Context context) {
        super(context);
        this.f316236d = 0.0f;
        this.f316237e = false;
        this.f316238f = new a();
        this.f316239h = false;
        this.f316240i = new Path();
        this.f316241m = new b();
        e();
    }

    private void e() {
        if (!this.f316239h) {
            this.f316238f.setDuration(200L);
            this.f316238f.setInterpolator(new LinearInterpolator());
            this.f316239h = true;
        }
    }

    public void a() {
        if (getVisibility() == 0) {
            this.f316237e = true;
            clearAnimation();
            this.f316238f.setAnimationListener(this.f316241m);
            startAnimation(this.f316238f);
        }
    }

    public void b() {
        clearAnimation();
        this.f316238f.setAnimationListener(null);
        this.f316237e = true;
        setVisibility(8);
        this.f316236d = 0.0f;
    }

    public void c() {
        this.f316237e = true;
        clearAnimation();
        this.f316238f.setAnimationListener(this.f316241m);
        startAnimation(this.f316238f);
    }

    public void d() {
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f316240i.reset();
        this.f316240i.addRect((1.0f - this.f316236d) * getWidth(), 0.0f, getWidth(), getBottom(), Path.Direction.CW);
        canvas.clipPath(this.f316240i, Region.Op.INTERSECT);
        super.dispatchDraw(canvas);
    }

    public void f() {
        if (getVisibility() != 0) {
            this.f316237e = false;
            this.f316238f.setAnimationListener(null);
            clearAnimation();
            setVisibility(0);
            startAnimation(this.f316238f);
        }
    }

    public void g() {
        clearAnimation();
        this.f316238f.setAnimationListener(null);
        this.f316237e = false;
        setVisibility(0);
        this.f316236d = 1.0f;
    }

    public void h() {
        this.f316237e = false;
        this.f316238f.setAnimationListener(null);
        clearAnimation();
        setVisibility(0);
        startAnimation(this.f316238f);
    }

    public ShaderAnimLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316236d = 0.0f;
        this.f316237e = false;
        this.f316238f = new a();
        this.f316239h = false;
        this.f316240i = new Path();
        this.f316241m = new b();
        e();
    }

    public ShaderAnimLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316236d = 0.0f;
        this.f316237e = false;
        this.f316238f = new a();
        this.f316239h = false;
        this.f316240i = new Path();
        this.f316241m = new b();
        e();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ShaderAnimLayout.this.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
