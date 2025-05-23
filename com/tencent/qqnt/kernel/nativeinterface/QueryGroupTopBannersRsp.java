package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class QueryGroupTopBannersRsp {
    public ArrayList<GroupTopBannerInfo> banners = new ArrayList<>();
    public long seq;

    public ArrayList<GroupTopBannerInfo> getBanners() {
        return this.banners;
    }

    public long getSeq() {
        return this.seq;
    }

    public String toString() {
        return "QueryGroupTopBannersRsp{banners=" + this.banners + ",seq=" + this.seq + ",}";
    }
}
