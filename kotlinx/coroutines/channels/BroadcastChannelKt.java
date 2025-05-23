package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"BroadcastChannel", "Lkotlinx/coroutines/channels/BroadcastChannel;", "E", "capacity", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class BroadcastChannelKt {
    @ObsoleteCoroutinesApi
    @NotNull
    public static final <E> BroadcastChannel<E> BroadcastChannel(int i3) {
        if (i3 != -2) {
            if (i3 != -1) {
                if (i3 != 0) {
                    if (i3 != Integer.MAX_VALUE) {
                        return new ArrayBroadcastChannel(i3);
                    }
                    throw new IllegalArgumentException("Unsupported UNLIMITED capacity for BroadcastChannel");
                }
                throw new IllegalArgumentException("Unsupported 0 capacity for BroadcastChannel");
            }
            return new ConflatedBroadcastChannel();
        }
        return new ArrayBroadcastChannel(Channel.INSTANCE.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core());
    }
}
