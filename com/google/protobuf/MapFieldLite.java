package com.google.protobuf;

import com.google.protobuf.ad;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: d, reason: collision with root package name */
    private static final MapFieldLite f35588d;
    private boolean isMutable;

    static {
        MapFieldLite mapFieldLite = new MapFieldLite();
        f35588d = mapFieldLite;
        mapFieldLite.makeImmutable();
    }

    MapFieldLite() {
        this.isMutable = true;
    }

    private static int c(Object obj) {
        if (obj instanceof byte[]) {
            return ad.d((byte[]) obj);
        }
        if (!(obj instanceof ad.c)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int calculateHashCodeForMap(Map<K, V> map) {
        int i3 = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            i3 += c(entry.getValue()) ^ c(entry.getKey());
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> Map<K, V> copy(Map<K, V> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), e(entry.getValue()));
        }
        return linkedHashMap;
    }

    private static void d(Map<?, ?> map) {
        for (Object obj : map.keySet()) {
            ad.a(obj);
            ad.a(map.get(obj));
        }
    }

    private static Object e(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            return Arrays.copyOf(bArr, bArr.length);
        }
        return obj;
    }

    public static <K, V> MapFieldLite<K, V> emptyMapField() {
        return f35588d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> boolean equals(Map<K, V> map, Map<K, V> map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !h(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private void f() {
        if (isMutable()) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private static boolean h(Object obj, Object obj2) {
        if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        return obj.equals(obj2);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        return super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return calculateHashCodeForMap(this);
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public void mergeFrom(MapFieldLite<K, V> mapFieldLite) {
        f();
        if (!mapFieldLite.isEmpty()) {
            putAll(mapFieldLite);
        }
    }

    public MapFieldLite<K, V> mutableCopy() {
        if (isEmpty()) {
            return new MapFieldLite<>();
        }
        return new MapFieldLite<>(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K k3, V v3) {
        f();
        ad.a(k3);
        ad.a(v3);
        return (V) super.put(k3, v3);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        f();
        d(map);
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        return (V) super.remove(obj);
    }

    MapFieldLite(Map<K, V> map) {
        super(map);
        this.isMutable = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && equals(this, (Map) obj);
    }

    public V put(Map.Entry<K, V> entry) {
        return put(entry.getKey(), entry.getValue());
    }
}
