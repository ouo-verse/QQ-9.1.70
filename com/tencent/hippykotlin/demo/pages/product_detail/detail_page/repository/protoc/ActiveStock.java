package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ActiveStock implements ISSOModel {
    public final long active;
    public final long remain;
    public final String remainTxt;
    public final long total;

    public ActiveStock() {
        this(0L, 0L, 0L, null, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.u("total", this.total);
        eVar.u("remain", this.remain);
        eVar.u("active", this.active);
        eVar.v("remain_txt", this.remainTxt);
        return eVar;
    }

    public final int hashCode() {
        return this.remainTxt.hashCode() + AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.active, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.remain, d.a(this.total) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ActiveStock(total=");
        m3.append(this.total);
        m3.append(", remain=");
        m3.append(this.remain);
        m3.append(", active=");
        m3.append(this.active);
        m3.append(", remainTxt=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.remainTxt, ')');
    }

    public ActiveStock(long j3, long j16, long j17, String str) {
        this.total = j3;
        this.remain = j16;
        this.active = j17;
        this.remainTxt = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveStock)) {
            return false;
        }
        ActiveStock activeStock = (ActiveStock) obj;
        return this.total == activeStock.total && this.remain == activeStock.remain && this.active == activeStock.active && Intrinsics.areEqual(this.remainTxt, activeStock.remainTxt);
    }

    public /* synthetic */ ActiveStock(long j3, long j16, long j17, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0L, 0L, "");
    }
}
