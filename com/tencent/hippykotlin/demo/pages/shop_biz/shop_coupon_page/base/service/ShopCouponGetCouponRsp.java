package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponGetCouponRsp implements ISSOModel {
    public static final ISSOModelFactory<ShopCouponGetCouponRsp> Factory = new ISSOModelFactory<ShopCouponGetCouponRsp>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponGetCouponRsp$Companion$Factory$1
        @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory
        public final ShopCouponGetCouponRsp decode(e eVar) {
            ArrayList arrayList;
            b l3 = eVar.l("items");
            ArrayList arrayList2 = null;
            if (l3 != null) {
                ArrayList arrayList3 = new ArrayList();
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    Object d16 = l3.d(i3);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d16;
                        int k3 = eVar2.k("ret_code", 0);
                        String q16 = eVar2.q("ret_msg", "");
                        String q17 = eVar2.q("coupon_batch_id", "");
                        e m3 = eVar2.m("coupon_show_info");
                        ShopCouponCouponShowInfo decode = m3 != null ? ShopCouponCouponShowInfo.Companion.decode(m3) : null;
                        b l16 = eVar2.l("coupon_ids");
                        if (l16 != null) {
                            ArrayList arrayList4 = new ArrayList();
                            int c17 = l16.c();
                            for (int i16 = 0; i16 < c17; i16++) {
                                String o16 = l16.o(i16);
                                if (o16 != null) {
                                    arrayList4.add(o16);
                                }
                            }
                            arrayList = arrayList4;
                        } else {
                            arrayList = null;
                        }
                        arrayList3.add(new ShopCouponCouponRetItem(k3, q16, q17, decode, arrayList));
                    }
                }
                arrayList2 = arrayList3;
            }
            return new ShopCouponGetCouponRsp(arrayList2);
        }
    };
    public final ArrayList<ShopCouponCouponRetItem> items;

    public ShopCouponGetCouponRsp() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<ShopCouponCouponRetItem> arrayList = this.items;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((ShopCouponCouponRetItem) it.next()).encode());
            }
        }
        eVar.v("items", bVar);
        return eVar;
    }

    public final int hashCode() {
        ArrayList<ShopCouponCouponRetItem> arrayList = this.items;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.hashCode();
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponGetCouponRsp(items=");
        m3.append(this.items);
        m3.append(')');
        return m3.toString();
    }

    public ShopCouponGetCouponRsp(ArrayList<ShopCouponCouponRetItem> arrayList) {
        this.items = arrayList;
    }

    public /* synthetic */ ShopCouponGetCouponRsp(ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShopCouponGetCouponRsp) && Intrinsics.areEqual(this.items, ((ShopCouponGetCouponRsp) obj).items);
    }
}
