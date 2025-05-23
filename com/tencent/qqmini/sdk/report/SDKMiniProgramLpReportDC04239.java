package com.tencent.qqmini.sdk.report;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.entry.MiniAppExposureManager;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.EnvUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class SDKMiniProgramLpReportDC04239 {
    public static final String AD_ACTION = "ad";
    public static final String AD_RESERVES_CLICK = "click";
    public static final String AD_RESERVES_CLICK_BAR = "click_bar";
    public static final String AD_RESERVES_EXPO_CALL = "expo_call";
    public static final String AD_RESERVES_EXPO_SUCC = "expo_success";
    public static final String AD_RESERVES_PRELOAD_CALL = "preload_call";
    public static final String AD_RESERVES_PRELOAD_FAIL = "preload_fail";
    public static final String AD_RESERVES_PRELOAD_SUCC = "preload_success";
    public static final String AD_RESERVES_REQUEAST_SUCCESS_REALTIME = "request_success_realtime";
    public static final String AD_RESERVES_REQUEST_CALL_CNT = "request_call_cnt";
    public static final String AD_RESERVES_REQUEST_SHIELD = "request_shield";
    public static final String AD_RESERVES_REQUEST_SUCC_OFFLINE = "request_success_offline";
    public static final String AD_RESERVES_REQUEST_SUCC_ONLINE = "request_success_online";
    public static final String AD_RESERVES_REQUEST_TIMEOUT = "request_timeout";
    public static final String AD_RESERVES_SKIP = "skip";
    public static final String AD_RESERVES_SPEC_DOWNLOAD_FAIL = "spec_download_fail";
    public static final String AD_RESERVES_SPEC_DOWNLOAD_SUCCESS = "spec_download_success";
    public static final String AD_RESERVES_SPEC_DOWNLOAD_TIMEOUT = "spec_download_timeout";
    public static final String AD_SUB_ACTION_LOADING_AD = "ad_loading";
    public static final String APP_TYPE_MINI_APP = "0";
    public static final String APP_TYPE_MINI_GAME = "1";
    public static final String ARK_ACTION = "ark";
    public static final String ARK_SUB_ACTION_BATTLE = "ark_battle";
    public static final String BUFFER_ACTION = "buffer_space";
    public static final String DESKTOP_ACTION = "desktop";
    public static final String DROP_DOWN_ACTION = "drop_down";
    public static final String DROP_DOWN_RESERVERS_DELETE = "delete";
    public static final String DROP_DOWN_RESERVERS_SETTOP_OFF = "settop_off";
    public static final String DROP_DOWN_RESERVERS_SETTOP_ON = "settop_on";
    public static final String DROP_DOWN_SUB_ACTION_CONTACT = "contact";
    public static final String DROP_DOWN_SUB_ACTION_MESSAGE = "message";
    public static final String DROP_DOWN_SUB_ACTION_MORE = "more";
    public static final String GAME_INNER_ACTION = "game_inner";
    public static final String INNER_SUB_ACTION_LOGIN = "login";
    public static final String INNER_SUB_ACTION_REGISTER = "regist";
    public static final String KEY_ACTION_TYPE = "actiontype";
    public static final String KEY_RESERVES_ACTION = "reserves_action";
    public static final String KEY_SUB_ACTION_TYPE = "sub_actiontype";
    public static final String MORE_ABOUT_RESERVERS_FEEDBACK = "feedback";
    public static final String MORE_ABOUT_RESERVERS_LAUNCH = "launch";
    public static final String MORE_ABOUT_RESERVERS_LIKE_OFF = "like_off";
    public static final String MORE_ABOUT_RESERVERS_LIKE_ON = "like_on";
    public static final String MORE_ABOUT_RESERVERS_PROFILE = "profile";
    public static final String MORE_ABOUT_RESERVERS_REPORT = "report";
    public static final String MORE_ABOUT_RESERVERS_SET = "set";
    public static final String MORE_ABOUT_RESERVERS_SETTOP_OFF = "settop_off";
    public static final String MORE_ABOUT_RESERVERS_SETTOP_ON = "settop_on";
    public static final String MORE_ABOUT_RESERVERS_SHARE = "share";
    public static final String MORE_BUTTON_RESERVERS_ABOUT = "about";
    public static final String MORE_BUTTON_RESERVERS_BACK_HOME = "back_home";
    public static final String MORE_BUTTON_RESERVERS_CANCEL = "cancel";
    public static final String MORE_BUTTON_RESERVERS_CANCEL_SYSTEM = "cancel_system";
    public static final String MORE_BUTTON_RESERVERS_MESSAGE = "message";
    public static final String MORE_BUTTON_RESERVERS_OPEN = "open";
    public static final String MORE_BUTTON_RESERVERS_QQ_FAVORITES = "qq_favorites";
    public static final String MORE_BUTTON_RESERVERS_SETTOP_OFF = "settop_off";
    public static final String MORE_BUTTON_RESERVERS_SETTOP_ON = "settop_on";
    public static final String MORE_BUTTON_RESERVERS_SHARE_MOMENTS = "share_Moments";
    public static final String MORE_BUTTON_RESERVERS_SHARE_OTHER = "share_";
    public static final String MORE_BUTTON_RESERVERS_SHARE_QQ = "share_QQ";
    public static final String MORE_BUTTON_RESERVERS_SHARE_QZ = "share_QZ";
    public static final String MORE_BUTTON_RESERVERS_SHARE_WX = "share_WX";
    public static final String MORE_BUTTON_RESERVERS_SHORTCUT = "add_desktop";
    public static final String PAGE_VIEW_ACTION = "page_view";
    public static final String PAGE_VIEW_SUB_ACTION_CLICK = "click";
    public static final String PAGE_VIEW_SUB_ACTION_CLOSE = "close";
    public static final String PAGE_VIEW_SUB_ACTION_EM_CLICK = "em_click";
    public static final String PAGE_VIEW_SUB_ACTION_EM_EXPO = "em_expo";
    public static final String PAGE_VIEW_SUB_ACTION_EXPO = "expo";
    public static final String PAGE_VIEW_SUB_ACTION_FINISHSHOW = "finishshow";
    public static final String PAGE_VIEW_SUB_ACTION_GAME_ON = "gameon";
    public static final String PAGE_VIEW_SUB_ACTION_HIDE = "hide";
    public static final String PAGE_VIEW_SUB_ACTION_LOAD = "load";
    public static final String PAGE_VIEW_SUB_ACTION_LOAD_FAIL = "load_fail";
    public static final String PAGE_VIEW_SUB_ACTION_SHOW = "show";
    public static final String PAGE_VIEW_SUB_ACTION_SHOW_FAIL = "show_fail";
    public static final String PAGE_VIEW_SUB_ACTION_UNLOAD = "unload";
    public static final String PAY_WX_ACTION = "wechat_pay";
    public static final String PAY_WX_SUB_ACTION_LAUNCH = "launch_wechatpay";
    public static final String RESERVERS_GAME_TIME_LOAD_POP = "load_timeout_popwindow";
    public static final String SCOPE_ACTION = "scope";
    public static final String SHARE_ALERT_RESERVERS_ACTION = "show";
    public static final String SYS_ALERT_ACTION = "sys_alert";
    private static final String TAG = "MiniProgramLpReportDC04239";
    public static final String USER_CLICK_ACTION = "user_click";
    public static final String USER_CLICK_SUB_ACTION_MORE_ABOUT = "more_about";
    public static final String USER_CLICK_SUB_ACTION_MORE_BUTTON = "more_button";
    public static final String USER_CLICK_SUB_ACTION_SHARE_ALERT = "share_alert";
    private static long mRecordDurationInterval = 5000;
    private static Runnable recordDurationRunnable = new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.1
        @Override // java.lang.Runnable
        public void run() {
            if (SDKMiniProgramLpReportDC04239.showMiniAppConfig != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("app_config", SDKMiniProgramLpReportDC04239.showMiniAppConfig);
                bundle.putLong("add_duration_ms", SDKMiniProgramLpReportDC04239.mRecordDurationInterval);
                AppBrandCmdProxy.g().sendCmd("record_duration", bundle, null);
                SDKMiniProgramLpReportDC04239.sendRecordDurationMsg();
            }
        }
    };
    private static MiniAppInfo showMiniAppConfig;

    SDKMiniProgramLpReportDC04239() {
    }

    public static void deleteRecordDurationMsg() {
        if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
            QMLog.i(TAG, "deleteRecordDurationMsg");
        }
        MiniProgramReporter.getInstance().getReportHandler().removeCallbacks(recordDurationRunnable);
    }

    public static void exposureReport(final List<MiniAppExposureManager.BaseExposureReport> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.18
            @Override // java.lang.Runnable
            public void run() {
                for (MiniAppExposureManager.BaseExposureReport baseExposureReport : list) {
                    if (baseExposureReport != null) {
                        baseExposureReport.report();
                    }
                }
                MiniProgramReporter.getInstance().flush();
            }
        });
    }

    private static void flushReport(String str, String str2) {
        if ("unload".equals(str2) || "close".equals(str2) || "hide".equals(str2) || "finishshow".equals(str2) || "sys_alert".equals(str)) {
            MiniProgramReporter.getInstance().flush();
            if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
                QMLog.d(TAG, "reportPageView() called flush()");
            }
        }
    }

    public static void gameInnerReport(final MiniAppInfo miniAppInfo, final JSONObject jSONObject) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.13
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("gameInnerReport() called with args: ");
                    JSONObject jSONObject2 = JSONObject.this;
                    if (jSONObject2 != null) {
                        str = jSONObject2.toString();
                    } else {
                        str = GlobalUtil.DEF_STRING;
                    }
                    sb5.append(str);
                    QMLog.d(SDKMiniProgramLpReportDC04239.TAG, sb5.toString());
                }
                JSONObject jSONObject3 = JSONObject.this;
                if (jSONObject3 != null) {
                    SDKMiniProgramLpReportDC04239.report(miniAppInfo, "1", (String) null, jSONObject3.optString("actiontype"), JSONObject.this.optString("sub_actiontype"), JSONObject.this.optString("reserves_action"));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getAppId(MiniAppInfo miniAppInfo) {
        String str = null;
        if (miniAppInfo == null) {
            return null;
        }
        LaunchParam launchParam = miniAppInfo.launchParam;
        if (launchParam != null) {
            str = launchParam.miniAppId;
        }
        if (TextUtils.isEmpty(str)) {
            return miniAppInfo.appId;
        }
        return str;
    }

    public static String getAppType(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null || !miniAppInfo.isReportTypeMiniGame()) {
            return "0";
        }
        return "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getDurationKey(String str, String str2) {
        return str + "_" + str2 + "_duration";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences getDurationSp(String str, String str2) {
        return AppLoaderFactory.g().getContext().getSharedPreferences(str + "_" + str2, 0);
    }

    public static boolean isLifeCycle(String str) {
        if (!"click".equals(str) && !"load".equals(str) && !"load_fail".equals(str) && !"show".equals(str) && !"show_fail".equals(str) && !"finishshow".equals(str) && !"hide".equals(str) && !"unload".equals(str) && !"close".equals(str)) {
            return false;
        }
        return true;
    }

    private static void processRecordDurationMsg(MiniAppInfo miniAppInfo, String str) {
        if ("show".equals(str)) {
            showMiniAppConfig = miniAppInfo;
            sendRecordDurationMsg();
        } else if ("unload".equals(str) || "hide".equals(str) || "close".equals(str)) {
            deleteRecordDurationMsg();
        }
    }

    public static void recordDuration(final MiniAppInfo miniAppInfo, final long j3) {
        ThreadManager.executeOnComputationThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String account = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAccount();
                    String appId = SDKMiniProgramLpReportDC04239.getAppId(MiniAppInfo.this);
                    if (!TextUtils.isEmpty(appId)) {
                        SharedPreferences durationSp = SDKMiniProgramLpReportDC04239.getDurationSp(account, appId);
                        String durationKey = SDKMiniProgramLpReportDC04239.getDurationKey(account, MiniProgramReportHelper.getLaunchIdFromMainProcess(MiniAppInfo.this));
                        long j16 = durationSp.getLong(durationKey, 0L);
                        durationSp.edit().putLong(durationKey, j3 + j16).apply();
                        QMLog.i(SDKMiniProgramLpReportDC04239.TAG, "recordDuration: " + (j16 + j3) + " key: " + durationKey);
                    }
                } catch (Throwable th5) {
                    QMLog.e(SDKMiniProgramLpReportDC04239.TAG, "recordDuration exception ", th5);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void report(MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4, String str5) {
        report(miniAppInfo, str, str2, str3, str4, str5, "", null, null, null, null);
    }

    public static void report4ScreenRecord(final MiniAppInfo miniAppInfo, final String str, final String str2, final String str3, final String str4, final String str5) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.21
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SDKMiniProgramLpReportDC04239.report(MiniAppInfo.this, SDKMiniProgramLpReportDC04239.getAppType(MiniAppInfo.this), null, str, str2, str3, SDKMiniProgramLpReportDC04239.getAppId(MiniAppInfo.this), str4, str5, null, null);
                    MiniProgramReporter.getInstance().flush();
                } catch (Throwable th5) {
                    QMLog.e(SDKMiniProgramLpReportDC04239.TAG, "report4ScreenRecord, exception:", th5);
                }
            }
        });
    }

    public static void reportApiInvoke(final MiniAppInfo miniAppInfo, final String str) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.14
            @Override // java.lang.Runnable
            public void run() {
                if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
                    QMLog.d(SDKMiniProgramLpReportDC04239.TAG, "reportApiInvoke() called with args: " + str);
                }
                MiniAppInfo miniAppInfo2 = miniAppInfo;
                if (miniAppInfo2 != null) {
                    SDKMiniProgramLpReportDC04239.report(miniAppInfo2, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo2), (String) null, "inner-app", "from_api", str);
                }
            }
        });
    }

    public static void reportAsync(String str, String str2, String str3, String str4) {
        reportAsync(str, str2, str3, str4, null, null);
    }

    public static void reportAsyncR10(final MiniAppInfo miniAppInfo, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8) {
        if (miniAppInfo == null) {
            QMLog.e(TAG, "reportAsyncR10 miniAppInfo is null ");
            return;
        }
        QMLog.d(TAG, " reportAsyncR10 actionType = " + str + " subActionType = " + str2 + " reserves = " + str4 + " reserves9 = " + str7 + " reserves10 = " + str8);
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.10
            @Override // java.lang.Runnable
            public void run() {
                SDKMiniProgramLpReportDC04239.reportWithR10(MiniAppInfo.this, str, str2, str3, str4, str5, str6, str7, str8);
            }
        });
    }

    public static void reportAsyncR9(final MiniAppInfo miniAppInfo, final String str, final String str2, final String str3, final String str4, final String str5, final String str6) {
        if (miniAppInfo == null) {
            QMLog.e(TAG, "reportAsyncR9 miniAppInfo is null ");
            return;
        }
        QMLog.e(TAG, " reportAsyncR9 actionType is = " + str2 + " reserves = " + str3 + " reserves9 = " + str6);
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.8
            @Override // java.lang.Runnable
            public void run() {
                SDKMiniProgramLpReportDC04239.reportAsyncR10(MiniAppInfo.this, str, str2, "", str3, str4, str5, str6, "");
            }
        });
    }

    public static void reportByQQ(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i3;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newBaseBusinessEntries(str, str2, str3, str4, str5, str6, str7));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        if (!QUAUtil.isQQApp()) {
            arrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
        }
        if (!QUAUtil.isQQApp() && !QUAUtil.isMicroApp()) {
            i3 = 12;
        } else {
            i3 = 2;
        }
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(i3, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    public static void reportByQQqunInfo(String str, String str2, String str3, String str4) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newQQqunInfoBusinessEntries(str, str2, str3, "", str4));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        if (!QUAUtil.isQQApp()) {
            arrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
        }
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData((QUAUtil.isQQApp() || QUAUtil.isMicroApp()) ? 2 : 12, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    public static void reportDropDown(final MiniAppInfo miniAppInfo, final String str, final String str2) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.17
            @Override // java.lang.Runnable
            public void run() {
                SDKMiniProgramLpReportDC04239.report(MiniAppInfo.this, SDKMiniProgramLpReportDC04239.getAppType(MiniAppInfo.this), (String) null, "drop_down", str, str2);
                MiniProgramReporter.getInstance().flush();
            }
        });
    }

    public static void reportForSDK(final MiniAppInfo miniAppInfo, final String str, final String str2, final String str3, final String str4, final String str5, final String str6) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.16
            @Override // java.lang.Runnable
            public void run() {
                SDKMiniProgramLpReportDC04239.report(MiniAppInfo.this, str, str2, str3, str4, str5, str6, null, null, null, null);
            }
        });
    }

    public static void reportMiniAppEvent(MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        reportMiniAppEvent(miniAppInfo, str, str2, str3, str4, str5, str6, str7, null, null);
    }

    public static void reportPageView(final MiniAppInfo miniAppInfo, final String str, final String str2, final String str3, final String str4) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.4
            @Override // java.lang.Runnable
            public void run() {
                if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
                    QMLog.d(SDKMiniProgramLpReportDC04239.TAG, "reportUserClick() called with: subActionType = [" + str3 + "], reserves = [" + str4 + "], appType = [" + str + "]");
                }
                SDKMiniProgramLpReportDC04239.report(miniAppInfo, str, str2, "page_view", str3, str4);
            }
        });
    }

    public static void reportUserClick(final MiniAppInfo miniAppInfo, final String str, final String str2, final String str3, final String str4, final String str5) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.2
            @Override // java.lang.Runnable
            public void run() {
                if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
                    QMLog.d(SDKMiniProgramLpReportDC04239.TAG, "reportUserClick() called with: actionType = [" + str3 + "],subActionType = [" + str4 + "], reserves = [" + str5 + "], appType = [" + str + "]");
                }
                SDKMiniProgramLpReportDC04239.report(miniAppInfo, str, str2, str3, str4, str5);
            }
        });
    }

    public static void reportWithGroupId(final MiniAppInfo miniAppInfo, final String str, final String str2, final String str3, final String str4, final String str5) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.19
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
                arrayList.addAll(MiniProgramReportHelper.newQQqunInfoBusinessEntries(str, str2, str3, str4, str5));
                arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
                arrayList.addAll(MiniProgramReportHelper.newVersionEntries(miniAppInfo));
                MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
                MiniProgramReporter.getInstance().flush();
            }
        });
    }

    public static void reportWithR10(MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newBusinessHalfEntries(miniAppInfo, str3, str4, str, str2, str6, str7, str8, miniAppInfo != null ? getAppType(miniAppInfo) : "0", str5, str9, str10));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        if (!QUAUtil.isQQApp()) {
            arrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
            if (miniAppInfo != null) {
                arrayList.add(MiniProgramReportHelper.newEntry("customInfo", miniAppInfo.customInfo));
            }
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(MiniProgramReportHelper.newEntry(entry.getKey(), entry.getValue()));
            }
        }
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData((QUAUtil.isQQApp() || QUAUtil.isMicroApp()) ? 2 : 12, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportWithR7(MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4, String str5, String str6) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newBusinessEntries(miniAppInfo, null, null, str, str2, str3, str4, null, null, null, str5, str6, miniAppInfo != null ? getAppType(miniAppInfo) : "0", ""));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        if (!QUAUtil.isQQApp()) {
            arrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
            if (miniAppInfo != null) {
                arrayList.add(MiniProgramReportHelper.newEntry("customInfo", miniAppInfo.customInfo));
            }
        }
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData((QUAUtil.isQQApp() || QUAUtil.isMicroApp()) ? 2 : 12, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportWithRefer(MiniAppInfo miniAppInfo, int i3, String str, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        int i16;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        if (miniAppInfo != null) {
            str7 = getAppType(miniAppInfo);
        } else {
            str7 = "0";
        }
        arrayList.addAll(MiniProgramReportHelper.newBusinessEntries(miniAppInfo, null, i3 + "", str, str2, str3, str4, null, null, null, str5, str6, str7, ""));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        if (!QUAUtil.isQQApp()) {
            arrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
            if (miniAppInfo != null) {
                arrayList.add(MiniProgramReportHelper.newEntry("customInfo", miniAppInfo.customInfo));
            }
        }
        if (!QUAUtil.isQQApp() && !QUAUtil.isMicroApp()) {
            i16 = 12;
        } else {
            i16 = 2;
        }
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(i16, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendRecordDurationMsg() {
        if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
            QMLog.i(TAG, "sendRecordDurationMsg");
        }
        MiniProgramReporter.getInstance().getReportHandler().removeCallbacks(recordDurationRunnable);
        MiniProgramReporter.getInstance().getReportHandler().postDelayed(recordDurationRunnable, mRecordDurationInterval);
    }

    public static void report(final MiniAppInfo miniAppInfo, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, String str7, String str8, String str9, String str10) {
        LaunchParam launchParam;
        if (isLifeCycle(str4) && !MiniAppReportManager2.IS_MAIN_PROCESS) {
            MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.15
                @Override // java.lang.Runnable
                public void run() {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("app_config", MiniAppInfo.this);
                    bundle.putString("actiontype", str3);
                    bundle.putString("sub_action", str4);
                    bundle.putString("path", str2);
                    bundle.putString("reserves", str5);
                    bundle.putString("reserves2", str6);
                    bundle.putString("app_type", str);
                    bundle.putBoolean("x5_enable", EnvUtils.isX5Enabled(MiniAppInfo.this));
                    AppBrandCmdProxy.g().sendCmd("launch_report", bundle, null);
                }
            });
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
            arrayList.addAll(MiniProgramReportHelper.newBusinessEntries(miniAppInfo, AppBrandUtil.getUrlWithoutParams(str2), (miniAppInfo == null || (launchParam = miniAppInfo.launchParam) == null) ? null : String.valueOf(launchParam.scene), str3, str4, str5, str6, str7, str8, str9, str10, str, null));
            arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
            if (!QUAUtil.isQQApp()) {
                arrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
                arrayList.add(MiniProgramReportHelper.newEntry("customInfo", miniAppInfo.customInfo));
            }
            MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData((QUAUtil.isQQApp() || QUAUtil.isMicroApp()) ? 2 : 12, arrayList, null));
        }
        flushReport(str3, str4);
        processRecordDurationMsg(miniAppInfo, str4);
    }

    public static void reportAsync(final String str, final String str2, final String str3, final String str4, final String str5, final String str6) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.7
            @Override // java.lang.Runnable
            public void run() {
                SDKMiniProgramLpReportDC04239.report(str, str2, str3, str4, str5, str6);
            }
        });
    }

    public static void reportMiniAppEvent(final MiniAppInfo miniAppInfo, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.3
            @Override // java.lang.Runnable
            public void run() {
                if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
                    QMLog.d(SDKMiniProgramLpReportDC04239.TAG, "reportMiniAppEvent() called with: actionType = [" + str3 + "],subActionType = [" + str4 + "], reserves = [" + str5 + "], appType = [" + str + "]");
                }
                SDKMiniProgramLpReportDC04239.report(miniAppInfo, str, str2, str3, str4, str5, str6, str7, str8, str9, null);
            }
        });
    }

    public static void reportPageView(final String str, final String str2) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.5
            @Override // java.lang.Runnable
            public void run() {
                SDKMiniProgramLpReportDC04239.exposureReport("page_view", str, str2);
            }
        });
    }

    public static void exposureReport(MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        LaunchParam launchParam;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newBusinessEntries(miniAppInfo, AppBrandUtil.getUrlWithoutParams(str2), (miniAppInfo == null || (launchParam = miniAppInfo.launchParam) == null) ? null : String.valueOf(launchParam.scene), str3, str4, str5, str6, null, null, null, null, str, ""));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        if (miniAppInfo != null && (str7 = miniAppInfo.reportData) != null && !TextUtils.isEmpty(str7)) {
            arrayList.addAll(MiniProgramReportHelper.newReportEntries(miniAppInfo.reportData));
        }
        if (!QUAUtil.isQQApp()) {
            arrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
            if (miniAppInfo != null) {
                arrayList.add(MiniProgramReportHelper.newEntry("customInfo", miniAppInfo.customInfo));
            }
        }
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData((QUAUtil.isQQApp() || QUAUtil.isMicroApp()) ? 2 : 12, arrayList, null));
    }

    public static void reportAsync(final MiniAppInfo miniAppInfo, final String str, final String str2, final String str3, final String str4, final String str5, final String str6) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.11
            @Override // java.lang.Runnable
            public void run() {
                SDKMiniProgramLpReportDC04239.reportWithR7(MiniAppInfo.this, str, str2, str3, str4, str5, str6);
            }
        });
    }

    public static void reportMiniAppEvent(MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4, String str5, String str6) {
        reportMiniAppEvent(miniAppInfo, str, str2, str3, str4, str5, str6, null);
    }

    public static void reportPageView(List<MiniAppExposureManager.MiniAppExposureData> list, String str) {
        reportPageView(list, null, str, false);
    }

    public static void reportAsync(final MiniAppInfo miniAppInfo, final int i3, final String str, final String str2, final String str3, final String str4, final String str5, final String str6) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.12
            @Override // java.lang.Runnable
            public void run() {
                SDKMiniProgramLpReportDC04239.reportWithRefer(MiniAppInfo.this, i3, str, str2, str3, str4, str5, str6);
            }
        });
    }

    public static void reportAsyncR9(final MiniAppInfo miniAppInfo, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7) {
        if (miniAppInfo == null) {
            QMLog.e(TAG, "reportAsyncR9 miniAppInfo is null ");
            return;
        }
        QMLog.e(TAG, " reportAsyncR9 actionType is = " + str2 + " reserves = " + str4 + " reserves9 = " + str7);
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.9
            @Override // java.lang.Runnable
            public void run() {
                SDKMiniProgramLpReportDC04239.reportAsyncR10(MiniAppInfo.this, str, str2, str3, str4, str5, str6, str7, "");
            }
        });
    }

    public static void reportPageView(List<MiniAppExposureManager.MiniAppExposureData> list, String str, boolean z16) {
        reportPageView(list, null, str, z16);
    }

    private static void reportPageView(final List<MiniAppExposureManager.MiniAppExposureData> list, final String str, final String str2, final boolean z16) {
        if (list == null || list.size() <= 0) {
            return;
        }
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.6
            @Override // java.lang.Runnable
            public void run() {
                MiniAppInfo miniAppConfig;
                LaunchParam launchParam;
                String str3;
                int i3;
                for (MiniAppExposureManager.MiniAppExposureData miniAppExposureData : list) {
                    if (miniAppExposureData != null && miniAppExposureData.getMiniAppConfig() != null && ((launchParam = (miniAppConfig = miniAppExposureData.getMiniAppConfig()).launchParam) == null || !z16 || ((i3 = launchParam.scene) != 3009 && i3 != 3010))) {
                        String appType = SDKMiniProgramLpReportDC04239.getAppType(miniAppConfig);
                        String str4 = str;
                        String str5 = str2;
                        String valueOf = String.valueOf(miniAppExposureData.getPosition());
                        if (z16) {
                            str3 = miniAppExposureData.getReserves2();
                        } else {
                            str3 = null;
                        }
                        SDKMiniProgramLpReportDC04239.exposureReport(miniAppConfig, appType, str4, "page_view", str5, valueOf, str3);
                    }
                }
                MiniProgramReporter.getInstance().flush();
            }
        });
    }

    public static void reportByQQqunInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newQQqunInfoBusinessEntries(str5, str6, str7, "", str8));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        if (!QUAUtil.isQQApp()) {
            arrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
        }
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData((QUAUtil.isQQApp() || QUAUtil.isMicroApp()) ? 2 : 12, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    public static void reportWithR7(MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newBusinessEntries(miniAppInfo, null, "", str2, str3, str4, str5, str6, str7, str8, str9, str10, str, ""));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        if (!QUAUtil.isQQApp()) {
            arrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
            if (miniAppInfo != null) {
                arrayList.add(MiniProgramReportHelper.newEntry("customInfo", miniAppInfo.customInfo));
            }
        }
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData((QUAUtil.isQQApp() || QUAUtil.isMicroApp()) ? 2 : 12, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportWithR10(MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newBusinessHalfEntries(miniAppInfo, str3, null, str, str2, str4, str5, str6, miniAppInfo != null ? getAppType(miniAppInfo) : "0", "", str7, str8));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        if (!QUAUtil.isQQApp()) {
            arrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
            if (miniAppInfo != null) {
                arrayList.add(MiniProgramReportHelper.newEntry("customInfo", miniAppInfo.customInfo));
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" reportWithR9 is isQQApp ");
        sb5.append(QUAUtil.isQQApp() || QUAUtil.isMicroApp());
        QMLog.e(TAG, sb5.toString());
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData((QUAUtil.isQQApp() || QUAUtil.isMicroApp()) ? 2 : 12, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void exposureReport(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newBaseBusinessEntries(str, str2, str3, null, null, null, null));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        if (!QUAUtil.isQQApp()) {
            arrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
        }
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData((QUAUtil.isQQApp() || QUAUtil.isMicroApp()) ? 2 : 12, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    private static void report(String str, String str2, String str3, String str4) {
        report(str, str2, str3, str4, (String) null, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void report(String str, String str2, String str3, String str4, String str5, String str6) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newBaseBusinessEntries(str, str2, str3, str4, str5, str6, null));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        if (!QUAUtil.isQQApp()) {
            arrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
        }
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData((QUAUtil.isQQApp() || QUAUtil.isMicroApp()) ? 2 : 12, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    public static void report(String str, String str2, String str3, String str4, String str5, String str6, boolean z16) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newBaseBusinessEntries(str, str2, str3, str4, str5, str6, null));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        if (!QUAUtil.isQQApp()) {
            arrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
        }
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData((QUAUtil.isQQApp() || QUAUtil.isMicroApp()) ? 2 : 12, arrayList, null));
        if (z16) {
            MiniProgramReporter.getInstance().flush();
        }
    }
}
