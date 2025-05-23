package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSelectParam {
    public ArrayList<String> feedIds = new ArrayList<>();
    public String searchWord = "";
    public boolean selectChannel;

    public ArrayList<String> getFeedIds() {
        return this.feedIds;
    }

    public String getSearchWord() {
        return this.searchWord;
    }

    public boolean getSelectChannel() {
        return this.selectChannel;
    }

    public String toString() {
        return "GProSelectParam{feedIds=" + this.feedIds + ",selectChannel=" + this.selectChannel + ",searchWord=" + this.searchWord + ",}";
    }
}
