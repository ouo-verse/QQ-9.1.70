package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel;

/* loaded from: classes33.dex */
public enum MyCouponTabPageType {
    WaitUse("\u5f85\u4f7f\u7528", true, 1, 2),
    /* JADX INFO: Fake field, exist only in values array */
    BeUsed("\u5df2\u4f7f\u7528", false, 3, 3),
    /* JADX INFO: Fake field, exist only in values array */
    OutOfDate("\u5df2\u8fc7\u671f", false, 4, 4);

    public final boolean bShowCount;
    public final int itemConfig;
    public final int status;
    public final String title;

    MyCouponTabPageType(String str, boolean z16, int i3, int i16) {
        this.title = str;
        this.bShowCount = z16;
        this.itemConfig = i3;
        this.status = i16;
    }
}
