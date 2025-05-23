package com.tencent.common.config.pad;

import android.app.Activity;
import android.os.Build;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class j {
    static IPatchRedirector $redirector_;

    private static String a() {
        try {
            String str = (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, "ro.build.characteristics");
            QLog.d("XiaomiDeviceType", 1, "characteristics = " + str);
            return str;
        } catch (Exception e16) {
            QLog.e("XiaomiDeviceType", 1, e16, new Object[0]);
            return null;
        }
    }

    public static DeviceType b() {
        DeviceType deviceType = DeviceType.PHONE;
        if (e()) {
            return DeviceType.FOLD;
        }
        if (f()) {
            return DeviceType.TABLET;
        }
        return deviceType;
    }

    public static int c(Activity activity) {
        int i3;
        try {
            i3 = Settings.Global.getInt(activity.getContentResolver(), "device_posture", 0);
            if (i3 == 0) {
                try {
                    if (g.c(activity)) {
                        i3 = 3;
                    }
                } catch (Exception e16) {
                    e = e16;
                    QLog.e("XiaomiDeviceType", 1, e, new Object[0]);
                    QLog.d("XiaomiDeviceType", 1, "gesture = " + i3);
                    return i3;
                }
            }
        } catch (Exception e17) {
            e = e17;
            i3 = 0;
        }
        QLog.d("XiaomiDeviceType", 1, "gesture = " + i3);
        return i3;
    }

    public static boolean d() {
        boolean z16 = false;
        try {
            Class<?> cls = Class.forName("miui.util.MiuiMultiDisplayTypeInfo");
            Object invoke = cls.getMethod("isFlipDevice", new Class[0]).invoke(cls, new Object[0]);
            if (invoke instanceof Boolean) {
                z16 = ((Boolean) invoke).booleanValue();
            }
            QLog.d("XiaomiDeviceType", 1, "isFlipDevice = " + z16);
        } catch (Throwable unused) {
        }
        return z16;
    }

    private static boolean e() {
        try {
            int intValue = ((Integer) SystemProperties.class.getMethod("getInt", String.class, Integer.TYPE).invoke(SystemProperties.class, "persist.sys.muiltdisplay_type", 0)).intValue();
            QLog.d("XiaomiDeviceType", 1, "muiltDisplayType = " + intValue);
            if (intValue == 2) {
                return true;
            }
            return false;
        } catch (Exception e16) {
            QLog.e("XiaomiDeviceType", 1, e16, new Object[0]);
            return false;
        }
    }

    private static boolean f() {
        String a16 = a();
        if (!TextUtils.isEmpty(a16)) {
            return a16.contains("tablet");
        }
        return false;
    }

    public static boolean g() {
        return CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER);
    }
}
