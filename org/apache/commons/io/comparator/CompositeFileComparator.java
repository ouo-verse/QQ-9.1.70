package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CompositeFileComparator extends AbstractFileComparator implements Serializable {
    private static final Comparator<?>[] NO_COMPARATORS = new Comparator[0];
    private static final long serialVersionUID = -2224170307287243428L;
    private final Comparator<File>[] delegates;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeFileComparator(Comparator<File>... comparatorArr) {
        if (comparatorArr == null) {
            this.delegates = NO_COMPARATORS;
            return;
        }
        Comparator<File>[] comparatorArr2 = new Comparator[comparatorArr.length];
        this.delegates = comparatorArr2;
        System.arraycopy(comparatorArr, 0, comparatorArr2, 0, comparatorArr.length);
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ List sort(List list) {
        return super.sort((List<File>) list);
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(super.toString());
        sb5.append('{');
        for (int i3 = 0; i3 < this.delegates.length; i3++) {
            if (i3 > 0) {
                sb5.append(',');
            }
            sb5.append(this.delegates[i3]);
        }
        sb5.append('}');
        return sb5.toString();
    }

    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        int i3 = 0;
        for (Comparator<File> comparator : this.delegates) {
            i3 = comparator.compare(file, file2);
            if (i3 != 0) {
                break;
            }
        }
        return i3;
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ File[] sort(File[] fileArr) {
        return super.sort(fileArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeFileComparator(Iterable<Comparator<File>> iterable) {
        if (iterable == null) {
            this.delegates = NO_COMPARATORS;
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Comparator<File>> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.delegates = (Comparator[]) arrayList.toArray(new Comparator[arrayList.size()]);
    }
}
