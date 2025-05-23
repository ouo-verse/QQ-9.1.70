package com.tencent.qqmini.minigame.widget;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DragableView extends RelativeLayout {
    protected int C;
    protected int D;
    protected int E;
    private int F;
    private int G;
    protected int H;
    protected int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private boolean N;
    private float P;
    private float Q;
    private float R;
    private float S;
    protected ViewPropertyAnimator T;

    /* renamed from: d, reason: collision with root package name */
    protected float f346862d;

    /* renamed from: e, reason: collision with root package name */
    protected float f346863e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f346864f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f346865h;

    /* renamed from: i, reason: collision with root package name */
    private float f346866i;

    /* renamed from: m, reason: collision with root package name */
    private float f346867m;

    public DragableView(Context context) {
        super(context);
        h();
    }

    private float b(float f16) {
        if (this.N) {
            float f17 = this.Q;
            float f18 = (f17 - this.I) / 2.0f;
            if (((this.M + f16) + f17) - f18 > this.E) {
                return ((r4 - r2) - f17) + f18;
            }
            int i3 = this.L;
            if (f16 < i3) {
                return i3 - f18;
            }
            return f16;
        }
        int i16 = this.M;
        if (i16 + f16 + this.I > this.E) {
            return (r3 - i16) - r2;
        }
        int i17 = this.L;
        if (f16 < i17) {
            return i17;
        }
        return f16;
    }

    private void d() {
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            this.D = point.x;
            this.E = point.y;
        } else {
            this.D = getContext().getResources().getDisplayMetrics().widthPixels;
            this.E = getContext().getResources().getDisplayMetrics().heightPixels;
        }
        QMLog.i("DragableView", "getScreenConfig mScreenWidth: " + this.D + ", mScreenHeight: " + this.E);
    }

    private void h() {
        i();
        d();
    }

    private boolean j(float f16, float f17, float f18, float f19) {
        if (Math.abs(f16 - f18) <= 10.0f && Math.abs(f17 - f19) <= 10.0f) {
            return false;
        }
        return true;
    }

    private void l(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float a16 = a((getX() + rawX) - this.f346866i);
        this.f346866i = rawX;
        setX(a16);
    }

    private void m(MotionEvent motionEvent) {
        float rawY = motionEvent.getRawY();
        float b16 = b((getY() + rawY) - this.f346867m);
        this.f346867m = rawY;
        setY(b16);
    }

    private void q() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        this.J = marginLayoutParams.leftMargin;
        this.K = marginLayoutParams.rightMargin;
        this.L = marginLayoutParams.topMargin;
        this.M = marginLayoutParams.bottomMargin;
    }

    private void r() {
        this.F = getMeasuredWidth();
        this.G = getMeasuredHeight();
    }

    private void s() {
        if (!this.f346865h) {
            return;
        }
        this.f346865h = false;
        float f16 = this.P - this.H;
        float f17 = this.Q - this.I;
        setX(getX() - (f16 / 2.0f));
        setY(getY() - (f17 / 2.0f));
        this.N = false;
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float a(float f16) {
        if (this.N) {
            float f17 = this.P;
            int i3 = this.K;
            float f18 = (f17 - this.H) / 2.0f;
            float f19 = ((f16 + f17) + i3) - f18;
            int i16 = this.D;
            if (f19 > i16) {
                return ((i16 - f17) - i3) + f18;
            }
            int i17 = this.J;
            if (f16 < i17) {
                return i17 - f18;
            }
            return f16;
        }
        int i18 = this.H;
        if (i18 + f16 + this.K > this.D) {
            return (r3 - i18) - r2;
        }
        int i19 = this.J;
        if (f16 < i19) {
            return i19;
        }
        return f16;
    }

    protected void c() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        this.I = marginLayoutParams.height;
        this.H = marginLayoutParams.width;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e(MotionEvent motionEvent) {
        c();
        u();
        this.f346862d = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        this.f346863e = rawY;
        this.f346866i = this.f346862d;
        this.f346867m = rawY;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(MotionEvent motionEvent) {
        l(motionEvent);
        m(motionEvent);
        boolean j3 = j(this.f346862d, this.f346863e, motionEvent.getRawX(), motionEvent.getRawY());
        this.f346864f = j3;
        if (j3) {
            p();
            t();
        }
        bringToFront();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g() {
        p();
        s();
        if (this.C == 0) {
            performClick();
        } else {
            if (!this.f346864f) {
                performClick();
            }
            k();
        }
        this.f346864f = false;
        return false;
    }

    protected void k() {
        int i3;
        float x16 = getX();
        int i16 = this.D;
        if (x16 > i16 / 2.0f) {
            i3 = 2;
        } else {
            i16 = 0;
            i3 = 1;
        }
        ViewPropertyAnimator animate = animate();
        this.T = animate;
        animate.setInterpolator(new DecelerateInterpolator()).x(a(i16)).setDuration(250L).setListener(new a(i3)).start();
    }

    public void n() {
        ViewPropertyAnimator viewPropertyAnimator = this.T;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        q();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.N) {
            setMeasuredDimension((int) this.P, (int) this.Q);
        } else {
            super.onMeasure(i3, i16);
        }
        r();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean e16;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    return false;
                }
                e16 = f(motionEvent);
            } else {
                e16 = g();
            }
        } else {
            e16 = e(motionEvent);
        }
        this.C = actionMasked;
        return e16;
    }

    public void setScaleSize(float f16, float f17) {
        this.P = f16;
        this.Q = f17;
    }

    public void setScreenWidth(int i3) {
        this.D = i3;
    }

    protected void t() {
        if (this.f346865h) {
            return;
        }
        this.f346865h = true;
        float f16 = this.Q;
        if (f16 > 0.0f) {
            float f17 = this.P;
            if (f17 > 0.0f) {
                setX(getX() + ((f17 - this.H) / 2.0f));
                setY(getY() + ((f16 - this.I) / 2.0f));
                this.R = this.P / this.F;
                this.S = this.Q / this.G;
                this.N = true;
                requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(int i3, int i16) {
        this.I = i16;
        this.H = i3;
    }

    public DragableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h();
    }

    public DragableView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        h();
    }

    private void u() {
    }

    public void i() {
    }

    protected void p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f346868d;

        a(int i3) {
            this.f346868d = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            DragableView.this.o(this.f346868d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public void o(int i3) {
    }
}
