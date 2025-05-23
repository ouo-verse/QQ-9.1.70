package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class Maps {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private enum EntryFunction implements com.google.common.base.d<Map.Entry<?, ?>, Object> {
        KEY { // from class: com.google.common.collect.Maps.EntryFunction.1
            @Override // com.google.common.collect.Maps.EntryFunction, com.google.common.base.d
            @NullableDecl
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE { // from class: com.google.common.collect.Maps.EntryFunction.2
            @Override // com.google.common.collect.Maps.EntryFunction, com.google.common.base.d
            @NullableDecl
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };

        @Override // com.google.common.base.d
        @CanIgnoreReturnValue
        @NullableDecl
        public abstract /* synthetic */ Object apply(@NullableDecl Map.Entry<?, ?> entry);

        /* synthetic */ EntryFunction(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a<K, V> extends af<Map.Entry<K, V>, K> {
        a(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.af
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public K a(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b<K, V> extends af<Map.Entry<K, V>, V> {
        b(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.af
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Map<?, ?> map, @NullableDecl Object obj) {
        return r.h(g(map.entrySet().iterator()), obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Map<?, ?> map, @NullableDecl Object obj) {
        return r.h(p(map.entrySet().iterator()), obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @GwtCompatible(serializable = true)
    public static <K, V> Map.Entry<K, V> d(@NullableDecl K k3, @NullableDecl V v3) {
        return new ImmutableEntry(k3, v3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableMap<E, Integer> e(Collection<E> collection) {
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        Iterator<E> it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            bVar.c(it.next(), Integer.valueOf(i3));
            i3++;
        }
        return bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K> com.google.common.base.d<Map.Entry<K, ?>, K> f() {
        return EntryFunction.KEY;
    }

    static <K, V> Iterator<K> g(Iterator<Map.Entry<K, V>> it) {
        return new a(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NullableDecl
    public static <K> K h(@NullableDecl Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static <K, V> ConcurrentMap<K, V> i() {
        return new ConcurrentHashMap();
    }

    public static <K, V> HashMap<K, V> j() {
        return new HashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> k() {
        return new LinkedHashMap<>();
    }

    public static <K extends Comparable, V> TreeMap<K, V> l() {
        return new TreeMap<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void m(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String n(Map<?, ?> map) {
        StringBuilder b16 = i.b(map.size());
        b16.append('{');
        boolean z16 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z16) {
                b16.append(", ");
            }
            b16.append(entry.getKey());
            b16.append('=');
            b16.append(entry.getValue());
            z16 = false;
        }
        b16.append('}');
        return b16.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> com.google.common.base.d<Map.Entry<?, V>, V> o() {
        return EntryFunction.VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Iterator<V> p(Iterator<Map.Entry<K, V>> it) {
        return new b(it);
    }
}
