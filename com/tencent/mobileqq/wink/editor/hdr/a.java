package com.tencent.mobileqq.wink.editor.hdr;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.gyailib.library.GYAssessPicQuality;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.enhance.api.IEnhanceHelper;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.gathererga.core.HardwareInfoProvider;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.tavcut.core.session.ICutSession;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f320450a = false;

    /* renamed from: b, reason: collision with root package name */
    private static GYAssessPicQuality f320451b = null;

    /* renamed from: c, reason: collision with root package name */
    private static int f320452c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static int f320453d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f320454e = false;

    public static boolean a() {
        if (k() && m()) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        ms.a.f("wink_hdr_HDRInitUtils", "checkHdrSo|WILL.");
        if (!f320450a) {
            String aEKitBaseResUnzipFinalPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEKitBaseResUnzipFinalPath();
            ms.a.f("wink_hdr_HDRInitUtils", "checkHdrSo|filePath:" + aEKitBaseResUnzipFinalPath);
            if (!TextUtils.isEmpty(aEKitBaseResUnzipFinalPath)) {
                System.load(aEKitBaseResUnzipFinalPath + "libYTHDR.so");
                ms.a.f("wink_hdr_HDRInitUtils", "checkHdrSo|finish.");
                f320450a = true;
            }
        }
        return true;
    }

    public static boolean c() {
        boolean z16;
        int i3 = 1;
        if (f320452c == 1) {
            ms.a.f("wink_hdr_HDRInitUtils", "can show hdr directly");
            return true;
        }
        if (((IEnhanceHelper) QRoute.api(IEnhanceHelper.class)).getEnhanceConfig().b()) {
            if (((IEnhanceHelper) QRoute.api(IEnhanceHelper.class)).getEnhanceConfig().getHdrType() == 0) {
                f320453d = !a() ? 1 : 0;
                if (o()) {
                    z16 = n();
                } else {
                    z16 = h();
                }
            } else {
                f320453d = 1;
                z16 = h();
            }
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 2;
        }
        f320452c = i3;
        ms.a.f("wink_hdr_HDRInitUtils", "couldShowHDR:" + f320452c + ProgressTracer.SEPARATOR + ((IEnhanceHelper) QRoute.api(IEnhanceHelper.class)).getEnhanceConfig().b() + ", type: " + f320453d);
        return z16;
    }

    public static com.tencent.videocut.render.b<Boolean, com.tencent.videocut.render.l> d(ICutSession iCutSession) {
        if (o()) {
            w53.b.a("wink_hdr_HDRInitUtils", "create normal hdr processor");
            return new com.tencent.videocut.render.h(iCutSession);
        }
        w53.b.a("wink_hdr_HDRInitUtils", "create downGrade hdr processor");
        return new com.tencent.videocut.render.e(iCutSession);
    }

    public static int e(GYAssessPicQuality gYAssessPicQuality) {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        ar arVar = ar.f326685a;
        int i3 = 0;
        if (arVar.a("ae_key_editor_opencl_hdr_option")) {
            i3 = arVar.e("ae_key_editor_opencl_hdr_option", 0);
            z16 = true;
        } else if (gYAssessPicQuality != null) {
            int hDROption = gYAssessPicQuality.getHDROption();
            arVar.o("ae_key_editor_opencl_hdr_option", hDROption);
            i3 = hDROption;
            z16 = false;
        } else {
            z16 = false;
        }
        ms.a.f("wink_hdr_HDRInitUtils", "hdr option:" + i3 + ", fromCache:" + z16 + ", cost:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return i3;
    }

    private static int f(SDKDeviceConfig sDKDeviceConfig) {
        if (f320451b == null) {
            f320451b = new GYAssessPicQuality();
        }
        int initInstance = f320451b.initInstance(sDKDeviceConfig);
        if (initInstance != 0) {
            return initInstance;
        }
        SDKModelConfig sDKModelConfig = new SDKModelConfig();
        HashMap hashMap = new HashMap();
        sDKModelConfig.modelPaths = hashMap;
        hashMap.put("root-path", ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir(AEResInfo.LIGHT_RES_BUNDLE_PIC_QUALITY));
        return f320451b.setupWithModel(sDKModelConfig);
    }

    public static boolean g() {
        if (f320453d == 1) {
            return true;
        }
        return false;
    }

    public static boolean h() {
        if (((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BUNDLE_PIC_ENHANCE) && ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BASE_PACKAGE)) {
            return true;
        }
        return false;
    }

    public static boolean i() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            boolean equalsIgnoreCase = HardwareInfoProvider.HARMONY_OS.equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString());
            ms.a.f("wink_hdr_HDRInitUtils", "Phone is HarmonyOS:" + equalsIgnoreCase);
            return equalsIgnoreCase;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean j() {
        boolean z16;
        String str = Build.BRAND;
        if (!"HUAWEI".equals(str.toUpperCase()) && !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR.equals(str.toUpperCase())) {
            z16 = false;
        } else {
            z16 = true;
        }
        ms.a.f("wink_hdr_HDRInitUtils", "Phone upper brand:" + str.toUpperCase());
        return z16;
    }

    public static boolean k() {
        if (j() && l()) {
            return false;
        }
        return true;
    }

    private static boolean l() {
        String[] split;
        String[] split2;
        try {
            String str = (String) SystemProperties.class.getDeclaredMethod("get", String.class).invoke(SystemProperties.class, "ro.build.version.emui");
            ms.a.f("wink_hdr_HDRInitUtils", "huawei build version is :" + str);
            if (!TextUtils.isEmpty(str) && (split = str.split("_")) != null && split.length >= 2 && (split2 = split[1].split("\\.")) != null && split2.length != 0) {
                int parseInt = Integer.parseInt(split2[0]);
                ms.a.f("wink_hdr_HDRInitUtils", "huawei ui main version is :" + parseInt);
                if (!str.startsWith("MagicUI")) {
                    if (!str.startsWith("MagicOS")) {
                        if (parseInt > 10) {
                            return false;
                        }
                        return true;
                    }
                }
                if (parseInt > 3) {
                    return false;
                }
                return true;
            }
            return false;
        } catch (Throwable th5) {
            ms.a.f("wink_hdr_HDRInitUtils", "isLowEMUI10\uff1aexception!!!" + th5.getMessage());
            return false;
        }
    }

    public static boolean m() {
        if (((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BASE_PACKAGE) && ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BUNDLE_PIC_QUALITY)) {
            SDKDeviceConfig sDKDeviceConfig = new SDKDeviceConfig();
            sDKDeviceConfig.setDevice("ARM");
            try {
                ms.a.a("wink_hdr_HDRInitUtils", "initRes: " + f(sDKDeviceConfig));
                int e16 = e(f320451b);
                f320454e = true;
                if (e16 == 0) {
                    return false;
                }
                return true;
            } catch (UnsatisfiedLinkError e17) {
                ms.a.d("wink_hdr_HDRInitUtils", "initPicQuality error: ", e17);
            }
        }
        return false;
    }

    public static boolean n() {
        if (((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BASE_PACKAGE) && ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BUNDLE_PIC_QUALITY)) {
            return true;
        }
        return false;
    }

    public static boolean o() {
        if (f320453d == 0) {
            return true;
        }
        return false;
    }
}
