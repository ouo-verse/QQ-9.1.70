package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProMsgSearchRsp {
    public boolean hasMore;
    public ArrayList<GProGuildMsg> results = new ArrayList<>();
    public String cookie = "";
    public GProDocHit docHit = new GProDocHit();

    public String getCookie() {
        return this.cookie;
    }

    public GProDocHit getDocHit() {
        return this.docHit;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public ArrayList<GProGuildMsg> getResults() {
        return this.results;
    }

    public String toString() {
        return "GProMsgSearchRsp{results=" + this.results + ",cookie=" + this.cookie + ",hasMore=" + this.hasMore + ",docHit=" + this.docHit + ",}";
    }
}
