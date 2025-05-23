package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GroupBannerPriority {
    public int bannerPriority;
    public int categoryType;

    public int getBannerPriority() {
        return this.bannerPriority;
    }

    public int getCategoryType() {
        return this.categoryType;
    }

    public String toString() {
        return "GroupBannerPriority{categoryType=" + this.categoryType + ",bannerPriority=" + this.bannerPriority + ",}";
    }
}
