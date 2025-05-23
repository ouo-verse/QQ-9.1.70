package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSCallFriendFollowBackEvent;
import com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAvatarFollowGuideAnimController;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedFastPushRocketAnimEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFollowTabLiveListEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSLiveStatusChangedEvent;
import com.tencent.biz.qqcircle.immersive.utils.aq;
import com.tencent.biz.qqcircle.immersive.views.QFSPlusFollowView;
import com.tencent.biz.qqcircle.manager.QFSUsersLiveStatusManager;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarDecorateView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.biz.qqcircle.widgets.QFSPushRocketFireworksView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSFeedChildAvatarPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener, QFSFollowView.c {

    /* renamed from: l0, reason: collision with root package name */
    private static final int f85025l0 = com.tencent.biz.qqcircle.utils.cx.a(132.0f);

    /* renamed from: m0, reason: collision with root package name */
    private static final int f85026m0 = com.tencent.biz.qqcircle.utils.cx.a(-40.0f);

    /* renamed from: n0, reason: collision with root package name */
    private static final int f85027n0 = com.tencent.biz.qqcircle.utils.cx.a(-60.0f);
    private int I;
    private int J;
    private FeedCloudMeta$StFeed L;
    private View M;
    private View N;
    private QFSPushRocketFireworksView P;
    private ImageView Q;
    private LinearLayout R;
    private QCircleAvatarView S;
    private QCircleAvatarDecorateView T;
    private QFSPlusFollowView U;
    private ImageView V;
    private ImageView W;
    private TextView X;
    private FrameLayout Y;
    private FrameLayout Z;

    /* renamed from: a0, reason: collision with root package name */
    private Size f85028a0;

    /* renamed from: b0, reason: collision with root package name */
    private QFSFeedAvatarFollowGuideAnimController f85029b0;

    /* renamed from: c0, reason: collision with root package name */
    private View f85030c0;

    /* renamed from: d0, reason: collision with root package name */
    private QFSPagAnimView f85031d0;

    /* renamed from: e0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.utils.aq f85032e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f85033f0;

    /* renamed from: g0, reason: collision with root package name */
    private t40.c f85034g0;

    /* renamed from: k0, reason: collision with root package name */
    private QFSFollowView.e f85038k0;
    private int K = 5;

    /* renamed from: h0, reason: collision with root package name */
    private Runnable f85035h0 = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildAvatarPresenter.1
        @Override // java.lang.Runnable
        public void run() {
            if (QFSFeedChildAvatarPresenter.this.f85032e0 == null) {
                return;
            }
            QFSFeedChildAvatarPresenter.this.f85032e0.f(QFSFeedChildAvatarPresenter.this.J, QFSFeedChildAvatarPresenter.this.X, QFSFeedChildAvatarPresenter.this.I);
        }
    };

    /* renamed from: i0, reason: collision with root package name */
    private Runnable f85036i0 = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildAvatarPresenter.2
        @Override // java.lang.Runnable
        public void run() {
            QFSFeedChildAvatarPresenter.this.T1();
        }
    };

    /* renamed from: j0, reason: collision with root package name */
    private Runnable f85037j0 = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildAvatarPresenter.3
        @Override // java.lang.Runnable
        public void run() {
            QFSFeedChildAvatarPresenter.this.u1();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements QFSFeedAvatarFollowGuideAnimController.b {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Map<String, Object> c() {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EX_XSJ_AVATAR_FOLLOW_GUIDE_MODULE);
            buildElementParams.put("xsj_custom_pgid", QFSFeedChildAvatarPresenter.this.r0());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().b()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
            Map<String, Object> S = QFSFeedChildAvatarPresenter.this.S(buildElementParams);
            S.putAll(ua0.c.d(QFSFeedChildAvatarPresenter.this.E));
            S.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(QFSFeedChildAvatarPresenter.this.f85018i + 1));
            T t16 = QFSFeedChildAvatarPresenter.this.f85017h;
            if (t16 != 0) {
                S.put("xsj_target_qq", ((FeedCloudMeta$StFeed) t16).poster.f398463id.get());
            }
            S.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            return S;
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAvatarFollowGuideAnimController.b
        public void a() {
            VideoReport.reportEvent("ev_xsj_abnormal_imp", null, c());
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAvatarFollowGuideAnimController.b
        public void b() {
            VideoReport.reportEvent("ev_xsj_abnormal_clck", null, c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements aq.d {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.utils.aq.d
        public void a(int i3) {
            QFSFeedChildAvatarPresenter.this.x0().postDelayed(QFSFeedChildAvatarPresenter.this.f85037j0, i3);
            RFWLog.d("QFSFeedChildAvatarPresenter", 1, "dismiss push text");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements QFSPagAnimView.c {
        d() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationCancel(QFSPagAnimView qFSPagAnimView) {
            com.tencent.biz.qqcircle.widgets.bc.a(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public void onAnimationEnd(QFSPagAnimView qFSPagAnimView) {
            QFSFeedChildAvatarPresenter.this.Q1(false);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationRepeat(QFSPagAnimView qFSPagAnimView) {
            com.tencent.biz.qqcircle.widgets.bc.c(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public void onAnimationStart(QFSPagAnimView qFSPagAnimView) {
            QFSFeedChildAvatarPresenter.this.s1();
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationUpdate(QFSPagAnimView qFSPagAnimView) {
            com.tencent.biz.qqcircle.widgets.bc.e(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onPagPlayError(QFSPagAnimView qFSPagAnimView, String str) {
            com.tencent.biz.qqcircle.widgets.bc.f(this, qFSPagAnimView, str);
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSFeedChildAvatarPresenter> f85043a;

        public e(QFSFeedChildAvatarPresenter qFSFeedChildAvatarPresenter) {
            this.f85043a = new WeakReference<>(qFSFeedChildAvatarPresenter);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            QFSFeedChildAvatarPresenter qFSFeedChildAvatarPresenter = this.f85043a.get();
            if (qFSFeedChildAvatarPresenter == null) {
                return buildElementParams;
            }
            e30.b bVar = qFSFeedChildAvatarPresenter.E;
            buildElementParams.putAll(ua0.c.d(bVar));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(qFSFeedChildAvatarPresenter.f85018i + 1));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_QQLIVE, Boolean.valueOf(com.tencent.biz.qqcircle.immersive.utils.r.p0(bVar.g())));
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            return buildElementParams;
        }
    }

    private void A1(QFSLiveStatusChangedEvent qFSLiveStatusChangedEvent) {
        if (this.L != null && qFSLiveStatusChangedEvent.getFinishLiveUins().contains(this.L.poster.f398463id.get()) && E0()) {
            t1();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r5.mClickType == 5) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void B1(QCirclePushAnimationEvent qCirclePushAnimationEvent) {
        int i3;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.L;
        if (feedCloudMeta$StFeed != null && qCirclePushAnimationEvent != null && qCirclePushAnimationEvent.mPageType == this.K && qCirclePushAnimationEvent.mTargetFeedId.equals(feedCloudMeta$StFeed.f398449id.get())) {
            if (qCirclePushAnimationEvent.mRecommendTimes != com.tencent.biz.qqcircle.l.c()) {
                i3 = 5;
            }
            x0().postDelayed(this.f85036i0, 920L);
            i3 = 6;
            com.tencent.biz.qqcircle.immersive.utils.aq aqVar = this.f85032e0;
            if (aqVar != null) {
                aqVar.k(i3, this.S, this.V, this.W);
            }
        }
    }

    private void C1(@NonNull com.tencent.biz.qqcircle.immersive.feed.event.an anVar) {
        QFSFeedAvatarFollowGuideAnimController qFSFeedAvatarFollowGuideAnimController = this.f85029b0;
        if (qFSFeedAvatarFollowGuideAnimController != null) {
            qFSFeedAvatarFollowGuideAnimController.z(anVar.e());
        }
    }

    private void D1(int i3, int i16, int i17, int i18) {
        ViewStub viewStub;
        if ((this.f85031d0 != null && this.f85030c0 != null) || (viewStub = (ViewStub) this.C.findViewById(R.id.f39251b6)) == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.f85030c0 = inflate;
        this.f85031d0 = (QFSPagAnimView) inflate.findViewById(R.id.f34040y3);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i16);
        layoutParams.topMargin = i17;
        layoutParams.leftMargin = i18;
        this.f85031d0.setLayoutParams(layoutParams);
        this.f85031d0.setClipChildren(false);
    }

    private void E1() {
        ViewStub viewStub = (ViewStub) this.C.findViewById(R.id.f39261b7);
        if (viewStub == null) {
            return;
        }
        View inflate = viewStub.inflate();
        QFSPushRocketFireworksView qFSPushRocketFireworksView = (QFSPushRocketFireworksView) inflate.findViewById(R.id.f505225m);
        this.P = qFSPushRocketFireworksView;
        this.Q = (ImageView) qFSPushRocketFireworksView.findViewById(R.id.f510026x);
        this.R = (LinearLayout) inflate.findViewById(R.id.f39271b8);
    }

    private void F1() {
        ViewStub viewStub;
        View inflate;
        View view = this.N;
        if (view == null || (viewStub = (ViewStub) view.findViewById(R.id.f512027g)) == null || (inflate = viewStub.inflate()) == null) {
            return;
        }
        TextView textView = (TextView) inflate.findViewById(R.id.f41101g6);
        this.X = textView;
        RFWTypefaceUtil.setNumberTypeface(textView, true);
        R1(this.X);
    }

    private void G1(View view) {
        QFSPlusFollowView qFSPlusFollowView = (QFSPlusFollowView) view.findViewById(R.id.v_g);
        this.U = qFSPlusFollowView;
        qFSPlusFollowView.setFollowedDismiss(true);
        this.U.setContentDescription("\u70b9\u51fb\u5173\u6ce8");
        P1(this.U);
        this.U.setVisibility(8);
        this.U.setFollowStateChangeListener(this);
    }

    private void H1(@NonNull View view) {
        this.Y = (FrameLayout) view.findViewById(R.id.v_s);
        this.Z = (FrameLayout) view.findViewById(R.id.v_y);
    }

    private void I1() {
        boolean z16;
        ViewStub viewStub = (ViewStub) this.M.findViewById(R.id.f39241b5);
        if (this.U != null && this.S != null && this.V != null && this.T != null && viewStub != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.e("QFSFeedChildAvatarPresenter", 1, "initQFSFeedAvatarGuideAnimController failed, view is inValid");
            return;
        }
        QFSFeedAvatarFollowGuideAnimController qFSFeedAvatarFollowGuideAnimController = new QFSFeedAvatarFollowGuideAnimController(this.S, this.V, this.T, this.Z, this.Y, this.U, viewStub);
        this.f85029b0 = qFSFeedAvatarFollowGuideAnimController;
        qFSFeedAvatarFollowGuideAnimController.B(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J1() {
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.g());
    }

    private void L1(String str, int i3, long j3) {
        if (this.f85031d0 == null) {
            return;
        }
        Q1(true);
        this.f85031d0.setPagAnimListener(new d());
        this.f85031d0.N(str, i3, j3);
    }

    private void M1() {
        if (this.f85035h0 != null) {
            x0().removeCallbacks(this.f85035h0);
        }
        if (this.f85036i0 != null) {
            x0().removeCallbacks(this.f85036i0);
        }
        if (this.f85037j0 != null) {
            x0().removeCallbacks(this.f85037j0);
        }
    }

    private void N1() {
        QFSPlusFollowView qFSPlusFollowView;
        QFSFollowView.e eVar = this.f85038k0;
        if (eVar != null && (qFSPlusFollowView = this.U) != null) {
            qFSPlusFollowView.C(eVar);
        }
    }

    private void O1() {
        QFSPagAnimView qFSPagAnimView = this.f85031d0;
        if (qFSPagAnimView != null) {
            qFSPagAnimView.V();
        }
        Q1(false);
    }

    private void P1(@NonNull QFSPlusFollowView qFSPlusFollowView) {
        qFSPlusFollowView.setItemReportListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q1(boolean z16) {
        int i3;
        QFSPagAnimView qFSPagAnimView = this.f85031d0;
        int i16 = 0;
        if (qFSPagAnimView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            qFSPagAnimView.setVisibility(i3);
        }
        View view = this.f85030c0;
        if (view != null) {
            if (!z16) {
                i16 = 8;
            }
            view.setVisibility(i16);
        }
    }

    private void R1(TextView textView) {
        textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, textView.getPaint().getTextSize(), new int[]{Color.parseColor("#FFFEE098"), Color.parseColor("#FFFEF2E4")}, (float[]) null, Shader.TileMode.CLAMP));
        textView.setShadowLayer(2, 0, 5, Color.parseColor("#FF000000"));
        textView.invalidate();
    }

    private void S1(String str, String str2) {
        FrameLayout frameLayout = this.Y;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            this.Y.setOnClickListener(this);
            this.Y.setBackground(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("QFSFeedChildAvatarPresenter", str));
        }
        FrameLayout frameLayout2 = this.Z;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
            this.Z.setOnClickListener(this);
            this.Z.setBackground(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("QFSFeedChildAvatarPresenter", str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1() {
        if (this.P == null) {
            E1();
        }
        QFSPushRocketFireworksView qFSPushRocketFireworksView = this.P;
        if (qFSPushRocketFireworksView != null) {
            r1(qFSPushRocketFireworksView);
            this.P.f(this.Q);
        }
    }

    private void U1() {
        this.J = 0;
        u1();
        com.tencent.biz.qqcircle.immersive.utils.aq aqVar = this.f85032e0;
        if (aqVar != null) {
            aqVar.u(0);
            this.f85032e0.l();
            this.f85032e0.m();
            this.f85032e0 = null;
        }
        v1();
        M1();
        O1();
    }

    private void V1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        QCircleAvatarDecorateView qCircleAvatarDecorateView = this.T;
        if (qCircleAvatarDecorateView == null) {
            QLog.d("QFSFeedChildAvatarPresenter", 1, "QCircleRefreshIconDecorate [updateAuthorAvatarDecorateView] author avatar decorate view not be null.");
            return;
        }
        if (feedCloudMeta$StFeed == null) {
            feedCloudMeta$StUser = null;
        } else {
            feedCloudMeta$StUser = feedCloudMeta$StFeed.poster;
        }
        if (feedCloudMeta$StUser == null) {
            QLog.d("QFSFeedChildAvatarPresenter", 1, "QCircleRefreshIconDecorate [updateAuthorAvatarDecorateView] user info should not be null.");
        } else {
            qCircleAvatarDecorateView.setUser(feedCloudMeta$StUser);
        }
    }

    private void W1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        QCircleAvatarView qCircleAvatarView = this.S;
        if (qCircleAvatarView == null) {
            QLog.d("QFSFeedChildAvatarPresenter", 1, "[updateAuthorAvatarView] author avatar view not be null.");
            return;
        }
        if (feedCloudMeta$StFeed == null) {
            feedCloudMeta$StUser = null;
        } else {
            feedCloudMeta$StUser = feedCloudMeta$StFeed.poster;
        }
        if (feedCloudMeta$StUser == null) {
            QLog.d("QFSFeedChildAvatarPresenter", 1, "[updateAuthorAvatarView] user info should not be null.");
            return;
        }
        qCircleAvatarView.setUser(feedCloudMeta$StUser, this.f85028a0);
        VideoReport.setElementId(this.S, "em_xsj_author_avatar");
        VideoReport.setEventDynamicParams(this.S, new e(this));
        VideoReport.setElementReuseIdentifier(this.S, "em_xsj_author_avatar" + this.E.g().f398449id.get());
        VideoReport.setElementEndExposePolicy(this.S, EndExposurePolicy.REPORT_ALL);
        f0(this.Y, "em_xsj_author_avatar");
        f0(this.Z, "em_xsj_author_avatar");
    }

    private void X1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QFSPlusFollowView qFSPlusFollowView = this.U;
        if (qFSPlusFollowView == null) {
            QLog.d("QFSFeedChildAvatarPresenter", 1, "[updateAuthorFollowView] author attention view not be null.");
        } else {
            qFSPlusFollowView.setUserData(feedCloudMeta$StFeed.poster.get(), feedCloudMeta$StFeed);
        }
    }

    private void Z1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QFSFeedAvatarFollowGuideAnimController qFSFeedAvatarFollowGuideAnimController = this.f85029b0;
        if (qFSFeedAvatarFollowGuideAnimController != null) {
            qFSFeedAvatarFollowGuideAnimController.v(feedCloudMeta$StFeed);
        }
    }

    private void a2(boolean z16) {
        boolean z17;
        if (this.M == null) {
            return;
        }
        QCircleReportBean reportBean = getReportBean();
        int i3 = 4;
        if (reportBean != null && TextUtils.equals(reportBean.getDtPageId(), QCircleDaTongConstant.PageId.PG_XSJ_FOLLOWING_PAGE)) {
            Object messageFromPart = ((BasePartFragment) s0().getHostFragment()).getPartManager().getMessageFromPart("qfs_action_top_live_status", null);
            if ((messageFromPart instanceof Boolean) && ((Boolean) messageFromPart).booleanValue()) {
                z17 = true;
            } else {
                z17 = false;
            }
            View view = this.M;
            if (!z16 && !z17) {
                i3 = 0;
            }
            view.setVisibility(i3);
            QLog.d("QFSFeedChildAvatarPresenter", 1, "[setViewStatus] isShowView: " + z16 + " isShowLiveList: " + z17);
            return;
        }
        View view2 = this.M;
        if (!z16) {
            i3 = 0;
        }
        view2.setVisibility(i3);
        QLog.d("QFSFeedChildAvatarPresenter", 1, "[setViewStatus] isShowView: " + z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c2() {
        if ((com.tencent.biz.qqcircle.immersive.utils.r.l0(((FeedCloudMeta$StFeed) this.f85017h).poster) || com.tencent.biz.qqcircle.immersive.utils.r.p0((FeedCloudMeta$StFeed) this.f85017h)) && QFSUsersLiveStatusManager.i().k(((FeedCloudMeta$StFeed) this.f85017h).poster.f398463id.get())) {
            S1(QCircleSkinHelper.getInstance().getUrl("qvideo_live_circle_diffusion"), QCircleSkinHelper.getInstance().getUrl("qvideo_live_zhibozhong_noboarder"));
        } else {
            t1();
        }
    }

    private void q1(QFSPlusFollowView qFSPlusFollowView) {
        if (this.f85038k0 == null) {
            this.f85038k0 = new QFSFollowView.e() { // from class: com.tencent.biz.qqcircle.immersive.feed.l
                @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.e
                public final void beforeClick() {
                    QFSFeedChildAvatarPresenter.this.J1();
                }
            };
        }
        if (qFSPlusFollowView != null) {
            qFSPlusFollowView.f(this.f85038k0);
        }
    }

    private void r1(View view) {
        LinearLayout linearLayout;
        if (view != null && (linearLayout = (LinearLayout) this.C.findViewById(R.id.f33120vl)) != null && this.N != null) {
            int height = (linearLayout.getHeight() - this.N.getBottom()) + (this.N.getHeight() / 2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.bottomMargin = height;
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.N, "translationY", 0.0f, 9.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.N, "translationY", 0.0f, 9.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.N, "translationY", 0.0f, 9.0f, 0.0f);
        ofFloat.setStartDelay(480L);
        ofFloat.setDuration(240L);
        ofFloat2.setStartDelay(680L);
        ofFloat2.setDuration(240L);
        ofFloat3.setStartDelay(640L);
        ofFloat3.setDuration(240L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat2).after(ofFloat).before(ofFloat3);
        animatorSet.start();
    }

    private void t1() {
        FrameLayout frameLayout = this.Y;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        FrameLayout frameLayout2 = this.Z;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1() {
        TextView textView = this.X;
        if (textView != null) {
            textView.setVisibility(8);
            this.X.setAlpha(1.0f);
            QLog.d("QFSFeedChildAvatarPresenter", 1, "dismiss push rocket text");
        }
        com.tencent.biz.qqcircle.immersive.utils.aq aqVar = this.f85032e0;
        if (aqVar != null) {
            aqVar.m();
        }
    }

    private void v1() {
        QFSPushRocketFireworksView qFSPushRocketFireworksView = this.P;
        if (qFSPushRocketFireworksView != null) {
            qFSPushRocketFireworksView.setVisibility(8);
            this.P.g();
        }
    }

    private void w1(QFSCallFriendFollowBackEvent qFSCallFriendFollowBackEvent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.L;
        if (feedCloudMeta$StFeed != null && qFSCallFriendFollowBackEvent.friendUin.equals(feedCloudMeta$StFeed.poster.f398463id.get()) && qFSCallFriendFollowBackEvent.scene == 1 && qFSCallFriendFollowBackEvent.feedId.equals(this.L.f398449id.get())) {
            int i3 = f85025l0;
            D1(i3, i3, f85026m0, f85027n0);
            L1("https://qq-video.cdn-go.cn/android/latest/defaultmode/8938/friend_invitation/qvideo_feed_invitation_touchhead.pag", 1, 3000L);
        }
    }

    private void x1(QFSFeedFastPushRocketAnimEvent qFSFeedFastPushRocketAnimEvent) {
        if (qFSFeedFastPushRocketAnimEvent != null && this.L != null && qFSFeedFastPushRocketAnimEvent.getFeedId().equals(this.L.f398449id.get()) && this.f85032e0 != null) {
            F1();
            this.J = qFSFeedFastPushRocketAnimEvent.getPushType();
            this.I = qFSFeedFastPushRocketAnimEvent.getPushRocketCount();
            this.f85032e0.u(this.J);
            this.f85032e0.t(new c());
            this.f85032e0.k(this.J, this.S, this.V, this.W);
            x0().post(this.f85035h0);
            if (this.J == 3) {
                x0().postDelayed(this.f85036i0, 920L);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y1(@NonNull com.tencent.biz.qqcircle.immersive.feed.event.m mVar) {
        QFSPlusFollowView qFSPlusFollowView;
        T t16 = this.f85017h;
        if ((t16 instanceof FeedCloudMeta$StFeed) && TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), mVar.f86173a) && (qFSPlusFollowView = this.U) != null) {
            qFSPlusFollowView.callOnClick();
        }
    }

    private void z1(@NonNull QFSFollowTabLiveListEvent qFSFollowTabLiveListEvent) {
        QCircleReportBean reportBean;
        int i3;
        if (this.M != null && (reportBean = getReportBean()) != null && TextUtils.equals(reportBean.getDtPageId(), QCircleDaTongConstant.PageId.PG_XSJ_FOLLOWING_PAGE)) {
            boolean z16 = qFSFollowTabLiveListEvent.mIsShowLiveList;
            QLog.d("QFSFeedChildAvatarPresenter", 1, "handleFollowTabLiveListEvent" + z16);
            View view = this.M;
            if (z16) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            view.setVisibility(i3);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.m) {
            y1((com.tencent.biz.qqcircle.immersive.feed.event.m) hVar);
        }
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.an) {
            C1((com.tencent.biz.qqcircle.immersive.feed.event.an) hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        a2(this.f85033f0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: K1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSFeedChildAvatarPresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        View view = this.N;
        if (view != null) {
            view.setVisibility(0);
        }
        this.L = feedCloudMeta$StFeed;
        c1(false);
        X1(feedCloudMeta$StFeed);
        W1(feedCloudMeta$StFeed);
        V1(feedCloudMeta$StFeed);
        Z1(feedCloudMeta$StFeed);
        QFSUsersLiveStatusManager.i().f(this.L);
        if (this.f85034g0 == null) {
            this.f85034g0 = (t40.c) u0(t40.c.class);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        U1();
        QFSFeedAvatarFollowGuideAnimController qFSFeedAvatarFollowGuideAnimController = this.f85029b0;
        if (qFSFeedAvatarFollowGuideAnimController != null) {
            qFSFeedAvatarFollowGuideAnimController.w();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        QLog.d(getTAG(), 1, "[onInitView] hashCode:" + hashCode());
        View findViewById = view.findViewById(R.id.f40491ei);
        this.M = findViewById;
        View findViewById2 = findViewById.findViewById(R.id.f39301ba);
        this.N = findViewById2;
        this.S = (QCircleAvatarView) findViewById2.findViewById(R.id.v_e);
        this.V = (ImageView) this.N.findViewById(R.id.f39281b9);
        this.W = (ImageView) this.N.findViewById(R.id.f39291b_);
        this.T = (QCircleAvatarDecorateView) this.N.findViewById(R.id.v_f);
        QCircleAvatarView qCircleAvatarView = this.S;
        if (qCircleAvatarView == null) {
            return;
        }
        qCircleAvatarView.setOnClickListener(this);
        this.T.setContentDescription("\u4f5c\u8005\u5934\u50cf\u88c5\u9970");
        this.S.setContentDescription("\u4f5c\u8005\u5934\u50cf");
        G1(this.N);
        H1(this.N);
        this.f85028a0 = com.tencent.biz.qqcircle.immersive.utils.n.a(view.getContext(), R.dimen.d1a);
        I1();
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.c
    public void O(boolean z16, FeedCloudMeta$StUser feedCloudMeta$StUser) {
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.v(z16, feedCloudMeta$StUser));
        QFSFeedAvatarFollowGuideAnimController qFSFeedAvatarFollowGuideAnimController = this.f85029b0;
        if (qFSFeedAvatarFollowGuideAnimController != null) {
            qFSFeedAvatarFollowGuideAnimController.y(feedCloudMeta$StUser.f398463id.get(), z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void c1(boolean z16) {
        super.c1(z16);
        this.f85033f0 = z16;
        a2(z16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSFeedFastPushRocketAnimEvent.class);
        eventClass.add(QCirclePushAnimationEvent.class);
        eventClass.add(QFSCallFriendFollowBackEvent.class);
        eventClass.add(QFSLiveStatusChangedEvent.class);
        eventClass.add(QFSFollowTabLiveListEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        this.f85032e0 = new com.tencent.biz.qqcircle.immersive.utils.aq();
        c2();
        u1();
        v1();
        QFSFeedAvatarFollowGuideAnimController qFSFeedAvatarFollowGuideAnimController = this.f85029b0;
        if (qFSFeedAvatarFollowGuideAnimController != null) {
            qFSFeedAvatarFollowGuideAnimController.x();
        }
        q1(this.U);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        t1();
        U1();
        N1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSFeedFastPushRocketAnimEvent) {
            x1((QFSFeedFastPushRocketAnimEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCirclePushAnimationEvent) {
            B1((QCirclePushAnimationEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSCallFriendFollowBackEvent) {
            w1((QFSCallFriendFollowBackEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSLiveStatusChangedEvent) {
            A1((QFSLiveStatusChangedEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSFollowTabLiveListEvent) {
            z1((QFSFollowTabLiveListEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        QCircleAvatarView qCircleAvatarView = this.S;
        if (qCircleAvatarView != null) {
            qCircleAvatarView.p();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAvatarPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements QFSFollowView.d {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public /* synthetic */ void b() {
            com.tencent.biz.qqcircle.widgets.aa.a(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void c(int i3) {
            if (QFSFeedChildAvatarPresenter.this.E0()) {
                QFSFeedChildAvatarPresenter qFSFeedChildAvatarPresenter = QFSFeedChildAvatarPresenter.this;
                qFSFeedChildAvatarPresenter.R0(80, 1, qFSFeedChildAvatarPresenter.r(), "");
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void onClick(int i3) {
            QFSFeedChildAvatarPresenter qFSFeedChildAvatarPresenter = QFSFeedChildAvatarPresenter.this;
            qFSFeedChildAvatarPresenter.R0(80, 2, qFSFeedChildAvatarPresenter.r(), "");
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_action_type", "follow");
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().b()));
            Map<String, Object> S = QFSFeedChildAvatarPresenter.this.S(hashMap);
            S.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_SHOW_AD, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.ad.a.h((ViewGroup) QFSFeedChildAvatarPresenter.this.C.findViewById(R.id.f40181do))));
            QFSFeedChildAvatarPresenter qFSFeedChildAvatarPresenter2 = QFSFeedChildAvatarPresenter.this;
            qFSFeedChildAvatarPresenter2.i0(qFSFeedChildAvatarPresenter2.C, QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, S);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void a() {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
