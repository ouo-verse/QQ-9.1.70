package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface CacheWithNotNullValues<K, V> {
    @NotNull
    V computeIfAbsent(K k3, @NotNull Function0<? extends V> function0);
}
