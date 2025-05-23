package com.tencent.hippykotlin.demo.pages.retain.model;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Labelheader implements ISSOModel {
    public final String countdownText;
    public final long countdownTime;
    public final String topText;

    public Labelheader() {
        this(null, null, 0L, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("top_text", this.topText);
        eVar.v("countdown_text", this.countdownText);
        eVar.u(StateEvent.Name.COUNTDOWN_TIME, this.countdownTime);
        return eVar;
    }

    public final int hashCode() {
        return d.a(this.countdownTime) + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.countdownText, this.topText.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Labelheader(topText=");
        m3.append(this.topText);
        m3.append(", countdownText=");
        m3.append(this.countdownText);
        m3.append(", countdownTime=");
        return GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(m3, this.countdownTime, ')');
    }

    public Labelheader(String str, String str2, long j3) {
        this.topText = str;
        this.countdownText = str2;
        this.countdownTime = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Labelheader)) {
            return false;
        }
        Labelheader labelheader = (Labelheader) obj;
        return Intrinsics.areEqual(this.topText, labelheader.topText) && Intrinsics.areEqual(this.countdownText, labelheader.countdownText) && this.countdownTime == labelheader.countdownTime;
    }

    public /* synthetic */ Labelheader(String str, String str2, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", 0L);
    }
}
