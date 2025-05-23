package com.tencent.guild.aio.util.ex;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0003\u00a8\u0006\u0006"}, d2 = {"K", "V", "", "Lkotlin/Pair;", "pair", "a", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class h {
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> a(@NotNull Map<K, ? extends V> map, @Nullable Pair<? extends K, ? extends V> pair) {
        Map<K, V> plus;
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (pair != null) {
            plus = MapsKt__MapsKt.plus(map, pair);
            return plus;
        }
        return map;
    }
}
