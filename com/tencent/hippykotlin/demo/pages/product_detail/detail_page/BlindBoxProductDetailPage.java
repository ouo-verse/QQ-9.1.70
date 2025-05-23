package com.tencent.hippykotlin.demo.pages.product_detail.detail_page;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingLocalUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.ProductDetailSource$EnumUnboxingLocalUtility;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class BlindBoxProductDetailPage extends ProductDetailPage {
    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage
    public final void pageExpReport() {
        int i3;
        e eVar = new e();
        eVar.v("box_id", PageDataExtKt.getUserData(getPageData()).q("mystery_box_id", ""));
        eVar.v("spu_id", getPageData().n().p("spu_id"));
        eVar.t("box_type", BoxType$EnumUnboxingLocalUtility.getId(SchemeParamExtensionKt.blindBoxType(PageDataExtKt.getUserData(getPageData()))));
        int k3 = PageDataExtKt.getUserData(getPageData()).k("blind_box_product_detail_source_from", 1);
        int[] values = BoxType$EnumUnboxingSharedUtility.values(2);
        int length = values.length;
        int i16 = 0;
        while (true) {
            if (i16 >= length) {
                i3 = 0;
                break;
            }
            i3 = values[i16];
            if (ProductDetailSource$EnumUnboxingLocalUtility.getId(i3) == k3) {
                break;
            } else {
                i16++;
            }
        }
        if (i3 == 0) {
            i3 = 1;
        }
        eVar.t("goodsdetail_source", ProductDetailSource$EnumUnboxingLocalUtility.getId(i3));
        String q16 = PageDataExtKt.getUserData(getPageData()).q("group_id", "");
        if (q16.length() > 0) {
            eVar.v("group_id", q16);
        }
        Utils.INSTANCE.currentBridgeModule().reportDT("blindbox_goodspage_exp", eVar);
    }
}
