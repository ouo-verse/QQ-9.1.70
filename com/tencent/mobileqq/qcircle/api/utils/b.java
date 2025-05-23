package com.tencent.mobileqq.qcircle.api.utils;

import android.os.Build;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    public static String a(String str) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_clip_data_black_list_9_0_95", str);
    }

    private static String b(String str) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_data_brand_black_list_9_0_95", str);
    }

    public static boolean c() {
        if (!e() && !d()) {
            return false;
        }
        return true;
    }

    private static boolean d() {
        try {
            return Arrays.asList(b("").split("\\|")).contains(Build.BRAND);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean e() {
        try {
            return Arrays.asList(a("").split("\\|")).contains(DeviceInfoMonitor.getModel());
        } catch (Throwable unused) {
            return false;
        }
    }
}
