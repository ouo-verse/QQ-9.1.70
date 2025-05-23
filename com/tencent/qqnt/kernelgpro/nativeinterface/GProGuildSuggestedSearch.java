package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildSuggestedSearch {
    public ArrayList<String> content;
    public String title;

    public GProGuildSuggestedSearch() {
        this.title = "";
        this.content = new ArrayList<>();
    }

    public ArrayList<String> getContent() {
        return this.content;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProGuildSuggestedSearch{title=" + this.title + ",content=" + this.content + ",}";
    }

    public GProGuildSuggestedSearch(String str, ArrayList<String> arrayList) {
        this.title = "";
        new ArrayList();
        this.title = str;
        this.content = arrayList;
    }
}
