package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DigestShareMsg {
    public String type = "";
    public String title = "";
    public String summary = "";
    public String brief = "";
    public String url = "";
    public String pictureUrl = "";
    public String action = "";
    public String source = "";
    public String sourceUrl = "";

    public String getAction() {
        return this.action;
    }

    public String getBrief() {
        return this.brief;
    }

    public String getPictureUrl() {
        return this.pictureUrl;
    }

    public String getSource() {
        return this.source;
    }

    public String getSourceUrl() {
        return this.sourceUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "DigestShareMsg{type=" + this.type + ",title=" + this.title + ",summary=" + this.summary + ",brief=" + this.brief + JefsClass.INDEX_URL + this.url + ",pictureUrl=" + this.pictureUrl + ",action=" + this.action + ",source=" + this.source + ",sourceUrl=" + this.sourceUrl + ",}";
    }
}
