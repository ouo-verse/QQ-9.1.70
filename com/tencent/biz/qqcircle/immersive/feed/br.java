package com.tencent.biz.qqcircle.immersive.feed;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.aspectj.QCircleForbidInteractProcessor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSCommentSendEvent;
import com.tencent.biz.qqcircle.events.QFSPushTenTimesEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSLikeStateChangeEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSUnShowFreeFlowViewEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSDoublePraiseEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StShare;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class br extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements Observer<e30.b>, View.OnClickListener {
    private FeedCloudMeta$StFeed I;
    private ImageView J;
    private TextView K;
    private TextView L;
    private FrameLayout M;
    private mc0.a P;
    private boolean R;
    private View T;
    private final Runnable N = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.bn
        @Override // java.lang.Runnable
        public final void run() {
            br.this.E1();
        }
    };
    private boolean Q = false;
    private int S = 0;

    private void A1(QCircleShareInfo qCircleShareInfo) {
        qCircleShareInfo.isEnableShareToMutual = com.tencent.biz.qqcircle.immersive.utils.a.c();
    }

    private void B1(QCircleShareInfo qCircleShareInfo, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!p40.o.f(QCirclePluginUtil.getQCircleInitBean(m0()))) {
            return;
        }
        p40.o.e(feedCloudMeta$StFeed);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void C1(View view) {
        T t16 = this.f85017h;
        int i3 = 1;
        if (t16 == 0) {
            QLog.e(getTAG(), 1, "shareBtnClick: mData == null");
            return;
        }
        if (QCircleForbidInteractProcessor.forbidInteractIfGuildFeed((FeedCloudMeta$StFeed) t16, 2)) {
            QLog.d(getTAG(), 1, "shareBtnClick: guild feed forbid interact");
        } else if (view.getId() == R.id.f165971dy1) {
            if (c40.a.f(this.I)) {
                i3 = 2;
            }
            y1(i3);
            SimpleEventBus.getInstance().dispatchEvent(new QFSUnShowFreeFlowViewEvent());
        }
    }

    public static void D1(QCircleShareInfo qCircleShareInfo) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (qCircleShareInfo != null && (feedCloudMeta$StFeed = qCircleShareInfo.feed) != null) {
            com.tencent.biz.qqcircle.immersive.utils.y.f(feedCloudMeta$StFeed.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void E1() {
        if (com.tencent.biz.qqcircle.utils.ai.f((FeedCloudMeta$StFeed) this.f85017h)) {
            F1(R.string.f195854fq, new RFWSmartPopupWindow.IStatusCallback() { // from class: com.tencent.biz.qqcircle.immersive.feed.bo
                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public /* synthetic */ void onClick(View view) {
                    a04.d.a(this, view);
                }

                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public /* synthetic */ void onDismiss() {
                    a04.d.b(this);
                }

                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public final void onShow() {
                    com.tencent.biz.qqcircle.utils.ai.j();
                }
            });
            return;
        }
        if (com.tencent.biz.qqcircle.utils.ai.h((FeedCloudMeta$StFeed) this.f85017h)) {
            z1();
            F1(R.string.f195354ed, new RFWSmartPopupWindow.IStatusCallback() { // from class: com.tencent.biz.qqcircle.immersive.feed.bp
                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public /* synthetic */ void onClick(View view) {
                    a04.d.a(this, view);
                }

                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public /* synthetic */ void onDismiss() {
                    a04.d.b(this);
                }

                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public final void onShow() {
                    com.tencent.biz.qqcircle.utils.ai.m();
                }
            });
        } else if (com.tencent.biz.qqcircle.utils.ai.g((FeedCloudMeta$StFeed) this.f85017h)) {
            F1(R.string.f195344ec, new RFWSmartPopupWindow.IStatusCallback() { // from class: com.tencent.biz.qqcircle.immersive.feed.bq
                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public /* synthetic */ void onClick(View view) {
                    a04.d.a(this, view);
                }

                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public /* synthetic */ void onDismiss() {
                    a04.d.b(this);
                }

                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public final void onShow() {
                    com.tencent.biz.qqcircle.utils.ai.k();
                }
            });
        }
    }

    private void F1(int i3, RFWSmartPopupWindow.IStatusCallback iStatusCallback) {
        Context context = this.J.getContext();
        if (!v1() && E0() && !s1(context)) {
            this.P = (mc0.a) mc0.a.c(context, i3).setAnchor(this.J).setPosition(2).setAlignment(0).addStatusCallback(iStatusCallback);
        }
    }

    private void H1(QCircleShareInfo qCircleShareInfo) {
        QLog.d(getTAG(), 1, "[tryOpenMultiShareFragment] return: shareButtonManager = null");
        QLog.d(getTAG(), 1, "[tryOpenMultiShareFragment] return: not startAnimation");
    }

    private void I1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.K == null) {
            QLog.d("QFSFeedChildSharePresenter", 1, "[updateFeedShareText] share text should not be null.");
            return;
        }
        ImageView imageView = this.J;
        if (imageView == null) {
            QLog.d("QFSFeedChildSharePresenter", 1, "[updateFeedShareText] mShareImg should not be null.");
            return;
        }
        imageView.setImageResource(R.drawable.f161637om0);
        this.K.setText(R.string.f184363lo);
        this.K.setTextSize(1, 11.0f);
        f0(this.J, "em_xsj_share_button");
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHARE_BUTTON_TYPE, "default");
        VideoReport.setElementParams(this.J, hashMap);
    }

    private boolean h1(String str) {
        boolean z16;
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null && TextUtils.equals(this.E.g().f398449id.get(), str) && this.E.g().opMask2.get().contains(31)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.d("QFSFeedChildSharePresenter", 1, "can not show breathe animation");
        }
        return z16;
    }

    private void j1(QFSLikeStateChangeEvent qFSLikeStateChangeEvent) {
        if (qFSLikeStateChangeEvent.getIsLike() && h1(qFSLikeStateChangeEvent.getFeedId())) {
            G1(1);
        }
    }

    private void k1(com.tencent.biz.qqcircle.immersive.feed.event.an anVar) {
        int c16 = anVar.c();
        int d16 = anVar.d();
        if ((c16 <= 30000 && d16 == 2) || (c16 > 30000 && d16 == 1)) {
            G1(0);
        }
    }

    private void l1(@NonNull QFSDoublePraiseEvent qFSDoublePraiseEvent) {
        if (!h1(qFSDoublePraiseEvent.getFeedId())) {
            return;
        }
        G1(2);
    }

    private void m1(QCirclePanelStateEvent qCirclePanelStateEvent) {
        RFWThreadManager.getUIHandler().removeCallbacks(this.N);
        if (qCirclePanelStateEvent.getPanelType() == 6) {
            this.R = qCirclePanelStateEvent.isShowing();
        }
    }

    private void n1(com.tencent.biz.qqcircle.immersive.feed.event.an anVar) {
        if (!com.tencent.biz.qqcircle.utils.l.f("exp_sharebuttondifferent", "exp_sharebuttondifferent_B") && !com.tencent.biz.qqcircle.utils.l.f("exp_sharebuttondifferent", "exp_sharebuttondifferent_C")) {
            k1(anVar);
        } else {
            r1(anVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void o1(@NonNull QFSPushTenTimesEvent qFSPushTenTimesEvent) {
        T t16 = this.f85017h;
        if (t16 == 0 || qFSPushTenTimesEvent.mFeed == null || !TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), qFSPushTenTimesEvent.mFeed.f398449id.get())) {
            return;
        }
        G1(4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void p1(@NonNull QFSCommentSendEvent qFSCommentSendEvent) {
        T t16 = this.f85017h;
        if (t16 == 0 || qFSCommentSendEvent.mFeed == null || !TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), qFSCommentSendEvent.mFeed.f398449id.get())) {
            return;
        }
        G1(3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void q1(com.tencent.biz.qqcircle.immersive.feed.event.ad adVar) {
        T t16 = this.f85017h;
        if ((t16 instanceof FeedCloudMeta$StFeed) && TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), adVar.a())) {
            this.S = adVar.b();
        }
    }

    private void r1(com.tencent.biz.qqcircle.immersive.feed.event.an anVar) {
        if (anVar.d() == 1) {
            G1(0);
        }
    }

    private boolean s1(@NonNull Context context) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return true;
        }
        return false;
    }

    private boolean t1() {
        if (!com.tencent.biz.qqcircle.utils.bz.l() || s0() == null) {
            return false;
        }
        QCircleInitBean initBean = s0().getInitBean();
        if (!(initBean instanceof QCircleFolderBean)) {
            return false;
        }
        return ((QCircleFolderBean) initBean).isTabFullScreenMode();
    }

    private boolean u1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        int i3;
        int i16;
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StFeed2 == null) {
            return false;
        }
        if (!h20.c.h()) {
            return true;
        }
        FeedCloudMeta$StShare feedCloudMeta$StShare = feedCloudMeta$StFeed.share;
        if (feedCloudMeta$StShare != null) {
            i3 = feedCloudMeta$StShare.sharedCount.get();
        } else {
            i3 = 0;
        }
        FeedCloudMeta$StShare feedCloudMeta$StShare2 = feedCloudMeta$StFeed2.share;
        if (feedCloudMeta$StShare2 != null) {
            i16 = feedCloudMeta$StShare2.sharedCount.get();
        } else {
            i16 = 0;
        }
        if (i3 == i16) {
            return false;
        }
        return true;
    }

    private boolean v1() {
        if (!QCirclePanelStateEvent.isSpecifiedPanelShowing(0) && !QCirclePanelStateEvent.isSpecifiedPanelShowing(3) && !QCirclePanelStateEvent.isSpecifiedPanelShowing(11) && !QCirclePanelStateEvent.isSpecifiedPanelShowing(12)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y1(int i3) {
        String str;
        boolean z16;
        if (this.f85017h == 0) {
            QLog.e(getTAG(), 1, "[openSharePanel] mData == null");
            return;
        }
        if (s0() == null) {
            QLog.d("QFSFeedChildSharePresenter", 1, "[openSharePanel] feed ioc should not be null.");
            return;
        }
        QCircleShareInfo c16 = com.tencent.biz.qqcircle.immersive.utils.au.c((FeedCloudMeta$StFeed) this.f85017h);
        c16.source = i3;
        c16.hadAdBanner = com.tencent.biz.qqcircle.immersive.utils.ad.a.h((ViewGroup) this.C.findViewById(R.id.f40181do));
        c16.feedBlockData = this.E;
        QCircleExtraTypeInfo r16 = r();
        c16.extraTypeInfo = r16;
        r16.mDataPosition = this.f85018i;
        if (((FeedCloudMeta$StFeed) this.f85017h).type.get() == 2) {
            c16.picDownPos = this.S;
        }
        c16.feed = (FeedCloudMeta$StFeed) this.f85017h;
        c16.mReportBean = getReportBean();
        if (getReportBean() != null) {
            str = getReportBean().getDtPageId();
        } else {
            str = "";
        }
        if (("pg_xsj_friendtab_explore_page".equals(str) || QCircleDaTongConstant.PageId.PG_XSJ_FOLLOWING_PAGE.equals(str) || "pg_xsj_explore_page".equals(str)) && c16.isShowQCircleEnterFloatingWindow) {
            z16 = true;
        } else {
            z16 = false;
        }
        c16.isShowQCircleEnterFloatingWindow = z16;
        if (t1() || com.tencent.biz.qqcircle.utils.bz.k()) {
            c16.isShowQCircleEnterFloatingWindow = false;
        }
        D1(c16);
        H1(c16);
        B1(c16, (FeedCloudMeta$StFeed) this.f85017h);
        A1(c16);
        QLog.d(getTAG(), 1, "[openSharePanel] isShowSetQQProfileCover:" + c16.isShowSetQQProfileCover);
        s0().onHandlerMessage("event_open_share", c16);
        i1();
        this.Q = true;
        if (wa0.c.f().g() > 0) {
            cc0.e.b(this.E);
        }
        w20.a.j().m();
    }

    private void z1() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SET_TOP_NEW_BUBBLE);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_action_type", QCircleDaTongConstant.ElementParamValue.NEW_FEATURE_BUBBLE_EXP);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().b()));
        VideoReport.reportEvent("ev_xsj_sharepanel_action", null, buildElementParams);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.an) {
            n1((com.tencent.biz.qqcircle.immersive.feed.event.an) hVar);
        } else if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ad) {
            q1((com.tencent.biz.qqcircle.immersive.feed.event.ad) hVar);
        } else if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ab) {
            y1(((com.tencent.biz.qqcircle.immersive.feed.event.ab) hVar).a());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        this.Q = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        View findViewById = view.findViewById(R.id.f41401gz);
        this.T = findViewById;
        this.K = (TextView) findViewById.findViewById(R.id.f165235va2);
        this.L = (TextView) this.T.findViewById(R.id.f165236va3);
        this.M = (FrameLayout) this.T.findViewById(R.id.v8p);
        ImageView imageView = (ImageView) this.T.findViewById(R.id.f165971dy1);
        this.J = imageView;
        imageView.setOnClickListener(this);
        this.J.setImageResource(com.tencent.biz.qqcircle.k.p());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSCommentSendEvent.class);
        eventClass.add(QFSPushTenTimesEvent.class);
        eventClass.add(QFSLikeStateChangeEvent.class);
        eventClass.add(QFSDoublePraiseEvent.class);
        eventClass.add(QCirclePanelStateEvent.class);
        return eventClass;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            C1(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        i1();
        super.onFeedUnSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        i1();
        RFWThreadManager.getUIHandler().removeCallbacks(this.N);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSCommentSendEvent) {
            p1((QFSCommentSendEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSPushTenTimesEvent) {
            o1((QFSPushTenTimesEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSLikeStateChangeEvent) {
            j1((QFSLikeStateChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSDoublePraiseEvent) {
            l1((QFSDoublePraiseEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            m1((QCirclePanelStateEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildSharePresenter";
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSFeedChildSharePresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        this.I = feedCloudMeta$StFeed;
        I1(feedCloudMeta$StFeed);
        w20.a.j().observerGlobalState(this.E, this);
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(m0());
        if (qCircleInitBean != null && qCircleInitBean.getExtraTypeInfo() != null) {
            U0(qCircleInitBean.getExtraTypeInfo());
        }
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        if (bVar == null) {
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.I;
        FeedCloudMeta$StFeed g16 = bVar.g();
        this.I = g16;
        if (u1(g16, feedCloudMeta$StFeed)) {
            I1(this.I);
        }
    }

    private void i1() {
    }

    private void G1(int i3) {
    }
}
