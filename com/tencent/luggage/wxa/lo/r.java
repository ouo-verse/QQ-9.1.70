package com.tencent.luggage.wxa.lo;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.view.WindowManager;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f133762a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f133763b = false;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f133764c;

    public static void a(Paint paint) {
        if (paint == null) {
            return;
        }
        if (f133762a) {
            paint.setFakeBoldText(true);
        } else {
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeWidth(0.8f);
        }
    }

    public static boolean b() {
        return f133763b;
    }

    public static boolean c() {
        if (f133764c == null) {
            String str = Build.MANUFACTURER;
            f133764c = Boolean.valueOf(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("xiaomi"));
        }
        return f133764c.booleanValue();
    }

    public static boolean d() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING);
    }

    public static void b(Path path, float f16, float f17, float f18, float f19, float f26, float f27) {
        float f28;
        float f29;
        float min = Math.min(f16, f18);
        float min2 = Math.min((f17 + 1.0f) * min, f18);
        float f36 = f18 / 2.0f;
        if (f16 <= f36) {
            f28 = (1.0f - f17) * 90.0f;
            f29 = f17 * 45.0f;
        } else {
            float f37 = 1.0f - ((min - f36) / f36);
            f28 = (1.0f - (f17 * f37)) * 90.0f;
            f29 = f37 * f17 * 45.0f;
        }
        float f38 = (90.0f - f28) / 2.0f;
        double d16 = min;
        float tan = (float) (Math.tan((f38 / 2.0f) * f19) * d16);
        float sin = (float) (Math.sin((f28 / 2.0f) * f19) * d16 * Math.sqrt(2.0d));
        double d17 = f29 * f19;
        float cos = (float) (tan * Math.cos(d17));
        float tan2 = (float) (cos * Math.tan(d17));
        float f39 = (((min2 - sin) - cos) - tan2) / 3.0f;
        path.lineTo(f26, Math.max(f27 / 2.0f, f27 - min2));
        float f46 = min2 - (f39 * 2.0f);
        float f47 = f46 - f39;
        path.cubicTo(f26, f27 - f46, f26, f27 - f47, f26 - tan2, f27 - (f47 - cos));
        float f48 = min * 2.0f;
        path.arcTo(new RectF(f26 - f48, f27 - f48, f26, f27), f38 + 0.0f, 90.0f - (f38 * 2.0f), false);
        path.cubicTo(f26 - f47, f27, f26 - f46, f27, Math.max(f26 / 2.0f, f26 - min2), f27);
    }

    public static void d(Path path, float f16, float f17, float f18, float f19, float f26, float f27) {
        float f28;
        float f29;
        float min = Math.min(f16, f18);
        float min2 = Math.min((f17 + 1.0f) * min, f18);
        float f36 = f18 / 2.0f;
        if (f16 <= f36) {
            f28 = (1.0f - f17) * 90.0f;
            f29 = f17 * 45.0f;
        } else {
            float f37 = 1.0f - ((min - f36) / f36);
            f28 = (1.0f - (f17 * f37)) * 90.0f;
            f29 = f37 * f17 * 45.0f;
        }
        float f38 = (90.0f - f28) / 2.0f;
        double d16 = min;
        float tan = (float) (Math.tan((f38 / 2.0f) * f19) * d16);
        float sin = (float) (Math.sin((f28 / 2.0f) * f19) * d16 * Math.sqrt(2.0d));
        double d17 = f29 * f19;
        float cos = (float) (tan * Math.cos(d17));
        float tan2 = (float) (cos * Math.tan(d17));
        float f39 = (((min2 - sin) - cos) - tan2) / 3.0f;
        path.moveTo(Math.max(f26 / 2.0f, f26 - min2), 0.0f);
        float f46 = min2 - (f39 * 2.0f);
        float f47 = f46 - f39;
        path.cubicTo(f26 - f46, 0.0f, f26 - f47, 0.0f, f26 - (f47 - cos), tan2);
        float f48 = min * 2.0f;
        path.arcTo(new RectF(f26 - f48, 0.0f, f26, f48), f38 + 270.0f, 90.0f - (f38 * 2.0f), false);
        path.cubicTo(f26, f47, f26, f46, f26, Math.min(f27 / 2.0f, min2));
    }

    public static Point a(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealSize(point);
        return point;
    }

    public static void c(Path path, float f16, float f17, float f18, float f19, float f26, float f27) {
        float f28;
        float f29;
        float min = Math.min(f16, f18);
        float min2 = Math.min((f17 + 1.0f) * min, f18);
        float f36 = f18 / 2.0f;
        if (f16 <= f36) {
            f28 = (1.0f - f17) * 90.0f;
            f29 = f17 * 45.0f;
        } else {
            float f37 = 1.0f - ((min - f36) / f36);
            f28 = (1.0f - (f17 * f37)) * 90.0f;
            f29 = f37 * f17 * 45.0f;
        }
        float f38 = (90.0f - f28) / 2.0f;
        double d16 = min;
        float tan = (float) (Math.tan((f38 / 2.0f) * f19) * d16);
        float sin = (float) (Math.sin((f28 / 2.0f) * f19) * d16 * Math.sqrt(2.0d));
        double d17 = f29 * f19;
        float cos = (float) (tan * Math.cos(d17));
        float tan2 = (float) (cos * Math.tan(d17));
        float f39 = (((min2 - sin) - cos) - tan2) / 3.0f;
        path.lineTo(0.0f, Math.min(f27 / 2.0f, min2));
        float f46 = min2 - (f39 * 2.0f);
        float f47 = f46 - f39;
        path.cubicTo(0.0f, f46, 0.0f, f47, tan2, f47 - cos);
        float f48 = min * 2.0f;
        path.arcTo(new RectF(0.0f, 0.0f, f48, f48), f38 + 180.0f, 90.0f - (f38 * 2.0f), false);
        float f49 = f26 / 2.0f;
        path.cubicTo(f47, 0.0f, f46, 0.0f, Math.min(f49, min2), 0.0f);
        path.lineTo(Math.max(f49, f26 - min2), 0.0f);
    }

    public static int a(String str, int i3) {
        if (str == null) {
            return i3;
        }
        try {
            return str.length() <= 0 ? i3 : Integer.decode(str).intValue();
        } catch (NumberFormatException e16) {
            n.a("WeUIUtil", e16, "", new Object[0]);
            return i3;
        }
    }

    public static boolean a() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.equalsIgnoreCase("blackshark");
    }

    public static Path a(RectF rectF, float f16, float f17, float f18, float f19, float f26) {
        Path path = new Path();
        if (f16 < 0.0f) {
            f16 = 0.0f;
        }
        float f27 = f17 < 0.0f ? 0.0f : f17;
        if (f19 < 0.0f) {
            f19 = 0.0f;
        }
        if (f18 < 0.0f) {
            f18 = 0.0f;
        }
        float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
        float width = rectF.width();
        float height = rectF.height();
        d(path, f27, f26, min, 0.017453292f, width, height);
        b(path, f18, f26, min, 0.017453292f, width, height);
        a(path, f19, f26, min, 0.017453292f, width, height);
        c(path, f16, f26, min, 0.017453292f, width, height);
        path.close();
        return path;
    }

    public static void a(Path path, float f16, float f17, float f18, float f19, float f26, float f27) {
        float f28;
        float f29;
        float min = Math.min(f16, f18);
        float min2 = Math.min((f17 + 1.0f) * min, f18);
        float f36 = f18 / 2.0f;
        if (f16 <= f36) {
            f28 = (1.0f - f17) * 90.0f;
            f29 = f17 * 45.0f;
        } else {
            float f37 = 1.0f - ((min - f36) / f36);
            f28 = (1.0f - (f17 * f37)) * 90.0f;
            f29 = f37 * f17 * 45.0f;
        }
        float f38 = (90.0f - f28) / 2.0f;
        double d16 = min;
        float tan = (float) (Math.tan((f38 / 2.0f) * f19) * d16);
        float sin = (float) (Math.sin((f28 / 2.0f) * f19) * d16 * Math.sqrt(2.0d));
        double d17 = f29 * f19;
        float cos = (float) (tan * Math.cos(d17));
        float tan2 = (float) (cos * Math.tan(d17));
        float f39 = (((min2 - sin) - cos) - tan2) / 3.0f;
        path.lineTo(Math.min(f26 / 2.0f, min2), f27);
        float f46 = min2 - (f39 * 2.0f);
        float f47 = f46 - f39;
        path.cubicTo(f46, f27, f47, f27, f47 - cos, f27 - tan2);
        float f48 = min * 2.0f;
        path.arcTo(new RectF(0.0f, f27 - f48, f48, f27), f38 + 90.0f, 90.0f - (f38 * 2.0f), false);
        path.cubicTo(0.0f, f27 - f47, 0.0f, f27 - f46, 0.0f, Math.max(f27 / 2.0f, f27 - min2));
    }
}
