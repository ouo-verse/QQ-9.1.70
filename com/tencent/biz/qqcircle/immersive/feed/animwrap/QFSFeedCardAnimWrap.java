package com.tencent.biz.qqcircle.immersive.feed.animwrap;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.immersive.views.QFSLightView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.RoundFrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.mobileqq.widget.ak;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedCardAnimWrap implements View.OnClickListener {

    /* renamed from: a0, reason: collision with root package name */
    private static final float f85877a0 = cx.a(36.0f);

    /* renamed from: b0, reason: collision with root package name */
    private static final float f85878b0 = cx.a(48.0f);

    /* renamed from: c0, reason: collision with root package name */
    private static final float f85879c0 = cx.a(52.0f);

    /* renamed from: d0, reason: collision with root package name */
    private static final float f85880d0 = cx.a(116.0f);

    /* renamed from: e0, reason: collision with root package name */
    private static final float f85881e0 = cx.a(5.0f);

    /* renamed from: f0, reason: collision with root package name */
    private static final float f85882f0 = cx.a(8.0f);

    /* renamed from: g0, reason: collision with root package name */
    private static final float f85883g0 = cx.a(12.0f);

    /* renamed from: h0, reason: collision with root package name */
    private static final float f85884h0 = cx.a(84.0f);

    /* renamed from: i0, reason: collision with root package name */
    private static final float f85885i0 = cx.a(40.0f);

    /* renamed from: j0, reason: collision with root package name */
    private static final float f85886j0 = cx.a(12.0f);

    /* renamed from: k0, reason: collision with root package name */
    private static final float f85887k0 = cx.a(72.0f);

    /* renamed from: l0, reason: collision with root package name */
    private static final float f85888l0 = cx.a(10.0f);

    /* renamed from: m0, reason: collision with root package name */
    private static final float f85889m0 = cx.a(12.0f);

    /* renamed from: n0, reason: collision with root package name */
    private static final float f85890n0 = cx.a(4.0f);

    /* renamed from: o0, reason: collision with root package name */
    private static final float f85891o0 = cx.a(6.0f);

    /* renamed from: p0, reason: collision with root package name */
    private static final float f85892p0 = cx.a(64.0f);

    /* renamed from: q0, reason: collision with root package name */
    private static final float f85893q0 = cx.a(28.0f);

    /* renamed from: r0, reason: collision with root package name */
    private static final float f85894r0 = cx.a(32.0f);
    private View C;
    private View D;
    private ImageView E;
    private TextView F;
    private TextView G;
    private View H;
    private TextView I;
    private FrameLayout J;
    private ImageView K;
    RoundFrameLayout L;
    QFSLightView M;
    private long N;
    private j S;
    private ValueAnimator T;
    private ValueAnimator U;
    private ValueAnimator V;
    private ValueAnimator W;

    /* renamed from: i, reason: collision with root package name */
    private View f85899i;

    /* renamed from: m, reason: collision with root package name */
    private View f85900m;

    /* renamed from: d, reason: collision with root package name */
    private float f85895d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f85896e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    private float f85897f = -1.0f;

    /* renamed from: h, reason: collision with root package name */
    private int f85898h = -1;
    ValueAnimator P = null;
    private boolean Q = false;
    private boolean R = false;
    Runnable X = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedCardAnimWrap.1
        @Override // java.lang.Runnable
        public void run() {
            QLog.d("QFSFeedCardAnimWrap", 1, "buttonAnimRunnable run");
            if (QFSFeedCardAnimWrap.this.Q) {
                QFSFeedCardAnimWrap qFSFeedCardAnimWrap = QFSFeedCardAnimWrap.this;
                qFSFeedCardAnimWrap.P.setDuration(qFSFeedCardAnimWrap.N);
                QFSFeedCardAnimWrap.this.P.start();
            }
        }
    };
    Runnable Y = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedCardAnimWrap.2
        @Override // java.lang.Runnable
        public void run() {
            QLog.d("QFSFeedCardAnimWrap", 1, "openCardRunnable run");
            if (QFSFeedCardAnimWrap.this.Q) {
                QFSFeedCardAnimWrap.this.T.start();
                QFSFeedCardAnimWrap.this.V.start();
            }
        }
    };
    Runnable Z = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedCardAnimWrap.3
        @Override // java.lang.Runnable
        public void run() {
            QLog.d("QFSFeedCardAnimWrap", 1, "hideBigCardRunnable run");
            if (QFSFeedCardAnimWrap.this.Q) {
                QFSFeedCardAnimWrap.this.U.start();
                QFSFeedCardAnimWrap.this.W.start();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSFeedCardAnimWrap.this.u(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (QFSFeedCardAnimWrap.this.K != null && valueAnimator != null) {
                QFSFeedCardAnimWrap.this.K.setAlpha(QFSFeedCardAnimWrap.this.s(true, 0, 1, valueAnimator.getAnimatedFraction()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QFSFeedCardAnimWrap.this.K != null) {
                QFSFeedCardAnimWrap.this.K.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QFSFeedCardAnimWrap.this.w(valueAnimator, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSFeedCardAnimWrap.this.u(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSFeedCardAnimWrap.this.v(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (QFSFeedCardAnimWrap.this.K != null && valueAnimator != null) {
                QFSFeedCardAnimWrap.this.K.setAlpha(QFSFeedCardAnimWrap.this.s(false, 0, 1, valueAnimator.getAnimatedFraction()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (QFSFeedCardAnimWrap.this.K != null) {
                QFSFeedCardAnimWrap.this.K.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QFSFeedCardAnimWrap.this.w(valueAnimator, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface j {
        void P(int i3);
    }

    public QFSFeedCardAnimWrap(View view, View view2, j jVar) {
        if (view2 == null) {
            return;
        }
        QLog.d("QFSFeedCardAnimWrap", 1, "new instance");
        this.S = jVar;
        this.D = view2;
        this.f85899i = view.findViewById(R.id.v_p);
        this.f85900m = view.findViewById(R.id.f39931d0);
        this.C = view.findViewById(R.id.f39941d1);
        RoundFrameLayout roundFrameLayout = (RoundFrameLayout) view2.findViewById(R.id.f39371bh);
        this.L = roundFrameLayout;
        this.F = (TextView) roundFrameLayout.findViewById(R.id.f38621_g);
        this.G = (TextView) this.L.findViewById(R.id.f38581_c);
        this.H = this.L.findViewById(R.id.f38561_a);
        this.I = (TextView) this.L.findViewById(R.id.f38571_b);
        this.E = (ImageView) this.L.findViewById(R.id.f38591_d);
        ImageView imageView = (ImageView) this.L.findViewById(R.id.f39381bi);
        this.K = imageView;
        imageView.setOnClickListener(this);
        this.J = (FrameLayout) this.L.findViewById(R.id.f39351bf);
        this.M = (QFSLightView) this.L.findViewById(R.id.f39361bg);
        x();
    }

    private void A() {
        RoundFrameLayout roundFrameLayout;
        View view;
        if (this.f85898h < 0 && (view = this.f85900m) != null) {
            this.f85898h = view.getHeight();
        }
        if (this.f85895d < 0.0f && (roundFrameLayout = this.L) != null) {
            this.f85895d = roundFrameLayout.getWidth();
        }
        if (this.f85899i != null) {
            if (this.f85896e < 0.0f || this.f85897f < 0.0f) {
                this.f85896e = Math.max(cx.a(268.0f), this.f85895d);
                float min = Math.min(this.f85899i.getWidth() - cx.a(12.0f), t());
                if (this.f85896e > min) {
                    QLog.i("QFSFeedCardAnimWrap", 1, "initViewParam adjust width before " + this.f85896e + ", " + this.f85897f);
                    this.f85896e = min;
                    QLog.i("QFSFeedCardAnimWrap", 1, "initViewParam adjust width after " + this.f85896e + ", " + this.f85897f);
                }
                this.f85897f = this.f85896e - (cx.a(12.0f) * 2);
                o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(ValueAnimator valueAnimator) {
        GradientDrawable gradientDrawable;
        TextView textView = this.I;
        if (textView == null || (gradientDrawable = (GradientDrawable) textView.getBackground()) == null) {
            return;
        }
        gradientDrawable.setColor(q(((Float) valueAnimator.getAnimatedValue()).floatValue()).intValue());
    }

    private void E() {
        F();
        View view = this.H;
        if (view != null) {
            float f16 = f85882f0;
            view.setPadding((int) f16, (int) f16, (int) f85884h0, 0);
        }
        ImageView imageView = this.E;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            float f17 = f85877a0;
            layoutParams.height = (int) f17;
            layoutParams.width = (int) f17;
            this.E.setLayoutParams(layoutParams);
        }
        TextView textView = this.I;
        if (textView != null && (textView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.I.getLayoutParams();
            layoutParams2.width = (int) f85892p0;
            layoutParams2.height = (int) f85893q0;
            layoutParams2.rightMargin = (int) f85888l0;
            layoutParams2.topMargin = (int) f85886j0;
            this.I.setLayoutParams(layoutParams2);
        }
        RoundFrameLayout roundFrameLayout = this.L;
        if (roundFrameLayout != null) {
            ViewGroup.LayoutParams layoutParams3 = roundFrameLayout.getLayoutParams();
            layoutParams3.height = (int) f85879c0;
            layoutParams3.width = -2;
            this.L.setLayoutParams(layoutParams3);
        }
        TextView textView2 = this.G;
        if (textView2 != null) {
            textView2.setPadding(0, (int) f85890n0, 0, 0);
        }
        TextView textView3 = this.F;
        if (textView3 != null) {
            textView3.setTextSize(1, 13.0f);
        }
        TextView textView4 = this.G;
        if (textView4 != null) {
            textView4.setTextSize(1, 11.0f);
        }
        ImageView imageView2 = this.K;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    private void F() {
        View view = this.f85900m;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = -2;
            this.f85900m.setLayoutParams(layoutParams);
            this.f85900m.setAlpha(1.0f);
        }
        View view2 = this.C;
        if (view2 != null) {
            view2.setAlpha(1.0f);
        }
    }

    private void o() {
        FrameLayout frameLayout = this.J;
        if (frameLayout != null && (frameLayout.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.J.getLayoutParams();
            layoutParams.width = (int) this.f85897f;
            this.J.setLayoutParams(layoutParams);
        }
    }

    private float r(boolean z16, float f16, float f17, float f18) {
        if (z16) {
            return ((f17 - f16) * f18) + f16;
        }
        return ((f16 - f17) * f18) + f17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float s(boolean z16, int i3, int i16, float f16) {
        float f17;
        float f18;
        if (z16) {
            f17 = (i16 - i3) * f16;
            f18 = i3;
        } else {
            f17 = (i3 - i16) * f16;
            f18 = i16;
        }
        return f17 + f18;
    }

    private int t() {
        return (cx.g() * 270) / QidPagView.DESIGN_PAG_WIDTH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z16) {
        TextView textView;
        float f16;
        float f17;
        TextView textView2 = this.F;
        if (textView2 != null) {
            if (z16) {
                f17 = 15.0f;
            } else {
                f17 = 13.0f;
            }
            textView2.setTextSize(1, f17);
        }
        TextView textView3 = this.G;
        if (textView3 != null) {
            if (z16) {
                f16 = 12.0f;
            } else {
                f16 = 11.0f;
            }
            textView3.setTextSize(1, f16);
        }
        if (z16 && (textView = this.I) != null && this.J != null && this.M != null) {
            textView.setVisibility(8);
            this.J.setVisibility(0);
            this.M.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z16) {
        TextView textView;
        if (!z16 && (textView = this.I) != null && this.J != null) {
            textView.setVisibility(0);
            this.J.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(ValueAnimator valueAnimator, boolean z16) {
        if (valueAnimator == null) {
            return;
        }
        float animatedFraction = valueAnimator.getAnimatedFraction();
        View view = this.f85900m;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = (int) s(z16, this.f85898h, 0, animatedFraction);
            this.f85900m.setLayoutParams(layoutParams);
            this.f85900m.setAlpha(s(z16, 1, 0, animatedFraction));
        }
        View view2 = this.C;
        if (view2 != null) {
            view2.setAlpha(s(z16, 1, 0, animatedFraction));
        }
        if (this.H != null) {
            int r16 = (int) r(z16, f85882f0, f85883g0, animatedFraction);
            this.H.setPadding(r16, r16, (int) r(z16, f85884h0, f85885i0, animatedFraction), 0);
        }
        ImageView imageView = this.E;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
            int r17 = (int) r(z16, f85877a0, f85878b0, animatedFraction);
            layoutParams2.height = r17;
            layoutParams2.width = r17;
            this.E.setLayoutParams(layoutParams2);
        }
        TextView textView = this.I;
        if (textView != null && (textView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.I.getLayoutParams();
            layoutParams3.width = (int) r(z16, f85892p0, this.f85897f, animatedFraction);
            layoutParams3.height = (int) r(z16, f85893q0, f85894r0, animatedFraction);
            layoutParams3.rightMargin = (int) r(z16, f85888l0, f85889m0, animatedFraction);
            layoutParams3.topMargin = (int) r(z16, f85886j0, f85887k0, animatedFraction);
            this.I.setLayoutParams(layoutParams3);
        }
        RoundFrameLayout roundFrameLayout = this.L;
        if (roundFrameLayout != null) {
            ViewGroup.LayoutParams layoutParams4 = roundFrameLayout.getLayoutParams();
            layoutParams4.height = (int) r(z16, f85879c0, f85880d0, animatedFraction);
            layoutParams4.width = (int) r(z16, this.f85895d, this.f85896e, animatedFraction);
            this.L.setLayoutParams(layoutParams4);
        }
        View view3 = this.D;
        if (view3 != null && (view3.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.D.getLayoutParams();
            layoutParams5.bottomMargin = (int) r(z16, f85881e0, 0.0f, animatedFraction);
            this.D.setLayoutParams(layoutParams5);
        }
        TextView textView2 = this.G;
        if (textView2 != null) {
            textView2.setPadding(0, (int) r(z16, f85890n0, f85891o0, animatedFraction), 0, 0);
        }
    }

    private void x() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.P = ofFloat;
        ofFloat.setDuration(this.N);
        this.P.setInterpolator(new AccelerateDecelerateInterpolator());
        this.P.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.x
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSFeedCardAnimWrap.this.B(valueAnimator);
            }
        });
        this.P.addListener(new d());
    }

    private void y() {
        if (this.U == null) {
            PathInterpolator pathInterpolator = new PathInterpolator(0.4f, 0.0f, 0.68f, 0.06f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.U = ofFloat;
            ofFloat.setInterpolator(pathInterpolator);
            this.U.setDuration(500L);
            this.U.addUpdateListener(new e());
            this.U.addListener(new f());
        }
        if (this.W == null) {
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.W = ofFloat2;
            ofFloat2.setDuration(500L);
            this.W.addUpdateListener(new g());
            this.W.addListener(new h());
        }
    }

    private void z() {
        if (this.T == null) {
            PathInterpolator pathInterpolator = new PathInterpolator(0.4f, 0.0f, 0.68f, 0.06f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.T = ofFloat;
            ofFloat.setInterpolator(pathInterpolator);
            this.T.setDuration(500L);
            this.T.addUpdateListener(new i());
            this.T.addListener(new a());
        }
        if (this.V == null) {
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.V = ofFloat2;
            ofFloat2.setDuration(500L);
            this.V.addUpdateListener(new b());
            this.V.addListener(new c());
        }
    }

    public void C() {
        QLog.i("QFSFeedCardAnimWrap", 1, NodeProps.ON_ATTACHED_TO_WINDOW);
        this.Q = true;
        E();
        this.I.setVisibility(0);
        this.J.setVisibility(8);
        ((GradientDrawable) this.I.getBackground()).setColor(452984831);
        this.L.setBackgroundColor(-1724960977);
    }

    public void D() {
        QLog.i("QFSFeedCardAnimWrap", 1, NodeProps.ON_DETACHED_FROM_WINDOW);
        this.Q = false;
        this.J.setVisibility(8);
        RFWThreadManager.getUIHandler().removeCallbacks(this.X);
        RFWThreadManager.getUIHandler().removeCallbacks(this.Y);
        RFWThreadManager.getUIHandler().removeCallbacks(this.Z);
        ValueAnimator valueAnimator = this.P;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.T;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator valueAnimator3 = this.U;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        ValueAnimator valueAnimator4 = this.V;
        if (valueAnimator4 != null) {
            valueAnimator4.cancel();
        }
        ValueAnimator valueAnimator5 = this.W;
        if (valueAnimator5 != null) {
            valueAnimator5.cancel();
        }
        QFSLightView qFSLightView = this.M;
        if (qFSLightView != null) {
            qFSLightView.m();
        }
        this.S = null;
        F();
    }

    public void G(boolean z16, long j3) {
        QLog.d("QFSFeedCardAnimWrap", 1, "startBigCardAnim isOpen=" + z16 + ",delayMillis=" + j3);
        if (!this.Q) {
            return;
        }
        A();
        z();
        y();
        if (z16) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.Y);
            RFWThreadManager.getUIHandler().postDelayed(this.Y, j3);
        } else {
            RFWThreadManager.getUIHandler().removeCallbacks(this.Z);
            RFWThreadManager.getUIHandler().postDelayed(this.Z, j3 + 200);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f39381bi) {
            G(false, 0L);
            j jVar = this.S;
            if (jVar != null) {
                jVar.P(3);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p(long j3, long j16, boolean z16) {
        QLog.d("QFSFeedCardAnimWrap", 1, "doButtonAnim delayMillis=" + j3 + ",canShowBigCard=" + z16);
        j jVar = this.S;
        if (jVar != null) {
            jVar.P(1);
        }
        this.N = j16;
        this.R = z16;
        RFWThreadManager.getUIHandler().removeCallbacks(this.X);
        RFWThreadManager.getUIHandler().postDelayed(this.X, j3);
    }

    public Integer q(float f16) {
        float f17;
        float[] fArr = {204.0f, f16, 1.0f};
        if (f16 < 0.1f) {
            f17 = 25.5f;
        } else {
            f17 = f16 * 255.0f;
        }
        return Integer.valueOf(Color.HSVToColor((int) f17, fArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d extends ak {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QFSFeedCardAnimWrap.this.R) {
                QFSFeedCardAnimWrap.this.G(true, 5000L);
                if (QFSFeedCardAnimWrap.this.S != null) {
                    QFSFeedCardAnimWrap.this.S.P(2);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
