package com.tencent.av.opengl;

import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes3.dex */
public class PtuSoLoader {
    private static final String TAG = "PtuSoLoader";
    public static boolean ptuSoVersion = false;
    public static boolean soloadedPTV = false;

    public static void loadPtuSO() {
        if (((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).isEnableAEModuleManager()) {
            soloadedPTV = ((IAEResUtil) QRoute.api(IAEResUtil.class)).loadAEBaseSo();
            ptuSoVersion = ((IAEResUtil) QRoute.api(IAEResUtil.class)).isFilterFaceSoVersionOK();
        }
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 1, "loadPtuSO, soloadedPTV[" + soloadedPTV + "], ptuSoVersion[" + ptuSoVersion + "], isSupported[" + ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).isEnableAEModuleManager() + "]");
        }
    }
}
