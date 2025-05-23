package org.jf.util;

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class AbstractForwardSequentialList<T> extends AbstractSequentialList<T> {
    /* JADX INFO: Access modifiers changed from: private */
    @Nonnull
    public Iterator<T> iterator(int i3) {
        if (i3 >= 0) {
            Iterator<T> it = iterator();
            for (int i16 = 0; i16 < i3; i16++) {
                it.next();
            }
            return it;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @Nonnull
    public abstract Iterator<T> iterator();

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    @Nonnull
    public ListIterator<T> listIterator(int i3) {
        try {
            return new AbstractListIterator<T>(i3, iterator(i3)) { // from class: org.jf.util.AbstractForwardSequentialList.1

                @Nullable
                private Iterator<T> forwardIterator;
                private int index;
                final /* synthetic */ int val$initialIndex;
                final /* synthetic */ Iterator val$initialIterator;

                {
                    this.val$initialIndex = i3;
                    this.val$initialIterator = r3;
                    this.index = i3 - 1;
                    this.forwardIterator = r3;
                }

                @Nonnull
                private Iterator<T> getForwardIterator() {
                    if (this.forwardIterator == null) {
                        try {
                            this.forwardIterator = AbstractForwardSequentialList.this.iterator(this.index + 1);
                        } catch (IndexOutOfBoundsException unused) {
                            throw new NoSuchElementException();
                        }
                    }
                    return this.forwardIterator;
                }

                @Override // org.jf.util.AbstractListIterator, java.util.ListIterator, java.util.Iterator
                public boolean hasNext() {
                    return getForwardIterator().hasNext();
                }

                @Override // org.jf.util.AbstractListIterator, java.util.ListIterator
                public boolean hasPrevious() {
                    if (this.index >= 0) {
                        return true;
                    }
                    return false;
                }

                @Override // org.jf.util.AbstractListIterator, java.util.ListIterator, java.util.Iterator
                public T next() {
                    T next = getForwardIterator().next();
                    this.index++;
                    return next;
                }

                @Override // org.jf.util.AbstractListIterator, java.util.ListIterator
                public int nextIndex() {
                    return this.index + 1;
                }

                @Override // org.jf.util.AbstractListIterator, java.util.ListIterator
                public T previous() {
                    this.forwardIterator = null;
                    try {
                        AbstractForwardSequentialList abstractForwardSequentialList = AbstractForwardSequentialList.this;
                        int i16 = this.index;
                        this.index = i16 - 1;
                        return (T) abstractForwardSequentialList.iterator(i16).next();
                    } catch (IndexOutOfBoundsException unused) {
                        throw new NoSuchElementException();
                    }
                }

                @Override // org.jf.util.AbstractListIterator, java.util.ListIterator
                public int previousIndex() {
                    return this.index;
                }
            };
        } catch (NoSuchElementException unused) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    @Nonnull
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }
}
