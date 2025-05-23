package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupCmd0xce5Rsp {
    public int maxRobotNum;
    public ArrayList<GroupRobotInfo> robotInfoList;
    public GroupRobotRedPointList robotRedpointList;
    public int role;

    public GroupCmd0xce5Rsp() {
        this.robotInfoList = new ArrayList<>();
        this.robotRedpointList = new GroupRobotRedPointList();
    }

    public int getMaxRobotNum() {
        return this.maxRobotNum;
    }

    public ArrayList<GroupRobotInfo> getRobotInfoList() {
        return this.robotInfoList;
    }

    public GroupRobotRedPointList getRobotRedpointList() {
        return this.robotRedpointList;
    }

    public int getRole() {
        return this.role;
    }

    public String toString() {
        return "GroupCmd0xce5Rsp{robotInfoList=" + this.robotInfoList + ",role=" + this.role + ",maxRobotNum=" + this.maxRobotNum + ",robotRedpointList=" + this.robotRedpointList + ",}";
    }

    public GroupCmd0xce5Rsp(ArrayList<GroupRobotInfo> arrayList, int i3, int i16, GroupRobotRedPointList groupRobotRedPointList) {
        this.robotInfoList = new ArrayList<>();
        new GroupRobotRedPointList();
        this.robotInfoList = arrayList;
        this.role = i3;
        this.maxRobotNum = i16;
        this.robotRedpointList = groupRobotRedPointList;
    }
}
