package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class SortedLists {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum KeyAbsentBehavior {
        NEXT_LOWER { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.1
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            int resultIndex(int i3) {
                return i3 - 1;
            }
        },
        NEXT_HIGHER { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.2
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i3) {
                return i3;
            }
        },
        INVERTED_INSERTION_INDEX { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.3
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i3) {
                return ~i3;
            }
        };

        abstract int resultIndex(int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum KeyPresentBehavior {
        ANY_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.1
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int resultIndex(Comparator<? super E> comparator, E e16, List<? extends E> list, int i3) {
                return i3;
            }
        },
        LAST_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int resultIndex(Comparator<? super E> comparator, E e16, List<? extends E> list, int i3) {
                int size = list.size() - 1;
                while (i3 < size) {
                    int i16 = ((i3 + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i16), e16) > 0) {
                        size = i16 - 1;
                    } else {
                        i3 = i16;
                    }
                }
                return i3;
            }
        },
        FIRST_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int resultIndex(Comparator<? super E> comparator, E e16, List<? extends E> list, int i3) {
                int i16 = 0;
                while (i16 < i3) {
                    int i17 = (i16 + i3) >>> 1;
                    if (comparator.compare(list.get(i17), e16) < 0) {
                        i16 = i17 + 1;
                    } else {
                        i3 = i17;
                    }
                }
                return i16;
            }
        },
        FIRST_AFTER { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.4
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e16, List<? extends E> list, int i3) {
                return KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e16, list, i3) + 1;
            }
        },
        LAST_BEFORE { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.5
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e16, List<? extends E> list, int i3) {
                return KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e16, list, i3) - 1;
            }
        };

        abstract <E> int resultIndex(Comparator<? super E> comparator, E e16, List<? extends E> list, int i3);
    }

    public static <E, K extends Comparable> int a(List<E> list, com.google.common.base.d<? super E, K> dVar, @NullableDecl K k3, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return b(list, dVar, k3, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K> int b(List<E> list, com.google.common.base.d<? super E, K> dVar, @NullableDecl K k3, Comparator<? super K> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return c(Lists.n(list, dVar), k3, comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E> int c(List<? extends E> list, @NullableDecl E e16, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        com.google.common.base.j.m(comparator);
        com.google.common.base.j.m(list);
        com.google.common.base.j.m(keyPresentBehavior);
        com.google.common.base.j.m(keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = Lists.i(list);
        }
        int size = list.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i16 = (i3 + size) >>> 1;
            int compare = comparator.compare(e16, list.get(i16));
            if (compare < 0) {
                size = i16 - 1;
            } else if (compare > 0) {
                i3 = i16 + 1;
            } else {
                return i3 + keyPresentBehavior.resultIndex(comparator, e16, list.subList(i3, size + 1), i16 - i3);
            }
        }
        return keyAbsentBehavior.resultIndex(i3);
    }
}
