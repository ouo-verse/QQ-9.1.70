package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsSearchSuggestItem {
    public int type;
    public String title = "";
    public String url = "";

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "UfsSearchSuggestItem{title=" + this.title + ",type=" + this.type + JefsClass.INDEX_URL + this.url + ",}";
    }
}
