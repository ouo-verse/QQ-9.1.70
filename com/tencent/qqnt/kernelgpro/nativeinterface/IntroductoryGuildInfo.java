package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class IntroductoryGuildInfo {
    public String guildAvatar;
    public String guildCover;
    public long guildId;
    public String guildName;
    public String guildProfile;
    public String joinGuildSig;
    public ArrayList<GProRecommendLabel> labelInfos;
    public ArrayList<GProMedalInfo> medalInfos;

    public IntroductoryGuildInfo() {
        this.guildName = "";
        this.guildAvatar = "";
        this.guildProfile = "";
        this.guildCover = "";
        this.medalInfos = new ArrayList<>();
        this.labelInfos = new ArrayList<>();
        this.joinGuildSig = "";
    }

    public String getGuildAvatar() {
        return this.guildAvatar;
    }

    public String getGuildCover() {
        return this.guildCover;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getGuildProfile() {
        return this.guildProfile;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public ArrayList<GProRecommendLabel> getLabelInfos() {
        return this.labelInfos;
    }

    public ArrayList<GProMedalInfo> getMedalInfos() {
        return this.medalInfos;
    }

    public String toString() {
        return "IntroductoryGuildInfo{guildId=" + this.guildId + ",guildName=" + this.guildName + ",guildAvatar=" + this.guildAvatar + ",guildProfile=" + this.guildProfile + ",guildCover=" + this.guildCover + ",medalInfos=" + this.medalInfos + ",labelInfos=" + this.labelInfos + ",joinGuildSig=" + this.joinGuildSig + ",}";
    }

    public IntroductoryGuildInfo(long j3, String str, String str2, String str3, String str4, ArrayList<GProMedalInfo> arrayList, ArrayList<GProRecommendLabel> arrayList2, String str5) {
        this.guildName = "";
        this.guildAvatar = "";
        this.guildProfile = "";
        this.guildCover = "";
        this.medalInfos = new ArrayList<>();
        new ArrayList();
        this.guildId = j3;
        this.guildName = str;
        this.guildAvatar = str2;
        this.guildProfile = str3;
        this.guildCover = str4;
        this.medalInfos = arrayList;
        this.labelInfos = arrayList2;
        this.joinGuildSig = str5;
    }
}
