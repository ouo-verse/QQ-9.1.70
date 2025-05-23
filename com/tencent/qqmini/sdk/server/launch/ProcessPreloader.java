package com.tencent.qqmini.sdk.server.launch;

import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqmini/sdk/server/launch/ProcessPreloader;", "", "performPreloadProcess", "", "process", "Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;", "lib_miniserver_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public interface ProcessPreloader {
    void performPreloadProcess(@NotNull MiniProcessorConfig process);
}
