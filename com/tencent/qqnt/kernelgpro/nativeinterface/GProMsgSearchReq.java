package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProMsgSearchReq {
    public GProMsgSearchCond cond;
    public String cookie;
    public Integer count;
    public long guildId;
    public String query;
    public long tinyId;
    public Integer type;

    public GProMsgSearchReq() {
        this.cookie = "";
    }

    public GProMsgSearchCond getCond() {
        return this.cond;
    }

    public String getCookie() {
        return this.cookie;
    }

    public Integer getCount() {
        return this.count;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getQuery() {
        return this.query;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public Integer getType() {
        return this.type;
    }

    public String toString() {
        return "GProMsgSearchReq{tinyId=" + this.tinyId + ",guildId=" + this.guildId + ",query=" + this.query + ",type=" + this.type + ",cond=" + this.cond + ",cookie=" + this.cookie + ",count=" + this.count + ",}";
    }

    public GProMsgSearchReq(long j3, long j16, String str, Integer num, GProMsgSearchCond gProMsgSearchCond, String str2, Integer num2) {
        this.tinyId = j3;
        this.guildId = j16;
        this.query = str;
        this.type = num;
        this.cond = gProMsgSearchCond;
        this.cookie = str2;
        this.count = num2;
    }
}
