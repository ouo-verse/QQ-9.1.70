package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.bean.QFSPushBoxBean;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSSuspendOpenBoxUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSUpdatePushStateEvent;
import com.tencent.biz.qqcircle.events.QFSUpdateSuspendBoxCountEvent;
import com.tencent.biz.qqcircle.immersive.refresh.ChrysanthemumLoadingView;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleOpenAllPushBoxRequest;
import com.tencent.biz.qqcircle.requests.QFSGetUserBoxCountRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.qcircle.api.IQFSPushOpenBoxPopWindowApi;
import com.tencent.mobileqq.qcircle.api.global.QFSPushOpenBoxInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudRead$GetUserBoxCntRsp;
import feedcloud.FeedCloudWrite$PushBoxBasic;
import feedcloud.FeedCloudWrite$PushBoxDrawAllRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StUserPushBoxInfo;

/* loaded from: classes4.dex */
public class QFSSuspendOpenPushBoxPart extends u implements SimpleEventReceiver, View.OnClickListener, IOrderElement {
    private ChrysanthemumLoadingView C;
    private long D;
    private boolean E = true;
    private String F = "";
    private boolean G = true;
    private boolean H = false;
    private Runnable I;
    private z70.b J;
    private boolean K;

    /* renamed from: d, reason: collision with root package name */
    private ViewStub f87569d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f87570e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f87571f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f87572h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f87573i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f87574m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$PushBoxDrawAllRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$PushBoxDrawAllRsp feedCloudWrite$PushBoxDrawAllRsp) {
            QLog.d("QFSSuspendOpenPushBoxPart", 1, "OpenAllPushBox onResponse, isSuccess:" + z16 + ", retCode: " + j3 + ", errMsg: " + str);
            QFSSuspendOpenPushBoxPart.this.G9(z16, j3, str, feedCloudWrite$PushBoxDrawAllRsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$GetUserBoxCntRsp> {
        b() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$GetUserBoxCntRsp feedCloudRead$GetUserBoxCntRsp) {
            QFSSuspendOpenPushBoxPart.this.F9(z16, j3, str, feedCloudRead$GetUserBoxCntRsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int id5 = view.getId();
            if (id5 == R.id.f507726a || id5 == R.id.f507826b) {
                SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(2, "", false));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void D9(QQCircleFeedBase$StUserPushBoxInfo qQCircleFeedBase$StUserPushBoxInfo) {
        if (qQCircleFeedBase$StUserPushBoxInfo == null) {
            return;
        }
        if (!this.E) {
            QLog.d("QFSSuspendOpenPushBoxPart", 1, "dealWithOpenBoxUpdateEvent but mCanUpdateBoxCntFromFeed is false");
        } else {
            QLog.d("QFSSuspendOpenPushBoxPart", 1, "dealWithOpenBoxUpdateEvent");
            V9(qQCircleFeedBase$StUserPushBoxInfo.unopendPushBoxCount.get());
        }
    }

    private void E9() {
        this.E = false;
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSSuspendOpenPushBoxPart.4
            @Override // java.lang.Runnable
            public void run() {
                QFSSuspendOpenPushBoxPart.this.E = true;
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F9(boolean z16, long j3, String str, FeedCloudRead$GetUserBoxCntRsp feedCloudRead$GetUserBoxCntRsp) {
        QLog.d("QFSSuspendOpenPushBoxPart", 1, "GetBoxCount onResponse, isSuccess:" + z16 + ", retCode: " + j3 + ", errMsg: " + str);
        if (z16 && j3 == 0 && feedCloudRead$GetUserBoxCntRsp != null) {
            V9(feedCloudRead$GetUserBoxCntRsp.un_open_count.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G9(boolean z16, long j3, String str, FeedCloudWrite$PushBoxDrawAllRsp feedCloudWrite$PushBoxDrawAllRsp) {
        U9(false);
        S9();
        E9();
        if (z16 && j3 == 0 && feedCloudWrite$PushBoxDrawAllRsp != null && !this.H) {
            List<FeedCloudWrite$PushBoxBasic> list = feedCloudWrite$PushBoxDrawAllRsp.drawBoxResult.get();
            com.tencent.biz.qqcircle.f.v().b(list);
            ArrayList arrayList = new ArrayList();
            for (FeedCloudWrite$PushBoxBasic feedCloudWrite$PushBoxBasic : list) {
                if (feedCloudWrite$PushBoxBasic != null) {
                    arrayList.add(new QFSPushBoxBean(feedCloudWrite$PushBoxBasic));
                }
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSUpdatePushStateEvent(list));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                QFSPushBoxBean qFSPushBoxBean = (QFSPushBoxBean) it.next();
                String feedId = qFSPushBoxBean.getFeedId();
                FeedCloudMeta$StPushList f16 = QCirclePushInfoManager.e().f(feedId);
                if (f16 != null) {
                    f16.pushBoxViewInfo.set(qFSPushBoxBean.getPushBoxViewInfo());
                    QCirclePushInfoManager.e().p(feedId, f16);
                }
            }
            boolean z17 = feedCloudWrite$PushBoxDrawAllRsp.isEnd.get();
            RFWLog.i("QFSSuspendOpenPushBoxPart", RFWLog.USR, "open box is end = " + z17 + " push box list size is " + list.size());
            if (z17) {
                V9(0L);
            } else {
                V9(feedCloudWrite$PushBoxDrawAllRsp.un_open_count.get());
            }
            P9(feedCloudWrite$PushBoxDrawAllRsp);
            return;
        }
        this.D = 0L;
        com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(this);
        O9(j3, str);
    }

    private void H9(QCirclePanelStateEvent qCirclePanelStateEvent) {
        FrameLayout frameLayout;
        if (this.K && qCirclePanelStateEvent.getPanelType() == 21 && !qCirclePanelStateEvent.isShowing() && this.D > 0 && (frameLayout = this.f87570e) != null) {
            frameLayout.setVisibility(0);
        }
    }

    private void I9(ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        if (aSEngineTabStatusEvent.getBusinessKey().equals(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE) && aSEngineTabStatusEvent.isSelected()) {
            M9();
        }
    }

    private void J9(boolean z16) {
        if (z16) {
            V9(0L);
        } else {
            V9(this.D - 1);
        }
    }

    private void K9() {
        if (this.f87569d != null) {
            return;
        }
        View partRootView = getPartRootView();
        if (partRootView == null) {
            QLog.d("QFSSuspendOpenPushBoxPart", 1, "do init view but rootView is null");
            return;
        }
        QLog.d("QFSSuspendOpenPushBoxPart", 1, "do init view");
        ViewStub viewStub = (ViewStub) partRootView.findViewById(R.id.f54782g5);
        this.f87569d = viewStub;
        FrameLayout frameLayout = (FrameLayout) viewStub.inflate().findViewById(R.id.f909953z);
        this.f87570e = frameLayout;
        this.f87571f = (LinearLayout) frameLayout.findViewById(R.id.f54762g3);
        this.f87572h = (TextView) this.f87570e.findViewById(R.id.f54752g2);
        this.f87573i = (TextView) this.f87570e.findViewById(R.id.f54772g4);
        this.f87574m = (TextView) this.f87570e.findViewById(R.id.f56872ls);
        this.C = (ChrysanthemumLoadingView) this.f87570e.findViewById(R.id.f509626t);
        View findViewById = this.f87570e.findViewById(R.id.f504725h);
        this.f87570e.setOnClickListener(this);
        this.C.setVisibility(8);
        this.J = new z70.b(findViewById, getContext(), "folder_tab", 301);
        com.tencent.biz.qqcircle.immersive.manager.e.a().addElement(this.J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L9(boolean z16) {
        int i3;
        int i16;
        ChrysanthemumLoadingView chrysanthemumLoadingView = this.C;
        if (chrysanthemumLoadingView == null) {
            return;
        }
        this.G = !z16;
        int i17 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        chrysanthemumLoadingView.setVisibility(i3);
        LinearLayout linearLayout = this.f87571f;
        if (z16) {
            i16 = 8;
        } else {
            i16 = 0;
        }
        linearLayout.setVisibility(i16);
        TextView textView = this.f87574m;
        if (z16) {
            i17 = 8;
        }
        textView.setVisibility(i17);
        if (z16) {
            this.C.c();
        } else {
            this.C.d();
        }
    }

    private void M9() {
        if (uq3.c.C() && !fb0.a.b("QFSSuspendOpenPushBoxPartgetBoxCount", 500L)) {
            VSNetworkHelper.getInstance().sendRequest(new QFSGetUserBoxCountRequest(), new b());
        }
    }

    private void N9() {
        if (this.G && !fb0.a.b("QFSSuspendOpenPushBoxPart", 500L)) {
            if (!HostNetworkUtils.isNetworkAvailable()) {
                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f19225470), 0);
                QLog.d("QFSSuspendOpenPushBoxPart", 1, "open box fail");
            } else {
                U9(true);
                R9();
                VSNetworkHelper.getInstance().sendRequest(new QCircleOpenAllPushBoxRequest(), new a());
            }
        }
    }

    private void O9(long j3, String str) {
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f19225470);
        if (j3 == 60002 || j3 == 60000) {
            a16 = str;
        }
        QCircleToast.o(a16, 0);
        RFWLog.i("QFSSuspendOpenPushBoxPart", RFWLog.USR, "handlePushBoxRps retCode = " + j3 + ", errMsg = " + str);
    }

    private void P9(FeedCloudWrite$PushBoxDrawAllRsp feedCloudWrite$PushBoxDrawAllRsp) {
        QFSPushOpenBoxInfo convertToOpenMultiBoxInfo = QFSPushOpenBoxInfo.convertToOpenMultiBoxInfo(feedCloudWrite$PushBoxDrawAllRsp);
        convertToOpenMultiBoxInfo.setSource(this.F);
        ((IQFSPushOpenBoxPopWindowApi) QRoute.api(IQFSPushOpenBoxPopWindowApi.class)).showPushOpenBoxWindow(getContext(), convertToOpenMultiBoxInfo, new c(), getPartRootView());
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(2, "", true));
    }

    private void Q9(long j3) {
        QLog.d("QFSSuspendOpenPushBoxPart", 1, "showPushBoxUi :" + j3);
        K9();
        if (j3 > 0) {
            if (this.f87570e == null) {
                return;
            }
            if (com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
                this.f87570e.setVisibility(8);
                this.K = true;
            } else {
                this.f87570e.setVisibility(0);
            }
            z70.b bVar = this.J;
            if (bVar != null) {
                bVar.l(RFWOrderElementManager.OrderMode.NORMAL_MODE);
            }
            W9(j3);
            T9();
            return;
        }
        com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(this);
    }

    private void R9() {
        this.H = false;
        if (this.I == null) {
            this.I = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSSuspendOpenPushBoxPart.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSSuspendOpenPushBoxPart.this.H = true;
                }
            };
        }
        getMainHandler().postDelayed(this.I, 5000L);
    }

    private void S9() {
        if (this.I == null) {
            return;
        }
        getMainHandler().removeCallbacks(this.I);
    }

    private void T9() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_BOX_NUM, Long.valueOf(this.D));
        VideoReport.setElementId(this.f87570e, QCircleDaTongConstant.ElementId.EM_XSJ_BOX_PENDANT);
        VideoReport.setElementParams(this.f87570e, buildElementParams);
        VideoReport.setElementExposePolicy(this.f87570e, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.f87570e, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.f87570e, ClickPolicy.REPORT_ALL);
    }

    private void U9(final boolean z16) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.fo
            @Override // java.lang.Runnable
            public final void run() {
                QFSSuspendOpenPushBoxPart.this.L9(z16);
            }
        });
    }

    private void V9(long j3) {
        QLog.d("QFSSuspendOpenPushBoxPart", 1, "updateSuspendPushBoxCount boxCount:" + j3);
        this.D = j3;
        com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
    }

    private void W9(long j3) {
        TextView textView = this.f87572h;
        if (textView == null) {
            return;
        }
        RFWTypefaceUtil.setNumberTypeface(textView, false);
        this.f87572h.setIncludeFontPadding(false);
        QLog.d("QFSSuspendOpenPushBoxPart", 1, "open box count1 is " + j3);
        String valueOf = String.valueOf(j3);
        if (j3 > 99) {
            this.f87572h.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1922346y));
        } else {
            this.f87572h.setText(valueOf);
        }
        RFWTypefaceUtil.setNumberTypeface(this.f87572h, false);
        RFWTypefaceUtil.setNumberTypeface(this.f87574m, "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8893/rocket/FZRuiZhengHeiS-EB-GB.ttf");
        RFWTypefaceUtil.setNumberTypeface(this.f87573i, "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8893/rocket/FZRuiZhengHeiS-EB-GB.ttf");
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        if (getContext() == null) {
            return "";
        }
        return String.valueOf(getContext().hashCode());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getElementExtraKey() {
        return com.tencent.biz.richframework.order.a.a(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSuspendOpenBoxUpdateEvent.class);
        arrayList.add(QFSUpdateSuspendBoxCountEvent.class);
        arrayList.add(ASEngineTabStatusEvent.class);
        arrayList.add(QCirclePanelStateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroup() {
        return "folder_pendant";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getGroupExtraKey() {
        return com.tencent.biz.richframework.order.a.b(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSuspendOpenPushBoxPart";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 100;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ boolean isDataReady() {
        return com.tencent.biz.richframework.order.a.c(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (this.D > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return com.tencent.biz.qqcircle.manager.i.a("qfs_enable_push_rocket");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f909953z) {
            this.F = QCircleDaTongConstant.ElementId.EM_XSJ_BOX_PENDANT;
            N9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        Q9(this.D);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        FrameLayout frameLayout = this.f87570e;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(8);
        z70.b bVar = this.J;
        if (bVar != null) {
            bVar.m();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        com.tencent.biz.qqcircle.immersive.manager.e.a().addElement(this);
        M9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            I9((ASEngineTabStatusEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSSuspendOpenBoxUpdateEvent) {
            QQCircleFeedBase$StUserPushBoxInfo pushBoxInfo = ((QFSSuspendOpenBoxUpdateEvent) simpleBaseEvent).getPushBoxInfo();
            QLog.d("QFSSuspendOpenPushBoxPart", 1, "get feed list event");
            D9(pushBoxInfo);
        } else if (simpleBaseEvent instanceof QFSUpdateSuspendBoxCountEvent) {
            J9(((QFSUpdateSuspendBoxCountEvent) simpleBaseEvent).getIsOpenAll());
        } else if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            H9((QCirclePanelStateEvent) simpleBaseEvent);
        }
    }
}
