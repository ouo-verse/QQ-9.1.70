package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProLiveRoomInfo implements Serializable {
    public int closeType;
    public boolean isActive;
    public int liveType;
    public int platform;
    public long queryId;
    long serialVersionUID = 1;
    public String channelId = "";
    public String channelName = "";
    public GProAnchorInfo anchorInfo = new GProAnchorInfo();
    public GProRoomInfo roomInfo = new GProRoomInfo();
    public GProLiveStreamInfo streamInfo = new GProLiveStreamInfo();
    public GProProgramInfo programInfo = new GProProgramInfo();
    public String closeTips = "";

    public GProAnchorInfo getAnchorInfo() {
        return this.anchorInfo;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getCloseTips() {
        return this.closeTips;
    }

    public int getCloseType() {
        return this.closeType;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public int getLiveType() {
        return this.liveType;
    }

    public int getPlatform() {
        return this.platform;
    }

    public GProProgramInfo getProgramInfo() {
        return this.programInfo;
    }

    public long getQueryId() {
        return this.queryId;
    }

    public GProRoomInfo getRoomInfo() {
        return this.roomInfo;
    }

    public GProLiveStreamInfo getStreamInfo() {
        return this.streamInfo;
    }

    public String toString() {
        return "GProLiveRoomInfo{channelId=" + this.channelId + ",channelName=" + this.channelName + ",queryId=" + this.queryId + ",anchorInfo=" + this.anchorInfo + ",roomInfo=" + this.roomInfo + ",streamInfo=" + this.streamInfo + ",liveType=" + this.liveType + ",platform=" + this.platform + ",programInfo=" + this.programInfo + ",closeType=" + this.closeType + ",closeTips=" + this.closeTips + ",isActive=" + this.isActive + ",}";
    }
}
