package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponUserCouponInfo;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponGetUserCouponsRsp implements ISSOModel {
    public static final ISSOModelFactory<ShopCouponGetUserCouponsRsp> Factory = new ISSOModelFactory<ShopCouponGetUserCouponsRsp>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponGetUserCouponsRsp$Companion$Factory$1
        @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory
        public final ShopCouponGetUserCouponsRsp decode(e eVar) {
            ArrayList arrayList;
            b l3 = eVar.l("coupons");
            if (l3 != null) {
                ArrayList arrayList2 = new ArrayList();
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    Object d16 = l3.d(i3);
                    if (d16 != null) {
                        ShopCouponUserCouponInfo.Companion companion = ShopCouponUserCouponInfo.Companion;
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        arrayList2.add(companion.decode((e) d16));
                    }
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            long o16 = eVar.o("total", 0L);
            e m3 = eVar.m("cookie");
            return new ShopCouponGetUserCouponsRsp(arrayList, o16, m3 != null ? new ShopCouponPageCookie(m3.o("index", 0L), m3.o("limit", 0L)) : null, eVar.g("is_end", false));
        }
    };
    public final ShopCouponPageCookie cookie;
    public final ArrayList<ShopCouponUserCouponInfo> coupons;
    public final boolean isEnd;
    public final long total;

    public ShopCouponGetUserCouponsRsp() {
        this(null, 0L, null, false, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<ShopCouponUserCouponInfo> arrayList = this.coupons;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((ShopCouponUserCouponInfo) it.next()).encode());
            }
        }
        eVar.v("coupons", bVar);
        eVar.u("total", this.total);
        ShopCouponPageCookie shopCouponPageCookie = this.cookie;
        if (shopCouponPageCookie != null) {
            eVar.v("cookie", shopCouponPageCookie.encode());
        }
        eVar.w("is_end", this.isEnd);
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        ArrayList<ShopCouponUserCouponInfo> arrayList = this.coupons;
        int m3 = AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.total, (arrayList == null ? 0 : arrayList.hashCode()) * 31, 31);
        ShopCouponPageCookie shopCouponPageCookie = this.cookie;
        int hashCode = (m3 + (shopCouponPageCookie != null ? shopCouponPageCookie.hashCode() : 0)) * 31;
        boolean z16 = this.isEnd;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponGetUserCouponsRsp(coupons=");
        m3.append(this.coupons);
        m3.append(", total=");
        m3.append(this.total);
        m3.append(", cookie=");
        m3.append(this.cookie);
        m3.append(", isEnd=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.isEnd, ')');
    }

    public ShopCouponGetUserCouponsRsp(ArrayList<ShopCouponUserCouponInfo> arrayList, long j3, ShopCouponPageCookie shopCouponPageCookie, boolean z16) {
        this.coupons = arrayList;
        this.total = j3;
        this.cookie = shopCouponPageCookie;
        this.isEnd = z16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponGetUserCouponsRsp)) {
            return false;
        }
        ShopCouponGetUserCouponsRsp shopCouponGetUserCouponsRsp = (ShopCouponGetUserCouponsRsp) obj;
        return Intrinsics.areEqual(this.coupons, shopCouponGetUserCouponsRsp.coupons) && this.total == shopCouponGetUserCouponsRsp.total && Intrinsics.areEqual(this.cookie, shopCouponGetUserCouponsRsp.cookie) && this.isEnd == shopCouponGetUserCouponsRsp.isEnd;
    }

    public /* synthetic */ ShopCouponGetUserCouponsRsp(ArrayList arrayList, long j3, ShopCouponPageCookie shopCouponPageCookie, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, 0L, null, false);
    }
}
