package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProBatchGetGuildLabelInfoReq {
    public ArrayList<Long> guildIds = new ArrayList<>();
    public int reqSource;

    public ArrayList<Long> getGuildIds() {
        return this.guildIds;
    }

    public int getReqSource() {
        return this.reqSource;
    }

    public String toString() {
        return "GProBatchGetGuildLabelInfoReq{guildIds=" + this.guildIds + ",reqSource=" + this.reqSource + ",}";
    }
}
