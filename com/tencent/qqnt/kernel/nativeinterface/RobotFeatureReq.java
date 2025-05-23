package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotFeatureReq {
    public String robotUid = "";
    public RobotFeatureFetchType fetchType = RobotFeatureFetchType.values()[0];
    public RobotSourceType sourceType = RobotSourceType.values()[0];

    public RobotFeatureFetchType getFetchType() {
        return this.fetchType;
    }

    public String getRobotUid() {
        return this.robotUid;
    }

    public RobotSourceType getSourceType() {
        return this.sourceType;
    }

    public String toString() {
        return "RobotFeatureReq{robotUid=" + this.robotUid + ",fetchType=" + this.fetchType + ",sourceType=" + this.sourceType + ",}";
    }
}
