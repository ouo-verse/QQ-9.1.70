package com.tencent.component.media.image;

import com.tencent.component.media.image.PoolParams;
import java.util.LinkedList;

/* loaded from: classes5.dex */
public abstract class BucketPool<T> implements Releaser<T> {
    private static final String TAG = "BucketPool";
    private static int[] dat = new int[30];
    private int bucketSize;
    private Bucket[] buckets;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class Bucket<T> {
        int allocCount;
        LinkedList<T> dataList;
        int itemSize;
        int minSize;
        int releaseCount = 0;
        int getCount = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Bucket() {
        }
    }

    public BucketPool(PoolParams poolParams) {
        int i3 = 0;
        this.bucketSize = 0;
        int bucketPoolSize = poolParams.getBucketPoolSize();
        this.bucketSize = bucketPoolSize;
        if (bucketPoolSize > 0) {
            this.buckets = new Bucket[bucketPoolSize];
            PoolParams.BucketParams bucketParams = null;
            while (i3 < this.bucketSize) {
                PoolParams.BucketParams bucketParams2 = poolParams.getBucketParams(i3);
                checkByteArrayParams(bucketParams2, bucketParams);
                this.buckets[i3] = getBuck(bucketParams2);
                i3++;
                bucketParams = bucketParams2;
            }
            return;
        }
        throw new RuntimeException("bucket size <= 0 !!");
    }

    private static void checkByteArrayParams(PoolParams.BucketParams bucketParams, PoolParams.BucketParams bucketParams2) {
        int i3;
        int i16;
        if (bucketParams.arraysSize > 0 && (i3 = bucketParams.bucketMinSize) > 0) {
            if (bucketParams2 != null) {
                i16 = bucketParams2.bucketMinSize;
            } else {
                i16 = 0;
            }
            if (i16 < i3) {
                return;
            }
            throw new RuntimeException("byteArrayParams.minSize can not smaller than pre " + i16 + ", bucketMinSize " + bucketParams.bucketMinSize);
        }
        throw new RuntimeException("byteArrayParams is wrong ");
    }

    protected abstract T allocData(int i3);

    public synchronized T get(int i3) {
        T t16;
        int i16;
        int i17 = 0;
        while (true) {
            if (i17 < this.bucketSize) {
                BucketPool<T>.Bucket<T> bucket = this.buckets[i17];
                if (bucket.minSize >= i3) {
                    t16 = bucket.dataList.poll();
                    if (t16 == null) {
                        i16 = handleBucketListEmpty(bucket);
                    }
                } else {
                    i17++;
                }
            } else {
                t16 = null;
                break;
            }
        }
        i16 = i3;
        if (t16 == null) {
            t16 = allocData(i16);
            miss(i3);
        } else {
            hit(i3, t16);
        }
        return t16;
    }

    protected Bucket getBuck(PoolParams.BucketParams bucketParams) {
        Bucket bucket = new Bucket();
        int i3 = bucketParams.arraysSize;
        bucket.itemSize = i3;
        bucket.minSize = bucketParams.bucketMinSize;
        bucket.allocCount = i3;
        bucket.dataList = new LinkedList<>();
        for (int i16 = 0; i16 < bucket.itemSize; i16++) {
            bucket.dataList.add(allocData(bucket.minSize));
        }
        return bucket;
    }

    protected abstract int getSizeForData(T t16);

    protected abstract int handleBucketListEmpty(BucketPool<T>.Bucket<T> bucket);

    protected abstract boolean handleRecyleData(BucketPool<T>.Bucket<T> bucket, T t16);

    @Override // com.tencent.component.media.image.Releaser
    public synchronized void release(T t16) {
        if (t16 == null) {
            return;
        }
        int sizeForData = getSizeForData(t16);
        boolean z16 = true;
        int i3 = this.bucketSize - 1;
        while (true) {
            if (i3 < 0) {
                break;
            }
            BucketPool<T>.Bucket<T> bucket = this.buckets[i3];
            int i16 = bucket.minSize;
            if (sizeForData > i16 + 2500) {
                releaseData(t16);
                return;
            } else {
                if (sizeForData >= i16) {
                    z16 = handleRecyleData(bucket, t16);
                    break;
                }
                i3--;
            }
        }
        if (z16) {
            releaseData(t16);
        }
    }

    protected abstract void releaseData(T t16);

    protected void miss(int i3) {
    }

    protected void hit(int i3, T t16) {
    }
}
