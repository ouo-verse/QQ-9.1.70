package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetTeamUpMembersRsp {
    public ArrayList<TeamUpMemberInfo> memberInfoList = new ArrayList<>();

    public ArrayList<TeamUpMemberInfo> getMemberInfoList() {
        return this.memberInfoList;
    }

    public String toString() {
        return "GetTeamUpMembersRsp{memberInfoList=" + this.memberInfoList + ",}";
    }
}
