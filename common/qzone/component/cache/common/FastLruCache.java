package common.qzone.component.cache.common;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class FastLruCache<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final int f390047a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<K, V> f390048b;

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<K, a<K, V>> f390049c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private ReferenceQueue<V> f390050d = new ReferenceQueue<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a<K, V> extends WeakReference<V> {

        /* renamed from: a, reason: collision with root package name */
        K f390051a;

        public a(K k3, V v3, ReferenceQueue<V> referenceQueue) {
            super(v3, referenceQueue);
            this.f390051a = k3;
        }
    }

    public FastLruCache(final int i3) {
        if (i3 > 0) {
            this.f390047a = i3;
            this.f390048b = new LinkedHashMap<K, V>(16, 0.75f, true) { // from class: common.qzone.component.cache.common.FastLruCache.1
                @Override // java.util.LinkedHashMap
                protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
                    if (size() > i3) {
                        return true;
                    }
                    return false;
                }
            };
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void a() {
        a aVar = (a) this.f390050d.poll();
        while (aVar != null) {
            this.f390049c.remove(aVar.f390051a);
            aVar = (a) this.f390050d.poll();
        }
    }

    public final synchronized V b(K k3) {
        V v3;
        a();
        V v16 = this.f390048b.get(k3);
        if (v16 != null) {
            return v16;
        }
        a<K, V> aVar = this.f390049c.get(k3);
        if (aVar == null) {
            v3 = null;
        } else {
            v3 = aVar.get();
        }
        return v3;
    }

    public final synchronized V c(K k3, V v3) {
        V v16;
        a();
        this.f390048b.put(k3, v3);
        a<K, V> put = this.f390049c.put(k3, new a<>(k3, v3, this.f390050d));
        if (put == null) {
            v16 = null;
        } else {
            v16 = put.get();
        }
        return v16;
    }
}
