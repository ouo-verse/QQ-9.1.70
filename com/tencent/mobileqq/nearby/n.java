package com.tencent.mobileqq.nearby;

import android.util.Log;
import com.tencent.mobileqq.nearby.api.INearbyService;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes15.dex */
public class n {
    public static Class a() {
        try {
            return ((INearbyService) QRoute.api(INearbyService.class)).getDynamicNowManagerClass();
        } catch (Throwable th5) {
            Log.e("QQNearbyManager", "[getDynamicNowManagerClass]", th5);
            return null;
        }
    }

    public static Class b() {
        try {
            return ((INearbyService) QRoute.api(INearbyService.class)).getGroupVideoManagerClass();
        } catch (Throwable th5) {
            Log.e("QQNearbyManager", "[getGroupVideoManagerClass]", th5);
            return null;
        }
    }

    public static String c() {
        try {
            return ((INearbyService) QRoute.api(INearbyService.class)).getHuayangPluginLauncherClassName();
        } catch (Throwable th5) {
            Log.e("QQNearbyManager", "[getHuayangPluginLauncherClassName]", th5);
            return null;
        }
    }

    public static String d() {
        try {
            return ((INearbyService) QRoute.api(INearbyService.class)).getHuayangPluginNewDownloaderClassName();
        } catch (Throwable th5) {
            Log.e("QQNearbyManager", "[getHuayangPluginNewDownloaderClassName]", th5);
            return null;
        }
    }

    public static Class e() {
        try {
            return ((INearbyService) QRoute.api(INearbyService.class)).getMiniCardManagerClass();
        } catch (Throwable th5) {
            Log.e("QQNearbyManager", "[getMiniCardManagerClass]", th5);
            return null;
        }
    }

    public static String f() {
        try {
            return ((INearbyService) QRoute.api(INearbyService.class)).getNearbyCardHandlerClassName();
        } catch (Throwable th5) {
            Log.e("QQNearbyManager", "[getNearbyCardHandlerClassName]", th5);
            return null;
        }
    }

    public static Class g() {
        try {
            return ((INearbyService) QRoute.api(INearbyService.class)).getNearbyCardManagerClass();
        } catch (Throwable th5) {
            Log.e("QQNearbyManager", "[getNearbyCardManagerClass]", th5);
            return null;
        }
    }

    public static Class h() {
        try {
            return ((INearbyService) QRoute.api(INearbyService.class)).getNearbyGeneralManagerClass();
        } catch (Throwable th5) {
            Log.e("QQNearbyManager", "[getNearbyGeneralManagerClass]", th5);
            return null;
        }
    }

    public static Class i() {
        try {
            return ((INearbyService) QRoute.api(INearbyService.class)).getNearbyHandlerClass();
        } catch (Throwable th5) {
            Log.e("QQNearbyManager", "[getNearbyHandlerClass]", th5);
            return null;
        }
    }

    public static Class j() {
        try {
            return ((INearbyService) QRoute.api(INearbyService.class)).getNearbyLikeLimitManagerClass();
        } catch (Throwable th5) {
            Log.e("QQNearbyManager", "[getNearbyLikeLimitManagerClass]", th5);
            return null;
        }
    }

    public static Class k() {
        try {
            return ((INearbyService) QRoute.api(INearbyService.class)).getNearbyMomentManagerClass();
        } catch (Throwable th5) {
            Log.e("QQNearbyManager", "[getNearbyMomentManagerClass]", th5);
            return null;
        }
    }

    public static Class l() {
        try {
            return ((INearbyService) QRoute.api(INearbyService.class)).getNearbyProxyClass();
        } catch (Throwable th5) {
            Log.e("QQNearbyManager", "[getNearbyProxyClass]", th5);
            return null;
        }
    }

    public static String m() {
        try {
            return ((INearbyService) QRoute.api(INearbyService.class)).getNearbyRelevantHandlerClassName();
        } catch (Throwable th5) {
            Log.e("QQNearbyManager", "[getNearbyRelevantHandlerClass]", th5);
            return null;
        }
    }

    public static String n() {
        try {
            return ((INearbyService) QRoute.api(INearbyService.class)).getNowChannerHandlerV2ClassName();
        } catch (Throwable th5) {
            Log.e("QQNearbyManager", "[getNowChannerHandlerV2ClassName]", th5);
            return null;
        }
    }

    public static int o() {
        try {
            return ((INearbyService) QRoute.api(INearbyService.class)).getQQNearbyFactoryCountManager();
        } catch (Throwable th5) {
            Log.e("QQNearbyManager", "[getQQNearbyFactoryCountManager]", th5);
            return 0;
        }
    }

    public static Class p() {
        try {
            return ((INearbyService) QRoute.api(INearbyService.class)).getSmallVideoFragmentClass();
        } catch (Throwable th5) {
            Log.e("QQNearbyManager", "[getSmallVideoFragmentClass]", th5);
            return null;
        }
    }
}
