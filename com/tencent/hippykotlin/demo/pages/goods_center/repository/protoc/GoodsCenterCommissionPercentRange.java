package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class GoodsCenterCommissionPercentRange implements ISSOModel {
    public final long lower;
    public final long upper;

    public GoodsCenterCommissionPercentRange() {
        this(0L, 0L, 3, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.u("lower", this.lower);
        eVar.u("upper", this.upper);
        return eVar;
    }

    public final int hashCode() {
        return d.a(this.upper) + (d.a(this.lower) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterCommissionPercentRange(lower=");
        m3.append(this.lower);
        m3.append(", upper=");
        return GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(m3, this.upper, ')');
    }

    public GoodsCenterCommissionPercentRange(long j3, long j16) {
        this.lower = j3;
        this.upper = j16;
    }

    public /* synthetic */ GoodsCenterCommissionPercentRange(long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0L);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterCommissionPercentRange)) {
            return false;
        }
        GoodsCenterCommissionPercentRange goodsCenterCommissionPercentRange = (GoodsCenterCommissionPercentRange) obj;
        return this.lower == goodsCenterCommissionPercentRange.lower && this.upper == goodsCenterCommissionPercentRange.upper;
    }
}
