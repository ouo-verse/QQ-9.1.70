package com.tencent.filament.zplan.render.impl;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.filament.zplan.util.vsync.VSyncScheduler;
import com.tencent.filament.zplan.view.FilamentTextureView;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
final class FilamentNativeRender$onDestroy$2 implements Runnable {
    final /* synthetic */ c this$0;

    @Override // java.lang.Runnable
    public final void run() {
        ViewParent viewParent;
        FLog fLog = FLog.INSTANCE;
        fLog.i("FilamentNativeRender_LifeCycle", "onDestroy stopScheduleVSync");
        VSyncScheduler G = c.G(null);
        if (G != null) {
            G.p();
        }
        FilamentTextureView t16 = c.t(null);
        if (t16 != null) {
            viewParent = t16.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null) {
            ((ViewGroup) viewParent).removeView(c.t(null));
            fLog.i("FilamentNativeRender_LifeCycle", "onDestroy removeView");
        }
        FilamentTextureView t17 = c.t(null);
        if (t17 != null) {
            t17.a();
        }
        c.H(null, null);
    }
}
