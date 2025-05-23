package com.tencent.qqmini.sdk.server.launch;

import androidx.annotation.VisibleForTesting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqmini/sdk/server/launch/RunningApp;", "", "id", "Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;", "(Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;)V", "getId", "()Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;", "state", "Lcom/tencent/qqmini/sdk/server/launch/RunningMiniAppState;", "getState", "()Lcom/tencent/qqmini/sdk/server/launch/RunningMiniAppState;", "setState", "(Lcom/tencent/qqmini/sdk/server/launch/RunningMiniAppState;)V", "lib_miniserver_internalRelease"}, k = 1, mv = {1, 1, 16})
@VisibleForTesting
/* loaded from: classes23.dex */
public final class RunningApp {

    @NotNull
    private final AppIdentity id;

    @NotNull
    private RunningMiniAppState state;

    public RunningApp(@NotNull AppIdentity id5) {
        Intrinsics.checkParameterIsNotNull(id5, "id");
        this.id = id5;
        this.state = RunningMiniAppState.STARTING;
    }

    @NotNull
    public final AppIdentity getId() {
        return this.id;
    }

    @NotNull
    public final RunningMiniAppState getState() {
        return this.state;
    }

    public final void setState(@NotNull RunningMiniAppState runningMiniAppState) {
        Intrinsics.checkParameterIsNotNull(runningMiniAppState, "<set-?>");
        this.state = runningMiniAppState;
    }
}
