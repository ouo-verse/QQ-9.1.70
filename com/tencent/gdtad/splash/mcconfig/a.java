package com.tencent.gdtad.splash.mcconfig;

import com.tencent.gdtad.splash.mcconfig.GdtSplashAdPreloadConfigParser;
import com.tencent.gdtad.splash.mcconfig.GdtSplashAdSwitchConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {
    public static GdtSplashAdPreloadConfigParser.a a() {
        try {
            GdtSplashAdPreloadConfigParser.a aVar = (GdtSplashAdPreloadConfigParser.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100410");
            QLog.i("GdtSplashAdConfigManager", 1, "getPreloadConfig, config=" + aVar);
            return aVar;
        } catch (Throwable th5) {
            GdtSplashAdPreloadConfigParser.a aVar2 = new GdtSplashAdPreloadConfigParser.a();
            QLog.e("GdtSplashAdConfigManager", 1, "getPreloadConfig, default=" + aVar2, th5);
            return aVar2;
        }
    }

    public static GdtSplashAdSwitchConfigParser.a b() {
        try {
            GdtSplashAdSwitchConfigParser.a aVar = (GdtSplashAdSwitchConfigParser.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100409");
            QLog.i("GdtSplashAdConfigManager", 1, "getSwitchConfig, config=" + aVar);
            return aVar;
        } catch (Throwable th5) {
            GdtSplashAdSwitchConfigParser.a aVar2 = new GdtSplashAdSwitchConfigParser.a();
            QLog.e("GdtSplashAdConfigManager", 1, "getSwitchConfig, default=" + aVar2, th5);
            return aVar2;
        }
    }

    public static boolean c() {
        boolean z16 = false;
        try {
            z16 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100411", false);
            QLog.i("GdtSplashAdConfigManager", 1, "isDeleteSplashAdCache=" + z16);
            return z16;
        } catch (Throwable th5) {
            QLog.e("GdtSplashAdConfigManager", 1, "isDeleteSplashAdCache, default=false", th5);
            return z16;
        }
    }

    public static boolean d() {
        boolean z16 = false;
        try {
            z16 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100410", false);
            QLog.i("GdtSplashAdConfigManager", 1, "isPreloadSplashAd=" + z16);
            return z16;
        } catch (Throwable th5) {
            QLog.e("GdtSplashAdConfigManager", 1, "isPreloadSplashAd, default=false", th5);
            return z16;
        }
    }

    public static boolean e() {
        boolean z16 = false;
        try {
            z16 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100409", false);
            QLog.i("GdtSplashAdConfigManager", 1, "isSplashAdEnabled=" + z16);
            return z16;
        } catch (Throwable th5) {
            QLog.e("GdtSplashAdConfigManager", 1, "isSplashAdEnabled, default=false", th5);
            return z16;
        }
    }
}
