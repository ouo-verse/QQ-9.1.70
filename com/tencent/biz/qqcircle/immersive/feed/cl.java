package com.tencent.biz.qqcircle.immersive.feed;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSCollectedFeedEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedOrientationChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFollowTabLiveListEvent;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSBarrageInputHelper;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSBarrageInputPopupWindow;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.view.RFWPlayerReuseUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e60.k;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cl extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements k.b {
    private View I;
    private View J;
    private View K;
    private int L;
    private View T;
    private TextView V;
    private QFSVideoView W;
    private boolean Y;
    private boolean M = false;
    private boolean N = false;
    private boolean P = false;
    private boolean Q = false;
    private boolean R = false;
    private boolean S = false;
    private int U = 1;
    private int X = 0;
    private boolean Z = false;

    private boolean A1() {
        boolean I0 = I0();
        boolean isFolderScreenOpenMode = TransitionHelper.isFolderScreenOpenMode(m0());
        boolean k3 = com.tencent.biz.qqcircle.utils.bz.k();
        boolean equals = QCircleDaTongConstant.PageId.PG_XSJ_QZEON_VIDEO_UGC_MID_PAG.equals(q0());
        if (this.Q != I0 || isFolderScreenOpenMode != this.R || k3 != this.S) {
            QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[isNotSupportFullScreenShow] feedId: " + j() + " | isVideoLandScape: " + I0 + " | isFolderScreenOpenMode: " + isFolderScreenOpenMode + " | isAllowLandscape: " + k3 + " | isQZoneMiddlePage" + equals);
            this.Q = I0;
            this.R = isFolderScreenOpenMode;
            this.S = k3;
        }
        if (!I0 || isFolderScreenOpenMode || k3 || equals) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B1() {
        t1(this.T.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C1(View view, Pair pair) {
        k1(view.getContext(), 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void D1(final View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f85017h != 0) {
            if (uq3.o.O0() && z1()) {
                k1(view.getContext(), 0, true);
            } else {
                com.tencent.biz.qqcircle.immersive.utils.bi.q(this.W, (FeedCloudMeta$StFeed) this.f85017h, new bi.a() { // from class: com.tencent.biz.qqcircle.immersive.feed.ck
                    @Override // com.tencent.biz.qqcircle.immersive.utils.bi.a
                    public final void a(Pair pair) {
                        cl.this.C1(view, pair);
                    }
                });
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void E1(View view) {
        if (this.I != null) {
            return;
        }
        if (view == null) {
            QLog.e(getTAG(), 1, "[makeSureInflateFullScreenPlayView] rootView is null");
            return;
        }
        View findViewById = view.findViewById(R.id.f42641kb);
        if (findViewById != null && findViewById.getParent() != null) {
            View inflate = ((ViewStub) findViewById).inflate();
            this.I = inflate;
            if (inflate == null) {
                QLog.e(getTAG(), 1, "[makeSureInflateFullScreenPlayView] inflate view is null");
                return;
            }
            this.J = view.findViewById(R.id.f34530ze);
            View findViewById2 = this.I.findViewById(R.id.yo_);
            this.K = findViewById2;
            VideoReport.setElementId(findViewById2, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA_SETTING_BUTTON);
            this.K.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.cj
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    cl.this.D1(view2);
                }
            });
            this.T = view.findViewById(R.id.f34500zb);
            this.V = (TextView) view.findViewById(R.id.f56172jw);
            this.W = (QFSVideoView) view.findViewById(R.id.f74163vi);
            return;
        }
        QLog.e(getTAG(), 1, "[makeSureInflateFullScreenPlayView] view stub is null");
    }

    private void F1(String str, int i3) {
        if (!TextUtils.equals(j(), str)) {
            return;
        }
        QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[handlePanelChangeEvent] isShowing: " + QCirclePanelStateEvent.isAnyPanelShowing() + " | panelType: " + i3 + " | feedId: " + str);
        e60.k.j().t(QCirclePanelStateEvent.isAnyPanelShowing());
    }

    private void H1() {
        View view = this.C;
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.f74163vi);
        View findViewById2 = this.C.findViewById(R.id.v_z);
        if (findViewById != null && findViewById2 != null) {
            N1(findViewById, 0);
            N1(findViewById2, 0);
        }
    }

    private void I1(int i3) {
        View view = this.J;
        if (view == null) {
            QLog.e("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[updateBottomContentMinHeight] mBottomLeftLayoutContent == null.");
            return;
        }
        view.setMinimumHeight(i3);
        QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[updateBottomContentMinHeight] currentMinHeight: " + i3 + " | layout content height: " + this.J.getHeight());
    }

    private int J1(int i3, View view, View view2) {
        int topHeight = (int) (((i3 / 2) - (((i3 + r0) * 0.88f) / 1.88f)) + DisplayUtil.getTopHeight(m0()));
        QLog.w("QOC-QFSFeedFullScreenEntrancePresenter", RFWLog.USR, "bottomMargin: " + topHeight);
        N1(view, topHeight);
        N1(view2, topHeight);
        return topHeight;
    }

    private void K1(int i3) {
        View view = this.C;
        if (view == null) {
            return;
        }
        view.findViewById(R.id.f34520zd).setPadding(0, i3, 0, 0);
    }

    private void L1(boolean z16) {
        boolean z17;
        if (this.I == null) {
            return;
        }
        QCircleReportBean reportBean = getReportBean();
        boolean I0 = I0();
        int i3 = 8;
        if (reportBean != null && TextUtils.equals(reportBean.getDtPageId(), QCircleDaTongConstant.PageId.PG_XSJ_FOLLOWING_PAGE)) {
            Object messageFromPart = ((BasePartFragment) s0().getHostFragment()).getPartManager().getMessageFromPart("qfs_action_top_live_status", null);
            if ((messageFromPart instanceof Boolean) && ((Boolean) messageFromPart).booleanValue()) {
                z17 = true;
            } else {
                z17 = false;
            }
            View view = this.I;
            if (I0 && !z16 && !z17) {
                i3 = 0;
            }
            view.setVisibility(i3);
            QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[setViewStatus] isVideoLandScape: " + I0 + " isOnSeek: " + z16 + " isShowLiveList: " + z17);
            return;
        }
        View view2 = this.I;
        if (I0 && !z16) {
            i3 = 0;
        }
        view2.setVisibility(i3);
        QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[setViewStatus] isVideoLandScape: " + I0 + " isOnSeek: " + z16);
    }

    private void M1() {
        View view;
        boolean A1 = A1();
        if (m0() != null) {
            this.Z = com.tencent.biz.qqcircle.immersive.utils.aa.a(m0().getResources().getConfiguration());
        }
        QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[updateFullScreenViewStatus] mIsActivityInFreeFormMode: " + this.Z + ", isNotSupportFullScreenShow:" + A1);
        if (!A1 && !this.Z) {
            E1(this.C);
        }
        if (this.I != null && this.V != null && this.f85017h != 0 && (view = this.K) != null) {
            if (!A1 && !this.Z) {
                view.setVisibility(0);
                this.V.setVisibility(0);
                K1(com.tencent.biz.qqcircle.utils.cx.a(28.0f));
            } else {
                view.setVisibility(8);
                this.V.setVisibility(8);
                K1(0);
            }
        }
    }

    private void N1(@NonNull View view, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.bottomMargin = i3;
        view.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String j() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return "";
        }
        return ((FeedCloudMeta$StFeed) t16).f398449id.get();
    }

    private void j1() {
        QFSBarrageInputPopupWindow p16 = QFSBarrageInputHelper.r().p();
        if (p16 != null && p16.isShowing()) {
            p16.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void k1(Context context, int i3, boolean z16) {
        l1(!z16 ? 1 : 0);
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setVideoCurrentPosition(this.L);
        qCircleLayerBean.setDataPosInList(this.f85018i);
        qCircleLayerBean.setFeed((FeedCloudMeta$StFeed) this.f85017h);
        qCircleLayerBean.setAVStateController(false);
        qCircleLayerBean.setFromReportBean(getReportBean());
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(m0());
        if (qCircleInitBean != null && qCircleInitBean.getActionBean() != null) {
            qCircleLayerBean.setActionBean(qCircleInitBean.getActionBean());
        }
        QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[enterVideoToFullScreen] mPos: " + this.f85018i + " | mCurrentPosition: " + this.L + " | feed id: " + j() + " \uff5c activityOrientation: " + i3);
        QFSVideoView qFSVideoView = this.W;
        if (qFSVideoView != null) {
            qFSVideoView.V0();
        }
        this.U = i3;
        RFWPlayerReuseUtils.prepareToReusePlayer(this.W);
        com.tencent.biz.qqcircle.launcher.c.L(context, qCircleLayerBean, i3);
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.w(j()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void l1(int i3) {
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(ua0.c.c((FeedCloudMeta$StFeed) this.f85017h)).setActionType(900).setSubActionType(i3).setPosition(this.f85018i).setfpageid(getReportBean().getFromPageId()).setPageId(y0()));
    }

    @NonNull
    private Activity m1(Activity activity) {
        View decorView;
        Object parent;
        View view;
        Window window = activity.getWindow();
        Context context = null;
        if (window == null) {
            decorView = null;
        } else {
            decorView = window.getDecorView();
        }
        if (decorView == null) {
            parent = null;
        } else {
            parent = decorView.getParent();
        }
        if (parent instanceof View) {
            view = (View) parent;
        } else {
            view = null;
        }
        if (view != null) {
            context = view.getContext();
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return activity;
    }

    private void n1(Configuration configuration) {
        M1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void o1(QFSCollectedFeedEvent qFSCollectedFeedEvent) {
        if (this.f85017h != 0 && qFSCollectedFeedEvent != null && qFSCollectedFeedEvent.getFeed() != null && TextUtils.equals(qFSCollectedFeedEvent.getFeedId(), j())) {
            ((FeedCloudMeta$StFeed) this.f85017h).collection.count.set(qFSCollectedFeedEvent.getFeed().collection.count.get());
            if (qFSCollectedFeedEvent.getFeed().opMask2.get().contains(25) && !((FeedCloudMeta$StFeed) this.f85017h).opMask2.get().contains(25)) {
                ((FeedCloudMeta$StFeed) this.f85017h).opMask2.get().add(25);
            } else if (!qFSCollectedFeedEvent.getFeed().opMask2.get().contains(25)) {
                ((FeedCloudMeta$StFeed) this.f85017h).opMask2.get().remove((Object) 25);
            }
        }
    }

    private void p1(QFSFeedOrientationChangeEvent qFSFeedOrientationChangeEvent) {
        if (qFSFeedOrientationChangeEvent.isSwitchFeedOrientation()) {
            e60.k.j().c();
        }
    }

    private void q1(@NonNull QFSFollowTabLiveListEvent qFSFollowTabLiveListEvent) {
        QCircleReportBean reportBean;
        int i3;
        if (I0() && this.I != null && (reportBean = getReportBean()) != null && TextUtils.equals(reportBean.getDtPageId(), QCircleDaTongConstant.PageId.PG_XSJ_FOLLOWING_PAGE)) {
            boolean z16 = qFSFollowTabLiveListEvent.mIsShowLiveList;
            QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 1, "handleFollowTabLiveListEvent" + z16);
            View view = this.I;
            if (z16) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            view.setVisibility(i3);
        }
    }

    private void r1(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null) {
            return;
        }
        if (rFWFeedSelectInfo.getPosition() != this.f85018i) {
            QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 4, "[handleOffScreenParam] selectInfo: " + rFWFeedSelectInfo + " | mPos: " + this.f85018i);
            return;
        }
        this.M = false;
        if (!I0()) {
            return;
        }
        QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[handleOffScreenParam] position: " + rFWFeedSelectInfo.getPosition() + " | hashCode: " + hashCode());
        e60.k.j().t(false);
        e60.k.j().s(this);
    }

    private void s1(QCirclePanelStateEvent qCirclePanelStateEvent) {
        String feedId;
        int panelType = qCirclePanelStateEvent.getPanelType();
        if (panelType != 2 && panelType != 27) {
            F1(qCirclePanelStateEvent.getFeedId(), qCirclePanelStateEvent.getPanelType());
            return;
        }
        if (TextUtils.isEmpty(qCirclePanelStateEvent.getFeedId())) {
            feedId = j();
        } else {
            feedId = qCirclePanelStateEvent.getFeedId();
        }
        F1(feedId, qCirclePanelStateEvent.getPanelType());
    }

    private void t1(int i3) {
        View view;
        int height;
        if (this.T != null && (view = this.I) != null && this.C != null) {
            if (i3 <= 0) {
                QLog.w("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[handlerInfoLayoutSizeChange] bottomInfoHeight <= 0.");
                return;
            }
            if (view.getVisibility() != 0) {
                QLog.w("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[handlerInfoLayoutSizeChange] mView.getVisibility() != View.VISIBLE.");
                return;
            }
            View findViewById = this.C.findViewById(R.id.f41541hc);
            int i16 = 0;
            if (findViewById == null) {
                height = 0;
            } else {
                height = findViewById.getHeight();
            }
            View findViewById2 = this.C.findViewById(R.id.f74163vi);
            View findViewById3 = this.C.findViewById(R.id.v_z);
            if (findViewById2 != null) {
                i16 = findViewById2.getHeight();
            }
            if (height > 0 && i16 > 0) {
                int J1 = (((height / 2) - (i16 / 2)) + i16) - J1(height, findViewById2, findViewById3);
                int a16 = ((height - J1) - this.X) - com.tencent.biz.qqcircle.utils.cx.a(8.0f);
                if (a16 < 0) {
                    QLog.w("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[handlerInfoLayoutSizeChange] minBottomContentHeight < 0.");
                    return;
                }
                QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[onInfoLayoutSizeChange] current feedId: " + j() + " | screenHeight: " + height + " | videoTop: " + J1 + " | videoHeight: " + i16 + " | minBottomContentHeight: " + a16);
                I1(a16);
                return;
            }
            QLog.w("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[handlerInfoLayoutSizeChange] screenHeight <= 0 || videoHeight <= 0.");
            return;
        }
        QLog.w("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[handlerInfoLayoutSizeChange] mBottomInfoLayout == null || mView == null || mRootView == null.");
    }

    private void u1(@NonNull com.tencent.biz.qqcircle.immersive.feed.event.aq aqVar) {
        View view;
        if (aqVar.f86158a == R.id.f74163vi && this.I != null) {
            if (this.U != 1) {
                QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 2, "[handlerQFSViewSizeChangeEvent] current orientation type not is portrait.");
            } else {
                if (A1() || (view = this.T) == null) {
                    return;
                }
                view.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ci
                    @Override // java.lang.Runnable
                    public final void run() {
                        cl.this.B1();
                    }
                });
            }
        }
    }

    private void v1(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        this.M = true;
        if (!I0()) {
            return;
        }
        int position = rFWFeedSelectInfo.getPosition();
        this.U = 1;
        QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[handlerUpScreenParams] position: " + position + " | hashCode: " + hashCode());
        e60.k.j().p(this);
    }

    private void w1(@NonNull com.tencent.biz.qqcircle.immersive.feed.event.an anVar) {
        this.L = anVar.e();
    }

    private boolean x1() {
        if (!uq3.o.k1()) {
            return false;
        }
        Context m06 = m0();
        if (!(m06 instanceof Activity)) {
            return false;
        }
        return ((Activity) m06).isDestroyed();
    }

    private boolean y1() {
        Context context;
        boolean z16;
        boolean z17;
        View view = this.C;
        if (view == null) {
            context = null;
        } else {
            context = view.getContext();
        }
        if (!(context instanceof Activity)) {
            QLog.e("QOC-QFSFeedFullScreenEntrancePresenter", 4, "[isInSpecialWindow] current context not is activity, end flow.");
            return false;
        }
        Activity m16 = m1((Activity) context);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            z16 = m16.isInMultiWindowMode();
        } else {
            z16 = false;
        }
        if (i3 >= 24) {
            z17 = m16.isInPictureInPictureMode();
        } else {
            z17 = false;
        }
        if (this.N != z16 || this.P != z17) {
            QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[isInSpecialWindow] isInMultiWindowMode: " + z16 + " | isInPictureInPictureMode: " + z17);
            this.N = z16;
            this.P = z17;
        }
        if (!z16 && !z17) {
            return false;
        }
        return true;
    }

    private boolean z1() {
        QFSVideoView qFSVideoView = this.W;
        if (qFSVideoView != null && qFSVideoView.getQCirclePlayer() != null && this.W.getQCirclePlayer().getRealPlayer() != null && this.W.getQCirclePlayer().getRealPlayer().isLoopBack()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.an) {
            w1((com.tencent.biz.qqcircle.immersive.feed.event.an) hVar);
        } else if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.aq) {
            u1((com.tencent.biz.qqcircle.immersive.feed.event.aq) hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: G1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.L = 0;
        this.U = 1;
        c1(false);
        M1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean H0() {
        return com.tencent.biz.qqcircle.manager.i.a("qfs_fullscreen_entrance_show");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        L1(this.Y);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
    }

    @Override // e60.k.b
    public boolean M8(int i3) {
        if (i3 == 1 || i3 == 2) {
            return false;
        }
        if (x1()) {
            QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[onScreenOrientation] current activity destroyed, allow orientation.");
            return false;
        }
        if (!J0()) {
            QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[onScreenOrientation] video on screen, allow orientation.");
            return false;
        }
        if (A1() || !this.M || y1()) {
            return false;
        }
        QLog.d("QOC-QFSFeedFullScreenEntrancePresenter", 1, "[onScreenOrientation] orientationType: " + i3 + " | hashCode: " + hashCode());
        k1(m0(), e60.h.G9(i3), false);
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.X = (int) view.getResources().getDimension(R.dimen.d06);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void c1(boolean z16) {
        this.Y = z16;
        L1(z16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleConfigChangeEvent.class);
        eventClass.add(QCirclePanelStateEvent.class);
        eventClass.add(QFSFeedOrientationChangeEvent.class);
        eventClass.add(QFSCollectedFeedEvent.class);
        eventClass.add(QFSFollowTabLiveListEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        v1(rFWFeedSelectInfo);
        M1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        r1(rFWFeedSelectInfo);
        H1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        r1(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            n1(((QCircleConfigChangeEvent) simpleBaseEvent).configuration);
            return;
        }
        if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            s1((QCirclePanelStateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSFeedOrientationChangeEvent) {
            p1((QFSFeedOrientationChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSCollectedFeedEvent) {
            o1((QFSCollectedFeedEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSFollowTabLiveListEvent) {
            q1((QFSFollowTabLiveListEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        v1(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onStop(rFWFeedSelectInfo);
        j1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QOC-QFSFeedFullScreenEntrancePresenter";
    }
}
