package com.tencent.rmonitor.base.config;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/rmonitor/base/config/ConfigProxy;", "", "()V", DownloadInfo.spKey_Config, "Lcom/tencent/rmonitor/base/config/ConfigCenter;", "getConfig", "()Lcom/tencent/rmonitor/base/config/ConfigCenter;", "setConfig", "(Lcom/tencent/rmonitor/base/config/ConfigCenter;)V", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public final class ConfigProxy {
    public static final ConfigProxy INSTANCE = new ConfigProxy();

    @NotNull
    private static ConfigCenter config = new ConfigCenter();

    ConfigProxy() {
    }

    @NotNull
    public final ConfigCenter getConfig() {
        return config;
    }

    public final void setConfig(@NotNull ConfigCenter configCenter) {
        Intrinsics.checkParameterIsNotNull(configCenter, "<set-?>");
        config = configCenter;
    }
}
