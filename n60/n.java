package n60;

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
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleSettingBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.QFSPersonalMenuInfo;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSPanelProfileFragment;
import com.tencent.biz.qqcircle.immersive.personal.adapter.k;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleSetUnCareRequest;
import com.tencent.biz.qqcircle.utils.ai;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StMainPageBasicBusiRspData;
import qqcircle.QQCircleRight$SetCircleUnCareRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class n extends n60.b implements View.OnClickListener {
    private RecyclerView C;
    private QUISettingsRecyclerView D;
    private com.tencent.biz.qqcircle.immersive.personal.adapter.l E;
    private QUIListItemAdapter F;
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.t G;
    private v.a H;
    private QUSHalfScreenFloatingView I;
    private com.tencent.biz.qqcircle.widgets.comment.e J;
    private boolean K;
    private QFSBaseFragment L;

    /* renamed from: f */
    private ImageView f418438f;

    /* renamed from: h */
    private ImageView f418439h;

    /* renamed from: i */
    private View f418440i;

    /* renamed from: m */
    private View f418441m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends v.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public List<String> a() {
            return Arrays.asList("key_update_version_main_basic_base_rsp");
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public void d(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            n.this.B0(wVar);
            if (wVar != null && !wVar.x() && n.this.K) {
                n.this.w0();
                n.this.K = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d */
        int f418443d = 0;

        /* renamed from: e */
        final /* synthetic */ View f418444e;

        /* renamed from: f */
        final /* synthetic */ int f418445f;

        /* renamed from: h */
        final /* synthetic */ int f418446h;

        b(View view, int i3, int i16) {
            this.f418444e = view;
            this.f418445f = i3;
            this.f418446h = i16;
        }

        private void a() {
            if (this.f418443d == 0) {
                n.this.I.measure(this.f418445f, this.f418446h);
                this.f418443d = n.this.I.x().getMeasuredHeight();
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57419d() {
            return this.f418444e;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        /* renamed from: defaultHeight */
        public int getF57420e() {
            a();
            return this.f418443d;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            a();
            return this.f418443d;
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
            n.this.v0(qFSPersonalMenuInfo);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d */
        final /* synthetic */ Runnable f418449d;

        /* renamed from: e */
        final /* synthetic */ String f418450e;

        d(Runnable runnable, String str) {
            this.f418449d = runnable;
            this.f418450e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Runnable runnable = this.f418449d;
            if (runnable != null) {
                runnable.run();
            }
            n.this.W(this.f418450e);
            n.this.U();
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
        final /* synthetic */ com.tencent.biz.qqcircle.immersive.personal.data.w f418458a;

        h(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            this.f418458a = wVar;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleRight$SetCircleUnCareRsp qQCircleRight$SetCircleUnCareRsp) {
            if (QLog.isColorLevel()) {
                QLog.d("QFSPersonaPanelHeadViewCompact", 1, "black person: isSuccess" + z16 + "retCode:" + j3 + "    errMsg:" + str);
            }
            if (z16 && j3 == 0) {
                QCircleToast.l(QCircleToast.f91646f, com.tencent.biz.qqcircle.utils.h.a(R.string.f181343di), 0, true, false);
                n.this.x0(this.f418458a.L());
                SimpleEventBus.getInstance().dispatchEvent(new QCircleAddblackUpdateEvent(1, this.f418458a.L()));
                n nVar = n.this;
                nVar.P(nVar.b(), this.f418458a.L(), 0, 1);
                n.this.O();
                return;
            }
            QCircleToast.l(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f19228473), 0, true, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class i implements View.OnClickListener {

        /* renamed from: d */
        private final WeakReference<n> f418460d;

        public i(n nVar) {
            this.f418460d = new WeakReference<>(nVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            n nVar = this.f418460d.get();
            if (nVar == null) {
                QLog.e("TitleMenuBtnClickListener", 1, "[onClick] viewCompact is null");
            } else {
                nVar.b0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class j implements View.OnClickListener {

        /* renamed from: d */
        private final WeakReference<n> f418461d;

        public j(n nVar) {
            this.f418461d = new WeakReference<>(nVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            n nVar = this.f418461d.get();
            if (nVar == null) {
                QLog.e("ZoomOutBtnClickListener", 1, "[onClick] viewCompact is null");
            } else {
                nVar.l0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public n(@NonNull n60.a aVar) {
        super(aVar);
        this.K = false;
    }

    private void A0(Dialog dialog) {
        if (dialog != null && (b() instanceof Activity) && !((Activity) b()).isFinishing()) {
            dialog.show();
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.G.N1().L()).setActionType(11).setSubActionType(7).setThrActionType(1).setPageId(e()).setfPageId(g().getFromPageId()));
        }
    }

    public void B0(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        int i3;
        ImageView imageView = this.f418439h;
        if (imageView != null && wVar != null) {
            if (QCirclePluginGlobalInfo.H()) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            imageView.setVisibility(i3);
            N(wVar);
        }
    }

    private void N(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        String str;
        if (this.f418439h == null || wVar == null || !wVar.z()) {
            return;
        }
        VideoReport.setElementId(this.f418439h, "em_xsj_more_button");
        if (TextUtils.isEmpty(wVar.s("CreatorCenterUrl"))) {
            str = "0";
        } else {
            str = "1";
        }
        VideoReport.setElementParam(this.f418439h, QCircleDaTongConstant.ElementParamKey.XSJ_IF_CP_CENTER, str);
    }

    public void O() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
        if (tVar != null && tVar.N1() != null) {
            String L1 = this.G.L1();
            if (TextUtils.isEmpty(L1)) {
                return;
            }
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setToUin(this.G.N1().L()).setActionType(65).setSubActionType(10).setFeedId(L1).setPageId(e()).setfpageid(g().getFromPageId()));
        }
    }

    private Group Q(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        ArrayList arrayList = new ArrayList();
        if (!wVar.v() && !wVar.w()) {
            arrayList.add(R(b().getString(R.string.f184893n4), R.drawable.qui_share, T(new n60.g(this), "share")));
        }
        if (!wVar.z() && wVar.e().urgeStatus.get() != 0) {
            arrayList.add(R(b().getString(R.string.f194314bk), R.drawable.qui_point_to, T(new Runnable() { // from class: n60.h
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.c0();
                }
            }, QCircleDaTongConstant.ElementParamValue.PUSH_UPDATE)));
        }
        arrayList.add(R(b().getString(R.string.f184733mo), R.drawable.qui_complaint, T(new Runnable() { // from class: n60.i
            @Override // java.lang.Runnable
            public final void run() {
                n.this.X();
            }
        }, "report")));
        if (!wVar.v()) {
            arrayList.add(R(b().getString(R.string.f181333dh), R.drawable.qui_shield, T(new Runnable() { // from class: n60.j
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.z0();
                }
            }, QCircleDaTongConstant.ElementParamValue.ADDTO_BLACKLIST)));
        }
        return Group.INSTANCE.d((com.tencent.mobileqq.widget.listitem.a[]) arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]));
    }

    private x R(String str, int i3, View.OnClickListener onClickListener) {
        return (x) new x(new x.b.C8996b(str, i3), new x.c.g("", true, false)).x(onClickListener);
    }

    private Group S(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(R(b().getString(R.string.f184893n4), R.drawable.qui_share, T(new n60.g(this), "share")));
        if (!wVar.u(13)) {
            arrayList.add(R(b().getString(R.string.f1899440r), R.drawable.f161634kk2, T(new Runnable() { // from class: n60.k
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.s0();
                }
            }, QCircleDaTongConstant.ElementParamValue.SHOW_WINDOW)));
        }
        if (!wVar.u(14)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("show Shopping ");
            sb5.append(!wVar.u(14));
            QLog.i("QFSPersonaPanelHeadViewCompact", 1, sb5.toString());
            arrayList.add(R(b().getString(R.string.f1899540s), R.drawable.f161632kk0, T(new Runnable() { // from class: n60.l
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.t0();
                }
            }, QCircleDaTongConstant.ElementParamValue.CANCLE_ORDER)));
        }
        if (!wVar.u(5)) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("show Money ");
            sb6.append(!this.G.N1().u(5));
            QLog.d("QFSPersonaPanelHeadViewCompact", 1, sb6.toString());
            arrayList.add(R(com.tencent.biz.qqcircle.immersive.utils.r.y(wVar, "WalletSheetTitle", b().getString(R.string.f184213l_)), R.drawable.qui_wallet, T(new Runnable() { // from class: n60.m
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.r0();
                }
            }, QCircleDaTongConstant.ElementParamValue.WALLET)));
        }
        if (k0(wVar)) {
            arrayList.add(R(b().getString(R.string.f19079432), R.drawable.qui_gift, T(new Runnable() { // from class: n60.d
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.m0();
                }
            }, QCircleDaTongConstant.ElementParamValue.GIFT)));
        }
        if (uq3.c.k0()) {
            arrayList.add(Y());
        }
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]));
    }

    private View.OnClickListener T(Runnable runnable, String str) {
        return new d(runnable, str);
    }

    public void U() {
        com.tencent.biz.qqcircle.widgets.comment.e eVar = this.J;
        if (eVar != null) {
            eVar.dismiss();
        }
    }

    private void V() {
        if (this.f418440i != null && i() != null) {
            VideoReport.setElementId(this.f418441m, QCircleDaTongConstant.ElementId.EM_XSJ_MORE_PANEL);
            HashMap hashMap = new HashMap();
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
            if (tVar != null && tVar.N1().u(13)) {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_PRODUCT_INFO, "1");
            } else {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_PRODUCT_INFO, "0");
            }
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar2 = this.G;
            if (tVar2 != null && tVar2.N1().u(14)) {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_MY_SHOPPING, "1");
            } else {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_MY_SHOPPING, "0");
            }
            VideoReport.setElementParams(this.f418440i, hashMap);
            VideoReport.setLogicParent(this.f418440i, i());
            return;
        }
        QLog.d("QFSPersonaPanelHeadViewCompact", 1, "[dtReportBindMoreAction] moreActionSheet, moreActionSheet.mRootView or rootView is null. ");
    }

    public void W(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", str);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_PANEL_ACTION, buildElementParams);
    }

    public void X() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
        if (tVar != null && tVar.N1() != null) {
            com.tencent.biz.qqcircle.immersive.personal.data.w N1 = this.G.N1();
            String b16 = com.tencent.biz.qqcircle.utils.u.b(N1.L());
            if (TextUtils.isEmpty(b16)) {
                return;
            }
            String Z = Z(N1);
            if (TextUtils.isEmpty(Z)) {
                com.tencent.biz.qqcircle.utils.u.a(new QCircleEvilReportInfo.Builder().setSubapp("wezone_profile").setScene("25015").setEviluind(b16).setContentid(new QCircleEvilReportInfo.ContentIdBuilder().setAccount_Type("1").getContentId()).build());
            } else {
                QLog.d("QFSPersonaPanelHeadViewCompact", 1, "[evilReport] new flow url: " + Z);
                com.tencent.biz.qqcircle.launcher.c.g(RFWApplication.getApplication(), Z);
            }
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(N1.L()).setActionType(11).setSubActionType(8).setThrActionType(0).setExt9(this.G.L1()).setFeedReportInfo(this.G.M1()).setPageId(e()).setfPageId(g().getFromPageId()));
        }
    }

    private x Y() {
        x R = R(b().getString(R.string.f195654f7), R.drawable.qui_qrcode, T(new Runnable() { // from class: n60.c
            @Override // java.lang.Runnable
            public final void run() {
                n.this.w0();
            }
        }, QCircleDaTongConstant.ElementParamValue.QRCODE));
        if (ai.d() && uq3.c.j0()) {
            R.v(new e());
        }
        return R;
    }

    private String Z(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
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

    private void a0() {
        U();
    }

    public void c0() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
        if (tVar != null && tVar.N1() != null) {
            com.tencent.biz.qqcircle.immersive.personal.request.b.q(this.G.N1());
        }
    }

    private void d0() {
        com.tencent.biz.qqcircle.immersive.personal.adapter.l lVar = new com.tencent.biz.qqcircle.immersive.personal.adapter.l();
        this.E = lVar;
        lVar.j0(new c());
        this.C.setLayoutManager(new SafeStaggeredGridLayoutManager(3, 1));
        this.C.setAdapter(this.E);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.Card);
        this.F = qUIListItemAdapter;
        this.D.setAdapter(qUIListItemAdapter);
    }

    private void e0() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
        if (tVar != null && tVar.N1() != null) {
            this.C.setVisibility(8);
            com.tencent.biz.qqcircle.immersive.personal.data.w N1 = this.G.N1();
            QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.FullWidth);
            this.F = qUIListItemAdapter;
            this.D.setAdapter(qUIListItemAdapter);
            this.D.addItemDecoration(new f());
            this.F.t0(Q(N1));
        }
    }

    private void f0() {
        this.I = new QUSHalfScreenFloatingView(b());
        View inflate = LayoutInflater.from(b()).inflate(R.layout.gmj, (ViewGroup) null);
        this.f418440i = inflate.findViewById(R.id.f46801vk);
        this.f418441m = inflate.findViewById(R.id.f46771vh);
        this.C = (RecyclerView) inflate.findViewById(R.id.f55632if);
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) inflate.findViewById(R.id.f34550zg);
        this.D = qUISettingsRecyclerView;
        qUISettingsRecyclerView.setDividerStyle(QUISettingsRecyclerView.DividerStyle.Hidden);
        this.f418440i.setOnClickListener(this);
        this.f418441m.setOnClickListener(this);
        d0();
        if (this.G.N1().z()) {
            g0();
            y0(R.drawable.qui_common_bg_bottom_standard_r8_top);
            this.f418441m.setBackground(b().getDrawable(R.drawable.ki_));
        } else {
            e0();
            y0(0);
            this.f418441m.setBackground(b().getDrawable(R.drawable.qui_common_bg_middle_light_bg));
        }
        this.I.setQUSDragFloatController(new b(inflate, View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0)));
        com.tencent.biz.qqcircle.widgets.comment.e eVar = new com.tencent.biz.qqcircle.widgets.comment.e(b(), R.style.MenuDialogStyle);
        this.J = eVar;
        eVar.getWindow().setWindowAnimations(R.style.f173293c);
        this.I.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: n60.f
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                n.this.U();
            }
        });
        this.J.setContentView(this.I);
    }

    private void g0() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
        if (tVar != null && tVar.N1() != null) {
            this.C.setVisibility(0);
            V();
            com.tencent.biz.qqcircle.immersive.personal.data.w N1 = this.G.N1();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new QFSPersonalMenuInfo(b().getString(R.string.f194534c6), R.drawable.qui_time));
            if (N1.u(20)) {
                arrayList.add(new QFSPersonalMenuInfo(b().getString(R.string.f1909943l), R.drawable.qui_message_record));
            }
            arrayList.add(new QFSPersonalMenuInfo(b().getString(R.string.f184863n1), R.drawable.qui_setting));
            this.E.setDatas(arrayList);
            this.F.t0(S(N1));
        }
    }

    private FeedCloudMeta$StFeed getFeed() {
        FeedCloudMeta$StShare feedCloudMeta$StShare = new FeedCloudMeta$StShare();
        feedCloudMeta$StShare.set(this.G.N1().b().share.get());
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        feedCloudMeta$StUser.set(this.G.N1().c());
        feedCloudMeta$StUser.busiData.set(ByteStringMicro.copyFrom(this.G.N1().a().toByteArray()));
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        feedCloudMeta$StFeed.poster = feedCloudMeta$StUser;
        feedCloudMeta$StFeed.share = feedCloudMeta$StShare;
        return feedCloudMeta$StFeed;
    }

    private void i0() {
        QFSPanelProfileFragment qFSPanelProfileFragment;
        if (this.L instanceof QFSPanelProfileFragment) {
            qFSPanelProfileFragment = (QFSPanelProfileFragment) c();
        } else {
            qFSPanelProfileFragment = null;
        }
        if (qFSPanelProfileFragment != null) {
            ImageView pi5 = qFSPanelProfileFragment.pi();
            this.f418439h = pi5;
            if (pi5 != null) {
                pi5.setOnClickListener(new i(this));
            }
            ImageView qi5 = qFSPanelProfileFragment.qi();
            this.f418438f = qi5;
            if (qi5 != null) {
                qi5.setOnClickListener(new j(this));
                return;
            }
            return;
        }
        QLog.d("QFSPersonaPanelHeadViewCompact", 1, "[initView] fragment is null");
    }

    private boolean j0() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
        if (tVar == null || tVar.N1() == null || !this.G.N1().x()) {
            return false;
        }
        QCircleToast.l(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f1924147f), 0, true, false);
        return true;
    }

    private boolean k0(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (wVar == null || ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() || wVar.e().giftCnt.get() <= 0) {
            return false;
        }
        return true;
    }

    public void m0() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
        if (tVar != null && tVar.N1() != null) {
            com.tencent.biz.qqcircle.launcher.c.g(b(), "https://h5.qzone.qq.com/v2/wezone/giftwall?_wv=3&_wwv=1&left_back_icon=0&src_type=web&version=1&uin=" + this.G.N1().L());
        }
    }

    private void n0(String str) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
        if (tVar != null && tVar.N1() != null) {
            String s16 = this.G.N1().s(str);
            if (TextUtils.isEmpty(s16)) {
                QLog.i("QFSPersonaPanelHeadViewCompact", 1, " url is empty! url key =" + str);
                return;
            }
            com.tencent.biz.qqcircle.launcher.c.g(b(), s16);
        }
    }

    private void o0() {
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUser(this.G.N1().c());
        com.tencent.biz.qqcircle.launcher.c.h0(b(), qCircleInitBean);
    }

    private void p0() {
        com.tencent.biz.qqcircle.launcher.c.C0(b(), new QCircleSettingBean());
    }

    public void q0() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
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
            this.L.getPartManager().broadcastMessage("share_action_show_share_sheet", qCircleShareInfo);
        }
    }

    public void r0() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
        if (tVar != null && tVar.N1() != null) {
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.G.N1().L()).setActionType(11).setSubActionType(34).setThrActionType(2));
            com.tencent.biz.qqcircle.launcher.c.o0(b(), uq3.c.f4(), null, -1);
        }
    }

    public /* synthetic */ void s0() {
        n0("mainpageEShopManagerUrl");
    }

    public /* synthetic */ void t0() {
        n0("mainpageEShopOrderUrl");
    }

    public /* synthetic */ void u0(com.tencent.biz.qqcircle.immersive.personal.data.w wVar, DialogInterface dialogInterface, int i3) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetUnCareRequest(wVar.L(), 1, 1, null), new h(wVar));
        dialogInterface.dismiss();
    }

    public void v0(QFSPersonalMenuInfo qFSPersonalMenuInfo) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar;
        String str;
        if (!fb0.a.a("showMoreActionSheetClick") && qFSPersonalMenuInfo != null && (tVar = this.G) != null && tVar.N1() != null) {
            com.tencent.biz.qqcircle.immersive.personal.data.w N1 = this.G.N1();
            String title = qFSPersonalMenuInfo.getTitle();
            if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f184733mo))) {
                X();
                str = "report";
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f181333dh))) {
                z0();
                str = QCircleDaTongConstant.ElementParamValue.ADDTO_BLACKLIST;
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f1899540s))) {
                n0("mainpageEShopOrderUrl");
                str = QCircleDaTongConstant.ElementParamValue.CANCLE_ORDER;
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f1899440r))) {
                n0("mainpageEShopManagerUrl");
                str = QCircleDaTongConstant.ElementParamValue.SHOW_WINDOW;
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.immersive.utils.r.y(N1, "WalletSheetTitle", b().getString(R.string.f184213l_)))) {
                r0();
                str = QCircleDaTongConstant.ElementParamValue.WALLET;
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f184893n4))) {
                q0();
                str = "share";
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f194534c6))) {
                o0();
                str = QCircleDaTongConstant.ElementParamValue.RECENTLY_WATCHED;
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f184863n1))) {
                p0();
                str = QCircleDaTongConstant.ElementParamValue.SETTINGS;
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f1909943l))) {
                n0("mainpageCommentHistoryUrl");
                str = QCircleDaTongConstant.ElementParamValue.PAST_COMMENT;
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f195654f7))) {
                w0();
                str = QCircleDaTongConstant.ElementParamValue.QRCODE;
            } else if (TextUtils.equals(title, com.tencent.biz.qqcircle.utils.h.a(R.string.f19079432))) {
                m0();
                str = QCircleDaTongConstant.ElementParamValue.GIFT;
            } else {
                str = "cancel";
            }
            W(str);
            U();
        }
    }

    public void w0() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
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
            this.L.getPartManager().broadcastMessage("share_action_show_share_sheet", qCircleShareInfo);
        }
    }

    private void y0(int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(b());
        relativeLayout.setBackgroundResource(i3);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        QUSHalfScreenDefaultHeaderView qUSHalfScreenDefaultHeaderView = new QUSHalfScreenDefaultHeaderView(b(), null, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dpToPx(5.0f));
        layoutParams.topMargin = ViewUtils.dpToPx(4.0f);
        relativeLayout.addView(qUSHalfScreenDefaultHeaderView, layoutParams);
        this.I.setHeaderView(relativeLayout);
    }

    public void z0() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
        if (tVar != null && tVar.N1() != null) {
            final com.tencent.biz.qqcircle.immersive.personal.data.w N1 = this.G.N1();
            QCircleCustomDialog.P(b(), null, com.tencent.biz.qqcircle.utils.h.a(R.string.f181353dj), R.string.cancel, R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: n60.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    n.this.u0(N1, dialogInterface, i3);
                }
            }, new g()).show();
        }
    }

    public void P(Context context, String str, int i3, int i16) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent("action_update_web_user_follow_state");
        intent.putExtra("uin", str);
        intent.putExtra("followstate", i3);
        intent.putExtra("blackstate", i16);
        context.sendBroadcast(intent);
    }

    public void b0() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
        if (tVar == null || tVar.N1() == null || j0() || fb0.a.a("QFSPersonaPanelHeadViewCompact_handleMenuEntranceClick")) {
            return;
        }
        f0();
        com.tencent.biz.qqcircle.widgets.comment.e eVar = this.J;
        if (eVar == null) {
            return;
        }
        A0(eVar);
    }

    @Override // n60.b
    public void j(@NonNull QFSBaseFragment qFSBaseFragment) {
        this.L = qFSBaseFragment;
        i0();
        this.G = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.t) qFSBaseFragment.getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.t.class);
        this.H = new a();
        this.G.O1().observeForever(this.H);
    }

    public void l0() {
        com.tencent.biz.qqcircle.immersive.personal.data.w wVar;
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
        if (tVar != null) {
            wVar = tVar.N1();
        } else {
            wVar = null;
        }
        if (wVar == null || j0() || fb0.a.a("QFSPersonaPanelHeadViewCompact_jumpFullScreenPersonalPage")) {
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUser(wVar.c());
        qCircleInitBean.setFromReportBean(g().m466clone());
        qCircleInitBean.setLaunchFrom("QFSPersonaPanelHeadViewCompact");
        com.tencent.biz.qqcircle.launcher.c.d0(b(), qCircleInitBean);
    }

    @Override // n60.b
    public void m(Configuration configuration) {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.I;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.L();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!j0() && view.getId() == R.id.f46801vk) {
            a0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // n60.b, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        this.G.O1().removeObserver(this.H);
        super.onPartDestroy(activity);
    }

    @Override // n60.b
    public void s(Activity activity) {
        super.s(activity);
        com.tencent.biz.qqcircle.widgets.comment.e eVar = this.J;
        if (eVar != null && eVar.isShowing()) {
            this.J.dismiss();
        }
    }

    public void x0(String str) {
        Intent intent = new Intent();
        intent.setAction("action_reload_get_main_page");
        intent.putExtra("uin", str);
        if (b() != null) {
            b().sendBroadcast(intent);
        }
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
                    View childAt = viewGroup.getChildAt(0);
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) childAt;
                        if (viewGroup2.getChildCount() >= 2) {
                            n.this.I.j(new b((mc0.a) mc0.a.c(n.this.b(), R.string.f195664f8).setAnchor(viewGroup2.getChildAt(1)).setPosition(3).setAlignment(0).addStatusCallback(new a())));
                        }
                    }
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes4.dex */
        class a implements RFWSmartPopupWindow.IStatusCallback {
            a() {
            }

            @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
            public void onShow() {
                ai.i();
            }

            @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
            public void onDismiss() {
            }

            @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
            public void onClick(View view) {
            }
        }

        /* compiled from: P */
        /* loaded from: classes4.dex */
        class b implements QUSBaseHalfScreenFloatingView.p {

            /* renamed from: d */
            final /* synthetic */ mc0.a f418454d;

            b(mc0.a aVar) {
                this.f418454d = aVar;
            }

            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
            public void onShowDefault() {
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

    @Override // n60.b
    public void o() {
    }
}
