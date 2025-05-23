package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.u;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final RegularImmutableMultiset<Object> EMPTY = new RegularImmutableMultiset<>(w.b());
    final transient w<E> contents;

    /* renamed from: h, reason: collision with root package name */
    private final transient int f35000h;

    /* renamed from: i, reason: collision with root package name */
    @LazyInit
    private transient ImmutableSet<E> f35001i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public final class ElementSet extends IndexedImmutableSet<E> {
        ElementSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        E get(int i3) {
            return RegularImmutableMultiset.this.contents.i(i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableMultiset.this.contents.C();
        }
    }

    /* compiled from: P */
    @GwtIncompatible
    /* loaded from: classes2.dex */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        SerializedForm(u<?> uVar) {
            int size = uVar.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i3 = 0;
            for (u.a<?> aVar : uVar.entrySet()) {
                this.elements[i3] = aVar.getElement();
                this.counts[i3] = aVar.getCount();
                i3++;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        Object readResolve() {
            ImmutableMultiset.b bVar = new ImmutableMultiset.b(this.elements.length);
            int i3 = 0;
            while (true) {
                Object[] objArr = this.elements;
                if (i3 < objArr.length) {
                    bVar.j(objArr[i3], this.counts[i3]);
                    i3++;
                } else {
                    return bVar.k();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableMultiset(w<E> wVar) {
        this.contents = wVar;
        long j3 = 0;
        for (int i3 = 0; i3 < wVar.C(); i3++) {
            j3 += wVar.k(i3);
        }
        this.f35000h = s1.c.b(j3);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.u
    public int count(@NullableDecl Object obj) {
        return this.contents.f(obj);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    u.a<E> getEntry(int i3) {
        return this.contents.g(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.u
    public int size() {
        return this.f35000h;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    Object writeReplace() {
        return new SerializedForm(this);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.u
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.f35001i;
        if (immutableSet != null) {
            return immutableSet;
        }
        ElementSet elementSet = new ElementSet();
        this.f35001i = elementSet;
        return elementSet;
    }
}
