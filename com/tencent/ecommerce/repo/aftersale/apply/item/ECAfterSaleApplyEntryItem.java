package com.tencent.ecommerce.repo.aftersale.apply.item;

import com.tencent.ecommerce.repo.aftersale.apply.ApplyType;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/item/b;", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "mainTitle", "c", QQWinkConstants.TAB_SUBTITLE, "Lcom/tencent/ecommerce/repo/aftersale/apply/ApplyType;", "d", "Lcom/tencent/ecommerce/repo/aftersale/apply/ApplyType;", "()Lcom/tencent/ecommerce/repo/aftersale/apply/ApplyType;", "applyType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/repo/aftersale/apply/ApplyType;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.aftersale.apply.item.b, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECAfterSaleApplyEntryItem extends d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String mainTitle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String subTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final ApplyType applyType;

    public ECAfterSaleApplyEntryItem(String str, String str2, ApplyType applyType) {
        super(ItemType.TYPE_ENTRY_ITEM);
        this.mainTitle = str;
        this.subTitle = str2;
        this.applyType = applyType;
    }

    /* renamed from: b, reason: from getter */
    public final ApplyType getApplyType() {
        return this.applyType;
    }

    public int hashCode() {
        String str = this.mainTitle;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subTitle;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ApplyType applyType = this.applyType;
        return hashCode2 + (applyType != null ? applyType.hashCode() : 0);
    }

    public String toString() {
        return "ECAfterSaleApplyEntryItem(mainTitle=" + this.mainTitle + ", subTitle=" + this.subTitle + ", applyType=" + this.applyType + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECAfterSaleApplyEntryItem)) {
            return false;
        }
        ECAfterSaleApplyEntryItem eCAfterSaleApplyEntryItem = (ECAfterSaleApplyEntryItem) other;
        return Intrinsics.areEqual(this.mainTitle, eCAfterSaleApplyEntryItem.mainTitle) && Intrinsics.areEqual(this.subTitle, eCAfterSaleApplyEntryItem.subTitle) && Intrinsics.areEqual(this.applyType, eCAfterSaleApplyEntryItem.applyType);
    }
}
