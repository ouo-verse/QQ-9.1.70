package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ItemList {
    public String type = "";
    public ArrayList<ItemData> itemDatas = new ArrayList<>();

    public ArrayList<ItemData> getItemDatas() {
        return this.itemDatas;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return "ItemList{type=" + this.type + ",itemDatas=" + this.itemDatas + ",}";
    }
}
