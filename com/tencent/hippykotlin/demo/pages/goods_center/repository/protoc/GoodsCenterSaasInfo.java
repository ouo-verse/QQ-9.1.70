package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterSaasInfo implements ISSOModel {
    public final String typeName;
    public final long typeNum;
    public final String typeStr;

    public GoodsCenterSaasInfo() {
        this(0L, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.u("type_num", this.typeNum);
        eVar.v("type_str", this.typeStr);
        eVar.v("type_name", this.typeName);
        return eVar;
    }

    public final int hashCode() {
        return this.typeName.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.typeStr, d.a(this.typeNum) * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterSaasInfo(typeNum=");
        m3.append(this.typeNum);
        m3.append(", typeStr=");
        m3.append(this.typeStr);
        m3.append(", typeName=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.typeName, ')');
    }

    public GoodsCenterSaasInfo(long j3, String str, String str2) {
        this.typeNum = j3;
        this.typeStr = str;
        this.typeName = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterSaasInfo)) {
            return false;
        }
        GoodsCenterSaasInfo goodsCenterSaasInfo = (GoodsCenterSaasInfo) obj;
        return this.typeNum == goodsCenterSaasInfo.typeNum && Intrinsics.areEqual(this.typeStr, goodsCenterSaasInfo.typeStr) && Intrinsics.areEqual(this.typeName, goodsCenterSaasInfo.typeName);
    }

    public /* synthetic */ GoodsCenterSaasInfo(long j3, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", "");
    }
}
