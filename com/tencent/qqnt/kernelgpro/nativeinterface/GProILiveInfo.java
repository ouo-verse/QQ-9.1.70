package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProILiveInfo {
    public long anchorUid;
    public long roomId;
    public String programId = "";
    public ArrayList<GProLiveDataItem> metricsData = new ArrayList<>();

    public long getAnchorUid() {
        return this.anchorUid;
    }

    public ArrayList<GProLiveDataItem> getMetricsData() {
        return this.metricsData;
    }

    public String getProgramId() {
        return this.programId;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String toString() {
        return "GProILiveInfo{programId=" + this.programId + ",anchorUid=" + this.anchorUid + ",roomId=" + this.roomId + ",metricsData=" + this.metricsData + ",}";
    }
}
