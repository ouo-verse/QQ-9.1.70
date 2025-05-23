package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupCmd0xce5Req {
    public long groupId;
    public int noGraytips;
    public ArrayList<GroupRobotInfo> robotInfoList;
    public int serviceType;

    public GroupCmd0xce5Req() {
        this.robotInfoList = new ArrayList<>();
    }

    public long getGroupId() {
        return this.groupId;
    }

    public int getNoGraytips() {
        return this.noGraytips;
    }

    public ArrayList<GroupRobotInfo> getRobotInfoList() {
        return this.robotInfoList;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public String toString() {
        return "GroupCmd0xce5Req{groupId=" + this.groupId + ",robotInfoList=" + this.robotInfoList + ",noGraytips=" + this.noGraytips + ",serviceType=" + this.serviceType + ",}";
    }

    public GroupCmd0xce5Req(long j3, ArrayList<GroupRobotInfo> arrayList, int i3, int i16) {
        new ArrayList();
        this.groupId = j3;
        this.robotInfoList = arrayList;
        this.noGraytips = i3;
        this.serviceType = i16;
    }
}
