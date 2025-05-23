package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TeamUpInviteToGroupReq {
    public String teamId = "";
    public ArrayList<Long> participantList = new ArrayList<>();

    public ArrayList<Long> getParticipantList() {
        return this.participantList;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public String toString() {
        return "TeamUpInviteToGroupReq{teamId=" + this.teamId + ",participantList=" + this.participantList + ",}";
    }
}
