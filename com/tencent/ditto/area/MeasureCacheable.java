package com.tencent.ditto.area;

import android.support.v4.util.LruCache;
import com.tencent.ditto.utils.DittoLog;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MeasureCacheable {
    public static final LruCache<CanvasMeasureCacheKey, TextMeasureCacheItem> mMeasureCache = new LruCache<>(2048);

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class CanvasMeasureCacheKey {
        public Integer cacheKey;
        public int keyHeightMeasureSpec;
        public int keyWidthMeasureSpec;

        public CanvasMeasureCacheKey(Integer num, int i3, int i16) {
            this.cacheKey = num;
            this.keyWidthMeasureSpec = i3;
            this.keyHeightMeasureSpec = i16;
        }

        public boolean equals(Object obj) {
            Integer num;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CanvasMeasureCacheKey)) {
                return false;
            }
            CanvasMeasureCacheKey canvasMeasureCacheKey = (CanvasMeasureCacheKey) obj;
            if (this.keyWidthMeasureSpec == canvasMeasureCacheKey.keyWidthMeasureSpec && this.keyHeightMeasureSpec == canvasMeasureCacheKey.keyHeightMeasureSpec && (num = this.cacheKey) != null && num.equals(canvasMeasureCacheKey.cacheKey)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.cacheKey.hashCode();
            int i3 = hashCode + (hashCode * 17) + this.keyWidthMeasureSpec;
            return i3 + (i3 * 17) + this.keyHeightMeasureSpec;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class TextMeasureCacheItem {
        public int keyHeightMeasureSpec;
        public int keyWidthMeasureSpec;
        public int measureHeight;
        public int measuredWidth;
    }

    public static void removeMeasureCache(Integer num) {
        if (num == null) {
            return;
        }
        Iterator<Map.Entry<CanvasMeasureCacheKey, TextMeasureCacheItem>> it = mMeasureCache.snapshot().entrySet().iterator();
        while (it.hasNext()) {
            CanvasMeasureCacheKey key = it.next().getKey();
            if (key != null && num.equals(key.cacheKey)) {
                mMeasureCache.remove(key);
            }
        }
    }

    public void addMeasureCache(Integer num, int i3, int i16, TextMeasureCacheItem textMeasureCacheItem) {
        if (textMeasureCacheItem != null && num != null) {
            mMeasureCache.put(new CanvasMeasureCacheKey(num, i3, i16), textMeasureCacheItem);
        }
    }

    public TextMeasureCacheItem getMeasureCache(Integer num, int i3, int i16) {
        if (num == null) {
            return null;
        }
        try {
            return mMeasureCache.get(new CanvasMeasureCacheKey(num, i3, i16));
        } catch (Exception e16) {
            DittoLog.e(DittoLog.defaultTag, "", e16);
            return null;
        }
    }
}
