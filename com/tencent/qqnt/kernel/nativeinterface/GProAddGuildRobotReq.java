package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAddGuildRobotReq {
    public ArrayList<GProGuildRobotAuthSetInfo> authSetInfos;
    public long guildId;
    public long robotUin;
    public int role;

    public GProAddGuildRobotReq() {
        this.authSetInfos = new ArrayList<>();
    }

    public ArrayList<GProGuildRobotAuthSetInfo> getAuthSetInfos() {
        return this.authSetInfos;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public int getRole() {
        return this.role;
    }

    public String toString() {
        return "GProAddGuildRobotReq{guildId=" + this.guildId + ",robotUin=" + this.robotUin + ",role=" + this.role + ",authSetInfos=" + this.authSetInfos + ",}";
    }

    public GProAddGuildRobotReq(long j3, long j16, int i3, ArrayList<GProGuildRobotAuthSetInfo> arrayList) {
        new ArrayList();
        this.guildId = j3;
        this.robotUin = j16;
        this.role = i3;
        this.authSetInfos = arrayList;
    }
}
