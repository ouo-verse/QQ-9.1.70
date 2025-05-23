package com.tencent.mobileqq.mini.utils;

import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

/* compiled from: P */
/* loaded from: classes33.dex */
public class EnvUtils {
    public static boolean isX5Enabled(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return false;
        }
        return true;
    }

    public static boolean isPkgDownloaded(MiniAppConfig miniAppConfig) {
        if (miniAppConfig == null) {
            return false;
        }
        return ApkgManager.pkgExists(miniAppConfig.config);
    }
}
