package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\t\u000eB\u009d\u0001\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\u0018\u0012\b\b\u0002\u0010.\u001a\u00020\u0004\u0012\b\b\u0002\u00102\u001a\u00020/\u0012\b\b\u0002\u00104\u001a\u00020\u0007\u0012\b\b\u0002\u00106\u001a\u00020\u0007\u0012\b\b\u0002\u0010:\u001a\u000207\u00a2\u0006\u0004\b;\u0010<J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u001f\u0010\fR\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\fR\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b$\u0010\fR\u0017\u0010(\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b\u0015\u0010'R\u0017\u0010+\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010\u001bR\"\u0010.\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010&\u001a\u0004\b)\u0010'\"\u0004\b,\u0010-R\u0017\u00102\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b$\u00100\u001a\u0004\b!\u00101R\"\u00104\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011\"\u0004\b3\u0010\u0013R\u0017\u00106\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b5\u0010\u000f\u001a\u0004\b5\u0010\u0011R\u0017\u0010:\u001a\u0002078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u00108\u001a\u0004\b\u001d\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "msgId", "b", "Z", "d", "()Z", "o", "(Z)V", "hasRead", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "userId", "", "J", "i", "()J", "peerTinyId", "e", "avatar", tl.h.F, "nick", "g", "k", "summary", "l", "time", "I", "()I", "emojiId", "j", "getFeedId", "feedId", "setSceneId", "(I)V", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l$b;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l$b;", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l$b;", "msgInfo", "setCanChat", "canChat", DomainData.DOMAIN_NAME, "isCommentDeleted", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l$a;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l$a;", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l$a;", "interactiveOption", "<init>", "(Ljava/lang/String;ZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJILcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l$b;ZZLcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l$a;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.l, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerLiteActionModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String msgId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean hasRead;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String userId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long peerTinyId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String avatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final String nick;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final String summary;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final String time;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int emojiId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final long feedId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private int sceneId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final MsgInfo msgInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean canChat;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isCommentDeleted;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private final InteractiveOption interactiveOption;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "d", "(Z)V", "canShowQuickReply", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "quickReplyText", "I", "()I", "interactiveId", "<init>", "(ZLjava/lang/String;I)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.l$a, reason: from toString */
    /* loaded from: classes33.dex */
    public static final /* data */ class InteractiveOption {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean canShowQuickReply;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String quickReplyText;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int interactiveId;

        public InteractiveOption() {
            this(false, null, 0, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getCanShowQuickReply() {
            return this.canShowQuickReply;
        }

        /* renamed from: b, reason: from getter */
        public final int getInteractiveId() {
            return this.interactiveId;
        }

        /* renamed from: c, reason: from getter */
        public final String getQuickReplyText() {
            return this.quickReplyText;
        }

        public final void d(boolean z16) {
            this.canShowQuickReply = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.canShowQuickReply;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((r06 * 31) + this.quickReplyText.hashCode()) * 31) + this.interactiveId;
        }

        public String toString() {
            return "InteractiveOption(canShowQuickReply=" + this.canShowQuickReply + ", quickReplyText=" + this.quickReplyText + ", interactiveId=" + this.interactiveId + ")";
        }

        public InteractiveOption(boolean z16, String quickReplyText, int i3) {
            Intrinsics.checkNotNullParameter(quickReplyText, "quickReplyText");
            this.canShowQuickReply = z16;
            this.quickReplyText = quickReplyText;
            this.interactiveId = i3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InteractiveOption)) {
                return false;
            }
            InteractiveOption interactiveOption = (InteractiveOption) other;
            return this.canShowQuickReply == interactiveOption.canShowQuickReply && Intrinsics.areEqual(this.quickReplyText, interactiveOption.quickReplyText) && this.interactiveId == interactiveOption.interactiveId;
        }

        public /* synthetic */ InteractiveOption(boolean z16, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? 0 : i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\"\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "feedId", "b", "I", "getFeedSource", "()I", "feedSource", "content", "d", "e", "pic", "getComment", "comment", "f", WSAutoShowCommentParams.KEY_COMMENT_ID, "g", "feedOwnerUid", tl.h.F, WSAutoShowCommentParams.KEY_REPLY_ID, "i", "Z", "()Z", "isFeedDeleted", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.l$b, reason: from toString */
    /* loaded from: classes33.dex */
    public static final /* data */ class MsgInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String feedId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int feedSource;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String content;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String pic;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final String comment;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final String commentId;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final String feedOwnerUid;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final String replyId;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isFeedDeleted;

        public MsgInfo() {
            this(null, 0, null, null, null, null, null, null, false, 511, null);
        }

        /* renamed from: a, reason: from getter */
        public final String getCommentId() {
            return this.commentId;
        }

        /* renamed from: b, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: c, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        /* renamed from: d, reason: from getter */
        public final String getFeedOwnerUid() {
            return this.feedOwnerUid;
        }

        /* renamed from: e, reason: from getter */
        public final String getPic() {
            return this.pic;
        }

        /* renamed from: f, reason: from getter */
        public final String getReplyId() {
            return this.replyId;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getIsFeedDeleted() {
            return this.isFeedDeleted;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((((((((((this.feedId.hashCode() * 31) + this.feedSource) * 31) + this.content.hashCode()) * 31) + this.pic.hashCode()) * 31) + this.comment.hashCode()) * 31) + this.commentId.hashCode()) * 31) + this.feedOwnerUid.hashCode()) * 31) + this.replyId.hashCode()) * 31;
            boolean z16 = this.isFeedDeleted;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        public String toString() {
            return "MsgInfo(feedId=" + this.feedId + ", feedSource=" + this.feedSource + ", content=" + this.content + ", pic=" + this.pic + ", comment=" + this.comment + ", commentId=" + this.commentId + ", feedOwnerUid=" + this.feedOwnerUid + ", replyId=" + this.replyId + ", isFeedDeleted=" + this.isFeedDeleted + ")";
        }

        public MsgInfo(String feedId, int i3, String content, String pic, String comment, String commentId, String feedOwnerUid, String replyId, boolean z16) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(pic, "pic");
            Intrinsics.checkNotNullParameter(comment, "comment");
            Intrinsics.checkNotNullParameter(commentId, "commentId");
            Intrinsics.checkNotNullParameter(feedOwnerUid, "feedOwnerUid");
            Intrinsics.checkNotNullParameter(replyId, "replyId");
            this.feedId = feedId;
            this.feedSource = i3;
            this.content = content;
            this.pic = pic;
            this.comment = comment;
            this.commentId = commentId;
            this.feedOwnerUid = feedOwnerUid;
            this.replyId = replyId;
            this.isFeedDeleted = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MsgInfo)) {
                return false;
            }
            MsgInfo msgInfo = (MsgInfo) other;
            return Intrinsics.areEqual(this.feedId, msgInfo.feedId) && this.feedSource == msgInfo.feedSource && Intrinsics.areEqual(this.content, msgInfo.content) && Intrinsics.areEqual(this.pic, msgInfo.pic) && Intrinsics.areEqual(this.comment, msgInfo.comment) && Intrinsics.areEqual(this.commentId, msgInfo.commentId) && Intrinsics.areEqual(this.feedOwnerUid, msgInfo.feedOwnerUid) && Intrinsics.areEqual(this.replyId, msgInfo.replyId) && this.isFeedDeleted == msgInfo.isFeedDeleted;
        }

        public /* synthetic */ MsgInfo(String str, int i3, String str2, String str3, String str4, String str5, String str6, String str7, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? "" : str3, (i16 & 16) != 0 ? "" : str4, (i16 & 32) != 0 ? "" : str5, (i16 & 64) != 0 ? "" : str6, (i16 & 128) == 0 ? str7 : "", (i16 & 256) == 0 ? z16 : false);
        }
    }

    public QQStrangerLiteActionModel() {
        this(null, false, null, 0L, null, null, null, null, 0, 0L, 0, null, false, false, null, 32767, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getCanChat() {
        return this.canChat;
    }

    /* renamed from: c, reason: from getter */
    public final int getEmojiId() {
        return this.emojiId;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getHasRead() {
        return this.hasRead;
    }

    /* renamed from: e, reason: from getter */
    public final InteractiveOption getInteractiveOption() {
        return this.interactiveOption;
    }

    /* renamed from: f, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    /* renamed from: g, reason: from getter */
    public final MsgInfo getMsgInfo() {
        return this.msgInfo;
    }

    /* renamed from: h, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.msgId.hashCode() * 31;
        boolean z16 = this.hasRead;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int hashCode2 = (((((((((((((((((((((hashCode + i3) * 31) + this.userId.hashCode()) * 31) + com.tencent.mobileqq.matchfriend.aio.foreground.g.a(this.peerTinyId)) * 31) + this.avatar.hashCode()) * 31) + this.nick.hashCode()) * 31) + this.summary.hashCode()) * 31) + this.time.hashCode()) * 31) + this.emojiId) * 31) + com.tencent.mobileqq.matchfriend.aio.foreground.g.a(this.feedId)) * 31) + this.sceneId) * 31) + this.msgInfo.hashCode()) * 31;
        boolean z17 = this.canChat;
        int i16 = z17;
        if (z17 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        boolean z18 = this.isCommentDeleted;
        return ((i17 + (z18 ? 1 : z18 ? 1 : 0)) * 31) + this.interactiveOption.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final long getPeerTinyId() {
        return this.peerTinyId;
    }

    /* renamed from: j, reason: from getter */
    public final int getSceneId() {
        return this.sceneId;
    }

    /* renamed from: k, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* renamed from: l, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    /* renamed from: m, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getIsCommentDeleted() {
        return this.isCommentDeleted;
    }

    public final void o(boolean z16) {
        this.hasRead = z16;
    }

    public QQStrangerLiteActionModel(String msgId, boolean z16, String userId, long j3, String avatar, String nick, String summary, String time, int i3, long j16, int i16, MsgInfo msgInfo, boolean z17, boolean z18, InteractiveOption interactiveOption) {
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(summary, "summary");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        Intrinsics.checkNotNullParameter(interactiveOption, "interactiveOption");
        this.msgId = msgId;
        this.hasRead = z16;
        this.userId = userId;
        this.peerTinyId = j3;
        this.avatar = avatar;
        this.nick = nick;
        this.summary = summary;
        this.time = time;
        this.emojiId = i3;
        this.feedId = j16;
        this.sceneId = i16;
        this.msgInfo = msgInfo;
        this.canChat = z17;
        this.isCommentDeleted = z18;
        this.interactiveOption = interactiveOption;
    }

    public String toString() {
        return "QQStrangerLiteActionModel(msgId=" + this.msgId + ", hasRead=" + this.hasRead + ", userId=" + this.userId + ", peerTinyId=" + this.peerTinyId + ", avatar=" + this.avatar + ", nick=" + this.nick + ", summary=" + this.summary + ", time=" + this.time + ", emojiId=" + this.emojiId + ", feedId=" + this.feedId + ", sceneId=" + this.sceneId + ", msgInfo=" + this.msgInfo + ", canChat=" + this.canChat + ", isCommentDeleted=" + this.isCommentDeleted + ", interactiveOption=" + this.interactiveOption + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQStrangerLiteActionModel)) {
            return false;
        }
        QQStrangerLiteActionModel qQStrangerLiteActionModel = (QQStrangerLiteActionModel) other;
        return Intrinsics.areEqual(this.msgId, qQStrangerLiteActionModel.msgId) && this.hasRead == qQStrangerLiteActionModel.hasRead && Intrinsics.areEqual(this.userId, qQStrangerLiteActionModel.userId) && this.peerTinyId == qQStrangerLiteActionModel.peerTinyId && Intrinsics.areEqual(this.avatar, qQStrangerLiteActionModel.avatar) && Intrinsics.areEqual(this.nick, qQStrangerLiteActionModel.nick) && Intrinsics.areEqual(this.summary, qQStrangerLiteActionModel.summary) && Intrinsics.areEqual(this.time, qQStrangerLiteActionModel.time) && this.emojiId == qQStrangerLiteActionModel.emojiId && this.feedId == qQStrangerLiteActionModel.feedId && this.sceneId == qQStrangerLiteActionModel.sceneId && Intrinsics.areEqual(this.msgInfo, qQStrangerLiteActionModel.msgInfo) && this.canChat == qQStrangerLiteActionModel.canChat && this.isCommentDeleted == qQStrangerLiteActionModel.isCommentDeleted && Intrinsics.areEqual(this.interactiveOption, qQStrangerLiteActionModel.interactiveOption);
    }

    public /* synthetic */ QQStrangerLiteActionModel(String str, boolean z16, String str2, long j3, String str3, String str4, String str5, String str6, int i3, long j16, int i16, MsgInfo msgInfo, boolean z17, boolean z18, InteractiveOption interactiveOption, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? true : z16, (i17 & 4) != 0 ? "" : str2, (i17 & 8) != 0 ? 0L : j3, (i17 & 16) != 0 ? "" : str3, (i17 & 32) != 0 ? "" : str4, (i17 & 64) != 0 ? "" : str5, (i17 & 128) == 0 ? str6 : "", (i17 & 256) != 0 ? 0 : i3, (i17 & 512) == 0 ? j16 : 0L, (i17 & 1024) != 0 ? 0 : i16, (i17 & 2048) != 0 ? new MsgInfo(null, 0, null, null, null, null, null, null, false, 511, null) : msgInfo, (i17 & 4096) != 0 ? false : z17, (i17 & 8192) != 0 ? false : z18, (i17 & 16384) != 0 ? new InteractiveOption(false, null, 0, 7, null) : interactiveOption);
    }
}
