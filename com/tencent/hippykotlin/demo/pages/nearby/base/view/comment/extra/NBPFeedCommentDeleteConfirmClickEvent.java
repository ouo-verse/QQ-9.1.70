package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPFeedCommentDeleteConfirmClickEvent implements INBPFeedCommentExtraEvent {

    /* renamed from: ok, reason: collision with root package name */
    public final boolean f114215ok;
    public final NBPFeedCommentDeleteConfirmOpenEvent openData;

    public NBPFeedCommentDeleteConfirmClickEvent(NBPFeedCommentDeleteConfirmOpenEvent nBPFeedCommentDeleteConfirmOpenEvent, boolean z16) {
        this.openData = nBPFeedCommentDeleteConfirmOpenEvent;
        this.f114215ok = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.openData.hashCode() * 31;
        boolean z16 = this.f114215ok;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPFeedCommentDeleteConfirmClickEvent(openData=");
        m3.append(this.openData);
        m3.append(", ok=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.f114215ok, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPFeedCommentDeleteConfirmClickEvent)) {
            return false;
        }
        NBPFeedCommentDeleteConfirmClickEvent nBPFeedCommentDeleteConfirmClickEvent = (NBPFeedCommentDeleteConfirmClickEvent) obj;
        return Intrinsics.areEqual(this.openData, nBPFeedCommentDeleteConfirmClickEvent.openData) && this.f114215ok == nBPFeedCommentDeleteConfirmClickEvent.f114215ok;
    }
}
