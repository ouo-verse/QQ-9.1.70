package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAnchorPrepareRsp {
    public String defaultRoomName;
    public GProAnchorRoomInfo info;
    public Integer logoNum;
    public Integer uploadCodecType;

    public String getDefaultRoomName() {
        return this.defaultRoomName;
    }

    public GProAnchorRoomInfo getInfo() {
        return this.info;
    }

    public Integer getLogoNum() {
        return this.logoNum;
    }

    public Integer getUploadCodecType() {
        return this.uploadCodecType;
    }

    public String toString() {
        return "GProAnchorPrepareRsp{info=" + this.info + ",defaultRoomName=" + this.defaultRoomName + ",logoNum=" + this.logoNum + ",uploadCodecType=" + this.uploadCodecType + ",}";
    }
}
