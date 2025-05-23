package com.tencent.biz.pubaccount.weishi.comment;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/comment/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "uin", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.pubaccount.weishi.comment.d, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class WSCommentFriendBaseInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String name;

    public WSCommentFriendBaseInfo(String uin, String str) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.name = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: b, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        int hashCode = this.uin.hashCode() * 31;
        String str = this.name;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "WSCommentFriendBaseInfo(uin=" + this.uin + ", name=" + this.name + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WSCommentFriendBaseInfo)) {
            return false;
        }
        WSCommentFriendBaseInfo wSCommentFriendBaseInfo = (WSCommentFriendBaseInfo) other;
        return Intrinsics.areEqual(this.uin, wSCommentFriendBaseInfo.uin) && Intrinsics.areEqual(this.name, wSCommentFriendBaseInfo.name);
    }
}
