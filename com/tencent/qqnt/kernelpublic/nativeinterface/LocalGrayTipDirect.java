package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class LocalGrayTipDirect implements Serializable {
    public String robotName;
    public long robotTid;
    public long robotUin;
    long serialVersionUID;

    public LocalGrayTipDirect() {
        this.serialVersionUID = 1L;
        this.robotName = "";
    }

    public String getRobotName() {
        return this.robotName;
    }

    public long getRobotTid() {
        return this.robotTid;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public String toString() {
        return "LocalGrayTipDirect{robotTid=" + this.robotTid + ",robotUin=" + this.robotUin + ",robotName=" + this.robotName + ",}";
    }

    public LocalGrayTipDirect(long j3, long j16, String str) {
        this.serialVersionUID = 1L;
        this.robotTid = j3;
        this.robotUin = j16;
        this.robotName = str;
    }
}
