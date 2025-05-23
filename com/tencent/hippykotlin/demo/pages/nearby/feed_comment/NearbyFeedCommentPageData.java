package com.tencent.hippykotlin.demo.pages.nearby.feed_comment;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import p35.ac;
import p35.g;

/* loaded from: classes31.dex */
public final class NearbyFeedCommentPageData {
    public final int appId;
    public final g commentInfo;
    public final String feedId;
    public final ac likeInfo;
    public final String posterUserId;
    public final int source;
    public final String viewerAvatar;
    public final String viewerNickname;
    public final String viewerUserId;
    public final boolean withKeyboard;

    public NearbyFeedCommentPageData(int i3, int i16, String str, String str2, String str3, String str4, String str5, g gVar, ac acVar, boolean z16) {
        this.appId = i3;
        this.source = i16;
        this.viewerUserId = str;
        this.viewerNickname = str2;
        this.viewerAvatar = str3;
        this.posterUserId = str4;
        this.feedId = str5;
        this.commentInfo = gVar;
        this.likeInfo = acVar;
        this.withKeyboard = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.feedId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.posterUserId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.viewerAvatar, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.viewerNickname, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.viewerUserId, QQAudioParams$$ExternalSyntheticOutline0.m(this.source, this.appId * 31, 31), 31), 31), 31), 31), 31);
        g gVar = this.commentInfo;
        int hashCode = (m3 + (gVar == null ? 0 : gVar.hashCode())) * 31;
        ac acVar = this.likeInfo;
        int hashCode2 = (hashCode + (acVar != null ? acVar.hashCode() : 0)) * 31;
        boolean z16 = this.withKeyboard;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode2 + i3;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NearbyFeedCommentPageData(appId=");
        m3.append(this.appId);
        m3.append(", source=");
        m3.append(this.source);
        m3.append(", viewerUserId=");
        m3.append(this.viewerUserId);
        m3.append(", viewerNickname=");
        m3.append(this.viewerNickname);
        m3.append(", viewerAvatar=");
        m3.append(this.viewerAvatar);
        m3.append(", posterUserId=");
        m3.append(this.posterUserId);
        m3.append(", feedId=");
        m3.append(this.feedId);
        m3.append(", commentInfo=");
        m3.append(this.commentInfo);
        m3.append(", likeInfo=");
        m3.append(this.likeInfo);
        m3.append(", withKeyboard=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.withKeyboard, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyFeedCommentPageData)) {
            return false;
        }
        NearbyFeedCommentPageData nearbyFeedCommentPageData = (NearbyFeedCommentPageData) obj;
        return this.appId == nearbyFeedCommentPageData.appId && this.source == nearbyFeedCommentPageData.source && Intrinsics.areEqual(this.viewerUserId, nearbyFeedCommentPageData.viewerUserId) && Intrinsics.areEqual(this.viewerNickname, nearbyFeedCommentPageData.viewerNickname) && Intrinsics.areEqual(this.viewerAvatar, nearbyFeedCommentPageData.viewerAvatar) && Intrinsics.areEqual(this.posterUserId, nearbyFeedCommentPageData.posterUserId) && Intrinsics.areEqual(this.feedId, nearbyFeedCommentPageData.feedId) && Intrinsics.areEqual(this.commentInfo, nearbyFeedCommentPageData.commentInfo) && Intrinsics.areEqual(this.likeInfo, nearbyFeedCommentPageData.likeInfo) && this.withKeyboard == nearbyFeedCommentPageData.withKeyboard;
    }
}
