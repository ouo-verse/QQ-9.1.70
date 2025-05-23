package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;

/* compiled from: P */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements g<K, V> {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class SerializedForm extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;

        SerializedForm(ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        Object readResolve() {
            return createMap(new a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class a<K, V> extends ImmutableMap.b<K, V> {
        public a() {
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public ImmutableBiMap<K, V> a() {
            if (this.f34887c == 0) {
                return ImmutableBiMap.of();
            }
            f();
            this.f34888d = true;
            return new RegularImmutableBiMap(this.f34886b, this.f34887c);
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public a<K, V> c(K k3, V v3) {
            super.c(k3, v3);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public a<K, V> d(Map.Entry<? extends K, ? extends V> entry) {
            super.d(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        @Beta
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public a<K, V> e(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.e(iterable);
            return this;
        }

        a(int i3) {
            super(i3);
        }
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    @Beta
    public static <K, V> a<K, V> builderWithExpectedSize(int i3) {
        h.b(i3, "expectedSize");
        return new a<>(i3);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    @CanIgnoreReturnValue
    @Deprecated
    public V forcePut(K k3, V v3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.g
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k3, V v3) {
        h.a(k3, v3);
        return new RegularImmutableBiMap(new Object[]{k3, v3}, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k3, V v3, K k16, V v16) {
        h.a(k3, v3);
        h.a(k16, v16);
        return new RegularImmutableBiMap(new Object[]{k3, v3, k16, v16}, 2);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    @Beta
    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4).e(iterable).a();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17) {
        h.a(k3, v3);
        h.a(k16, v16);
        h.a(k17, v17);
        return new RegularImmutableBiMap(new Object[]{k3, v3, k16, v16, k17, v17}, 3);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17, K k18, V v18) {
        h.a(k3, v3);
        h.a(k16, v16);
        h.a(k17, v17);
        h.a(k18, v18);
        return new RegularImmutableBiMap(new Object[]{k3, v3, k16, v16, k17, v17, k18, v18}, 4);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19) {
        h.a(k3, v3);
        h.a(k16, v16);
        h.a(k17, v17);
        h.a(k18, v18);
        h.a(k19, v19);
        return new RegularImmutableBiMap(new Object[]{k3, v3, k16, v16, k17, v17, k18, v18, k19, v19}, 5);
    }
}
