package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPFeedCommentInputClosedEvent implements INBPFeedCommentExtraEvent {
    public final String inputText;
    public final boolean isQuickComment;
    public final NBPFeedCommentInputOpenEvent openData;
    public final boolean submit;

    public NBPFeedCommentInputClosedEvent(NBPFeedCommentInputOpenEvent nBPFeedCommentInputOpenEvent, boolean z16, String str, boolean z17) {
        this.openData = nBPFeedCommentInputOpenEvent;
        this.submit = z16;
        this.inputText = str;
        this.isQuickComment = z17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.openData.hashCode() * 31;
        boolean z16 = this.submit;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.inputText, (hashCode + i3) * 31, 31);
        boolean z17 = this.isQuickComment;
        return m3 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPFeedCommentInputClosedEvent(openData=");
        m3.append(this.openData);
        m3.append(", submit=");
        m3.append(this.submit);
        m3.append(", inputText=");
        m3.append(this.inputText);
        m3.append(", isQuickComment=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.isQuickComment, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPFeedCommentInputClosedEvent)) {
            return false;
        }
        NBPFeedCommentInputClosedEvent nBPFeedCommentInputClosedEvent = (NBPFeedCommentInputClosedEvent) obj;
        return Intrinsics.areEqual(this.openData, nBPFeedCommentInputClosedEvent.openData) && this.submit == nBPFeedCommentInputClosedEvent.submit && Intrinsics.areEqual(this.inputText, nBPFeedCommentInputClosedEvent.inputText) && this.isQuickComment == nBPFeedCommentInputClosedEvent.isQuickComment;
    }
}
