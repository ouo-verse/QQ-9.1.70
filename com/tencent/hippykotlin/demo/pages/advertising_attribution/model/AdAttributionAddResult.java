package com.tencent.hippykotlin.demo.pages.advertising_attribution.model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdAttributionAddResult {
    public final int code;

    /* renamed from: msg, reason: collision with root package name */
    public final String f114179msg;
    public final String msgCN;

    public AdAttributionAddResult(int i3, String str, String str2) {
        this.code = i3;
        this.f114179msg = str;
        this.msgCN = str2;
    }

    public final int hashCode() {
        return this.msgCN.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.f114179msg, this.code * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("AdAttributionAddResult(code=");
        m3.append(this.code);
        m3.append(", msg=");
        m3.append(this.f114179msg);
        m3.append(", msgCN=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.msgCN, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdAttributionAddResult)) {
            return false;
        }
        AdAttributionAddResult adAttributionAddResult = (AdAttributionAddResult) obj;
        return this.code == adAttributionAddResult.code && Intrinsics.areEqual(this.f114179msg, adAttributionAddResult.f114179msg) && Intrinsics.areEqual(this.msgCN, adAttributionAddResult.msgCN);
    }
}
