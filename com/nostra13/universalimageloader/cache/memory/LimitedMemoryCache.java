package com.nostra13.universalimageloader.cache.memory;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.utils.L;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class LimitedMemoryCache extends BaseMemoryCache {
    private static final int MAX_NORMAL_CACHE_SIZE = 16777216;
    private static final int MAX_NORMAL_CACHE_SIZE_IN_MB = 16;
    private final int sizeLimit;
    private final List<Bitmap> hardCache = Collections.synchronizedList(new LinkedList());
    private final AtomicInteger cacheSize = new AtomicInteger();

    public LimitedMemoryCache(int i3) {
        this.sizeLimit = i3;
        if (i3 > 16777216) {
            L.w("You set too large memory cache size (more than %1$d Mb)", 16);
        }
    }

    @Override // com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCache
    public void clear() {
        this.hardCache.clear();
        this.cacheSize.set(0);
        super.clear();
    }

    protected abstract int getSize(Bitmap bitmap);

    protected int getSizeLimit() {
        return this.sizeLimit;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCache
    public boolean put(String str, Bitmap bitmap) {
        boolean z16;
        int size = getSize(bitmap);
        int sizeLimit = getSizeLimit();
        int i3 = this.cacheSize.get();
        if (size < sizeLimit) {
            while (i3 + size > sizeLimit) {
                Bitmap removeNext = removeNext();
                if (this.hardCache.remove(removeNext)) {
                    i3 = this.cacheSize.addAndGet(-getSize(removeNext));
                }
            }
            this.hardCache.add(bitmap);
            this.cacheSize.addAndGet(size);
            z16 = true;
        } else {
            z16 = false;
        }
        super.put(str, bitmap);
        return z16;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCache
    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null && this.hardCache.remove(bitmap)) {
            this.cacheSize.addAndGet(-getSize(bitmap));
        }
        return super.remove(str);
    }

    protected abstract Bitmap removeNext();
}
