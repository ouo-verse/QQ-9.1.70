package com.tencent.hippy.qq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.hippy.qq.api.IBaseHttpAdapter;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IHippyAdapter;
import com.tencent.hippy.qq.api.IHippyInnerApi;
import com.tencent.hippy.qq.api.IHippyReportCache;
import com.tencent.hippy.qq.api.IHippySSR;
import com.tencent.hippy.qq.api.ISSRBundleRequester;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.obj.HippyEngineReportData;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.HippyDebugUtil;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.NumberUtil;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class BaseHippyFragment extends QPublicBaseFragment implements HippyActivityLifecycleOwner, com.tencent.mobileqq.pad.f {
    public static final String EXTRA_KEY_COST_EXECUTE_SSR_COMMON_JS = "excutessrScript";
    public static final String EXTRA_KEY_CUR_STEP = "curLoadStep";
    public static final String EXTRA_KEY_IS_PREDRAW = "isPredraw";
    public static final String EXTRA_KEY_IS_PRELOAD = "isPreload";
    public static final String EXTRA_KEY_IS_RESTORED = "isRestored";
    public static final String EXTRA_KEY_PRELOADING_STEP_WHEN_USE = "removePreDrawState";
    public static final String EXTRA_KEY_PSKEY_STATE = "pskeyState";
    public static final String EXTRA_KEY_REPORT_SIGNATURE = "sign";
    public static final String EXTRA_KEY_SKEY_STATE = "skeyState";
    public static final String EXTRA_KEY_SSR_COMMON_JS_VERSION = "commonssrVer";
    public static final String EXTRA_KEY_UPDATE_BUS_JS_STATE = "updateBusJsState";
    protected static final String TAG = "BaseHippyFragment";
    private static final String URL_PARAMETER_BUNDLE_NAME = "v_bundleName";
    private long mCreateViewStartTime;
    private MyFlingGestureHandler mFlingGesture;
    protected HippyQQPreloadEngine mHippyQQEngine;
    private long mLoadHippyStartTime;
    private String mModuleName;
    private int mOpenId;
    private String mPreloadingStepNameWhenUse;
    private ISSRBundleRequester mSSRBundleRequester;
    private Bundle mEmptyBundle = new Bundle();
    public String mFrameworkType = HippyQQConstants.HIPPY_VUE;
    private boolean isHandleBackEvent = true;
    private boolean mIsPageAppeared = true;
    private HippyActivityLifecycleDispatcher mDispatcher = new HippyActivityLifecycleDispatcher();
    private OpenHippyInfo mOpenHippyInfo = new OpenHippyInfo();
    private boolean mIsActivityRestored = false;
    private boolean mIsActivitySaving = false;
    BaseActivityLifecycleCallbacks activityLifecycle = new BaseActivityLifecycleCallbacks() { // from class: com.tencent.hippy.qq.fragment.BaseHippyFragment.4
        private void removeFragmentState(Bundle bundle) {
            if (bundle != null) {
                bundle.remove("android:viewHierarchyState");
                bundle.remove("android:fragments");
                bundle.remove("android:support:fragments");
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public boolean doOnDispatchKeyEvent(KeyEvent keyEvent) {
            return false;
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onPreSetContentView(int i3) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onRestoreInstanceState(Activity activity, Bundle bundle) {
            BaseHippyFragment.this.mIsActivityRestored = true;
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onSaveInstanceState(Activity activity, Bundle bundle) {
            removeFragmentState(bundle);
            if (bundle != null) {
                removeFragmentState(bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key"));
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onPreSetContentView(View view) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityDestroyed(Activity activity) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityOnStart(Activity activity) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityPause(Activity activity) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityPostPaused(Activity activity) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityPostResumed(Activity activity) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityPrePaused(Activity activity) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityPreResumed(Activity activity) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityResume(Activity activity) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityStopped(Activity activity) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onAccountChanged(Activity activity) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onPostThemeChanged(Activity activity) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityCreate(Activity activity, Bundle bundle) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityPostCreated(Activity activity, Bundle bundle) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityPreCreated(Activity activity, Bundle bundle) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnConfigurationChanged(Activity activity, Configuration configuration) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnNewIntent(Activity activity, Intent intent) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnWindowFocusChanged(Activity activity, boolean z16) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onMultiWindowModeChanged(Activity activity, boolean z16) {
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onPreHandleStartActivityForResult(Activity activity, Intent intent, int i3) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class MyFlingGestureHandler extends FlingGestureHandler {
        private boolean enableFling;

        public MyFlingGestureHandler(Activity activity, Bundle bundle) {
            super(activity);
            this.enableFling = bundle.getBoolean(OpenHippyInfo.EXTRA_KEY_IS_ENABLE_RIGHT_FLING);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.activity.fling.FlingHandler
        public boolean canWrapContent() {
            return this.enableFling;
        }

        public void enableFling(boolean z16) {
            this.enableFling = z16;
            if (!isWrapped()) {
                wrap();
            }
            TopGestureLayout topGestureLayout = this.mTopLayout;
            if (topGestureLayout != null) {
                topGestureLayout.setInterceptTouchFlag(z16);
            }
        }

        @Override // com.tencent.mobileqq.activity.fling.FlingGestureHandler, com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener
        public void flingLToR() {
            if (this.enableFling) {
                super.flingLToR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doActivityBack() {
        if (getQBaseActivity() != null) {
            getQBaseActivity().doOnBackPressed();
        }
    }

    private JSONObject generateInitData() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            return null;
        }
        IHippyAccessHelper iHippyAccessHelper = (IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class);
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        String str = this.mModuleName;
        OpenHippyInfo openHippyInfo = this.mOpenHippyInfo;
        JSONObject jSInitData = iHippyAccessHelper.getJSInitData(appRuntime, str, openHippyInfo.url, openHippyInfo.domain, getParameters().getString(OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA));
        try {
            jSInitData.put("ssrBundleUrl", this.mOpenHippyInfo.ssrBundleUrl);
            String str2 = this.mModuleName;
            if (str2 != null && str2.contains(HippyQQConstants.ModuleName.QQ_GAME_CENTER)) {
                jSInitData.put("ssrBundleData", this.mOpenHippyInfo.ssrBundleData);
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "generateInitData error:", e16);
        }
        JSONObject doBussinessInitData = doBussinessInitData(jSInitData);
        if (doBussinessInitData != null) {
            return doBussinessInitData;
        }
        return jSInitData;
    }

    private int getModuleVersion() {
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null) {
            return hippyQQPreloadEngine.getModuleVersion();
        }
        return 0;
    }

    private long getValueFromStepCosts(String str, HashMap<String, Long> hashMap) {
        if (hashMap.containsKey(str)) {
            return hashMap.get(str).longValue();
        }
        return 0L;
    }

    private void initHippy(Bundle bundle, ViewGroup viewGroup) {
        if (this.mHippyQQEngine == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (bundle != null && bundle.containsKey("param")) {
            try {
                jSONObject = new JSONObject(bundle.getString("param"));
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "initHippy error:" + e16);
            }
        }
        if (!this.mHippyQQEngine.isReady()) {
            QLog.e(TAG, 1, "HippyQQEngine not ready");
        }
        this.mHippyQQEngine.initHippyInContainer(viewGroup, jSONObject, false, new HippyQQEngine.HippyQQEngineListener() { // from class: com.tencent.hippy.qq.fragment.BaseHippyFragment.3
            @Override // com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener
            public void onError(int i3, String str) {
                if (i3 != 0 && i3 != -11) {
                    if (!BaseHippyFragment.this.gotoErrorUrl()) {
                        BaseHippyFragment.this.onLoadHippyError(i3, str);
                    }
                    BaseHippyFragment.this.onLoadHippyFinish(i3, str);
                }
                QLog.d(BaseHippyFragment.TAG, 1, "Hippy: initHippy error statusCode=" + i3 + ", msg=" + str);
            }

            @Override // com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener
            public void onSuccess() {
                QLog.d(BaseHippyFragment.TAG, 1, "Hippy: initHippy success!");
                BaseHippyFragment.this.onLoadHippySuccess();
                BaseHippyFragment.this.onLoadHippyFinish(0, null);
            }
        });
    }

    private void modifyGlobalExtra(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mHippyQQEngine.runJavaScript("global.__HIPPYNATIVEGLOBAL__.tkd.extra=" + ("JSON.parse('" + jSONObject.toString() + "')"));
    }

    private void modifyParamsByInterpolator() {
        HippyInterpolator hippyInterpolator = ((IHippyInnerApi) QRoute.api(IHippyInnerApi.class)).getHippyInterpolator(this.mOpenHippyInfo.bundleName);
        if (hippyInterpolator != null) {
            OpenHippyInfo openHippyInfo = this.mOpenHippyInfo;
            openHippyInfo.url = hippyInterpolator.getUrl(openHippyInfo, this.mHippyQQEngine);
            this.mHippyQQEngine.setPageUrl(this.mOpenHippyInfo.url);
            OpenHippyInfo openHippyInfo2 = this.mOpenHippyInfo;
            openHippyInfo2.ssrBundleUrl = hippyInterpolator.getSsrBundleUrl(openHippyInfo2, this.mHippyQQEngine);
        }
    }

    private void printPerformanceData(HashMap<String, Long> hashMap) {
        boolean z16;
        if (hashMap == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Hippy Performancedata isPreload:");
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null) {
            z16 = hippyQQPreloadEngine.isPreloaded();
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(',');
        for (Map.Entry<String, Long> entry : hashMap.entrySet()) {
            sb5.append(entry.getKey());
            sb5.append(':');
            sb5.append(entry.getValue());
            sb5.append(',');
        }
        QLog.i(TAG, 2, sb5.toString());
    }

    private void putStepCost(LinkedHashMap<String, Long> linkedHashMap, String str, long j3, long j16) {
        if (j3 > 0 && j16 > 0) {
            linkedHashMap.put(str, Long.valueOf(j3 - j16));
        }
    }

    private void readParameters() {
        OpenHippyInfo openHippyInfo = new OpenHippyInfo(getParameters());
        this.mOpenHippyInfo = openHippyInfo;
        this.mFrameworkType = HippyUtils.safelyGetJsFrameworkType(openHippyInfo.framework, openHippyInfo.url);
        String str = this.mOpenHippyInfo.bundleName;
        this.mModuleName = str;
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.mOpenHippyInfo.url) && this.mOpenHippyInfo.url.contains(URL_PARAMETER_BUNDLE_NAME)) {
            try {
                this.mModuleName = Uri.parse(this.mOpenHippyInfo.url).getQueryParameter(URL_PARAMETER_BUNDLE_NAME);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "readParameters error:", e16);
            }
        }
    }

    private void reportWillOpenEvent() {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("processName", MobileQQ.sMobileQQ.getQQProcessName());
        hashMap.put("from", getParameters().getString("from"));
        hashMap.put("commonssrVer", String.valueOf(((IHippySSR) QRoute.api(IHippySSR.class)).getSSRCommonJsVersion()));
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null) {
            String str2 = "1";
            if (hippyQQPreloadEngine.isPreloaded()) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("isPreload", str);
            if (!this.mHippyQQEngine.isPredraw()) {
                str2 = "0";
            }
            hashMap.put("isPredraw", str2);
            hashMap.put(OpenHippyInfo.EXTRA_KEY_PRELOAD_TYPE, TabPreloadItem.preloadTypeToString(this.mHippyQQEngine.getPreloadType()));
        }
        HippyReporter.getInstance().reportToDengTa(this.mModuleName, 0, HippyReporter.EventCode.WILL_OPEN_HIPPY, 0, hashMap);
    }

    private void requestSSRBundle(IBaseHttpAdapter iBaseHttpAdapter) {
        if (TextUtils.isEmpty(this.mOpenHippyInfo.ssrBundleUrl)) {
            return;
        }
        ISSRBundleRequester createSSRBundleRequester = ((IHippySSR) QRoute.api(IHippySSR.class)).createSSRBundleRequester();
        this.mSSRBundleRequester = createSSRBundleRequester;
        createSSRBundleRequester.requestSSRBundle(iBaseHttpAdapter, this.mOpenHippyInfo);
    }

    @Deprecated
    protected abstract JSONObject doBussinessInitData(JSONObject jSONObject);

    public void doOnNewIntent(Intent intent) {
        this.mDispatcher.onNewIntent(getActivity(), intent);
    }

    public void enableRightFling(boolean z16) {
        this.mFlingGesture.enableFling(z16);
    }

    public final JSONObject generateBusinessData() {
        return doBussinessInitData(new JSONObject());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HashMap<String, Long> generateStepCosts() {
        LinkedHashMap<String, Long> linkedHashMap;
        HashMap<String, Long> performanceData = getPerformanceData();
        long valueFromStepCosts = getValueFromStepCosts(HippyQQConstants.STEP_NAME_ENTRANCE_SHOW, performanceData);
        long valueFromStepCosts2 = getValueFromStepCosts(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, performanceData);
        long valueFromStepCosts3 = getValueFromStepCosts(HippyQQConstants.STEP_NAME_PAGE_CREATE_START, performanceData);
        long valueFromStepCosts4 = getValueFromStepCosts(HippyQQConstants.STEP_NAME_LOAD_HIPPY_START, performanceData);
        long valueFromStepCosts5 = getValueFromStepCosts(HippyQQConstants.STEP_NAME_LOAD_LIBRARY_START, performanceData);
        long valueFromStepCosts6 = getValueFromStepCosts(HippyQQConstants.STEP_NAME_LOAD_LIBRARY_END, performanceData);
        long valueFromStepCosts7 = getValueFromStepCosts(HippyQQConstants.STEP_NAME_INIT_ENGINE_END, performanceData);
        long valueFromStepCosts8 = getValueFromStepCosts(HippyQQConstants.STEP_NAME_LOAD_MODULE_START, performanceData);
        long valueFromStepCosts9 = getValueFromStepCosts(HippyQQConstants.STEP_NAME_LOAD_MODULE_END, performanceData);
        long valueFromStepCosts10 = getValueFromStepCosts(HippyQQConstants.STEP_NAME_LOAD_SNAPSHOT_END, performanceData);
        LinkedHashMap<String, Long> linkedHashMap2 = new LinkedHashMap<>();
        putStepCost(linkedHashMap2, "ActivityCreate", valueFromStepCosts3, valueFromStepCosts2);
        putStepCost(linkedHashMap2, "containerCreate", valueFromStepCosts4, valueFromStepCosts3);
        putStepCost(linkedHashMap2, "prepareData", valueFromStepCosts5, valueFromStepCosts4);
        putStepCost(linkedHashMap2, "loadLibrary", valueFromStepCosts6, valueFromStepCosts5);
        putStepCost(linkedHashMap2, "initEngine", valueFromStepCosts7, valueFromStepCosts6);
        putStepCost(linkedHashMap2, "checkJsBundle", valueFromStepCosts8, valueFromStepCosts7);
        if (valueFromStepCosts10 != 0) {
            putStepCost(linkedHashMap2, "loadSnapshot", valueFromStepCosts10, valueFromStepCosts8);
            putStepCost(linkedHashMap2, "snapshotTotal", valueFromStepCosts10, valueFromStepCosts2);
        }
        if (valueFromStepCosts > 0) {
            putStepCost(linkedHashMap2, "showDurationTime", valueFromStepCosts2, valueFromStepCosts);
        }
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null) {
            long j3 = hippyQQPreloadEngine.mExecuteSSRCommonJsCost;
            if (j3 > 0) {
                linkedHashMap = linkedHashMap2;
                linkedHashMap.put("excutessrScript", Long.valueOf(j3));
                LinkedHashMap<String, Long> linkedHashMap3 = linkedHashMap;
                putStepCost(linkedHashMap3, "loadJsBundle", valueFromStepCosts9, valueFromStepCosts8);
                putStepCost(linkedHashMap3, "total", valueFromStepCosts9, valueFromStepCosts2);
                return linkedHashMap;
            }
        }
        linkedHashMap = linkedHashMap2;
        LinkedHashMap<String, Long> linkedHashMap32 = linkedHashMap;
        putStepCost(linkedHashMap32, "loadJsBundle", valueFromStepCosts9, valueFromStepCosts8);
        putStepCost(linkedHashMap32, "total", valueFromStepCosts9, valueFromStepCosts2);
        return linkedHashMap;
    }

    @Override // com.tencent.hippy.qq.fragment.HippyActivityLifecycleOwner
    @NotNull
    public HippyActivityLifecycleDispatcher getActivityLifecycleDispatcher() {
        return this.mDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getLastStepName() {
        HashMap<String, Long> performanceData = getPerformanceData();
        String str = "";
        long j3 = 0;
        for (String str2 : performanceData.keySet()) {
            if (performanceData.get(str2).longValue() > j3) {
                j3 = performanceData.get(str2).longValue();
                str = str2;
            }
        }
        return str;
    }

    public String getModuleName() {
        return this.mModuleName;
    }

    public int getOpenId() {
        return this.mOpenHippyInfo.openId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle getParameters() {
        Bundle bundle;
        if (getArguments() != null) {
            bundle = getArguments().getBundle("params");
        } else {
            bundle = null;
        }
        if (bundle == null) {
            return this.mEmptyBundle;
        }
        return bundle;
    }

    public HashMap<String, Long> getPerformanceData() {
        HashMap<String, Long> hashMap = new HashMap<>();
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null) {
            hashMap.putAll(hippyQQPreloadEngine.getLoadStepsTime());
        }
        long j3 = getParameters().getLong(OpenHippyInfo.EXTRA_KEY_ENTRANCE_SHOW_TIME);
        if (j3 > 0 && !this.mIsActivityRestored) {
            hashMap.put(HippyQQConstants.STEP_NAME_ENTRANCE_SHOW, Long.valueOf(j3));
        }
        long j16 = getParameters().getLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START);
        if (this.mIsActivityRestored || j16 <= 0) {
            j16 = this.mCreateViewStartTime;
        }
        hashMap.put(HippyQQConstants.STEP_NAME_PAGE_CREATE_START, Long.valueOf(this.mCreateViewStartTime));
        hashMap.put(HippyQQConstants.STEP_NAME_LOAD_HIPPY_START, Long.valueOf(this.mLoadHippyStartTime));
        hashMap.put(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, Long.valueOf(j16));
        return hashMap;
    }

    public ISSRBundleRequester getSSRBundleRequester() {
        return this.mSSRBundleRequester;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean gotoErrorUrl() {
        QBaseActivity qBaseActivity;
        String string = getParameters().getString(OpenHippyInfo.EXTRA_KEY_ERROR_URL);
        QLog.d(TAG, 1, "Hippy: initHippy errorUrl:" + string);
        if (TextUtils.isEmpty(string) || (qBaseActivity = getQBaseActivity()) == null || qBaseActivity.isFinishing()) {
            return false;
        }
        String str = this.mModuleName;
        if (str != null && str.startsWith(HippyQQConstants.ModuleName.QQ_GAME_CENTER)) {
            ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).startGameCenterActivity(qBaseActivity, string);
        } else if (this.mModuleName != null && ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).isQQGamePubHippyBundle(this.mModuleName)) {
            HippyUtils.gotoGamePubAccountErrorUrl(qBaseActivity, string);
        } else {
            HippyUtils.gotoBrowserActivity(qBaseActivity, string);
        }
        qBaseActivity.finish();
        return true;
    }

    public boolean isFragmentDestroyed() {
        if (getQBaseActivity() != null && !getQBaseActivity().isFinishing()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void loadHippy(ViewGroup viewGroup) {
        this.mLoadHippyStartTime = System.currentTimeMillis();
        readParameters();
        if (TextUtils.isEmpty(this.mModuleName)) {
            return;
        }
        this.mHippyQQEngine = null;
        if (!this.mOpenHippyInfo.isDisablePreload) {
            HippyQQPreloadEngine preloadedHippyQQEngine = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).getPreloadedHippyQQEngine(this.mModuleName, this.mFrameworkType, this.mOpenHippyInfo.minJsBundleVersion);
            this.mHippyQQEngine = preloadedHippyQQEngine;
            if (preloadedHippyQQEngine == null) {
                this.mPreloadingStepNameWhenUse = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).getPreloadingStep(this.mModuleName);
            }
        }
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine == null) {
            this.mHippyQQEngine = new HippyQQPreloadEngine(this, this.mModuleName, this.mOpenHippyInfo.url);
        } else {
            hippyQQPreloadEngine.setFragment(this);
            this.mHippyQQEngine.setHippyActivityLifecycleOwner(this);
            this.mHippyQQEngine.setPageUrl(this.mOpenHippyInfo.url);
        }
        modifyParamsByInterpolator();
        IBaseHttpAdapter createBaseHttpAdapter = ((IHippyAdapter) QRoute.api(IHippyAdapter.class)).createBaseHttpAdapter(HippyUtils.enableHttp2());
        requestSSRBundle(createBaseHttpAdapter);
        JSONObject generateInitData = generateInitData();
        if (this.mHippyQQEngine.isPreloadBase()) {
            this.mHippyQQEngine.setModuleName(this.mModuleName);
            this.mHippyQQEngine.resetApiProviders(this.mModuleName);
            modifyGlobalExtra(generateInitData);
        }
        this.mHippyQQEngine.setHttpAdapter(createBaseHttpAdapter);
        this.mHippyQQEngine.setOpenHippyInfo(this.mOpenHippyInfo);
        this.mHippyQQEngine.setJsBundleType(this.mFrameworkType);
        this.mHippyQQEngine.setInitData(generateInitData, generateInitData);
        if (!this.mHippyQQEngine.isPreloaded()) {
            this.mHippyQQEngine.checkLoginState(generateInitData, !TextUtils.isEmpty(this.mOpenHippyInfo.domain));
        }
        QLog.i(TAG, 1, "ModuleName:" + this.mModuleName + " HippyQQEngine:" + this.mHippyQQEngine + " preloadType:" + this.mHippyQQEngine.getPreloadType());
        reportWillOpenEvent();
        initHippy(getParameters(), viewGroup);
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        openHippyInfo.bundleName = this.mModuleName;
        openHippyInfo.processName = "local";
        openHippyInfo.from = "openHippy";
        ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).destroyPreloadHippy(openHippyInfo);
        ((IHippySSR) QRoute.api(IHippySSR.class)).updateSSRCommonJs();
        OpenHippyInfo openHippyInfo2 = this.mOpenHippyInfo;
        if (openHippyInfo2.openId == 0) {
            openHippyInfo2.openId = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).generateOpenId();
            getParameters().putInt("openId", this.mOpenHippyInfo.openId);
            ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).onOpenHippyStart(this.mOpenHippyInfo);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mDispatcher.onActivityCreated(getQBaseActivity(), bundle);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        this.mDispatcher.onActivityResult(getQBaseActivity(), i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        HippyQQPreloadEngine hippyQQPreloadEngine;
        if (!this.isHandleBackEvent || (hippyQQPreloadEngine = this.mHippyQQEngine) == null) {
            return false;
        }
        return hippyQQPreloadEngine.doOnBackPressed(new HippyEngine.BackPressHandler() { // from class: com.tencent.hippy.qq.fragment.BaseHippyFragment.1
            @Override // com.tencent.mtt.hippy.HippyEngine.BackPressHandler
            public void handleBackPress() {
                BaseHippyFragment.this.isHandleBackEvent = false;
                BaseHippyFragment.this.doActivityBack();
                BaseHippyFragment.this.isHandleBackEvent = true;
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @CallSuper
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        QLog.i(TAG, 1, "onCreateView this:" + this);
        this.mCreateViewStartTime = System.currentTimeMillis();
        this.mFlingGesture = new MyFlingGestureHandler(getActivity(), getParameters());
        if (getQBaseActivity() != null) {
            getQBaseActivity().registerActivityLifecycleCallbacks(this.activityLifecycle);
        }
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.i(TAG, 1, "onDestroy this:" + this);
        if (getQBaseActivity() != null) {
            getQBaseActivity().unregisterActivityLifecycleCallbacks(this.activityLifecycle);
        }
        this.mDispatcher.onActivityDestroyed(getQBaseActivity());
        this.mDispatcher.clearAllListener();
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null) {
            hippyQQPreloadEngine.onDestroy();
            if (!this.mOpenHippyInfo.isDisablePreload && !this.mIsActivitySaving) {
                preloadEngine();
            }
        }
        ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).onHippyDestroy(this.mOpenHippyInfo);
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        if (!this.mOpenHippyInfo.isDisablePreload) {
            preloadEngine();
        }
    }

    protected final void onLoadHippyFinish(int i3, String str) {
        String str2;
        HashMap<String, Long> generateStepCosts = generateStepCosts();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ret", Integer.valueOf(i3));
        hashMap.put("errMsg", str);
        hashMap.put("removePreDrawState", this.mPreloadingStepNameWhenUse);
        hashMap.put("processName", MobileQQ.sMobileQQ.getQQProcessName());
        hashMap.put("from", getParameters().getString("from"));
        hashMap.put("commonssrVer", String.valueOf(((IHippySSR) QRoute.api(IHippySSR.class)).getSSRCommonJsVersion()));
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null) {
            hashMap.put("updateBusJsState", Integer.valueOf(hippyQQPreloadEngine.mReportJSBundleState));
            hashMap.put("skeyState", Integer.valueOf(this.mHippyQQEngine.mReportSKeyState));
            hashMap.put("pskeyState", Integer.valueOf(this.mHippyQQEngine.mReportPSKeyState));
            hashMap.put("isPreload", Boolean.valueOf(this.mHippyQQEngine.isPreloaded()));
            hashMap.put("isPredraw", Boolean.valueOf(this.mHippyQQEngine.isPredraw()));
            hashMap.put(OpenHippyInfo.EXTRA_KEY_PRELOAD_TYPE, TabPreloadItem.preloadTypeToString(this.mHippyQQEngine.getPreloadType()));
            hashMap.put("sign", this.mHippyQQEngine.mPreloadFrom);
        }
        HippyQQPreloadEngine hippyQQPreloadEngine2 = this.mHippyQQEngine;
        if (hippyQQPreloadEngine2 != null && i3 != 0 && i3 != -11) {
            hashMap.putAll(hippyQQPreloadEngine2.generateReportExtraParams());
        }
        if (this.mIsActivityRestored) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("isRestored", str2);
        if (this.mHippyQQEngine != null) {
            HippyReporter.getInstance().reportHippyLoadResult(3, this.mModuleName, getModuleVersion(), hashMap, generateStepCosts, this.mHippyQQEngine.mReportUpdateJSCosts);
        }
        if (QLog.isColorLevel()) {
            printPerformanceData(generateStepCosts);
        }
        HippyEngineReportData reportData = ((IHippyReportCache) QRoute.api(IHippyReportCache.class)).getReportData(this.mModuleName);
        if (reportData != null) {
            ((IHippyReportCache) QRoute.api(IHippyReportCache.class)).clearReportData(this.mModuleName);
            HippyReporter.getInstance().reportHippyLoadResult(12, this.mModuleName, reportData.moduleVersion, reportData.reportResult, reportData.loadHippyCosts, reportData.updateJSCosts);
            if (QLog.isColorLevel()) {
                printPerformanceData(reportData.loadHippyCosts);
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        doOnNewIntent(intent);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mIsPageAppeared) {
            this.mDispatcher.onActivityPaused(getQBaseActivity());
            HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
            if (hippyQQPreloadEngine != null) {
                hippyQQPreloadEngine.onPause();
            }
        }
        if (HippyDebugUtil.isDebugEnable()) {
            ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).stopFPSMonitor(getActivity());
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        String currentThemeId = QQTheme.getCurrentThemeId();
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        boolean isVasTheme = QQTheme.isVasTheme();
        QLog.i(TAG, 1, "onPostThemeChanged  themeId:" + currentThemeId + " isNightModeTheme:" + isNowThemeIsNight + " isVasThem:" + isVasTheme);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("themeId", NumberUtil.stringToInt(currentThemeId));
        hippyMap.pushBoolean("isNightModeTheme", isNowThemeIsNight);
        hippyMap.pushBoolean("isVasTheme", isVasTheme);
        sendHippyNativeEvent(HippyQQConstants.EventNames.EVENT_THEME_MODE_CHANGED, hippyMap);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mIsPageAppeared) {
            this.mDispatcher.onActivityResumed(getQBaseActivity());
            HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
            if (hippyQQPreloadEngine != null) {
                hippyQQPreloadEngine.onResume();
            }
        }
        if (HippyDebugUtil.isDebugEnable()) {
            ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).startFPSMonitor(getActivity());
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mDispatcher.onActivitySaveInstanceState(getQBaseActivity(), bundle);
        this.mIsActivitySaving = true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mDispatcher.onActivityStarted(getQBaseActivity());
        this.mFlingGesture.onStart();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mDispatcher.onActivityStopped(getQBaseActivity());
        this.mFlingGesture.onStop();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    protected void preloadEngine() {
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null && !this.mOpenHippyInfo.isDisablePreloadWhenClosed) {
            TabPreloadItem.PreloadType preloadType = hippyQQPreloadEngine.getPreloadType();
            if (getParameters().getBoolean(OpenHippyInfo.EXTRA_KEY_IS_PREDRAW_WHEN_CLOSED)) {
                preloadType = TabPreloadItem.PreloadType.PRE_DRAW;
            } else if (getParameters().getBoolean(OpenHippyInfo.EXTRA_KEY_IS_PRELOAD_WHEN_CLOSED)) {
                preloadType = TabPreloadItem.PreloadType.PRE_LOAD;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "preloadEngine preloadType:" + preloadType);
            }
            if (preloadType != TabPreloadItem.PreloadType.NO_PRELOAD) {
                OpenHippyInfo openHippyInfo = new OpenHippyInfo();
                openHippyInfo.preloadTabName = getParameters().getString(OpenHippyInfo.EXTRA_KEY_PRELOAD_TAB_NAME);
                openHippyInfo.bundleName = this.mModuleName;
                openHippyInfo.preloadType = preloadType;
                openHippyInfo.processName = "local";
                openHippyInfo.isPreloadFromExitPage = true;
                openHippyInfo.from = "back";
                openHippyInfo.domain = this.mOpenHippyInfo.domain;
                openHippyInfo.framework = this.mFrameworkType;
                if (preloadType == TabPreloadItem.PreloadType.PRE_BASE) {
                    openHippyInfo.bundleName = "";
                    openHippyInfo.domain = "";
                }
                ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).preloadHippyPage(openHippyInfo);
            }
        }
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        return onBackEvent();
    }

    public void sendHippyNativeEvent(String str, Object obj) {
        try {
            if (this.mHippyQQEngine != null && obj != null && !TextUtils.isEmpty(str)) {
                ((EventDispatcher) this.mHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(str, obj);
            }
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "sendHippyNativeEvent fail:" + th5.getMessage());
        }
    }

    public void setPageAppeared(boolean z16) {
        this.mIsPageAppeared = z16;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    public boolean onBackEvent(final HippyEngine.BackPressHandler backPressHandler) {
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine == null) {
            return false;
        }
        return hippyQQPreloadEngine.doOnBackPressed(new HippyEngine.BackPressHandler() { // from class: com.tencent.hippy.qq.fragment.BaseHippyFragment.2
            @Override // com.tencent.mtt.hippy.HippyEngine.BackPressHandler
            public void handleBackPress() {
                HippyEngine.BackPressHandler backPressHandler2 = backPressHandler;
                if (backPressHandler2 != null) {
                    backPressHandler2.handleBackPress();
                }
            }
        });
    }

    protected void onLoadHippySuccess() {
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
    }

    protected void onLoadHippyError(int i3, String str) {
    }
}
