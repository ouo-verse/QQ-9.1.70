package com.tencent.mobileqq.utils;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class r {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static Boolean f307813a;

        private static boolean a() {
            if (b() > 29) {
                try {
                    return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("chat_list_blur_view_enabled_8988", true);
                } catch (Throwable unused) {
                    return true;
                }
            }
            if (Build.VERSION.SDK_INT >= 24) {
                return true;
            }
            return false;
        }

        private static int b() {
            ApplicationInfo applicationInfo = MobileQQ.sMobileQQ.getApplicationInfo();
            if (applicationInfo == null) {
                return 0;
            }
            return applicationInfo.targetSdkVersion;
        }

        public static boolean c() {
            Boolean bool = f307813a;
            if (bool != null) {
                return bool.booleanValue();
            }
            f307813a = Boolean.valueOf(a());
            QLog.i("BlurUtil", 1, "is blur enabled, enable:" + f307813a + ", target api:" + b() + ", build api:" + Build.VERSION.SDK_INT);
            return f307813a.booleanValue();
        }
    }

    public static boolean a() {
        return a.c();
    }
}
