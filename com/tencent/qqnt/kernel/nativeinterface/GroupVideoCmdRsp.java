package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupVideoCmdRsp {
    public byte[] pbBuf;

    public GroupVideoCmdRsp() {
        this.pbBuf = new byte[0];
    }

    public byte[] getPbBuf() {
        return this.pbBuf;
    }

    public String toString() {
        return "GroupVideoCmdRsp{pbBuf=" + this.pbBuf + ",}";
    }

    public GroupVideoCmdRsp(byte[] bArr) {
        this.pbBuf = bArr;
    }
}
