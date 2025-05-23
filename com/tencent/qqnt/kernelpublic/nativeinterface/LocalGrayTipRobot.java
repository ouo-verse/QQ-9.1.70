package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class LocalGrayTipRobot implements Serializable {
    public boolean isBlackRobot;
    public long robotTid;
    long serialVersionUID = 1;

    public LocalGrayTipRobot() {
    }

    public boolean getIsBlackRobot() {
        return this.isBlackRobot;
    }

    public long getRobotTid() {
        return this.robotTid;
    }

    public String toString() {
        return "LocalGrayTipRobot{robotTid=" + this.robotTid + ",isBlackRobot=" + this.isBlackRobot + ",}";
    }

    public LocalGrayTipRobot(long j3, boolean z16) {
        this.robotTid = j3;
        this.isBlackRobot = z16;
    }
}
