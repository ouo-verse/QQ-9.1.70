package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetGuildRobotListRsp {
    public ArrayList<GProGuildRobotInfo> addedList;
    public ArrayList<GProGuildRobotInfo> recommendList;
    public int robotMaxNum;
    public int role;
    public int totalRecommend;

    public GProGetGuildRobotListRsp() {
        this.addedList = new ArrayList<>();
        this.recommendList = new ArrayList<>();
    }

    public ArrayList<GProGuildRobotInfo> getAddedList() {
        return this.addedList;
    }

    public ArrayList<GProGuildRobotInfo> getRecommendList() {
        return this.recommendList;
    }

    public int getRobotMaxNum() {
        return this.robotMaxNum;
    }

    public int getRole() {
        return this.role;
    }

    public int getTotalRecommend() {
        return this.totalRecommend;
    }

    public String toString() {
        return "GProGetGuildRobotListRsp{addedList=" + this.addedList + ",recommendList=" + this.recommendList + ",totalRecommend=" + this.totalRecommend + ",role=" + this.role + ",robotMaxNum=" + this.robotMaxNum + ",}";
    }

    public GProGetGuildRobotListRsp(ArrayList<GProGuildRobotInfo> arrayList, ArrayList<GProGuildRobotInfo> arrayList2, int i3, int i16, int i17) {
        this.addedList = new ArrayList<>();
        new ArrayList();
        this.addedList = arrayList;
        this.recommendList = arrayList2;
        this.totalRecommend = i3;
        this.role = i16;
        this.robotMaxNum = i17;
    }
}
