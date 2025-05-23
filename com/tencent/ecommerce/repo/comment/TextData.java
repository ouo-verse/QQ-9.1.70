package com.tencent.ecommerce.repo.comment;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$RptData;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$TextData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/repo/comment/i;", "Lcom/tencent/ecommerce/repo/comment/h;", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_product_review_common/ECQshopProductReviewCommon$RptData;", "a", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "text", "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.comment.i, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class TextData extends h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String text;

    @Override // com.tencent.ecommerce.repo.comment.h
    public ECQshopProductReviewCommon$RptData a() {
        ECQshopProductReviewCommon$TextData eCQshopProductReviewCommon$TextData = new ECQshopProductReviewCommon$TextData();
        eCQshopProductReviewCommon$TextData.content.set(this.text);
        ECQshopProductReviewCommon$RptData eCQshopProductReviewCommon$RptData = new ECQshopProductReviewCommon$RptData();
        eCQshopProductReviewCommon$RptData.data_type.set(1);
        eCQshopProductReviewCommon$RptData.text_data.set(eCQshopProductReviewCommon$TextData);
        return eCQshopProductReviewCommon$RptData;
    }

    public int hashCode() {
        String str = this.text;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "TextData(text=" + this.text + ")";
    }

    public TextData(String str) {
        super(null);
        this.text = str;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TextData) && Intrinsics.areEqual(this.text, ((TextData) other).text);
        }
        return true;
    }
}
