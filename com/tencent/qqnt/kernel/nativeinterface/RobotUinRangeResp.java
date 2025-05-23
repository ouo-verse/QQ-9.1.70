package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotUinRangeResp {
    public ArrayList<RobotUinRange> robotUinRanges;
    public int version;

    public RobotUinRangeResp() {
        this.robotUinRanges = new ArrayList<>();
    }

    public ArrayList<RobotUinRange> getRobotUinRanges() {
        return this.robotUinRanges;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        return "RobotUinRangeResp{version=" + this.version + ",robotUinRanges=" + this.robotUinRanges + ",}";
    }

    public RobotUinRangeResp(int i3, ArrayList<RobotUinRange> arrayList) {
        new ArrayList();
        this.version = i3;
        this.robotUinRanges = arrayList;
    }
}
