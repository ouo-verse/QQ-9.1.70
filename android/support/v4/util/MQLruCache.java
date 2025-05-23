package android.support.v4.util;

import android.util.Pair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class MQLruCache<K, O> {
    public static final byte HIGH = 2;
    public static final byte LOW = 0;
    private static final byte MAX_QUEUE = 3;
    public static final byte NORMAL = 1;
    private static final int RISE_PRIORITY_COUNT = 128;
    private int LARGE_SIZE = -1;
    private final HashSet<K> largeSizeItem = new HashSet<>();
    private int[] maxSizes;
    private AsyncLruCache<K, MQLruCache<K, O>.CacheItem>[] mqCaches;
    private ArrayList<Pair<K, MQLruCache<K, O>.CacheItem>>[] oldValues;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class CacheItem {
        public int hitCount = 0;
        public byte priority;
        public O value;

        public CacheItem(O o16, byte b16) {
            this.value = o16;
            this.priority = b16;
        }
    }

    public MQLruCache(int i3) {
        this.mqCaches = null;
        this.oldValues = null;
        this.maxSizes = null;
        if (i3 > 0) {
            this.mqCaches = new AsyncLruCache[3];
            this.oldValues = new ArrayList[3];
            this.maxSizes = r1;
            int[] iArr = {(i3 * 5) / 10, (i3 * 4) / 10, (i3 * 1) / 10};
            for (final int i16 = 0; i16 < 3; i16++) {
                this.oldValues[i16] = new ArrayList<>();
                this.mqCaches[i16] = new AsyncLruCache<K, MQLruCache<K, O>.CacheItem>(this.maxSizes[i16]) { // from class: android.support.v4.util.MQLruCache.1
                    @Override // android.support.v4.util.AsyncLruCache
                    protected /* bridge */ /* synthetic */ void entryRemoved(boolean z16, Object obj, Object obj2, Object obj3) {
                        entryRemoved(z16, (boolean) obj, (MQLruCache<boolean, O>.CacheItem) obj2, (MQLruCache<boolean, O>.CacheItem) obj3);
                    }

                    @Override // android.support.v4.util.AsyncLruCache
                    protected /* bridge */ /* synthetic */ int sizeOf(Object obj, Object obj2) {
                        return sizeOf((AnonymousClass1) obj, (MQLruCache<AnonymousClass1, O>.CacheItem) obj2);
                    }

                    protected void entryRemoved(boolean z16, K k3, MQLruCache<K, O>.CacheItem cacheItem, MQLruCache<K, O>.CacheItem cacheItem2) {
                        if (z16 && i16 > 0) {
                            MQLruCache.this.oldValues[i16].add(Pair.create(k3, cacheItem));
                        } else {
                            MQLruCache.this.entryObjRemoved(z16, k3, cacheItem != null ? cacheItem.value : null, cacheItem2 != null ? cacheItem2.value : null);
                        }
                        if (MQLruCache.this.largeSizeItem.size() <= 0 || !MQLruCache.this.largeSizeItem.contains(k3)) {
                            return;
                        }
                        MQLruCache.this.largeSizeItem.remove(k3);
                    }

                    protected int sizeOf(K k3, MQLruCache<K, O>.CacheItem cacheItem) {
                        int sizeOfObj = MQLruCache.this.sizeOfObj(k3, cacheItem.value);
                        if (MQLruCache.this.LARGE_SIZE > 0 && sizeOfObj >= MQLruCache.this.LARGE_SIZE && !MQLruCache.this.largeSizeItem.contains(k3)) {
                            MQLruCache.this.largeSizeItem.add(k3);
                            MQLruCache.this.warningLargeItem(k3, sizeOfObj);
                        }
                        return sizeOfObj;
                    }
                };
            }
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final synchronized int cacheCount() {
        int i3;
        i3 = 0;
        for (int i16 = 0; i16 < 3; i16++) {
            i3 += this.mqCaches[i16].cacheCount();
        }
        return i3;
    }

    public final synchronized void evict(int i3) {
        for (int i16 = 0; i16 <= i3 && i16 < 3; i16++) {
            this.mqCaches[i16].evictAll();
            this.oldValues[i16].clear();
        }
    }

    public final synchronized void evictAll() {
        for (int i3 = 0; i3 < 3; i3++) {
            this.mqCaches[i3].evictAll();
            this.oldValues[i3].clear();
        }
    }

    public final synchronized O get(K k3) {
        MQLruCache<K, O>.CacheItem cacheItem = null;
        int i3 = 0;
        while (true) {
            if (i3 > 2) {
                break;
            }
            try {
                cacheItem = this.mqCaches[i3].get(k3);
                if (cacheItem != null) {
                    int i16 = cacheItem.hitCount + 1;
                    cacheItem.hitCount = i16;
                    if (i16 >= 128 && cacheItem.priority < 2) {
                        this.mqCaches[i3].remove(k3);
                        cacheItem.priority = (byte) (cacheItem.priority + 1);
                        cacheItem.hitCount = 0;
                        put((MQLruCache<K, O>) k3, (MQLruCache<MQLruCache<K, O>, O>.CacheItem) cacheItem);
                    }
                } else {
                    i3++;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        if (cacheItem == null) {
            return null;
        }
        return cacheItem.value;
    }

    public synchronized ArrayList<K> getLargeCache() {
        ArrayList<K> arrayList;
        arrayList = new ArrayList<>();
        Iterator<K> it = this.largeSizeItem.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public final synchronized int hitCount() {
        int i3;
        i3 = 0;
        for (int i16 = 0; i16 < 3; i16++) {
            i3 += this.mqCaches[i16].hitCount();
        }
        return i3;
    }

    public final synchronized int maxSize() {
        int i3;
        i3 = 0;
        for (int i16 = 0; i16 < 3; i16++) {
            i3 += this.mqCaches[i16].maxSize();
        }
        return i3;
    }

    public final synchronized int missCount() {
        int i3;
        i3 = 0;
        for (int i16 = 0; i16 < 3; i16++) {
            i3 += this.mqCaches[i16].missCount();
        }
        return i3;
    }

    public O put(K k3, O o16) {
        return put((MQLruCache<K, O>) k3, (MQLruCache<MQLruCache<K, O>, O>.CacheItem) new CacheItem(o16, (byte) 1));
    }

    public synchronized void releaseLargeCache() {
        if (this.largeSizeItem.size() == 0) {
            return;
        }
        ArrayList<K> largeCache = getLargeCache();
        for (int i3 = 0; i3 < largeCache.size(); i3++) {
            remove(largeCache.get(i3));
        }
        this.largeSizeItem.clear();
    }

    public final synchronized O remove(K k3) {
        MQLruCache<K, O>.CacheItem cacheItem = null;
        for (int i3 = 0; i3 < 3; i3++) {
            try {
                cacheItem = this.mqCaches[i3].remove(k3);
                if (cacheItem != null) {
                    break;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        if (cacheItem == null) {
            return null;
        }
        return cacheItem.value;
    }

    public final synchronized void resetMaxSize(float f16) {
        if (f16 <= 0.0f) {
            return;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            int i16 = (int) (r1[i3] * f16);
            this.maxSizes[i3] = i16;
            this.mqCaches[i3].resetMaxSize(i16);
        }
    }

    public void setLargeSize(int i3) {
        this.LARGE_SIZE = i3;
        if (i3 <= 0) {
            this.largeSizeItem.clear();
        }
    }

    public final synchronized int size() {
        int i3;
        i3 = 0;
        for (int i16 = 0; i16 < 3; i16++) {
            i3 += this.mqCaches[i16].size();
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int sizeOfObj(K k3, O o16) {
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized Map<K, O> snapshot() {
        LinkedHashMap linkedHashMap;
        linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (int i3 = 0; i3 < 3; i3++) {
            linkedHashMap2.putAll(this.mqCaches[i3].snapshot());
        }
        for (Map.Entry entry : linkedHashMap2.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((CacheItem) entry.getValue()).value);
        }
        return linkedHashMap;
    }

    public final synchronized void trimToSize(int i3) {
        int size = size();
        if (size <= i3) {
            return;
        }
        int i16 = size - i3;
        int i17 = 0;
        while (true) {
            int size2 = this.mqCaches[i17].size();
            if (size2 >= i16) {
                this.mqCaches[i17].trimToSize(size2 - i16);
                break;
            }
            this.mqCaches[i17].trimToSize(0);
            i16 -= size2;
            i17++;
            if (i16 <= 0 || i17 >= 3) {
                break;
            }
        }
        this.oldValues[0].clear();
        this.oldValues[1].clear();
        this.oldValues[2].clear();
    }

    public O put(K k3, O o16, byte b16) {
        if (b16 < 0 || b16 > 2) {
            b16 = 0;
        }
        return put((MQLruCache<K, O>) k3, (MQLruCache<MQLruCache<K, O>, O>.CacheItem) new CacheItem(o16, b16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final synchronized O put(K k3, MQLruCache<K, O>.CacheItem cacheItem) {
        byte b16 = cacheItem.priority;
        for (int i3 = 0; i3 < 3 && (i3 == b16 || this.mqCaches[i3].remove(k3) == null); i3++) {
        }
        this.mqCaches[b16].put(k3, cacheItem);
        while (b16 > 0 && this.oldValues[b16].size() > 0) {
            for (int i16 = 0; i16 < this.oldValues[b16].size(); i16++) {
                Pair<K, MQLruCache<K, O>.CacheItem> pair = this.oldValues[b16].get(i16);
                Object obj = pair.second;
                ((CacheItem) obj).priority = (byte) (r4.priority - 1);
                ((CacheItem) obj).hitCount = 0;
                this.mqCaches[((CacheItem) obj).priority].put(pair.first, obj);
            }
            this.oldValues[b16].clear();
            b16 = (byte) (b16 - 1);
        }
        return cacheItem.value;
    }

    public void warningLargeItem(K k3, int i3) {
    }

    protected void entryObjRemoved(boolean z16, K k3, O o16, O o17) {
    }
}
