package com.tencent.ark.open.appmanage;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Constants;
import com.tencent.ark.Logger;
import com.tencent.ark.StringUtil;
import com.tencent.ark.open.ArkAppBizMgr;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkUtil;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateNet;
import com.tencent.ark.open.internal.ArkAppCGIMgr;
import com.tencent.mobileqq.mini.api.MiniConst;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AppUpdateTask {
    public static final int MIN_APP_UPDATE_INTERVAL = 10;
    private static final String TAG = "ArkApp.ArkAppMgr";
    private final ArrayList<UpdateTask> mUpdateAppTaskList = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Holder {
        static final AppUpdateTask instance = new AppUpdateTask();

        protected Holder() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface IUpdateAppByNameCallback {
        void onUpdateAppByName(UpdateTask updateTask);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Result {
        public static final int Fail = 0;
        public static final int NoUpdate = 2;
        public static final int Update = 1;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class UpdateApp {
        public String appName;
        public String bizSrc;
        public String expectVersion;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class UpdateTask {
        public UpdateApp app;
        public ArkAppMgr.AppPathInfo appPathInfo;
        ArkAppInfo.AppDownloadInfo downloadInfo;
        public String errMsg;
        ArkAppMgr.AppPathInfo localAppPathInfo;
        public int result = 0;
        public int retCode = -1;
        final ArrayList<IUpdateAppByNameCallback> callback = new ArrayList<>();
        long startTime = System.currentTimeMillis();

        public String getAppVersion() {
            ArkAppInfo.AppDesc appDesc;
            ArkAppMgr.AppPathInfo appPathInfo = this.localAppPathInfo;
            if (appPathInfo != null && (appDesc = appPathInfo.desc) != null) {
                return appDesc.version;
            }
            return "0.0.0.0";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateTask buildTask(UpdateApp updateApp, IUpdateAppByNameCallback iUpdateAppByNameCallback) {
        UpdateTask updateTask = new UpdateTask();
        updateTask.app = updateApp;
        updateTask.localAppPathInfo = LocalAppManager.getLocalAppPathByAppName(updateApp.appName, updateApp.bizSrc);
        updateTask.callback.add(iUpdateAppByNameCallback);
        return updateTask;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String copyAppPackageToAppInstallDir(String str, String str2, String str3, byte[] bArr) {
        FileOutputStream fileOutputStream;
        String appPathByNameAndVersion;
        ?? r26 = 0;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            try {
                File file = new File(Utility.getAppDirByNameAndVersion(str));
                if (!file.exists()) {
                    file.delete();
                    file.mkdirs();
                } else if (file.isFile()) {
                    file.delete();
                    file.mkdirs();
                }
                appPathByNameAndVersion = Utility.getAppPathByNameAndVersion(str, str2, str3);
                fileOutputStream = new FileOutputStream(appPathByNameAndVersion);
            } catch (Exception e16) {
                e = e16;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (r26 != 0) {
                }
                throw th;
            }
            try {
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.close();
                } catch (Exception e17) {
                    Logger.logI("ArkApp.ArkAppMgr", "copyAppPackageToAppInstallDir, exception:", e17.getMessage());
                }
                return appPathByNameAndVersion;
            } catch (Exception e18) {
                e = e18;
                e.printStackTrace();
                Logger.logI("ArkApp.ArkAppMgr", "copyAppPackageToAppInstallDir, exception:", e.getMessage());
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e19) {
                        Logger.logI("ArkApp.ArkAppMgr", "copyAppPackageToAppInstallDir, exception:", e19.getMessage());
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            r26 = str2;
            if (r26 != 0) {
                try {
                    r26.close();
                } catch (Exception e26) {
                    Logger.logI("ArkApp.ArkAppMgr", "copyAppPackageToAppInstallDir, exception:", e26.getMessage());
                }
            }
            throw th;
        }
    }

    private static synchronized void deleteOldAppWhenUpdateSuccess(String str, final String str2, final boolean z16) {
        synchronized (AppUpdateTask.class) {
            if (str != null) {
                if (str.length() != 0 && str2 != null && str2.length() != 0) {
                    String appDirByNameAndVersion = Utility.getAppDirByNameAndVersion(str);
                    if (appDirByNameAndVersion != null && appDirByNameAndVersion.length() != 0) {
                        File file = new File(appDirByNameAndVersion);
                        if (!file.isDirectory()) {
                            return;
                        }
                        if (!file.exists()) {
                            return;
                        }
                        file.listFiles(new FileFilter() { // from class: com.tencent.ark.open.appmanage.AppUpdateTask.5
                            @Override // java.io.FileFilter
                            public boolean accept(File file2) {
                                String name = file2.getName();
                                int lastIndexOf = name.lastIndexOf(46);
                                if (lastIndexOf <= 0 || TextUtils.isEmpty(name.substring(lastIndexOf))) {
                                    return false;
                                }
                                String substring = name.substring(0, lastIndexOf);
                                if (!Utility.isValidAppVersion(substring) || Utility.compareVersionString(substring, str2) >= 0) {
                                    return false;
                                }
                                if (z16) {
                                    file2.deleteOnExit();
                                    return true;
                                }
                                file2.delete();
                                return true;
                            }
                        });
                    }
                }
            }
        }
    }

    private void flushAppUpdateTime(UpdateTask updateTask) {
        int i3;
        ArkAppInfo.AppDownloadInfo appDownloadInfo = updateTask.downloadInfo;
        if (appDownloadInfo != null) {
            i3 = randomize(appDownloadInfo.updatePeriodByMinutes);
        } else {
            i3 = 0;
        }
        UpdateApp updateApp = updateTask.app;
        AppUpdateManager.updateAppUpdateTime(updateApp.appName, updateApp.bizSrc, i3);
    }

    public static AppUpdateTask getInstance() {
        return Holder.instance;
    }

    private void handleAppConfigUpdate(String str, String str2, ArkAppCGIMgr.QueryAppInfoResult queryAppInfoResult) {
        ArkAppInfo.AppDownloadInfo appDownloadInfo = queryAppInfoResult.info;
        if (appDownloadInfo != null && appDownloadInfo.config != null) {
            ArkAppConfigMgr.getInstance().saveAppConfig(str, str2, queryAppInfoResult.info.config);
        } else {
            ArkAppConfigMgr.getInstance().getAppConfig(str, str2);
        }
    }

    private void handleAppUpdate(UpdateTask updateTask, String str, ArkAppCGIMgr.QueryAppInfoResult queryAppInfoResult) {
        UpdateApp updateApp;
        if (updateTask != null && (updateApp = updateTask.app) != null) {
            if (queryAppInfoResult == null) {
                Logger.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_QueryAppInfoByAppNameResult, info is null, app-name=%s", str));
                notifyUpdateAppByNameResult(0, -2, null, updateTask);
                return;
            }
            String str2 = updateApp.bizSrc;
            if (!TextUtils.isEmpty(str2)) {
                ArkAppBizMgr.getInstance().putBizSrcInList(str, str2);
            }
            handleAppConfigUpdate(str, str2, queryAppInfoResult);
            int i3 = queryAppInfoResult.retCode;
            if (i3 != 0) {
                Logger.logI("ArkApp.ArkAppMgr", StringUtil.format("handleAppUpdate, retCode is not SUCCESS, app%s, ret=%d", str, Integer.valueOf(i3)));
                notifyUpdateAppByNameResult(0, queryAppInfoResult.retCode, queryAppInfoResult.f72568msg, updateTask);
                return;
            }
            int i16 = queryAppInfoResult.state;
            if (i16 == 3) {
                Logger.logI("ArkApp.ArkAppMgr", String.format("handleAppUpdate, app offline, app=%s", str));
                LocalAppManager.deleteAppByNameAndBiz(str, str2, true);
                notifyUpdateAppByNameResult(0, -5, queryAppInfoResult.f72568msg, updateTask);
                return;
            }
            if (i16 == 2) {
                ArkAppMgr.AppPathInfo appPathInfo = updateTask.localAppPathInfo;
                if (appPathInfo == null) {
                    Logger.logI("ArkApp.ArkAppMgr", String.format("handleAppUpdate, no update, no local app, app=%s", str));
                    notifyUpdateAppByNameResult(0, -1, null, updateTask);
                    return;
                } else {
                    updateTask.appPathInfo = appPathInfo;
                    notifyUpdateAppByNameResult(2, 0, null, updateTask);
                    return;
                }
            }
            if (i16 == 1) {
                ArkAppInfo.AppDownloadInfo appDownloadInfo = queryAppInfoResult.info;
                if (appDownloadInfo == null) {
                    Logger.logI("ArkApp.ArkAppMgr", StringUtil.format("handleAppUpdate, appResult.info is NULL, app-name=%s, ret-code=%d", str, Integer.valueOf(i3)));
                    notifyUpdateAppByNameResult(0, -1, null, updateTask);
                    return;
                }
                updateTask.downloadInfo = appDownloadInfo;
                ArkAppMgr.AppPathInfo appPathInfo2 = new ArkAppMgr.AppPathInfo();
                updateTask.appPathInfo = appPathInfo2;
                ArkAppInfo.AppDownloadInfo appDownloadInfo2 = queryAppInfoResult.info;
                appPathInfo2.desc = appDownloadInfo2.desc;
                AppManageInfoStorage.saveAppSignature(str, appDownloadInfo2.sign);
                ArkAppCGIMgr arkAppCGIMgr = ArkAppCGIMgr.getInstance();
                ArkAppInfo.AppDownloadInfo appDownloadInfo3 = queryAppInfoResult.info;
                arkAppCGIMgr.downloadAppPackage(appDownloadInfo3.downloadUrl, appDownloadInfo3.sign, updateTask, new ArkAppCGIMgr.ArkAppCGICallback() { // from class: com.tencent.ark.open.appmanage.AppUpdateTask.3
                    @Override // com.tencent.ark.open.internal.ArkAppCGIMgr.ArkAppCGICallback
                    public void onDownloadAppPackage(final boolean z16, final byte[] bArr, final Object obj) {
                        ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.open.appmanage.AppUpdateTask.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AppUpdateTask.this.onDownloadAppPackageResult(z16, bArr, (UpdateTask) obj);
                            }
                        });
                    }
                });
                return;
            }
            Logger.logI("ArkApp.ArkAppMgr", StringUtil.format("handleAppUpdate, invalid app state, app=%s, state=%d", str, Integer.valueOf(i16)));
            notifyUpdateAppByNameResult(0, -1, null, updateTask);
            return;
        }
        Logger.logE("ArkApp.ArkAppMgr", "handleAppUpdate task or task.app is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mergeTask(String str, String str2, IUpdateAppByNameCallback iUpdateAppByNameCallback) {
        synchronized (this.mUpdateAppTaskList) {
            Iterator<UpdateTask> it = this.mUpdateAppTaskList.iterator();
            while (it.hasNext()) {
                UpdateTask next = it.next();
                boolean equalsIgnoreCase = next.app.appName.equalsIgnoreCase(str);
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                if (TextUtils.isEmpty(next.app.appName)) {
                    next.app.appName = "";
                }
                boolean equals = TextUtils.equals(next.app.bizSrc, str2);
                if (equalsIgnoreCase && equals) {
                    next.callback.add(iUpdateAppByNameCallback);
                    Logger.logI("ArkApp.ArkAppMgr", StringUtil.format("updateApps, request merged, app=%s, time=%d", str, Long.valueOf(next.startTime)));
                    return true;
                }
            }
            return false;
        }
    }

    private void notifyUpdateAppByNameResult(int i3, int i16, String str, final UpdateTask updateTask) {
        boolean z16;
        synchronized (this.mUpdateAppTaskList) {
            this.mUpdateAppTaskList.remove(updateTask);
        }
        updateTask.result = i3;
        updateTask.retCode = i16;
        updateTask.errMsg = str;
        if (i16 != 0) {
            updateTask.appPathInfo = null;
        } else {
            ArkAppMgr.AppPathInfo appPathInfo = updateTask.appPathInfo;
            if (appPathInfo != null && appPathInfo.path != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            ArkUtil.assertTrue(z16);
            flushAppUpdateTime(updateTask);
        }
        report(updateTask);
        ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.ark.open.appmanage.AppUpdateTask.4
            @Override // java.lang.Runnable
            public void run() {
                for (int i17 = 0; i17 < updateTask.callback.size(); i17++) {
                    IUpdateAppByNameCallback iUpdateAppByNameCallback = updateTask.callback.get(i17);
                    if (iUpdateAppByNameCallback != null) {
                        iUpdateAppByNameCallback.onUpdateAppByName(updateTask);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DefaultLocale"})
    public void onDownloadAppPackageResult(boolean z16, byte[] bArr, UpdateTask updateTask) {
        if (z16 && bArr.length != 0) {
            UpdateApp updateApp = updateTask.app;
            String str = updateApp.appName;
            String str2 = updateApp.bizSrc;
            ArkAppInfo.AppDesc appDesc = updateTask.appPathInfo.desc;
            String copyAppPackageToAppInstallDir = copyAppPackageToAppInstallDir(appDesc.name, appDesc.version, getAppFileExtension(updateTask), bArr);
            if (copyAppPackageToAppInstallDir == null) {
                ArkAppInfo.AppDesc appDesc2 = updateTask.appPathInfo.desc;
                Logger.logI("ArkApp.ArkAppMgr", String.format("onDownloadAppPackageResult, copy file fail, app-name=%s, app-version=%s", appDesc2.name, appDesc2.version));
                notifyUpdateAppByNameResult(0, -3, null, updateTask);
                return;
            }
            ArkAppCacheMgr.cacheManifestInfo(copyAppPackageToAppInstallDir, str2, str);
            int checkAppVersion = ArkAppCacheMgr.checkAppVersion(copyAppPackageToAppInstallDir);
            if (checkAppVersion != 1) {
                Logger.logI("ArkApp.ArkAppMgr", String.format("onDownloadAppPackageResult, check version fail, ret=%d, app-name=%s, app-path=%s", Integer.valueOf(checkAppVersion), str, copyAppPackageToAppInstallDir));
                LocalAppManager.deleteAppByNameAndBiz(str, str2, false);
                notifyUpdateAppByNameResult(0, 7, null, updateTask);
                return;
            }
            AppManageInfoStorage.saveAppDesc(updateTask.appPathInfo.desc.name, ArkAppCacheMgr.getApplicationDesc(str));
            ArkAppInfo.AppDesc appDesc3 = updateTask.appPathInfo.desc;
            Logger.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_DownloadAppPackageResult, success, app-name=%s, app-version=%s, app-path=%s", appDesc3.name, appDesc3.version, copyAppPackageToAppInstallDir));
            ArkAppMgr.AppPathInfo appPathInfo = updateTask.appPathInfo;
            appPathInfo.path = copyAppPackageToAppInstallDir;
            appPathInfo.from = 0;
            deleteOldAppWhenUpdateSuccess(str, appPathInfo.desc.version, true);
            notifyUpdateAppByNameResult(1, 0, null, updateTask);
            return;
        }
        Logger.logI("ArkApp.ArkAppMgr", String.format("onDownloadAppPackageResult fail, app=%s", updateTask.app.appName));
        notifyUpdateAppByNameResult(0, -2, null, updateTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DefaultLocale"})
    public void onQueryAppInfoByAppNameResult(ArkAppCGIMgr.QueryAppInfoByAppNameBatchResult queryAppInfoByAppNameBatchResult, ArrayList<UpdateTask> arrayList) {
        int i3 = queryAppInfoByAppNameBatchResult.updateInterval;
        if (i3 > 0) {
            AppUpdateManager.putGlobalUpdatePeriod(i3);
        }
        Iterator<UpdateTask> it = arrayList.iterator();
        while (it.hasNext()) {
            UpdateTask next = it.next();
            UpdateApp updateApp = next.app;
            String str = updateApp.appName;
            handleAppUpdate(next, str, queryAppInfoByAppNameBatchResult.resultList.get(ArkAppConfigMgr.getAppConfigCacheKey(str, updateApp.bizSrc)));
        }
    }

    private void report(UpdateTask updateTask) {
        int i3;
        boolean z16;
        HashMap hashMap = new HashMap();
        hashMap.put("appid", updateTask.app.appName);
        hashMap.put("result", String.valueOf(updateTask.result));
        hashMap.put("errorCode", String.valueOf(updateTask.retCode));
        if (updateTask.localAppPathInfo != null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        hashMap.put(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, String.valueOf(i3));
        hashMap.put("netType", String.valueOf(getNetType()));
        ArkEnvironmentManager arkEnvironmentManager = ArkEnvironmentManager.getInstance();
        String str = updateTask.app.appName;
        if (updateTask.retCode == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        arkEnvironmentManager.doDataReport(str, Constants.Event.ArkAppUpdateMonitor, z16, (int) (System.currentTimeMillis() - updateTask.startTime), hashMap);
    }

    public static String resultValueToString(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return "Unknown";
                }
                return "NoUpdate";
            }
            return "Update";
        }
        return "Fail";
    }

    String getAppFileExtension(UpdateTask updateTask) {
        int lastIndexOf;
        String str = updateTask.downloadInfo.downloadUrl;
        if (str != null && (lastIndexOf = str.lastIndexOf(46)) > 0) {
            return updateTask.downloadInfo.downloadUrl.substring(lastIndexOf + 1);
        }
        return "ark";
    }

    protected int getNetType() {
        IArkDelegateNet netDelegate = ArkDelegateManager.getInstance().getNetDelegate();
        if (netDelegate != null) {
            return netDelegate.getNetworkType();
        }
        return -1;
    }

    protected void queryAppInfo(final ArrayList<UpdateTask> arrayList) {
        ArrayList<ArkAppCGIMgr.AppNameVersion> arrayList2 = new ArrayList<>();
        Iterator<UpdateTask> it = arrayList.iterator();
        while (it.hasNext()) {
            UpdateTask next = it.next();
            ArkAppCGIMgr.AppNameVersion appNameVersion = new ArkAppCGIMgr.AppNameVersion();
            appNameVersion.appName = next.app.appName;
            appNameVersion.appVersion = next.getAppVersion();
            UpdateApp updateApp = next.app;
            appNameVersion.expectAppVersion = updateApp.expectVersion;
            appNameVersion.bizSrc = updateApp.bizSrc;
            arrayList2.add(appNameVersion);
        }
        ArkAppCGIMgr.getInstance().queryAppInfoByAppName(arrayList2, new ArkAppCGIMgr.ArkAppCGICallback() { // from class: com.tencent.ark.open.appmanage.AppUpdateTask.2
            @Override // com.tencent.ark.open.internal.ArkAppCGIMgr.ArkAppCGICallback
            public void onQueryAppInfoByAppName(ArkAppCGIMgr.QueryAppInfoByAppNameBatchResult queryAppInfoByAppNameBatchResult) {
                AppUpdateTask.this.onQueryAppInfoByAppNameResult(queryAppInfoByAppNameBatchResult, arrayList);
            }
        });
    }

    int randomize(int i3) {
        return (int) (i3 * (((Math.random() * 0.4000000059604645d) + 1.0d) - 0.20000000298023224d));
    }

    public void updateApps(final ArrayList<UpdateApp> arrayList, final IUpdateAppByNameCallback iUpdateAppByNameCallback) {
        if (arrayList != null && arrayList.size() != 0) {
            ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.open.appmanage.AppUpdateTask.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<UpdateTask> arrayList2 = new ArrayList<>();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        UpdateApp updateApp = (UpdateApp) it.next();
                        if (!AppUpdateTask.this.mergeTask(updateApp.appName, updateApp.bizSrc, iUpdateAppByNameCallback)) {
                            UpdateTask buildTask = AppUpdateTask.this.buildTask(updateApp, iUpdateAppByNameCallback);
                            synchronized (AppUpdateTask.this.mUpdateAppTaskList) {
                                AppUpdateTask.this.mUpdateAppTaskList.add(buildTask);
                            }
                            arrayList2.add(buildTask);
                        }
                    }
                    AppUpdateTask.this.queryAppInfo(arrayList2);
                }
            });
        } else {
            Logger.logI("ArkApp.ArkAppMgr", "updateApps, appNameList=null");
        }
    }
}
