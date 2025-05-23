package com.qzone.widget.dynamicgridview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class DynamicArrayList<E> extends ArrayList<E> implements c<E> {
    private final MutableLiveData<ArrayList<E>> liveData;
    private e<E> mListener;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private class a implements Iterator<E> {

        /* renamed from: d, reason: collision with root package name */
        private Iterator<E> f60761d;

        /* renamed from: e, reason: collision with root package name */
        private int f60762e;

        /* renamed from: f, reason: collision with root package name */
        private int f60763f = -1;

        a(Iterator<E> it) {
            this.f60762e = DynamicArrayList.this.size();
            this.f60761d = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f60761d.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            E next = this.f60761d.next();
            int i3 = this.f60762e;
            this.f60762e = i3 - 1;
            this.f60763f = DynamicArrayList.this.size() - i3;
            return next;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f60761d.remove();
            if (DynamicArrayList.this.mListener != null) {
                DynamicArrayList.this.mListener.remove(this.f60763f);
            }
            DynamicArrayList.this.h();
            this.f60763f = -1;
        }
    }

    public DynamicArrayList() {
        this.liveData = new MutableLiveData<>(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.liveData.postValue(this);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i3, E e16) {
        e<E> eVar = this.mListener;
        if (eVar != null) {
            eVar.add(i3, e16);
        }
        h();
        super.add(i3, e16);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i3, Collection<? extends E> collection) {
        e<E> eVar = this.mListener;
        if (eVar != null) {
            eVar.addAll(i3, collection);
        }
        h();
        return super.addAll(i3, collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        e<E> eVar = this.mListener;
        if (eVar != null) {
            eVar.clear();
        }
        h();
        super.clear();
    }

    @Override // com.qzone.widget.dynamicgridview.c
    public E doRemove(int i3) {
        E e16 = (E) super.remove(i3);
        h();
        return e16;
    }

    @Override // com.qzone.widget.dynamicgridview.c
    public E doSet(int i3, E e16) {
        E e17 = (E) super.set(i3, e16);
        h();
        return e17;
    }

    public LiveData<ArrayList<E>> getLiveData() {
        return this.liveData;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new a(super.iterator());
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public E remove(int i3) {
        e<E> eVar = this.mListener;
        if (eVar != null) {
            eVar.remove(i3);
        }
        h();
        return (E) super.remove(i3);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public E set(int i3, E e16) {
        e<E> eVar = this.mListener;
        if (eVar != null) {
            eVar.set(i3, e16);
        }
        h();
        return (E) super.set(i3, e16);
    }

    public void setOnListWriteListener(e<E> eVar) {
        this.mListener = eVar;
        if (eVar != null) {
            eVar.b(this);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i3) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public DynamicArrayList(int i3) {
        super(i3);
        this.liveData = new MutableLiveData<>(this);
    }

    public DynamicArrayList(Collection<? extends E> collection) {
        super(collection);
        this.liveData = new MutableLiveData<>(this);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e16) {
        e<E> eVar = this.mListener;
        if (eVar != null) {
            eVar.add(e16);
        }
        h();
        return super.add(e16);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        e<E> eVar = this.mListener;
        if (eVar != null) {
            eVar.addAll(collection);
        }
        h();
        return super.addAll(collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        e<E> eVar = this.mListener;
        if (eVar != null) {
            eVar.remove(obj);
        }
        h();
        return super.remove(obj);
    }
}
