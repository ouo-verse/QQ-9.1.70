package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRemoveRiskMembersReq {
    public boolean addBlack;
    public long guildId;
    public boolean removeFromGuild;
    public int revokeType;
    public boolean selectAll;
    public ArrayList<Long> tinyidList;

    public GProRemoveRiskMembersReq() {
        this.tinyidList = new ArrayList<>();
    }

    public boolean getAddBlack() {
        return this.addBlack;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getRemoveFromGuild() {
        return this.removeFromGuild;
    }

    public int getRevokeType() {
        return this.revokeType;
    }

    public boolean getSelectAll() {
        return this.selectAll;
    }

    public ArrayList<Long> getTinyidList() {
        return this.tinyidList;
    }

    public void setAddBlack(boolean z16) {
        this.addBlack = z16;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setRemoveFromGuild(boolean z16) {
        this.removeFromGuild = z16;
    }

    public void setRevokeType(int i3) {
        this.revokeType = i3;
    }

    public void setSelectAll(boolean z16) {
        this.selectAll = z16;
    }

    public void setTinyidList(ArrayList<Long> arrayList) {
        this.tinyidList = arrayList;
    }

    public String toString() {
        return "GProRemoveRiskMembersReq{tinyidList=" + this.tinyidList + ",selectAll=" + this.selectAll + ",guildId=" + this.guildId + ",addBlack=" + this.addBlack + ",removeFromGuild=" + this.removeFromGuild + ",revokeType=" + this.revokeType + ",}";
    }

    public GProRemoveRiskMembersReq(ArrayList<Long> arrayList, boolean z16, long j3, boolean z17, boolean z18, int i3) {
        new ArrayList();
        this.tinyidList = arrayList;
        this.selectAll = z16;
        this.guildId = j3;
        this.addBlack = z17;
        this.removeFromGuild = z18;
        this.revokeType = i3;
    }
}
