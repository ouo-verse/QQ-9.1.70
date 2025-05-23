package com.tencent.bugly.common.reporter.data;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AttachmentInfo {
    private ArrayList<Item> mItemLists = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class Item {
        public byte type = 0;
        public String fileName = "";
        public byte[] data = null;
    }

    public void addItem(Item item) {
        this.mItemLists.add(item);
    }

    public void clear() {
        this.mItemLists.clear();
    }

    public void delItem(Item item) {
        this.mItemLists.remove(item);
    }

    public ArrayList<Item> getItemLists() {
        return this.mItemLists;
    }
}
