package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProFeedSummary implements Serializable {
    long serialVersionUID = 1;
    public String feedId = "";
    public String title = "";
    public ArrayList<GProFeedThumbnail> feedThumbnails = new ArrayList<>();

    public String getFeedId() {
        return this.feedId;
    }

    public ArrayList<GProFeedThumbnail> getFeedThumbnails() {
        return this.feedThumbnails;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProFeedSummary{feedId=" + this.feedId + ",title=" + this.title + ",feedThumbnails=" + this.feedThumbnails + ",}";
    }
}
