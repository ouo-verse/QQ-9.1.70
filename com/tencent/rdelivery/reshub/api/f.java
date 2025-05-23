package com.tencent.rdelivery.reshub.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/rdelivery/reshub/api/f;", "", "", "b", "", "resId", "a", "Ljava/lang/Runnable;", "preloadAction", "cancelAction", "", "c", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public interface f {
    boolean a(@NotNull String resId);

    boolean b();

    void c(@NotNull String resId, @NotNull Runnable preloadAction, @NotNull Runnable cancelAction);
}
