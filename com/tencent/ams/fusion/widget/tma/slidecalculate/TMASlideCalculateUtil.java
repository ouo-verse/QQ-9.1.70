package com.tencent.ams.fusion.widget.tma.slidecalculate;

import android.graphics.Point;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TMASlideCalculateUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SlideAdComponent";

    public TMASlideCalculateUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static double checkIsSpecialMove(Point point, Point point2, double d16) {
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

    public static boolean checkSlideValid(Point point, Point point2, SlideConfig slideConfig) {
        double degrees;
        double d16;
        if (point == null || point2 == null || slideConfig == null) {
            return false;
        }
        int i3 = point2.x;
        int i16 = point.x;
        int i17 = (i3 - i16) * (i3 - i16);
        int i18 = point2.y;
        int i19 = point.y;
        double sqrt = Math.sqrt(i17 + ((i18 - i19) * (i18 - i19)));
        Log.d(TAG, "distance:" + sqrt + " startPoint:" + point.x + "," + point.y + ";endPoint:" + point2.x + "," + point2.y + " config:" + slideConfig.toString());
        if (sqrt < slideConfig.getDistance()) {
            return false;
        }
        Point point3 = new Point(point.x, point.y);
        Point point4 = new Point(point2.x, point2.y);
        point4.x -= point3.x;
        point4.y = point3.y - point4.y;
        point3.x = 0;
        point3.y = 0;
        Log.d(TAG, "covert startPoint:" + point3.x + "," + point3.y + ";endPoint:" + point4.x + "," + point4.y);
        double checkIsSpecialMove = checkIsSpecialMove(point3, point4, -1.0d);
        if (checkIsSpecialMove == -1.0d) {
            double d17 = (point4.y - point3.y) / (point4.x - point3.x);
            int quadrant = getQuadrant(point3, point4);
            if (quadrant != 1) {
                if (quadrant != 2 && quadrant != 3) {
                    if (quadrant != 4) {
                        return false;
                    }
                    degrees = Math.toDegrees(Math.atan(d17));
                    d16 = 360.0d;
                } else {
                    degrees = Math.toDegrees(Math.atan(d17));
                    d16 = 180.0d;
                }
                checkIsSpecialMove = d16 + degrees;
            } else {
                checkIsSpecialMove = Math.toDegrees(Math.atan(d17));
            }
        }
        boolean checkValidArea = checkValidArea(checkIsSpecialMove, Integer.valueOf(slideConfig.getDegreeA()), Integer.valueOf(slideConfig.getDegreeB()));
        boolean checkValidArea2 = checkValidArea(checkIsSpecialMove, slideConfig.getDegreeC(), slideConfig.getDegreeD());
        Log.d(TAG, "isTouchInArea:" + checkValidArea + checkValidArea2);
        if (checkValidArea || checkValidArea2) {
            return true;
        }
        double min = Math.min(Math.abs(checkIsSpecialMove - slideConfig.getDegreeA()), Math.abs(checkIsSpecialMove - getOffset(r11, slideConfig.getDegreeB())));
        if (slideConfig.getDegreeC() != null && slideConfig.getDegreeD() != null) {
            min = Math.min(Math.min(min, Math.abs(checkIsSpecialMove - slideConfig.getDegreeC().intValue())), Math.abs(checkIsSpecialMove - getOffset(r3, slideConfig.getDegreeD().intValue())));
        }
        Log.d(TAG, "min:" + min);
        if (slideConfig.getDegreeN() < min) {
            return false;
        }
        double cos = Math.cos(Math.toRadians(min)) * sqrt;
        Log.d(TAG, "projectDistance:" + cos);
        if (Math.ceil(cos) <= slideConfig.getDistance()) {
            return false;
        }
        return true;
    }

    private static boolean checkValidArea(double d16, Integer num, Integer num2) {
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

    private static int getOffset(int i3, int i16) {
        if (i3 >= 0 && i16 >= 0) {
            int i17 = i3 + i16;
            if (i17 > 360) {
                return i17 % 360;
            }
            return i17;
        }
        return -1;
    }

    private static int getQuadrant(Point point, Point point2) {
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
