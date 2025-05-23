package com.tencent.hippykotlin.demo.pages.foundation.module;

import c45.e;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class OIDBResponse<Rsp extends e> {
    public final int code;

    /* renamed from: msg, reason: collision with root package name */
    public final String f114186msg;
    public final Rsp rsp;
    public final boolean success;

    public OIDBResponse(boolean z16, int i3, String str, Rsp rsp) {
        this.success = z16;
        this.code = i3;
        this.f114186msg = str;
        this.rsp = rsp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z16 = this.success;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.f114186msg, QQAudioParams$$ExternalSyntheticOutline0.m(this.code, r06 * 31, 31), 31);
        Rsp rsp = this.rsp;
        return m3 + (rsp == null ? 0 : rsp.hashCode());
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("OIDBResponse(success=");
        m3.append(this.success);
        m3.append(", code=");
        m3.append(this.code);
        m3.append(", msg=");
        m3.append(this.f114186msg);
        m3.append(", rsp=");
        m3.append(this.rsp);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OIDBResponse)) {
            return false;
        }
        OIDBResponse oIDBResponse = (OIDBResponse) obj;
        return this.success == oIDBResponse.success && this.code == oIDBResponse.code && Intrinsics.areEqual(this.f114186msg, oIDBResponse.f114186msg) && Intrinsics.areEqual(this.rsp, oIDBResponse.rsp);
    }
}
