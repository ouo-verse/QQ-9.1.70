package com.tencent.ecommerce.biz.orders.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/SampleOrderState;", "", "", "value", "I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "RESERVE", "AUDITING", "CANCELLED", "REJECTED", "SIGNING", "FULFILLING", "ABORT_AUDITING", "UNFULFILLED", "FULFILLED", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum SampleOrderState {
    RESERVE(0),
    AUDITING(1),
    CANCELLED(2),
    REJECTED(3),
    SIGNING(4),
    FULFILLING(5),
    ABORT_AUDITING(6),
    UNFULFILLED(7),
    FULFILLED(8);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/SampleOrderState$a;", "", "", "value", "Lcom/tencent/ecommerce/biz/orders/common/SampleOrderState;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.common.SampleOrderState$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final SampleOrderState a(int value) {
            SampleOrderState sampleOrderState;
            SampleOrderState[] values = SampleOrderState.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    sampleOrderState = null;
                    break;
                }
                sampleOrderState = values[i3];
                if (sampleOrderState.value == value) {
                    break;
                }
                i3++;
            }
            return sampleOrderState != null ? sampleOrderState : SampleOrderState.RESERVE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    SampleOrderState(int i3) {
        this.value = i3;
    }
}
