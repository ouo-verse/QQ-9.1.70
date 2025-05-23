package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterFilter implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final GoodsCenterCommissionPercentRange commissionPercentRange;
    public final GoodsCenterPriceRange priceRange;
    public final ArrayList<GoodsCenterSaasInfo> saasType;

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
        public final GoodsCenterFilter decode(e eVar) {
            e m3 = eVar.m("price_range");
            ArrayList arrayList = null;
            GoodsCenterPriceRange goodsCenterPriceRange = m3 != null ? new GoodsCenterPriceRange(m3.o("lower", 0L), m3.o("upper", 0L)) : null;
            e m16 = eVar.m("commission_percent_range");
            GoodsCenterCommissionPercentRange goodsCenterCommissionPercentRange = m16 != null ? new GoodsCenterCommissionPercentRange(m16.o("lower", 0L), m16.o("upper", 0L)) : null;
            b l3 = eVar.l("saas_type");
            if (l3 != null) {
                arrayList = new ArrayList();
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    Object d16 = l3.d(i3);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d16;
                        arrayList.add(new GoodsCenterSaasInfo(eVar2.o("type_num", 0L), eVar2.q("type_str", ""), eVar2.q("type_name", "")));
                    }
                }
            }
            return new GoodsCenterFilter(goodsCenterPriceRange, goodsCenterCommissionPercentRange, arrayList);
        }
    }

    public GoodsCenterFilter() {
        this(null, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        GoodsCenterPriceRange goodsCenterPriceRange = this.priceRange;
        if (goodsCenterPriceRange != null) {
            eVar.v("price_range", goodsCenterPriceRange.encode());
        }
        GoodsCenterCommissionPercentRange goodsCenterCommissionPercentRange = this.commissionPercentRange;
        if (goodsCenterCommissionPercentRange != null) {
            eVar.v("commission_percent_range", goodsCenterCommissionPercentRange.encode());
        }
        b bVar = new b();
        ArrayList<GoodsCenterSaasInfo> arrayList = this.saasType;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((GoodsCenterSaasInfo) it.next()).encode());
            }
        }
        eVar.v("saas_type", bVar);
        return eVar;
    }

    public final int hashCode() {
        GoodsCenterPriceRange goodsCenterPriceRange = this.priceRange;
        int hashCode = (goodsCenterPriceRange == null ? 0 : goodsCenterPriceRange.hashCode()) * 31;
        GoodsCenterCommissionPercentRange goodsCenterCommissionPercentRange = this.commissionPercentRange;
        int hashCode2 = (hashCode + (goodsCenterCommissionPercentRange == null ? 0 : goodsCenterCommissionPercentRange.hashCode())) * 31;
        ArrayList<GoodsCenterSaasInfo> arrayList = this.saasType;
        return hashCode2 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterFilter(priceRange=");
        m3.append(this.priceRange);
        m3.append(", commissionPercentRange=");
        m3.append(this.commissionPercentRange);
        m3.append(", saasType=");
        m3.append(this.saasType);
        m3.append(')');
        return m3.toString();
    }

    public GoodsCenterFilter(GoodsCenterPriceRange goodsCenterPriceRange, GoodsCenterCommissionPercentRange goodsCenterCommissionPercentRange, ArrayList<GoodsCenterSaasInfo> arrayList) {
        this.priceRange = goodsCenterPriceRange;
        this.commissionPercentRange = goodsCenterCommissionPercentRange;
        this.saasType = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterFilter)) {
            return false;
        }
        GoodsCenterFilter goodsCenterFilter = (GoodsCenterFilter) obj;
        return Intrinsics.areEqual(this.priceRange, goodsCenterFilter.priceRange) && Intrinsics.areEqual(this.commissionPercentRange, goodsCenterFilter.commissionPercentRange) && Intrinsics.areEqual(this.saasType, goodsCenterFilter.saasType);
    }

    public /* synthetic */ GoodsCenterFilter(GoodsCenterPriceRange goodsCenterPriceRange, GoodsCenterCommissionPercentRange goodsCenterCommissionPercentRange, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null);
    }
}
