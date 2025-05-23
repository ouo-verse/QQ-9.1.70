package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AIWriteInfo {
    public String title = "";
    public ArrayList<ItemList> itemList = new ArrayList<>();
    public ItemData defaultData = new ItemData();

    public ItemData getDefaultData() {
        return this.defaultData;
    }

    public ArrayList<ItemList> getItemList() {
        return this.itemList;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "AIWriteInfo{title=" + this.title + ",itemList=" + this.itemList + ",defaultData=" + this.defaultData + ",}";
    }
}
