package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GeoPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class le {
    private static double a(int i3, int i16, int i17, float f16) {
        double d16 = 1.0d - f16;
        return (d16 * d16 * i3) + (2.0f * f16 * d16 * i16) + (f16 * f16 * i17);
    }

    private static float a(int i3, int i16, int i17, int i18, float f16) {
        float f17 = (i16 - i3) * 3.0f;
        float f18 = ((i17 - i16) * 3.0f) - f17;
        float f19 = ((i18 - i3) - f17) - f18;
        float f26 = f16 * f16;
        return (f19 * f26 * f16) + (f18 * f26) + (f17 * f16) + i3;
    }

    private static int a(List<GeoPoint> list, int[] iArr, fa faVar) {
        int size;
        int i3 = 0;
        if (list == null || (size = list.size()) < 2) {
            return 0;
        }
        int i16 = 0;
        while (i3 < size - 1) {
            GeoPoint geoPoint = list.get(i3);
            int i17 = i3 + 1;
            GeoPoint geoPoint2 = list.get(i17);
            fw a16 = faVar.a(geoPoint);
            fw a17 = faVar.a(geoPoint2);
            double d16 = a17.f148383a - a16.f148383a;
            double d17 = a17.f148384b - a16.f148384b;
            int sqrt = (int) Math.sqrt((d16 * d16) + (d17 * d17));
            int max = sqrt / Math.max(4, (sqrt / 500) * 4);
            iArr[i3] = max;
            i16 += max;
            i3 = i17;
        }
        return i16;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x011f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<GeoPoint> a(List<GeoPoint> list, int i3) {
        int size;
        GeoPoint geoPoint;
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size2 = list.size();
        ArrayList arrayList = new ArrayList(i3);
        int i16 = 0;
        GeoPoint geoPoint2 = list.get(0);
        GeoPoint geoPoint3 = list.get(size2 - 1);
        int i17 = 2;
        int longitudeE6 = (geoPoint2.getLongitudeE6() + geoPoint3.getLongitudeE6()) / 2;
        int latitudeE6 = (geoPoint2.getLatitudeE6() + geoPoint3.getLatitudeE6()) / 2;
        for (int i18 = 0; i18 < size2; i18++) {
            GeoPoint geoPoint4 = list.get(i18);
            geoPoint4.setLongitudeE6(geoPoint4.getLongitudeE6() - longitudeE6);
            geoPoint4.setLatitudeE6(geoPoint4.getLatitudeE6() - latitudeE6);
        }
        float f16 = 1.0f / (i3 + 1);
        int i19 = 0;
        float f17 = f16;
        while (i19 < i3) {
            if (!list.isEmpty() && ((size = list.size()) == 3 || size == 4)) {
                if (size == 3) {
                    GeoPoint geoPoint5 = list.get(i16);
                    GeoPoint geoPoint6 = list.get(1);
                    GeoPoint geoPoint7 = list.get(i17);
                    if (geoPoint5 != null && geoPoint6 != null && geoPoint7 != null) {
                        geoPoint = new GeoPoint((int) a(geoPoint5.getLatitudeE6(), geoPoint6.getLatitudeE6(), geoPoint7.getLatitudeE6(), f17), (int) a(geoPoint5.getLongitudeE6(), geoPoint6.getLongitudeE6(), geoPoint7.getLongitudeE6(), f17));
                        if (geoPoint != null) {
                            geoPoint.setLongitudeE6(geoPoint.getLongitudeE6() + longitudeE6);
                            geoPoint.setLatitudeE6(geoPoint.getLatitudeE6() + latitudeE6);
                            arrayList.add(geoPoint);
                            f17 += f16;
                        }
                        i19++;
                        i16 = 0;
                        i17 = 2;
                    }
                } else {
                    GeoPoint geoPoint8 = list.get(i16);
                    GeoPoint geoPoint9 = list.get(1);
                    GeoPoint geoPoint10 = list.get(i17);
                    GeoPoint geoPoint11 = list.get(3);
                    if (geoPoint8 != null && geoPoint9 != null && geoPoint10 != null && geoPoint11 != null) {
                        geoPoint = new GeoPoint((int) a(geoPoint8.getLatitudeE6(), geoPoint9.getLatitudeE6(), geoPoint10.getLatitudeE6(), geoPoint11.getLatitudeE6(), f17), (int) a(geoPoint8.getLongitudeE6(), geoPoint9.getLongitudeE6(), geoPoint10.getLongitudeE6(), geoPoint11.getLongitudeE6(), f17));
                        if (geoPoint != null) {
                        }
                        i19++;
                        i16 = 0;
                        i17 = 2;
                    }
                }
            }
            geoPoint = null;
            if (geoPoint != null) {
            }
            i19++;
            i16 = 0;
            i17 = 2;
        }
        return arrayList;
    }

    private static GeoPoint a(List<GeoPoint> list, float f16) {
        int size;
        if (list == null || list.isEmpty() || !((size = list.size()) == 3 || size == 4)) {
            return null;
        }
        if (size == 3) {
            GeoPoint geoPoint = list.get(0);
            GeoPoint geoPoint2 = list.get(1);
            GeoPoint geoPoint3 = list.get(2);
            if (geoPoint == null || geoPoint2 == null || geoPoint3 == null) {
                return null;
            }
            return new GeoPoint((int) a(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6(), geoPoint3.getLatitudeE6(), f16), (int) a(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6(), geoPoint3.getLongitudeE6(), f16));
        }
        GeoPoint geoPoint4 = list.get(0);
        GeoPoint geoPoint5 = list.get(1);
        GeoPoint geoPoint6 = list.get(2);
        GeoPoint geoPoint7 = list.get(3);
        if (geoPoint4 != null && geoPoint5 != null && geoPoint6 != null && geoPoint7 != null) {
            return new GeoPoint((int) a(geoPoint4.getLatitudeE6(), geoPoint5.getLatitudeE6(), geoPoint6.getLatitudeE6(), geoPoint7.getLatitudeE6(), f16), (int) a(geoPoint4.getLongitudeE6(), geoPoint5.getLongitudeE6(), geoPoint6.getLongitudeE6(), geoPoint7.getLongitudeE6(), f16));
        }
        return null;
    }

    private static double a(fw fwVar, fw fwVar2) {
        double d16 = fwVar2.f148383a - fwVar.f148383a;
        double d17 = fwVar2.f148384b - fwVar.f148384b;
        return Math.sqrt((d16 * d16) + (d17 * d17));
    }
}
