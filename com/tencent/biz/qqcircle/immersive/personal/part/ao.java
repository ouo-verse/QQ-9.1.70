package com.tencent.biz.qqcircle.immersive.personal.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleSettingBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.QFSPersonalMenuInfo;
import com.tencent.biz.qqcircle.immersive.personal.adapter.k;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleSetUnCareRequest;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.event.QCircleAddblackUpdateEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenDefaultHeaderView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StShare;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StMainPageBasicBusiRspData;
import qqcircle.QQCircleRight$SetCircleUnCareRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ao extends com.tencent.biz.qqcircle.immersive.part.u implements View.OnClickListener {
    private QUIListItemAdapter C;
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.t D;
    private v.a E;
    private QUSHalfScreenFloatingView F;
    private com.tencent.biz.qqcircle.widgets.comment.e G;
    private boolean H = false;

    /* renamed from: d */
    private ImageView f88844d;

    /* renamed from: e */
    private View f88845e;

    /* renamed from: f */
    private View f88846f;

    /* renamed from: h */
    private RecyclerView f88847h;

    /* renamed from: i */
    private QUISettingsRecyclerView f88848i;

    /* renamed from: m */
    private com.tencent.biz.qqcircle.immersive.personal.adapter.l f88849m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends v.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public List<String> a() {
            return Arrays.asList("key_update_version_main_basic_base_rsp");
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public void d(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            ao.this.Ca(wVar);
            if (wVar != null && !wVar.x() && ao.this.H) {
                ao.this.wa();
                ao.this.H = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d */
        int f88851d = 0;

        /* renamed from: e */
        final /* synthetic */ View f88852e;

        /* renamed from: f */
        final /* synthetic */ int f88853f;

        /* renamed from: h */
        final /* synthetic */ int f88854h;

        b(View view, int i3, int i16) {
            this.f88852e = view;
            this.f88853f = i3;
            this.f88854h = i16;
        }

        private void a() {
            if (this.f88851d == 0) {
                ao.this.F.measure(this.f88853f, this.f88854h);
                this.f88851d = ao.this.F.x().getMeasuredHeight();
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57419d() {
            return this.f88852e;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        /* renamed from: defaultHeight */
        public int getF57420e() {
            a();
            return this.f88851d;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            a();
            return this.f88851d;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements k.b {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.k.b
        public void a(int i3, QFSPersonalMenuInfo qFSPersonalMenuInfo, View view) {
            ao.this.va(qFSPersonalMenuInfo);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d */
        final /* synthetic */ Runnable f88857d;

        /* renamed from: e */
        final /* synthetic */ String f88858e;

        d(Runnable runnable, String str) {
            this.f88857d = runnable;
            this.f88858e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Runnable runnable = this.f88857d;
            if (runnable != null) {
                runnable.run();
            }
            ao.this.Z9(this.f88858e);
            ao.this.getPartManager().broadcastMessage("qfs_close_personal_menu_dialog", null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f extends RecyclerView.ItemDecoration {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (recyclerView.getChildPosition(view) == 0) {
                rect.top = -ViewUtils.dip2px(14.0f);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class h implements VSDispatchObserver.OnVSRspCallBack<QQCircleRight$SetCircleUnCareRsp> {

        /* renamed from: a */
        final /* synthetic */ com.tencent.biz.qqcircle.immersive.personal.data.w f88866a;

        h(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            this.f88866a = wVar;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleRight$SetCircleUnCareRsp qQCircleRight$SetCircleUnCareRsp) {
            if (QLog.isColorLevel()) {
                QLog.d("QFSPersonalMenuPart", 1, "black person: isSuccess" + z16 + "retCode:" + j3 + "    errMsg:" + str);
            }
            if (z16 && j3 == 0) {
                QCircleToast.l(QCircleToast.f91646f, com.tencent.biz.qqcircle.utils.h.a(R.string.f181343di), 0, true, false);
                ao.this.xa(this.f88866a.L());
                SimpleEventBus.getInstance().dispatchEvent(new QCircleAddblackUpdateEvent(1, this.f88866a.L()));
                ao aoVar = ao.this;
                aoVar.S9(aoVar.getContext(), this.f88866a.L(), 0, 1);
                ao.this.R9();
                return;
            }
            QCircleToast.l(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f19228473), 0, true, false);
        }
    }

    public void Aa() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.D;
        if (tVar != null && tVar.N1() != null) {
            final com.tencent.biz.qqcircle.immersive.personal.data.w N1 = this.D.N1();
            QCircleCustomDialog.P(getContext(), null, com.tencent.biz.qqcircle.utils.h.a(R.string.f181353dj), R.string.cancel, R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.am
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ao.this.ua(N1, dialogInterface, i3);
                }
            }, new g()).show();
        }
    }

    private void Ba(Dialog dialog) {
        if (dialog != null && (getContext() instanceof Activity) && !((Activity) getContext()).isFinishing()) {
            dialog.show();
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.D.N1().L()).setActionType(11).setSubActionType(7).setThrActionType(1).setPageId(getPageId()).setfPageId(getFromPageId()));
        }
    }

    public void Ca(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        ImageView imageView = this.f88844d;
        if (imageView != null && wVar != null) {
            imageView.setVisibility(8);
            Q9(wVar);
        }
    }

    private void Q9(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        String str;
        if (this.f88844d == null || wVar == null || !wVar.z()) {
            return;
        }
        VideoReport.setElementId(this.f88844d, "em_xsj_more_button");
        if (TextUtils.isEmpty(wVar.s("CreatorCenterUrl"))) {
            str = "0";
        } else {
            str = "1";
        }
        VideoReport.setElementParam(this.f88844d, QCircleDaTongConstant.ElementParamKey.XSJ_IF_CP_CENTER, str);
    }

    public void R9() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.D;
        if (tVar != null && tVar.N1() != null) {
            String L1 = this.D.L1();
            if (TextUtils.isEmpty(L1)) {
                return;
            }
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setToUin(this.D.N1().L()).setActionType(65).setSubActionType(10).setFeedId(L1).setPageId(getPageId()).setfpageid(getReportBean().getFromPageId()));
        }
    }

    private Group T9(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        ArrayList arrayList = new ArrayList();
        if (!wVar.v() && !wVar.w()) {
            arrayList.add(U9(getContext().getString(R.string.f184893n4), R.drawable.qui_share, W9(new af(this), "share")));
        }
        arrayList.add(U9(getContext().getString(R.string.f184733mo), R.drawable.qui_complaint, W9(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.ag
            @Override // java.lang.Runnable
            public final void run() {
                ao.this.aa();
            }
        }, "report")));
        if (!wVar.v()) {
            arrayList.add(U9(getContext().getString(R.string.f181333dh), R.drawable.qui_shield, W9(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.ah
                @Override // java.lang.Runnable
                public final void run() {
                    ao.this.Aa();
                }
            }, QCircleDaTongConstant.ElementParamValue.ADDTO_BLACKLIST)));
        }
        return Group.INSTANCE.d((com.tencent.mobileqq.widget.listitem.a[]) arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]));
    }

    private com.tencent.mobileqq.widget.listitem.x U9(String str, int i3, View.OnClickListener onClickListener) {
        return (com.tencent.mobileqq.widget.listitem.x) new com.tencent.mobileqq.widget.listitem.x(new x.b.C8996b(str, i3), new x.c.g("", true, false)).x(onClickListener);
    }

    private Group V9(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(U9(getContext().getString(R.string.f184893n4), R.drawable.qui_share, W9(new af(this), "share")));
        if (!wVar.u(13)) {
            arrayList.add(U9(getContext().getString(R.string.f1899440r), R.drawable.f161634kk2, W9(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.ai
                @Override // java.lang.Runnable
                public final void run() {
                    ao.this.sa();
                }
            }, QCircleDaTongConstant.ElementParamValue.SHOW_WINDOW)));
        }
        if (!wVar.u(14)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("show Shopping ");
            sb5.append(!wVar.u(14));
            QLog.i("QFSPersonalMenuPart", 1, sb5.toString());
            arrayList.add(U9(getContext().getString(R.string.f1899540s), R.drawable.f161632kk0, W9(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.aj
                @Override // java.lang.Runnable
                public final void run() {
                    ao.this.ta();
                }
            }, QCircleDaTongConstant.ElementParamValue.CANCLE_ORDER)));
        }
        if (!wVar.u(5)) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("show Money ");
            sb6.append(!this.D.N1().u(5));
            QLog.d("QFSPersonalMenuPart", 1, sb6.toString());
            arrayList.add(U9(com.tencent.biz.qqcircle.immersive.utils.r.y(wVar, "WalletSheetTitle", getContext().getString(R.string.f184213l_)), R.drawable.qui_wallet, W9(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.ak
                @Override // java.lang.Runnable
                public final void run() {
                    ao.this.ra();
                }
            }, QCircleDaTongConstant.ElementParamValue.WALLET)));
        }
        if (la(wVar)) {
            arrayList.add(U9(getContext().getString(R.string.f19079432), R.drawable.qui_gift, W9(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.al
                @Override // java.lang.Runnable
                public final void run() {
                    ao.this.ma();
                }
            }, QCircleDaTongConstant.ElementParamValue.GIFT)));
        }
        if (uq3.c.k0()) {
            arrayList.add(ba());
        }
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]));
    }

    private View.OnClickListener W9(Runnable runnable, String str) {
        return new d(runnable, str);
    }

    public void X9() {
        com.tencent.biz.qqcircle.widgets.comment.e eVar = this.G;
        if (eVar != null) {
            eVar.dismiss();
        }
    }

    private void Y9() {
        if (this.f88845e != null && getPartRootView() != null) {
            VideoReport.setElementId(this.f88846f, QCircleDaTongConstant.ElementId.EM_XSJ_MORE_PANEL);
            HashMap hashMap = new HashMap();
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.D;
            if (tVar != null && tVar.N1().u(13)) {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_PRODUCT_INFO, "1");
            } else {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_PRODUCT_INFO, "0");
            }
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar2 = this.D;
            if (tVar2 != null && tVar2.N1().u(14)) {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_MY_SHOPPING, "1");
            } else {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_MY_SHOPPING, "0");
            }
            VideoReport.setElementParams(this.f88845e, hashMap);
            VideoReport.setLogicParent(this.f88845e, getPartRootView());
            return;
        }
        QLog.d("QFSPersonalMenuPart", 1, "[dtReportBindMoreAction] moreActionSheet, moreActionSheet.mRootView or rootView is null. ");
    }

    public void Z9(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", str);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_PANEL_ACTION, buildElementParams);
    }

    public void aa() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.D;
        if (tVar != null && tVar.N1() != null) {
            com.tencent.biz.qqcircle.immersive.personal.data.w N1 = this.D.N1();
            String b16 = com.tencent.biz.qqcircle.utils.u.b(N1.L());
            if (TextUtils.isEmpty(b16)) {
                return;
            }
            String ca5 = ca(N1);
            if (TextUtils.isEmpty(ca5)) {
                com.tencent.biz.qqcircle.utils.u.a(new QCircleEvilReportInfo.Builder().setSubapp("wezone_profile").setScene("25015").setEviluind(b16).setContentid(new QCircleEvilReportInfo.ContentIdBuilder().setAccount_Type("1").getContentId()).build());
            } else {
                QLog.d("QFSPersonalMenuPart", 1, "[evilReport] new flow url: " + ca5);
                com.tencent.biz.qqcircle.launcher.c.g(RFWApplication.getApplication(), ca5);
            }
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(N1.L()).setActionType(11).setSubActionType(8).setThrActionType(0).setExt9(this.D.L1()).setFeedReportInfo(this.D.M1()).setPageId(getPageId()).setfPageId(getReportBean().getFromPageId()));
        }
    }

    private com.tencent.mobileqq.widget.listitem.x ba() {
        com.tencent.mobileqq.widget.listitem.x U9 = U9(getContext().getString(R.string.f195654f7), R.drawable.qui_qrcode, W9(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.an
            @Override // java.lang.Runnable
            public final void run() {
                ao.this.wa();
            }
        }, QCircleDaTongConstant.ElementParamValue.QRCODE));
        U9.v(new e());
        return U9;
    }

    private String ca(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        QQCircleFeedBase$StMainPageBasicBusiRspData e16;
        List<FeedCloudCommon$Entry> list = null;
        if (wVar == null) {
            e16 = null;
        } else {
            e16 = wVar.e();
        }
        if (e16 != null) {
            list = e16.urlInfo.get();
        }
        if (list == null || list.isEmpty()) {
            return "";
        }
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            if (feedCloudCommon$Entry != null && TextUtils.equals(feedCloudCommon$Entry.key.get(), "userReportUrl")) {
                return feedCloudCommon$Entry.value.get();
            }
        }
        return "";
    }

    private void da() {
        X9();
    }

    private void ea() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.D;
        if (tVar != null && tVar.N1() != null) {
            ia();
            com.tencent.biz.qqcircle.widgets.comment.e eVar = this.G;
            if (eVar == null) {
                return;
            }
            Ba(eVar);
        }
    }

    private void ga() {
        com.tencent.biz.qqcircle.immersive.personal.adapter.l lVar = new com.tencent.biz.qqcircle.immersive.personal.adapter.l();
        this.f88849m = lVar;
        lVar.j0(new c());
        this.f88847h.setLayoutManager(new SafeStaggeredGridLayoutManager(3, 1));
        this.f88847h.setAdapter(this.f88849m);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.Card);
        this.C = qUIListItemAdapter;
        this.f88848i.setAdapter(qUIListItemAdapter);
    }

    private FeedCloudMeta$StFeed getFeed() {
        FeedCloudMeta$StShare feedCloudMeta$StShare = new FeedCloudMeta$StShare();
        feedCloudMeta$StShare.set(this.D.N1().b().share.get());
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        feedCloudMeta$StUser.set(this.D.N1().c());
        feedCloudMeta$StUser.busiData.set(ByteStringMicro.copyFrom(this.D.N1().a().toByteArray()));
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        feedCloudMeta$StFeed.poster = feedCloudMeta$StUser;
        feedCloudMeta$StFeed.share = feedCloudMeta$StShare;
        return feedCloudMeta$StFeed;
    }

    private void ha() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.D;
        if (tVar != null && tVar.N1() != null) {
            this.f88847h.setVisibility(8);
            com.tencent.biz.qqcircle.immersive.personal.data.w N1 = this.D.N1();
            QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.FullWidth);
            this.C = qUIListItemAdapter;
            this.f88848i.setAdapter(qUIListItemAdapter);
            this.f88848i.addItemDecoration(new f());
            this.C.t0(T9(N1));
        }
    }

    private void ia() {
        this.F = new QUSHalfScreenFloatingView(getContext());
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gmj, (ViewGroup) null);
        this.f88845e = inflate.findViewById(R.id.f46801vk);
        this.f88846f = inflate.findViewById(R.id.f46771vh);
        this.f88847h = (RecyclerView) inflate.findViewById(R.id.f55632if);
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) inflate.findViewById(R.id.f34550zg);
        this.f88848i = qUISettingsRecyclerView;
        qUISettingsRecyclerView.setDividerStyle(QUISettingsRecyclerView.DividerStyle.Hidden);
        this.f88845e.setOnClickListener(this);
        this.f88846f.setOnClickListener(this);
        ga();
        if (this.D.N1().z()) {
            ja();
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_r8_top);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            relativeLayout.addView(new QUSHalfScreenDefaultHeaderView(getContext(), null, 0));
            this.F.setHeaderView(relativeLayout);
            this.f88846f.setBackground(getContext().getDrawable(R.drawable.ki_));
        } else {
            ha();
            this.f88846f.setBackground(getContext().getDrawable(R.drawable.qui_common_bg_middle_light_bg));
        }
        this.F.setQUSDragFloatController(new b(inflate, View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0)));
        com.tencent.biz.qqcircle.widgets.comment.e eVar = new com.tencent.biz.qqcircle.widgets.comment.e(getContext(), R.style.MenuDialogStyle);
        this.G = eVar;
        eVar.getWindow().setWindowAnimations(R.style.f173293c);
        this.F.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.ae
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                ao.this.X9();
            }
        });
        this.G.setContentView(this.F);
    }

    private void initViewModel() {
        this.D = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.t) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.t.class);
        this.E = new a();
        this.D.O1().observeForever(this.E);
    }

    private void ja() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.D;
        if (tVar != null && tVar.N1() != null) {
            this.f88847h.setVisibility(0);
            Y9();
            com.tencent.biz.qqcircle.immersive.personal.data.w N1 = this.D.N1();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new QFSPersonalMenuInfo(getContext().getString(R.string.f194534c6), R.drawable.qui_time));
            if (N1.u(20)) {
                arrayList.add(new QFSPersonalMenuInfo(getContext().getString(R.string.f1909943l), R.drawable.qui_message_record));
            }
            arrayList.add(new QFSPersonalMenuInfo(getContext().getString(R.string.f184863n1), R.drawable.qui_setting));
            this.f88849m.setDatas(arrayList);
            this.C.t0(V9(N1));
        }
    }

    private boolean la(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (wVar == null || ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() || wVar.e().giftCnt.get() <= 0) {
            return false;
        }
        return true;
    }

    public void ma() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.D;
        if (tVar != null && tVar.N1() != null) {
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), "https://h5.qzone.qq.com/v2/wezone/giftwall?_wv=3&_wwv=1&left_back_icon=0&src_type=web&version=1&uin=" + this.D.N1().L());
        }
    }

    private void na(String str) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.D;
        if (tVar != null && tVar.N1() != null) {
            String s16 = this.D.N1().s(str);
            if (TextUtils.isEmpty(s16)) {
                QLog.i("QFSPersonalMenuPart", 1, " url is empty! url key =" + str);
                return;
            }
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), s16);
        }
    }

    private void oa() {
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUser(this.D.N1().c());
        com.tencent.biz.qqcircle.launcher.c.h0(getContext(), qCircleInitBean);
    }

    private void pa() {
        QCircleSettingBean qCircleSettingBean = new QCircleSettingBean();
        qCircleSettingBean.setFromPage(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED);
        com.tencent.biz.qqcircle.launcher.c.C0(getContext(), qCircleSettingBean);
    }

    public void qa() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.D;
        if (tVar != null && tVar.N1() != null) {
            FeedCloudMeta$StFeed feed = getFeed();
            QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
            qCircleShareInfo.type = 1;
            qCircleShareInfo.isShowReport = false;
            qCircleShareInfo.feed = feed;
            qCircleShareInfo.shareStyleType = 2;
            boolean k06 = uq3.c.k0();
            qCircleShareInfo.isShowPersonalQrcode = k06;
            qCircleShareInfo.isShowCopySchemaLink = k06;
            qCircleShareInfo.mainPageUserUin = feed.poster.f398463id.get();
            qCircleShareInfo.feedBlockData = new e30.b(feed);
            qCircleShareInfo.source = 10;
            getPartManager().broadcastMessage("share_action_show_share_sheet", qCircleShareInfo);
        }
    }

    public void ra() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.D;
        if (tVar != null && tVar.N1() != null) {
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.D.N1().L()).setActionType(11).setSubActionType(34).setThrActionType(2));
            com.tencent.biz.qqcircle.launcher.c.o0(getContext(), uq3.c.f4(), null, -1);
        }
    }

    public /* synthetic */ void sa() {
        na("mainpageEShopManagerUrl");
    }

    public /* synthetic */ void ta() {
        na("mainpageEShopOrderUrl");
    }

    public /* synthetic */ void ua(com.tencent.biz.qqcircle.immersive.personal.data.w wVar, DialogInterface dialogInterface, int i3) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetUnCareRequest(wVar.L(), 1, 1, null), new h(wVar));
        dialogInterface.dismiss();
    }

    public void va(QFSPersonalMenuInfo qFSPersonalMenuInfo) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar;
        String str;
        if (!fb0.a.a("showMoreActionSheetClick") && qFSPersonalMenuInfo != null && (tVar = this.D) != null && tVar.N1() != null) {
            com.tencent.biz.qqcircle.immersive.personal.data.w N1 = this.D.N1();
            String title = qFSPersonalMenuInfo.getTitle();
            if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f184733mo))) {
                aa();
                str = "report";
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f181333dh))) {
                Aa();
                str = QCircleDaTongConstant.ElementParamValue.ADDTO_BLACKLIST;
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f1899540s))) {
                na("mainpageEShopOrderUrl");
                str = QCircleDaTongConstant.ElementParamValue.CANCLE_ORDER;
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f1899440r))) {
                na("mainpageEShopManagerUrl");
                str = QCircleDaTongConstant.ElementParamValue.SHOW_WINDOW;
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.immersive.utils.r.y(N1, "WalletSheetTitle", getContext().getString(R.string.f184213l_)))) {
                ra();
                str = QCircleDaTongConstant.ElementParamValue.WALLET;
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f184893n4))) {
                qa();
                str = "share";
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f194534c6))) {
                oa();
                str = QCircleDaTongConstant.ElementParamValue.RECENTLY_WATCHED;
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f184863n1))) {
                pa();
                str = QCircleDaTongConstant.ElementParamValue.SETTINGS;
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f1909943l))) {
                na("mainpageCommentHistoryUrl");
                str = QCircleDaTongConstant.ElementParamValue.PAST_COMMENT;
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f195654f7))) {
                wa();
                str = QCircleDaTongConstant.ElementParamValue.QRCODE;
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f19079432))) {
                ma();
                str = QCircleDaTongConstant.ElementParamValue.GIFT;
            } else {
                str = "cancel";
            }
            Z9(str);
            getPartManager().broadcastMessage("qfs_close_personal_menu_dialog", null);
        }
    }

    public void wa() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.D;
        if (tVar != null && tVar.N1() != null) {
            FeedCloudMeta$StFeed feed = getFeed();
            QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
            qCircleShareInfo.type = 1;
            qCircleShareInfo.feed = feed;
            qCircleShareInfo.isShowPersonalQrcodeDown = true;
            qCircleShareInfo.shareStyleType = 2;
            qCircleShareInfo.source = 7;
            qCircleShareInfo.mainPageUserUin = feed.poster.f398463id.get();
            qCircleShareInfo.feedBlockData = new e30.b(feed);
            getPartManager().broadcastMessage("share_action_show_share_sheet", qCircleShareInfo);
        }
    }

    public void S9(Context context, String str, int i3, int i16) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent("action_update_web_user_follow_state");
        intent.putExtra("uin", str);
        intent.putExtra("followstate", i3);
        intent.putExtra("blackstate", i16);
        context.sendBroadcast(intent);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalMenuPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("qfs_close_personal_menu_dialog".equals(str)) {
            X9();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("QFSPersonalMenuPart_onClick")) {
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.D;
            if (tVar != null && tVar.N1() != null && this.D.N1().x()) {
                QCircleToast.l(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f1924147f), 0, true, false);
            } else {
                int id5 = view.getId();
                if (id5 == R.id.f44641pq) {
                    ea();
                } else if (id5 == R.id.f46801vk) {
                    da();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.F;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.L();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.f44641pq);
        this.f88844d = imageView;
        imageView.setOnClickListener(this);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        this.D.O1().removeObserver(this.E);
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        com.tencent.biz.qqcircle.widgets.comment.e eVar = this.G;
        if (eVar != null && eVar.isShowing()) {
            this.G.dismiss();
        }
    }

    public void xa(String str) {
        Intent intent = new Intent();
        intent.setAction("action_reload_get_main_page");
        intent.putExtra("uin", str);
        if (getContext() != null) {
            getContext().sendBroadcast(intent);
        }
    }

    public void za(boolean z16) {
        this.H = z16;
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements com.tencent.mobileqq.widget.listitem.f {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.listitem.f
        public void a(@NonNull View view) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.getChildCount() >= 1) {
                    ao.this.F.j(new a(viewGroup.getChildAt(0)));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes4.dex */
        public class a implements QUSBaseHalfScreenFloatingView.p {

            /* renamed from: d */
            final /* synthetic */ View f88861d;

            a(View view) {
                this.f88861d = view;
            }

            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
            public void onShowDefault() {
                if (com.tencent.biz.qqcircle.utils.ai.d() && uq3.c.j0()) {
                    View view = this.f88861d;
                    if ((view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() >= 2) {
                        mc0.a.c(ao.this.getContext(), R.string.f195664f8).setAnchor(((ViewGroup) this.f88861d).getChildAt(1)).setPosition(3).setAlignment(0).addStatusCallback(new C0900a());
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.biz.qqcircle.immersive.personal.part.ao$e$a$a */
            /* loaded from: classes4.dex */
            class C0900a implements RFWSmartPopupWindow.IStatusCallback {
                C0900a() {
                }

                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public void onShow() {
                    com.tencent.biz.qqcircle.utils.ai.i();
                }

                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public void onDismiss() {
                }

                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public void onClick(View view) {
                }
            }

            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
            public void onShowDefaultStart() {
            }

            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
            public void onShowMin() {
            }

            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
            public void onShowMinStart() {
            }

            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
            public void onShowTotal() {
            }

            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
            public void onShowTotalStart() {
            }
        }
    }
}
