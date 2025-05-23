package com.microrapid.opencv;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class ImageAutoProcessor {
    public static ImageStatisticsData getImageStatistics(Bitmap bitmap, String str) {
        return new ImageStatisticsData(nativeGetImageStatistics(bitmap, str));
    }

    @NonNull
    public static List<ImageMainColorData> mainColorExtract(@NonNull Bitmap bitmap, int i3) {
        float[][] nativeMainColorExtract = nativeMainColorExtract(bitmap, i3);
        LinkedList linkedList = new LinkedList();
        if (nativeMainColorExtract == null) {
            return linkedList;
        }
        for (float[] fArr : nativeMainColorExtract) {
            if (fArr != null) {
                linkedList.add(new ImageMainColorData(fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5]));
            }
        }
        return linkedList;
    }

    public static native void nativeContrastAuto(Bitmap bitmap, Bitmap bitmap2);

    public static native void nativeDenoiseBEEPS(Bitmap bitmap, Bitmap bitmap2);

    public static native double[] nativeGetImageStatistics(Bitmap bitmap, String str);

    public static native void nativeLightnessAuto(Bitmap bitmap, Bitmap bitmap2);

    public static native float[][] nativeMainColorExtract(Bitmap bitmap, int i3);

    public static native double nativeTemperatureFromUIColor(String str, int i3, int i16, int i17);
}
