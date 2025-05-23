package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop;

import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/l;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "content", "Lcom/tencent/ecommerce/base/ui/api/ECToastIcon;", "b", "Lcom/tencent/ecommerce/base/ui/api/ECToastIcon;", "icon", "<init>", "(Ljava/lang/String;Lcom/tencent/ecommerce/base/ui/api/ECToastIcon;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.l, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class OrderDetailToastEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String content;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECToastIcon icon;

    public OrderDetailToastEvent(String str, ECToastIcon eCToastIcon) {
        this.content = str;
        this.icon = eCToastIcon;
    }

    public int hashCode() {
        String str = this.content;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ECToastIcon eCToastIcon = this.icon;
        return hashCode + (eCToastIcon != null ? eCToastIcon.hashCode() : 0);
    }

    public String toString() {
        return "OrderDetailToastEvent(content=" + this.content + ", icon=" + this.icon + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderDetailToastEvent)) {
            return false;
        }
        OrderDetailToastEvent orderDetailToastEvent = (OrderDetailToastEvent) other;
        return Intrinsics.areEqual(this.content, orderDetailToastEvent.content) && Intrinsics.areEqual(this.icon, orderDetailToastEvent.icon);
    }
}
