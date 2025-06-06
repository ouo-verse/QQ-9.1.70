package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GrabRedBagReq {
    public byte[] index;
    public long msgSeq;
    public String name;
    public byte[] pcBody;
    public String peerUid;
    public int recvType;
    public long recvUin;
    public String wishing;

    public GrabRedBagReq() {
        this.pcBody = new byte[0];
        this.index = new byte[0];
        this.name = "";
        this.wishing = "";
        this.peerUid = "";
    }

    public byte[] getIndex() {
        return this.index;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public String getName() {
        return this.name;
    }

    public byte[] getPcBody() {
        return this.pcBody;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public int getRecvType() {
        return this.recvType;
    }

    public long getRecvUin() {
        return this.recvUin;
    }

    public String getWishing() {
        return this.wishing;
    }

    public String toString() {
        return "GrabRedBagReq{pcBody=" + this.pcBody + ",index=" + this.index + ",name=" + this.name + ",wishing=" + this.wishing + ",recvUin=" + this.recvUin + ",peerUid=" + this.peerUid + ",recvType=" + this.recvType + ",msgSeq=" + this.msgSeq + ",}";
    }

    public GrabRedBagReq(byte[] bArr, byte[] bArr2, String str, String str2, long j3, String str3, int i3, long j16) {
        this.pcBody = bArr;
        this.index = bArr2;
        this.name = str;
        this.wishing = str2;
        this.recvUin = j3;
        this.peerUid = str3;
        this.recvType = i3;
        this.msgSeq = j16;
    }
}
