package com.tencent.zplan.world.render.offscreen;

import com.epicgames.ue4.UE4;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 2})
/* loaded from: classes27.dex */
final class ZPlanWorldOffscreenRender$surfaceDestroyed$1 implements Runnable {
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public final void run() {
        if (a.b(null)) {
            UE4.ParallelWorld.onSurfaceDestroyed(a.a(null));
        } else {
            ZPlanServiceHelper.I.v0(a.a(null));
        }
    }
}
