package com.tencent.hippykotlin.demo.pages.retain.model;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes33.dex */
public final class GetPromotePopupReq implements ISSOModel {
    public final int channel;
    public final String from;
    public final String spuId;

    public GetPromotePopupReq() {
        this(null, 0, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("spu_id", this.spuId);
        eVar.t(WadlProxyConsts.CHANNEL, this.channel);
        eVar.v("from", this.from);
        return eVar;
    }

    public final int hashCode() {
        return this.from.hashCode() + QQAudioParams$$ExternalSyntheticOutline0.m(this.channel, this.spuId.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GetPromotePopupReq(spuId=");
        m3.append(this.spuId);
        m3.append(", channel=");
        m3.append(this.channel);
        m3.append(", from=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.from, ')');
    }

    public GetPromotePopupReq(String str, int i3, String str2) {
        this.spuId = str;
        this.channel = i3;
        this.from = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetPromotePopupReq)) {
            return false;
        }
        GetPromotePopupReq getPromotePopupReq = (GetPromotePopupReq) obj;
        return Intrinsics.areEqual(this.spuId, getPromotePopupReq.spuId) && this.channel == getPromotePopupReq.channel && Intrinsics.areEqual(this.from, getPromotePopupReq.from);
    }

    public /* synthetic */ GetPromotePopupReq(String str, int i3, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, "");
    }
}
