package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

/* loaded from: classes20.dex */
public class SlideBottomPanel extends FrameLayout {

    /* renamed from: f0, reason: collision with root package name */
    protected static float f316263f0 = 5.0f;
    protected float C;
    private int D;
    protected int E;
    private VelocityTracker F;
    protected int G;
    protected float H;
    protected float I;
    protected float J;
    protected float K;
    protected long L;
    protected boolean M;
    protected float N;
    protected float P;
    protected float Q;
    protected int R;
    protected boolean S;
    protected int T;
    protected int U;
    protected int V;
    protected boolean W;

    /* renamed from: a0, reason: collision with root package name */
    protected Interpolator f316264a0;

    /* renamed from: b0, reason: collision with root package name */
    protected Interpolator f316265b0;

    /* renamed from: c0, reason: collision with root package name */
    private Context f316266c0;

    /* renamed from: d, reason: collision with root package name */
    private int f316267d;

    /* renamed from: d0, reason: collision with root package name */
    private int f316268d0;

    /* renamed from: e, reason: collision with root package name */
    private float f316269e;

    /* renamed from: e0, reason: collision with root package name */
    protected r f316270e0;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f316271f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f316272h;

    /* renamed from: i, reason: collision with root package name */
    protected float f316273i;

    /* renamed from: m, reason: collision with root package name */
    protected float f316274m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            view.setTop(i26);
            view.setBottom(i28);
            view.setLeft(i19);
            view.setRight(i27);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f316276d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f316277e;

        b(View view, int i3) {
            this.f316276d = view;
            this.f316277e = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                Float f16 = (Float) animatedValue;
                this.f316276d.setY(f16.floatValue());
                r rVar = SlideBottomPanel.this.f316270e0;
                if (rVar != null) {
                    rVar.fadeBackground(1.0f - (f16.floatValue() / this.f316277e));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f316280d;

        d(View view) {
            this.f316280d = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                Float f16 = (Float) animatedValue;
                this.f316280d.setY(f16.floatValue());
                r rVar = SlideBottomPanel.this.f316270e0;
                if (rVar != null) {
                    rVar.fadeBackground(1.0f - (f16.floatValue() / (r1.G - SlideBottomPanel.this.P)));
                }
            }
        }
    }

    public SlideBottomPanel(Context context) {
        this(context, null);
    }

    private int d(int i3) {
        return (int) ((i3 * this.f316269e) + 0.5f);
    }

    private void k(MotionEvent motionEvent) {
        if (this.F == null) {
            this.F = VelocityTracker.obtain();
        }
        this.F.addMovement(motionEvent);
    }

    private boolean l(Context context) {
        return az.e(context);
    }

    private void q() {
        VelocityTracker velocityTracker = this.F;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.F.recycle();
            this.F = null;
        }
    }

    private void s() {
        Context context = this.f316266c0;
        if (context == null) {
            return;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.f316268d0 = displayMetrics.heightPixels;
        this.N = r0 - d(60);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        this.F.computeCurrentVelocity(1000, this.D);
        this.f316273i = this.F.getXVelocity();
        this.f316274m = this.F.getYVelocity();
    }

    public void b() {
        if (!this.f316272h && !this.f316271f) {
            View findViewWithTag = findViewWithTag(1);
            ValueAnimator duration = ValueAnimator.ofFloat(findViewWithTag.getY(), this.G - this.N).setDuration(this.R);
            duration.setTarget(findViewWithTag);
            duration.setInterpolator(this.f316264a0);
            duration.addUpdateListener(new d(findViewWithTag));
            duration.addListener(new e());
            duration.start();
            this.f316272h = true;
            this.W = false;
            r rVar = this.f316270e0;
            if (rVar != null) {
                rVar.displayPanel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double c(float f16, float f17, float f18, float f19) {
        float f26 = f16 - f18;
        float f27 = f17 - f19;
        return Math.sqrt((f26 * f26) + (f27 * f27));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean f16;
        k(motionEvent);
        r rVar = this.f316270e0;
        if (rVar != null) {
            rVar.cancelAnimator();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    g(motionEvent);
                }
            } else {
                h(motionEvent);
                q();
            }
            f16 = false;
        } else {
            f16 = f(motionEvent);
        }
        if (f16 || super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    protected int e() {
        if (this.W) {
            if (l(this.f316266c0)) {
                return (this.G - this.T) + az.c(this.f316266c0);
            }
            return this.G - this.T;
        }
        return (int) (this.G - this.P);
    }

    protected boolean f(MotionEvent motionEvent) {
        this.L = System.currentTimeMillis();
        this.H = motionEvent.getX();
        float y16 = motionEvent.getY();
        this.J = y16;
        this.I = y16;
        if (!this.f316272h && y16 > e()) {
            this.S = true;
            return true;
        }
        if (!this.f316272h && this.J <= e()) {
            this.S = false;
        } else {
            boolean z16 = this.f316272h;
            if (z16) {
                float f16 = this.J;
                int i3 = this.G;
                float f17 = this.N;
                if (f16 > i3 - f17 && f16 <= (i3 - f17) + this.P) {
                    this.S = true;
                }
            }
            if (z16 && this.J < this.G - this.N) {
                j();
                this.S = false;
            }
        }
        return false;
    }

    protected void g(MotionEvent motionEvent) {
        if (!this.S) {
            return;
        }
        a();
        if (Math.abs(this.f316273i) > Math.abs(this.f316274m)) {
            return;
        }
        View findViewWithTag = findViewWithTag(1);
        if (!this.M && Math.abs(motionEvent.getY() - this.I) > this.C) {
            this.M = true;
            this.J = motionEvent.getY();
            findViewWithTag.addOnLayoutChangeListener(new a());
        }
        if (this.M) {
            this.K = motionEvent.getY() - this.J;
            this.J = motionEvent.getY();
            float y16 = findViewWithTag.getY();
            r rVar = this.f316270e0;
            if (rVar != null) {
                int i3 = this.G;
                if (y16 > i3 - this.N) {
                    float f16 = this.P;
                    if (y16 < i3 - f16) {
                        rVar.fadeBackground(1.0f - (y16 / (i3 - f16)));
                    }
                }
            }
            float f17 = this.K;
            float f18 = y16 + f17;
            int i16 = this.G;
            float f19 = this.N;
            if (f18 <= i16 - f19) {
                findViewWithTag.offsetTopAndBottom((int) ((i16 - f19) - y16));
                return;
            }
            if (y16 + f17 >= e()) {
                if (this.W) {
                    return;
                }
                float f26 = this.K;
                int i17 = this.U;
                if (f26 > i17) {
                    this.K = i17;
                }
                findViewWithTag.offsetTopAndBottom((int) this.K);
                return;
            }
            findViewWithTag.offsetTopAndBottom((int) this.K);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void h(MotionEvent motionEvent) {
        if (!this.S) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.L;
        a();
        if (this.f316272h || motionEvent.getY() - this.I >= 0.0f || Math.abs(motionEvent.getY() - this.I) <= this.Q) {
            float f16 = this.f316274m;
            if (f16 >= 0.0f || Math.abs(f16) <= Math.abs(this.f316273i) || Math.abs(this.f316274m) <= this.E) {
                if (!this.f316272h && currentTimeMillis < 300) {
                    float y16 = motionEvent.getY();
                    float f17 = this.I;
                    if (y16 - f17 < 0.0f && c(this.H, f17, motionEvent.getX(), motionEvent.getY()) < f316263f0) {
                        b();
                        if (this.f316272h) {
                            View findViewWithTag = findViewWithTag(1);
                            float y17 = findViewWithTag.getY();
                            int i3 = this.G;
                            float f18 = this.N;
                            if (y17 >= i3 - f18) {
                                float f19 = this.Q;
                                if (y17 >= (i3 - f18) + f19) {
                                    if (y17 > (i3 - f18) + f19) {
                                        j();
                                    }
                                }
                            }
                            ObjectAnimator.ofFloat(findViewWithTag, "y", y17, i3 - f18).setDuration(this.R).start();
                        }
                        this.S = false;
                        this.M = false;
                        this.K = 0.0f;
                    }
                }
                if (!this.f316272h && this.M) {
                    int y18 = (int) (motionEvent.getY() - this.I);
                    boolean z16 = this.W;
                    if ((!z16 && y18 > this.V) || (z16 && y18 < 0 && Math.abs(y18) < this.Q)) {
                        o();
                    }
                    if (!this.W && y18 < 0 && Math.abs(y18) < this.Q) {
                        p();
                    }
                }
                if (this.f316272h) {
                }
                this.S = false;
                this.M = false;
                this.K = 0.0f;
            }
        }
        b();
        if (this.f316272h) {
        }
        this.S = false;
        this.M = false;
        this.K = 0.0f;
    }

    public void i() {
        if (!this.f316272h) {
            return;
        }
        j();
    }

    protected void j() {
        if (this.f316271f) {
            return;
        }
        View findViewWithTag = findViewWithTag(1);
        int i3 = (int) (this.G - this.P);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(findViewWithTag.getY(), this.G - this.P);
        ofFloat.setInterpolator(this.f316265b0);
        ofFloat.setTarget(findViewWithTag);
        ofFloat.addUpdateListener(new b(findViewWithTag, i3));
        ofFloat.addListener(new c());
        ofFloat.start();
        r rVar = this.f316270e0;
        if (rVar != null) {
            rVar.hidePanel();
        }
    }

    public boolean m() {
        return this.W;
    }

    public boolean n() {
        return this.f316272h;
    }

    public void o() {
        int i3;
        View findViewWithTag = findViewWithTag(1);
        float y16 = findViewWithTag.getY();
        if (l(this.f316266c0)) {
            i3 = (this.G - this.T) + az.c(this.f316266c0);
        } else {
            i3 = this.G - this.T;
        }
        ObjectAnimator.ofFloat(findViewWithTag, "y", y16, i3).setDuration(this.R).start();
        this.W = true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.M;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f316267d = getChildCount();
        int i19 = (int) (this.G - this.P);
        for (int i26 = 0; i26 < this.f316267d; i26++) {
            View childAt = getChildAt(i26);
            childAt.layout(0, i19, childAt.getMeasuredWidth(), childAt.getMeasuredHeight() + i19);
            childAt.setTag(1);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.M && !this.f316272h) {
            return false;
        }
        return true;
    }

    public void p() {
        View findViewWithTag = findViewWithTag(1);
        ObjectAnimator.ofFloat(findViewWithTag, "y", findViewWithTag.getY(), this.G - this.P).setDuration(this.R).start();
        this.W = false;
    }

    public void r(Configuration configuration) {
        if (configuration == null) {
            return;
        }
        s();
        this.G = this.f316268d0;
    }

    public void setSlidePanelListener(r rVar) {
        this.f316270e0 = rVar;
    }

    public SlideBottomPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideBottomPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316271f = false;
        this.f316272h = false;
        this.M = false;
        this.S = false;
        this.W = false;
        this.f316264a0 = new AccelerateInterpolator();
        this.f316265b0 = new AccelerateInterpolator();
        this.f316266c0 = context;
        this.f316269e = getResources().getDisplayMetrics().density;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(this.f316266c0);
        this.D = viewConfiguration.getScaledMaximumFlingVelocity();
        this.E = viewConfiguration.getScaledMinimumFlingVelocity();
        this.C = viewConfiguration.getScaledTouchSlop();
        s();
        float d16 = d(84);
        this.P = d16;
        f316263f0 = d16;
        this.Q = d(30);
        this.R = 250;
        this.G = this.f316268d0;
        if (l(this.f316266c0)) {
            int d17 = d(30);
            this.T = d17;
            this.U = (int) ((this.P - d17) + az.c(this.f316266c0));
        } else {
            int d18 = d(51);
            this.T = d18;
            this.U = (int) (this.P - d18);
        }
        this.V = d(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class c extends f {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            SlideBottomPanel slideBottomPanel = SlideBottomPanel.this;
            slideBottomPanel.f316271f = false;
            slideBottomPanel.f316272h = false;
            slideBottomPanel.W = false;
            r rVar = slideBottomPanel.f316270e0;
            if (rVar != null) {
                rVar.hidePanelFinish();
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SlideBottomPanel slideBottomPanel = SlideBottomPanel.this;
            slideBottomPanel.f316271f = false;
            slideBottomPanel.f316272h = false;
            slideBottomPanel.W = false;
            r rVar = slideBottomPanel.f316270e0;
            if (rVar != null) {
                rVar.hidePanelFinish();
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SlideBottomPanel.this.f316271f = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class e extends f {
        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            SlideBottomPanel slideBottomPanel = SlideBottomPanel.this;
            slideBottomPanel.f316271f = false;
            r rVar = slideBottomPanel.f316270e0;
            if (rVar != null) {
                rVar.displayPanelFinish();
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SlideBottomPanel slideBottomPanel = SlideBottomPanel.this;
            slideBottomPanel.f316271f = false;
            r rVar = slideBottomPanel.f316270e0;
            if (rVar != null) {
                rVar.displayPanelFinish();
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SlideBottomPanel.this.f316271f = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
