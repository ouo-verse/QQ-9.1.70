package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupMedalLevel {
    public int medalLevel;
    public String medalIcon = "";
    public String medalDesc = "";
    public String medalRule = "";
    public GroupMedalPoint medalPoint = new GroupMedalPoint();

    public String getMedalDesc() {
        return this.medalDesc;
    }

    public String getMedalIcon() {
        return this.medalIcon;
    }

    public int getMedalLevel() {
        return this.medalLevel;
    }

    public GroupMedalPoint getMedalPoint() {
        return this.medalPoint;
    }

    public String getMedalRule() {
        return this.medalRule;
    }

    public String toString() {
        return "GroupMedalLevel{medalLevel=" + this.medalLevel + ",medalIcon=" + this.medalIcon + ",medalDesc=" + this.medalDesc + ",medalRule=" + this.medalRule + ",medalPoint=" + this.medalPoint + ",}";
    }
}
