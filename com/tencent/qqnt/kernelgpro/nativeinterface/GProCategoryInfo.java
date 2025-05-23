package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProCategoryInfo implements Serializable {
    public long categoryId;
    public int categoryIndex;
    public int categoryType;
    public int closeSwitch;
    public boolean folded;
    public long guildId;
    long serialVersionUID = 1;
    public ArrayList<GProCategoryChannelInfo> msgChannelInfoList = new ArrayList<>();
    public String categoryName = "";
    public String categoryAlias = "";
    public ArrayList<GProCategoryInfoBytesCategoryCommonEntry> bytesCategoryCommonList = new ArrayList<>();

    public ArrayList<GProCategoryInfoBytesCategoryCommonEntry> getBytesCategoryCommonList() {
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

    public int getCloseSwitch() {
        return this.closeSwitch;
    }

    public boolean getFolded() {
        return this.folded;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<GProCategoryChannelInfo> getMsgChannelInfoList() {
        return this.msgChannelInfoList;
    }

    public String toString() {
        return "GProCategoryInfo{categoryIndex=" + this.categoryIndex + ",msgChannelInfoList=" + this.msgChannelInfoList + ",categoryName=" + this.categoryName + ",categoryId=" + this.categoryId + ",categoryType=" + this.categoryType + ",closeSwitch=" + this.closeSwitch + ",categoryAlias=" + this.categoryAlias + ",bytesCategoryCommonList=" + this.bytesCategoryCommonList + ",guildId=" + this.guildId + ",folded=" + this.folded + ",}";
    }
}
