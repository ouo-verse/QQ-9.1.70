package com.tencent.mobileqq.qqvideoedit;

import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.ResourceLoadUtil;
import java.util.ArrayList;
import qd4.DynamicSoConfig;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    private static boolean a(String str) {
        try {
            System.load(str);
            return true;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public static boolean b() {
        boolean z16;
        boolean z17;
        String unzipAEResPath;
        String unzipAEResPath2;
        String aEKitBaseResUnzipFinalPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEKitBaseResUnzipFinalPath();
        try {
            System.loadLibrary(AECameraConstants.LIB_V8);
            z16 = ResourceLoadUtil.loadSoSync(aEKitBaseResUnzipFinalPath + "libtav.so");
        } catch (Throwable th5) {
            QLog.e("QQVideoEditResManager", 1, "loadAEKit fail: ", th5);
            z16 = false;
        }
        String lightSDKBaseResUnzipFinalPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightSDKBaseResUnzipFinalPath();
        try {
            System.loadLibrary(AECameraConstants.LIB_V8);
            unzipAEResPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getUnzipAEResPath(AEResInfo.LIGHT_RES_FILAMENT);
            unzipAEResPath2 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getUnzipAEResPath(AEResInfo.LIGHT_RES_PAG);
        } catch (Throwable th6) {
            QLog.e("QQVideoEditResManager", 1, "loadLight fail: ", th6);
        }
        if (a(unzipAEResPath + AECameraConstants.FILAMENT_NAME)) {
            if (a(unzipAEResPath2 + AECameraConstants.LIB_PAG)) {
                if (a(lightSDKBaseResUnzipFinalPath + AECameraConstants.LIB_LIGHT)) {
                    z17 = true;
                    if (!z16 && z17) {
                        return true;
                    }
                    return false;
                }
            }
        }
        z17 = false;
        if (!z16) {
        }
        return false;
    }

    public static boolean c() {
        DynamicSoConfig dynamicSoConfig = new DynamicSoConfig(((IAEResUtil) QRoute.api(IAEResUtil.class)).getUnzipAEResPath(AEResInfo.LIGHT_RES_FILAMENT), AECameraConstants.FILAMENT_NAME, false);
        DynamicSoConfig dynamicSoConfig2 = new DynamicSoConfig(((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightSDKBaseResUnzipFinalPath(), AECameraConstants.LIB_LIGHT, false);
        DynamicSoConfig dynamicSoConfig3 = new DynamicSoConfig(((IAEResUtil) QRoute.api(IAEResUtil.class)).getUnzipAEResPath(AEResInfo.LIGHT_RES_PAG), AECameraConstants.LIB_PAG, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(dynamicSoConfig);
        arrayList.add(dynamicSoConfig3);
        arrayList.add(dynamicSoConfig2);
        return od4.b.y(arrayList);
    }
}
