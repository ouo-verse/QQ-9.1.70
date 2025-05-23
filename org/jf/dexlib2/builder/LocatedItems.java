package org.jf.dexlib2.builder;

import com.google.common.collect.ImmutableList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.builder.ItemWithLocation;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class LocatedItems<T extends ItemWithLocation> {

    @Nullable
    private List<T> items = null;

    /* JADX INFO: Access modifiers changed from: private */
    public void addItem(@Nonnull T t16) {
        if (this.items == null) {
            this.items = new ArrayList(1);
        }
        this.items.add(t16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nonnull
    public List<T> getItems() {
        List<T> list = this.items;
        if (list == null) {
            return ImmutableList.of();
        }
        return list;
    }

    protected abstract String getAddLocatedItemError();

    public Set<T> getModifiableItems(final MethodLocation methodLocation) {
        return new AbstractSet<T>() { // from class: org.jf.dexlib2.builder.LocatedItems.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            @Nonnull
            public Iterator<T> iterator() {
                final Iterator it = LocatedItems.this.getItems().iterator();
                return (Iterator<T>) new Iterator<T>() { // from class: org.jf.dexlib2.builder.LocatedItems.1.1

                    @Nullable
                    private T currentItem = null;

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        T t16 = this.currentItem;
                        if (t16 != null) {
                            t16.setLocation(null);
                        }
                        it.remove();
                    }

                    @Override // java.util.Iterator
                    public T next() {
                        T t16 = (T) it.next();
                        this.currentItem = t16;
                        return t16;
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return LocatedItems.this.getItems().size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean add(@Nonnull T t16) {
                if (!t16.isPlaced()) {
                    t16.setLocation(methodLocation);
                    LocatedItems.this.addItem(t16);
                    return true;
                }
                throw new IllegalArgumentException(LocatedItems.this.getAddLocatedItemError());
            }
        };
    }

    public void mergeItemsIntoNext(@Nonnull MethodLocation methodLocation, LocatedItems<T> locatedItems) {
        List<T> list;
        if (locatedItems != this && (list = this.items) != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                it.next().setLocation(methodLocation);
            }
            List<T> list2 = this.items;
            list2.addAll(locatedItems.getItems());
            locatedItems.items = list2;
            this.items = null;
        }
    }
}
