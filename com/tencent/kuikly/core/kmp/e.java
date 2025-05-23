package com.tencent.kuikly.core.kmp;

import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\n\u0010\bJ\u001a\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H\u0086\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0012\u0010\fJ\u001e\u0010\u0015\u001a\u00020\r2\u0014\u0010\u0014\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R0\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0017j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020 8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010!R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000#8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(R&\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*0#8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010$\u00a8\u0006/"}, d2 = {"Lcom/tencent/kuikly/core/kmp/e;", "K", "V", "", "", "isEmpty", "key", "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "g", "(Ljava/lang/Object;Ljava/lang/Object;)V", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "", "from", "putAll", QCircleLpReportDc05507.KEY_CLEAR, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "internalHashMap", "Lcom/tencent/kuikly/core/kmp/c;", "e", "Lcom/tencent/kuikly/core/kmp/c;", "rwLock", "", "()I", "size", "", "()Ljava/util/Set;", "keys", "", "f", "()Ljava/util/Collection;", "values", "", "c", "entries", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e<K, V> implements Map<K, V>, KMutableMap {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HashMap<K, V> internalHashMap = new HashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final c rwLock = new c();

    public Set<Map.Entry<K, V>> c() {
        int collectionSizeOrDefault;
        Set<Map.Entry<K, V>> mutableSet;
        this.rwLock.a();
        Set<Map.Entry<K, V>> entrySet = this.internalHashMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "internalHashMap.entries");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry it5 = (Map.Entry) it.next();
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            arrayList.add(h.a(it5));
        }
        mutableSet = CollectionsKt___CollectionsKt.toMutableSet(arrayList);
        this.rwLock.b();
        return mutableSet;
    }

    @Override // java.util.Map
    public void clear() {
        this.rwLock.c();
        this.internalHashMap.clear();
        this.rwLock.d();
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        this.rwLock.a();
        boolean containsKey = this.internalHashMap.containsKey(key);
        this.rwLock.b();
        return containsKey;
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        this.rwLock.a();
        boolean containsValue = this.internalHashMap.containsValue(value);
        this.rwLock.b();
        return containsValue;
    }

    public Set<K> d() {
        Set<K> mutableSet;
        this.rwLock.a();
        Set<K> keySet = this.internalHashMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "internalHashMap.keys");
        mutableSet = CollectionsKt___CollectionsKt.toMutableSet(keySet);
        this.rwLock.b();
        return mutableSet;
    }

    public int e() {
        this.rwLock.a();
        int size = this.internalHashMap.size();
        this.rwLock.b();
        return size;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return c();
    }

    public Collection<V> f() {
        List mutableList;
        this.rwLock.a();
        Collection<V> values = this.internalHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "internalHashMap.values");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) values);
        this.rwLock.b();
        return mutableList;
    }

    public final void g(K key, V value) {
        this.rwLock.c();
        this.internalHashMap.put(key, value);
        this.rwLock.d();
    }

    @Override // java.util.Map
    public V get(Object key) {
        this.rwLock.a();
        V v3 = this.internalHashMap.get(key);
        this.rwLock.b();
        return v3;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        this.rwLock.a();
        boolean isEmpty = this.internalHashMap.isEmpty();
        this.rwLock.b();
        return isEmpty;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return d();
    }

    @Override // java.util.Map
    public V put(K key, V value) {
        this.rwLock.c();
        V put = this.internalHashMap.put(key, value);
        this.rwLock.d();
        return put;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.rwLock.c();
        this.internalHashMap.putAll(from);
        this.rwLock.d();
    }

    @Override // java.util.Map
    public V remove(Object key) {
        this.rwLock.c();
        V remove = this.internalHashMap.remove(key);
        this.rwLock.d();
        return remove;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return e();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return f();
    }
}
