package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetRiskMemberRedPointRsp {
    public long duration;
    public long seqNo;
    public String tips;

    public GProGetRiskMemberRedPointRsp() {
        this.tips = "";
    }

    public long getDuration() {
        return this.duration;
    }

    public long getSeqNo() {
        return this.seqNo;
    }

    public String getTips() {
        return this.tips;
    }

    public String toString() {
        return "GProGetRiskMemberRedPointRsp{seqNo=" + this.seqNo + ",duration=" + this.duration + ",tips=" + this.tips + ",}";
    }

    public GProGetRiskMemberRedPointRsp(long j3, long j16, String str) {
        this.seqNo = j3;
        this.duration = j16;
        this.tips = str;
    }
}
