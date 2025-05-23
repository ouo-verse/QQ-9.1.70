package com.tencent.mobileqq.onlinestatus.shareposter;

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
/* loaded from: classes16.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static final int f256271a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f256272b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f256273c;

    static {
        int dip2px = ViewUtils.dip2px(46.0f);
        f256271a = dip2px;
        f256272b = ViewUtils.dip2px(1.5f);
        f256273c = dip2px / 2;
    }

    private static Bitmap a(int i3) {
        try {
            return Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e16) {
            QLog.w("QRCodeUtil", 1, "createBitmap OOM: " + e16.getMessage());
            return null;
        }
    }

    private static void b(j jVar, int i3, Canvas canvas) {
        Bitmap b16 = jVar.b();
        if (b16 == null) {
            return;
        }
        try {
            int i16 = f256271a;
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b16, i16, i16, false);
            int c16 = jVar.c() / 2;
            int i17 = f256273c;
            canvas.drawBitmap(createScaledBitmap, c16 - i17, c16 - i17, (Paint) null);
        } catch (OutOfMemoryError e16) {
            QLog.w("QRCodeUtil", 1, "drawCenterLogoImage createScaledBitmap OOM: " + e16.getMessage());
        }
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

    private static void d(BitMatrix bitMatrix, Canvas canvas, int i3, int i16, boolean z16) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i16);
        e(bitMatrix, canvas, i3, z16, paint);
        c(bitMatrix, canvas, i3, paint);
    }

    private static void e(BitMatrix bitMatrix, Canvas canvas, int i3, boolean z16, Paint paint) {
        int width = bitMatrix.getWidth();
        float f16 = (i3 - (f256272b * width)) / width;
        float f17 = f16 / 2.0f;
        int i16 = i3 / 2;
        float f18 = ((f256271a * 4) / 5) + i16;
        for (int i17 = 0; i17 < width; i17++) {
            float f19 = f256272b * i17;
            float f26 = 0.0f;
            for (int i18 = 0; i18 < width; i18++) {
                f26 += f256272b;
                if (bitMatrix.get(i18, i17) && ((i17 > 6 || i18 > 6) && ((i17 > 6 || i18 < width - 7 || i18 > width - 1) && (i18 > 6 || i17 < width - 7 || i17 > width - 1)))) {
                    float f27 = (i18 * f16) + f17 + f26;
                    float f28 = (i17 * f16) + f17 + f19;
                    if (!z16 || !k(f17, i16, f27, f28)) {
                        float f29 = i16;
                        if (f27 <= f29 || f28 <= f29 || m(f27 + f17, f28 + f17, f29, f29, f18)) {
                            canvas.drawCircle(f27, f28, f17, paint);
                        }
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
            enumMap.put((EnumMap) EncodeHintType.QRCODE_VERSION, (EncodeHintType) Integer.valueOf(n(i3)));
        }
        enumMap.put((EnumMap) EncodeHintType.MARGIN, (EncodeHintType) 0);
        try {
            return new QRCodeWriter().encode(str, 0, 0, enumMap);
        } catch (Throwable th5) {
            QLog.e("QRCodeUtil", 1, "encodeUrl2Matrix encode error:" + th5.getMessage());
            return null;
        }
    }

    public static BitMatrix g(String str) {
        return f(str, -1);
    }

    private static Bitmap h(Context context, BitMatrix bitMatrix, j jVar) {
        int c16 = jVar.c();
        int a16 = jVar.a();
        Bitmap a17 = a(c16);
        boolean z16 = true;
        if (a17 == null) {
            QLog.d("QRCodeUtil", 1, "getQrCode() myCode == null!");
            return a17;
        }
        Canvas canvas = new Canvas(a17);
        if (jVar.b() == null) {
            z16 = false;
        }
        d(bitMatrix, canvas, c16, a16, z16);
        canvas.drawBitmap(a17, (Rect) null, new Rect(0, 0, c16, c16), (Paint) null);
        b(jVar, bitMatrix.getWidth(), canvas);
        return a17;
    }

    public static Bitmap i(Context context, j jVar) {
        if (QLog.isColorLevel()) {
            QLog.i("QRCodeUtil", 1, "getQrCodeImg context: " + context + ", params: " + jVar);
        }
        if (l(context, jVar)) {
            QLog.w("QRCodeUtil", 1, "getQrCodeImg context: " + context + ", params: " + jVar);
            return null;
        }
        BitMatrix g16 = g(jVar.d());
        if (g16 == null) {
            QLog.e("QRCodeUtil", 1, "getQrCodeImg matrix is null!");
            return null;
        }
        return h(context, g16, jVar);
    }

    private static String j(CharSequence charSequence) {
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (charSequence.charAt(i3) > '\u00ff') {
                return "UTF-8";
            }
        }
        return null;
    }

    private static boolean k(float f16, int i3, float f17, float f18) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int i16 = f256273c;
        int i17 = i3 - i16;
        int i18 = i3 + i16;
        float f19 = i17;
        if (f17 + f16 > f19) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (f18 + f16 > f19) {
            z17 = true;
        } else {
            z17 = false;
        }
        float f26 = i18;
        if (f18 - f16 < f26) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (f17 - f16 < f26) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z16 && z17 && z19 && z18) {
            return true;
        }
        return false;
    }

    private static boolean l(Context context, j jVar) {
        if (jVar != null && !jVar.e() && context != null) {
            return false;
        }
        return true;
    }

    private static boolean m(float f16, float f17, float f18, float f19, float f26) {
        if (Math.pow(f16 - f18, 2.0d) + Math.pow(f17 - f19, 2.0d) <= Math.pow(f26, 2.0d)) {
            return true;
        }
        return false;
    }

    private static int n(int i3) {
        if (i3 < 21) {
            return 1;
        }
        if (i3 > 177) {
            return 39;
        }
        return ((i3 - 21) / 4) + 1;
    }
}
