package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProReportTarget {
    public ArrayList<Long> uin = new ArrayList<>();
    public ArrayList<Long> guildId = new ArrayList<>();
    public ArrayList<Long> groupId = new ArrayList<>();

    public ArrayList<Long> getGroupId() {
        return this.groupId;
    }

    public ArrayList<Long> getGuildId() {
        return this.guildId;
    }

    public ArrayList<Long> getUin() {
        return this.uin;
    }

    public String toString() {
        return "GProReportTarget{uin=" + this.uin + ",guildId=" + this.guildId + ",groupId=" + this.groupId + ",}";
    }
}
