package com.tencent.qqmini.minigame.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b {
    public static Pair<Integer, Integer> a(Context context, DisplayMetrics displayMetrics, boolean z16, int i3, int i16) {
        boolean z17;
        int max;
        if (context != null && displayMetrics != null) {
            double d16 = displayMetrics.density;
            WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class);
            if (wnsConfigProxy != null) {
                z17 = wnsConfigProxy.getNotchIgnoreEnable(false);
            } else {
                z17 = false;
            }
            if (!z17 && i3 > 0 && i16 > 0) {
                int i17 = (int) (i3 / d16);
                int i18 = (int) (i16 / d16);
                if (i17 != 0 && i18 != 0) {
                    return new Pair<>(Integer.valueOf(i17), Integer.valueOf(i18));
                }
            }
            if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDeviceType() == MiniAppProxy.DeviceType.FOLD) {
                if (!z16 && context.getResources().getConfiguration().orientation != 2) {
                    z16 = false;
                } else {
                    z16 = true;
                }
            }
            try {
                int i19 = displayMetrics.widthPixels;
                int i26 = displayMetrics.heightPixels;
                int statusBarHeight = DisplayUtil.getStatusBarHeight(context);
                boolean c16 = c(context, false);
                if (!b(context)) {
                    if (z16) {
                        max = Math.min(i19, i26);
                        i19 = Math.max(i19, i26);
                    } else {
                        max = Math.max(i19, i26);
                        i19 = Math.min(i19, i26);
                    }
                    i26 = max;
                }
                int i27 = (int) (i26 / d16);
                int i28 = (int) (i19 / d16);
                int i29 = (int) (statusBarHeight / d16);
                if (z16 && c16) {
                    i28 -= i29;
                }
                return new Pair<>(Integer.valueOf(i28), Integer.valueOf(i27));
            } catch (Throwable th5) {
                QMLog.e("MiniGameWindowSizeHelper", "getWindowSize throw:", th5);
            }
        }
        return null;
    }

    public static boolean b(Context context) {
        MiniAppProxy miniAppProxy;
        if (context == null || (miniAppProxy = (MiniAppProxy) AppLoaderFactory.g().getProxyManager().get(MiniAppProxy.class)) == null) {
            return false;
        }
        return miniAppProxy.isFolderScreenOpenMode(context);
    }

    private static boolean c(Context context, boolean z16) {
        if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI)) {
            if (Settings.Secure.getInt(context.getContentResolver(), "display_notch_status", 0) != 1) {
                return false;
            }
            return true;
        }
        return z16;
    }
}
