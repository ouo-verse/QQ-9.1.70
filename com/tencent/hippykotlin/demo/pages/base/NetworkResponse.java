package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NetworkResponse<RSP> {
    public final int code;
    public final RSP data;
    public final String message;
    public final SpanReqData spanReqData;

    public NetworkResponse() {
        this(0, null, null, null, 15);
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.message, this.code * 31, 31);
        RSP rsp = this.data;
        int hashCode = (m3 + (rsp == null ? 0 : rsp.hashCode())) * 31;
        SpanReqData spanReqData = this.spanReqData;
        return hashCode + (spanReqData != null ? spanReqData.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NetworkResponse(code=");
        m3.append(this.code);
        m3.append(", message=");
        m3.append(this.message);
        m3.append(", data=");
        m3.append(this.data);
        m3.append(", spanReqData=");
        m3.append(this.spanReqData);
        m3.append(')');
        return m3.toString();
    }

    public NetworkResponse(int i3, String str, RSP rsp, SpanReqData spanReqData) {
        this.code = i3;
        this.message = str;
        this.data = rsp;
        this.spanReqData = spanReqData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkResponse)) {
            return false;
        }
        NetworkResponse networkResponse = (NetworkResponse) obj;
        return this.code == networkResponse.code && Intrinsics.areEqual(this.message, networkResponse.message) && Intrinsics.areEqual(this.data, networkResponse.data) && Intrinsics.areEqual(this.spanReqData, networkResponse.spanReqData);
    }

    public /* synthetic */ NetworkResponse(int i3, String str, Object obj, SpanReqData spanReqData, int i16) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? null : obj, (i16 & 8) != 0 ? null : spanReqData);
    }
}
