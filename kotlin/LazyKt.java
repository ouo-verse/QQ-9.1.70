package kotlin;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"kotlin/LazyKt__LazyJVMKt", "kotlin/LazyKt__LazyKt"}, k = 4, mv = {1, 7, 1}, xi = 49)
/* loaded from: classes28.dex */
public final class LazyKt extends LazyKt__LazyKt {
    LazyKt() {
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Lazy lazy(@NotNull LazyThreadSafetyMode lazyThreadSafetyMode, @NotNull Function0 function0) {
        return LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, function0);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Lazy lazy(@NotNull Function0 function0) {
        return LazyKt__LazyJVMKt.lazy(function0);
    }
}
