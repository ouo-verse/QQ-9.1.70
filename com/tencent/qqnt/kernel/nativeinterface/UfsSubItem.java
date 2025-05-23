package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsSubItem {
    public int layoutId;
    public int mediaTotalCount;
    public int showArrow;
    public ArrayList<UfsSubItemText> titleList = new ArrayList<>();
    public ArrayList<UfsSubItemText> summaryList = new ArrayList<>();
    public ArrayList<UfsSubItemMedia> mediaList = new ArrayList<>();
    public String jumpUrl = "";
    public String backgroudColor = "";

    public String getBackgroudColor() {
        return this.backgroudColor;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getLayoutId() {
        return this.layoutId;
    }

    public ArrayList<UfsSubItemMedia> getMediaList() {
        return this.mediaList;
    }

    public int getMediaTotalCount() {
        return this.mediaTotalCount;
    }

    public int getShowArrow() {
        return this.showArrow;
    }

    public ArrayList<UfsSubItemText> getSummaryList() {
        return this.summaryList;
    }

    public ArrayList<UfsSubItemText> getTitleList() {
        return this.titleList;
    }

    public String toString() {
        return "UfsSubItem{layoutId=" + this.layoutId + ",titleList=" + this.titleList + ",summaryList=" + this.summaryList + ",mediaTotalCount=" + this.mediaTotalCount + ",mediaList=" + this.mediaList + ",jumpUrl=" + this.jumpUrl + ",showArrow=" + this.showArrow + ",backgroudColor=" + this.backgroudColor + ",}";
    }
}
