package com.tencent.zplan.world;

import com.epicgames.ue4.UE4;
import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes27.dex */
final class OffscreenWorldRender$surfaceDestroyed$1 implements Runnable {
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public final void run() {
        UE4.ParallelWorld.onSurfaceDestroyed(a.a(null));
    }
}
