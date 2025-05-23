package com.tencent.ecommerce.repo.sampleorder;

import com.tencent.ecommerce.repo.aftersale.apply.ECAfterSaleApplyOptionInfo;
import com.tencent.ecommerce.repo.aftersale.common.ECAfterSaleProductCard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/repo/sampleorder/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "token", "Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "b", "Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "productCard", "Lcom/tencent/ecommerce/repo/aftersale/apply/g;", "c", "Lcom/tencent/ecommerce/repo/aftersale/apply/g;", "()Lcom/tencent/ecommerce/repo/aftersale/apply/g;", "optionInfo", "<init>", "(Ljava/lang/String;Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;Lcom/tencent/ecommerce/repo/aftersale/apply/g;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.sampleorder.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECAbortFulfillOption {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String token;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECAfterSaleProductCard productCard;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final ECAfterSaleApplyOptionInfo optionInfo;

    public ECAbortFulfillOption(String str, ECAfterSaleProductCard eCAfterSaleProductCard, ECAfterSaleApplyOptionInfo eCAfterSaleApplyOptionInfo) {
        this.token = str;
        this.productCard = eCAfterSaleProductCard;
        this.optionInfo = eCAfterSaleApplyOptionInfo;
    }

    /* renamed from: a, reason: from getter */
    public final ECAfterSaleApplyOptionInfo getOptionInfo() {
        return this.optionInfo;
    }

    public int hashCode() {
        String str = this.token;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ECAfterSaleProductCard eCAfterSaleProductCard = this.productCard;
        int hashCode2 = (hashCode + (eCAfterSaleProductCard != null ? eCAfterSaleProductCard.hashCode() : 0)) * 31;
        ECAfterSaleApplyOptionInfo eCAfterSaleApplyOptionInfo = this.optionInfo;
        return hashCode2 + (eCAfterSaleApplyOptionInfo != null ? eCAfterSaleApplyOptionInfo.hashCode() : 0);
    }

    public String toString() {
        return "ECAbortFulfillOption(token=" + this.token + ", productCard=" + this.productCard + ", optionInfo=" + this.optionInfo + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECAbortFulfillOption)) {
            return false;
        }
        ECAbortFulfillOption eCAbortFulfillOption = (ECAbortFulfillOption) other;
        return Intrinsics.areEqual(this.token, eCAbortFulfillOption.token) && Intrinsics.areEqual(this.productCard, eCAbortFulfillOption.productCard) && Intrinsics.areEqual(this.optionInfo, eCAbortFulfillOption.optionInfo);
    }
}
