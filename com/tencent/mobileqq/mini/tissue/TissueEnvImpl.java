package com.tencent.mobileqq.mini.tissue;

import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.minigame.manager.EngineManager;
import com.tencent.mobileqq.minigame.manager.InstalledEngine;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class TissueEnvImpl {
    public static final String BUNDLE_KEY_TISSUE_NATIVE_LIB_DIR = "tissuenativelibdir";
    public static final String LOG_TAG = "Tissue";
    private static boolean sCheckLibUpdate = false;

    public static String getNativeLibDir() {
        if (!sCheckLibUpdate) {
            BaseLibInfo baseLibInfo = TissueWnsConfig.getBaseLibInfo();
            if (baseLibInfo != null) {
                EngineManager.g().installBaseLib(baseLibInfo, null);
            }
            sCheckLibUpdate = true;
        }
        ArrayList<InstalledEngine> engineList = EngineManager.g().getEngineList(99);
        if (engineList != null) {
            int size = engineList.size();
            QZLog.i(LOG_TAG, " getInstalledEngineList success " + size);
            if (size > 0) {
                InstalledEngine installedEngine = engineList.get(0);
                QZLog.i(LOG_TAG, "verify engine " + installedEngine);
                if (verifyTissueEngine(installedEngine.engineDir)) {
                    return installedEngine.engineDir;
                }
            }
        }
        return null;
    }

    public static String getNativeLibDirInSubProgress() {
        ICommonManager commonManager = AppLoaderFactory.g().getCommonManager();
        if (commonManager == null) {
            return null;
        }
        return commonManager.getTissueSoPath();
    }

    public static boolean verifyTissueEngine(String str) {
        ICommonManager commonManager = AppLoaderFactory.g().getCommonManager();
        if (commonManager == null) {
            return false;
        }
        return commonManager.verifyTissueEngine(str);
    }
}
