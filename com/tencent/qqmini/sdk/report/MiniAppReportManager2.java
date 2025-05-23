package com.tencent.qqmini.sdk.report;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMiniReportProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.runtime.AppStateManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppReportManager2 {
    public static final String APP_TYPE_MINI_APP = "0";
    public static final String APP_TYPE_MINI_GAME = "1";
    public static final String KEY_ACTION_TYPE = "action_type";
    public static final String KEY_ADD_DURATION_MS = "add_duration_ms";
    public static final String KEY_APP_CONFIG = "app_config";
    public static final String KEY_APP_TYPE = "app_type";
    public static final String KEY_PATH = "path";
    public static final String KEY_REFER = "refer";
    public static final String KEY_RESERVES = "reserves";
    public static final String KEY_RESERVES2 = "reserves2";
    public static final String KEY_SLOT_ID = "slot_id";
    public static final String KEY_SUB_ACTION = "sub_action";
    public static final String KEY_VIA = "via";
    public static final String KEY_X5_ENABLE = "x5_enable";
    public static final String PAGE_VIEW_ACTION = "page_view";
    public static final String TAG = "MiniAppReportManager2";
    public static final String VALUE_SERVICE_NOT_PRELOAD = "service_not_preload";
    public static final String VALUE_SERVICE_PRELAUNCH = "service_prelaunch";
    public static final String VALUE_SERVICE_PRELOAD = "service_preload";
    public static final String VALUE_SERVICE_PRELOAD_FINISHED = "service_preload_finished";
    public static final long LAUNCH_TIME_OUT = getShowTimeout();
    public static final boolean IS_MAIN_PROCESS = AppLoaderFactory.g().isMainProcess();
    public static HashMap<String, AppLaunchState> launchStateMap = new HashMap<>();
    public static HashMap<String, Integer> lanchFailCode = new HashMap<>();
    private static boolean first = true;
    private static boolean timerEnable = false;
    private static Handler handler = null;
    private static Runnable launchTimeoutRunnable = new Runnable() { // from class: com.tencent.qqmini.sdk.report.MiniAppReportManager2.1
        @Override // java.lang.Runnable
        public void run() {
            boolean z16 = false;
            try {
                boolean unused = MiniAppReportManager2.timerEnable = false;
                long currentTimeMillis = System.currentTimeMillis();
                for (Map.Entry<String, AppLaunchState> entry : MiniAppReportManager2.launchStateMap.entrySet()) {
                    entry.getKey();
                    AppLaunchState value = entry.getValue();
                    if (value.launchResult == 0 && currentTimeMillis - value.activeTime > MiniAppReportManager2.LAUNCH_TIME_OUT) {
                        MiniAppReportManager2.reportTimeout(value);
                    }
                    if (value.launchResult == 0) {
                        z16 = true;
                    }
                }
                if (z16) {
                    MiniAppReportManager2.setTimeOutForLaunch();
                }
            } catch (Throwable th5) {
                QMLog.e("MiniAppReportManager2", "", th5);
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class AppLaunchState {
        public static final int LAUNCHING = 0;
        public static final int LAUNCH_FAIL = 2;
        public static final int LAUNCH_SUCESS = 1;
        public static boolean hasX5 = false;
        public long activeTime;
        public String appId;
        public long clickTime;
        public int engineType;
        public long hideTime;
        public String jsError;
        public String launchId;
        public long launchTime;
        public long loadEndTime;
        public long loadTime;
        public boolean needReportLaunchResult;
        public int reportType;
        public long showTime;
        public int verType;
        public int launchResult = 0;
        public boolean hasPkg = false;
        public boolean flutterMode = false;

        public void fromJson(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.appId = jSONObject.getString("appid");
                this.engineType = jSONObject.getInt(TagName.ENGINE_TYPE);
                this.reportType = jSONObject.getInt(AdMetricTag.Report.TYPE);
                this.verType = jSONObject.getInt("verType");
                this.launchId = jSONObject.getString("launchId");
                this.clickTime = jSONObject.getLong("clickTime");
                this.loadTime = jSONObject.getLong(WinkDengtaReportConstant.Params.REPORT_PARMA_LOAD_TIME);
                this.launchTime = jSONObject.getLong("launchTime");
                this.launchResult = jSONObject.getInt("launchResult");
                this.activeTime = jSONObject.getLong("activeTime");
                this.showTime = jSONObject.getLong(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME);
                this.hideTime = jSONObject.getLong("hideTime");
                this.jsError = jSONObject.getString("jsError");
                this.needReportLaunchResult = jSONObject.getBoolean("needReportLaunchResult");
                this.hasPkg = jSONObject.getBoolean("hasPkg");
                this.flutterMode = jSONObject.optBoolean("flutterMode");
                this.loadEndTime = jSONObject.optLong("loadEndTime");
            } catch (Throwable unused) {
            }
        }

        public String hasPkgAndX5() {
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("SDK_");
            String str2 = "";
            if (!hasX5) {
                str = "";
            } else {
                str = "hasX5";
            }
            sb5.append(str);
            if (this.hasPkg) {
                str2 = "_hasPkg";
            }
            sb5.append(str2);
            return sb5.toString();
        }

        public void reset() {
            this.loadTime = 0L;
            this.launchTime = 0L;
            this.launchResult = 0;
            this.showTime = 0L;
            this.hideTime = 0L;
            this.needReportLaunchResult = true;
            this.jsError = null;
            this.hasPkg = false;
            this.loadEndTime = 0L;
        }

        public String toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", this.appId);
                jSONObject.put(TagName.ENGINE_TYPE, this.engineType);
                jSONObject.put(AdMetricTag.Report.TYPE, this.reportType);
                jSONObject.put("verType", this.verType);
                jSONObject.put("launchId", this.launchId);
                jSONObject.put("clickTime", this.clickTime);
                jSONObject.put(WinkDengtaReportConstant.Params.REPORT_PARMA_LOAD_TIME, this.loadTime);
                jSONObject.put("launchTime", this.launchTime);
                jSONObject.put("launchResult", this.launchResult);
                jSONObject.put("activeTime", this.activeTime);
                jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, this.showTime);
                jSONObject.put("hideTime", this.hideTime);
                jSONObject.put("jsError", this.jsError);
                jSONObject.put("needReportLaunchResult", this.needReportLaunchResult);
                jSONObject.put("hasPkg", this.hasPkg);
                jSONObject.put("flutterMode", this.flutterMode);
                jSONObject.put("loadEndTime", this.loadEndTime);
                return jSONObject.toString();
            } catch (Throwable unused) {
                return null;
            }
        }

        public String toString() {
            return "launchId: " + this.launchId + ", appId: 0";
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class FailCode {
        public static final String APPID_CONFLICT_FAIL = "appid_conflict";
        public static final String BASE_LIB_TASK_FAIL = "baselib_task_fail";
        public static final String CACHE_HIT = "hit";
        public static final String CACHE_UNHIT = "unhit";
        public static final String DOWNLOAD_PKG_FAIL = "download_apk_fail";
        public static final String DOWNLOAD_URL_FAIL = "download_url_fail";
        public static final String FLUTTER_SDK_FAIL = "flutter_sdk_fail";
        public static final String INIT_DATA_FAIL = "init_data_fail";
        public static final String IS_X5_JSCORE = "is_x5_jscore";
        public static final String JS_ERROR = "jsError";
        public static final String LOADING_PAGE_KILL = "loading_page_kill";
        public static final String LOAD_BASE_LIB_FAIL = "load_baselib_fail";
        public static final String LOAD_PKG_FAIL = "load_pkg_fail";
        public static final String NOT_FOREGROUND_FAIL = "not_foreground";
        public static final String NOT_READY_FAIL = "not_ready";
        public static final String OFFLINE_NOT_READY_FAIL = "offline_not_ready";
        public static final String OFFLINE_NOT_SUPPORT_FAIL = "offline_not_support";
        public static final String PKG_IS_DOWNLOADED = "pkg_is_downloaded";
        public static final String PKG_TASK_FAIL = "pkg_task_fail";
        public static final String QQ_VERSION_LIMIT_FAIL = "qq_version_limit_fail";
        public static final String SHORTCUT_REQUEST_FAIL = "shotcut_request_fail";
        public static final String SHOW_PAGE_KILL = "show_page_kill";
        public static final String SPLASH_EXIT_WHEN_FAIL = "splash_exit_when_fail";
        public static final String START_NO_INTENT_FAIL = "start_no_intent";
        public static final String SYSTEM_VERSION_LIMIT_FAIL = "system_version_limit_fail";
        public static final String TIME_OUT_CODE = "timeout";
        public static final String TIME_OUT_CODE_25 = "timeout_25";
        public static final String UNPKG_PKG_FAIL = "unpkg_fail";
        public static final String USER_CANCEL_BACK_KEY = "cancel_by_backkey";
        public static final String USER_CANCEL_CLOSE = "cancel_by_close";
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class PageViewSubAction {
        public static final String APKG_CACHE = "cache_apkg_hit";
        public static final String BACK_KEY = "2back_key";
        public static final String CLICK = "2click";
        public static final String CLOSE = "2close";
        public static final String CREATE = "2create";
        public static final String FINISHSHOW = "2finishshow";
        public static final String HIDE = "2hide";
        public static final String LAUNCH = "2launch";
        public static final String LAUNCH_FAIL = "2launch_fail";
        public static final String LOAD = "2load";
        public static final String LOAD_END = "2load_end";
        public static final String PAGE_HIDE = "2page_hide";
        public static final String PAGE_SHOW = "2page_show";
        public static final String SHOW = "2show";
        public static final String UNLOAD = "2unload";
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ReportBackKeyReserve {
        public static final String CODE_INNER_PAGE = "inner_page";
        public static final String CODE_LOADING_PAGE = "loading_page";
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ReportCloseReserve {
        public static final String CODE_INNER_PAGE = "inner_page";
        public static final String CODE_LOADING_PAGE = "loading_page";
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ReportShowReserve {
        public static final String CODE_BRING_TO_FRONT = "bring_to_front";
        public static final String CODE_CHANGE_PAGE = "switch_page";
        public static final String CODE_CLICK_RESUME = "click_resume";
        public static final String CODE_FIRST_FRAME = "first_frame";
        public static final String CODE_PATH_PAGE_SHOW = "path_page_show";
    }

    static {
        lanchFailCode.put("load_baselib_fail", 402);
        lanchFailCode.put("download_url_fail", 403);
        lanchFailCode.put("download_apk_fail", 404);
        lanchFailCode.put("unpkg_fail", 405);
        lanchFailCode.put("load_pkg_fail", 406);
        lanchFailCode.put("system_version_limit_fail", 407);
        lanchFailCode.put("qq_version_limit_fail", 408);
        lanchFailCode.put("loading_page_kill", 409);
        lanchFailCode.put("baselib_task_fail", 410);
        lanchFailCode.put("pkg_task_fail", 411);
        lanchFailCode.put("start_no_intent", 412);
        lanchFailCode.put("appid_conflict", 413);
        lanchFailCode.put("init_data_fail", 414);
        lanchFailCode.put("not_foreground", 415);
        lanchFailCode.put("splash_exit_when_fail", 416);
        lanchFailCode.put("shotcut_request_fail", 417);
        lanchFailCode.put("offline_not_support", 418);
        lanchFailCode.put("offline_not_ready", 419);
        lanchFailCode.put("not_ready", 420);
        lanchFailCode.put("show_page_kill", 421);
    }

    private static void doReportOld(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<String, String> map, MiniAppInfo miniAppInfo) {
        boolean z16;
        String str8;
        String str9;
        String str10;
        Map<String, String> map2 = map;
        if (QMLog.isDebugEnabled()) {
            QMLog.d("MiniAppReportManager2", "doReportOld actionType = " + str + " subActionType = " + str2 + " launchId = " + str3);
        }
        if (QUAUtil.isQQApp()) {
            int i3 = 1001;
            if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.via)) {
                if (TextUtils.equals(miniAppInfo.via, "3005_1")) {
                    i3 = 3005;
                } else if (TextUtils.equals(miniAppInfo.via, "3043_1")) {
                    i3 = 3043;
                }
                QMLog.d("MiniAppReportManager2", "doReportOld new report link = " + miniAppInfo.link + " via = " + miniAppInfo.via + " subActionType = " + str2);
            }
            if (map2 != null && map2.containsKey(KEY_SLOT_ID)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.launchParam.slotId)) {
                if (map2 == null) {
                    map2 = new HashMap<>();
                }
                map2.put(KEY_SLOT_ID, miniAppInfo.launchParam.slotId);
            }
            Map<String, String> map3 = map2;
            if ("2click".equals(str2)) {
                if (miniAppInfo != null) {
                    StringBuilder sb5 = new StringBuilder();
                    LaunchParam launchParam = miniAppInfo.launchParam;
                    if (launchParam != null) {
                        i3 = launchParam.scene;
                    }
                    sb5.append(i3);
                    sb5.append("");
                    String sb6 = sb5.toString();
                    if (isHalfMini(miniAppInfo)) {
                        str10 = "halfscreen";
                    } else {
                        str10 = ReportConst.ACTION.FULLSCREEN;
                    }
                    SDKMiniProgramLpReportDC04239.reportWithR10(miniAppInfo, "page_view", "click", str4, sb6, str3, str5, str6, str7, str10, miniAppInfo.link, map3);
                    return;
                }
                return;
            }
            if ("2show".equals(str2)) {
                if (miniAppInfo != null) {
                    StringBuilder sb7 = new StringBuilder();
                    LaunchParam launchParam2 = miniAppInfo.launchParam;
                    if (launchParam2 != null) {
                        i3 = launchParam2.scene;
                    }
                    sb7.append(i3);
                    sb7.append("");
                    String sb8 = sb7.toString();
                    if (isHalfMini(miniAppInfo)) {
                        str9 = "halfscreen";
                    } else {
                        str9 = ReportConst.ACTION.FULLSCREEN;
                    }
                    SDKMiniProgramLpReportDC04239.reportWithR10(miniAppInfo, "page_view", "show", str4, sb8, str3, str5, str6, str7, str9, miniAppInfo.link, map3);
                    return;
                }
                return;
            }
            if ("2hide".equals(str2)) {
                if (miniAppInfo != null) {
                    StringBuilder sb9 = new StringBuilder();
                    LaunchParam launchParam3 = miniAppInfo.launchParam;
                    if (launchParam3 != null) {
                        i3 = launchParam3.scene;
                    }
                    sb9.append(i3);
                    sb9.append("");
                    String sb10 = sb9.toString();
                    if (isHalfMini(miniAppInfo)) {
                        str8 = "halfscreen";
                    } else {
                        str8 = ReportConst.ACTION.FULLSCREEN;
                    }
                    SDKMiniProgramLpReportDC04239.reportWithR10(miniAppInfo, "page_view", "hide", str4, sb10, str3, str5, str6, str7, str8, miniAppInfo.link, map3);
                    return;
                }
                return;
            }
            if ("2load".equals(str2)) {
                report(str, "load", str3, str4, str5, str6, str7, map3, miniAppInfo);
                return;
            }
            if ("2close".equals(str2)) {
                report(str, "close", str3, str4, str5, str6, str7, map3, miniAppInfo);
                return;
            }
            if ("2unload".equals(str2)) {
                report(str, "unload", str3, str4, str5, str6, str7, map3, miniAppInfo);
                return;
            }
            if ("2show_fail".equals(str2)) {
                report(str, "show_fail", str3, str4, str5, str6, str7, map3, miniAppInfo);
            } else if ("2load_fail".equals(str2)) {
                report(str, "load_fail", str3, str4, str5, str6, str7, map3, miniAppInfo);
            } else if ("2finishshow".equals(str2)) {
                report(str, "finishshow", str3, str4, str5, str6, str7, map3, miniAppInfo);
            }
        }
    }

    private static AppStateManager getAppStateManager(MiniAppInfo miniAppInfo) {
        BaseRuntimeLoader queryAppRunTimeLoader;
        if (miniAppInfo == null || (queryAppRunTimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(miniAppInfo)) == null) {
            return null;
        }
        return queryAppRunTimeLoader.getAppStateManager();
    }

    private static String getAppType(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null || !miniAppInfo.isReportTypeMiniGame()) {
            return "0";
        }
        return "1";
    }

    private static String getReserve2(String str, boolean z16, boolean z17) {
        String apkgDownloadDesc = MiniAppStartState.getApkgDownloadDesc(str);
        if (z16 && z17) {
            return "apkg_download_preloaded";
        }
        return apkgDownloadDesc;
    }

    private static String getReserve3(MiniAppInfo miniAppInfo, String str, AppStateManager appStateManager) {
        String baselibLoadDesc;
        if (miniAppInfo.isReportTypeMiniGame()) {
            baselibLoadDesc = MiniAppStartState.getProcessLoadDesc(str);
        } else {
            baselibLoadDesc = MiniAppStartState.getBaselibLoadDesc(str);
        }
        if (appStateManager != null && appStateManager.isFlutter) {
            if ((appStateManager.isFromPreload || appStateManager.isFromPrelaunch) && appStateManager.hasPreloadCompleted) {
                return VALUE_SERVICE_PRELOAD_FINISHED;
            }
            return baselibLoadDesc;
        }
        return baselibLoadDesc;
    }

    public static long getShowTimeout() {
        return WnsConfig.getConfig("qqtriton", "MiniShowTimeout", 45000L);
    }

    private static String getTimeOutCode(long j3) {
        if (j3 < 0) {
            return "timeout-1";
        }
        if (j3 < 15000) {
            return "timeout_" + Math.round((float) (j3 / 1000));
        }
        if (j3 < s.G) {
            return "timeout_25";
        }
        return "timeout";
    }

    private static boolean isHalfMini(MiniAppInfo miniAppInfo) {
        LaunchParam launchParam;
        EntryModel entryModel;
        if (miniAppInfo == null || (launchParam = miniAppInfo.launchParam) == null || (entryModel = launchParam.entryModel) == null || entryModel.type != 9) {
            return false;
        }
        return true;
    }

    private static boolean isNeedFlush(String str, String str2) {
        if (!"2hide".equals(str) && (!"2show".equals(str) || (!"first_frame".equals(str2) && !"click_resume".equals(str2)))) {
            return false;
        }
        return true;
    }

    private static void loadLaunchStates() {
        String string;
        SharedPreferences sharedPreferences = AppLoaderFactory.g().getContext().getSharedPreferences("MiniAppLaunshState", 4);
        String string2 = sharedPreferences.getString("appid", null);
        if (string2 != null) {
            for (String str : string2.split(",")) {
                if (!TextUtils.isEmpty(str) && (string = sharedPreferences.getString(str, null)) != null) {
                    AppLaunchState appLaunchState = new AppLaunchState();
                    appLaunchState.fromJson(string);
                    if (!TextUtils.isEmpty(appLaunchState.appId)) {
                        launchStateMap.put(str, appLaunchState);
                    }
                }
            }
            setTimeOutForLaunch();
        }
    }

    public static boolean needReportData(String str, MiniAppInfo miniAppInfo) {
        return true;
    }

    public static void onEnterBackground() {
        QMLog.d("MiniAppReportManager2", "onEnterBackground");
        try {
            MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.MiniAppReportManager2.3
                @Override // java.lang.Runnable
                public void run() {
                    MiniProgramReporter.getInstance().reportImmediatelyLaunchDcData();
                }
            });
        } catch (Throwable th5) {
            QMLog.e("MiniAppReportManager2", "onEnterBackground exception", th5);
        }
    }

    private static void report(String str, String str2, String str3, String str4, String str5, String str6, String str7, MiniAppInfo miniAppInfo) {
        report(str, str2, str3, str4, str5, str6, str7, null, miniAppInfo);
    }

    private static void reportLaunchFail(String str, String str2, MiniAppInfo miniAppInfo, String str3, String str4, String str5) {
        Integer num = lanchFailCode.get(str);
        if (num == null) {
            num = 401;
        }
        MiniReportManager.reportEventType(miniAppInfo, 2, str2, null, null, num.intValue(), str4, 0L, null, MiniAppStartState.getBaseLibDownloadDesc(str3), MiniAppStartState.getApkgDownloadDesc(str3), str5, MiniAppStartState.getPageSwitchDesc(str3));
    }

    public static void reportLaunchPiecewise(int i3, String str, MiniAppInfo miniAppInfo) {
        AppLaunchState appLaunchState = launchStateMap.get(miniAppInfo.appId);
        String str2 = "";
        if (appLaunchState != null) {
            if (appLaunchState.flutterMode) {
                str2 = "flutter";
            } else if (AppLaunchState.hasX5) {
                str2 = "_webview_x5";
            } else {
                str2 = "_webview_system";
            }
            if (appLaunchState.hasPkg) {
                str2 = str2 + "_hasPkg";
            }
        }
        MiniReportManager.reportEventType(miniAppInfo, i3, str2, MiniReportManager.getAppType(miniAppInfo));
    }

    public static void reportPageView(final String str, final String str2, final String str3, final MiniAppInfo miniAppInfo) {
        try {
            if (IS_MAIN_PROCESS) {
                reportPageViewInMainProcess(str, str2, str3, miniAppInfo);
                return;
            }
            MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.MiniAppReportManager2.2
                @Override // java.lang.Runnable
                public void run() {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("app_config", MiniAppInfo.this);
                    bundle.putString("action_type", "page_view");
                    bundle.putString("sub_action", str);
                    bundle.putString("path", str3);
                    bundle.putString("reserves", str2);
                    AppBrandCmdProxy.g().sendCmd("launch_report2", bundle, null);
                }
            });
            reportQulaityResult(str, str2, str3, miniAppInfo);
            if ("2unload".equals(str) && miniAppInfo != null) {
                MiniAppStartState.removeState(miniAppInfo.appId);
            }
            setCrashReportAppInfo(str, miniAppInfo);
        } catch (Throwable th5) {
            QMLog.e("MiniAppReportManager2", "", th5);
        }
    }

    public static void reportPageViewInMainProcess(String str, String str2, String str3, MiniAppInfo miniAppInfo) {
        long j3;
        boolean z16;
        int i3;
        boolean z17;
        HashMap hashMap;
        int i16;
        String str4;
        LaunchParam launchParam;
        String str5;
        int i17;
        String str6;
        AppLaunchState updateLaunchState = updateLaunchState(str, str2, str3, miniAppInfo);
        if (updateLaunchState == null) {
            QMLog.d("MiniAppReportManager2", "new report (launchState is not exist): [subActionType = " + str + "], [reserves = " + str2 + "], [path = " + str3 + "]");
            return;
        }
        long j16 = updateLaunchState.launchTime - updateLaunchState.clickTime;
        long j17 = updateLaunchState.hideTime - updateLaunchState.showTime;
        if (QMLog.isDebugEnabled()) {
            QMLog.d("MiniAppReportManager2", "reportPageViewInMainProcess called with: launchId = [" + updateLaunchState.launchId + "],subActionType = [" + str + "],reserves = [" + str2 + "],launchduration = [" + j16 + "],showduration = [" + j17 + "],reportData = [" + miniAppInfo.launchParam.reportData + "],position = [" + miniAppInfo.position + "],slotId = [" + miniAppInfo.launchParam.slotId + "],via = [" + miniAppInfo.via + "],");
        }
        long j18 = updateLaunchState.loadTime;
        long j19 = updateLaunchState.clickTime;
        long j26 = j18 - j19;
        long j27 = updateLaunchState.loadEndTime - j19;
        int i18 = 1001;
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.via)) {
            if (TextUtils.equals(miniAppInfo.via, "3005_1")) {
                i18 = 3005;
            } else if (TextUtils.equals(miniAppInfo.via, "3043_1")) {
                i18 = 3043;
            }
            QMLog.d("MiniAppReportManager2", "new report link = " + miniAppInfo.link + " via = " + miniAppInfo.via);
        }
        int i19 = i18;
        if ("2back_key".equals(str) && updateLaunchState.needReportLaunchResult) {
            j3 = j17;
            report("page_view", "2show_fail", updateLaunchState.launchId, null, "back_cancel", String.valueOf(j16), updateLaunchState.hasPkgAndX5(), miniAppInfo);
            z16 = false;
            updateLaunchState.needReportLaunchResult = false;
        } else {
            j3 = j17;
            z16 = false;
        }
        if ("2close".equals(str) && updateLaunchState.needReportLaunchResult) {
            i3 = i19;
            z17 = z16;
            report("page_view", "2show_fail", updateLaunchState.launchId, null, "close_cancel", String.valueOf(j16), updateLaunchState.hasPkgAndX5(), miniAppInfo);
            updateLaunchState.needReportLaunchResult = z17;
        } else {
            i3 = i19;
            z17 = z16;
        }
        if ("2hide".equals(str)) {
            if (updateLaunchState.needReportLaunchResult) {
                str5 = "";
                report("page_view", "2show_fail", updateLaunchState.launchId, null, "home_cancel", String.valueOf(j16), updateLaunchState.hasPkgAndX5(), miniAppInfo);
                updateLaunchState.needReportLaunchResult = z17;
            } else {
                str5 = "";
            }
            if (miniAppInfo != null) {
                StringBuilder sb5 = new StringBuilder();
                LaunchParam launchParam2 = miniAppInfo.launchParam;
                if (launchParam2 != null) {
                    i17 = launchParam2.scene;
                } else {
                    i17 = i3;
                }
                sb5.append(i17);
                sb5.append(str5);
                String sb6 = sb5.toString();
                String str7 = updateLaunchState.launchId;
                String valueOf = String.valueOf(j3);
                if (isHalfMini(miniAppInfo)) {
                    str6 = "halfscreen";
                } else {
                    str6 = ReportConst.ACTION.FULLSCREEN;
                }
                SDKMiniProgramLpReportDC04239.reportWithR10(miniAppInfo, "page_view", str, str3, sb6, str7, str2, valueOf, null, str6, miniAppInfo.link, null);
            }
            AttaReporter.g("103", miniAppInfo, j3);
            doReportOld("page_view", str, updateLaunchState.launchId, str3, str2, null, updateLaunchState.hasPkgAndX5(), null, miniAppInfo);
            return;
        }
        if ("2launch_fail".equals(str)) {
            if (updateLaunchState.needReportLaunchResult) {
                report("page_view", "2show_fail", updateLaunchState.launchId, null, str2, String.valueOf(j16), updateLaunchState.hasPkgAndX5(), miniAppInfo);
                updateLaunchState.needReportLaunchResult = z17;
                return;
            }
            return;
        }
        if ("2launch".equals(str)) {
            if (updateLaunchState.needReportLaunchResult) {
                report("page_view", "2show", updateLaunchState.launchId, str3, str2, String.valueOf(j16), updateLaunchState.hasPkgAndX5(), miniAppInfo);
                updateLaunchState.needReportLaunchResult = z17;
            }
            if ("first_frame".equals(str2)) {
                report("page_view", "2show", updateLaunchState.launchId, str3, "first_frame_extend", String.valueOf(j16), updateLaunchState.hasPkgAndX5(), miniAppInfo);
                AttaReporter.g("118", miniAppInfo, 0L);
                return;
            }
            return;
        }
        if ("2load".equals(str)) {
            report("page_view", str, updateLaunchState.launchId, str3, str2, String.valueOf(j26), updateLaunchState.hasPkgAndX5(), miniAppInfo);
            return;
        }
        if ("2load_end".equals(str)) {
            report("page_view", str, updateLaunchState.launchId, str3, str2, String.valueOf(j27), updateLaunchState.hasPkgAndX5(), miniAppInfo);
            return;
        }
        if ("2show".equals(str)) {
            if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null && !TextUtils.isEmpty(launchParam.spkTaskKey)) {
                hashMap = new HashMap();
                hashMap.put("xinghuo_task_key", miniAppInfo.launchParam.spkTaskKey);
            } else {
                hashMap = null;
            }
            HashMap hashMap2 = hashMap;
            if (miniAppInfo != null) {
                StringBuilder sb7 = new StringBuilder();
                LaunchParam launchParam3 = miniAppInfo.launchParam;
                if (launchParam3 != null) {
                    i16 = launchParam3.scene;
                } else {
                    i16 = i3;
                }
                sb7.append(i16);
                sb7.append("");
                String sb8 = sb7.toString();
                String str8 = updateLaunchState.launchId;
                if (isHalfMini(miniAppInfo)) {
                    str4 = "halfscreen";
                } else {
                    str4 = ReportConst.ACTION.FULLSCREEN;
                }
                SDKMiniProgramLpReportDC04239.reportWithR10(miniAppInfo, "page_view", str, str3, sb8, str8, str2, null, null, str4, miniAppInfo.link, hashMap2);
                return;
            }
            return;
        }
        report("page_view", str, updateLaunchState.launchId, str3, str2, null, updateLaunchState.hasPkgAndX5(), miniAppInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void reportQualityColdStart(String str, MiniAppInfo miniAppInfo, String str2, String str3) {
        boolean z16;
        String str4;
        MiniAppStartState.updateState(str2, true);
        if (miniAppInfo.isEngineTypeMiniApp() && miniAppInfo.supportNativeRenderMode()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !MiniAppPrelaunchRecorder.get().isCheckinColdStart()) {
            return;
        }
        String reserve2 = getReserve2(str2, z16, MiniAppPrelaunchRecorder.get().isPrelaunchSuccess());
        AppStateManager appStateManager = getAppStateManager(miniAppInfo);
        String reserve3 = getReserve3(miniAppInfo, str2, appStateManager);
        if (MiniAppStartState.getBaseLibDownload(str2) == 1 && appStateManager != null) {
            QMLog.i("MiniAppReportManager2", "check prelaunch  hasPreloadCompleted:" + appStateManager.hasPreloadCompleted + "   isFromPrelaunch:" + appStateManager.isFromPrelaunch);
            if (appStateManager.hasPreloadCompleted && appStateManager.isFromPrelaunch) {
                str4 = VALUE_SERVICE_PRELAUNCH;
                MiniReportManager.reportEventType(miniAppInfo, 2, str, null, null, 0, str3, 0L, null, MiniAppStartState.getBaseLibDownloadDesc(str2), reserve2, str4, "cold_start");
                if (!z16) {
                    MiniAppStartState.reset(str2, true);
                    return;
                }
                return;
            }
        }
        str4 = reserve3;
        MiniReportManager.reportEventType(miniAppInfo, 2, str, null, null, 0, str3, 0L, null, MiniAppStartState.getBaseLibDownloadDesc(str2), reserve2, str4, "cold_start");
        if (!z16) {
        }
    }

    private static void reportQulaityResult(String str, String str2, String str3, MiniAppInfo miniAppInfo) {
        String str4;
        String str5;
        String baselibLoadDesc;
        boolean z16;
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
            str4 = miniAppInfo.appId;
        } else {
            str4 = "";
        }
        if (miniAppInfo != null) {
            if (miniAppInfo.isReportTypeMiniGame()) {
                str5 = "1";
            } else {
                str5 = "0";
            }
            String str6 = str5;
            if (miniAppInfo.isReportTypeMiniGame()) {
                baselibLoadDesc = MiniAppStartState.getProcessLoadDesc(str4);
            } else {
                baselibLoadDesc = MiniAppStartState.getBaselibLoadDesc(str4);
            }
            String str7 = baselibLoadDesc;
            if ("2launch_fail".equals(str)) {
                reportLaunchFail(str2, str3, miniAppInfo, str4, str6, str7);
                return;
            }
            if ("2launch".equals(str) && "first_frame".equals(str2)) {
                reportQualityColdStart(str3, miniAppInfo, str4, str6);
                return;
            }
            if ("2launch".equals(str) && "click_resume".equals(str2)) {
                if (miniAppInfo.isEngineTypeMiniApp() && miniAppInfo.supportNativeRenderMode()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    MiniAppStartState.reset(str4, true);
                }
                if (MiniAppStartState.getPageSwitch(str4) != 1) {
                    MiniReportManager.reportEventType(miniAppInfo, 2, str3, null, null, 0, str6, 0L, null, MiniAppStartState.getBaseLibDownloadDesc(str4), MiniAppStartState.getApkgDownloadDesc(str4), str7, "hot_start");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportTimeout(AppLaunchState appLaunchState) {
        String str;
        appLaunchState.launchResult = 2;
        long j3 = appLaunchState.hideTime;
        long j16 = appLaunchState.clickTime;
        long j17 = j3 - j16;
        if (j17 <= 0) {
            j17 = j16 - System.currentTimeMillis();
        }
        String timeOutCode = getTimeOutCode(j17);
        if (appLaunchState.needReportLaunchResult) {
            MiniAppInfo miniAppInfo = new MiniAppInfo();
            miniAppInfo.appId = appLaunchState.appId;
            try {
                miniAppInfo.verType = appLaunchState.verType;
                miniAppInfo.setEngineType(appLaunchState.engineType);
                miniAppInfo.setReportType(appLaunchState.reportType);
            } catch (NumberFormatException unused) {
            }
            if (appLaunchState.loadTime == 0) {
                str = "2load_fail";
            } else {
                str = "2show_fail";
            }
            report("page_view", str, appLaunchState.launchId, null, timeOutCode, String.valueOf(j17), appLaunchState.hasPkgAndX5(), miniAppInfo);
            appLaunchState.needReportLaunchResult = false;
            appLaunchState.launchResult = 2;
            saveLaunchStates();
        }
    }

    private static void saveLaunchStates() {
        SharedPreferences.Editor edit = AppLoaderFactory.g().getContext().getSharedPreferences("MiniAppLaunshState", 4).edit();
        edit.clear();
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<String, AppLaunchState> entry : launchStateMap.entrySet()) {
            String key = entry.getKey();
            AppLaunchState value = entry.getValue();
            if (value.launchResult == 0) {
                sb5.append(key);
                sb5.append(',');
                edit.putString(key, value.toJson());
            }
        }
        edit.putString("appid", sb5.toString());
        edit.apply();
    }

    public static void setCrashReportAppInfo(String str, MiniAppInfo miniAppInfo) {
        if ("2show".equals(str) && miniAppInfo != null) {
            ((IMiniReportProxy) ProxyManager.get(IMiniReportProxy.class)).setMiniAppInfo(miniAppInfo.appId + "|" + miniAppInfo.name + "|" + miniAppInfo.versionId + "|" + miniAppInfo.verType + "|" + miniAppInfo.engineType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setTimeOutForLaunch() {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        Handler handler2 = handler;
        if (handler2 != null && !timerEnable) {
            handler2.postDelayed(launchTimeoutRunnable, LAUNCH_TIME_OUT);
            timerEnable = true;
        }
    }

    public static void stopTimeOutForLaunch() {
        timerEnable = false;
        Handler handler2 = handler;
        if (handler2 != null) {
            handler2.removeCallbacks(launchTimeoutRunnable);
        }
    }

    private static AppLaunchState updateLaunchState(String str, String str2, String str3, MiniAppInfo miniAppInfo) {
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z16 = false;
            if (first) {
                first = false;
                loadLaunchStates();
                launchTimeoutRunnable.run();
            }
            AppLaunchState appLaunchState = launchStateMap.get(miniAppInfo.appId);
            if (appLaunchState == null) {
                appLaunchState = new AppLaunchState();
                appLaunchState.launchId = String.valueOf(currentTimeMillis);
                launchStateMap.put(miniAppInfo.appId, appLaunchState);
            }
            appLaunchState.appId = miniAppInfo.appId;
            appLaunchState.engineType = miniAppInfo.getEngineType();
            appLaunchState.reportType = miniAppInfo.getReportType();
            appLaunchState.verType = miniAppInfo.verType;
            appLaunchState.activeTime = currentTimeMillis;
            if ("2click".equals(str)) {
                if (appLaunchState.launchResult != 0) {
                    appLaunchState.launchId = String.valueOf(currentTimeMillis);
                }
                appLaunchState.reset();
                setTimeOutForLaunch();
                appLaunchState.clickTime = currentTimeMillis;
                if (!AppLaunchState.hasX5) {
                    if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getTbsVersion() > 0) {
                        z16 = true;
                    }
                    AppLaunchState.hasX5 = z16;
                }
                appLaunchState.hasPkg = ApkgManager.pkgExists(miniAppInfo);
                appLaunchState.flutterMode = true;
                saveLaunchStates();
            }
            if (appLaunchState.launchResult != 0 && "2show".equals(str) && "bring_to_front".equals(str2)) {
                appLaunchState.reset();
                setTimeOutForLaunch();
                appLaunchState.clickTime = currentTimeMillis;
                saveLaunchStates();
            }
            if ("2load".equals(str)) {
                appLaunchState.loadTime = currentTimeMillis;
            }
            if ("2load_end".equals(str)) {
                appLaunchState.loadEndTime = currentTimeMillis;
            }
            if (appLaunchState.launchResult == 0 && "2launch".equals(str)) {
                appLaunchState.launchTime = currentTimeMillis;
                appLaunchState.launchResult = 1;
                appLaunchState.needReportLaunchResult = true;
                saveLaunchStates();
            }
            if (appLaunchState.launchResult == 0 && ("2launch_fail".equals(str) || "2close".equals(str) || "2back_key".equals(str) || "2hide".equals(str))) {
                appLaunchState.launchTime = currentTimeMillis;
                appLaunchState.launchResult = 2;
                appLaunchState.needReportLaunchResult = true;
                saveLaunchStates();
            }
            if ("2show".equals(str)) {
                appLaunchState.showTime = currentTimeMillis;
                appLaunchState.hideTime = 0L;
            }
            if ("2hide".equals(str)) {
                appLaunchState.hideTime = currentTimeMillis;
            }
            if ("2unload".equals(str)) {
                launchStateMap.remove(miniAppInfo.appId);
            }
            if (QMLog.isDebugEnabled()) {
                QMLog.d("MiniAppReportManager2", "launchState: launchId = [" + appLaunchState.launchId + "], launchResult = [" + appLaunchState.launchResult + "], clickTime = [" + appLaunchState.clickTime + "], launchTime = [" + appLaunchState.launchTime + "], showTime = [" + appLaunchState.showTime + "], hideTime = [" + appLaunchState.hideTime + "]");
            }
            return appLaunchState;
        }
        QMLog.d("MiniAppReportManager2", "new report (appId is null)");
        return null;
    }

    private static void report(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<String, String> map, MiniAppInfo miniAppInfo) {
        ArrayList arrayList;
        LaunchParam launchParam;
        int i3;
        doReportOld(str, str2, str3, str4, str5, str6, str7, map, miniAppInfo);
        String appType = getAppType(miniAppInfo);
        if (QMLog.isDebugEnabled()) {
            QMLog.d("MiniAppReportManager2", "reportPageViewInMainProcess new report called with: [launchId = " + str3 + "], [subActionType = " + str2 + "], [appType = " + appType + "], [reserves = " + str5 + "], [reserves2 = " + str6 + "], [reserves3 = " + str7 + "], [path =" + str4 + "]], [reportData = " + miniAppInfo.launchParam.reportData + "], [position = " + miniAppInfo.position + "], [slotId = " + miniAppInfo.launchParam.slotId + "], [via = " + miniAppInfo.via);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList2.addAll(MiniProgramReportHelper.newBusinessEntries(miniAppInfo, AppBrandUtil.getUrlWithoutParams(str4), (miniAppInfo == null || (launchParam = miniAppInfo.launchParam) == null) ? null : String.valueOf(launchParam.scene), str, str2, str5, str6, str7, (miniAppInfo == null || (i3 = miniAppInfo.tianshuAdId) == 0) ? null : String.valueOf(i3), null, null, appType, str3));
        arrayList2.addAll(MiniProgramReportHelper.newGenericEntries());
        if (!QUAUtil.isQQApp()) {
            arrayList2.addAll(MiniProgramReportHelper.newThirdSourceEntries());
            if (miniAppInfo != null) {
                arrayList2.add(MiniProgramReportHelper.newEntry("customInfo", miniAppInfo.customInfo));
            }
        }
        if (!(map != null && map.containsKey(KEY_SLOT_ID)) && miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.launchParam.slotId)) {
            arrayList2.add(MiniProgramReportHelper.newEntry(KEY_SLOT_ID, miniAppInfo.launchParam.slotId));
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList2.add(MiniProgramReportHelper.newEntry(entry.getKey(), entry.getValue()));
            }
        }
        if (WnsConfig.getConfig("qqminiapp", "mini_app_report_first_frame_flush", 1) == 1) {
            arrayList = arrayList2;
            if (isNeedFlush(str2, str5)) {
                MiniProgramReporter.getInstance().setReportLaunchNeedflush(true);
            }
        } else {
            arrayList = arrayList2;
        }
        MiniProgramReporter.getInstance().addDcData(MiniProgramReportHelper.newSingleReportData((QUAUtil.isQQApp() || QUAUtil.isMicroApp()) ? 2 : 12, arrayList, null));
    }
}
