package com.tencent.qqmini.sdk.server.launch;

import androidx.annotation.VisibleForTesting;
import kotlin.Metadata;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0081\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqmini/sdk/server/launch/RunningProcessState;", "", "(Ljava/lang/String;I)V", "STARTING", "PRELOAD", DebugCoroutineInfoImplKt.RUNNING, "lib_miniserver_internalRelease"}, k = 1, mv = {1, 1, 16})
@VisibleForTesting
/* loaded from: classes23.dex */
public enum RunningProcessState {
    STARTING,
    PRELOAD,
    RUNNING
}
