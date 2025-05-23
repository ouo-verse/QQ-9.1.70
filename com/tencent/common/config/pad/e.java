package com.tencent.common.config.pad;

import android.os.Build;
import android.os.SystemProperties;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static DeviceType a() {
        DeviceType deviceType = DeviceType.PHONE;
        try {
            String str = (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, "ro.config.zui.devicetype");
            QLog.d("LenovoDeviceUtil", 1, "zuiDeviceType = " + str);
            if ("PAD".equalsIgnoreCase(str) || "PAD_WITH_SIM".equalsIgnoreCase(str)) {
                return DeviceType.TABLET;
            }
            return deviceType;
        } catch (Exception e16) {
            QLog.e("LenovoDeviceUtil", 1, e16, new Object[0]);
            return deviceType;
        }
    }

    public static boolean b() {
        return Build.BRAND.equalsIgnoreCase("Lenovo");
    }
}
