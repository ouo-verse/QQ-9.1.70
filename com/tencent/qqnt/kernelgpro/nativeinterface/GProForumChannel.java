package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProForumChannel implements Serializable {
    public long channelId;
    public String channelName;
    public long endColor;
    public String guildFaceUrl;
    public long guildId;
    public String guildName;
    public String hotValueTitle;
    public int index;
    public String joinSign;
    long serialVersionUID;
    public long startColor;
    public int type;

    public GProForumChannel() {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.channelName = "";
        this.hotValueTitle = "";
        this.guildFaceUrl = "";
        this.joinSign = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public long getEndColor() {
        return this.endColor;
    }

    public String getGuildFaceUrl() {
        return this.guildFaceUrl;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getHotValueTitle() {
        return this.hotValueTitle;
    }

    public int getIndex() {
        return this.index;
    }

    public String getJoinSign() {
        return this.joinSign;
    }

    public long getStartColor() {
        return this.startColor;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProForumChannel{index=" + this.index + ",guildId=" + this.guildId + ",guildName=" + this.guildName + ",channelId=" + this.channelId + ",channelName=" + this.channelName + ",hotValueTitle=" + this.hotValueTitle + ",type=" + this.type + ",guildFaceUrl=" + this.guildFaceUrl + ",startColor=" + this.startColor + ",endColor=" + this.endColor + ",joinSign=" + this.joinSign + ",}";
    }

    public GProForumChannel(int i3, long j3, String str, long j16, String str2, String str3, int i16, String str4, long j17, long j18, String str5) {
        this.serialVersionUID = 1L;
        this.index = i3;
        this.guildId = j3;
        this.guildName = str;
        this.channelId = j16;
        this.channelName = str2;
        this.hotValueTitle = str3;
        this.type = i16;
        this.guildFaceUrl = str4;
        this.startColor = j17;
        this.endColor = j18;
        this.joinSign = str5;
    }
}
