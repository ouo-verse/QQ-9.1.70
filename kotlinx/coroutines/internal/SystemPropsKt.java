package kotlinx.coroutines.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt", "kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt"}, k = 4, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class SystemPropsKt {
    public static final int getAVAILABLE_PROCESSORS() {
        return SystemPropsKt__SystemPropsKt.getAVAILABLE_PROCESSORS();
    }

    public static final int systemProp(@NotNull String str, int i3, int i16, int i17) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(str, i3, i16, i17);
    }

    public static final long systemProp(@NotNull String str, long j3, long j16, long j17) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(str, j3, j16, j17);
    }

    @Nullable
    public static final String systemProp(@NotNull String str) {
        return SystemPropsKt__SystemPropsKt.systemProp(str);
    }

    public static final boolean systemProp(@NotNull String str, boolean z16) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(str, z16);
    }
}
