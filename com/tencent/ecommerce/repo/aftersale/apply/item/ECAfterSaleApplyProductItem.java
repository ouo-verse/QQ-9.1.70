package com.tencent.ecommerce.repo.aftersale.apply.item;

import com.tencent.ecommerce.repo.aftersale.common.ECAfterSaleProductCard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/item/f;", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "b", "Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "orderCard", "<init>", "(Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.aftersale.apply.item.f, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECAfterSaleApplyProductItem extends d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECAfterSaleProductCard orderCard;

    public ECAfterSaleApplyProductItem(ECAfterSaleProductCard eCAfterSaleProductCard) {
        super(ItemType.TYPE_PRODUCT_ORDER);
        this.orderCard = eCAfterSaleProductCard;
    }

    public int hashCode() {
        ECAfterSaleProductCard eCAfterSaleProductCard = this.orderCard;
        if (eCAfterSaleProductCard != null) {
            return eCAfterSaleProductCard.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ECAfterSaleApplyProductItem(orderCard=" + this.orderCard + ")";
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ECAfterSaleApplyProductItem) && Intrinsics.areEqual(this.orderCard, ((ECAfterSaleApplyProductItem) other).orderCard);
        }
        return true;
    }
}
