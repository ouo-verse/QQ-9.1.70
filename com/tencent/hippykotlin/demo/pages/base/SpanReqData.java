package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SpanReqData {
    public final String spanContext;
    public final String traceId;

    public SpanReqData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final int hashCode() {
        return this.traceId.hashCode() + (this.spanContext.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("SpanReqData(spanContext=");
        m3.append(this.spanContext);
        m3.append(", traceId=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.traceId, ')');
    }

    public SpanReqData(String str, String str2) {
        this.spanContext = str;
        this.traceId = str2;
    }

    public /* synthetic */ SpanReqData(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpanReqData)) {
            return false;
        }
        SpanReqData spanReqData = (SpanReqData) obj;
        return Intrinsics.areEqual(this.spanContext, spanReqData.spanContext) && Intrinsics.areEqual(this.traceId, spanReqData.traceId);
    }
}
