package com.tencent.ecommerce.repo.aftersale.apply;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/ApplyType;", "", "", "value", "I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "APPLY_TYPE_UNKNOWN", "APPLY_TYPE_REFUND_ONLY", "APPLY_TYPE_RETURN_REFUND", "APPLY_TYPE_JUDGEMENT", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum ApplyType {
    APPLY_TYPE_UNKNOWN(0),
    APPLY_TYPE_REFUND_ONLY(1),
    APPLY_TYPE_RETURN_REFUND(2),
    APPLY_TYPE_JUDGEMENT(3);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/ApplyType$a;", "", "", "value", "Lcom/tencent/ecommerce/repo/aftersale/apply/ApplyType;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.aftersale.apply.ApplyType$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ApplyType a(int value) {
            ApplyType applyType;
            ApplyType[] values = ApplyType.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    applyType = null;
                    break;
                }
                applyType = values[i3];
                if (applyType.ordinal() == value) {
                    break;
                }
                i3++;
            }
            return applyType != null ? applyType : ApplyType.APPLY_TYPE_UNKNOWN;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    ApplyType(int i3) {
        this.value = i3;
    }
}
