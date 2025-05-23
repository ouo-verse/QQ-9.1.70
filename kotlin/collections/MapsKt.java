package kotlin.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"kotlin/collections/MapsKt__MapWithDefaultKt", "kotlin/collections/MapsKt__MapsJVMKt", "kotlin/collections/MapsKt__MapsKt", "kotlin/collections/MapsKt___MapsJvmKt", "kotlin/collections/MapsKt___MapsKt"}, k = 4, mv = {1, 7, 1}, xi = 49)
/* loaded from: classes28.dex */
public final class MapsKt extends MapsKt___MapsKt {
    MapsKt() {
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static /* bridge */ /* synthetic */ Map build(@NotNull Map map) {
        return MapsKt__MapsJVMKt.build(map);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static /* bridge */ /* synthetic */ Map createMapBuilder() {
        return MapsKt__MapsJVMKt.createMapBuilder();
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Map emptyMap() {
        return MapsKt__MapsKt.emptyMap();
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Map toMap(@NotNull Iterable iterable) {
        return MapsKt__MapsKt.toMap(iterable);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static /* bridge */ /* synthetic */ Map toMutableMap(@NotNull Map map) {
        return MapsKt__MapsKt.toMutableMap(map);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Map mapOf(@NotNull Pair... pairArr) {
        return MapsKt__MapsKt.mapOf(pairArr);
    }
}
