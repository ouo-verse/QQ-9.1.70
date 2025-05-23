package com.tencent.luggage.wxa.z3;

import android.hardware.Camera;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class r {
    public static int a() {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i3 = 0;
        while (true) {
            if (i3 >= numberOfCameras) {
                i3 = 0;
                break;
            }
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == 0) {
                w.a("ScanCameraUtil", String.format("cam get bid %d", Integer.valueOf(i3)));
                break;
            }
            i3++;
        }
        w.a("ScanCameraUtil", String.format("cam getBackCameraId %d", Integer.valueOf(i3)));
        return i3;
    }

    public static q a(int i3, int i16) {
        if (com.tencent.luggage.wxa.t9.l.g().equals("M9")) {
            return new n().a(i3, i16);
        }
        w.a("ScanCameraUtil", "openCamera(), CameraUtilImplAPI9, cameraId = " + i3);
        return new m().a(i3, i16);
    }
}
