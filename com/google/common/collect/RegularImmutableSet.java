package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public final class RegularImmutableSet<E> extends ImmutableSet<E> {
    static final RegularImmutableSet<Object> EMPTY = new RegularImmutableSet<>(new Object[0], 0, null, 0, 0);

    @VisibleForTesting
    final transient Object[] elements;

    /* renamed from: f, reason: collision with root package name */
    private final transient int f35002f;

    /* renamed from: h, reason: collision with root package name */
    private final transient int f35003h;

    /* renamed from: i, reason: collision with root package name */
    private final transient int f35004i;

    @VisibleForTesting
    final transient Object[] table;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableSet(Object[] objArr, int i3, Object[] objArr2, int i16, int i17) {
        this.elements = objArr;
        this.table = objArr2;
        this.f35002f = i16;
        this.f35003h = i3;
        this.f35004i = i17;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.table;
        if (obj == null || objArr == null) {
            return false;
        }
        int c16 = p.c(obj);
        while (true) {
            int i3 = c16 & this.f35002f;
            Object obj2 = objArr[i3];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            c16 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i3) {
        System.arraycopy(this.elements, 0, objArr, i3, this.f35004i);
        return i3 + this.f35004i;
    }

    @Override // com.google.common.collect.ImmutableSet
    ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(this.elements, this.f35004i);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f35003h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.elements;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.f35004i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f35004i;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public ai<E> iterator() {
        return asList().iterator();
    }
}
