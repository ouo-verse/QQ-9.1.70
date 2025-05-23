package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetRiskMemberRedPointReq {
    public long guildId;
    public long seqNo;

    public GProGetRiskMemberRedPointReq() {
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getSeqNo() {
        return this.seqNo;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setSeqNo(long j3) {
        this.seqNo = j3;
    }

    public String toString() {
        return "GProGetRiskMemberRedPointReq{guildId=" + this.guildId + ",seqNo=" + this.seqNo + ",}";
    }

    public GProGetRiskMemberRedPointReq(long j3, long j16) {
        this.guildId = j3;
        this.seqNo = j16;
    }
}
