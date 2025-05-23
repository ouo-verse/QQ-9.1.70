package com.gyailib.librarytest;

import android.graphics.Bitmap;
import com.gyailib.library.GYDetectCommonResultStruct;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GYAITestUtil {
    static {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("gy_test_all");
        } catch (Error e16) {
            e16.printStackTrace();
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    public static native double[][] compareDetectCommonResult(GYDetectCommonResultStruct gYDetectCommonResultStruct, GYDetectCommonResultStruct gYDetectCommonResultStruct2);

    public static native float differChannel(Bitmap bitmap, Bitmap bitmap2, float f16);

    public static native float[] iou(Bitmap bitmap, Bitmap bitmap2);
}
