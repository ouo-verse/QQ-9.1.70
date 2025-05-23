package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

/* loaded from: classes32.dex */
public class AEMaterialPanel extends AEAbsBottomPanal {
    private com.tencent.aelight.camera.ae.part.c C;
    private e D;
    private Runnable E;

    /* renamed from: e, reason: collision with root package name */
    public int f62907e;

    /* renamed from: f, reason: collision with root package name */
    private AEMaterialProviderView f62908f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f62909h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f62910i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.c f62911m;

    /* loaded from: classes32.dex */
    public interface e {
        void a(AEMaterialMetaData aEMaterialMetaData);

        void b();

        void c();

        void d();
    }

    public AEMaterialPanel(Context context) {
        super(context);
        this.f62907e = t();
        this.f62909h = false;
        this.f62910i = false;
    }

    private void A(Runnable runnable) {
        if (this.f62908f == null) {
            w();
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this, "translationY", this.f62907e, 0.0f));
        animatorSet.addListener(new a());
        animatorSet.setDuration(300L).start();
        Animation b16 = com.tencent.aelight.camera.aioeditor.capture.util.g.b(this.f62908f, 0.0f, 1.0f);
        b16.setStartOffset(200L);
        b16.setDuration(100L);
        b16.setAnimationListener(new b(runnable));
        startAnimation(b16);
        if ((getContext() instanceof Activity) && gq.a.r(((Activity) getContext()).getIntent())) {
            com.tencent.aelight.camera.aebase.c.c(5, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        com.tencent.aelight.camera.ae.part.c cVar = this.C;
        if (cVar != null) {
            cVar.q(131075, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        com.tencent.aelight.camera.ae.camera.ui.c cVar = this.f62911m;
        if (cVar != null) {
            cVar.a(false, 150);
        }
    }

    private void p(Runnable runnable) {
        u();
        AEMaterialProviderView aEMaterialProviderView = this.f62908f;
        if (aEMaterialProviderView != null) {
            aEMaterialProviderView.setVisibility(8);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    private void r(Runnable runnable) {
        ms.a.a("AEMaterialPanel", "in close panel animation.");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", 0.0f, this.f62907e);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.addListener(new c(runnable));
        animatorSet.setDuration(300L).start();
        Animation b16 = com.tencent.aelight.camera.aioeditor.capture.util.g.b(this.f62908f, 1.0f, 0.0f);
        b16.setStartOffset(0L);
        b16.setDuration(100L);
        b16.setAnimationListener(new d());
        startAnimation(b16);
    }

    private int t() {
        return com.tencent.aelight.camera.ae.flashshow.util.v.a(getContext(), 242.0f);
    }

    private void u() {
        setTranslationY(t());
        setVisibility(8);
    }

    public void B(String str, String str2) {
        AEMaterialProviderView aEMaterialProviderView = this.f62908f;
        if (aEMaterialProviderView != null) {
            aEMaterialProviderView.l(str, str2);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal
    public void f(boolean z16) {
        if (getContext() instanceof Activity) {
            final Activity activity = (Activity) getContext();
            if (gq.a.r(activity.getIntent()) && v()) {
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                Runnable runnable = new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Intent intent = new Intent();
                        intent.setAction("ae_editor_bottom_tab_show_hide");
                        intent.putExtra("is_show", true);
                        activity.sendBroadcast(intent);
                    }
                };
                this.E = runnable;
                uIHandler.postDelayed(runnable, 300L);
            }
        }
        q(z16, new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.2
            @Override // java.lang.Runnable
            public void run() {
                AEMaterialPanel.this.D();
                AEMaterialPanel.this.C();
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal
    public boolean g() {
        return !v();
    }

    public void q(boolean z16, Runnable runnable) {
        if (v()) {
            if (z16) {
                r(runnable);
            } else {
                p(runnable);
            }
            com.tencent.aelight.camera.ae.part.c cVar = this.C;
            if (cVar != null) {
                cVar.q(196613, new Object[0]);
            }
            if (QLog.isColorLevel()) {
                QLog.d("AEMaterialPanel", 2, "panel closed");
            }
        }
    }

    public void setCaptureController(com.tencent.aelight.camera.ae.camera.ui.c cVar) {
        this.f62911m = cVar;
    }

    public void setMaterialPanelListener(e eVar) {
        this.D = eVar;
    }

    public void setPartManager(com.tencent.aelight.camera.ae.part.c cVar) {
        this.C = cVar;
    }

    public boolean v() {
        AEMaterialProviderView aEMaterialProviderView;
        return (getVisibility() == 8 || (aEMaterialProviderView = this.f62908f) == null || aEMaterialProviderView.getVisibility() != 0) ? false : true;
    }

    public void w() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = t();
        setLayoutParams(layoutParams);
        AEMaterialProviderView aEMaterialProviderView = new AEMaterialProviderView(getContext(), this.D);
        this.f62908f = aEMaterialProviderView;
        addView(aEMaterialProviderView);
    }

    public void y() {
        if (QLog.isColorLevel()) {
            QLog.i("AEMaterialPanel", 2, "onDestroy()");
        }
        AEMaterialProviderView aEMaterialProviderView = this.f62908f;
        if (aEMaterialProviderView != null) {
            aEMaterialProviderView.j();
            this.f62908f = null;
        }
        if (this.E != null) {
            ThreadManager.getUIHandler().removeCallbacks(this.E);
        }
    }

    public void z() {
        AEMaterialProviderView aEMaterialProviderView = this.f62908f;
        if (aEMaterialProviderView != null) {
            aEMaterialProviderView.k();
        }
    }

    public void s(String str, String str2, boolean z16) {
        A(null);
        if (!z16 || str == null || str2 == null) {
            return;
        }
        B(str, str2);
    }

    public AEMaterialPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f62907e = t();
        this.f62909h = false;
        this.f62910i = false;
    }

    public AEMaterialPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f62907e = t();
        this.f62909h = false;
        this.f62910i = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a extends com.tencent.mobileqq.widget.f {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ms.a.c("AEMaterialPanel", "[openWithAnimation] translationY - onAnimationCancel");
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
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
    public class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f62914d;

        b(Runnable runnable) {
            this.f62914d = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AEMaterialPanel.this.f62909h = false;
            if (AEMaterialPanel.this.D != null) {
                AEMaterialPanel.this.D.b();
            }
            Runnable runnable = this.f62914d;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            AEMaterialPanel.this.f62909h = true;
            if (AEMaterialPanel.this.f62908f != null) {
                AEMaterialPanel.this.f62908f.setAlpha(1.0f);
                AEMaterialPanel.this.f62908f.setVisibility(0);
            } else {
                ms.a.c("AEMaterialPanel", "[openWithAnimation] alpha - onAnimationStart, mContentView == null");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c extends com.tencent.mobileqq.widget.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f62916d;

        c(Runnable runnable) {
            this.f62916d = runnable;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AEMaterialPanel.this.f62910i = false;
            if (AEMaterialPanel.this.D != null) {
                AEMaterialPanel.this.D.d();
            }
            Runnable runnable = this.f62916d;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            AEMaterialPanel.this.f62910i = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (AEMaterialPanel.this.f62908f != null) {
                AEMaterialPanel.this.f62908f.setAlpha(1.0f);
                AEMaterialPanel.this.f62908f.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public void x(int i3, int i16, Intent intent) {
    }
}
