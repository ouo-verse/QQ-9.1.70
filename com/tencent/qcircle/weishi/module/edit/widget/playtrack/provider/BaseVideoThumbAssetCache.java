package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CMTime;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BaseVideoThumbAssetCache {
    protected final String mAssetId;
    protected long mCacheSize = 0;
    protected LruCache<LRUKey, Integer> mLruCache;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class BitmapPoint {
        public Bitmap bitmap;
        public long time;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BitmapPoint(Bitmap bitmap, long j3) {
            this.bitmap = bitmap;
            this.time = j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class LRUKey {
        public String assetId;
        public long time;

        public LRUKey(String str, long j3) {
            this.assetId = str;
            this.time = j3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            LRUKey lRUKey = (LRUKey) obj;
            if (this.time == lRUKey.time && TextUtils.equals(this.assetId, lRUKey.assetId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.assetId, Long.valueOf(this.time));
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class SeekListResult {
        public int index;
        boolean isNormalized;
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class SeekResult {
        public Bitmap bitmap;
        boolean isNormalized;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SeekResult(Bitmap bitmap, boolean z16) {
            this.bitmap = bitmap;
            this.isNormalized = z16;
        }
    }

    public BaseVideoThumbAssetCache(String str, LruCache<LRUKey, Integer> lruCache) {
        this.mAssetId = str;
        this.mLruCache = lruCache;
    }

    public abstract void addCover(CMTime cMTime, Bitmap bitmap);

    public String getAssetId() {
        return this.mAssetId;
    }

    public long getCacheSize() {
        return this.mCacheSize;
    }

    public abstract SeekResult getCover(long j3);

    public abstract void release();

    public abstract void releaseLowMemory(long j3);
}
