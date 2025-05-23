package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildRobotInfo {
    public String robotAvatar;
    public boolean robotBan;
    public String robotDesc;
    public ArrayList<GProGuildRobotFeature> robotFeatures;
    public String robotName;
    public int robotOffline;
    public int robotTestStatus;
    public long robotTid;
    public long robotUin;
    public ArrayList<String> tags;

    public GProGuildRobotInfo() {
        this.robotName = "";
        this.robotAvatar = "";
        this.robotDesc = "";
        this.robotFeatures = new ArrayList<>();
        this.tags = new ArrayList<>();
    }

    public String getRobotAvatar() {
        return this.robotAvatar;
    }

    public boolean getRobotBan() {
        return this.robotBan;
    }

    public String getRobotDesc() {
        return this.robotDesc;
    }

    public ArrayList<GProGuildRobotFeature> getRobotFeatures() {
        return this.robotFeatures;
    }

    public String getRobotName() {
        return this.robotName;
    }

    public int getRobotOffline() {
        return this.robotOffline;
    }

    public int getRobotTestStatus() {
        return this.robotTestStatus;
    }

    public long getRobotTid() {
        return this.robotTid;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public String toString() {
        return "GProGuildRobotInfo{robotUin=" + this.robotUin + ",robotName=" + this.robotName + ",robotAvatar=" + this.robotAvatar + ",robotDesc=" + this.robotDesc + ",robotOffline=" + this.robotOffline + ",robotFeatures=" + this.robotFeatures + ",robotTestStatus=" + this.robotTestStatus + ",robotTid=" + this.robotTid + ",robotBan=" + this.robotBan + ",tags=" + this.tags + ",}";
    }

    public GProGuildRobotInfo(long j3, String str, String str2, String str3, int i3, ArrayList<GProGuildRobotFeature> arrayList, int i16, long j16, boolean z16, ArrayList<String> arrayList2) {
        this.robotName = "";
        this.robotAvatar = "";
        this.robotDesc = "";
        this.robotFeatures = new ArrayList<>();
        new ArrayList();
        this.robotUin = j3;
        this.robotName = str;
        this.robotAvatar = str2;
        this.robotDesc = str3;
        this.robotOffline = i3;
        this.robotFeatures = arrayList;
        this.robotTestStatus = i16;
        this.robotTid = j16;
        this.robotBan = z16;
        this.tags = arrayList2;
    }
}
