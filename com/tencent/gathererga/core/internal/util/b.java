package com.tencent.gathererga.core.internal.util;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static String a() {
        String str = Build.MANUFACTURER;
        if (!CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equalsIgnoreCase(str) && !"Redmi".equalsIgnoreCase(str)) {
            if (!"OPPO".equalsIgnoreCase(str) && !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_ONEPLUS.equalsIgnoreCase(str) && !"realme".equalsIgnoreCase(str)) {
                if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(str)) {
                    return c("ro.vivo.os.version");
                }
                if ("HUAWEI".equalsIgnoreCase(str)) {
                    String c16 = c("hw_sc.build.platform.version");
                    if (TextUtils.isEmpty(c16)) {
                        c("ro.build.version.emui");
                        return c16;
                    }
                    return c16;
                }
                if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR.equalsIgnoreCase(str)) {
                    String c17 = c("ro.build.version.magic");
                    if (TextUtils.isEmpty(c17)) {
                        c17 = c("hw_sc.build.platform.version");
                    }
                    if (TextUtils.isEmpty(c17)) {
                        return c("ro.build.version.emui");
                    }
                    return c17;
                }
                return "";
            }
            String c18 = c("ro.build.version.oplusrom");
            if (TextUtils.isEmpty(c18)) {
                c("ro.build.version.opporom");
                return c18;
            }
            return c18;
        }
        String c19 = c("ro.build.version.incremental");
        if (TextUtils.isEmpty(c19)) {
            return c("ro.mi.os.version.name");
        }
        return c19;
    }

    public static int b() {
        return Build.VERSION.SDK_INT;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            d.b("getSystemProperties propertyName is empty");
            return "";
        }
        try {
            return (String) SystemProperties.class.getDeclaredMethod("get", String.class).invoke(SystemProperties.class, str);
        } catch (Throwable th5) {
            d.b("getSystemProperties error: " + th5.getMessage());
            return "";
        }
    }
}
