package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class QPlusCategoryCoupon implements ISSOReqModel, ISSORspModel<QPlusCategoryCoupon> {
    public final int couponCnt;
    public final int couponType;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QPlusCategoryCoupon() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCategoryCoupon decode(e eVar) {
        return new QPlusCategoryCoupon(eVar.k("coupon_type", 0), eVar.k("coupon_cnt", 0));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("coupon_type", this.couponType);
        eVar.t("coupon_cnt", this.couponCnt);
        return eVar;
    }

    public QPlusCategoryCoupon(int i3, int i16) {
        this.couponType = i3;
        this.couponCnt = i16;
    }

    public /* synthetic */ QPlusCategoryCoupon(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0);
    }
}
