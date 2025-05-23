package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponUserCouponInfo implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final String couponBatchId;
    public final ArrayList<String> couponId;
    public final ShopCouponCouponShowInfo couponShowInfo;
    public final ArrayList<ShopCouponCouponStyle> couponStyle;
    public final String useCouponUrl;

    public ShopCouponUserCouponInfo() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("coupon_batch_id", this.couponBatchId);
        ShopCouponCouponShowInfo shopCouponCouponShowInfo = this.couponShowInfo;
        if (shopCouponCouponShowInfo != null) {
            eVar.v("coupon_show_info", shopCouponCouponShowInfo.encode());
        }
        b bVar = new b();
        ArrayList<String> arrayList = this.couponId;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t((String) it.next());
            }
        }
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "coupon_id", bVar);
        ArrayList<ShopCouponCouponStyle> arrayList2 = this.couponStyle;
        if (arrayList2 != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                m3.t(((ShopCouponCouponStyle) it5.next()).encode());
            }
        }
        eVar.v("coupon_style", m3);
        eVar.v("use_coupon_url", this.useCouponUrl);
        return eVar;
    }

    public final int hashCode() {
        int hashCode = this.couponBatchId.hashCode() * 31;
        ShopCouponCouponShowInfo shopCouponCouponShowInfo = this.couponShowInfo;
        int hashCode2 = (hashCode + (shopCouponCouponShowInfo == null ? 0 : shopCouponCouponShowInfo.hashCode())) * 31;
        ArrayList<String> arrayList = this.couponId;
        int hashCode3 = (hashCode2 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<ShopCouponCouponStyle> arrayList2 = this.couponStyle;
        return this.useCouponUrl.hashCode() + ((hashCode3 + (arrayList2 != null ? arrayList2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponUserCouponInfo(couponBatchId=");
        m3.append(this.couponBatchId);
        m3.append(", couponShowInfo=");
        m3.append(this.couponShowInfo);
        m3.append(", couponId=");
        m3.append(this.couponId);
        m3.append(", couponStyle=");
        m3.append(this.couponStyle);
        m3.append(", useCouponUrl=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.useCouponUrl, ')');
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public final ShopCouponUserCouponInfo decode(e eVar) {
            ArrayList arrayList;
            ArrayList arrayList2;
            String str;
            String str2;
            b bVar;
            int i3;
            ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo;
            ShopCouponShowDiscount shopCouponShowDiscount;
            String q16 = eVar.q("coupon_batch_id", "");
            e m3 = eVar.m("coupon_show_info");
            ShopCouponCouponShowInfo decode = m3 != null ? ShopCouponCouponShowInfo.Companion.decode(m3) : null;
            String str3 = "coupon_id";
            b l3 = eVar.l("coupon_id");
            if (l3 != null) {
                ArrayList arrayList3 = new ArrayList();
                int c16 = l3.c();
                for (int i16 = 0; i16 < c16; i16++) {
                    String o16 = l3.o(i16);
                    if (o16 != null) {
                        arrayList3.add(o16);
                    }
                }
                arrayList = arrayList3;
            } else {
                arrayList = null;
            }
            String str4 = "coupon_style";
            b l16 = eVar.l("coupon_style");
            if (l16 != null) {
                ArrayList arrayList4 = new ArrayList();
                int c17 = l16.c();
                int i17 = 0;
                while (i17 < c17) {
                    Object d16 = l16.d(i17);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d16;
                        String q17 = eVar2.q(str3, "");
                        e m16 = eVar2.m(str4);
                        if (m16 != null) {
                            String q18 = m16.q("coupon_type_name", "");
                            String q19 = m16.q("coupon_issuer_name", "");
                            String q26 = m16.q("coupon_usable_range", "");
                            String q27 = m16.q("coupon_use_rule", "");
                            String q28 = m16.q("coupon_time_scope", "");
                            e m17 = m16.m("coupon_show_discount");
                            if (m17 != null) {
                                str = str3;
                                str2 = str4;
                                bVar = l16;
                                i3 = c17;
                                shopCouponShowDiscount = new ShopCouponShowDiscount(m17.q("discount_amount", ""), m17.q("discount_threshold", ""), m17.q("discount_simple_lable", ""), m17.k("type", 0));
                            } else {
                                str = str3;
                                str2 = str4;
                                bVar = l16;
                                i3 = c17;
                                shopCouponShowDiscount = null;
                            }
                            shopCouponCouponShowStyleInfo = new ShopCouponCouponShowStyleInfo(q18, q19, q26, q27, q28, shopCouponShowDiscount);
                        } else {
                            str = str3;
                            str2 = str4;
                            bVar = l16;
                            i3 = c17;
                            shopCouponCouponShowStyleInfo = null;
                        }
                        arrayList4.add(new ShopCouponCouponStyle(q17, shopCouponCouponShowStyleInfo, eVar2.q("use_coupon_url", "")));
                    } else {
                        str = str3;
                        str2 = str4;
                        bVar = l16;
                        i3 = c17;
                    }
                    i17++;
                    str3 = str;
                    str4 = str2;
                    l16 = bVar;
                    c17 = i3;
                }
                arrayList2 = arrayList4;
            } else {
                arrayList2 = null;
            }
            return new ShopCouponUserCouponInfo(q16, decode, arrayList, arrayList2, eVar.q("use_coupon_url", ""));
        }
    }

    public ShopCouponUserCouponInfo(String str, ShopCouponCouponShowInfo shopCouponCouponShowInfo, ArrayList<String> arrayList, ArrayList<ShopCouponCouponStyle> arrayList2, String str2) {
        this.couponBatchId = str;
        this.couponShowInfo = shopCouponCouponShowInfo;
        this.couponId = arrayList;
        this.couponStyle = arrayList2;
        this.useCouponUrl = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponUserCouponInfo)) {
            return false;
        }
        ShopCouponUserCouponInfo shopCouponUserCouponInfo = (ShopCouponUserCouponInfo) obj;
        return Intrinsics.areEqual(this.couponBatchId, shopCouponUserCouponInfo.couponBatchId) && Intrinsics.areEqual(this.couponShowInfo, shopCouponUserCouponInfo.couponShowInfo) && Intrinsics.areEqual(this.couponId, shopCouponUserCouponInfo.couponId) && Intrinsics.areEqual(this.couponStyle, shopCouponUserCouponInfo.couponStyle) && Intrinsics.areEqual(this.useCouponUrl, shopCouponUserCouponInfo.useCouponUrl);
    }

    public /* synthetic */ ShopCouponUserCouponInfo(String str, ShopCouponCouponShowInfo shopCouponCouponShowInfo, ArrayList arrayList, ArrayList arrayList2, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, null, null, "");
    }
}
