package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPFeedCommentMenuOpenEvent implements INBPFeedCommentExtraEvent {
    public final int appId;
    public final String feedId;
    public final String pagerId;
    public final String posterUserId;
    public final String targetCommentId;
    public final String targetReplyId;
    public final String targetUserId;
    public final String viewerUserId;

    public NBPFeedCommentMenuOpenEvent(int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.appId = i3;
        this.feedId = str;
        this.pagerId = str2;
        this.viewerUserId = str3;
        this.posterUserId = str4;
        this.targetUserId = str5;
        this.targetCommentId = str6;
        this.targetReplyId = str7;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.targetCommentId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.targetUserId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.posterUserId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.viewerUserId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.pagerId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.feedId, this.appId * 31, 31), 31), 31), 31), 31), 31);
        String str = this.targetReplyId;
        return m3 + (str == null ? 0 : str.hashCode());
    }

    public final e toJson() {
        e eVar = new e();
        eVar.t("appId", this.appId);
        eVar.v("feedId", this.feedId);
        eVar.v("pager_id", this.pagerId);
        eVar.v("viewerUserId", this.viewerUserId);
        eVar.v("posterUserId", this.posterUserId);
        eVar.v("targetUserId", this.targetUserId);
        eVar.v("targetCommentId", this.targetCommentId);
        eVar.v("targetReplyId", this.targetReplyId);
        return eVar;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPFeedCommentMenuOpenEvent(appId=");
        m3.append(this.appId);
        m3.append(", feedId=");
        m3.append(this.feedId);
        m3.append(", pagerId=");
        m3.append(this.pagerId);
        m3.append(", viewerUserId=");
        m3.append(this.viewerUserId);
        m3.append(", posterUserId=");
        m3.append(this.posterUserId);
        m3.append(", targetUserId=");
        m3.append(this.targetUserId);
        m3.append(", targetCommentId=");
        m3.append(this.targetCommentId);
        m3.append(", targetReplyId=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.targetReplyId, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPFeedCommentMenuOpenEvent)) {
            return false;
        }
        NBPFeedCommentMenuOpenEvent nBPFeedCommentMenuOpenEvent = (NBPFeedCommentMenuOpenEvent) obj;
        return this.appId == nBPFeedCommentMenuOpenEvent.appId && Intrinsics.areEqual(this.feedId, nBPFeedCommentMenuOpenEvent.feedId) && Intrinsics.areEqual(this.pagerId, nBPFeedCommentMenuOpenEvent.pagerId) && Intrinsics.areEqual(this.viewerUserId, nBPFeedCommentMenuOpenEvent.viewerUserId) && Intrinsics.areEqual(this.posterUserId, nBPFeedCommentMenuOpenEvent.posterUserId) && Intrinsics.areEqual(this.targetUserId, nBPFeedCommentMenuOpenEvent.targetUserId) && Intrinsics.areEqual(this.targetCommentId, nBPFeedCommentMenuOpenEvent.targetCommentId) && Intrinsics.areEqual(this.targetReplyId, nBPFeedCommentMenuOpenEvent.targetReplyId);
    }
}
