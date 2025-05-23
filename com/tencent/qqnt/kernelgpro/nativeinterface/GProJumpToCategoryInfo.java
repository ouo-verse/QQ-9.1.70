package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProJumpToCategoryInfo {
    public long categoryId;
    public int feedSortType;
    public long guildId;

    public long getCategoryId() {
        return this.categoryId;
    }

    public int getFeedSortType() {
        return this.feedSortType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProJumpToCategoryInfo{guildId=" + this.guildId + ",categoryId=" + this.categoryId + ",feedSortType=" + this.feedSortType + ",}";
    }
}
