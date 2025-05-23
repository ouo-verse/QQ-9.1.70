package com.tencent.mobileqq.activity.aio.voicetextpanel.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.f;

/* compiled from: P */
/* loaded from: classes10.dex */
public class VoiceTextEditScrollerView extends RelativeLayout {
    private float C;
    private float D;
    private float E;
    private float F;
    private boolean G;
    private float H;
    private boolean I;
    private int J;
    private int K;
    private int L;
    private boolean M;
    private boolean N;
    private c71.a P;

    /* renamed from: d, reason: collision with root package name */
    private int f180187d;

    /* renamed from: e, reason: collision with root package name */
    private VelocityTracker f180188e;

    /* renamed from: f, reason: collision with root package name */
    private Context f180189f;

    /* renamed from: h, reason: collision with root package name */
    private float f180190h;

    /* renamed from: i, reason: collision with root package name */
    private float f180191i;

    /* renamed from: m, reason: collision with root package name */
    private int f180192m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f180193d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f180194e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f180195f;

        a(int i3, int i16, View view) {
            this.f180193d = i3;
            this.f180194e = i16;
            this.f180195f = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            VoiceTextEditScrollerView.this.m(valueAnimator, this.f180193d, this.f180194e, this.f180195f);
        }
    }

    public VoiceTextEditScrollerView(Context context) {
        this(context, null);
    }

    private void c(MotionEvent motionEvent) {
        this.f180188e.addMovement(motionEvent);
    }

    private boolean d(float f16) {
        float h16 = h(f16);
        if (this.F <= 2000.0f && h16 <= ScreenUtil.dip2px(150.0f) && this.I) {
            return false;
        }
        return true;
    }

    private void e() {
        this.f180188e.computeCurrentVelocity(1000, this.f180187d);
        this.C = this.f180188e.getYVelocity();
    }

    private void f() {
        if (!this.I) {
            if (this.N) {
                this.N = false;
                e71.a.a("0X800A8A0", 3, 0);
                return;
            } else {
                e71.a.a("0X800A8A0", 2, 0);
                return;
            }
        }
        e71.a.a("0X800A8A0", 1, 0);
    }

    private void g() {
        if (this.M) {
            c71.a aVar = this.P;
            if (aVar != null) {
                aVar.a();
            }
            this.M = false;
        }
    }

    private float h(float f16) {
        return f16 - this.E;
    }

    private void i(MotionEvent motionEvent) {
        this.M = true;
        this.D = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        this.E = rawY;
        this.H = rawY;
        this.F = -1.0f;
        this.I = false;
        c(motionEvent);
        c71.a aVar = this.P;
        if (aVar != null) {
            aVar.d(this.f180192m);
        }
    }

    private void j(MotionEvent motionEvent) {
        float abs = Math.abs(motionEvent.getRawX() - this.D);
        float abs2 = Math.abs(motionEvent.getRawY() - this.E);
        float f16 = this.f180190h;
        if (abs <= f16 && abs2 <= f16) {
            return;
        }
        this.I = true;
        if (abs2 > this.f180191i) {
            g();
        }
        int rawY = (int) (motionEvent.getRawY() - this.H);
        int top = getTop() + rawY;
        int bottom = getBottom() + rawY;
        if (top < this.L) {
            return;
        }
        c71.a aVar = this.P;
        if (aVar != null && top >= (this.f180192m - aVar.f()) - this.J) {
            return;
        }
        setTop(top);
        setBottom(bottom);
        this.F = this.C;
        this.H = motionEvent.getRawY();
    }

    private void k(MotionEvent motionEvent) {
        if (this.P != null) {
            g();
            if (d(motionEvent.getRawY())) {
                l(this.J);
                return;
            }
            int i3 = this.K;
            int i16 = this.J;
            this.P.b(i3 - i16, i16);
        }
    }

    private void l(int i3) {
        c71.a aVar = this.P;
        if (aVar != null) {
            int f16 = aVar.f();
            this.P.e((this.f180192m - f16) - i3, getHeight() - f16, getHeight());
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ValueAnimator valueAnimator, int i3, int i16, View view) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int animatedFraction = (int) (i3 - (valueAnimator.getAnimatedFraction() * i16));
        view.measure(View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec(animatedFraction, 1073741824));
        int i17 = (int) floatValue;
        view.layout(getLeft(), i17, getRight(), animatedFraction + i17);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void n(int i3, int i16, int i17, int i18, int i19, int i26, View view) {
        ValueAnimator duration = ValueAnimator.ofFloat(i3, i16).setDuration(i26);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.addUpdateListener(new a(i18, i17, view));
        duration.start();
        duration.addListener(new b(i19));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.G) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000d, code lost:
    
        if (r0 != 3) goto L14;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    c(motionEvent);
                    e();
                    j(motionEvent);
                }
            }
            k(motionEvent);
        } else {
            i(motionEvent);
        }
        return this.G;
    }

    public void setListener(c71.a aVar) {
        this.P = aVar;
    }

    public void setMaskClick(boolean z16) {
        this.N = z16;
    }

    public void setMaxHeight(int i3) {
        this.f180192m = i3;
    }

    public void setPanelActionDownPos(int i3, int i16) {
        this.J = i3;
        this.K = i16;
        this.L = getTop();
    }

    public void setSlideEnable(boolean z16) {
        this.G = z16;
    }

    public VoiceTextEditScrollerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VoiceTextEditScrollerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = false;
        this.I = false;
        this.J = -1;
        this.K = -1;
        this.L = -1;
        this.M = true;
        this.N = false;
        this.f180189f = context;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f180187d = viewConfiguration.getScaledMaximumFlingVelocity();
        float scaledTouchSlop = viewConfiguration.getScaledTouchSlop() * 2;
        this.f180190h = scaledTouchSlop;
        this.f180191i = scaledTouchSlop * 3.0f;
        ((WindowManager) this.f180189f.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.f180188e = VelocityTracker.obtain();
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f180197d;

        b(int i3) {
            this.f180197d = i3;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (VoiceTextEditScrollerView.this.P != null) {
                if (this.f180197d == 0) {
                    VoiceTextEditScrollerView.this.P.c();
                } else {
                    VoiceTextEditScrollerView.this.P.g();
                }
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
    }
}
