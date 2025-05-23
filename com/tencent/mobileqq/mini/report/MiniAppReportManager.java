package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER;
import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.utils.EnvUtils;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppReportManager {
    public static final int DEFAULT_DURATION = 1;
    public static final String KEY_ACTION_TYPE = "action_type";
    public static final String KEY_ADD_DURATION_MS = "add_duration_ms";
    public static final String KEY_APP_CONFIG = "app_config";
    public static final String KEY_APP_TYPE = "app_type";
    public static final String KEY_PATH = "path";
    public static final String KEY_RESERVES = "reserves";
    public static final String KEY_RESERVES2 = "reserves2";
    public static final String KEY_SUB_ACTION = "sub_action";
    public static final String KEY_X5_ENABLE = "x5_enable";
    public static final long MAX_TIME_VALUE = 9999999;
    public static final String TAG = "MiniAppReportManager";
    private static Application.ActivityLifecycleCallbacks lifecycleCallbacks;
    public static final long OPEN_TIME_OUT = GameWnsUtils.getShowTimeout();
    public static final long DELAY_WAITING = GameWnsUtils.getReportDelayWaiting();
    public static final long DELAY_CHECK_DB = GameWnsUtils.getReportDelayCheckDB();
    public static HashMap<String, Long> clickTimeMap = new HashMap<>();
    public static HashMap<String, Long> showTimeMap = new HashMap<>();
    public static HashMap<String, Long> appPauseTimeMap = new HashMap<>();
    public static HashSet<String> jsErrorSet = new HashSet<>();
    public static HashSet<String> x5EnableSet = new HashSet<>();
    public static HashSet<String> hasPkgSet = new HashSet<>();
    private static volatile boolean needCheckReportForeground = true;
    public static HashMap<String, MiniAppReportEntity> miniAppReportEntityHashMap = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class ReportCloseReserve {
        public static final String CODE_INNER_PAGE = "inner_page";
        public static final String CODE_LOADING_PAGE = "loading_page";
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class ReportFailCode {
        public static final String CODE_APPID_CONFLICT_FAIL = "appid_conflict";
        public static final String CODE_BASE_LIB_TASK_FAIL = "baselib_task_fail";
        public static final String CODE_DOWNLOAD_PKG_FAIL = "download_apk_fail";
        public static final String CODE_DOWNLOAD_URL_FAIL = "download_url_fail";
        public static final String CODE_INIT_DATA_FAIL = "init_data_fail";
        public static final String CODE_JS_ERROR = "jsError";
        public static final String CODE_LOADING_PAGE_BACK_PRESS = "loading_page_back_press";
        public static final String CODE_LOADING_PAGE_KILL = "loading_page_kill";
        public static final String CODE_LOAD_BASE_LIB_FAIL = "load_baselib_fail";
        public static final String CODE_LOAD_PKG_FAIL = "load_pkg_fail";
        public static final String CODE_NOT_FOREGROUND_FAIL = "not_foreground";
        public static final String CODE_NOT_READY_FAIL = "not_ready";
        public static final String CODE_OFFLINE_NOT_READY_FAIL = "offline_not_ready";
        public static final String CODE_OFFLINE_NOT_SUPPORT_FAIL = "offline_not_support";
        public static final String CODE_PKG_TASK_FAIL = "pkg_task_fail";
        public static final String CODE_QQ_VERSION_LIMIT_FAIL = "qq_version_limit_fail";
        public static final String CODE_SHORTCUT_REQUEST_FAIL = "shortcut_request_fail";
        public static final String CODE_SPLASH_EXIT_WHEN_FAIL = "splash_exit_when_fail";
        public static final String CODE_START_NO_INTENT_FAIL = "start_no_intent";
        public static final String CODE_SYSTEM_VERSION_LIMIT_FAIL = "system_version_limit_fail";
        public static final String CODE_UNPKG_PKG_FAIL = "unpkg_fail";
        public static final String TIME_OUT_CODE = "timeout";
        public static final String TIME_OUT_CODE_10 = "timeout_10";
        public static final String TIME_OUT_CODE_15 = "timeout_15";
        public static final String TIME_OUT_CODE_20 = "timeout_20";
        public static final String TIME_OUT_CODE_5 = "timeout_5";
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class ReportHideReserve2 {
        public static final String CODE_HIDE_DELAY_REPORT = "delay_report";
        public static final String CODE_HIDE_NORMAL = "hide_normal";
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class ReportShowReserve {
        public static final String CODE_BRING_TO_FRONT = "bring_to_front";
        public static final String CODE_CHANGE_PAGE = "switch_page";
        public static final String CODE_FIRST_FRAME = "first_frame";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkReportDataFromDB() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniAppReportManager.5
            @Override // java.lang.Runnable
            public void run() {
                long j3;
                List<MiniAppReportEntity> l3 = MiniAppReportManager.l();
                if (l3 == null || l3.size() == 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (MiniAppReportEntity miniAppReportEntity : l3) {
                    if (miniAppReportEntity != null) {
                        try {
                            j3 = Long.valueOf(miniAppReportEntity.launchId).longValue();
                        } catch (NumberFormatException unused) {
                            QLog.e(MiniAppReportManager.TAG, 1, "checkReportDataFromDB, launchId: " + miniAppReportEntity.launchId);
                            j3 = 0;
                        }
                        boolean contains = MiniAppReportManager.x5EnableSet.contains(miniAppReportEntity.launchId);
                        boolean contains2 = MiniAppReportManager.hasPkgSet.contains(miniAppReportEntity.launchId);
                        if ("click".equals(miniAppReportEntity.subActionType)) {
                            if (System.currentTimeMillis() - j3 > MiniAppReportManager.OPEN_TIME_OUT) {
                                if (MiniAppReportManager.jsErrorSet.contains(miniAppReportEntity.launchId)) {
                                    MiniAppReportManager.reportPageViewToDc04239(miniAppReportEntity, "load_fail", "jsError", MiniAppReportManager.getX5AndPkgCode(contains, contains2), null);
                                } else {
                                    long timeFromClickToHide = MiniAppReportManager.getTimeFromClickToHide(miniAppReportEntity.launchId);
                                    MiniAppReportManager.reportPageViewToDc04239(miniAppReportEntity, "load_fail", MiniAppReportManager.getTimeOutCode(timeFromClickToHide), MiniAppReportManager.getX5AndPkgCode(contains, contains2), String.valueOf(timeFromClickToHide));
                                }
                                MiniAppReportManager.jsErrorSet.remove(miniAppReportEntity.launchId);
                                MiniAppReportManager.appPauseTimeMap.remove(miniAppReportEntity.launchId);
                                MiniAppReportManager.x5EnableSet.remove(miniAppReportEntity.launchId);
                                MiniAppReportManager.hasPkgSet.remove(miniAppReportEntity.launchId);
                                MiniAppReportManager.deleteReportDcDataFromDB(miniAppReportEntity);
                                arrayList.add(miniAppReportEntity);
                            }
                        } else if ("load".equals(miniAppReportEntity.subActionType)) {
                            if (System.currentTimeMillis() - j3 > MiniAppReportManager.OPEN_TIME_OUT) {
                                if (MiniAppReportManager.jsErrorSet.contains(miniAppReportEntity.launchId)) {
                                    MiniAppReportManager.reportPageViewToDc04239(miniAppReportEntity, "show_fail", "jsError", MiniAppReportManager.getX5AndPkgCode(contains, contains2), null);
                                } else {
                                    long timeFromClickToHide2 = MiniAppReportManager.getTimeFromClickToHide(miniAppReportEntity.launchId);
                                    MiniAppReportManager.reportPageViewToDc04239(miniAppReportEntity, "show_fail", MiniAppReportManager.getTimeOutCode(timeFromClickToHide2), MiniAppReportManager.getX5AndPkgCode(contains, contains2), String.valueOf(timeFromClickToHide2));
                                }
                                MiniAppReportManager.jsErrorSet.remove(miniAppReportEntity.launchId);
                                MiniAppReportManager.appPauseTimeMap.remove(miniAppReportEntity.launchId);
                                MiniAppReportManager.x5EnableSet.remove(miniAppReportEntity.launchId);
                                MiniAppReportManager.hasPkgSet.remove(miniAppReportEntity.launchId);
                                MiniAppReportManager.deleteReportDcDataFromDB(miniAppReportEntity);
                                arrayList.add(miniAppReportEntity);
                            }
                        } else if ("show".equals(miniAppReportEntity.subActionType)) {
                            String saveDuration = MiniAppReportManager.getSaveDuration(miniAppReportEntity);
                            if (saveDuration != null) {
                                MiniAppReportManager.reportPageViewToDc04239(miniAppReportEntity, "hide", null, ReportHideReserve2.CODE_HIDE_DELAY_REPORT, saveDuration);
                                arrayList.add(miniAppReportEntity);
                            }
                            MiniAppReportManager.deleteReportDcDataFromDB(miniAppReportEntity);
                        } else {
                            MiniAppReportManager.deleteReportDcDataFromDB(miniAppReportEntity);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    MiniProgramReporter.getInstance().reportImmediatelyLaunchDcData();
                }
            }
        }, 32, null, true);
    }

    public static void clearAppPauseTime(MiniAppConfig miniAppConfig) {
        appPauseTimeMap.remove(MiniProgramReportHelper.getLaunchIdFromMainProcess(miniAppConfig));
    }

    private static void clearDuration(final MiniAppConfig miniAppConfig, final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniAppReportManager.10
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                try {
                    long l3 = com.tencent.open.adapter.a.f().l();
                    String appId = MiniAppReportManager.getAppId(MiniAppConfig.this);
                    if (TextUtils.isEmpty(appId)) {
                        return;
                    }
                    SharedPreferences durationSp = MiniAppReportManager.getDurationSp(l3, appId);
                    if (TextUtils.isEmpty(str)) {
                        str2 = MiniProgramReportHelper.getLaunchIdFromMainProcess(MiniAppConfig.this);
                    } else {
                        str2 = str;
                    }
                    String durationKey = MiniAppReportManager.getDurationKey(l3, str2);
                    durationSp.edit().remove(durationKey).apply();
                    if (QLog.isColorLevel()) {
                        QLog.i(MiniAppReportManager.TAG, 2, "clearDuration " + durationKey);
                    }
                } catch (Throwable th5) {
                    QLog.e(MiniAppReportManager.TAG, 1, "clearDuration exception ", th5);
                }
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void deleteReportDcDataFromDB(MiniAppReportEntity miniAppReportEntity) {
        AppInterface appInterface = MiniAppUtils.getAppInterface();
        if (!(appInterface instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "deleteMiniAppFromDB, app is null.");
            return;
        }
        try {
            EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
            if (createEntityManager == null || miniAppReportEntity == null) {
                return;
            }
            createEntityManager.remove(miniAppReportEntity);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "deleteReportDcDataFromDB exception", th5);
        }
    }

    private static String getDurationAndDelete(MiniAppConfig miniAppConfig) {
        String launchIdFromMainProcess = MiniProgramReportHelper.getLaunchIdFromMainProcess(miniAppConfig);
        if (launchIdFromMainProcess != null && showTimeMap.containsKey(launchIdFromMainProcess)) {
            long longValue = showTimeMap.get(launchIdFromMainProcess).longValue();
            showTimeMap.remove(launchIdFromMainProcess);
            long currentTimeMillis = System.currentTimeMillis() - longValue;
            if (currentTimeMillis > 0) {
                return String.valueOf(currentTimeMillis);
            }
            return "0";
        }
        return "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getDurationKey(long j3, String str) {
        return j3 + "_" + str + "_duration";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences getDurationSp(long j3, String str) {
        return BaseApplicationImpl.getApplication().getSharedPreferences(j3 + "_" + str, 0);
    }

    private static String getPatientDurationAndDelete(MiniAppConfig miniAppConfig) {
        String launchIdFromMainProcess = MiniProgramReportHelper.getLaunchIdFromMainProcess(miniAppConfig);
        if (launchIdFromMainProcess != null && clickTimeMap.containsKey(launchIdFromMainProcess)) {
            long longValue = clickTimeMap.get(launchIdFromMainProcess).longValue();
            clickTimeMap.remove(launchIdFromMainProcess);
            long currentTimeMillis = System.currentTimeMillis() - longValue;
            if (currentTimeMillis > 0) {
                return String.valueOf(currentTimeMillis);
            }
            return "0";
        }
        return "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getSaveDuration(MiniAppReportEntity miniAppReportEntity) {
        if (miniAppReportEntity != null) {
            try {
                long l3 = com.tencent.open.adapter.a.f().l();
                String str = miniAppReportEntity.appId;
                if (!TextUtils.isEmpty(str)) {
                    SharedPreferences durationSp = getDurationSp(l3, str);
                    String durationKey = getDurationKey(l3, miniAppReportEntity.launchId);
                    long j3 = durationSp.getLong(durationKey, 0L);
                    r1 = j3 > 0 ? String.valueOf(j3) : null;
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "getSaveDuration " + r1 + " key=" + durationKey);
                    }
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "getSaveDuration exception ", th5);
            }
        }
        return r1;
    }

    private static BaseTransaction getUpdateEntityTransaction(Entity entity) {
        if (entity.getStatus() == 1000) {
            return new PersistOrReplaceTransaction(entity);
        }
        if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
            return new UpdateTransaction(entity);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getX5AndPkgCode(boolean z16, boolean z17) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        String str2 = "";
        if (!z16) {
            str = "";
        } else {
            str = "hasX5";
        }
        sb5.append(str);
        if (z17) {
            str2 = "_hasPkg";
        }
        sb5.append(str2);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void insertReportDcDataToDB(List<MiniAppReportEntity> list) {
        AppInterface appInterface = MiniAppUtils.getAppInterface();
        if (list != null && list.size() != 0 && (appInterface instanceof QQAppInterface)) {
            try {
                EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
                if (createEntityManager != null) {
                    ArrayList arrayList = new ArrayList();
                    for (MiniAppReportEntity miniAppReportEntity : list) {
                        BaseTransaction updateEntityTransaction = getUpdateEntityTransaction(miniAppReportEntity);
                        if (updateEntityTransaction != null) {
                            arrayList.add(updateEntityTransaction);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "has reportPageView, insertReportDcDataToDB : " + miniAppReportEntity.toString());
                        }
                    }
                    createEntityManager.doMultiDBOperateByTransaction(arrayList);
                    return;
                }
                return;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "insertReportDcDataToDB exception", th5);
                return;
            }
        }
        QLog.e(TAG, 1, "insertReportDcDataToDB, app = " + appInterface);
    }

    static /* bridge */ /* synthetic */ List l() {
        return queryReportDcDataFromDB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportMiniGameFastShareClick$0(MiniAppConfig miniAppConfig, String str, String str2) {
        MiniProgramLpReportDC04239.report(miniAppConfig, MiniProgramLpReportDC04239.getAppType(miniAppConfig), "", "share_panel", "fast_share", "click", null, null, null, str, str2);
    }

    private static boolean needCheckReportForeground() {
        return needCheckReportForeground;
    }

    private static boolean needReport(String str, String str2) {
        MiniAppReportEntity miniAppReportEntity;
        if (TextUtils.isEmpty(str2) || !miniAppReportEntityHashMap.containsKey(str) || (miniAppReportEntity = miniAppReportEntityHashMap.get(str)) == null) {
            return true;
        }
        if ("load_fail".equals(miniAppReportEntity.subActionType) || "show_fail".equals(miniAppReportEntity.subActionType) || "show".equals(miniAppReportEntity.subActionType)) {
            return ("load_fail".equals(str2) || "show_fail".equals(str2)) ? false : true;
        }
        return true;
    }

    public static void onEnterBackground() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onEnterBackground");
        }
        try {
            MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniAppReportManager.6
                @Override // java.lang.Runnable
                public void run() {
                    MiniProgramReporter.getInstance().reportImmediatelyLaunchDcData();
                }
            });
            setNeedCheckReportForeground(true);
            MiniGameHomeReportService.INSTANCE.recordEnterBackground();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "onEnterBackground exception", th5);
        }
    }

    public static void onEnterForeground() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onEnterForeground");
        }
        if (!needCheckReportForeground()) {
            QLog.e(TAG, 1, "onEnterForeground needCheckReportForground=false");
            return;
        }
        try {
            MiniProgramReporter.getInstance().reportImmediatelyLaunchDcData();
            MiniProgramReporter.getInstance().getReportHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniAppReportManager.7
                @Override // java.lang.Runnable
                public void run() {
                    MiniAppReportManager.checkReportDataFromDB();
                }
            }, DELAY_CHECK_DB);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "onEnterForeground exception", th5);
        }
    }

    private static List<MiniAppReportEntity> queryReportDcDataFromDB() {
        EntityManager createEntityManager;
        AppInterface appInterface = MiniAppUtils.getAppInterface();
        if (!(appInterface instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "queryReportDcDataFromDB, app is null.");
            return null;
        }
        try {
            if (appInterface.getAccount() == null || (createEntityManager = appInterface.getEntityManagerFactory().createEntityManager()) == null) {
                return null;
            }
            return createEntityManager.query(MiniAppReportEntity.class, MiniAppReportEntity.class.getSimpleName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "queryReportDcDataFromDB exception", th5);
            return null;
        }
    }

    public static void recordDuration(final MiniAppConfig miniAppConfig, final long j3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniAppReportManager.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long l3 = com.tencent.open.adapter.a.f().l();
                    String appId = MiniAppReportManager.getAppId(MiniAppConfig.this);
                    if (TextUtils.isEmpty(appId)) {
                        return;
                    }
                    SharedPreferences durationSp = MiniAppReportManager.getDurationSp(l3, appId);
                    String durationKey = MiniAppReportManager.getDurationKey(l3, MiniProgramReportHelper.getLaunchIdFromMainProcess(MiniAppConfig.this));
                    long j16 = durationSp.getLong(durationKey, 0L);
                    durationSp.edit().putLong(durationKey, j3 + j16).apply();
                    if (QLog.isColorLevel()) {
                        QLog.i(MiniAppReportManager.TAG, 2, "recordDuration: " + (j16 + j3) + " key: " + durationKey);
                    }
                } catch (Throwable th5) {
                    QLog.e(MiniAppReportManager.TAG, 1, "recordDuration exception ", th5);
                }
            }
        }, 16, null, false);
    }

    public static void registerActivityLifecycleCallbacks() {
        if (lifecycleCallbacks == null) {
            lifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.tencent.mobileqq.mini.report.MiniAppReportManager.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    if (QLog.isColorLevel()) {
                        QLog.i(MiniAppReportManager.TAG, 2, "onActivityPaused " + activity.getClass().getSimpleName());
                    }
                    if (activity instanceof MiniChatActivity) {
                        MiniAppReportManager.setNeedCheckReportForeground(true);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    if (QLog.isColorLevel()) {
                        QLog.i(MiniAppReportManager.TAG, 2, "onActivityResumed " + activity.getClass().getSimpleName());
                    }
                    if ((activity instanceof MiniChatActivity) || (activity instanceof PublicTransFragmentActivity)) {
                        MiniAppReportManager.setNeedCheckReportForeground(false);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    if (QLog.isColorLevel()) {
                        QLog.i(MiniAppReportManager.TAG, 2, "onActivityStopped " + activity.getClass().getSimpleName());
                    }
                    if (activity instanceof PublicTransFragmentActivity) {
                        MiniAppReportManager.setNeedCheckReportForeground(true);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }
            };
            BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(lifecycleCallbacks);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void report(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z16) {
        LaunchParam launchParam;
        String str9 = str7;
        if ("click".equals(str5)) {
            MiniProgramReportHelper.generateLaunchIdInMainProcess(miniAppConfig);
            setClickTime(miniAppConfig);
        }
        String launchIdFromMainProcess = TextUtils.isEmpty(str) ? MiniProgramReportHelper.getLaunchIdFromMainProcess(miniAppConfig) : str;
        if (z16 && !x5EnableSet.contains(launchIdFromMainProcess)) {
            if (x5EnableSet.size() > 50) {
                x5EnableSet.clear();
            }
            x5EnableSet.add(launchIdFromMainProcess);
        }
        if (!hasPkgSet.contains(launchIdFromMainProcess) && EnvUtils.isPkgDownloaded(miniAppConfig)) {
            if (hasPkgSet.size() > 50) {
                hasPkgSet.clear();
            }
            hasPkgSet.add(launchIdFromMainProcess);
        }
        if (!needReport(launchIdFromMainProcess, str5)) {
            QLog.e(TAG, 1, "no need report! called with: [subActionType = " + str5 + "], [appType = " + str2 + "], [reserves = " + str6 + "], [reserves2 = " + str9 + "], [reserves3 = " + str8 + "], [launchid =" + launchIdFromMainProcess);
            return;
        }
        String str10 = str8;
        if ("show".equals(str5)) {
            setShowTime(miniAppConfig);
            recordDuration(miniAppConfig, 1L);
            getPatientDurationAndDelete(miniAppConfig);
            boolean contains = x5EnableSet.contains(launchIdFromMainProcess);
            boolean contains2 = hasPkgSet.contains(launchIdFromMainProcess);
            if (TextUtils.isEmpty(str7)) {
                str9 = getX5AndPkgCode(contains, contains2);
            }
            jsErrorSet.remove(launchIdFromMainProcess);
            appPauseTimeMap.remove(launchIdFromMainProcess);
            x5EnableSet.remove(launchIdFromMainProcess);
            hasPkgSet.remove(launchIdFromMainProcess);
        } else if ("hide".equals(str5)) {
            String durationAndDelete = getDurationAndDelete(miniAppConfig);
            if (ReportHideReserve2.CODE_HIDE_DELAY_REPORT.equals(str9)) {
                durationAndDelete = str10;
            }
            clearDuration(miniAppConfig, launchIdFromMainProcess);
            str10 = durationAndDelete;
        }
        if ("loading_page_kill".equals(str6) || "loading_page_back_press".equals(str6)) {
            str10 = getPatientDurationAndDelete(miniAppConfig);
            boolean contains3 = x5EnableSet.contains(launchIdFromMainProcess);
            boolean contains4 = hasPkgSet.contains(launchIdFromMainProcess);
            if (TextUtils.isEmpty(str9)) {
                str9 = getX5AndPkgCode(contains3, contains4);
            }
            jsErrorSet.remove(launchIdFromMainProcess);
            appPauseTimeMap.remove(launchIdFromMainProcess);
            x5EnableSet.remove(launchIdFromMainProcess);
            hasPkgSet.remove(launchIdFromMainProcess);
        }
        String str11 = str9;
        String str12 = str10;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "report called with: [subActionType = " + str5 + "], [appType = " + str2 + "], [reserves = " + str6 + "], [reserves2 = " + str11 + "], [reserves3 = " + str12 + "], [launchid =" + launchIdFromMainProcess);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newBusinessEntries(miniAppConfig, AppBrandUtil.getUrlWithoutParams(str3), (miniAppConfig == null || (launchParam = miniAppConfig.launchParam) == null) ? null : String.valueOf(launchParam.scene), str4, str5, str6, str11, str12, null, null, null, null, null, str2, launchIdFromMainProcess));
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        APP_REPORT_TRANSFER.SingleDcData newSingleReportData = MiniProgramReportHelper.newSingleReportData(2, arrayList, null);
        MiniProgramReporter.getInstance().addDcData(newSingleReportData);
        updateReportMap(launchIdFromMainProcess, newSingleReportData);
    }

    public static void reportClickDc04239(final MiniAppConfig miniAppConfig, final String str, final String str2, final String str3, final String str4, boolean z16) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniAppReportManager.4
            @Override // java.lang.Runnable
            public void run() {
                MiniAppReportManager.report(MiniAppConfig.this, null, str, str2, "page_view", str3, str4, null, null, false);
            }
        });
    }

    public static void reportToDc04239(final MiniAppConfig miniAppConfig, final String str, final String str2, final String str3, final String str4, final String str5, final boolean z16) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniAppReportManager.2
            @Override // java.lang.Runnable
            public void run() {
                MiniAppReportManager.report(MiniAppConfig.this, null, str5, str, str2, str3, str4, null, null, z16);
            }
        });
    }

    public static void setAppPauseTime(MiniAppConfig miniAppConfig) {
        if (appPauseTimeMap.size() > 50) {
            appPauseTimeMap.clear();
        }
        appPauseTimeMap.put(MiniProgramReportHelper.getLaunchIdFromMainProcess(miniAppConfig), Long.valueOf(System.currentTimeMillis()));
    }

    private static void setClickTime(MiniAppConfig miniAppConfig) {
        if (clickTimeMap.size() > 50) {
            clickTimeMap.clear();
        }
        clickTimeMap.put(MiniProgramReportHelper.getLaunchIdFromMainProcess(miniAppConfig), Long.valueOf(System.currentTimeMillis()));
    }

    public static void setJsError(MiniAppConfig miniAppConfig) {
        if (jsErrorSet.size() > 50) {
            jsErrorSet.clear();
        }
        jsErrorSet.add(MiniProgramReportHelper.getLaunchIdFromMainProcess(miniAppConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setNeedCheckReportForeground(boolean z16) {
        needCheckReportForeground = z16;
    }

    private static void setShowTime(MiniAppConfig miniAppConfig) {
        if (showTimeMap.size() > 50) {
            showTimeMap.clear();
        }
        showTimeMap.put(MiniProgramReportHelper.getLaunchIdFromMainProcess(miniAppConfig), Long.valueOf(System.currentTimeMillis()));
    }

    private static boolean updateEntity(EntityManager entityManager, Entity entity) {
        boolean z16 = false;
        if (entityManager.isOpen()) {
            if (entity.getStatus() == 1000) {
                entityManager.persistOrReplace(entity);
                if (entity.getStatus() == 1001) {
                    z16 = true;
                }
            } else if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                z16 = entityManager.update(entity);
            }
            entityManager.close();
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateEntity em closed e=" + entity.getTableName());
        }
        return false;
    }

    private static void updateReportMap(String str, APP_REPORT_TRANSFER.SingleDcData singleDcData) {
        MiniAppReportEntity miniAppReportEntity;
        if (miniAppReportEntityHashMap.size() > 50) {
            miniAppReportEntityHashMap.clear();
        }
        if (miniAppReportEntityHashMap.containsKey(str)) {
            miniAppReportEntity = miniAppReportEntityHashMap.get(str);
        } else {
            miniAppReportEntity = new MiniAppReportEntity();
        }
        String str2 = "";
        String str3 = "";
        String str4 = str3;
        boolean z16 = false;
        String str5 = str4;
        for (COMM.Entry entry : singleDcData.report_data.get()) {
            if ("launchid".equals(entry.key.get())) {
                str = entry.value.get();
            }
            if ("appid".equals(entry.key.get())) {
                str2 = entry.value.get();
            }
            if ("sub_actiontype".equals(entry.key.get())) {
                str5 = entry.value.get();
                if (!"click".equals(str5) && !"load".equals(str5) && !"show".equals(str5) && !"load_fail".equals(str5) && !"show_fail".equals(str5)) {
                    break;
                } else {
                    z16 = true;
                }
            }
            if ("app_type".equals(entry.key.get())) {
                str3 = entry.value.get();
            }
            if (DTConstants.APPStatusConstant.APP_STATUS.equals(entry.key.get())) {
                str4 = entry.value.get();
            }
        }
        if (miniAppReportEntity == null || !z16) {
            return;
        }
        miniAppReportEntity.appId = str2;
        miniAppReportEntity.appType = str3;
        miniAppReportEntity.launchId = str;
        miniAppReportEntity.subActionType = str5;
        miniAppReportEntity.verType = str4;
        miniAppReportEntityHashMap.put(str, miniAppReportEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getAppId(MiniAppConfig miniAppConfig) {
        MiniAppInfo miniAppInfo;
        LaunchParam launchParam;
        String str = (miniAppConfig == null || (launchParam = miniAppConfig.launchParam) == null) ? null : launchParam.miniAppId;
        return (!TextUtils.isEmpty(str) || miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null) ? str : miniAppInfo.appId;
    }

    public static void recordReportItemToDB(final List<APP_REPORT_TRANSFER.SingleDcData> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniAppReportManager.8
            @Override // java.lang.Runnable
            public void run() {
                PBRepeatMessageField<COMM.Entry> pBRepeatMessageField;
                ArrayList arrayList = new ArrayList();
                for (APP_REPORT_TRANSFER.SingleDcData singleDcData : list) {
                    if (singleDcData != null && (pBRepeatMessageField = singleDcData.report_data) != null) {
                        String str = "";
                        String str2 = "";
                        String str3 = str2;
                        String str4 = str3;
                        boolean z16 = false;
                        String str5 = str4;
                        for (COMM.Entry entry : pBRepeatMessageField.get()) {
                            if ("launchid".equals(entry.key.get())) {
                                str = entry.value.get();
                            }
                            if ("appid".equals(entry.key.get())) {
                                str5 = entry.value.get();
                            }
                            if ("sub_actiontype".equals(entry.key.get())) {
                                str2 = entry.value.get();
                                if (!"click".equals(str2) && !"load".equals(str2) && !"show".equals(str2) && !"load_fail".equals(str2) && !"show_fail".equals(str2)) {
                                    break;
                                } else {
                                    z16 = true;
                                }
                            }
                            if ("app_type".equals(entry.key.get())) {
                                str3 = entry.value.get();
                            }
                            if (DTConstants.APPStatusConstant.APP_STATUS.equals(entry.key.get())) {
                                str4 = entry.value.get();
                            }
                        }
                        String str6 = str;
                        String str7 = str5;
                        String str8 = str2;
                        if (z16 && !TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7)) {
                            arrayList.add(new MiniAppReportEntity(str6, str7, str8, str3, str4));
                        }
                    }
                }
                MiniAppReportManager.insertReportDcDataToDB(arrayList);
            }
        }, 32, null, true);
    }

    public static void reportMiniGameFastShareClick(final MiniAppConfig miniAppConfig, int i3, final String str) {
        final String str2;
        if (i3 == 0) {
            str2 = "c2c";
        } else if (i3 == 1) {
            str2 = VipFunCallConstants.KEY_GROUP;
        } else {
            str2 = i3 == 10014 ? WadlProxyConsts.CHANNEL : null;
        }
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.c
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppReportManager.lambda$reportMiniGameFastShareClick$0(MiniAppConfig.this, str2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportPageViewToDc04239(final MiniAppReportEntity miniAppReportEntity, final String str, final String str2, final String str3, final String str4) {
        if (miniAppReportEntity == null) {
            QLog.e(TAG, 1, "reportPageViewToDc04239 fail, called with: [subActionType = " + str + "], [reserves = " + str2 + "], [reserves2 = " + str3);
            return;
        }
        MiniAppInfo miniAppInfo = new MiniAppInfo();
        miniAppInfo.appId = miniAppReportEntity.appId;
        try {
            miniAppInfo.verType = Integer.valueOf(miniAppReportEntity.verType).intValue();
            miniAppInfo.setReportType(Integer.valueOf(miniAppReportEntity.appType).intValue());
        } catch (NumberFormatException unused) {
        }
        final MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniAppReportManager.3
            @Override // java.lang.Runnable
            public void run() {
                MiniAppConfig miniAppConfig2 = MiniAppConfig.this;
                MiniAppReportEntity miniAppReportEntity2 = miniAppReportEntity;
                MiniAppReportManager.report(miniAppConfig2, miniAppReportEntity2.launchId, miniAppReportEntity2.appType, null, "page_view", str, str2, str3, str4, false);
            }
        });
    }

    public static void splashMiniGameClickReport(SplashMiniGameData splashMiniGameData) {
        if (splashMiniGameData != null) {
            MiniAppInfo miniAppInfo = new MiniAppInfo();
            miniAppInfo.appId = splashMiniGameData.appId;
            try {
                miniAppInfo.verType = Integer.valueOf(splashMiniGameData.version).intValue();
                miniAppInfo.setReportType(Integer.valueOf("1").intValue());
            } catch (NumberFormatException unused) {
            }
            reportClickDc04239(new MiniAppConfig(miniAppInfo), "1", null, "click", null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getTimeOutCode(long j3) {
        if (j3 < 0) {
            return "timeout";
        }
        if (j3 < 10000) {
            return "timeout_" + (j3 / 1000);
        }
        if (j3 < 15000) {
            return "timeout_15";
        }
        if (j3 >= 20000) {
            return "timeout";
        }
        return "timeout_20";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getTimeFromClickToHide(String str) {
        if (str == null || !clickTimeMap.containsKey(str) || !appPauseTimeMap.containsKey(str)) {
            return MAX_TIME_VALUE;
        }
        long longValue = appPauseTimeMap.get(str).longValue() - clickTimeMap.get(str).longValue();
        return longValue < 0 ? MAX_TIME_VALUE : longValue;
    }
}
