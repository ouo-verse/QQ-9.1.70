package com.tencent.mobileqq.mini.entry.search.comm;

/* compiled from: P */
/* loaded from: classes33.dex */
public class TitleInfo implements ItemInfo {
    public String mTitle;
    public boolean showRefreshButton = false;

    public TitleInfo(String str) {
        this.mTitle = str;
    }

    @Override // com.tencent.mobileqq.mini.entry.search.comm.ItemInfo
    public int getType() {
        return 1;
    }

    public void setRefreshButtonVisibility(boolean z16) {
        this.showRefreshButton = z16;
    }
}
