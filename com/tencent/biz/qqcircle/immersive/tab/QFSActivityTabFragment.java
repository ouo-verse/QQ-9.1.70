package com.tencent.biz.qqcircle.immersive.tab;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSRefreshSubTabEvent;
import com.tencent.biz.qqcircle.immersive.tab.QFSActivityTabFragment;
import com.tencent.biz.qqcircle.immersive.views.QFSFullScreenHintView;
import com.tencent.biz.qqcircle.immersive.views.QFSSlideConflictView;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.lazyload.QFSNotifyLazyLoadEvent;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QFSMainProcessWebView;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSActivityTabFragment extends QFSFolderTabFragment implements t40.b {
    private final String R;
    private String S;
    private t40.b T;
    private QFSMainProcessWebView U;
    protected QCirclePanelLoadingView V;
    private View W;
    private QFSFullScreenHintView X;
    private boolean Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f89999a0;

    /* renamed from: b0, reason: collision with root package name */
    private QFSSlideConflictView f90000b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f90001c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f90002d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f90003e0;

    /* renamed from: f0, reason: collision with root package name */
    private Boolean f90004f0;

    /* renamed from: g0, reason: collision with root package name */
    private long f90005g0;

    /* renamed from: h0, reason: collision with root package name */
    private final Map<String, String> f90006h0;

    /* renamed from: i0, reason: collision with root package name */
    private final BroadcastReceiver f90007i0;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            QFSSlideConflictView qFSSlideConflictView;
            if (intent == null || (qFSSlideConflictView = QFSActivityTabFragment.this.f90000b0) == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("event");
            if (TextUtils.equals(stringExtra, "disableh5-touch-move")) {
                QLog.d("QFSActivityTabFragment", 4, "[onReceive] " + stringExtra);
                qFSSlideConflictView.setDisallowParentInterceptTouchEvent(false);
                return;
            }
            if (TextUtils.equals(stringExtra, "ableh5-touch-move")) {
                QLog.d("QFSActivityTabFragment", 4, "[onReceive] " + stringExtra);
                qFSSlideConflictView.setDisallowParentInterceptTouchEvent(true);
                return;
            }
            if (TextUtils.equals(stringExtra, "h5_page_load_perf_event")) {
                String stringExtra2 = intent.getStringExtra("source");
                QLog.d("QFSActivityTabFragment", 4, "[onReceive] h5 report data" + stringExtra2);
                if (!TextUtils.isEmpty(stringExtra2)) {
                    QFSActivityTabFragment.this.f90006h0.put("h5_report_data", stringExtra2);
                    QFSActivityTabFragment.this.f90003e0 = stringExtra2;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSActivityTabFragment.this.Pi();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements QFSMainProcessWebView.StatusListener {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            QFSActivityTabFragment.this.showLoadingView();
        }

        @Override // cooperation.qqcircle.utils.QFSMainProcessWebView.StatusListener
        public void loadSucceed() {
            QLog.d("QFSActivityTabFragment", 1, "[initWebView] loadSucceed");
            QFSActivityTabFragment.this.hideLoadingView();
            if (QFSActivityTabFragment.this.X != null) {
                QFSActivityTabFragment.this.X.o0();
            }
            QFSActivityTabFragment.this.f90001c0 = true;
            QFSActivityTabFragment.this.f90002d0 = false;
            QFSActivityTabFragment.this.f90006h0.put("page_load_time", String.valueOf(System.currentTimeMillis() - QFSActivityTabFragment.this.f90005g0));
        }

        @Override // cooperation.qqcircle.utils.QFSMainProcessWebView.StatusListener
        public void onError(Object obj, Object obj2) {
            QLog.d("QFSActivityTabFragment", 1, "[initWebView] onError " + obj2 + ",code:" + obj);
            QFSActivityTabFragment.this.hideLoadingView();
            if (QFSActivityTabFragment.this.X != null) {
                QFSActivityTabFragment.this.X.B0("\u7f51\u9875\u52a0\u8f7d\u5931\u8d25:" + obj);
            }
            if (obj != null && obj2 != null) {
                QFSActivityTabFragment.this.f90006h0.put("page_load_error_code", String.valueOf(obj));
                QFSActivityTabFragment.this.f90006h0.put("page_load_error_msg", String.valueOf(obj2));
            }
            QFSActivityTabFragment.this.f90002d0 = true;
            QFSActivityTabFragment.this.f90001c0 = false;
        }

        @Override // cooperation.qqcircle.utils.QFSMainProcessWebView.StatusListener
        public void onWebViewDestroy() {
            QLog.d("QFSActivityTabFragment", 1, "[onWebViewDestroy]");
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.tab.b
                @Override // java.lang.Runnable
                public final void run() {
                    QFSActivityTabFragment.c.this.b();
                }
            });
            QFSActivityTabFragment.this.f90002d0 = false;
            QFSActivityTabFragment.this.f90001c0 = false;
        }
    }

    public QFSActivityTabFragment(QCircleTabInfo qCircleTabInfo, int i3) {
        super(qCircleTabInfo, i3);
        this.f90006h0 = new ConcurrentHashMap();
        this.f90007i0 = new a();
        if (qCircleTabInfo != null && qCircleTabInfo.getTabDiyConfig() != null) {
            this.R = qCircleTabInfo.getTabDiyConfig().jumpUrlInfo.jumpUrl.get();
            this.S = qCircleTabInfo.getTabTaskId();
        } else {
            this.R = null;
            this.S = null;
        }
        QLog.d("QFSActivityTabFragment", 1, "[QFSActivityTabFragment] origin url:" + this.R + ",mTaskId:" + this.S);
        yi(this.S);
    }

    private void Ai(boolean z16) {
        if (!Sh()) {
            return;
        }
        if (z16) {
            Qi();
        } else {
            zi();
        }
    }

    private void Bi() {
        try {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
                activity.registerReceiver(this.f90007i0, intentFilter, "com.tencent.msg.permission.pushnotify", null);
            }
        } catch (Exception e16) {
            RFWLog.e("QFSActivityTabFragment", RFWLog.USR, "doRegisterReceiver error:" + e16);
        }
    }

    private boolean Ci() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_force_refresh_when_enter_qfs", false);
    }

    private boolean Di() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_activity_tab_force_kill_tools_process_when_exit", false);
    }

    private boolean Ei() {
        Boolean bool = this.f90004f0;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_h5_tab_slid", true));
        this.f90004f0 = valueOf;
        return valueOf.booleanValue();
    }

    private boolean Fi() {
        if (this.Z > 1 || bz.r()) {
            return false;
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_activity_tab_web_preload_9_0_80", true);
    }

    private int Gi() {
        QLog.d("QFSActivityTabFragment", 1, "getDefaultTopBarHeight");
        return ImmersiveUtils.getStatusBarHeight(getContext()) + ImmersiveUtils.dpToPx(48.0f);
    }

    private int Hi() {
        if (!this.P) {
            return 0;
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return Gi();
        }
        View findViewById = activity.findViewById(R.id.vg5);
        if (findViewById != null && findViewById.getMeasuredHeight() != 0) {
            int[] iArr = new int[2];
            findViewById.getLocationOnScreen(iArr);
            int i3 = iArr[1];
            if (i3 == 0) {
                return Gi();
            }
            return i3 + findViewById.getMeasuredHeight();
        }
        return Gi();
    }

    private String Ii() {
        String str;
        String str2 = this.R;
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            int pxToDp = ImmersiveUtils.pxToDp(Hi());
            if (str2.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str = str2 + "&qfsTobBarPos=";
            } else {
                str = str2 + "?qfsTobBarPos=";
            }
            return (((str + String.valueOf(pxToDp)) + "&enableTouchConflict=1") + "&is_qfs_main_tab=1") + "&qfs_page_lifecycle=1";
        } catch (Exception unused) {
            return str2;
        }
    }

    private void Ji(ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        QFSMainProcessWebView qFSMainProcessWebView;
        if (!aSEngineTabStatusEvent.getBusinessKey().equals(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE)) {
            return;
        }
        Ai(aSEngineTabStatusEvent.isSelected());
        if (aSEngineTabStatusEvent.isSelected()) {
            RFWLog.d("QFSActivityTabFragment", RFWLog.USR, "handleTabChangeEvent onSelect");
            if (Li()) {
                QFSMainProcessWebView qFSMainProcessWebView2 = this.U;
                if (qFSMainProcessWebView2 != null) {
                    qFSMainProcessWebView2.startKeepAlive();
                    this.U.onRealShow(Ci());
                    return;
                }
                return;
            }
            if (Fi() && (qFSMainProcessWebView = this.U) != null) {
                qFSMainProcessWebView.doRender(Ci());
                return;
            }
            return;
        }
        RFWLog.d("QFSActivityTabFragment", RFWLog.USR, "handleTabChangeEvent onUnselect");
        QFSMainProcessWebView qFSMainProcessWebView3 = this.U;
        if (qFSMainProcessWebView3 != null) {
            qFSMainProcessWebView3.onRealHide();
            this.U.stopKeepAlive();
            if (QFSMainProcessWebView.enableKillInstanceOnExit()) {
                this.U.postDelayDestroyRemoteView();
            } else {
                Mi();
            }
        }
    }

    private void Ki(View view) {
        QFSMainProcessWebView qFSMainProcessWebView = (QFSMainProcessWebView) view.findViewById(R.id.f33140vn);
        this.U = qFSMainProcessWebView;
        qFSMainProcessWebView.setStatusListener(new c());
    }

    private boolean Li() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_activity_tab_use_diy_visible_interface", true)) {
            return Rh();
        }
        return getUserVisibleHint();
    }

    private void Mi() {
        if (!Di()) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.tab.a
            @Override // java.lang.Runnable
            public final void run() {
                QFSActivityTabFragment.Ni();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ni() {
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) MobileQQ.sMobileQQ.getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                if (runningAppProcessInfo.processName.equals("com.tencent.mobileqq:tool")) {
                    SystemMethodProxy.killProcess(runningAppProcessInfo.pid);
                    RFWLog.d("QFSActivityTabFragment", RFWLog.USR, "killToolsIfNeed real do");
                }
            }
        } catch (Exception e16) {
            RFWLog.d("QFSActivityTabFragment", RFWLog.USR, "killToolsIfNeed error:" + e16);
        }
    }

    private void Oi() {
        QLog.d("QFSActivityTabFragment", 1, "[preloadWebUrl] mH5TabIndexOnList:" + this.Z);
        if (!Fi()) {
            return;
        }
        QLog.d("QFSActivityTabFragment", 1, "[preloadWebUrl] real do");
        load();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pi() {
        if (this.U == null) {
            QLog.e("QFSActivityTabFragment", 1, "mWebView is null");
            return;
        }
        String Ii = Ii();
        QLog.d("QFSActivityTabFragment", 1, "[realLoadData] jumpUrl:" + Ii);
        if (!TextUtils.isEmpty(Ii)) {
            this.U.initConfig(Ii);
        }
    }

    private void Qi() {
        String str;
        RFWLog.d("QFSActivityTabFragment", RFWLog.USR, "resetCollectReportInfo");
        this.f90006h0.clear();
        this.f90005g0 = System.currentTimeMillis();
        Map<String, String> map = this.f90006h0;
        String str2 = "1";
        if (this.f90001c0) {
            str = "1";
        } else {
            str = "0";
        }
        map.put("enter_succeed", str);
        Map<String, String> map2 = this.f90006h0;
        if (!this.f90002d0) {
            str2 = "0";
        }
        map2.put("enter_error_status", str2);
        if (this.f90001c0 && !TextUtils.isEmpty(this.f90003e0)) {
            this.f90006h0.put("h5_report_data", this.f90003e0);
        }
    }

    private void Ri(String str) {
        QCirclePanelLoadingView qCirclePanelLoadingView;
        View view;
        HashMap<String, String> c16 = com.tencent.biz.qqcircle.d.c(str);
        if (c16 == null) {
            return;
        }
        try {
            String str2 = c16.get("qfs_h5_page_show_loading");
            String str3 = c16.get("qfs_h5_page_bg_color");
            RFWLog.d("QFSActivityTabFragment", RFWLog.USR, "resetUiConfig showLoading:" + str2 + ",bgColor:" + str3);
            if (!TextUtils.isEmpty(str3) && (view = this.W) != null) {
                view.setBackgroundColor(Color.parseColor("#" + str3));
            }
            if (str2 != null && !TextUtils.equals(str2, "1")) {
                this.Y = false;
                if (this.Y && (qCirclePanelLoadingView = this.V) != null) {
                    qCirclePanelLoadingView.k0();
                    return;
                }
            }
            this.Y = true;
            if (this.Y) {
            }
        } catch (Exception e16) {
            RFWLog.d("QFSActivityTabFragment", RFWLog.USR, "resetUiConfig error:" + e16);
        }
    }

    private void Ti() {
        if (Ei()) {
            try {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.unregisterReceiver(this.f90007i0);
                }
            } catch (Exception e16) {
                RFWLog.e("QFSActivityTabFragment", RFWLog.USR, "unregisterReceiver error:" + e16);
            }
        }
    }

    public static void yi(String str) {
        TextUtils.isEmpty(str);
    }

    private void zi() {
        RFWLog.d("QFSActivityTabFragment", RFWLog.USR, "doPageReport");
        this.f90006h0.put("stay_time", String.valueOf(System.currentTimeMillis() - this.f90005g0));
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : this.f90006h0.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("attach_info");
            String jSONObject2 = jSONObject.toString();
            feedCloudCommon$Entry.value.set(jSONObject2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(feedCloudCommon$Entry);
            RFWLog.d("QFSActivityTabFragment", RFWLog.USR, "doPageReport :" + jSONObject2);
            QCircleQualityReporter.reportQualityEvent(QCircleQualityReporter.KEY_QFS_H5_TAB_PERF_EVENT, arrayList);
        } catch (Exception e16) {
            RFWLog.e("QFSActivityTabFragment", RFWLog.USR, "doPageReport error:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void Hh(QFSNotifyLazyLoadEvent qFSNotifyLazyLoadEvent) {
        super.Hh(qFSNotifyLazyLoadEvent);
        if (qFSNotifyLazyLoadEvent.getNotifyId() == 7) {
            Oi();
        }
    }

    public void Si(int i3) {
        this.Z = i3;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void fi() {
        RFWLog.d("QFSActivityTabFragment", RFWLog.USR, "scrollToTopAndRefresh");
        QFSMainProcessWebView qFSMainProcessWebView = this.U;
        if (qFSMainProcessWebView != null) {
            qFSMainProcessWebView.doRender(true);
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        String titleName = getTitleName();
        if (!TextUtils.isEmpty(titleName)) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TAB_TITLE, titleName);
        }
        if (!TextUtils.isEmpty(this.S)) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTIVITY_ID, this.S);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g7b;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        if (TextUtils.isEmpty(this.Q)) {
            return QCircleDaTongConstant.PageId.PG_XSJ_OPERATION_TAB_PAGE;
        }
        return this.Q;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(ASEngineTabStatusEvent.class);
        eventClass.add(QFSRefreshSubTabEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSActivityTabFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    protected void hideLoadingView() {
        QCirclePanelLoadingView qCirclePanelLoadingView = this.V;
        if (qCirclePanelLoadingView != null) {
            qCirclePanelLoadingView.k0();
        }
        View view = this.W;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.part.ILazyLoader
    public void load() {
        if (this.f89999a0) {
            return;
        }
        this.f89999a0 = true;
        Pi();
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Ti();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QFSMainProcessWebView qFSMainProcessWebView = this.U;
        if (qFSMainProcessWebView != null) {
            qFSMainProcessWebView.setStatusListener(null);
        }
    }

    @Override // t40.b
    public void onHandlerMessage(String str, Object... objArr) {
        t40.b bVar = this.T;
        if (bVar != null) {
            bVar.onHandlerMessage(str, objArr);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QFSMainProcessWebView qFSMainProcessWebView = this.U;
        if (qFSMainProcessWebView != null) {
            qFSMainProcessWebView.onRealHide();
            this.U.stopKeepAlive();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            Ji((ASEngineTabStatusEvent) simpleBaseEvent);
        } else if ((simpleBaseEvent instanceof QFSRefreshSubTabEvent) && ((QFSRefreshSubTabEvent) simpleBaseEvent).getCurrentPos() == this.G) {
            fi();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QFSVideoView.D = null;
        QFSMainProcessWebView qFSMainProcessWebView = this.U;
        if (qFSMainProcessWebView != null) {
            qFSMainProcessWebView.startKeepAlive();
            this.U.onRealShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        this.f90000b0 = (QFSSlideConflictView) view.findViewById(R.id.f57662nx);
        this.V = (QCirclePanelLoadingView) view.findViewById(R.id.f57652nw);
        QFSFullScreenHintView qFSFullScreenHintView = (QFSFullScreenHintView) view.findViewById(R.id.f52242__);
        this.X = qFSFullScreenHintView;
        qFSFullScreenHintView.setTokenByErrorCode(10014L, 16);
        this.X.setTokenByErrorCode(10009L, 1);
        this.X.setOnRetryClickListener(new b());
        this.W = view.findViewById(R.id.f57642nv);
        Ki(view);
        Ri(Ii());
        if (Ei()) {
            Bi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        this.T = (t40.b) getIocInterface(t40.b.class);
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        if (!z16) {
            QFSMainProcessWebView qFSMainProcessWebView = this.U;
            if (qFSMainProcessWebView != null) {
                qFSMainProcessWebView.stopKeepAlive();
            }
            zi();
            return;
        }
        Qi();
    }

    protected void showLoadingView() {
        QCirclePanelLoadingView qCirclePanelLoadingView = this.V;
        if (qCirclePanelLoadingView != null && this.Y) {
            qCirclePanelLoadingView.n0();
        }
        View view = this.W;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public QFSActivityTabFragment(String str, QCircleTabInfo qCircleTabInfo, int i3) {
        super(qCircleTabInfo, i3);
        this.f90006h0 = new ConcurrentHashMap();
        this.f90007i0 = new a();
        this.R = str;
        this.S = com.tencent.biz.qqcircle.d.c(str).get(QCircleSchemeAttr.WebView.KEY_BUSINESS_ID);
        QLog.d("QFSActivityTabFragment", 1, "[QFSActivityTabFragment] origin url:" + str + ",taskId:" + this.S);
        yi(this.S);
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void di() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void scrollToTop() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void sh() {
    }
}
