package com.tencent.common.config.pad;

import android.app.Activity;
import android.os.Build;
import android.view.Display;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static DeviceType a() {
        DeviceType deviceType = DeviceType.PHONE;
        try {
            Class<?> cls = Class.forName("com.oplus.content.OplusFeatureConfigManager");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Method declaredMethod = cls.getDeclaredMethod("hasFeature", String.class);
            Object invoke2 = declaredMethod.invoke(invoke, "oplus.hardware.type.tablet");
            if ((invoke2 instanceof Boolean) && ((Boolean) invoke2).booleanValue()) {
                deviceType = DeviceType.TABLET;
            }
            Object invoke3 = declaredMethod.invoke(invoke, "oplus.hardware.type.fold");
            if ((invoke3 instanceof Boolean) && ((Boolean) invoke3).booleanValue()) {
                deviceType = DeviceType.FOLD;
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e16) {
            QLog.e("OppoDeviceUtil", 1, e16, new Object[0]);
        }
        QLog.d("OppoDeviceUtil", 1, "getOppoDeviceType = " + deviceType);
        return deviceType;
    }

    public static int b(Activity activity) {
        if (d() && Build.VERSION.SDK_INT >= 35) {
            try {
                Class<?> cls = Class.forName("com.oplus.flexiblewindow.FlexibleWindowManager");
                Object invoke = cls.getDeclaredMethod("getFlexibleWindowState", Activity.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), activity);
                if (invoke instanceof Integer) {
                    QLog.d("OppoDeviceUtil", 1, "getOppoFlexibleWindowState = " + invoke);
                    return ((Integer) invoke).intValue();
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e16) {
                QLog.e("OppoDeviceUtil", 1, e16, new Object[0]);
            }
        }
        return 0;
    }

    public static boolean c(Activity activity) {
        if (activity == null) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        int physicalHeight = defaultDisplay.getMode().getPhysicalHeight();
        int physicalWidth = defaultDisplay.getMode().getPhysicalWidth();
        float f16 = activity.getResources().getConfiguration().densityDpi;
        int min = (int) ((Math.min(physicalHeight, physicalWidth) / f16) * 160.0f);
        QLog.d("OppoDeviceUtil", 1, "height = [" + physicalHeight + "], width = [" + physicalWidth + "], densityDpi = [" + f16 + "]smallestScreenWidthDp = [" + min + "]");
        if (min < 600) {
            return false;
        }
        return true;
    }

    public static boolean d() {
        String str = Build.BRAND;
        if (!str.equalsIgnoreCase("OPPO") && !str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_ONEPLUS) && !str.equalsIgnoreCase("realme")) {
            return false;
        }
        return true;
    }
}
