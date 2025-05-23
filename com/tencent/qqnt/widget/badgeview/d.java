package com.tencent.qqnt.widget.badgeview;

import android.graphics.PointF;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static Float a(float f16, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + (f16 * (number2.floatValue() - floatValue)));
    }

    public static void b(PointF pointF, float f16, Double d16, List<PointF> list) {
        float f17;
        if (d16 != null) {
            double atan = (float) Math.atan(d16.doubleValue());
            double d17 = f16;
            float cos = (float) (Math.cos(atan) * d17);
            f17 = (float) (Math.sin(atan) * d17);
            f16 = cos;
        } else {
            f17 = 0.0f;
        }
        list.add(new PointF(pointF.x + f16, pointF.y + f17));
        list.add(new PointF(pointF.x - f16, pointF.y - f17));
    }

    public static PointF c(PointF pointF, PointF pointF2, float f16) {
        return new PointF(a(f16, Float.valueOf(pointF.x), Float.valueOf(pointF2.x)).floatValue(), a(f16, Float.valueOf(pointF.y), Float.valueOf(pointF2.y)).floatValue());
    }

    public static float d(PointF pointF, PointF pointF2) {
        return (float) Math.sqrt(Math.pow(pointF.x - pointF2.x, 2.0d) + Math.pow(pointF.y - pointF2.y, 2.0d));
    }

    public static int e(PointF pointF, PointF pointF2) {
        float f16 = pointF.x;
        float f17 = pointF2.x;
        if (f16 > f17) {
            float f18 = pointF.y;
            float f19 = pointF2.y;
            if (f18 > f19) {
                return 4;
            }
            if (f18 < f19) {
                return 1;
            }
            return -1;
        }
        if (f16 < f17) {
            float f26 = pointF.y;
            float f27 = pointF2.y;
            if (f26 > f27) {
                return 3;
            }
            if (f26 < f27) {
                return 2;
            }
            return -1;
        }
        return -1;
    }

    public static double f(double d16, int i3) {
        if (d16 < 0.0d) {
            d16 += 1.5707963267948966d;
        }
        return d16 + ((i3 - 1) * 1.5707963267948966d);
    }

    public static double g(double d16) {
        return (d16 / 6.283185307179586d) * 360.0d;
    }
}
