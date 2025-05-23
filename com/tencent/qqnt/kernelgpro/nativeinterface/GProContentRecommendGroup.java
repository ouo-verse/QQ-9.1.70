package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProContentRecommendGroup implements Serializable {
    public long groupCode;
    long serialVersionUID = 1;
    public String headUrl = "";
    public String groupName = "";
    public String groupSummary = "";
    public String joinText = "";
    public String joinGroupAuth = "";
    public String groupMembers = "";
    public ArrayList<String> recommendReasons = new ArrayList<>();

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getGroupMembers() {
        return this.groupMembers;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getGroupSummary() {
        return this.groupSummary;
    }

    public String getHeadUrl() {
        return this.headUrl;
    }

    public String getJoinGroupAuth() {
        return this.joinGroupAuth;
    }

    public String getJoinText() {
        return this.joinText;
    }

    public ArrayList<String> getRecommendReasons() {
        return this.recommendReasons;
    }

    public String toString() {
        return "GProContentRecommendGroup{groupCode=" + this.groupCode + ",headUrl=" + this.headUrl + ",groupName=" + this.groupName + ",groupSummary=" + this.groupSummary + ",joinText=" + this.joinText + ",joinGroupAuth=" + this.joinGroupAuth + ",groupMembers=" + this.groupMembers + ",recommendReasons=" + this.recommendReasons + ",}";
    }
}
