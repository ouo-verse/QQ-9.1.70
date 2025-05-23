package com.tencent.mobileqq.mini.api;

import android.util.Log;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQMiniManager {
    public static Entity createDeskTopAppEntity() {
        try {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).createDeskTopAppEntity();
        } catch (Throwable th5) {
            Log.e("QQMiniManager", "", th5);
            return null;
        }
    }

    public static Manager createMiniAppEntityManager(String str) {
        try {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).createMiniAppEntityManager(str);
        } catch (Throwable th5) {
            Log.e("QQMiniManager", "", th5);
            return null;
        }
    }

    public static AppRuntime createMiniAppInterface(MobileQQ mobileQQ, String str) {
        try {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).createMiniAppInterface(mobileQQ, str);
        } catch (Throwable th5) {
            Log.e("QQMiniManager", "", th5);
            return null;
        }
    }

    public static Class getApkgConfigManagerClass() {
        try {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).getApkgConfigManagerClass();
        } catch (Throwable th5) {
            Log.e("QQMiniManager", "", th5);
            return null;
        }
    }

    public static Class getAppBrandUIClass() {
        try {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).getAppBrandUIClass();
        } catch (Throwable th5) {
            Log.e("QQMiniManager", "", th5);
            return null;
        }
    }

    public static Class getDeskTopAppEntityClass() {
        try {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).getDeskTopAppEntityClass();
        } catch (Throwable th5) {
            Log.e("QQMiniManager", "", th5);
            return null;
        }
    }

    public static Class getDesktopAppEntityV3Class() {
        try {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).getDesktopAppEntityV3Class();
        } catch (Throwable th5) {
            Log.e("QQMiniManager", "", th5);
            return null;
        }
    }

    public static Class getMiniAppEntityClass() {
        try {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniAppEntityClass();
        } catch (Throwable th5) {
            Log.e("QQMiniManager", "", th5);
            return null;
        }
    }

    public static String getMiniAppEntryHandlerClassName() {
        try {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniAppEntryHandlerClass().getName();
        } catch (Throwable th5) {
            Log.e("QQMiniManager", "", th5);
            return null;
        }
    }

    public static Class getMiniAppExposureManagerClass() {
        try {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniAppExposureManagerClass();
        } catch (Throwable th5) {
            Log.e("QQMiniManager", "", th5);
            return null;
        }
    }

    public static Class getMiniAppGameDebugSettingFragmentClass() {
        try {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniAppGameDebugSettingFragmentClass();
        } catch (Throwable th5) {
            Log.e("QQMiniManager", "", th5);
            return null;
        }
    }

    public static Class getMiniAppLocalSearchManagerClass() {
        try {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniAppLocalSearchManagerClass();
        } catch (Throwable th5) {
            Log.e("QQMiniManager", "", th5);
            return null;
        }
    }

    public static Class getMiniAppSearchDataManagerClass() {
        try {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniAppSearchDataManagerClass();
        } catch (Throwable th5) {
            Log.e("QQMiniManager", "", th5);
            return null;
        }
    }

    public static Class getMiniAppUserAppInfoListManagerClass() {
        try {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniAppUserAppInfoListManagerClass();
        } catch (Throwable th5) {
            Log.e("QQMiniManager", "", th5);
            return null;
        }
    }

    public static Class getPublicFragmentActivityForMiniClass() {
        try {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).getPublicFragmentActivityForMiniClass();
        } catch (Throwable th5) {
            Log.e("QQMiniManager", "", th5);
            return null;
        }
    }
}
