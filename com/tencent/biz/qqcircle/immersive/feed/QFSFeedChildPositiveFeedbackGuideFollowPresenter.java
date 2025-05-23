package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.events.QFSLikeStateChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSDoublePraiseEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSSendFollowedReqEvent;
import com.tencent.biz.qqcircle.immersive.request.QFSGetFeedBottomPositiveFeedbackGuildFollowRequest;
import com.tencent.biz.qqcircle.widgets.QFSMultiGuideBtnManageLayout;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$ButtonInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StFeedDeatilSecondaryLoadRsp;
import feedcloud.FeedCloudWidget$StButtonGroup;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class QFSFeedChildPositiveFeedbackGuideFollowPresenter extends ao {
    private ViewStub M;
    private View N;
    private View P;
    private QFSMultiGuideBtnManageLayout Q;
    private FeedCloudWidget$StButtonGroup R;
    private boolean S;
    private String T;
    private IOrderElement U;
    private boolean V;
    private t40.c W;
    private int X = -1;
    private final Runnable Y = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildPositiveFeedbackGuideFollowPresenter.1
        @Override // java.lang.Runnable
        public void run() {
            if (QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.Q != null && QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.Q.getVisibility() == 0) {
                if (QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.S) {
                    QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[mDisMissRunnable] mMultiButtonLayout is doing select animation");
                    return;
                }
                QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[mDisMissRunnable] start. mOtherBannerView = " + QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.P);
                QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.Q.t(4, QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.P);
                return;
            }
            QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[mDisMissRunnable] mMultiButtonLayout is not visible");
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.Q != null && QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.P != null) {
                float f16 = -((Integer) valueAnimator.getAnimatedValue()).intValue();
                QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.Q.setTranslationY(f16);
                QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.P.setTranslationY(f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements QFSMultiGuideBtnManageLayout.m {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSMultiGuideBtnManageLayout.m
        public void a(int i3) {
            QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.r1(i3);
            QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.Q.t(i3, QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.P);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements QFSMultiGuideBtnManageLayout.m {
        e() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSMultiGuideBtnManageLayout.m
        public void a(int i3) {
            QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.r1(i3);
            QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.Q.s(i3);
        }
    }

    private void A1(QFSSendFollowedReqEvent qFSSendFollowedReqEvent) {
        if (this.Q != null && qFSSendFollowedReqEvent != null) {
            if (!TextUtils.equals(qFSSendFollowedReqEvent.getFeedId(), t1())) {
                QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[handleSelectedFollowEvent] is not the same feed. event.getFeedId() = " + qFSSendFollowedReqEvent.getFeedId() + ", getFeedId() = " + t1());
                return;
            }
            QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[handleSelectedFollowEvent] mOtherBannerView = " + this.P);
            RFWThreadManager.getUIHandler().removeCallbacks(this.Y);
            this.Q.t(3, this.P);
        }
    }

    private void B1() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, DisplayUtil.dip2px(m0(), 32.0f));
        ofInt.setStartDelay(40L);
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new a());
        ofInt.addListener(new b());
        ofInt.start();
        QFSMultiGuideBtnManageLayout qFSMultiGuideBtnManageLayout = this.Q;
        if (qFSMultiGuideBtnManageLayout != null) {
            qFSMultiGuideBtnManageLayout.setOnSelectedListener(new c());
        }
    }

    private boolean C1(e30.b bVar) {
        if (bVar != null && bVar.g() != null) {
            if (com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
                QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[isCanShow] forbid follow because of sencebeat");
                return false;
            }
            if (D1()) {
                QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[isCanShow] is followed");
                return false;
            }
            QFSMultiGuideBtnManageLayout qFSMultiGuideBtnManageLayout = this.Q;
            if (qFSMultiGuideBtnManageLayout != null && qFSMultiGuideBtnManageLayout.getVisibility() == 0) {
                QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[isCanShow] positive feedback guide follow is showing");
                return false;
            }
            if (this.S) {
                QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[isCanShow] isDoActioned");
                return false;
            }
            if (g1()) {
                return false;
            }
            QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[isCanShow] mShowingElement = " + this.U);
            if (TextUtils.isEmpty(this.T) || !com.tencent.biz.qqcircle.immersive.utils.r.x0(this.T, v1())) {
                return true;
            }
            QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[isCanShow] the feed has arrive the max show times");
            return false;
        }
        QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[isCanShow] feed should not be null");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean D1() {
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).poster != null && !QCirclePluginUtil.isFollow(((FeedCloudMeta$StFeed) t16).poster) && !QCirclePluginUtil.isOwner(((FeedCloudMeta$StFeed) this.f85017h).poster) && !QCircleFollowManager.getInstance().isUinFollowed(((FeedCloudMeta$StFeed) this.f85017h).poster.f398463id.get())) {
            return false;
        }
        return true;
    }

    private boolean E1() {
        t40.c cVar = this.W;
        if (cVar != null && cVar.getFeedSourceType() == 82) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F1(QFSGetFeedBottomPositiveFeedbackGuildFollowRequest qFSGetFeedBottomPositiveFeedbackGuildFollowRequest, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StFeedDeatilSecondaryLoadRsp feedCloudRead$StFeedDeatilSecondaryLoadRsp) {
        QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[sendReq] requestFeedBottomPositiveFeedbackGuildData onReceive: dispatch Success:" + z16 + " | TraceId:" + qFSGetFeedBottomPositiveFeedbackGuildFollowRequest.getTraceId() + " | SeqId:" + qFSGetFeedBottomPositiveFeedbackGuildFollowRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isCache:" + VSNetworkHelper.isProtocolCache(str));
        if (z16 && j3 == 0 && feedCloudRead$StFeedDeatilSecondaryLoadRsp != null) {
            if (feedCloudRead$StFeedDeatilSecondaryLoadRsp.guide_info == null) {
                QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[sendReq] rsp.guide_info should not be null");
                return;
            }
            this.T = com.tencent.biz.qqcircle.utils.bh.d(feedCloudRead$StFeedDeatilSecondaryLoadRsp.extInfo.mapInfo.get(), "sub_button_limit");
            QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[sendReq] onReceive Success. maxShowTimes = " + this.T);
            if (feedCloudRead$StFeedDeatilSecondaryLoadRsp.guide_info.guide_type.get() != 4) {
                QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[sendReq] guide type is not GUIDE_TYPE_FEED_BUTTOM_SUB_LIKE, type = " + feedCloudRead$StFeedDeatilSecondaryLoadRsp.guide_info.guide_type.get());
                return;
            }
            K1(feedCloudRead$StFeedDeatilSecondaryLoadRsp.guide_info.btmSubInfo);
        }
    }

    private void G1(@NonNull View view) {
        if (this.M != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f493822j);
        this.M = viewStub;
        View inflate = viewStub.inflate();
        this.N = inflate;
        if (inflate == null) {
            QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[makeSureInflate] mInflateView should not be null");
        } else {
            this.Q = (QFSMultiGuideBtnManageLayout) inflate.findViewById(R.id.f493722i);
        }
    }

    private void I1() {
        i1(this.Q, new d());
        N1(this.Q, 4);
        QFSMultiGuideBtnManageLayout qFSMultiGuideBtnManageLayout = this.Q;
        if (qFSMultiGuideBtnManageLayout != null) {
            qFSMultiGuideBtnManageLayout.setOnSelectedListener(new e());
        }
    }

    private void J1(e30.b bVar) {
        int i3 = 0;
        if (!uq3.n.c(System.currentTimeMillis(), uq3.k.a().f("sp_key_feed_positive_feedback_guide_follow_show_timestamp" + v1(), 0L))) {
            QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[sendReq] is not the same day");
            uq3.k.a().m("sp_key_feed_positive_feedback_guide_follow_showed_times" + v1(), 0);
        }
        int e16 = uq3.k.a().e("sp_key_feed_positive_feedback_guide_follow_showed_times" + v1(), 0);
        QLog.i("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[sendReq] showedTimes = " + e16);
        QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[sendReq] requestFeedBottomPositiveFeedbackGuildData. feed id = " + t1());
        FeedCloudMeta$StFeed g16 = bVar.g();
        t40.c cVar = this.W;
        if (cVar != null) {
            i3 = cVar.getFeedSourceType();
        }
        final QFSGetFeedBottomPositiveFeedbackGuildFollowRequest qFSGetFeedBottomPositiveFeedbackGuildFollowRequest = new QFSGetFeedBottomPositiveFeedbackGuildFollowRequest(g16, e16, i3);
        VSNetworkHelper.getInstance().sendRequest(qFSGetFeedBottomPositiveFeedbackGuildFollowRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.feed.aw
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.F1(qFSGetFeedBottomPositiveFeedbackGuildFollowRequest, baseRequest, z16, j3, str, (FeedCloudRead$StFeedDeatilSecondaryLoadRsp) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void K1(FeedCloudMeta$ButtonInfo feedCloudMeta$ButtonInfo) {
        FeedCloudWidget$StButtonGroup feedCloudWidget$StButtonGroup;
        if (feedCloudMeta$ButtonInfo != null && (feedCloudWidget$StButtonGroup = feedCloudMeta$ButtonInfo.buttons) != null) {
            FeedCloudWidget$StButtonGroup feedCloudWidget$StButtonGroup2 = feedCloudWidget$StButtonGroup.get();
            this.R = feedCloudWidget$StButtonGroup2;
            if (RFSafeListUtils.isEmpty(feedCloudWidget$StButtonGroup2.buttons.get())) {
                QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[showGuideFollowView] multiBtnData is empty");
                return;
            }
            G1(this.C);
            QFSMultiGuideBtnManageLayout qFSMultiGuideBtnManageLayout = this.Q;
            if (qFSMultiGuideBtnManageLayout == null) {
                QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[showGuideFollowView] mMultiButtonLayout is null");
                return;
            }
            qFSMultiGuideBtnManageLayout.setData((FeedCloudMeta$StFeed) this.f85017h, this.R, this.I);
            this.Q.setInfoViewTop(this.J);
            this.Q.setBottomBannerViewGroup(this.K);
            QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[showGuideFollowView] feed id: " + t1());
            View s16 = s1(this.K);
            this.P = s16;
            if (s16 == null) {
                QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[showGuideFollowView] only startAnimation");
                I1();
                return;
            } else {
                QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[showGuideFollowView] show exchange animation");
                B1();
                return;
            }
        }
        QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[showGuideFollowView] multiBtnData should not be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L1(boolean z16) {
        int i3;
        QFSMultiGuideBtnManageLayout qFSMultiGuideBtnManageLayout = this.Q;
        int i16 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        N1(qFSMultiGuideBtnManageLayout, i3);
        LinearLayout linearLayout = this.K;
        if (!z16) {
            i16 = 8;
        }
        N1(linearLayout, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M1() {
        uq3.k.a().n("sp_key_feed_positive_feedback_guide_follow_show_timestamp" + v1(), System.currentTimeMillis());
        int e16 = uq3.k.a().e("sp_key_feed_positive_feedback_guide_follow_showed_times" + v1(), 0);
        QLog.i("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[doFrequencyControlRecord] showed times:" + e16);
        uq3.k.a().m("sp_key_feed_positive_feedback_guide_follow_showed_times" + v1(), e16 + 1);
        RFWThreadManager.getUIHandler().removeCallbacks(this.Y);
        RFWThreadManager.getUIHandler().postDelayed(this.Y, 5000L);
    }

    private void N1(View view, int i3) {
        if (view == null) {
            QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[updateViewVisible] view is null");
        } else if (view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    private boolean q1(com.tencent.biz.qqcircle.immersive.feed.event.an anVar, int i3) {
        if (anVar != null && i3 < (anVar.f() * anVar.d()) + anVar.e()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1(int i3) {
        this.S = true;
        QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[onSelect] type = " + i3 + ", isDoActioned = " + this.S);
        if (i3 == 3) {
            y1();
        }
    }

    private View s1(View view) {
        if (view != null && (view instanceof ViewGroup)) {
            int i3 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i3 >= viewGroup.getChildCount()) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i3);
                if (!(childAt instanceof ViewStub) && !(childAt instanceof QFSMultiGuideBtnManageLayout)) {
                    View childAt2 = viewGroup.getChildAt(i3);
                    QLog.i("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[findOtherBannerView] childView =" + childAt2);
                    if (childAt2 != null && childAt2.getVisibility() == 0) {
                        QLog.i("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[findOtherBannerView] childView is visible");
                        return childAt2;
                    }
                    QLog.i("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[findOtherBannerView] childView is not visible");
                }
                i3++;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String t1() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return "null";
        }
        return ((FeedCloudMeta$StFeed) t16).f398449id.get();
    }

    private int u1() {
        if (this.X == -1) {
            String b16 = com.tencent.biz.qqcircle.utils.l.b("exp_xsj_gzh_feeds_follow");
            if (TextUtils.equals(b16, "exp_xsj_gzh_feeds_follow_A")) {
                this.X = 0;
            } else if (TextUtils.equals(b16, "exp_xsj_gzh_feeds_follow_B")) {
                this.X = 5000;
            } else if (TextUtils.equals(b16, "exp_xsj_gzh_feeds_follow_C")) {
                this.X = 10000;
            }
        }
        return this.X;
    }

    private String v1() {
        if (E1()) {
            return "pg_xsj_gzh_page";
        }
        return QCircleDaTongConstant.PageId.PG_XSJ_LAYER_PAGE;
    }

    private void w1(QFSLikeStateChangeEvent qFSLikeStateChangeEvent) {
        if (qFSLikeStateChangeEvent != null && qFSLikeStateChangeEvent.getIsLike()) {
            if (!TextUtils.equals(qFSLikeStateChangeEvent.getFeedId(), t1())) {
                QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[handleAfterLikeEvent] is not the same feed. event.getFeedId() = " + qFSLikeStateChangeEvent.getFeedId() + ", getFeedId() = " + t1());
                return;
            }
            if (this.V) {
                QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[handleAfterLikeEvent] has sent request.");
            } else {
                if (E1() && u1() == 0) {
                    return;
                }
                com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
            }
        }
    }

    private void x1(@NonNull QFSDoublePraiseEvent qFSDoublePraiseEvent) {
        if (!TextUtils.equals(qFSDoublePraiseEvent.getFeedId(), t1())) {
            QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[handleDoublePraiseEvent] is not the same feed. event.getFeedId() = " + qFSDoublePraiseEvent.getFeedId() + ", getFeedId() = " + t1());
            return;
        }
        if (this.V) {
            QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[handleDoublePraiseEvent] has sent request.");
        } else {
            com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y1() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            QLog.e("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "do follow but feed is null");
        } else {
            T0(new com.tencent.biz.qqcircle.immersive.feed.event.m(((FeedCloudMeta$StFeed) t16).f398449id.get()));
        }
    }

    private void z1(com.tencent.biz.qqcircle.immersive.feed.event.an anVar) {
        if (E1() && !this.V) {
            int u16 = u1();
            if (u16 > 0 && q1(anVar, u16)) {
                com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
                return;
            }
            return;
        }
        if (anVar != null && anVar.d() == 1 && !this.V) {
            com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.an) {
            z1((com.tencent.biz.qqcircle.immersive.feed.event.an) hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: H1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (this.W == null) {
            this.W = (t40.c) u0(t40.c.class);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSSendFollowedReqEvent.class);
        eventClass.add(QFSLikeStateChangeEvent.class);
        eventClass.add(QFSDoublePraiseEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 100;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        this.V = true;
        return C1(this.E);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        J1(this.E);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        L1(false);
        QFSMultiGuideBtnManageLayout qFSMultiGuideBtnManageLayout = this.Q;
        if (qFSMultiGuideBtnManageLayout != null) {
            qFSMultiGuideBtnManageLayout.setTranslationY(0.0f);
        }
        View view = this.P;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
        this.P = null;
        this.U = null;
        this.S = false;
        this.V = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        RFWThreadManager.getUIHandler().removeCallbacks(this.Y);
        QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[onFeedUnSelected] mMultiButtonLayout =" + this.Q + ", mOtherBannerView = " + this.P);
        com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement((IOrderElement) this, false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSendFollowedReqEvent) {
            A1((QFSSendFollowedReqEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSLikeStateChangeEvent) {
            w1((QFSLikeStateChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSDoublePraiseEvent) {
            x1((QFSDoublePraiseEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildPositiveFeedbackGuideFollowPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[hideOtherAndStartShowBottomGuideFollowAnimation] onAnimationEnd");
            QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.M1();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.L1(true);
            if (QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.Q != null) {
                QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[hideOtherAndStartShowBottomGuideFollowAnimation] onAnimationStart.before. mMultiButtonLayout.getTranslationY = " + QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.Q.getTranslationY() + "\uff0c mMultiButtonLayout.getY = " + QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.Q.getY() + "\uff0c mMultiButtonLayout.getVisibility = " + QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.Q.getVisibility() + "\uff0c mMultiButtonLayout.getAlpha = " + QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.Q.getAlpha());
                QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.Q.setAlpha(1.0f);
                QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.Q.setTranslationY((float) DisplayUtil.dip2px(QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.m0(), 32.0f));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("QFSFeedChildPositiveFeedbackGuideFollowPresenter", 1, "[onlyShowBottomGuideFollowAnimation] onAnimationEnd");
            QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.M1();
            QFSFeedChildPositiveFeedbackGuideFollowPresenter.this.L1(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
