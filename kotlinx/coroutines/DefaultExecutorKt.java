package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"DefaultDelay", "Lkotlinx/coroutines/Delay;", "getDefaultDelay", "()Lkotlinx/coroutines/Delay;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class DefaultExecutorKt {

    @NotNull
    private static final Delay DefaultDelay = DefaultExecutor.INSTANCE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f412771a = 0;

    @NotNull
    public static final Delay getDefaultDelay() {
        return DefaultDelay;
    }
}
