package com.tencent.biz.qqcircle.bizparts;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFollowUserBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleSettingBean;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageBasicDataRequest;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleSpecialFollowListBlock;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.sender.call.Call;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import feedcloud.FeedCloudRead$StGetMainPageBasicDataRsp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import qqcircle.QQCircleFeedBase$StMainPageBasicBusiRspData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class dt extends com.tencent.biz.qqcircle.bizparts.b implements Call.OnRspCallBack<QCircleBaseRequest> {

    /* renamed from: d, reason: collision with root package name */
    private QUISecNavBar f83079d;

    /* renamed from: e, reason: collision with root package name */
    private QUISettingsRecyclerView f83080e;

    /* renamed from: f, reason: collision with root package name */
    private QUIListItemAdapter f83081f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Function2<View, BaseAction, Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view, BaseAction baseAction) {
            if (baseAction == BaseAction.ACTION_LEFT_BUTTON) {
                dt.this.J9();
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f83083d;

        b(Runnable runnable) {
            this.f83083d = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Runnable runnable = this.f83083d;
            if (runnable != null) {
                runnable.run();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J9() {
        if (!getPartManager().onBackEvent() && getActivity() != null) {
            getActivity().finish();
        }
    }

    private void K9(List<com.tencent.mobileqq.widget.listitem.a> list) {
        if (com.tencent.biz.qqcircle.utils.k.h("exp_xsj_fbq_aiface_cluster_v2") && uq3.k.b().c("mmkv_key_first_guide_set", false)) {
            list.add(O9(com.tencent.biz.qqcircle.utils.h.a(R.string.f188283w_), new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.ds
                @Override // java.lang.Runnable
                public final void run() {
                    dt.this.W9();
                }
            }));
        }
    }

    private Group L9() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(O9(com.tencent.biz.qqcircle.utils.h.a(R.string.f184383lq), new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.dm
            @Override // java.lang.Runnable
            public final void run() {
                dt.this.da();
            }
        }));
        if (com.tencent.biz.qqcircle.manager.i.a("qfs_private_message_entrance_show")) {
            arrayList.add(O9(com.tencent.biz.qqcircle.utils.h.a(R.string.f185193nx), new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.dn
                @Override // java.lang.Runnable
                public final void run() {
                    dt.this.ba();
                }
            }));
        }
        if (U9()) {
            arrayList.add(O9(com.tencent.biz.qqcircle.utils.h.a(R.string.f196434ha), new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.do
                @Override // java.lang.Runnable
                public final void run() {
                    dt.this.aa();
                }
            }));
            K9(arrayList);
            arrayList.add(O9(com.tencent.biz.qqcircle.utils.h.a(R.string.f183953kk), new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.dp
                @Override // java.lang.Runnable
                public final void run() {
                    dt.this.Y9();
                }
            }));
        } else {
            arrayList.add(O9(com.tencent.biz.qqcircle.utils.h.a(R.string.f185123nq), new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.dq
                @Override // java.lang.Runnable
                public final void run() {
                    dt.this.ea();
                }
            }));
            arrayList.add(O9(com.tencent.biz.qqcircle.utils.h.a(R.string.f196434ha), new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.do
                @Override // java.lang.Runnable
                public final void run() {
                    dt.this.aa();
                }
            }));
            K9(arrayList);
            arrayList.add(O9(com.tencent.biz.qqcircle.utils.h.a(R.string.f184113l0), new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.dr
                @Override // java.lang.Runnable
                public final void run() {
                    dt.this.Z9();
                }
            }));
        }
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]));
    }

    private Group[] M9() {
        return new Group[]{L9(), N9()};
    }

    private Group N9() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(O9(com.tencent.biz.qqcircle.utils.h.a(R.string.f195434el), new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.dj
            @Override // java.lang.Runnable
            public final void run() {
                dt.this.ca();
            }
        }));
        arrayList.add(O9(com.tencent.biz.qqcircle.utils.h.a(R.string.f195394eh), new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.dk
            @Override // java.lang.Runnable
            public final void run() {
                dt.this.X9();
            }
        }));
        arrayList.add(O9(com.tencent.biz.qqcircle.utils.h.a(R.string.f195364ee), new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.dl
            @Override // java.lang.Runnable
            public final void run() {
                dt.this.V9();
            }
        }));
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]));
    }

    private com.tencent.mobileqq.widget.listitem.x O9(String str, Runnable runnable) {
        return P9(str, "", runnable);
    }

    private com.tencent.mobileqq.widget.listitem.x P9(String str, String str2, Runnable runnable) {
        return (com.tencent.mobileqq.widget.listitem.x) new com.tencent.mobileqq.widget.listitem.x(new x.b.d(str), new x.c.g(str2, true, false)).x(new b(runnable));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private QQCircleFeedBase$StMainPageBasicBusiRspData Q9() {
        String q16 = com.tencent.biz.qqcircle.immersive.utils.r.q();
        MutableLiveData globalData = w20.a.j().getGlobalData(QQCircleFeedBase$StMainPageBasicBusiRspData.class, q16);
        if (globalData != null && globalData.getValue() != 0) {
            return (QQCircleFeedBase$StMainPageBasicBusiRspData) globalData.getValue();
        }
        MutableLiveData globalData2 = w20.a.j().getGlobalData(com.tencent.biz.qqcircle.immersive.personal.data.w.class, q16);
        if (globalData2 != null && globalData2.getValue() != 0) {
            return ((com.tencent.biz.qqcircle.immersive.personal.data.w) globalData2.getValue()).e();
        }
        return null;
    }

    private void R9(FeedCloudRead$StGetMainPageBasicDataRsp feedCloudRead$StGetMainPageBasicDataRsp) {
        byte[] byteArray = feedCloudRead$StGetMainPageBasicDataRsp.busiRspData.get().toByteArray();
        MutableLiveData globalData = w20.a.j().getGlobalData(QQCircleFeedBase$StMainPageBasicBusiRspData.class, com.tencent.biz.qqcircle.immersive.utils.r.q());
        QQCircleFeedBase$StMainPageBasicBusiRspData qQCircleFeedBase$StMainPageBasicBusiRspData = new QQCircleFeedBase$StMainPageBasicBusiRspData();
        try {
            qQCircleFeedBase$StMainPageBasicBusiRspData.mergeFrom(byteArray);
        } catch (Exception e16) {
            QLog.e("QCircleSettingContentPart", 1, "mergeFrom StMainPageBusiRspData error. " + e16);
        }
        globalData.postValue(qQCircleFeedBase$StMainPageBasicBusiRspData);
    }

    private void S9() {
        if (!uq3.o.A1()) {
            return;
        }
        com.tencent.biz.qqcircle.immersive.personal.utils.m.f89099a.g();
    }

    private void T9(View view) {
        QUISecNavBar qUISecNavBar = (QUISecNavBar) view.findViewById(R.id.f55572i_);
        this.f83079d = qUISecNavBar;
        qUISecNavBar.setLeftImageResInTransParent(R.drawable.qui_chevron_left);
        this.f83079d.setAutoAdaptTransparent(true);
        this.f83079d.setTitleAlpha(0.0f);
        this.f83079d.setLeftImageRes(R.drawable.qui_chevron_left);
        this.f83079d.setOnBaseTitleBarClickListener(new a());
    }

    private boolean U9() {
        return com.tencent.biz.qqcircle.utils.k.h("exp_notification_qpush_setup_page");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V9() {
        String str;
        QQCircleFeedBase$StMainPageBasicBusiRspData Q9 = Q9();
        if (Q9 != null) {
            str = com.tencent.biz.qqcircle.immersive.utils.af.a(Q9.urlInfo.get(), "aigcStatementUrl");
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = "https://rule.tencent.com/rule/preview/c73d7934-62ee-4a71-a053-4b748883b1f5";
        }
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W9() {
        QCircleSettingBean qCircleSettingBean = new QCircleSettingBean();
        qCircleSettingBean.setFromReportBean(getReportBean());
        com.tencent.biz.qqcircle.launcher.c.o(getContext(), qCircleSettingBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X9() {
        String str;
        QQCircleFeedBase$StMainPageBasicBusiRspData Q9 = Q9();
        if (Q9 != null) {
            str = com.tencent.biz.qqcircle.immersive.utils.af.a(Q9.urlInfo.get(), "complaintGuidelinesUrl");
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = "https://rule.tencent.com/rule/preview/8d955eef-893b-4de3-ab44-0d8bd2f63aca";
        }
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y9() {
        QCircleSettingBean qCircleSettingBean = new QCircleSettingBean();
        qCircleSettingBean.setFromReportBean(getReportBean());
        com.tencent.biz.qqcircle.launcher.c.V(getContext(), qCircleSettingBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z9() {
        QCircleSettingBean qCircleSettingBean = new QCircleSettingBean();
        qCircleSettingBean.setFromReportBean(getReportBean());
        com.tencent.biz.qqcircle.launcher.c.X(getContext(), qCircleSettingBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        QCircleSettingBean qCircleSettingBean = new QCircleSettingBean();
        qCircleSettingBean.setFromReportBean(getReportBean());
        com.tencent.biz.qqcircle.launcher.c.i0(getContext(), qCircleSettingBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setFromReportBean(getReportBean().m466clone());
        com.tencent.biz.qqcircle.launcher.c.m0(getContext(), qCircleInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca() {
        String str;
        QQCircleFeedBase$StMainPageBasicBusiRspData Q9 = Q9();
        if (Q9 != null) {
            str = com.tencent.biz.qqcircle.immersive.utils.af.a(Q9.urlInfo.get(), "serviceProtocolUrl");
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = "https://rule.tencent.com/rule/preview/a880964c-66e7-4556-8a39-827f92b2b355";
        }
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da() {
        com.tencent.biz.qqcircle.launcher.c.k0(getContext(), new QCircleSettingBean());
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(22).setThrActionType(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea() {
        QCircleFollowUserBean qCircleFollowUserBean = new QCircleFollowUserBean();
        qCircleFollowUserBean.setFromReportBean(getReportBean());
        qCircleFollowUserBean.setAdapterClassName(QCircleSpecialFollowListBlock.class.getName());
        com.tencent.biz.qqcircle.launcher.c.J(getContext(), qCircleFollowUserBean);
    }

    private void ha() {
        int i3;
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if (qCircleInitBean != null && qCircleInitBean.getFromPage() == 532) {
            return;
        }
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null && qCircleInitBean.getSchemeAttrs().containsKey("from") && TextUtils.isDigitsOnly(qCircleInitBean.getSchemeAttrs().get("from"))) {
            i3 = Integer.parseInt(qCircleInitBean.getSchemeAttrs().get("from"));
        } else {
            i3 = 0;
        }
        com.tencent.biz.qqcircle.immersive.personal.request.b.p(HostDataTransUtils.getAccount(), this, i3, true);
    }

    @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
    /* renamed from: ga, reason: merged with bridge method [inline-methods] */
    public void onReceive(boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, Bundle bundle) {
        QLog.d("QCircleSettingContentPart", 1, "[onReceive] -> request = " + qCircleBaseRequest + " , traceId : " + qCircleBaseRequest.getTraceId() + " , isSuccess : " + z16 + " , retCode : " + j3 + " , errMsg : " + str + " , ownerUin : " + HostDataTransUtils.getAccount() + " , isCache : " + VSNetworkHelper.isProtocolCache(str));
        if ((qCircleBaseRequest instanceof QFSGetMainPageBasicDataRequest) && z16 && j3 == 0 && (obj instanceof FeedCloudRead$StGetMainPageBasicDataRsp)) {
            R9((FeedCloudRead$StGetMainPageBasicDataRsp) obj);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleSettingContentPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        T9(view);
        ha();
        this.f83080e = (QUISettingsRecyclerView) view.findViewById(R.id.f54532fg);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter();
        this.f83081f = qUIListItemAdapter;
        this.f83080e.setAdapter(qUIListItemAdapter);
        this.f83081f.t0(M9());
        S9();
    }
}
