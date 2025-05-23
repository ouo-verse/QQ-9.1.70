package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupVideoCmdReq {
    public int cmdType;
    public byte[] pbBuf;

    public GroupVideoCmdReq() {
        this.pbBuf = new byte[0];
    }

    public int getCmdType() {
        return this.cmdType;
    }

    public byte[] getPbBuf() {
        return this.pbBuf;
    }

    public String toString() {
        return "GroupVideoCmdReq{cmdType=" + this.cmdType + ",pbBuf=" + this.pbBuf + ",}";
    }

    public GroupVideoCmdReq(int i3, byte[] bArr) {
        this.cmdType = i3;
        this.pbBuf = bArr;
    }
}
