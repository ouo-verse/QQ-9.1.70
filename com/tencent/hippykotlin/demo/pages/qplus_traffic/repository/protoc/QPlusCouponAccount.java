package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusCouponAccount implements ISSOReqModel, ISSORspModel<QPlusCouponAccount> {
    public final ArrayList<QPlusCategoryCoupon> catCoupon;
    public final int totalCouponCnt;

    public QPlusCouponAccount(int i3, ArrayList<QPlusCategoryCoupon> arrayList) {
        this.totalCouponCnt = i3;
        this.catCoupon = arrayList;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("total_coupon_cnt", this.totalCouponCnt);
        b bVar = new b();
        ArrayList<QPlusCategoryCoupon> arrayList = this.catCoupon;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((QPlusCategoryCoupon) it.next()).encode());
            }
        }
        eVar.v("cat_coupon", bVar);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCouponAccount decode(e eVar) {
        ArrayList arrayList;
        int k3 = eVar.k("total_coupon_cnt", 0);
        b l3 = eVar.l("cat_coupon");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList.add(new QPlusCategoryCoupon(eVar2.k("coupon_type", 0), eVar2.k("coupon_cnt", 0)));
                }
            }
        } else {
            arrayList = null;
        }
        return new QPlusCouponAccount(k3, arrayList);
    }
}
