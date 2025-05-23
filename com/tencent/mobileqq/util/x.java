package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private static int f306801a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static String f306802b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f306803c = true;

    public static boolean a(Context context) {
        boolean z16;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z17 = false;
        if (identifier > 0) {
            z16 = resources.getBoolean(identifier);
        } else {
            z16 = false;
        }
        try {
            String str = (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, "qemu.hw.mainkeys");
            int i3 = Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
            if (!"1".equals(str) && 1 != i3) {
                z17 = "0".equals(str) ? true : z16;
            }
            return z17;
        } catch (Exception unused) {
            return z16;
        }
    }

    public static float b(Context context, float f16) {
        return f16 * (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    public static int c(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static int d(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int e(Context context) {
        String str;
        Resources resources = context.getResources();
        if (f306803c) {
            str = "navigation_bar_height";
        } else {
            str = "navigation_bar_height_landscape";
        }
        return d(resources, str);
    }

    public static com.tencent.mobileqq.activity.richmedia.i f(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new com.tencent.mobileqq.activity.richmedia.i(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static boolean g(Context context) {
        boolean z16;
        int i3 = f306801a;
        if (i3 != -1) {
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            z16 = resources.getBoolean(identifier);
            if ("1".equals(f306802b)) {
                z16 = false;
            } else if ("0".equals(f306802b)) {
                z16 = true;
            }
        } else {
            z16 = !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        if (QLog.isColorLevel()) {
            QLog.d("XPanelContainer", 2, "hasNavbar=" + z16);
        }
        if (z16) {
            f306801a = 1;
        } else {
            f306801a = 0;
        }
        return z16;
    }

    public static int h(Context context, float f16) {
        return (int) ((f16 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int i(Context context, float f16) {
        return (int) ((f16 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int j(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
