package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowInfo;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponGetCouponByIDRsp implements ISSOModel {
    public static final ISSOModelFactory<ShopCouponGetCouponByIDRsp> Factory = new ISSOModelFactory<ShopCouponGetCouponByIDRsp>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponGetCouponByIDRsp$Companion$Factory$1
        @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory
        public final ShopCouponGetCouponByIDRsp decode(e eVar) {
            ArrayList arrayList;
            b l3 = eVar.l("coupon_show_info");
            ArrayList arrayList2 = null;
            if (l3 != null) {
                ArrayList arrayList3 = new ArrayList();
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    Object d16 = l3.d(i3);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d16;
                        e m3 = eVar2.m("cond");
                        ShopCouponQueryORConditon shopCouponQueryORConditon = m3 != null ? new ShopCouponQueryORConditon(m3.q("shop_id", ""), m3.q("spu_id", ""), m3.q("media_id", "")) : null;
                        b l16 = eVar2.l("coupon_show_info");
                        if (l16 != null) {
                            arrayList = new ArrayList();
                            int c17 = l16.c();
                            for (int i16 = 0; i16 < c17; i16++) {
                                Object d17 = l16.d(i16);
                                if (d17 != null) {
                                    ShopCouponCouponShowInfo.Companion companion = ShopCouponCouponShowInfo.Companion;
                                    Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                    arrayList.add(companion.decode((e) d17));
                                }
                            }
                        } else {
                            arrayList = null;
                        }
                        arrayList3.add(new ShopCouponProductShowCoupons(shopCouponQueryORConditon, arrayList));
                    }
                }
                arrayList2 = arrayList3;
            }
            return new ShopCouponGetCouponByIDRsp(arrayList2);
        }
    };
    public final ArrayList<ShopCouponProductShowCoupons> couponShowInfo;

    public ShopCouponGetCouponByIDRsp() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<ShopCouponProductShowCoupons> arrayList = this.couponShowInfo;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((ShopCouponProductShowCoupons) it.next()).encode());
            }
        }
        eVar.v("coupon_show_info", bVar);
        return eVar;
    }

    public final int hashCode() {
        ArrayList<ShopCouponProductShowCoupons> arrayList = this.couponShowInfo;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.hashCode();
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponGetCouponByIDRsp(couponShowInfo=");
        m3.append(this.couponShowInfo);
        m3.append(')');
        return m3.toString();
    }

    public ShopCouponGetCouponByIDRsp(ArrayList<ShopCouponProductShowCoupons> arrayList) {
        this.couponShowInfo = arrayList;
    }

    public /* synthetic */ ShopCouponGetCouponByIDRsp(ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShopCouponGetCouponByIDRsp) && Intrinsics.areEqual(this.couponShowInfo, ((ShopCouponGetCouponByIDRsp) obj).couponShowInfo);
    }
}
