package com.tencent.qqperf.safemode;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.unitedconfig_android.api.impl.UnitedConfigManagerImpl;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqperf.crashdefend.CrashDefendManager;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeHelper;
import java.io.File;
import mqq.app.MobileQQ;
import wy3.c;
import wy3.d;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SafeModeClearHelper {
    private static boolean a(@NonNull Context context) {
        boolean z16;
        try {
            File b16 = d.c().b(context, "CD/T_SW/");
            if (b16 != null && b16.exists()) {
                if (new File(b16.getAbsolutePath(), "N_C").exists()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                c.g("SafeModeClearHelper", "checkIsNeedClearConfigForSystemTest switchCheck is " + z16);
                return z16;
            }
            c.g("SafeModeClearHelper", "checkIsNeedClearConfigForSystemTest dir is invalied");
            return false;
        } catch (Throwable th5) {
            c.d("SafeModeClearHelper", "checkIsNeedClearConfigForSystemTest failed with Throwable!", th5);
            return false;
        }
    }

    public static void b(Context context) {
        com.tencent.qqperf.crashdefend.c.a(context);
        m(context);
        l(3, "test_for_safemode_clear", null);
        l(3, "test_for_safemode_crash", null);
        c(context);
        d();
        e(context);
        m(context);
        l(3, "test_for_safemode_clear", null);
        l(3, "test_for_safemode_crash", null);
    }

    private static boolean c(Context context) {
        try {
            ((UnitedConfigManagerImpl) QRoute.api(IUnitedConfigManager.class)).removeAll();
            c.g("SafeModeClearHelper", "clearAllQQMCData end");
            return true;
        } catch (Throwable th5) {
            c.d("SafeModeClearHelper", "clearAllQQMCData failed with Throwable!", th5);
            return false;
        }
    }

    private static boolean d() {
        try {
            boolean clearAllData = ((IFeatureRuntimeService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFeatureRuntimeService.class, "all")).clearAllData();
            c.g("SafeModeClearHelper", "clearAllShiplyData result=" + clearAllData);
            return clearAllData;
        } catch (Throwable th5) {
            c.d("SafeModeClearHelper", "clearAllShiplyData failed with Throwable!", th5);
            return false;
        }
    }

    private static boolean e(Context context) {
        try {
            ABTestController.getInstance().clearAllExpData(context);
            c.g("SafeModeClearHelper", "clearAllTABData end");
            return true;
        } catch (Throwable th5) {
            c.d("SafeModeClearHelper", "clearAllTABData failed with Throwable!", th5);
            return false;
        }
    }

    public static boolean f(int i3, String str, String str2) {
        com.tencent.qqperf.crashdefend.c.a(j());
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    c.c("SafeModeClearHelper", "clearConfigData failed with error configType:" + i3);
                    return false;
                }
                l(i3, str, str2);
                boolean g16 = g(str);
                l(i3, str, str2);
                return g16;
            }
            l(i3, str, str2);
            boolean i16 = i(str, str2);
            l(i3, str, str2);
            return i16;
        }
        l(i3, str, str2);
        boolean h16 = h(str);
        l(i3, str, str2);
        return h16;
    }

    private static boolean g(String str) {
        if (str == null) {
            return false;
        }
        try {
            ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).removeLocal(str);
            c.g("SafeModeClearHelper", "clearQQMCData invoke end");
            return true;
        } catch (Throwable th5) {
            c.d("SafeModeClearHelper", "clearQQMCData failed with Throwable!", th5);
            return false;
        }
    }

    private static boolean h(String str) {
        if (str == null) {
            return false;
        }
        try {
            boolean clearData = ((IFeatureRuntimeService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFeatureRuntimeService.class, "all")).clearData(str);
            c.g("SafeModeClearHelper", "clearShiplyData result=" + clearData);
            return clearData;
        } catch (Throwable th5) {
            c.d("SafeModeClearHelper", "clearShiplyData failed with Throwable!", th5);
            return false;
        }
    }

    private static boolean i(String str, @NonNull String str2) {
        try {
            if (!ABTestController.getInstance().initWithAppID(str)) {
                c.g("SafeModeClearHelper", "clearTABData jump with checkAppID is false!");
                return false;
            }
            Context j3 = j();
            if (j3 == null) {
                c.c("SafeModeClearHelper", "clearTABData jump with context is null!");
                return false;
            }
            boolean clearExpData = ABTestController.getInstance().clearExpData(j3, str, str2);
            c.g("SafeModeClearHelper", "clearTABData result=" + clearExpData);
            return clearExpData;
        } catch (Throwable th5) {
            c.d("SafeModeClearHelper", "clearTABData failed with Throwable!", th5);
            return false;
        }
    }

    private static Context j() {
        Context q16 = CrashDefendManager.i().q();
        if (q16 == null) {
            return BaseApplication.getContext();
        }
        return q16;
    }

    private static void k(@NonNull Context context) {
        try {
            File b16 = d.c().b(context, "CD/T_SW/");
            if (b16 != null && b16.exists()) {
                File file = new File(b16.getAbsolutePath(), "N_C");
                if (file.exists()) {
                    file.delete();
                }
                c.a("SafeModeClearHelper", "removeSystemTestClearConfigSwitchFile end!");
                return;
            }
            c.g("SafeModeClearHelper", "removeSystemTestClearConfigSwitchFile dir is invalied");
        } catch (Throwable th5) {
            c.d("SafeModeClearHelper", "removeSystemTestClearConfigSwitchFile failed with Throwable!", th5);
        }
    }

    public static synchronized void n(Context context) {
        synchronized (SafeModeClearHelper.class) {
            if (context == null) {
                c.c("SafeModeClearHelper", "tryClearAllConfigForSystemTest jump context is null!");
                return;
            }
            com.tencent.qqperf.crashdefend.c.a(context);
            if (SafeModeHelper.a() && a(context)) {
                b(context);
                k(context);
            }
        }
    }

    private static void m(Context context) {
    }

    private static void l(int i3, String str, String str2) {
    }
}
