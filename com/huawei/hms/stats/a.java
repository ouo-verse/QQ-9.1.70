package com.huawei.hms.stats;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    private static final a f37493f = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Object f37494a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private boolean f37495b = false;

    /* renamed from: c, reason: collision with root package name */
    private final List<Runnable> f37496c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final Handler f37497d = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f37498e = new RunnableC0274a();

    /* compiled from: P */
    /* renamed from: com.huawei.hms.stats.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0274a implements Runnable {
        RunnableC0274a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.i("AnalyticsCacheManager", "Timeout execCacheBi.");
            if (!HiAnalyticsUtils.getInstance().getInitFlag()) {
                a.this.a();
            } else {
                a.this.b();
            }
        }
    }

    a() {
    }

    public static a c() {
        return f37493f;
    }

    public void a(Runnable runnable) {
        synchronized (this.f37494a) {
            if (runnable == null) {
                return;
            }
            if (this.f37495b) {
                return;
            }
            if (this.f37496c.size() >= 60) {
                return;
            }
            this.f37496c.add(runnable);
            this.f37497d.removeCallbacks(this.f37498e);
            this.f37497d.postDelayed(this.f37498e, 10000L);
        }
    }

    public void b() {
        synchronized (this.f37494a) {
            HMSLog.i("AnalyticsCacheManager", "execCacheBi: cache size: " + this.f37496c.size());
            this.f37495b = true;
            try {
                Iterator<Runnable> it = this.f37496c.iterator();
                while (it.hasNext()) {
                    it.next().run();
                    it.remove();
                }
            } catch (Throwable th5) {
                HMSLog.e("AnalyticsCacheManager", "<execCacheBi> failed. " + th5.getMessage());
                a();
            }
            this.f37495b = false;
        }
    }

    public void a() {
        synchronized (this.f37494a) {
            HMSLog.i("AnalyticsCacheManager", "clear AnalyticsCache.");
            this.f37496c.clear();
        }
    }
}
