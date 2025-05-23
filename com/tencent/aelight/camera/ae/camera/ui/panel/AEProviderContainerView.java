package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes32.dex */
public class AEProviderContainerView extends AEAbsBottomPanal {
    private View C;
    private ArrayList<View> D;
    private AEBeautyProviderView E;
    private AEFilterProviderView F;
    private boolean G;
    private boolean H;
    private AECaptureController I;
    private com.tencent.aelight.camera.ae.part.c J;
    private int K;
    private AECaptureMode L;
    private int M;
    private int N;
    View.OnClickListener P;

    /* renamed from: e, reason: collision with root package name */
    public int f62929e;

    /* renamed from: f, reason: collision with root package name */
    private View f62930f;

    /* renamed from: h, reason: collision with root package name */
    private View f62931h;

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f62932i;

    /* renamed from: m, reason: collision with root package name */
    private View f62933m;

    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int id5 = view.getId();
            if (id5 == R.id.roq) {
                id0.a.o("clk_beauty", id0.a.e(-1), 0, false, new String[0]);
                if (AEProviderContainerView.this.K != 1) {
                    AEProviderContainerView.this.t();
                }
            } else if (id5 == R.id.rth) {
                id0.a.o("clk_filter", id0.a.e(-1), 0, false, new String[0]);
                if (AEProviderContainerView.this.K != 0) {
                    AEProviderContainerView.this.u();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public AEProviderContainerView(Context context) {
        super(context);
        this.f62929e = com.tencent.aelight.camera.ae.flashshow.util.v.a(getContext(), 195.0f);
        this.D = new ArrayList<>();
        this.G = false;
        this.H = false;
        this.K = 0;
        this.L = AECaptureMode.NORMAL;
        this.M = 0;
        this.N = 0;
        this.P = new a();
        p();
    }

    private void A() {
        if (gq.a.r(((Activity) getContext()).getIntent())) {
            int m3 = AEBeautyProviderView.m();
            if (m3 != this.M) {
                HashMap hashMap = new HashMap();
                hashMap.put("ext15", String.valueOf(m3));
                com.tencent.aelight.camera.aebase.c.d(12, 3, hashMap);
            }
            int n3 = AEBeautyProviderView.n();
            if (n3 != this.N) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("ext15", String.valueOf(n3));
                com.tencent.aelight.camera.aebase.c.d(12, 4, hashMap2);
            }
        }
    }

    private void p() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dml, (ViewGroup) null);
        addView(inflate);
        View findViewById = inflate.findViewById(R.id.roq);
        this.f62930f = findViewById;
        findViewById.setOnClickListener(this.P);
        View findViewById2 = inflate.findViewById(R.id.rth);
        this.f62931h = findViewById2;
        findViewById2.setOnClickListener(this.P);
        this.f62932i = (FrameLayout) inflate.findViewById(R.id.ryw);
        this.f62933m = inflate.findViewById(R.id.ryx);
        this.C = inflate.findViewById(R.id.rqu);
        this.D.add(this.f62933m);
        this.D.add(this.C);
        this.D.add(this.f62930f);
        this.D.add(this.f62931h);
    }

    private void z() {
        int i3 = this.K;
        if (i3 == 0) {
            u();
        } else {
            if (i3 != 1) {
                return;
            }
            t();
        }
    }

    public void D() {
        AEBeautyProviderView aEBeautyProviderView = this.E;
        if (aEBeautyProviderView != null) {
            aEBeautyProviderView.v();
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal
    public void f(boolean z16) {
        if (this.G) {
            C();
        }
        AEFilterProviderView aEFilterProviderView = this.F;
        if (aEFilterProviderView != null) {
            aEFilterProviderView.x();
            this.F.setVisibility(8);
        }
        AEBeautyProviderView aEBeautyProviderView = this.E;
        if (aEBeautyProviderView != null) {
            aEBeautyProviderView.setVisibility(8);
            this.E = null;
            A();
        }
        com.tencent.aelight.camera.ae.part.c cVar = this.J;
        if (cVar != null) {
            cVar.q(196613, new Object[0]);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AEProviderContainerView", 2, "panel closed");
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal
    public boolean g() {
        return !s();
    }

    public void o() {
        if (!this.H) {
            if (QLog.isColorLevel()) {
                QLog.e("AEProviderContainerView", 2, "doOpenProviderView failed isInflated" + this.H);
                return;
            }
            return;
        }
        z();
        B();
    }

    public boolean q() {
        return getContext() != null && gq.a.r(((Activity) getContext()).getIntent());
    }

    public boolean r() {
        return this.L == AECaptureMode.GIF;
    }

    public boolean s() {
        boolean z16;
        AEFilterProviderView aEFilterProviderView = this.F;
        if (aEFilterProviderView == null && this.E == null) {
            return false;
        }
        if (aEFilterProviderView != null) {
            z16 = (aEFilterProviderView.getVisibility() == 0) | false;
        } else {
            z16 = false;
        }
        AEBeautyProviderView aEBeautyProviderView = this.E;
        if (aEBeautyProviderView != null) {
            return z16 | (aEBeautyProviderView.getVisibility() == 0);
        }
        return z16;
    }

    public void setBackGroundAlpha(float f16) {
        ArrayList<View> arrayList = this.D;
        if (arrayList != null) {
            Iterator<View> it = arrayList.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next != null) {
                    next.setAlpha(f16);
                }
            }
        }
    }

    public void setCaptureMode(AECaptureMode aECaptureMode) {
        this.L = aECaptureMode;
    }

    public void setControllerAndManager(AECaptureController aECaptureController, com.tencent.aelight.camera.ae.part.c cVar) {
        this.I = aECaptureController;
        this.J = cVar;
        this.H = true;
    }

    public void v() {
        AEFilterProviderView aEFilterProviderView = this.F;
        if (aEFilterProviderView != null) {
            aEFilterProviderView.u();
        }
        com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().V(null, (Activity) getContext(), 0);
        com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().L(null, 0);
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).o((Activity) getContext());
    }

    public void w() {
        AEFilterProviderView aEFilterProviderView = this.F;
        if (aEFilterProviderView != null) {
            aEFilterProviderView.w();
            this.F = null;
        }
    }

    public void x() {
        AEFilterProviderView aEFilterProviderView = this.F;
        if (aEFilterProviderView != null) {
            aEFilterProviderView.z();
        }
        AEBeautyProviderView aEBeautyProviderView = this.E;
        if (aEBeautyProviderView != null) {
            aEBeautyProviderView.q();
        }
    }

    public void y() {
        AEFilterProviderView aEFilterProviderView = this.F;
        if (aEFilterProviderView != null) {
            aEFilterProviderView.A();
        }
    }

    private void C() {
        this.G = false;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", 0.0f, this.f62929e);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.addListener(new d());
        animatorSet.setDuration(300L).start();
        Animation b16 = com.tencent.aelight.camera.aioeditor.capture.util.g.b(this, 1.0f, 0.0f);
        b16.setStartOffset(0L);
        b16.setDuration(100L);
        b16.setAnimationListener(new e());
        startAnimation(b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.K = 1;
        this.f62931h.setSelected(false);
        this.f62930f.setSelected(true);
        AEFilterProviderView aEFilterProviderView = this.F;
        if (aEFilterProviderView != null) {
            aEFilterProviderView.x();
            this.F.setAlpha(1.0f);
            this.F.setVisibility(8);
        }
        if (this.E == null) {
            AEBeautyProviderView aEBeautyProviderView = new AEBeautyProviderView(getContext());
            this.E = aEBeautyProviderView;
            this.f62932i.addView(aEBeautyProviderView);
        }
        AEBeautyProviderView aEBeautyProviderView2 = this.E;
        if (aEBeautyProviderView2 != null) {
            if (!aEBeautyProviderView2.f62854i) {
                aEBeautyProviderView2.setController(this.I);
                this.E.o(null);
            }
            this.E.setAlpha(1.0f);
            this.E.setVisibility(0);
            this.E.p();
        }
        if (gq.a.r(((Activity) getContext()).getIntent())) {
            this.M = AEBeautyProviderView.m();
            this.N = AEBeautyProviderView.n();
            com.tencent.aelight.camera.aebase.c.c(12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.K = 0;
        this.f62931h.setSelected(true);
        this.f62930f.setSelected(false);
        AEBeautyProviderView aEBeautyProviderView = this.E;
        if (aEBeautyProviderView != null) {
            aEBeautyProviderView.setAlpha(1.0f);
            this.E.setVisibility(8);
            this.E = null;
            A();
        }
        if (this.F == null) {
            AEFilterProviderView aEFilterProviderView = new AEFilterProviderView(getContext());
            this.F = aEFilterProviderView;
            aEFilterProviderView.setNeedTabBar(false);
            this.F.m(com.tencent.aelight.camera.ae.flashshow.util.v.a(getContext(), 162.0f));
            AEFilterProviderView aEFilterProviderView2 = this.F;
            if (aEFilterProviderView2 != null) {
                this.f62932i.addView(aEFilterProviderView2);
            }
        }
        AEFilterProviderView aEFilterProviderView3 = this.F;
        if (aEFilterProviderView3 != null) {
            if (!aEFilterProviderView3.I) {
                aEFilterProviderView3.v(null);
            }
            this.F.setAlpha(1.0f);
            this.F.setVisibility(0);
            this.F.y();
        }
        if (gq.a.r(((Activity) getContext()).getIntent())) {
            com.tencent.aelight.camera.aebase.c.c(11, null);
        }
    }

    public void B() {
        this.G = true;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this, "translationY", this.f62929e, 0.0f));
        animatorSet.addListener(new b());
        animatorSet.setDuration(300L).start();
        Animation b16 = com.tencent.aelight.camera.aioeditor.capture.util.g.b(this, 0.0f, 1.0f);
        b16.setStartOffset(200L);
        b16.setDuration(100L);
        b16.setAnimationListener(new c());
        startAnimation(b16);
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal
    public void e() {
        f(true);
    }

    public AEProviderContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f62929e = com.tencent.aelight.camera.ae.flashshow.util.v.a(getContext(), 195.0f);
        this.D = new ArrayList<>();
        this.G = false;
        this.H = false;
        this.K = 0;
        this.L = AECaptureMode.NORMAL;
        this.M = 0;
        this.N = 0;
        this.P = new a();
        p();
    }

    public AEProviderContainerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f62929e = com.tencent.aelight.camera.ae.flashshow.util.v.a(getContext(), 195.0f);
        this.D = new ArrayList<>();
        this.G = false;
        this.H = false;
        this.K = 0;
        this.L = AECaptureMode.NORMAL;
        this.M = 0;
        this.N = 0;
        this.P = new a();
        p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b extends com.tencent.mobileqq.widget.f {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.d("AEProviderContainerView", 2, "panel opened");
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            AEProviderContainerView.this.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d extends com.tencent.mobileqq.widget.f {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.d("AEProviderContainerView", 2, "panel closed");
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AEProviderContainerView.this.setAlpha(1.0f);
            AEProviderContainerView.this.setVisibility(8);
            if (AEProviderContainerView.this.I != null) {
                AEProviderContainerView.this.I.a(false, 150);
            }
            if (AEProviderContainerView.this.J != null) {
                AEProviderContainerView.this.J.q(131075, new Object[0]);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
