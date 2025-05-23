package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildInfoAndMemberListRsp {
    public int totalMemberCnt;
    public GProGuild guildInfo = new GProGuild();
    public ArrayList<GProUser> memberList = new ArrayList<>();
    public ArrayList<String> avatarMetas = new ArrayList<>();

    public ArrayList<String> getAvatarMetas() {
        return this.avatarMetas;
    }

    public GProGuild getGuildInfo() {
        return this.guildInfo;
    }

    public ArrayList<GProUser> getMemberList() {
        return this.memberList;
    }

    public int getTotalMemberCnt() {
        return this.totalMemberCnt;
    }

    public String toString() {
        return "GProGuildInfoAndMemberListRsp{guildInfo=" + this.guildInfo + ",memberList=" + this.memberList + ",avatarMetas=" + this.avatarMetas + ",totalMemberCnt=" + this.totalMemberCnt + ",}";
    }
}
