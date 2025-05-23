package com.tencent.zplan.world.manager;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.zplan.utils.ZLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanWorldManager$doOnWorldThread$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f386312d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Function0 f386313e;

    @Override // java.lang.Runnable
    public final void run() {
        ZPlanWorldManager zPlanWorldManager = ZPlanWorldManager.f386245m;
        String str = this.f386312d;
        ZLog zLog = ZLog.f386189b;
        zLog.k("ZPlanWorldManager", "doOnWorldThread before task, from: " + str);
        this.f386313e.invoke();
        zLog.k("ZPlanWorldManager", "doOnWorldThread after task, from: " + str);
    }
}
