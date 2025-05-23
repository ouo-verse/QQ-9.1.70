package com.tencent.component.media.image;

import com.tencent.component.media.image.BucketPool;
import com.tencent.component.media.image.PoolParams;
import java.util.LinkedList;

/* loaded from: classes5.dex */
public class ByteArrayPool extends BucketPool<byte[]> {
    public ByteArrayPool(PoolParams poolParams) {
        super(poolParams);
    }

    @Override // com.tencent.component.media.image.BucketPool
    protected BucketPool.Bucket getBuck(PoolParams.BucketParams bucketParams) {
        BucketPool.Bucket bucket = new BucketPool.Bucket();
        int i3 = bucketParams.arraysSize;
        bucket.itemSize = i3;
        bucket.minSize = bucketParams.bucketMinSize;
        bucket.allocCount = i3;
        bucket.dataList = new LinkedList<>();
        return bucket;
    }

    @Override // com.tencent.component.media.image.BucketPool
    protected int handleBucketListEmpty(BucketPool<byte[]>.Bucket<byte[]> bucket) {
        return bucket.minSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.BucketPool
    public void releaseData(byte[] bArr) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.BucketPool
    public byte[] allocData(int i3) {
        return new byte[i3];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.BucketPool
    public int getSizeForData(byte[] bArr) {
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.BucketPool
    public boolean handleRecyleData(BucketPool<byte[]>.Bucket<byte[]> bucket, byte[] bArr) {
        if (bucket.dataList.size() >= bucket.itemSize) {
            return true;
        }
        bucket.dataList.add(bArr);
        return false;
    }
}
