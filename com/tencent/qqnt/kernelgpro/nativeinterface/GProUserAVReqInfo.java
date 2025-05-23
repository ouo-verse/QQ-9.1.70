package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProUserAVReqInfo {
    public GProAVCommonReqInfo commonInfo;
    public GProAVDevOptInfo devOpt;
    public ArrayList<GProExtInfo> extInfos;
    public long tinyId;

    public GProUserAVReqInfo() {
        this.commonInfo = new GProAVCommonReqInfo();
        this.devOpt = new GProAVDevOptInfo();
        this.extInfos = new ArrayList<>();
    }

    public GProAVCommonReqInfo getCommonInfo() {
        return this.commonInfo;
    }

    public GProAVDevOptInfo getDevOpt() {
        return this.devOpt;
    }

    public ArrayList<GProExtInfo> getExtInfos() {
        return this.extInfos;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public void setCommonInfo(GProAVCommonReqInfo gProAVCommonReqInfo) {
        this.commonInfo = gProAVCommonReqInfo;
    }

    public void setDevOpt(GProAVDevOptInfo gProAVDevOptInfo) {
        this.devOpt = gProAVDevOptInfo;
    }

    public void setExtInfos(ArrayList<GProExtInfo> arrayList) {
        this.extInfos = arrayList;
    }

    public void setTinyId(long j3) {
        this.tinyId = j3;
    }

    public String toString() {
        return "GProUserAVReqInfo{commonInfo=" + this.commonInfo + ",tinyId=" + this.tinyId + ",devOpt=" + this.devOpt + ",extInfos=" + this.extInfos + ",}";
    }

    public GProUserAVReqInfo(GProAVCommonReqInfo gProAVCommonReqInfo, long j3, GProAVDevOptInfo gProAVDevOptInfo) {
        this.commonInfo = new GProAVCommonReqInfo();
        this.devOpt = new GProAVDevOptInfo();
        this.extInfos = new ArrayList<>();
        this.commonInfo = gProAVCommonReqInfo;
        this.tinyId = j3;
        this.devOpt = gProAVDevOptInfo;
    }
}
