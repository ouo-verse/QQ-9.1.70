package com.tencent.biz.qqcircle.comment.recpic;

import android.graphics.Point;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u0013\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0016\u0010\t\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J$\u0010\r\u001a\u0004\u0018\u00010\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/ah;", "", "", "", "dataList", "d", "array1", "array2", "a", "b", "", "Lcom/tencent/biz/qqcircle/comment/recpic/aj;", "picList", "c", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ah {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ah f83774a = new ah();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues((Double) ((Pair) t16).getSecond(), (Double) ((Pair) t17).getSecond());
            return compareValues;
        }
    }

    ah() {
    }

    private final double[] a(double[] array1, double[] array2) {
        boolean z16;
        if (array1.length == array2.length) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            double[] dArr = new double[array1.length];
            int length = array1.length;
            for (int i3 = 0; i3 < length; i3++) {
                dArr[i3] = array1[i3] + array2[i3];
            }
            return dArr;
        }
        throw new IllegalArgumentException("Arrays must be of the same size".toString());
    }

    private final double[] d(List<double[]> dataList) {
        double[] doubleArray;
        double[] dArr = new double[1024];
        Iterator<double[]> it = dataList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            dArr = a(it.next(), dArr);
            i3++;
        }
        if (i3 > 1) {
            ArrayList arrayList = new ArrayList(dArr.length);
            for (double d16 : dArr) {
                arrayList.add(Double.valueOf(d16 / i3));
            }
            doubleArray = CollectionsKt___CollectionsKt.toDoubleArray(arrayList);
            return doubleArray;
        }
        if (i3 != 1) {
            return null;
        }
        return dArr;
    }

    @Nullable
    public final double[] b(@NotNull List<double[]> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        double[] d16 = d(dataList);
        QLog.d("QFSKMeans", 4, "[callKMeans] " + d16);
        return d16;
    }

    @Nullable
    public final double[] c(@NotNull List<QFSRecPicInfo> picList, @NotNull List<double[]> dataList) {
        int i3;
        Double m917minOrNull;
        int indexOf;
        List sortedWith;
        int collectionSizeOrDefault;
        int i16;
        double sumOfDouble;
        double sumOfDouble2;
        Iterator<double[]> it;
        double sumOfDouble3;
        Intrinsics.checkNotNullParameter(picList, "picList");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        ArrayList arrayList = new ArrayList(dataList.size());
        ArrayList arrayList2 = new ArrayList(dataList.size());
        Iterator<Point> it5 = z.f83900a.m().c().iterator();
        while (true) {
            if (it5.hasNext()) {
                Point next = it5.next();
                if (dataList.size() < next.x) {
                    i3 = next.y;
                    break;
                }
            } else {
                i3 = 2;
                break;
            }
        }
        if (i3 >= dataList.size()) {
            i3 = dataList.size() - 1;
        }
        Iterator<double[]> it6 = dataList.iterator();
        int i17 = 0;
        while (it6.hasNext()) {
            int i18 = i17 + 1;
            double[] next2 = it6.next();
            arrayList2.clear();
            int i19 = 0;
            for (double[] dArr : dataList) {
                int i26 = i19 + 1;
                if (i19 == i17) {
                    it = it6;
                } else {
                    ArrayList arrayList3 = new ArrayList(next2.length);
                    int i27 = 0;
                    int i28 = 0;
                    for (int length = next2.length; i27 < length; length = length) {
                        arrayList3.add(Double.valueOf(Math.pow(next2[i27] - dArr[i28], 2.0d)));
                        i27++;
                        it6 = it6;
                        i28++;
                    }
                    it = it6;
                    sumOfDouble3 = CollectionsKt___CollectionsKt.sumOfDouble(arrayList3);
                    arrayList2.add(Double.valueOf(Math.sqrt(sumOfDouble3)));
                }
                i19 = i26;
                it6 = it;
            }
            Iterator<double[]> it7 = it6;
            CollectionsKt__MutableCollectionsJVMKt.sort(arrayList2);
            List subList = arrayList2.subList(0, i3);
            Intrinsics.checkNotNullExpressionValue(subList, "disList.subList(0, limitNum)");
            sumOfDouble2 = CollectionsKt___CollectionsKt.sumOfDouble(subList);
            arrayList.add(Double.valueOf(sumOfDouble2 / i3));
            i17 = i18;
            it6 = it7;
        }
        m917minOrNull = CollectionsKt___CollectionsKt.m917minOrNull((Iterable<Double>) arrayList);
        indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends Double>) ((List<? extends Object>) arrayList), m917minOrNull);
        if (indexOf < 0) {
            return null;
        }
        QLog.d("QFSKMeans", 1, "centroidsIdx: " + indexOf);
        double[] dArr2 = dataList.get(indexOf);
        ArrayList arrayList4 = new ArrayList(dataList.size());
        int i29 = 0;
        for (double[] dArr3 : dataList) {
            int i36 = i29 + 1;
            if (i29 == indexOf) {
                i16 = i36;
            } else {
                ArrayList arrayList5 = new ArrayList(dArr3.length);
                int length2 = dArr3.length;
                int i37 = 0;
                int i38 = 0;
                while (i37 < length2) {
                    arrayList5.add(Double.valueOf(Math.pow(dArr3[i37] - dArr2[i38], 2.0d)));
                    i37++;
                    i36 = i36;
                    i38++;
                    dArr3 = dArr3;
                }
                i16 = i36;
                sumOfDouble = CollectionsKt___CollectionsKt.sumOfDouble(arrayList5);
                arrayList4.add(new Pair(Integer.valueOf(i29), Double.valueOf(Math.sqrt(sumOfDouble))));
            }
            i29 = i16;
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList4, new a());
        List subList2 = sortedWith.subList(0, i3);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(subList2, 10);
        ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault);
        Iterator it8 = subList2.iterator();
        while (it8.hasNext()) {
            arrayList6.add(Integer.valueOf(((Number) ((Pair) it8.next()).getFirst()).intValue()));
        }
        ArrayList arrayList7 = new ArrayList();
        int i39 = 0;
        for (Object obj : picList) {
            int i46 = i39 + 1;
            if (i39 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (arrayList6.contains(Integer.valueOf(i39))) {
                arrayList7.add(obj);
            }
            i39 = i46;
        }
        picList.clear();
        picList.addAll(arrayList7);
        ArrayList arrayList8 = new ArrayList();
        int i47 = 0;
        for (Object obj2 : dataList) {
            int i48 = i47 + 1;
            if (i47 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (arrayList6.contains(Integer.valueOf(i47))) {
                arrayList8.add(obj2);
            }
            i47 = i48;
        }
        dataList.clear();
        dataList.addAll(arrayList8);
        return dArr2;
    }
}
