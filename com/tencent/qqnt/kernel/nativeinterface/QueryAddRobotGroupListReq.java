package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class QueryAddRobotGroupListReq {
    public byte[] cookie;
    public long robotUin;

    public QueryAddRobotGroupListReq() {
        this.cookie = new byte[0];
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public String toString() {
        return "QueryAddRobotGroupListReq{robotUin=" + this.robotUin + ",cookie=" + this.cookie + ",}";
    }

    public QueryAddRobotGroupListReq(long j3, byte[] bArr) {
        this.robotUin = j3;
        this.cookie = bArr;
    }
}
