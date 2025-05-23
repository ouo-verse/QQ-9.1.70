package com.tencent.ecommerce.repo.aftersale.apply.item;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0011\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/item/c;", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Z", "d", "()Z", "setRequired", "(Z)V", "isRequired", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "extraText", "", "Ljava/util/List;", "()Ljava/util/List;", "f", "(Ljava/util/List;)V", "imgPathList", "<init>", "(ZLjava/lang/String;Ljava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.aftersale.apply.item.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECAfterSaleApplyExtraItem extends d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isRequired;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String extraText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private List<String> imgPathList;

    public ECAfterSaleApplyExtraItem() {
        this(false, null, null, 7, null);
    }

    /* renamed from: b, reason: from getter */
    public final String getExtraText() {
        return this.extraText;
    }

    public final List<String> c() {
        return this.imgPathList;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsRequired() {
        return this.isRequired;
    }

    public final void e(String str) {
        this.extraText = str;
    }

    public final void f(List<String> list) {
        this.imgPathList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isRequired;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        String str = this.extraText;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        List<String> list = this.imgPathList;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ECAfterSaleApplyExtraItem(isRequired=" + this.isRequired + ", extraText=" + this.extraText + ", imgPathList=" + this.imgPathList + ")";
    }

    public /* synthetic */ ECAfterSaleApplyExtraItem(boolean z16, String str, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    public ECAfterSaleApplyExtraItem(boolean z16, String str, List<String> list) {
        super(ItemType.TYPE_EXTRA_SUPPLEMENT);
        this.isRequired = z16;
        this.extraText = str;
        this.imgPathList = list;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECAfterSaleApplyExtraItem)) {
            return false;
        }
        ECAfterSaleApplyExtraItem eCAfterSaleApplyExtraItem = (ECAfterSaleApplyExtraItem) other;
        return this.isRequired == eCAfterSaleApplyExtraItem.isRequired && Intrinsics.areEqual(this.extraText, eCAfterSaleApplyExtraItem.extraText) && Intrinsics.areEqual(this.imgPathList, eCAfterSaleApplyExtraItem.imgPathList);
    }
}
