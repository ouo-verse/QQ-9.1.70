package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ae {

    /* renamed from: e, reason: collision with root package name */
    private static volatile ae f388139e;

    /* renamed from: a, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f388140a = new BaseScheduledThreadPoolExecutor(1);

    /* renamed from: b, reason: collision with root package name */
    private Map<String, ScheduledFuture> f388141b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private Object f388142c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private SharedPreferences f388143d;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class a implements Runnable {
        public abstract String e();
    }

    ae(Context context) {
        this.f388143d = context.getSharedPreferences("mipush_extra", 0);
    }

    public static ae b(Context context) {
        if (f388139e == null) {
            synchronized (ae.class) {
                if (f388139e == null) {
                    f388139e = new ae(context);
                }
            }
        }
        return f388139e;
    }

    private static String d(String str) {
        return "last_job_time" + str;
    }

    private ScheduledFuture f(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f388142c) {
            scheduledFuture = this.f388141b.get(aVar.e());
        }
        return scheduledFuture;
    }

    public void g(Runnable runnable) {
        h(runnable, 0);
    }

    public void h(Runnable runnable, int i3) {
        this.f388140a.schedule(runnable, i3, TimeUnit.SECONDS);
    }

    public boolean i(a aVar) {
        return n(aVar, 0);
    }

    public boolean j(a aVar, int i3) {
        return k(aVar, i3, 0);
    }

    public boolean k(a aVar, int i3, int i16) {
        return l(aVar, i3, i16, false);
    }

    public boolean l(a aVar, int i3, int i16, final boolean z16) {
        if (aVar != null && f(aVar) == null) {
            final String d16 = d(aVar.e());
            b bVar = new b(aVar) { // from class: com.xiaomi.push.ae.1
                @Override // com.xiaomi.push.ae.b
                void a() {
                    super.a();
                }

                @Override // com.xiaomi.push.ae.b
                void e() {
                    if (!z16) {
                        ae.this.f388143d.edit().putLong(d16, System.currentTimeMillis()).commit();
                    }
                }
            };
            if (!z16) {
                long abs = Math.abs(System.currentTimeMillis() - this.f388143d.getLong(d16, 0L)) / 1000;
                if (abs < i3 - i16) {
                    i16 = (int) (i3 - abs);
                }
            }
            try {
                ScheduledFuture<?> scheduleAtFixedRate = this.f388140a.scheduleAtFixedRate(bVar, i16, i3, TimeUnit.SECONDS);
                synchronized (this.f388142c) {
                    this.f388141b.put(aVar.e(), scheduleAtFixedRate);
                }
                return true;
            } catch (Exception e16) {
                jz4.c.q(e16);
                return true;
            }
        }
        return false;
    }

    public boolean m(String str) {
        synchronized (this.f388142c) {
            ScheduledFuture scheduledFuture = this.f388141b.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f388141b.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    public boolean n(a aVar, int i3) {
        if (aVar != null && f(aVar) == null) {
            ScheduledFuture<?> schedule = this.f388140a.schedule(new b(aVar) { // from class: com.xiaomi.push.ae.2
                @Override // com.xiaomi.push.ae.b
                void e() {
                    synchronized (ae.this.f388142c) {
                        ae.this.f388141b.remove(this.f388148d.e());
                    }
                }
            }, i3, TimeUnit.SECONDS);
            synchronized (this.f388142c) {
                this.f388141b.put(aVar.e(), schedule);
            }
            return true;
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static class b implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        a f388148d;

        public b(a aVar) {
            this.f388148d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.f388148d.run();
            e();
        }

        void a() {
        }

        void e() {
        }
    }
}
