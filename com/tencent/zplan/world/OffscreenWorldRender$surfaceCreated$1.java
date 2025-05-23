package com.tencent.zplan.world;

import android.view.Surface;
import com.epicgames.ue4.UE4;
import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes27.dex */
final class OffscreenWorldRender$surfaceCreated$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Surface f386215d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f386216e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f386217f;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public final void run() {
        long a16 = a.a(null);
        Surface surface = this.f386215d;
        if (surface == null) {
            Intrinsics.throwNpe();
        }
        UE4.ParallelWorld.onSurfaceCreated(a16, surface, this.f386216e, this.f386217f);
        a.b(null, true);
    }
}
