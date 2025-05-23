package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterExtraField implements ISSOModel {

    /* renamed from: k, reason: collision with root package name */
    public final String f114196k;

    /* renamed from: v, reason: collision with root package name */
    public final String f114197v;

    public GoodsCenterExtraField() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("k", this.f114196k);
        eVar.v("v", this.f114197v);
        return eVar;
    }

    public final int hashCode() {
        return this.f114197v.hashCode() + (this.f114196k.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterExtraField(k=");
        m3.append(this.f114196k);
        m3.append(", v=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.f114197v, ')');
    }

    public GoodsCenterExtraField(String str, String str2) {
        this.f114196k = str;
        this.f114197v = str2;
    }

    public /* synthetic */ GoodsCenterExtraField(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterExtraField)) {
            return false;
        }
        GoodsCenterExtraField goodsCenterExtraField = (GoodsCenterExtraField) obj;
        return Intrinsics.areEqual(this.f114196k, goodsCenterExtraField.f114196k) && Intrinsics.areEqual(this.f114197v, goodsCenterExtraField.f114197v);
    }
}
