package com.tencent.aio.base.mvvm.recycler;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000\u00a8\u0006\u0003"}, d2 = {"Ljava/lang/Class;", "", "a", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class d {
    public static final int a(@NotNull Class<?> level) {
        Intrinsics.checkNotNullParameter(level, "$this$level");
        AIOCacheMarket aIOCacheMarket = (AIOCacheMarket) level.getAnnotation(AIOCacheMarket.class);
        if (aIOCacheMarket != null) {
            return aIOCacheMarket.level();
        }
        return 4;
    }
}
