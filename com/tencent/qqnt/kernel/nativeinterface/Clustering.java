package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class Clustering {
    public int clusteringNum;
    public String fileSetId = "";
    public String clusteringId = "";
    public Picture thumbnail = new Picture();
    public String name = "";

    public String getClusteringId() {
        return this.clusteringId;
    }

    public int getClusteringNum() {
        return this.clusteringNum;
    }

    public String getFileSetId() {
        return this.fileSetId;
    }

    public String getName() {
        return this.name;
    }

    public Picture getThumbnail() {
        return this.thumbnail;
    }
}
