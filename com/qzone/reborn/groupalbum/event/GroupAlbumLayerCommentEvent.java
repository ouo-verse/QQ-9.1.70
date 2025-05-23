package com.qzone.reborn.groupalbum.event;

import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 %2\u00020\u0001:\u0001&B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/groupalbum/event/GroupAlbumLayerCommentEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "action", "I", "getAction", "()I", "", "feedId", "Ljava/lang/String;", "getFeedId", "()Ljava/lang/String;", "lloc", "getLloc", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "comment", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "getComment", "()Lcom/qzone/proxy/feedcomponent/model/Comment;", "setComment", "(Lcom/qzone/proxy/feedcomponent/model/Comment;)V", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "reply", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "getReply", "()Lcom/qzone/proxy/feedcomponent/model/Reply;", "setReply", "(Lcom/qzone/proxy/feedcomponent/model/Reply;)V", "", "fromFeedDetail", "Z", "getFromFeedDetail", "()Z", "setFromFeedDetail", "(Z)V", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/qzone/proxy/feedcomponent/model/Comment;Lcom/qzone/proxy/feedcomponent/model/Reply;Z)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumLayerCommentEvent extends SimpleBaseEvent {
    public static final int ADD_COMMENT = 1;
    public static final int ADD_REPLY = 3;
    public static final int REMOVE_COMMENT = 2;
    public static final int REMOVE_REPLY = 4;
    private final int action;
    private Comment comment;
    private final String feedId;
    private boolean fromFeedDetail;
    private final String lloc;
    private Reply reply;

    public /* synthetic */ GroupAlbumLayerCommentEvent(int i3, String str, String str2, Comment comment, Reply reply, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, comment, reply, (i16 & 32) != 0 ? false : z16);
    }

    public final int getAction() {
        return this.action;
    }

    public final Comment getComment() {
        return this.comment;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final boolean getFromFeedDetail() {
        return this.fromFeedDetail;
    }

    public final String getLloc() {
        return this.lloc;
    }

    public final Reply getReply() {
        return this.reply;
    }

    public final void setComment(Comment comment) {
        this.comment = comment;
    }

    public final void setFromFeedDetail(boolean z16) {
        this.fromFeedDetail = z16;
    }

    public final void setReply(Reply reply) {
        this.reply = reply;
    }

    public GroupAlbumLayerCommentEvent(int i3, String feedId, String lloc, Comment comment, Reply reply, boolean z16) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(lloc, "lloc");
        this.action = i3;
        this.feedId = feedId;
        this.lloc = lloc;
        this.comment = comment;
        this.reply = reply;
        this.fromFeedDetail = z16;
    }
}
