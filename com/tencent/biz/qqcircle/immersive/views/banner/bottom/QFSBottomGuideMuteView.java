package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QFSBottomMuteViewEvent;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdTopViewPresenter;
import com.tencent.biz.qqcircle.immersive.utils.bk;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.bq;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleKeyVolumeChangeEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomGuideMuteView extends c implements View.OnClickListener, SimpleEventReceiver {
    private static final int N;
    private static final int P;
    private static final int Q;
    private static final int R;
    private static final boolean S;
    private static boolean T;
    private boolean D;
    private LinearLayout E;
    private View F;
    private ViewStub G;
    private FrameLayout H;
    private TextView I;
    private Runnable J;
    private Runnable K;
    private AnimatorSet L;
    private AnimatorSet M;

    static {
        int a16 = cx.a(34.0f);
        N = a16;
        int a17 = cx.a(12.0f);
        P = a17;
        Q = cx.a(3.0f);
        R = a16 + a17;
        S = com.tencent.biz.qqcircle.f.e();
    }

    public QFSBottomGuideMuteView(com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
        this.D = true;
    }

    private void C(Runnable runnable) {
        if (runnable != null) {
            QLog.d("QFSBottomGuideMuteView", 1, "[cancelRunnable] remove mAnimRunnable");
            n().removeCallbacks(runnable);
        }
    }

    private long D() {
        try {
            return Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_mute_guide_view_time_interval", String.valueOf(7L)));
        } catch (Exception e16) {
            QLog.d("QFSBottomGuideMuteView", 1, "[getDefaultMuteGuideInterval] error :" + e16);
            return 7L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatorSet E() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.H, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.H, "translationY", 0.0f, N);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.E, "translationY", 0.0f, R);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.F, "translationY", -r9, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new b());
        animatorSet.setDuration(280L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatorSet F() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.H, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setStartDelay(80L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.H, "translationY", N, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.E, "translationY", R, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.F, "translationY", 0.0f, -r9);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new a());
        animatorSet.setDuration(280L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        return animatorSet;
    }

    private void G() {
        TextView textView = this.I;
        if (textView == null) {
            return;
        }
        VideoReport.setElementId(textView, QCircleDaTongConstant.ElementId.EM_XSJ_MUTE_QUICKOPEN_BUTTON);
        VideoReport.setElementExposePolicy(this.I, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.I, ClickPolicy.REPORT_ALL);
        VideoReport.traverseExposure();
    }

    private boolean H() {
        if (!com.tencent.biz.qqcircle.f.f()) {
            QLog.d("QFSBottomGuideMuteView", 1, "[isCanShowGuideMute] not enableDefaultMuteFromWNS, return");
            return false;
        }
        if (!S && !com.tencent.biz.qqcircle.f.e()) {
            if (bq.d("sp_key_guild_mute_last_time", "sp_key_guild_mute_count", D(), uq3.c.g1())) {
                QLog.d("QFSBottomGuideMuteView", 1, "[isCanShowGuideMute] arrive frequency, return");
                return false;
            }
            if (this.f90603f != 0) {
                QLog.d("QFSBottomGuideMuteView", 2, "[isCanShowGuideMute] mPos != 0, return. mPos = " + this.f90603f);
                return false;
            }
            if (T) {
                QLog.d("QFSBottomGuideMuteView", 1, "[isCanShowGuideMute] mHasDoAnim = true, return");
                return false;
            }
            QLog.d("QFSBottomGuideMuteView", 1, "[isCanShowGuideMute] guild mute Enabled true");
            return true;
        }
        QLog.d("QFSBottomGuideMuteView", 1, "[isCanShowGuideMute] mute switch open, return");
        return false;
    }

    private void I(@NotNull View view) {
        this.E = (LinearLayout) view.findViewById(R.id.f34500zb);
        this.F = view.findViewById(R.id.f40491ei);
        if (this.G != null) {
            QLog.e("QFSBottomGuideMuteView", 1, "[makeSureInflate] mStub != null, return");
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f43411me);
        this.G = viewStub;
        if (viewStub == null) {
            QLog.e("QFSBottomGuideMuteView", 1, "[makeSureInflate] viewStub == null, return");
            return;
        }
        View inflate = viewStub.inflate();
        if (inflate == null) {
            QLog.d("QFSBottomGuideMuteView", 1, "[makeSureInflate] viewStub.inflate() == null, return");
            return;
        }
        this.H = (FrameLayout) inflate.findViewById(R.id.f1201978w);
        TextView textView = (TextView) inflate.findViewById(R.id.f111466la);
        this.I = textView;
        textView.setOnClickListener(this);
        this.J = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSBottomGuideMuteView.1
            @Override // java.lang.Runnable
            public void run() {
                bq.h("sp_key_guild_mute_last_time", "sp_key_guild_mute_count", uq3.c.g1());
                QFSBottomGuideMuteView.T = true;
                QFSBottomGuideMuteView qFSBottomGuideMuteView = QFSBottomGuideMuteView.this;
                qFSBottomGuideMuteView.L = qFSBottomGuideMuteView.F();
                QFSBottomGuideMuteView.this.L.start();
                QLog.d("QFSBottomGuideMuteView", 1, "[mStartAnimRunnable] start show anim");
            }
        };
        this.K = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSBottomGuideMuteView.2
            @Override // java.lang.Runnable
            public void run() {
                QFSBottomGuideMuteView qFSBottomGuideMuteView = QFSBottomGuideMuteView.this;
                qFSBottomGuideMuteView.M = qFSBottomGuideMuteView.E();
                QFSBottomGuideMuteView.this.M.start();
                QLog.d("QFSBottomGuideMuteView", 1, "[mDismissAnimRunnable] start dismiss anim");
            }
        };
    }

    private void J(QCircleKeyVolumeChangeEvent qCircleKeyVolumeChangeEvent) {
        AnimatorSet animatorSet;
        if (qCircleKeyVolumeChangeEvent.getKeyCode() != 25) {
            return;
        }
        AnimatorSet animatorSet2 = this.L;
        if ((animatorSet2 != null && animatorSet2.isRunning()) || ((animatorSet = this.M) != null && animatorSet.isRunning())) {
            QLog.d("QFSBottomGuideMuteView", 1, "[onKeyVolumeClick] anim is running");
        } else {
            this.D = false;
            com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
        }
    }

    private void K() {
        C(this.J);
        C(this.K);
        L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        bk.c(this.H, 8);
        FrameLayout frameLayout = this.H;
        if (frameLayout != null) {
            frameLayout.setAlpha(1.0f);
            this.H.setTranslationY(0.0f);
        }
        LinearLayout linearLayout = this.E;
        if (linearLayout != null) {
            linearLayout.setTranslationY(0.0f);
        }
        View view = this.F;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
    }

    private void M() {
        long j3;
        long j16;
        QLog.d("QFSBottomGuideMuteView", 1, "[startAnim] mIsDelay =" + this.D);
        C(this.J);
        Handler n3 = n();
        Runnable runnable = this.J;
        if (this.D) {
            j3 = 3000;
        } else {
            j3 = 0;
        }
        n3.postDelayed(runnable, j3);
        C(this.K);
        Handler n16 = n();
        Runnable runnable2 = this.K;
        if (this.D) {
            j16 = 8000;
        } else {
            j16 = 5000;
        }
        n16.postDelayed(runnable2, j16);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleKeyVolumeChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 104;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return H();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f111466la) {
            com.tencent.biz.qqcircle.f.a0(true);
            QCircleToast.o("\u5f00\u542f\u6210\u529f", 0);
            K();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        I(this.f90604h);
        bk.c(this.H, 8);
        M();
        G();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        bk.c(this.H, 8);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        K();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleKeyVolumeChangeEvent) {
            J((QCircleKeyVolumeChangeEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
        bk.c(this.H, 8);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
        K();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            bk.c(QFSBottomGuideMuteView.this.H, 0);
            z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(QFSBottomGuideMuteView.this.j());
            if (x16 != null) {
                x16.b(QFSBottomGuideMuteView.this.H);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSBottomGuideMuteView.this.L();
            z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(QFSBottomGuideMuteView.this.j());
            if (x16 != null) {
                x16.i(QFSBottomGuideMuteView.this.H);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (QFSBottomGuideMuteView.this.f90602e == null) {
                return;
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSBottomMuteViewEvent(false, QFSBottomGuideMuteView.this.f90602e.f398449id.get()));
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
