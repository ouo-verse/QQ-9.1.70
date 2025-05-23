package kotlin.reflect.jvm.internal.impl.platform;

import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public final class PlatformUtilKt {
    @NotNull
    public static final String getPresentableDescription(@NotNull TargetPlatform targetPlatform) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(targetPlatform, "<this>");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(targetPlatform.getComponentPlatforms(), "/", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }
}
