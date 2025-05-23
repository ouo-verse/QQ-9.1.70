package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildInfoInLabel implements Serializable {
    public String guildIcon;
    public long guildId;
    public ArrayList<String> guildLabels;
    public String guildName;
    public int guildStatus;
    public String joinGuildSig;
    long serialVersionUID;

    public GProGuildInfoInLabel() {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.guildIcon = "";
        this.guildLabels = new ArrayList<>();
        this.joinGuildSig = "";
    }

    public String getGuildIcon() {
        return this.guildIcon;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<String> getGuildLabels() {
        return this.guildLabels;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public int getGuildStatus() {
        return this.guildStatus;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public String toString() {
        return "GProGuildInfoInLabel{guildId=" + this.guildId + ",guildName=" + this.guildName + ",guildIcon=" + this.guildIcon + ",guildLabels=" + this.guildLabels + ",guildStatus=" + this.guildStatus + ",joinGuildSig=" + this.joinGuildSig + ",}";
    }

    public GProGuildInfoInLabel(long j3, String str, String str2, ArrayList<String> arrayList, int i3, String str3) {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.guildIcon = "";
        new ArrayList();
        this.guildId = j3;
        this.guildName = str;
        this.guildIcon = str2;
        this.guildLabels = arrayList;
        this.guildStatus = i3;
        this.joinGuildSig = str3;
    }
}
