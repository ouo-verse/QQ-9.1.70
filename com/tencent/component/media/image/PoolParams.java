package com.tencent.component.media.image;

/* loaded from: classes5.dex */
public interface PoolParams {

    /* loaded from: classes5.dex */
    public static class BucketParams {
        public int arraysSize;
        public int bucketMinSize;

        public BucketParams(int i3, int i16) {
            this.bucketMinSize = i3;
            this.arraysSize = i16;
        }
    }

    BucketParams getBucketParams(int i3);

    int getBucketPoolSize();
}
