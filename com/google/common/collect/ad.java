package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class ad {
    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        if (comparator == null) {
            return Ordering.natural();
        }
        return comparator;
    }

    public static boolean b(Comparator<?> comparator, Iterable<?> iterable) {
        Comparator comparator2;
        com.google.common.base.j.m(comparator);
        com.google.common.base.j.m(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else if (iterable instanceof ac) {
            comparator2 = ((ac) iterable).comparator();
        } else {
            return false;
        }
        return comparator.equals(comparator2);
    }
}
