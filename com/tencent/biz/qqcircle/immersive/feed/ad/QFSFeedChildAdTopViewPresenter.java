package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.animwrap.n;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSTabTitleVisibilityEvent;
import com.tencent.biz.qqcircle.immersive.manager.QFSTopViewManager;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.shake.GdtShakeIconView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Map;
import tencent.gdt.qq_ad_get;

/* loaded from: classes4.dex */
public class QFSFeedChildAdTopViewPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: g0, reason: collision with root package name */
    private static final ArrayList<Integer> f85384g0;

    /* renamed from: h0, reason: collision with root package name */
    private static final ArrayList<Integer> f85385h0;

    /* renamed from: i0, reason: collision with root package name */
    private static int f85386i0;
    private FeedCloudMeta$StFeed I;
    private View J;
    private View K;
    private TextView L;
    private View M;
    private TextView N;
    private View P;
    private GdtShakeIconView Q;
    private View R;
    private View S;
    private com.tencent.biz.qqcircle.immersive.feed.animwrap.n T;
    private com.tencent.biz.qqcircle.immersive.feed.animwrap.n U;
    private ValueAnimator V;
    private int W;
    private int X;

    /* renamed from: b0, reason: collision with root package name */
    private GdtAd f85388b0;

    /* renamed from: e0, reason: collision with root package name */
    private float f85391e0;
    private int Y = 1000;
    private int Z = 2000;

    /* renamed from: a0, reason: collision with root package name */
    private int f85387a0 = 1000 + 2000;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f85389c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f85390d0 = false;

    /* renamed from: f0, reason: collision with root package name */
    private final Handler f85392f0 = new a(Looper.getMainLooper());

    /* loaded from: classes4.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 == 1) {
                QFSFeedChildAdTopViewPresenter.this.y1();
                return;
            }
            if (i3 == 2) {
                QFSFeedChildAdTopViewPresenter.this.t1();
            } else {
                if (i3 != 3) {
                    if (i3 == 4) {
                        QFSFeedChildAdTopViewPresenter.this.z1();
                        return;
                    }
                    return;
                }
                QFSFeedChildAdTopViewPresenter.this.J.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (QFSFeedChildAdTopViewPresenter.this.L.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) QFSFeedChildAdTopViewPresenter.this.L.getBackground()).setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    static {
        ArrayList<Integer> arrayList = new ArrayList<>();
        f85384g0 = arrayList;
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        f85385h0 = arrayList2;
        arrayList.add(Integer.valueOf(R.id.f41501h9));
        arrayList.add(Integer.valueOf(R.id.f40051db));
        arrayList.add(Integer.valueOf(R.id.f41471h6));
        arrayList.add(Integer.valueOf(R.id.f34520zd));
        arrayList2.add(Integer.valueOf(R.id.f39041al));
    }

    private void A1() {
        this.Y = af.O(this.I);
        int P = af.P(this.I);
        this.Z = P;
        this.f85387a0 = this.Y + P;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        L1(false);
        J1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f85390d0) {
            com.tencent.biz.qqcircle.immersive.utils.j.f90213a.K(this.f85388b0, view, this.f85018i, r(), Integer.MIN_VALUE);
            this.f85390d0 = false;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean D1(View view, MotionEvent motionEvent) {
        if (view != null && motionEvent != null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action == 1 || action == 3) && Math.abs(motionEvent.getY() - this.f85391e0) > f85386i0) {
                    this.f85390d0 = false;
                }
            } else {
                this.f85391e0 = motionEvent.getY();
                this.f85390d0 = com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a.b(this.f85388b0, view.getHeight(), this.f85391e0);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.immersive.utils.j.f90213a.I(this.f85388b0, view, this.f85018i, r(), Integer.MIN_VALUE);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F1(ValueAnimator valueAnimator) {
        if (valueAnimator != null && this.V != null) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.R.setTranslationY(-floatValue);
            this.S.setTranslationY(floatValue);
        }
    }

    private void G1(boolean z16) {
        if (this.L == null) {
            QLog.e("QFSFeedChildAdTopViewPresenter", 1, "[notifySplashEndBroadcastMessage] error, mTopViewAdEntry is null");
            return;
        }
        QLog.i("QFSFeedChildAdTopViewPresenter", 2, String.format("[notifySplashEndBroadcastMessage] shouldShowButtonScaleAnimation:%b", Boolean.valueOf(z16)));
        com.tencent.biz.qqcircle.immersive.feed.event.q qVar = new com.tencent.biz.qqcircle.immersive.feed.event.q(this.L.getWidth(), this.L.getHeight());
        qVar.c(z16);
        T0(qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I1() {
        K1(2);
        this.R.setTranslationY(0.0f);
        this.S.setTranslationY(0.0f);
        this.K.setVisibility(4);
        this.M.setVisibility(0);
        this.N.setVisibility(0);
        O1();
    }

    private void J1() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdTopViewPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) QFSFeedChildAdTopViewPresenter.this).f85017h).f398449id.get(), 8));
            }
        });
    }

    private void K1(int i3) {
        boolean z16;
        if (i3 != 1 && i3 != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.r(1, z16));
        this.W = i3;
    }

    private void L1(boolean z16) {
        QLog.d("QFSFeedChildAdTopViewPresenter", 1, "showContent");
        G1(z16);
        this.f85392f0.removeCallbacksAndMessages(null);
        K1(3);
        v1().j(z16);
        w1().j(z16);
        SimpleEventBus.getInstance().dispatchEvent(new QFSTabTitleVisibilityEvent(0, z16, 333));
        View findViewById = this.C.findViewById(R.id.f39041al);
        if (!z16 && findViewById != null) {
            findViewById.setAlpha(1.0f);
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.92f, 1.0f, 0.93f, 1, 0.0f, 1, 1.0f);
        scaleAnimation.setDuration(20L);
        this.L.startAnimation(scaleAnimation);
        this.f85392f0.sendEmptyMessageDelayed(3, 20L);
    }

    private void M1() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, ImmersiveUtils.getScreenHeight() / 2);
        this.V = ofFloat;
        ofFloat.setDuration(1000L);
        this.V.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.df
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSFeedChildAdTopViewPresenter.this.F1(valueAnimator);
            }
        });
        this.V.addListener(new b());
        this.V.start();
    }

    private void N1() {
        if (!this.f85389c0) {
            return;
        }
        GdtShakeIconView gdtShakeIconView = this.Q;
        if (gdtShakeIconView == null) {
            QLog.e("QFSFeedChildAdTopViewPresenter", 1, "showShakeAnimation error, mTopViewShakeIcon is null");
        } else {
            gdtShakeIconView.setImageResource();
            this.Q.startAnimation(1, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA);
        }
    }

    private void O1() {
        this.N.setText("\u8df3\u8fc7 " + this.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1() {
        ValueAnimator ofArgb = ValueAnimator.ofArgb(436207615, RichStatus.TOPIC_COLOR);
        ofArgb.setDuration(this.Z);
        ofArgb.addUpdateListener(new c());
        ofArgb.start();
    }

    public static boolean u1() {
        if (uq3.c.X0("qqcircle", "qqcircle_enable_top_view_order", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    private com.tencent.biz.qqcircle.immersive.feed.animwrap.n v1() {
        if (this.T == null) {
            this.T = new n.d().e(333).f(this.C.getId()).g(f85384g0).a();
        }
        return this.T;
    }

    private com.tencent.biz.qqcircle.immersive.feed.animwrap.n w1() {
        if (this.U == null) {
            this.U = new n.d().e(333).f(R.id.f34520zd).g(f85385h0).a();
        }
        return this.U;
    }

    public static z70.b x1(Context context) {
        if (!u1()) {
            return null;
        }
        if (context == null) {
            if (!HostAppSettingUtil.isDebugVersion()) {
                QLog.e("QFSFeedChildAdTopViewPresenter", 1, "[getTopViewOrderElement] context should not be null.");
                return null;
            }
            throw new RuntimeException("[getTopViewOrderElement] context should not be null.");
        }
        return z70.b.g(com.tencent.biz.qqcircle.immersive.manager.e.a().getGroupElementList(context, "folder_pendant"), 105);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1() {
        int i3 = this.X - 1;
        this.X = i3;
        if (i3 <= 0) {
            L1(true);
        } else {
            O1();
            this.f85392f0.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1() {
        if (!this.f85389c0) {
            return;
        }
        if (this.P == null) {
            QLog.e("QFSFeedChildAdTopViewPresenter", 1, "handleShakeScaleAnimation error, mTopViewShakeIconContainer is null");
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new d());
        this.P.startAnimation(scaleAnimation);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean D0(e40.p pVar) {
        super.D0(pVar);
        int i3 = this.W;
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: H1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        int i16 = 0;
        if (this.f85017h == 0 || feedCloudMeta$StFeed == null || !feedCloudMeta$StFeed.f398449id.get().equals(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get())) {
            K1(0);
        }
        super.L0(feedCloudMeta$StFeed, i3);
        if (this.f85017h != 0 && this.E != null) {
            QLog.d("QFSFeedChildAdTopViewPresenter", 1, "onBindData id = " + ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get() + " position=" + this.f85018i + "_" + hashCode());
            U0(ae.b(this.E.g(), i3));
            qq_ad_get.QQAdGetRsp.AdInfo e16 = u.e(this.E);
            this.f85388b0 = new GdtAd(e16);
            this.I = u.c(this.E);
            this.f85389c0 = QFSTopViewManager.i(e16);
            this.L.setText(QFSTopViewManager.e().d(e16));
            View view = this.P;
            if (view != null) {
                if (!this.f85389c0) {
                    i16 = 8;
                }
                view.setVisibility(i16);
            }
            A1();
            return;
        }
        QLog.d("QFSFeedChildAdTopViewPresenter", 1, "[onBindData] feed is null.");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @SuppressLint({"ClickableViewAccessibility"})
    public void N0(@NonNull View view) {
        super.N0(view);
        QLog.d("QFSFeedChildAdTopViewPresenter", 1, "onInitView rootView=" + view + " hashcode " + hashCode());
        View inflate = ((ViewStub) view.findViewById(R.id.f41511h_)).inflate();
        this.J = inflate;
        this.K = inflate.findViewById(R.id.f55862j2);
        this.R = this.J.findViewById(R.id.f38641_i);
        this.S = this.J.findViewById(R.id.f38631_h);
        this.L = (TextView) this.J.findViewById(R.id.f55852j1);
        this.N = (TextView) this.J.findViewById(R.id.f55892j5);
        this.M = this.J.findViewById(R.id.f55842j0);
        this.P = this.J.findViewById(R.id.f55882j4);
        this.Q = (GdtShakeIconView) this.J.findViewById(R.id.f55872j3);
        this.J.setVisibility(8);
        K1(0);
        SimpleEventBus.getInstance().registerReceiver(this);
        this.N.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.db
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSFeedChildAdTopViewPresenter.this.B1(view2);
            }
        });
        this.J.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSFeedChildAdTopViewPresenter.this.C1(view2);
            }
        });
        f85386i0 = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.J.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dd
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean D1;
                D1 = QFSFeedChildAdTopViewPresenter.this.D1(view2, motionEvent);
                return D1;
            }
        });
        this.L.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.de
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSFeedChildAdTopViewPresenter.this.E1(view2);
            }
        });
        Map<String, Object> c16 = ae.c(r0(), "state2", null, this.f85018i);
        ae.a(this.N, this.E, QCircleDaTongConstant.ElementId.EM_XSJ_COMERCIAL_SKIP, c16);
        ae.a(this.L, this.E, "em_xsj_commercial_button", c16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        boolean z16;
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.getPosition() == this.f85018i) {
            boolean j3 = QFSTopViewManager.e().j((FeedCloudMeta$StFeed) this.f85017h);
            boolean g16 = QFSTopViewManager.e().g((FeedCloudMeta$StFeed) this.f85017h);
            QLog.d("QFSFeedChildAdTopViewPresenter", 1, "onFeedSelected id = " + ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get() + " position=" + this.f85018i + " isTopViewFeed " + j3 + " hasShowed " + g16 + " state " + this.W + " hashcode " + hashCode());
            if (j3 && this.f85018i == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            QFSTopViewManager.e().l((FeedCloudMeta$StFeed) this.f85017h);
            if (!z16) {
                if (s0().isContainerOnScreen()) {
                    L1(false);
                    return;
                }
                return;
            }
            if (!g16 && this.W == 0) {
                z70.b x16 = x1(m0());
                if (x16 != null) {
                    x16.l(RFWOrderElementManager.OrderMode.ROB_MODE);
                }
                K1(1);
                this.J.setVisibility(0);
                this.X = this.f85387a0 / 1000;
                O1();
                N1();
                M1();
                this.f85392f0.sendEmptyMessageDelayed(1, 1000L);
                this.f85392f0.sendEmptyMessageDelayed(2, this.Y);
                if (this.f85389c0) {
                    this.f85392f0.sendEmptyMessageDelayed(4, this.f85387a0 - 200);
                }
                v1().d(this.C.findViewById(R.id.f41541hc), false);
                w1().d(this.C.findViewById(R.id.f39041al), false);
                View findViewById = this.C.findViewById(R.id.f39041al);
                if (findViewById != null) {
                    findViewById.setAlpha(0.0f);
                }
                SimpleEventBus.getInstance().dispatchEvent(new QFSTabTitleVisibilityEvent(4, false, 0));
                return;
            }
            G1(false);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        z70.b x16 = x1(m0());
        if (x16 != null) {
            x16.m();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        z70.b x16 = x1(m0());
        if (x16 != null) {
            x16.m();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdTopViewPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QFSFeedChildAdTopViewPresenter.this.I1();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSFeedChildAdTopViewPresenter.this.I1();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (QFSFeedChildAdTopViewPresenter.this.Q != null) {
                QFSFeedChildAdTopViewPresenter.this.Q.resetImageResource();
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
