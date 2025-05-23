package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchGroup {
    public boolean exactSearch;
    public int groupNum;
    public String keyWords;
    public String penetrate;
    public String platform;
    public Integer version;

    public SearchGroup() {
        this.penetrate = "";
    }

    public boolean getExactSearch() {
        return this.exactSearch;
    }

    public int getGroupNum() {
        return this.groupNum;
    }

    public String getKeyWords() {
        return this.keyWords;
    }

    public String getPenetrate() {
        return this.penetrate;
    }

    public String getPlatform() {
        return this.platform;
    }

    public Integer getVersion() {
        return this.version;
    }

    public String toString() {
        return "SearchGroup{keyWords=" + this.keyWords + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",platform=" + this.platform + ",penetrate=" + this.penetrate + ",exactSearch=" + this.exactSearch + ",groupNum=" + this.groupNum + ",}";
    }

    public SearchGroup(String str, Integer num, String str2, String str3, boolean z16, int i3) {
        this.keyWords = str;
        this.version = num;
        this.platform = str2;
        this.penetrate = str3;
        this.exactSearch = z16;
        this.groupNum = i3;
    }
}
