package com.tencent.hippykotlin.demo.pages.retain.model;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ActiveTimeRange implements ISSOModel {
    public final long begin;
    public final long end;

    public ActiveTimeRange() {
        this(0L, 0L, 3, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.u("begin", this.begin);
        eVar.u("end", this.end);
        return eVar;
    }

    public final int hashCode() {
        return d.a(this.end) + (d.a(this.begin) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ActiveTimeRange(begin=");
        m3.append(this.begin);
        m3.append(", end=");
        return GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(m3, this.end, ')');
    }

    public ActiveTimeRange(long j3, long j16) {
        this.begin = j3;
        this.end = j16;
    }

    public /* synthetic */ ActiveTimeRange(long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0L);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveTimeRange)) {
            return false;
        }
        ActiveTimeRange activeTimeRange = (ActiveTimeRange) obj;
        return this.begin == activeTimeRange.begin && this.end == activeTimeRange.end;
    }
}
