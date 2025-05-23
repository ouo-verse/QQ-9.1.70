package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ExplainLiveRoomBaseInfo implements ISSOModel {
    public final String anchorNick;
    public final long roomId;
    public final String roomUrl;
    public final String title;

    public ExplainLiveRoomBaseInfo() {
        this(0L, null, null, null, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.u(AudienceReportConst.ROOM_ID, this.roomId);
        eVar.v("room_url", this.roomUrl);
        eVar.v("title", this.title);
        eVar.v("anchor_nick", this.anchorNick);
        return eVar;
    }

    public final int hashCode() {
        return this.anchorNick.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.title, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.roomUrl, d.a(this.roomId) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ExplainLiveRoomBaseInfo(roomId=");
        m3.append(this.roomId);
        m3.append(", roomUrl=");
        m3.append(this.roomUrl);
        m3.append(", title=");
        m3.append(this.title);
        m3.append(", anchorNick=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.anchorNick, ')');
    }

    public ExplainLiveRoomBaseInfo(long j3, String str, String str2, String str3) {
        this.roomId = j3;
        this.roomUrl = str;
        this.title = str2;
        this.anchorNick = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExplainLiveRoomBaseInfo)) {
            return false;
        }
        ExplainLiveRoomBaseInfo explainLiveRoomBaseInfo = (ExplainLiveRoomBaseInfo) obj;
        return this.roomId == explainLiveRoomBaseInfo.roomId && Intrinsics.areEqual(this.roomUrl, explainLiveRoomBaseInfo.roomUrl) && Intrinsics.areEqual(this.title, explainLiveRoomBaseInfo.title) && Intrinsics.areEqual(this.anchorNick, explainLiveRoomBaseInfo.anchorNick);
    }

    public /* synthetic */ ExplainLiveRoomBaseInfo(long j3, String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", "", "");
    }
}
