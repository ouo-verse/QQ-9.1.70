package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStLiteBanner {
    public GProStImage icon = new GProStImage();
    public String title = "";
    public String jumpUrl = "";
    public String activityID = "";
    public String jsonStyle = "";
    public ArrayList<GProFeedEntry> extInfoList = new ArrayList<>();

    public String getActivityID() {
        return this.activityID;
    }

    public ArrayList<GProFeedEntry> getExtInfoList() {
        return this.extInfoList;
    }

    public GProStImage getIcon() {
        return this.icon;
    }

    public String getJsonStyle() {
        return this.jsonStyle;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProStLiteBanner{icon=" + this.icon + ",title=" + this.title + ",jumpUrl=" + this.jumpUrl + ",activityID=" + this.activityID + ",jsonStyle=" + this.jsonStyle + ",extInfoList=" + this.extInfoList + ",}";
    }
}
