package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetSelectChannelIDRsp {
    public ArrayList<Long> guildIds;
    public ArrayList<GProGuildInfoInLabel> guildInfos;

    public GProGetSelectChannelIDRsp() {
        this.guildIds = new ArrayList<>();
        this.guildInfos = new ArrayList<>();
    }

    public ArrayList<Long> getGuildIds() {
        return this.guildIds;
    }

    public ArrayList<GProGuildInfoInLabel> getGuildInfos() {
        return this.guildInfos;
    }

    public String toString() {
        return "GProGetSelectChannelIDRsp{guildIds=" + this.guildIds + ",guildInfos=" + this.guildInfos + ",}";
    }

    public GProGetSelectChannelIDRsp(ArrayList<Long> arrayList, ArrayList<GProGuildInfoInLabel> arrayList2) {
        this.guildIds = new ArrayList<>();
        new ArrayList();
        this.guildIds = arrayList;
        this.guildInfos = arrayList2;
    }
}
