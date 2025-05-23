package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class BasicPointInfo {
    public byte[] headUrl;
    public long readSeqNo;
    public long seqNo;

    public BasicPointInfo() {
        this.headUrl = new byte[0];
    }

    public byte[] getHeadUrl() {
        return this.headUrl;
    }

    public long getReadSeqNo() {
        return this.readSeqNo;
    }

    public long getSeqNo() {
        return this.seqNo;
    }

    public String toString() {
        return "BasicPointInfo{headUrl=" + this.headUrl + ",seqNo=" + this.seqNo + ",readSeqNo=" + this.readSeqNo + ",}";
    }

    public BasicPointInfo(byte[] bArr, long j3, long j16) {
        this.headUrl = bArr;
        this.seqNo = j3;
        this.readSeqNo = j16;
    }
}
