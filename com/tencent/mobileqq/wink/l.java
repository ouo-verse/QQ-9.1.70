package com.tencent.mobileqq.wink;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.utils.y;
import com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.tav.ResourceLoadUtil;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import sd4.DynamicSoConfig;

/* compiled from: P */
/* loaded from: classes21.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final String f323390a = Environment.getExternalStorageDirectory().getPath();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f323391b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f323392c = false;

    private static boolean a(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileUtils.copyFile(f323390a + File.separator + AECameraConstants.LIB_LIGHT, str + AECameraConstants.LIB_LIGHT);
            return true;
        } catch (Throwable th5) {
            w53.b.d("WinkResManager", "load error", th5);
            return false;
        }
    }

    public static String b() {
        c();
        return ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightSDKBaseResUnzipFinalPath();
    }

    private static boolean c() {
        AECameraPrefsUtil.c().b("SP_USE_LOCAL_LIGHT_SO", false, 0);
        return false;
    }

    public static boolean d() {
        return f323392c;
    }

    public static boolean e() {
        boolean z16;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z17;
        boolean z18;
        boolean z19;
        ms.a.a("WinkResManager", "loadLib begin sIsLoadedLib:" + f323392c);
        boolean c16 = c();
        boolean g16 = g();
        ms.a.c("WinkResManager", "loadLib loadAEKitResult:" + g16);
        String lightSDKBaseResUnzipFinalPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightSDKBaseResUnzipFinalPath();
        String unzipAEResPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getUnzipAEResPath(AEResInfo.LIGHT_RES_FILAMENT);
        String unzipAEResPath2 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getUnzipAEResPath(AEResInfo.LIGHT_RES_PAG);
        if (c16) {
            String lightSDKBaseResUnzipFinalPath2 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightSDKBaseResUnzipFinalPath();
            if (a(b())) {
                lightSDKBaseResUnzipFinalPath2 = b();
            }
            lightSDKBaseResUnzipFinalPath = lightSDKBaseResUnzipFinalPath2;
        }
        String h16 = h(lightSDKBaseResUnzipFinalPath);
        String h17 = h(unzipAEResPath);
        String h18 = h(unzipAEResPath2);
        boolean z26 = true;
        try {
            System.loadLibrary(AECameraConstants.LIB_V8);
            w53.b.a("WinkResManager", "lightSoPath is " + h16 + ", filamentSoPath is " + h17 + ", pagPath is " + h18);
            if (!f323392c) {
                z17 = true;
            } else {
                z17 = false;
            }
            DynamicSoConfig dynamicSoConfig = new DynamicSoConfig(h18, AECameraConstants.LIB_PAG, z17);
            if (!f323392c) {
                z18 = true;
            } else {
                z18 = false;
            }
            DynamicSoConfig dynamicSoConfig2 = new DynamicSoConfig(h17, AECameraConstants.FILAMENT_NAME, z18);
            if (!f323392c) {
                z19 = true;
            } else {
                z19 = false;
            }
            z16 = rd4.c.z(Arrays.asList(dynamicSoConfig2, dynamicSoConfig, new DynamicSoConfig(h16, AECameraConstants.LIB_LIGHT, z19)));
        } catch (Throwable th5) {
            w53.b.d("WinkResManager", "loadLib error", th5);
            z16 = false;
        }
        y.f326739a.e(h16);
        ms.a.c("WinkResManager", "loadLib loadAEKitResult:" + g16 + " loadLightResult = " + z16);
        if (!g16 || !z16) {
            z26 = false;
        }
        f323392c = z26;
        if (!z26) {
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("soPath", h16);
                hashMap.put("filamentSoPath", h17);
                String str5 = "1";
                if (f323392c) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("pag", str);
                if (f323392c) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                hashMap.put(ZPlanApiImpl.FILAMENT_TAG, str2);
                if (f323392c) {
                    str3 = "1";
                } else {
                    str3 = "0";
                }
                hashMap.put(MiniAppConst.MENU_STYLE_LIGHT, str3);
                if (g16) {
                    str4 = "1";
                } else {
                    str4 = "0";
                }
                hashMap.put("loadAEKitResult", str4);
                if (!z16) {
                    str5 = "0";
                }
                hashMap.put("loadLightResult", str5);
                ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportLoadError(hashMap);
            } catch (Exception e16) {
                ms.a.d("WinkResManager", "loadLib reportEvent error:" + f323392c, e16);
            }
        }
        ms.a.a("WinkResManager", "loadLib end sIsLoadedLib:" + f323392c);
        return f323392c;
    }

    public static void f() {
        w53.b.f("WinkResManager", "loadLibFromCache sIsLoadedLib: " + f323392c);
        if (!f323392c) {
            e();
        }
    }

    public static boolean g() {
        if (f323391b) {
            return true;
        }
        String aEKitBaseResUnzipFinalPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEKitBaseResUnzipFinalPath();
        try {
            w53.b.a("WinkResManager", "soPath is " + aEKitBaseResUnzipFinalPath);
            boolean loadSoSync = ResourceLoadUtil.loadSoSync(aEKitBaseResUnzipFinalPath + "libtav.so");
            f323391b = loadSoSync;
            return loadSoSync;
        } catch (Throwable th5) {
            w53.b.d("WinkResManager", "tavKit loadLib error", th5);
            return false;
        }
    }

    private static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.charAt(str.length() - 1) == File.separatorChar) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }
}
