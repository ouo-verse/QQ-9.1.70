package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAdminAVReqInfo {
    public GProAVDevOptInfo avDevOptInfo;
    public GProAVCommonReqInfo commonInfo;
    public long tinyId;

    public GProAdminAVReqInfo() {
        this.commonInfo = new GProAVCommonReqInfo();
        this.avDevOptInfo = new GProAVDevOptInfo();
    }

    public GProAVDevOptInfo getAvDevOptInfo() {
        return this.avDevOptInfo;
    }

    public GProAVCommonReqInfo getCommonInfo() {
        return this.commonInfo;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public void setAvDevOptInfo(GProAVDevOptInfo gProAVDevOptInfo) {
        this.avDevOptInfo = gProAVDevOptInfo;
    }

    public void setCommonInfo(GProAVCommonReqInfo gProAVCommonReqInfo) {
        this.commonInfo = gProAVCommonReqInfo;
    }

    public void setTinyId(long j3) {
        this.tinyId = j3;
    }

    public String toString() {
        return "GProAdminAVReqInfo{commonInfo=" + this.commonInfo + ",tinyId=" + this.tinyId + ",avDevOptInfo=" + this.avDevOptInfo + ",}";
    }

    public GProAdminAVReqInfo(GProAVCommonReqInfo gProAVCommonReqInfo, long j3, GProAVDevOptInfo gProAVDevOptInfo) {
        this.commonInfo = new GProAVCommonReqInfo();
        new GProAVDevOptInfo();
        this.commonInfo = gProAVCommonReqInfo;
        this.tinyId = j3;
        this.avDevOptInfo = gProAVDevOptInfo;
    }
}
