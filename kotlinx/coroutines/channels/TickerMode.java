package kotlinx.coroutines.channels;

import java.util.Arrays;
import kotlin.Metadata;
import kotlinx.coroutines.ObsoleteCoroutinesApi;

/* compiled from: P */
@ObsoleteCoroutinesApi
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/channels/TickerMode;", "", "(Ljava/lang/String;I)V", "FIXED_PERIOD", "FIXED_DELAY", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public enum TickerMode {
    FIXED_PERIOD,
    FIXED_DELAY;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static TickerMode[] valuesCustom() {
        TickerMode[] valuesCustom = values();
        return (TickerMode[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
