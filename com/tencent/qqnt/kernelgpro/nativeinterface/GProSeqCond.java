package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSeqCond {
    public long beginSeq;
    public long channelId;
    public long endSeq;
    public long guildId;

    public GProSeqCond() {
    }

    public long getBeginSeq() {
        return this.beginSeq;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getEndSeq() {
        return this.endSeq;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProSeqCond{guildId=" + this.guildId + ",channelId=" + this.channelId + ",beginSeq=" + this.beginSeq + ",endSeq=" + this.endSeq + ",}";
    }

    public GProSeqCond(long j3, long j16, long j17, long j18) {
        this.guildId = j3;
        this.channelId = j16;
        this.beginSeq = j17;
        this.endSeq = j18;
    }
}
