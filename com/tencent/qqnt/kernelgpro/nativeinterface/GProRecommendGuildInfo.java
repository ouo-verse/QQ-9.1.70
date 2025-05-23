package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendGuildInfo {
    public String cover;

    /* renamed from: face, reason: collision with root package name */
    public String f359311face;
    public String faceAnimationOnIdle;
    public String faceAnimationOnUpdate;
    public long fontColorId;
    public String guildCode;
    public long guildId;
    public String introduction;
    public int locationType;
    public String name;
    public ArrayList<GProNavigationInfo> navigationInfoList;
    public GProPlayFaceAnimationPolicy playFaceAnimationPolicy;
    public long seq;
    public String subTitle;
    public ArrayList<GProTextMedalInfo> textMedalInfoList;

    public GProRecommendGuildInfo() {
        this.name = "";
        this.f359311face = "";
        this.cover = "";
        this.subTitle = "";
        this.introduction = "";
        this.guildCode = "";
        this.faceAnimationOnUpdate = "";
        this.faceAnimationOnIdle = "";
        this.playFaceAnimationPolicy = new GProPlayFaceAnimationPolicy();
        this.navigationInfoList = new ArrayList<>();
        this.textMedalInfoList = new ArrayList<>();
    }

    public String getCover() {
        return this.cover;
    }

    public String getFace() {
        return this.f359311face;
    }

    public String getFaceAnimationOnIdle() {
        return this.faceAnimationOnIdle;
    }

    public String getFaceAnimationOnUpdate() {
        return this.faceAnimationOnUpdate;
    }

    public long getFontColorId() {
        return this.fontColorId;
    }

    public String getGuildCode() {
        return this.guildCode;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public int getLocationType() {
        return this.locationType;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<GProNavigationInfo> getNavigationInfoList() {
        return this.navigationInfoList;
    }

    public GProPlayFaceAnimationPolicy getPlayFaceAnimationPolicy() {
        return this.playFaceAnimationPolicy;
    }

    public long getSeq() {
        return this.seq;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public ArrayList<GProTextMedalInfo> getTextMedalInfoList() {
        return this.textMedalInfoList;
    }

    public String toString() {
        return "GProRecommendGuildInfo{guildId=" + this.guildId + ",name=" + this.name + ",face=" + this.f359311face + ",cover=" + this.cover + ",fontColorId=" + this.fontColorId + ",subTitle=" + this.subTitle + ",introduction=" + this.introduction + ",guildCode=" + this.guildCode + ",seq=" + this.seq + ",faceAnimationOnUpdate=" + this.faceAnimationOnUpdate + ",faceAnimationOnIdle=" + this.faceAnimationOnIdle + ",playFaceAnimationPolicy=" + this.playFaceAnimationPolicy + ",navigationInfoList=" + this.navigationInfoList + ",locationType=" + this.locationType + ",textMedalInfoList=" + this.textMedalInfoList + ",}";
    }

    public GProRecommendGuildInfo(long j3, String str, String str2, String str3, long j16, String str4, String str5, String str6, long j17, String str7, String str8, GProPlayFaceAnimationPolicy gProPlayFaceAnimationPolicy, ArrayList<GProNavigationInfo> arrayList, int i3, ArrayList<GProTextMedalInfo> arrayList2) {
        this.name = "";
        this.f359311face = "";
        this.cover = "";
        this.subTitle = "";
        this.introduction = "";
        this.guildCode = "";
        this.faceAnimationOnUpdate = "";
        this.faceAnimationOnIdle = "";
        this.playFaceAnimationPolicy = new GProPlayFaceAnimationPolicy();
        this.navigationInfoList = new ArrayList<>();
        new ArrayList();
        this.guildId = j3;
        this.name = str;
        this.f359311face = str2;
        this.cover = str3;
        this.fontColorId = j16;
        this.subTitle = str4;
        this.introduction = str5;
        this.guildCode = str6;
        this.seq = j17;
        this.faceAnimationOnUpdate = str7;
        this.faceAnimationOnIdle = str8;
        this.playFaceAnimationPolicy = gProPlayFaceAnimationPolicy;
        this.navigationInfoList = arrayList;
        this.locationType = i3;
        this.textMedalInfoList = arrayList2;
    }
}
