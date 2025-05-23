package com.tencent.component.media.image;

import android.graphics.Bitmap;
import com.tencent.component.media.image.PoolParams;

/* loaded from: classes5.dex */
public final class ReuseBitmapCacheProxy extends BitmapPool {
    private static final String TAG = "NewBitmapPool";
    ReuseBitmapCache advanceBitmapPool;

    public ReuseBitmapCacheProxy(PoolParams poolParams, int i3) {
        super(new PoolParams() { // from class: com.tencent.component.media.image.ReuseBitmapCacheProxy.1
            @Override // com.tencent.component.media.image.PoolParams
            public PoolParams.BucketParams getBucketParams(int i16) {
                return new PoolParams.BucketParams(1, 1);
            }

            @Override // com.tencent.component.media.image.PoolParams
            public int getBucketPoolSize() {
                return 1;
            }
        });
        this.advanceBitmapPool = ReuseBitmapCache.getInstance(i3);
    }

    @Override // com.tencent.component.media.image.BitmapPool
    public void resizeCache(float f16) {
        ReuseBitmapCache reuseBitmapCache = this.advanceBitmapPool;
        if (reuseBitmapCache != null) {
            reuseBitmapCache.resiezeCache(f16);
        }
    }

    @Override // com.tencent.component.media.image.BitmapPool
    public void trimToSize(float f16) {
        ReuseBitmapCache reuseBitmapCache = this.advanceBitmapPool;
        if (reuseBitmapCache != null) {
            reuseBitmapCache.trimToSize(f16);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.component.media.image.BucketPool
    public synchronized Bitmap get(int i3) {
        Bitmap bitmapFromPool;
        bitmapFromPool = this.advanceBitmapPool.getBitmapFromPool(i3);
        if (bitmapFromPool == null) {
            miss(i3);
        } else {
            hit(i3, bitmapFromPool);
        }
        if (bitmapFromPool == null) {
            bitmapFromPool = allocData(i3);
        }
        return bitmapFromPool;
    }

    @Override // com.tencent.component.media.image.BitmapPool, com.tencent.component.media.image.BucketPool, com.tencent.component.media.image.Releaser
    public synchronized void release(Bitmap bitmap) {
        if (!this.advanceBitmapPool.addBitMapIntoPool(bitmap)) {
            releaseData(bitmap);
        }
    }
}
