package com.tencent.hippy.qq.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.tencent.comic.api.IQQComicHippyUtil;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.IHippyReportCache;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.obj.HippyEngineReportData;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.hippy.qq.view.HippyQQViewCreator;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.crossend.api.IQQCrossEnd;
import com.tencent.mobileqq.guild.hippy.IGuildHippyApi;
import com.tencent.mobileqq.minigame.minigamecenter.api.IMiniGameCenterHippyApi;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.qcircle.api.ITVideoPublicAccountHippyApi;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qqlivehall.iv.api.hippy.IQQIvLiveHallHippyApi;
import com.tencent.mobileqq.qqnews.api.IQQNewsHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasSquareApi;
import com.tencent.mobileqq.vas.hippy.api.IVasHippyApi;
import com.tencent.mobileqq.vas.hippy.api.IZPlanParadiseHippyApi;
import com.tencent.mobileqq.vas.hippy.api.IZplanVasHippyApi;
import com.tencent.mobileqq.vashealth.api.IQQHealthHippyApi;
import com.tencent.mobileqq.weather.api.IWeatherHippyApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyFileBundleLoader;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxService;
import com.tencent.timi.game.api.ITimiGameApi;
import cooperation.vip.ad.IQQVASGuideHippyApi;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class HippyQQPreloadEngine extends HippyQQEngine {
    public static final String EVENT_JS_BUNDLE_UPDATED = "JsBundleUpdated";
    public static final String EXTRA_KEY_SWITCH_PROCESS_COST = "switchProcess";
    private static final String PRELOAD_STEP_END = "end";
    private static final String PRELOAD_STEP_INIT_ENGINE_END = "initEngineEnd";
    private static final String PRELOAD_STEP_LOAD_JS = "loadJs";
    private static final String PRELOAD_STEP_LOAD_SO_END = "loadSoEnd";
    private static final String PRELOAD_STEP_START = "start";
    private static final String PRELOAD_STEP_UPDATE_JS = "updateJs";
    public static final int STATUS_JSBUNDLE_NOT_EXISTS = -20001;
    public static final int STATUS_LOW_MEMORY = -20002;
    public static final int STATUS_PRELOAD_CANCELED = -20003;
    protected static final String TAG = "HippyQQPreloadEngine";
    private Object mCheckAndLoadLock;
    private String mCurrentPreloadStepName;
    private boolean mIsCheckUpdateFinished;
    private boolean mIsHippyLoaded;
    private boolean mIsInitEngineFinished;
    private boolean mIsPreload;
    private volatile boolean mIsPreloadCanceled;
    private boolean mIsPreloadCreating;
    private boolean mIsPreloadFinished;
    private int mPredrawHippyWidth;
    private long mPreloadEndTime;
    public String mPreloadFrom;
    protected int mPreloadModuleVersion;
    private int mPreloadSceneType;
    private long mPreloadStartTime;
    private TabPreloadItem.PreloadType mPreloadType;
    public int mReportJSBundleState;
    public int mReportPSKeyState;
    public int mReportSKeyState;
    public HashMap<String, String> mReportUpdateJSCosts;
    private long mSwitchProcessTimeCost;
    private IUpdateListener mUpdateListener;

    public HippyQQPreloadEngine(QBaseFragment qBaseFragment, Activity activity, String str, String str2) {
        super(activity, str, str2);
        this.mPreloadType = TabPreloadItem.PreloadType.NO_PRELOAD;
        this.mIsPreloadFinished = false;
        this.mPreloadModuleVersion = 0;
        this.mIsCheckUpdateFinished = false;
        this.mIsInitEngineFinished = false;
        this.mCheckAndLoadLock = new Object();
        this.mIsHippyLoaded = false;
        this.mIsPreloadCanceled = false;
        this.mReportSKeyState = 0;
        this.mReportPSKeyState = -1;
        this.mReportJSBundleState = 201;
        this.mCurrentPreloadStepName = "";
        this.mUpdateListener = new IUpdateListener() { // from class: com.tencent.hippy.qq.app.HippyQQPreloadEngine.3
            @Override // com.tencent.hippy.qq.api.IUpdateListener
            public void onUpdateFailed(int i3, int i16, String str3, String str4, HashMap<String, String> hashMap) {
                HippyQQPreloadEngine.this.onJsBundleUpdateComplete(i16, str3, hashMap);
            }

            @Override // com.tencent.hippy.qq.api.IUpdateListener
            public void onUpdateSuccess(int i3, String str3, HashMap<String, String> hashMap) {
                HippyQQPreloadEngine.this.onJsBundleUpdateComplete(0, null, hashMap);
            }
        };
        initPreloadEngine(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callBackError(int i3, String str) {
        this.mPreloadEndTime = System.currentTimeMillis();
        onLoadFail(i3, str);
        reportPreloadResult(i3, str);
        ((IHippyReportCache) QRoute.api(IHippyReportCache.class)).saveReportData(this.mModuleName, new HippyEngineReportData(this.mModuleVersion, generateResultMap(i3, str), generatePreloadStepCosts(), this.mReportUpdateJSCosts));
        if (!this.mIsHippyLoaded) {
            this.mMapLoadStepsTime.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callBackSuccess() {
        this.mCurrentPreloadStepName = "end";
        this.mPreloadEndTime = System.currentTimeMillis();
        HippyQQEngine.HippyQQEngineListener hippyQQEngineListener = this.mEngineListener;
        if (hippyQQEngineListener != null) {
            hippyQQEngineListener.onSuccess();
        }
        reportPreloadResult(0, null);
        if (!this.mIsHippyLoaded) {
            this.mMapLoadStepsTime.clear();
        }
        ((IHippyReportCache) QRoute.api(IHippyReportCache.class)).clearReportData(this.mModuleName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndLoad() {
        if (checkCanceledPreload() || !isReadyToLoadHippy()) {
            return;
        }
        this.mCurrentPreloadStepName = PRELOAD_STEP_LOAD_JS;
        if (this.mIsPreloadCreating) {
            preloadHippy();
        } else {
            loadHippy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkCanceledPreload() {
        if (this.mIsPreloadCreating && this.mIsPreloadCanceled) {
            QLog.i(TAG, 1, "Preload canceled, bundle:" + getModuleName());
            callBackError(-20003, "preload canceled");
            return true;
        }
        return false;
    }

    private HashMap<String, Object> generateResultMap(int i3, String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ret", Integer.valueOf(i3));
        hashMap.put("errMsg", str);
        hashMap.put("curLoadStep", getPreloadStep());
        hashMap.put("isPreload", Boolean.valueOf(isPreloaded()));
        hashMap.put("isPredraw", Boolean.valueOf(isPredraw()));
        hashMap.put(OpenHippyInfo.EXTRA_KEY_PRELOAD_TYPE, TabPreloadItem.preloadTypeToString(getPreloadType()));
        hashMap.put("from", this.mPreloadFrom);
        hashMap.put("skeyState", Integer.valueOf(this.mReportSKeyState));
        hashMap.put("pskeyState", Integer.valueOf(this.mReportPSKeyState));
        hashMap.put(EXTRA_KEY_SWITCH_PROCESS_COST, String.valueOf(this.mSwitchProcessTimeCost));
        hashMap.put("processName", MobileQQ.sMobileQQ.getQQProcessName());
        hashMap.put("sign", this.mPreloadFrom);
        return hashMap;
    }

    private long getValueFromStepCosts(String str, HashMap<String, Long> hashMap) {
        if (hashMap.containsKey(str)) {
            return hashMap.get(str).longValue();
        }
        return 0L;
    }

    private boolean isLowMemory() {
        ActivityManager activityManager = (ActivityManager) BaseApplication.getContext().getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    private boolean isReadyToLoadHippy() {
        QLog.i(TAG, 1, "isReadyToLoadHippy update:" + this.mIsCheckUpdateFinished + " initEngine:" + this.mIsInitEngineFinished + " updateJsType:" + getOpenHippyInfo().updateJsBundleType);
        if (this.mIsPreloadCreating) {
            if (isPreloadBase()) {
                return this.mIsInitEngineFinished;
            }
            if (this.mIsCheckUpdateFinished && this.mIsInitEngineFinished) {
                return true;
            }
            return false;
        }
        if (this.mIsCheckUpdateFinished && this.mIsInitEngineFinished) {
            return true;
        }
        int i3 = getOpenHippyInfo().updateJsBundleType;
        int moduleVersion = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(getModuleName());
        if (getOpenHippyInfo().minJsBundleVersion > 0 && moduleVersion < getOpenHippyInfo().minJsBundleVersion) {
            i3 = 0;
        }
        if (i3 != 1) {
            return false;
        }
        if (this.mIsInitEngineFinished && moduleVersion >= 0) {
            return true;
        }
        return false;
    }

    private void loadHippy() {
        synchronized (this.mCheckAndLoadLock) {
            if (this.mIsHippyLoaded) {
                QLog.i(TAG, 1, "loadHippy has loaded.");
                return;
            }
            this.mIsHippyLoaded = true;
            if (isPredraw()) {
                if (this.mHippyRootView.getParent() == null) {
                    addRootView(this.mHippyRootView);
                }
                this.mMapLoadStepsTime.put(HippyQQConstants.STEP_NAME_LOAD_MODULE_END, Long.valueOf(System.currentTimeMillis()));
                this.mModuleVersion = this.mPreloadModuleVersion;
                callBackSuccess();
                return;
            }
            loadModule();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onJsBundleUpdateComplete(int i3, String str, HashMap<String, String> hashMap) {
        this.mReportJSBundleState = i3;
        this.mReportUpdateJSCosts = hashMap;
        if (QLog.isColorLevel() || i3 != 0) {
            QLog.i(TAG, 2, "onJsBundleUpdateComplte retCode:" + i3 + " retMsg:" + str);
        }
        if (isDebugMode()) {
            return;
        }
        if (i3 == 2 && this.mIsPreloadCreating) {
            callBackError(i3, "preload not allowed");
            return;
        }
        if (HippyQQEngine.isMainThread()) {
            this.mIsCheckUpdateFinished = true;
            checkAndLoad();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.hippy.qq.app.HippyQQPreloadEngine.2
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.i(HippyQQPreloadEngine.TAG, 2, "onJsBundleUpdateComplte run");
                    }
                    HippyQQPreloadEngine.this.mIsCheckUpdateFinished = true;
                    HippyQQPreloadEngine.this.checkAndLoad();
                }
            });
        }
        if (!this.mIsPreload && this.mIsInitEngineFinished && getOpenHippyInfo().updateJsBundleType == 1) {
            if (i3 == 0 || i3 == 101) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushString("bundleName", getModuleName());
                hippyMap.pushInt("newVersion", ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(getModuleName()));
                sendEvent(EVENT_JS_BUNDLE_UPDATED, hippyMap);
            }
        }
    }

    private void precreateHippy(HippyQQEngine.HippyQQEngineListener hippyQQEngineListener, TabPreloadItem.PreloadType preloadType, boolean z16, int i3) {
        this.mPreloadType = preloadType;
        this.mIsPreload = true;
        this.mIsPreloadCreating = true;
        this.mPreloadSceneType = i3;
        this.mPreloadStartTime = System.currentTimeMillis();
        this.mEngineListener = hippyQQEngineListener;
        this.mCurrentPreloadStepName = "start";
        if (isLowMemory()) {
            String str = "Can't preload " + getModuleName() + ", because system is in low memory, type:" + preloadType;
            callBackError(-20002, str);
            QLog.e(TAG, 1, str);
            return;
        }
        ((IHippyLibrary) QRoute.api(IHippyLibrary.class)).loadLibraryIfNeed(this);
        if (!isPreloadBase()) {
            updateJsBundle(z16);
        }
    }

    private void predrawModule(String str) {
        String str2;
        QLog.d(HippyQQConstants.HIPPY_TAG, 1, "predrawModule start:" + getModuleName() + " this:" + this);
        HippyEngine.ModuleLoadParams moduleLoadParams = new HippyEngine.ModuleLoadParams();
        moduleLoadParams.context = MobileQQ.sMobileQQ.getApplicationContext();
        if (TextUtils.isEmpty(this.componentName)) {
            str2 = getModuleName();
        } else {
            str2 = this.componentName;
        }
        moduleLoadParams.componentName = str2;
        moduleLoadParams.jsFilePath = str;
        moduleLoadParams.nativeParams = getNativeParams();
        moduleLoadParams.jsParams = getJsParamsMap(moduleLoadParams);
        this.mModuleVersion = this.mPreloadModuleVersion;
        this.mHippyRootView = getHippyEngine().loadModule(moduleLoadParams, new HippyEngine.ModuleListener() { // from class: com.tencent.hippy.qq.app.HippyQQPreloadEngine.1
            @Override // com.tencent.mtt.hippy.HippyEngine.ModuleListener
            public boolean onJsException(HippyJsException hippyJsException) {
                QLog.e(HippyQQConstants.HIPPY_TAG, 1, "predrawModule exception:" + hippyJsException);
                HippyReporter hippyReporter = HippyReporter.getInstance();
                String moduleName = HippyQQPreloadEngine.this.getModuleName();
                HippyQQPreloadEngine hippyQQPreloadEngine = HippyQQPreloadEngine.this;
                hippyReporter.reportException(moduleName, hippyQQPreloadEngine.mModuleVersion, 4, hippyJsException, hippyQQPreloadEngine.generateReportExtraParams());
                return true;
            }

            @Override // com.tencent.mtt.hippy.HippyEngine.ModuleListener
            public void onLoadCompleted(HippyEngine.ModuleLoadStatus moduleLoadStatus, String str3, HippyRootView hippyRootView) {
                QLog.d(HippyQQConstants.HIPPY_TAG, 1, "Hippy: predrawModule statusCode:" + moduleLoadStatus);
                if (!HippyQQPreloadEngine.this.checkCanceledPreload()) {
                    HippyQQPreloadEngine.this.mIsPreloadCreating = false;
                    if ((moduleLoadStatus != HippyEngine.ModuleLoadStatus.STATUS_OK && moduleLoadStatus != HippyEngine.ModuleLoadStatus.STATUS_REPEAT_LOAD) || hippyRootView == null) {
                        HippyQQPreloadEngine.this.callBackError(moduleLoadStatus.value(), str3);
                        return;
                    }
                    HippyQQPreloadEngine hippyQQPreloadEngine = HippyQQPreloadEngine.this;
                    hippyQQPreloadEngine.mIsPageLoaded = true;
                    hippyQQPreloadEngine.mHippyRootView = hippyRootView;
                    hippyQQPreloadEngine.callBackSuccess();
                }
            }
        });
    }

    private void preloadHippy() {
        synchronized (this.mCheckAndLoadLock) {
            if (this.mIsPreloadFinished) {
                QLog.i(TAG, 1, "preloadHippy has preloaded.");
                return;
            }
            this.mIsPreloadFinished = true;
            if (isPreloadBase()) {
                this.mIsPreloadCreating = false;
                callBackSuccess();
                return;
            }
            int moduleVersion = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(getModuleName());
            if (moduleVersion != -1) {
                File moduleIndex = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleIndex(getModuleName(), moduleVersion);
                if (moduleIndex != null && moduleIndex.exists()) {
                    this.mPreloadModuleVersion = moduleVersion;
                    this.mMapLoadStepsTime.put(HippyQQConstants.STEP_NAME_LOAD_MODULE_START, Long.valueOf(System.currentTimeMillis()));
                    if (this.mPreloadType == TabPreloadItem.PreloadType.PRE_DRAW) {
                        predrawModule(moduleIndex.getAbsolutePath());
                        return;
                    } else {
                        preloadModule(moduleIndex.getAbsolutePath());
                        return;
                    }
                }
                ((IHippySetting) QRoute.api(IHippySetting.class)).setModuleVersion(getModuleName(), 0);
            }
            callBackError(-20001, "js bundle not exists");
        }
    }

    private void preloadModule(String str) {
        QLog.d(HippyQQConstants.HIPPY_TAG, 1, "preloadModule start:" + getModuleName() + " this:" + this);
        getHippyEngine().preloadModule(new HippyFileBundleLoader(str, true, getModuleName()));
        if (checkCanceledPreload()) {
            return;
        }
        this.mIsPreloadCreating = false;
        callBackSuccess();
    }

    private final void reportPreloadResult(int i3, String str) {
        HashMap<String, Long> generatePreloadStepCosts = generatePreloadStepCosts();
        HippyReporter.getInstance().reportHippyLoadResult(10, getModuleName(), getPreloadModuleVersion(), generateResultMap(i3, str), generatePreloadStepCosts, this.mReportUpdateJSCosts);
    }

    private void savePredrawHippyWidth() {
        DisplayMetrics displayMetrics = HippyUtils.getDisplayMetrics();
        if (displayMetrics != null) {
            this.mPredrawHippyWidth = displayMetrics.widthPixels;
        }
    }

    private void setApiProviders(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HippyUtils.addGameCenterApiProvider(this.providers);
        IQQComicHippyUtil iQQComicHippyUtil = (IQQComicHippyUtil) QRoute.api(IQQComicHippyUtil.class);
        if (iQQComicHippyUtil.isBoodoModule(str)) {
            this.providers.add(iQQComicHippyUtil.createHippyAPIProvider());
        }
        IVasHippyApi iVasHippyApi = (IVasHippyApi) QRoute.api(IVasHippyApi.class);
        if (iVasHippyApi.isVasModuleNeedToBeAdd(str)) {
            this.providers.add(iVasHippyApi.createHippyAPIProvider());
        }
        IMiniGamePublicAccountApi iMiniGamePublicAccountApi = (IMiniGamePublicAccountApi) QRoute.api(IMiniGamePublicAccountApi.class);
        if (iMiniGamePublicAccountApi.isMiniGamePAModule(str)) {
            this.providers.add(iMiniGamePublicAccountApi.createHippyProvider());
        }
        IQQGameHippyApi iQQGameHippyApi = (IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class);
        this.providers.add(iQQGameHippyApi.getQQGameHippyAPIProvider(str));
        IWeatherHippyApi iWeatherHippyApi = (IWeatherHippyApi) QRoute.api(IWeatherHippyApi.class);
        if (iWeatherHippyApi.isWeatherModule(str)) {
            this.providers.add(iWeatherHippyApi.createHippyProvider());
        }
        IQQHealthHippyApi iQQHealthHippyApi = (IQQHealthHippyApi) QRoute.api(IQQHealthHippyApi.class);
        if (iQQHealthHippyApi.isHealthModule(str)) {
            this.providers.add(iQQHealthHippyApi.createHippyProvider());
        }
        IQQIvLiveHallHippyApi iQQIvLiveHallHippyApi = (IQQIvLiveHallHippyApi) QRoute.api(IQQIvLiveHallHippyApi.class);
        if (iQQIvLiveHallHippyApi.isQQIvLiveHallModule(str)) {
            this.providers.add(iQQIvLiveHallHippyApi.getQQIvLiveHallHippyAPIProvider());
        }
        ITimiGameApi iTimiGameApi = (ITimiGameApi) QRoute.api(ITimiGameApi.class);
        if (iTimiGameApi.isTimiModule(str)) {
            this.providers.add(iTimiGameApi.getTimiApiProvider());
        }
        IGuildHippyApi iGuildHippyApi = (IGuildHippyApi) QRoute.api(IGuildHippyApi.class);
        if (iGuildHippyApi.isGuildModule(str)) {
            this.providers.add(iGuildHippyApi.getGuildHippyApiProvider());
        }
        IMiniGameCenterHippyApi iMiniGameCenterHippyApi = (IMiniGameCenterHippyApi) QRoute.api(IMiniGameCenterHippyApi.class);
        if (iMiniGameCenterHippyApi.isMiniGameCenterModule(str) || iQQGameHippyApi.isGameCenterBundle(str)) {
            this.providers.add(iMiniGameCenterHippyApi.createHippyProvider());
        }
        IMiniBoxService iMiniBoxService = (IMiniBoxService) QRoute.api(IMiniBoxService.class);
        if (iMiniBoxService.isMiniBoxHippyModule(str)) {
            this.providers.add(iMiniBoxService.getHippyModuleProvider());
        }
        IZplanVasHippyApi iZplanVasHippyApi = (IZplanVasHippyApi) QRoute.api(IZplanVasHippyApi.class);
        if (iZplanVasHippyApi.isVasZplanSmallHomeModule(str) || ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).isSquareHippyModule(str)) {
            this.providers.add(iZplanVasHippyApi.getVasZplanHippyAPIProvider());
        }
        IQQVASGuideHippyApi iQQVASGuideHippyApi = (IQQVASGuideHippyApi) QRoute.api(IQQVASGuideHippyApi.class);
        if (iQQVASGuideHippyApi.isVASGuideModule(str)) {
            this.providers.add(iQQVASGuideHippyApi.getQQIvLiveHallHippyAPIProvider());
        }
        IQQNewsHippyApi iQQNewsHippyApi = (IQQNewsHippyApi) QRoute.api(IQQNewsHippyApi.class);
        if (iQQNewsHippyApi.isQQNewsModule(str)) {
            this.providers.add(iQQNewsHippyApi.createHippyProvider());
        }
        IZPlanParadiseHippyApi iZPlanParadiseHippyApi = (IZPlanParadiseHippyApi) QRoute.api(IZPlanParadiseHippyApi.class);
        if (iZPlanParadiseHippyApi.isZplanParadiseModule(str)) {
            this.providers.add(iZPlanParadiseHippyApi.getHippyAPIProvider());
        }
        ITVideoPublicAccountHippyApi iTVideoPublicAccountHippyApi = (ITVideoPublicAccountHippyApi) QRoute.api(ITVideoPublicAccountHippyApi.class);
        if (iTVideoPublicAccountHippyApi.isTVideoPublicAccountModule(str)) {
            this.providers.add(iTVideoPublicAccountHippyApi.createHippyProvider());
        }
        this.providers.add(((IQQCrossEnd) QRoute.api(IQQCrossEnd.class)).getQQCrossHippyAPIProvider());
    }

    public void cancelPreload() {
        this.mIsPreloadCanceled = true;
    }

    public void checkLoginState(JSONObject jSONObject, boolean z16) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("skey");
        String optString2 = jSONObject.optString("p_skey");
        this.mReportSKeyState = !TextUtils.isEmpty(optString) ? 1 : 0;
        if (!z16 && optString2 == null) {
            this.mReportPSKeyState = -1;
        } else {
            this.mReportPSKeyState = !TextUtils.isEmpty(optString2) ? 1 : 0;
        }
    }

    public void computeSwitchProcessTimeCost(long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (j3 > 0 && j3 < currentTimeMillis) {
            this.mSwitchProcessTimeCost = currentTimeMillis - j3;
        }
    }

    @Override // com.tencent.hippy.qq.app.HippyQQEngine
    protected void destroyEngine() {
        super.destroyEngine();
        ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).removeJsBundleUpdateListener(getModuleName(), this.mUpdateListener);
    }

    protected HashMap<String, Long> generatePreloadStepCosts() {
        long j3 = this.mPreloadStartTime;
        long valueFromStepCosts = getValueFromStepCosts(HippyQQConstants.STEP_NAME_LOAD_LIBRARY_END, this.mMapLoadStepsTime);
        long valueFromStepCosts2 = getValueFromStepCosts("initEngineEnd", this.mMapLoadStepsTime);
        long valueFromStepCosts3 = getValueFromStepCosts(HippyQQConstants.STEP_NAME_LOAD_MODULE_START, this.mMapLoadStepsTime);
        long j16 = this.mPreloadEndTime;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (valueFromStepCosts > 0 && j3 > 0) {
            linkedHashMap.put("loadLibrary", Long.valueOf(valueFromStepCosts - j3));
        }
        if (valueFromStepCosts2 > 0 && valueFromStepCosts > 0) {
            linkedHashMap.put("initEngine", Long.valueOf(valueFromStepCosts2 - valueFromStepCosts));
        }
        if (valueFromStepCosts3 > 0 && valueFromStepCosts2 > 0) {
            linkedHashMap.put("checkJsBundle", Long.valueOf(valueFromStepCosts3 - valueFromStepCosts2));
        }
        if (j16 > 0 && valueFromStepCosts3 > 0) {
            linkedHashMap.put("loadJsBundle", Long.valueOf(j16 - valueFromStepCosts3));
        }
        if (j16 > 0) {
            long j17 = this.mPreloadStartTime;
            if (j17 > 0) {
                linkedHashMap.put("total", Long.valueOf(j16 - j17));
            }
        }
        return linkedHashMap;
    }

    public HippyRootView getPredrawHippyRootView() {
        if (isPredraw()) {
            return this.mHippyRootView;
        }
        return null;
    }

    public int getPredrawHippyWidth() {
        return this.mPredrawHippyWidth;
    }

    public int getPreloadModuleVersion() {
        return this.mPreloadModuleVersion;
    }

    public String getPreloadStep() {
        return this.mCurrentPreloadStepName;
    }

    public TabPreloadItem.PreloadType getPreloadType() {
        return this.mPreloadType;
    }

    @Override // com.tencent.hippy.qq.app.HippyQQEngine
    protected void initHippyEngine() {
        boolean isCanInitHippyEngine = isCanInitHippyEngine();
        QLog.i(TAG, 1, "initHippyEngine isCanInitHippyEngine:" + isCanInitHippyEngine);
        if (!isCanInitHippyEngine) {
            return;
        }
        String coreJsFilePath = ((IHippyLibrary) QRoute.api(IHippyLibrary.class)).getCoreJsFilePath(getCoreJsFileName());
        if (!Boolean.valueOf(((IHippyLibrary) QRoute.api(IHippyLibrary.class)).isUseDebugSo()).booleanValue() && TextUtils.isEmpty(coreJsFilePath)) {
            QLog.e(TAG, 1, "initHippyEngine corejs empty");
        } else {
            super.initHippyEngine();
        }
    }

    @Override // com.tencent.hippy.qq.app.HippyQQEngine
    public void initHippyInContainer(@NonNull ViewGroup viewGroup, @NonNull JSONObject jSONObject, boolean z16, HippyQQEngine.HippyQQEngineListener hippyQQEngineListener) {
        super.initHippyInContainer(viewGroup, jSONObject, z16, hippyQQEngineListener);
        updateJsBundle(false);
    }

    protected void initPreloadEngine(String str) {
        setViewCreator(new HippyQQViewCreator(str));
        setApiProviders(str);
    }

    @Override // com.tencent.hippy.qq.app.HippyQQEngine
    protected boolean isCanCheckPackageUpdate() {
        return false;
    }

    @Override // com.tencent.hippy.qq.app.HippyQQEngine
    protected boolean isCanInitHippyEngine() {
        if (this.mIsPreloadCreating) {
            return true;
        }
        return super.isCanInitHippyEngine();
    }

    public boolean isNeedShowLoading() {
        if (isPreloaded()) {
            return false;
        }
        if (isReady() && !((IHippyUpdate) QRoute.api(IHippyUpdate.class)).checkUpdateJsBundleInterval(getModuleName())) {
            return false;
        }
        return true;
    }

    public boolean isPredraw() {
        if (this.mIsPreload && this.mPreloadType == TabPreloadItem.PreloadType.PRE_DRAW) {
            return true;
        }
        return false;
    }

    public boolean isPreloadBase() {
        if (this.mIsPreload && this.mPreloadType == TabPreloadItem.PreloadType.PRE_BASE) {
            return true;
        }
        return false;
    }

    public boolean isPreloaded() {
        return this.mIsPreload;
    }

    @Override // com.tencent.hippy.qq.app.HippyQQEngine
    protected void loadModule() {
        File moduleIndex;
        if (this.mIsPreload && !this.mIsPreloadCreating) {
            if (isPreloadBase()) {
                super.loadModule();
                return;
            } else {
                if (this.mPreloadModuleVersion > 0 && (moduleIndex = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleIndex(getModuleName(), this.mPreloadModuleVersion)) != null && moduleIndex.exists()) {
                    this.mModuleVersion = this.mPreloadModuleVersion;
                    loadModule(moduleIndex.getAbsolutePath());
                    return;
                }
                return;
            }
        }
        super.loadModule();
    }

    @Override // com.tencent.hippy.qq.app.HippyQQEngine
    protected void onInitEngineComplete(HippyEngine.EngineInitStatus engineInitStatus, String str) {
        QLog.i(TAG, 1, "onInitEngineComplete statusCode:" + engineInitStatus);
        this.mIsInitEngineFinished = true;
        this.mCurrentPreloadStepName = "initEngineEnd";
        if (QLog.isColorLevel() || engineInitStatus != HippyEngine.EngineInitStatus.STATUS_OK) {
            QLog.d(HippyQQConstants.HIPPY_TAG, 1, "Hippy: initEngine statusCode=" + engineInitStatus + ", msg=" + str);
        }
        if (engineInitStatus != HippyEngine.EngineInitStatus.STATUS_OK) {
            callBackError(engineInitStatus.value(), str);
        } else if (isDebugMode()) {
            loadModule(HippyQQConstants.MAIN_BUNDLE_NAME);
        } else {
            checkAndLoad();
        }
    }

    @Override // com.tencent.hippy.qq.app.HippyQQEngine, com.tencent.hippy.qq.api.LibraryLoadListener
    public void onLoadSuccess() {
        QLog.i(TAG, 1, "onLoadSuccess mIsPreload:" + this.mIsPreload + " mIsPreloadCreating:" + this.mIsPreloadCreating);
        this.mCurrentPreloadStepName = PRELOAD_STEP_LOAD_SO_END;
        if (this.mIsPreload && !this.mIsPreloadCreating) {
            checkAndLoad();
            return;
        }
        if (this.mIsPreloadCreating && this.mPreloadType == TabPreloadItem.PreloadType.PRE_DRAW) {
            savePredrawHippyWidth();
        }
        super.onLoadSuccess();
    }

    @Override // com.tencent.hippy.qq.app.HippyQQEngine
    public void onResume() {
        super.onResume();
    }

    public void predrawHippy(HippyQQEngine.HippyQQEngineListener hippyQQEngineListener, boolean z16, int i3) {
        precreateHippy(hippyQQEngineListener, TabPreloadItem.PreloadType.PRE_DRAW, z16, i3);
    }

    public void preloadBaseHippy(HippyQQEngine.HippyQQEngineListener hippyQQEngineListener, String str, int i3) {
        setJsBundleType(str);
        precreateHippy(hippyQQEngineListener, TabPreloadItem.PreloadType.PRE_BASE, false, i3);
    }

    public void resetApiProviders(String str) {
        setViewCreator(new HippyQQViewCreator(str));
        setApiProviders(str);
        if (getHippyEngine() != null) {
            getHippyEngine().getEngineContext().addApiProviders(this.providers);
        }
    }

    @Override // com.tencent.hippy.qq.app.HippyQQEngine
    public void setFragment(QBaseFragment qBaseFragment) {
        this.mFragment = qBaseFragment;
    }

    public void setModuleName(String str) {
        this.mModuleName = str;
    }

    public void setPreloadFrom(String str) {
        this.mPreloadFrom = str;
    }

    public void setSwitchProcessTimeCost(long j3) {
        this.mSwitchProcessTimeCost = j3;
    }

    protected void updateJsBundle(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "updateJsBundleBySSO moduleName:" + getModuleName());
        }
        if (!this.mIsCheckUpdateFinished && !TextUtils.isEmpty(getModuleName())) {
            this.mCurrentPreloadStepName = PRELOAD_STEP_UPDATE_JS;
            Bundle bundle = new Bundle();
            bundle.putBoolean(IHippyUpdate.EXTRA_KEY_IS_CHECK_PRELOAD, z16);
            bundle.putInt(IHippyUpdate.EXTRA_KEY_PRELOAD_SCENE_TYPE, this.mPreloadSceneType);
            bundle.putString("reportFrom", this.mPreloadFrom);
            bundle.putInt(OpenHippyInfo.EXTRA_KEY_MIN_JS_BUNDLE_VERSION, getOpenHippyInfo().minJsBundleVersion);
            bundle.putBoolean(IHippyUpdate.EXTRA_KEY_IS_CONTROL_FLOW, false);
            ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).updateJsBundle(getModuleName(), ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isUpdateHippyJsBundleByHttp(), 4, bundle, this.mUpdateListener);
        }
    }

    public HippyQQPreloadEngine(QBaseFragment qBaseFragment, String str, String str2) {
        super(qBaseFragment, str, str2);
        this.mPreloadType = TabPreloadItem.PreloadType.NO_PRELOAD;
        this.mIsPreloadFinished = false;
        this.mPreloadModuleVersion = 0;
        this.mIsCheckUpdateFinished = false;
        this.mIsInitEngineFinished = false;
        this.mCheckAndLoadLock = new Object();
        this.mIsHippyLoaded = false;
        this.mIsPreloadCanceled = false;
        this.mReportSKeyState = 0;
        this.mReportPSKeyState = -1;
        this.mReportJSBundleState = 201;
        this.mCurrentPreloadStepName = "";
        this.mUpdateListener = new IUpdateListener() { // from class: com.tencent.hippy.qq.app.HippyQQPreloadEngine.3
            @Override // com.tencent.hippy.qq.api.IUpdateListener
            public void onUpdateFailed(int i3, int i16, String str3, String str4, HashMap<String, String> hashMap) {
                HippyQQPreloadEngine.this.onJsBundleUpdateComplete(i16, str3, hashMap);
            }

            @Override // com.tencent.hippy.qq.api.IUpdateListener
            public void onUpdateSuccess(int i3, String str3, HashMap<String, String> hashMap) {
                HippyQQPreloadEngine.this.onJsBundleUpdateComplete(0, null, hashMap);
            }
        };
        initPreloadEngine(str);
    }

    public void preloadHippy(HippyQQEngine.HippyQQEngineListener hippyQQEngineListener, boolean z16, int i3) {
        precreateHippy(hippyQQEngineListener, TabPreloadItem.PreloadType.PRE_LOAD, z16, i3);
    }
}
