package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendShareLive implements Serializable {
    public String anchorIcon;
    public long anchorId;
    public ArrayList<String> audienceIcons;
    public long channelId;
    public long roomId;
    public String roomName;
    long serialVersionUID;
    public String streamUrl;

    public GProRecommendShareLive() {
        this.serialVersionUID = 1L;
        this.anchorIcon = "";
        this.audienceIcons = new ArrayList<>();
        this.roomName = "";
        this.streamUrl = "";
    }

    public String getAnchorIcon() {
        return this.anchorIcon;
    }

    public long getAnchorId() {
        return this.anchorId;
    }

    public ArrayList<String> getAudienceIcons() {
        return this.audienceIcons;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public String getStreamUrl() {
        return this.streamUrl;
    }

    public String toString() {
        return "GProRecommendShareLive{anchorIcon=" + this.anchorIcon + ",audienceIcons=" + this.audienceIcons + ",anchorId=" + this.anchorId + ",channelId=" + this.channelId + ",roomName=" + this.roomName + ",roomId=" + this.roomId + ",streamUrl=" + this.streamUrl + ",}";
    }

    public GProRecommendShareLive(String str, ArrayList<String> arrayList, long j3, long j16, String str2, long j17, String str3) {
        this.serialVersionUID = 1L;
        this.anchorIcon = "";
        new ArrayList();
        this.anchorIcon = str;
        this.audienceIcons = arrayList;
        this.anchorId = j3;
        this.channelId = j16;
        this.roomName = str2;
        this.roomId = j17;
        this.streamUrl = str3;
    }
}
