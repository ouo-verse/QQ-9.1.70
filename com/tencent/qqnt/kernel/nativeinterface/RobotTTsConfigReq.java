package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotTTsConfigReq {
    public int autoTts;
    public String robotUid = "";
    public String pickTtsId = "";

    public int getAutoTts() {
        return this.autoTts;
    }

    public String getPickTtsId() {
        return this.pickTtsId;
    }

    public String getRobotUid() {
        return this.robotUid;
    }

    public String toString() {
        return "RobotTTsConfigReq{robotUid=" + this.robotUid + ",pickTtsId=" + this.pickTtsId + ",autoTts=" + this.autoTts + ",}";
    }
}
