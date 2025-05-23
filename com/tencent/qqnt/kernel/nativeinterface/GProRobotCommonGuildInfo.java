package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRobotCommonGuildInfo {
    public String guildFace;
    public long guildFaceSeq;
    public long guildId;
    public String guildName;
    public ArrayList<GProGuildRobot> robotsStatus;
    public int status;

    public GProRobotCommonGuildInfo() {
        this.guildName = "";
        this.guildFace = "";
        this.robotsStatus = new ArrayList<>();
    }

    public String getGuildFace() {
        return this.guildFace;
    }

    public long getGuildFaceSeq() {
        return this.guildFaceSeq;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public ArrayList<GProGuildRobot> getRobotsStatus() {
        return this.robotsStatus;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return "GProRobotCommonGuildInfo{guildName=" + this.guildName + ",guildId=" + this.guildId + ",status=" + this.status + ",guildFace=" + this.guildFace + ",guildFaceSeq=" + this.guildFaceSeq + ",robotsStatus=" + this.robotsStatus + ",}";
    }

    public GProRobotCommonGuildInfo(String str, long j3, int i3, String str2, long j16, ArrayList<GProGuildRobot> arrayList) {
        this.guildName = "";
        this.guildFace = "";
        new ArrayList();
        this.guildName = str;
        this.guildId = j3;
        this.status = i3;
        this.guildFace = str2;
        this.guildFaceSeq = j16;
        this.robotsStatus = arrayList;
    }
}
