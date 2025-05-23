package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: P */
@GwtCompatible(serializable = true)
/* loaded from: classes2.dex */
final class CompoundOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<? super T>[] comparators;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompoundOrdering(Comparator<? super T> comparator, Comparator<? super T> comparator2) {
        this.comparators = new Comparator[]{comparator, comparator2};
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t16, T t17) {
        int i3 = 0;
        while (true) {
            Comparator<? super T>[] comparatorArr = this.comparators;
            if (i3 >= comparatorArr.length) {
                return 0;
            }
            int compare = comparatorArr[i3].compare(t16, t17);
            if (compare != 0) {
                return compare;
            }
            i3++;
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CompoundOrdering) {
            return Arrays.equals(this.comparators, ((CompoundOrdering) obj).comparators);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.comparators);
    }

    public String toString() {
        return "Ordering.compound(" + Arrays.toString(this.comparators) + ")";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompoundOrdering(Iterable<? extends Comparator<? super T>> iterable) {
        this.comparators = (Comparator[]) q.l(iterable, new Comparator[0]);
    }
}
