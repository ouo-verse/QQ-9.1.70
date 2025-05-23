package com.tencent.mobileqq.theme;

import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.er;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f292817a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43649);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f292817a = Integer.MAX_VALUE;
        }
    }

    public static boolean a() {
        return QMMKV.from(BaseApplication.context, "common_mmkv_configurations").decodeBool("navigation_color_init", true);
    }

    public static void b(Window window) {
        if (window == null) {
            return;
        }
        f292817a = window.getNavigationBarColor();
    }

    public static void c(boolean z16) {
        QMMKV.from(BaseApplication.context, "common_mmkv_configurations").encodeBool("navigation_color_init", z16);
    }

    public static void d(@NonNull Window window) {
        int i3;
        try {
            boolean c16 = er.c(MobileQQ.getMobileQQ(), "KEY_DISABLE_NAVIGATION_BAR", true, false);
            QLog.d("ThemeNavigationBarUtil", 2, "[NavigationBar] enableNavigationBarColor =", Boolean.valueOf(c16));
            if (c16) {
                return;
            }
            if (cu.f()) {
                QLog.d("ThemeNavigationBarUtil", 2, "[NavigationBar] not support machine");
                return;
            }
            if (f292817a == Integer.MAX_VALUE) {
                f292817a = window.getNavigationBarColor();
            }
            boolean isLastThemeIsNight = QQTheme.isLastThemeIsNight();
            boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
            QLog.d("ThemeNavigationBarUtil", 2, "[NavigationBar] setNavigationBarColor sLightThemeNavigationBarColor=", Integer.valueOf(f292817a), " isCurNightMode=", Boolean.valueOf(isNowThemeIsNight), " isLastNightMode=", Boolean.valueOf(isLastThemeIsNight));
            if (isNowThemeIsNight || isLastThemeIsNight || ImmersiveUtils.isVivoAndLOLLIPOP()) {
                if (isNowThemeIsNight) {
                    i3 = -16777216;
                } else {
                    i3 = f292817a;
                }
                e(window, i3);
            }
        } catch (Throwable th5) {
            QLog.d("ThemeNavigationBarUtil", 2, "[NavigationBar] setNavigationBarColor throwable=", th5);
        }
    }

    public static void e(@NonNull Window window, @ColorInt int i3) {
        QLog.d("ThemeNavigationBarUtil", 1, "[NavigationBar] setImmersiveNavigationBarColor activity=", window, " color=", Integer.valueOf(i3));
        try {
            window.addFlags(Integer.MIN_VALUE);
            window.setNavigationBarColor(i3);
        } catch (Throwable th5) {
            QLog.d("ThemeNavigationBarUtil", 1, "[NavigationBar] setNavigationBarColor =", th5);
        }
    }

    public static void f(@NonNull Window window) {
        if (ImmersiveUtils.isVivoAndLOLLIPOP()) {
            e(window, -16777216);
        }
    }
}
