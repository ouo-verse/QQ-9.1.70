package com.tencent.ecommerce.repo.aftersale.apply.item;

import com.tencent.ecommerce.repo.aftersale.apply.ECAfterSaleApplyOptionInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/item/g;", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/ecommerce/repo/aftersale/apply/g;", "c", "Lcom/tencent/ecommerce/repo/aftersale/apply/g;", "b", "()Lcom/tencent/ecommerce/repo/aftersale/apply/g;", "optionInfo", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/ItemType;", "d", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/ItemType;", "a", "()Lcom/tencent/ecommerce/repo/aftersale/apply/item/ItemType;", "itemType", "<init>", "(Lcom/tencent/ecommerce/repo/aftersale/apply/g;Lcom/tencent/ecommerce/repo/aftersale/apply/item/ItemType;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.aftersale.apply.item.g, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECAfterSaleApplySubOptionItem extends e {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ECAfterSaleApplyOptionInfo optionInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ItemType itemType;

    public /* synthetic */ ECAfterSaleApplySubOptionItem(ECAfterSaleApplyOptionInfo eCAfterSaleApplyOptionInfo, ItemType itemType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eCAfterSaleApplyOptionInfo, (i3 & 2) != 0 ? ItemType.TYPE_SUB_OPTION_ITEM : itemType);
    }

    @Override // com.tencent.ecommerce.repo.aftersale.apply.item.d
    /* renamed from: a, reason: from getter */
    public ItemType getItemType() {
        return this.itemType;
    }

    @Override // com.tencent.ecommerce.repo.aftersale.apply.item.e
    /* renamed from: b, reason: from getter */
    public ECAfterSaleApplyOptionInfo getOptionInfo() {
        return this.optionInfo;
    }

    public int hashCode() {
        ECAfterSaleApplyOptionInfo optionInfo = getOptionInfo();
        int hashCode = (optionInfo != null ? optionInfo.hashCode() : 0) * 31;
        ItemType itemType = getItemType();
        return hashCode + (itemType != null ? itemType.hashCode() : 0);
    }

    public String toString() {
        return "ECAfterSaleApplySubOptionItem(optionInfo=" + getOptionInfo() + ", itemType=" + getItemType() + ")";
    }

    public ECAfterSaleApplySubOptionItem(ECAfterSaleApplyOptionInfo eCAfterSaleApplyOptionInfo, ItemType itemType) {
        super(eCAfterSaleApplyOptionInfo);
        this.optionInfo = eCAfterSaleApplyOptionInfo;
        this.itemType = itemType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECAfterSaleApplySubOptionItem)) {
            return false;
        }
        ECAfterSaleApplySubOptionItem eCAfterSaleApplySubOptionItem = (ECAfterSaleApplySubOptionItem) other;
        return Intrinsics.areEqual(getOptionInfo(), eCAfterSaleApplySubOptionItem.getOptionInfo()) && Intrinsics.areEqual(getItemType(), eCAfterSaleApplySubOptionItem.getItemType());
    }
}
