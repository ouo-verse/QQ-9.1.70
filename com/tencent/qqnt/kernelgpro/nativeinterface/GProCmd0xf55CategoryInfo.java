package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProCmd0xf55CategoryInfo implements Serializable {
    public long categoryId;
    public int categoryIndex;
    public int categoryType;
    public int closeSwitch;
    long serialVersionUID = 1;
    public String categoryName = "";
    public GProChannelCategoryInfo channelCategoryInfo = new GProChannelCategoryInfo();
    public String categoryAlias = "";
    public ArrayList<GProCmd0xf55CategoryInfoBytesCategoryCommonEntry> bytesCategoryCommonList = new ArrayList<>();

    public ArrayList<GProCmd0xf55CategoryInfoBytesCategoryCommonEntry> getBytesCategoryCommonList() {
        return this.bytesCategoryCommonList;
    }

    public String getCategoryAlias() {
        return this.categoryAlias;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public int getCategoryIndex() {
        return this.categoryIndex;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public int getCategoryType() {
        return this.categoryType;
    }

    public GProChannelCategoryInfo getChannelCategoryInfo() {
        return this.channelCategoryInfo;
    }

    public int getCloseSwitch() {
        return this.closeSwitch;
    }

    public String toString() {
        return "GProCmd0xf55CategoryInfo{categoryIndex=" + this.categoryIndex + ",categoryName=" + this.categoryName + ",categoryId=" + this.categoryId + ",channelCategoryInfo=" + this.channelCategoryInfo + ",categoryType=" + this.categoryType + ",closeSwitch=" + this.closeSwitch + ",categoryAlias=" + this.categoryAlias + ",bytesCategoryCommonList=" + this.bytesCategoryCommonList + ",}";
    }
}
