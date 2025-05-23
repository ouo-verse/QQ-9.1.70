package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f63668a = {AECameraConstants.FILAMENT_NAME};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f63669b = {AECameraConstants.LIB_PAG};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f63670c = {"libalgo_rithm_jni.so", "libimage_filter_common.so", "libimage_filter_gpu.so", "libpitu_device.so", "libpitu_tools.so", "libpitu_voice.so", "libvoicechanger_shared.so", "libtav.so", "libtavffmpeg.so"};

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f63671d = {AECameraConstants.LIB_LIGHT, "liblight_device_query.so"};

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap<String, String[]> f63672e = new HashMap<>();

    public static void b() {
        HashMap<String, String[]> hashMap = f63672e;
        if (hashMap.size() > 0) {
            return;
        }
        hashMap.put(AEResInfo.AGENT_TYPE_FILAMENT, f63668a);
        hashMap.put(AEResInfo.AGENT_TYPE_AE_BASE_RES, f63670c);
        hashMap.put(AEResInfo.AGENT_TYPE_LIGHT_SDK_BASE, f63671d);
        hashMap.put(AEResInfo.AGENT_TYPE_PAG, f63669b);
    }

    public static void a(AEResBeanWrapper aEResBeanWrapper) {
        String[] strArr;
        if (aEResBeanWrapper == null) {
            return;
        }
        b();
        HashMap<String, String[]> hashMap = f63672e;
        if (!hashMap.containsKey(aEResBeanWrapper.agentType) || (strArr = hashMap.get(aEResBeanWrapper.agentType)) == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            String str2 = AEResUtil.H(aEResBeanWrapper) + str;
            if (str2 != null && new File(str2).exists()) {
                ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFilePath(BaseApplication.context, str2);
                ms.a.f("SOResManager", "checkAndUpdateSoRes completed:" + str2);
            } else {
                ms.a.c("SOResManager", "checkAndUpdateSoRes error: soPath is null or not exits = " + str2);
                return;
            }
        }
    }
}
