package com.tencent.mobileqq.mini.report;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppReportManager2 {
    public static final String KEY_ACTION_TYPE = "action_type";
    public static final String KEY_APP_CONFIG = "app_config";
    public static final String KEY_APP_TYPE = "app_type";
    public static final String KEY_PATH = "path";
    public static final String KEY_RESERVES = "reserves";
    public static final String KEY_SUB_ACTION = "sub_action";
    public static final String PAGE_VIEW_ACTION = "page_view";
    public static final String TAG = "MiniAppReportManager2";
    private static boolean first;
    private static Handler handler;
    public static final boolean isMainProcess;
    public static HashMap<String, Integer> lanchFailCode;
    private static Runnable launchTimeoutRunnable;
    private static boolean timerEnable;
    public static final long LAUNCH_TIME_OUT = GameWnsUtils.getShowTimeout();
    public static HashMap<String, AppLaunchState> launchStateMap = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes33.dex */
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
    /* loaded from: classes33.dex */
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
    /* loaded from: classes33.dex */
    public static class ReportBackKeyReserve {
        public static final String CODE_INNER_PAGE = "inner_page";
        public static final String CODE_LOADING_PAGE = "loading_page";
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class ReportCloseReserve {
        public static final String CODE_INNER_PAGE = "inner_page";
        public static final String CODE_LOADING_PAGE = "loading_page";
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class ReportShowReserve {
        public static final String CODE_BRING_TO_FRONT = "bring_to_front";
        public static final String CODE_CHANGE_PAGE = "switch_page";
        public static final String CODE_CLICK_RESUME = "click_resume";
        public static final String CODE_FIRST_FRAME = "first_frame";
    }

    static {
        isMainProcess = MobileQQ.sProcessId == 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        lanchFailCode = hashMap;
        hashMap.put("load_baselib_fail", 402);
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
        first = true;
        launchTimeoutRunnable = new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniAppReportManager2.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z16 = false;
                try {
                    MiniAppReportManager2.timerEnable = false;
                    long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
                    for (Map.Entry<String, AppLaunchState> entry : MiniAppReportManager2.launchStateMap.entrySet()) {
                        entry.getKey();
                        AppLaunchState value = entry.getValue();
                        if (value.launchResult == 0 && serverTimeMillis - value.activeTime > MiniAppReportManager2.LAUNCH_TIME_OUT) {
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
                    QLog.e("MiniAppReportManager2", 2, "", th5);
                }
            }
        };
        timerEnable = false;
        handler = null;
    }

    private static String getAppType(MiniAppConfig miniAppConfig) {
        if (miniAppConfig == null || !miniAppConfig.isReportTypeMiniGame()) {
            return "0";
        }
        return "1";
    }

    private static void loadLaunchStates() {
        String string;
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("MiniAppLaunshState", 4);
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

    public static boolean needReportData(String str, MiniAppConfig miniAppConfig) {
        return true;
    }

    private static void reportPageViewInMainProcess(String str, String str2, String str3, MiniAppConfig miniAppConfig) {
        AppLaunchState updateLaunchState = updateLaunchState(str, str2, str3, miniAppConfig);
        if (updateLaunchState == null) {
            QLog.d("MiniAppReportManager2", 2, "new report (launchState is not exist): [subActionType = " + str + "], [reserves = " + str2 + "], [path = " + str3 + "]");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppReportManager2", 2, "reportPageViewInMainProcess called with: launchId = [" + updateLaunchState.launchId + "], subActionType = [" + str + "], reserves = [" + str2 + "], path = [" + str3 + "]");
        }
        long j3 = updateLaunchState.launchTime;
        long j16 = updateLaunchState.clickTime;
        long j17 = j3 - j16;
        long j18 = updateLaunchState.hideTime - updateLaunchState.showTime;
        long j19 = updateLaunchState.loadTime - j16;
        long j26 = updateLaunchState.loadEndTime - j16;
        if ("2back_key".equals(str) && updateLaunchState.needReportLaunchResult) {
            report("page_view", "2show_fail", updateLaunchState.launchId, null, "back_cancel", String.valueOf(j17), updateLaunchState.hasPkgAndX5(), miniAppConfig);
            updateLaunchState.needReportLaunchResult = false;
        }
        if ("2close".equals(str) && updateLaunchState.needReportLaunchResult) {
            report("page_view", "2show_fail", updateLaunchState.launchId, null, "close_cancel", String.valueOf(j17), updateLaunchState.hasPkgAndX5(), miniAppConfig);
            updateLaunchState.needReportLaunchResult = false;
        }
        if ("2hide".equals(str)) {
            if (updateLaunchState.needReportLaunchResult) {
                report("page_view", "2show_fail", updateLaunchState.launchId, null, "home_cancel", String.valueOf(j17), updateLaunchState.hasPkgAndX5(), miniAppConfig);
                updateLaunchState.needReportLaunchResult = false;
            }
            report("page_view", str, updateLaunchState.launchId, str3, null, str2, String.valueOf(j18), miniAppConfig);
            QLog.e("MiniAppReportManager2", 1, "2hide: cost:" + str2 + "  duration:" + j18);
            return;
        }
        if ("2launch_fail".equals(str)) {
            if (updateLaunchState.needReportLaunchResult) {
                report("page_view", "2show_fail", updateLaunchState.launchId, null, str2, String.valueOf(j17), updateLaunchState.hasPkgAndX5(), miniAppConfig);
                updateLaunchState.needReportLaunchResult = false;
                return;
            }
            return;
        }
        if ("2launch".equals(str)) {
            if (updateLaunchState.needReportLaunchResult) {
                report("page_view", "2show", updateLaunchState.launchId, str3, str2, String.valueOf(j17), updateLaunchState.hasPkgAndX5(), miniAppConfig);
                updateLaunchState.needReportLaunchResult = false;
            }
            if ("first_frame".equals(str2)) {
                report("page_view", "2show", updateLaunchState.launchId, str3, "first_frame_extend", String.valueOf(j17), updateLaunchState.hasPkgAndX5(), miniAppConfig);
                return;
            }
            return;
        }
        if ("2load".equals(str)) {
            report("page_view", str, updateLaunchState.launchId, str3, str2, String.valueOf(j19), updateLaunchState.hasPkgAndX5(), miniAppConfig);
        } else if ("2load_end".equals(str)) {
            report("page_view", str, updateLaunchState.launchId, str3, str2, String.valueOf(j26), updateLaunchState.hasPkgAndX5(), miniAppConfig);
        } else {
            report("page_view", str, updateLaunchState.launchId, str3, str2, null, updateLaunchState.hasPkgAndX5(), miniAppConfig);
        }
    }

    private static void saveLaunchStates() {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("MiniAppLaunshState", 4).edit();
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
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setTimeOutForLaunch() {
        if (QLog.isColorLevel()) {
            QLog.i("MiniAppReportManager2", 2, "setTimeOut for launch");
        }
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        Handler handler2 = handler;
        if (handler2 == null || timerEnable) {
            return;
        }
        handler2.postDelayed(launchTimeoutRunnable, LAUNCH_TIME_OUT);
        timerEnable = true;
    }

    public static void stopTimeOutForLaunch() {
        if (QLog.isColorLevel()) {
            QLog.i("MiniAppReportManager2", 2, "stopTimeOut for report timeout");
        }
        timerEnable = false;
        Handler handler2 = handler;
        if (handler2 != null) {
            handler2.removeCallbacks(launchTimeoutRunnable);
        }
    }

    private static AppLaunchState updateLaunchState(String str, String str2, String str3, MiniAppConfig miniAppConfig) {
        MiniAppInfo miniAppInfo;
        if (miniAppConfig != null && (miniAppInfo = miniAppConfig.config) != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            if (first) {
                first = false;
                loadLaunchStates();
                launchTimeoutRunnable.run();
            }
            AppLaunchState appLaunchState = launchStateMap.get(miniAppConfig.config.appId);
            if (appLaunchState == null) {
                appLaunchState = new AppLaunchState();
                appLaunchState.launchId = String.valueOf(serverTimeMillis);
                launchStateMap.put(miniAppConfig.config.appId, appLaunchState);
            }
            MiniAppInfo miniAppInfo2 = miniAppConfig.config;
            appLaunchState.appId = miniAppInfo2.appId;
            appLaunchState.engineType = miniAppInfo2.getEngineType();
            appLaunchState.reportType = miniAppConfig.config.getReportType();
            appLaunchState.verType = miniAppConfig.config.verType;
            appLaunchState.activeTime = serverTimeMillis;
            if ("2click".equals(str)) {
                if (appLaunchState.launchResult != 0) {
                    appLaunchState.launchId = String.valueOf(serverTimeMillis);
                }
                appLaunchState.reset();
                setTimeOutForLaunch();
                appLaunchState.clickTime = serverTimeMillis;
                if (!AppLaunchState.hasX5) {
                    AppLaunchState.hasX5 = QbSdk.getTbsVersion(BaseApplication.getContext()) > 0 || QbSdk.getTmpDirTbsVersion(BaseApplication.getContext()) > 0;
                }
                appLaunchState.hasPkg = ApkgManager.pkgExists(miniAppConfig.config);
                appLaunchState.flutterMode = miniAppConfig.isSdkMode;
                saveLaunchStates();
            }
            if (appLaunchState.launchResult != 0 && "2show".equals(str) && "bring_to_front".equals(str2)) {
                appLaunchState.reset();
                setTimeOutForLaunch();
                appLaunchState.clickTime = serverTimeMillis;
                saveLaunchStates();
            }
            if ("2load".equals(str)) {
                appLaunchState.loadTime = serverTimeMillis;
            }
            if ("2load_end".equals(str)) {
                appLaunchState.loadEndTime = serverTimeMillis;
            }
            if (appLaunchState.launchResult == 0 && "2launch".equals(str)) {
                appLaunchState.launchTime = serverTimeMillis;
                appLaunchState.launchResult = 1;
                appLaunchState.needReportLaunchResult = true;
                saveLaunchStates();
            }
            if (appLaunchState.launchResult == 0 && ("2launch_fail".equals(str) || "2close".equals(str) || "2back_key".equals(str) || "2hide".equals(str))) {
                appLaunchState.launchTime = serverTimeMillis;
                appLaunchState.launchResult = 2;
                appLaunchState.needReportLaunchResult = true;
                saveLaunchStates();
            }
            if ("2show".equals(str)) {
                appLaunchState.showTime = serverTimeMillis;
                appLaunchState.hideTime = 0L;
            }
            if ("2hide".equals(str)) {
                appLaunchState.hideTime = serverTimeMillis;
            }
            if ("2unload".equals(str)) {
                launchStateMap.remove(miniAppConfig.config.appId);
            }
            if (QLog.isColorLevel()) {
                QLog.d("MiniAppReportManager2", 2, "launchState: launchId = [" + appLaunchState.launchId + "], launchResult = [" + appLaunchState.launchResult + "], clickTime = [" + appLaunchState.clickTime + "], launchTime = [" + appLaunchState.launchTime + "], showTime = [" + appLaunchState.showTime + "], hideTime = [" + appLaunchState.hideTime + "]");
            }
            return appLaunchState;
        }
        QLog.d("MiniAppReportManager2", 2, "new report (appId is null)");
        return null;
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
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
            String str2;
            StringBuilder sb5 = new StringBuilder();
            String str3 = "";
            if (!this.flutterMode) {
                str = "";
            } else {
                str = "flutterMode_";
            }
            sb5.append(str);
            if (!hasX5) {
                str2 = "";
            } else {
                str2 = "hasX5";
            }
            sb5.append(str2);
            if (this.hasPkg) {
                str3 = "_hasPkg";
            }
            sb5.append(str3);
            return sb5.toString();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportTimeout(AppLaunchState appLaunchState) {
        String str;
        appLaunchState.launchResult = 2;
        long j3 = appLaunchState.hideTime;
        long j16 = appLaunchState.clickTime;
        long j17 = j3 - j16;
        if (j17 <= 0) {
            j17 = j16 - NetConnInfoCenter.getServerTimeMillis();
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
            MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
            if (appLaunchState.loadTime == 0) {
                str = "2load_fail";
            } else {
                str = "2show_fail";
            }
            report("page_view", str, appLaunchState.launchId, null, timeOutCode, String.valueOf(j17), appLaunchState.hasPkgAndX5(), miniAppConfig);
            appLaunchState.needReportLaunchResult = false;
            appLaunchState.launchResult = 2;
            saveLaunchStates();
        }
    }

    private static String getTimeOutCode(long j3) {
        if (j3 < 0) {
            return "timeout-1";
        }
        if (j3 >= 15000) {
            if (j3 < s.G) {
                return "timeout_25";
            }
            return "timeout";
        }
        return "timeout_" + Math.round((float) (j3 / 1000));
    }

    private static void report(String str, String str2, String str3, String str4, String str5, String str6, String str7, MiniAppConfig miniAppConfig) {
        LaunchParam launchParam;
        String appType = getAppType(miniAppConfig);
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppReportManager2", 2, "reportPageViewInMainProcess  new report called with: [launchId = " + str3 + "], [subActionType = " + str2 + "], [appType = " + appType + "], [reserves = " + str5 + "], [reserves2 = " + str6 + "], [reserves3 = " + str7 + "], [path =" + str4 + "]");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newBusinessEntries(miniAppConfig, AppBrandUtil.getUrlWithoutParams(str4), (miniAppConfig == null || (launchParam = miniAppConfig.launchParam) == null) ? null : String.valueOf(launchParam.scene), str, str2, str5, str6, str7, null, null, null, null, null, appType, str3));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        MiniProgramReporter.getInstance().addDcData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
        if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_report_first_frame_flush", 1) == 1 && "2show".equals(str2) && "first_frame".equals(str5)) {
            MiniProgramReporter.getInstance().setReportLaunchNeedflush(true);
        }
    }

    public static void reportPageView(final String str, final String str2, final String str3, final MiniAppConfig miniAppConfig) {
        String str4;
        String str5;
        String baselibLoadDesc;
        String baselibLoadDesc2;
        String baselibLoadDesc3;
        MiniAppInfo miniAppInfo;
        try {
            if (isMainProcess) {
                reportPageViewInMainProcess(str, str2, str3, miniAppConfig);
                return;
            }
            MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniAppReportManager2.1
                @Override // java.lang.Runnable
                public void run() {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("app_config", MiniAppConfig.this);
                    bundle.putString("action_type", "page_view");
                    bundle.putString("sub_action", str);
                    bundle.putString("path", str3);
                    bundle.putString("reserves", str2);
                    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "launch_report2", bundle);
                }
            });
            boolean isReportTypeMiniGame = miniAppConfig == null ? false : miniAppConfig.isReportTypeMiniGame();
            if (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null || TextUtils.isEmpty(miniAppInfo.appId)) {
                str5 = "";
            } else {
                str5 = miniAppConfig.config.appId;
            }
            String str6 = "1";
            try {
                if (!"2launch_fail".equals(str)) {
                    str4 = "";
                    if ("2launch".equals(str) && "first_frame".equals(str2)) {
                        MiniAppStartState.updateState(str5, true);
                        if (!isReportTypeMiniGame) {
                            str6 = "0";
                        }
                        String baseLibDownloadDesc = MiniAppStartState.getBaseLibDownloadDesc(str5);
                        String apkgDownloadDesc = MiniAppStartState.getApkgDownloadDesc(str5);
                        if (isReportTypeMiniGame) {
                            baselibLoadDesc2 = MiniAppStartState.getProcessLoadDesc(str5);
                        } else {
                            baselibLoadDesc2 = MiniAppStartState.getBaselibLoadDesc(str5);
                        }
                        MiniReportManager.reportEventType(miniAppConfig, 2, str3, null, null, 0, str6, 0L, null, baseLibDownloadDesc, apkgDownloadDesc, baselibLoadDesc2, "cold_start");
                    } else if ("2launch".equals(str) && "click_resume".equals(str2)) {
                        MiniAppStartState.reset(str5, true);
                        if (MiniAppStartState.getPageSwitch(str5) != 1) {
                            if (!isReportTypeMiniGame) {
                                str6 = "0";
                            }
                            String baseLibDownloadDesc2 = MiniAppStartState.getBaseLibDownloadDesc(str5);
                            String apkgDownloadDesc2 = MiniAppStartState.getApkgDownloadDesc(str5);
                            if (isReportTypeMiniGame) {
                                baselibLoadDesc = MiniAppStartState.getProcessLoadDesc(str5);
                            } else {
                                baselibLoadDesc = MiniAppStartState.getBaselibLoadDesc(str5);
                            }
                            MiniReportManager.reportEventType(miniAppConfig, 2, str3, null, null, 0, str6, 0L, null, baseLibDownloadDesc2, apkgDownloadDesc2, baselibLoadDesc, "hot_start");
                        }
                    }
                } else {
                    Integer num = lanchFailCode.get(str2);
                    if (num == null) {
                        num = 401;
                    }
                    int intValue = num.intValue();
                    if (!isReportTypeMiniGame) {
                        str6 = "0";
                    }
                    String baseLibDownloadDesc3 = MiniAppStartState.getBaseLibDownloadDesc(str5);
                    String apkgDownloadDesc3 = MiniAppStartState.getApkgDownloadDesc(str5);
                    if (isReportTypeMiniGame) {
                        baselibLoadDesc3 = MiniAppStartState.getProcessLoadDesc(str5);
                    } else {
                        baselibLoadDesc3 = MiniAppStartState.getBaselibLoadDesc(str5);
                    }
                    str4 = "";
                    MiniReportManager.reportEventType(miniAppConfig, 2, str3, null, null, intValue, str6, 0L, null, baseLibDownloadDesc3, apkgDownloadDesc3, baselibLoadDesc3, MiniAppStartState.getPageSwitchDesc(str5));
                }
                if (miniAppConfig == null || miniAppConfig.config == null || !"2unload".equals(str)) {
                    return;
                }
                MiniAppStartState.removeState(miniAppConfig.config.appId);
            } catch (Throwable th5) {
                th = th5;
                QLog.e("MiniAppReportManager2", 2, str4, th);
            }
        } catch (Throwable th6) {
            th = th6;
            str4 = "";
        }
    }
}
