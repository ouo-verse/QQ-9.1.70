package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleSettingBean;
import com.tencent.biz.qqcircle.beans.QFSPrivateSettingBean;
import com.tencent.biz.qqcircle.beans.QFSPrivateSubSettingBean;
import com.tencent.biz.qqcircle.events.QFSPrivacySubSettingUpdateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.events.QFSRefreshMainTabEvent;
import com.tencent.biz.qqcircle.immersive.personal.utils.m;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleNewSetUserSwitchRequest;
import com.tencent.biz.qqcircle.requests.QCircleSetCircleSwitchRequest;
import com.tencent.biz.qqcircle.requests.QCircleSetUserSwitchRequest;
import com.tencent.biz.qqcircle.requests.QFSCountCircleRightRequest;
import com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.SetSwitchRsp;
import feedcloud.Switch;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StMainPageBasicBusiRspData;
import qqcircle.QQCircleProfile$SetUserSwitchRsp;
import qqcircle.QQCircleRight$CountCircleRightRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cp extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener, SimpleEventReceiver<SimpleBaseEvent>, m.a {
    private final List<Integer> C = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f83006d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.qqcircle.adapter.ak f83007e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleSettingBean f83008f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f83009h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f83010i;

    /* renamed from: m, reason: collision with root package name */
    private List<Integer> f83011m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleRight$CountCircleRightRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleRight$CountCircleRightRsp qQCircleRight$CountCircleRightRsp) {
            if (z16 && j3 == 0 && qQCircleRight$CountCircleRightRsp != null) {
                QLog.d("QCirclePrivacySettingContentPart", 1, "CountCircleRightRsp updateBlacklistNum= " + qQCircleRight$CountCircleRightRsp.count);
                cp.this.Da(qQCircleRight$CountCircleRightRsp.count.get());
                return;
            }
            QLog.e("QCirclePrivacySettingContentPart", 1, "CountCircleRightRsp retCode= " + j3 + ",errMsg = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSPrivateSubSettingBean qFSPrivateSubSettingBean = new QFSPrivateSubSettingBean(com.tencent.biz.qqcircle.utils.h.a(R.string.f1909843k));
            qFSPrivateSubSettingBean.setOpMaskList(cp.this.C);
            ArrayList arrayList = new ArrayList();
            arrayList.add(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_PRAISED);
            arrayList.add(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_RECOM_LIKE_FEED_TO_FRIENDS);
            qFSPrivateSubSettingBean.setSwitchKeyList(arrayList);
            com.tencent.biz.qqcircle.launcher.c.l0(cp.this.getContext(), qFSPrivateSubSettingBean);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSPrivateSubSettingBean qFSPrivateSubSettingBean = new QFSPrivateSubSettingBean(com.tencent.biz.qqcircle.utils.h.a(R.string.f193734a0));
            qFSPrivateSubSettingBean.setOpMaskList(cp.this.C);
            ArrayList arrayList = new ArrayList();
            arrayList.add(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_PRESENTATION_OFM);
            arrayList.add(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_CONTRACT_SWITCH);
            qFSPrivateSubSettingBean.setSwitchKeyList(arrayList);
            com.tencent.biz.qqcircle.launcher.c.l0(cp.this.getContext(), qFSPrivateSubSettingBean);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSPrivateSubSettingBean qFSPrivateSubSettingBean = new QFSPrivateSubSettingBean(com.tencent.biz.qqcircle.utils.h.a(R.string.f193724_z));
            qFSPrivateSubSettingBean.setOpMaskList(cp.this.C);
            ArrayList arrayList = new ArrayList();
            arrayList.add(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_ENABLE_PERSONAL_RECOMMEND);
            arrayList.add(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_TEENAGE_MANAGER);
            qFSPrivateSubSettingBean.setSwitchKeyList(arrayList);
            com.tencent.biz.qqcircle.launcher.c.l0(cp.this.getContext(), qFSPrivateSubSettingBean);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.biz.qqcircle.launcher.c.q(view.getContext(), new QCircleInitBean());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class g implements QFSSettingSwitchView.b {

        /* compiled from: P */
        /* loaded from: classes4.dex */
        class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetUserSwitchRsp> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f83019a;

            a(boolean z16) {
                this.f83019a = z16;
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetUserSwitchRsp qQCircleProfile$SetUserSwitchRsp) {
                if (z16 && j3 == 0) {
                    com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.c(cp.this.f83011m, 8, this.f83019a);
                } else {
                    com.tencent.biz.qqcircle.utils.cj.b(false, j3, str);
                }
            }
        }

        g() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            VSNetworkHelper.getInstance().sendRequest(new QCircleSetUserSwitchRequest(1, !z16 ? 1 : 0), new a(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class h implements QFSSettingSwitchView.b {

        /* compiled from: P */
        /* loaded from: classes4.dex */
        class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetUserSwitchRsp> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f83022a;

            a(boolean z16) {
                this.f83022a = z16;
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetUserSwitchRsp qQCircleProfile$SetUserSwitchRsp) {
                if (z16 && j3 == 0) {
                    com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.c(cp.this.f83011m, 9, this.f83022a);
                } else {
                    com.tencent.biz.qqcircle.utils.cj.b(false, j3, str);
                }
            }
        }

        h() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            VSNetworkHelper.getInstance().sendRequest(new QCircleSetUserSwitchRequest(4, !z16 ? 1 : 0), new a(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class i implements QFSSettingSwitchView.b {

        /* compiled from: P */
        /* loaded from: classes4.dex */
        class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetUserSwitchRsp> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f83025a;

            a(boolean z16) {
                this.f83025a = z16;
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetUserSwitchRsp qQCircleProfile$SetUserSwitchRsp) {
                if (z16 && j3 == 0) {
                    com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.c(cp.this.f83011m, 3, this.f83025a);
                } else {
                    com.tencent.biz.qqcircle.utils.cj.b(false, j3, str);
                }
            }
        }

        i() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            VSNetworkHelper.getInstance().sendRequest(new QCircleSetUserSwitchRequest(0, !z16 ? 1 : 0), new a(z16));
            if (z16) {
                QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(23).setThrActionType(3));
            } else {
                QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(23).setThrActionType(2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class j implements QFSSettingSwitchView.b {

        /* compiled from: P */
        /* loaded from: classes4.dex */
        class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetUserSwitchRsp> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f83028a;

            a(boolean z16) {
                this.f83028a = z16;
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetUserSwitchRsp qQCircleProfile$SetUserSwitchRsp) {
                if (z16 && j3 == 0) {
                    com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.c(cp.this.f83011m, 4, this.f83028a);
                } else {
                    com.tencent.biz.qqcircle.utils.cj.b(false, j3, str);
                }
            }
        }

        j() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            VSNetworkHelper.getInstance().sendRequest(new QCircleSetUserSwitchRequest(2, !z16 ? 1 : 0), new a(z16));
            if (z16) {
                QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(23).setThrActionType(5));
            } else {
                QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(23).setThrActionType(4));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Aa(boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, QQCircleProfile$SetUserSwitchRsp qQCircleProfile$SetUserSwitchRsp) {
        if (z17 && j3 == 0) {
            com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.c(this.f83011m, 28, z16);
        } else {
            com.tencent.biz.qqcircle.utils.cj.b(false, j3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ba(CompoundButton compoundButton, final boolean z16) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetUserSwitchRequest(15, !z16 ? 1 : 0), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.bizparts.co
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
                cp.this.Aa(z16, baseRequest, z17, j3, str, (QQCircleProfile$SetUserSwitchRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ca(UIStateData uIStateData) {
        int state = uIStateData.getState();
        if (state != 2 && state != 3) {
            if (state == 4) {
                QCircleToast.l(QCircleToast.f91645e, uIStateData.getMsg(), 0, true, false);
                return;
            }
            return;
        }
        Ga((QQCircleFeedBase$StMainPageBasicBusiRspData) uIStateData.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Da(long j3) {
        String str;
        if (j3 < 100) {
            str = "" + j3;
        } else {
            str = "99+";
        }
        for (int i3 = 0; i3 < this.f83007e.i0().size(); i3++) {
            QFSPrivateSettingBean qFSPrivateSettingBean = this.f83007e.i0().get(i3);
            if (TextUtils.equals(qFSPrivateSettingBean.getKey(), QFSPrivateSettingBean.KEY_SIMPLE_ITEM_BLACK_LIST)) {
                qFSPrivateSettingBean.setRightText(str);
                this.f83007e.notifyItemChanged(i3);
            }
        }
    }

    private void Ea(String str, boolean z16) {
        com.tencent.biz.qqcircle.adapter.ak akVar = this.f83007e;
        if (akVar == null) {
            return;
        }
        akVar.l0(str, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Fa() {
        int i3;
        String q16 = com.tencent.biz.qqcircle.immersive.utils.r.q();
        MutableLiveData globalData = w20.a.j().getGlobalData(QQCircleFeedBase$StMainPageBasicBusiRspData.class, q16);
        if (globalData != null && globalData.getValue() != 0) {
            this.f83011m = ((QQCircleFeedBase$StMainPageBasicBusiRspData) globalData.getValue()).opMask.get();
            Ga((QQCircleFeedBase$StMainPageBasicBusiRspData) globalData.getValue());
            return;
        }
        MutableLiveData globalData2 = w20.a.j().getGlobalData(com.tencent.biz.qqcircle.immersive.personal.data.w.class, q16);
        if (globalData2 != null && globalData2.getValue() != 0) {
            Ga(((com.tencent.biz.qqcircle.immersive.personal.data.w) globalData2.getValue()).e());
            return;
        }
        com.tencent.biz.qqcircle.viewmodels.q qVar = (com.tencent.biz.qqcircle.viewmodels.q) getViewModel(com.tencent.biz.qqcircle.viewmodels.q.class);
        qVar.L1().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.bizparts.ca
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                cp.this.Ca((UIStateData) obj);
            }
        });
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null && qCircleInitBean.getSchemeAttrs().containsKey("from") && TextUtils.isDigitsOnly(qCircleInitBean.getSchemeAttrs().get("from"))) {
            i3 = Integer.parseInt(qCircleInitBean.getSchemeAttrs().get("from"));
        } else {
            i3 = 0;
        }
        qVar.O1(i3);
    }

    private void Ga(QQCircleFeedBase$StMainPageBasicBusiRspData qQCircleFeedBase$StMainPageBasicBusiRspData) {
        if (qQCircleFeedBase$StMainPageBasicBusiRspData == null) {
            return;
        }
        if (this.f83008f == null) {
            this.f83008f = new QCircleSettingBean();
        }
        this.f83008f.setTagManagerUrl(com.tencent.biz.qqcircle.immersive.utils.af.a(qQCircleFeedBase$StMainPageBasicBusiRspData.urlInfo.get(), "personalizedTagUrl"));
        this.f83008f.setServiceProtocolUrl(com.tencent.biz.qqcircle.immersive.utils.af.a(qQCircleFeedBase$StMainPageBasicBusiRspData.urlInfo.get(), "serviceProtocolUrl"));
        this.f83008f.setComplaintGuidelinesUrl(com.tencent.biz.qqcircle.immersive.utils.af.a(qQCircleFeedBase$StMainPageBasicBusiRspData.urlInfo.get(), "complaintGuidelinesUrl"));
        this.f83008f.setAIGCStatementUrl(com.tencent.biz.qqcircle.immersive.utils.af.a(qQCircleFeedBase$StMainPageBasicBusiRspData.urlInfo.get(), "aigcStatementUrl"));
        List<Integer> list = qQCircleFeedBase$StMainPageBasicBusiRspData.opMask.get();
        this.f83007e.updateData(list);
        boolean contains = list.contains(33);
        this.f83009h = contains;
        this.f83010i = contains;
        this.C.clear();
        this.C.addAll(list);
    }

    private void Ha(Map<String, Boolean> map) {
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                Boolean bool = map.get(str);
                if (bool != null) {
                    Ea(str, bool.booleanValue());
                }
            }
        }
    }

    private void Q9(boolean z16) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_PROTECT_SETTING_BUTTON);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRIVACY_SETTING_BUTTON_STATE, Integer.valueOf(z16 ? 1 : 0));
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    private void R9() {
        if (this.f83010i != this.f83009h) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSRefreshMainTabEvent());
        }
    }

    private void S9(QFSPrivacySubSettingUpdateEvent qFSPrivacySubSettingUpdateEvent) {
        com.tencent.biz.qqcircle.immersive.personal.utils.n nVar = com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a;
        nVar.c(this.f83011m, qFSPrivacySubSettingUpdateEvent.getCode(), qFSPrivacySubSettingUpdateEvent.getIsChecked());
        nVar.c(this.C, qFSPrivacySubSettingUpdateEvent.getCode(), qFSPrivacySubSettingUpdateEvent.getIsChecked());
    }

    private void T9(ArrayList<QFSPrivateSettingBean> arrayList) {
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_VIDEO_VOICE);
        qFSPrivateSettingBean.setBgType(0);
        qFSPrivateSettingBean.setTitle(getContext().getString(R.string.f183043i4));
        qFSPrivateSettingBean.setHide(com.tencent.biz.qqcircle.utils.h.a(R.string.f183033i3));
        qFSPrivateSettingBean.setHead(getContext().getString(R.string.f184363lo));
        qFSPrivateSettingBean.setListener(new QFSSettingSwitchView.b() { // from class: com.tencent.biz.qqcircle.bizparts.cm
            @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                QCircleHostConfig.setQQCircleAllowExtractVideoMusic(z16);
            }
        });
        arrayList.add(qFSPrivateSettingBean);
    }

    private void U9(ArrayList<QFSPrivateSettingBean> arrayList) {
        if (this.f83008f == null) {
            return;
        }
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_ALLOW_GAME_PAGE_ENTRANCE);
        qFSPrivateSettingBean.setTitle(com.tencent.biz.qqcircle.utils.h.a(R.string.f183063i6));
        qFSPrivateSettingBean.setHide(com.tencent.biz.qqcircle.utils.h.a(R.string.f183053i5));
        qFSPrivateSettingBean.setListener(new QFSSettingSwitchView.b() { // from class: com.tencent.biz.qqcircle.bizparts.cl
            @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                cp.this.pa(compoundButton, z16);
            }
        });
        qFSPrivateSettingBean.setEid(QCircleDaTongConstant.ElementId.EM_XSJ_PRIVACY_GAME_PAGE_ENTRANCE);
        arrayList.add(qFSPrivateSettingBean);
    }

    private void V9(ArrayList<QFSPrivateSettingBean> arrayList) {
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_BLACK_LIST);
        qFSPrivateSettingBean.setViewType(2);
        qFSPrivateSettingBean.setBgType(3);
        qFSPrivateSettingBean.setOnClickListener(new f());
        qFSPrivateSettingBean.setLeftText(com.tencent.biz.qqcircle.utils.h.a(R.string.f181693eg));
        arrayList.add(qFSPrivateSettingBean);
    }

    private void W9(ArrayList<QFSPrivateSettingBean> arrayList) {
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_LIKE);
        qFSPrivateSettingBean.setViewType(2);
        qFSPrivateSettingBean.setBgType(1);
        qFSPrivateSettingBean.setDrawableId(R.drawable.qui_heart);
        qFSPrivateSettingBean.setOnClickListener(new c());
        qFSPrivateSettingBean.setLeftText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1909843k));
        arrayList.add(qFSPrivateSettingBean);
    }

    private void X9(ArrayList<QFSPrivateSettingBean> arrayList) {
        if (!uq3.c.C6()) {
            QLog.i("QCirclePrivacySettingContentPartonInitView", 2, "QCircleConfigHelper.isQQCircleShowTroopToolBarEntrance()==false");
            return;
        }
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_NEW_MSG);
        qFSPrivateSettingBean.setTitle(com.tencent.biz.qqcircle.utils.h.a(R.string.f184983nc));
        qFSPrivateSettingBean.setHide(com.tencent.biz.qqcircle.utils.h.a(R.string.f184993nd));
        qFSPrivateSettingBean.setListener(new j());
        arrayList.add(qFSPrivateSettingBean);
    }

    private void Y9(ArrayList<QFSPrivateSettingBean> arrayList) {
        final QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_ONE_KEY_DEFEND);
        qFSPrivateSettingBean.setTitle(uq3.o.k0(getContext().getString(R.string.f185003ne)));
        qFSPrivateSettingBean.setHide(uq3.o.j0(getContext().getString(R.string.f185013nf)));
        qFSPrivateSettingBean.setDrawableId(R.drawable.qui_safety);
        qFSPrivateSettingBean.setListener(new QFSSettingSwitchView.b() { // from class: com.tencent.biz.qqcircle.bizparts.ci
            @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                cp.this.ra(qFSPrivateSettingBean, compoundButton, z16);
            }
        });
        qFSPrivateSettingBean.setEid(QCircleDaTongConstant.ElementId.EM_XSJ_PROTECT_SETTING_BUTTON);
        arrayList.add(qFSPrivateSettingBean);
    }

    private void Z9(ArrayList<QFSPrivateSettingBean> arrayList) {
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_PYMK);
        qFSPrivateSettingBean.setViewType(2);
        qFSPrivateSettingBean.setBgType(1);
        qFSPrivateSettingBean.setOnClickListener(new d());
        qFSPrivateSettingBean.setLeftText(com.tencent.biz.qqcircle.utils.h.a(R.string.f193734a0));
        arrayList.add(qFSPrivateSettingBean);
    }

    private void aa(ArrayList<QFSPrivateSettingBean> arrayList) {
        boolean d16 = uq3.c.d();
        QLog.d("QCirclePrivacySettingContentPart", 1, "[initPersonalAiCommentSwitch] isEnableAiComment: " + d16);
        if (!d16) {
            return;
        }
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_ENABLE_AI_COMMENT);
        qFSPrivateSettingBean.setTitle(getContext().getString(R.string.f183013i1));
        qFSPrivateSettingBean.setHide(uq3.c.b1("qqcircle", "qqcircle_user_ai_comment_setting_desc", com.dataline.util.j.d(getContext().getString(R.string.f183023i2))));
        qFSPrivateSettingBean.setListener(new QFSSettingSwitchView.b() { // from class: com.tencent.biz.qqcircle.bizparts.ck
            @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                cp.ta(compoundButton, z16);
            }
        });
        qFSPrivateSettingBean.setEid(QCircleDaTongConstant.ElementId.EM_XSJ_PRIVACY_SWITCH_DIVERSITY_CMT);
        arrayList.add(qFSPrivateSettingBean);
    }

    private void ba(ArrayList<QFSPrivateSettingBean> arrayList) {
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_PERSONALIZE);
        qFSPrivateSettingBean.setViewType(2);
        qFSPrivateSettingBean.setOnClickListener(new e());
        qFSPrivateSettingBean.setLeftText(com.tencent.biz.qqcircle.utils.h.a(R.string.f193724_z));
        arrayList.add(qFSPrivateSettingBean);
    }

    private void ca(ArrayList<QFSPrivateSettingBean> arrayList) {
        com.tencent.biz.qqcircle.comment.recpic.aa aaVar = com.tencent.biz.qqcircle.comment.recpic.aa.f83750a;
        if (!aaVar.t() && aaVar.F()) {
            QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_REC_PIC);
            com.tencent.biz.qqcircle.comment.recpic.z zVar = com.tencent.biz.qqcircle.comment.recpic.z.f83900a;
            qFSPrivateSettingBean.setTitle(zVar.w().getSettingTitle());
            qFSPrivateSettingBean.setHide(zVar.w().getSettingDesc());
            qFSPrivateSettingBean.setChecked(uq3.k.a().c(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_REC_PIC, false));
            qFSPrivateSettingBean.setListener(new QFSSettingSwitchView.b() { // from class: com.tencent.biz.qqcircle.bizparts.cg
                @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    cp.ua(compoundButton, z16);
                }
            });
            qFSPrivateSettingBean.setEid(QCircleDaTongConstant.ElementId.EM_XSJ_REC_PIC_PRIVATE_SWITCH);
            arrayList.add(qFSPrivateSettingBean);
        }
    }

    private void da(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f515828h);
        this.f83006d = recyclerView;
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        this.f83006d.addOnScrollListener(new b());
        com.tencent.biz.qqcircle.adapter.ak akVar = new com.tencent.biz.qqcircle.adapter.ak();
        this.f83007e = akVar;
        this.f83006d.setAdapter(akVar);
        ArrayList<QFSPrivateSettingBean> arrayList = new ArrayList<>();
        ea(arrayList);
        U9(arrayList);
        ma(arrayList);
        X9(arrayList);
        W9(arrayList);
        ga(arrayList);
        ja(arrayList);
        Y9(arrayList);
        ca(arrayList);
        ia(arrayList);
        ha(arrayList);
        Z9(arrayList);
        V9(arrayList);
        T9(arrayList);
        ba(arrayList);
        aa(arrayList);
        this.f83007e.k0(arrayList);
    }

    private void ea(ArrayList<QFSPrivateSettingBean> arrayList) {
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_CARD);
        qFSPrivateSettingBean.setHead(getContext().getString(R.string.f193714_y));
        qFSPrivateSettingBean.setTitle(uq3.c.b1("qqcircle", "qqcircle_show_card_profile_switch_header", getContext().getString(R.string.f185043ni)));
        qFSPrivateSettingBean.setHide(uq3.c.b1("qqcircle", "qqcircle_show_card_profile_switch_hint", getContext().getString(R.string.f185053nj)));
        qFSPrivateSettingBean.setListener(new i());
        arrayList.add(qFSPrivateSettingBean);
    }

    private void ga(ArrayList<QFSPrivateSettingBean> arrayList) {
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_COLLECT);
        qFSPrivateSettingBean.setTitle(uq3.c.b1("qqcircle", "qqcircle_show_collect_switch_header", getContext().getString(R.string.f184903n5)));
        qFSPrivateSettingBean.setHide(uq3.c.b1("qqcircle", "qqcircle_show_collect_switch_hint", getContext().getString(R.string.f184913n6)));
        qFSPrivateSettingBean.setBgType(3);
        qFSPrivateSettingBean.setDrawableId(R.drawable.qui_collection);
        qFSPrivateSettingBean.setListener(new QFSSettingSwitchView.b() { // from class: com.tencent.biz.qqcircle.bizparts.cn
            @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                cp.this.wa(compoundButton, z16);
            }
        });
        qFSPrivateSettingBean.setEid(QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_COLLECT_SETTING_BUTTON);
        arrayList.add(qFSPrivateSettingBean);
    }

    private void ha(ArrayList<QFSPrivateSettingBean> arrayList) {
        int i3;
        int i16;
        if (com.tencent.biz.qqcircle.f.I().getBoolean("SP_KEY_IS_PENGUIN_USER", false)) {
            return;
        }
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_FAN);
        Context context = getContext();
        if (com.tencent.biz.qqcircle.manager.i.a("qfs_private_message_entrance_show")) {
            i3 = R.string.f184943n9;
        } else {
            i3 = R.string.f184973nb;
        }
        qFSPrivateSettingBean.setTitle(uq3.c.b1("qqcircle", "qqcircle_show_fans_and_focus_profile_switch_header", context.getString(i3)));
        Context context2 = getContext();
        if (com.tencent.biz.qqcircle.manager.i.a("qfs_private_message_entrance_show")) {
            i16 = R.string.f184953n_;
        } else {
            i16 = R.string.f184963na;
        }
        qFSPrivateSettingBean.setHide(uq3.c.b1("qqcircle", "qqcircle_show_fans_and_focus_profile_switch_hint", context2.getString(i16)));
        qFSPrivateSettingBean.setListener(new h());
        qFSPrivateSettingBean.setEid(QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOWER_FOLLOW_LIST_BUTTON);
        arrayList.add(qFSPrivateSettingBean);
    }

    private void ia(ArrayList<QFSPrivateSettingBean> arrayList) {
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_PRESENTATION_MFO);
        qFSPrivateSettingBean.setTitle(com.tencent.biz.qqcircle.utils.h.a(R.string.f195814fm));
        qFSPrivateSettingBean.setHide(com.tencent.biz.qqcircle.utils.h.a(R.string.f195824fn));
        qFSPrivateSettingBean.setHead(com.tencent.biz.qqcircle.utils.h.a(R.string.f193744a1));
        qFSPrivateSettingBean.setListener(new QFSSettingSwitchView.b() { // from class: com.tencent.biz.qqcircle.bizparts.cj
            @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                cp.this.xa(compoundButton, z16);
            }
        });
        qFSPrivateSettingBean.setEid(QCircleDaTongConstant.ElementId.EM_XSJ_PRIVACY_SWITCH_RECOM_FRIENDS);
        arrayList.add(qFSPrivateSettingBean);
    }

    private void ja(ArrayList<QFSPrivateSettingBean> arrayList) {
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_PUSHED);
        qFSPrivateSettingBean.setTitle(uq3.c.b1("qqcircle", "qqcircle_show_pushed_profile_switch_header", getContext().getString(R.string.f185063nk)));
        qFSPrivateSettingBean.setHide(uq3.c.b1("qqcircle", "qqcircle_show_pushed_profile_switch_hint", getContext().getString(R.string.f185073nl)));
        qFSPrivateSettingBean.setDrawableId(R.drawable.qui_rocket_text_primary);
        qFSPrivateSettingBean.setListener(new g());
        qFSPrivateSettingBean.setEid(QCircleDaTongConstant.ElementId.EM_XSJ_PUSH_LIST_BUTTON);
        arrayList.add(qFSPrivateSettingBean);
    }

    private void la() {
        com.tencent.biz.qqcircle.immersive.personal.utils.m mVar = com.tencent.biz.qqcircle.immersive.personal.utils.m.f89099a;
        mVar.b(this);
        Ha(mVar.c());
        mVar.g();
    }

    private void ma(ArrayList<QFSPrivateSettingBean> arrayList) {
        if (!com.tencent.biz.qqcircle.manager.i.a("qqcircle_visitor_effort_frequency")) {
            QLog.i("QCirclePrivacySettingContentPart", 2, "initVisitorSwitch return, businessEnable false");
            return;
        }
        if (uq3.c.E4() <= 0) {
            return;
        }
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_VISITOR_SWITCH);
        qFSPrivateSettingBean.setTitle(com.tencent.biz.qqcircle.utils.h.a(R.string.f185083nm));
        qFSPrivateSettingBean.setHide(com.tencent.biz.qqcircle.utils.h.a(R.string.f185093nn));
        qFSPrivateSettingBean.setListener(new QFSSettingSwitchView.b() { // from class: com.tencent.biz.qqcircle.bizparts.ch
            @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                cp.this.Ba(compoundButton, z16);
            }
        });
        qFSPrivateSettingBean.setEid(QCircleDaTongConstant.ElementId.EM_XSJ_SHOW_PROFILE_VISITOR_BTN);
        arrayList.add(qFSPrivateSettingBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void oa(boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, QQCircleProfile$SetUserSwitchRsp qQCircleProfile$SetUserSwitchRsp) {
        if (z17 && j3 == 0) {
            com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.c(this.f83011m, 25, z16);
        } else {
            com.tencent.biz.qqcircle.utils.cj.b(false, j3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void pa(CompoundButton compoundButton, final boolean z16) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetUserSwitchRequest(12, !z16 ? 1 : 0), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.bizparts.cf
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
                cp.this.oa(z16, baseRequest, z17, j3, str, (QQCircleProfile$SetUserSwitchRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void qa(QCircleNewSetUserSwitchRequest qCircleNewSetUserSwitchRequest, QFSPrivateSettingBean qFSPrivateSettingBean, boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, SetSwitchRsp setSwitchRsp) {
        String traceId;
        String traceId2;
        String str2 = "";
        if (z17 && j3 == 0) {
            int i3 = RFWLog.USR;
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[initOneKeyDefendSwitch] one key switch change, isChecked: ");
            sb5.append(z16);
            sb5.append(" | traceId: ");
            if (qCircleNewSetUserSwitchRequest == null) {
                traceId2 = "";
            } else {
                traceId2 = qCircleNewSetUserSwitchRequest.getTraceId();
            }
            sb5.append(traceId2);
            sb5.append(" | cmdName: ");
            if (qCircleNewSetUserSwitchRequest != null) {
                str2 = qCircleNewSetUserSwitchRequest.getCmd();
            }
            sb5.append(str2);
            objArr[0] = sb5.toString();
            RFWLog.d("QOK-QCirclePrivacySettingContentPart", i3, objArr);
            com.tencent.biz.qqcircle.immersive.personal.utils.m.f89099a.k(Switch.PROTECTION.name(), z16, "type_privacy_switch");
            com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.c(this.f83011m, 34, z16);
            return;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("[initOneKeyDefendSwitch] update fail, retCode: ");
        sb6.append(j3);
        sb6.append(" | errMsg: ");
        sb6.append(str);
        sb6.append(" | traceId:");
        if (qCircleNewSetUserSwitchRequest == null) {
            traceId = "";
        } else {
            traceId = qCircleNewSetUserSwitchRequest.getTraceId();
        }
        sb6.append(traceId);
        sb6.append(" | cmdName: ");
        if (qCircleNewSetUserSwitchRequest != null) {
            str2 = qCircleNewSetUserSwitchRequest.getCmd();
        }
        sb6.append(str2);
        QLog.d("QOK-QCirclePrivacySettingContentPart", 1, sb6.toString());
        com.tencent.biz.qqcircle.utils.cj.b(false, j3, str);
        Ea(qFSPrivateSettingBean.getKey(), !z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ra(final QFSPrivateSettingBean qFSPrivateSettingBean, CompoundButton compoundButton, final boolean z16) {
        final QCircleNewSetUserSwitchRequest qCircleNewSetUserSwitchRequest = new QCircleNewSetUserSwitchRequest(RFWApplication.getAccountId(), String.valueOf(Switch.PROTECTION), z16);
        Q9(z16);
        VSNetworkHelper.getInstance().sendRequest(qCircleNewSetUserSwitchRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.bizparts.cc
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
                cp.this.qa(qCircleNewSetUserSwitchRequest, qFSPrivateSettingBean, z16, baseRequest, z17, j3, str, (SetSwitchRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void sa(QCircleSetCircleSwitchRequest qCircleSetCircleSwitchRequest, boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
        String str2;
        if (z17 && j3 == 0) {
            String traceId = qCircleSetCircleSwitchRequest.getTraceId();
            uq3.k.a().j("sp_key_show_ai_comment_agreement_dialog", false);
            if (z16) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            uq3.c.h7("qqcircle", "qqcircle_user_ai_comment_setting_status", str2);
            QLog.d("WNS-QCirclePrivacySettingContentPart", 1, "[handleAiCommentSwitchChange] secondaryKey: qqcircle_user_ai_comment_setting_status | isChecked: " + z16 + ", switch change success. traceId:" + traceId);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = com.tencent.biz.qqcircle.utils.h.a(R.string.ci8);
        }
        QCircleToast.o(str, 0);
        QLog.e("QCirclePrivacySettingContentPart", 1, "[handleAiCommentSwitchChange] set switch error! retCode = " + j3 + APLogFileUtil.SEPARATOR_LOG + qCircleSetCircleSwitchRequest.getTraceId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void ta(CompoundButton compoundButton, final boolean z16) {
        String str;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        final QCircleSetCircleSwitchRequest qCircleSetCircleSwitchRequest = new QCircleSetCircleSwitchRequest("qqcircle", "qqcircle_user_ai_comment_setting_status", str);
        VSNetworkHelper.getInstance().sendRequest(qCircleSetCircleSwitchRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.bizparts.cd
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str2, Object obj) {
                cp.sa(QCircleSetCircleSwitchRequest.this, z16, baseRequest, z17, j3, str2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void ua(CompoundButton compoundButton, boolean z16) {
        uq3.k.a().j(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_REC_PIC, z16);
        QLog.d("QCirclePrivacySettingContentPart", 1, "set rec pic switch: isChecked: " + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void va(boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, QQCircleProfile$SetUserSwitchRsp qQCircleProfile$SetUserSwitchRsp) {
        if (z17 && j3 == 0) {
            com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.c(this.f83011m, 19, z16);
        } else {
            com.tencent.biz.qqcircle.utils.cj.b(false, j3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wa(CompoundButton compoundButton, final boolean z16) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetUserSwitchRequest(9, !z16 ? 1 : 0), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.bizparts.cb
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
                cp.this.va(z16, baseRequest, z17, j3, str, (QQCircleProfile$SetUserSwitchRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xa(CompoundButton compoundButton, final boolean z16) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetUserSwitchRequest(11, !z16 ? 1 : 0), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.bizparts.ce
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
                cp.this.za(z16, baseRequest, z17, j3, str, (QQCircleProfile$SetUserSwitchRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void za(boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, QQCircleProfile$SetUserSwitchRsp qQCircleProfile$SetUserSwitchRsp) {
        if (z17 && j3 == 0) {
            com.tencent.biz.qqcircle.immersive.personal.utils.n.f89104a.c(this.f83011m, 23, z16);
        } else {
            com.tencent.biz.qqcircle.utils.cj.b(false, j3, str);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSPrivacySubSettingUpdateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCirclePrivacySettingContentPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.utils.m.a
    public void m0(@NonNull Map<String, Boolean> map) {
        Ha(map);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.y_2 && !getPartManager().onBackEvent() && getActivity() != null) {
            getActivity().finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f83008f = (QCircleSettingBean) getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
        da(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.y_2);
        imageView.setOnClickListener(this);
        if (getHostFragment() instanceof QCircleBaseFragment) {
            ((QCircleBaseFragment) getHostFragment()).setExcludeInteractiveView(imageView);
        }
        Fa();
        la();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        R9();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.tencent.biz.qqcircle.immersive.personal.utils.m.f89099a.j(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        VSNetworkHelper.getInstance().sendRequest(new QFSCountCircleRightRequest(1), new a());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSPrivacySubSettingUpdateEvent) {
            S9((QFSPrivacySubSettingUpdateEvent) simpleBaseEvent);
        }
    }
}
