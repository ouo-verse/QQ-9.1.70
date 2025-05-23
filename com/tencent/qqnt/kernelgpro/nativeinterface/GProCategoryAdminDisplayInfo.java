package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProCategoryAdminDisplayInfo {
    public long categoryAdminNum;
    public long categoryId;
    public String categoryName = "";
    public int categoryType;

    public long getCategoryAdminNum() {
        return this.categoryAdminNum;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public int getCategoryType() {
        return this.categoryType;
    }

    public String toString() {
        return "GProCategoryAdminDisplayInfo{categoryId=" + this.categoryId + ",categoryName=" + this.categoryName + ",categoryAdminNum=" + this.categoryAdminNum + ",categoryType=" + this.categoryType + ",}";
    }
}
