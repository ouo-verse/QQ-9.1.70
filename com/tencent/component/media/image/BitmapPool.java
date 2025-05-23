package com.tencent.component.media.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.BitmapUtils;

@TargetApi(19)
/* loaded from: classes5.dex */
public abstract class BitmapPool extends BucketPool<Bitmap> {
    public static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    public static final int BYTES_PER_PIXEL = 4;
    private static final String TAG = "BitmapPool";
    private int hitCount;
    private int missCount;
    private long totalExpectSize;
    private long totalRealSize;

    public BitmapPool(PoolParams poolParams) {
        super(poolParams);
    }

    private static int getBitmapSize(int i3) {
        int i16 = i3 % 4;
        int i17 = i3 / 4;
        if (i16 != 0) {
            return i17 + 1;
        }
        return i17;
    }

    public int getHitCount() {
        return this.hitCount;
    }

    public int getMissCount() {
        return this.missCount;
    }

    public long getTotalExpectSize() {
        return this.totalExpectSize;
    }

    public long getTotalRealSize() {
        return this.totalRealSize;
    }

    @Override // com.tencent.component.media.image.BucketPool
    protected int handleBucketListEmpty(BucketPool<Bitmap>.Bucket<Bitmap> bucket) {
        bucket.allocCount++;
        return bucket.minSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.BucketPool
    public void miss(int i3) {
        this.missCount++;
        ImageManagerEnv.getLogger();
    }

    public abstract void resizeCache(float f16);

    public abstract void trimToSize(float f16);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.component.media.image.BucketPool
    public Bitmap allocData(int i3) {
        return Bitmap.createBitmap(1, getBitmapSize(i3), BITMAP_CONFIG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.BucketPool
    public int getSizeForData(Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.BucketPool
    public boolean handleRecyleData(BucketPool<Bitmap>.Bucket<Bitmap> bucket, Bitmap bitmap) {
        boolean z16;
        int size = bucket.dataList.size();
        int i3 = bucket.itemSize;
        if (size >= i3 || (bucket.allocCount > i3 + 2 && bucket.dataList.size() > (bucket.itemSize / 4) + 1)) {
            z16 = true;
        } else {
            bucket.dataList.add(bitmap);
            z16 = false;
        }
        if (z16) {
            bucket.allocCount--;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.BucketPool
    public void hit(int i3, Bitmap bitmap) {
        this.hitCount++;
        this.totalRealSize += BitmapUtils.getBitmapAllocSize(bitmap);
        this.totalExpectSize += i3;
        ImageManagerEnv.getLogger();
    }

    @Override // com.tencent.component.media.image.BucketPool, com.tencent.component.media.image.Releaser
    public synchronized void release(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        if (bitmap.isMutable()) {
            super.release((BitmapPool) bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.BucketPool
    public void releaseData(Bitmap bitmap) {
        bitmap.recycle();
    }
}
