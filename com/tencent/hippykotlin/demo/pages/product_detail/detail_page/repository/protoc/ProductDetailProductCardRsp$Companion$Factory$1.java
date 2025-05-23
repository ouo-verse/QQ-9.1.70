package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailProductCardRsp$Companion$Factory$1 implements ISSOModelFactory<ProductDetailProductCardRsp> {
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory
    public final ProductDetailProductCardRsp decode(e eVar) {
        ProductDetailShop productDetailShop;
        ProductDetailProduct productDetailProduct;
        String str;
        int i3;
        int i16;
        boolean z16;
        ProductDetailShop productDetailShop2;
        String str2;
        ProductDetailService productDetailService;
        ProductDetailButton productDetailButton;
        ArrayList arrayList;
        String str3;
        ArrayList arrayList2;
        String str4;
        int i17;
        b bVar;
        String str5;
        String q16 = eVar.q("spu_id", "");
        int k3 = eVar.k("biz_type", 0);
        int k16 = eVar.k("status", 0);
        boolean g16 = eVar.g("hide_share", false);
        e m3 = eVar.m("product");
        ProductDetailProduct decode = m3 != null ? ProductDetailProduct.Companion.decode(m3) : null;
        e m16 = eVar.m("shop");
        String str6 = "desc";
        if (m16 != null) {
            String q17 = m16.q("id", "");
            String q18 = m16.q("name", "");
            String q19 = m16.q("icon", "");
            e m17 = m16.m("button");
            ProductDetailButtonItem productDetailButtonItem = m17 != null ? new ProductDetailButtonItem(m17.k("button_type", 0), m17.q(FileReaderHelper.TXT_EXT, ""), m17.q("jump_url", ""), m17.q("icon", ""), m17.q("desc", "")) : null;
            e m18 = m16.m(TabPreloadItem.TAB_NAME_DYNAMIC);
            productDetailShop = new ProductDetailShop(q17, q18, q19, productDetailButtonItem, m18 != null ? new ProductDetailShopDynamic(m18.q("sales", "")) : null);
        } else {
            productDetailShop = null;
        }
        e m19 = eVar.m("shop_service");
        if (m19 == null) {
            productDetailProduct = decode;
            str = q16;
            i3 = k3;
            i16 = k16;
            z16 = g16;
            productDetailShop2 = productDetailShop;
            str2 = "desc";
            productDetailService = null;
        } else {
            productDetailShop2 = productDetailShop;
            b l3 = m19.l("services");
            productDetailProduct = decode;
            if (l3 == null) {
                str = q16;
                i3 = k3;
                i16 = k16;
                z16 = g16;
                str2 = "desc";
                arrayList2 = null;
            } else {
                arrayList2 = new ArrayList();
                z16 = g16;
                int c16 = l3.c();
                i16 = k16;
                int i18 = 0;
                while (i18 < c16) {
                    int i19 = c16;
                    Object d16 = l3.d(i18);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d16;
                        bVar = l3;
                        i17 = k3;
                        str4 = q16;
                        str5 = str6;
                        arrayList2.add(new ProductDetailServiceItem(eVar2.k("service_type", 0), eVar2.q("icon", ""), eVar2.q("title", ""), eVar2.q(str6, "")));
                    } else {
                        str4 = q16;
                        i17 = k3;
                        bVar = l3;
                        str5 = str6;
                    }
                    i18++;
                    c16 = i19;
                    l3 = bVar;
                    k3 = i17;
                    q16 = str4;
                    str6 = str5;
                }
                str = q16;
                i3 = k3;
                str2 = str6;
            }
            productDetailService = new ProductDetailService(arrayList2, m19.q("ship_template_id", ""), m19.q("shipping_tips", ""));
        }
        e m26 = eVar.m("button");
        if (m26 != null) {
            b l16 = m26.l("button_item");
            if (l16 != null) {
                arrayList = new ArrayList();
                int c17 = l16.c();
                int i26 = 0;
                while (i26 < c17) {
                    Object d17 = l16.d(i26);
                    if (d17 != null) {
                        Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar3 = (e) d17;
                        str3 = str2;
                        arrayList.add(new ProductDetailButtonItem(eVar3.k("button_type", 0), eVar3.q(FileReaderHelper.TXT_EXT, ""), eVar3.q("jump_url", ""), eVar3.q("icon", ""), eVar3.q(str3, "")));
                    } else {
                        str3 = str2;
                    }
                    i26++;
                    str2 = str3;
                }
            } else {
                arrayList = null;
            }
            productDetailButton = new ProductDetailButton(arrayList);
        } else {
            productDetailButton = null;
        }
        e m27 = eVar.m("bulletin");
        ProductDetailBulletin productDetailBulletin = m27 != null ? new ProductDetailBulletin(m27.q(FileReaderHelper.TXT_EXT, ""), m27.q("icon", "")) : null;
        e m28 = eVar.m("user_right");
        ProductDetailUserRight productDetailUserRight = m28 != null ? new ProductDetailUserRight(m28.k("role_id", 0), m28.q("role_name", ""), m28.q("role_desc", "")) : null;
        e m29 = eVar.m("active_info");
        ProductDetailActiveInfo decode2 = m29 != null ? ProductDetailActiveInfo.Companion.decode(m29) : null;
        e m36 = eVar.m("delivery_info");
        return new ProductDetailProductCardRsp(str, i3, i16, z16, productDetailProduct, productDetailShop2, productDetailService, productDetailButton, productDetailBulletin, productDetailUserRight, decode2, m36 != null ? new ProductDetailDeliveryInfo(m36.k("delivery_mode", 0), m36.k("delivery_opportunity", 0), m36.k("delivery_time_type", 0), m36.o("delivery_day", 0L), m36.o("presale_end_time", 0L), m36.g("has_end_time", false)) : null);
    }
}
