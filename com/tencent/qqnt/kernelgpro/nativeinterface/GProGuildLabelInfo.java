package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildLabelInfo {
    public long guildId;
    public String guildName = "";
    public String profile = "";
    public String guildCover = "";
    public String guildIcon = "";
    public ArrayList<GProGuildLabel> labels = new ArrayList<>();
    public ArrayList<GProMedalInfo> medals = new ArrayList<>();
    public ArrayList<GProRecommendGuildState> stateList = new ArrayList<>();

    public String getGuildCover() {
        return this.guildCover;
    }

    public String getGuildIcon() {
        return this.guildIcon;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public ArrayList<GProGuildLabel> getLabels() {
        return this.labels;
    }

    public ArrayList<GProMedalInfo> getMedals() {
        return this.medals;
    }

    public String getProfile() {
        return this.profile;
    }

    public ArrayList<GProRecommendGuildState> getStateList() {
        return this.stateList;
    }

    public String toString() {
        return "GProGuildLabelInfo{guildId=" + this.guildId + ",guildName=" + this.guildName + ",profile=" + this.profile + ",guildCover=" + this.guildCover + ",guildIcon=" + this.guildIcon + ",labels=" + this.labels + ",medals=" + this.medals + ",stateList=" + this.stateList + ",}";
    }
}
