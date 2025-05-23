package com.tencent.biz.qqcircle.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.EnumMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class ca {
    private static void a(int i3, Bitmap bitmap, int i16, Bitmap bitmap2) {
        if (bitmap == null) {
            return;
        }
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        float f16 = i16;
        float f17 = i3 / 2;
        int i17 = (int) (f17 - f16);
        int i18 = (int) (f17 + f16);
        canvas.drawBitmap(bitmap2, (Rect) null, new Rect(i17, i17, i18, i18), paint);
    }

    private static Bitmap b(BitMatrix bitMatrix, int i3, int i16) throws WriterException {
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        int[] iArr = new int[width * height];
        for (int i17 = 0; i17 < height; i17++) {
            int i18 = i17 * width;
            for (int i19 = 0; i19 < width; i19++) {
                int i26 = i18 + i19;
                int i27 = -1;
                if (bitMatrix.get(i19, i17)) {
                    if (i3 == -1) {
                        i27 = -16777216;
                    } else {
                        i27 = i3;
                    }
                } else if (i16 != -1) {
                    i27 = i16;
                }
                iArr[i26] = i27;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    private static Bitmap c(String str, int i3, int i16, int i17, int i18) throws WriterException {
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        enumMap.put((EnumMap) EncodeHintType.ERROR_CORRECTION, (EncodeHintType) ErrorCorrectionLevel.M);
        String e16 = e(str);
        if (!TextUtils.isEmpty(e16)) {
            enumMap.put((EnumMap) EncodeHintType.CHARACTER_SET, (EncodeHintType) e16);
        }
        enumMap.put((EnumMap) EncodeHintType.MARGIN, (EncodeHintType) 0);
        try {
            return b(new QRCodeWriter().encode(str, i3, i16, enumMap), i17, i18);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Bitmap d(String str, Bitmap bitmap, int i3, int i16, int i17, int i18) {
        try {
            Bitmap c16 = c(str, i3, i3, i17, i18);
            if (bitmap != null) {
                a(i3, c16, i16, bitmap);
            }
            return c16;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String e(CharSequence charSequence) {
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (charSequence.charAt(i3) > '\u00ff') {
                return "UTF-8";
            }
        }
        return null;
    }
}
