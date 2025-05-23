package com.tencent.gamematrix.gmcg.base.lifecycle;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface CGLifecycle {
    void addListener(@NonNull CGLifecycleListener cGLifecycleListener);

    void removeListener(@NonNull CGLifecycleListener cGLifecycleListener);
}
