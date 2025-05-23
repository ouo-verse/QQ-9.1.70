package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f264356a;

    /* renamed from: b, reason: collision with root package name */
    public static int f264357b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34786);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f264356a = 0;
            f264357b = 480;
        }
    }

    public static boolean a(Context context) {
        boolean z16;
        boolean z17 = false;
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier > 0) {
                z16 = resources.getBoolean(identifier);
            } else {
                z16 = false;
            }
            try {
                if (Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) == 1) {
                    return false;
                }
                if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
                    String str = (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, "qemu.hw.mainkeys");
                    if ("1".equals(str)) {
                        return false;
                    }
                    if ("0".equals(str)) {
                        return true;
                    }
                }
                return z16;
            } catch (Exception e16) {
                e = e16;
                z17 = z16;
                if (QLog.isColorLevel()) {
                    QLog.e("FloatingScreenUtils", 2, "checkNavigationBarShow error: " + e.toString());
                    return z17;
                }
                return z17;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static final int b(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    @TargetApi(13)
    public static int c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        int i3 = point.y;
        f264357b = i3;
        return i3;
    }

    public static int d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (NoSuchMethodException e16) {
            QLog.e("FloatingScreenUtils", 2, e16.getMessage());
            return -1;
        }
    }

    public static boolean e(Context context) {
        if (f264356a == 0) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 26 && i3 < 28 && LiuHaiUtils.hasNotchInScreen_AndroidO(context)) {
                if (QLog.isColorLevel()) {
                    QLog.d("FloatingScreenUtils", 2, "AndroidO With Notch in Screen.");
                }
                f264356a = 1;
            } else {
                f264356a = 2;
            }
        }
        if (f264356a == 1) {
            return true;
        }
        return false;
    }
}
