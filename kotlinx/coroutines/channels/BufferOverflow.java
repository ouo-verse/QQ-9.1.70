package kotlinx.coroutines.channels;

import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/channels/BufferOverflow;", "", "(Ljava/lang/String;I)V", "SUSPEND", "DROP_OLDEST", "DROP_LATEST", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public enum BufferOverflow {
    SUSPEND,
    DROP_OLDEST,
    DROP_LATEST;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static BufferOverflow[] valuesCustom() {
        BufferOverflow[] valuesCustom = values();
        return (BufferOverflow[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
