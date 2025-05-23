package com.tencent.qqmini.sdk.launcher.core.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.ApkgFileUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes23.dex */
public class PreLoadApkgToStrHelper {
    private static final String PRELOAD_APKG_THREAD_NAME = "preload_apkg_thread";
    private static final String TAG = "PreLoadApkgToStrHelper";
    private final Set<String> mApkgNameSet;
    private final Map<String, String> mApkgToStrMap;
    private final boolean mIsPreloadApkg;
    private final Handler mPreloadApkgHandler;
    private final HandlerThread mPreloadApkgThread;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class SingletonHolder {
        public static final PreLoadApkgToStrHelper INSTANCE = new PreLoadApkgToStrHelper();

        SingletonHolder() {
        }
    }

    public static PreLoadApkgToStrHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File[] getMiniAppApkgDirFiles(String str) {
        File file = new File(str);
        if (file.isDirectory()) {
            return file.listFiles();
        }
        return new File[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isApkgFileValid(File file) {
        if (file != null && file.exists() && !file.isDirectory() && file.canRead()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putApkgInfoStringToMap(String str, File file) {
        if (!this.mIsPreloadApkg) {
            QMLog.i(TAG, "preload apkg is not open!");
        }
        if (!isApkgFileValid(file)) {
            QMLog.e(TAG, "apkg file is invalid!");
            return;
        }
        if (this.mApkgToStrMap.containsKey(str + "_" + file.getName())) {
            QMLog.e(TAG, "mMiniApkgNameMap contains appId: " + str + " apkgFile:" + file.getName());
            return;
        }
        if (AppLoaderFactory.g().isMainProcess()) {
            QMLog.i(TAG, "putApkgInfoStringToMap not cache in main thread!");
            return;
        }
        try {
            HashMap<String, ApkgFileUtils.WxapkgFile> fileMapFromApkg = ApkgFileUtils.getFileMapFromApkg(file);
            if (fileMapFromApkg != null && !fileMapFromApkg.isEmpty()) {
                for (Map.Entry<String, ApkgFileUtils.WxapkgFile> entry : fileMapFromApkg.entrySet()) {
                    this.mApkgToStrMap.put(str + "_" + file.getName() + "_" + entry.getValue().start + "_" + entry.getValue().length, ApkgFileUtils.readApkgToStr(file, entry.getValue().start, entry.getValue().length));
                }
                QMLog.i(TAG, "preload apkg file name:" + file.getName());
                this.mApkgNameSet.add(str + "_" + file.getName());
            }
        } catch (IOException e16) {
            QMLog.e(TAG, "preloadApkgInfoToMap getFileMapFromApkg error!", e16);
        }
    }

    public void clearApkgToStrMap() {
        if (!this.mIsPreloadApkg) {
            QMLog.i(TAG, "clearApkgToStrMap preload apkg is not open!");
            return;
        }
        if (!this.mApkgToStrMap.isEmpty()) {
            QMLog.i(TAG, "clearApkgToStrMap apkgToStrMap is empty!");
        } else if (AppLoaderFactory.g().isMainProcess()) {
            QMLog.i(TAG, "clearApkgToStrMap not cache in main thread!");
        } else {
            this.mPreloadApkgHandler.post(new Runnable() { // from class: com.tencent.qqmini.sdk.launcher.core.utils.PreLoadApkgToStrHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    PreLoadApkgToStrHelper.this.mApkgToStrMap.clear();
                }
            });
        }
    }

    public String getApkgToStringFromMap(String str) {
        if (!this.mIsPreloadApkg) {
            QMLog.i(TAG, "preload apkg is not open!");
            return "";
        }
        if (!this.mApkgToStrMap.isEmpty() && !TextUtils.isEmpty(str)) {
            if (!this.mApkgToStrMap.containsKey(str)) {
                QMLog.i(TAG, "mApkgToStrMap is not contains key!");
                return "";
            }
            if (AppLoaderFactory.g().isMainProcess()) {
                QMLog.i(TAG, "getApkgToStringFromMap not cache in main thread!");
                return "";
            }
            return this.mApkgToStrMap.get(str);
        }
        QMLog.i(TAG, "mApkgToStrMap is empty or apkgInfoKey is invalid!");
        return "";
    }

    public void preloadMainApkgInfoToMap(final MiniAppInfo miniAppInfo) {
        if (!this.mIsPreloadApkg) {
            QMLog.i(TAG, "preload apkg is not open!");
            return;
        }
        if (miniAppInfo == null) {
            QMLog.e(TAG, "preloadMainApkgInfoToMap miniAppInfo is null!");
        } else if (AppLoaderFactory.g().isMainProcess()) {
            QMLog.i(TAG, "preloadMainApkgInfoToMap not cache in main thread!");
        } else {
            this.mPreloadApkgHandler.post(new Runnable() { // from class: com.tencent.qqmini.sdk.launcher.core.utils.PreLoadApkgToStrHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    String apkgFolderPath = ApkgManager.getApkgFolderPath(miniAppInfo);
                    if (TextUtils.isEmpty(apkgFolderPath)) {
                        QMLog.e(PreLoadApkgToStrHelper.TAG, "apkgFilePath is null or empty!");
                        return;
                    }
                    File file = new File(apkgFolderPath + File.separator + ApkgInfo.NAME_MAIN_APKG);
                    if (PreLoadApkgToStrHelper.this.isApkgFileValid(file)) {
                        PreLoadApkgToStrHelper.this.putApkgInfoStringToMap(miniAppInfo.appId, file);
                    }
                }
            });
        }
    }

    public void preloadSubApkgInfoToMap(final MiniAppInfo miniAppInfo) {
        if (!this.mIsPreloadApkg) {
            QMLog.i(TAG, "preload apkg is not open!");
            return;
        }
        if (miniAppInfo == null) {
            QMLog.e(TAG, "preloadSubApkgInfoToMap miniAppInfo is null!");
        } else if (AppLoaderFactory.g().isMainProcess()) {
            QMLog.i(TAG, "preloadSubApkgInfoToMap not cache in main thread!");
        } else {
            this.mPreloadApkgHandler.post(new Runnable() { // from class: com.tencent.qqmini.sdk.launcher.core.utils.PreLoadApkgToStrHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    String apkgFolderPath = ApkgManager.getApkgFolderPath(miniAppInfo);
                    if (!TextUtils.isEmpty(apkgFolderPath)) {
                        for (File file : PreLoadApkgToStrHelper.this.getMiniAppApkgDirFiles(apkgFolderPath)) {
                            PreLoadApkgToStrHelper.this.putApkgInfoStringToMap(miniAppInfo.appId, file);
                        }
                        return;
                    }
                    QMLog.e(PreLoadApkgToStrHelper.TAG, "apkgFilePath is null or empty!");
                }
            });
        }
    }

    public void putApkgToStringToMap(String str, String str2) {
        if (!this.mIsPreloadApkg) {
            QMLog.i(TAG, "preload apkg is not open!");
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (AppLoaderFactory.g().isMainProcess()) {
                QMLog.i(TAG, "putApkgToStringToMap not cache in main thread!");
                return;
            } else {
                this.mApkgToStrMap.put(str, str2);
                return;
            }
        }
        QMLog.i(TAG, "mApkgToStrMap is not contains key!");
    }

    PreLoadApkgToStrHelper() {
        this.mApkgToStrMap = new HashMap();
        this.mApkgNameSet = new HashSet();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(PRELOAD_APKG_THREAD_NAME);
        this.mPreloadApkgThread = baseHandlerThread;
        baseHandlerThread.start();
        this.mPreloadApkgHandler = new Handler(baseHandlerThread.getLooper());
        this.mIsPreloadApkg = AppLoaderFactory.g().getMiniAppEnv().getPreloadApkgState();
    }
}
