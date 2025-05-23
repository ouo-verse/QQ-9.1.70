package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildSearchNewSearchReq {
    public long guildId;
    public long tinyid;
    public String query = "";
    public byte[] cookie = new byte[0];
    public GProGuildSearchSearchType searchType = new GProGuildSearchSearchType();
    public GProGuildSearchSearchCond cond = new GProGuildSearchSearchCond();

    public GProGuildSearchSearchCond getCond() {
        return this.cond;
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getQuery() {
        return this.query;
    }

    public GProGuildSearchSearchType getSearchType() {
        return this.searchType;
    }

    public long getTinyid() {
        return this.tinyid;
    }

    public String toString() {
        return "GProGuildSearchNewSearchReq{tinyid=" + this.tinyid + ",guildId=" + this.guildId + ",query=" + this.query + ",cookie=" + this.cookie + ",searchType=" + this.searchType + ",cond=" + this.cond + ",}";
    }
}
