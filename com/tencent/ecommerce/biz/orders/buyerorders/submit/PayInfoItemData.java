package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\r\u001a\u00020\n\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/r;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/p;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "b", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "selectedPayType", "", "c", "Ljava/util/List;", "a", "()Ljava/util/List;", "supportedPayType", "<init>", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;Ljava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.r, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class PayInfoItemData extends p {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final PayType selectedPayType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<PayType> supportedPayType;

    public final List<PayType> a() {
        return this.supportedPayType;
    }

    public int hashCode() {
        PayType payType = this.selectedPayType;
        int hashCode = (payType != null ? payType.hashCode() : 0) * 31;
        List<PayType> list = this.supportedPayType;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "PayInfoItemData(selectedPayType=" + this.selectedPayType + ", supportedPayType=" + this.supportedPayType + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PayInfoItemData(PayType payType, List<? extends PayType> list) {
        super(4, null);
        this.selectedPayType = payType;
        this.supportedPayType = list;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayInfoItemData)) {
            return false;
        }
        PayInfoItemData payInfoItemData = (PayInfoItemData) other;
        return Intrinsics.areEqual(this.selectedPayType, payInfoItemData.selectedPayType) && Intrinsics.areEqual(this.supportedPayType, payInfoItemData.supportedPayType);
    }
}
