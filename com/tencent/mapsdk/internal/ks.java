package com.tencent.mapsdk.internal;

import android.graphics.Point;
import android.location.Location;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ks {

    /* renamed from: a, reason: collision with root package name */
    public static final int f149069a = 256;

    /* renamed from: b, reason: collision with root package name */
    public static final int f149070b = 20;

    /* renamed from: c, reason: collision with root package name */
    public static final double f149071c = 4.272282972352698E7d;

    /* renamed from: d, reason: collision with root package name */
    private static final int f149072d = 20037508;

    /* renamed from: e, reason: collision with root package name */
    private static final int f149073e = 30240971;

    /* renamed from: f, reason: collision with root package name */
    private static final double f149074f = 111319.49077777778d;

    /* renamed from: g, reason: collision with root package name */
    private static final double f149075g = 0.017453292519943295d;

    /* renamed from: h, reason: collision with root package name */
    private static final double f149076h = 0.008726646259971648d;

    /* renamed from: i, reason: collision with root package name */
    private static final double f149077i = 114.59155902616465d;

    private static int a(double d16) {
        return (int) ((d16 * f149074f) + 2.0037508E7d);
    }

    private static int b(int i3) {
        return i3 + f149073e;
    }

    private static double c(double d16) {
        return (d16 * 3.141592653589793d) / 180.0d;
    }

    private static int d(int i3) {
        return i3 - f149073e;
    }

    private static double e(int i3) {
        return (i3 - f149072d) / f149074f;
    }

    private static double f(int i3) {
        return (Math.atan(Math.exp(((i3 - f149073e) / f149074f) * 0.017453292519943295d)) * f149077i) - 90.0d;
    }

    private static int a(int i3) {
        return i3 + f149072d;
    }

    private static int b(double d16) {
        return (int) (((Math.log(Math.tan((d16 + 90.0d) * f149076h)) / 0.017453292519943295d) * f149074f) + 3.0240971E7d);
    }

    private static int c(int i3) {
        return i3 - f149072d;
    }

    private static Point d(GeoPoint geoPoint) {
        if (geoPoint != null) {
            double longitudeE6 = geoPoint.getLongitudeE6() / 1000000.0d;
            double log = Math.log(Math.tan(((geoPoint.getLatitudeE6() / 1000000.0d) + 90.0d) * f149076h)) / 0.01745329238474369d;
            Point point = new Point();
            point.x = (int) (((longitudeE6 + 180.0d) / 360.0d) * 2.68435456E8d);
            point.y = (int) (((180.0d - log) / 360.0d) * 2.68435456E8d);
            return point;
        }
        throw new IllegalArgumentException("point is null");
    }

    private static float a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (geoPoint != null && geoPoint2 != null) {
            return (float) a(geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d, geoPoint2.getLatitudeE6() / 1000000.0d, geoPoint2.getLongitudeE6() / 1000000.0d);
        }
        throw new IllegalArgumentException("point is null");
    }

    private static void b(double d16, double d17, double d18, double d19, float[] fArr) {
        double d26;
        double d27;
        double d28 = (0.017453292519943295d * d19) - (d17 * 0.017453292519943295d);
        double atan = Math.atan(Math.tan(d16 * 0.017453292519943295d) * 0.996647189328169d);
        double atan2 = Math.atan(Math.tan(d18 * 0.017453292519943295d) * 0.996647189328169d);
        double cos = Math.cos(atan);
        double cos2 = Math.cos(atan2);
        double sin = Math.sin(atan);
        double sin2 = Math.sin(atan2);
        double d29 = cos * cos2;
        double d36 = sin * sin2;
        double d37 = d28;
        int i3 = 0;
        double d38 = 0.0d;
        double d39 = 0.0d;
        double d46 = 0.0d;
        double d47 = 0.0d;
        double d48 = 0.0d;
        while (true) {
            if (i3 >= 20) {
                d26 = sin;
                d27 = sin2;
                break;
            }
            d38 = Math.cos(d37);
            d39 = Math.sin(d37);
            double d49 = cos2 * d39;
            double d56 = (cos * sin2) - ((sin * cos2) * d38);
            d26 = sin;
            double sqrt = Math.sqrt((d49 * d49) + (d56 * d56));
            d27 = sin2;
            double d57 = d36 + (d29 * d38);
            d47 = Math.atan2(sqrt, d57);
            double d58 = sqrt == 0.0d ? 0.0d : (d29 * d39) / sqrt;
            double d59 = 1.0d - (d58 * d58);
            double d65 = d59 == 0.0d ? 0.0d : d57 - ((d36 * 2.0d) / d59);
            double d66 = 0.006739496756586903d * d59;
            double d67 = ((d66 / 16384.0d) * (((((320.0d - (175.0d * d66)) * d66) - 768.0d) * d66) + 4096.0d)) + 1.0d;
            double d68 = (d66 / 1024.0d) * ((d66 * (((74.0d - (47.0d * d66)) * d66) - 128.0d)) + 256.0d);
            double d69 = 2.0955066698943685E-4d * d59 * (((4.0d - (d59 * 3.0d)) * 0.0033528106718309896d) + 4.0d);
            double d75 = d65 * d65;
            double d76 = d68 * sqrt * (d65 + ((d68 / 4.0d) * ((((d75 * 2.0d) - 1.0d) * d57) - ((((d68 / 6.0d) * d65) * (((sqrt * 4.0d) * sqrt) - 3.0d)) * ((d75 * 4.0d) - 3.0d)))));
            double d77 = d28 + ((1.0d - d69) * 0.0033528106718309896d * d58 * (d47 + (sqrt * d69 * (d65 + (d69 * d57 * (((2.0d * d65) * d65) - 1.0d))))));
            if (Math.abs((d77 - d37) / d77) < 1.0E-12d) {
                d48 = d76;
                d46 = d67;
                break;
            }
            i3++;
            sin = d26;
            sin2 = d27;
            d48 = d76;
            d37 = d77;
            d46 = d67;
        }
        fArr[0] = (float) (d46 * 6356752.3142d * (d47 - d48));
        if (fArr.length > 1) {
            double d78 = d27 * cos;
            double d79 = d26;
            fArr[1] = (float) (((float) Math.atan2(cos2 * d39, d78 - ((d79 * cos2) * d38))) * 57.29577951308232d);
            if (fArr.length > 2) {
                fArr[2] = (float) (((float) Math.atan2(cos * d39, ((-d79) * cos2) + (d78 * d38))) * 57.29577951308232d);
            }
        }
    }

    private static Point c(GeoPoint geoPoint) {
        if (geoPoint != null) {
            return new Point(a(geoPoint.getLongitudeE6() / 1000000.0d) - f149072d, b(geoPoint.getLatitudeE6() / 1000000.0d) - f149073e);
        }
        throw new IllegalArgumentException("point is null");
    }

    private static Point c(int i3, int i16) {
        return new Point(a(i3 / 1000000.0d) - f149072d, b(i16 / 1000000.0d) - f149073e);
    }

    private static void a(double d16, double d17, double d18, double d19, float[] fArr) {
        Location.distanceBetween(d16, d17, d18, d19, fArr);
        fArr[0] = (float) a(d16, d17, d18, d19);
    }

    private static GeoPoint d(int i3, int i16) {
        return new GeoPoint((int) (Math.toDegrees((Math.atan(Math.exp(3.141592653589793d - (i16 / 4.272282972352698E7d))) - 0.7853981633974483d) * 2.0d) * 1000000.0d), (int) (Math.toDegrees((i3 / 4.272282972352698E7d) - 3.141592653589793d) * 1000000.0d));
    }

    private static double a(double d16, double d17, double d18, double d19) {
        double c16 = c(d18 - d16);
        double c17 = c(d19 - d17);
        double d26 = c16 / 2.0d;
        double d27 = c17 / 2.0d;
        double sin = (Math.sin(d26) * Math.sin(d26)) + (Math.sin(d27) * Math.sin(d27) * Math.cos(c(d16)) * Math.cos(c(d18)));
        return Math.atan2(Math.sqrt(sin), Math.sqrt(1.0d - sin)) * 2.0d * 6371.0d * 1000.0d;
    }

    private static GeoPoint a(int i3, int i16) {
        return new GeoPoint((int) (f(i16) * 1000000.0d), (int) (e(i3) * 1000000.0d));
    }

    public static LatLng a(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        return new LatLng(geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d);
    }

    private static Point b(GeoPoint geoPoint) {
        if (geoPoint != null) {
            return new Point(a(geoPoint.getLongitudeE6() / 1000000.0d), b(geoPoint.getLatitudeE6() / 1000000.0d));
        }
        throw new IllegalArgumentException("point is null");
    }

    public static List<LatLng> a(List<GeoPoint> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<GeoPoint> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    private static GeoPoint b(int i3, int i16) {
        return new GeoPoint((int) (f(i16 + f149073e) * 1000000.0d), (int) (e(i3 + f149072d) * 1000000.0d));
    }

    private static float b(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (geoPoint == null || geoPoint2 == null) {
            return 0.0f;
        }
        float[] fArr = new float[10];
        double latitudeE6 = geoPoint.getLatitudeE6() / 1000000.0d;
        double longitudeE6 = geoPoint.getLongitudeE6() / 1000000.0d;
        double latitudeE62 = geoPoint2.getLatitudeE6() / 1000000.0d;
        double longitudeE62 = geoPoint2.getLongitudeE6() / 1000000.0d;
        Location.distanceBetween(latitudeE6, longitudeE6, latitudeE62, longitudeE62, fArr);
        fArr[0] = (float) a(latitudeE6, longitudeE6, latitudeE62, longitudeE62);
        return fArr[1];
    }
}
