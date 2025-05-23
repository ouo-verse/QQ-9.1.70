package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LruMemoryCache implements MemoryCache {
    private final LinkedHashMap<String, Bitmap> map;
    private final int maxSize;
    private int size;

    public LruMemoryCache(int i3) {
        if (i3 > 0) {
            this.maxSize = i3;
            this.map = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int sizeOf(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x006f, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void trimToSize(int i3) {
        while (true) {
            synchronized (this) {
                if (this.size >= 0 && (!this.map.isEmpty() || this.size == 0)) {
                    if (this.size <= i3 || this.map.isEmpty()) {
                        break;
                    }
                    Map.Entry<String, Bitmap> next = this.map.entrySet().iterator().next();
                    if (next != null) {
                        String key = next.getKey();
                        Bitmap value = next.getValue();
                        this.map.remove(key);
                        this.size -= sizeOf(key, value);
                    } else {
                        return;
                    }
                } else {
                    break;
                }
            }
        }
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public void clear() {
        trimToSize(-1);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public final Bitmap get(String str) {
        Bitmap bitmap;
        if (str != null) {
            synchronized (this) {
                bitmap = this.map.get(str);
            }
            return bitmap;
        }
        throw new NullPointerException("key == null");
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.map.keySet());
        }
        return hashSet;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public final boolean put(String str, Bitmap bitmap) {
        if (str != null && bitmap != null) {
            synchronized (this) {
                this.size += sizeOf(str, bitmap);
                Bitmap put = this.map.put(str, bitmap);
                if (put != null) {
                    this.size -= sizeOf(str, put);
                }
            }
            trimToSize(this.maxSize);
            return true;
        }
        throw new NullPointerException("key == null || value == null");
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCache
    public final Bitmap remove(String str) {
        Bitmap remove;
        if (str != null) {
            synchronized (this) {
                remove = this.map.remove(str);
                if (remove != null) {
                    this.size -= sizeOf(str, remove);
                }
            }
            return remove;
        }
        throw new NullPointerException("key == null");
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.maxSize));
    }
}
