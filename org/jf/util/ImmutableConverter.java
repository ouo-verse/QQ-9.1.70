package org.jf.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class ImmutableConverter<ImmutableItem, Item> {
    protected abstract boolean isImmutable(@Nonnull Item item);

    @Nonnull
    protected abstract ImmutableItem makeImmutable(@Nonnull Item item);

    @Nonnull
    public ImmutableList<ImmutableItem> toList(@Nullable Iterable<? extends Item> iterable) {
        if (iterable == null) {
            return ImmutableList.of();
        }
        boolean z16 = true;
        if (iterable instanceof ImmutableList) {
            Iterator<? extends Item> it = iterable.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!isImmutable(it.next())) {
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
        }
        if (!z16) {
            return (ImmutableList) iterable;
        }
        final Iterator<? extends Item> it5 = iterable.iterator();
        return ImmutableList.copyOf(new Iterator<ImmutableItem>() { // from class: org.jf.util.ImmutableConverter.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it5.hasNext();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Iterator
            public ImmutableItem next() {
                return (ImmutableItem) ImmutableConverter.this.makeImmutable(it5.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                it5.remove();
            }
        });
    }

    @Nonnull
    public ImmutableSet<ImmutableItem> toSet(@Nullable Iterable<? extends Item> iterable) {
        if (iterable == null) {
            return ImmutableSet.of();
        }
        boolean z16 = true;
        if (iterable instanceof ImmutableSet) {
            Iterator<? extends Item> it = iterable.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!isImmutable(it.next())) {
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
        }
        if (!z16) {
            return (ImmutableSet) iterable;
        }
        final Iterator<? extends Item> it5 = iterable.iterator();
        return ImmutableSet.copyOf(new Iterator<ImmutableItem>() { // from class: org.jf.util.ImmutableConverter.2
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it5.hasNext();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Iterator
            public ImmutableItem next() {
                return (ImmutableItem) ImmutableConverter.this.makeImmutable(it5.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                it5.remove();
            }
        });
    }

    @Nonnull
    public ImmutableSortedSet<ImmutableItem> toSortedSet(@Nonnull Comparator<? super ImmutableItem> comparator, @Nullable Iterable<? extends Item> iterable) {
        if (iterable == null) {
            return ImmutableSortedSet.of();
        }
        boolean z16 = true;
        if ((iterable instanceof ImmutableSortedSet) && ((ImmutableSortedSet) iterable).comparator().equals(comparator)) {
            Iterator<? extends Item> it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = false;
                    break;
                }
                if (!isImmutable(it.next())) {
                    break;
                }
            }
        }
        if (!z16) {
            return (ImmutableSortedSet) iterable;
        }
        final Iterator<? extends Item> it5 = iterable.iterator();
        return ImmutableSortedSet.copyOf(comparator, new Iterator<ImmutableItem>() { // from class: org.jf.util.ImmutableConverter.3
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it5.hasNext();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Iterator
            public ImmutableItem next() {
                return (ImmutableItem) ImmutableConverter.this.makeImmutable(it5.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                it5.remove();
            }
        });
    }

    @Nonnull
    public SortedSet<ImmutableItem> toSortedSet(@Nonnull Comparator<? super ImmutableItem> comparator, @Nullable SortedSet<? extends Item> sortedSet) {
        if (sortedSet != null && sortedSet.size() != 0) {
            Object[] objArr = new Object[sortedSet.size()];
            Iterator<? extends Item> it = sortedSet.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                objArr[i3] = makeImmutable(it.next());
                i3++;
            }
            return ArraySortedSet.of((Comparator) comparator, objArr);
        }
        return ImmutableSortedSet.of();
    }
}
