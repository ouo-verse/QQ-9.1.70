package com.tencent.biz.qqcircle.immersive.redpacket.task;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aE\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"K", "V", "", "", "resetKeys", "resetValue", "", "a", "(Ljava/util/Map;[Ljava/lang/Object;Ljava/lang/Object;)V", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d {
    public static final <K, V> void a(@NotNull Map<K, V> map, @NotNull K[] resetKeys, V v3) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(resetKeys, "resetKeys");
        map.clear();
        for (K k3 : resetKeys) {
            map.put(k3, v3);
        }
    }
}
