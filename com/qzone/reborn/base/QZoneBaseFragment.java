package com.qzone.reborn.base;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qzone.app.QZoneAppInterface;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ci;
import com.qzone.reborn.tracer.monitor.QZoneMonitorProxyImpl;
import com.qzone.report.QZonePerfReporter;
import com.qzone.util.ap;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.api.QZoneApiProxy;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Page(business = Business.QZone, type = PageHierarchy.NonMainPage)
/* loaded from: classes37.dex */
public abstract class QZoneBaseFragment extends ImmersivePartFragment implements ap.a {
    protected static final String TAG = "QZoneBaseFragment";
    private View mContentView;
    protected boolean mIsRecreated = false;
    private tc.e mNetStateViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneBaseFragment> f53556a;

        public a(QZoneBaseFragment qZoneBaseFragment) {
            this.f53556a = new WeakReference<>(qZoneBaseFragment);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            QZoneBaseFragment qZoneBaseFragment;
            WeakReference<QZoneBaseFragment> weakReference = this.f53556a;
            if (weakReference == null || (qZoneBaseFragment = weakReference.get()) == null) {
                return null;
            }
            return qZoneBaseFragment.getChildDaTongDynamicParams();
        }
    }

    private void checkQZoneInitState() {
        if (!km.a.f412646a.a()) {
            RFWLog.i(TAG, RFWLog.USR, this + " qzone process do not need init env");
            return;
        }
        if (getActivity() == null || QZoneApiProxy.isQZonePluginInit()) {
            return;
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            QZoneApiProxy.initEnv(getActivity(), MobileQQ.sMobileQQ.peekAppRuntime());
            QZoneApiProxy.initServlet(getActivity(), MobileQQ.sMobileQQ.peekAppRuntime());
            return;
        }
        RFWLog.i(TAG, RFWLog.USR, this + " checkQZoneInitState error, peekAppRuntime is null");
    }

    private void doLifecycleLog(String str) {
        RFWLog.i(TAG, RFWLog.USR, "qzone fragment lifecycle " + this + MsgSummary.STR_COLON + str);
    }

    private void endFragmentInflateStep() {
        jo.g c16 = jo.h.f410717a.c();
        if (c16 != null) {
            c16.m("FRAGMENT_INFLATE");
        }
    }

    private String getRMonitorTraceName() {
        return getClass().getSimpleName();
    }

    private void startFragmentInflateStep() {
        jo.g c16 = jo.h.f410717a.c();
        if (c16 != null) {
            c16.x("FRAGMENT_INFLATE");
        }
    }

    public abstract /* synthetic */ List<Part> assembleParts();

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return com.tencent.biz.richframework.compat.f.b(this, i3, keyEvent);
    }

    protected boolean enableDaTongPageRegister() {
        return true;
    }

    protected Map<String, Object> getChildDaTongDynamicParams() {
        return null;
    }

    protected Map<String, Object> getChildDaTongPageParams() {
        return null;
    }

    protected String getDaTongPageId() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T getIocInterface(Class<T> cls) {
        return (T) PartFragmentIOCKt.getIocInterface(this, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public String getLogTag() {
        return TAG;
    }

    public <T extends ViewModel> T getOuterViewModel(Class<T> cls) {
        if (getParentFragment() instanceof QZoneBaseFragment) {
            return (T) ((QZoneBaseFragment) getParentFragment()).getViewModel(cls);
        }
        RFWLog.fatal(getLogTag(), RFWLog.USR, new RuntimeException("getOuterViewModel error: " + getParentFragment()));
        return null;
    }

    public int getReportPageId() {
        return -1;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        com.tencent.biz.richframework.compat.f.c(this, activity);
    }

    public boolean isRecreated() {
        return this.mIsRecreated;
    }

    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return com.tencent.biz.richframework.compat.f.d(this);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected boolean isUseDarkTextStatusBar() {
        return !QQTheme.isNowThemeIsNight();
    }

    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return com.tencent.biz.richframework.compat.f.e(this);
    }

    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return com.tencent.biz.richframework.compat.f.f(this);
    }

    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return com.tencent.biz.richframework.compat.f.g(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        doLifecycleLog("onActivityCreated");
        jo.g c16 = jo.h.f410717a.c();
        if (c16 != null) {
            c16.m("PART_INIT");
        }
        super.onActivityCreated(bundle);
        checkQZoneInitState();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        doLifecycleLog("onCreateView");
        startFragmentInflateStep();
        View f16 = jm.b.f410600a.f(getActivity(), getContentLayoutId(), false);
        this.mContentView = f16;
        if (f16 == null) {
            this.mContentView = layoutInflater.inflate(getContentLayoutId(), viewGroup, false);
        }
        endFragmentInflateStep();
        return this.mContentView;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        doLifecycleLog(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        tc.e eVar = this.mNetStateViewModel;
        if (eVar != null) {
            eVar.onDestroy();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        doLifecycleLog("onDestroyView");
        super.onDestroyView();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public void onPartTimeCostReport(String str, String str2, long j3) {
        String str3 = str + "#" + str2;
        if (j3 > 10) {
            com.qzone.reborn.debug.timecost.b.f53835a.c("part_lifecycle", str3, j3);
        }
        if (j3 > 20) {
            QZonePerfReporter.f59697a.i(str3, j3);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        doLifecycleLog(MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        super.onPause();
        po.a.f426574a.a(getRMonitorTraceName());
        com.qzone.reborn.tracer.monitor.b.a().stop();
        ap.g();
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        SimpleUIUtil.bgColor = 0;
        SimpleUIUtil.textColor = 0;
    }

    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        com.tencent.biz.richframework.compat.f.l(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        doLifecycleLog("onResume");
        jo.g c16 = jo.h.f410717a.c();
        if (c16 != null) {
            c16.x("FRAGMENT_ON_RESUME");
        }
        registerDaTongReportPageId();
        super.onResume();
        po.a.f426574a.b(getRMonitorTraceName());
        com.qzone.reborn.tracer.monitor.b.a().start(getActivity());
        if (c16 != null) {
            c16.m("FRAGMENT_ON_RESUME");
        }
        ap.h(this);
    }

    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        doLifecycleLog(DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED);
        com.qzone.reborn.tracer.monitor.b.a().injectProxyImpl(QZoneMonitorProxyImpl.b());
        jo.g c16 = jo.h.f410717a.c();
        if (c16 != null) {
            c16.x("FRAGMENT_ON_VIEW_CREATED");
        }
        super.onViewCreated(view, bundle);
        tc.e eVar = (tc.e) getViewModel(tc.e.class);
        this.mNetStateViewModel = eVar;
        eVar.R1(true);
        if (c16 != null) {
            c16.m("FRAGMENT_ON_VIEW_CREATED");
            c16.x("PART_INIT");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.mIsRecreated = true;
        }
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return com.tencent.biz.richframework.compat.f.o(this);
    }

    public void registerDaTongReportPageId() {
        String str;
        if (!enableDaTongPageRegister()) {
            QLog.i(TAG, 1, "reportDaTongRegister enableDaTongPageRegister is false, subPage: " + getLogTag());
            return;
        }
        if (this.mContentView == null) {
            QLog.i(TAG, 1, "reportDaTongRegister  mContentView == null , subPage: " + getLogTag());
            return;
        }
        if (!TextUtils.isEmpty(getDaTongPageId())) {
            str = getDaTongPageId();
        } else {
            str = "qzone_base_pageId";
        }
        VideoReport.setPageId(this.mContentView, str);
        VideoReport.setPageParams(this.mContentView, new fo.a().d(getLogTag(), getChildDaTongPageParams()));
        VideoReport.setEventDynamicParams(this.mContentView, new a(this));
        QLog.i(TAG, 1, "registerDaTongReportPageId  | appKey: 0AND0MWZXR4U3RVU | subPage: " + getLogTag() + " | pageId: " + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerIoc(Object obj, Class<?> cls) {
        registerIoc(getFragmentContentView(), obj, cls);
    }

    public void syncLoginStatus() {
        if (getActivity() != null) {
            ci.b(getActivity().getIntent());
        }
        AppRuntime qzoneAppInterface = LoginData.getInstance().getQzoneAppInterface();
        if (qzoneAppInterface instanceof QZoneAppInterface) {
            ((QZoneAppInterface) qzoneAppInterface).onActivityCreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unregisterIoc(Class<?> cls) {
        PartFragmentIOCKt.unregisterIoc(this, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerIoc(View view, Object obj, Class<?> cls) {
        PartFragmentIOCKt.registerIoc(this, view, obj, cls);
    }
}
