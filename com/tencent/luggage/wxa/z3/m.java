package com.tencent.luggage.wxa.z3;

import android.hardware.Camera;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;

/* compiled from: P */
/* loaded from: classes9.dex */
public class m {
    /* JADX WARN: Removed duplicated region for block: B:19:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public q a(int i3, int i16) {
        int i17;
        int i18;
        q qVar = new q();
        qVar.f146264a = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            w.d("CameraUtilImpl23", "Call Camera.open cameraID " + i3);
            qVar.f146264a = CameraMonitor.open(i3);
            w.d("CameraUtilImpl23", String.format("Call Camera.open back, use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            if (qVar.f146264a == null) {
                w.b("CameraUtilImpl23", "open camera error, not exception, but camera null");
                return null;
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            long currentTimeMillis2 = System.currentTimeMillis();
            w.d("CameraUtilImpl23", "Call Camera.getCameraInfo cameraID " + i3);
            Camera.getCameraInfo(i3, cameraInfo);
            w.d("CameraUtilImpl23", String.format("Call Camera.getCameraInfo back, use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)));
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 == 3) {
                            i17 = 270;
                        }
                    } else {
                        i17 = 180;
                    }
                } else {
                    i17 = 90;
                }
                if (cameraInfo.facing != 1) {
                    i18 = (360 - (cameraInfo.orientation % 360)) % 360;
                } else {
                    i18 = ((cameraInfo.orientation - i17) + 360) % 360;
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                w.d("CameraUtilImpl23", "Call Camera.setDisplayOrientation " + i18);
                qVar.f146264a.setDisplayOrientation(i18);
                w.d("CameraUtilImpl23", String.format("Call Camera.setDisplayOrientation back, use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3)));
                qVar.f146265b = i18;
                return qVar;
            }
            i17 = 0;
            if (cameraInfo.facing != 1) {
            }
            long currentTimeMillis32 = System.currentTimeMillis();
            w.d("CameraUtilImpl23", "Call Camera.setDisplayOrientation " + i18);
            qVar.f146264a.setDisplayOrientation(i18);
            w.d("CameraUtilImpl23", String.format("Call Camera.setDisplayOrientation back, use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis32)));
            qVar.f146265b = i18;
            return qVar;
        } catch (Exception e16) {
            w.b("CameraUtilImpl23", "open camera error " + e16.getMessage());
            return null;
        }
    }
}
