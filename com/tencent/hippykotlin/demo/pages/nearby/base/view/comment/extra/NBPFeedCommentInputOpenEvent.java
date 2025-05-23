package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedCommentRepoKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CommentPanelState;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPFeedCommentInputOpenEvent implements INBPFeedCommentExtraEvent {
    public static final Companion Companion = new Companion();
    public List<QuickCommentItem> aiQuickComments;
    public final int appId;
    public final String feedId;
    public final String key = "NBPFeedCommentInputOpenEvent";
    public final String pagerId;
    public final CommentPanelState panelState;
    public final String placeholder;
    public List<QuickCommentItem> quickComments;
    public final String requestId;
    public final String targetCommentId;
    public final String targetReplyId;
    public final String targetUserNickname;

    public NBPFeedCommentInputOpenEvent(String str, int i3, String str2, String str3, String str4, String str5, String str6, String str7, CommentPanelState commentPanelState, List<QuickCommentItem> list, List<QuickCommentItem> list2) {
        this.requestId = str;
        this.appId = i3;
        this.feedId = str2;
        this.pagerId = str3;
        this.targetCommentId = str4;
        this.targetReplyId = str5;
        this.targetUserNickname = str6;
        this.placeholder = str7;
        this.panelState = commentPanelState;
        this.quickComments = list;
        this.aiQuickComments = list2;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.pagerId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.feedId, QQAudioParams$$ExternalSyntheticOutline0.m(this.appId, this.requestId.hashCode() * 31, 31), 31), 31);
        String str = this.targetCommentId;
        int hashCode = (m3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.targetReplyId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.targetUserNickname;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.placeholder;
        return this.aiQuickComments.hashCode() + ((this.quickComments.hashCode() + ((this.panelState.hashCode() + ((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31)) * 31)) * 31);
    }

    public final e toJson() {
        e eVar = new e();
        eVar.v("request_id", this.requestId);
        eVar.t("app_id", this.appId);
        eVar.v("feed_id", this.feedId);
        eVar.v("pager_id", this.pagerId);
        String str = this.targetCommentId;
        if (str != null) {
            eVar.v("target_comment_id", str);
        }
        String str2 = this.targetReplyId;
        if (str2 != null) {
            eVar.v("target_reply_id", str2);
        }
        String str3 = this.targetUserNickname;
        if (str3 != null) {
            eVar.v("target_user_nickname", str3);
        }
        String str4 = this.placeholder;
        if (str4 != null) {
            eVar.v("placeholder", str4);
        }
        eVar.t("panel_state", this.panelState.ordinal());
        eVar.v("quick_comments", StrangerFeedCommentRepoKt.toJSON(this.quickComments));
        eVar.v("ai_quick_comments", StrangerFeedCommentRepoKt.toJSON(this.aiQuickComments));
        return eVar;
    }

    public final String toString() {
        return "NBPFeedCommentInputOpenEvent(requestId=" + this.requestId + ", appId=" + this.appId + ", feedId=" + this.feedId + ", pagerId=" + this.pagerId + ", targetCommentId=" + this.targetCommentId + ", targetReplyId=" + this.targetReplyId + ", targetUserNickname=" + this.targetUserNickname + ", placeholder=" + this.placeholder + ", panelState=" + this.panelState + ", quickComments=" + this.quickComments + ", aiQuickComments=" + this.aiQuickComments + ')';
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final NBPFeedCommentInputOpenEvent fromJson(e eVar) {
            String p16 = eVar.p("request_id");
            int j3 = eVar.j("app_id");
            String p17 = eVar.p("feed_id");
            String p18 = eVar.p("pager_id");
            String p19 = eVar.p("target_comment_id");
            CommentPanelState commentPanelState = null;
            if (p19.length() == 0) {
                p19 = null;
            }
            String p26 = eVar.p("target_reply_id");
            String str = p26.length() == 0 ? null : p26;
            String p27 = eVar.p("target_user_nickname");
            String str2 = p27.length() == 0 ? null : p27;
            String p28 = eVar.p("placeholder");
            String str3 = p28.length() == 0 ? null : p28;
            int j16 = eVar.j("panel_state");
            CommentPanelState[] values = CommentPanelState.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                CommentPanelState commentPanelState2 = values[i3];
                if (commentPanelState2.ordinal() == j16) {
                    commentPanelState = commentPanelState2;
                    break;
                }
                i3++;
            }
            return new NBPFeedCommentInputOpenEvent(p16, j3, p17, p18, p19, str, str2, str3, commentPanelState == null ? CommentPanelState.None : commentPanelState, StrangerFeedCommentRepoKt.parseQuickCommentList(eVar.l("quick_comments")), StrangerFeedCommentRepoKt.parseQuickCommentList(eVar.l("ai_quick_comments")));
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPFeedCommentInputOpenEvent)) {
            return false;
        }
        NBPFeedCommentInputOpenEvent nBPFeedCommentInputOpenEvent = (NBPFeedCommentInputOpenEvent) obj;
        return Intrinsics.areEqual(this.requestId, nBPFeedCommentInputOpenEvent.requestId) && this.appId == nBPFeedCommentInputOpenEvent.appId && Intrinsics.areEqual(this.feedId, nBPFeedCommentInputOpenEvent.feedId) && Intrinsics.areEqual(this.pagerId, nBPFeedCommentInputOpenEvent.pagerId) && Intrinsics.areEqual(this.targetCommentId, nBPFeedCommentInputOpenEvent.targetCommentId) && Intrinsics.areEqual(this.targetReplyId, nBPFeedCommentInputOpenEvent.targetReplyId) && Intrinsics.areEqual(this.targetUserNickname, nBPFeedCommentInputOpenEvent.targetUserNickname) && Intrinsics.areEqual(this.placeholder, nBPFeedCommentInputOpenEvent.placeholder) && this.panelState == nBPFeedCommentInputOpenEvent.panelState && Intrinsics.areEqual(this.quickComments, nBPFeedCommentInputOpenEvent.quickComments) && Intrinsics.areEqual(this.aiQuickComments, nBPFeedCommentInputOpenEvent.aiQuickComments);
    }
}
