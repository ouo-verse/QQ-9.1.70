package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStMedalInfo {
    public boolean isHighLight;
    public boolean isNew;
    public int rank;
    public int reportValue;
    public int type;
    public String medalName = "";
    public String medalID = "";
    public String jumpUrl = "";
    public String iconUrl = "";
    public String backgroundUrl = "";
    public String describe = "";

    public String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    public String getDescribe() {
        return this.describe;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public boolean getIsHighLight() {
        return this.isHighLight;
    }

    public boolean getIsNew() {
        return this.isNew;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getMedalID() {
        return this.medalID;
    }

    public String getMedalName() {
        return this.medalName;
    }

    public int getRank() {
        return this.rank;
    }

    public int getReportValue() {
        return this.reportValue;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProStMedalInfo{type=" + this.type + ",medalName=" + this.medalName + ",medalID=" + this.medalID + ",rank=" + this.rank + ",isHighLight=" + this.isHighLight + ",isNew=" + this.isNew + ",jumpUrl=" + this.jumpUrl + ",iconUrl=" + this.iconUrl + ",backgroundUrl=" + this.backgroundUrl + ",describe=" + this.describe + ",reportValue=" + this.reportValue + ",}";
    }
}
