package com.tencent.map.geolocation.sapp;

import android.content.Context;
import c.t.m.sapp.c.q;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TencentLocationUtils {
    TencentLocationUtils() {
        throw new UnsupportedOperationException();
    }

    public static boolean contains(TencentLocation tencentLocation, double d16, TencentLocation tencentLocation2) {
        if (tencentLocation != null && tencentLocation2 != null) {
            if (distanceBetween(tencentLocation, tencentLocation2) <= d16) {
                return true;
            }
            return false;
        }
        throw null;
    }

    public static double distanceBetween(TencentLocation tencentLocation, TencentLocation tencentLocation2) {
        if (tencentLocation != null && tencentLocation2 != null) {
            return q.a(tencentLocation.getLatitude(), tencentLocation.getLongitude(), tencentLocation2.getLatitude(), tencentLocation2.getLongitude());
        }
        throw null;
    }

    public static boolean isFromGps(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return false;
        }
        return "gps".equals(tencentLocation.getProvider());
    }

    public static boolean isFromNetwork(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return false;
        }
        return "network".equals(tencentLocation.getProvider());
    }

    public static boolean isSupportGps(Context context) {
        context.getClass();
        if ((q.f(context) & 16) == 0) {
            return true;
        }
        return false;
    }

    public static boolean wgs84ToGcj02(double[] dArr, double[] dArr2) {
        if (dArr != null && dArr2 != null) {
            try {
                if (dArr.length == 2 && dArr2.length == 2) {
                    return TencentExtraKeys.wgs84ToGcj02(dArr, dArr2);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public static double distanceBetween(double d16, double d17, double d18, double d19) {
        return q.a(d16, d17, d18, d19);
    }
}
