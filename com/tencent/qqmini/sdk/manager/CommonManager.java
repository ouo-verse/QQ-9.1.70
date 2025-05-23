package com.tencent.qqmini.sdk.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.tissue.TissueEnvImpl;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.PreCacheManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import java.io.File;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class CommonManager implements ICommonManager {
    public static String sTissueRequiredVersion = "1.7.1";
    private String tissueSoPath;

    private boolean checkEngineAvailable(String str, String[] strArr, String str2) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            QMLog.w(TissueEnvImpl.LOG_TAG, "basePath is empty");
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        EngineVersion fromFolderName = EngineVersion.fromFolderName(file.getName());
        QMLog.i(TissueEnvImpl.LOG_TAG, "currentVersion:" + fromFolderName + ",requiredVersion:" + str2);
        if (fromFolderName != null && EngineVersion.compareVersion(fromFolderName.mMinor, str2) >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QMLog.i(TissueEnvImpl.LOG_TAG, "versionCheck:" + z16);
            return false;
        }
        return checkFileExists(str, strArr);
    }

    private static boolean checkFileExists(String str, String[] strArr) {
        for (String str2 : strArr) {
            File file = new File(str, str2);
            if (!file.exists()) {
                QMLog.w(TissueEnvImpl.LOG_TAG, file.getAbsolutePath() + " not exists");
                return false;
            }
            if (!file.isFile()) {
                QMLog.w(TissueEnvImpl.LOG_TAG, file.getAbsolutePath() + " not a file");
                return false;
            }
            if (!file.canRead()) {
                QMLog.w(TissueEnvImpl.LOG_TAG, file.getAbsolutePath() + " not readable");
                return false;
            }
        }
        QMLog.i(TissueEnvImpl.LOG_TAG, str + " is fine");
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.ICommonManager
    public void addActivityResultListener(IActivityResultListener iActivityResultListener) {
        ActivityResultManager.g().addActivityResultListener(iActivityResultListener);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.ICommonManager
    public void fetchPeriodicCacheIfNeed(final MiniAppInfo miniAppInfo) {
        if (AppLoaderFactory.g().isMainProcess()) {
            PreCacheManager.g().fetchPeriodicCacheIfNeed(miniAppInfo, new PreCacheManager.OnCacheListener() { // from class: com.tencent.qqmini.sdk.manager.CommonManager.1
                @Override // com.tencent.qqmini.sdk.core.manager.PreCacheManager.OnCacheListener
                public void onCacheUpdated(boolean z16, boolean z17) {
                    if (z16 && z17) {
                        try {
                            MiniSDK.notifyPeriodicCacheUpdate(AppLoaderFactory.g().getContext(), miniAppInfo);
                        } catch (Throwable th5) {
                            QMLog.e("CommonManager", "", th5);
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.ICommonManager
    public EngineChannel getChannelForType(int i3) {
        return EngineManager.g().getChannelForType(i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.ICommonManager
    public CrashRtInfoHolder getCrashRtInfoHolder() {
        BaseRuntime runtime;
        BaseRuntimeLoader currentRunTimeLoader = AppRuntimeLoaderManager.g().getCurrentRunTimeLoader();
        if (currentRunTimeLoader == null) {
            currentRunTimeLoader = AppRuntimeLoaderManager.g().getPrepareRuntimeLoader();
        }
        if (currentRunTimeLoader != null && (runtime = currentRunTimeLoader.getRuntime()) != null) {
            return runtime.getCrashRtInfoHolder();
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.ICommonManager
    public BaseRuntime getCurrentRuntime() {
        BaseRuntimeLoader currentRunTimeLoader = AppRuntimeLoaderManager.g().getCurrentRunTimeLoader();
        if (currentRunTimeLoader != null) {
            return currentRunTimeLoader.getRuntime();
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.ICommonManager
    public String getTissueSoPath() {
        return this.tissueSoPath;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.ICommonManager
    public void removeActivityResultListener(IActivityResultListener iActivityResultListener) {
        ActivityResultManager.g().removeActivityResultListener(iActivityResultListener);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.ICommonManager
    public void setTissueSoPath(String str) {
        this.tissueSoPath = str;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.ICommonManager
    public boolean verifyTissueEngine(String str) {
        return checkEngineAvailable(str, new String[]{MiniSDKConst.LIB_V8RT, "libflutter.so", "libapp.so"}, sTissueRequiredVersion);
    }
}
