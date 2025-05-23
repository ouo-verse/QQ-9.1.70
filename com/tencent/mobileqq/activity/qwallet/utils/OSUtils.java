package com.tencent.mobileqq.activity.qwallet.utils;

import android.os.SystemProperties;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes10.dex */
public class OSUtils {
    private static final String KEY_DISPLAY = "ro.build.display.id";
    private static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";

    public static String getEMUIVersion() {
        if (!isEMUI()) {
            return "";
        }
        return getSystemProperty(KEY_EMUI_VERSION_NAME, "");
    }

    private static String getFlymeOSFlag() {
        return getSystemProperty(KEY_DISPLAY, "");
    }

    public static String getFlymeOSVersion() {
        if (!isFlymeOS()) {
            return "";
        }
        return getSystemProperty(KEY_DISPLAY, "");
    }

    public static String getMIUIVersion() {
        if (!isMIUI()) {
            return "";
        }
        return getSystemProperty(KEY_MIUI_VERSION_NAME, "");
    }

    private static String getSystemProperty(String str, String str2) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, str, str2);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return str2;
        }
    }

    public static boolean isEMUI() {
        return !TextUtils.isEmpty(getSystemProperty(KEY_EMUI_VERSION_NAME, ""));
    }

    public static boolean isEMUI3_1() {
        String eMUIVersion = getEMUIVersion();
        if (!"EmotionUI 3".equals(eMUIVersion) && !eMUIVersion.contains("EmotionUI_3.1")) {
            return false;
        }
        return true;
    }

    public static boolean isFlymeOS() {
        return getFlymeOSFlag().toLowerCase().contains("flyme");
    }

    public static boolean isFlymeOS4More() {
        int intValue;
        String flymeOSVersion = getFlymeOSVersion();
        try {
            if (!flymeOSVersion.isEmpty()) {
                if (flymeOSVersion.toLowerCase().contains("os")) {
                    intValue = Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue();
                } else {
                    intValue = Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue();
                }
                if (intValue >= 4) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(getSystemProperty(KEY_MIUI_VERSION_NAME, ""));
    }

    public static boolean isMIUI6More() {
        String mIUIVersion = getMIUIVersion();
        try {
            if (!mIUIVersion.isEmpty()) {
                if (Integer.valueOf(mIUIVersion.substring(1)).intValue() >= 6) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }
}
