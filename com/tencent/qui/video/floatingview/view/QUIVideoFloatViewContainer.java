package com.tencent.qui.video.floatingview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class QUIVideoFloatViewContainer extends FrameLayout {
    static IPatchRedirector $redirector_;
    private float C;
    private float D;
    private float E;
    private float F;
    private boolean G;
    private final int H;
    private float I;
    private boolean J;
    private boolean K;
    private int L;
    private boolean M;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.qui.video.floatingview.operate.a f363927d;

    /* renamed from: e, reason: collision with root package name */
    private m f363928e;

    /* renamed from: f, reason: collision with root package name */
    private QUIVideoFloatDefaultView f363929f;

    /* renamed from: h, reason: collision with root package name */
    private WindowManager f363930h;

    /* renamed from: i, reason: collision with root package name */
    private WindowManager.LayoutParams f363931i;

    /* renamed from: m, reason: collision with root package name */
    private bz3.b f363932m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a implements b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUIVideoFloatViewContainer.this);
            }
        }

        @Override // com.tencent.qui.video.floatingview.view.b
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                QUIVideoFloatViewContainer.this.y(z16, false);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            }
        }

        @Override // com.tencent.qui.video.floatingview.view.b
        public /* synthetic */ void b(boolean z16) {
            com.tencent.qui.video.floatingview.view.a.a(this, z16);
        }

        @Override // com.tencent.qui.video.floatingview.view.b
        public /* synthetic */ void c(boolean z16) {
            com.tencent.qui.video.floatingview.view.a.b(this, z16);
        }

        @Override // com.tencent.qui.video.floatingview.view.b
        public void onCloseClick() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (QUIVideoFloatViewContainer.this.f363927d != null) {
                QUIVideoFloatViewContainer.this.f363927d.a();
            }
        }
    }

    public QUIVideoFloatViewContainer(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private int A() {
        QUIVideoFloatDefaultView qUIVideoFloatDefaultView = this.f363929f;
        if (qUIVideoFloatDefaultView != null && qUIVideoFloatDefaultView.c() != null) {
            return this.f363929f.c().getHeight();
        }
        return -1;
    }

    private int B(int i3, boolean z16) {
        int i16 = 0;
        if (u().d()) {
            int h16 = (com.tencent.biz.qui.quicommon.e.h() - i3) - this.f363928e.g();
            if (z16) {
                i16 = ((this.f363931i.height - m.f363981n) - (m.f363980m * 2)) / 2;
            }
            return h16 + i16;
        }
        int h17 = ((com.tencent.biz.qui.quicommon.e.h() - i3) - this.f363928e.g()) - com.tencent.biz.qui.quicommon.e.l(getContext());
        if (u().a()) {
            i16 = ((this.f363931i.height - m.f363981n) - (m.f363980m * 2)) / 2;
        }
        return h17 + i16;
    }

    private int C(boolean z16) {
        if (z16) {
            return this.f363928e.h() - (((this.f363931i.height - m.f363981n) - (m.f363980m * 4)) / 2);
        }
        return this.f363928e.h();
    }

    private int D(boolean z16) {
        int l3 = com.tencent.biz.qui.quicommon.e.l(ud0.b.a());
        if (com.tencent.biz.qui.quicommon.e.m()) {
            boolean z17 = this.M;
            if (!z17 && z16) {
                return (-(this.f363931i.width - m.f363982o)) - l3;
            }
            if (z17 && !z16) {
                return com.tencent.biz.qui.quicommon.e.j() - m.f363982o;
            }
            if (z16) {
                return -(this.f363931i.width - m.f363982o);
            }
            return (com.tencent.biz.qui.quicommon.e.j() - m.f363982o) - l3;
        }
        if (z16) {
            return -(this.f363931i.width - m.f363982o);
        }
        return com.tencent.biz.qui.quicommon.e.j() - m.f363982o;
    }

    private int E(int i3) {
        boolean m3 = com.tencent.biz.qui.quicommon.e.m();
        this.M = com.tencent.biz.qui.quicommon.e.n();
        ud0.d.a("QUIVideoFloatViewContainer", ud0.d.f438811e, "getTargetSuctionRightX mIsStatusBarOnLeft:" + this.M);
        int l3 = com.tencent.biz.qui.quicommon.e.l(ud0.b.a());
        if (m3) {
            if (this.M) {
                return (com.tencent.biz.qui.quicommon.e.j() - i3) - m.f363983p;
            }
            return ((com.tencent.biz.qui.quicommon.e.j() - i3) - m.f363983p) - l3;
        }
        return (com.tencent.biz.qui.quicommon.e.j() - i3) - m.f363983p;
    }

    private int F() {
        boolean m3 = com.tencent.biz.qui.quicommon.e.m();
        this.M = com.tencent.biz.qui.quicommon.e.n();
        ud0.d.a("QUIVideoFloatViewContainer", ud0.d.f438811e, "getTargetSuctionRightX mIsStatusBarOnLeft:" + this.M);
        if (m3) {
            if (this.M) {
                return m.f363983p;
            }
            return m.f363983p - com.tencent.biz.qui.quicommon.e.l(ud0.b.a());
        }
        return m.f363983p;
    }

    private int G() {
        int B = B(this.f363931i.height, false);
        int i3 = this.f363931i.y;
        if (i3 < C(false)) {
            return C(false);
        }
        if (i3 <= B) {
            return i3;
        }
        return B;
    }

    private int H() {
        if (I()) {
            return B(this.f363931i.height, true);
        }
        if (J()) {
            return C(true);
        }
        return this.f363931i.y;
    }

    private boolean I() {
        WindowManager.LayoutParams layoutParams = this.f363931i;
        if (layoutParams.y + layoutParams.height >= com.tencent.biz.qui.quicommon.e.h()) {
            return true;
        }
        return false;
    }

    private boolean J() {
        if (this.f363931i.y < 0) {
            return true;
        }
        return false;
    }

    private boolean K() {
        if (this.f363931i.x <= (com.tencent.biz.qui.quicommon.e.j() - this.f363931i.width) / 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(int i3, int i16, int i17, int i18, int i19, int i26, boolean z16, boolean z17, ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        int i27 = (int) (i3 + ((i16 - i3) * animatedFraction));
        int i28 = (int) (i17 - ((i17 - i18) * animatedFraction));
        WindowManager.LayoutParams layoutParams = this.f363931i;
        layoutParams.x = i27;
        layoutParams.y = (int) (i19 + ((i26 - i19) * animatedFraction));
        q0(-1, i28);
        p0(this);
        if (animatedFraction >= 1.0f) {
            if (z16) {
                this.f363929f.p(true);
            } else {
                this.f363929f.s(true);
            }
            this.f363928e.A(K(), n());
        }
        if (!u().a()) {
            u().g(true);
            U(z17);
            this.f363929f.q(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(int i3, int i16, ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        q0(-1, (int) (i3 + ((i16 - i3) * animatedFraction)));
        if (animatedFraction >= 1.0f) {
            this.K = false;
            q0(-1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(int i3, int i16, int i17, int i18, int i19, int i26, ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        int i27 = (int) (i3 + ((i16 - i3) * animatedFraction));
        int B = B(i17, false);
        if (i18 < i19) {
            i18 = i19;
        }
        if (i18 <= B) {
            B = i18;
        }
        WindowManager.LayoutParams layoutParams = this.f363931i;
        layoutParams.x = i27;
        layoutParams.y = B;
        q0(-1, (int) (i26 + ((i17 - i26) * animatedFraction)));
        p0(this);
        u().g(false);
        if (animatedFraction >= 1.0f) {
            q0(-1, -1);
            this.f363929f.q(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(int i3, int i16, int i17, ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        int i18 = (int) (i3 + ((i16 - i3) * animatedFraction));
        int d16 = this.f363928e.d(i18);
        WindowManager.LayoutParams layoutParams = this.f363931i;
        layoutParams.width = i18;
        layoutParams.height = d16;
        p0(this);
        if (animatedFraction >= 1.0f || i18 <= i17) {
            valueAnimator.cancel();
            Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(int i3, int i16, int i17, int i18, int i19, int i26, ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        float f16 = i3 + ((i16 - i3) * animatedFraction);
        ud0.d.a("QUIVideoFloatViewContainer", ud0.d.f438809c, "rotationToHorizontal x:" + f16);
        WindowManager.LayoutParams layoutParams = this.f363931i;
        layoutParams.x = (int) f16;
        layoutParams.width = (int) (((float) i17) + (((float) (i18 - i17)) * animatedFraction));
        layoutParams.height = (int) (i19 + ((i26 - i19) * animatedFraction));
        p0(this);
        if (animatedFraction >= 1.0f) {
            r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        float f16 = i3 + ((i16 - i3) * animatedFraction);
        WindowManager.LayoutParams layoutParams = this.f363931i;
        layoutParams.x = (int) f16;
        layoutParams.y = (int) (i17 + ((i18 - i17) * animatedFraction));
        layoutParams.width = (int) (i19 + ((i26 - i19) * animatedFraction));
        layoutParams.height = (int) (i27 + ((i28 - i27) * animatedFraction));
        p0(this);
        if (animatedFraction >= 1.0f) {
            r0();
        }
    }

    private void U(boolean z16) {
        bz3.b bVar = this.f363932m;
        if (bVar == null) {
            return;
        }
        bVar.b(z16);
    }

    private void V(boolean z16) {
        bz3.b bVar = this.f363932m;
        if (bVar == null) {
            return;
        }
        bVar.j(z16);
    }

    private void W() {
        int E;
        q0(-1, -1);
        int min = Math.min(Math.max(this.f363931i.height, this.f363928e.o(u().e())), this.f363928e.m(u().e()));
        int u16 = this.f363928e.u(min);
        int j3 = (int) ((this.f363928e.j() * com.tencent.biz.qui.quicommon.e.h()) - (min / 2));
        WindowManager.LayoutParams layoutParams = this.f363931i;
        if (this.f363928e.v()) {
            E = F();
        } else {
            E = E(u16);
        }
        layoutParams.x = E;
        int max = Math.max(Math.min(j3, B(this.f363931i.height, false)), C(false));
        WindowManager.LayoutParams layoutParams2 = this.f363931i;
        layoutParams2.y = max;
        layoutParams2.width = u16;
        layoutParams2.height = min;
        p0(this);
        r0();
    }

    private void X() {
        float j3 = this.f363928e.j() * com.tencent.biz.qui.quicommon.e.h();
        this.f363931i.x = D(this.f363928e.v());
        this.f363931i.y = Math.max(Math.min((int) (j3 - r1.height), B(this.f363931i.height, true)), C(true));
        p0(this);
    }

    private void Y(int i3, int i16) {
        boolean z16;
        if (this.f363929f == null) {
            return;
        }
        if (i3 == 0 && i16 == 0) {
            return;
        }
        this.L += i3;
        int A = A();
        ud0.d.g("QUIVideoFloatViewContainer", ud0.d.f438809c, i3 + "|" + i16 + "|" + this.f363931i.x + "|" + this.f363931i.y);
        int c16 = this.f363928e.c();
        if (u().a() && !this.K && A < c16 && Math.abs(this.L) > this.H * 1.5d) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            x();
            ud0.d.a("QUIVideoFloatViewContainer", ud0.d.f438809c, "drag update");
        }
        WindowManager.LayoutParams layoutParams = this.f363931i;
        layoutParams.y += i16;
        layoutParams.x -= i3;
        p0(this);
        float m3 = m();
        if (m3 >= 0.33f) {
            this.f363929f.o(true);
            this.f363929f.u(m3);
            this.f363929f.p(false);
            this.f363929f.s(false);
            return;
        }
        if (p()) {
            this.f363929f.o(true);
            this.f363929f.u(m3);
        } else if (o()) {
            this.f363929f.o(true);
            this.f363929f.u(m3);
        } else {
            this.f363929f.o(false);
            this.f363929f.p(false);
            this.f363929f.s(false);
        }
    }

    private void Z() {
        if (o()) {
            w(false, false);
        } else if (p()) {
            w(true, false);
        } else {
            v();
        }
    }

    private void a0(MotionEvent motionEvent) {
        float rawY = motionEvent.getRawY();
        float rawX = motionEvent.getRawX();
        Y((int) (rawX - this.F), (int) (rawY - this.E));
        this.E = rawY;
        this.F = rawX;
    }

    private void b0() {
        final int i3 = this.f363931i.width;
        if (i3 > this.f363928e.e()) {
            final int e16 = this.f363928e.e();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(50L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qui.video.floatingview.view.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    QUIVideoFloatViewContainer.this.O(i3, e16, e16, valueAnimator);
                }
            });
            ofFloat.start();
            return;
        }
        Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void S(ValueAnimator valueAnimator, int i3, int i16, int i17, int i18) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        int i19 = (int) (i3 + ((i16 - i3) * animatedFraction));
        int i26 = (int) (i17 + ((i18 - i17) * animatedFraction));
        WindowManager.LayoutParams layoutParams = this.f363931i;
        layoutParams.x = i19;
        layoutParams.y = i26;
        p0(this);
        if (animatedFraction >= 1.0f) {
            if (u().a()) {
                u().g(false);
                V(false);
            }
            this.f363929f.o(false);
            this.f363929f.p(false);
            this.f363929f.s(false);
            r0();
        }
    }

    private void d0(MotionEvent motionEvent) {
        float m06 = m0(motionEvent);
        float f16 = this.I;
        if (f16 != -1.0f && m06 != -1.0f) {
            if (Math.abs(m06 - f16) > 1.0f) {
                s0(m06 / this.I);
                ud0.d.a("QUIVideoFloatViewContainer", ud0.d.f438809c, this.I + "|" + m06);
                this.I = m06;
                return;
            }
            return;
        }
        this.I = m06;
    }

    private void g0() {
        int i3;
        int min;
        int i16;
        final int i17;
        q0(-1, -1);
        if (u().d()) {
            i3 = this.f363931i.width;
        } else {
            i3 = this.f363931i.height;
        }
        if (u().d()) {
            i16 = Math.min(Math.max((int) (i3 / this.f363928e.k()), this.f363928e.p(false)), this.f363928e.n(false));
            min = (int) (i16 / m.f363977j);
        } else {
            min = Math.min(Math.max((int) (i3 / this.f363928e.k()), this.f363928e.o(false)), this.f363928e.m(false));
            i16 = (int) (min * m.f363977j);
        }
        final int i18 = i16;
        final int i19 = min;
        final int i26 = this.f363931i.x;
        if (!K()) {
            i17 = (com.tencent.biz.qui.quicommon.e.j() - i18) - m.f363983p;
        } else {
            i17 = i26;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        WindowManager.LayoutParams layoutParams = this.f363931i;
        final int i27 = layoutParams.width;
        final int i28 = layoutParams.height;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qui.video.floatingview.view.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QUIVideoFloatViewContainer.this.P(i26, i17, i27, i18, i28, i19, valueAnimator);
            }
        });
        u().l(false);
        ofFloat.start();
    }

    private void h0() {
        int i3;
        final int i16;
        final int i17;
        final int i18;
        final int i19;
        q0(-1, -1);
        WindowManager.LayoutParams layoutParams = this.f363931i;
        final int i26 = layoutParams.x;
        final int i27 = layoutParams.y;
        if (u().d()) {
            i3 = this.f363931i.width;
        } else {
            i3 = this.f363931i.height;
        }
        if (u().d()) {
            int max = Math.max(Math.min((int) (i3 * this.f363928e.k()), this.f363928e.n(true)), this.f363928e.p(true));
            i17 = max;
            i16 = (int) (max / m.f363978k);
        } else {
            int max2 = Math.max(Math.min((int) (i3 * this.f363928e.k()), this.f363928e.m(true)), this.f363928e.o(true));
            i16 = max2;
            i17 = (int) (max2 * m.f363978k);
        }
        if (!K()) {
            i18 = (com.tencent.biz.qui.quicommon.e.j() - i17) - m.f363983p;
        } else {
            i18 = i26;
        }
        int B = B(i16, false);
        if (i27 > B) {
            i19 = B;
        } else {
            i19 = i27;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        WindowManager.LayoutParams layoutParams2 = this.f363931i;
        final int i28 = layoutParams2.width;
        final int i29 = layoutParams2.height;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qui.video.floatingview.view.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QUIVideoFloatViewContainer.this.Q(i26, i18, i27, i19, i28, i17, i29, i16, valueAnimator);
            }
        });
        u().l(true);
        ofFloat.start();
    }

    private void k(View view) {
        QUIVideoFloatDefaultView qUIVideoFloatDefaultView = this.f363929f;
        if (qUIVideoFloatDefaultView == null) {
            return;
        }
        qUIVideoFloatDefaultView.b(view, this.f363927d.c());
        this.f363929f.r(!this.f363927d.f().f());
    }

    private void k0() {
        WindowManager.LayoutParams layoutParams = this.f363931i;
        final int i3 = layoutParams.x;
        final int E = E(layoutParams.width);
        final int i16 = this.f363931i.y;
        final int G = G();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qui.video.floatingview.view.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QUIVideoFloatViewContainer.this.R(i3, E, i16, G, valueAnimator);
            }
        });
        ofFloat.start();
    }

    private void l() {
        QUIVideoFloatDefaultView qUIVideoFloatDefaultView = new QUIVideoFloatDefaultView(ud0.b.a());
        this.f363929f = qUIVideoFloatDefaultView;
        qUIVideoFloatDefaultView.setDelegate(this.f363932m);
        this.f363929f.setClickListener(new a());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.f363929f, layoutParams);
    }

    private void l0() {
        final int i3 = this.f363931i.x;
        final int F = F();
        final int i16 = this.f363931i.y;
        final int G = G();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qui.video.floatingview.view.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QUIVideoFloatViewContainer.this.S(i3, F, i16, G, valueAnimator);
            }
        });
        ofFloat.start();
    }

    private float m() {
        int j3 = com.tencent.biz.qui.quicommon.e.j();
        WindowManager.LayoutParams layoutParams = this.f363931i;
        int i3 = layoutParams.x;
        int i16 = layoutParams.width;
        if (K()) {
            if (i3 > 0) {
                return 0.0f;
            }
            return (Math.abs(i3) - m.f363983p) / (i16 - (m.f363980m * 2));
        }
        if (i3 >= j3 - (m.f363980m * 2)) {
            return 1.0f;
        }
        return (((i3 + i16) - j3) - m.f363983p) / (i16 - (m.f363980m * 2));
    }

    private float m0(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getPointerCount() == 2) {
            float x16 = motionEvent.getX(0) - motionEvent.getX(1);
            float y16 = motionEvent.getY(0) - motionEvent.getY(1);
            return (float) Math.sqrt((x16 * x16) + (y16 * y16));
        }
        return 0.0f;
    }

    private float n() {
        WindowManager.LayoutParams layoutParams = this.f363931i;
        return (layoutParams.y + (layoutParams.height / 2)) / com.tencent.biz.qui.quicommon.e.h();
    }

    private boolean o() {
        WindowManager.LayoutParams layoutParams = this.f363931i;
        if (layoutParams.x >= com.tencent.biz.qui.quicommon.e.j() - (layoutParams.width / 2)) {
            return true;
        }
        return false;
    }

    private boolean p() {
        WindowManager.LayoutParams layoutParams = this.f363931i;
        if (layoutParams.x <= (-layoutParams.width) / 2) {
            return true;
        }
        return false;
    }

    private void p0(QUIVideoFloatViewContainer qUIVideoFloatViewContainer) {
        try {
            this.f363930h.updateViewLayout(qUIVideoFloatViewContainer, this.f363931i);
        } catch (Exception e16) {
            ud0.d.b("QUIVideoFloatViewContainer", ud0.d.f438811e, e16);
        }
    }

    private void q() {
        ud0.d.a("QUIVideoFloatViewContainer", ud0.d.f438809c, "changToHorizonScreen:");
        u().k(false);
        this.f363928e.x(u().e(), u().d());
        if (u().a()) {
            X();
        } else {
            W();
        }
    }

    private void r() {
        ud0.d.a("QUIVideoFloatViewContainer", ud0.d.f438809c, "changToVerticalScreen:");
        u().k(true);
        this.f363928e.x(u().e(), u().d());
        if (u().a()) {
            X();
        } else {
            W();
        }
    }

    private void r0() {
        this.f363928e.y(this.f363931i.width).z(this.f363931i.height).x(u().e(), u().d()).A(K(), n()).B(this.f363931i.x).C(this.f363931i.y).w();
    }

    private void s0(float f16) {
        this.J = true;
        int i3 = this.f363931i.width;
        float f17 = i3;
        float f18 = f16 * i3;
        if (f18 > this.f363928e.e() && f18 > f17) {
            f18 = 5.0f + f17;
        }
        float max = Math.max(f18, this.f363928e.i());
        WindowManager.LayoutParams layoutParams = this.f363931i;
        int i16 = (int) max;
        layoutParams.width = i16;
        layoutParams.height = this.f363928e.d(i16);
        ud0.d.a("QUIVideoFloatViewContainer", ud0.d.f438809c, "zoomWindowManger:width:height" + this.f363931i.width + "|" + this.f363931i.height + "|" + this.f363931i.x + "|" + this.f363931i.y);
        p0(this);
    }

    private void v() {
        if (K()) {
            l0();
        } else {
            k0();
        }
    }

    private void w(final boolean z16, final boolean z17) {
        final int i3 = this.f363931i.x;
        final int D = D(z16);
        final int A = A();
        final int i16 = m.f363981n + (m.f363980m * 2);
        final int i17 = this.f363931i.y;
        final int H = H();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qui.video.floatingview.view.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QUIVideoFloatViewContainer.this.L(i3, D, A, i16, i17, H, z16, z17, valueAnimator);
            }
        });
        ofFloat.start();
    }

    private void x() {
        final int A = A();
        this.K = true;
        final int c16 = this.f363928e.c() - (m.f363980m * 2);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qui.video.floatingview.view.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QUIVideoFloatViewContainer.this.M(A, c16, valueAnimator);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z16, boolean z17) {
        int E;
        QUIVideoFloatDefaultView qUIVideoFloatDefaultView = this.f363929f;
        if (qUIVideoFloatDefaultView == null) {
            return;
        }
        qUIVideoFloatDefaultView.p(false);
        this.f363929f.s(false);
        this.f363929f.o(false);
        final int c16 = this.f363928e.c() - (m.f363980m * 2);
        final int A = A();
        WindowManager.LayoutParams layoutParams = this.f363931i;
        final int i3 = layoutParams.y;
        final int i16 = layoutParams.x;
        if (z16) {
            E = F();
        } else {
            E = E(layoutParams.width);
        }
        final int i17 = E;
        final int C = C(false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qui.video.floatingview.view.l
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QUIVideoFloatViewContainer.this.N(i16, i17, c16, i3, C, A, valueAnimator);
            }
        });
        ofFloat.start();
        V(z17);
    }

    public void T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        QUIVideoFloatDefaultView qUIVideoFloatDefaultView = this.f363929f;
        if (qUIVideoFloatDefaultView == null) {
            return;
        }
        qUIVideoFloatDefaultView.w(true);
    }

    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        QUIVideoFloatDefaultView qUIVideoFloatDefaultView = this.f363929f;
        if (qUIVideoFloatDefaultView == null) {
            return;
        }
        qUIVideoFloatDefaultView.v(false);
    }

    public void f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QUIVideoFloatDefaultView qUIVideoFloatDefaultView = this.f363929f;
        if (qUIVideoFloatDefaultView == null) {
            return;
        }
        qUIVideoFloatDefaultView.v(true);
    }

    public void i0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else if (z16) {
            h0();
        } else {
            g0();
        }
    }

    public void j0(View view, m mVar, bz3.b bVar, com.tencent.qui.video.floatingview.operate.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, mVar, bVar, aVar);
            return;
        }
        this.f363928e = mVar;
        this.f363932m = bVar;
        this.f363927d = aVar;
        this.f363930h = (WindowManager) ud0.b.a().getSystemService("window");
        t(mVar);
        l();
        k(view);
        this.f363930h.addView(this, this.f363931i);
    }

    public void n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            y(K(), true);
        }
    }

    public void o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        QUIVideoFloatDefaultView qUIVideoFloatDefaultView = this.f363929f;
        if (qUIVideoFloatDefaultView == null) {
            return;
        }
        qUIVideoFloatDefaultView.w(false);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.M = com.tencent.biz.qui.quicommon.e.n();
            ud0.d.a("QUIVideoFloatViewContainer", ud0.d.f438809c, "changToHorizonScreen isStatusBarOnLeft:" + this.M);
            q();
            return;
        }
        this.M = false;
        r();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        if (r0 != 3) goto L29;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean z16 = false;
        if (motionEvent.getPointerCount() > 2) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float y16 = motionEvent.getY();
                    float x16 = motionEvent.getX();
                    if (Math.abs(this.C - y16) > this.H || Math.abs(this.D - x16) > this.H) {
                        z16 = true;
                    }
                    this.G = z16;
                    if (z16) {
                        this.C = motionEvent.getRawY();
                        this.D = motionEvent.getRawX();
                        this.E = motionEvent.getRawY();
                        this.F = motionEvent.getRawX();
                    }
                }
            }
            this.G = false;
        } else {
            this.C = motionEvent.getY();
            this.D = motionEvent.getX();
            this.G = false;
        }
        return this.G;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        if (r0 != 5) goto L34;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        int pointerCount = motionEvent.getPointerCount();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                    }
                } else if (pointerCount == 2) {
                    d0(motionEvent);
                } else if (pointerCount == 1 && this.G && !this.J) {
                    a0(motionEvent);
                }
                return true;
            }
            if (this.G) {
                if (this.J) {
                    b0();
                } else {
                    Z();
                }
            }
            this.J = false;
            this.I = -1.0f;
            this.L = 0;
            return true;
        }
        if (pointerCount == 2) {
            this.I = m0(motionEvent);
        }
        return true;
    }

    public void q0(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QUIVideoFloatDefaultView qUIVideoFloatDefaultView = this.f363929f;
        if (qUIVideoFloatDefaultView != null && qUIVideoFloatDefaultView.c() != null) {
            FrameLayout c16 = this.f363929f.c();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c16.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i16;
            c16.setLayoutParams(layoutParams);
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        WindowManager windowManager = this.f363930h;
        if (windowManager == null) {
            return;
        }
        windowManager.removeView(this);
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        QUIVideoFloatDefaultView qUIVideoFloatDefaultView = this.f363929f;
        if (qUIVideoFloatDefaultView == null) {
            return;
        }
        qUIVideoFloatDefaultView.setProgress(i3);
    }

    WindowManager.LayoutParams t(m mVar) {
        int i3;
        if (this.f363931i == null) {
            this.f363931i = new WindowManager.LayoutParams();
        }
        int i16 = Build.VERSION.SDK_INT;
        if (i16 >= 26) {
            i3 = 2038;
        } else {
            i3 = 2003;
        }
        WindowManager.LayoutParams layoutParams = this.f363931i;
        layoutParams.type = i3;
        layoutParams.format = 1;
        layoutParams.flags = 16777768;
        layoutParams.gravity = 53;
        layoutParams.rotationAnimation = 0;
        layoutParams.x = mVar.l();
        this.f363931i.y = mVar.s();
        this.f363931i.width = mVar.t();
        this.f363931i.height = mVar.c();
        if (i16 >= 28) {
            this.f363931i.layoutInDisplayCutoutMode = 2;
        }
        mVar.A(K(), n());
        return this.f363931i;
    }

    public com.tencent.qui.video.floatingview.e u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.qui.video.floatingview.e) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f363927d.c();
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            if (this.f363929f == null) {
                return;
            }
            w(K(), true);
            this.f363929f.o(true);
            this.f363929f.u(1.0f);
        }
    }

    public QUIVideoFloatViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QUIVideoFloatViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }

    public QUIVideoFloatViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.I = -1.0f;
            this.H = ViewConfiguration.get(context).getScaledTouchSlop();
        }
    }
}
