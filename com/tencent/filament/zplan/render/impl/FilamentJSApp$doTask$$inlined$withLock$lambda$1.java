package com.tencent.filament.zplan.render.impl;

import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE, "com/tencent/filament/zplan/render/impl/FilamentJSApp$doTask$1$1"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
final class FilamentJSApp$doTask$$inlined$withLock$lambda$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f105827d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Function0 f105828e;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public final void run() {
        FLog.INSTANCE.i("FilamentJSApp", this.f105827d + " run.");
        this.f105828e.invoke();
    }
}
