package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes29.dex */
class ReverseComparator extends AbstractFileComparator implements Serializable {
    private static final long serialVersionUID = -4808255005272229056L;
    private final Comparator<File> delegate;

    public ReverseComparator(Comparator<File> comparator) {
        if (comparator != null) {
            this.delegate = comparator;
            return;
        }
        throw new IllegalArgumentException("Delegate comparator is missing");
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public String toString() {
        return super.toString() + "[" + this.delegate.toString() + "]";
    }

    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        return this.delegate.compare(file2, file);
    }
}
