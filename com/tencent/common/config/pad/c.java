package com.tencent.common.config.pad;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static DeviceType a(Context context) {
        if (b(context)) {
            return DeviceType.FOLD;
        }
        if (e()) {
            return DeviceType.TABLET;
        }
        return DeviceType.PHONE;
    }

    private static boolean b(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null || !packageManager.hasSystemFeature("com.hihonor.hardware.sensor.posture")) {
            return false;
        }
        return true;
    }

    public static boolean c() {
        return CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean d(Activity activity) {
        if (activity == null) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels;
        int i16 = displayMetrics.heightPixels;
        float f16 = activity.getResources().getConfiguration().densityDpi;
        int min = (int) ((Math.min(i16, i3) / f16) * 160.0f);
        QLog.d("HonorDeviceUtil", 1, "height = [" + i16 + "], width = [" + i3 + "], densityDpi = [" + f16 + "]smallestScreenWidthDp = [" + min + "]");
        if (min < 600) {
            return false;
        }
        return true;
    }

    private static boolean e() {
        String a16 = b.a();
        if (!TextUtils.isEmpty(a16)) {
            return a16.contains("tablet");
        }
        return false;
    }
}
