package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProCategoryAdminInfo {
    public int categoryType;
    public String categoryName = "";
    public ArrayList<GProChannelAdminInfo> channelAdminList = new ArrayList<>();

    public String getCategoryName() {
        return this.categoryName;
    }

    public int getCategoryType() {
        return this.categoryType;
    }

    public ArrayList<GProChannelAdminInfo> getChannelAdminList() {
        return this.channelAdminList;
    }

    public String toString() {
        return "GProCategoryAdminInfo{categoryName=" + this.categoryName + ",channelAdminList=" + this.channelAdminList + ",categoryType=" + this.categoryType + ",}";
    }
}
