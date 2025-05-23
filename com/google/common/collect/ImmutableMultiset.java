package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.u;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements u<E> {

    /* renamed from: e, reason: collision with root package name */
    @LazyInit
    private transient ImmutableList<E> f34904e;

    /* renamed from: f, reason: collision with root package name */
    @LazyInit
    private transient ImmutableSet<u.a<E>> f34905f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public final class EntrySet extends IndexedImmutableSet<u.a<E>> {
        private static final long serialVersionUID = 0;

        EntrySet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof u.a)) {
                return false;
            }
            u.a aVar = (u.a) obj;
            if (aVar.getCount() <= 0 || ImmutableMultiset.this.count(aVar.getElement()) != aVar.getCount()) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }

        /* synthetic */ EntrySet(ImmutableMultiset immutableMultiset, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.IndexedImmutableSet
        public u.a<E> get(int i3) {
            return ImmutableMultiset.this.getEntry(i3);
        }
    }

    /* compiled from: P */
    @GwtIncompatible
    /* loaded from: classes2.dex */
    static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends ai<E> {

        /* renamed from: d, reason: collision with root package name */
        int f34906d;

        /* renamed from: e, reason: collision with root package name */
        @MonotonicNonNullDecl
        E f34907e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Iterator f34908f;

        a(Iterator it) {
            this.f34908f = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f34906d <= 0 && !this.f34908f.hasNext()) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f34906d <= 0) {
                u.a aVar = (u.a) this.f34908f.next();
                this.f34907e = (E) aVar.getElement();
                this.f34906d = aVar.getCount();
            }
            this.f34906d--;
            return this.f34907e;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b<E> extends ImmutableCollection.b<E> {

        /* renamed from: a, reason: collision with root package name */
        w<E> f34910a;

        /* renamed from: b, reason: collision with root package name */
        boolean f34911b;

        /* renamed from: c, reason: collision with root package name */
        boolean f34912c;

        public b() {
            this(4);
        }

        @NullableDecl
        static <T> w<T> l(Iterable<T> iterable) {
            if (iterable instanceof RegularImmutableMultiset) {
                return ((RegularImmutableMultiset) iterable).contents;
            }
            if (iterable instanceof AbstractMapBasedMultiset) {
                return ((AbstractMapBasedMultiset) iterable).backingMap;
            }
            return null;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        @CanIgnoreReturnValue
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public b<E> a(E e16) {
            return j(e16, 1);
        }

        @CanIgnoreReturnValue
        public b<E> g(E... eArr) {
            super.b(eArr);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public b<E> h(Iterable<? extends E> iterable) {
            if (iterable instanceof u) {
                u d16 = Multisets.d(iterable);
                w l3 = l(d16);
                if (l3 != null) {
                    w<E> wVar = this.f34910a;
                    wVar.d(Math.max(wVar.C(), l3.C()));
                    for (int e16 = l3.e(); e16 >= 0; e16 = l3.s(e16)) {
                        j(l3.i(e16), l3.k(e16));
                    }
                } else {
                    Set<u.a<E>> entrySet = d16.entrySet();
                    w<E> wVar2 = this.f34910a;
                    wVar2.d(Math.max(wVar2.C(), entrySet.size()));
                    for (u.a<E> aVar : d16.entrySet()) {
                        j(aVar.getElement(), aVar.getCount());
                    }
                }
            } else {
                super.c(iterable);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public b<E> i(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        @CanIgnoreReturnValue
        public b<E> j(E e16, int i3) {
            if (i3 == 0) {
                return this;
            }
            if (this.f34911b) {
                this.f34910a = new w<>(this.f34910a);
                this.f34912c = false;
            }
            this.f34911b = false;
            com.google.common.base.j.m(e16);
            w<E> wVar = this.f34910a;
            wVar.u(e16, i3 + wVar.f(e16));
            return this;
        }

        public ImmutableMultiset<E> k() {
            if (this.f34910a.C() == 0) {
                return ImmutableMultiset.of();
            }
            if (this.f34912c) {
                this.f34910a = new w<>(this.f34910a);
                this.f34912c = false;
            }
            this.f34911b = true;
            return new RegularImmutableMultiset(this.f34910a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i3) {
            this.f34911b = false;
            this.f34912c = false;
            this.f34910a = w.c(i3);
        }
    }

    private static <E> ImmutableMultiset<E> a(E... eArr) {
        return new b().g(eArr).k();
    }

    public static <E> b<E> builder() {
        return new b<>();
    }

    static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends u.a<? extends E>> collection) {
        b bVar = new b(collection.size());
        for (u.a<? extends E> aVar : collection) {
            bVar.j(aVar.getElement(), aVar.getCount());
        }
        return bVar.k();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return a(eArr);
    }

    private ImmutableSet<u.a<E>> d() {
        if (isEmpty()) {
            return ImmutableSet.of();
        }
        return new EntrySet(this, null);
    }

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.EMPTY;
    }

    @Override // com.google.common.collect.u
    @CanIgnoreReturnValue
    @Deprecated
    public final int add(E e16, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.f34904e;
        if (immutableList == null) {
            ImmutableList<E> asList = super.asList();
            this.f34904e = asList;
            return asList;
        }
        return immutableList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        if (count(obj) > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public int copyIntoArray(Object[] objArr, int i3) {
        ai<u.a<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            u.a<E> next = it.next();
            Arrays.fill(objArr, i3, next.getCount() + i3, next.getElement());
            i3 += next.getCount();
        }
        return i3;
    }

    public abstract /* synthetic */ int count(@NullableDecl @CompatibleWith("E") Object obj);

    public abstract ImmutableSet<E> elementSet();

    @Override // java.util.Collection
    public boolean equals(@NullableDecl Object obj) {
        return Multisets.e(this, obj);
    }

    abstract u.a<E> getEntry(int i3);

    @Override // java.util.Collection
    public int hashCode() {
        return ab.b(entrySet());
    }

    @Override // com.google.common.collect.u
    @CanIgnoreReturnValue
    @Deprecated
    public final int remove(Object obj, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.u
    @CanIgnoreReturnValue
    @Deprecated
    public final int setCount(E e16, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    abstract Object writeReplace();

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        b bVar = new b(Multisets.g(iterable));
        bVar.h(iterable);
        return bVar.k();
    }

    public static <E> ImmutableMultiset<E> of(E e16) {
        return a(e16);
    }

    @Override // com.google.common.collect.u
    public ImmutableSet<u.a<E>> entrySet() {
        ImmutableSet<u.a<E>> immutableSet = this.f34905f;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<u.a<E>> d16 = d();
        this.f34905f = d16;
        return d16;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public ai<E> iterator() {
        return new a(entrySet().iterator());
    }

    @Override // com.google.common.collect.u
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean setCount(E e16, int i3, int i16) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E e16, E e17) {
        return a(e16, e17);
    }

    public static <E> ImmutableMultiset<E> of(E e16, E e17, E e18) {
        return a(e16, e17, e18);
    }

    public static <E> ImmutableMultiset<E> of(E e16, E e17, E e18, E e19) {
        return a(e16, e17, e18, e19);
    }

    public static <E> ImmutableMultiset<E> of(E e16, E e17, E e18, E e19, E e26) {
        return a(e16, e17, e18, e19, e26);
    }

    public static <E> ImmutableMultiset<E> of(E e16, E e17, E e18, E e19, E e26, E e27, E... eArr) {
        return new b().a(e16).a(e17).a(e18).a(e19).a(e26).a(e27).g(eArr).k();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        return new b().i(it).k();
    }
}
