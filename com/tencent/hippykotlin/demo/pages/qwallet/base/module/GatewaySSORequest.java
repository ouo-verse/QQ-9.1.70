package com.tencent.hippykotlin.demo.pages.qwallet.base.module;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class GatewaySSORequest {
    public final String method;
    public final boolean needEncrypt;
    public final String requestBytesBase64;
    public final String service;

    public GatewaySSORequest(String str, String str2, String str3, boolean z16) {
        this.service = str;
        this.method = str2;
        this.requestBytesBase64 = str3;
        this.needEncrypt = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.requestBytesBase64, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.method, this.service.hashCode() * 31, 31), 31);
        boolean z16 = this.needEncrypt;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return m3 + i3;
    }

    public final String toString() {
        StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('[');
        m3.append(this.service);
        m3.append('.');
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.method, ']');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GatewaySSORequest)) {
            return false;
        }
        GatewaySSORequest gatewaySSORequest = (GatewaySSORequest) obj;
        return Intrinsics.areEqual(this.service, gatewaySSORequest.service) && Intrinsics.areEqual(this.method, gatewaySSORequest.method) && Intrinsics.areEqual(this.requestBytesBase64, gatewaySSORequest.requestBytesBase64) && this.needEncrypt == gatewaySSORequest.needEncrypt;
    }
}
