package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterCategory implements ISSOModel {
    public final int goodsType;

    /* renamed from: id, reason: collision with root package name */
    public final long f114195id;
    public final String name;

    public GoodsCenterCategory() {
        this(0L, null, 0, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.u("id", this.f114195id);
        eVar.v("name", this.name);
        eVar.t("goods_type", this.goodsType);
        return eVar;
    }

    public final int hashCode() {
        return this.goodsType + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.name, d.a(this.f114195id) * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterCategory(id=");
        m3.append(this.f114195id);
        m3.append(", name=");
        m3.append(this.name);
        m3.append(", goodsType=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.goodsType, ')');
    }

    public GoodsCenterCategory(long j3, String str, int i3) {
        this.f114195id = j3;
        this.name = str;
        this.goodsType = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterCategory)) {
            return false;
        }
        GoodsCenterCategory goodsCenterCategory = (GoodsCenterCategory) obj;
        return this.f114195id == goodsCenterCategory.f114195id && Intrinsics.areEqual(this.name, goodsCenterCategory.name) && this.goodsType == goodsCenterCategory.goodsType;
    }

    public /* synthetic */ GoodsCenterCategory(long j3, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", 0);
    }
}
