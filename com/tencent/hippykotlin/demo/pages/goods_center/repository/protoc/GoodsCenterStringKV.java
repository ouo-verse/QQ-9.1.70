package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterStringKV implements ISSOModel {
    public final String key;
    public final String value;

    public GoodsCenterStringKV() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("key", this.key);
        eVar.v("value", this.value);
        return eVar;
    }

    public final int hashCode() {
        return this.value.hashCode() + (this.key.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterStringKV(key=");
        m3.append(this.key);
        m3.append(", value=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.value, ')');
    }

    public GoodsCenterStringKV(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public /* synthetic */ GoodsCenterStringKV(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterStringKV)) {
            return false;
        }
        GoodsCenterStringKV goodsCenterStringKV = (GoodsCenterStringKV) obj;
        return Intrinsics.areEqual(this.key, goodsCenterStringKV.key) && Intrinsics.areEqual(this.value, goodsCenterStringKV.value);
    }
}
