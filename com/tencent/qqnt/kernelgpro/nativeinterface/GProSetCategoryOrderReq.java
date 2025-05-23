package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSetCategoryOrderReq {
    public long guildId;
    public ArrayList<Long> enableList = new ArrayList<>();
    public ArrayList<Long> disableList = new ArrayList<>();

    public ArrayList<Long> getDisableList() {
        return this.disableList;
    }

    public ArrayList<Long> getEnableList() {
        return this.enableList;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProSetCategoryOrderReq{guildId=" + this.guildId + ",enableList=" + this.enableList + ",disableList=" + this.disableList + ",}";
    }
}
