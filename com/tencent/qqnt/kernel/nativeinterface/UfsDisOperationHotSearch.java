package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsDisOperationHotSearch {
    public String title = "";
    public String picUrl = "";
    public UfsDisJumpLink picJumpLink = new UfsDisJumpLink();
    public ArrayList<UfsDisOperationHotSearchItem> items = new ArrayList<>();

    public ArrayList<UfsDisOperationHotSearchItem> getItems() {
        return this.items;
    }

    public UfsDisJumpLink getPicJumpLink() {
        return this.picJumpLink;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "UfsDisOperationHotSearch{title=" + this.title + ",picUrl=" + this.picUrl + ",picJumpLink=" + this.picJumpLink + ",items=" + this.items + ",}";
    }
}
