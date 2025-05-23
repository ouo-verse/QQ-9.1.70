package com.tencent.local_edit.andserver.util.comparator;

import com.tencent.local_edit.andserver.util.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class CompoundComparator<T> implements Comparator<T>, Serializable {
    private final List<InvertibleComparator> comparators;

    public CompoundComparator() {
        this.comparators = new ArrayList();
    }

    public void addComparator(Comparator<? extends T> comparator) {
        if (comparator instanceof InvertibleComparator) {
            this.comparators.add((InvertibleComparator) comparator);
        } else {
            this.comparators.add(new InvertibleComparator(comparator));
        }
    }

    @Override // java.util.Comparator
    public int compare(T t16, T t17) {
        boolean z16;
        if (this.comparators.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        a.d(z16, "No sort definitions have been added to this CompoundComparator to compare");
        Iterator<InvertibleComparator> it = this.comparators.iterator();
        while (it.hasNext()) {
            int compare = it.next().compare(t16, t17);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompoundComparator)) {
            return false;
        }
        return this.comparators.equals(((CompoundComparator) obj).comparators);
    }

    public int getComparatorCount() {
        return this.comparators.size();
    }

    public int hashCode() {
        return this.comparators.hashCode();
    }

    public void invertOrder() {
        Iterator<InvertibleComparator> it = this.comparators.iterator();
        while (it.hasNext()) {
            it.next().invertOrder();
        }
    }

    public void setAscendingOrder(int i3) {
        this.comparators.get(i3).setAscending(true);
    }

    public void setComparator(int i3, Comparator<? extends T> comparator) {
        if (comparator instanceof InvertibleComparator) {
            this.comparators.set(i3, (InvertibleComparator) comparator);
        } else {
            this.comparators.set(i3, new InvertibleComparator(comparator));
        }
    }

    public void setDescendingOrder(int i3) {
        this.comparators.get(i3).setAscending(false);
    }

    public String toString() {
        return "CompoundComparator: " + this.comparators;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompoundComparator(Comparator... comparatorArr) {
        a.c(comparatorArr, "Comparators must not be null");
        this.comparators = new ArrayList(comparatorArr.length);
        for (Comparator comparator : comparatorArr) {
            addComparator(comparator);
        }
    }

    public void invertOrder(int i3) {
        this.comparators.get(i3).invertOrder();
    }

    public void addComparator(Comparator<? extends T> comparator, boolean z16) {
        this.comparators.add(new InvertibleComparator(comparator, z16));
    }

    public void setComparator(int i3, Comparator<T> comparator, boolean z16) {
        this.comparators.set(i3, new InvertibleComparator(comparator, z16));
    }
}
