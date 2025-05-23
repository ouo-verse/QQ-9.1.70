package com.tencent.mapsdk.internal;

import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.IndexCallback;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class lj {
    public static double a(double d16) {
        double d17 = d16 % 360.0d;
        if (d17 > 180.0d) {
            return d17 - 360.0d;
        }
        return d17 < -180.0d ? d17 + 360.0d : d17;
    }

    private static double b(double d16) {
        return (d16 * 3.141592653589793d) / 180.0d;
    }

    private static double c(double d16) {
        return (d16 * 180.0d) / 3.141592653589793d;
    }

    public static double a(double d16, double d17, double d18, double d19, double d26, double d27) {
        return ((((d17 - d19) * d26) + ((d18 - d16) * d27)) + (d16 * d19)) - (d18 * d17);
    }

    private static double[] b(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d16;
        double[] a16 = a(latLng2, latLng3);
        double d17 = 0.0d;
        if (Double.isNaN(a16[0])) {
            d16 = latLng.latitude;
        } else {
            double d18 = a16[0];
            if (d18 == 0.0d) {
                d17 = Double.NaN;
                d16 = Double.NaN;
            } else {
                d17 = (-1.0d) / d18;
                d16 = latLng.latitude + ((1.0d / d18) * latLng.longitude);
            }
        }
        return new double[]{d17, d16};
    }

    private static boolean c(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        return (a((Coordinate) latLng2, (Coordinate) latLng3) - a((Coordinate) latLng, (Coordinate) latLng2)) - a((Coordinate) latLng, (Coordinate) latLng3) < 1.0E-6d;
    }

    private static double a(double d16, int i3) {
        try {
            return new BigDecimal(d16).setScale(i3, 4).doubleValue();
        } catch (Exception unused) {
            return d16;
        }
    }

    private static float a(float f16, int i3) {
        try {
            return new BigDecimal(f16).setScale(i3, 4).floatValue();
        } catch (Exception unused) {
            return f16;
        }
    }

    private static double c(Coordinate coordinate, Coordinate coordinate2, Coordinate coordinate3) {
        return Math.atan((a(coordinate, coordinate2) / 2.0d) / a(coordinate3, coordinate, coordinate2)) * 2.0d;
    }

    private static PointF a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        float f16 = pointF2.x;
        float f17 = pointF.x;
        if (f16 != f17) {
            float f18 = pointF4.x;
            float f19 = pointF3.x;
            if (f18 != f19) {
                float f26 = pointF2.y;
                float f27 = pointF.y;
                float f28 = (f26 - f27) / (f16 - f17);
                float f29 = pointF4.y;
                float f36 = pointF3.y;
                float f37 = (f29 - f36) / (f18 - f19);
                if (f28 == f37) {
                    return null;
                }
                float f38 = ((f36 * f18) - (f29 * f19)) / (f18 - f19);
                float f39 = (f38 - (((f27 * f16) - (f26 * f17)) / (f16 - f17))) / (f28 - f37);
                return new PointF(f39, (f37 * f39) + f38);
            }
        }
        return null;
    }

    private static double b(Coordinate coordinate, Coordinate coordinate2) {
        return (coordinate.y() - coordinate2.y()) / (coordinate.x() - coordinate2.x());
    }

    public static double b(Coordinate coordinate, Coordinate coordinate2, Coordinate coordinate3) {
        return Math.atan((a(coordinate, coordinate2) / 2.0d) / a(coordinate3, coordinate, coordinate2)) * 2.0d * a(coordinate, coordinate3);
    }

    private static double c(Coordinate coordinate, Coordinate coordinate2) {
        return (Math.atan((coordinate.y() - coordinate2.y()) / (coordinate.x() - coordinate2.x())) * 180.0d) / 3.141592653589793d;
    }

    private static Rect a(GeoPoint geoPoint, Rect rect) {
        int max = Math.max(Math.abs(rect.left - geoPoint.getLongitudeE6()), Math.abs(rect.right - geoPoint.getLongitudeE6()));
        int max2 = Math.max(Math.abs(rect.top - geoPoint.getLatitudeE6()), Math.abs(rect.bottom - geoPoint.getLatitudeE6()));
        return new Rect(geoPoint.getLongitudeE6() - max2, geoPoint.getLatitudeE6() - max, geoPoint.getLongitudeE6() + max2, geoPoint.getLatitudeE6() + max);
    }

    private static Rect a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (geoPoint == null || geoPoint2 == null || geoPoint.equals(geoPoint2)) {
            return null;
        }
        int abs = Math.abs(geoPoint.getLongitudeE6() - geoPoint2.getLongitudeE6());
        int abs2 = Math.abs(geoPoint.getLatitudeE6() - geoPoint2.getLatitudeE6());
        return new Rect(geoPoint.getLongitudeE6() - abs, geoPoint.getLatitudeE6() - abs2, geoPoint.getLongitudeE6() + abs, geoPoint.getLatitudeE6() + abs2);
    }

    private static GeoPoint a(GeoPoint geoPoint, GeoPoint geoPoint2, GeoPoint geoPoint3) {
        int latitudeE6 = geoPoint2.getLatitudeE6() - geoPoint.getLatitudeE6();
        int longitudeE6 = geoPoint2.getLongitudeE6() - geoPoint.getLongitudeE6();
        if (latitudeE6 == 0 && longitudeE6 == 0) {
            return null;
        }
        double latitudeE62 = (((geoPoint3.getLatitudeE6() - geoPoint.getLatitudeE6()) * latitudeE6) + ((geoPoint3.getLongitudeE6() - geoPoint.getLongitudeE6()) * longitudeE6)) / ((latitudeE6 * latitudeE6) + (longitudeE6 * longitudeE6));
        if (latitudeE62 < 0.0d) {
            return new GeoPoint(geoPoint);
        }
        if (latitudeE62 > 1.0d) {
            return new GeoPoint(geoPoint2);
        }
        return new GeoPoint(geoPoint.getLatitudeE6() + ((int) (latitudeE6 * latitudeE62)), geoPoint.getLongitudeE6() + ((int) (longitudeE6 * latitudeE62)));
    }

    private static double[] a(LatLng latLng, LatLng latLng2) {
        double d16;
        double d17;
        if (Math.abs(latLng.longitude - latLng2.longitude) < 1.0E-6d) {
            d17 = Double.NaN;
            d16 = Double.NaN;
        } else if (Math.abs(latLng.latitude - latLng2.latitude) < 1.0E-6d) {
            double d18 = latLng.latitude;
            d17 = 0.0d;
            d16 = d18;
        } else {
            double d19 = latLng2.latitude;
            double d26 = latLng.latitude;
            double d27 = latLng2.longitude;
            double d28 = latLng.longitude;
            double d29 = (d19 - d26) / (d27 - d28);
            d16 = ((d27 * d26) - (d28 * d19)) / (d27 - d26);
            d17 = d29;
        }
        return new double[]{d17, d16};
    }

    public static double a(Coordinate coordinate, Coordinate coordinate2, Coordinate coordinate3) {
        double a16 = a(coordinate, coordinate2);
        double a17 = a(coordinate, coordinate3);
        double a18 = a(coordinate2, coordinate3);
        double d16 = a16 + a17;
        if (d16 == a18) {
            return 0.0d;
        }
        if (a18 <= 1.0E-6d) {
            return a16;
        }
        double d17 = a17 * a17;
        double d18 = a16 * a16;
        double d19 = a18 * a18;
        if (d17 >= d18 + d19) {
            return a16;
        }
        if (d18 >= d17 + d19) {
            return a17;
        }
        double d26 = (d16 + a18) / 2.0d;
        return (Math.sqrt((((d26 - a16) * d26) * (d26 - a17)) * (d26 - a18)) * 2.0d) / a18;
    }

    public static LatLng a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d16;
        double d17;
        double[] a16 = a(latLng2, latLng3);
        if (Double.isNaN(a16[0])) {
            d17 = latLng2.longitude;
            d16 = latLng.latitude;
        } else {
            double d18 = a16[0];
            if (d18 == 0.0d) {
                double d19 = latLng.longitude;
                double d26 = latLng2.latitude;
                d17 = d19;
                d16 = d26;
            } else {
                double d27 = d18 * d18;
                double d28 = latLng2.longitude;
                double d29 = latLng.latitude;
                double d36 = latLng2.latitude;
                double d37 = (((d27 * d28) + ((d29 - d36) * d18)) + latLng.longitude) / (d27 + 1.0d);
                d16 = (d18 * (d37 - d28)) + d36;
                d17 = d37;
            }
        }
        return new LatLng(d16, d17);
    }

    public static LatLng a(LatLng latLng, LatLng latLng2, int i3) {
        double d16 = latLng2.longitude;
        double d17 = latLng.longitude;
        double d18 = d16 > d17 ? d17 - i3 : d17 + i3;
        double d19 = latLng2.latitude;
        double d26 = latLng.latitude;
        return new LatLng(d19 > d26 ? d26 - i3 : d26 + i3, d18);
    }

    public static double a(Coordinate coordinate, Coordinate coordinate2) {
        double x16 = coordinate.x() - coordinate2.x();
        double y16 = coordinate.y() - coordinate2.y();
        return Math.sqrt((x16 * x16) + (y16 * y16));
    }

    public static boolean a(LatLng latLng, double d16, LatLng latLng2, LatLng latLng3) {
        if (a((Coordinate) latLng, (Coordinate) latLng2, (Coordinate) latLng3) - d16 > 1.0E-6d) {
            return false;
        }
        LatLng a16 = a(latLng, latLng2, latLng3);
        return (a((Coordinate) latLng2, (Coordinate) latLng3) - a((Coordinate) a16, (Coordinate) latLng2)) - a((Coordinate) a16, (Coordinate) latLng3) < 1.0E-6d;
    }

    private static String a() {
        byte[] bArr = new byte[20];
        new SecureRandom().nextBytes(bArr);
        return new String(bArr);
    }

    private static int a(int i3) {
        int i16 = i3 - 0;
        if (i16 > 0) {
            return new SecureRandom().nextInt(i16) + 0;
        }
        return 0;
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? str : Util.getMD5String(str.getBytes());
    }

    public static String a(File file) {
        int i3;
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
                    byte[] bArr = new byte[10485760];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
                    int length = 40 - bigInteger.length();
                    if (length > 0) {
                        for (i3 = 0; i3 < length; i3++) {
                            bigInteger = "0".concat(String.valueOf(bigInteger));
                        }
                    }
                    ku.a((Closeable) fileInputStream2);
                    return bigInteger;
                } catch (IOException e16) {
                    e = e16;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    ku.a((Closeable) fileInputStream);
                    return "";
                } catch (NoSuchAlgorithmException e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    ku.a((Closeable) fileInputStream);
                    return "";
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    ku.a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (IOException e18) {
                e = e18;
            } catch (NoSuchAlgorithmException e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static double a(Coordinate coordinate, Coordinate coordinate2, Coordinate coordinate3, Coordinate coordinate4) {
        double x16 = (coordinate2.x() - coordinate.x()) * 2.0d;
        double y16 = (coordinate2.y() - coordinate.y()) * 2.0d;
        double x17 = (((coordinate2.x() * coordinate2.x()) + (coordinate2.y() * coordinate2.y())) - (coordinate.x() * coordinate.x())) - (coordinate.y() * coordinate.y());
        double x18 = (coordinate3.x() - coordinate2.x()) * 2.0d;
        double y17 = (coordinate3.y() - coordinate2.y()) * 2.0d;
        double x19 = (((coordinate3.x() * coordinate3.x()) + (coordinate3.y() * coordinate3.y())) - (coordinate2.x() * coordinate2.x())) - (coordinate2.y() * coordinate2.y());
        double d16 = (x17 * y17) - (x19 * y16);
        double d17 = (y17 * x16) - (y16 * x18);
        double d18 = d16 / d17;
        double d19 = ((x16 * x19) - (x18 * x17)) / d17;
        coordinate4.setX(d18);
        coordinate4.setY(d19);
        return Math.sqrt(Math.pow(coordinate.x() - d18, 2.0d) + Math.pow(coordinate.y() - d19, 2.0d));
    }

    public static double a(Coordinate coordinate, Coordinate coordinate2, double d16, boolean z16, Coordinate coordinate3) {
        double a16 = (a(coordinate, coordinate2) * 0.5d) / Math.sin(b(0.5d * d16));
        double x16 = (coordinate.x() + coordinate2.x()) / 2.0d;
        double y16 = (coordinate.y() + coordinate2.y()) / 2.0d;
        double sqrt = Math.sqrt((Math.pow(a16, 2.0d) / (Math.pow(coordinate.x() - coordinate2.x(), 2.0d) + Math.pow(coordinate.y() - coordinate2.y(), 2.0d))) - 0.25d);
        double y17 = (coordinate.y() - coordinate2.y()) * sqrt;
        double x17 = (coordinate2.x() - coordinate.x()) * sqrt;
        if (d16 - 180.0d <= 1.0E-6d) {
            y17 = -y17;
            x17 = -x17;
        }
        if (Double.isNaN(y17)) {
            y17 = 0.0d;
        }
        if (Double.isNaN(x17)) {
            x17 = 0.0d;
        }
        double d17 = z16 ? x16 + y17 : x16 - y17;
        double d18 = z16 ? y16 + x17 : y16 - x17;
        coordinate3.setX(d17);
        coordinate3.setY(d18);
        return a16;
    }

    public static <T extends Coordinate> void a(T t16, double d16, T t17, T t18, boolean z16, IndexCallback<Pair<Double, Double>> indexCallback) {
        double atan = (Math.atan((t16.y() - t17.y()) / (t16.x() - t17.x())) * 180.0d) / 3.141592653589793d;
        boolean z17 = t16.x() > t17.x() ? !z16 : z16;
        int i3 = 0;
        double d17 = 0.0d;
        while (i3 < 360) {
            double d18 = i3;
            double tan = Math.tan(b(z16 ? atan - d18 : d18 + atan));
            if (d17 != 0.0d && d17 * tan < 0.0d && Math.abs(tan) > 1.0d) {
                z17 = !z17;
            }
            double sqrt = d16 / Math.sqrt((tan * tan) + 1.0d);
            double d19 = tan * sqrt;
            LogUtil.b(ky.f149101g, i3 + ":curDeltaK[" + tan + "]deltaKChanged[" + z17 + "]clockwise[" + z16 + "]deltaX[" + sqrt + "]deltaY[" + d19 + "]");
            if (z17) {
                sqrt = -sqrt;
                d19 = -d19;
            }
            double x16 = t16.x();
            double d26 = z16 ? x16 - sqrt : x16 + sqrt;
            double y16 = t16.y();
            double d27 = z16 ? y16 - d19 : y16 + d19;
            double a16 = a(t17.x(), t17.y(), t18.x(), t18.y(), d26, d27);
            if (!z16 ? a16 < 0.0d : a16 > 0.0d) {
                indexCallback.callback(i3, new Pair<>(Double.valueOf(d26), Double.valueOf(d27)));
            }
            i3++;
            d17 = tan;
        }
    }
}
