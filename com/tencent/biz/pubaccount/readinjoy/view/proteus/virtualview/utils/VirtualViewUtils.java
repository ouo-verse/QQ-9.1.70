package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes4.dex */
public class VirtualViewUtils {
    private static RectF oval = new RectF();
    private static Path sPath = new Path();

    public static void clipCanvas(Canvas canvas, int i3, int i16, int i17, int i18) {
        clipCanvas(canvas, i3, i16, i17, i18, i18, i18, i18);
    }

    public static void drawBackground(Canvas canvas, Paint paint, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        int i28;
        int i29;
        int i36;
        int i37;
        if (canvas != null && paint != null) {
            float f16 = i17;
            float f17 = f16 / 2.0f;
            sPath.reset();
            Path path = sPath;
            int i38 = 0;
            if (i18 > 0) {
                i28 = i18;
            } else {
                i28 = 0;
            }
            path.moveTo(i28 + i17, f16);
            Path path2 = sPath;
            int i39 = i3 - i17;
            if (i19 > 0) {
                i29 = i19;
            } else {
                i29 = 0;
            }
            path2.lineTo(i39 - i29, f16);
            if (i19 > 0) {
                oval.set(i3 - r12, 0.0f, i3, i19 * 2);
                oval.offset(-f17, f17);
                sPath.arcTo(oval, 270.0f, 90.0f);
            }
            Path path3 = sPath;
            float f18 = i39;
            int i46 = i16 - i17;
            if (i27 > 0) {
                i36 = i27;
            } else {
                i36 = 0;
            }
            path3.lineTo(f18, i46 - i36);
            if (i27 > 0) {
                int i47 = i27 * 2;
                oval.set(i3 - i47, i16 - i47, i3, i16);
                float f19 = -f17;
                oval.offset(f19, f19);
                sPath.arcTo(oval, 0.0f, 90.0f);
            }
            Path path4 = sPath;
            if (i26 > 0) {
                i37 = i26;
            } else {
                i37 = 0;
            }
            path4.lineTo(i37 + i17, i46);
            if (i26 > 0) {
                oval.set(0.0f, i16 - r9, i26 * 2, i16);
                oval.offset(f17, -f17);
                sPath.arcTo(oval, 90.0f, 90.0f);
            }
            Path path5 = sPath;
            if (i18 > 0) {
                i38 = i18;
            }
            path5.lineTo(f16, i17 + i38);
            if (i18 > 0) {
                float f26 = i18 * 2;
                oval.set(0.0f, 0.0f, f26, f26);
                oval.offset(f17, f17);
                sPath.arcTo(oval, 180.0f, 90.0f);
            }
            canvas.drawPath(sPath, paint);
        }
    }

    public static void drawBorder(Canvas canvas, Paint paint, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        float f27;
        float f28;
        float f29;
        if (canvas != null && paint != null) {
            float f36 = i17 / 2.0f;
            if (i18 > 0) {
                f16 = i18;
            } else {
                f16 = 0.0f;
            }
            if (i26 > 0) {
                f17 = i16 - i26;
            } else {
                f17 = i16;
            }
            canvas.drawLine(f36, f16, f36, f17, paint);
            if (i18 > 0) {
                f18 = i18;
            } else {
                f18 = 0.0f;
            }
            if (i19 > 0) {
                f19 = i3 - i19;
            } else {
                f19 = i3;
            }
            canvas.drawLine(f18, f36, f19, f36, paint);
            float f37 = i3;
            float f38 = f37 - f36;
            if (i19 > 0) {
                f26 = i19;
            } else {
                f26 = 0.0f;
            }
            if (i27 > 0) {
                f27 = i16 - i27;
            } else {
                f27 = i16;
            }
            canvas.drawLine(f38, f26, f38, f27, paint);
            if (i26 > 0) {
                f28 = i26;
            } else {
                f28 = 0.0f;
            }
            float f39 = i16;
            float f46 = f39 - f36;
            if (i27 > 0) {
                f29 = i3 - i27;
            } else {
                f29 = f37;
            }
            canvas.drawLine(f28, f46, f29, f46, paint);
            if (i18 > 0) {
                float f47 = i18 * 2;
                oval.set(0.0f, 0.0f, f47, f47);
                oval.offset(f36, f36);
                canvas.drawArc(oval, 180.0f, 90.0f, false, paint);
            }
            if (i19 > 0) {
                oval.set(i3 - r3, 0.0f, f37, i19 * 2);
                oval.offset(-f36, f36);
                canvas.drawArc(oval, 270.0f, 90.0f, false, paint);
            }
            if (i27 > 0) {
                int i28 = i27 * 2;
                oval.set(i3 - i28, i16 - i28, f37, f39);
                float f48 = -f36;
                oval.offset(f48, f48);
                canvas.drawArc(oval, 0.0f, 90.0f, false, paint);
            }
            if (i26 > 0) {
                oval.set(0.0f, i16 - r2, i26 * 2, f39);
                oval.offset(f36, -f36);
                canvas.drawArc(oval, 90.0f, 90.0f, false, paint);
            }
        }
    }

    private static boolean isRounded(int i3, int i16, int i17, int i18) {
        if (i3 <= 0 && i16 <= 0 && i17 <= 0 && i18 <= 0) {
            return false;
        }
        return true;
    }

    public static void clipCanvas(Canvas canvas, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        if (canvas != null && isRounded(i18, i19, i26, i27)) {
            float f16 = i17;
            float f17 = f16 / 2.0f;
            sPath.reset();
            sPath.moveTo((i18 > 0 ? i18 : 0) + i17, f16);
            int i28 = i3 - i17;
            sPath.lineTo(i28 - (i19 > 0 ? i19 : 0), f16);
            if (i19 > 0) {
                oval.set(i3 - r11, 0.0f, i3, i19 * 2);
                oval.offset(-f17, f17);
                sPath.arcTo(oval, 270.0f, 90.0f);
            }
            int i29 = i16 - i17;
            sPath.lineTo(i28, i29 - (i27 > 0 ? i27 : 0));
            if (i27 > 0) {
                int i36 = i27 * 2;
                oval.set(i3 - i36, i16 - i36, i3, i16);
                float f18 = -f17;
                oval.offset(f18, f18);
                sPath.arcTo(oval, 0.0f, 90.0f);
            }
            sPath.lineTo((i26 > 0 ? i26 : 0) + i17, i29);
            if (i26 > 0) {
                oval.set(0.0f, i16 - r8, i26 * 2, i16);
                oval.offset(f17, -f17);
                sPath.arcTo(oval, 90.0f, 90.0f);
            }
            sPath.lineTo(f16, i17 + (i18 > 0 ? i18 : 0));
            if (i18 > 0) {
                float f19 = i18 * 2;
                oval.set(0.0f, 0.0f, f19, f19);
                oval.offset(f17, f17);
                sPath.arcTo(oval, 180.0f, 90.0f);
            }
            canvas.clipPath(sPath);
        }
    }
}
