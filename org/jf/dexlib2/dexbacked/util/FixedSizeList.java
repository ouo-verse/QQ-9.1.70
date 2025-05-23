package org.jf.dexlib2.dexbacked.util;

import java.util.AbstractList;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class FixedSizeList<T> extends AbstractList<T> {
    @Override // java.util.AbstractList, java.util.List
    public T get(int i3) {
        if (i3 >= 0 && i3 < size()) {
            return readItem(i3);
        }
        throw new IndexOutOfBoundsException();
    }

    @Nonnull
    public abstract T readItem(int i3);
}
