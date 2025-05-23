package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetJoinedRecommendItemsRsp {
    public boolean isEnd;
    public ArrayList<GProJoinedRecommendItem> items = new ArrayList<>();
    public String sessionId = "";
    public String traceId = "";
    public byte[] cookies = new byte[0];

    public byte[] getCookies() {
        return this.cookies;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<GProJoinedRecommendItem> getItems() {
        return this.items;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProGetJoinedRecommendItemsRsp{items=" + this.items + ",sessionId=" + this.sessionId + ",traceId=" + this.traceId + ",isEnd=" + this.isEnd + ",cookies=" + this.cookies + ",}";
    }
}
