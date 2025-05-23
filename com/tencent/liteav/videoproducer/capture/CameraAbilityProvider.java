package com.tencent.liteav.videoproducer.capture;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;

@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class CameraAbilityProvider {
    public static int getCamera2SupportLevel() {
        CameraManager cameraManager = (CameraManager) ContextUtils.getApplicationContext().getSystemService("camera");
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            if (cameraIdList.length <= 0) {
                return -1;
            }
            return getSystemHardwareLevel(cameraManager, cameraIdList);
        } catch (Throwable th5) {
            LiteavLog.e("CameraAbilityProvider", "getCamera2SupportLevel exception:".concat(String.valueOf(th5)));
            return -1;
        }
    }

    private static int getSystemHardwareLevel(CameraManager cameraManager, String[] strArr) throws Throwable {
        int i3 = -1;
        for (String str : strArr) {
            CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
            Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            if (num == null || num.intValue() == 0 || num.intValue() == 1) {
                Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                if (num2 == null) {
                    return -1;
                }
                i3 = num2.intValue();
            }
        }
        return i3;
    }
}
