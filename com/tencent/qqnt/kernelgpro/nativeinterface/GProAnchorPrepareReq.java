package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAnchorPrepareReq {
    public String machine;
    public Integer roomType;

    public String getMachine() {
        return this.machine;
    }

    public Integer getRoomType() {
        return this.roomType;
    }

    public String toString() {
        return "GProAnchorPrepareReq{roomType=" + this.roomType + ",machine=" + this.machine + ",}";
    }
}
