package com.tencent.zplan.utils;

import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 2})
/* loaded from: classes27.dex */
final class VSyncScheduler$callbackMainLoop$1 implements Runnable {
    final /* synthetic */ d this$0;

    @Override // java.lang.Runnable
    public final void run() {
        long c16;
        d.d(null).decrementAndGet();
        long nanoTime = System.nanoTime();
        if (d.c(null) == 0) {
            c16 = 0;
        } else {
            c16 = nanoTime - d.c(null);
        }
        if (c16 < 0 || d.e(null)) {
            d.h(null, false);
            c16 = d.a(null);
        }
        d.g(null, nanoTime);
        d.i(null, d.f(null) + c16);
        d.b(null);
        d.f(null);
        throw null;
    }
}
