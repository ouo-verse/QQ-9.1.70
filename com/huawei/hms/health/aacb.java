package com.huawei.hms.health;

import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.huawei.hms.hihealth.HiHealthKitClient;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.huawei.hms.utils.Util;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aacb {
    private static final boolean aab;
    private static final String aaba;
    private static final String aabb;
    private static final String aabc;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0064  */
    static {
        String aab2;
        int i3;
        boolean z16;
        boolean aaba2 = aaba("com.huawei.android.os.BuildEx");
        aab = aaba2;
        String str = "";
        if (!aaba2) {
            aab2 = "";
        } else {
            aab2 = aab("ro.build.version.emui", "");
        }
        aaba = aab2;
        aab(aab2);
        if (aaba2) {
            String aab3 = aab("ro.build.hw_emui_api_level", "");
            if (!TextUtils.isEmpty(aab3)) {
                try {
                    i3 = Integer.parseInt(aab3);
                } catch (NumberFormatException unused) {
                    aabz.aab("EnvironmentInfo", "getEmuiVersionCodeExImpl: catch a NumberFormatException");
                }
                StringBuilder aab4 = aab.aab("initEmuiVersionCodeEx, isEmuiBuildEx=");
                z16 = aab;
                aab4.append(z16);
                aab4.append(", emuiVersionCode=");
                aab4.append(i3);
                aabz.aabb("EnvironmentInfo", aab4.toString());
                aabb = aab("hw_sc.build.platform.version", "");
                if (z16) {
                    str = aab("ro.build.version.magic", "");
                }
                aabc = str;
            }
        }
        i3 = 0;
        StringBuilder aab42 = aab.aab("initEmuiVersionCodeEx, isEmuiBuildEx=");
        z16 = aab;
        aab42.append(z16);
        aab42.append(", emuiVersionCode=");
        aab42.append(i3);
        aabz.aabb("EnvironmentInfo", aab42.toString());
        aabb = aab("hw_sc.build.platform.version", "");
        if (z16) {
        }
        aabc = str;
    }

    static String aab(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            Object invoke = SystemProperties.class.getDeclaredMethod("get", String.class, String.class).invoke(null, str, str2);
            return invoke instanceof String ? (String) invoke : str2;
        } catch (ClassNotFoundException unused) {
            str3 = "getSystemProperties ClassNotFoundException";
            aabz.aab("EnvironmentInfo", str3);
            return str2;
        } catch (IllegalAccessException unused2) {
            str3 = "getSystemProperties IllegalAccessException";
            aabz.aab("EnvironmentInfo", str3);
            return str2;
        } catch (NoSuchMethodException unused3) {
            str3 = "getSystemProperties NoSuchMethodException";
            aabz.aab("EnvironmentInfo", str3);
            return str2;
        } catch (InvocationTargetException unused4) {
            str3 = "getSystemProperties InvocationTargetException";
            aabz.aab("EnvironmentInfo", str3);
            return str2;
        }
    }

    private static boolean aaba(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            aabz.aab("EnvironmentInfo", "isSupportEmuiBuildEx ClassNotFoundException");
            return false;
        }
    }

    private static boolean aab(String str) {
        boolean z16 = !TextUtils.isEmpty(str) && str.contains("EmotionUI");
        StringBuilder aab2 = aab.aab("checkEmuiSystem, isEmuiBuildEx=");
        aab2.append(aab);
        aab2.append(", isEmui=");
        aab2.append(z16);
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void aab() throws SecurityException {
        boolean z16;
        boolean z17;
        Context context = HiHealthKitClient.getInstance().getContext();
        if (context == null) {
            return;
        }
        String appId = Util.getAppId(context);
        if ("10414141".equals(appId) || "102162151".equals(appId)) {
            aabz.aabb("EnvironmentInfo", "skip checkSystemVersion");
            return;
        }
        String str = aabb;
        boolean z18 = true;
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\\.");
            if (split.length > 0 && TextUtils.isDigitsOnly(split[0]) && Integer.parseInt(split[0]) >= 2) {
                z16 = true;
                if (!z16) {
                    aabz.aabb("EnvironmentInfo", "System OS is Harmony.");
                } else {
                    String str2 = aabc;
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split2 = str2.split("\\.");
                        if (split2.length > 0 && TextUtils.isDigitsOnly(split2[0]) && Integer.parseInt(split2[0]) >= 2) {
                            z17 = true;
                            if (z17) {
                                StringBuilder aab2 = aab.aab("Android SDK Version is ");
                                int i3 = Build.VERSION.SDK_INT;
                                aab2.append(i3);
                                aabz.aabb("EnvironmentInfo", aab2.toString());
                                if (i3 <= 23) {
                                    z18 = false;
                                }
                            } else {
                                aabz.aabb("EnvironmentInfo", "System OS is Magic New Ui.");
                            }
                        }
                    }
                    z17 = false;
                    if (z17) {
                    }
                }
                if (z18) {
                    throw new SecurityException(String.valueOf(HiHealthStatusCodes.SYSTEM_VERSION_IS_INVALID));
                }
                if (!aaca.aaba(context)) {
                    throw new SecurityException(String.valueOf(HiHealthStatusCodes.DEVICE_NOT_SUPPORT));
                }
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
        if (z18) {
        }
    }
}
