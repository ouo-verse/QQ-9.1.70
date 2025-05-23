package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSquareBannerItem {
    public long bannerId;
    public int urlType;
    public String title = "";
    public String desc = "";
    public String summary = "";
    public String cover = "";
    public String url = "";
    public String shortCover = "";

    public long getBannerId() {
        return this.bannerId;
    }

    public String getCover() {
        return this.cover;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getShortCover() {
        return this.shortCover;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public int getUrlType() {
        return this.urlType;
    }

    public String toString() {
        return "GroupSquareBannerItem{bannerId=" + this.bannerId + ",title=" + this.title + ",desc=" + this.desc + ",summary=" + this.summary + ",cover=" + this.cover + ",urlType=" + this.urlType + JefsClass.INDEX_URL + this.url + ",shortCover=" + this.shortCover + ",}";
    }
}
