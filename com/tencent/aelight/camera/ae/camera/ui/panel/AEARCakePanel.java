package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes32.dex */
public class AEARCakePanel extends AEAbsBottomPanal {
    private static int I = 1;
    private com.tencent.aelight.camera.ae.camera.ui.c C;
    private com.tencent.aelight.camera.ae.part.c D;
    private g E;
    private Context F;
    boolean G;
    AEARCakeMaterialManager.c H;

    /* renamed from: e, reason: collision with root package name */
    AEARCakeProvidewView f62829e;

    /* renamed from: f, reason: collision with root package name */
    boolean f62830f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f62831h;

    /* renamed from: i, reason: collision with root package name */
    public int f62832i;

    /* renamed from: m, reason: collision with root package name */
    private List<com.tencent.aelight.camera.ae.data.a> f62833m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
        }
    }

    /* loaded from: classes32.dex */
    class d implements AEARCakeMaterialManager.c {
        d() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager.c
        public void a() {
            ms.a.f("AEARCakePanel", "arcake :panel onConfigUpdated---");
            AEARCakePanel.this.x();
        }
    }

    /* loaded from: classes32.dex */
    public interface g {
        void a(AEMaterialMetaData aEMaterialMetaData);
    }

    public AEARCakePanel(Context context) {
        super(context);
        this.f62830f = false;
        this.f62831h = false;
        this.f62832i = r();
        this.G = false;
        this.H = new d();
    }

    private int r() {
        return com.tencent.aelight.camera.ae.flashshow.util.v.a(getContext(), 169.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        if (this.f62833m == null) {
            ms.a.f("AEARCakePanel", "arcake : isMaterialAllDownload no data ");
            return false;
        }
        ms.a.f("AEARCakePanel", "arcake : mCurrentMaterials size " + this.f62833m.size());
        if (this.f62833m.size() <= I) {
            return false;
        }
        Iterator<com.tencent.aelight.camera.ae.data.a> it = this.f62833m.iterator();
        while (it.hasNext()) {
            AEARCakeMaterial b16 = it.next().b();
            ms.a.a("AEARCakePanel", "arcake : mCurrentMaterials name " + b16.name + " usable " + b16.usable);
            if (!b16.usable) {
                return true;
            }
        }
        return false;
    }

    private void w(Runnable runnable) {
        if (this.f62829e == null) {
            u();
        } else {
            x();
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", this.f62832i, 0.0f);
        ofFloat.addUpdateListener(new a());
        animatorSet.play(ofFloat);
        animatorSet.addListener(new b());
        animatorSet.setDuration(300L).start();
        Animation b16 = com.tencent.aelight.camera.aioeditor.capture.util.g.b(this.f62829e, 0.0f, 1.0f);
        b16.setStartOffset(200L);
        b16.setDuration(100L);
        b16.setAnimationListener(new c(runnable));
        startAnimation(b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (!this.G) {
            ms.a.c("AEARCakePanel", "arcake :not arcake mode can not refresh data");
            return;
        }
        final List<com.tencent.aelight.camera.ae.data.a> k3 = AEARCakeMaterialManager.i().k();
        ms.a.f("AEARCakePanel", "arcake : giftMaterials size : " + k3.size());
        this.f62833m = k3;
        if (CollectionUtils.isEmpty(k3)) {
            return;
        }
        for (com.tencent.aelight.camera.ae.data.a aVar : k3) {
            ms.a.a("AEARCakePanel", "arcake : gift : " + aVar.toString());
            AEARCakeMaterial b16 = aVar.b();
            if (b16 == null) {
                ms.a.a("AEARCakePanel", "arcake : aeArCakeMaterial is null ");
            } else {
                ms.a.a("AEARCakePanel", "arcake : gift : " + b16.toString());
            }
        }
        if (this.f62829e == null) {
            AEARCakeMaterialManager.i().e();
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel.6
            @Override // java.lang.Runnable
            public void run() {
                if (AEARCakePanel.this.D != null) {
                    AEARCakePanel.this.D.q(FileMsg.TRANSFILE_TYPE_PTT_SILK_SLICE_TO_TEXT, Boolean.valueOf(AEARCakePanel.this.s()));
                }
                if (AEARCakePanel.this.f62829e != null) {
                    ms.a.a("AEARCakePanel", "arcake : select positon :" + AEARCakeMaterialManager.i().o());
                    AEARCakePanel.this.f62829e.c(k3, AEARCakeMaterialManager.i().o());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        ms.a.a("AEARCakePanel", "showCaptureLayout");
        com.tencent.aelight.camera.ae.camera.ui.c cVar = this.C;
        if (cVar != null) {
            cVar.a(false, 150);
        }
        com.tencent.aelight.camera.ae.part.c cVar2 = this.D;
        if (cVar2 != null) {
            cVar2.q(FileMsg.TRANSFILE_TYPE_PTT_SILK_SLICE_TO_TEXT, Boolean.valueOf(s()));
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal
    public void f(boolean z16) {
        o(z16, new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel.1
            @Override // java.lang.Runnable
            public void run() {
                AEARCakePanel.this.y();
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal
    public boolean g() {
        return false;
    }

    public void o(boolean z16, Runnable runnable) {
        if (t()) {
            if (z16) {
                p(runnable);
            }
            if (QLog.isColorLevel()) {
                QLog.d("AEARCakePanel", 2, "panel closed");
            }
        }
    }

    public void q() {
        ms.a.a("AEARCakePanel", "doOpenProviderView");
        w(null);
    }

    public void setCaptureController(com.tencent.aelight.camera.ae.camera.ui.c cVar) {
        this.C = cVar;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal
    public void setClosedByTouch(boolean z16) {
        super.setClosedByTouch(z16);
    }

    public void setMaterialPanelListener(g gVar, boolean z16) {
        this.E = gVar;
        this.G = z16;
        AEARCakeMaterialManager.i().y(this.E);
        AEARCakeMaterialManager.i().s(this.H);
    }

    public void setMaterialSelectId() {
        ms.a.a("AEARCakePanel", "arcake : setMaterialSelectId");
        x();
    }

    public void setPartManager(com.tencent.aelight.camera.ae.part.c cVar) {
        this.D = cVar;
    }

    public boolean t() {
        AEARCakeProvidewView aEARCakeProvidewView;
        return (getVisibility() == 8 || (aEARCakeProvidewView = this.f62829e) == null || aEARCakeProvidewView.getVisibility() != 0) ? false : true;
    }

    public void u() {
        ms.a.a("AEARCakePanel", "arcake : loadView" + this.E);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = r();
        setLayoutParams(layoutParams);
        AEARCakeProvidewView aEARCakeProvidewView = new AEARCakeProvidewView(getContext(), this.E);
        this.f62829e = aEARCakeProvidewView;
        addView(aEARCakeProvidewView);
        x();
    }

    public void v() {
        if (QLog.isColorLevel()) {
            QLog.i("AEARCakePanel", 2, "ar cake panel onDestroy()");
        }
        AEARCakeProvidewView aEARCakeProvidewView = this.f62829e;
        if (aEARCakeProvidewView != null) {
            aEARCakeProvidewView.b();
            this.f62829e = null;
        }
        if (this.H != null) {
            AEARCakeMaterialManager.i().t(this.H);
        }
        this.E = null;
        AEARCakeMaterialManager.i().y(null);
    }

    private void p(Runnable runnable) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", 0.0f, this.f62832i);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.addListener(new e(runnable));
        animatorSet.setDuration(300L).start();
        Animation b16 = com.tencent.aelight.camera.aioeditor.capture.util.g.b(this.f62829e, 1.0f, 0.0f);
        b16.setStartOffset(0L);
        b16.setDuration(100L);
        b16.setAnimationListener(new f());
        startAnimation(b16);
    }

    public AEARCakePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f62830f = false;
        this.f62831h = false;
        this.f62832i = r();
        this.G = false;
        this.H = new d();
    }

    public AEARCakePanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f62830f = false;
        this.f62831h = false;
        this.f62832i = r();
        this.G = false;
        this.H = new d();
        this.F = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b extends com.tencent.mobileqq.widget.f {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
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
    public class c implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f62837d;

        c(Runnable runnable) {
            this.f62837d = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AEARCakePanel.this.f62830f = false;
            Runnable runnable = this.f62837d;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            AEARCakePanel aEARCakePanel = AEARCakePanel.this;
            aEARCakePanel.f62830f = true;
            AEARCakeProvidewView aEARCakeProvidewView = aEARCakePanel.f62829e;
            if (aEARCakeProvidewView != null) {
                aEARCakeProvidewView.setAlpha(1.0f);
                AEARCakePanel.this.f62829e.setVisibility(0);
            } else {
                ms.a.c("AEARCakePanel", "[openWithAnimation] alpha - onAnimationStart, mContentView == null");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e extends com.tencent.mobileqq.widget.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f62840d;

        e(Runnable runnable) {
            this.f62840d = runnable;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AEARCakePanel.this.f62831h = false;
            Runnable runnable = this.f62840d;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            AEARCakePanel.this.f62831h = true;
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
    public class f implements Animation.AnimationListener {
        f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AEARCakeProvidewView aEARCakeProvidewView = AEARCakePanel.this.f62829e;
            if (aEARCakeProvidewView != null) {
                aEARCakeProvidewView.setAlpha(1.0f);
                AEARCakePanel.this.f62829e.setVisibility(8);
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
