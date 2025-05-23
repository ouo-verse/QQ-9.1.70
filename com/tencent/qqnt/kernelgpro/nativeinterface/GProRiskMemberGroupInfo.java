package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRiskMemberGroupInfo {
    public long groupId;
    public String groupName;
    public ArrayList<GProBlackUserInfo> rptMemberList;
    public int totalNum;

    public GProRiskMemberGroupInfo() {
        this.groupName = "";
        this.rptMemberList = new ArrayList<>();
    }

    public long getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public ArrayList<GProBlackUserInfo> getRptMemberList() {
        return this.rptMemberList;
    }

    public int getTotalNum() {
        return this.totalNum;
    }

    public String toString() {
        return "GProRiskMemberGroupInfo{groupId=" + this.groupId + ",groupName=" + this.groupName + ",rptMemberList=" + this.rptMemberList + ",totalNum=" + this.totalNum + ",}";
    }

    public GProRiskMemberGroupInfo(long j3, String str, ArrayList<GProBlackUserInfo> arrayList, int i3) {
        this.groupName = "";
        new ArrayList();
        this.groupId = j3;
        this.groupName = str;
        this.rptMemberList = arrayList;
        this.totalNum = i3;
    }
}
