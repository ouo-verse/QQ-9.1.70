package com.google.android.apps.internal.games.memoryadvice;

import com.google.android.apps.internal.games.memoryadvice.MemoryAdvisor;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes2.dex */
class MemoryWatcher$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MemoryAdvisor f32922d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ long f32923e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f32924f;
    final /* synthetic */ d this$0;

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
    
        if (r0 > r4) goto L9;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        MemoryAdvisor.MemoryState g16 = MemoryAdvisor.g(this.f32922d.e());
        long a16 = currentTimeMillis - d.a(null);
        if (a16 > 100) {
            d.d(null, d.c(null) + a16);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (g16 == d.e(null)) {
            d.h(null, d.g(null) + (currentTimeMillis2 - currentTimeMillis));
            long g17 = ((d.g(null) * 1000) / this.f32923e) - ((currentTimeMillis2 - d.i(null)) - d.c(null));
            long j3 = 1;
            if (g17 >= 1) {
                j3 = this.f32924f;
            }
            g17 = j3;
            d.b(null, System.currentTimeMillis() + g17);
            d.k(null).schedule(new TimerTask() { // from class: com.google.android.apps.internal.games.memoryadvice.MemoryWatcher$1.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    MemoryWatcher$1.this.getClass();
                    d.j(null).run();
                }
            }, g17);
            return;
        }
        d.f(null, g16);
        throw null;
    }
}
