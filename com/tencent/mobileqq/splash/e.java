package com.tencent.mobileqq.splash;

import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static long a() {
        return QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeLong(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + g.a() + "amsHotSplashBgPreloadTime", 0L);
    }

    public static long b() {
        return QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeLong(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + g.a() + "amsSplashPreloadTime", 0L);
    }

    public static boolean c() {
        if (QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeInt(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + g.a() + "amsHotSplashBgPreload", 0) < ((IGdtAPI) QRoute.api(IGdtAPI.class)).getAmsHotSplashBgPreloadLimit()) {
            return false;
        }
        return true;
    }

    public static boolean d() {
        long currentTimeMillis = System.currentTimeMillis();
        long a16 = a();
        long b16 = b();
        if (currentTimeMillis - a16 > ((IGdtAPI) QRoute.api(IGdtAPI.class)).getAmsHotBgPreloadDuration() && currentTimeMillis - b16 > ((IGdtAPI) QRoute.api(IGdtAPI.class)).getAmsPreloadDuration()) {
            return false;
        }
        return true;
    }

    public static boolean e() {
        int decodeInt = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeInt(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + g.a() + "amsSplashFgPreload", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long b16 = b();
        if (decodeInt < ((IGdtAPI) QRoute.api(IGdtAPI.class)).getAmsSplashFgPreloadLimit() && currentTimeMillis - b16 > ((IGdtAPI) QRoute.api(IGdtAPI.class)).getAmsPreloadDuration()) {
            return false;
        }
        return true;
    }

    public static void f() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        String str = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + g.a() + "amsHotSplashBgPreload";
        int decodeInt = from.decodeInt(str, 0) + 1;
        from.encodeInt(str, decodeInt);
        QLog.d("SplashPreloadLimitManager", 1, "updateHotSplashBgPreload time:" + decodeInt + " time " + System.currentTimeMillis());
        g();
    }

    public static void g() {
        QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).encodeLong(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + g.a() + "amsHotSplashBgPreloadTime", System.currentTimeMillis());
    }

    public static void h() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        String str = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + g.a() + "amsSplashFgPreload";
        int decodeInt = from.decodeInt(str, 0) + 1;
        from.encodeInt(str, decodeInt);
        i();
        QLog.d("SplashPreloadLimitManager", 1, "updateSplashFgPreload time:" + decodeInt + " time " + System.currentTimeMillis());
    }

    public static void i() {
        QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).encodeLong(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + g.a() + "amsSplashPreloadTime", System.currentTimeMillis());
    }
}
