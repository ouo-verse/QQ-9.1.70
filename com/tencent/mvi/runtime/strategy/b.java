package com.tencent.mvi.runtime.strategy;

import androidx.annotation.MainThread;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H'J%\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H'\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H'\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mvi/runtime/strategy/b;", "", "T", "Ljava/lang/Class;", "clazz", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "fetcher", "", "c", "b", "(Ljava/lang/Class;)Ljava/lang/Object;", "", "a", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public interface b {
    @MainThread
    <T> boolean a(@NotNull Class<T> clazz);

    @MainThread
    @Nullable
    <T> T b(@NotNull Class<T> clazz);

    @MainThread
    <T> void c(@NotNull Class<T> clazz, @NotNull IStrategyFetcher<T> fetcher);
}
