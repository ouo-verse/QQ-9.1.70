package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchFunctionItem {
    public int fid;
    public String name = "";
    public String headUrl = "";
    public String iOSJumpUrl = "";
    public String androidJumpUrl = "";
    public ArrayList<SearchHitInfo> nameHits = new ArrayList<>();

    public String getAndroidJumpUrl() {
        return this.androidJumpUrl;
    }

    public int getFid() {
        return this.fid;
    }

    public String getHeadUrl() {
        return this.headUrl;
    }

    public String getIOSJumpUrl() {
        return this.iOSJumpUrl;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<SearchHitInfo> getNameHits() {
        return this.nameHits;
    }

    public String toString() {
        return "SearchFunctionItem{fid=" + this.fid + ",name=" + this.name + ",headUrl=" + this.headUrl + ",iOSJumpUrl=" + this.iOSJumpUrl + ",androidJumpUrl=" + this.androidJumpUrl + ",nameHits=" + this.nameHits + ",}";
    }
}
