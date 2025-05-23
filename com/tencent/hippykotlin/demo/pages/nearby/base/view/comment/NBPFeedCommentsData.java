package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import p35.ac;
import p35.g;

/* loaded from: classes31.dex */
public final class NBPFeedCommentsData {
    public final int appId;
    public final g commentInfo;
    public final String feedId;
    public final ac likeInfo;
    public final String posterUserId;
    public final String replyCommentId;
    public final String replyReplyId;
    public final boolean showReplyInput;
    public final int source;
    public final String viewerAvatar;
    public final String viewerNickname;
    public final String viewerUserId;

    public NBPFeedCommentsData(int i3, int i16, String str, String str2, String str3, String str4, String str5, g gVar, ac acVar, String str6, String str7, boolean z16) {
        this.appId = i3;
        this.source = i16;
        this.viewerUserId = str;
        this.viewerNickname = str2;
        this.viewerAvatar = str3;
        this.posterUserId = str4;
        this.feedId = str5;
        this.commentInfo = gVar;
        this.likeInfo = acVar;
        this.replyCommentId = str6;
        this.replyReplyId = str7;
        this.showReplyInput = z16;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final g getCommentInfo() {
        return this.commentInfo;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final ac getLikeInfo() {
        return this.likeInfo;
    }

    public final String getPosterUserId() {
        return this.posterUserId;
    }

    public final String getViewerUserId() {
        return this.viewerUserId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.feedId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.posterUserId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.viewerAvatar, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.viewerNickname, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.viewerUserId, QQAudioParams$$ExternalSyntheticOutline0.m(this.source, this.appId * 31, 31), 31), 31), 31), 31), 31);
        g gVar = this.commentInfo;
        int hashCode = (m3 + (gVar == null ? 0 : gVar.hashCode())) * 31;
        ac acVar = this.likeInfo;
        int hashCode2 = (hashCode + (acVar == null ? 0 : acVar.hashCode())) * 31;
        String str = this.replyCommentId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.replyReplyId;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z16 = this.showReplyInput;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode4 + i3;
    }

    public final String toString() {
        return "NBPFeedCommentsData(appId=" + this.appId + ", source=" + this.source + ", viewerUserId=" + this.viewerUserId + ", viewerNickname=" + this.viewerNickname + ", viewerAvatar=" + this.viewerAvatar + ", posterUserId=" + this.posterUserId + ", feedId=" + this.feedId + ", commentInfo=" + this.commentInfo + ", likeInfo=" + this.likeInfo + ", replyCommentId=" + this.replyCommentId + ", replyReplyId=" + this.replyReplyId + ", showReplyInput=" + this.showReplyInput + ')';
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPFeedCommentsData)) {
            return false;
        }
        NBPFeedCommentsData nBPFeedCommentsData = (NBPFeedCommentsData) obj;
        return this.appId == nBPFeedCommentsData.appId && this.source == nBPFeedCommentsData.source && Intrinsics.areEqual(this.viewerUserId, nBPFeedCommentsData.viewerUserId) && Intrinsics.areEqual(this.viewerNickname, nBPFeedCommentsData.viewerNickname) && Intrinsics.areEqual(this.viewerAvatar, nBPFeedCommentsData.viewerAvatar) && Intrinsics.areEqual(this.posterUserId, nBPFeedCommentsData.posterUserId) && Intrinsics.areEqual(this.feedId, nBPFeedCommentsData.feedId) && Intrinsics.areEqual(this.commentInfo, nBPFeedCommentsData.commentInfo) && Intrinsics.areEqual(this.likeInfo, nBPFeedCommentsData.likeInfo) && Intrinsics.areEqual(this.replyCommentId, nBPFeedCommentsData.replyCommentId) && Intrinsics.areEqual(this.replyReplyId, nBPFeedCommentsData.replyReplyId) && this.showReplyInput == nBPFeedCommentsData.showReplyInput;
    }
}
