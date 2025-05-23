package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetFeedsByIndexRsp {
    public boolean isEnd;
    public ArrayList<GProIndexFeedItem> indexItems = new ArrayList<>();
    public String totalStr = "";
    public byte[] cookie = new byte[0];

    public byte[] getCookie() {
        return this.cookie;
    }

    public ArrayList<GProIndexFeedItem> getIndexItems() {
        return this.indexItems;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public String getTotalStr() {
        return this.totalStr;
    }

    public String toString() {
        return "GProGetFeedsByIndexRsp{indexItems=" + this.indexItems + ",totalStr=" + this.totalStr + ",cookie=" + this.cookie + ",isEnd=" + this.isEnd + ",}";
    }
}
