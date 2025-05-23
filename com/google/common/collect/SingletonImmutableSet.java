package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.concurrent.LazyInit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    final transient E element;

    /* renamed from: f, reason: collision with root package name */
    @LazyInit
    private transient int f35005f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingletonImmutableSet(E e16) {
        this.element = (E) com.google.common.base.j.m(e16);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.element.equals(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i3) {
        objArr[i3] = this.element;
        return i3 + 1;
    }

    @Override // com.google.common.collect.ImmutableSet
    ImmutableList<E> createAsList() {
        return ImmutableList.of((Object) this.element);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i3 = this.f35005f;
        if (i3 == 0) {
            int hashCode = this.element.hashCode();
            this.f35005f = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        if (this.f35005f != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.element.toString() + ']';
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public ai<E> iterator() {
        return r.u(this.element);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingletonImmutableSet(E e16, int i3) {
        this.element = e16;
        this.f35005f = i3;
    }
}
