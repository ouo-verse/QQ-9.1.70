package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel;

/* compiled from: P */
/* loaded from: classes33.dex */
public final /* synthetic */ class MyCouponListItemConfig$EnumUnboxingLocalUtility {
    public static /* synthetic */ String getText(int i3) {
        if (i3 == 1) {
            return "\u7acb\u5373\u4f7f\u7528";
        }
        if (i3 == 2) {
            return "\u5373\u5c06\u751f\u6548";
        }
        if (i3 == 3) {
            return "\u5df2\u4f7f\u7528";
        }
        if (i3 == 4) {
            return "\u5df2\u8fc7\u671f";
        }
        if (i3 == 5) {
            return "";
        }
        throw null;
    }

    public static /* synthetic */ String getTextToken(int i3) {
        if (i3 == 1) {
            return "qecommerce_skin_color_text_red_brand";
        }
        if (i3 == 2) {
            return "qecommerce_skin_color_tag_secondary";
        }
        if (i3 == 3 || i3 == 4) {
            return "qecommerce_skin_color_text_light";
        }
        if (i3 == 5) {
            return "";
        }
        throw null;
    }

    public static /* synthetic */ String name(int i3) {
        if (i3 == 1) {
            return "ValidNormal";
        }
        if (i3 == 2) {
            return "ValidFuture";
        }
        if (i3 == 3) {
            return "InvalidReused";
        }
        if (i3 == 4) {
            return "InvalidOutOfDate";
        }
        if (i3 == 5) {
            return "InvalidSkeleton";
        }
        throw null;
    }

    public static /* synthetic */ boolean getEnabled(int i3) {
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        if (i3 == 3 || i3 == 4 || i3 == 5) {
            return false;
        }
        throw null;
    }
}
