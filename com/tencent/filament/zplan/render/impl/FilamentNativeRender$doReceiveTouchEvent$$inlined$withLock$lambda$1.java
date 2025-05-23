package com.tencent.filament.zplan.render.impl;

import com.tencent.filament.zplan.engine.FilamentViewer;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE, "com/tencent/filament/zplan/render/impl/FilamentNativeRender$doReceiveTouchEvent$1$1"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
final class FilamentNativeRender$doReceiveTouchEvent$$inlined$withLock$lambda$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ TouchEvent f105870d;
    final /* synthetic */ c this$0;

    @Override // java.lang.Runnable
    public final void run() {
        FilamentViewer F = c.F(null);
        if (F != null) {
            F.receiveTouchEvent(this.f105870d);
        }
    }
}
