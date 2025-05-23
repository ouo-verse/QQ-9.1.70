package kotlin.random;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\t\u0010\u0000\u001a\u00020\u0001H\u0081\b\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0007\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0007\u00a8\u0006\n"}, d2 = {"defaultPlatformRandom", "Lkotlin/random/Random;", "doubleFromParts", "", "hi26", "", "low27", "asJavaRandom", "Ljava/util/Random;", "asKotlinRandom", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class PlatformRandomKt {
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final java.util.Random asJavaRandom(@NotNull Random random) {
        AbstractPlatformRandom abstractPlatformRandom;
        java.util.Random impl;
        Intrinsics.checkNotNullParameter(random, "<this>");
        if (random instanceof AbstractPlatformRandom) {
            abstractPlatformRandom = (AbstractPlatformRandom) random;
        } else {
            abstractPlatformRandom = null;
        }
        if (abstractPlatformRandom == null || (impl = abstractPlatformRandom.getImpl()) == null) {
            return new KotlinRandom(random);
        }
        return impl;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final Random asKotlinRandom(@NotNull java.util.Random random) {
        KotlinRandom kotlinRandom;
        Random impl;
        Intrinsics.checkNotNullParameter(random, "<this>");
        if (random instanceof KotlinRandom) {
            kotlinRandom = (KotlinRandom) random;
        } else {
            kotlinRandom = null;
        }
        if (kotlinRandom == null || (impl = kotlinRandom.getImpl()) == null) {
            return new PlatformRandom(random);
        }
        return impl;
    }

    @InlineOnly
    private static final Random defaultPlatformRandom() {
        return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }

    public static final double doubleFromParts(int i3, int i16) {
        return ((i3 << 27) + i16) / 9.007199254740992E15d;
    }
}
