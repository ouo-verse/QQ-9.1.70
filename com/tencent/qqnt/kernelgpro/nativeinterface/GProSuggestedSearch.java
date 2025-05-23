package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSuggestedSearch {
    public String title = "";
    public ArrayList<String> contentList = new ArrayList<>();

    public ArrayList<String> getContentList() {
        return this.contentList;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProSuggestedSearch{title=" + this.title + ",contentList=" + this.contentList + ",}";
    }
}
