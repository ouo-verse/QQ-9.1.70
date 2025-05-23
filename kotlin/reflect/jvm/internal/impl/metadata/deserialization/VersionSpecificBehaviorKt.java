package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class VersionSpecificBehaviorKt {
    public static final boolean isKotlin1Dot4OrLater(@NotNull BinaryVersion version) {
        Intrinsics.checkNotNullParameter(version, "version");
        if (version.getMajor() == 1 && version.getMinor() >= 4) {
            return true;
        }
        return false;
    }

    public static final boolean isVersionRequirementTableWrittenCorrectly(@NotNull BinaryVersion version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return isKotlin1Dot4OrLater(version);
    }
}
