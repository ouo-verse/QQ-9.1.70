package com.tencent.mobileqq.vasgift.mvvm.business.banner;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Looper;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPAGAnimationViewImpl;
import com.tencent.mobileqq.vasgift.utils.ThreadManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class GiftBannerContainer extends FrameLayout implements com.tencent.mobileqq.vasgift.mvvm.business.banner.b {
    private com.tencent.mobileqq.vasgift.mvvm.business.banner.d C;
    private final Object D;

    /* renamed from: d, reason: collision with root package name */
    private final BaseBannerView f311745d;

    /* renamed from: e, reason: collision with root package name */
    private BaseBannerView f311746e;

    /* renamed from: f, reason: collision with root package name */
    private BaseBannerView f311747f;

    /* renamed from: h, reason: collision with root package name */
    private int f311748h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.qqgift.mvvm.business.anim.a f311749i;

    /* renamed from: m, reason: collision with root package name */
    private final BannerResManager f311750m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            GiftBannerContainer.this.f311747f.setTranslationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.mvvm.business.anim.a f311755d;

        b(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
            this.f311755d = aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            synchronized (GiftBannerContainer.this.D) {
                QLog.i("Gift_Banner_Container", 1, "banner showed");
                GiftBannerContainer.this.f311748h = 2;
                GiftBannerContainer.this.f311747f.setAnimationListener(GiftBannerContainer.this);
                GiftBannerContainer.this.f311747f.n(this.f311755d.f264926q);
                VasPerfReportUtils.report(VasPerfReportUtils.BANNER_PLAY_END, "", "", "", 0L);
                VasLogReporter.getVasGift().report("bannerAnimation playAnimation:" + this.f311755d, VasLogReportProxy.LEVEL.HIGHEST);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z16) {
            onAnimationStart(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            GiftBannerContainer.this.f311747f.setTranslationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            synchronized (GiftBannerContainer.this.D) {
                QLog.i("Gift_Banner_Container", 1, "banner dismissed");
                GiftBannerContainer.this.f311748h = 0;
                GiftBannerContainer.this.f311747f.o();
                GiftBannerContainer.this.f311747f.setVisibility(4);
                if (GiftBannerContainer.this.C != null) {
                    GiftBannerContainer.this.C.j();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z16) {
            onAnimationStart(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    public GiftBannerContainer(@NonNull Context context, BannerResManager bannerResManager) {
        super(context);
        this.f311748h = 0;
        this.D = new Object();
        this.f311750m = bannerResManager;
        com.tencent.mobileqq.vasgift.mvvm.business.banner.c cVar = new com.tencent.mobileqq.vasgift.mvvm.business.banner.c(context, bannerResManager);
        this.f311745d = cVar;
        addView(cVar);
        cVar.setVisibility(8);
    }

    private void m(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        this.f311750m.l(aVar.f264914e, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bc A[Catch: all -> 0x00c1, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x003f, B:9:0x0080, B:12:0x0089, B:14:0x008d, B:15:0x009d, B:16:0x00ab, B:18:0x00bc, B:19:0x00bf, B:23:0x00a2, B:25:0x00a8), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, int i3) {
        String str;
        com.tencent.mobileqq.vasgift.mvvm.business.banner.d dVar;
        synchronized (this.D) {
            boolean E = this.f311750m.E(aVar.f264914e);
            QLog.i("Gift_Banner_Container", 1, "play isResExit " + E + " pagIsLoad:" + QQGiftPAGAnimationViewImpl.f311895g.a());
            if (E) {
                str = "cache";
            } else {
                str = "noCache";
            }
            VasPerfReportUtils.report(VasPerfReportUtils.BANNER_PLAY_START, str, "", String.valueOf(QQGiftPAGAnimationViewImpl.f311895g.a()), 0L);
            VasLogReporter.getVasGift().report("bannerAnimation isResExit " + E + " pagIsLoad:" + QQGiftPAGAnimationViewImpl.f311895g.a(), VasLogReportProxy.LEVEL.HIGHEST);
            this.f311749i = aVar;
            if (E && QQGiftPAGAnimationViewImpl.f311895g.a()) {
                if (this.f311746e == null) {
                    com.tencent.mobileqq.vasgift.mvvm.business.banner.a aVar2 = new com.tencent.mobileqq.vasgift.mvvm.business.banner.a(getContext(), this.f311750m);
                    this.f311746e = aVar2;
                    addView(aVar2);
                }
                this.f311747f = this.f311746e;
                r(aVar, this.f311750m.n(aVar.f264914e), i3);
                this.f311748h = 1;
                dVar = this.C;
                if (dVar != null) {
                    dVar.h(aVar);
                }
            }
            this.f311747f = this.f311745d;
            if (!E) {
                m(aVar);
            }
            r(aVar, this.f311750m.n(aVar.f264914e), i3);
            this.f311748h = 1;
            dVar = this.C;
            if (dVar != null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        synchronized (this.D) {
            this.f311748h = 3;
            ValueAnimator ofInt = ValueAnimator.ofInt(0, -this.f311747f.getWidth());
            ofInt.setDuration(200L);
            ofInt.setInterpolator(new AccelerateInterpolator());
            ofInt.addUpdateListener(new c());
            ofInt.addListener(new d());
            ofInt.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        int i3;
        synchronized (this.D) {
            QLog.i("Gift_Banner_Container", 1, "stop playStatus is " + this.f311748h);
            BaseBannerView baseBannerView = this.f311747f;
            if (baseBannerView != null && (i3 = this.f311748h) != 0 && i3 != 3) {
                com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = this.f311749i;
                this.f311749i = null;
                baseBannerView.o();
                this.f311747f.clearAnimation();
                this.f311748h = 2;
                com.tencent.mobileqq.vasgift.mvvm.business.banner.d dVar = this.C;
                if (dVar != null) {
                    dVar.g(aVar, this.f311747f.f311739d.k());
                }
            }
        }
    }

    private void r(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, String str, int i3) {
        com.tencent.mobileqq.vasgift.mvvm.business.banner.d dVar = this.C;
        if (dVar != null) {
            dVar.a();
        }
        this.f311747f.setVisibility(0);
        this.f311747f.i(aVar, str);
        this.f311747f.setNum(i3);
        ValueAnimator ofInt = ValueAnimator.ofInt(getWidth(), 0);
        ofInt.setDuration(200L);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(new a());
        ofInt.addListener(new b(aVar));
        ofInt.start();
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.b
    public void g(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, int i3) {
        if (aVar != this.f311749i) {
            QLog.e("Gift_Banner_Container", 1, "banner animation end but not match");
            return;
        }
        QLog.i("Gift_Banner_Container", 1, "banner animation end");
        com.tencent.mobileqq.vasgift.mvvm.business.banner.d dVar = this.C;
        if (dVar != null) {
            dVar.g(aVar, i3);
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.b
    public void h(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar != this.f311749i) {
            QLog.e("Gift_Banner_Container", 1, "banner animation start but not match");
            return;
        }
        QLog.i("Gift_Banner_Container", 1, "banner animation start");
        com.tencent.mobileqq.vasgift.mvvm.business.banner.d dVar = this.C;
        if (dVar != null) {
            dVar.h(aVar);
        }
    }

    public void l() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            p();
        } else {
            ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.GiftBannerContainer.6
                @Override // java.lang.Runnable
                public void run() {
                    GiftBannerContainer.this.p();
                }
            });
        }
    }

    public void o(final com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, final int i3) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            n(aVar, i3);
        } else {
            ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.GiftBannerContainer.3
                @Override // java.lang.Runnable
                public void run() {
                    GiftBannerContainer.this.n(aVar, i3);
                }
            });
        }
    }

    public void s() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            q();
        } else {
            ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.GiftBannerContainer.1
                @Override // java.lang.Runnable
                public void run() {
                    GiftBannerContainer.this.q();
                }
            });
        }
    }

    public void setBannerListener(com.tencent.mobileqq.vasgift.mvvm.business.banner.d dVar) {
        this.C = dVar;
    }

    public boolean t(final int i3) {
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar;
        synchronized (this.D) {
            QLog.i("Gift_Banner_Container", 1, "updateCurrentTargetNum " + i3 + " playStatus is " + this.f311748h);
            int i16 = this.f311748h;
            if (i16 != 3 && (aVar = this.f311749i) != null) {
                aVar.f264926q = i3;
                if (i16 == 2) {
                    post(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.GiftBannerContainer.2
                        @Override // java.lang.Runnable
                        public void run() {
                            GiftBannerContainer.this.f311747f.n(i3);
                        }
                    });
                }
                return true;
            }
            return false;
        }
    }
}
