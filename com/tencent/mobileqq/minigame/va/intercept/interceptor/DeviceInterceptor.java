package com.tencent.mobileqq.minigame.va.intercept.interceptor;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback;
import com.tencent.mobileqq.mini.server.MiniAppSSORequestClient;
import com.tencent.mobileqq.mini.server.MiniAppSSOResponse;
import com.tencent.mobileqq.mini.server.request.MiniGameVAHardwareConfigRequest;
import com.tencent.mobileqq.minigame.api.IMiniGameVAManager;
import com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi;
import com.tencent.mobileqq.minigame.api.impl.MiniGameVAManagerImpl;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.utils.MiniGameDownloadUtil;
import com.tencent.mobileqq.minigame.va.intercept.BaseInterceptor;
import com.tencent.mobileqq.minigame.va.intercept.InterceptRequest;
import com.tencent.mobileqq.minigame.va.intercept.interceptor.DeviceInterceptor;
import com.tencent.mobileqq.minigame.va.util.CommonUtil;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.minigame.config_center.MiniGameVAHardwareConfig$ConfigItem;
import com.tencent.trpcprotocol.minigame.config_center.MiniGameVAHardwareConfig$GetConfigRsp;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DeviceInterceptor extends BaseInterceptor {
    private static final boolean DEBUG_DISABLE_SERVER_HARDWARE_CHECK = false;
    private static final String MMKV_KEY_HARDWARE_CONFIG = "minigame_va_hardware_config";
    private static final String MMKV_KEY_HARDWARE_CONFIG_LAST_REQ_TS = "minigame_va_hardware_config_last_req_ts";
    private static final String MMKV_KEY_HARDWARE_CONFIG_REQ_INTERVAL = "minigame_va_hardware_config_req_interval";
    private static final String MMKV_KEY_HARDWARE_CONFIG_VALUE_APPID = "appid";
    private static final String MMKV_KEY_HARDWARE_CONFIG_VALUE_IS_VA_AVAILABLE = "isVAAvailable";
    private static final String MMKV_KEY_HARDWARE_CONFIG_VALUE_MINI_FAILED_REASON = "failedReason";
    private static final String MMKV_KEY_HARDWARE_CONFIG_VALUE_MINI_PLUGIN_VERSION = "miniPluginVersion";
    private static final String MMKV_KEY_HARDWARE_CONFIG_VALUE_MIN_REMAIN_STORAGE = "minRemainStorage";
    private static final String MMKV_KEY_HARDWARE_CONFIG_VALUE_USE_WIFI_AND_XG_SWITCH = "useWifiAndXGSwitch";
    private static final String MMKV_KEY_HARDWARE_CONFIG_VALUE_WIFI_AUTO_DOWNLOAD = "wifiAutoDownload";
    private static final String TAG = "MiniGameVADeviceInterceptor";
    private static final int VA_SUPPORT_MIN_OS_VERSION = 26;
    private final ConcurrentHashMap<String, String> modelCheckFailedReasonMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, String> hardwareConfigCheckFailedReasonMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, MiniGameVAManagerImpl.MiniGameVAHardwareConfigItem> hardwareConfigMap = new ConcurrentHashMap<>();
    private long hardwareConfigLastReqTs = 0;
    private long hardwareConfigReqInterval = 0;
    private boolean isHardwareConfigRequested = false;
    private String currentUin = "";

    private void saveNewHardwareConfig(long j3) {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_MINI_APP);
        JSONArray jSONArray = new JSONArray();
        Iterator<Map.Entry<String, MiniGameVAManagerImpl.MiniGameVAHardwareConfigItem>> it = this.hardwareConfigMap.entrySet().iterator();
        while (it.hasNext()) {
            MiniGameVAManagerImpl.MiniGameVAHardwareConfigItem value = it.next().getValue();
            jSONArray.mo162put(createConfigItemJson(value));
            MiniGameVAUtil.updateWifiAutoUpgradeVAFlag(value.getAppId(), value.getWifiAutoDownload(), true, false);
            MiniGameVAUtil.setUseWifiAndXGSwitch(value.getUseWifiAndXGSwitch());
        }
        String str = "_" + MiniGameVAUtil.getCurrentUinFromAppRuntime();
        from.encodeString(MMKV_KEY_HARDWARE_CONFIG + str, jSONArray.toString());
        long currentTimeMillis = System.currentTimeMillis();
        from.encodeLong(MMKV_KEY_HARDWARE_CONFIG_REQ_INTERVAL + str, j3);
        from.encodeLong(MMKV_KEY_HARDWARE_CONFIG_LAST_REQ_TS + str, currentTimeMillis);
        QLog.d(TAG, 1, "saveNewHardwareConfig interval:" + j3 + ", ts:" + currentTimeMillis + ", newConfig:" + this.hardwareConfigMap);
    }

    public void clearLocalHardwareConfig() {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_MINI_APP);
        String str = "_" + MiniGameVAUtil.getCurrentUinFromAppRuntime();
        from.removeKey(MMKV_KEY_HARDWARE_CONFIG_REQ_INTERVAL + str);
        from.removeKey(MMKV_KEY_HARDWARE_CONFIG_LAST_REQ_TS + str);
        from.removeKey(MMKV_KEY_HARDWARE_CONFIG + str);
        this.hardwareConfigMap.clear();
        this.hardwareConfigLastReqTs = 0L;
        this.hardwareConfigReqInterval = 0L;
        this.isHardwareConfigRequested = false;
    }

    public MiniGameVAManagerImpl.MiniGameVAHardwareConfigItem getHardwareConfigItem(String str) {
        if (this.hardwareConfigMap.containsKey(str)) {
            return null;
        }
        return this.hardwareConfigMap.get(str);
    }

    @Override // com.tencent.mobileqq.minigame.va.intercept.BaseInterceptor
    public void handleIntercept(InterceptRequest interceptRequest) {
        if (!isModelLimitValid(interceptRequest.appId, false)) {
            MiniGameVAInterceptConfig.VAInterceptConfig appConfig = interceptRequest.getAppConfig();
            boolean isAppInstalled = interceptRequest.canJumpApp() ? PackageUtil.isAppInstalled(interceptRequest.getContext(), appConfig.getGameAppPkgName()) : false;
            QLog.d(TAG, 1, "interceptLaunch isModelLimitValid false isAppInstalled:" + isAppInstalled);
            if (isAppInstalled) {
                QLog.d(TAG, 1, "interceptLaunch isModelLimitValid false launch game app");
                MiniGameVAUtil.launchGameApp(interceptRequest.getContext(), appConfig, interceptRequest.gameData, interceptRequest.getCallback(), interceptRequest.startInterceptTime, interceptRequest.scene, interceptRequest.via);
                return;
            }
            interceptRequest.getCallback().onInterceptResult(false, false);
            MiniGameVAUtil.reportLaunch(appConfig.getGameAppId(), "3", "1", "", System.currentTimeMillis() - interceptRequest.startInterceptTime, interceptRequest.scene, interceptRequest.via);
            MiniGameVAUtil.showDebugToast("\u62e6\u622a\u5931\u8d25:" + this.modelCheckFailedReasonMap.get(interceptRequest.appId));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleIntercept isModelLimitValid is ok");
        }
        BaseInterceptor baseInterceptor = this.nextInterceptor;
        if (baseInterceptor != null) {
            baseInterceptor.handleIntercept(interceptRequest);
        }
    }

    public boolean isModelLimitValid(String str, boolean z16) {
        if (!AppSetting.isPublicVersion() && !AppSetting.isGrayVersion() && CommonUtil.isLocalInterceptDisable()) {
            QLog.d(TAG, 1, "isModelLimitValid isLocalInterceptDisable, appId:" + str);
            return false;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            QLog.d(TAG, 1, "isModelLimitValid os version not support:" + i3);
            this.modelCheckFailedReasonMap.put(str, "\u7cfb\u7edf\u7248\u672c\u8fc7\u4f4e");
            return false;
        }
        MiniGameVAInterceptConfig.VAInterceptConfig vAAppConfig = CommonUtil.getVAAppConfig(str);
        if (vAAppConfig == null) {
            QLog.d(TAG, 1, "isModelLimitValid not in vaInterceptConfig");
            this.modelCheckFailedReasonMap.put(str, "\u62e6\u622a\u914d\u7f6e\u5339\u914d\u5931\u8d25");
            return false;
        }
        if (!this.hardwareConfigMap.containsKey(str)) {
            QLog.d(TAG, 1, "isModelLimitValid appId:" + str + ", not in config map:" + this.hardwareConfigMap);
            this.modelCheckFailedReasonMap.put(str, "\u65e0\u540e\u53f0\u673a\u578b\u914d\u7f6e");
            return false;
        }
        MiniGameVAManagerImpl.MiniGameVAHardwareConfigItem miniGameVAHardwareConfigItem = this.hardwareConfigMap.get(str);
        if (miniGameVAHardwareConfigItem == null || !miniGameVAHardwareConfigItem.isVAAvailable()) {
            QLog.w(TAG, 1, "isModelLimitValid hardware check failed, configItem:" + miniGameVAHardwareConfigItem);
            String str2 = this.hardwareConfigCheckFailedReasonMap.get(str);
            if (!TextUtils.isEmpty(str2)) {
                this.modelCheckFailedReasonMap.put(str, str2);
            } else if (miniGameVAHardwareConfigItem != null && !TextUtils.isEmpty(miniGameVAHardwareConfigItem.getFailedReason())) {
                this.modelCheckFailedReasonMap.put(str, miniGameVAHardwareConfigItem.getFailedReason());
                QLog.w(TAG, 1, "isModelLimitValid hardware check failed, failedReason:" + miniGameVAHardwareConfigItem.getFailedReason());
            } else {
                this.modelCheckFailedReasonMap.put(str, "\u672a\u77e5\u539f\u56e0");
            }
            return false;
        }
        if (z16) {
            long b16 = cu.b() / 1024;
            if (((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).isApkDownloadInnerStorageEnable()) {
                b16 = MiniGameDownloadUtil.INSTANCE.getAvailableAppInnerStorage() / 1024;
                QLog.i(TAG, 1, "isModelLimitValid remainSize:" + b16);
            }
            if (b16 < miniGameVAHardwareConfigItem.getMinRemainStorage()) {
                QLog.w(TAG, 1, "isModelLimitValid no space, remainSize:" + b16 + ", minRemainStorage:" + miniGameVAHardwareConfigItem.getMinRemainStorage());
                MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989335", "20", vAAppConfig.getGameAppId(), null);
                return false;
            }
        }
        return true;
    }

    public void updateHardwareConfigFromServer(MiniGameVAInterceptConfig miniGameVAInterceptConfig) {
        if (miniGameVAInterceptConfig.getInterceptConfigMap().isEmpty()) {
            QLog.w(TAG, 1, "initHardwareConfig vaInterceptConfig empty");
            return;
        }
        if (this.isHardwareConfigRequested && TextUtils.equals(this.currentUin, MiniGameVAUtil.getCurrentUinFromAppRuntime())) {
            QLog.w(TAG, 1, "initHardwareConfig isHardwareConfigRequested true");
            return;
        }
        initHardwareConfigFromCache();
        if (this.hardwareConfigReqInterval > 0 && System.currentTimeMillis() - this.hardwareConfigLastReqTs < this.hardwareConfigReqInterval * 1000) {
            QLog.w(TAG, 1, "initHardwareConfig not exceeding interval");
            return;
        }
        ArrayList arrayList = new ArrayList(miniGameVAInterceptConfig.getInterceptConfigMap().keySet());
        this.isHardwareConfigRequested = true;
        this.currentUin = MiniGameVAUtil.getCurrentUinFromAppRuntime();
        MiniAppSSORequestClient.INSTANCE.sendReq(new MiniGameVAHardwareConfigRequest(arrayList), new AnonymousClass1());
    }

    private static JSONObject createConfigItemJson(MiniGameVAManagerImpl.MiniGameVAHardwareConfigItem miniGameVAHardwareConfigItem) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("appid", miniGameVAHardwareConfigItem.getAppId());
                jSONObject2.put(MMKV_KEY_HARDWARE_CONFIG_VALUE_IS_VA_AVAILABLE, miniGameVAHardwareConfigItem.isVAAvailable());
                jSONObject2.put(MMKV_KEY_HARDWARE_CONFIG_VALUE_MIN_REMAIN_STORAGE, miniGameVAHardwareConfigItem.getMinRemainStorage());
                jSONObject2.put(MMKV_KEY_HARDWARE_CONFIG_VALUE_MINI_PLUGIN_VERSION, miniGameVAHardwareConfigItem.getMiniPluginVersion());
                jSONObject2.put(MMKV_KEY_HARDWARE_CONFIG_VALUE_MINI_FAILED_REASON, miniGameVAHardwareConfigItem.getFailedReason());
                jSONObject2.put("wifiAutoDownload", miniGameVAHardwareConfigItem.getWifiAutoDownload());
                jSONObject2.put(MMKV_KEY_HARDWARE_CONFIG_VALUE_USE_WIFI_AND_XG_SWITCH, miniGameVAHardwareConfigItem.getUseWifiAndXGSwitch());
                return jSONObject2;
            } catch (Exception e16) {
                e = e16;
                jSONObject = jSONObject2;
                QLog.e(TAG, 1, "saveNewHardwareConfig exception:", e);
                return jSONObject;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.minigame.va.intercept.interceptor.DeviceInterceptor$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public class AnonymousClass1 implements MiniAppSSOReqCallback {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(MiniAppSSOResponse miniAppSSOResponse) {
            DeviceInterceptor.this.handleHardwareConfig(miniAppSSOResponse);
        }

        @Override // com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback
        public void onResponse(final MiniAppSSOResponse miniAppSSOResponse) {
            if (miniAppSSOResponse == null) {
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.intercept.interceptor.a
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceInterceptor.AnonymousClass1.this.lambda$onResponse$0(miniAppSSOResponse);
                }
            }, 64, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void handleHardwareConfig(MiniAppSSOResponse miniAppSSOResponse) {
        int i3 = 1;
        boolean z16 = miniAppSSOResponse.getRetCode() == 0;
        QLog.d(TAG, 1, "initHardwareConfig sendReq isSuccess:" + z16 + "retCode:" + miniAppSSOResponse.getRetCode());
        if (z16 && miniAppSSOResponse.isDataValid()) {
            try {
                MiniGameVAHardwareConfig$GetConfigRsp miniGameVAHardwareConfig$GetConfigRsp = new MiniGameVAHardwareConfig$GetConfigRsp();
                miniGameVAHardwareConfig$GetConfigRsp.mergeFrom(miniAppSSOResponse.getData());
                for (MiniGameVAHardwareConfig$ConfigItem miniGameVAHardwareConfig$ConfigItem : miniGameVAHardwareConfig$GetConfigRsp.items.get()) {
                    String str = miniGameVAHardwareConfig$ConfigItem.appid.get();
                    String stringUtf8 = miniGameVAHardwareConfig$ConfigItem.info.get().toStringUtf8();
                    QLog.d(TAG, i3, "initHardwareConfig rsp appId:" + str + ", info:" + stringUtf8);
                    JSONObject jSONObject = new JSONObject(stringUtf8);
                    MiniGameVAManagerImpl.MiniGameVAHardwareConfigItem miniGameVAHardwareConfigItem = new MiniGameVAManagerImpl.MiniGameVAHardwareConfigItem(str, jSONObject.optInt(MMKV_KEY_HARDWARE_CONFIG_VALUE_IS_VA_AVAILABLE) == i3 ? i3 : 0, jSONObject.optLong("minRemainStorageSpace"), jSONObject.optString("vaAvailableVersion"), jSONObject.optString(MMKV_KEY_HARDWARE_CONFIG_VALUE_MINI_FAILED_REASON), jSONObject.optInt("wifiAutoDownload") == i3 ? i3 : 0, jSONObject.optInt(MMKV_KEY_HARDWARE_CONFIG_VALUE_USE_WIFI_AND_XG_SWITCH) == i3 ? i3 : 0);
                    if (!miniGameVAHardwareConfigItem.isVAAvailable()) {
                        this.hardwareConfigCheckFailedReasonMap.put(str, jSONObject.optString(MMKV_KEY_HARDWARE_CONFIG_VALUE_MINI_FAILED_REASON));
                    }
                    this.hardwareConfigMap.put(str, miniGameVAHardwareConfigItem);
                    i3 = 1;
                }
                saveNewHardwareConfig(miniGameVAHardwareConfig$GetConfigRsp.interval.get());
                ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).updateCrashProtect(false);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "initHardwareConfig parse rsp exception:", e16);
            }
        }
    }

    public void initHardwareConfigFromCache() {
        JSONArray jSONArray;
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_MINI_APP);
        String str = "_" + MiniGameVAUtil.getCurrentUinFromAppRuntime();
        this.hardwareConfigReqInterval = from.decodeLong(MMKV_KEY_HARDWARE_CONFIG_REQ_INTERVAL + str, 0L);
        this.hardwareConfigLastReqTs = from.decodeLong(MMKV_KEY_HARDWARE_CONFIG_LAST_REQ_TS + str, 0L);
        String decodeString = from.decodeString(MMKV_KEY_HARDWARE_CONFIG + str, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        this.hardwareConfigMap.clear();
        try {
            jSONArray = new JSONArray(decodeString);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "initLocalHardwareConfig", e16);
            jSONArray = null;
        }
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            this.hardwareConfigMap.put(optJSONObject.optString("appid"), new MiniGameVAManagerImpl.MiniGameVAHardwareConfigItem(optJSONObject.optString("appid"), optJSONObject.optBoolean(MMKV_KEY_HARDWARE_CONFIG_VALUE_IS_VA_AVAILABLE), optJSONObject.optLong(MMKV_KEY_HARDWARE_CONFIG_VALUE_MIN_REMAIN_STORAGE), optJSONObject.optString(MMKV_KEY_HARDWARE_CONFIG_VALUE_MINI_PLUGIN_VERSION), optJSONObject.optString(MMKV_KEY_HARDWARE_CONFIG_VALUE_MINI_FAILED_REASON), optJSONObject.optBoolean("wifiAutoDownload"), optJSONObject.optBoolean(MMKV_KEY_HARDWARE_CONFIG_VALUE_USE_WIFI_AND_XG_SWITCH)));
        }
        QLog.d(TAG, 1, "initLocalHardwareConfig reqInterval:" + this.hardwareConfigReqInterval + "lastReqTs:" + this.hardwareConfigLastReqTs + "localConfig:" + this.hardwareConfigMap);
    }
}
