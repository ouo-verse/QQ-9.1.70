package com.tencent.ecommerce.repo.comment;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\n\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/repo/comment/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/repo/comment/ECQShopPublishCommentState;", "a", "Lcom/tencent/ecommerce/repo/comment/ECQShopPublishCommentState;", "publishState", "b", "Ljava/lang/String;", "()Ljava/lang/String;", WSAutoShowCommentParams.KEY_COMMENT_ID, "<init>", "(Lcom/tencent/ecommerce/repo/comment/ECQShopPublishCommentState;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.comment.d, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECQShopPublishCommentResponse {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECQShopPublishCommentState publishState;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String commentId;

    public ECQShopPublishCommentResponse(ECQShopPublishCommentState eCQShopPublishCommentState, String str) {
        this.publishState = eCQShopPublishCommentState;
        this.commentId = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getCommentId() {
        return this.commentId;
    }

    public int hashCode() {
        ECQShopPublishCommentState eCQShopPublishCommentState = this.publishState;
        int hashCode = (eCQShopPublishCommentState != null ? eCQShopPublishCommentState.hashCode() : 0) * 31;
        String str = this.commentId;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ECQShopPublishCommentResponse(publishState=" + this.publishState + ", commentId=" + this.commentId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECQShopPublishCommentResponse)) {
            return false;
        }
        ECQShopPublishCommentResponse eCQShopPublishCommentResponse = (ECQShopPublishCommentResponse) other;
        return Intrinsics.areEqual(this.publishState, eCQShopPublishCommentResponse.publishState) && Intrinsics.areEqual(this.commentId, eCQShopPublishCommentResponse.commentId);
    }
}
