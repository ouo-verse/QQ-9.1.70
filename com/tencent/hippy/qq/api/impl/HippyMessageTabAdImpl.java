package com.tencent.hippy.qq.api.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.hippy.qq.api.BaseMessageTabAdData;
import com.tencent.hippy.qq.api.HippyMessageTabAdData;
import com.tencent.hippy.qq.api.HippyPreloadListener;
import com.tencent.hippy.qq.api.IHippyMessageTabAd;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.api.KuiklyMessageTabAdData;
import com.tencent.hippy.qq.api.LibraryLoadListener;
import com.tencent.hippy.qq.api.MMKVCommonFileKeys;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.api.impl.HippyMessageTabAdImpl;
import com.tencent.hippy.qq.messagetabad.MessageTabAdFragment;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.ResError;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.statemachine.MainStateManager;
import com.tencent.statemachine.api.IStateManager;
import com.tencent.statemachine.api.MainState;
import com.tencent.statemachine.api.StateObserver;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public class HippyMessageTabAdImpl implements IHippyMessageTabAd {
    private static final String FROM = "MessageTagAd";
    private static final int MESSAGE_TAG_SHOW = 1;
    private static final int PAGE_TYPE_HIPPY = 1;
    private static final int PAGE_TYPE_KUIKLY = 2;
    private static final int SEND_MESSAGE_DELAY_IN_MILLISECOND = 1000;
    private static final String TAG = "HippyMessageTabAdImpl";
    private static final String TIANSHU_REPORT_CUSTOM_AD_ID = "tianshu.31";
    private static BaseMessageTabAdData curAdData = null;
    private static volatile boolean isAdPreloaded = false;
    private static Object lock = new Object();
    private static Handler uiHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.hippy.qq.api.impl.g
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean lambda$static$0;
            lambda$static$0 = HippyMessageTabAdImpl.lambda$static$0(message);
            return lambda$static$0;
        }
    });
    private static StateObserver mMainTabStateObserver = new StateObserver() { // from class: com.tencent.hippy.qq.api.impl.h
        @Override // com.tencent.statemachine.api.StateObserver
        public final void onStateChanged(String str, String str2) {
            HippyMessageTabAdImpl.lambda$static$2(str, str2);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.hippy.qq.api.impl.HippyMessageTabAdImpl$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass1 implements HippyPreloadListener {
        final /* synthetic */ HippyMessageTabAdData val$adData;

        AnonymousClass1(HippyMessageTabAdData hippyMessageTabAdData) {
            this.val$adData = hippyMessageTabAdData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0(HippyMessageTabAdData hippyMessageTabAdData, int i3, List list) {
            QLog.i(HippyMessageTabAdImpl.TAG, 1, "preloadResource success view added adId:" + hippyMessageTabAdData.adId);
            HippyMessageTabAdImpl.this.onPreloadSuccess(hippyMessageTabAdData);
            HippyMessageTabAdImpl.setAdBoolValue(hippyMessageTabAdData.adId, MMKVCommonFileKeys.IS_MESSAGE_TAB_AD_PRELOADED_PREFIX, true);
        }

        private void onSuccess(HippyRootView hippyRootView) {
            if (hippyRootView != null && hippyRootView.getChildCount() <= 0) {
                QLog.i(HippyMessageTabAdImpl.TAG, 1, "preloadResource success wait for adding view adId:" + this.val$adData.adId);
                final HippyMessageTabAdData hippyMessageTabAdData = this.val$adData;
                hippyRootView.setOnLoadCompleteListener(new HippyRootView.OnLoadCompleteListener() { // from class: com.tencent.hippy.qq.api.impl.i
                    @Override // com.tencent.mtt.hippy.HippyRootView.OnLoadCompleteListener
                    public final void onLoadComplete(int i3, List list) {
                        HippyMessageTabAdImpl.AnonymousClass1.this.lambda$onSuccess$0(hippyMessageTabAdData, i3, list);
                    }
                });
                return;
            }
            QLog.i(HippyMessageTabAdImpl.TAG, 1, "preloadResource success id:" + this.val$adData.adId);
            HippyMessageTabAdImpl.this.onPreloadSuccess(this.val$adData);
            HippyMessageTabAdImpl.setAdBoolValue(this.val$adData.adId, MMKVCommonFileKeys.IS_MESSAGE_TAB_AD_PRELOADED_PREFIX, true);
        }

        @Override // com.tencent.hippy.qq.api.HippyPreloadListener
        public void onFinish(int i3, String str, HippyRootView hippyRootView) {
            if (i3 != 0) {
                if (i3 != 3) {
                    HippyMessageTabAdImpl.this.onPreloadFailed(this.val$adData);
                    return;
                }
                return;
            }
            onSuccess(hippyRootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkJsBundle(HippyMessageTabAdData hippyMessageTabAdData) {
        int moduleVersion = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(hippyMessageTabAdData.openHippyInfo.bundleName);
        if (moduleVersion > 0 && moduleVersion > hippyMessageTabAdData.openHippyInfo.minJsBundleVersion) {
            return true;
        }
        return false;
    }

    private static OpenHippyInfo createOpenHippyInfo(HippyMessageTabAdData hippyMessageTabAdData) {
        OpenHippyInfo openHippyInfo = hippyMessageTabAdData.openHippyInfo;
        OpenHippyInfo openHippyInfo2 = new OpenHippyInfo();
        openHippyInfo2.bundleName = openHippyInfo.bundleName;
        openHippyInfo2.domain = openHippyInfo.domain;
        openHippyInfo2.framework = openHippyInfo.framework;
        openHippyInfo2.url = openHippyInfo.url;
        openHippyInfo2.ssrBundleUrl = openHippyInfo.ssrBundleUrl;
        openHippyInfo2.minJsBundleVersion = openHippyInfo.minJsBundleVersion;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("adId", String.valueOf(hippyMessageTabAdData.adId));
        hashMap.put("extendJson", hippyMessageTabAdData.extendJson);
        SerializableMap serializableMap = new SerializableMap();
        openHippyInfo2.mExtraMap = serializableMap;
        serializableMap.wrapMap(hashMap);
        return openHippyInfo2;
    }

    private static boolean getAdBoolValue(int i3, String str) {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(getMMKVKey(i3, str), false);
    }

    private static String getMMKVKey(int i3, String str) {
        return str + HippyAccessHelper.getCurrentUin() + "_" + i3;
    }

    private static boolean isAdShowedToday(int i3) {
        if (System.currentTimeMillis() / 86400000 == QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong(getMMKVKey(i3, MMKVCommonFileKeys.MESSAGE_TAB_AD_SHOW_TIME_PREFIX), 0L)) {
            return true;
        }
        return false;
    }

    private static boolean isMessageTabResumed() {
        return MainState.MAIN_STATE_MESSAGE_TAB_SHOW.equals(MainStateManager.getInstance().getCurrentState());
    }

    private static boolean isSupportKuikly() {
        if (((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAME_CENTER_TAB_AD_FLOAT_CONFIG).optInt("isSupportKuikly", 1) == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$preDownloadKuikly$1(KuiklyMessageTabAdData kuiklyMessageTabAdData, ResError resError) {
        QLog.i(TAG, 2, "[preDownloadKuikly] code:" + resError.getCode());
        if (resError.getCode() == 0) {
            onPreloadSuccess(kuiklyMessageTabAdData);
            return null;
        }
        if (resError.getCode() != 1) {
            resetPreloadData();
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(Message message) {
        if (message.what == 1) {
            onMessageTabShow();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$2(String str, String str2) {
        if (MainState.MAIN_STATE_MESSAGE_TAB_SHOW.equals(str)) {
            uiHandler.removeMessages(1);
            uiHandler.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    private void lightPreloadResource(final HippyMessageTabAdData hippyMessageTabAdData) {
        QLog.i(TAG, 1, "lightPreloadResource adId:" + hippyMessageTabAdData.adId);
        ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle(hippyMessageTabAdData.openHippyInfo.bundleName, FROM, new IUpdateListener() { // from class: com.tencent.hippy.qq.api.impl.HippyMessageTabAdImpl.2
            @Override // com.tencent.hippy.qq.api.IUpdateListener
            public void onUpdateFailed(int i3, int i16, String str, String str2, HashMap<String, String> hashMap) {
                QLog.e(HippyMessageTabAdImpl.TAG, 1, "lightPreloadResource onLoadFail:", Integer.valueOf(i16));
                if (HippyMessageTabAdImpl.this.checkJsBundle(hippyMessageTabAdData)) {
                    HippyMessageTabAdImpl.this.loadHippyLibrary(hippyMessageTabAdData);
                } else {
                    HippyMessageTabAdImpl.resetPreloadData();
                }
            }

            @Override // com.tencent.hippy.qq.api.IUpdateListener
            public void onUpdateSuccess(int i3, String str, HashMap<String, String> hashMap) {
                QLog.i(HippyMessageTabAdImpl.TAG, 1, "lightPreloadResource onUpdateSuccess adId:" + hippyMessageTabAdData.adId);
                HippyMessageTabAdImpl.this.loadHippyLibrary(hippyMessageTabAdData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadHippyLibrary(final HippyMessageTabAdData hippyMessageTabAdData) {
        QLog.i(TAG, 1, "loadHippyLibrary adId:" + hippyMessageTabAdData.adId);
        HippyQQLibraryManager.getInstance().loadLibraryIfNeed(new LibraryLoadListener() { // from class: com.tencent.hippy.qq.api.impl.HippyMessageTabAdImpl.3
            @Override // com.tencent.hippy.qq.api.LibraryLoadListener
            public void onLoadFail(int i3, String str) {
                QLog.e(HippyMessageTabAdImpl.TAG, 1, "loadHippyLibrary onLoadFail:", Integer.valueOf(i3));
                HippyMessageTabAdImpl.resetPreloadData();
            }

            @Override // com.tencent.hippy.qq.api.LibraryLoadListener
            public void onLoadSuccess() {
                QLog.e(HippyMessageTabAdImpl.TAG, 1, "loadHippyLibrary onLoadSuccess");
                HippyMessageTabAdImpl.this.onPreloadSuccess(hippyMessageTabAdData);
            }
        });
    }

    private static void onMessageTabShow() {
        BaseMessageTabAdData baseMessageTabAdData;
        if (!isMessageTabResumed()) {
            return;
        }
        synchronized (lock) {
            if (curAdData != null && isAdPreloaded) {
                baseMessageTabAdData = curAdData;
            } else {
                baseMessageTabAdData = null;
            }
        }
        if (baseMessageTabAdData != null) {
            openHippyOrKuikly(baseMessageTabAdData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPreloadFailed(HippyMessageTabAdData hippyMessageTabAdData) {
        QLog.i(TAG, 1, "onPreDrawFailed adId:" + hippyMessageTabAdData.adId);
        lightPreloadResource(hippyMessageTabAdData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPreloadSuccess(BaseMessageTabAdData baseMessageTabAdData) {
        boolean isMessageTabResumed = isMessageTabResumed();
        QLog.i(TAG, 1, "onPreloadSuccess adId:" + baseMessageTabAdData.adId + " isMessageTabResumed:" + isMessageTabResumed);
        if (isMessageTabResumed) {
            openHippyOrKuikly(baseMessageTabAdData);
        } else {
            isAdPreloaded = true;
        }
    }

    private static void openHippyOrKuikly(BaseMessageTabAdData baseMessageTabAdData) {
        int i3;
        boolean z16 = baseMessageTabAdData instanceof HippyMessageTabAdData;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        if (((ITianshuManager) QRoute.api(ITianshuManager.class)).isBizExecuted(1)) {
            QLog.e(TAG, 1, "can't open adID:" + baseMessageTabAdData.adId + ", because bizSplash is showing.");
            reportTianshuAnd87(baseMessageTabAdData.adId, 213, 1, baseMessageTabAdData.adTraceInfo, i3);
            return;
        }
        if (z16) {
            OpenHippyInfo createOpenHippyInfo = createOpenHippyInfo((HippyMessageTabAdData) baseMessageTabAdData);
            createOpenHippyInfo.from = FROM;
            createOpenHippyInfo.fragmentClass = MessageTabAdFragment.class;
            createOpenHippyInfo.updateJsBundleType = 1;
            createOpenHippyInfo.isDisablePreloadWhenClosed = true;
            createOpenHippyInfo.isAnimated = false;
            createOpenHippyInfo.isTransparent = true;
            createOpenHippyInfo.openHippy(BaseApplication.getContext());
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[openHippyOrKuikly] hippy");
            }
        } else if (baseMessageTabAdData instanceof KuiklyMessageTabAdData) {
            ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).launchKuiklyPage(BaseApplication.getContext(), ((KuiklyMessageTabAdData) baseMessageTabAdData).openKuiklyInfo);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[openHippyOrKuikly] kuikly");
            }
        }
        resetPreloadData();
        ((IStateManager) QRoute.api(IStateManager.class)).removeMainStateObserver(mMainTabStateObserver);
        setAdShowTime(baseMessageTabAdData.adId);
        reportTianshuAnd87(baseMessageTabAdData.adId, 101, 1, baseMessageTabAdData.adTraceInfo, i3);
        QLog.e(TAG, 1, "open success adID:" + baseMessageTabAdData.adId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private BaseMessageTabAdData parseAdDataFromTianShu(TianShuAccess.AdItem adItem) {
        if (adItem == null || adItem.argList.get() == null || adItem.argList.get().size() == 0) {
            return null;
        }
        TabPreloadItem.PreloadType preloadType = TabPreloadItem.PreloadType.NO_PRELOAD;
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        String str = null;
        String str2 = null;
        for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
            String str3 = mapEntry.key.get();
            String str4 = mapEntry.value.get();
            if ("bundleName".equals(str3)) {
                openHippyInfo.bundleName = str4;
            } else if ("domain".equals(str3)) {
                openHippyInfo.domain = str4;
            } else if ("framework".equals(str3)) {
                openHippyInfo.framework = str4;
            } else if ("url".equals(str3)) {
                openHippyInfo.url = str4;
            } else if ("ssrBundleUrl".equals(str3)) {
                openHippyInfo.ssrBundleUrl = str4;
            } else if (OpenHippyInfo.EXTRA_KEY_MIN_JS_BUNDLE_VERSION.equals(str3)) {
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        openHippyInfo.minJsBundleVersion = Integer.parseInt(str4);
                    } catch (NumberFormatException e16) {
                        QLog.e(TAG, 1, "parseAdDataFromTianShu e:", e16);
                    }
                }
            } else if ("bid".equals(str3)) {
                str2 = str4;
            } else if ("extendJson".equals(str3)) {
                str = str4;
            } else if (OpenHippyInfo.EXTRA_KEY_PRELOAD_TYPE.equals(str3)) {
                preloadType = TabPreloadItem.convertToPreloadType(str4);
            }
        }
        int i3 = adItem.iAdId.get();
        KuiklyMessageTabAdData parseKuiklyAdDataFromTianShu = parseKuiklyAdDataFromTianShu(str, i3);
        KuiklyMessageTabAdData kuiklyMessageTabAdData = parseKuiklyAdDataFromTianShu;
        if (parseKuiklyAdDataFromTianShu == null) {
            HippyMessageTabAdData hippyMessageTabAdData = new HippyMessageTabAdData();
            hippyMessageTabAdData.openHippyInfo = openHippyInfo;
            kuiklyMessageTabAdData = hippyMessageTabAdData;
        }
        kuiklyMessageTabAdData.adId = i3;
        kuiklyMessageTabAdData.adTraceInfo = adItem.traceinfo.get();
        kuiklyMessageTabAdData.offlinePackageBid = str2;
        kuiklyMessageTabAdData.extendJson = str;
        kuiklyMessageTabAdData.preloadType = preloadType;
        if (!checkAdData(kuiklyMessageTabAdData)) {
            return null;
        }
        return kuiklyMessageTabAdData;
    }

    private KuiklyMessageTabAdData parseKuiklyAdDataFromTianShu(String str, int i3) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        KuiklyMessageTabAdData kuiklyMessageTabAdData = null;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "[parseKuiklyAdDataFromTianShu] extendJson is empty");
            return null;
        }
        if (!isSupportKuikly()) {
            QLog.e(TAG, 1, "[parseKuiklyAdDataFromTianShu] isSupportKuikly false");
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (Throwable th5) {
            th = th5;
        }
        if (jSONObject.optInt("pageType") != 2 || (optJSONObject = jSONObject.optJSONObject("kuiklyPageData")) == null) {
            return null;
        }
        String optString = optJSONObject.optString("page_name");
        String optString2 = optJSONObject.optString("bundle_name");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            KuiklyMessageTabAdData kuiklyMessageTabAdData2 = new KuiklyMessageTabAdData();
            try {
                optJSONObject.put("extendJson", str);
                optJSONObject.put("adId", String.valueOf(i3));
                kuiklyMessageTabAdData2.openKuiklyInfo = optJSONObject;
                kuiklyMessageTabAdData = kuiklyMessageTabAdData2;
            } catch (Throwable th6) {
                th = th6;
                kuiklyMessageTabAdData = kuiklyMessageTabAdData2;
                QLog.e(TAG, 1, "parse Kuikly info error", th);
                return kuiklyMessageTabAdData;
            }
        }
        QLog.i(TAG, 2, "parse Kuikly info," + optJSONObject);
        return kuiklyMessageTabAdData;
    }

    private void preDownloadKuikly(final KuiklyMessageTabAdData kuiklyMessageTabAdData) {
        JSONObject jSONObject;
        if (kuiklyMessageTabAdData != null && (jSONObject = kuiklyMessageTabAdData.openKuiklyInfo) != null) {
            String optString = jSONObject.optString("bundle_name");
            if (!TextUtils.isEmpty(optString)) {
                ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).updateDexRes(optString, new Function1() { // from class: com.tencent.hippy.qq.api.impl.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit lambda$preDownloadKuikly$1;
                        lambda$preDownloadKuikly$1 = HippyMessageTabAdImpl.this.lambda$preDownloadKuikly$1(kuiklyMessageTabAdData, (ResError) obj);
                        return lambda$preDownloadKuikly$1;
                    }
                });
                return;
            }
        }
        QLog.e(TAG, 1, "[preDownloadKuikly] adData is invalid," + kuiklyMessageTabAdData);
    }

    private void preloadResource(HippyMessageTabAdData hippyMessageTabAdData) {
        QLog.i(TAG, 1, "preloadResource id:" + hippyMessageTabAdData.adId + " type:" + hippyMessageTabAdData.preloadType.ordinal());
        OpenHippyInfo createOpenHippyInfo = createOpenHippyInfo(hippyMessageTabAdData);
        createOpenHippyInfo.preloadType = hippyMessageTabAdData.preloadType;
        createOpenHippyInfo.isDisableTabPreload = true;
        HippyAccessHelper.preloadHippyPage(createOpenHippyInfo, new AnonymousClass1(hippyMessageTabAdData));
    }

    private void prepareResource(BaseMessageTabAdData baseMessageTabAdData) {
        updateOfflinePackage(baseMessageTabAdData);
        if (baseMessageTabAdData instanceof HippyMessageTabAdData) {
            TabPreloadItem.PreloadType preloadType = baseMessageTabAdData.preloadType;
            if (preloadType != TabPreloadItem.PreloadType.PRE_DRAW && preloadType != TabPreloadItem.PreloadType.PRE_LOAD) {
                lightPreloadResource((HippyMessageTabAdData) baseMessageTabAdData);
                return;
            } else if (getAdBoolValue(baseMessageTabAdData.adId, MMKVCommonFileKeys.IS_MESSAGE_TAB_AD_PRELOADED_PREFIX)) {
                lightPreloadResource((HippyMessageTabAdData) baseMessageTabAdData);
                return;
            } else {
                preloadResource((HippyMessageTabAdData) baseMessageTabAdData);
                return;
            }
        }
        if (baseMessageTabAdData instanceof KuiklyMessageTabAdData) {
            preDownloadKuikly((KuiklyMessageTabAdData) baseMessageTabAdData);
        }
    }

    private static void reportTianshuAnd87(int i3, int i16, int i17, String str, int i18) {
        tianshuReport(i16, String.valueOf(i3), i17, str, TIANSHU_REPORT_CUSTOM_AD_ID, "", true);
        reportTo87(i3, i16, i17, str, i18);
    }

    private static void reportTo87(int i3, int i16, int i17, String str, int i18) {
        try {
            String str2 = HippyAccessHelper.getCurrentUin() + "_" + (System.currentTimeMillis() / 1000);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ext25", i16 + "");
            hashMap.put("ext26", i3 + "");
            hashMap.put("ext27", i17 + "");
            hashMap.put("ext28", str + "");
            hashMap.put("ext29", TIANSHU_REPORT_CUSTOM_AD_ID);
            hashMap.put("ext30", str2);
            hashMap.put("ext31", i18 + "");
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "425", "769", "76930", "929432", "", hashMap);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void resetPreloadData() {
        synchronized (lock) {
            curAdData = null;
            isAdPreloaded = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setAdBoolValue(int i3, String str, boolean z16) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(getMMKVKey(i3, str), z16);
    }

    private static void setAdShowTime(int i3) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeLong(getMMKVKey(i3, MMKVCommonFileKeys.MESSAGE_TAB_AD_SHOW_TIME_PREFIX), System.currentTimeMillis() / 86400000);
    }

    private static void tianshuReport(int i3, String str, int i16, String str2, String str3, String str4, boolean z16) {
        try {
            TianShuReportData tianShuReportData = new TianShuReportData();
            String currentUin = HippyAccessHelper.getCurrentUin();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            tianShuReportData.mTraceId = currentUin + "_" + currentTimeMillis;
            tianShuReportData.mActionId = i3;
            tianShuReportData.mActionValue = i16;
            tianShuReportData.mItemId = str;
            tianShuReportData.mOperTime = currentTimeMillis;
            tianShuReportData.mTraceNum = 1;
            tianShuReportData.mAppId = str3;
            tianShuReportData.mPageId = str4;
            tianShuReportData.mModuleId = "";
            tianShuReportData.mTriggerInfo = str2;
            tianShuReportData.mNeedReportCachedUrl = z16;
            ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 2, "report appId:" + str3 + " adId:" + str + " actionId:" + i3);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "report e:", e16);
        }
    }

    private void updateOfflinePackage(final BaseMessageTabAdData baseMessageTabAdData) {
        if (TextUtils.isEmpty(baseMessageTabAdData.offlinePackageBid)) {
            return;
        }
        QLog.i(TAG, 1, "updateOfflinePackage start adId:" + baseMessageTabAdData.adId + " bid:" + baseMessageTabAdData.offlinePackageBid);
        HtmlOffline.C(new ArrayList(baseMessageTabAdData.adId), MobileQQ.sMobileQQ.peekAppRuntime(), new com.tencent.biz.common.offline.a() { // from class: com.tencent.hippy.qq.api.impl.HippyMessageTabAdImpl.4
            @Override // com.tencent.biz.common.offline.a
            public void loaded(String str, int i3) {
                QLog.i(HippyMessageTabAdImpl.TAG, 1, "updateOfflinePackage end adId:" + baseMessageTabAdData.adId + " bid:" + baseMessageTabAdData.offlinePackageBid + " code:" + i3);
            }

            @Override // com.tencent.biz.common.offline.a
            public void progress(int i3) {
            }
        }, true, true);
    }

    public boolean checkAdData(BaseMessageTabAdData baseMessageTabAdData) {
        JSONObject jSONObject;
        if (baseMessageTabAdData == null || baseMessageTabAdData.adId == 0) {
            return false;
        }
        if (baseMessageTabAdData instanceof HippyMessageTabAdData) {
            OpenHippyInfo openHippyInfo = ((HippyMessageTabAdData) baseMessageTabAdData).openHippyInfo;
            if (TextUtils.isEmpty(openHippyInfo.bundleName) || TextUtils.isEmpty(openHippyInfo.domain) || TextUtils.isEmpty(openHippyInfo.framework)) {
                return false;
            }
            if (!openHippyInfo.framework.contains(HippyQQConstants.HIPPY_VUE) && !openHippyInfo.framework.contains("react")) {
                return false;
            }
            return true;
        }
        if (!(baseMessageTabAdData instanceof KuiklyMessageTabAdData) || (jSONObject = ((KuiklyMessageTabAdData) baseMessageTabAdData).openKuiklyInfo) == null || TextUtils.isEmpty(jSONObject.optString("page_name")) || TextUtils.isEmpty(jSONObject.optString("bundle_name"))) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.hippy.qq.api.IHippyMessageTabAd
    public void handleMessageTabAd(TianShuAccess.AdItem adItem) {
        BaseMessageTabAdData parseAdDataFromTianShu = parseAdDataFromTianShu(adItem);
        if (parseAdDataFromTianShu == null) {
            QLog.e(TAG, 1, "handleHippyMessageTabAd parse data error");
            return;
        }
        QLog.i(TAG, 1, "handleHippyMessageTabAd id:" + parseAdDataFromTianShu.adId);
        if (isAdShowedToday(parseAdDataFromTianShu.adId)) {
            if (QLog.isDebugVersion()) {
                QLog.d(TAG, 1, "handleHippyMessageTabAd this ad showed today:" + parseAdDataFromTianShu.adId);
                return;
            }
            return;
        }
        synchronized (lock) {
            if (curAdData != null) {
                QLog.i(TAG, 1, "handleHippyMessageTabAd has preloaded AD, can't preload:" + parseAdDataFromTianShu.adId + " preloading:" + curAdData.adId);
                return;
            }
            curAdData = parseAdDataFromTianShu;
            isAdPreloaded = false;
            ((IStateManager) QRoute.api(IStateManager.class)).addMainStateObserver(mMainTabStateObserver);
            prepareResource(parseAdDataFromTianShu);
        }
    }
}
