package com.tencent.biz.qqcircle.immersive.refresh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public class QFSPullRefreshLayout extends FrameLayout {
    private boolean C;
    private float D;
    private float E;
    private int F;
    private int G;
    private FrameLayout H;
    private com.tencent.biz.qqcircle.immersive.refresh.b I;
    private int J;
    private boolean K;
    private float L;
    private float M;
    private boolean N;
    private boolean P;
    private boolean Q;
    private int R;
    private boolean S;
    private float T;
    private float U;
    private float V;
    private float W;

    /* renamed from: a0, reason: collision with root package name */
    private float f89642a0;

    /* renamed from: b0, reason: collision with root package name */
    private QFSDefaultHeaderView f89643b0;

    /* renamed from: c0, reason: collision with root package name */
    private DefaultFooterView f89644c0;

    /* renamed from: d, reason: collision with root package name */
    private View f89645d;

    /* renamed from: d0, reason: collision with root package name */
    private ValueAnimator f89646d0;

    /* renamed from: e, reason: collision with root package name */
    private f f89647e;

    /* renamed from: e0, reason: collision with root package name */
    private ValueAnimator f89648e0;

    /* renamed from: f, reason: collision with root package name */
    private h f89649f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f89650f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f89651g0;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f89652h;

    /* renamed from: h0, reason: collision with root package name */
    private FooterStatusTask f89653h0;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.refresh.b f89654i;

    /* renamed from: i0, reason: collision with root package name */
    private HeaderStatusTask f89655i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f89656j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f89657k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f89658l0;

    /* renamed from: m, reason: collision with root package name */
    private int f89659m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f89660m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f89661n0;

    /* renamed from: o0, reason: collision with root package name */
    private final List<WeakReference<g>> f89662o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f89663p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f89664q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f89665r0;

    /* loaded from: classes4.dex */
    private static class FooterStatusTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QFSPullRefreshLayout> f89668d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f89669e;

        public FooterStatusTask(QFSPullRefreshLayout qFSPullRefreshLayout, boolean z16) {
            this.f89668d = new WeakReference<>(qFSPullRefreshLayout);
            this.f89669e = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSPullRefreshLayout qFSPullRefreshLayout;
            WeakReference<QFSPullRefreshLayout> weakReference = this.f89668d;
            if (weakReference == null) {
                qFSPullRefreshLayout = null;
            } else {
                qFSPullRefreshLayout = weakReference.get();
            }
            if (qFSPullRefreshLayout != null) {
                qFSPullRefreshLayout.i0(this.f89669e);
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class HeaderStatusTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QFSPullRefreshLayout> f89670d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f89671e;

        public HeaderStatusTask(QFSPullRefreshLayout qFSPullRefreshLayout, boolean z16) {
            this.f89670d = new WeakReference<>(qFSPullRefreshLayout);
            this.f89671e = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSPullRefreshLayout qFSPullRefreshLayout;
            WeakReference<QFSPullRefreshLayout> weakReference = this.f89670d;
            if (weakReference == null) {
                qFSPullRefreshLayout = null;
            } else {
                qFSPullRefreshLayout = weakReference.get();
            }
            if (qFSPullRefreshLayout != null) {
                qFSPullRefreshLayout.j0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            QFSPullRefreshLayout.this.f0(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            QFSPullRefreshLayout.this.f89661n0 = false;
            QFSPullRefreshLayout.this.e0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            QFSPullRefreshLayout.this.f89661n0 = true;
            QFSPullRefreshLayout.this.h0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View[] f89674d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f89675e;

        c(View[] viewArr, boolean z16) {
            this.f89674d = viewArr;
            this.f89675e = z16;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (View view : this.f89674d) {
                view.setTranslationY(floatValue);
            }
            float f16 = (-floatValue) / QFSPullRefreshLayout.this.L;
            if (f16 > 1.0f) {
                f16 = 1.0f;
            }
            if (QFSPullRefreshLayout.this.I == null) {
                return;
            }
            if (QFSPullRefreshLayout.this.R == 1) {
                QFSPullRefreshLayout.this.I.D(QFSPullRefreshLayout.this, f16);
            }
            QFSPullRefreshLayout.this.I.A(valueAnimator.getAnimatedFraction(), this.f89675e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View[] f89677d;

        d(View[] viewArr) {
            this.f89677d = viewArr;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (View view : this.f89677d) {
                view.setTranslationY(floatValue);
            }
            float f16 = floatValue / QFSPullRefreshLayout.this.D;
            if (f16 > 1.0f) {
                f16 = 1.0f;
            }
            if (QFSPullRefreshLayout.this.f89654i != null && QFSPullRefreshLayout.this.F == 1) {
                QFSPullRefreshLayout.this.f89654i.D(QFSPullRefreshLayout.this, f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            QFSPullRefreshLayout.this.L();
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(QFSPullRefreshLayout qFSPullRefreshLayout, int i3);

        void b(QFSPullRefreshLayout qFSPullRefreshLayout);
    }

    /* loaded from: classes4.dex */
    public interface g {
        void Y(boolean z16, boolean z17);

        void f0(boolean z16);

        void onHide(boolean z16);
    }

    /* loaded from: classes4.dex */
    public interface h {
        void a(MotionEvent motionEvent);
    }

    public QFSPullRefreshLayout(Context context) {
        this(context, null);
    }

    private void A() {
        QLog.d("PullRefreshLayout", 1, "[dispatchFooterViewPullStartEvent] mShowFooterLayoutByForceShow\uff1a" + this.f89664q0);
        for (WeakReference<g> weakReference : this.f89662o0) {
            if (weakReference != null) {
                g gVar = weakReference.get();
                if (gVar == null) {
                    this.f89662o0.remove(weakReference);
                } else {
                    gVar.f0(this.f89664q0);
                }
            }
        }
    }

    private void B(boolean z16) {
        QLog.d("PullRefreshLayout", 1, "[dispatchFooterViewPullUpEndEvent] visibility:" + z16 + "\uff0cmShowFooterLayoutByForceShow\uff1a" + this.f89664q0);
        for (WeakReference<g> weakReference : this.f89662o0) {
            if (weakReference != null) {
                g gVar = weakReference.get();
                if (gVar == null) {
                    this.f89662o0.remove(weakReference);
                } else {
                    gVar.Y(this.f89664q0, z16);
                }
            }
        }
    }

    private void C(MotionEvent motionEvent, float f16) {
        if (this.S) {
            this.f89645d.dispatchTouchEvent(motionEvent);
            return;
        }
        if (f16 > 0.0f) {
            motionEvent.setLocation(motionEvent.getX(), (motionEvent.getY() - ViewConfiguration.get(getContext()).getScaledTouchSlop()) - f16);
        } else if (f16 < 0.0f) {
            motionEvent.setLocation(motionEvent.getX(), (motionEvent.getY() + ViewConfiguration.get(getContext()).getScaledTouchSlop()) - f16);
        }
        motionEvent.setAction(0);
        this.f89645d.dispatchTouchEvent(motionEvent);
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(2);
        this.f89645d.dispatchTouchEvent(obtain);
        obtain.recycle();
        this.S = true;
    }

    private boolean D() {
        if (this.f89660m0 && E()) {
            return true;
        }
        return false;
    }

    private boolean E() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_open_footer_view_force_show", 1) == 1) {
            return true;
        }
        return false;
    }

    private float H() {
        int i3 = this.J;
        if (i3 == 1) {
            return this.f89645d.getTranslationY();
        }
        if (i3 == 3) {
            return this.H.getTranslationY();
        }
        return this.H.getTranslationY();
    }

    private float I() {
        int i3 = this.f89659m;
        if (i3 == 1) {
            return this.f89645d.getTranslationY();
        }
        if (i3 == 3) {
            return this.f89652h.getTranslationY();
        }
        return this.f89652h.getTranslationY();
    }

    private float J() {
        if (O()) {
            return this.f89642a0;
        }
        return 1.0f;
    }

    private boolean O() {
        if (H() < 0.0f) {
            return true;
        }
        return false;
    }

    private boolean Q() {
        if (this.f89665r0 || I() > 0.0f) {
            return true;
        }
        return false;
    }

    private void V(int i3, int i16) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f89645d.getLayoutParams();
        int measuredWidth = this.f89645d.getMeasuredWidth();
        int measuredHeight = this.f89645d.getMeasuredHeight();
        int i17 = i3 + layoutParams.leftMargin;
        int i18 = i16 + layoutParams.topMargin;
        this.f89645d.layout(i17, i18, measuredWidth + i17, measuredHeight + i18);
    }

    private void W(int i3, int i16) {
        int i17;
        int i18;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.H.getLayoutParams();
        int measuredWidth = this.H.getMeasuredWidth();
        int measuredHeight = this.H.getMeasuredHeight();
        if (this.J == 1) {
            i17 = i3 + layoutParams.leftMargin;
            i18 = (i16 - layoutParams.bottomMargin) - measuredHeight;
        } else {
            i17 = i3 + layoutParams.leftMargin;
            i18 = i16 - layoutParams.bottomMargin;
        }
        this.H.layout(i17, i18, measuredWidth + i17, measuredHeight + i18);
    }

    private void X(int i3, int i16) {
        int i17;
        int i18;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f89652h.getLayoutParams();
        int measuredWidth = this.f89652h.getMeasuredWidth();
        int measuredHeight = this.f89652h.getMeasuredHeight();
        if (this.f89659m == 1) {
            i17 = i3 + layoutParams.leftMargin;
            i18 = i16 + layoutParams.topMargin;
        } else {
            i17 = i3 + layoutParams.leftMargin;
            i18 = (i16 + layoutParams.topMargin) - measuredHeight;
        }
        this.f89652h.layout(i17, i18, measuredWidth + i17, measuredHeight + i18);
    }

    private boolean Y(float f16) {
        if (f16 > 0.0f) {
            if (v() && !O() && !this.f89665r0) {
                return false;
            }
            return true;
        }
        if (w() && !D()) {
            return false;
        }
        return true;
    }

    private void b0(float f16, MotionEvent motionEvent) {
        if (Q()) {
            a0(I() + f16, motionEvent);
            return;
        }
        if (O()) {
            Z(H() + f16, motionEvent);
            return;
        }
        if (f16 < 0.0f) {
            boolean D = D();
            if ((!w() && this.K) || D) {
                if (this.N && K()) {
                    h0();
                    e0();
                }
                Z(H() + f16, motionEvent);
                return;
            }
            C(motionEvent, f16);
            return;
        }
        if (f16 > 0.0f) {
            if (!v() && this.C) {
                a0(I() + f16, motionEvent);
            } else {
                C(motionEvent, f16);
            }
        }
    }

    private void d0(long j3) {
        float H = H();
        QLog.d("PullRefreshLayout", 1, "[finishLoadMore] resetLoadMoreTransY duration: " + j3 + " | footerTransY: " + H);
        q(H, 0.0f, new e(), j3, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        if (D()) {
            com.tencent.biz.qqcircle.immersive.refresh.b bVar = this.I;
            if (bVar != null) {
                bVar.s(this);
                return;
            }
            return;
        }
        if (this.R == 2) {
            return;
        }
        this.R = 2;
        com.tencent.biz.qqcircle.immersive.refresh.b bVar2 = this.I;
        if (bVar2 != null) {
            bVar2.s(this);
        }
        f fVar = this.f89647e;
        if (fVar != null) {
            fVar.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(int i3) {
        if (this.F == 2) {
            return;
        }
        this.F = 2;
        com.tencent.biz.qqcircle.immersive.refresh.b bVar = this.f89654i;
        if (bVar != null) {
            bVar.s(this);
        }
        f fVar = this.f89647e;
        if (fVar != null) {
            fVar.a(this, i3);
        }
    }

    private void g0() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f89645d.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.G;
        if (this.f89659m == 1) {
            addView(this.f89652h, 0, layoutParams2);
        } else {
            addView(this.f89652h, layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        if (this.J == 1) {
            addView(this.H, 0, layoutParams3);
        } else {
            addView(this.H, layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(boolean z16) {
        this.R = 3;
        com.tencent.biz.qqcircle.immersive.refresh.b bVar = this.I;
        if (bVar != null) {
            bVar.C(this, z16);
        }
        d0(300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        this.F = 3;
        com.tencent.biz.qqcircle.immersive.refresh.b bVar = this.f89654i;
        if (bVar != null) {
            bVar.C(this, true);
        }
        r(I(), 0.0f, null);
    }

    private void o() {
        if (this.F == 3) {
            this.F = 1;
            this.f89654i.U(this);
        }
        if (this.R == 3) {
            this.R = 1;
            com.tencent.biz.qqcircle.immersive.refresh.b bVar = this.I;
            if (bVar != null) {
                bVar.U(this);
            }
        }
    }

    private void p() {
        if (this.C && this.f89654i == null) {
            if (this.f89643b0 == null) {
                this.f89643b0 = new QFSDefaultHeaderView(getContext());
            }
            setHeaderView(this.f89643b0, this.f89659m);
        }
        if (this.K && this.I == null) {
            if (this.f89644c0 == null) {
                this.f89644c0 = new DefaultFooterView(getContext());
            }
            setFooterView(this.f89644c0, this.J);
        }
    }

    private void q(float f16, float f17, Animator.AnimatorListener animatorListener, long j3, boolean z16) {
        View[] viewArr;
        int i3 = this.J;
        if (i3 == 1) {
            viewArr = new View[]{this.f89645d};
        } else if (i3 == 3) {
            viewArr = new View[]{this.H};
        } else {
            viewArr = new View[]{this.f89645d, this.H};
        }
        if (this.f89648e0 == null) {
            this.f89648e0 = new ValueAnimator();
        }
        this.f89648e0.setFloatValues(f16, f17);
        this.f89648e0.removeAllListeners();
        this.f89648e0.removeAllUpdateListeners();
        this.f89648e0.setDuration(j3);
        if (animatorListener != null) {
            this.f89648e0.addListener(animatorListener);
        }
        this.f89648e0.addUpdateListener(new c(viewArr, z16));
        this.f89648e0.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(float f16, float f17, Animator.AnimatorListener animatorListener) {
        View[] viewArr;
        int i3 = this.f89659m;
        if (i3 == 1) {
            viewArr = new View[]{this.f89645d};
        } else if (i3 == 3) {
            viewArr = new View[]{this.f89652h};
        } else {
            viewArr = new View[]{this.f89645d, this.f89652h};
        }
        if (this.f89646d0 == null) {
            this.f89646d0 = new ValueAnimator();
        }
        this.f89646d0.setFloatValues(f16, f17);
        this.f89646d0.removeAllListeners();
        this.f89646d0.removeAllUpdateListeners();
        this.f89646d0.setDuration(300L);
        if (animatorListener != null) {
            this.f89646d0.addListener(animatorListener);
        }
        this.f89646d0.addUpdateListener(new d(viewArr));
        this.f89646d0.start();
    }

    private void u(MotionEvent motionEvent) {
        if (this.S) {
            C(motionEvent, 0.0f);
        }
        if (Q()) {
            float I = I();
            float f16 = this.D;
            if (I >= f16) {
                r(I, f16, new a());
                return;
            } else {
                r(I, 0.0f, null);
                return;
            }
        }
        if (O()) {
            float H = H();
            if ((-H) >= this.L) {
                B(true);
                q(H, -this.L, new b(), 300L, false);
                return;
            } else {
                B(false);
                d0(300L);
                return;
            }
        }
        if (this.f89663p0) {
            B(false);
            z();
        }
    }

    private boolean v() {
        View view = this.f89645d;
        if (view == null) {
            return false;
        }
        if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            if (absListView.getChildCount() <= 0) {
                return false;
            }
            if (absListView.getFirstVisiblePosition() <= 0 && absListView.getChildAt(0).getTop() >= absListView.getPaddingTop()) {
                return false;
            }
            return true;
        }
        if (!view.canScrollVertically(-1) && this.f89645d.getScrollY() <= 0) {
            return false;
        }
        return true;
    }

    private boolean w() {
        View view = this.f89645d;
        if (view == null) {
            return false;
        }
        return view.canScrollVertically(1);
    }

    private void z() {
        QLog.d("PullRefreshLayout", 1, "[dispatchFooterViewHideEvent] mShowFooterLayoutByForceShow\uff1a" + this.f89664q0);
        for (WeakReference<g> weakReference : this.f89662o0) {
            if (weakReference != null) {
                g gVar = weakReference.get();
                if (gVar == null) {
                    this.f89662o0.remove(weakReference);
                } else {
                    gVar.onHide(this.f89664q0);
                }
            }
        }
    }

    public void F(boolean z16) {
        QLog.d("PullRefreshLayout", 2, "[finishLoadMore] finish load more: " + z16);
        this.P = z16;
        if (this.f89645d == null) {
            QLog.d("PullRefreshLayout", 1, "[finishLoadMore] content view should not be null.");
        } else {
            if (this.R != 2) {
                return;
            }
            if (this.f89653h0 != null) {
                RFWThreadManager.getUIHandler().removeCallbacks(this.f89653h0);
            }
            this.f89653h0 = new FooterStatusTask(this, z16);
            RFWThreadManager.getUIHandler().postDelayed(this.f89653h0, 200L);
        }
    }

    public void G(boolean z16) {
        this.P = z16;
        if (this.f89645d != null && this.F == 2) {
            if (this.f89655i0 != null) {
                RFWThreadManager.getUIHandler().removeCallbacks(this.f89655i0);
            }
            this.f89655i0 = new HeaderStatusTask(this, z16);
            RFWThreadManager.getUIHandler().postDelayed(this.f89655i0, 200L);
        }
    }

    public boolean K() {
        return this.P;
    }

    public void L() {
        View refreshView;
        com.tencent.biz.qqcircle.immersive.refresh.b bVar = this.I;
        if (bVar == null) {
            refreshView = null;
        } else {
            refreshView = bVar.getRefreshView();
        }
        if (refreshView == null) {
            QLog.e("PullRefreshLayout", 1, "[hideFooterView] load more view should not be null.");
        } else {
            if (refreshView.getVisibility() == 8) {
                return;
            }
            QLog.d("PullRefreshLayout", 2, "[hideFooterView] hide footer view.");
            refreshView.setVisibility(8);
            z();
        }
    }

    public void M() {
        QLog.d("PullRefreshLayout", 1, "[hideFooterViewByForce]");
        this.R = 3;
        d0(300L);
    }

    public boolean N() {
        return this.f89651g0;
    }

    public boolean P() {
        View refreshView;
        com.tencent.biz.qqcircle.immersive.refresh.b bVar = this.I;
        if (bVar == null) {
            refreshView = null;
        } else {
            refreshView = bVar.getRefreshView();
        }
        if (refreshView != null && refreshView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public boolean R() {
        return this.K;
    }

    public boolean S() {
        if (this.R == 2) {
            return true;
        }
        return false;
    }

    public boolean T() {
        if (this.F == 2) {
            return true;
        }
        return false;
    }

    public boolean U() {
        return this.f89661n0;
    }

    protected void Z(float f16, MotionEvent motionEvent) {
        if (this.S) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            this.f89645d.dispatchTouchEvent(obtain);
            obtain.recycle();
            this.S = false;
        }
        if (!this.f89663p0) {
            this.f89664q0 = D();
            this.f89663p0 = true;
            A();
        }
        float f17 = this.L;
        float f18 = (-f16) / f17;
        if (f18 > this.M / f17) {
            return;
        }
        if (f16 > 0.0f) {
            C(motionEvent, f16);
            f16 = 0.0f;
        }
        com.tencent.biz.qqcircle.immersive.refresh.b bVar = this.I;
        if (bVar != null && this.R == 1) {
            bVar.D(this, f18);
        }
        int i3 = this.J;
        if (i3 == 1) {
            this.f89645d.setTranslationY(f16);
        } else if (i3 == 3) {
            this.H.setTranslationY(f16);
        } else {
            this.H.setTranslationY(f16);
            this.f89645d.setTranslationY(f16);
        }
    }

    protected void a0(float f16, MotionEvent motionEvent) {
        if (this.S) {
            motionEvent.setAction(3);
            this.f89645d.dispatchTouchEvent(motionEvent);
            this.S = false;
        }
        float f17 = this.D;
        float f18 = f16 / f17;
        if (f18 > this.E / f17) {
            return;
        }
        if (f16 < 0.0f) {
            C(motionEvent, f16);
            f16 = 0.0f;
        }
        com.tencent.biz.qqcircle.immersive.refresh.b bVar = this.f89654i;
        if (bVar != null && this.F == 1) {
            bVar.D(this, f18);
        }
        int i3 = this.f89659m;
        if (i3 == 1) {
            this.f89645d.setTranslationY(f16);
        } else if (i3 == 3) {
            this.f89652h.setTranslationY(f16);
        } else {
            this.f89652h.setTranslationY(f16);
            this.f89645d.setTranslationY(f16);
        }
    }

    public void c0(WeakReference<g> weakReference) {
        this.f89662o0.remove(weakReference);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        h hVar;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if ((actionMasked == 1 || actionMasked == 3 || actionMasked == 6) && Math.abs(motionEvent.getY() - this.W) >= 100.0f && (hVar = this.f89649f) != null) {
                hVar.a(motionEvent);
            }
        } else {
            this.W = motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void h0() {
        View refreshView;
        com.tencent.biz.qqcircle.immersive.refresh.b bVar = this.I;
        if (bVar == null) {
            refreshView = null;
        } else {
            refreshView = bVar.getRefreshView();
        }
        if (refreshView == null) {
            QLog.d("PullRefreshLayout", 1, "[showFooterView] load more view should not be null.");
            return;
        }
        if (this.f89657k0) {
            refreshView.setVisibility(4);
            return;
        }
        if (refreshView.getVisibility() == 0) {
            return;
        }
        QLog.d("PullRefreshLayout", 2, "[showFooterView] show footer view, isLoadMoreEnable: " + R());
        refreshView.setVisibility(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getChildCount() == 1) {
            this.f89645d = getChildAt(0);
            g0();
            p();
            return;
        }
        throw new RuntimeException("can only have one child widget");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeView(this.f89652h);
        removeView(this.H);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f89650f0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (T() || !this.f89658l0) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 2) {
                if (this.f89645d == null) {
                    return false;
                }
                int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
                float y16 = motionEvent.getY() - this.V;
                if (Math.abs(y16) < scaledTouchSlop) {
                    return false;
                }
                this.T = motionEvent.getX();
                this.U = motionEvent.getY();
                return Y(y16);
            }
        } else {
            this.S = false;
            this.V = motionEvent.getY();
            o();
            this.f89663p0 = false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingBottom = ((i18 - i16) - getPaddingBottom()) - this.f89656j0;
        V(paddingLeft, paddingTop);
        X(paddingLeft, paddingTop);
        W(paddingLeft, paddingBottom);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (this.D <= 0.0f) {
            this.D = this.f89652h.getMeasuredHeight();
        }
        float f16 = this.E;
        if (f16 <= 0.0f || f16 < this.D) {
            this.E = this.D * 2.0f;
        }
        if (this.L <= 0.0f) {
            this.L = this.H.getMeasuredHeight();
        }
        float f17 = this.M;
        if (f17 <= 0.0f || f17 < this.L) {
            this.M = this.L * 2.0f;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (T() || !this.f89658l0) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3 && actionMasked != 6) {
                        return super.onTouchEvent(motionEvent);
                    }
                } else {
                    float x16 = motionEvent.getX();
                    float y16 = motionEvent.getY();
                    float f16 = y16 - this.U;
                    this.T = x16;
                    this.U = y16;
                    float rint = (float) Math.rint(f16 / J());
                    if (rint == 0.0f) {
                        return true;
                    }
                    b0(rint, motionEvent);
                    return true;
                }
            }
            u(motionEvent);
            return true;
        }
        this.T = motionEvent.getX();
        this.U = motionEvent.getY();
        return true;
    }

    public void s(int i3) {
        t(0L, i3);
    }

    public void setAutoLoadEnable(boolean z16) {
        this.N = z16;
    }

    public void setCloseFooterMoveRadio(float f16) {
        this.f89642a0 = f16;
    }

    public void setEnableShowFooterViewByForce(boolean z16) {
        QLog.d("PullRefreshLayout", 1, "[setEnableShowFooterViewByForce] enabled:" + z16);
        this.f89660m0 = z16;
    }

    public void setEnabledCheckContentBottom(boolean z16) {
        this.Q = z16;
    }

    public void setFakeLoadingMoreAnim() {
        this.f89651g0 = true;
        com.tencent.biz.qqcircle.immersive.refresh.b bVar = this.I;
        if (bVar == null) {
            QLog.d("PullRefreshLayout", 1, "[setFakeLoadingMoreAnim] footer view should not be null.");
        } else {
            bVar.s(this);
        }
    }

    public void setFooterPosition(int i3) {
        this.J = i3;
    }

    public void setFooterView(com.tencent.biz.qqcircle.immersive.refresh.b bVar) {
        setFooterView(bVar, 2, null);
    }

    public void setForceInvisibleLoadMoreContent(boolean z16) {
        this.f89657k0 = z16;
    }

    public void setHeaderPosition(int i3) {
        this.f89659m = i3;
    }

    public void setHeaderView(com.tencent.biz.qqcircle.immersive.refresh.b bVar) {
        setHeaderView(bVar, 2, null);
    }

    public void setHeaderViewMarginTop(int i3) {
        this.G = i3;
    }

    public void setLoadMoreEnable(boolean z16) {
        this.K = z16;
    }

    public void setOnRefreshListener(f fVar) {
        this.f89647e = fVar;
    }

    public void setOnShowFooterViewListener(WeakReference<g> weakReference) {
        this.f89662o0.add(weakReference);
    }

    public void setOnVerticalSwipeListener(h hVar) {
        this.f89649f = hVar;
    }

    public void setRefreshEnable(boolean z16) {
        this.C = z16;
    }

    public void setSourceToHeadOut(boolean z16) {
        this.f89665r0 = z16;
    }

    public void setStartLoadMoreDistance(float f16) {
        this.L = f16;
    }

    public void setStartRefreshDistance(float f16) {
        this.D = f16;
    }

    public void setTouchEnable(boolean z16) {
        this.f89658l0 = z16;
    }

    public void setViewBottomMargin(int i3) {
        this.f89656j0 = i3;
    }

    public void t(long j3, final int i3) {
        if (this.F != 2 && I() <= 0.0f) {
            postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.5

                /* renamed from: com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout$5$a */
                /* loaded from: classes4.dex */
                class a extends AnimatorListenerAdapter {
                    a() {
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        QFSPullRefreshLayout.this.f0(i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (QFSPullRefreshLayout.this.f89645d == null) {
                        return;
                    }
                    if (QFSPullRefreshLayout.this.F == 3) {
                        QFSPullRefreshLayout.this.f89654i.U(QFSPullRefreshLayout.this);
                        QFSPullRefreshLayout.this.F = 1;
                    }
                    QFSPullRefreshLayout qFSPullRefreshLayout = QFSPullRefreshLayout.this;
                    qFSPullRefreshLayout.r(0.0f, qFSPullRefreshLayout.D, new a());
                }
            }, j3);
        }
    }

    public void x() {
        this.f89651g0 = false;
    }

    public void y(boolean z16) {
        this.f89650f0 = z16;
    }

    public QFSPullRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f89659m = 2;
        this.C = true;
        this.D = 0.0f;
        this.E = 0.0f;
        this.F = 3;
        this.J = 2;
        this.K = true;
        this.L = 0.0f;
        this.M = 0.0f;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = 3;
        this.S = false;
        this.f89642a0 = 3.0f;
        this.f89656j0 = 0;
        this.f89657k0 = false;
        this.f89658l0 = true;
        this.f89660m0 = false;
        this.f89661n0 = false;
        this.f89662o0 = new CopyOnWriteArrayList();
        this.f89665r0 = false;
        if (isInEditMode()) {
            return;
        }
        this.f89652h = new FrameLayout(context);
        this.H = new FrameLayout(context);
    }

    public void setFooterView(com.tencent.biz.qqcircle.immersive.refresh.b bVar, int i3) {
        setFooterView(bVar, i3, null);
    }

    public void setHeaderView(com.tencent.biz.qqcircle.immersive.refresh.b bVar, int i3) {
        setHeaderView(bVar, i3, null);
    }

    public void setFooterView(com.tencent.biz.qqcircle.immersive.refresh.b bVar, int i3, FrameLayout.LayoutParams layoutParams) {
        if (bVar == null || bVar.getRefreshView() == null) {
            return;
        }
        this.J = i3;
        this.I = bVar;
        this.L = bVar.b0();
        this.M = bVar.B();
        this.H.removeAllViews();
        if (layoutParams != null) {
            this.H.addView(bVar.getRefreshView(), layoutParams);
        } else {
            this.H.addView(bVar.getRefreshView());
        }
    }

    public void setHeaderView(com.tencent.biz.qqcircle.immersive.refresh.b bVar, int i3, FrameLayout.LayoutParams layoutParams) {
        if (bVar == null || bVar.getRefreshView() == null) {
            return;
        }
        this.f89654i = bVar;
        this.f89659m = i3;
        this.D = bVar.b0();
        this.E = bVar.B();
        this.f89652h.removeAllViews();
        if (layoutParams != null) {
            this.f89652h.addView(bVar.getRefreshView(), layoutParams);
        } else {
            this.f89652h.addView(bVar.getRefreshView());
        }
    }
}
