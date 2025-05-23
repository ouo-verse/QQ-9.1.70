package com.tencent.zplan.meme;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.zplan.common.utils.LogUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class f {
    public static byte[] a(byte[] bArr, int i3, int i16, int i17) throws OutOfMemoryError {
        if (i3 < i17) {
            b("flipVerticalAndCropCenter originWidth < width error, " + i3 + "<" + i17, null);
            return bArr;
        }
        byte[] bArr2 = new byte[i16 * i17 * 4];
        if (i16 * i3 * 4 <= bArr.length) {
            for (int i18 = i16; i18 > 0; i18--) {
                System.arraycopy(bArr, ((i18 - 1) * i3 * 4) + (((i3 - i17) / 2) * 4), bArr2, (i16 - i18) * i17 * 4, i17 * 4);
            }
        }
        return bArr2;
    }

    private static void b(String str, Throwable th5) {
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            a16.e("[zplan][MemeUtil]", 1, str, th5);
        } else {
            Log.e("[zplan][MemeUtil]", str, th5);
        }
    }

    public static boolean c(Bitmap bitmap, int i3, File file) throws IOException {
        File file2 = new File(file.getParent());
        if (!file2.exists() || !file2.isDirectory()) {
            file2.mkdirs();
        }
        if (!file.exists() || !file.isFile()) {
            file.createNewFile();
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i3, bufferedOutputStream2);
                bufferedOutputStream2.flush();
                bufferedOutputStream2.close();
                return true;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    b("saveBitmapFileAsJPEG error.", th);
                    return false;
                } finally {
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean d(Bitmap bitmap, File file) throws IOException {
        return c(bitmap, 100, file);
    }

    public static boolean e(Bitmap bitmap, int i3, String str) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        File file = new File(str);
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            File file2 = new File(file.getParent());
            if (!file2.exists() || !file2.isDirectory()) {
                file2.mkdirs();
            }
            if (!file.exists() || !file.isFile()) {
                file = com.tencent.zplan.common.utils.c.f385288a.c(str);
            }
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, i3, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return true;
        } catch (Throwable th6) {
            th = th6;
            bufferedOutputStream2 = bufferedOutputStream;
            try {
                b("saveBitmapFileAsPNG error.", th);
                return false;
            } finally {
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
            }
        }
    }

    public static void f(byte[] bArr, int i3) {
        if (bArr != null && bArr.length >= 4 && bArr.length % 4 == 0) {
            byte b16 = (byte) ((i3 >> 16) & 255);
            byte b17 = (byte) ((i3 >> 8) & 255);
            byte b18 = (byte) (i3 & 255);
            byte b19 = (byte) ((i3 >> 24) & 255);
            for (int i16 = 0; i16 <= bArr.length - 4; i16 += 4) {
                int i17 = i16 + 3;
                if (bArr[i17] == 0) {
                    bArr[i16] = b16;
                    bArr[i16 + 1] = b17;
                    bArr[i16 + 2] = b18;
                    bArr[i17] = b19;
                }
            }
            return;
        }
        b("updateBackgroundPixel exit due to pixel error", null);
    }
}
