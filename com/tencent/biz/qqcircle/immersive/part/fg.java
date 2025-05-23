package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.activity.QCircleTransFragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSCommentPermissionUserUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSOpenSettingPermissionWindowEvent;
import com.tencent.biz.qqcircle.immersive.request.QFSSettingDownloadPermissionRequest;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.qqcircle.utils.QFSSlidBottomView;
import com.tencent.biz.qqcircle.utils.ay;
import com.tencent.biz.qqcircle.widgets.QFSSettingCommentPermissionBottomDialog;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StRight;
import feedcloud.FeedCloudWrite$StModifyDownLoadSwitchRsp;
import feedcloud.RightFlag;
import feedcloud.RightInfo;
import feedcloud.Switch;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class fg extends u implements SimpleEventReceiver {
    private ViewStub C;
    private View D;
    private FrameLayout E;
    private QFSSlidBottomView F;
    private QUISettingsRecyclerView G;
    private QUIListItemAdapter H;
    private FeedCloudMeta$StFeed I;
    private com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> P;

    /* renamed from: d, reason: collision with root package name */
    private boolean f88095d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f88096e;

    /* renamed from: m, reason: collision with root package name */
    private View f88100m;

    /* renamed from: f, reason: collision with root package name */
    private boolean f88097f = true;

    /* renamed from: h, reason: collision with root package name */
    private int f88098h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f88099i = 0;
    private final CompoundButton.OnCheckedChangeListener J = new a();
    private final CompoundButton.OnCheckedChangeListener K = new b();
    private final View.OnClickListener L = new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.fb
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            fg.this.da(view);
        }
    };
    private final View.OnClickListener M = new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.fc
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            fg.this.ea(view);
        }
    };
    private final View.OnClickListener N = new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.fd
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            fg.this.ga(view);
        }
    };

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            fg.this.f88095d = z16;
            if (fg.this.F != null && !fg.this.f88097f) {
                fg.this.ja();
                fg.this.T9(!z16);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            fg.this.f88096e = z16;
            if (fg.this.F != null && !fg.this.f88097f) {
                fg.this.ia();
                fg.this.S9(!z16);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StModifyDownLoadSwitchRsp> {
        c() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StModifyDownLoadSwitchRsp feedCloudWrite$StModifyDownLoadSwitchRsp) {
            int i3;
            QLog.d("QFSSettingDownloadPermissionPart", 1, "onResponse, isSuccess:" + z16 + ", retCode: " + j3 + ", errMsg: " + str);
            if (z16 && j3 == 0 && feedCloudWrite$StModifyDownLoadSwitchRsp != null) {
                if (fg.this.f88096e) {
                    i3 = R.string.f188563x1;
                } else {
                    i3 = R.string.f188583x3;
                }
                QCircleToast.l(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(i3), 0, true, false);
                fg.this.oa();
                return;
            }
            QCircleToast.l(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f19228473), 0, true, false);
        }
    }

    private void R9() {
        String dtPageId;
        if (this.I == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMT_FEED_BUTTON);
        buildElementParams.put("xsj_feed_id", this.I.f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.I.poster.f398463id.get());
        if (getReportBean() == null) {
            dtPageId = "";
        } else {
            dtPageId = getReportBean().getDtPageId();
        }
        buildElementParams.put("xsj_custom_pgid", dtPageId);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S9(boolean z16) {
        String dtPageId;
        if (this.I == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SET_DOWNLOAD_BUTTON);
        buildElementParams.put("xsj_feed_id", this.I.f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.I.poster.f398463id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SET_DOWNLOAD_BEGIN_STATUS, Integer.valueOf(z16 ? 1 : 0));
        if (getReportBean() == null) {
            dtPageId = "";
        } else {
            dtPageId = getReportBean().getDtPageId();
        }
        buildElementParams.put("xsj_custom_pgid", dtPageId);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T9(boolean z16) {
        String dtPageId;
        if (this.I == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SET_PRIVATE_BUTTON);
        buildElementParams.put("xsj_feed_id", this.I.f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.I.poster.f398463id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SET_PRIVATE_BEGIN_STATUS, Integer.valueOf(z16 ? 1 : 0));
        if (getReportBean() == null) {
            dtPageId = "";
        } else {
            dtPageId = getReportBean().getDtPageId();
        }
        buildElementParams.put("xsj_custom_pgid", dtPageId);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U9() {
        String dtPageId;
        if (this.I == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA_SET_RIGHT_PANEL);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SET_PRIVATE_BEGIN_STATUS, Integer.valueOf(this.f88098h));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SET_DOWNLOAD_BEGIN_STATUS, Integer.valueOf(this.f88099i));
        buildElementParams.put("xsj_feed_id", this.I.f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.I.poster.f398463id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SET_PRIVATE_END_STATUS, Integer.valueOf(this.f88095d ? 1 : 0));
        buildElementParams.put("xsj_set_download_end_status", Integer.valueOf(this.f88096e ? 1 : 0));
        if (getReportBean() == null) {
            dtPageId = "";
        } else {
            dtPageId = getReportBean().getDtPageId();
        }
        buildElementParams.put("xsj_custom_pgid", dtPageId);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    private void V9(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StRight feedCloudMeta$StRight;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StRight = feedCloudMeta$StFeed.right) != null && feedCloudMeta$StRight.ugcRight != null) {
            ArrayList arrayList = new ArrayList();
            com.tencent.biz.qqcircle.utils.cq cqVar = com.tencent.biz.qqcircle.utils.cq.f92752a;
            if (cqVar.s(feedCloudMeta$StFeed)) {
                arrayList.add(W9(com.tencent.biz.qqcircle.utils.h.a(R.string.f195524eu), R.drawable.qui_eye_on, cqVar.k(cqVar.i(feedCloudMeta$StFeed)), this.L));
                com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> W9 = W9(com.tencent.biz.qqcircle.utils.h.a(R.string.f195504es), R.drawable.qui_comment, com.tencent.biz.qqcircle.utils.h.a(R.string.f184403ls), this.M);
                W9.t(true);
                arrayList.add(W9);
            } else {
                QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
                com.tencent.biz.qqcircle.immersive.utils.au.m(qCircleShareInfo, feedCloudMeta$StFeed);
                this.f88095d = qCircleShareInfo.isShowSetToPublicPermission;
                arrayList.add(X9(com.tencent.biz.qqcircle.utils.h.a(R.string.f195544ew), R.drawable.qui_lock, this.f88095d, this.J));
                if (!feedCloudMeta$StFeed.feedExtraInfo.daily.is_daily.get()) {
                    com.tencent.biz.qqcircle.immersive.utils.au.l(new QCircleShareInfo(), feedCloudMeta$StFeed);
                    this.f88096e = !r3.isNotAllowDownload;
                    arrayList.add(X9(com.tencent.biz.qqcircle.utils.h.a(R.string.f195514et), R.drawable.qui_download, this.f88096e, this.K));
                }
                if (feedCloudMeta$StFeed.opMask2.get().contains(62)) {
                    String f16 = cqVar.f(cqVar.e(feedCloudMeta$StFeed));
                    com.tencent.biz.qqcircle.immersive.personal.utils.m mVar = com.tencent.biz.qqcircle.immersive.personal.utils.m.f89099a;
                    Switch r85 = Switch.PROTECTION;
                    if (mVar.e(r85.name()) && cqVar.e(feedCloudMeta$StFeed) == RightFlag.RIGHTFLAG_NONE.getValue()) {
                        f16 = cqVar.f(RightFlag.RIGHTFLAG_QQFRIEND.getValue());
                        RFWLog.d("QOK-QFSSettingDownloadPermissionPart", RFWLog.USR, "[bindPermissionAdapterData] local open protection flag, commentSettingPermissionText: " + f16);
                        na(feedCloudMeta$StFeed);
                    } else if (!mVar.f(r85.name()) && !mVar.e(r85.name()) && cqVar.e(feedCloudMeta$StFeed) == RightFlag.RIGHTFLAG_QQFRIEND.getValue()) {
                        f16 = cqVar.f(RightFlag.RIGHTFLAG_NONE.getValue());
                        RFWLog.d("QOK-QFSSettingDownloadPermissionPart", RFWLog.USR, "[bindPermissionAdapterData] close protection flag, commentSettingPermissionText: " + f16);
                        na(feedCloudMeta$StFeed);
                    }
                    com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> W92 = W9(com.tencent.biz.qqcircle.utils.h.a(R.string.f195504es), R.drawable.qui_comment, f16, this.N);
                    this.P = W92;
                    arrayList.add(W92);
                }
            }
            this.H.t0(new Group((com.tencent.mobileqq.widget.listitem.a[]) arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0])));
            return;
        }
        QLog.d(getTAG(), 1, "[bindPermissionAdapterData] feed is null");
    }

    private com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> W9(String str, int i3, String str2, View.OnClickListener onClickListener) {
        return (com.tencent.mobileqq.widget.listitem.x) new oc0.a(new x.b.C8996b(str, i3), new x.c.g(str2, true, false)).x(onClickListener);
    }

    private com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.f> X9(String str, int i3, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        return (com.tencent.mobileqq.widget.listitem.x) new oc0.a(new x.b.C8996b(str, i3), new x.c.f(z16, onCheckedChangeListener)).x(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.ff
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                fg.ca(view);
            }
        });
    }

    private void Y9() {
        QFSSlidBottomView qFSSlidBottomView = this.F;
        if (qFSSlidBottomView == null) {
            return;
        }
        this.f88097f = true;
        qFSSlidBottomView.setVisibility(8);
        la(true);
    }

    private void Z9() {
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.FullWidth);
        this.H = qUIListItemAdapter;
        this.G.setAdapter(qUIListItemAdapter);
    }

    private void aa() {
        View view = this.f88100m;
        if (view == null) {
            return;
        }
        if (this.C != null && this.F != null) {
            this.E.setVisibility(0);
            this.F.j(this.D);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f54522ff);
        this.C = viewStub;
        FrameLayout frameLayout = (FrameLayout) viewStub.inflate().findViewById(R.id.f32590u6);
        this.E = frameLayout;
        this.F = (QFSSlidBottomView) frameLayout.findViewById(R.id.f54592fm);
        this.D = this.E.findViewById(R.id.f511827e);
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) this.E.findViewById(R.id.f48121z5);
        this.G = qUISettingsRecyclerView;
        qUISettingsRecyclerView.setDividerStyle(QUISettingsRecyclerView.DividerStyle.Hidden);
        Z9();
        ba();
    }

    private void ba() {
        this.F.c(new d());
        this.E.setVisibility(0);
        this.F.j(this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void ca(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void da(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.utils.cq.f92752a.u(getContext(), this.I, 4);
        Y9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ea(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QCircleToast.h(R.string.f195534ev, 0);
        Y9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ga(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        new QFSSettingCommentPermissionBottomDialog(getContext(), this.I, getReportBean()).show();
        Y9();
        R9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ha(RightInfo rightInfo) {
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar;
        RightFlag rightFlag;
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar2 = this.P;
        if (xVar2 != null && xVar2.O() != null && rightInfo != null && (rightFlag = rightInfo.right_flag) != null) {
            String f16 = com.tencent.biz.qqcircle.utils.cq.f92752a.f(rightFlag.getValue());
            this.P.O().h(f16);
            RFWLog.d("QOK-QFSSettingDownloadPermissionPart", RFWLog.USR, "[updateCommentPermissionFlagText] local open protection flag, text: " + f16);
        }
        QUIListItemAdapter qUIListItemAdapter = this.H;
        if (qUIListItemAdapter != null && (xVar = this.P) != null) {
            qUIListItemAdapter.l0(xVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia() {
        if (this.I == null) {
            return;
        }
        if (!HostNetworkUtils.isNetworkAvailable()) {
            QCircleToast.l(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f19228473), 0, true, false);
            QLog.d("QFSSettingDownloadPermissionPart", 1, "setting permission fail");
        } else {
            VSNetworkHelper.getInstance().sendRequest(new QFSSettingDownloadPermissionRequest(this.I, this.f88096e ? 1 : 0), new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.I;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        com.tencent.biz.qqcircle.utils.bm.k(feedCloudMeta$StFeed, !this.f88095d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(boolean z16) {
        if (getActivity() instanceof QCircleTransFragmentActivity) {
            return;
        }
        com.tencent.biz.qqcircle.immersive.utils.ax.g(getContext(), z16);
    }

    private void ma() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.I;
        if (feedCloudMeta$StFeed == null) {
            QLog.e(getTAG(), 1, "[setButtonState] mFeed is null");
            return;
        }
        V9(feedCloudMeta$StFeed);
        this.f88098h = this.f88095d ? 1 : 0;
        this.f88099i = this.f88096e ? 1 : 0;
        this.f88097f = false;
    }

    private void na(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        com.tencent.biz.qqcircle.utils.ay.c(com.tencent.biz.qqcircle.utils.bj.g(feedCloudMeta$StFeed), new ay.a() { // from class: com.tencent.biz.qqcircle.immersive.part.fe
            @Override // com.tencent.biz.qqcircle.utils.ay.a
            public final void a(RightInfo rightInfo) {
                fg.this.ha(rightInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.I;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        feedCloudMeta$StFeed.right.notAllowDownLoad.set(!this.f88096e);
        w20.a.j().initOrUpdateGlobalState((w20.a) new e30.b(this.I), true);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSOpenSettingPermissionWindowEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSettingDownloadPermissionPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, la0.a
    public QCircleReportBean getReportBean() {
        IPartHost partHost = getPartHost();
        if (partHost instanceof com.tencent.biz.qqcircle.richframework.part.a) {
            Object reportBean = ((com.tencent.biz.qqcircle.richframework.part.a) partHost).getReportBean();
            if (reportBean instanceof QCircleReportBean) {
                return (QCircleReportBean) reportBean;
            }
        }
        return super.getReportBean();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        String str2;
        super.handleBroadcastMessage(str, obj);
        if (!"layer_open_setting_permission_window".equals(str) || !(obj instanceof e30.b)) {
            return;
        }
        this.I = ((e30.b) obj).g();
        String tag = getTAG();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[handleBroadcastMessage] feedId=");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.I;
        if (feedCloudMeta$StFeed == null) {
            str2 = "";
        } else {
            str2 = feedCloudMeta$StFeed.f398449id.get();
        }
        sb5.append(str2);
        QLog.d(tag, 1, sb5.toString());
        aa();
        ma();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (258 == i3) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSCommentPermissionUserUpdateEvent(getContext(), intent));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QFSSlidBottomView qFSSlidBottomView = this.F;
        if (qFSSlidBottomView != null && qFSSlidBottomView.getVisibility() == 0) {
            this.F.d();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f88100m = view;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        this.f88097f = true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        String str;
        if ((simpleBaseEvent instanceof QFSOpenSettingPermissionWindowEvent) && simpleBaseEvent.mHashCode == getActivityHashCode()) {
            QFSOpenSettingPermissionWindowEvent qFSOpenSettingPermissionWindowEvent = (QFSOpenSettingPermissionWindowEvent) simpleBaseEvent;
            this.I = qFSOpenSettingPermissionWindowEvent.getFeed();
            if (qFSOpenSettingPermissionWindowEvent.getIsOpen()) {
                String tag = getTAG();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[onReceiveEvent] feedId=");
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.I;
                if (feedCloudMeta$StFeed == null) {
                    str = "";
                } else {
                    str = feedCloudMeta$StFeed.f398449id.get();
                }
                sb5.append(str);
                QLog.d(tag, 1, sb5.toString());
                aa();
                ma();
                return;
            }
            Y9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements QCircleSlidBottomView.d {
        d() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void a() {
            fg.this.U9();
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public /* synthetic */ void onConfigurationChanged() {
            com.tencent.biz.qqcircle.utils.ad.a(this);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onDismiss() {
            String str;
            fg.this.f88097f = true;
            SimpleEventBus.getInstance().dispatchEvent(new QFSOpenSettingPermissionWindowEvent(fg.this.I, false));
            fg.this.la(true);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if (fg.this.I == null) {
                str = "";
            } else {
                str = fg.this.I.f398449id.get();
            }
            simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(12, str, false));
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onShow() {
            String str;
            fg.this.la(false);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if (fg.this.I == null) {
                str = "";
            } else {
                str = fg.this.I.f398449id.get();
            }
            simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(12, str, true));
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onStatusChange(int i3) {
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onScrollChanged(int i3, int i16, int i17, int i18) {
        }
    }
}
