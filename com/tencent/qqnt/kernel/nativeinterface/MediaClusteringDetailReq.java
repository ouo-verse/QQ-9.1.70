package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MediaClusteringDetailReq {
    public int count;
    public int seq;
    public String fileSetId = "";
    public ClusteringType type = ClusteringType.values()[0];
    public String clusteringId = "";
    public FileFilterType filterType = FileFilterType.values()[0];
    public byte[] paginationInfo = new byte[0];
    public FlashTransferSceneType sceneType = FlashTransferSceneType.values()[0];

    public String getClusteringId() {
        return this.clusteringId;
    }

    public int getCount() {
        return this.count;
    }

    public String getFileSetId() {
        return this.fileSetId;
    }

    public FileFilterType getFilterType() {
        return this.filterType;
    }

    public byte[] getPaginationInfo() {
        return this.paginationInfo;
    }

    public FlashTransferSceneType getSceneType() {
        return this.sceneType;
    }

    public int getSeq() {
        return this.seq;
    }

    public ClusteringType getType() {
        return this.type;
    }
}
