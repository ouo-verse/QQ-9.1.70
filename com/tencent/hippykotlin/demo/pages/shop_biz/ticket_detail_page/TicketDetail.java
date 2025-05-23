package com.tencent.hippykotlin.demo.pages.shop_biz.ticket_detail_page;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class TicketDetail {
    public final String condition;
    public final String contact;
    public final String deadlineStr;

    /* renamed from: id, reason: collision with root package name */
    public final String f114306id;
    public final String name;
    public final String note;

    public TicketDetail(String str, String str2, String str3, String str4, String str5, String str6) {
        this.name = str;
        this.f114306id = str2;
        this.deadlineStr = str3;
        this.condition = str4;
        this.contact = str5;
        this.note = str6;
    }

    public final int hashCode() {
        return this.note.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.contact, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.condition, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.deadlineStr, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.f114306id, this.name.hashCode() * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("TicketDetail(name=");
        m3.append(this.name);
        m3.append(", id=");
        m3.append(this.f114306id);
        m3.append(", deadlineStr=");
        m3.append(this.deadlineStr);
        m3.append(", condition=");
        m3.append(this.condition);
        m3.append(", contact=");
        m3.append(this.contact);
        m3.append(", note=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.note, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TicketDetail)) {
            return false;
        }
        TicketDetail ticketDetail = (TicketDetail) obj;
        return Intrinsics.areEqual(this.name, ticketDetail.name) && Intrinsics.areEqual(this.f114306id, ticketDetail.f114306id) && Intrinsics.areEqual(this.deadlineStr, ticketDetail.deadlineStr) && Intrinsics.areEqual(this.condition, ticketDetail.condition) && Intrinsics.areEqual(this.contact, ticketDetail.contact) && Intrinsics.areEqual(this.note, ticketDetail.note);
    }
}
