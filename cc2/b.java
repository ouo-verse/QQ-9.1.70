package cc2;

import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b {
    public static int a(Activity activity) {
        return ImmersiveUtils.getStatusBarHeight(activity);
    }

    public static boolean b() {
        return ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    }

    public static void c(Activity activity, int i3) {
        SystemBarCompact systemBarCompact = new SystemBarCompact(activity, true, -1);
        systemBarCompact.init();
        systemBarCompact.setStatusBarColor(i3);
    }

    public static boolean d(Activity activity, boolean z16) {
        int i3 = 9216;
        if (!cu.f() && !cu.g()) {
            if (!z16) {
                i3 = 1280;
            }
            activity.getWindow().getDecorView().setSystemUiVisibility(i3);
            return z16;
        }
        if (ImmersiveUtils.supportStatusBarDarkMode()) {
            ImmersiveUtils.setStatusBarDarkMode(activity.getWindow(), z16);
            if (cu.g()) {
                if (!z16) {
                    i3 = 1280;
                }
                activity.getWindow().getDecorView().setSystemUiVisibility(i3);
                return z16;
            }
            return z16;
        }
        return false;
    }

    public static void e(Activity activity, boolean z16) {
        if (QQTheme.isCustomTheme(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin(), true)) {
            c(activity, 0);
            return;
        }
        if (z16) {
            c(activity, -16777216);
            d(activity, false);
        } else if (d(activity, true)) {
            c(activity, -1);
        } else {
            c(activity, -2368549);
        }
    }
}
