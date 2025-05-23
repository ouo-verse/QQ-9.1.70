package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAVReportReqInfo {
    public GProAVCommonReqInfo commonInfo;
    public ArrayList<GProExtInfo> extInfos;
    public long tinyId;
    public GProUserDevState userDevState;

    public GProAVReportReqInfo() {
        this.commonInfo = new GProAVCommonReqInfo();
        this.userDevState = new GProUserDevState();
        this.extInfos = new ArrayList<>();
    }

    public GProAVCommonReqInfo getCommonInfo() {
        return this.commonInfo;
    }

    public ArrayList<GProExtInfo> getExtInfos() {
        return this.extInfos;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public GProUserDevState getUserDevState() {
        return this.userDevState;
    }

    public void setCommonInfo(GProAVCommonReqInfo gProAVCommonReqInfo) {
        this.commonInfo = gProAVCommonReqInfo;
    }

    public void setExtInfos(ArrayList<GProExtInfo> arrayList) {
        this.extInfos = arrayList;
    }

    public void setTinyId(long j3) {
        this.tinyId = j3;
    }

    public void setUserDevState(GProUserDevState gProUserDevState) {
        this.userDevState = gProUserDevState;
    }

    public String toString() {
        return "GProAVReportReqInfo{commonInfo=" + this.commonInfo + ",tinyId=" + this.tinyId + ",userDevState=" + this.userDevState + ",extInfos=" + this.extInfos + ",}";
    }

    public GProAVReportReqInfo(GProAVCommonReqInfo gProAVCommonReqInfo, long j3, GProUserDevState gProUserDevState) {
        this.commonInfo = new GProAVCommonReqInfo();
        this.userDevState = new GProUserDevState();
        this.extInfos = new ArrayList<>();
        this.commonInfo = gProAVCommonReqInfo;
        this.tinyId = j3;
        this.userDevState = gProUserDevState;
    }
}
