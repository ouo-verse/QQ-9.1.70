package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStClientInfo {
    public String feedclientkey = "";
    public ArrayList<GProFeedEntry> clientMapList = new ArrayList<>();

    public ArrayList<GProFeedEntry> getClientMapList() {
        return this.clientMapList;
    }

    public String getFeedclientkey() {
        return this.feedclientkey;
    }

    public String toString() {
        return "GProStClientInfo{feedclientkey=" + this.feedclientkey + ",clientMapList=" + this.clientMapList + ",}";
    }
}
