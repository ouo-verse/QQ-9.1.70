package com.tencent.component.media.image;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.component.media.utils.LruCache;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/* loaded from: classes5.dex */
public class ReuseBitmapPool {
    public static final String TAG = "NewBucketPool";
    private LruCache<Integer, Bitmap> bitmapItemSetLruCache;
    private TreeMap<Integer, List<Integer>> bitmapKeySet = new TreeMap<>();
    private int limit;
    private int maxSizePerKey;

    public ReuseBitmapPool(int i3, int i16, int i17) {
        this.limit = i16;
        this.maxSizePerKey = Math.min(i3, i17);
        if (i3 <= 0) {
            ImageManagerLog.w(TAG, "ReuseBitmapPool maxSize<=0:" + i3);
            i3 = 1;
        }
        this.bitmapItemSetLruCache = new LruCache<Integer, Bitmap>(i3) { // from class: com.tencent.component.media.image.ReuseBitmapPool.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.component.media.utils.LruCache
            public synchronized void entryRemoved(boolean z16, Integer num, Bitmap bitmap, Bitmap bitmap2) {
                super.entryRemoved(z16, (boolean) num, bitmap, bitmap2);
                if (z16) {
                    int bitmapAllocSize = BitmapUtils.getBitmapAllocSize(bitmap);
                    List list = (List) ReuseBitmapPool.this.bitmapKeySet.get(Integer.valueOf(bitmapAllocSize));
                    if (list == null) {
                        ImageManagerEnv.getLogger();
                        return;
                    }
                    list.remove(num);
                    if (list.isEmpty()) {
                        ReuseBitmapPool.this.bitmapKeySet.remove(Integer.valueOf(bitmapAllocSize));
                    }
                    ImageManagerEnv.getLogger();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.component.media.utils.LruCache
            public int sizeOf(Integer num, Bitmap bitmap) {
                return BitmapUtils.getBitmapAllocSize(bitmap);
            }
        };
    }

    private boolean addIntoPoolInternal(Bitmap bitmap) {
        Integer ceilingKey;
        int bitmapAllocSize = BitmapUtils.getBitmapAllocSize(bitmap);
        if (bitmapAllocSize <= this.limit && bitmapAllocSize > 0) {
            if (this.bitmapItemSetLruCache.size() + bitmapAllocSize > this.bitmapItemSetLruCache.maxSize() && (ceilingKey = this.bitmapKeySet.ceilingKey(Integer.valueOf(bitmapAllocSize))) != null && ceilingKey.intValue() * 0.8d < bitmapAllocSize) {
                ImageManagerEnv.getLogger();
                return false;
            }
            List<Integer> list = this.bitmapKeySet.get(Integer.valueOf(bitmapAllocSize));
            if (list == null) {
                list = Collections.synchronizedList(new LinkedList());
                this.bitmapKeySet.put(Integer.valueOf(bitmapAllocSize), list);
            }
            if (list.size() * bitmapAllocSize > this.maxSizePerKey) {
                ImageManagerEnv.getLogger();
                return false;
            }
            Integer valueOf = Integer.valueOf(bitmap.hashCode());
            list.add(valueOf);
            this.bitmapItemSetLruCache.put(valueOf, bitmap);
            return true;
        }
        ImageManagerEnv.getLogger();
        return false;
    }

    private Bitmap removeFromPoolInternal(Integer num) {
        Bitmap bitmap;
        List<Integer> list = this.bitmapKeySet.get(num);
        if (list != null && !list.isEmpty()) {
            bitmap = this.bitmapItemSetLruCache.remove(list.remove(list.size() - 1));
        } else {
            bitmap = null;
        }
        if (list.isEmpty()) {
            this.bitmapKeySet.remove(num);
        }
        return bitmap;
    }

    public synchronized boolean addBitMapIntoPool(Bitmap bitmap) {
        return addIntoPoolInternal(bitmap);
    }

    public synchronized Bitmap getBitmapFromPool(int i3) {
        Integer ceilingKey = this.bitmapKeySet.ceilingKey(Integer.valueOf(i3));
        Bitmap bitmap = null;
        if (ceilingKey == null) {
            ImageManagerEnv.getLogger();
            return null;
        }
        if (ceilingKey.intValue() > i3 * 2) {
            ImageManagerEnv.getLogger();
            return null;
        }
        try {
            bitmap = removeFromPoolInternal(ceilingKey);
        } catch (Throwable th5) {
            ImageManagerLog.e(TAG, Log.getStackTraceString(th5));
        }
        if (bitmap != null) {
            ImageManagerEnv.getLogger();
        }
        return bitmap;
    }

    public void resizeCahce(float f16) {
        BitmapUtils.resize(this.bitmapItemSetLruCache, f16);
    }

    public void trimToSize(float f16) {
        BitmapUtils.trimToSize(this.bitmapItemSetLruCache, f16);
    }
}
