package com.tencent.mobileqq.winkpublish.model;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* compiled from: P */
/* loaded from: classes21.dex */
public class DynamicArrayList<E> extends ArrayList<E> implements DoListWriteInterface<E> {
    private OnListWriteListener<E> mListener;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    private class DelegateIterator implements Iterator<E> {
        private Iterator<E> mOther;
        private int mRemaining;
        private int mRemovalIndex;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mOther.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            E next = this.mOther.next();
            int i3 = this.mRemaining;
            this.mRemaining = i3 - 1;
            this.mRemovalIndex = DynamicArrayList.this.size() - i3;
            return next;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.mOther.remove();
            if (DynamicArrayList.this.mListener != null) {
                DynamicArrayList.this.mListener.remove(this.mRemovalIndex);
            }
            this.mRemovalIndex = -1;
        }

        DelegateIterator(Iterator<E> it) {
            this.mRemaining = DynamicArrayList.this.size();
            this.mRemovalIndex = -1;
            this.mOther = it;
        }
    }

    public DynamicArrayList() {
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i3, E e16) {
        OnListWriteListener<E> onListWriteListener = this.mListener;
        if (onListWriteListener != null) {
            onListWriteListener.add(i3, e16);
        }
        super.add(i3, e16);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i3, Collection<? extends E> collection) {
        OnListWriteListener<E> onListWriteListener = this.mListener;
        if (onListWriteListener != null) {
            onListWriteListener.addAll(i3, collection);
        }
        return super.addAll(i3, collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        OnListWriteListener<E> onListWriteListener = this.mListener;
        if (onListWriteListener != null) {
            onListWriteListener.clear();
        }
        super.clear();
    }

    @Override // com.tencent.mobileqq.winkpublish.model.DoListWriteInterface
    public E doRemove(int i3) {
        return (E) super.remove(i3);
    }

    @Override // com.tencent.mobileqq.winkpublish.model.DoListWriteInterface
    public E doSet(int i3, E e16) {
        return (E) super.set(i3, e16);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NonNull
    public Iterator<E> iterator() {
        return new DelegateIterator(super.iterator());
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    @NonNull
    public ListIterator<E> listIterator() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public E remove(int i3) {
        OnListWriteListener<E> onListWriteListener = this.mListener;
        if (onListWriteListener != null) {
            onListWriteListener.remove(i3);
        }
        return (E) super.remove(i3);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public E set(int i3, E e16) {
        OnListWriteListener<E> onListWriteListener = this.mListener;
        if (onListWriteListener != null) {
            onListWriteListener.set(i3, e16);
        }
        return (E) super.set(i3, e16);
    }

    public void setOnListWriteListener(OnListWriteListener<E> onListWriteListener) {
        this.mListener = onListWriteListener;
        if (onListWriteListener != null) {
            onListWriteListener.setDoListWriteInterface(this);
        }
    }

    public DynamicArrayList(int i3) {
        super(i3);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    @NonNull
    public ListIterator<E> listIterator(int i3) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public DynamicArrayList(Collection<? extends E> collection) {
        super(collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e16) {
        OnListWriteListener<E> onListWriteListener = this.mListener;
        if (onListWriteListener != null) {
            onListWriteListener.add(e16);
        }
        return super.add(e16);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        OnListWriteListener<E> onListWriteListener = this.mListener;
        if (onListWriteListener != null) {
            onListWriteListener.addAll(collection);
        }
        return super.addAll(collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        OnListWriteListener<E> onListWriteListener = this.mListener;
        if (onListWriteListener != null) {
            onListWriteListener.remove(obj);
        }
        return super.remove(obj);
    }
}
