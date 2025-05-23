package com.tencent.filament.zplan.render.impl;

import com.tencent.filament.zplan.util.vsync.VSyncScheduler;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
final class FilamentNativeRender$onPause$1 implements Runnable {
    final /* synthetic */ c this$0;

    @Override // java.lang.Runnable
    public final void run() {
        FLog.INSTANCE.i("FilamentNativeRender_LifeCycle", "onPause stopScheduleVSync");
        VSyncScheduler G = c.G(null);
        if (G != null) {
            G.p();
        }
    }
}
