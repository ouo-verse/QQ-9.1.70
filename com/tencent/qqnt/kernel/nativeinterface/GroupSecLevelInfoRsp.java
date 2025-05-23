package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSecLevelInfoRsp {
    public long allianceId;
    public long groupCode;
    public int groupFlagExt4;
    public int groupFreezeReason;
    public int groupSecLevel;
    public int groupSecLevelInfo;

    public long getAllianceId() {
        return this.allianceId;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getGroupFlagExt4() {
        return this.groupFlagExt4;
    }

    public int getGroupFreezeReason() {
        return this.groupFreezeReason;
    }

    public int getGroupSecLevel() {
        return this.groupSecLevel;
    }

    public int getGroupSecLevelInfo() {
        return this.groupSecLevelInfo;
    }

    public String toString() {
        return "GroupSecLevelInfoRsp{groupCode=" + this.groupCode + ",groupSecLevel=" + this.groupSecLevel + ",groupSecLevelInfo=" + this.groupSecLevelInfo + ",groupFlagExt4=" + this.groupFlagExt4 + ",groupFreezeReason=" + this.groupFreezeReason + ",allianceId=" + this.allianceId + ",}";
    }
}
