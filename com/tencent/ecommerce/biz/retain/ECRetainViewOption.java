package com.tencent.ecommerce.biz.retain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/biz/retain/ECRetainViewOption;", "", "", "value", "I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "EXIT", "RETAIN", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum ECRetainViewOption {
    EXIT(0),
    RETAIN(1);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/retain/ECRetainViewOption$a;", "", "", "value", "Lcom/tencent/ecommerce/biz/retain/ECRetainViewOption;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.retain.ECRetainViewOption$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECRetainViewOption a(int value) {
            ECRetainViewOption eCRetainViewOption;
            ECRetainViewOption[] values = ECRetainViewOption.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    eCRetainViewOption = null;
                    break;
                }
                eCRetainViewOption = values[i3];
                if (eCRetainViewOption.value == value) {
                    break;
                }
                i3++;
            }
            return eCRetainViewOption != null ? eCRetainViewOption : ECRetainViewOption.EXIT;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    ECRetainViewOption(int i3) {
        this.value = i3;
    }
}
