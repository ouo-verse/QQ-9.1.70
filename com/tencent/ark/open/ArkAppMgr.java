package com.tencent.ark.open;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Constants;
import com.tencent.ark.Logger;
import com.tencent.ark.StringUtil;
import com.tencent.ark.data.ArkAppElement;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.appmanage.AppManageInfoStorage;
import com.tencent.ark.open.appmanage.AppUpdateManager;
import com.tencent.ark.open.appmanage.AppUpdateTask;
import com.tencent.ark.open.appmanage.LocalAppManager;
import com.tencent.ark.open.appmanage.Utility;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.internal.ArkAppCGIMgr;
import com.tencent.ark.open.internal.WeakReferenceHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkAppMgr implements Handler.Callback {
    public static final boolean DEBUG = ArkEnvironmentManager.getInstance().getDebugFlag();
    protected static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    private static final int MSG_NotifyGetAppPathByName = 1916;
    public static final String TAG = "ArkApp.ArkAppMgr";
    private final WeakReferenceHandler mHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    private final HashMap<String, AppPathInfo> mAppPathCache = new HashMap<>();
    private final HashMap<String, AppPathInfo> mDebugAppPathCache = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class AppPathInfo {
        public static final int FROM_CACHE = 1;
        public static final int FROM_DOWNLOAD = 0;
        public static final int FROM_LOCAL = 2;
        public ArkAppInfo.AppDesc desc = new ArkAppInfo.AppDesc();
        public int from;
        public String path;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class GetAppPathByNameTask {
        public String appName;
        public AppPathInfo appPathInfo;
        public String bizSrc;
        IGetAppPathByNameCallback callback;
        public String errMsg;
        WeakReferenceHandler handler;
        public String minAppVersion;
        public int retCode = -1;

        GetAppPathByNameTask(String str, String str2, String str3) {
            this.appName = str;
            this.minAppVersion = str2;
            this.bizSrc = str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Holder {
        static final ArkAppMgr gInstance = new ArkAppMgr();

        Holder() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface IGetAppPathByNameCallback {
        void onGetAppPathByName(int i3, String str, AppPathInfo appPathInfo);
    }

    public ArkAppMgr() {
        doInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doGetAppPathByName(final GetAppPathByNameTask getAppPathByNameTask) {
        AppPathInfo appInfoFromLocal = getAppInfoFromLocal(getAppPathByNameTask.appName, getAppPathByNameTask.bizSrc, getAppPathByNameTask.minAppVersion);
        boolean hasUrlChecker = ArkAppConfigMgr.getInstance().hasUrlChecker(getAppPathByNameTask.appName, getAppPathByNameTask.bizSrc);
        if (appInfoFromLocal != null && hasUrlChecker) {
            getAppPathByNameTask.appPathInfo = appInfoFromLocal;
            asyncNotifyTaskResult(getAppPathByNameTask, 0);
            return;
        }
        Logger.logI(TAG, "getAppPathByName, app not found at local, update app, app = " + getAppPathByNameTask.appName + ",min-ver = " + getAppPathByNameTask.minAppVersion + ",bizSrc = " + getAppPathByNameTask.bizSrc);
        ArrayList<AppUpdateTask.UpdateApp> arrayList = new ArrayList<>();
        AppUpdateTask.UpdateApp updateApp = new AppUpdateTask.UpdateApp();
        updateApp.appName = getAppPathByNameTask.appName;
        updateApp.expectVersion = getAppPathByNameTask.minAppVersion;
        updateApp.bizSrc = getAppPathByNameTask.bizSrc;
        arrayList.add(updateApp);
        AppUpdateTask.getInstance().updateApps(arrayList, new AppUpdateTask.IUpdateAppByNameCallback() { // from class: com.tencent.ark.open.ArkAppMgr.3
            @Override // com.tencent.ark.open.appmanage.AppUpdateTask.IUpdateAppByNameCallback
            public void onUpdateAppByName(final AppUpdateTask.UpdateTask updateTask) {
                getAppPathByNameTask.handler.post(new Runnable() { // from class: com.tencent.ark.open.ArkAppMgr.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        ArkAppMgr.this.onUpdateAppResult(updateTask, getAppPathByNameTask);
                    }
                });
            }
        });
    }

    private static Looper getCallbackLooper() {
        if (Looper.myLooper() != null) {
            return Looper.myLooper();
        }
        return Looper.getMainLooper();
    }

    public static ArkAppMgr getInstance() {
        return Holder.gInstance;
    }

    private void notifyTaskResult(GetAppPathByNameTask getAppPathByNameTask) {
        AppPathInfo appPathInfo;
        int i3 = getAppPathByNameTask.retCode;
        if (i3 != 0) {
            getAppPathByNameTask.appPathInfo = null;
        }
        if (i3 == 0 && ((appPathInfo = getAppPathByNameTask.appPathInfo) == null || appPathInfo.path == null)) {
            getAppPathByNameTask.retCode = -1;
            Logger.logI(TAG, StringUtil.format("notifyGetAppPathByNameTaskResult, retCode is success but task.appPathInfo.path==NULL, retCode=%d, app-name=%s", -1, getAppPathByNameTask.appName));
        }
        IGetAppPathByNameCallback iGetAppPathByNameCallback = getAppPathByNameTask.callback;
        if (iGetAppPathByNameCallback != null) {
            String str = getAppPathByNameTask.errMsg;
            if (str == null || str.length() == 0) {
                getAppPathByNameTask.errMsg = Utility.QueryAppRetCodeToString(getAppPathByNameTask.retCode);
            }
            iGetAppPathByNameCallback.onGetAppPathByName(getAppPathByNameTask.retCode, getAppPathByNameTask.errMsg, getAppPathByNameTask.appPathInfo);
        }
    }

    private void preloadLocalApps() {
        for (ArkAppElement arkAppElement : LocalAppManager.enumInstalledAppName()) {
            getAppFromFile(arkAppElement.appName, arkAppElement.bizSrc);
        }
    }

    void asyncNotifyTaskResult(GetAppPathByNameTask getAppPathByNameTask, int i3) {
        getAppPathByNameTask.retCode = i3;
        getAppPathByNameTask.handler.obtainMessage(MSG_NotifyGetAppPathByName, getAppPathByNameTask).sendToTarget();
    }

    boolean checkAppSignature(AppPathInfo appPathInfo) {
        if (appPathInfo == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!DEBUG && !ArkEnvironmentManager.getInstance().isTestEnv()) {
            String str = appPathInfo.desc.name;
            String str2 = appPathInfo.path;
            File file = new File(str2);
            if (file.exists() && file.isFile()) {
                byte[] loadAppSignature = AppManageInfoStorage.loadAppSignature(str);
                if (loadAppSignature != null && loadAppSignature.length != 0) {
                    if (!ArkAppCGIMgr.verifyAppPackage(file, loadAppSignature)) {
                        Logger.logI(TAG, String.format("checkAppSignature, check fail, app=%s, path=%s", str, str2));
                        ArkAppInfo.AppDesc appDesc = appPathInfo.desc;
                        LocalAppManager.deleteAppByNameAndBiz(appDesc.name, appDesc.bizSrc, true);
                        return false;
                    }
                    Logger.logI(TAG, String.format("checkAppSignature, success, app=%s, path=%s, time=%s", str, str2, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                    return true;
                }
                Logger.logI(TAG, "checkAppSignature, sign is empty, app=" + str + ", path=" + str2);
                return true;
            }
            Logger.logI(TAG, "checkAppSignature, file not exist, app=" + str + ", path=" + str2);
            return false;
        }
        Logger.logI(TAG, "checkAppSignature, debug or test env, ignored");
        return true;
    }

    public void clearAppPathCache() {
        synchronized (this.mAppPathCache) {
            this.mAppPathCache.clear();
        }
    }

    public void clearDebugAppPathCache() {
        this.mDebugAppPathCache.clear();
    }

    protected void doInit() {
        ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.open.ArkAppMgr.1
            @Override // java.lang.Runnable
            public void run() {
                ArkAppMgr.this.doPreload();
            }
        });
    }

    void doPreload() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z16 = ArkDelegateManager.setupArkEnvironment(true);
            long currentTimeMillis2 = System.currentTimeMillis();
            preloadLocalApps();
            Logger.logI(TAG, String.format("ArkAppMgr.init, delegate-inited=%s, time1=%s, time2=%s", Boolean.valueOf(z16), Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)));
        } catch (NoClassDefFoundError e16) {
            Logger.logI(TAG, e16.toString());
        }
    }

    final AppPathInfo getAppFromCache(String str) {
        AppPathInfo debuggingAppInfo = getDebuggingAppInfo(str);
        if (debuggingAppInfo != null) {
            debuggingAppInfo.from = 1;
            return debuggingAppInfo;
        }
        AppPathInfo cachedAppInfo = getCachedAppInfo(str);
        if (cachedAppInfo != null) {
            cachedAppInfo.from = 1;
            return cachedAppInfo;
        }
        return null;
    }

    final AppPathInfo getAppFromFile(String str, String str2) {
        AppPathInfo localAppPathByAppName = LocalAppManager.getLocalAppPathByAppName(str, str2);
        if (localAppPathByAppName == null) {
            Logger.logI(TAG, String.format("doGetAppFromLocal, not found at local, app=%s", str));
            return null;
        }
        int checkAppVersion = ArkAppCacheMgr.checkAppVersion(localAppPathByAppName.path);
        if (checkAppVersion != 1) {
            Logger.logI(TAG, String.format("doGetAppFromLocal, not support version, ret=%s, app=%s, app-ver=%s", Integer.valueOf(checkAppVersion), str, localAppPathByAppName.desc.version));
            LocalAppManager.deleteAppByNameAndBiz(str, str2, false);
            return null;
        }
        if (!checkAppSignature(localAppPathByAppName)) {
            Logger.logI(TAG, String.format("doGetAppFromLocal, signature failed, ret=%s, app=%s, app-ver=%s", Integer.valueOf(checkAppVersion), str, localAppPathByAppName.desc.version));
            return null;
        }
        synchronized (this.mAppPathCache) {
            this.mAppPathCache.put(localAppPathByAppName.desc.name, localAppPathByAppName);
        }
        localAppPathByAppName.from = 2;
        return localAppPathByAppName;
    }

    public AppPathInfo getAppInfoFromCache(String str, String str2, String str3) {
        return getAppPathInfoByNameFromLocal(str, str2, str3, true);
    }

    public AppPathInfo getAppInfoFromLocal(String str, String str2, String str3) {
        return getAppPathInfoByNameFromLocal(str, str2, str3, false);
    }

    public void getAppPathByName(String str, String str2, String str3, IGetAppPathByNameCallback iGetAppPathByNameCallback) {
        final GetAppPathByNameTask getAppPathByNameTask = new GetAppPathByNameTask(str, str2, str3);
        getAppPathByNameTask.callback = iGetAppPathByNameCallback;
        getAppPathByNameTask.handler = new WeakReferenceHandler(getCallbackLooper(), this);
        if (str != null && str.length() != 0 && ArkUtil.isDeviceSupportArkMsg()) {
            ArkDelegateManager.setupArkEnvironment(true);
            if (!ArkEnvironmentManager.getInstance().isLibraryLoad()) {
                asyncNotifyTaskResult(getAppPathByNameTask, -6);
                return;
            } else {
                ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.open.ArkAppMgr.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ArkAppMgr.this.doGetAppPathByName(getAppPathByNameTask);
                    }
                });
                return;
            }
        }
        asyncNotifyTaskResult(getAppPathByNameTask, -1);
    }

    public String getAppPathFromCache(String str, String str2, String str3) {
        AppPathInfo appInfoFromCache = getAppInfoFromCache(str, str2, str3);
        if (appInfoFromCache != null) {
            return appInfoFromCache.path;
        }
        return null;
    }

    public String getAppPathFromLocal(String str, String str2, String str3) {
        AppPathInfo appInfoFromLocal = getAppInfoFromLocal(str, str2, str3);
        if (appInfoFromLocal != null) {
            return appInfoFromLocal.path;
        }
        return null;
    }

    AppPathInfo getAppPathInfoByNameFromLocal(String str, String str2, String str3, boolean z16) {
        if (str == null || str.length() == 0 || !ArkUtil.isDeviceSupportArkMsg()) {
            return null;
        }
        AppManageInfoStorage.updateAppLastUseTime(str, str2);
        AppPathInfo appFromCache = getAppFromCache(str);
        if (appFromCache == null && !z16) {
            appFromCache = getAppFromFile(str, str2);
        }
        if (appFromCache == null) {
            return null;
        }
        if (str3 != null && Utility.compareVersionString(appFromCache.desc.version, str3) < 0) {
            return null;
        }
        return appFromCache;
    }

    AppPathInfo getCachedAppInfo(String str) {
        synchronized (this.mAppPathCache) {
            AppPathInfo appPathInfo = this.mAppPathCache.get(str);
            if (appPathInfo == null) {
                return null;
            }
            if (appPathInfo.path == null) {
                this.mAppPathCache.remove(str);
                return null;
            }
            File file = new File(appPathInfo.path);
            if (file.exists() && file.isFile()) {
                return appPathInfo;
            }
            this.mAppPathCache.remove(str);
            return null;
        }
    }

    AppPathInfo getDebuggingAppInfo(String str) {
        synchronized (this.mDebugAppPathCache) {
            AppPathInfo appPathInfo = this.mDebugAppPathCache.get(str);
            if (appPathInfo != null && appPathInfo.path != null) {
                File file = new File(appPathInfo.path);
                if (!file.exists() || !file.isFile()) {
                    return null;
                }
                return appPathInfo;
            }
            return null;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == MSG_NotifyGetAppPathByName) {
            notifyTaskResult((GetAppPathByNameTask) message.obj);
            return true;
        }
        return false;
    }

    public void onDestroy() {
        Logger.logI(TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        clearAppPathCache();
        clearDebugAppPathCache();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    void onUpdateAppResult(AppUpdateTask.UpdateTask updateTask, GetAppPathByNameTask getAppPathByNameTask) {
        String str;
        int i3 = updateTask.retCode;
        String str2 = updateTask.errMsg;
        AppUpdateTask.UpdateApp updateApp = updateTask.app;
        String str3 = updateApp.appName;
        String str4 = updateApp.bizSrc;
        if (i3 != 0) {
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = str3;
            objArr[2] = str4;
            if (str2 != null) {
                str = str2;
            } else {
                str = "unknown";
            }
            objArr[3] = str;
            Logger.logI(TAG, String.format("onUpdateAppResult fail, retCode=%s, app-name=%s, bizSrc=%s, msg=%s", objArr));
        } else if (Utility.compareVersionString(updateTask.appPathInfo.desc.version, getAppPathByNameTask.minAppVersion) >= 0) {
            Logger.logI(TAG, String.format("onUpdateAppResult: success, result=%s, app-name=%s, bizSrc=%s, expect-ver=%s, local-ver=%s", AppUpdateTask.resultValueToString(updateTask.result), str3, str4, getAppPathByNameTask.minAppVersion, updateTask.appPathInfo.desc.version));
        } else {
            Logger.logI(TAG, String.format("onUpdateAppResult fail, invalid app version, result=%s, app-name=%s, bizSrc=%s, expect-ver=%s, local-ver=%s", AppUpdateTask.resultValueToString(updateTask.result), str3, str4, getAppPathByNameTask.minAppVersion, updateTask.appPathInfo.desc.version));
            i3 = 6;
            str2 = null;
        }
        getAppPathByNameTask.retCode = i3;
        getAppPathByNameTask.errMsg = str2;
        if (i3 == 0) {
            getAppPathByNameTask.appPathInfo = updateTask.appPathInfo;
            synchronized (this.mAppPathCache) {
                this.mAppPathCache.put(getAppPathByNameTask.appName, getAppPathByNameTask.appPathInfo);
            }
        }
        notifyTaskResult(getAppPathByNameTask);
    }

    public void setDebugAppPathCache(String str, String str2) {
        setDebugAppPathCache(str, "", str2);
    }

    public void updateInstalledApps() {
        AppUpdateManager.getInstance().updateInstalledApps(new AppUpdateTask.IUpdateAppByNameCallback() { // from class: com.tencent.ark.open.ArkAppMgr.4
            @Override // com.tencent.ark.open.appmanage.AppUpdateTask.IUpdateAppByNameCallback
            public void onUpdateAppByName(AppUpdateTask.UpdateTask updateTask) {
                synchronized (ArkAppMgr.this.mAppPathCache) {
                    if (updateTask.appPathInfo != null) {
                        ArkAppMgr.this.mAppPathCache.put(updateTask.app.appName, updateTask.appPathInfo);
                    }
                }
            }
        });
    }

    public void setDebugAppPathCache(String str, String str2, String str3) {
        AppPathInfo appPathInfo = new AppPathInfo();
        appPathInfo.path = str3;
        ArkAppInfo.AppDesc appDesc = appPathInfo.desc;
        appDesc.name = str;
        appDesc.bizSrc = str2;
        appDesc.version = ArkAppCacheMgr.getApplicationVersion(str3);
        synchronized (this.mDebugAppPathCache) {
            this.mDebugAppPathCache.put(str, appPathInfo);
        }
    }

    public String getAppPathFromCache(String str, String str2) {
        return getAppPathFromCache(str, str2, Constants.DEFAULT_MIN_APP_VERSION);
    }

    public String getAppPathFromLocal(String str, String str2) {
        return getAppPathFromLocal(str, str2, Constants.DEFAULT_MIN_APP_VERSION);
    }
}
