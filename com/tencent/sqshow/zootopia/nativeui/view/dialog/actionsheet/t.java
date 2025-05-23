package com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.EnumMap;

/* compiled from: P */
/* loaded from: classes34.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private static final int f371784a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f371785b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f371786c;

    private static Bitmap a(int i3) {
        try {
            return Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e16) {
            QLog.w("QRCodeUtil", 1, "createBitmap OOM: " + e16.getMessage());
            return null;
        }
    }

    private static void b(u uVar, int i3, Canvas canvas) {
        Bitmap b16 = uVar.b();
        if (b16 == null) {
            return;
        }
        try {
            int i16 = f371784a;
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b16, i16, i16, false);
            int c16 = uVar.c() / 2;
            int i17 = f371786c;
            canvas.drawBitmap(createScaledBitmap, c16 - i17, c16 - i17, (Paint) null);
        } catch (OutOfMemoryError e16) {
            QLog.w("QRCodeUtil", 1, "drawCenterLogoImage createScaledBitmap OOM: " + e16.getMessage());
        }
    }

    private static void d(BitMatrix bitMatrix, Canvas canvas, int i3, int i16, boolean z16) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i16);
        e(bitMatrix, canvas, i3, z16, paint);
        c(bitMatrix, canvas, i3, paint);
    }

    private static void e(BitMatrix bitMatrix, Canvas canvas, int i3, boolean z16, Paint paint) {
        int width = bitMatrix.getWidth();
        float f16 = (i3 - (f371785b * width)) / width;
        float f17 = f16 / 2.0f;
        int i16 = i3 / 2;
        int i17 = (f371784a * 4) / 5;
        for (int i18 = 0; i18 < width; i18++) {
            float f18 = f371785b * i18;
            float f19 = 0.0f;
            for (int i19 = 0; i19 < width; i19++) {
                f19 += f371785b;
                if (bitMatrix.get(i19, i18) && ((i18 > 6 || i19 > 6) && ((i18 > 6 || i19 < width - 7 || i19 > width - 1) && (i19 > 6 || i18 < width - 7 || i18 > width - 1)))) {
                    float f26 = (i19 * f16) + f17 + f19;
                    float f27 = (i18 * f16) + f17 + f18;
                    if (!z16 || !k(f17, i16, f26, f27)) {
                        canvas.drawCircle(f26, f27, f17, paint);
                    }
                }
            }
        }
    }

    public static BitMatrix f(String str, int i3) {
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        enumMap.put((EnumMap) EncodeHintType.ERROR_CORRECTION, (EncodeHintType) ErrorCorrectionLevel.L);
        String j3 = j(str);
        if (j3 != null) {
            enumMap.put((EnumMap) EncodeHintType.CHARACTER_SET, (EncodeHintType) j3);
        }
        if (i3 != -1) {
            enumMap.put((EnumMap) EncodeHintType.QRCODE_VERSION, (EncodeHintType) Integer.valueOf(m(i3)));
        }
        enumMap.put((EnumMap) EncodeHintType.MARGIN, (EncodeHintType) 0);
        try {
            return new QRCodeWriter().encode(str, 0, 0, enumMap);
        } catch (Throwable th5) {
            QLog.e("QRCodeUtil", 1, "encodeUrl2Matrix encode error:" + th5.getMessage());
            return null;
        }
    }

    private static Bitmap h(Context context, BitMatrix bitMatrix, u uVar) {
        int c16 = uVar.c();
        int a16 = uVar.a();
        Bitmap a17 = a(c16);
        if (a17 == null) {
            QLog.d("QRCodeUtil", 1, "getQrCode() myCode == null!");
            return a17;
        }
        Canvas canvas = new Canvas(a17);
        d(bitMatrix, canvas, c16, a16, uVar.b() != null);
        canvas.drawBitmap(a17, (Rect) null, new Rect(0, 0, c16, c16), (Paint) null);
        b(uVar, bitMatrix.getWidth(), canvas);
        return a17;
    }

    public static Bitmap i(Context context, u uVar) {
        if (QLog.isColorLevel()) {
            QLog.i("QRCodeUtil", 1, "getQrCodeImg context: " + context + ", params: " + uVar);
        }
        if (l(context, uVar)) {
            QLog.w("QRCodeUtil", 1, "getQrCodeImg context: " + context + ", params: " + uVar);
            return null;
        }
        BitMatrix g16 = g(uVar.d());
        if (g16 == null) {
            QLog.e("QRCodeUtil", 1, "getQrCodeImg matrix is null!");
            return null;
        }
        return h(context, g16, uVar);
    }

    private static boolean k(float f16, int i3, float f17, float f18) {
        int i16 = f371786c;
        int i17 = i3 - i16;
        float f19 = i17;
        float f26 = i3 + i16;
        return (((f17 + f16) > f19 ? 1 : ((f17 + f16) == f19 ? 0 : -1)) > 0) && (((f18 + f16) > f19 ? 1 : ((f18 + f16) == f19 ? 0 : -1)) > 0) && (((f17 - f16) > f26 ? 1 : ((f17 - f16) == f26 ? 0 : -1)) < 0) && (((f18 - f16) > f26 ? 1 : ((f18 - f16) == f26 ? 0 : -1)) < 0);
    }

    public static BitMatrix g(String str) {
        return f(str, -1);
    }

    private static String j(CharSequence charSequence) {
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (charSequence.charAt(i3) > '\u00ff') {
                return "UTF-8";
            }
        }
        return null;
    }

    static {
        int dip2px = ViewUtils.dip2px(40.0f);
        f371784a = dip2px;
        f371785b = ViewUtils.dip2px(1.5f);
        f371786c = dip2px / 2;
    }

    private static boolean l(Context context, u uVar) {
        return uVar == null || uVar.e() || context == null;
    }

    private static void c(BitMatrix bitMatrix, Canvas canvas, int i3, Paint paint) {
        float width = ((i3 / bitMatrix.getWidth()) * 7.0f) / 2.0f;
        int i16 = 0;
        float f16 = i3 - width;
        float[] fArr = {width, width, f16, width, width, f16};
        int i17 = (int) ((5.0f * width) / 7.0f);
        int i18 = (int) ((3.0f * width) / 7.0f);
        int alpha = paint.getAlpha();
        int color = paint.getColor();
        Xfermode xfermode = paint.getXfermode();
        int i19 = 0;
        while (i19 < 3) {
            int i26 = i19 * 2;
            float f17 = fArr[i26];
            float f18 = fArr[i26 + 1];
            paint.setColor(color);
            canvas.drawCircle(f17, f18, width, paint);
            paint.setAlpha(i16);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawCircle(f17, f18, i17, paint);
            paint.setColor(color);
            paint.setAlpha(alpha);
            paint.setXfermode(xfermode);
            canvas.drawCircle(f17, f18, i18, paint);
            i19++;
            i16 = 0;
        }
    }

    private static int m(int i3) {
        if (i3 < 21) {
            return 1;
        }
        if (i3 > 177) {
            return 39;
        }
        return ((i3 - 21) / 4) + 1;
    }
}
