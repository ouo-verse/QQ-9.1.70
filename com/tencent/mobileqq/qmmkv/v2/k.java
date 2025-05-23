package com.tencent.mobileqq.qmmkv.v2;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/v2/k;", "Lcom/tencent/mobileqq/qmmkv/v2/j;", "", "mmapId", "", "withAccount", "d", "mmapKey", "", "mode", "Lcom/tencent/mobileqq/qmmkv/v2/e;", "b", "a", "library_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public interface k extends j {
    boolean a(@NotNull String mmapId, @NotNull String mmapKey);

    @NotNull
    e b(@NotNull String mmapId, @NotNull String mmapKey, int mode);

    @NotNull
    String d(@NotNull String mmapId, boolean withAccount);
}
