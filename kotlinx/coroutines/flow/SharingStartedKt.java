package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.flow.SharingStarted;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\b"}, d2 = {"WhileSubscribed", "Lkotlinx/coroutines/flow/SharingStarted;", "Lkotlinx/coroutines/flow/SharingStarted$Companion;", "stopTimeout", "Lkotlin/time/Duration;", "replayExpiration", "WhileSubscribed-5qebJ5I", "(Lkotlinx/coroutines/flow/SharingStarted$Companion;JJ)Lkotlinx/coroutines/flow/SharingStarted;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class SharingStartedKt {
    @ExperimentalTime
    @NotNull
    /* renamed from: WhileSubscribed-5qebJ5I, reason: not valid java name */
    public static final SharingStarted m2035WhileSubscribed5qebJ5I(@NotNull SharingStarted.Companion companion, long j3, long j16) {
        return new StartedWhileSubscribed(Duration.m1873toLongMillisecondsimpl(j3), Duration.m1873toLongMillisecondsimpl(j16));
    }

    /* renamed from: WhileSubscribed-5qebJ5I$default, reason: not valid java name */
    public static /* synthetic */ SharingStarted m2036WhileSubscribed5qebJ5I$default(SharingStarted.Companion companion, long j3, long j16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = Duration.INSTANCE.m1928getZEROUwyO8pc();
        }
        if ((i3 & 2) != 0) {
            j16 = Duration.INSTANCE.m1926getINFINITEUwyO8pc();
        }
        return m2035WhileSubscribed5qebJ5I(companion, j3, j16);
    }
}
