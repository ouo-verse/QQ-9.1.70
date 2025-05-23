package com.tenpay.sdk.util;

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
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import java.util.EnumMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class QRCodeUtils {
    private static final String TAG = "QRCodeUtils";

    private static void drawLogo(int i3, Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            return;
        }
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        float f16 = i3 * 0.1f;
        float f17 = i3 / 2;
        int i16 = (int) (f17 - f16);
        int i17 = (int) (f17 + f16);
        canvas.drawBitmap(bitmap2, (Rect) null, new Rect(i16, i16, i17, i17), paint);
        QwLog.i("gen qrcode append logo over...");
    }

    public static BitMatrix encode(String str, int i3) {
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        enumMap.put((EnumMap) EncodeHintType.ERROR_CORRECTION, (EncodeHintType) ErrorCorrectionLevel.L);
        String guessAppropriateEncoding = guessAppropriateEncoding(str);
        if (guessAppropriateEncoding != null) {
            enumMap.put((EnumMap) EncodeHintType.CHARACTER_SET, (EncodeHintType) guessAppropriateEncoding);
        }
        if (i3 != -1) {
            enumMap.put((EnumMap) EncodeHintType.QRCODE_VERSION, (EncodeHintType) Integer.valueOf(numberToVersion(i3)));
        }
        enumMap.put((EnumMap) EncodeHintType.MARGIN, (EncodeHintType) 0);
        try {
            return new QRCodeWriter().encode(str, 0, 0, enumMap);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "encode error:" + th5.getMessage());
            return null;
        }
    }

    private static Bitmap genBMByMatrix(BitMatrix bitMatrix, int i3, int i16) throws WriterException {
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

    private static Bitmap genQrCode(String str, int i3, int i16, int i17, int i18) throws WriterException {
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        enumMap.put((EnumMap) EncodeHintType.ERROR_CORRECTION, (EncodeHintType) ErrorCorrectionLevel.M);
        String guessAppropriateEncoding = guessAppropriateEncoding(str);
        if (!TextUtils.isEmpty(guessAppropriateEncoding)) {
            enumMap.put((EnumMap) EncodeHintType.CHARACTER_SET, (EncodeHintType) guessAppropriateEncoding);
        }
        enumMap.put((EnumMap) EncodeHintType.MARGIN, (EncodeHintType) 0);
        try {
            return genBMByMatrix(new QRCodeWriter().encode(str, i3, i16, enumMap), i17, i18);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Bitmap getQRCode(String str, Bitmap bitmap, int i3, int i16, int i17) {
        QwLog.i("shareLink = " + str);
        try {
            Bitmap genQrCode = genQrCode(str, i3, i3, i16, i17);
            QwLog.i("gen qrcode over...");
            if (bitmap != null) {
                drawLogo(i3, genQrCode, bitmap);
                QwLog.i("drawLogo over...");
            }
            return genQrCode;
        } catch (Exception e16) {
            QwLog.e("get getQRCode error" + e16.getMessage());
            return null;
        }
    }

    private static String guessAppropriateEncoding(CharSequence charSequence) {
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (charSequence.charAt(i3) > '\u00ff') {
                return "UTF-8";
            }
        }
        return null;
    }

    protected static int numberToVersion(int i3) {
        if (i3 < 21) {
            return 1;
        }
        if (i3 > 177) {
            return 39;
        }
        return ((i3 - 21) / 4) + 1;
    }
}
