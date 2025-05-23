package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProFeedAbstract {
    public String feedId = "";
    public String title = "";
    public ArrayList<GProThumbnail> thumbnailList = new ArrayList<>();

    public String getFeedId() {
        return this.feedId;
    }

    public ArrayList<GProThumbnail> getThumbnailList() {
        return this.thumbnailList;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProFeedAbstract{feedId=" + this.feedId + ",title=" + this.title + ",thumbnailList=" + this.thumbnailList + ",}";
    }
}
