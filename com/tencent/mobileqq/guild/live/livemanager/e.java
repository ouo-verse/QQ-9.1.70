package com.tencent.mobileqq.guild.live.livemanager;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e {

    /* renamed from: i, reason: collision with root package name */
    private Handler f226813i;

    /* renamed from: k, reason: collision with root package name */
    private ValueAnimator f226815k;

    /* renamed from: l, reason: collision with root package name */
    private ValueAnimator f226816l;

    /* renamed from: m, reason: collision with root package name */
    private xr0.a f226817m;

    /* renamed from: a, reason: collision with root package name */
    private final Set<View> f226805a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private final Set<View> f226806b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private final Set<View> f226807c = new HashSet();

    /* renamed from: d, reason: collision with root package name */
    private final Set<View> f226808d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    private final Set<View> f226809e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private final Set<View> f226810f = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private final Set<View> f226811g = new HashSet();

    /* renamed from: h, reason: collision with root package name */
    private final Set<View> f226812h = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    private boolean f226814j = true;

    /* renamed from: n, reason: collision with root package name */
    private final Runnable f226818n = new Runnable() { // from class: com.tencent.mobileqq.guild.live.livemanager.d
        @Override // java.lang.Runnable
        public final void run() {
            e.this.F();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            e.this.f226814j = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.f226814j = true;
            e eVar = e.this;
            if (!eVar.y(eVar.B())) {
                e.this.N();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.X(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            e.this.X(8);
            e.this.f226814j = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.X(8);
            e.this.f226814j = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            e.this.G(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public e() {
        E();
        D();
    }

    private boolean A(int i3) {
        if (i3 != 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int B() {
        return GLiveChannelCore.f226698a.t().m();
    }

    private void C() {
        if (this.f226813i == null) {
            this.f226813i = new Handler(Looper.getMainLooper());
        }
    }

    private void D() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f226816l = ofFloat;
        u(ofFloat);
        this.f226816l.addListener(new b());
    }

    private void E() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f226815k = ofFloat;
        u(ofFloat);
        this.f226815k.addListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(float f16) {
        int B = B();
        V(this.f226805a, f16, y(B));
        V(this.f226807c, f16, A(B));
        V(this.f226806b, f16, x(B));
        V(this.f226808d, f16, w(B));
        V(this.f226809e, f16, z(B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        Handler handler = this.f226813i;
        if (handler != null) {
            handler.removeCallbacks(this.f226818n);
        }
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void F() {
        t();
        this.f226816l.start();
    }

    private void P() {
        t();
        this.f226815k.start();
    }

    private void R() {
        if (this.f226813i == null) {
            C();
        }
        this.f226813i.postDelayed(this.f226818n, 3000L);
    }

    private void S() {
        QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[switchShowOrHideAnim] ");
        if (this.f226814j) {
            F();
        } else {
            P();
        }
    }

    private void T(Set<View> set, boolean z16, boolean z17) {
        int i3;
        if (z17) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        for (View view : set) {
            if (view != null) {
                view.setAlpha(z16 ? 1.0f : 0.0f);
                view.setVisibility(i3);
            }
        }
    }

    private void U() {
        int B = B();
        T(this.f226810f, true, y(B));
        T(this.f226811g, false, w(B));
        T(this.f226812h, false, x(B));
    }

    private void V(Set<View> set, float f16, boolean z16) {
        if (z16) {
            return;
        }
        for (View view : set) {
            if (view != null) {
                view.setAlpha(f16);
            }
        }
    }

    private void W(Set<View> set, int i3, boolean z16) {
        if (z16) {
            return;
        }
        for (View view : set) {
            if (view != null) {
                view.setVisibility(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i3) {
        int B = B();
        W(this.f226805a, i3, y(B));
        W(this.f226807c, i3, A(B));
        W(this.f226806b, i3, x(B));
        W(this.f226808d, i3, w(B));
        W(this.f226809e, i3, z(B));
    }

    private void p() {
        QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[cancelShowHideAnim] ");
        this.f226815k.cancel();
        this.f226816l.cancel();
    }

    private void q() {
        t();
        U();
        X(0);
        G(1.0f);
        this.f226814j = true;
    }

    private void r() {
        Handler handler = this.f226813i;
        if (handler != null) {
            handler.removeCallbacks(this.f226818n);
        }
    }

    private void s() {
        r();
        this.f226813i = null;
    }

    private void t() {
        p();
        r();
    }

    private void u(ValueAnimator valueAnimator) {
        valueAnimator.setDuration(180L);
        valueAnimator.addUpdateListener(new c());
    }

    private boolean w(int i3) {
        if (i3 == 0) {
            return true;
        }
        return false;
    }

    private boolean x(int i3) {
        if (i3 != 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y(int i3) {
        if (i3 != 0) {
            return true;
        }
        return false;
    }

    private boolean z(int i3) {
        if (i3 == 2) {
            return true;
        }
        return false;
    }

    public void H() {
        if (com.tencent.mobileqq.guild.util.o.c("QGL.video_root_fast_click")) {
            QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[onClickVideoArea] fastclick");
            return;
        }
        if (!GLiveChannelCore.f226698a.t().n().getValue().booleanValue()) {
            QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[onClickVideoArea] not enter room");
            return;
        }
        xr0.a aVar = this.f226817m;
        if (aVar != null && aVar.needHidePanel()) {
            QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[onClickVideoArea] hide panel");
        } else {
            QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[onClickVideoArea] ");
            S();
        }
    }

    public void I() {
        q();
        R();
    }

    public void J(int i3) {
        QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[onVideoScreenStateChange] ");
        q();
        if (i3 == 0) {
            R();
        }
    }

    public void K(View view, String str) {
        QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[removeAlwaysHideOnLandState] tag = " + str);
        this.f226812h.remove(view);
    }

    public void L(View view, String str) {
        QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[removeLandScreenAnimChangeView] tag = " + str);
        this.f226806b.remove(view);
    }

    public void M(View view, String str) {
        QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[removePortraitScreenAnimChangeView] tag = " + str);
        this.f226807c.remove(view);
    }

    public void Q(xr0.a aVar) {
        this.f226817m = aVar;
    }

    public void h(View view, String str) {
        QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[addAlwaysHideOnFullScreenState] tag = " + str);
        this.f226811g.add(view);
    }

    public void i(View view, String str) {
        QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[addAlwaysHideOnLandState] tag = " + str);
        this.f226812h.add(view);
    }

    public void j(View view, String str) {
        QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[addAlwaysShowOnNormalState] tag = " + str);
        this.f226810f.add(view);
    }

    public void k(View view, String str) {
        QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[addFullScreenAnimChangeView] tag = " + str);
        this.f226808d.add(view);
    }

    public void l(View view, String str) {
        QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[addLandScreenAnimChangeView] tag = " + str);
        this.f226806b.add(view);
    }

    public void m(View view, String str) {
        QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[addNormalAnimChangeView] tag = " + str);
        this.f226805a.add(view);
    }

    public void n(View view, String str) {
        QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[addPortraitAndNormalAnimChangeView] tag = " + str);
        this.f226809e.add(view);
    }

    public void o(View view, String str) {
        QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[addPortraitScreenAnimChangeView] tag = " + str);
        this.f226807c.add(view);
    }

    public void v() {
        QLog.d("QGL.GuildLiveShowHideAnimHelper", 1, "[destroy] ");
        t();
        s();
        this.f226805a.clear();
        this.f226806b.clear();
        this.f226807c.clear();
        this.f226808d.clear();
        this.f226809e.clear();
        this.f226810f.clear();
        this.f226811g.clear();
        this.f226812h.clear();
        this.f226817m = null;
    }
}
