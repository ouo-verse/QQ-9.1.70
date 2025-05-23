package com.tencent.sqshow.zootopia.data;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/l;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", WSAutoShowCommentParams.KEY_COMMENT_ID, "comment", "", "c", "J", "getCommentTime", "()J", "commentTime", "Lcom/tencent/sqshow/zootopia/data/z;", "d", "Lcom/tencent/sqshow/zootopia/data/z;", "()Lcom/tencent/sqshow/zootopia/data/z;", "userData", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLcom/tencent/sqshow/zootopia/data/z;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.l, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaMapComment {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String commentId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String comment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long commentTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZootopiaUserData userData;

    public ZootopiaMapComment(String commentId, String comment, long j3, ZootopiaUserData userData) {
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(userData, "userData");
        this.commentId = commentId;
        this.comment = comment;
        this.commentTime = j3;
        this.userData = userData;
    }

    /* renamed from: a, reason: from getter */
    public final String getComment() {
        return this.comment;
    }

    /* renamed from: b, reason: from getter */
    public final String getCommentId() {
        return this.commentId;
    }

    /* renamed from: c, reason: from getter */
    public final ZootopiaUserData getUserData() {
        return this.userData;
    }

    public int hashCode() {
        return (((((this.commentId.hashCode() * 31) + this.comment.hashCode()) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.commentTime)) * 31) + this.userData.hashCode();
    }

    public String toString() {
        return "ZootopiaMapComment(commentId=" + this.commentId + ", comment=" + this.comment + ", commentTime=" + this.commentTime + ", userData=" + this.userData + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaMapComment)) {
            return false;
        }
        ZootopiaMapComment zootopiaMapComment = (ZootopiaMapComment) other;
        return Intrinsics.areEqual(this.commentId, zootopiaMapComment.commentId) && Intrinsics.areEqual(this.comment, zootopiaMapComment.comment) && this.commentTime == zootopiaMapComment.commentTime && Intrinsics.areEqual(this.userData, zootopiaMapComment.userData);
    }
}
