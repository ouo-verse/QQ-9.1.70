package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetJoinedRecommendItemsReq {
    public String transInfo = "";
    public String sessionId = "";
    public ArrayList<Integer> moduleIds = new ArrayList<>();
    public byte[] cookies = new byte[0];

    public byte[] getCookies() {
        return this.cookies;
    }

    public ArrayList<Integer> getModuleIds() {
        return this.moduleIds;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getTransInfo() {
        return this.transInfo;
    }

    public String toString() {
        return "GProGetJoinedRecommendItemsReq{transInfo=" + this.transInfo + ",sessionId=" + this.sessionId + ",moduleIds=" + this.moduleIds + ",cookies=" + this.cookies + ",}";
    }
}
