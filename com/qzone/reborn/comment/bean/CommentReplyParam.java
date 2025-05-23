package com.qzone.reborn.comment.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/comment/bean/CommentReplyParam;", "Ljava/io/Serializable;", "commentID", "", "commentUin", "replyID", "replyUin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCommentID", "()Ljava/lang/String;", "setCommentID", "(Ljava/lang/String;)V", "getCommentUin", "setCommentUin", "getReplyID", "setReplyID", "getReplyUin", "setReplyUin", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommentReplyParam implements Serializable {
    private String commentID;
    private String commentUin;
    private String replyID;
    private String replyUin;

    public CommentReplyParam() {
        this(null, null, null, null, 15, null);
    }

    public final String getCommentID() {
        return this.commentID;
    }

    public final String getCommentUin() {
        return this.commentUin;
    }

    public final String getReplyID() {
        return this.replyID;
    }

    public final String getReplyUin() {
        return this.replyUin;
    }

    public final void setCommentID(String str) {
        this.commentID = str;
    }

    public final void setCommentUin(String str) {
        this.commentUin = str;
    }

    public final void setReplyID(String str) {
        this.replyID = str;
    }

    public final void setReplyUin(String str) {
        this.replyUin = str;
    }

    public CommentReplyParam(String str, String str2, String str3, String str4) {
        this.commentID = str;
        this.commentUin = str2;
        this.replyID = str3;
        this.replyUin = str4;
    }

    public /* synthetic */ CommentReplyParam(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4);
    }
}
