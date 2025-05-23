package kotlinx.coroutines.flow;

import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/flow/SharingCommand;", "", "(Ljava/lang/String;I)V", "START", "STOP", "STOP_AND_RESET_REPLAY_CACHE", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public enum SharingCommand {
    START,
    STOP,
    STOP_AND_RESET_REPLAY_CACHE;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static SharingCommand[] valuesCustom() {
        SharingCommand[] valuesCustom = values();
        return (SharingCommand[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
