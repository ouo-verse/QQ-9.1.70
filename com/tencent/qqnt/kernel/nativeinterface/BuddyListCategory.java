package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BuddyListCategory {
    public ArrayList<String> buddyUids;
    public int categoryId;
    public int categorySortId;
    public int categroyMbCount;
    public String categroyName;
    public int onlineCount;

    public BuddyListCategory() {
        this.categroyName = "";
        this.buddyUids = new ArrayList<>();
    }

    public ArrayList<String> getBuddyUids() {
        return this.buddyUids;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public int getCategorySortId() {
        return this.categorySortId;
    }

    public int getCategroyMbCount() {
        return this.categroyMbCount;
    }

    public String getCategroyName() {
        return this.categroyName;
    }

    public int getOnlineCount() {
        return this.onlineCount;
    }

    public BuddyListCategory(int i3, int i16, String str, int i17, int i18, ArrayList<String> arrayList) {
        this.categroyName = "";
        new ArrayList();
        this.categoryId = i3;
        this.categorySortId = i16;
        this.categroyName = str;
        this.categroyMbCount = i17;
        this.onlineCount = i18;
        this.buddyUids = arrayList;
    }
}
