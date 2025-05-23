package com.tencent.qqmini.minigame.gpkg;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.NetworkTimeoutInfo;
import java.io.File;

/* loaded from: classes23.dex */
public class MiniGamePkg extends ApkgBaseInfo {
    public static final String NAME_CONFIG_JSON = "game.json";
    public static final String NAME_ENTRY_FILE = "game.js";
    public static final String NAME_OFFLINECONFIG_JSON = "offlineconfig.json";
    public static final String PLUGIN_ENTRY_FILE = "plugin.js";
    public static final String TAG = "MiniGamePkg";
    private final f gameSubPkgManager;
    public final a mGameConfigJson;
    private final MiniAppInfo miniAppInfo;
    public NetworkTimeoutInfo networkTimeoutInfo;

    public MiniGamePkg(String str, MiniAppInfo miniAppInfo) {
        super(str, miniAppInfo);
        this.mGameConfigJson = new a();
        this.gameSubPkgManager = new f();
        this.miniAppInfo = miniAppInfo;
    }

    private static void initOkHttp(MiniGamePkg miniGamePkg) {
        NetworkTimeoutInfo networkTimeoutInfo;
        try {
            QMLog.e(TAG, "loadGamePkgFromFolderPath initNetwork");
            if (miniGamePkg == null || (networkTimeoutInfo = miniGamePkg.networkTimeoutInfo) == null) {
                networkTimeoutInfo = new NetworkTimeoutInfo();
            }
            SpecialProxy specialProxy = (SpecialProxy) AppLoaderFactory.g().getProxyManager().get(SpecialProxy.class);
            if (specialProxy != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(SpecialProxy.KEY_NETWORK_TIMEOUT_INFO, networkTimeoutInfo);
                specialProxy.sendEventToHost(2, bundle, null);
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "loadGamePkgFromFolderPath initNetwork failed", th5);
        }
    }

    public static MiniGamePkg loadGamePkgFromFolderPath(String str, String str2, MiniAppInfo miniAppInfo) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            MiniGamePkg miniGamePkg = new MiniGamePkg(str, miniAppInfo);
            miniGamePkg.init(str2);
            initOkHttp(miniGamePkg);
            return miniGamePkg;
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo
    public String getRootPath(String str) {
        return this.gameSubPkgManager.a(str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo
    public String getWorkerPath(String str, String str2) {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo
    public void init(String str) {
        try {
            if (str != null) {
                this.mConfigStr = FileUtils.readFileToString(new File(getApkgFolderPath() + "/" + str, NAME_CONFIG_JSON));
            } else {
                this.mConfigStr = FileUtils.readFileToString(new File(getApkgFolderPath(), NAME_CONFIG_JSON));
            }
            this.mGameConfigJson.b(this.mConfigStr);
            f fVar = this.gameSubPkgManager;
            MiniAppInfo miniAppInfo = this.miniAppInfo;
            fVar.b(miniAppInfo, this.mGameConfigJson.c(miniAppInfo));
            this.networkTimeoutInfo = NetworkTimeoutInfo.parse(this.mGameConfigJson.f346447c);
        } catch (Throwable th5) {
            QMLog.e(TAG, "init: independentPath=" + str + "; \n exception msg=" + th5.getMessage());
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo
    public boolean isUrlResReady(String str, MiniAppInfo miniAppInfo) {
        return false;
    }

    public void loadGameSubPackage(String str, g gVar) {
        this.gameSubPkgManager.c(str, gVar);
    }
}
