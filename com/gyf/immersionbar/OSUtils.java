package com.gyf.immersionbar;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;

/* compiled from: P */
/* loaded from: classes2.dex */
public class OSUtils {
    private static final String KEY_DISPLAY = "ro.build.display.id";
    private static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";

    public static String getEMUIVersion() {
        if (isEMUI()) {
            return getSystemProperty(KEY_EMUI_VERSION_NAME);
        }
        return "";
    }

    private static String getFlymeOSFlag() {
        return getSystemProperty(KEY_DISPLAY);
    }

    public static String getFlymeOSVersion() {
        if (isFlymeOS()) {
            return getSystemProperty(KEY_DISPLAY);
        }
        return "";
    }

    public static String getMIUIVersion() {
        if (isMIUI()) {
            return getSystemProperty(KEY_MIUI_VERSION_NAME);
        }
        return "";
    }

    @SuppressLint({"PrivateApi"})
    private static String getSystemProperty(String str) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, str, "");
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static boolean isColorOs() {
        return !TextUtils.isEmpty(getSystemProperty("ro.build.version.opporom"));
    }

    public static boolean isEMUI() {
        return !TextUtils.isEmpty(getSystemProperty(KEY_EMUI_VERSION_NAME));
    }

    public static boolean isEMUI3_0() {
        return getEMUIVersion().contains("EmotionUI_3.0");
    }

    public static boolean isEMUI3_1() {
        String eMUIVersion = getEMUIVersion();
        if (!"EmotionUI 3".equals(eMUIVersion) && !eMUIVersion.contains("EmotionUI_3.1")) {
            return false;
        }
        return true;
    }

    public static boolean isEMUI3_x() {
        if (!isEMUI3_0() && !isEMUI3_1()) {
            return false;
        }
        return true;
    }

    public static boolean isFlymeOS() {
        return getFlymeOSFlag().toLowerCase().contains("flyme");
    }

    public static boolean isFlymeOS4Later() {
        int parseInt;
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            if (flymeOSVersion.toLowerCase().contains("os")) {
                parseInt = Integer.parseInt(flymeOSVersion.substring(9, 10));
            } else {
                parseInt = Integer.parseInt(flymeOSVersion.substring(6, 7));
            }
            if (parseInt < 4) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isFlymeOS5() {
        int parseInt;
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            if (flymeOSVersion.toLowerCase().contains("os")) {
                parseInt = Integer.parseInt(flymeOSVersion.substring(9, 10));
            } else {
                parseInt = Integer.parseInt(flymeOSVersion.substring(6, 7));
            }
            if (parseInt != 5) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isFuntouchOrOriginOs() {
        return !TextUtils.isEmpty(getSystemProperty("ro.vivo.os.version"));
    }

    public static boolean isHuaWei() {
        return Build.MANUFACTURER.toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI);
    }

    public static boolean isLenovo() {
        return Build.MANUFACTURER.toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_LENOVO);
    }

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(getSystemProperty(KEY_MIUI_VERSION_NAME));
    }

    public static boolean isMIUI6Later() {
        String mIUIVersion = getMIUIVersion();
        if (mIUIVersion.isEmpty()) {
            return false;
        }
        try {
            if (Integer.parseInt(mIUIVersion.substring(1)) < 6) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isMeizu() {
        return Build.MANUFACTURER.toLowerCase().contains("meizu");
    }

    public static boolean isOppo() {
        return Build.MANUFACTURER.toLowerCase().contains("oppo");
    }

    public static boolean isSamsung() {
        return Build.MANUFACTURER.toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING);
    }

    public static boolean isVivo() {
        return Build.MANUFACTURER.toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO);
    }

    public static boolean isXiaoMi() {
        return Build.MANUFACTURER.toLowerCase().contains("xiaomi");
    }
}
