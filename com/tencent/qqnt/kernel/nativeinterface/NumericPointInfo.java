package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class NumericPointInfo {
    public long num;
    public long readSeqNo;
    public long seqNo;

    public NumericPointInfo() {
    }

    public long getNum() {
        return this.num;
    }

    public long getReadSeqNo() {
        return this.readSeqNo;
    }

    public long getSeqNo() {
        return this.seqNo;
    }

    public String toString() {
        return "NumericPointInfo{num=" + this.num + ",seqNo=" + this.seqNo + ",readSeqNo=" + this.readSeqNo + ",}";
    }

    public NumericPointInfo(long j3, long j16, long j17) {
        this.num = j3;
        this.seqNo = j16;
        this.readSeqNo = j17;
    }
}
