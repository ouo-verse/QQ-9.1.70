package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupRobotInfoFor0x91ee {
    public boolean isAdded;
    public GroupRobotBaseInfo baseInfo = new GroupRobotBaseInfo();
    public ArrayList<String> labels = new ArrayList<>();

    public GroupRobotBaseInfo getBaseInfo() {
        return this.baseInfo;
    }

    public boolean getIsAdded() {
        return this.isAdded;
    }

    public ArrayList<String> getLabels() {
        return this.labels;
    }

    public String toString() {
        return "GroupRobotInfoFor0x91ee{baseInfo=" + this.baseInfo + ",isAdded=" + this.isAdded + ",labels=" + this.labels + ",}";
    }
}
