package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchNetSugWordsRsp {
    public ArrayList<SearchNetSugInfo> netSugInfos = new ArrayList<>();
    public String stringExtension = "";
    public String keyWord = "";
    public SearchTabInfo tab = new SearchTabInfo();

    public String getKeyWord() {
        return this.keyWord;
    }

    public ArrayList<SearchNetSugInfo> getNetSugInfos() {
        return this.netSugInfos;
    }

    public String getStringExtension() {
        return this.stringExtension;
    }

    public SearchTabInfo getTab() {
        return this.tab;
    }

    public String toString() {
        return "SearchNetSugWordsRsp{netSugInfos=" + this.netSugInfos + ",stringExtension=" + this.stringExtension + ",keyWord=" + this.keyWord + ",tab=" + this.tab + ",}";
    }
}
