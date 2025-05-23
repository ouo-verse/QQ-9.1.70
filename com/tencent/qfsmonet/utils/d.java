package com.tencent.qfsmonet.utils;

import android.hardware.SensorManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static void a(float[] fArr, int i3, float[] fArr2) {
        float[] fArr3 = new float[16];
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        SensorManager.getRotationMatrixFromVector(fArr3, fArr);
                        SensorManager.remapCoordinateSystem(fArr3, 130, 1, fArr2);
                        return;
                    }
                    return;
                }
            } else {
                SensorManager.getRotationMatrixFromVector(fArr3, fArr);
                SensorManager.remapCoordinateSystem(fArr3, 2, 129, fArr2);
                return;
            }
        }
        SensorManager.getRotationMatrixFromVector(fArr2, fArr);
    }
}
