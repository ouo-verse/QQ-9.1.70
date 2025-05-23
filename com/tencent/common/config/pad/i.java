package com.tencent.common.config.pad;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i {
    static IPatchRedirector $redirector_;

    public static DeviceType a() {
        DeviceType deviceType = DeviceType.PHONE;
        try {
            Class<?> cls = Class.forName("android.util.FtDeviceInfo");
            String str = (String) cls.getMethod("getDeviceType", new Class[0]).invoke(cls, new Object[0]);
            if ("tablet".equalsIgnoreCase(str)) {
                deviceType = DeviceType.TABLET;
            } else if ("foldable".equalsIgnoreCase(str)) {
                deviceType = DeviceType.FOLD;
            }
        } catch (Exception e16) {
            QLog.e("VivoDeviceUtil", 1, e16, new Object[0]);
        }
        return deviceType;
    }

    public static boolean b() {
        return "VIVO".equalsIgnoreCase(Build.MANUFACTURER);
    }
}
