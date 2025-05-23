package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: m, reason: collision with root package name */
    @RetainedWith
    @LazyInit
    private transient ImmutableListMultimap<V, K> f34874m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class a<K, V> extends ImmutableMultimap.c<K, V> {
        public ImmutableListMultimap<K, V> f() {
            return (ImmutableListMultimap) super.a();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i3) {
        super(immutableMap, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableListMultimap<V, K> a() {
        a builder = builder();
        ai it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.c(entry.getValue(), entry.getKey());
        }
        ImmutableListMultimap<V, K> f16 = builder.f();
        f16.f34874m = this;
        return f16;
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(s<? extends K, ? extends V> sVar) {
        if (sVar.isEmpty()) {
            return of();
        }
        if (sVar instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) sVar;
            if (!immutableListMultimap.isPartialView()) {
                return immutableListMultimap;
            }
        }
        return fromMapEntries(sVar.asMap().entrySet(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> ImmutableListMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, @NullableDecl Comparator<? super V> comparator) {
        ImmutableList sortedCopyOf;
        if (collection.isEmpty()) {
            return of();
        }
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        int i3 = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            Collection<? extends V> value = entry.getValue();
            if (comparator == null) {
                sortedCopyOf = ImmutableList.copyOf((Collection) value);
            } else {
                sortedCopyOf = ImmutableList.sortedCopyOf(comparator, value);
            }
            if (!sortedCopyOf.isEmpty()) {
                bVar.c(key, sortedCopyOf);
                i3 += sortedCopyOf.size();
            }
        }
        return new ImmutableListMultimap<>(bVar.a(), i3);
    }

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            ImmutableMap.b builder = ImmutableMap.builder();
            int i3 = 0;
            for (int i16 = 0; i16 < readInt; i16++) {
                Object readObject = objectInputStream.readObject();
                int readInt2 = objectInputStream.readInt();
                if (readInt2 > 0) {
                    ImmutableList.a builder2 = ImmutableList.builder();
                    for (int i17 = 0; i17 < readInt2; i17++) {
                        builder2.a(objectInputStream.readObject());
                    }
                    builder.c(readObject, builder2.j());
                    i3 += readInt2;
                } else {
                    throw new InvalidObjectException("Invalid value count " + readInt2);
                }
            }
            try {
                ImmutableMultimap.d.f34902a.b(this, builder.a());
                ImmutableMultimap.d.f34903b.a(this, i3);
                return;
            } catch (IllegalArgumentException e16) {
                throw ((InvalidObjectException) new InvalidObjectException(e16.getMessage()).initCause(e16));
            }
        }
        throw new InvalidObjectException("Invalid key count " + readInt);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        aa.d(this, objectOutputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.s
    public /* bridge */ /* synthetic */ ImmutableCollection get(@NullableDecl Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k3, V v3) {
        a builder = builder();
        builder.c(k3, v3);
        return builder.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.s
    public /* bridge */ /* synthetic */ Collection get(@NullableDecl Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> immutableListMultimap = this.f34874m;
        if (immutableListMultimap != null) {
            return immutableListMultimap;
        }
        ImmutableListMultimap<V, K> a16 = a();
        this.f34874m = a16;
        return a16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.s
    public /* bridge */ /* synthetic */ List get(@NullableDecl Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ List replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.s
    public ImmutableList<V> get(@NullableDecl K k3) {
        ImmutableList<V> immutableList = (ImmutableList) this.map.get(k3);
        return immutableList == null ? ImmutableList.of() : immutableList;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.s
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableList<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableList<V> replaceValues(K k3, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k3, V v3, K k16, V v16) {
        a builder = builder();
        builder.c(k3, v3);
        builder.c(k16, v16);
        return builder.f();
    }

    @Beta
    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a().i(iterable).f();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17) {
        a builder = builder();
        builder.c(k3, v3);
        builder.c(k16, v16);
        builder.c(k17, v17);
        return builder.f();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17, K k18, V v18) {
        a builder = builder();
        builder.c(k3, v3);
        builder.c(k16, v16);
        builder.c(k17, v17);
        builder.c(k18, v18);
        return builder.f();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19) {
        a builder = builder();
        builder.c(k3, v3);
        builder.c(k16, v16);
        builder.c(k17, v17);
        builder.c(k18, v18);
        builder.c(k19, v19);
        return builder.f();
    }
}
