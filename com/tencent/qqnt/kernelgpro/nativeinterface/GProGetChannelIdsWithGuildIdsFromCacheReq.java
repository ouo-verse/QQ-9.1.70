package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetChannelIdsWithGuildIdsFromCacheReq {
    public ArrayList<Long> guildIds;
    public ArrayList<Integer> validChannelTypes;

    public GProGetChannelIdsWithGuildIdsFromCacheReq() {
        this.guildIds = new ArrayList<>();
        this.validChannelTypes = new ArrayList<>();
    }

    public ArrayList<Long> getGuildIds() {
        return this.guildIds;
    }

    public ArrayList<Integer> getValidChannelTypes() {
        return this.validChannelTypes;
    }

    public String toString() {
        return "GProGetChannelIdsWithGuildIdsFromCacheReq{guildIds=" + this.guildIds + ",validChannelTypes=" + this.validChannelTypes + ",}";
    }

    public GProGetChannelIdsWithGuildIdsFromCacheReq(ArrayList<Long> arrayList, ArrayList<Integer> arrayList2) {
        this.guildIds = new ArrayList<>();
        new ArrayList();
        this.guildIds = arrayList;
        this.validChannelTypes = arrayList2;
    }
}
