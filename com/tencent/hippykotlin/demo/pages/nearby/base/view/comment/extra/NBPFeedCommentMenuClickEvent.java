package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPFeedCommentMenuClickEvent implements INBPFeedCommentExtraEvent {
    public final NBPFeedCommentMenuItem action;
    public final NBPFeedCommentMenuOpenEvent openData;

    public NBPFeedCommentMenuClickEvent(NBPFeedCommentMenuOpenEvent nBPFeedCommentMenuOpenEvent, NBPFeedCommentMenuItem nBPFeedCommentMenuItem) {
        this.openData = nBPFeedCommentMenuOpenEvent;
        this.action = nBPFeedCommentMenuItem;
    }

    public final int hashCode() {
        return this.action.hashCode() + (this.openData.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPFeedCommentMenuClickEvent(openData=");
        m3.append(this.openData);
        m3.append(", action=");
        m3.append(this.action);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPFeedCommentMenuClickEvent)) {
            return false;
        }
        NBPFeedCommentMenuClickEvent nBPFeedCommentMenuClickEvent = (NBPFeedCommentMenuClickEvent) obj;
        return Intrinsics.areEqual(this.openData, nBPFeedCommentMenuClickEvent.openData) && this.action == nBPFeedCommentMenuClickEvent.action;
    }
}
