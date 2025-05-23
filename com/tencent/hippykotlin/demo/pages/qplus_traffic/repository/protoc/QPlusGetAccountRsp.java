package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusGetAccountRsp implements ISSOReqModel, ISSORspModel<QPlusGetAccountRsp> {
    public final QPlusCoinAccount coinAccount;
    public final QPlusCouponAccount couponAccount;

    public QPlusGetAccountRsp() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusGetAccountRsp decode(e eVar) {
        e m3 = eVar.m("coin_account");
        QPlusCouponAccount qPlusCouponAccount = null;
        ArrayList arrayList = null;
        QPlusCoinAccount qPlusCoinAccount = m3 != null ? new QPlusCoinAccount(m3.k("coin_amount", 0)) : null;
        e m16 = eVar.m("coupon_account");
        if (m16 != null) {
            int k3 = m16.k("total_coupon_cnt", 0);
            b l3 = m16.l("cat_coupon");
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
            }
            qPlusCouponAccount = new QPlusCouponAccount(k3, arrayList);
        }
        return new QPlusGetAccountRsp(qPlusCoinAccount, qPlusCouponAccount);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        QPlusCoinAccount qPlusCoinAccount = this.coinAccount;
        if (qPlusCoinAccount != null) {
            eVar.v("coin_account", qPlusCoinAccount.encode());
        }
        QPlusCouponAccount qPlusCouponAccount = this.couponAccount;
        if (qPlusCouponAccount != null) {
            eVar.v("coupon_account", qPlusCouponAccount.encode());
        }
        return eVar;
    }

    public QPlusGetAccountRsp(QPlusCoinAccount qPlusCoinAccount, QPlusCouponAccount qPlusCouponAccount) {
        this.coinAccount = qPlusCoinAccount;
        this.couponAccount = qPlusCouponAccount;
    }

    public /* synthetic */ QPlusGetAccountRsp(QPlusCoinAccount qPlusCoinAccount, QPlusCouponAccount qPlusCouponAccount, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }
}
