package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetTeamUpDetailReq {
    public long groupId;
    public String teamId = "";

    public long getGroupId() {
        return this.groupId;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public String toString() {
        return "GetTeamUpDetailReq{teamId=" + this.teamId + ",groupId=" + this.groupId + ",}";
    }
}
