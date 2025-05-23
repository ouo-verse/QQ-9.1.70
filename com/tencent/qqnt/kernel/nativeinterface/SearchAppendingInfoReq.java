package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchAppendingInfoReq {
    public ArrayList<SearchAppendingItem> items = new ArrayList<>();
    public String stringExtension = "";
    public SearchTabInfo tabInfo = new SearchTabInfo();
    public String version = "";
    public String keyword = "";

    public ArrayList<SearchAppendingItem> getItems() {
        return this.items;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public String getStringExtension() {
        return this.stringExtension;
    }

    public SearchTabInfo getTabInfo() {
        return this.tabInfo;
    }

    public String getVersion() {
        return this.version;
    }

    public String toString() {
        return "SearchAppendingInfoReq{items=" + this.items + ",stringExtension=" + this.stringExtension + ",tabInfo=" + this.tabInfo + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",keyword=" + this.keyword + ",}";
    }
}
