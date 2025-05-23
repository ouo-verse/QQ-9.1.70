package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0015\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "showAccountInfo", "b", "showAddressInfo", "c", "showModifyAddress", "d", "showLogisticsInfo", "e", "showFreightInfo", "f", "showPayDetail", "<init>", "(ZZZZZZ)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.i, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECOrderDetailWidgetsVisibility {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean showAccountInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean showAddressInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean showModifyAddress;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean showLogisticsInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean showFreightInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean showPayDetail;

    public ECOrderDetailWidgetsVisibility() {
        this(false, false, false, false, false, false, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.showAccountInfo;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        ?? r26 = this.showAddressInfo;
        int i16 = r26;
        if (r26 != 0) {
            i16 = 1;
        }
        int i17 = (i3 + i16) * 31;
        ?? r27 = this.showModifyAddress;
        int i18 = r27;
        if (r27 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        ?? r28 = this.showLogisticsInfo;
        int i26 = r28;
        if (r28 != 0) {
            i26 = 1;
        }
        int i27 = (i19 + i26) * 31;
        ?? r29 = this.showFreightInfo;
        int i28 = r29;
        if (r29 != 0) {
            i28 = 1;
        }
        int i29 = (i27 + i28) * 31;
        boolean z17 = this.showPayDetail;
        return i29 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public String toString() {
        return "ECOrderDetailWidgetsVisibility(showAccountInfo=" + this.showAccountInfo + ", showAddressInfo=" + this.showAddressInfo + ", showModifyAddress=" + this.showModifyAddress + ", showLogisticsInfo=" + this.showLogisticsInfo + ", showFreightInfo=" + this.showFreightInfo + ", showPayDetail=" + this.showPayDetail + ")";
    }

    public ECOrderDetailWidgetsVisibility(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27) {
        this.showAccountInfo = z16;
        this.showAddressInfo = z17;
        this.showModifyAddress = z18;
        this.showLogisticsInfo = z19;
        this.showFreightInfo = z26;
        this.showPayDetail = z27;
    }

    public /* synthetic */ ECOrderDetailWidgetsVisibility(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? false : z18, (i3 & 8) != 0 ? false : z19, (i3 & 16) != 0 ? false : z26, (i3 & 32) != 0 ? false : z27);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECOrderDetailWidgetsVisibility)) {
            return false;
        }
        ECOrderDetailWidgetsVisibility eCOrderDetailWidgetsVisibility = (ECOrderDetailWidgetsVisibility) other;
        return this.showAccountInfo == eCOrderDetailWidgetsVisibility.showAccountInfo && this.showAddressInfo == eCOrderDetailWidgetsVisibility.showAddressInfo && this.showModifyAddress == eCOrderDetailWidgetsVisibility.showModifyAddress && this.showLogisticsInfo == eCOrderDetailWidgetsVisibility.showLogisticsInfo && this.showFreightInfo == eCOrderDetailWidgetsVisibility.showFreightInfo && this.showPayDetail == eCOrderDetailWidgetsVisibility.showPayDetail;
    }
}
