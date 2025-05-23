package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int i3) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public V create(@NonNull K k3) {
        return null;
    }

    public final synchronized int createCount() {
        return this.createCount;
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    @Nullable
    public final V get(@NonNull K k3) {
        V v3;
        if (k3 != null) {
            synchronized (this) {
                V v16 = this.map.get(k3);
                if (v16 != null) {
                    this.hitCount++;
                    return v16;
                }
                this.missCount++;
                V create = create(k3);
                if (create == null) {
                    return null;
                }
                synchronized (this) {
                    this.createCount++;
                    v3 = (V) this.map.put(k3, create);
                    if (v3 != null) {
                        this.map.put(k3, v3);
                    } else {
                        this.size += safeSizeOf(k3, create);
                    }
                }
                if (v3 != null) {
                    entryRemoved(false, k3, create, v3);
                    return v3;
                }
                trimToSize(this.maxSize);
                return create;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    @Nullable
    public final V put(@NonNull K k3, @NonNull V v3) {
        V put;
        if (k3 != null && v3 != null) {
            synchronized (this) {
                this.putCount++;
                this.size += safeSizeOf(k3, v3);
                put = this.map.put(k3, v3);
                if (put != null) {
                    this.size -= safeSizeOf(k3, put);
                }
            }
            if (put != null) {
                entryRemoved(false, k3, put, v3);
            }
            trimToSize(this.maxSize);
            return put;
        }
        throw new NullPointerException("key == null || value == null");
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    @Nullable
    public final V remove(@NonNull K k3) {
        V remove;
        if (k3 != null) {
            synchronized (this) {
                remove = this.map.remove(k3);
                if (remove != null) {
                    this.size -= safeSizeOf(k3, remove);
                }
            }
            if (remove != null) {
                entryRemoved(false, k3, remove, null);
            }
            return remove;
        }
        throw new NullPointerException("key == null");
    }

    public void resize(int i3) {
        if (i3 > 0) {
            synchronized (this) {
                this.maxSize = i3;
            }
            trimToSize(i3);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final synchronized int size() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int sizeOf(@NonNull K k3, @NonNull V v3) {
        return 1;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.map);
    }

    public final synchronized String toString() {
        int i3;
        int i16 = this.hitCount;
        int i17 = this.missCount + i16;
        if (i17 != 0) {
            i3 = (i16 * 100) / i17;
        } else {
            i3 = 0;
        }
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0071, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void trimToSize(int i3) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.size >= 0 && (!this.map.isEmpty() || this.size == 0)) {
                    if (this.size <= i3 || this.map.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.map.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.map.remove(key);
                    this.size -= safeSizeOf(key, value);
                    this.evictionCount++;
                } else {
                    break;
                }
            }
            entryRemoved(true, key, value, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void entryRemoved(boolean z16, @NonNull K k3, @NonNull V v3, @Nullable V v16) {
    }
}
