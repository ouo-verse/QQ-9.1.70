package com.qq.e.comm.plugin.tangramsplash.interactive.gesture;

import android.graphics.PointF;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    public static float a(List<PointF> list, List<PointF> list2) {
        if (list == null || list2 == null) {
            return -1.0f;
        }
        int min = Math.min(list.size(), list2.size());
        if (min >= 20) {
            min = 20;
        }
        return a(list, list2, min);
    }

    private static float a(List<PointF> list, List<PointF> list2, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        float a16 = a(a(a(list, i3)), a(a(list2, i3)));
        GDTLogger.d(String.format("computeSimilarity cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return a16;
    }

    private static List<PointF> a(List<PointF> list, int i3) {
        if (i3 <= 1) {
            GDTLogger.d("sample count <= 1 !");
            return list;
        }
        if (i3 == list.size()) {
            GDTLogger.d("sample count == path.size, no need resample!");
            return list;
        }
        PointF pointF = list.get(0);
        double d16 = 0.0d;
        for (int i16 = 1; i16 < list.size(); i16++) {
            d16 += a(pointF, list.get(i16));
            pointF = list.get(i16);
        }
        List<PointF> a16 = a(list, d16 / (i3 - 1));
        if (a16.size() < i3) {
            GDTLogger.d(String.format("sample result %d, sample count %d", Integer.valueOf(a16.size()), Integer.valueOf(i3)));
            a16.add(new PointF(list.get(list.size() - 1).x, list.get(list.size() - 1).y));
        }
        return a16;
    }

    private static List<PointF> a(List<PointF> list, double d16) {
        PointF pointF;
        double d17;
        int i3;
        char c16 = 2;
        char c17 = 0;
        int i16 = 1;
        GDTLogger.d(String.format("point count %d, interval %f", Integer.valueOf(list.size()), Double.valueOf(d16)));
        if (list.size() > 1 && d16 >= 1.0d) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PointF(list.get(0).x, list.get(0).y));
            PointF pointF2 = list.get(0);
            int i17 = 1;
            double d18 = 0.0d;
            while (i17 < list.size()) {
                int i18 = i17 - 1;
                double d19 = list.get(i17).x - list.get(i18).x;
                double d26 = list.get(i17).y - list.get(i18).y;
                double hypot = (float) Math.hypot(d19, d26);
                double d27 = hypot + d18;
                Object[] objArr = new Object[3];
                objArr[c17] = Double.valueOf(d27);
                objArr[i16] = Double.valueOf(d16);
                objArr[c16] = Double.valueOf(d18);
                GDTLogger.d(String.format("dd %f, interval %f, remain %f", objArr));
                while (d27 >= d16) {
                    if (d27 == d16) {
                        pointF = new PointF(list.get(i17).x, list.get(i17).y);
                        i3 = i16;
                        d17 = hypot;
                        d27 = 0.0d;
                    } else {
                        double d28 = (d16 - d18) / hypot;
                        d17 = hypot;
                        pointF = new PointF((float) (pointF2.x + (d19 * d28)), (float) (pointF2.y + (d28 * d26)));
                        d27 -= d16;
                        i3 = 1;
                    }
                    Object[] objArr2 = new Object[i3];
                    objArr2[0] = Double.valueOf(Math.hypot(pointF.x - pointF2.x, pointF.y - pointF2.y) + d18);
                    GDTLogger.d(String.format("interval %f", objArr2));
                    arrayList.add(pointF);
                    pointF2 = pointF;
                    c17 = 0;
                    hypot = d17;
                    i16 = 1;
                }
                PointF pointF3 = list.get(i17);
                i17++;
                pointF2 = pointF3;
                d18 = d27;
                c16 = 2;
                i16 = 1;
            }
            return arrayList;
        }
        GDTLogger.d("point count <= 1 or interval < 1, no need resample!");
        return list;
    }

    private static float a(PointF pointF, PointF pointF2) {
        return (float) Math.hypot(pointF.x - pointF2.x, pointF.y - pointF2.y);
    }

    private static float a(float[] fArr, float[] fArr2) {
        if (fArr.length != fArr2.length) {
            return -1.0f;
        }
        double d16 = 0.0d;
        double d17 = 0.0d;
        double d18 = 0.0d;
        for (int i3 = 0; i3 < fArr.length; i3++) {
            d16 += fArr2[i3] * r7;
            d18 += Math.pow(fArr[i3], 2.0d);
            d17 += Math.pow(fArr2[i3], 2.0d);
        }
        return (float) (d16 / (Math.sqrt(d18) * Math.sqrt(d17)));
    }

    private static float[] a(List<PointF> list) {
        float[] fArr = new float[list.size() * 2];
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        for (int i3 = 1; i3 < list.size(); i3++) {
            int i16 = i3 * 2;
            int i17 = i3 - 1;
            fArr[i16] = list.get(i3).x - list.get(i17).x;
            fArr[i16 + 1] = list.get(i3).y - list.get(i17).y;
        }
        return fArr;
    }
}
