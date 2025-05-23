package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProBlockInfo implements Serializable {
    public String blockId;
    public int blockIndex;
    public String blockName;
    public int blockType;
    public ArrayList<GProRecommendCategory> categories;
    public boolean hasMore;
    public int isWhole;
    public ArrayList<GProRecommendItem> items;
    long serialVersionUID;

    public GProBlockInfo() {
        this.serialVersionUID = 1L;
        this.blockId = "";
        this.blockName = "";
        this.items = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    public String getBlockId() {
        return this.blockId;
    }

    public int getBlockIndex() {
        return this.blockIndex;
    }

    public String getBlockName() {
        return this.blockName;
    }

    public int getBlockType() {
        return this.blockType;
    }

    public ArrayList<GProRecommendCategory> getCategories() {
        return this.categories;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public int getIsWhole() {
        return this.isWhole;
    }

    public ArrayList<GProRecommendItem> getItems() {
        return this.items;
    }

    public String toString() {
        return "GProBlockInfo{blockId=" + this.blockId + ",blockType=" + this.blockType + ",blockIndex=" + this.blockIndex + ",blockName=" + this.blockName + ",items=" + this.items + ",hasMore=" + this.hasMore + ",categories=" + this.categories + ",isWhole=" + this.isWhole + ",}";
    }

    public GProBlockInfo(String str, int i3, int i16, String str2, ArrayList<GProRecommendItem> arrayList, boolean z16, ArrayList<GProRecommendCategory> arrayList2, int i17) {
        this.serialVersionUID = 1L;
        this.blockId = "";
        this.blockName = "";
        this.items = new ArrayList<>();
        new ArrayList();
        this.blockId = str;
        this.blockType = i3;
        this.blockIndex = i16;
        this.blockName = str2;
        this.items = arrayList;
        this.hasMore = z16;
        this.categories = arrayList2;
        this.isWhole = i17;
    }
}
