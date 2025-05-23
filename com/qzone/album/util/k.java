package com.qzone.album.util;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;
import com.tencent.component.media.image.drawable.NinePatchRefDrawable;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.io.ByteArrayOutputStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes39.dex */
public class k {
    private static void a(Bitmap bitmap, byte[] bArr) {
        int width = bitmap.getWidth() - 2;
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, width, 1, bitmap.getHeight() - 1, width, 1);
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i16 >= width) {
                break;
            }
            if (-16777216 == iArr[i16]) {
                h(bArr, 12, i16);
                break;
            }
            i16++;
        }
        int i17 = width - 1;
        while (true) {
            if (i17 < 0) {
                break;
            }
            if (-16777216 == iArr[i17]) {
                h(bArr, 16, (width - i17) - 1);
                break;
            }
            i17--;
        }
        int height = bitmap.getHeight() - 2;
        int[] iArr2 = new int[height];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, height);
        while (true) {
            if (i3 >= height) {
                break;
            }
            if (-16777216 == iArr2[i3]) {
                h(bArr, 20, i3);
                break;
            }
            i3++;
        }
        for (int i18 = height - 1; i18 >= 0; i18--) {
            if (-16777216 == iArr2[i18]) {
                h(bArr, 24, (height - i18) - 1);
                return;
            }
        }
    }

    public static byte[] d(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i3 = 0; i3 < 32; i3++) {
            byteArrayOutputStream.write(0);
        }
        int i16 = width - 2;
        int[] iArr = new int[i16];
        bitmap.getPixels(iArr, 0, width, 1, 0, i16, 1);
        boolean z16 = iArr[0] == -16777216;
        boolean z17 = iArr[i16 + (-1)] == -16777216;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < i16; i19++) {
            if (iArr[i19] != -16777216) {
                iArr[i19] = 0;
            }
            if (i18 != iArr[i19]) {
                i17++;
                g(byteArrayOutputStream, i19);
                i18 = iArr[i19];
            }
        }
        if (z17) {
            i17++;
            g(byteArrayOutputStream, i16);
        }
        int i26 = i17 + 1;
        if (z16) {
            i26--;
        }
        if (z17) {
            i26--;
        }
        int i27 = height - 2;
        int[] iArr2 = new int[i27];
        bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, i27);
        boolean z18 = iArr2[0] == -16777216;
        boolean z19 = iArr2[i27 + (-1)] == -16777216;
        int i28 = 0;
        int i29 = 0;
        for (int i36 = 0; i36 < i27; i36++) {
            if (iArr2[i36] != -16777216) {
                iArr2[i36] = 0;
            }
            if (i29 != iArr2[i36]) {
                i28++;
                g(byteArrayOutputStream, i36);
                i29 = iArr2[i36];
            }
        }
        if (z19) {
            i28++;
            g(byteArrayOutputStream, i27);
        }
        int i37 = i28 + 1;
        if (z18) {
            i37--;
        }
        if (z19) {
            i37--;
        }
        int i38 = 0;
        while (true) {
            int i39 = i26 * i37;
            if (i38 < i39) {
                g(byteArrayOutputStream, 1);
                i38++;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArray[0] = 1;
                byteArray[1] = (byte) i17;
                byteArray[2] = (byte) i28;
                byteArray[3] = (byte) i39;
                a(bitmap, byteArray);
                return byteArray;
            }
        }
    }

    private static int b(byte[] bArr, int i3) {
        byte b16 = bArr[i3 + 0];
        byte b17 = bArr[i3 + 1];
        byte b18 = bArr[i3 + 2];
        return ((bArr[i3 + 3] << 24) & (-16777216)) | (b16 & 255) | ((b17 << 8) & 65280) | ((b18 << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT);
    }

    public static void e(byte[] bArr, Rect rect) {
        rect.left = b(bArr, 12);
        rect.right = b(bArr, 16);
        rect.top = b(bArr, 20);
        rect.bottom = b(bArr, 24);
    }

    public static Drawable c(BitmapReference bitmapReference) {
        Bitmap bitmap;
        if (bitmapReference == null || (bitmap = bitmapReference.getBitmap()) == null) {
            return null;
        }
        if (bitmap.getNinePatchChunk() == null) {
            return new BitmapRefDrawable(bitmapReference);
        }
        Rect rect = new Rect();
        e(bitmap.getNinePatchChunk(), rect);
        return new NinePatchRefDrawable(u4.a.z().K(), bitmapReference, bitmap.getNinePatchChunk(), rect, null);
    }

    public static byte[] f(byte[] bArr, float f16, float f17) {
        if (bArr == null) {
            return null;
        }
        byte b16 = bArr[1];
        for (int i3 = 0; i3 < b16; i3++) {
            int i16 = (i3 * 4) + 32;
            int b17 = (int) (b(bArr, i16) * f16);
            if (b17 == b(bArr, i16 - 4)) {
                b17++;
            }
            h(bArr, i16, b17);
        }
        byte b18 = bArr[2];
        for (int i17 = 0; i17 < b18; i17++) {
            int i18 = ((b16 + i17) * 4) + 32;
            int b19 = (int) (b(bArr, i18) * f17);
            if (b19 == b(bArr, i18 - 4)) {
                b19++;
            }
            h(bArr, i18, b19);
        }
        h(bArr, 12, (int) (b(bArr, 12) * f16));
        h(bArr, 16, (int) (b(bArr, 16) * f16));
        h(bArr, 20, (int) (b(bArr, 20) * f17));
        h(bArr, 24, (int) (b(bArr, 24) * f17));
        return bArr;
    }

    private static void g(ByteArrayOutputStream byteArrayOutputStream, int i3) {
        try {
            byteArrayOutputStream.write((byte) ((i3 >> 0) & 255));
            byteArrayOutputStream.write((byte) ((i3 >> 8) & 255));
            byteArrayOutputStream.write((byte) ((i3 >> 16) & 255));
            byteArrayOutputStream.write((byte) ((i3 >> 24) & 255));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static void h(byte[] bArr, int i3, int i16) {
        bArr[i3 + 0] = (byte) (i16 >> 0);
        bArr[i3 + 1] = (byte) (i16 >> 8);
        bArr[i3 + 2] = (byte) (i16 >> 16);
        bArr[i3 + 3] = (byte) (i16 >> 24);
    }
}
