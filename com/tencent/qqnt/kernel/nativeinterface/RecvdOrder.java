package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RecvdOrder {
    public long amount;
    public int createTime;
    public String recvName;
    public long recvUin;
    public String uid;

    public RecvdOrder() {
        this.recvName = "";
    }

    public long getAmount() {
        return this.amount;
    }

    public int getCreateTime() {
        return this.createTime;
    }

    public String getRecvName() {
        return this.recvName;
    }

    public long getRecvUin() {
        return this.recvUin;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "RecvdOrder{recvUin=" + this.recvUin + ",recvName=" + this.recvName + ",amount=" + this.amount + ",createTime=" + this.createTime + ",uid=" + this.uid + ",}";
    }

    public RecvdOrder(long j3, String str, long j16, int i3, String str2) {
        this.recvUin = j3;
        this.recvName = str;
        this.amount = j16;
        this.createTime = i3;
        this.uid = str2;
    }
}
