package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ExplainGetShopLiveStatusRsp implements ISSOModel {
    public static final ISSOModelFactory<ExplainGetShopLiveStatusRsp> Factory = new ISSOModelFactory<ExplainGetShopLiveStatusRsp>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ExplainGetShopLiveStatusRsp$Companion$Factory$1
        @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory
        public final ExplainGetShopLiveStatusRsp decode(e eVar) {
            ExplainEnumLiveStatus explainEnumLiveStatus = new ExplainEnumLiveStatus(eVar.k("status", 0));
            e m3 = eVar.m(AegisLogger.ROOM_INFO);
            return new ExplainGetShopLiveStatusRsp(explainEnumLiveStatus, m3 != null ? new ExplainLiveRoomBaseInfo(m3.o(AudienceReportConst.ROOM_ID, 0L), m3.q("room_url", ""), m3.q("title", ""), m3.q("anchor_nick", "")) : null, eVar.k("polling_tick", 0));
        }
    };
    public final int pollingTick;
    public final ExplainLiveRoomBaseInfo roomInfo;
    public final ExplainEnumLiveStatus status;

    public ExplainGetShopLiveStatusRsp() {
        this(null, null, 0, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        ExplainEnumLiveStatus explainEnumLiveStatus = this.status;
        if (explainEnumLiveStatus != null) {
            eVar.v("status", explainEnumLiveStatus);
        }
        ExplainLiveRoomBaseInfo explainLiveRoomBaseInfo = this.roomInfo;
        if (explainLiveRoomBaseInfo != null) {
            eVar.v(AegisLogger.ROOM_INFO, explainLiveRoomBaseInfo.encode());
        }
        eVar.t("polling_tick", this.pollingTick);
        return eVar;
    }

    public final int hashCode() {
        ExplainEnumLiveStatus explainEnumLiveStatus = this.status;
        int hashCode = (explainEnumLiveStatus == null ? 0 : explainEnumLiveStatus.hashCode()) * 31;
        ExplainLiveRoomBaseInfo explainLiveRoomBaseInfo = this.roomInfo;
        return this.pollingTick + ((hashCode + (explainLiveRoomBaseInfo != null ? explainLiveRoomBaseInfo.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ExplainGetShopLiveStatusRsp(status=");
        m3.append(this.status);
        m3.append(", roomInfo=");
        m3.append(this.roomInfo);
        m3.append(", pollingTick=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.pollingTick, ')');
    }

    public ExplainGetShopLiveStatusRsp(ExplainEnumLiveStatus explainEnumLiveStatus, ExplainLiveRoomBaseInfo explainLiveRoomBaseInfo, int i3) {
        this.status = explainEnumLiveStatus;
        this.roomInfo = explainLiveRoomBaseInfo;
        this.pollingTick = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExplainGetShopLiveStatusRsp)) {
            return false;
        }
        ExplainGetShopLiveStatusRsp explainGetShopLiveStatusRsp = (ExplainGetShopLiveStatusRsp) obj;
        return Intrinsics.areEqual(this.status, explainGetShopLiveStatusRsp.status) && Intrinsics.areEqual(this.roomInfo, explainGetShopLiveStatusRsp.roomInfo) && this.pollingTick == explainGetShopLiveStatusRsp.pollingTick;
    }

    public /* synthetic */ ExplainGetShopLiveStatusRsp(ExplainEnumLiveStatus explainEnumLiveStatus, ExplainLiveRoomBaseInfo explainLiveRoomBaseInfo, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, 0);
    }
}
