package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetSimpleProfileAsyncReq {
    public long guildId;
    public int srcType;
    public long tinyId;

    public long getGuildId() {
        return this.guildId;
    }

    public int getSrcType() {
        return this.srcType;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProGetSimpleProfileAsyncReq{guildId=" + this.guildId + ",tinyId=" + this.tinyId + ",srcType=" + this.srcType + ",}";
    }
}
