package com.tencent.liteav.base.util;

import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class l implements q {

    /* renamed from: a, reason: collision with root package name */
    final ThreadPoolExecutor f119032a;

    /* renamed from: b, reason: collision with root package name */
    final CustomHandler f119033b;

    /* renamed from: c, reason: collision with root package name */
    final List<a> f119034c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f119035a;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f119037c;

        /* renamed from: d, reason: collision with root package name */
        private final Runnable f119038d = o.a(this);

        /* renamed from: e, reason: collision with root package name */
        private final long f119039e;

        public a(Runnable runnable, long j3) {
            this.f119037c = runnable;
            this.f119035a = n.a(this, runnable);
            this.f119039e = j3;
        }

        public final void a() {
            l.this.f119033b.postDelayed(this.f119038d, this.f119039e);
        }
    }

    public l() {
        this((byte) 0);
    }

    @Override // com.tencent.liteav.base.util.q
    public final void a(Runnable runnable) {
        this.f119032a.execute(runnable);
    }

    l(byte b16) {
        this("SequenceTaskRunner_");
    }

    public final void a(Runnable runnable, long j3) {
        a aVar = new a(runnable, j3);
        synchronized (this) {
            this.f119034c.add(aVar);
        }
        aVar.a();
    }

    public l(String str) {
        this.f119032a = new BaseThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), m.a(str));
        this.f119033b = new CustomHandler(Looper.getMainLooper());
        this.f119034c = new ArrayList();
    }
}
