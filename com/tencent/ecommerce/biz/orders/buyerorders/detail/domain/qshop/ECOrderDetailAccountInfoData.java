package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "type", "b", "Ljava/lang/String;", "title", "c", "id", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.b, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECOrderDetailAccountInfoData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String id;

    public ECOrderDetailAccountInfoData() {
        this(0, null, null, 7, null);
    }

    public int hashCode() {
        int i3 = this.type * 31;
        String str = this.title;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.id;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ECOrderDetailAccountInfoData(type=" + this.type + ", title=" + this.title + ", id=" + this.id + ")";
    }

    public ECOrderDetailAccountInfoData(int i3, String str, String str2) {
        this.type = i3;
        this.title = str;
        this.id = str2;
    }

    public /* synthetic */ ECOrderDetailAccountInfoData(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECOrderDetailAccountInfoData)) {
            return false;
        }
        ECOrderDetailAccountInfoData eCOrderDetailAccountInfoData = (ECOrderDetailAccountInfoData) other;
        return this.type == eCOrderDetailAccountInfoData.type && Intrinsics.areEqual(this.title, eCOrderDetailAccountInfoData.title) && Intrinsics.areEqual(this.id, eCOrderDetailAccountInfoData.id);
    }
}
