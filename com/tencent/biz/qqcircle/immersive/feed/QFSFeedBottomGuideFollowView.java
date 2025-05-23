package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSSendFollowedReqEvent;
import com.tencent.biz.qqcircle.widgets.QFSMultiGuideBtnManageLayout;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StGuideInfo;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudWidget$StButton;
import feedcloud.FeedCloudWidget$StButtonGroup;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto$StButton;
import qqcircle.QQCircleDitto$StButtonGroup;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedBottomGuideFollowView extends com.tencent.biz.qqcircle.immersive.views.banner.bottom.c implements SimpleEventReceiver {
    private View D;
    private View E;
    private QFSMultiGuideBtnManageLayout F;
    private QCircleInitBean G;
    private List<QQCircleDitto$StButton> H;
    private QQCircleDitto$StButtonGroup I;
    private boolean J;
    private FeedCloudWidget$StButtonGroup K;
    private List<FeedCloudWidget$StButton> L;
    private boolean M;
    private Runnable N;
    private boolean P;
    private String Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements QFSMultiGuideBtnManageLayout.m {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSMultiGuideBtnManageLayout.m
        public void a(int i3) {
            QLog.d("QFSFeedBottomGuideFollowView", 1, "[onSelect] type = " + i3);
            QFSFeedBottomGuideFollowView.this.J = true;
            if (i3 == 3) {
                QFSFeedBottomGuideFollowView.this.F();
            } else if (i3 == 4 && QFSFeedBottomGuideFollowView.this.o() != null && QFSFeedBottomGuideFollowView.this.o().getInitBean() != null && QFSFeedBottomGuideFollowView.this.o().getInitBean().getExtraTypeInfo() != null && QFSFeedBottomGuideFollowView.this.o().getInitBean().getExtraTypeInfo().sourceType == 20101) {
                QFSFeedBottomGuideFollowView qFSFeedBottomGuideFollowView = QFSFeedBottomGuideFollowView.this;
                qFSFeedBottomGuideFollowView.K(5000, 55011, qFSFeedBottomGuideFollowView.k());
                com.tencent.biz.qqcircle.immersive.personal.data.w wVar = new com.tencent.biz.qqcircle.immersive.personal.data.w(QFSFeedBottomGuideFollowView.this.Q);
                wVar.K();
                wVar.H();
                wVar.R();
            }
            QFSFeedBottomGuideFollowView.this.F.s(i3);
        }
    }

    public QFSFeedBottomGuideFollowView(@NonNull com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
        this.H = new ArrayList();
        this.L = new ArrayList();
        this.M = false;
    }

    private void D() {
        if (this.N != null) {
            QLog.d("QFSFeedBottomGuideFollowView", 1, "[cancelShowRunnable] remove mFolderPageShowMultiBtnRunnable");
            n().removeCallbacks(this.N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        int e16 = uq3.k.a().e(this.Q + "sp_key_follow_button_group_display_count_author", 0);
        if (e16 == 0) {
            uq3.k.a().n(this.Q + "sp_key_follow_button_group_display_timestamp", System.currentTimeMillis());
        }
        uq3.k.a().m(this.Q + "sp_key_follow_button_group_display_count_author", e16 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSFeedBottomGuideFollowView", 1, "do follow but feed is null");
        } else {
            s(new com.tencent.biz.qqcircle.immersive.feed.event.m(feedCloudMeta$StFeed.f398449id.get()));
        }
    }

    private void H(QFSSendFollowedReqEvent qFSSendFollowedReqEvent) {
        if (this.F != null && qFSSendFollowedReqEvent != null) {
            if (!TextUtils.equals(qFSSendFollowedReqEvent.getFeedId(), l())) {
                QLog.e("QFSFeedBottomGuideFollowView", 1, "[handleSelectedFollowEvent] is not the same feed. event.getFeedId() = " + qFSSendFollowedReqEvent.getFeedId() + ", getFeedId() = " + l());
                return;
            }
            QLog.d("QFSFeedBottomGuideFollowView", 1, "[handleSelectedFollowEvent]");
            this.F.s(3);
        }
    }

    private boolean I() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        if (!QCirclePluginUtil.isFollow(feedCloudMeta$StFeed.poster) && !QCirclePluginUtil.isOwner(this.f90602e.poster) && !QCircleFollowManager.getInstance().isUinFollowed(this.f90602e.poster.f398463id.get())) {
            return false;
        }
        return true;
    }

    private void J(@NonNull View view) {
        this.F = (QFSMultiGuideBtnManageLayout) view.findViewById(R.id.ype);
        this.D = view.findViewById(R.id.f34510zc);
        this.E = view.findViewById(R.id.f39941d1);
        this.N = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedBottomGuideFollowView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QFSFeedBottomGuideFollowView.this.F != null && QFSFeedBottomGuideFollowView.this.F.getVisibility() == 0) {
                    QLog.d("QFSFeedBottomGuideFollowView", 1, "[mFolderPageShowMultiBtnRunnable] guide follow is showing");
                } else {
                    QLog.d("QFSFeedBottomGuideFollowView", 1, "[mFolderPageShowMultiBtnRunnable] folder tab. startAnimation");
                    QFSFeedBottomGuideFollowView.this.N();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i3, int i16, QCircleExtraTypeInfo qCircleExtraTypeInfo) {
        if (qCircleExtraTypeInfo != null && qCircleExtraTypeInfo.mFeed != null && p() != null) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(qCircleExtraTypeInfo.mFeed));
            dataBuilder.setActionType(i3).setSubActionType(i16).setToUin(qCircleExtraTypeInfo.mFeed.poster.f398463id.get()).setPosition(qCircleExtraTypeInfo.mDataPosition).setPlayScene(qCircleExtraTypeInfo.mPlayScene).setPageId(p().getPageId()).setfpageid(Integer.valueOf(p().getFromPageId()).intValue()).setFirstFeedId(w20.a.j().h());
            QCircleLpReportDc05507.report(dataBuilder);
            return;
        }
        RFWLog.e("QCircleReportHelper_QFSFeedBottomGuideFollowView", RFWLog.USR, "extraTypeInfo is null or lost feed,actionType:" + i3 + ",subActionType:" + i16);
    }

    private void L() {
        PBRepeatMessageField<FeedCloudMeta$StGuideInfo> pBRepeatMessageField;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && (pBRepeatMessageField = feedCloudMeta$StFeed.guideInfos) != null && pBRepeatMessageField.size() >= 1) {
            FeedCloudWidget$StButtonGroup feedCloudWidget$StButtonGroup = this.f90602e.guideInfos.get(0).btmSubInfo.buttons.get();
            this.K = feedCloudWidget$StButtonGroup;
            if (feedCloudWidget$StButtonGroup == null) {
                QLog.e("QFSFeedBottomGuideFollowView", 1, "[showFolderPageGuideFollowView] mStButtonGroup should not be null");
                return;
            }
            List<FeedCloudWidget$StButton> list = feedCloudWidget$StButtonGroup.buttons.get();
            this.L = list;
            if (RFSafeListUtils.isEmpty(list)) {
                QLog.e("QFSFeedBottomGuideFollowView", 1, "[showFolderPageGuideFollowView] multiBtnData is empty");
                return;
            }
            this.F.setData(this.f90602e, this.K, this.D);
            this.F.setInfoViewTop(this.E);
            QLog.d("QFSFeedBottomGuideFollowView", 1, "[showFolderPageGuideFollowView] updateMultiButtonLayout() before,isFolderPageShowMultiBtn = " + this.M);
            O();
            return;
        }
        QLog.e("QFSFeedBottomGuideFollowView", 1, "[showFolderPageGuideFollowView] folder tab. feed btn data should not be null");
    }

    private void M() {
        if (o().getInitBean().getExtraTypeInfo().sourceType != 20101) {
            QLog.d("QFSFeedBottomGuideFollowView", 1, "[showLayerPageGuideFollowView] the page is not personal product tab");
            return;
        }
        QQCircleDitto$StButtonGroup b16 = com.tencent.biz.qqcircle.immersive.utils.ak.a().b();
        this.I = b16;
        if (b16 == null) {
            QLog.e("QFSFeedBottomGuideFollowView", 1, "[showLayerPageGuideFollowView] mStButtonGroup should not be null");
            return;
        }
        List<QQCircleDitto$StButton> list = b16.buttons.get();
        this.H = list;
        if (RFSafeListUtils.isEmpty(list)) {
            QLog.e("QFSFeedBottomGuideFollowView", 1, "[showLayerPageGuideFollowView] multiBtnData is empty");
            return;
        }
        this.F.setData(this.f90602e, this.I, this.D);
        this.F.setInfoViewTop(this.E);
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.F, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(250L);
        ofFloat.setStartDelay(80L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.D, "translationY", DisplayUtil.dip2px(j(), 42.0f), 0.0f);
        ofFloat2.setDuration(250L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.E, "translationY", DisplayUtil.dip2px(j(), 42.0f), 0.0f);
        ofFloat3.setDuration(250L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(330L);
        animatorSet.playTogether(ofFloat2, ofFloat3, ofFloat);
        animatorSet.start();
        animatorSet.addListener(new a());
        Q(this.F, 4);
    }

    private void O() {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed.poster) != null && this.F != null) {
            this.Q = feedCloudMeta$StUser.f398463id.get();
            QCircleInitBean qCircleInitBean = this.G;
            if (qCircleInitBean instanceof QCircleFolderBean) {
                this.M = true;
                if (!com.tencent.biz.qqcircle.immersive.utils.ak.a().c(this.f90601d)) {
                    D();
                    n().postDelayed(this.N, 3000L);
                    QLog.d("QFSFeedBottomGuideFollowView", 1, "[updateMultiButtonLayout] postDelayed runnable");
                } else {
                    P(true);
                    QLog.d("QFSFeedBottomGuideFollowView", 1, "[updateMultiButtonLayout] show right now");
                }
            } else if (qCircleInitBean instanceof QCircleLayerBean) {
                P(true);
                this.P = true;
            }
            this.F.setOnSelectedListener(new b());
            return;
        }
        QLog.d("QFSFeedBottomGuideFollowView", 1, "[updateMultiButtonLayout] mFeed should not be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(boolean z16) {
        int i3;
        QFSMultiGuideBtnManageLayout qFSMultiGuideBtnManageLayout = this.F;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        Q(qFSMultiGuideBtnManageLayout, i3);
    }

    private void Q(View view, int i3) {
        if (view == null) {
            QLog.e("QFSFeedBottomGuideFollowView", 1, "[updateViewVisible] view is null");
        } else if (view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    public void G(QFSSeekEvent qFSSeekEvent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), qFSSeekEvent.mFeedId) && this.M && !qFSSeekEvent.mIsOnSeek && this.P) {
            QLog.d("QFSFeedBottomGuideFollowView", 1, "[handleSeekEvent] after seek, show guide follow view");
            P(true);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList getEventClass() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QFSSendFollowedReqEvent.class);
        arrayList.add(QFSSeekEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 113;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(e30.b bVar, int i3) {
        super.h(bVar, i3);
        if (this.f90601d == null) {
            QLog.d("QFSFeedBottomGuideFollowView", 1, "[onBindData] mFeedBlockData should not be null");
        } else {
            com.tencent.biz.qqcircle.immersive.utils.ak.a().i(this.f90601d.g());
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (com.tencent.biz.qqcircle.helpers.d.a(1, false)) {
            QLog.d("QFSFeedBottomGuideFollowView", 1, "[isElementCanActivate] forbid follow because of sencebeat");
            return false;
        }
        if (I()) {
            QLog.d("QFSFeedBottomGuideFollowView", 1, "[isElementCanActivate] is Followed");
            return false;
        }
        if (this.J) {
            QLog.d("QFSFeedBottomGuideFollowView", 1, "[isElementCanActivate] isDoActioned");
            return false;
        }
        QCircleExtraTypeInfo k3 = k();
        if (k3 != null && o() != null && com.tencent.biz.qqcircle.immersive.utils.ak.a().e(this.f90601d, k3.sourceType, o().getInitBean())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        J(this.f90604h);
        QLog.d("QFSFeedBottomGuideFollowView", 1, "[onElementActivated] feed id: " + l());
        if (this.f90602e != null && !I()) {
            if (o() == null) {
                QLog.d("QFSFeedBottomGuideFollowView", 1, "[onElementActivated] feed ioc should not be null.");
                return;
            }
            QCircleInitBean initBean = o().getInitBean();
            this.G = initBean;
            if (initBean instanceof QCircleFolderBean) {
                QLog.d("QFSFeedBottomGuideFollowView", 2, "[onElementActivated] QCircleFolderBean");
                L();
                return;
            } else {
                if (initBean instanceof QCircleLayerBean) {
                    QLog.d("QFSFeedBottomGuideFollowView", 2, "[onElementActivated] QCircleLayerBean");
                    M();
                    return;
                }
                return;
            }
        }
        QLog.d("QFSFeedBottomGuideFollowView", 1, "[onElementActivated] is Followed");
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        D();
        P(false);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSendFollowedReqEvent) {
            H((QFSSendFollowedReqEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSSeekEvent) {
            G((QFSSeekEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
        SimpleEventBus.getInstance().registerReceiver(this);
        P(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        D();
        QCircleInitBean qCircleInitBean = this.G;
        if (qCircleInitBean != null && (qCircleInitBean instanceof QCircleFolderBean)) {
            QLog.d("QFSFeedBottomGuideFollowView", 1, "[onDetached] folder page multi btn. mIsShowed =" + this.P);
            this.M = false;
        }
        if (this.P) {
            com.tencent.biz.qqcircle.immersive.utils.ak.a().h(this.f90601d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QLog.d("QFSFeedBottomGuideFollowView", 1, "animatorSet onAnimationCancel");
            QFSFeedBottomGuideFollowView.this.P(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("QFSFeedBottomGuideFollowView", 1, "animatorSet onAnimationEnd");
            QFSFeedBottomGuideFollowView.this.P(true);
            QFSFeedBottomGuideFollowView.this.P = true;
            QFSFeedBottomGuideFollowView qFSFeedBottomGuideFollowView = QFSFeedBottomGuideFollowView.this;
            qFSFeedBottomGuideFollowView.K(5010, 55000, qFSFeedBottomGuideFollowView.k());
            QFSFeedBottomGuideFollowView.this.E();
            com.tencent.biz.qqcircle.immersive.utils.ak.a().g(((com.tencent.biz.qqcircle.immersive.views.banner.bottom.c) QFSFeedBottomGuideFollowView.this).f90601d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
