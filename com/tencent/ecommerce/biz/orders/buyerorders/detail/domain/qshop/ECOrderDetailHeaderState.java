package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/f;", "", "", "stateTitleStr", "stateDescStr", "a", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "b", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.f, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECOrderDetailHeaderState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String stateTitleStr;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String stateDescStr;

    public ECOrderDetailHeaderState() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final ECOrderDetailHeaderState a(String stateTitleStr, String stateDescStr) {
        return new ECOrderDetailHeaderState(stateTitleStr, stateDescStr);
    }

    public int hashCode() {
        String str = this.stateTitleStr;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.stateDescStr;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ECOrderDetailHeaderState(stateTitleStr=" + this.stateTitleStr + ", stateDescStr=" + this.stateDescStr + ")";
    }

    public ECOrderDetailHeaderState(String str, String str2) {
        this.stateTitleStr = str;
        this.stateDescStr = str2;
    }

    public /* synthetic */ ECOrderDetailHeaderState(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECOrderDetailHeaderState)) {
            return false;
        }
        ECOrderDetailHeaderState eCOrderDetailHeaderState = (ECOrderDetailHeaderState) other;
        return Intrinsics.areEqual(this.stateTitleStr, eCOrderDetailHeaderState.stateTitleStr) && Intrinsics.areEqual(this.stateDescStr, eCOrderDetailHeaderState.stateDescStr);
    }

    public static /* synthetic */ ECOrderDetailHeaderState b(ECOrderDetailHeaderState eCOrderDetailHeaderState, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = eCOrderDetailHeaderState.stateTitleStr;
        }
        if ((i3 & 2) != 0) {
            str2 = eCOrderDetailHeaderState.stateDescStr;
        }
        return eCOrderDetailHeaderState.a(str, str2);
    }
}
