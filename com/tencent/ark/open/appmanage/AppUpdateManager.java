package com.tencent.ark.open.appmanage;

import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.Logger;
import com.tencent.ark.StringUtil;
import com.tencent.ark.data.ArkAppElement;
import com.tencent.ark.mmkv.IMMKV;
import com.tencent.ark.mmkv.MMKVManager;
import com.tencent.ark.mmkv.MMKVUtils;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.appmanage.AppUpdateTask;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateNet;
import com.tencent.ark.open.delegate.IArkDelegateSetup;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AppUpdateManager {
    private static final int APP_UPDATE_INTERVAL_BY_MINUTES = 180;
    private static final int CHECK_APP_UPDATE_INTERVAL;
    private static final String KEY_CHECK_APP_UPDATE_INTERVAL = "KEY_CHECK_APP_UPDATE_INTERVAL";
    private static final int MINUTE_TO_MICROSECOND = 60000;
    private static final String PREF_APP_UPDATE_PERIOD = "ArkAppUpdatePeriod";
    private static final String PREF_APP_UPDATE_RECORD = "ArkAppUpdateRecord";
    private static final String TAG = "ArkApp.ArkAppMgr";
    private static boolean appUpdateDebugMode;
    private long lastTimeCheckAppUpdate = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ICheckNetworkCallback {
        void onCheckNetwork(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class LazyHolder {
        static final AppUpdateManager instance = new AppUpdateManager();

        LazyHolder() {
        }
    }

    static {
        int i3;
        if (ArkAppMgr.DEBUG) {
            i3 = 4;
        } else {
            i3 = 300;
        }
        CHECK_APP_UPDATE_INTERVAL = i3;
        appUpdateDebugMode = false;
    }

    private void beginCheckNetwork(final ICheckNetworkCallback iCheckNetworkCallback) {
        ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.open.appmanage.AppUpdateManager.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                IArkDelegateNet netDelegate = ArkDelegateManager.getInstance().getNetDelegate();
                if (netDelegate != null) {
                    z16 = netDelegate.isNetworkAvailable();
                } else {
                    z16 = true;
                }
                iCheckNetworkCallback.onCheckNetwork(z16);
            }
        });
    }

    private static void deleteNotUsedApps() {
        for (ArkAppElement arkAppElement : LocalAppManager.enumInstalledAppName()) {
            if (AppManageInfoStorage.isAppNotRecentUse(arkAppElement.appName, arkAppElement.bizSrc)) {
                Logger.logI("ArkApp.ArkAppMgr", String.format("delete not used app: %s, bizSrcL %s", arkAppElement.appName, arkAppElement.bizSrc));
                LocalAppManager.deleteAppByNameAndBiz(arkAppElement.appName, arkAppElement.bizSrc, true);
                AppManageInfoStorage.updateAppLastUseTime(arkAppElement.appName, arkAppElement.bizSrc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpdateInstalledApps(AppUpdateTask.IUpdateAppByNameCallback iUpdateAppByNameCallback) {
        if (!shouldUpdateApp()) {
            return;
        }
        deleteNotUsedApps();
        List<ArkAppElement> updateAppList = getUpdateAppList();
        if (updateAppList.isEmpty()) {
            Logger.logI("ArkApp.ArkAppMgr", "doUpdateInstalledApps, no app need update.");
        } else {
            logUpdateInfo(updateAppList);
            runUpdateAppTask(updateAppList, iUpdateAppByNameCallback);
        }
    }

    private int getGlobalUpdatePeriod() {
        IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
        if (arkMMKV == null) {
            return CHECK_APP_UPDATE_INTERVAL;
        }
        return arkMMKV.getInt(MMKVUtils.fixUpdateTimeKey(KEY_CHECK_APP_UPDATE_INTERVAL), CHECK_APP_UPDATE_INTERVAL);
    }

    public static AppUpdateManager getInstance() {
        return LazyHolder.instance;
    }

    private List<ArkAppElement> getUpdateAppList() {
        List<ArkAppElement> enumInstalledAppName = LocalAppManager.enumInstalledAppName();
        ArrayList arrayList = new ArrayList();
        addPredownloadAppToList(arrayList);
        for (ArkAppElement arkAppElement : enumInstalledAppName) {
            if (isAppNeedUpdate(arkAppElement.appName, arkAppElement.bizSrc) || appUpdateDebugMode) {
                if (!arrayList.contains(arkAppElement)) {
                    arrayList.add(arkAppElement);
                }
            }
        }
        return arrayList;
    }

    private boolean isAppNeedUpdate(String str, String str2) {
        IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
        if (arkMMKV == null) {
            return false;
        }
        String appConfigCacheKey = ArkAppConfigMgr.getAppConfigCacheKey(str, str2);
        long j3 = arkMMKV.getLong(MMKVUtils.fixUpdateRecordKey(appConfigCacheKey), 0L);
        int i3 = arkMMKV.getInt(MMKVUtils.fixUpdatePeriodKey(appConfigCacheKey), 180);
        AppManageInfoStorage.getAppLastUseTime(str, str2);
        if (Math.abs(System.currentTimeMillis() - j3) / 60000 <= i3) {
            return false;
        }
        return true;
    }

    public static boolean isAppUpdateBefore(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String appConfigCacheKey = ArkAppConfigMgr.getAppConfigCacheKey(str, str2);
        IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
        if (arkMMKV == null || arkMMKV.getLong(MMKVUtils.fixUpdateRecordKey(appConfigCacheKey), -1L) == -1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logAppUpdateResult(AppUpdateTask.UpdateTask updateTask) {
        String str;
        int i3;
        ArkAppInfo.AppDesc appDesc;
        int i16 = updateTask.result;
        if (i16 != 1 && i16 != 2) {
            Logger.logI("ArkApp.ArkAppMgr", String.format("runUpdateLocalAppTask, updateAppByName fail, result=%s, app-name=%s", AppUpdateTask.resultValueToString(i16), updateTask.app.appName));
            return;
        }
        ArkAppMgr.AppPathInfo appPathInfo = updateTask.appPathInfo;
        if (appPathInfo != null && (appDesc = appPathInfo.desc) != null && !TextUtils.isEmpty(appDesc.version)) {
            str = updateTask.appPathInfo.desc.version;
        } else {
            str = "";
        }
        ArkAppInfo.AppDownloadInfo appDownloadInfo = updateTask.downloadInfo;
        if (appDownloadInfo != null) {
            i3 = appDownloadInfo.updatePeriodByMinutes;
        } else {
            i3 = 0;
        }
        Logger.logI("ArkApp.ArkAppMgr", StringUtil.format("runUpdateLocalAppTask, updateAppByName success, result=%s, app-name=%s, app-version=%s, update-period=%d", AppUpdateTask.resultValueToString(updateTask.result), updateTask.app.appName, str, Integer.valueOf(i3)));
    }

    private void logUpdateInfo(List<ArkAppElement> list) {
        StringBuilder sb5 = new StringBuilder();
        for (ArkAppElement arkAppElement : list) {
            sb5.append(arkAppElement.appName);
            sb5.append(",");
            sb5.append(arkAppElement.bizSrc);
            sb5.append(';');
        }
        Logger.logI("ArkApp.ArkAppMgr", String.format("doUpdateInstalledApps, start to update, last-time=%s, app-count=%s, app-name-list=%s.", Long.valueOf(this.lastTimeCheckAppUpdate), Integer.valueOf(list.size()), sb5.toString()));
    }

    static void putAppUpdatePeriod(String str, String str2, int i3) {
        if (!TextUtils.isEmpty(str) && i3 != 0) {
            String appConfigCacheKey = ArkAppConfigMgr.getAppConfigCacheKey(str, str2);
            int max = Math.max(10, i3);
            IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
            if (arkMMKV == null) {
                return;
            }
            arkMMKV.putInt(MMKVUtils.fixUpdatePeriodKey(appConfigCacheKey), max);
            Logger.logI("ArkApp.ArkAppMgr", "ArkSafe.putAppUpdatePeriod app=", str, ", bizSrc=", str2, ", updatePeriodByMinutes=", Integer.valueOf(max));
        }
    }

    public static void putAppUpdateTime(String str, String str2, long j3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String appConfigCacheKey = ArkAppConfigMgr.getAppConfigCacheKey(str, str2);
        IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
        if (arkMMKV == null) {
            return;
        }
        arkMMKV.putLong(MMKVUtils.fixUpdateRecordKey(appConfigCacheKey), j3);
    }

    public static void putGlobalUpdatePeriod(int i3) {
        IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
        if (arkMMKV == null) {
            return;
        }
        arkMMKV.putInt(MMKVUtils.fixUpdateTimeKey(KEY_CHECK_APP_UPDATE_INTERVAL), i3);
    }

    private void runUpdateAppTask(List<ArkAppElement> list, final AppUpdateTask.IUpdateAppByNameCallback iUpdateAppByNameCallback) {
        if (list.isEmpty()) {
            return;
        }
        ArrayList<AppUpdateTask.UpdateApp> arrayList = new ArrayList<>();
        for (ArkAppElement arkAppElement : list) {
            AppUpdateTask.UpdateApp updateApp = new AppUpdateTask.UpdateApp();
            updateApp.appName = arkAppElement.appName;
            updateApp.bizSrc = arkAppElement.bizSrc;
            arrayList.add(updateApp);
        }
        AppUpdateTask.getInstance().updateApps(arrayList, new AppUpdateTask.IUpdateAppByNameCallback() { // from class: com.tencent.ark.open.appmanage.AppUpdateManager.3
            @Override // com.tencent.ark.open.appmanage.AppUpdateTask.IUpdateAppByNameCallback
            public void onUpdateAppByName(AppUpdateTask.UpdateTask updateTask) {
                AppUpdateManager.this.logAppUpdateResult(updateTask);
                AppUpdateTask.IUpdateAppByNameCallback iUpdateAppByNameCallback2 = iUpdateAppByNameCallback;
                if (iUpdateAppByNameCallback2 != null) {
                    iUpdateAppByNameCallback2.onUpdateAppByName(updateTask);
                }
            }
        });
    }

    private boolean shouldUpdateApp() {
        int globalUpdatePeriod = getGlobalUpdatePeriod();
        long abs = (Math.abs(System.currentTimeMillis() - this.lastTimeCheckAppUpdate) / 1000) / 60;
        if (this.lastTimeCheckAppUpdate != 0 && abs <= globalUpdatePeriod && !appUpdateDebugMode) {
            Logger.logI("ArkApp.ArkAppMgr", String.format("doUpdateInstalledApps, not update time, delta=%s, interval=%s", Long.valueOf(abs), Integer.valueOf(globalUpdatePeriod)));
            return false;
        }
        this.lastTimeCheckAppUpdate = System.currentTimeMillis();
        return true;
    }

    public static void updateAppUpdateTime(String str, String str2, int i3) {
        if (str != null && str.length() != 0) {
            putAppUpdateTime(str, str2, System.currentTimeMillis());
            if (i3 != 0) {
                putAppUpdatePeriod(str, str2, i3);
            }
        }
    }

    void addPredownloadAppToList(List<ArkAppElement> list) {
        List<ArkAppElement> list2;
        IArkDelegateSetup setupDelegate = ArkDelegateManager.getInstance().getSetupDelegate();
        if (setupDelegate != null) {
            list2 = setupDelegate.getPredownloadApp();
        } else {
            list2 = null;
        }
        if (list2 == null) {
            return;
        }
        Logger.logI("ArkApp.ArkAppMgr", String.format("addPredownloadAppToList, count=%s", Integer.valueOf(list2.size())));
        for (ArkAppElement arkAppElement : list2) {
            if (LocalAppManager.getLocalAppPathByAppName(arkAppElement.appName, arkAppElement.bizSrc) == null && !list.contains(arkAppElement)) {
                list.add(arkAppElement);
            }
        }
    }

    public void clearGlobalUpdateTime() {
        this.lastTimeCheckAppUpdate = 0L;
        Logger.logI("ArkApp.ArkAppMgr", "ArkSafe.clearGlobalUpdateTime");
    }

    public void setDebugMode(boolean z16) {
        appUpdateDebugMode = z16;
    }

    public void updateInstalledApps(final AppUpdateTask.IUpdateAppByNameCallback iUpdateAppByNameCallback) {
        beginCheckNetwork(new ICheckNetworkCallback() { // from class: com.tencent.ark.open.appmanage.AppUpdateManager.1
            @Override // com.tencent.ark.open.appmanage.AppUpdateManager.ICheckNetworkCallback
            public void onCheckNetwork(boolean z16) {
                if (!z16) {
                    Logger.logI("ArkApp.ArkAppMgr", "updateInstalledApps, network not available.");
                } else {
                    Logger.logI("ArkApp.ArkAppMgr", "updateInstalledApps, onCheckNetwork available.");
                    AppUpdateManager.this.doUpdateInstalledApps(iUpdateAppByNameCallback);
                }
            }
        });
    }
}
