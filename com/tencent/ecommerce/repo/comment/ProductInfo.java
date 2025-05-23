package com.tencent.ecommerce.repo.comment;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\n\u001a\u0004\b\t\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/repo/comment/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "spuId", "b", "()Ljava/lang/String;", "skuId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.comment.g, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ProductInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String spuId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String skuId;

    public ProductInfo(String str, String str2) {
        this.spuId = str;
        this.skuId = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getSkuId() {
        return this.skuId;
    }

    public int hashCode() {
        String str = this.spuId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.skuId;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ProductInfo(spuId=" + this.spuId + ", skuId=" + this.skuId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProductInfo)) {
            return false;
        }
        ProductInfo productInfo = (ProductInfo) other;
        return Intrinsics.areEqual(this.spuId, productInfo.spuId) && Intrinsics.areEqual(this.skuId, productInfo.skuId);
    }
}
