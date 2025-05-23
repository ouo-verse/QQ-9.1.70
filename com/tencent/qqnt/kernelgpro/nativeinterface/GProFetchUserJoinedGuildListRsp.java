package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFetchUserJoinedGuildListRsp {
    public boolean isEnd;
    public GProUserJoinedGuildSummary joinedGuildSummary = new GProUserJoinedGuildSummary();
    public String cookie = "";

    public String getCookie() {
        return this.cookie;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public GProUserJoinedGuildSummary getJoinedGuildSummary() {
        return this.joinedGuildSummary;
    }

    public String toString() {
        return "GProFetchUserJoinedGuildListRsp{joinedGuildSummary=" + this.joinedGuildSummary + ",isEnd=" + this.isEnd + ",cookie=" + this.cookie + ",}";
    }
}
