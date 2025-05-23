package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterActiveInfo implements ISSOModel {
    public final String activeId;
    public final int activeType;

    public GoodsCenterActiveInfo() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("active_id", this.activeId);
        eVar.t("active_type", this.activeType);
        return eVar;
    }

    public final int hashCode() {
        return this.activeType + (this.activeId.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterActiveInfo(activeId=");
        m3.append(this.activeId);
        m3.append(", activeType=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.activeType, ')');
    }

    public GoodsCenterActiveInfo(String str, int i3) {
        this.activeId = str;
        this.activeType = i3;
    }

    public /* synthetic */ GoodsCenterActiveInfo(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterActiveInfo)) {
            return false;
        }
        GoodsCenterActiveInfo goodsCenterActiveInfo = (GoodsCenterActiveInfo) obj;
        return Intrinsics.areEqual(this.activeId, goodsCenterActiveInfo.activeId) && this.activeType == goodsCenterActiveInfo.activeType;
    }
}
