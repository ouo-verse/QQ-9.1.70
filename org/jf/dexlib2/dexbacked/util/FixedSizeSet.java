package org.jf.dexlib2.dexbacked.util;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class FixedSizeSet<T> extends AbstractSet<T> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        return new Iterator<T>() { // from class: org.jf.dexlib2.dexbacked.util.FixedSizeSet.1
            int index = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index < FixedSizeSet.this.size()) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            public T next() {
                if (hasNext()) {
                    FixedSizeSet fixedSizeSet = FixedSizeSet.this;
                    int i3 = this.index;
                    this.index = i3 + 1;
                    return (T) fixedSizeSet.readItem(i3);
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Nonnull
    public abstract T readItem(int i3);
}
