package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetAiAvatarCategoryInfosReq {
    public String categoryId = "";
    public boolean isFirstFetch;
    public int page;
    public int pageSize;
    public int source;

    public String getCategoryId() {
        return this.categoryId;
    }

    public boolean getIsFirstFetch() {
        return this.isFirstFetch;
    }

    public int getPage() {
        return this.page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getSource() {
        return this.source;
    }

    public String toString() {
        return "GetAiAvatarCategoryInfosReq{source=" + this.source + ",page=" + this.page + ",pageSize=" + this.pageSize + ",categoryId=" + this.categoryId + ",isFirstFetch=" + this.isFirstFetch + ",}";
    }
}
