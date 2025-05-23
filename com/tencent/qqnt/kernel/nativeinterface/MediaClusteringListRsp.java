package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MediaClusteringListRsp {
    public boolean isEnd;
    public int pollBatchSeq;
    public int result;
    public int seq;
    public int totalCount;
    public String errMs = "";
    public ClusteringType type = ClusteringType.values()[0];
    public byte[] paginationInfo = new byte[0];
    public ArrayList<Clustering> clusteringList = new ArrayList<>();
    public String fileSetId = "";

    public ArrayList<Clustering> getClusteringList() {
        return this.clusteringList;
    }

    public String getErrMs() {
        return this.errMs;
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

    public int getPollBatchSeq() {
        return this.pollBatchSeq;
    }

    public int getResult() {
        return this.result;
    }

    public int getSeq() {
        return this.seq;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public ClusteringType getType() {
        return this.type;
    }
}
