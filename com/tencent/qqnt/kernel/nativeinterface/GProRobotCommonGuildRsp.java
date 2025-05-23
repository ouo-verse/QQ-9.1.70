package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRobotCommonGuildRsp {
    public ArrayList<GProRobotCommonGuildInfo> guilds;
    public int total;

    public GProRobotCommonGuildRsp() {
        this.guilds = new ArrayList<>();
    }

    public ArrayList<GProRobotCommonGuildInfo> getGuilds() {
        return this.guilds;
    }

    public int getTotal() {
        return this.total;
    }

    public String toString() {
        return "GProRobotCommonGuildRsp{guilds=" + this.guilds + ",total=" + this.total + ",}";
    }

    public GProRobotCommonGuildRsp(ArrayList<GProRobotCommonGuildInfo> arrayList, int i3) {
        new ArrayList();
        this.guilds = arrayList;
        this.total = i3;
    }
}
