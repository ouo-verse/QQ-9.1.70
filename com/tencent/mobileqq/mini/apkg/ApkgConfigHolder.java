package com.tencent.mobileqq.mini.apkg;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.preload.a;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ApkgConfigHolder implements Serializable {
    private static final String CONFIG_NAME = ".ApkgConfigs";
    private static final String TAG = "ApkgConfigHolder";
    private static final long serialVersionUID = 1;
    private Map<String, ApkgConfigWrapper> mApkgConfigs = new HashMap();
    private Map<String, ApkgConfigWrapper> mDebugApkgConfigs = new HashMap();
    private transient byte[] mSaveLock;
    private transient String mSavePath;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class ApkgConfigWrapper implements Serializable {
        private static final long serialVersionUID = 1;
        public MiniAppInfo apkgConfig;
        public List<MiniAppInfo> oldConfigs;

        public ApkgConfigWrapper() {
        }

        public void updateConfig(MiniAppInfo miniAppInfo) {
            MiniAppInfo miniAppInfo2 = this.apkgConfig;
            this.apkgConfig = miniAppInfo;
            if (miniAppInfo2 == null || miniAppInfo2.version == miniAppInfo.version) {
                return;
            }
            if (this.oldConfigs == null) {
                this.oldConfigs = new LinkedList();
            }
            this.oldConfigs.add(miniAppInfo);
            if (this.oldConfigs.size() > 1) {
                MiniAppInfo miniAppInfo3 = this.oldConfigs.get(0);
                this.oldConfigs.remove(0);
                ApkgConfigHolder.removeRes(miniAppInfo3);
            }
        }

        public ApkgConfigWrapper(MiniAppInfo miniAppInfo) {
            this.apkgConfig = miniAppInfo;
        }
    }

    private static String getConfigPath(AppRuntime appRuntime) {
        return appRuntime.getApplication().getFilesDir().getPath() + "/mini/" + appRuntime.getAccount() + "/" + CONFIG_NAME;
    }

    public static ApkgConfigHolder readConfig(QQAppInterface qQAppInterface) {
        ApkgConfigHolder apkgConfigHolder;
        String configPath = getConfigPath(qQAppInterface);
        try {
            apkgConfigHolder = (ApkgConfigHolder) ((IQWalletApi) QRoute.api(IQWalletApi.class)).readObject(configPath);
        } catch (Throwable th5) {
            th5.printStackTrace();
            apkgConfigHolder = null;
        }
        if (apkgConfigHolder == null) {
            apkgConfigHolder = new ApkgConfigHolder();
        }
        apkgConfigHolder.mSavePath = configPath;
        apkgConfigHolder.mSaveLock = new byte[0];
        if (apkgConfigHolder.mDebugApkgConfigs == null) {
            apkgConfigHolder.mDebugApkgConfigs = new HashMap();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "readApkgConfigHolder:" + apkgConfigHolder);
        }
        return apkgConfigHolder;
    }

    public MiniAppInfo getConfig(String str) {
        ApkgConfigWrapper apkgConfigWrapper = this.mApkgConfigs.get(str);
        if (apkgConfigWrapper != null) {
            return apkgConfigWrapper.apkgConfig;
        }
        return null;
    }

    public void saveConfig() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.apkg.ApkgConfigHolder.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ApkgConfigHolder.this.mSaveLock) {
                    IQWalletApi iQWalletApi = (IQWalletApi) QRoute.api(IQWalletApi.class);
                    ApkgConfigHolder apkgConfigHolder = ApkgConfigHolder.this;
                    iQWalletApi.saveObject(apkgConfigHolder, apkgConfigHolder.mSavePath);
                }
            }
        });
    }

    public static void removeRes(MiniAppInfo miniAppInfo) {
        if (miniAppInfo != null) {
            a.a(miniAppInfo.downloadUrl, false, 0);
            FileUtils.delete(ApkgManager.getApkgFolderPath(miniAppInfo), false);
        }
    }

    public void updateConfig(List<MiniAppInfo> list) {
        if (list != null) {
            for (MiniAppInfo miniAppInfo : list) {
                if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
                    if (miniAppInfo.verType == 3) {
                        this.mDebugApkgConfigs.get(miniAppInfo.appId);
                        this.mDebugApkgConfigs.put(miniAppInfo.appId, new ApkgConfigWrapper(miniAppInfo));
                    } else {
                        ApkgConfigWrapper apkgConfigWrapper = this.mApkgConfigs.get(miniAppInfo.appId);
                        if (apkgConfigWrapper == null) {
                            apkgConfigWrapper = new ApkgConfigWrapper();
                            this.mApkgConfigs.put(miniAppInfo.appId, new ApkgConfigWrapper(miniAppInfo));
                        }
                        apkgConfigWrapper.updateConfig(miniAppInfo);
                    }
                }
            }
            saveConfig();
        }
    }
}
