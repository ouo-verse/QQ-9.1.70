package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetHotLiveReq {
    public int refreshNum;
    public GProMVPSourceInfo source = new GProMVPSourceInfo();
    public byte[] cookies = new byte[0];
    public String sessionId = "";
    public ArrayList<GProItemIdInfo> needTopItems = new ArrayList<>();

    public byte[] getCookies() {
        return this.cookies;
    }

    public ArrayList<GProItemIdInfo> getNeedTopItems() {
        return this.needTopItems;
    }

    public int getRefreshNum() {
        return this.refreshNum;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public GProMVPSourceInfo getSource() {
        return this.source;
    }

    public String toString() {
        return "GProGetHotLiveReq{source=" + this.source + ",cookies=" + this.cookies + ",refreshNum=" + this.refreshNum + ",sessionId=" + this.sessionId + ",needTopItems=" + this.needTopItems + ",}";
    }
}
