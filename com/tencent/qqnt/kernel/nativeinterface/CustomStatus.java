package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CustomStatus {
    public long faceId;
    public long faceType;
    public String wording;

    public CustomStatus() {
        this.wording = "";
    }

    public long getFaceId() {
        return this.faceId;
    }

    public long getFaceType() {
        return this.faceType;
    }

    public String getWording() {
        return this.wording;
    }

    public String toString() {
        return "CustomStatus{faceId=" + this.faceId + ",faceType=" + this.faceType + ",wording=" + this.wording + ",}";
    }

    public CustomStatus(long j3, long j16, String str) {
        this.faceId = j3;
        this.faceType = j16;
        this.wording = str;
    }
}
