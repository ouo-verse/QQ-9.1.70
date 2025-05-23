package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TeamUpApplyReq {
    public String teamId = "";
    public ArrayList<TeamUpImage> pictures = new ArrayList<>();

    public ArrayList<TeamUpImage> getPictures() {
        return this.pictures;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public String toString() {
        return "TeamUpApplyReq{teamId=" + this.teamId + ",pictures=" + this.pictures + ",}";
    }
}
