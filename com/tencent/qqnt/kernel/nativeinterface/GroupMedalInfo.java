package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupMedalInfo {
    public long medalCreateTime;
    public int medalCurrentPoint;
    public int medalLevel;
    public String medalID = "";
    public String medalName = "";
    public ArrayList<GroupMedalLabel> medalLabelArray = new ArrayList<>();
    public String medalIcon = "";
    public String medalDesc = "";
    public ArrayList<GroupMedalLevel> medalLevelArray = new ArrayList<>();
    public GroupMedalStatus medalStatus = GroupMedalStatus.values()[0];
    public GroupMedalSVIPInfo medalSVIPInfo = new GroupMedalSVIPInfo();
    public String medalConditions = "";
    public String medalJumpUrl = "";
    public GroupMedalReward medalReward = new GroupMedalReward();

    public String getMedalConditions() {
        return this.medalConditions;
    }

    public long getMedalCreateTime() {
        return this.medalCreateTime;
    }

    public int getMedalCurrentPoint() {
        return this.medalCurrentPoint;
    }

    public String getMedalDesc() {
        return this.medalDesc;
    }

    public String getMedalID() {
        return this.medalID;
    }

    public String getMedalIcon() {
        return this.medalIcon;
    }

    public String getMedalJumpUrl() {
        return this.medalJumpUrl;
    }

    public ArrayList<GroupMedalLabel> getMedalLabelArray() {
        return this.medalLabelArray;
    }

    public int getMedalLevel() {
        return this.medalLevel;
    }

    public ArrayList<GroupMedalLevel> getMedalLevelArray() {
        return this.medalLevelArray;
    }

    public String getMedalName() {
        return this.medalName;
    }

    public GroupMedalReward getMedalReward() {
        return this.medalReward;
    }

    public GroupMedalSVIPInfo getMedalSVIPInfo() {
        return this.medalSVIPInfo;
    }

    public GroupMedalStatus getMedalStatus() {
        return this.medalStatus;
    }

    public String toString() {
        return "GroupMedalInfo{medalID=" + this.medalID + ",medalName=" + this.medalName + ",medalLevel=" + this.medalLevel + ",medalLabelArray=" + this.medalLabelArray + ",medalIcon=" + this.medalIcon + ",medalDesc=" + this.medalDesc + ",medalLevelArray=" + this.medalLevelArray + ",medalStatus=" + this.medalStatus + ",medalSVIPInfo=" + this.medalSVIPInfo + ",medalConditions=" + this.medalConditions + ",medalCurrentPoint=" + this.medalCurrentPoint + ",medalCreateTime=" + this.medalCreateTime + ",medalJumpUrl=" + this.medalJumpUrl + ",medalReward=" + this.medalReward + ",}";
    }
}
