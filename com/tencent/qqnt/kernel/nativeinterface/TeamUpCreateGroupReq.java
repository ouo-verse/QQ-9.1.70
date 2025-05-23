package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TeamUpCreateGroupReq {
    public String teamId = "";
    public ArrayList<Long> participants = new ArrayList<>();

    public ArrayList<Long> getParticipants() {
        return this.participants;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public String toString() {
        return "TeamUpCreateGroupReq{teamId=" + this.teamId + ",participants=" + this.participants + ",}";
    }
}
