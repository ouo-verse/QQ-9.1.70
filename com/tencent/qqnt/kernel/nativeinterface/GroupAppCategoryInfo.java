package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupAppCategoryInfo {
    public String title = "";
    public ArrayList<GroupAppItem> appItemList = new ArrayList<>();

    public ArrayList<GroupAppItem> getAppItemList() {
        return this.appItemList;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GroupAppCategoryInfo{title=" + this.title + ",appItemList=" + this.appItemList + ",}";
    }
}
