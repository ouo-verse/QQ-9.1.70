package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetGuildHomeCategoriesReq {
    public boolean filterClosedCategories;
    public long guildId;
    public boolean needChannel;

    public boolean getFilterClosedCategories() {
        return this.filterClosedCategories;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getNeedChannel() {
        return this.needChannel;
    }

    public String toString() {
        return "GProGetGuildHomeCategoriesReq{guildId=" + this.guildId + ",needChannel=" + this.needChannel + ",filterClosedCategories=" + this.filterClosedCategories + ",}";
    }
}
