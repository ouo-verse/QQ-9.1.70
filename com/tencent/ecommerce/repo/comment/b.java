package com.tencent.ecommerce.repo.comment;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$RptData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_product_review_common/ECQshopProductReviewCommon$RptData;", "Lcom/tencent/ecommerce/repo/comment/h;", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b {
    public static final h a(ECQshopProductReviewCommon$RptData eCQshopProductReviewCommon$RptData) {
        if (eCQshopProductReviewCommon$RptData.data_type.get() != 1) {
            return null;
        }
        return new TextData(eCQshopProductReviewCommon$RptData.text_data.content.get());
    }
}
