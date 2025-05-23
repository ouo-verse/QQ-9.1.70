package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MediaClusteringDetailRsp {
    public boolean isEnd;
    public int result;
    public int seq;
    public String errMs = "";
    public String fileSetId = "";
    public ClusteringType type = ClusteringType.values()[0];
    public String clusteringId = "";
    public byte[] paginationInfo = new byte[0];
    public ArrayList<File> fileLists = new ArrayList<>();
    public MediaClusteringDetailTotalInfo totalInfo = new MediaClusteringDetailTotalInfo();

    public String getClusteringId() {
        return this.clusteringId;
    }

    public String getErrMs() {
        return this.errMs;
    }

    public ArrayList<File> getFileLists() {
        return this.fileLists;
    }

    public String getFileSetId() {
        return this.fileSetId;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public byte[] getPaginationInfo() {
        return this.paginationInfo;
    }

    public int getResult() {
        return this.result;
    }

    public int getSeq() {
        return this.seq;
    }

    public MediaClusteringDetailTotalInfo getTotalInfo() {
        return this.totalInfo;
    }

    public ClusteringType getType() {
        return this.type;
    }
}
