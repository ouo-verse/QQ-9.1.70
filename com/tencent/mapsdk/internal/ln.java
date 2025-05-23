package com.tencent.mapsdk.internal;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ln {

    /* renamed from: a, reason: collision with root package name */
    public static final Random f149227a = new Random();

    private static List<PointF> a(List<PointF> list, double d16) {
        int size = list.size();
        if (list.isEmpty() || size < 3) {
            return list;
        }
        int size2 = list.size() - 1;
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        int i3 = size2;
        while (list.get(0).equals(list.get(i3))) {
            i3--;
            if (i3 <= 0) {
                return list;
            }
        }
        arrayList.add(Integer.valueOf(i3));
        a(list, 0, i3, d16, arrayList);
        b(arrayList, 0, arrayList.size() - 1, new Comparator<Integer>() { // from class: com.tencent.mapsdk.internal.ln.1
            private static int a(Integer num, Integer num2) {
                return num.intValue() - num2.intValue();
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Integer num, Integer num2) {
                return num.intValue() - num2.intValue();
            }
        });
        ArrayList arrayList2 = new ArrayList();
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            arrayList2.add(list.get(((Integer) arrayList.get(i16)).intValue()));
        }
        return arrayList2;
    }

    private static <E> void b(ArrayList<E> arrayList, int i3, int i16, Comparator<? super E> comparator) {
        while (i16 > i3) {
            int nextInt = f149227a.nextInt((i16 - i3) + 1) + i3;
            E e16 = arrayList.get(nextInt);
            a(arrayList, nextInt, i16);
            int i17 = i3;
            int i18 = i17;
            while (i17 < i16) {
                if (comparator.compare(arrayList.get(i17), e16) <= 0) {
                    a(arrayList, i18, i17);
                    i18++;
                }
                i17++;
            }
            a(arrayList, i18, i16);
            b(arrayList, i3, i18 - 1, comparator);
            i3 = i18 + 1;
        }
    }

    private static <E> void a(ArrayList<E> arrayList, int i3, int i16) {
        E e16 = arrayList.get(i3);
        arrayList.set(i3, arrayList.get(i16));
        arrayList.set(i16, e16);
    }

    private static <E> int a(ArrayList<E> arrayList, int i3, int i16, Comparator<? super E> comparator) {
        int nextInt = f149227a.nextInt((i16 - i3) + 1) + i3;
        E e16 = arrayList.get(nextInt);
        a(arrayList, nextInt, i16);
        int i17 = i3;
        while (i3 < i16) {
            if (comparator.compare(arrayList.get(i3), e16) <= 0) {
                a(arrayList, i17, i3);
                i17++;
            }
            i3++;
        }
        a(arrayList, i17, i16);
        return i17;
    }

    private static <E> void a(ArrayList<E> arrayList, Comparator<? super E> comparator) {
        b(arrayList, 0, arrayList.size() - 1, comparator);
    }

    private static void a(List<PointF> list, int i3, int i16, double d16, ArrayList<Integer> arrayList) {
        double d17;
        int i17 = i3;
        while (true) {
            int i18 = 0;
            double d18 = 0.0d;
            for (int i19 = i17; i19 < i16; i19++) {
                PointF pointF = list.get(i17);
                PointF pointF2 = list.get(i16);
                PointF pointF3 = list.get(i19);
                if (pointF.equals(pointF2) || pointF3.equals(pointF) || pointF3.equals(pointF2)) {
                    d17 = 0.0d;
                } else {
                    float f16 = pointF.x;
                    float f17 = pointF2.y;
                    float f18 = pointF2.x;
                    float f19 = pointF3.y;
                    float f26 = pointF3.x;
                    float f27 = pointF.y;
                    d17 = (Math.abs(((((((f16 * f17) + (f18 * f19)) + (f26 * f27)) - (f18 * f27)) - (f26 * f17)) - (f16 * f19)) * 0.5d) * 2.0d) / Math.sqrt(Math.pow(pointF.x - pointF2.x, 2.0d) + Math.pow(pointF.y - pointF2.y, 2.0d));
                }
                if (d17 > d18) {
                    i18 = i19;
                    d18 = d17;
                }
            }
            if (d18 <= d16 || i18 == 0) {
                return;
            }
            arrayList.add(Integer.valueOf(i18));
            a(list, i17, i18, d16, arrayList);
            i17 = i18;
        }
    }

    private static double a(PointF pointF, PointF pointF2, PointF pointF3) {
        if (pointF.equals(pointF2) || pointF3.equals(pointF) || pointF3.equals(pointF2)) {
            return 0.0d;
        }
        float f16 = pointF.x;
        float f17 = pointF2.y;
        float f18 = pointF2.x;
        float f19 = pointF3.y;
        float f26 = pointF3.x;
        float f27 = pointF.y;
        return (Math.abs(((((((f16 * f17) + (f18 * f19)) + (f26 * f27)) - (f18 * f27)) - (f26 * f17)) - (f16 * f19)) * 0.5d) * 2.0d) / Math.sqrt(Math.pow(pointF.x - pointF2.x, 2.0d) + Math.pow(pointF.y - pointF2.y, 2.0d));
    }
}
