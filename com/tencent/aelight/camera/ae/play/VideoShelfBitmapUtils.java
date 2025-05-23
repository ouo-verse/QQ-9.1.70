package com.tencent.aelight.camera.ae.play;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class VideoShelfBitmapUtils {
    public static Bitmap resizeImage(Bitmap bitmap, int i3, int i16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i3 / width, i16 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap rotateWithExif(Bitmap bitmap, String str) {
        int degreeByExif;
        return (BitmapUtils.isLegal(bitmap) && (degreeByExif = BitmapUtils.getDegreeByExif(str) % 360) != 0) ? BitmapUtils.rotateBitmap(bitmap, degreeByExif) : bitmap;
    }
}
