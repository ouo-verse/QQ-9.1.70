package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFetchUserJoinedGuildListReq {
    public String cookie = "";
    public long guildId;
    public int pageSize;
    public long tinyId;

    public String getCookie() {
        return this.cookie;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProFetchUserJoinedGuildListReq{guildId=" + this.guildId + ",tinyId=" + this.tinyId + ",cookie=" + this.cookie + ",pageSize=" + this.pageSize + ",}";
    }
}
