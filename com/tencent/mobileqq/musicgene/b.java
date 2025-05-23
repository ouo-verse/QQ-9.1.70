package com.tencent.mobileqq.musicgene;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    private static void a(int[] iArr, int[] iArr2, int i3, int i16, float f16) {
        int i17 = i3 - 1;
        int i18 = (int) f16;
        int i19 = (i18 * 2) + 1;
        int i26 = i19 * 256;
        int[] iArr3 = new int[i26];
        int i27 = 0;
        for (int i28 = 0; i28 < i26; i28++) {
            iArr3[i28] = i28 / i19;
        }
        int i29 = 0;
        int i36 = 0;
        while (i29 < i16) {
            int i37 = i27;
            int i38 = i37;
            int i39 = i38;
            int i46 = i39;
            for (int i47 = -i18; i47 <= i18; i47++) {
                int i48 = iArr[e(i47, i27, i17) + i36];
                i37 += (i48 >> 24) & 255;
                i38 += (i48 >> 16) & 255;
                i39 += (i48 >> 8) & 255;
                i46 += i48 & 255;
            }
            int i49 = i29;
            int i56 = i27;
            while (i56 < i3) {
                iArr2[i49] = (iArr3[i37] << 24) | (iArr3[i38] << 16) | (iArr3[i39] << 8) | iArr3[i46];
                int i57 = i56 + i18 + 1;
                if (i57 > i17) {
                    i57 = i17;
                }
                int i58 = i56 - i18;
                if (i58 < 0) {
                    i58 = i27;
                }
                int i59 = iArr[i57 + i36];
                int i65 = iArr[i58 + i36];
                i37 += ((i59 >> 24) & 255) - ((i65 >> 24) & 255);
                i38 += ((i59 & ITVKAsset.VOD_ASSET_MASK_BIT) - (16711680 & i65)) >> 16;
                i39 += ((i59 & 65280) - (65280 & i65)) >> 8;
                i46 += (i59 & 255) - (i65 & 255);
                i49 += i16;
                i56++;
                i17 = i17;
                i27 = 0;
            }
            i36 += i3;
            i29++;
            i27 = 0;
        }
    }

    public static Bitmap b(Bitmap bitmap, int i3, int i16, int i17) {
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap d16 = d(bitmap, i3, i16, i17);
            if (d16 == null) {
                return null;
            }
            int width = (int) (d16.getWidth() * 0.03f);
            int height = (int) (d16.getHeight() * 0.03f);
            if (height > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(d16, width, height, d16.getWidth() - (width << 1), d16.getHeight() - (height << 1));
                if (!d16.isRecycled()) {
                    d16.recycle();
                }
                return createBitmap;
            }
            return d16;
        } catch (Exception e16) {
            QLog.e("BitmapAlgorithms", 1, e16.toString());
            return null;
        }
    }

    private static void c(int[] iArr, int[] iArr2, int i3, int i16, float f16) {
        int i17;
        float f17 = f16 - ((int) f16);
        float f18 = 1.0f / ((2.0f * f17) + 1.0f);
        char c16 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i18 < i16) {
            iArr2[i18] = iArr[c16];
            int i26 = i18 + i16;
            int i27 = 1;
            int i28 = 1;
            while (true) {
                i17 = i3 - 1;
                if (i28 < i17) {
                    int i29 = i19 + i28;
                    int i36 = iArr[i29 - 1];
                    int i37 = iArr[i29];
                    int i38 = iArr[i29 + i27];
                    int i39 = (i37 >> 24) & 255;
                    int i46 = (i37 >> 8) & 255;
                    iArr2[i26] = (((int) ((((i37 >> 16) & 255) + ((int) ((((i36 >> 16) & 255) + ((i38 >> 16) & 255)) * f17))) * f18)) << 16) | (((int) ((i39 + ((int) ((((i36 >> 24) & 255) + ((i38 >> 24) & 255)) * f17))) * f18)) << 24) | (((int) ((i46 + ((int) ((((i36 >> 8) & 255) + ((i38 >> 8) & 255)) * f17))) * f18)) << 8) | ((int) (((i37 & 255) + ((int) (((i36 & 255) + (i38 & 255)) * f17))) * f18));
                    i26 += i16;
                    i28++;
                    i18 = i18;
                    i19 = i19;
                    i27 = 1;
                }
            }
            iArr2[i26] = iArr[i17];
            i19 += i3;
            i18++;
            c16 = 0;
        }
    }

    public static Bitmap d(Bitmap bitmap, int i3, int i16, int i17) {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i18 = width * height;
            int[] iArr = new int[i18];
            int[] iArr2 = new int[i18];
            bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            for (int i19 = 0; i19 < i3; i19++) {
                a(iArr, iArr2, width, height, i16);
                a(iArr2, iArr, height, width, i17);
            }
            c(iArr, iArr2, width, height, i16);
            c(iArr2, iArr, height, width, i17);
            bitmap2.setPixels(iArr, 0, width, 0, 0, width, height);
        } catch (Error e16) {
            QLog.e("BitmapAlgorithms", 1, e16.toString());
        } catch (Exception e17) {
            QLog.e("BitmapAlgorithms", 1, e17.toString());
        } catch (OutOfMemoryError e18) {
            QLog.e("BitmapAlgorithms", 1, e18.toString());
        }
        return bitmap2;
    }

    private static int e(int i3, int i16, int i17) {
        if (i3 < i16) {
            return i16;
        }
        if (i3 > i17) {
            return i17;
        }
        return i3;
    }
}
