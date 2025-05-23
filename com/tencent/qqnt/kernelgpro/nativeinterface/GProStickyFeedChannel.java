package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStickyFeedChannel implements Serializable {
    long serialVersionUID = 1;
    public String feedCount = "";
    public ArrayList<GProFeedSummary> feedSummaryList = new ArrayList<>();
    public String activeMemberCount = "";
    public ArrayList<GProUser> activeMemberList = new ArrayList<>();

    public String getActiveMemberCount() {
        return this.activeMemberCount;
    }

    public ArrayList<GProUser> getActiveMemberList() {
        return this.activeMemberList;
    }

    public String getFeedCount() {
        return this.feedCount;
    }

    public ArrayList<GProFeedSummary> getFeedSummaryList() {
        return this.feedSummaryList;
    }

    public String toString() {
        return "GProStickyFeedChannel{feedCount=" + this.feedCount + ",feedSummaryList=" + this.feedSummaryList + ",activeMemberCount=" + this.activeMemberCount + ",activeMemberList=" + this.activeMemberList + ",}";
    }
}
