package com.epicgames.ue4.util;

import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes2.dex */
final class VSyncScheduler$callbackMainLoop$1 implements Runnable {
    final /* synthetic */ c this$0;

    @Override // java.lang.Runnable
    public final void run() {
        long c16;
        c.d(null).decrementAndGet();
        long nanoTime = System.nanoTime();
        if (c.c(null) == 0) {
            c16 = 0;
        } else {
            c16 = nanoTime - c.c(null);
        }
        if (c16 < 0 || c.e(null)) {
            c.h(null, false);
            c16 = c.a(null);
        }
        c.g(null, nanoTime);
        c.i(null, c.f(null) + c16);
        c.b(null);
        c.f(null);
        throw null;
    }
}
