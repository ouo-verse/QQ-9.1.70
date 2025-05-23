package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.o;
import gt0.a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class GoodsCenterProductInfo implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final ArrayList<String> cdnMainPics;
    public final long commission;
    public final double commissionRate;
    public final String commissionRateTxt;
    public final ArrayList<Long> commissions;
    public final int delivery_mode;
    public final String desc;
    public final String detailUrl;
    public final String extData;
    public final ArrayList<GoodsCenterExtraField> extraFields;
    public final int goodsType;
    public final boolean inWindow;
    public final long inventory;
    public final ArrayList<GoodsCenterLabelInfo> labels;
    public final long oriPrice;
    public final String pageName;
    public final long price;
    public final ArrayList<Long> prices;
    public final GoodsCenterActiveInfo qshopActiveInfo;
    public final String saasProductId;
    public final String saasTypeName;
    public final String saasTypeStr;
    public final long sales;
    public final String salesTxt;
    public final ArrayList<GoodsCenterLabelInfo> serviceTags;
    public final GoodsCenterShopInfo shopInfo;
    public final String title;

    public GoodsCenterProductInfo() {
        this(null, null, null, 0, 0L, 0L, 0L, 0.0d, null, 0L, 0L, null, null, null, null, null, null, null, null, null, null, false, null, null, null, 0, null, 134217727, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("saas_product_id", this.saasProductId);
        eVar.v("saas_type_str", this.saasTypeStr);
        eVar.v("title", this.title);
        eVar.t("goods_type", this.goodsType);
        eVar.u("price", this.price);
        eVar.u("ori_price", this.oriPrice);
        eVar.u("commission", this.commission);
        eVar.s("commission_rate", this.commissionRate);
        eVar.v("commission_rate_txt", this.commissionRateTxt);
        eVar.u("inventory", this.inventory);
        eVar.u("sales", this.sales);
        b bVar = new b();
        ArrayList<Long> arrayList = this.prices;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.s(((Number) it.next()).longValue());
            }
        }
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "prices", bVar);
        ArrayList<Long> arrayList2 = this.commissions;
        if (arrayList2 != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                m3.s(((Number) it5.next()).longValue());
            }
        }
        eVar.v("commissions", m3);
        eVar.v("saas_type_name", this.saasTypeName);
        eVar.v("sales_txt", this.salesTxt);
        b a16 = o.a(eVar, "desc", this.desc);
        ArrayList<String> arrayList3 = this.cdnMainPics;
        if (arrayList3 != null) {
            Iterator<T> it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                a16.t((String) it6.next());
            }
        }
        eVar.v("cdn_main_pics", a16);
        eVar.v("detail_url", this.detailUrl);
        eVar.v("page_name", this.pageName);
        b a17 = o.a(eVar, "ext_data", this.extData);
        ArrayList<GoodsCenterLabelInfo> arrayList4 = this.labels;
        if (arrayList4 != null) {
            Iterator<T> it7 = arrayList4.iterator();
            while (it7.hasNext()) {
                a17.t(((GoodsCenterLabelInfo) it7.next()).encode());
            }
        }
        eVar.v("labels", a17);
        eVar.w("in_window", this.inWindow);
        b bVar2 = new b();
        ArrayList<GoodsCenterLabelInfo> arrayList5 = this.serviceTags;
        if (arrayList5 != null) {
            Iterator<T> it8 = arrayList5.iterator();
            while (it8.hasNext()) {
                bVar2.t(((GoodsCenterLabelInfo) it8.next()).encode());
            }
        }
        eVar.v("service_tags", bVar2);
        GoodsCenterShopInfo goodsCenterShopInfo = this.shopInfo;
        if (goodsCenterShopInfo != null) {
            eVar.v("shop_info", goodsCenterShopInfo.encode());
        }
        GoodsCenterActiveInfo goodsCenterActiveInfo = this.qshopActiveInfo;
        if (goodsCenterActiveInfo != null) {
            eVar.v("qshop_active_info", goodsCenterActiveInfo.encode());
        }
        eVar.t("delivery_mode", this.delivery_mode);
        b bVar3 = new b();
        ArrayList<GoodsCenterExtraField> arrayList6 = this.extraFields;
        if (arrayList6 != null) {
            Iterator<T> it9 = arrayList6.iterator();
            while (it9.hasNext()) {
                bVar3.t(((GoodsCenterExtraField) it9.next()).encode());
            }
        }
        eVar.v("extra_fields", bVar3);
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.sales, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.inventory, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.commissionRateTxt, (a.a(this.commissionRate) + AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.commission, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.oriPrice, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.price, QQAudioParams$$ExternalSyntheticOutline0.m(this.goodsType, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.title, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.saasTypeStr, this.saasProductId.hashCode() * 31, 31), 31), 31), 31), 31), 31)) * 31, 31), 31), 31);
        ArrayList<Long> arrayList = this.prices;
        int hashCode = (m3 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<Long> arrayList2 = this.commissions;
        int m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.desc, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.salesTxt, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.saasTypeName, (hashCode + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31, 31), 31), 31);
        ArrayList<String> arrayList3 = this.cdnMainPics;
        int m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.extData, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.pageName, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.detailUrl, (m16 + (arrayList3 == null ? 0 : arrayList3.hashCode())) * 31, 31), 31), 31);
        ArrayList<GoodsCenterLabelInfo> arrayList4 = this.labels;
        int hashCode2 = (m17 + (arrayList4 == null ? 0 : arrayList4.hashCode())) * 31;
        boolean z16 = this.inWindow;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        ArrayList<GoodsCenterLabelInfo> arrayList5 = this.serviceTags;
        int hashCode3 = (i16 + (arrayList5 == null ? 0 : arrayList5.hashCode())) * 31;
        GoodsCenterShopInfo goodsCenterShopInfo = this.shopInfo;
        int hashCode4 = (hashCode3 + (goodsCenterShopInfo == null ? 0 : goodsCenterShopInfo.hashCode())) * 31;
        GoodsCenterActiveInfo goodsCenterActiveInfo = this.qshopActiveInfo;
        int m18 = QQAudioParams$$ExternalSyntheticOutline0.m(this.delivery_mode, (hashCode4 + (goodsCenterActiveInfo == null ? 0 : goodsCenterActiveInfo.hashCode())) * 31, 31);
        ArrayList<GoodsCenterExtraField> arrayList6 = this.extraFields;
        return m18 + (arrayList6 != null ? arrayList6.hashCode() : 0);
    }

    public final String toString() {
        return "GoodsCenterProductInfo(saasProductId=" + this.saasProductId + ", saasTypeStr=" + this.saasTypeStr + ", title=" + this.title + ", goodsType=" + this.goodsType + ", price=" + this.price + ", oriPrice=" + this.oriPrice + ", commission=" + this.commission + ", commissionRate=" + this.commissionRate + ", commissionRateTxt=" + this.commissionRateTxt + ", inventory=" + this.inventory + ", sales=" + this.sales + ", prices=" + this.prices + ", commissions=" + this.commissions + ", saasTypeName=" + this.saasTypeName + ", salesTxt=" + this.salesTxt + ", desc=" + this.desc + ", cdnMainPics=" + this.cdnMainPics + ", detailUrl=" + this.detailUrl + ", pageName=" + this.pageName + ", extData=" + this.extData + ", labels=" + this.labels + ", inWindow=" + this.inWindow + ", serviceTags=" + this.serviceTags + ", shopInfo=" + this.shopInfo + ", qshopActiveInfo=" + this.qshopActiveInfo + ", delivery_mode=" + this.delivery_mode + ", extraFields=" + this.extraFields + ')';
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final GoodsCenterProductInfo decode(e eVar) {
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            String str;
            String str2;
            ArrayList arrayList4;
            ArrayList arrayList5;
            ArrayList arrayList6;
            int i3;
            GoodsCenterActiveInfo goodsCenterActiveInfo;
            ArrayList arrayList7;
            b bVar;
            b bVar2;
            String q16 = eVar.q("saas_product_id", "");
            String q17 = eVar.q("saas_type_str", "");
            String q18 = eVar.q("title", "");
            int k3 = eVar.k("goods_type", 0);
            long o16 = eVar.o("price", 0L);
            long o17 = eVar.o("ori_price", 0L);
            long o18 = eVar.o("commission", 0L);
            double i16 = eVar.i("commission_rate", 0.0d);
            String q19 = eVar.q("commission_rate_txt", "");
            long o19 = eVar.o("inventory", 0L);
            long o26 = eVar.o("sales", 0L);
            b l3 = eVar.l("prices");
            if (l3 != null) {
                ArrayList arrayList8 = new ArrayList();
                int c16 = l3.c();
                int i17 = 0;
                while (i17 < c16) {
                    arrayList8.add(Long.valueOf(l3.m(i17)));
                    i17++;
                    l3 = l3;
                }
                arrayList = arrayList8;
            } else {
                arrayList = null;
            }
            b l16 = eVar.l("commissions");
            if (l16 != null) {
                ArrayList arrayList9 = new ArrayList();
                int c17 = l16.c();
                int i18 = 0;
                while (i18 < c17) {
                    arrayList9.add(Long.valueOf(l16.m(i18)));
                    i18++;
                    l16 = l16;
                }
                arrayList2 = arrayList9;
            } else {
                arrayList2 = null;
            }
            String q26 = eVar.q("saas_type_name", "");
            String q27 = eVar.q("sales_txt", "");
            String q28 = eVar.q("desc", "");
            b l17 = eVar.l("cdn_main_pics");
            if (l17 != null) {
                ArrayList arrayList10 = new ArrayList();
                int c18 = l17.c();
                int i19 = 0;
                while (i19 < c18) {
                    int i26 = c18;
                    String o27 = l17.o(i19);
                    if (o27 != null) {
                        arrayList10.add(o27);
                    }
                    i19++;
                    c18 = i26;
                }
                arrayList3 = arrayList10;
            } else {
                arrayList3 = null;
            }
            String q29 = eVar.q("detail_url", "");
            String q36 = eVar.q("page_name", "");
            String q37 = eVar.q("ext_data", "");
            b l18 = eVar.l("labels");
            if (l18 != null) {
                str2 = q18;
                ArrayList arrayList11 = new ArrayList();
                str = q17;
                int c19 = l18.c();
                int i27 = 0;
                while (i27 < c19) {
                    int i28 = c19;
                    Object d16 = l18.d(i27);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d16;
                        bVar2 = l18;
                        arrayList11.add(new GoodsCenterLabelInfo(eVar2.q("background_color", ""), eVar2.q("text_color", ""), eVar2.q("text", ""), eVar2.q("text_prefix", ""), eVar2.k("text_style_type", 0), eVar2.q(LayoutAttrDefine.BorderColor, ""), eVar2.q("pic_url", ""), eVar2.k("width", 0), eVar2.k("height", 0), eVar2.q("pic_token", "")));
                    } else {
                        bVar2 = l18;
                    }
                    i27++;
                    c19 = i28;
                    l18 = bVar2;
                }
                arrayList4 = arrayList11;
            } else {
                str = q17;
                str2 = q18;
                arrayList4 = null;
            }
            boolean g16 = eVar.g("in_window", false);
            b l19 = eVar.l("service_tags");
            if (l19 != null) {
                ArrayList arrayList12 = new ArrayList();
                arrayList5 = arrayList4;
                int c26 = l19.c();
                int i29 = 0;
                while (i29 < c26) {
                    int i36 = c26;
                    Object d17 = l19.d(i29);
                    if (d17 != null) {
                        Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar3 = (e) d17;
                        bVar = l19;
                        arrayList12.add(new GoodsCenterLabelInfo(eVar3.q("background_color", ""), eVar3.q("text_color", ""), eVar3.q("text", ""), eVar3.q("text_prefix", ""), eVar3.k("text_style_type", 0), eVar3.q(LayoutAttrDefine.BorderColor, ""), eVar3.q("pic_url", ""), eVar3.k("width", 0), eVar3.k("height", 0), eVar3.q("pic_token", "")));
                    } else {
                        bVar = l19;
                    }
                    i29++;
                    c26 = i36;
                    l19 = bVar;
                }
                arrayList6 = arrayList12;
            } else {
                arrayList5 = arrayList4;
                arrayList6 = null;
            }
            e m3 = eVar.m("shop_info");
            GoodsCenterShopInfo goodsCenterShopInfo = m3 != null ? new GoodsCenterShopInfo(m3.q("shop_id", ""), m3.q("shop_name", ""), m3.q("url", "")) : null;
            e m16 = eVar.m("qshop_active_info");
            if (m16 != null) {
                i3 = 0;
                goodsCenterActiveInfo = new GoodsCenterActiveInfo(m16.q("active_id", ""), m16.k("active_type", 0));
            } else {
                i3 = 0;
                goodsCenterActiveInfo = null;
            }
            int k16 = eVar.k("delivery_mode", i3);
            b l26 = eVar.l("extra_fields");
            if (l26 != null) {
                ArrayList arrayList13 = new ArrayList();
                int c27 = l26.c();
                while (i3 < c27) {
                    Object d18 = l26.d(i3);
                    if (d18 != null) {
                        Intrinsics.checkNotNull(d18, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar4 = (e) d18;
                        arrayList13.add(new GoodsCenterExtraField(eVar4.q("k", ""), eVar4.q("v", "")));
                    }
                    i3++;
                }
                arrayList7 = arrayList13;
            } else {
                arrayList7 = null;
            }
            return new GoodsCenterProductInfo(q16, str, str2, k3, o16, o17, o18, i16, q19, o19, o26, arrayList, arrayList2, q26, q27, q28, arrayList3, q29, q36, q37, arrayList5, g16, arrayList6, goodsCenterShopInfo, goodsCenterActiveInfo, k16, arrayList7);
        }
    }

    public GoodsCenterProductInfo(String str, String str2, String str3, int i3, long j3, long j16, long j17, double d16, String str4, long j18, long j19, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, String str5, String str6, String str7, ArrayList<String> arrayList3, String str8, String str9, String str10, ArrayList<GoodsCenterLabelInfo> arrayList4, boolean z16, ArrayList<GoodsCenterLabelInfo> arrayList5, GoodsCenterShopInfo goodsCenterShopInfo, GoodsCenterActiveInfo goodsCenterActiveInfo, int i16, ArrayList<GoodsCenterExtraField> arrayList6) {
        this.saasProductId = str;
        this.saasTypeStr = str2;
        this.title = str3;
        this.goodsType = i3;
        this.price = j3;
        this.oriPrice = j16;
        this.commission = j17;
        this.commissionRate = d16;
        this.commissionRateTxt = str4;
        this.inventory = j18;
        this.sales = j19;
        this.prices = arrayList;
        this.commissions = arrayList2;
        this.saasTypeName = str5;
        this.salesTxt = str6;
        this.desc = str7;
        this.cdnMainPics = arrayList3;
        this.detailUrl = str8;
        this.pageName = str9;
        this.extData = str10;
        this.labels = arrayList4;
        this.inWindow = z16;
        this.serviceTags = arrayList5;
        this.shopInfo = goodsCenterShopInfo;
        this.qshopActiveInfo = goodsCenterActiveInfo;
        this.delivery_mode = i16;
        this.extraFields = arrayList6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterProductInfo)) {
            return false;
        }
        GoodsCenterProductInfo goodsCenterProductInfo = (GoodsCenterProductInfo) obj;
        return Intrinsics.areEqual(this.saasProductId, goodsCenterProductInfo.saasProductId) && Intrinsics.areEqual(this.saasTypeStr, goodsCenterProductInfo.saasTypeStr) && Intrinsics.areEqual(this.title, goodsCenterProductInfo.title) && this.goodsType == goodsCenterProductInfo.goodsType && this.price == goodsCenterProductInfo.price && this.oriPrice == goodsCenterProductInfo.oriPrice && this.commission == goodsCenterProductInfo.commission && Double.compare(this.commissionRate, goodsCenterProductInfo.commissionRate) == 0 && Intrinsics.areEqual(this.commissionRateTxt, goodsCenterProductInfo.commissionRateTxt) && this.inventory == goodsCenterProductInfo.inventory && this.sales == goodsCenterProductInfo.sales && Intrinsics.areEqual(this.prices, goodsCenterProductInfo.prices) && Intrinsics.areEqual(this.commissions, goodsCenterProductInfo.commissions) && Intrinsics.areEqual(this.saasTypeName, goodsCenterProductInfo.saasTypeName) && Intrinsics.areEqual(this.salesTxt, goodsCenterProductInfo.salesTxt) && Intrinsics.areEqual(this.desc, goodsCenterProductInfo.desc) && Intrinsics.areEqual(this.cdnMainPics, goodsCenterProductInfo.cdnMainPics) && Intrinsics.areEqual(this.detailUrl, goodsCenterProductInfo.detailUrl) && Intrinsics.areEqual(this.pageName, goodsCenterProductInfo.pageName) && Intrinsics.areEqual(this.extData, goodsCenterProductInfo.extData) && Intrinsics.areEqual(this.labels, goodsCenterProductInfo.labels) && this.inWindow == goodsCenterProductInfo.inWindow && Intrinsics.areEqual(this.serviceTags, goodsCenterProductInfo.serviceTags) && Intrinsics.areEqual(this.shopInfo, goodsCenterProductInfo.shopInfo) && Intrinsics.areEqual(this.qshopActiveInfo, goodsCenterProductInfo.qshopActiveInfo) && this.delivery_mode == goodsCenterProductInfo.delivery_mode && Intrinsics.areEqual(this.extraFields, goodsCenterProductInfo.extraFields);
    }

    public /* synthetic */ GoodsCenterProductInfo(String str, String str2, String str3, int i3, long j3, long j16, long j17, double d16, String str4, long j18, long j19, ArrayList arrayList, ArrayList arrayList2, String str5, String str6, String str7, ArrayList arrayList3, String str8, String str9, String str10, ArrayList arrayList4, boolean z16, ArrayList arrayList5, GoodsCenterShopInfo goodsCenterShopInfo, GoodsCenterActiveInfo goodsCenterActiveInfo, int i16, ArrayList arrayList6, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", 0, 0L, 0L, 0L, 0.0d, "", 0L, 0L, null, null, "", "", "", null, "", "", "", null, false, null, null, null, 0, null);
    }
}
