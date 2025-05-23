package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MultiTransInfo {
    public int friendFlag;
    public byte[] fromAnonId;
    public String fromFaceUrl;
    public int msgId;
    public int status;

    public MultiTransInfo() {
        this.fromAnonId = new byte[0];
        this.fromFaceUrl = "";
    }

    public int getFriendFlag() {
        return this.friendFlag;
    }

    public byte[] getFromAnonId() {
        return this.fromAnonId;
    }

    public String getFromFaceUrl() {
        return this.fromFaceUrl;
    }

    public int getMsgId() {
        return this.msgId;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return "MultiTransInfo{status=" + this.status + ",msgId=" + this.msgId + ",friendFlag=" + this.friendFlag + ",fromAnonId=" + this.fromAnonId + ",fromFaceUrl=" + this.fromFaceUrl + ",}";
    }

    public MultiTransInfo(int i3, int i16, int i17, byte[] bArr, String str) {
        this.status = i3;
        this.msgId = i16;
        this.friendFlag = i17;
        this.fromAnonId = bArr;
        this.fromFaceUrl = str;
    }
}
