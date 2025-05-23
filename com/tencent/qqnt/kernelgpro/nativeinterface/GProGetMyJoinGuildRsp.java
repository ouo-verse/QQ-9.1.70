package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetMyJoinGuildRsp {
    public ArrayList<GProJoinGuild> joinGuilds = new ArrayList<>();

    public ArrayList<GProJoinGuild> getJoinGuilds() {
        return this.joinGuilds;
    }

    public String toString() {
        return "GProGetMyJoinGuildRsp{joinGuilds=" + this.joinGuilds + ",}";
    }
}
