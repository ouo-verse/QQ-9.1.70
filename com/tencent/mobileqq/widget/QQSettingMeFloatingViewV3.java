package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQSettingMeFloatingViewV3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQSettingMeFloatingViewV3 extends FrameLayout {
    private final ObservableRelativeLayout C;
    private final LinearLayout D;
    private final LinearLayout E;
    private final View F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean P;
    private boolean Q;
    private h R;
    private e S;
    private final f T;
    private au U;
    private final AtomicBoolean V;
    private VelocityTracker W;

    /* renamed from: a0, reason: collision with root package name */
    private final MutableLiveData<Float> f316075a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f316076b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f316077c0;

    /* renamed from: d, reason: collision with root package name */
    private int f316078d;

    /* renamed from: d0, reason: collision with root package name */
    private BounceScrollView f316079d0;

    /* renamed from: e, reason: collision with root package name */
    private int f316080e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f316081e0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f316082f;

    /* renamed from: f0, reason: collision with root package name */
    private float f316083f0;

    /* renamed from: g0, reason: collision with root package name */
    private float f316084g0;

    /* renamed from: h, reason: collision with root package name */
    private float f316085h;

    /* renamed from: h0, reason: collision with root package name */
    private float f316086h0;

    /* renamed from: i, reason: collision with root package name */
    private int f316087i;

    /* renamed from: i0, reason: collision with root package name */
    private float f316088i0;

    /* renamed from: j0, reason: collision with root package name */
    private final int f316089j0;

    /* renamed from: k0, reason: collision with root package name */
    private byte f316090k0;

    /* renamed from: m, reason: collision with root package name */
    private int f316091m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f316092d;

        a(boolean z16) {
            this.f316092d = z16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f316092d) {
                if (QQSettingMeFloatingViewV3.this.R != null) {
                    QQSettingMeFloatingViewV3.this.R.onShowMin();
                }
            } else {
                if (QQSettingMeFloatingViewV3.this.R != null) {
                    QQSettingMeFloatingViewV3.this.R.onShowDefault();
                }
                QQSettingMeFloatingViewV3.this.B();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QQSettingMeFloatingViewV3.this.R != null) {
                QQSettingMeFloatingViewV3.this.R.onShowDefault();
            }
            QQSettingMeFloatingViewV3.this.B();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QQSettingMeFloatingViewV3.this.R != null) {
                QQSettingMeFloatingViewV3.this.R.onShowMin();
            }
            QQSettingMeFloatingViewV3.this.N = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            QQSettingMeFloatingViewV3.this.N = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface e {
        void a(View view, float f16, boolean z16, long j3, f fVar);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface f {
        void a(Animator animator, List<ValueAnimator> list, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface g {
        void a(float f16);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface h {
        void onShowDefault();

        void onShowMin();
    }

    public QQSettingMeFloatingViewV3(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.V.set(false);
    }

    private void D(long j3) {
        float y16 = this.C.getY();
        if (((int) y16) != 0 && this.V.compareAndSet(false, true)) {
            this.f316091m = 1;
            e eVar = this.S;
            if (eVar != null) {
                eVar.a(this.C, 0.0f, false, j3, this.T);
            } else {
                i(y16, 0, new c());
            }
        }
    }

    private void G(float f16) {
        float f17 = f16 - this.f316083f0;
        if (f17 > 0.0f && this.f316090k0 != 1) {
            this.f316090k0 = (byte) 1;
        } else if (f17 < 0.0f && this.f316090k0 != 2) {
            this.f316090k0 = (byte) 2;
        }
    }

    private void H(boolean z16) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z16);
        }
    }

    private void i(float f16, int i3, AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.C, "y", f16, i3);
        ofFloat.setInterpolator(new DecelerateInterpolator(0.5f));
        ofFloat.addListener(animatorListenerAdapter);
        ofFloat.setDuration(200L).start();
    }

    private void j() {
        h hVar = this.R;
        if (hVar == null) {
            return;
        }
        if (this.f316091m == 1) {
            hVar.onShowDefault();
        } else {
            hVar.onShowMin();
        }
    }

    private void k() {
        com.tencent.mobileqq.activity.qqsettingme.utils.b.a();
        float f16 = this.f316087i;
        if (f16 != this.f316085h) {
            this.f316085h = f16;
            this.f316075a0.postValue(Float.valueOf(f16));
            findViewById(R.id.aav).setLayoutParams(new RelativeLayout.LayoutParams(0, (int) this.f316085h));
            QLog.i("QQSettingMeFloatingView", 1, "checkAndRefreshInitHeight: " + this.f316085h);
        }
    }

    private void l() {
        float o16 = o();
        float m3 = this.f316080e - m();
        boolean z16 = false;
        if (o16 > m3) {
            float f16 = (o16 - m3) / (o16 - this.f316078d);
            byte b16 = this.f316090k0;
            if (b16 == 1 && !this.Q && f16 > 0.125d) {
                this.Q = true;
            } else if (b16 == 2 && this.Q && f16 < 0.125d) {
                this.Q = false;
            }
            z16 = true;
        }
        if (z16) {
            this.D.performHapticFeedback(1, 2);
        }
    }

    private float m() {
        this.D.getGlobalVisibleRect(new Rect());
        return r0.top;
    }

    private float q(float f16) {
        int o16 = o();
        int i3 = this.f316080e;
        float f17 = i3 - o16;
        float f18 = i3 - this.f316078d;
        if (f16 < f17) {
            return 1.0f;
        }
        if (f16 >= f18) {
            return 0.0f;
        }
        float f19 = (f16 - f17) / (f18 - f17);
        return 1.0f - (f19 * f19);
    }

    private void r() {
        ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height);
        layoutParams2.addRule(12);
        this.F.setLayoutParams(layoutParams2);
        this.C.addView(this.F);
    }

    private void s() {
        BounceScrollView bounceScrollView = new BounceScrollView(getContext(), null);
        bounceScrollView.setId(R.id.un8);
        bounceScrollView.setVerticalScrollBarEnabled(false);
        bounceScrollView.setFillViewport(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(2, R.id.um5);
        bounceScrollView.setLayoutParams(layoutParams);
        this.C.addView(bounceScrollView);
        this.f316079d0 = bounceScrollView;
        bounceScrollView.setOnScrollChangedListener(new b());
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.e6j, bounceScrollView);
        QLog.i("QQSettingMeFloatingView", 1, "QQSettingMeFloatingView getInitHeight: " + this.f316085h);
        inflate.findViewById(R.id.aav).setLayoutParams(new RelativeLayout.LayoutParams(0, (int) this.f316085h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!this.H && !this.I) {
            y();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(Animator animator, List list, boolean z16) {
        if (animator == null) {
            return;
        }
        animator.addListener(new a(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(Float f16) {
        this.f316075a0.postValue(Float.valueOf(f16.floatValue() + this.f316085h));
    }

    private void w(MotionEvent motionEvent) {
        if (!this.f316081e0) {
            return;
        }
        float rawY = motionEvent.getRawY();
        G(rawY);
        VelocityTracker velocityTracker = this.W;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        if (!this.L) {
            this.L = true;
        }
        float f16 = rawY - this.f316083f0;
        float y16 = this.C.getY();
        float q16 = y16 + (f16 * q(y16 + f16));
        if (q16 < 0.0f) {
            q16 = 0.0f;
        }
        float f17 = this.f316087i + q16;
        if (this.f316077c0) {
            if (f17 <= (this.f316080e - this.f316078d) / 2) {
                this.C.setY(q16);
            }
        } else if (q16 < this.f316080e - this.f316078d) {
            this.C.setY(q16);
        }
        this.f316083f0 = rawY;
        H(true);
        l();
    }

    private void x(MotionEvent motionEvent) {
        if (this.L) {
            this.L = false;
        }
        VelocityTracker velocityTracker = this.W;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        if (this.Q) {
            F(200L);
        } else {
            D(200L);
        }
        this.f316090k0 = (byte) 0;
        getParent().requestDisallowInterceptTouchEvent(false);
    }

    private void y() {
        if (this.f316091m == 0) {
            D(200L);
        } else {
            F(200L);
        }
    }

    public void A() {
        this.f316080e = 0;
    }

    public void C() {
        D(200L);
    }

    public void E() {
        F(200L);
    }

    public void F(long j3) {
        if (!this.f316082f) {
            D(j3 * 2);
            return;
        }
        if (this.f316091m == 0) {
            return;
        }
        this.f316091m = 0;
        float y16 = this.C.getY();
        int o16 = o() - this.f316078d;
        if (((int) y16) == o16) {
            return;
        }
        e eVar = this.S;
        if (eVar != null) {
            eVar.a(this.C, o16, true, j3, this.T);
        } else {
            i(y16, o16, new d());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (this.W == null) {
            this.W = VelocityTracker.obtain();
        }
        float m3 = m();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (!this.M && Math.abs(motionEvent.getRawY() - this.f316084g0) <= this.f316089j0) {
                        z19 = false;
                    } else {
                        z19 = true;
                    }
                    this.M = z19;
                    if (Math.abs(motionEvent.getRawX() - this.f316088i0) > Math.abs(motionEvent.getRawY() - this.f316086h0) * 2.0f) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    if (!this.M) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    this.f316088i0 = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    this.f316086h0 = rawY;
                    this.J = true;
                    if (this.H && !this.P) {
                        float f16 = this.f316085h;
                        if (m3 < f16) {
                            this.f316076b0 = true;
                        } else if (m3 == f16 && rawY > this.f316084g0) {
                            this.f316076b0 = false;
                        }
                        if (this.f316076b0) {
                            return super.dispatchTouchEvent(motionEvent);
                        }
                        if (!this.I && m3 == f16 && rawY < this.f316084g0) {
                            this.f316076b0 = true;
                            return super.dispatchTouchEvent(motionEvent);
                        }
                        w(motionEvent);
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        return true;
                    }
                }
            } else {
                if (this.H && this.f316076b0) {
                    this.f316076b0 = false;
                    return super.dispatchTouchEvent(motionEvent);
                }
                if (this.J && !this.P) {
                    x(motionEvent);
                }
            }
        } else {
            this.M = false;
            this.J = false;
            this.L = false;
            this.f316083f0 = motionEvent.getRawY();
            this.f316084g0 = motionEvent.getRawY();
            this.f316086h0 = this.f316083f0;
            this.f316088i0 = motionEvent.getRawX();
            Rect rect = new Rect();
            this.D.getGlobalVisibleRect(rect);
            if (!rect.isEmpty() && rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.H = z16;
            Rect rect2 = new Rect();
            this.E.getGlobalVisibleRect(rect2);
            if (!rect2.isEmpty() && rect2.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.I = z17;
            if (!z17) {
                this.F.getGlobalVisibleRect(rect);
                if (!rect.isEmpty() && rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                this.I = z18;
            }
            this.Q = false;
        }
        if (!this.H && !this.I && (this.f316091m == 0 || !this.K)) {
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (dispatchTouchEvent) {
            H(true);
            if (this.W != null && motionEvent.getActionMasked() == 1) {
                this.W.recycle();
                this.W = null;
            }
        }
        return dispatchTouchEvent;
    }

    public int n() {
        return this.f316091m;
    }

    public int o() {
        int i3;
        if (this.U != null && (i3 = this.f316087i) > 0) {
            return this.f316080e - i3;
        }
        return this.f316078d;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean z17 = true;
        if (this.P) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if ((action == 2 || action == 3) && this.J && !this.f316076b0) {
                z16 = true;
            } else {
                z16 = false;
            }
        } else {
            z16 = this.M;
        }
        if (!z16 && !this.N) {
            z17 = false;
        }
        H(z17);
        return z17;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (this.f316080e <= 0) {
            this.f316080e = getMeasuredHeight();
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (!this.G) {
            j();
            this.G = true;
        }
    }

    public int p() {
        return this.f316080e;
    }

    public void setController(au auVar) {
        if (auVar == null) {
            return;
        }
        this.U = auVar;
        this.f316087i = auVar.a();
        View b16 = auVar.b(this.D);
        if (b16 != null) {
            if (b16.getParent() != null) {
                ((ViewGroup) b16.getParent()).removeView(b16);
            }
            this.D.addView(b16);
        }
        k();
        this.f316091m = 1;
    }

    public void setCustomMoveAnimator(e eVar) {
        this.S = eVar;
    }

    public void setDefaultMarginTop(int i3) {
        if (this.f316087i == i3) {
            return;
        }
        this.f316087i = i3;
        k();
    }

    public void setEnableMoveToHalf(boolean z16) {
        this.f316077c0 = z16;
    }

    public void setEnableMoveToMin(boolean z16) {
        this.f316082f = z16;
    }

    public void setForbidTouchEvent(boolean z16) {
        this.P = z16;
    }

    public void setMinHeight(int i3) {
        this.f316078d = i3;
    }

    public void setOnShowEventListener(@Nullable h hVar) {
        this.R = hVar;
    }

    public void setOutSideTouchEnable(boolean z16) {
        this.K = z16;
    }

    public void setTopUpdateObserver(LifecycleOwner lifecycleOwner, final g gVar) {
        if (lifecycleOwner != null && gVar != null) {
            this.f316075a0.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.widget.av
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQSettingMeFloatingViewV3.g.this.a(((Float) obj).floatValue());
                }
            });
            this.C.b(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.widget.aw
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQSettingMeFloatingViewV3.this.v((Float) obj);
                }
            });
        }
    }

    public QQSettingMeFloatingViewV3(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QQSettingMeFloatingViewV3(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316082f = true;
        this.f316087i = 0;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = null;
        this.S = null;
        this.V = new AtomicBoolean(false);
        this.f316075a0 = new MutableLiveData<>(Float.valueOf(0.0f));
        this.f316076b0 = false;
        this.f316077c0 = true;
        this.f316079d0 = null;
        this.f316081e0 = true;
        this.f316090k0 = (byte) 0;
        ObservableRelativeLayout observableRelativeLayout = new ObservableRelativeLayout(context);
        this.C = observableRelativeLayout;
        addView(observableRelativeLayout, new FrameLayout.LayoutParams(-1, -1));
        this.F = LayoutInflater.from(context).inflate(R.layout.h3u, (ViewGroup) this, false);
        this.f316089j0 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f316085h = com.tencent.mobileqq.activity.qqsettingme.utils.b.b();
        s();
        r();
        this.E = (LinearLayout) observableRelativeLayout.findViewById(R.id.zxp);
        this.D = (LinearLayout) observableRelativeLayout.findViewById(R.id.um_);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.widget.ax
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQSettingMeFloatingViewV3.this.t(view);
            }
        });
        this.T = new f() { // from class: com.tencent.mobileqq.widget.ay
            @Override // com.tencent.mobileqq.widget.QQSettingMeFloatingViewV3.f
            public final void a(Animator animator, List list, boolean z16) {
                QQSettingMeFloatingViewV3.this.u(animator, list, z16);
            }
        };
    }

    public void z() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements BounceScrollView.d {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.BounceScrollView.d
        public void onScrollChanged(int i3, int i16, int i17, int i18) {
            QQSettingMeFloatingViewV3.this.f316075a0.postValue(Float.valueOf(QQSettingMeFloatingViewV3.this.f316085h - i16));
        }

        @Override // com.tencent.mobileqq.widget.BounceScrollView.d
        public void ae(float f16, float f17) {
        }
    }
}
