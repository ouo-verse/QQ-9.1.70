package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProContentRecommendVoice implements Serializable {
    public long channelId;
    public int channelType;
    public long guildId;
    public int themeType;
    long serialVersionUID = 1;
    public String cover = "";
    public ArrayList<String> memberAvatarList = new ArrayList<>();
    public String voiceTitle = "";
    public byte[] joinSig = new byte[0];
    public String themeSessionId = "";
    public GProFeedGuildInfo guildInfo = new GProFeedGuildInfo();
    public GProContentRecommendStreamInfo screenStreamUrl = new GProContentRecommendStreamInfo();

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

    public GProFeedGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    public byte[] getJoinSig() {
        return this.joinSig;
    }

    public ArrayList<String> getMemberAvatarList() {
        return this.memberAvatarList;
    }

    public GProContentRecommendStreamInfo getScreenStreamUrl() {
        return this.screenStreamUrl;
    }

    public String getThemeSessionId() {
        return this.themeSessionId;
    }

    public int getThemeType() {
        return this.themeType;
    }

    public String getVoiceTitle() {
        return this.voiceTitle;
    }

    public String toString() {
        return "GProContentRecommendVoice{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelType=" + this.channelType + ",cover=" + this.cover + ",memberAvatarList=" + this.memberAvatarList + ",themeType=" + this.themeType + ",voiceTitle=" + this.voiceTitle + ",joinSig=" + this.joinSig + ",themeSessionId=" + this.themeSessionId + ",guildInfo=" + this.guildInfo + ",screenStreamUrl=" + this.screenStreamUrl + ",}";
    }
}
