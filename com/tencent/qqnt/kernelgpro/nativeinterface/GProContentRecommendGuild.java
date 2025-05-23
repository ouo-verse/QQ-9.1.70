package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProContentRecommendGuild implements Serializable {
    public long guildId;
    long serialVersionUID = 1;
    public String guildName = "";
    public String guildAvatar = "";
    public ArrayList<GProGuildLabel> tagList = new ArrayList<>();
    public ArrayList<GProMedalInfo> medals = new ArrayList<>();
    public String guildProfile = "";
    public String cover = "";
    public byte[] joinSig = new byte[0];
    public GProGameGiftInfo giftInfo = new GProGameGiftInfo();
    public String guildIntro = "";

    public String getCover() {
        return this.cover;
    }

    public GProGameGiftInfo getGiftInfo() {
        return this.giftInfo;
    }

    public String getGuildAvatar() {
        return this.guildAvatar;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildIntro() {
        return this.guildIntro;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getGuildProfile() {
        return this.guildProfile;
    }

    public byte[] getJoinSig() {
        return this.joinSig;
    }

    public ArrayList<GProMedalInfo> getMedals() {
        return this.medals;
    }

    public ArrayList<GProGuildLabel> getTagList() {
        return this.tagList;
    }

    public String toString() {
        return "GProContentRecommendGuild{guildId=" + this.guildId + ",guildName=" + this.guildName + ",guildAvatar=" + this.guildAvatar + ",tagList=" + this.tagList + ",medals=" + this.medals + ",guildProfile=" + this.guildProfile + ",cover=" + this.cover + ",joinSig=" + this.joinSig + ",giftInfo=" + this.giftInfo + ",guildIntro=" + this.guildIntro + ",}";
    }
}
