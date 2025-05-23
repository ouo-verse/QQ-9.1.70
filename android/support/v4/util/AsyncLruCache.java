package android.support.v4.util;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class AsyncLruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public AsyncLruCache(int i3) {
        if (i3 > 0) {
            this.maxSize = i3;
            this.map = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int safeSizeOf(K k3, V v3) {
        int sizeOf = sizeOf(k3, v3);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException("Negative size: " + k3 + ContainerUtils.KEY_VALUE_DELIMITER + v3);
    }

    public final int cacheCount() {
        LinkedHashMap<K, V> linkedHashMap = this.map;
        if (linkedHashMap != null) {
            return linkedHashMap.size();
        }
        return 0;
    }

    protected V create(K k3) {
        return null;
    }

    public final int createCount() {
        return this.createCount;
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        return this.evictionCount;
    }

    public final V get(K k3) {
        if (k3 != null) {
            V v3 = this.map.get(k3);
            if (v3 != null) {
                this.hitCount++;
                return v3;
            }
            this.missCount++;
            V create = create(k3);
            if (create == null) {
                return null;
            }
            this.createCount++;
            V v16 = (V) this.map.put(k3, create);
            if (v16 != null) {
                this.map.put(k3, v16);
            } else {
                this.size += safeSizeOf(k3, create);
            }
            if (v16 != null) {
                entryRemoved(false, k3, create, v16);
                return v16;
            }
            trimToSize(this.maxSize);
            return create;
        }
        throw new NullPointerException("key == null");
    }

    public final int hitCount() {
        return this.hitCount;
    }

    public final int maxSize() {
        return this.maxSize;
    }

    public final int missCount() {
        return this.missCount;
    }

    public final V put(K k3, V v3) {
        if (k3 != null && v3 != null) {
            this.putCount++;
            this.size += safeSizeOf(k3, v3);
            V put = this.map.put(k3, v3);
            if (put != null) {
                this.size -= safeSizeOf(k3, put);
            }
            if (put != null) {
                entryRemoved(false, k3, put, v3);
            }
            trimToSize(this.maxSize);
            return put;
        }
        throw new NullPointerException("key == null || value == null");
    }

    public final int putCount() {
        return this.putCount;
    }

    public final V remove(K k3) {
        if (k3 != null) {
            V remove = this.map.remove(k3);
            if (remove != null) {
                this.size -= safeSizeOf(k3, remove);
            }
            if (remove != null) {
                entryRemoved(false, k3, remove, null);
            }
            return remove;
        }
        throw new NullPointerException("key == null");
    }

    public final void resetMaxSize(int i3) {
        if (i3 <= 0) {
            return;
        }
        this.maxSize = i3;
    }

    public final int size() {
        return this.size;
    }

    protected int sizeOf(K k3, V v3) {
        return 1;
    }

    public final Map<K, V> snapshot() {
        return new LinkedHashMap(this.map);
    }

    public final String toString() {
        int i3;
        int i16 = this.hitCount;
        int i17 = this.missCount + i16;
        if (i17 != 0) {
            i3 = (i16 * 100) / i17;
        } else {
            i3 = 0;
        }
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i3));
    }

    public void trimToSize(int i3) {
        while (this.size >= 0 && (!this.map.isEmpty() || this.size == 0)) {
            if (this.size > i3 && !this.map.isEmpty()) {
                Map.Entry<K, V> next = this.map.entrySet().iterator().next();
                K key = next.getKey();
                V value = next.getValue();
                this.map.remove(key);
                this.size -= safeSizeOf(key, value);
                this.evictionCount++;
                entryRemoved(true, key, value, null);
            } else {
                return;
            }
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    protected void entryRemoved(boolean z16, K k3, V v3, V v16) {
    }
}
