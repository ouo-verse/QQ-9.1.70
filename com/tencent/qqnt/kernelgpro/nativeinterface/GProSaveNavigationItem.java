package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSaveNavigationItem {
    public long categoryId;
    public long iconId;
    public String jumpUrl;
    public String title;

    public GProSaveNavigationItem() {
        this.title = "";
        this.jumpUrl = "";
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public long getIconId() {
        return this.iconId;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCategoryId(long j3) {
        this.categoryId = j3;
    }

    public void setIconId(long j3) {
        this.iconId = j3;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "GProSaveNavigationItem{iconId=" + this.iconId + ",title=" + this.title + ",jumpUrl=" + this.jumpUrl + ",categoryId=" + this.categoryId + ",}";
    }

    public GProSaveNavigationItem(long j3, String str, String str2) {
        this.iconId = j3;
        this.title = str;
        this.jumpUrl = str2;
    }
}
