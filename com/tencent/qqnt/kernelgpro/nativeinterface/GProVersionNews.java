package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProVersionNews {
    public String jumpFeedUrl;
    public ArrayList<String> newsUrlList;
    public String subtitle;
    public String title;

    public GProVersionNews() {
        this.title = "";
        this.subtitle = "";
        this.newsUrlList = new ArrayList<>();
        this.jumpFeedUrl = "";
    }

    public String getJumpFeedUrl() {
        return this.jumpFeedUrl;
    }

    public ArrayList<String> getNewsUrlList() {
        return this.newsUrlList;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProVersionNews{title=" + this.title + ",subtitle=" + this.subtitle + ",newsUrlList=" + this.newsUrlList + ",jumpFeedUrl=" + this.jumpFeedUrl + ",}";
    }

    public GProVersionNews(String str, String str2, ArrayList<String> arrayList, String str3) {
        this.title = "";
        this.subtitle = "";
        new ArrayList();
        this.title = str;
        this.subtitle = str2;
        this.newsUrlList = arrayList;
        this.jumpFeedUrl = str3;
    }
}
