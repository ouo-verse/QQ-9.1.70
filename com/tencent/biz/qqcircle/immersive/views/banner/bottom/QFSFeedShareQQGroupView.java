package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.immersive.utils.au;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$QQGroupInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StGuideInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedShareQQGroupView extends c implements View.OnClickListener {
    private View D;
    private FrameLayout E;
    private TextView F;
    private String G;
    private long H;
    private FeedCloudMeta$StGuideInfo I;
    private Runnable J;
    private Runnable K;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class IsInQQGroupRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QFSFeedShareQQGroupView> f90584d;

        /* renamed from: e, reason: collision with root package name */
        private String f90585e;

        IsInQQGroupRunnable(QFSFeedShareQQGroupView qFSFeedShareQQGroupView, String str) {
            this.f90584d = new WeakReference<>(qFSFeedShareQQGroupView);
            this.f90585e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<QFSFeedShareQQGroupView> weakReference = this.f90584d;
            if (weakReference != null && weakReference.get() != null) {
                if (!this.f90584d.get().I(this.f90584d.get().I)) {
                    QLog.d("QFSFeedShareQQGroupView", 1, "[IsInQQGroupRunnable] is in qq group");
                    this.f90584d.get().O(this.f90584d.get().I, this.f90585e);
                } else {
                    QLog.d("QFSFeedShareQQGroupView", 1, "[IsInQQGroupRunnable] is not in qq group");
                    this.f90584d.get().P(this.f90584d.get().I, this.f90585e);
                    this.f90584d.get().K(this.f90584d.get().I);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a implements IQCircleChatUtilApi.QQGroupCallBack {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<QFSFeedShareQQGroupView> f90586a;

        a(QFSFeedShareQQGroupView qFSFeedShareQQGroupView) {
            this.f90586a = new WeakReference<>(qFSFeedShareQQGroupView);
        }

        @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi.QQGroupCallBack
        public void canJoinGroup(long j3) {
            WeakReference<QFSFeedShareQQGroupView> weakReference = this.f90586a;
            if (weakReference != null && weakReference.get() != null) {
                this.f90586a.get().H = j3;
            }
        }
    }

    public QFSFeedShareQQGroupView(@NonNull com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
    }

    public static boolean E(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (MobileQQ.sProcessId != 1) {
            QLog.d("QFSFeedShareQQGroupView", 1, "[canShow] now is not in MobileQQ process");
            return false;
        }
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.guideInfos.has() && feedCloudMeta$StFeed.guideInfos.get().size() > 0) {
            int i3 = feedCloudMeta$StFeed.guideInfos.get().get(0).guide_type.get();
            boolean H = H();
            QLog.d("QFSFeedShareQQGroupView", 1, "[canShow] guideType: " + i3 + " | hasOverLimitCount: " + H);
            if (i3 != 3 || H) {
                return false;
            }
            return true;
        }
        QLog.d("QFSFeedShareQQGroupView", 4, "[canShow] feed.guideInfos.get().size() <= 0");
        return false;
    }

    private String F(long j3) {
        FeedCloudMeta$StGuideInfo feedCloudMeta$StGuideInfo = this.I;
        if (feedCloudMeta$StGuideInfo != null && feedCloudMeta$StGuideInfo.extData.qqGroupInfo.has()) {
            for (FeedCloudMeta$QQGroupInfo feedCloudMeta$QQGroupInfo : this.I.extData.qqGroupInfo.get()) {
                if (feedCloudMeta$QQGroupInfo != null && feedCloudMeta$QQGroupInfo.f398444id.get() == j3) {
                    return String.valueOf(feedCloudMeta$QQGroupInfo.jumpAuth.get());
                }
            }
        }
        return null;
    }

    private long G() {
        long j3 = this.H;
        if (j3 != 0) {
            return j3;
        }
        FeedCloudMeta$StGuideInfo feedCloudMeta$StGuideInfo = this.I;
        if (feedCloudMeta$StGuideInfo == null || feedCloudMeta$StGuideInfo.extData.qqGroupInfo.size() <= 0) {
            return 0L;
        }
        return this.I.extData.qqGroupInfo.get().get(0).f398444id.get();
    }

    public static boolean H() {
        int e16 = uq3.k.a().e("sp_key_qq_group_share_count", 0);
        long f16 = uq3.k.a().f("sp_key_qq_group_share_count_time", 0L);
        QLog.d("QFSFeedShareQQGroupView", 4, "hasOverLimitCount count : " + e16);
        if (System.currentTimeMillis() - f16 > 86400000 || e16 <= uq3.c.L2()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I(FeedCloudMeta$StGuideInfo feedCloudMeta$StGuideInfo) {
        if (feedCloudMeta$StGuideInfo != null && feedCloudMeta$StGuideInfo.extData.qqGroupInfo.has()) {
            Iterator<FeedCloudMeta$QQGroupInfo> it = feedCloudMeta$StGuideInfo.extData.qqGroupInfo.get().iterator();
            while (it.hasNext()) {
                String valueOf = String.valueOf(it.next().f398444id.get());
                boolean isInQQGroup = ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).isInQQGroup(valueOf);
                if (isInQQGroup) {
                    this.G = valueOf;
                    return isInQQGroup;
                }
            }
            this.G = null;
        }
        return false;
    }

    private void J(@NonNull View view) {
        if (this.D == null) {
            this.D = ((ViewStub) view.findViewById(R.id.f513627w)).inflate();
        }
        this.E = (FrameLayout) this.D.findViewById(R.id.f513527v);
        this.F = (TextView) this.D.findViewById(R.id.f365814y);
        this.E.setOnClickListener(this);
        S(this.E, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(FeedCloudMeta$StGuideInfo feedCloudMeta$StGuideInfo) {
        if (this.H == 0 && feedCloudMeta$StGuideInfo != null && feedCloudMeta$StGuideInfo.extData.qqGroupInfo.has()) {
            ArrayList arrayList = new ArrayList();
            for (FeedCloudMeta$QQGroupInfo feedCloudMeta$QQGroupInfo : feedCloudMeta$StGuideInfo.extData.qqGroupInfo.get()) {
                if (feedCloudMeta$QQGroupInfo == null) {
                    return;
                } else {
                    arrayList.add(Long.valueOf(feedCloudMeta$QQGroupInfo.f398444id.get()));
                }
            }
            ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).preQQGroupInfoForJoin(arrayList, new a(this));
        }
    }

    private void L() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedShareQQGroupView.3
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                VideoReport.setElementId(QFSFeedShareQQGroupView.this.E, QCircleDaTongConstant.ElementId.EM_XSJ_INTERACT_GROUP_TOTRAFFIC_BUTTON);
                if (!TextUtils.isEmpty(QFSFeedShareQQGroupView.this.G)) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_INTERACT_GROUP_BUTTON_STATE, 2);
                } else {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_INTERACT_GROUP_BUTTON_STATE, 1);
                }
                VideoReport.reportEvent("ev_xsj_abnormal_clck", QFSFeedShareQQGroupView.this.E, buildElementParams);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedShareQQGroupView.4
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                VideoReport.setElementId(QFSFeedShareQQGroupView.this.E, QCircleDaTongConstant.ElementId.EM_XSJ_INTERACT_GROUP_TOTRAFFIC_BUTTON);
                if (!TextUtils.isEmpty(QFSFeedShareQQGroupView.this.G)) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_INTERACT_GROUP_BUTTON_STATE, 2);
                } else {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_INTERACT_GROUP_BUTTON_STATE, 1);
                }
                VideoReport.reportEvent("ev_xsj_abnormal_imp", QFSFeedShareQQGroupView.this.E, buildElementParams);
            }
        });
    }

    private void N() {
        QCircleShareInfo c16 = au.c(this.f90602e);
        c16.feed = this.f90602e;
        c16.silentShareType = 2;
        c16.mShareUin = this.G;
        c16.mShareUinType = 1;
        o().onHandlerMessage("event_silent_share", c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(final FeedCloudMeta$StGuideInfo feedCloudMeta$StGuideInfo, String str) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (!TextUtils.isEmpty(str) && (feedCloudMeta$StFeed = this.f90602e) != null && str.equals(feedCloudMeta$StFeed.f398449id.get())) {
            this.K = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedShareQQGroupView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (feedCloudMeta$StGuideInfo.btmSubInfo.buttons.buttons.has() && feedCloudMeta$StGuideInfo.btmSubInfo.buttons.buttons.get().size() > 0) {
                        QFSFeedShareQQGroupView qFSFeedShareQQGroupView = QFSFeedShareQQGroupView.this;
                        qFSFeedShareQQGroupView.S(qFSFeedShareQQGroupView.E, 0);
                        String str2 = feedCloudMeta$StGuideInfo.btmSubInfo.buttons.buttons.get().get(0).style.textPre.get();
                        if (TextUtils.isEmpty(str2)) {
                            QFSFeedShareQQGroupView qFSFeedShareQQGroupView2 = QFSFeedShareQQGroupView.this;
                            qFSFeedShareQQGroupView2.S(qFSFeedShareQQGroupView2.E, 8);
                        } else {
                            QFSFeedShareQQGroupView.this.F.setText(str2);
                            QFSFeedShareQQGroupView.this.M();
                        }
                    }
                }
            };
            n().post(this.K);
            QLog.d("QFSFeedShareQQGroupView", 1, "[showJoinQQGroup]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(final FeedCloudMeta$StGuideInfo feedCloudMeta$StGuideInfo, String str) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (!TextUtils.isEmpty(str) && (feedCloudMeta$StFeed = this.f90602e) != null && str.equals(feedCloudMeta$StFeed.f398449id.get())) {
            this.J = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedShareQQGroupView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (feedCloudMeta$StGuideInfo.btmSubInfo.buttons.buttons.has() && feedCloudMeta$StGuideInfo.btmSubInfo.buttons.buttons.get().size() > 0) {
                        QFSFeedShareQQGroupView qFSFeedShareQQGroupView = QFSFeedShareQQGroupView.this;
                        qFSFeedShareQQGroupView.S(qFSFeedShareQQGroupView.E, 0);
                        String str2 = feedCloudMeta$StGuideInfo.btmSubInfo.buttons.buttons.get().get(0).style.textPost.get();
                        if (TextUtils.isEmpty(str2)) {
                            QFSFeedShareQQGroupView qFSFeedShareQQGroupView2 = QFSFeedShareQQGroupView.this;
                            qFSFeedShareQQGroupView2.S(qFSFeedShareQQGroupView2.E, 8);
                        } else {
                            if (QFSFeedShareQQGroupView.this.F != null) {
                                QFSFeedShareQQGroupView.this.F.setText(str2);
                            }
                            QFSFeedShareQQGroupView.this.M();
                        }
                    }
                }
            };
            n().post(this.J);
            QLog.d("QFSFeedShareQQGroupView", 1, "[mShowShareRunnable]");
        }
    }

    private void R(FeedCloudMeta$StGuideInfo feedCloudMeta$StGuideInfo, String str) {
        if (feedCloudMeta$StGuideInfo != null && this.E != null && E(this.f90602e)) {
            RFWThreadManager.getInstance().execOnAsyncDisplayThread(new IsInQQGroupRunnable(this, str));
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[updateView] data = ");
        sb5.append(feedCloudMeta$StGuideInfo);
        sb5.append(", mQQGroupFrameLayout = ");
        sb5.append(this.E);
        sb5.append(", !canShow(mFeed) = ");
        sb5.append(!E(this.f90602e));
        QLog.d("QFSFeedShareQQGroupView", 1, sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(View view, int i3) {
        if (view != null && view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    public void Q() {
        if (System.currentTimeMillis() - uq3.k.a().f("sp_key_qq_group_share_count_time", 0L) >= 86400000) {
            uq3.k.a().m("sp_key_qq_group_share_count", 1);
            uq3.k.a().n("sp_key_qq_group_share_count_time", System.currentTimeMillis());
            QLog.d("QFSFeedShareQQGroupView", 4, "updateLimitCount count : 1");
        } else {
            int e16 = uq3.k.a().e("sp_key_qq_group_share_count", 0);
            uq3.k.a().m("sp_key_qq_group_share_count", e16 + 1);
            QLog.d("QFSFeedShareQQGroupView", 4, "updateLimitCount count : " + e16);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void e(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.e(rFWFeedSelectInfo);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        R(this.I, feedCloudMeta$StFeed.f398449id.get());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 116;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(e30.b bVar, int i3) {
        super.h(bVar, i3);
        if (bVar != null && bVar.g().guideInfos.has() && bVar.g().guideInfos.get().size() > 0) {
            FeedCloudMeta$StGuideInfo feedCloudMeta$StGuideInfo = bVar.g().guideInfos.get(0);
            this.I = feedCloudMeta$StGuideInfo;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
            if (feedCloudMeta$StFeed == null) {
                return;
            }
            R(feedCloudMeta$StGuideInfo, feedCloudMeta$StFeed.f398449id.get());
            return;
        }
        this.I = null;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return E(this.f90602e);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f513527v) {
            if (com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
                QLog.d("QFSFeedShareQQGroupView", 1, "[onclick] forbid fast share because of sencebeat");
            } else {
                if (TextUtils.isEmpty(this.G)) {
                    long G = G();
                    ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).enterQQGroupDetail(view.getContext(), String.valueOf(G), F(G), "feed");
                } else {
                    N();
                }
                L();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        QLog.d("QFSFeedShareQQGroupView", 1, "[onElementActivated]");
        J(this.f90604h);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        R(this.I, feedCloudMeta$StFeed.f398449id.get());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        S(this.E, 8);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
        if (!E(this.f90602e)) {
            S(this.E, 8);
        } else {
            Q();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
        if (this.E == null) {
            return;
        }
        n().removeCallbacks(this.J);
        n().removeCallbacks(this.K);
        if (H()) {
            S(this.E, 8);
        }
    }
}
