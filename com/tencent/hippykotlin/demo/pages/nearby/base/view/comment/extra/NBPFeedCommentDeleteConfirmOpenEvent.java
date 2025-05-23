package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPFeedCommentDeleteConfirmOpenEvent implements INBPFeedCommentExtraEvent {
    public final String feedId;
    public final String pagerId;
    public final String targetCommentId;
    public final String targetReplyId;

    public NBPFeedCommentDeleteConfirmOpenEvent(String str, String str2, String str3, String str4) {
        this.feedId = str;
        this.pagerId = str2;
        this.targetCommentId = str3;
        this.targetReplyId = str4;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.targetCommentId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.pagerId, this.feedId.hashCode() * 31, 31), 31);
        String str = this.targetReplyId;
        return m3 + (str == null ? 0 : str.hashCode());
    }

    public final e toJson() {
        e eVar = new e();
        eVar.v("feedId", this.feedId);
        eVar.v("pager_id", this.pagerId);
        eVar.v("targetCommentId", this.targetCommentId);
        eVar.v("targetReplyId", this.targetReplyId);
        return eVar;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPFeedCommentDeleteConfirmOpenEvent(feedId=");
        m3.append(this.feedId);
        m3.append(", pagerId=");
        m3.append(this.pagerId);
        m3.append(", targetCommentId=");
        m3.append(this.targetCommentId);
        m3.append(", targetReplyId=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.targetReplyId, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPFeedCommentDeleteConfirmOpenEvent)) {
            return false;
        }
        NBPFeedCommentDeleteConfirmOpenEvent nBPFeedCommentDeleteConfirmOpenEvent = (NBPFeedCommentDeleteConfirmOpenEvent) obj;
        return Intrinsics.areEqual(this.feedId, nBPFeedCommentDeleteConfirmOpenEvent.feedId) && Intrinsics.areEqual(this.pagerId, nBPFeedCommentDeleteConfirmOpenEvent.pagerId) && Intrinsics.areEqual(this.targetCommentId, nBPFeedCommentDeleteConfirmOpenEvent.targetCommentId) && Intrinsics.areEqual(this.targetReplyId, nBPFeedCommentDeleteConfirmOpenEvent.targetReplyId);
    }
}
