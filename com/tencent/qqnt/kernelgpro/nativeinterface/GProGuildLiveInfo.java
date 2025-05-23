package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGuildLiveInfo implements Serializable {
    public int liveType;
    public int platform;
    public long queryId;
    public int queryIdType;
    public int resultCode;
    long serialVersionUID = 1;
    public String errMsg = "";
    public GProAnchorInfo anchorInfo = new GProAnchorInfo();
    public GProRoomInfo roomInfo = new GProRoomInfo();
    public GProLiveStreamInfo streamInfo = new GProLiveStreamInfo();

    public GProAnchorInfo getAnchorInfo() {
        return this.anchorInfo;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public int getLiveType() {
        return this.liveType;
    }

    public int getPlatform() {
        return this.platform;
    }

    public long getQueryId() {
        return this.queryId;
    }

    public int getQueryIdType() {
        return this.queryIdType;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public GProRoomInfo getRoomInfo() {
        return this.roomInfo;
    }

    public GProLiveStreamInfo getStreamInfo() {
        return this.streamInfo;
    }

    public String toString() {
        return "GProGuildLiveInfo{resultCode=" + this.resultCode + ",errMsg=" + this.errMsg + ",queryId=" + this.queryId + ",queryIdType=" + this.queryIdType + ",anchorInfo=" + this.anchorInfo + ",roomInfo=" + this.roomInfo + ",streamInfo=" + this.streamInfo + ",liveType=" + this.liveType + ",platform=" + this.platform + ",}";
    }
}
