package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BuddyCategorySortInfo {
    public int categoryId;
    public String categroyName;

    public BuddyCategorySortInfo() {
        this.categroyName = "";
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public String getCategroyName() {
        return this.categroyName;
    }

    public BuddyCategorySortInfo(int i3, String str) {
        this.categoryId = i3;
        this.categroyName = str;
    }
}
