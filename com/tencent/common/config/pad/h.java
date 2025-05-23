package com.tencent.common.config.pad;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h {
    static IPatchRedirector $redirector_;

    public static DeviceType a(Context context) {
        if (f()) {
            return DeviceType.TABLET;
        }
        if (d()) {
            return DeviceType.FOLD;
        }
        return DeviceType.PHONE;
    }

    public static String b(String str) {
        String str2;
        try {
            Class<?> cls = Class.forName("com.samsung.android.feature.SemFloatingFeature");
            str2 = (String) cls.getDeclaredMethod("getString", String.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), str);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e16) {
            QLog.e("SamsungDeviceUtil", 1, e16, new Object[0]);
            str2 = "";
        }
        QLog.d("SamsungDeviceUtil", 1, "getSamsungFeature() featureTagName = [" + str + "], tagValue = [" + str2 + "]");
        return str2;
    }

    public static boolean c() {
        return Constants.KEY_OPTION_TRUE.equals(b("SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FLIP"));
    }

    private static boolean d() {
        return Constants.KEY_OPTION_TRUE.equals(b("SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FOLD"));
    }

    public static boolean e() {
        return Build.MANUFACTURER.equalsIgnoreCase("Samsung");
    }

    private static boolean f() {
        String a16 = b.a();
        if (!TextUtils.isEmpty(a16)) {
            return a16.contains("tablet");
        }
        return false;
    }
}
