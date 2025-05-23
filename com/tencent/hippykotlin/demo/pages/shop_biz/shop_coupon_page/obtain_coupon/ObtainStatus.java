package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon;

/* compiled from: P */
/* loaded from: classes33.dex */
public enum ObtainStatus {
    INIT("\u7acb\u5373\u9886\u53d6", "qecommerce_skin_color_text_red_brand"),
    SUCCESS_GET_ALL("\u5df2\u9886\u53d6", "qecommerce_skin_color_tag_secondary"),
    SUCCESS_GET_PART("\u7ee7\u7eed\u9886\u53d6", "qecommerce_skin_color_text_red_brand"),
    SUCCESS_NONE_LEFT("\u5df2\u9886\u5b8c", "qecommerce_skin_color_tag_secondary"),
    FAIL_NONE_LEFT("\u5df2\u9886\u5b8c", "qecommerce_skin_color_tag_secondary"),
    FAIL_OVER_LIMIT("\u5df2\u9886\u53d6", "qecommerce_skin_color_tag_secondary"),
    FAIL_OUT_OF_DATE("\u5df2\u8fc7\u671f", "qecommerce_skin_color_tag_secondary"),
    FAIL_INVALIDATE("\u5df2\u5931\u6548", "qecommerce_skin_color_tag_secondary");

    public final String colorToken;
    public final String text;

    ObtainStatus(String str, String str2) {
        this.text = str;
        this.colorToken = str2;
    }
}
