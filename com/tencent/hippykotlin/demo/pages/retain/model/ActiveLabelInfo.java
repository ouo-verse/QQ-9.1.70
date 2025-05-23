package com.tencent.hippykotlin.demo.pages.retain.model;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ActiveLabelInfo implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final String activeId;
    public final Button button;
    public final ActivePrice livePrice;
    public final ActiveTimeRange liveTimeRange;

    public ActiveLabelInfo() {
        this(null, null, null, null, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("active_id", this.activeId);
        ActivePrice activePrice = this.livePrice;
        if (activePrice != null) {
            eVar.v("live_price", activePrice.encode());
        }
        ActiveTimeRange activeTimeRange = this.liveTimeRange;
        if (activeTimeRange != null) {
            eVar.v("live_time_range", activeTimeRange.encode());
        }
        Button button = this.button;
        if (button != null) {
            eVar.v("button", button.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        int hashCode = this.activeId.hashCode() * 31;
        ActivePrice activePrice = this.livePrice;
        int hashCode2 = (hashCode + (activePrice == null ? 0 : activePrice.hashCode())) * 31;
        ActiveTimeRange activeTimeRange = this.liveTimeRange;
        int hashCode3 = (hashCode2 + (activeTimeRange == null ? 0 : activeTimeRange.hashCode())) * 31;
        Button button = this.button;
        return hashCode3 + (button != null ? button.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ActiveLabelInfo(activeId=");
        m3.append(this.activeId);
        m3.append(", livePrice=");
        m3.append(this.livePrice);
        m3.append(", liveTimeRange=");
        m3.append(this.liveTimeRange);
        m3.append(", button=");
        m3.append(this.button);
        m3.append(')');
        return m3.toString();
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public final ActiveLabelInfo decode(e eVar) {
            String q16 = eVar.q("active_id", "");
            e m3 = eVar.m("live_price");
            ActivePrice activePrice = m3 != null ? new ActivePrice(m3.o(Element.ELEMENT_NAME_MIN, 0L), m3.o("max", 0L), m3.o("original", 0L), m3.q("discount_price_txt", ""), m3.q("discount_price_desc", ""), m3.o("live", 0L), m3.o("live_special", 0L)) : null;
            e m16 = eVar.m("live_time_range");
            ActiveTimeRange activeTimeRange = m16 != null ? new ActiveTimeRange(m16.o("begin", 0L), m16.o("end", 0L)) : null;
            e m17 = eVar.m("button");
            return new ActiveLabelInfo(q16, activePrice, activeTimeRange, m17 != null ? new Button(m17.q("left_text", ""), m17.q("right_text", ""), m17.q("right_jumpurl", "")) : null);
        }
    }

    public ActiveLabelInfo(String str, ActivePrice activePrice, ActiveTimeRange activeTimeRange, Button button) {
        this.activeId = str;
        this.livePrice = activePrice;
        this.liveTimeRange = activeTimeRange;
        this.button = button;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveLabelInfo)) {
            return false;
        }
        ActiveLabelInfo activeLabelInfo = (ActiveLabelInfo) obj;
        return Intrinsics.areEqual(this.activeId, activeLabelInfo.activeId) && Intrinsics.areEqual(this.livePrice, activeLabelInfo.livePrice) && Intrinsics.areEqual(this.liveTimeRange, activeLabelInfo.liveTimeRange) && Intrinsics.areEqual(this.button, activeLabelInfo.button);
    }

    public /* synthetic */ ActiveLabelInfo(String str, ActivePrice activePrice, ActiveTimeRange activeTimeRange, Button button, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, null, null);
    }
}
