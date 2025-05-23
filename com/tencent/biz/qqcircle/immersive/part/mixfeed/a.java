package com.tencent.biz.qqcircle.immersive.part.mixfeed;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.c;
import com.tencent.biz.qqcircle.immersive.events.QFSMixSubTabSelectEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.utils.z;
import com.tencent.biz.qqcircle.widgets.QCircleInteractiveLayout;
import com.tencent.biz.qqcircle.widgets.QCircleNearbyTabStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import feedcloud.FeedCloudMeta$StGPSV2;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends u implements c.InterfaceC0846c, SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private boolean f88210d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleNearbyTabStatusView f88211e;

    /* renamed from: h, reason: collision with root package name */
    private int f88213h;

    /* renamed from: f, reason: collision with root package name */
    private boolean f88212f = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f88214i = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.part.mixfeed.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class ViewOnClickListenerC0894a implements View.OnClickListener {
        ViewOnClickListenerC0894a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(94).setSubActionType(5));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.this.f88211e.setVisibility(8);
            a.this.N9();
            EventCollector.getInstance().onViewClicked(view);
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
            a.this.L9();
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(94).setSubActionType(6));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d extends QQPermission.BasePermissionsListener {
        d() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.d("QFSGpsFetchPart", 1, "requestGetCoarseGpsPermission result grant");
            a.this.G9();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            a.this.Q9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e extends QQPermission.BasePermissionsListener {
        e() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.d("QFSGpsFetchPart", 1, "requestGetFineGpsPermission result grant");
            a.this.f88212f = true;
            a.this.G9();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            a.this.O9();
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
            if (!a.this.J9()) {
                a.this.broadcastMessage("qfs_refresh_data", null);
                QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(94).setSubActionType(6));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            boolean k3 = com.tencent.biz.qqcircle.c.e().k();
            QLog.d("QFSGpsFetchPart", 1, "showCoarsePermissionGpsErrorView click, isGpsInfoReady:" + k3);
            if (!k3) {
                a.this.M9();
                QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(94).setSubActionType(6));
            } else {
                a.this.broadcastMessage("qfs_refresh_data", null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a(int i3) {
        this.f88213h = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G9() {
        QCircleNearbyTabStatusView qCircleNearbyTabStatusView = this.f88211e;
        if (qCircleNearbyTabStatusView != null) {
            qCircleNearbyTabStatusView.o0();
        }
        R9();
        com.tencent.biz.qqcircle.c.e().h(this);
        QLog.d("QFSGpsFetchPart", 1, "getLocationAndFetchData");
    }

    private void H9(QFSMixSubTabSelectEvent qFSMixSubTabSelectEvent) {
        Activity activity;
        if (!this.f88214i && qFSMixSubTabSelectEvent.getSelectPos() == this.f88213h && (activity = getActivity()) != null && activity.hashCode() == qFSMixSubTabSelectEvent.getActivityHashCode()) {
            J9();
        }
    }

    private void I9() {
        QCircleNearbyTabStatusView qCircleNearbyTabStatusView = new QCircleNearbyTabStatusView(getContext());
        qCircleNearbyTabStatusView.setEmptyClickListener(new ViewOnClickListenerC0894a());
        this.f88211e = qCircleNearbyTabStatusView;
        qCircleNearbyTabStatusView.setOnRetryClickListener(new b());
        View partRootView = getPartRootView();
        if (getPartRootView() instanceof QCircleInteractiveLayout) {
            partRootView = ((QCircleInteractiveLayout) partRootView).getChildAt(0);
        }
        ((ViewGroup) partRootView).addView(qCircleNearbyTabStatusView, new FrameLayout.LayoutParams(-1, -1));
        this.f88211e.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J9() {
        if (!com.tencent.biz.qqcircle.c.e().k()) {
            S9();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L9() {
        z.b(getActivity(), 2, new d(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_MIX_FEED), "android.permission.ACCESS_COARSE_LOCATION");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M9() {
        z.b(getActivity(), 2, new e(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_MIX_FEED), "android.permission.ACCESS_FINE_LOCATION");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O9() {
        QLog.d("QFSGpsFetchPart", 1, "showCoarsePermissionGpsErrorView");
        K9();
        QCircleNearbyTabStatusView qCircleNearbyTabStatusView = this.f88211e;
        if (qCircleNearbyTabStatusView != null && (qCircleNearbyTabStatusView instanceof QCircleNearbyTabStatusView)) {
            qCircleNearbyTabStatusView.M0(new g());
        }
    }

    private void P9() {
        QLog.d("QFSGpsFetchPart", 1, "showNoGpsInfoView");
        K9();
        QCircleNearbyTabStatusView qCircleNearbyTabStatusView = this.f88211e;
        if (qCircleNearbyTabStatusView != null && (qCircleNearbyTabStatusView instanceof QCircleNearbyTabStatusView)) {
            qCircleNearbyTabStatusView.L0(new f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q9() {
        K9();
        QLog.d("QFSGpsFetchPart", 1, "showNoPermissionView");
        QCircleNearbyTabStatusView qCircleNearbyTabStatusView = this.f88211e;
        if (qCircleNearbyTabStatusView != null && (qCircleNearbyTabStatusView instanceof QCircleNearbyTabStatusView)) {
            qCircleNearbyTabStatusView.M0(new c());
        }
    }

    private void S9() {
        if (com.tencent.biz.qqcircle.c.e().c(getActivity())) {
            G9();
        } else {
            Q9();
        }
    }

    protected void K9() {
        broadcastMessage("qfs_change_loading_view_status", Boolean.FALSE);
    }

    public void N9() {
        QLog.d(getTAG(), 1, "scrollToTopAndRefresh");
        QCircleNearbyTabStatusView qCircleNearbyTabStatusView = this.f88211e;
        if (qCircleNearbyTabStatusView != null) {
            qCircleNearbyTabStatusView.o0();
        }
        broadcastMessage("qfs_refresh_data", null);
    }

    public void R9() {
        broadcastMessage("qfs_show_refresh_ani", null);
    }

    @Override // com.tencent.biz.qqcircle.c.InterfaceC0846c
    public void g9(int i3) {
        if (!this.f88212f && i3 == 2 && com.tencent.biz.qqcircle.c.e().c(getActivity()) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_nearby_tab_fine_location", true)) {
            O9();
        } else {
            P9();
        }
        this.f88212f = false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSMixSubTabSelectEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSGpsFetchPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        I9();
        this.f88214i = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_nearby_tab_init_request_location", false);
        QLog.d("QFSGpsFetchPart", 1, "onInitView, mEnableInitRequestLocation:" + this.f88214i);
        if (this.f88214i) {
            J9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (this.f88210d && com.tencent.biz.qqcircle.c.e().c(activity)) {
            G9();
            this.f88210d = false;
            QLog.d("QFSGpsFetchPart", 1, "refresh data after location permission got");
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSMixSubTabSelectEvent) {
            H9((QFSMixSubTabSelectEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.c.InterfaceC0846c
    public void v9(FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2) {
        N9();
        this.f88212f = false;
    }
}
