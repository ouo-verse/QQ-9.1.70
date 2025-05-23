package com.tencent.common.config.pad;

import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static DeviceType a(Context context) {
        if (context == null) {
            context = BaseApplication.getContext();
        }
        DeviceType deviceType = DeviceType.PHONE;
        if (f()) {
            deviceType = DeviceType.TABLET;
        } else if (e(context)) {
            deviceType = DeviceType.FOLD;
        }
        QLog.d("HuaweiDeviceUtil", 1, "getHuaweiDeviceType = " + deviceType);
        return deviceType;
    }

    public static int b(Context context) {
        int i3;
        try {
            i3 = Settings.Global.getInt(context.getContentResolver(), "hw_fold_display_mode_prepare");
        } catch (Exception e16) {
            QLog.e("HuaweiDeviceUtil", 1, e16, new Object[0]);
            i3 = 0;
        }
        QLog.d("HuaweiDeviceUtil", 1, "gesture = " + i3);
        return i3;
    }

    private static boolean c() {
        Exception e16;
        String str;
        try {
            str = (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(null, "hw_sc.build.os.phonetype", "not getProp by key");
            try {
                QLog.d("HuaweiDeviceUtil", 1, "phone type = " + str);
            } catch (Exception e17) {
                e16 = e17;
                QLog.e("HuaweiDeviceUtil", 1, e16, new Object[0]);
                return "filpPhone".equalsIgnoreCase(str);
            }
        } catch (Exception e18) {
            e16 = e18;
            str = "";
        }
        return "filpPhone".equalsIgnoreCase(str);
    }

    public static boolean d() {
        return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
    }

    private static boolean e(Context context) {
        String model = DeviceInfoMonitor.getModel();
        if (!"BAL-AL60".equals(model) && !"BAL-AL00".equals(model) && !"BAL-L49".equals(model)) {
            if (context == null) {
                context = BaseApplication.getContext();
            }
            if (context.getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture")) {
                return !c();
            }
        }
        return false;
    }

    private static boolean f() {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            boolean equals = "tablet".equals(cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "ro.build.characteristics", ""));
            QLog.d("HuaweiDeviceUtil", 1, "isHuaweiTablet = " + equals);
            return equals;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e16) {
            QLog.e("HuaweiDeviceUtil", 1, e16, new Object[0]);
            String a16 = b.a();
            if (TextUtils.isEmpty(a16)) {
                return false;
            }
            return a16.contains("tablet");
        }
    }
}
