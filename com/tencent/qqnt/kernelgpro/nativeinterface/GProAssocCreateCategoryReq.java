package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAssocCreateCategoryReq {
    public GProCategoryChannelIdList categoryInfo = new GProCategoryChannelIdList();
    public int specificCateype;

    public GProCategoryChannelIdList getCategoryInfo() {
        return this.categoryInfo;
    }

    public int getSpecificCateype() {
        return this.specificCateype;
    }

    public String toString() {
        return "GProAssocCreateCategoryReq{specificCateype=" + this.specificCateype + ",categoryInfo=" + this.categoryInfo + ",}";
    }
}
