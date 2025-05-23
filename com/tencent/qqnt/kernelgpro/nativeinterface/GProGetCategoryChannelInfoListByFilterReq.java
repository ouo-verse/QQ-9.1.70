package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetCategoryChannelInfoListByFilterReq {
    public ArrayList<Long> categoryIdList = new ArrayList<>();
    public ArrayList<Integer> categoryTypeList = new ArrayList<>();
    public long guildId;

    public ArrayList<Long> getCategoryIdList() {
        return this.categoryIdList;
    }

    public ArrayList<Integer> getCategoryTypeList() {
        return this.categoryTypeList;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProGetCategoryChannelInfoListByFilterReq{guildId=" + this.guildId + ",categoryIdList=" + this.categoryIdList + ",categoryTypeList=" + this.categoryTypeList + ",}";
    }
}
