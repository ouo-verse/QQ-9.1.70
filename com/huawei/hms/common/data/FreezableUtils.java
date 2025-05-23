package com.huawei.hms.common.data;

import com.qzone.misc.network.uploader.report.BusinessReport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        return freezeIterable(arrayList);
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        BusinessReport.AnonymousClass1 anonymousClass1 = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            anonymousClass1.add((BusinessReport.AnonymousClass1) it.next().freeze());
        }
        return anonymousClass1;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        return freezeIterable(Arrays.asList(eArr));
    }
}
