package com.tencent.hippykotlin.demo.pages.advertising_attribution.model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdAttributionReq implements ISSOModel {
    public final e reportData;

    public AdAttributionReq(e eVar) {
        this.reportData = eVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("body", this.reportData.toString());
        return eVar;
    }

    public final int hashCode() {
        return this.reportData.hashCode();
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("AdAttributionReq(reportData=");
        m3.append(this.reportData);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AdAttributionReq) && Intrinsics.areEqual(this.reportData, ((AdAttributionReq) obj).reportData);
    }
}
