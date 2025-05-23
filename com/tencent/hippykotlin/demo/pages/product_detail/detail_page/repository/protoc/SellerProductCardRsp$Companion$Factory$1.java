package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class SellerProductCardRsp$Companion$Factory$1 implements ISSOModelFactory<SellerProductCardRsp> {
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory
    public final SellerProductCardRsp decode(e eVar) {
        String str;
        int i3;
        ArrayList arrayList;
        String str2;
        String str3;
        Shop shop;
        Shop shop2;
        String str4;
        String str5;
        Service service;
        ArrayList arrayList2;
        ArrayList arrayList3;
        b bVar;
        String str6;
        String str7;
        String str8;
        ArrayList arrayList4;
        String str9;
        String str10;
        b bVar2;
        String str11;
        ButtonItem buttonItem;
        b bVar3;
        String q16 = eVar.q("spu_id", "");
        int k3 = eVar.k("biz_type", 0);
        int k16 = eVar.k("status", 0);
        e m3 = eVar.m("product");
        Product decode = m3 != null ? Product.Companion.decode(m3) : null;
        b l3 = eVar.l("labels");
        String str12 = LayoutAttrDefine.BorderColor;
        Product product = decode;
        if (l3 != null) {
            i3 = k3;
            ArrayList arrayList5 = new ArrayList();
            str = q16;
            int c16 = l3.c();
            int i16 = 0;
            while (i16 < c16) {
                int i17 = c16;
                Object d16 = l3.d(i16);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    bVar3 = l3;
                    arrayList5.add(new ProductDetailLabelInfo(eVar2.q("background_color", ""), eVar2.q("text_color", ""), eVar2.q("text", ""), eVar2.q("text_prefix", ""), eVar2.k("text_style_type", 0), eVar2.q(LayoutAttrDefine.BorderColor, ""), eVar2.q("pic_url", ""), eVar2.k("width", 0), eVar2.k("height", 0), eVar2.q("pic_token", "")));
                } else {
                    bVar3 = l3;
                }
                i16++;
                c16 = i17;
                l3 = bVar3;
            }
            arrayList = arrayList5;
        } else {
            str = q16;
            i3 = k3;
            arrayList = null;
        }
        String q17 = eVar.q("source", "");
        String q18 = eVar.q("url", "");
        e m16 = eVar.m("shop");
        String str13 = "desc";
        ArrayList arrayList6 = arrayList;
        String str14 = "icon";
        String str15 = "pic_token";
        if (m16 == null) {
            str2 = "height";
            str3 = "width";
            shop = null;
        } else {
            String q19 = m16.q("id", "");
            String q26 = m16.q("name", "");
            String q27 = m16.q("icon", "");
            e m17 = m16.m("button");
            str2 = "height";
            if (m17 != null) {
                str3 = "width";
                buttonItem = new ButtonItem(m17.k("button_type", 0), m17.q(FileReaderHelper.TXT_EXT, ""), m17.q("jump_url", ""), m17.q("icon", ""), m17.q("desc", ""));
            } else {
                str3 = "width";
                buttonItem = null;
            }
            e m18 = m16.m(TabPreloadItem.TAB_NAME_DYNAMIC);
            shop = new Shop(q19, q26, q27, buttonItem, m18 != null ? new ShopDynamic(m18.q("sales", "")) : null);
        }
        e m19 = eVar.m("shop_service");
        if (m19 == null) {
            shop2 = shop;
            str4 = "pic_url";
            str5 = LayoutAttrDefine.BorderColor;
            service = null;
        } else {
            b l16 = m19.l("services");
            if (l16 == null) {
                shop2 = shop;
                str4 = "pic_url";
                str5 = LayoutAttrDefine.BorderColor;
                arrayList4 = null;
            } else {
                arrayList4 = new ArrayList();
                shop2 = shop;
                int c17 = l16.c();
                str4 = "pic_url";
                int i18 = 0;
                while (i18 < c17) {
                    int i19 = c17;
                    Object d17 = l16.d(i18);
                    if (d17 != null) {
                        Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar3 = (e) d17;
                        bVar2 = l16;
                        str11 = str12;
                        str10 = str14;
                        str9 = str13;
                        arrayList4.add(new ProductDetailServiceItem(eVar3.k("service_type", 0), eVar3.q(str14, ""), eVar3.q("title", ""), eVar3.q(str13, "")));
                    } else {
                        str9 = str13;
                        str10 = str14;
                        bVar2 = l16;
                        str11 = str12;
                    }
                    i18++;
                    c17 = i19;
                    l16 = bVar2;
                    str12 = str11;
                    str14 = str10;
                    str13 = str9;
                }
                str5 = str12;
            }
            service = new Service(arrayList4, m19.q("ship_template_id", ""), m19.q("shipping_tips", ""));
        }
        b l17 = eVar.l("prod_tags");
        if (l17 != null) {
            ArrayList arrayList7 = new ArrayList();
            int c18 = l17.c();
            int i26 = 0;
            while (i26 < c18) {
                Object d18 = l17.d(i26);
                if (d18 != null) {
                    Intrinsics.checkNotNull(d18, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar4 = (e) d18;
                    str7 = str5;
                    bVar = l17;
                    str8 = str2;
                    str6 = str15;
                    arrayList7.add(new ProductDetailLabelInfo(eVar4.q("background_color", ""), eVar4.q("text_color", ""), eVar4.q("text", ""), eVar4.q("text_prefix", ""), eVar4.k("text_style_type", 0), eVar4.q(str7, ""), eVar4.q(str4, ""), eVar4.k(str3, 0), eVar4.k(str8, 0), eVar4.q(str6, "")));
                } else {
                    bVar = l17;
                    str6 = str15;
                    str7 = str5;
                    str8 = str2;
                }
                i26++;
                str2 = str8;
                str15 = str6;
                str5 = str7;
                l17 = bVar;
            }
            arrayList2 = arrayList7;
        } else {
            arrayList2 = null;
        }
        e m26 = eVar.m(WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_PROMOTE);
        Promote decode2 = m26 != null ? Promote.Companion.decode(m26) : null;
        boolean g16 = eVar.g("is_add", false);
        boolean g17 = eVar.g("is_sample", false);
        b l18 = eVar.l("rule_desc");
        if (l18 != null) {
            arrayList3 = new ArrayList();
            int c19 = l18.c();
            for (int i27 = 0; i27 < c19; i27++) {
                String o16 = l18.o(i27);
                if (o16 != null) {
                    arrayList3.add(o16);
                }
            }
        } else {
            arrayList3 = null;
        }
        e m27 = eVar.m("delivery_info");
        return new SellerProductCardRsp(str, i3, k16, product, arrayList6, q17, q18, shop2, service, arrayList2, decode2, g16, g17, arrayList3, m27 != null ? new DeliveryInfo(m27.k("delivery_mode", 0), m27.k("delivery_opportunity", 0), m27.k("delivery_time_type", 0), m27.o("delivery_day", 0L), m27.o("presale_end_time", 0L), m27.g("has_end_time", false)) : null);
    }
}
