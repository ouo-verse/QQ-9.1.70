package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProHotLiveCard implements Serializable {
    public long channelId;
    public int channelType;
    public long guildId;
    public long roomId;
    public int themeType;
    long serialVersionUID = 1;
    public String cover = "";
    public String liveTitle = "";
    public String icon = "";
    public ArrayList<String> memberAvatarList = new ArrayList<>();
    public String themeSessionId = "";

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public String getCover() {
        return this.cover;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getLiveTitle() {
        return this.liveTitle;
    }

    public ArrayList<String> getMemberAvatarList() {
        return this.memberAvatarList;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String getThemeSessionId() {
        return this.themeSessionId;
    }

    public int getThemeType() {
        return this.themeType;
    }

    public String toString() {
        return "GProHotLiveCard{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelType=" + this.channelType + ",cover=" + this.cover + ",liveTitle=" + this.liveTitle + ",icon=" + this.icon + ",memberAvatarList=" + this.memberAvatarList + ",themeType=" + this.themeType + ",roomId=" + this.roomId + ",themeSessionId=" + this.themeSessionId + ",}";
    }
}
