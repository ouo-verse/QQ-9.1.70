package com.tencent.ecommerce.biz.orders.common;

import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/QShopOrderState;", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayStatus;", "getPayStatus", "", "value", "I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "UNKNOWN", "PAYMENT_PENDING", "PAYMENT_DONE", "DELIVERY_PENDING", "DELIVERY_DONE", "REFUND", "PAYMENT_CANCELED", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum QShopOrderState {
    UNKNOWN(0),
    PAYMENT_PENDING(1),
    PAYMENT_DONE(2),
    DELIVERY_PENDING(3),
    DELIVERY_DONE(4),
    REFUND(5),
    PAYMENT_CANCELED(6);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/QShopOrderState$a;", "", "", "value", "Lcom/tencent/ecommerce/biz/orders/common/QShopOrderState;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.common.QShopOrderState$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final QShopOrderState a(int value) {
            QShopOrderState qShopOrderState;
            QShopOrderState[] values = QShopOrderState.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    qShopOrderState = null;
                    break;
                }
                qShopOrderState = values[i3];
                if (qShopOrderState.value == value) {
                    break;
                }
                i3++;
            }
            return qShopOrderState != null ? qShopOrderState : QShopOrderState.UNKNOWN;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    QShopOrderState(int i3) {
        this.value = i3;
    }

    public final PayStatus getPayStatus() {
        int i3 = k.f103715a[ordinal()];
        if (i3 == 1) {
            return PayStatus.UNKNOWN;
        }
        if (i3 != 2) {
            return PayStatus.PAID;
        }
        return PayStatus.UNPAID;
    }
}
