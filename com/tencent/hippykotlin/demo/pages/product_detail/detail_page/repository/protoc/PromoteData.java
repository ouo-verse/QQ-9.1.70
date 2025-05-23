package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class PromoteData implements ISSOModel {
    public final ArrayList<Long> datas;
    public final ArrayList<String> dates;
    public final String key;
    public final String tips;
    public final String value;

    public PromoteData() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("key", this.key);
        b a16 = o.a(eVar, "value", this.value);
        ArrayList<String> arrayList = this.dates;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                a16.t((String) it.next());
            }
        }
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "dates", a16);
        ArrayList<Long> arrayList2 = this.datas;
        if (arrayList2 != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                m3.s(((Number) it5.next()).longValue());
            }
        }
        eVar.v("datas", m3);
        eVar.v("tips", this.tips);
        return eVar;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.value, this.key.hashCode() * 31, 31);
        ArrayList<String> arrayList = this.dates;
        int hashCode = (m3 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<Long> arrayList2 = this.datas;
        return this.tips.hashCode() + ((hashCode + (arrayList2 != null ? arrayList2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("PromoteData(key=");
        m3.append(this.key);
        m3.append(", value=");
        m3.append(this.value);
        m3.append(", dates=");
        m3.append(this.dates);
        m3.append(", datas=");
        m3.append(this.datas);
        m3.append(", tips=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.tips, ')');
    }

    public PromoteData(String str, String str2, ArrayList<String> arrayList, ArrayList<Long> arrayList2, String str3) {
        this.key = str;
        this.value = str2;
        this.dates = arrayList;
        this.datas = arrayList2;
        this.tips = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PromoteData)) {
            return false;
        }
        PromoteData promoteData = (PromoteData) obj;
        return Intrinsics.areEqual(this.key, promoteData.key) && Intrinsics.areEqual(this.value, promoteData.value) && Intrinsics.areEqual(this.dates, promoteData.dates) && Intrinsics.areEqual(this.datas, promoteData.datas) && Intrinsics.areEqual(this.tips, promoteData.tips);
    }

    public /* synthetic */ PromoteData(String str, String str2, ArrayList arrayList, ArrayList arrayList2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", null, null, "");
    }
}
