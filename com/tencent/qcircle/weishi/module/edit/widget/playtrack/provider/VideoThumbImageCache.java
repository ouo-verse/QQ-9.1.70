package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbAssetCache;
import com.tencent.tav.coremedia.CMTime;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoThumbImageCache extends BaseVideoThumbAssetCache {
    private Bitmap mBitmap;

    public VideoThumbImageCache(String str, LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> lruCache) {
        super(str, lruCache);
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbAssetCache
    public void addCover(CMTime cMTime, Bitmap bitmap) {
        this.mBitmap = bitmap;
        this.mCacheSize += bitmap.getAllocationByteCount();
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbAssetCache
    public BaseVideoThumbAssetCache.SeekResult getCover(long j3) {
        if (this.mBitmap == null) {
            return new BaseVideoThumbAssetCache.SeekResult(null, false);
        }
        this.mLruCache.get(new BaseVideoThumbAssetCache.LRUKey(this.mAssetId, 0L));
        return new BaseVideoThumbAssetCache.SeekResult(this.mBitmap, false);
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbAssetCache
    public void release() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
            this.mLruCache.remove(new BaseVideoThumbAssetCache.LRUKey(this.mAssetId, 0L));
        }
        this.mCacheSize = 0L;
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbAssetCache
    public void releaseLowMemory(long j3) {
        release();
    }
}
