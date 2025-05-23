package com.tencent.ecommerce.biz.orders.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/TrailSubStatus;", "", "", "value", "I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "NO_MSG", "ARRIVE_RECEIVE_CITY", "DELIVERING", "ARRIVE_IN_EXPRESS_BOX", "NORMAL_RECEIVED", "DELIVERY_ABNORMAL_FINALLY_RECEIVED", "SUBSTITUTE_RECEIVED", "RECEIVE_IN_EXPRESS_BOX", "WRONG_NO_SENDER_MSG", "NOT_RECEIVE_OVER_TIME", "UPDATE_TRAIL_OVER_TIME", "WRONG_USER_REJECTION", "DISPATCH_ABNORMAL", "REFUND_RECEIVED", "REFUND_NOT_RECEIVED", "NOT_RECEIVE_IN_EXPRESS_BOX", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum TrailSubStatus {
    NO_MSG(0),
    ARRIVE_RECEIVE_CITY(201),
    DELIVERING(202),
    ARRIVE_IN_EXPRESS_BOX(211),
    NORMAL_RECEIVED(301),
    DELIVERY_ABNORMAL_FINALLY_RECEIVED(302),
    SUBSTITUTE_RECEIVED(304),
    RECEIVE_IN_EXPRESS_BOX(311),
    WRONG_NO_SENDER_MSG(401),
    NOT_RECEIVE_OVER_TIME(402),
    UPDATE_TRAIL_OVER_TIME(403),
    WRONG_USER_REJECTION(404),
    DISPATCH_ABNORMAL(405),
    REFUND_RECEIVED(406),
    REFUND_NOT_RECEIVED(407),
    NOT_RECEIVE_IN_EXPRESS_BOX(412);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/TrailSubStatus$a;", "", "", "value", "Lcom/tencent/ecommerce/biz/orders/common/TrailSubStatus;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.common.TrailSubStatus$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final TrailSubStatus a(int value) {
            TrailSubStatus trailSubStatus;
            TrailSubStatus[] values = TrailSubStatus.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    trailSubStatus = null;
                    break;
                }
                trailSubStatus = values[i3];
                if (trailSubStatus.value == value) {
                    break;
                }
                i3++;
            }
            return trailSubStatus != null ? trailSubStatus : TrailSubStatus.NO_MSG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    TrailSubStatus(int i3) {
        this.value = i3;
    }
}
