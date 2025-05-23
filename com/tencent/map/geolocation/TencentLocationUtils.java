package com.tencent.map.geolocation;

import android.content.Context;
import c.t.m.g.n3;
import c.t.m.g.t3;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TencentLocationUtils {
    public TencentLocationUtils() {
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
            return t3.a(tencentLocation.getLatitude(), tencentLocation.getLongitude(), tencentLocation2.getLatitude(), tencentLocation2.getLongitude());
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
        if ((n3.a().a(context) & 16) == 0) {
            return true;
        }
        return false;
    }

    public static double distanceBetween(double d16, double d17, double d18, double d19) {
        return t3.a(d16, d17, d18, d19);
    }
}
