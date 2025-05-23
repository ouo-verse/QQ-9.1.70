package com.tencent.richframework.preload.activity;

import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/richframework/preload/activity/ActivityPreloadConfig;", "", "()V", "resetBaseContextBeforeAttachBaseEnabled", "", "getResetBaseContextBeforeAttachBaseEnabled", "()Z", "resetBaseResourceEnabled", "getResetBaseResourceEnabled", "preload-activity_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ActivityPreloadConfig {

    @NotNull
    public static final ActivityPreloadConfig INSTANCE = new ActivityPreloadConfig();
    private static final boolean resetBaseResourceEnabled = RFWConfig.getConfigValue("ARGUS_RESET_BASE_RESOURCE", false);
    private static final boolean resetBaseContextBeforeAttachBaseEnabled = RFWConfig.getConfigValue("ARGUS_RESET_BASE_CONTEXT", true);

    ActivityPreloadConfig() {
    }

    public final boolean getResetBaseContextBeforeAttachBaseEnabled() {
        return resetBaseContextBeforeAttachBaseEnabled;
    }

    public final boolean getResetBaseResourceEnabled() {
        return resetBaseResourceEnabled;
    }
}
