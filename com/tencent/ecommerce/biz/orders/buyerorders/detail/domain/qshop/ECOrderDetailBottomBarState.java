package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop;

import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.BottomAreaOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\tBM\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\nR\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "showBottomBar", "b", "showMainOperateTv", "c", "I", "mainOperateTextResId", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/BottomAreaOperation;", "d", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/BottomAreaOperation;", "mainTextOperation", "e", "showSubOperateTv", "f", "subOperateTextResId", "g", "subTextOperation", "<init>", "(ZZILcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/BottomAreaOperation;ZILcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/BottomAreaOperation;)V", tl.h.F, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECOrderDetailBottomBarState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean showBottomBar;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean showMainOperateTv;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int mainOperateTextResId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final BottomAreaOperation mainTextOperation;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean showSubOperateTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final int subOperateTextResId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final BottomAreaOperation subTextOperation;

    public ECOrderDetailBottomBarState() {
        this(false, false, 0, null, false, 0, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.showBottomBar;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        ?? r26 = this.showMainOperateTv;
        int i16 = r26;
        if (r26 != 0) {
            i16 = 1;
        }
        int i17 = (((i3 + i16) * 31) + this.mainOperateTextResId) * 31;
        BottomAreaOperation bottomAreaOperation = this.mainTextOperation;
        int hashCode = (i17 + (bottomAreaOperation != null ? bottomAreaOperation.hashCode() : 0)) * 31;
        boolean z17 = this.showSubOperateTv;
        int i18 = (((hashCode + (z17 ? 1 : z17 ? 1 : 0)) * 31) + this.subOperateTextResId) * 31;
        BottomAreaOperation bottomAreaOperation2 = this.subTextOperation;
        return i18 + (bottomAreaOperation2 != null ? bottomAreaOperation2.hashCode() : 0);
    }

    public String toString() {
        return "ECOrderDetailBottomBarState(showBottomBar=" + this.showBottomBar + ", showMainOperateTv=" + this.showMainOperateTv + ", mainOperateTextResId=" + this.mainOperateTextResId + ", mainTextOperation=" + this.mainTextOperation + ", showSubOperateTv=" + this.showSubOperateTv + ", subOperateTextResId=" + this.subOperateTextResId + ", subTextOperation=" + this.subTextOperation + ")";
    }

    public ECOrderDetailBottomBarState(boolean z16, boolean z17, int i3, BottomAreaOperation bottomAreaOperation, boolean z18, int i16, BottomAreaOperation bottomAreaOperation2) {
        this.showBottomBar = z16;
        this.showMainOperateTv = z17;
        this.mainOperateTextResId = i3;
        this.mainTextOperation = bottomAreaOperation;
        this.showSubOperateTv = z18;
        this.subOperateTextResId = i16;
        this.subTextOperation = bottomAreaOperation2;
    }

    public /* synthetic */ ECOrderDetailBottomBarState(boolean z16, boolean z17, int i3, BottomAreaOperation bottomAreaOperation, boolean z18, int i16, BottomAreaOperation bottomAreaOperation2, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? false : z16, (i17 & 2) != 0 ? false : z17, (i17 & 4) != 0 ? -1 : i3, (i17 & 8) != 0 ? BottomAreaOperation.NONE : bottomAreaOperation, (i17 & 16) == 0 ? z18 : false, (i17 & 32) != 0 ? -1 : i16, (i17 & 64) != 0 ? BottomAreaOperation.NONE : bottomAreaOperation2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECOrderDetailBottomBarState)) {
            return false;
        }
        ECOrderDetailBottomBarState eCOrderDetailBottomBarState = (ECOrderDetailBottomBarState) other;
        return this.showBottomBar == eCOrderDetailBottomBarState.showBottomBar && this.showMainOperateTv == eCOrderDetailBottomBarState.showMainOperateTv && this.mainOperateTextResId == eCOrderDetailBottomBarState.mainOperateTextResId && Intrinsics.areEqual(this.mainTextOperation, eCOrderDetailBottomBarState.mainTextOperation) && this.showSubOperateTv == eCOrderDetailBottomBarState.showSubOperateTv && this.subOperateTextResId == eCOrderDetailBottomBarState.subOperateTextResId && Intrinsics.areEqual(this.subTextOperation, eCOrderDetailBottomBarState.subTextOperation);
    }
}
