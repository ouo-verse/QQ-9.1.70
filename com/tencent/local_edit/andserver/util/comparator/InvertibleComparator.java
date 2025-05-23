package com.tencent.local_edit.andserver.util.comparator;

import com.tencent.local_edit.andserver.util.a;
import java.io.Serializable;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes7.dex */
public class InvertibleComparator<T> implements Comparator<T>, Serializable {
    private boolean ascending = true;
    private final Comparator<T> comparator;

    public InvertibleComparator(Comparator<T> comparator) {
        a.c(comparator, "Comparator must not be null.");
        this.comparator = comparator;
    }

    @Override // java.util.Comparator
    public int compare(T t16, T t17) {
        int compare = this.comparator.compare(t16, t17);
        if (compare != 0) {
            if (!this.ascending) {
                if (Integer.MIN_VALUE == compare) {
                    return Integer.MAX_VALUE;
                }
                return compare * (-1);
            }
            return compare;
        }
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InvertibleComparator)) {
            return false;
        }
        InvertibleComparator invertibleComparator = (InvertibleComparator) obj;
        if (this.comparator.equals(invertibleComparator.comparator) && this.ascending == invertibleComparator.ascending) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public void invertOrder() {
        this.ascending = !this.ascending;
    }

    public boolean isAscending() {
        return this.ascending;
    }

    public void setAscending(boolean z16) {
        this.ascending = z16;
    }

    public String toString() {
        return "InvertibleComparator: [" + this.comparator + "]; ascending=" + this.ascending;
    }

    public InvertibleComparator(Comparator<T> comparator, boolean z16) {
        a.c(comparator, "Comparator must not be null.");
        this.comparator = comparator;
        setAscending(z16);
    }
}
