package com.tencent.common.config.pad;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        try {
            String str = (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, "ro.build.characteristics");
            QLog.d("DefaultDeviceUtil", 1, "characteristics = " + str);
            return str;
        } catch (Exception e16) {
            QLog.e("DefaultDeviceUtil", 1, e16, new Object[0]);
            return null;
        }
    }

    public static DeviceType b(Context context) {
        if (d(context)) {
            return DeviceType.TABLET;
        }
        return DeviceType.PHONE;
    }

    private static double c(@NonNull Context context) {
        if (context == null) {
            context = BaseApplication.getContext();
        }
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        double sqrt = Math.sqrt(Math.pow(r0.widthPixels / r0.xdpi, 2.0d) + Math.pow(r0.heightPixels / r0.ydpi, 2.0d));
        QLog.d("DefaultDeviceUtil", 1, "screenInches = " + sqrt);
        return sqrt;
    }

    private static boolean d(@NonNull Context context) {
        String a16 = a();
        if (!TextUtils.isEmpty(a16)) {
            return a16.contains("tablet");
        }
        if (context == null) {
            context = BaseApplication.getContext();
        }
        if (e(context) && c(context) >= 7.0d) {
            return true;
        }
        return false;
    }

    private static boolean e(@NonNull Context context) {
        boolean z16;
        if (context == null) {
            context = BaseApplication.getContext();
        }
        if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("DefaultDeviceUtil", 1, "isTabletWindow = " + z16);
        return z16;
    }
}
