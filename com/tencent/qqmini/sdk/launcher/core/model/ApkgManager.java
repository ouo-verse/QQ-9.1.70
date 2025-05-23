package com.tencent.qqmini.sdk.launcher.core.model;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ApkgManager {
    private static final String TAG = "ApkgManager";
    private static volatile ApkgManager sInstance;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class RootPath {
        private static String PATH_APKG_TISSUE_ROOT;
        private static String PATH_GAMEPKG_ROOT;
        private static String PATH_WXAPKG_ROOT;

        static /* synthetic */ String access$000() {
            return getGamePkgRoot();
        }

        static /* synthetic */ String access$100() {
            return getTissuePkgRoot();
        }

        static /* synthetic */ String access$200() {
            return getAppPkgRoot();
        }

        private static String getAppPkgRoot() {
            if (PATH_WXAPKG_ROOT == null) {
                PATH_WXAPKG_ROOT = getRoot() + "/mini/";
            }
            return PATH_WXAPKG_ROOT;
        }

        private static String getGamePkgRoot() {
            if (PATH_GAMEPKG_ROOT == null) {
                PATH_GAMEPKG_ROOT = getRoot() + "/minigame/";
            }
            return PATH_GAMEPKG_ROOT;
        }

        public static String getRoot() {
            return AppLoaderFactory.g().getContext().getFilesDir().getPath();
        }

        private static String getTissuePkgRoot() {
            if (PATH_APKG_TISSUE_ROOT == null) {
                PATH_APKG_TISSUE_ROOT = getRoot() + "/mini_tissue/";
            }
            return PATH_APKG_TISSUE_ROOT;
        }
    }

    public static String getApkgFolderPath(MiniAppInfo miniAppInfo) {
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
            if (miniAppInfo.verType == 3) {
                return getPkgRoot(miniAppInfo) + MD5Utils.toMD5(miniAppInfo.appId) + "_" + miniAppInfo.versionId;
            }
            return getPkgRoot(miniAppInfo) + miniAppInfo.appId + "_debug";
        }
        return "";
    }

    public static ApkgManager getInstance() {
        if (sInstance == null) {
            synchronized (ApkgManager.class) {
                if (sInstance == null) {
                    sInstance = new ApkgManager();
                }
            }
        }
        return sInstance;
    }

    public static String getPkgRoot(MiniAppInfo miniAppInfo) {
        if (miniAppInfo.isEngineTypeMiniGame()) {
            return RootPath.access$000();
        }
        if (miniAppInfo.launchParam.isFlutterMode) {
            return RootPath.access$100();
        }
        return RootPath.access$200();
    }
}
