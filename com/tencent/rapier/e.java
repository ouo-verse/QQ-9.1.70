package com.tencent.rapier;

import java.lang.reflect.Type;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/rapier/e;", "T", "", "Lcom/tencent/rapier/k;", "rapier", "Ljava/lang/reflect/Type;", "type", "Lcom/tencent/rapier/d;", "", "a", "b", "rapier_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public interface e<T> {
    @NotNull
    d<T, byte[]> a(@NotNull k rapier, @NotNull Type type);

    @NotNull
    d<byte[], T> b(@NotNull k rapier, @NotNull Type type);
}
