package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProLiveSearchInfo {
    public long anchorTinyId;
    public long channelId;
    public long guildId;
    public int joinedGuild;
    public int liveType;
    public long roomId;
    public String streamUrl = "";
    public String coverUrl = "";
    public String tag = "";
    public String joinGuildSig = "";
    public String guildName = "";
    public String guildIconUrl = "";
    public String roomName = "";
    public GProRecallInfo recallInfo = new GProRecallInfo();

    public long getAnchorTinyId() {
        return this.anchorTinyId;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getGuildIconUrl() {
        return this.guildIconUrl;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public int getJoinedGuild() {
        return this.joinedGuild;
    }

    public int getLiveType() {
        return this.liveType;
    }

    public GProRecallInfo getRecallInfo() {
        return this.recallInfo;
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

    public String getTag() {
        return this.tag;
    }

    public String toString() {
        return "GProLiveSearchInfo{joinedGuild=" + this.joinedGuild + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",roomId=" + this.roomId + ",anchorTinyId=" + this.anchorTinyId + ",streamUrl=" + this.streamUrl + ",coverUrl=" + this.coverUrl + ",tag=" + this.tag + ",joinGuildSig=" + this.joinGuildSig + ",guildName=" + this.guildName + ",guildIconUrl=" + this.guildIconUrl + ",roomName=" + this.roomName + ",recallInfo=" + this.recallInfo + ",liveType=" + this.liveType + ",}";
    }
}
