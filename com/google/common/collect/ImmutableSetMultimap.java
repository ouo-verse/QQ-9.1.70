package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.aa;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    @RetainedWith
    @LazyInit
    @MonotonicNonNullDecl
    private transient ImmutableSetMultimap<V, K> C;

    @MonotonicNonNullDecl
    private transient ImmutableSet<Map.Entry<K, V>> D;

    /* renamed from: m, reason: collision with root package name */
    private final transient ImmutableSet<V> f34920m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* renamed from: f, reason: collision with root package name */
        @Weak
        private final transient ImmutableSetMultimap<K, V> f34921f;

        EntrySet(ImmutableSetMultimap<K, V> immutableSetMultimap) {
            this.f34921f = immutableSetMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.f34921f.containsEntry(entry.getKey(), entry.getValue());
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
            return this.f34921f.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public ai<Map.Entry<K, V>> iterator() {
            return this.f34921f.entryIterator();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class a<K, V> extends ImmutableMultimap.c<K, V> {
        @Override // com.google.common.collect.ImmutableMultimap.c
        Collection<V> b() {
            return y.c();
        }

        public ImmutableSetMultimap<K, V> f() {
            Collection entrySet = this.f34899a.entrySet();
            Comparator<? super K> comparator = this.f34900b;
            if (comparator != null) {
                entrySet = Ordering.from(comparator).onKeys().immutableSortedCopy(entrySet);
            }
            return ImmutableSetMultimap.fromMapEntries(entrySet, this.f34901c);
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        @CanIgnoreReturnValue
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public a<K, V> c(K k3, V v3) {
            super.c(k3, v3);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        @CanIgnoreReturnValue
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public a<K, V> d(Map.Entry<? extends K, ? extends V> entry) {
            super.d(entry);
            return this;
        }

        @CanIgnoreReturnValue
        @Beta
        public a<K, V> i(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.e(iterable);
            return this;
        }
    }

    /* compiled from: P */
    @GwtIncompatible
    /* loaded from: classes2.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final aa.b<ImmutableSetMultimap> f34922a = aa.a(ImmutableSetMultimap.class, "emptySet");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i3, @NullableDecl Comparator<? super V> comparator) {
        super(immutableMap, i3);
        this.f34920m = b(comparator);
    }

    private static <K, V> ImmutableSetMultimap<K, V> a(s<? extends K, ? extends V> sVar, Comparator<? super V> comparator) {
        com.google.common.base.j.m(sVar);
        if (sVar.isEmpty() && comparator == null) {
            return of();
        }
        if (sVar instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) sVar;
            if (!immutableSetMultimap.isPartialView()) {
                return immutableSetMultimap;
            }
        }
        return fromMapEntries(sVar.asMap().entrySet(), comparator);
    }

    private static <V> ImmutableSet<V> b(@NullableDecl Comparator<? super V> comparator) {
        if (comparator == null) {
            return ImmutableSet.of();
        }
        return ImmutableSortedSet.emptySet(comparator);
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableSetMultimap<V, K> c() {
        a builder = builder();
        ai it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.c(entry.getValue(), entry.getKey());
        }
        ImmutableSetMultimap<V, K> f16 = builder.f();
        f16.C = this;
        return f16;
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(s<? extends K, ? extends V> sVar) {
        return a(sVar, null);
    }

    private static <V> ImmutableSet<V> d(@NullableDecl Comparator<? super V> comparator, Collection<? extends V> collection) {
        if (comparator == null) {
            return ImmutableSet.copyOf((Collection) collection);
        }
        return ImmutableSortedSet.copyOf((Comparator) comparator, (Collection) collection);
    }

    private static <V> ImmutableSet.a<V> e(@NullableDecl Comparator<? super V> comparator) {
        if (comparator == null) {
            return new ImmutableSet.a<>();
        }
        return new ImmutableSortedSet.a(comparator);
    }

    static <K, V> ImmutableSetMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, @NullableDecl Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        int i3 = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            ImmutableSet d16 = d(comparator, entry.getValue());
            if (!d16.isEmpty()) {
                bVar.c(key, d16);
                i3 += d16.size();
            }
        }
        return new ImmutableSetMultimap<>(bVar.a(), i3, comparator);
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            ImmutableMap.b builder = ImmutableMap.builder();
            int i3 = 0;
            for (int i16 = 0; i16 < readInt; i16++) {
                Object readObject = objectInputStream.readObject();
                int readInt2 = objectInputStream.readInt();
                if (readInt2 > 0) {
                    ImmutableSet.a e16 = e(comparator);
                    for (int i17 = 0; i17 < readInt2; i17++) {
                        e16.a(objectInputStream.readObject());
                    }
                    ImmutableSet l3 = e16.l();
                    if (l3.size() == readInt2) {
                        builder.c(readObject, l3);
                        i3 += readInt2;
                    } else {
                        throw new InvalidObjectException("Duplicate key-value pairs exist for key " + readObject);
                    }
                } else {
                    throw new InvalidObjectException("Invalid value count " + readInt2);
                }
            }
            try {
                ImmutableMultimap.d.f34902a.b(this, builder.a());
                ImmutableMultimap.d.f34903b.a(this, i3);
                b.f34922a.b(this, b(comparator));
                return;
            } catch (IllegalArgumentException e17) {
                throw ((InvalidObjectException) new InvalidObjectException(e17.getMessage()).initCause(e17));
            }
        }
        throw new InvalidObjectException("Invalid key count " + readInt);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(valueComparator());
        aa.d(this, objectOutputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.s
    public /* bridge */ /* synthetic */ ImmutableCollection get(@NullableDecl Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    @NullableDecl
    Comparator<? super V> valueComparator() {
        ImmutableSet<V> immutableSet = this.f34920m;
        if (immutableSet instanceof ImmutableSortedSet) {
            return ((ImmutableSortedSet) immutableSet).comparator();
        }
        return null;
    }

    @Beta
    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a().i(iterable).f();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k3, V v3) {
        a builder = builder();
        builder.c(k3, v3);
        return builder.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.s
    public /* bridge */ /* synthetic */ Collection get(@NullableDecl Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> immutableSetMultimap = this.C;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<V, K> c16 = c();
        this.C = c16;
        return c16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.s
    public /* bridge */ /* synthetic */ Set get(@NullableDecl Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.s
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.D;
        if (immutableSet != null) {
            return immutableSet;
        }
        EntrySet entrySet = new EntrySet(this);
        this.D = entrySet;
        return entrySet;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.s
    public ImmutableSet<V> get(@NullableDecl K k3) {
        return (ImmutableSet) com.google.common.base.f.a((ImmutableSet) this.map.get(k3), this.f34920m);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.s
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableSet<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableSet<V> replaceValues(K k3, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k3, V v3, K k16, V v16) {
        a builder = builder();
        builder.c(k3, v3);
        builder.c(k16, v16);
        return builder.f();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17) {
        a builder = builder();
        builder.c(k3, v3);
        builder.c(k16, v16);
        builder.c(k17, v17);
        return builder.f();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17, K k18, V v18) {
        a builder = builder();
        builder.c(k3, v3);
        builder.c(k16, v16);
        builder.c(k17, v17);
        builder.c(k18, v18);
        return builder.f();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19) {
        a builder = builder();
        builder.c(k3, v3);
        builder.c(k16, v16);
        builder.c(k17, v17);
        builder.c(k18, v18);
        builder.c(k19, v19);
        return builder.f();
    }
}
