package com.tencent.ams.music.widget.slidecalculate;

import android.graphics.Point;
import android.util.Log;
import com.tencent.ams.fusion.widget.tma.slidecalculate.TMASlideCalculateUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;

    private static double a(Point point, Point point2, double d16) {
        int i3 = point2.x;
        int i16 = point.x;
        if (i3 == i16) {
            if (point2.y > point.y) {
                return 90.0d;
            }
            return 270.0d;
        }
        if (point2.y == point.y) {
            if (i3 > i16) {
                return 0.0d;
            }
            return 180.0d;
        }
        return d16;
    }

    public static boolean b(Point point, Point point2, a aVar) {
        double degrees;
        double d16;
        if (point == null || point2 == null || aVar == null) {
            return false;
        }
        int i3 = point2.x;
        int i16 = point.x;
        int i17 = (i3 - i16) * (i3 - i16);
        int i18 = point2.y;
        int i19 = point.y;
        double sqrt = Math.sqrt(i17 + ((i18 - i19) * (i18 - i19)));
        Log.d(TMASlideCalculateUtil.TAG, "distance:" + sqrt + " startPoint:" + point.x + "," + point.y + ";endPoint:" + point2.x + "," + point2.y + " config:" + aVar.toString());
        if (sqrt < aVar.f()) {
            return false;
        }
        Point point3 = new Point(point.x, point.y);
        Point point4 = new Point(point2.x, point2.y);
        point4.x -= point3.x;
        point4.y = point3.y - point4.y;
        point3.x = 0;
        point3.y = 0;
        Log.d(TMASlideCalculateUtil.TAG, "covert startPoint:" + point3.x + "," + point3.y + ";endPoint:" + point4.x + "," + point4.y);
        double a16 = a(point3, point4, -1.0d);
        if (a16 == -1.0d) {
            double d17 = (point4.y - point3.y) / (point4.x - point3.x);
            int e16 = e(point3, point4);
            if (e16 != 1) {
                if (e16 != 2 && e16 != 3) {
                    if (e16 != 4) {
                        return false;
                    }
                    degrees = Math.toDegrees(Math.atan(d17));
                    d16 = 360.0d;
                } else {
                    degrees = Math.toDegrees(Math.atan(d17));
                    d16 = 180.0d;
                }
                a16 = d16 + degrees;
            } else {
                a16 = Math.toDegrees(Math.atan(d17));
            }
        }
        boolean c16 = c(a16, Integer.valueOf(aVar.a()), Integer.valueOf(aVar.b()));
        boolean c17 = c(a16, aVar.c(), aVar.d());
        Log.d(TMASlideCalculateUtil.TAG, "isTouchInArea:" + c16 + c17);
        if (c16 || c17) {
            return true;
        }
        double min = Math.min(Math.abs(a16 - aVar.a()), Math.abs(a16 - d(r11, aVar.b())));
        if (aVar.c() != null && aVar.d() != null) {
            min = Math.min(Math.min(min, Math.abs(a16 - aVar.c().intValue())), Math.abs(a16 - d(r3, aVar.d().intValue())));
        }
        Log.d(TMASlideCalculateUtil.TAG, "min:" + min);
        if (aVar.e() < min) {
            return false;
        }
        double cos = Math.cos(Math.toRadians(min)) * sqrt;
        Log.d(TMASlideCalculateUtil.TAG, "projectDistance:" + cos);
        if (Math.ceil(cos) <= aVar.f()) {
            return false;
        }
        return true;
    }

    private static boolean c(double d16, Integer num, Integer num2) {
        if (num == null || num2 == null) {
            return false;
        }
        int intValue = num.intValue() + num2.intValue();
        if (intValue > 360) {
            int i3 = intValue % 360;
            if ((d16 < num.intValue() || d16 > 360.0d) && (d16 < 0.0d || d16 > i3)) {
                return false;
            }
        } else if (d16 < num.intValue() || d16 > intValue) {
            return false;
        }
        return true;
    }

    private static int d(int i3, int i16) {
        if (i3 >= 0 && i16 >= 0) {
            int i17 = i3 + i16;
            if (i17 > 360) {
                return i17 % 360;
            }
            return i17;
        }
        return -1;
    }

    private static int e(Point point, Point point2) {
        boolean z16;
        if (point != null && point2 != null) {
            boolean z17 = false;
            if (point2.x - point.x > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (point2.y - point.y > 0) {
                z17 = true;
            }
            if (z16 && z17) {
                return 1;
            }
            if (!z16 && z17) {
                return 2;
            }
            if (!z16) {
                return 3;
            }
            return 4;
        }
        return -1;
    }
}
