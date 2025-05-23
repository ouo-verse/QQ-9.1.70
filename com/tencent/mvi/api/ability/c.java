package com.tencent.mvi.api.ability;

import android.os.Bundle;
import androidx.annotation.MainThread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mvi/api/ability/c;", "", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public interface c {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes21.dex */
    public static final class a {
        @MainThread
        @Nullable
        public static Bundle a(@NotNull c cVar, @NotNull d stateCmd) {
            Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
            return null;
        }
    }

    @MainThread
    @Nullable
    Bundle generateVBState(@NotNull d stateCmd);
}
