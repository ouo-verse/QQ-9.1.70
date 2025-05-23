package com.tencent.qqmini.sdk.utils;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;

/* compiled from: P */
/* loaded from: classes23.dex */
public class EnvUtils {
    public static boolean isPkgDownloaded(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return false;
        }
        return ApkgManager.pkgExists(miniAppInfo);
    }

    public static boolean isX5Enabled(MiniAppInfo miniAppInfo) {
        return false;
    }
}
