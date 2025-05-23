package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProDirectMsgReport {
    public long guildId;
    public byte[] meta;
    public long readCntSeq;
    public long readCntTime;
    public long readMsgSeq;
    public long readMsgTime;

    public GProDirectMsgReport() {
        this.meta = new byte[0];
    }

    public long getGuildId() {
        return this.guildId;
    }

    public byte[] getMeta() {
        return this.meta;
    }

    public long getReadCntSeq() {
        return this.readCntSeq;
    }

    public long getReadCntTime() {
        return this.readCntTime;
    }

    public long getReadMsgSeq() {
        return this.readMsgSeq;
    }

    public long getReadMsgTime() {
        return this.readMsgTime;
    }

    public String toString() {
        return "GProDirectMsgReport{guildId=" + this.guildId + ",readMsgSeq=" + this.readMsgSeq + ",readMsgTime=" + this.readMsgTime + ",readCntSeq=" + this.readCntSeq + ",readCntTime=" + this.readCntTime + ",meta=" + this.meta + ",}";
    }

    public GProDirectMsgReport(long j3, long j16, long j17, long j18, long j19, byte[] bArr) {
        this.guildId = j3;
        this.readMsgSeq = j16;
        this.readMsgTime = j17;
        this.readCntSeq = j18;
        this.readCntTime = j19;
        this.meta = bArr;
    }
}
