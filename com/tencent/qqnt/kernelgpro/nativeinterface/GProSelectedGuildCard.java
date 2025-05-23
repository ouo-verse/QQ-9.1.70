package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSelectedGuildCard implements Serializable {
    public long guildId;
    long serialVersionUID = 1;
    public String guildName = "";
    public String guildAvatar = "";
    public ArrayList<GProGuildLabel> tagList = new ArrayList<>();
    public ArrayList<GProMedalInfo> medals = new ArrayList<>();

    public String getGuildAvatar() {
        return this.guildAvatar;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public ArrayList<GProMedalInfo> getMedals() {
        return this.medals;
    }

    public ArrayList<GProGuildLabel> getTagList() {
        return this.tagList;
    }

    public String toString() {
        return "GProSelectedGuildCard{guildId=" + this.guildId + ",guildName=" + this.guildName + ",guildAvatar=" + this.guildAvatar + ",tagList=" + this.tagList + ",medals=" + this.medals + ",}";
    }
}
