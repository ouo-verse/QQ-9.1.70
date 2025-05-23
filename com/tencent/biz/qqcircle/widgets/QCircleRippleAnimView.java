package com.tencent.biz.qqcircle.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleRippleAnimView extends View {
    private float C;
    private float D;
    private ViewGroup E;
    private c F;
    private Animator.AnimatorListener G;
    private ValueAnimator.AnimatorUpdateListener H;
    private TimeInterpolator I;
    private int J;
    private boolean K;

    /* renamed from: d, reason: collision with root package name */
    private Paint f93100d;

    /* renamed from: e, reason: collision with root package name */
    private int f93101e;

    /* renamed from: f, reason: collision with root package name */
    private int f93102f;

    /* renamed from: h, reason: collision with root package name */
    private int f93103h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f93104i;

    /* renamed from: m, reason: collision with root package name */
    private long f93105m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QCircleRippleAnimView.this.F != null) {
                QCircleRippleAnimView.this.F.onAnimationEnd();
            }
            QCircleRippleAnimView.this.f93104i = false;
            QCircleRippleAnimView.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QCircleRippleAnimView.this.f93103h = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
            QCircleRippleAnimView.this.postInvalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void onAnimationEnd();
    }

    public QCircleRippleAnimView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f93100d = paint;
        paint.setAntiAlias(true);
        this.f93100d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        i();
    }

    private void e() {
        setVisibility(0);
        if (!this.K) {
            this.E.addView(this, new ViewGroup.LayoutParams(-1, -1));
            this.K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.E != null) {
            setVisibility(8);
            this.E = null;
        }
        if (this.f93100d != null) {
            this.f93100d = null;
        }
    }

    private ValueAnimator h() {
        ValueAnimator duration = ValueAnimator.ofFloat(this.f93102f, this.f93101e).setDuration(this.f93105m);
        TimeInterpolator timeInterpolator = this.I;
        if (timeInterpolator != null) {
            duration.setInterpolator(timeInterpolator);
        }
        duration.addUpdateListener(this.H);
        duration.addListener(this.G);
        return duration;
    }

    private void i() {
        this.G = new a();
        this.H = new b();
    }

    public QCircleRippleAnimView f(ViewGroup viewGroup) {
        this.E = viewGroup;
        return this;
    }

    public QCircleRippleAnimView j(long j3) {
        this.f93105m = j3;
        return this;
    }

    public QCircleRippleAnimView k(int i3) {
        this.J = i3;
        return this;
    }

    public QCircleRippleAnimView l(float f16, float f17) {
        this.C = f16;
        this.D = f17;
        return this;
    }

    public QCircleRippleAnimView m(TimeInterpolator timeInterpolator) {
        this.I = timeInterpolator;
        return this;
    }

    public QCircleRippleAnimView n(int i3) {
        this.f93101e = i3;
        return this;
    }

    public QCircleRippleAnimView o(c cVar) {
        this.F = cVar;
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        canvas.drawColor(this.J);
        canvas.drawCircle(this.C, this.D, this.f93103h, this.f93100d);
        canvas.restoreToCount(saveLayer);
    }

    public QCircleRippleAnimView p(int i3) {
        this.f93102f = i3;
        return this;
    }

    public void q() {
        if (!this.f93104i) {
            this.f93104i = true;
            e();
            h().start();
        }
    }
}
