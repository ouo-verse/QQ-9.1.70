package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class lg {

    /* renamed from: a, reason: collision with root package name */
    public static double f149183a = 6378137.0d;

    /* renamed from: b, reason: collision with root package name */
    public static final double f149184b = 111319.49079327357d;

    /* renamed from: c, reason: collision with root package name */
    public static final double f149185c = 0.017453292519943295d;

    /* renamed from: d, reason: collision with root package name */
    private static final double f149186d = 6378137.0d * 6.283185307179586d;

    /* renamed from: e, reason: collision with root package name */
    private static final double f149187e = 0.017453292519943295d;

    /* renamed from: f, reason: collision with root package name */
    private static final double f149188f = 2.68435456E8d;

    public static boolean a(LatLng latLng, List<LatLng> list, double d16) {
        long j3;
        double abs;
        List<LatLng> list2 = list;
        if (latLng == null || list2 == null || list.size() == 0 || d16 <= f149186d) {
            return false;
        }
        double d17 = d16 / 2.0d;
        LatLngBounds build = LatLngBounds.builder().include(list2).build();
        double lonEast = build.getLonEast() + d16;
        if (LatLngBounds.from(build.getLatNorth() + d16, lonEast, build.getLatSouth() - d16, build.getLonWest() - d16).contains(latLng)) {
            int i3 = 0;
            while (i3 < list.size() - 1) {
                a a16 = a.a(list2.get(i3));
                int i16 = i3 + 1;
                a a17 = a.a(list2.get(i16));
                a a18 = a.a(latLng);
                a aVar = new a();
                aVar.f149189a = a17.f149189a - a16.f149189a;
                aVar.f149190b = a17.f149190b - a16.f149190b;
                a aVar2 = new a();
                aVar2.f149189a = a18.f149189a - a17.f149189a;
                aVar2.f149190b = a18.f149190b - a17.f149190b;
                a aVar3 = new a();
                double d18 = a18.f149189a - a16.f149189a;
                aVar3.f149189a = d18;
                double d19 = a18.f149190b - a16.f149190b;
                aVar3.f149190b = d19;
                double d26 = aVar.f149189a;
                double d27 = aVar2.f149189a * d26;
                double d28 = d17;
                double d29 = aVar.f149190b;
                double d36 = (d26 * d18) + (d29 * d19);
                if (d27 + (aVar2.f149190b * d29) > f149186d) {
                    double d37 = a18.f149190b - a17.f149190b;
                    double d38 = a18.f149189a - a17.f149189a;
                    abs = Math.sqrt((d38 * d38) + (d37 * d37));
                    j3 = 0;
                } else {
                    j3 = 0;
                    if (d36 < f149186d) {
                        double d39 = a18.f149190b - a16.f149190b;
                        double d46 = a18.f149189a - a16.f149189a;
                        abs = Math.sqrt((d46 * d46) + (d39 * d39));
                    } else {
                        abs = Math.abs((d26 * d19) - (d29 * d18)) / Math.sqrt((d26 * d26) + (d29 * d29));
                    }
                }
                if (abs <= d28) {
                    return true;
                }
                list2 = list;
                d17 = d28;
                i3 = i16;
            }
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        double f149189a;

        /* renamed from: b, reason: collision with root package name */
        double f149190b;

        a(double d16, double d17) {
            this.f149189a = d16;
            this.f149190b = d17;
        }

        public static a a(LatLng latLng) {
            return new a(latLng.x(), latLng.y());
        }

        public a() {
        }
    }

    private static LatLngBounds a(LatLngBounds latLngBounds, double d16) {
        double lonEast = latLngBounds.getLonEast() + d16;
        return LatLngBounds.from(latLngBounds.getLatNorth() + d16, lonEast, latLngBounds.getLatSouth() - d16, latLngBounds.getLonWest() - d16);
    }

    public static double a(double d16, double d17) {
        return (d16 * (f149188f / f149186d)) / Math.cos(d17 * 0.017453292519943295d);
    }

    public static double a(List<LatLng> list) {
        double d16 = f149186d;
        if (list == null || list.size() < 3) {
            return f149186d;
        }
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            LatLng latLng = list.get(i3);
            i3++;
            LatLng latLng2 = list.get(i3 % size);
            double cos = latLng.longitude * 111319.49079327357d * Math.cos(latLng.latitude * 0.017453292519943295d);
            double d17 = latLng.latitude * 111319.49079327357d;
            d16 += (cos * (latLng2.latitude * 111319.49079327357d)) - (((latLng2.longitude * 111319.49079327357d) * Math.cos(latLng2.latitude * 0.017453292519943295d)) * d17);
        }
        return Math.abs(d16 / 2.0d);
    }

    private static double a(a aVar, a aVar2, a aVar3) {
        a aVar4 = new a();
        aVar4.f149189a = aVar2.f149189a - aVar.f149189a;
        aVar4.f149190b = aVar2.f149190b - aVar.f149190b;
        a aVar5 = new a();
        aVar5.f149189a = aVar3.f149189a - aVar2.f149189a;
        aVar5.f149190b = aVar3.f149190b - aVar2.f149190b;
        a aVar6 = new a();
        double d16 = aVar3.f149189a - aVar.f149189a;
        aVar6.f149189a = d16;
        double d17 = aVar3.f149190b - aVar.f149190b;
        aVar6.f149190b = d17;
        double d18 = aVar4.f149189a;
        double d19 = aVar5.f149189a * d18;
        double d26 = aVar4.f149190b;
        double d27 = (d18 * d16) + (d26 * d17);
        if (d19 + (aVar5.f149190b * d26) > f149186d) {
            double d28 = aVar3.f149190b - aVar2.f149190b;
            double d29 = aVar3.f149189a - aVar2.f149189a;
            return Math.sqrt((d29 * d29) + (d28 * d28));
        }
        if (d27 < f149186d) {
            double d36 = aVar3.f149190b - aVar.f149190b;
            double d37 = aVar3.f149189a - aVar.f149189a;
            return Math.sqrt((d37 * d37) + (d36 * d36));
        }
        return Math.abs((d18 * d17) - (d26 * d16)) / Math.sqrt((d18 * d18) + (d26 * d26));
    }
}
