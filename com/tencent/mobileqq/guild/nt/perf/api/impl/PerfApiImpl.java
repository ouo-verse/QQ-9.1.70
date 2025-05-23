package com.tencent.mobileqq.guild.nt.perf.api.impl;

import com.tencent.mobileqq.guild.nt.perf.api.IPerfApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import oy3.a;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/nt/perf/api/impl/PerfApiImpl;", "Lcom/tencent/mobileqq/guild/nt/perf/api/IPerfApi;", "()V", "startMonitorDropFrame", "", "scene", "", "stopMonitorDropFrame", "qqguild-boundaries-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class PerfApiImpl implements IPerfApi {
    @Override // com.tencent.mobileqq.guild.nt.perf.api.IPerfApi
    public void startMonitorDropFrame(@NotNull String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        a.a().b(scene);
    }

    @Override // com.tencent.mobileqq.guild.nt.perf.api.IPerfApi
    public void stopMonitorDropFrame(@NotNull String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        a.a().c(scene, false);
    }
}
