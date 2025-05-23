package com.tencent.rmonitor.base.config;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.rmonitor.base.config.IConfigLoader;
import com.tencent.rmonitor.base.config.data.k;
import com.tencent.rmonitor.base.config.data.l;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes25.dex */
public class ConfigFetcher implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private final l f365264d = new l();

    /* renamed from: f, reason: collision with root package name */
    private IConfigLoader f365266f = null;

    /* renamed from: h, reason: collision with root package name */
    private final com.tencent.rmonitor.base.config.impl.g f365267h = new com.tencent.rmonitor.base.config.impl.g();

    /* renamed from: i, reason: collision with root package name */
    private Handler f365268i = null;

    /* renamed from: m, reason: collision with root package name */
    private boolean f365269m = false;

    /* renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArraySet<f> f365265e = new CopyOnWriteArraySet<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final ConfigFetcher f365271a = new ConfigFetcher();
    }

    protected ConfigFetcher() {
    }

    private IConfigLoader e() {
        IConfigLoader iConfigLoader = this.f365266f;
        if (iConfigLoader != null) {
            return iConfigLoader;
        }
        return this.f365267h;
    }

    private Handler f() {
        return this.f365268i;
    }

    public static ConfigFetcher g() {
        return a.f365271a;
    }

    private void k() {
        if (this.f365269m) {
            return;
        }
        this.f365269m = true;
        try {
            this.f365267h.d(this.f365264d);
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_config_fetcher", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(IConfigLoader.LoadReason loadReason) {
        IConfigLoader e16 = e();
        if (e16 == null) {
            Logger.f365497g.i("RMonitor_config_fetcher", "load config fail for loader is null");
            return;
        }
        Logger.f365497g.d("RMonitor_config_fetcher", "load config now.");
        try {
            e16.a(this.f365264d, loadReason);
            Iterator<f> it = this.f365265e.iterator();
            while (it.hasNext()) {
                it.next().a(this.f365264d);
            }
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_config_fetcher", th5);
        }
    }

    private boolean m() {
        return !this.f365269m;
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.f365265e.add(fVar);
        }
    }

    public void c() {
        Handler f16 = f();
        if (f16 != null) {
            f16.postDelayed(new Runnable() { // from class: com.tencent.rmonitor.base.config.ConfigFetcher.1
                @Override // java.lang.Runnable
                public void run() {
                    ConfigFetcher.this.l(IConfigLoader.LoadReason.CONFIG_CHANGE);
                }
            }, 100L);
        }
    }

    public k d(String str) {
        if (m()) {
            k();
        }
        return this.f365264d.b(str);
    }

    public m h(String str) {
        if (m()) {
            k();
        }
        return this.f365264d.c(str);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        return true;
    }

    public void i(Looper looper) {
        if (looper == null) {
            return;
        }
        Handler handler = this.f365268i;
        if (handler == null || handler.getLooper() != looper) {
            this.f365268i = new Handler(looper, this);
        }
    }

    public void j(final IConfigLoader.LoadReason loadReason) {
        Runnable runnable = new Runnable() { // from class: com.tencent.rmonitor.base.config.ConfigFetcher.2
            @Override // java.lang.Runnable
            public void run() {
                ConfigFetcher.this.l(loadReason);
            }
        };
        Handler f16 = f();
        if (f16 != null && f16.getLooper().getThread() != Thread.currentThread()) {
            Logger.f365497g.d("RMonitor_config_fetcher", "load config in specified thread.");
            f16.post(runnable);
        } else {
            Logger.f365497g.d("RMonitor_config_fetcher", "load config in current thread.");
            runnable.run();
        }
    }

    public List<String> n(List<String> list) {
        if (m()) {
            k();
        }
        return this.f365264d.d(list);
    }

    public void o(IConfigLoader iConfigLoader) {
        this.f365266f = iConfigLoader;
    }

    public void p(String str) {
        this.f365267h.f(str);
    }

    public void q(UserMeta userMeta) {
        this.f365267h.g(userMeta);
    }
}
