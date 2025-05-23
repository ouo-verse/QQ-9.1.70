package com.google.protobuf;

import com.google.protobuf.ad;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: P */
/* loaded from: classes2.dex */
abstract class d<E> extends AbstractList<E> implements ad.j<E> {

    /* renamed from: d, reason: collision with root package name */
    private boolean f35843d = true;

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e16) {
        d();
        return super.add(e16);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        d();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        d();
        super.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        if (this.f35843d) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i3 = 0; i3 < size; i3++) {
            if (!get(i3).equals(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i3 = 1;
        for (int i16 = 0; i16 < size; i16++) {
            i3 = (i3 * 31) + get(i16).hashCode();
        }
        return i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        d();
        return super.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        d();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        d();
        return super.retainAll(collection);
    }

    @Override // com.google.protobuf.ad.j
    public final void y() {
        this.f35843d = false;
    }

    public boolean z() {
        return this.f35843d;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i3, Collection<? extends E> collection) {
        d();
        return super.addAll(i3, collection);
    }
}
