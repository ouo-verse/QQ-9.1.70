package com.tencent.mobileqq.shortvideo.panoramicvideo.utils;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SensorUtil {
    private static float[] mTmp = new float[16];
    private static float[] oTmp = new float[16];

    public static void getOrientation(SensorEvent sensorEvent, float[] fArr) {
        SensorManager.getRotationMatrixFromVector(oTmp, sensorEvent.values);
        SensorManager.getOrientation(oTmp, fArr);
    }

    public static void getOrientationFromRotationMatrix(float[] fArr, float[] fArr2) {
        SensorManager.getOrientation(fArr, fArr2);
    }

    public static void sensorRotationVectorToMatrix(SensorEvent sensorEvent, int i3, float[] fArr) {
        float[] fArr2 = sensorEvent.values;
        if (i3 != 0) {
            SensorManager.getRotationMatrixFromVector(mTmp, fArr2);
            SensorManager.remapCoordinateSystem(mTmp, 2, 129, fArr);
        } else {
            SensorManager.getRotationMatrixFromVector(fArr, fArr2);
        }
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }
}
