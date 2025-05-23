package com.tencent.ecommerce.repo.comment;

import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/repo/comment/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpan$a;", "a", "Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpan$a;", "requestInfo", "Lcom/tencent/ecommerce/repo/comment/d;", "b", "Lcom/tencent/ecommerce/repo/comment/d;", "data", "<init>", "(Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpan$a;Lcom/tencent/ecommerce/repo/comment/d;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.comment.e, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECQShopPublishCommentResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECOrderSpan.OrderRequestInfo requestInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECQShopPublishCommentResponse data;

    public ECQShopPublishCommentResult(ECOrderSpan.OrderRequestInfo orderRequestInfo, ECQShopPublishCommentResponse eCQShopPublishCommentResponse) {
        this.requestInfo = orderRequestInfo;
        this.data = eCQShopPublishCommentResponse;
    }

    public int hashCode() {
        ECOrderSpan.OrderRequestInfo orderRequestInfo = this.requestInfo;
        int hashCode = (orderRequestInfo != null ? orderRequestInfo.hashCode() : 0) * 31;
        ECQShopPublishCommentResponse eCQShopPublishCommentResponse = this.data;
        return hashCode + (eCQShopPublishCommentResponse != null ? eCQShopPublishCommentResponse.hashCode() : 0);
    }

    public String toString() {
        return "ECQShopPublishCommentResult(requestInfo=" + this.requestInfo + ", data=" + this.data + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECQShopPublishCommentResult)) {
            return false;
        }
        ECQShopPublishCommentResult eCQShopPublishCommentResult = (ECQShopPublishCommentResult) other;
        return Intrinsics.areEqual(this.requestInfo, eCQShopPublishCommentResult.requestInfo) && Intrinsics.areEqual(this.data, eCQShopPublishCommentResult.data);
    }
}
