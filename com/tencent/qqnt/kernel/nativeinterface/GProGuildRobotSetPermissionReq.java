package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildRobotSetPermissionReq {
    public ArrayList<GProGuildRobotAuthSetInfo> authSetInfos;
    public long guildId;
    public long robotUin;
    public int role;
    public int setType;

    public GProGuildRobotSetPermissionReq() {
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

    public int getSetType() {
        return this.setType;
    }

    public String toString() {
        return "GProGuildRobotSetPermissionReq{guildId=" + this.guildId + ",robotUin=" + this.robotUin + ",role=" + this.role + ",authSetInfos=" + this.authSetInfos + ",setType=" + this.setType + ",}";
    }

    public GProGuildRobotSetPermissionReq(long j3, long j16, int i3, ArrayList<GProGuildRobotAuthSetInfo> arrayList, int i16) {
        new ArrayList();
        this.guildId = j3;
        this.robotUin = j16;
        this.role = i3;
        this.authSetInfos = arrayList;
        this.setType = i16;
    }
}
