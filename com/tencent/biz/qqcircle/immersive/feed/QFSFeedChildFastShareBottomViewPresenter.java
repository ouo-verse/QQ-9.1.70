package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostChatHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.QFSFastShareUserInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSLikeStateChangeEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSShowFastShareHintEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSDoublePraiseEvent;
import com.tencent.biz.qqcircle.manager.g;
import com.tencent.biz.qqcircle.widgets.RoundFrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSFeedChildFastShareBottomViewPresenter extends ao implements View.OnClickListener {
    private RoundFrameLayout M;
    private TextView N;
    private FrameLayout P;
    private ImageView Q;
    private TextView R;
    private View S;
    private Runnable T;
    private QFSFastShareUserInfo U;
    private boolean V;
    private com.tencent.biz.qqcircle.manager.g W;
    private View X;

    /* JADX WARN: Multi-variable type inference failed */
    private void A1() {
        T t16 = this.f85017h;
        if (t16 != 0 && this.U != null) {
            QCircleShareInfo c16 = com.tencent.biz.qqcircle.immersive.utils.au.c((FeedCloudMeta$StFeed) t16);
            c16.feed = (FeedCloudMeta$StFeed) this.f85017h;
            c16.silentShareType = 2;
            c16.mShareUin = F1();
            c16.mShareUinType = this.U.getType();
            c16.mShareUinName = this.U.getDisplayName();
            c16.mNeedShowShareDialog = false;
            s0().onHandlerMessage("event_silent_share", c16);
            String transferShareInfoToString = QFSFastShareUserInfo.transferShareInfoToString(new QFSFastShareUserInfo(this.U.getDisplayName(), F1(), this.U.getType()));
            if (!TextUtils.isEmpty(transferShareInfoToString)) {
                uq3.k.a().p(QFSFastShareUserInfo.SP_KEY_FAST_SHARE_USER_INFO, transferShareInfoToString);
            }
        }
    }

    private View B1() {
        if (this.K == null) {
            return null;
        }
        for (int i3 = 0; i3 < this.K.getChildCount(); i3++) {
            View childAt = this.K.getChildAt(i3);
            if (!(childAt instanceof ViewStub) && childAt.getId() != R.id.f3736172) {
                QLog.i("QFSFeedChildFastShareBottomViewPresenter", 1, "[findOtherBannerView] childView =" + childAt);
                if (childAt.getVisibility() == 0) {
                    QLog.i("QFSFeedChildFastShareBottomViewPresenter", 1, "[findOtherBannerView] childView is visible");
                    return childAt;
                }
                QLog.i("QFSFeedChildFastShareBottomViewPresenter", 1, "[findOtherBannerView] childView is not visible");
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String C1() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return "";
        }
        return ((FeedCloudMeta$StFeed) t16).f398449id.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String D1() {
        QFSFastShareUserInfo qFSFastShareUserInfo = this.U;
        if (qFSFastShareUserInfo != null && qFSFastShareUserInfo.getType() == 10008) {
            return QCircleDaTongConstant.ElementId.EM_XSJ_SHARE_SEND_TOAST;
        }
        return QCircleDaTongConstant.ElementId.EM_XSJ_QUICK_SHARE_FEEDBACK_GUIDE_PANEL;
    }

    private String E1() {
        QFSFastShareUserInfo qFSFastShareUserInfo = this.U;
        if (qFSFastShareUserInfo == null) {
            return "";
        }
        return qFSFastShareUserInfo.getDisplayName();
    }

    private String F1() {
        QFSFastShareUserInfo qFSFastShareUserInfo = this.U;
        if (qFSFastShareUserInfo == null) {
            return "";
        }
        return qFSFastShareUserInfo.getUin();
    }

    private void G1(QFSLikeStateChangeEvent qFSLikeStateChangeEvent) {
        if (TextUtils.equals(qFSLikeStateChangeEvent.getFeedId(), C1()) && qFSLikeStateChangeEvent.getIsLike()) {
            I1();
        }
    }

    private void H1(QFSDoublePraiseEvent qFSDoublePraiseEvent) {
        if (!TextUtils.equals(qFSDoublePraiseEvent.getFeedId(), C1())) {
            return;
        }
        I1();
    }

    private void I1() {
        if (this.V) {
            return;
        }
        this.V = true;
        com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void J1(QFSShowFastShareHintEvent qFSShowFastShareHintEvent) {
        if (this.f85017h != 0 && qFSShowFastShareHintEvent.getFeedId().equals(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get())) {
            this.U = qFSShowFastShareHintEvent.getFastShareUserInfo();
            T1();
        }
    }

    private void K1() {
        this.V = false;
        Q1(this.M, false);
        Q1(this.K, false);
        RoundFrameLayout roundFrameLayout = this.M;
        if (roundFrameLayout != null) {
            roundFrameLayout.setTranslationY(0.0f);
        }
        View view = this.X;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
        this.X = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L1(boolean z16) {
        FrameLayout frameLayout = this.P;
        if (frameLayout == null) {
            return;
        }
        if (!z16) {
            Q1(frameLayout, false);
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(240L);
        ofFloat.addListener(new b());
        ofFloat.start();
    }

    private void M1() {
        ViewStub viewStub;
        if (this.M != null || (viewStub = (ViewStub) this.C.findViewById(R.id.f3738174)) == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.M = (RoundFrameLayout) inflate.findViewById(R.id.f3736172);
        this.N = (TextView) inflate.findViewById(R.id.f3737173);
        this.M.setOnClickListener(this);
    }

    private void N1() {
        ViewStub viewStub;
        if (this.P != null || (viewStub = (ViewStub) this.C.findViewById(R.id.f39791cm)) == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.P = (FrameLayout) inflate.findViewById(R.id.f39771ck);
        this.Q = (ImageView) inflate.findViewById(R.id.f39761cj);
        this.R = (TextView) inflate.findViewById(R.id.f39801cn);
        View findViewById = inflate.findViewById(R.id.f39781cl);
        this.S = findViewById;
        findViewById.setOnClickListener(this);
    }

    private boolean O1() {
        QFSFastShareUserInfo qFSFastShareUserInfo = this.U;
        if (qFSFastShareUserInfo == null || qFSFastShareUserInfo.getType() != 1) {
            return false;
        }
        return true;
    }

    private void P1() {
        QFSFastShareUserInfo qFSFastShareUserInfo = this.U;
        String str = "";
        if (qFSFastShareUserInfo != null && qFSFastShareUserInfo.getType() == 10008) {
            Bundle bundle = new Bundle();
            if (QCirclePluginUtil.isFriend(this.U.getUin())) {
                bundle.putInt(QCircleHostConstants.AppConstants.Key.UIN_TYPE(), QCircleHostConstants.AppConstants.Value.UIN_TYPE_FRIEND());
            } else {
                bundle.putBoolean(HostChatUtils.QCIRCLE_CHAT_HIDE_MENU_KEY(), true);
                bundle.putInt(QCircleHostConstants.AppConstants.Key.UIN_TYPE(), QCircleHostConstants.AppConstants.Value.UIN_TYPE_TEMP_CIRCLE());
            }
            bundle.putInt(QCircleHostConstants._ChatActivityConstants.KEY_AIO_MSG_SOURCE(), QCircleHostConstants._ChatActivityConstants.TYPE_DETAIL_MSG_REMIND());
            bundle.putBoolean(HostChatUtils.getQCircleFromPersonalPageKey(), false);
            String buddyName = HostDataTransUtils.getBuddyName(this.U.getUin(), true);
            if (buddyName.equals(this.U.getUin())) {
                if (this.U.getUin().equals(this.U.getDisplayName())) {
                    buddyName = "";
                } else {
                    buddyName = this.U.getDisplayName();
                }
            }
            String UIN_NAME = QCircleHostConstants.AppConstants.Key.UIN_NAME();
            if (buddyName != null) {
                str = buddyName;
            }
            bundle.putString(UIN_NAME, str);
            QCircleHostChatHelper.jumpPrivateChat(m0(), this.U.getDisplayName(), "", this.U.getUin(), bundle, false);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt(QCircleHostConstants.AppConstants.Key.UIN_TYPE(), O1() ? 1 : 0);
        bundle2.putBoolean(HostChatUtils.getQCircleFromPersonalPageKey(), false);
        if (O1()) {
            str = F1();
        }
        QCircleHostChatHelper.jumpPrivateChat(m0(), E1(), str, F1(), bundle2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q1(View view, boolean z16) {
        int i3;
        if (view == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R1(boolean z16) {
        M1();
        Q1(this.M, false);
        U1();
        com.tencent.biz.qqcircle.manager.g.u(this.f85018i);
        if (!z16 && this.K != null) {
            QLog.d("QFSFeedChildFastShareBottomViewPresenter", 1, "no need anim and show.");
            Q1(this.K, true);
            Q1(this.M, true);
        } else {
            z1(this.M, QCircleDaTongConstant.ElementId.EM_XSJ_QUICK_SHARE_GUIDE_PANEL);
            View B1 = B1();
            this.X = B1;
            h1(this.M, B1, new a());
        }
    }

    private void S1() {
        FrameLayout frameLayout = this.P;
        if (frameLayout == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, "translationY", com.tencent.biz.qqcircle.utils.cx.a(64.0f), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.P, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(280L);
        ofFloat2.setDuration(240L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildFastShareBottomViewPresenter.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (QFSFeedChildFastShareBottomViewPresenter.this.T == null) {
                    QFSFeedChildFastShareBottomViewPresenter.this.T = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildFastShareBottomViewPresenter.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QFSFeedChildFastShareBottomViewPresenter.this.L1(true);
                        }
                    };
                }
                QFSFeedChildFastShareBottomViewPresenter.this.x0().postDelayed(QFSFeedChildFastShareBottomViewPresenter.this.T, 3000L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                QFSFeedChildFastShareBottomViewPresenter qFSFeedChildFastShareBottomViewPresenter = QFSFeedChildFastShareBottomViewPresenter.this;
                qFSFeedChildFastShareBottomViewPresenter.Q1(qFSFeedChildFastShareBottomViewPresenter.P, true);
                QFSFeedChildFastShareBottomViewPresenter qFSFeedChildFastShareBottomViewPresenter2 = QFSFeedChildFastShareBottomViewPresenter.this;
                qFSFeedChildFastShareBottomViewPresenter2.z1(qFSFeedChildFastShareBottomViewPresenter2.S, QFSFeedChildFastShareBottomViewPresenter.this.D1());
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
    }

    private void T1() {
        N1();
        V1();
        S1();
    }

    private void U1() {
        String str;
        if (this.U == null) {
            return;
        }
        if (O1()) {
            str = com.tencent.biz.qqcircle.utils.h.a(R.string.f195724fd) + " " + this.U.getDisplayName();
        } else {
            str = com.tencent.biz.qqcircle.utils.h.a(R.string.f195734fe) + " @" + this.U.getDisplayName();
        }
        TextView textView = this.N;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void V1() {
        Drawable p16;
        String str;
        if (this.U == null) {
            return;
        }
        if (O1()) {
            p16 = QCirclePluginGlobalInfo.q(F1(), 4);
            str = com.tencent.biz.qqcircle.utils.h.a(R.string.f195724fd) + this.U.getDisplayName();
        } else {
            p16 = QCirclePluginGlobalInfo.p(F1());
            str = com.tencent.biz.qqcircle.utils.h.a(R.string.f1909343f) + this.U.getDisplayName();
        }
        this.R.setText(str);
        this.Q.setImageDrawable(p16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1(final QFSFastShareUserInfo qFSFastShareUserInfo) {
        x0().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildFastShareBottomViewPresenter.5
            @Override // java.lang.Runnable
            public void run() {
                QFSFastShareUserInfo qFSFastShareUserInfo2 = qFSFastShareUserInfo;
                if (qFSFastShareUserInfo2 != null) {
                    QFSFeedChildFastShareBottomViewPresenter.this.U = qFSFastShareUserInfo2;
                    QFSFeedChildFastShareBottomViewPresenter.this.R1(true);
                } else {
                    com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement((IOrderElement) QFSFeedChildFastShareBottomViewPresenter.this, true);
                }
            }
        });
    }

    private boolean y1() {
        if (!r0().equals("pg_xsj_explore_page") || !this.V || g1() || !com.tencent.biz.qqcircle.manager.g.d(this.f85018i)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1(View view, String str) {
        e30.b bVar;
        String uin;
        String str2;
        if (view != null && (bVar = this.E) != null && bVar.g() != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(this.E));
            QFSFastShareUserInfo qFSFastShareUserInfo = this.U;
            if (qFSFastShareUserInfo == null) {
                uin = "";
            } else {
                uin = qFSFastShareUserInfo.getUin();
            }
            buildElementParams.put("xsj_target_qq", uin);
            if (O1()) {
                str2 = "2";
            } else {
                str2 = "1";
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHARE_TARGET_TYPE, str2);
            VideoReport.setElementId(view, str);
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.setElementReuseIdentifier(view, str + this.E.g().f398449id.get());
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSLikeStateChangeEvent.class);
        eventClass.add(QFSDoublePraiseEvent.class);
        eventClass.add(QFSShowFastShareHintEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 101;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return y1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f3736172) {
            if (com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
                QLog.d("QFSFeedChildFastShareBottomViewPresenter", 1, "[onclick] forbid fast share because of sencebeat");
            } else {
                K1();
                A1();
                T1();
            }
        } else if (id5 == R.id.f39781cl) {
            x0().removeCallbacks(this.T);
            P1();
            L1(false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildFastShareBottomViewPresenter.4

            /* renamed from: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildFastShareBottomViewPresenter$4$a */
            /* loaded from: classes4.dex */
            class a implements g.a {
                a() {
                }

                @Override // com.tencent.biz.qqcircle.manager.g.a
                public void a(QFSFastShareUserInfo qFSFastShareUserInfo) {
                    QFSFeedChildFastShareBottomViewPresenter.this.x1(qFSFastShareUserInfo);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QFSFeedChildFastShareBottomViewPresenter.this.W = new com.tencent.biz.qqcircle.manager.g(QFSFeedChildFastShareBottomViewPresenter.this.r0());
                QFSFeedChildFastShareBottomViewPresenter.this.W.l(new a());
            }
        });
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        K1();
        L1(false);
        com.tencent.biz.qqcircle.manager.g gVar = this.W;
        if (gVar != null) {
            gVar.t();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        x0().removeCallbacks(this.T);
        com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement((IOrderElement) this, false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSLikeStateChangeEvent) {
            G1((QFSLikeStateChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSDoublePraiseEvent) {
            H1((QFSDoublePraiseEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSShowFastShareHintEvent) {
            J1((QFSShowFastShareHintEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildFastShareBottomViewPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("QFSFeedChildFastShareBottomViewPresenter", 1, "anim finish and show.");
            QFSFeedChildFastShareBottomViewPresenter qFSFeedChildFastShareBottomViewPresenter = QFSFeedChildFastShareBottomViewPresenter.this;
            qFSFeedChildFastShareBottomViewPresenter.Q1(qFSFeedChildFastShareBottomViewPresenter.K, true);
            QFSFeedChildFastShareBottomViewPresenter qFSFeedChildFastShareBottomViewPresenter2 = QFSFeedChildFastShareBottomViewPresenter.this;
            qFSFeedChildFastShareBottomViewPresenter2.Q1(qFSFeedChildFastShareBottomViewPresenter2.M, true);
            VideoReport.traversePage(QFSFeedChildFastShareBottomViewPresenter.this.M);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSFeedChildFastShareBottomViewPresenter qFSFeedChildFastShareBottomViewPresenter = QFSFeedChildFastShareBottomViewPresenter.this;
            qFSFeedChildFastShareBottomViewPresenter.Q1(qFSFeedChildFastShareBottomViewPresenter.P, false);
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
