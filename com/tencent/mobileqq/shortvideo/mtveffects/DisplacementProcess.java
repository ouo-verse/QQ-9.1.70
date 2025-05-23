package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.Bitmap;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes18.dex */
public class DisplacementProcess {
    private static void calcHorizontialPosition(int[] iArr, int[] iArr2, int i3, int i16, int i17, int i18) {
        if (iArr != null && iArr2 != null) {
            int i19 = i3 * i16;
            for (int i26 = i19; i26 < i16; i26++) {
                iArr[i26] = -1;
            }
            for (int i27 = 0; i27 < i16; i27++) {
                int i28 = i19 + i27;
                int i29 = iArr2[i28];
                int grayValue = ((int) ((((grayValue((i29 >> 16) & 255, (i29 >> 8) & 255, i29 & 255) - 128) * i18) * 1.0f) / 255.0f)) + i28;
                if (grayValue >= i19 && grayValue < i19 + i16) {
                    iArr[grayValue] = formatCoordinate((int) ((((i28 - i19) * 1.0f) / i16) * 1.572864E7f));
                }
            }
        }
    }

    private static int formatCoordinate(int i3) {
        return (i3 & 16777215) | (-16777216);
    }

    private static int grayValue(int i3, int i16, int i17) {
        return (((i3 * 299) + (i16 * LpReportInfoConfig.ACTION_HOMEPAGE_GUEST)) + (i17 * 114)) / 1000;
    }

    public static Bitmap horizontialProcess(Bitmap bitmap, int i3) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i16 = width * height;
            int[] iArr = new int[i16];
            int[] iArr2 = new int[i16];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            for (int i17 = 0; i17 < height; i17++) {
                calcHorizontialPosition(iArr2, iArr, i17, width, height, i3);
            }
            return Bitmap.createBitmap(iArr2, width, height, Bitmap.Config.ARGB_8888);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void saveBitmap(Bitmap bitmap, String str) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        File file2 = new File(file.getParent());
        if (!file2.exists()) {
            file2.mkdirs();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e16) {
            e = e16;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } catch (FileNotFoundException e17) {
            e = e17;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            fileOutputStream = fileOutputStream2;
            if (fileOutputStream == null) {
            }
        }
        if (fileOutputStream == null) {
            try {
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e18) {
                e18.printStackTrace();
            }
        }
    }
}
