package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BuddyCategory implements IKernelModel {
    public ArrayList<UserSimpleInfo> buddyList;
    public int categoryId;
    public int categorySortId;
    public int categroyMbCount;
    public String categroyName;

    public BuddyCategory() {
        this.categroyName = "";
        this.buddyList = new ArrayList<>();
    }

    public ArrayList<UserSimpleInfo> getBuddyList() {
        return this.buddyList;
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

    public void setBuddyList(ArrayList<UserSimpleInfo> arrayList) {
        this.buddyList = arrayList;
    }

    public void setCategoryId(int i3) {
        this.categoryId = i3;
    }

    public void setCategorySortId(int i3) {
        this.categorySortId = i3;
    }

    public void setCategroyMbCount(int i3) {
        this.categroyMbCount = i3;
    }

    public void setCategroyName(String str) {
        this.categroyName = str;
    }

    public BuddyCategory(int i3, int i16, String str, int i17, ArrayList<UserSimpleInfo> arrayList) {
        this.categroyName = "";
        new ArrayList();
        this.categoryId = i3;
        this.categorySortId = i16;
        this.categroyName = str;
        this.categroyMbCount = i17;
        this.buddyList = arrayList;
    }
}
