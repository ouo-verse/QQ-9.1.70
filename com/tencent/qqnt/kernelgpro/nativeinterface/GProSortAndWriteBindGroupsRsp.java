package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSortAndWriteBindGroupsRsp {
    public ArrayList<Long> groupCodeList = new ArrayList<>();
    public long guildId;

    public ArrayList<Long> getGroupCodeList() {
        return this.groupCodeList;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProSortAndWriteBindGroupsRsp{guildId=" + this.guildId + ",groupCodeList=" + this.groupCodeList + ",}";
    }
}
