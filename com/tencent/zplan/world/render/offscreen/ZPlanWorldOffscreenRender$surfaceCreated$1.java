package com.tencent.zplan.world.render.offscreen;

import android.view.Surface;
import com.epicgames.ue4.UE4;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 2})
/* loaded from: classes27.dex */
final class ZPlanWorldOffscreenRender$surfaceCreated$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Surface f386357d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f386358e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f386359f;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public final void run() {
        if (a.b(null)) {
            long a16 = a.a(null);
            Surface surface = this.f386357d;
            Intrinsics.checkNotNull(surface);
            UE4.ParallelWorld.onSurfaceCreated(a16, surface, this.f386358e, this.f386359f);
        } else {
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            long a17 = a.a(null);
            Surface surface2 = this.f386357d;
            Intrinsics.checkNotNull(surface2);
            zPlanServiceHelper.u0(a17, surface2, this.f386358e, this.f386359f);
        }
        a.c(null, true);
    }
}
