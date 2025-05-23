package com.qq.e.comm.plugin.stat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.k.ac;
import com.qq.e.comm.plugin.k.t;
import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class p {

    /* renamed from: c, reason: collision with root package name */
    private static volatile p f39726c;

    /* renamed from: a, reason: collision with root package name */
    private Context f39727a;

    /* renamed from: b, reason: collision with root package name */
    private k f39728b;

    /* renamed from: d, reason: collision with root package name */
    private Runnable f39729d = new Runnable() { // from class: com.qq.e.comm.plugin.stat.p.4
        @Override // java.lang.Runnable
        public void run() {
            p.this.e();
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private Runnable f39730e = new Runnable() { // from class: com.qq.e.comm.plugin.stat.p.5
        @Override // java.lang.Runnable
        public void run() {
            p.this.f();
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private Runnable f39731f = new Runnable() { // from class: com.qq.e.comm.plugin.stat.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (!t.a(p.this.f39727a)) {
                p.this.a(2);
            }
        }
    };

    p() {
        Context appContext = GDTADManager.getInstance().getAppContext();
        this.f39727a = appContext;
        this.f39728b = new k(appContext);
        if (com.qq.e.comm.plugin.j.c.a("statRegisterActivityCallbacks", 0, 1) && (this.f39727a instanceof Application)) {
            GDTLogger.d("Stat register activity listener");
            ((Application) this.f39727a).registerActivityLifecycleCallbacks(new a(this));
        }
        a(this.f39727a);
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.plugin.stat.p.1
            @Override // java.lang.Runnable
            public void run() {
                p.this.a(1);
                g.a(p.this.f39727a.getApplicationContext()).a();
            }
        });
    }

    public static p a() {
        if (f39726c == null) {
            synchronized (p.class) {
                if (f39726c == null) {
                    f39726c = new p();
                }
            }
        }
        return f39726c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        GdtSDKThreadManager.getSubThreadHandler().postDelayed(this.f39731f, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        GDTLogger.d("Call save stat");
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.plugin.stat.p.7
            @Override // java.lang.Runnable
            public void run() {
                if (p.this.f39728b != null) {
                    p.this.f39728b.a();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        GDTLogger.d("Call commit stat");
        if (ac.a(this.f39727a)) {
            GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.plugin.stat.p.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        p.this.f39728b.b();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        GDTLogger.d("Call report stat");
        if (ac.a(this.f39727a)) {
            GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.plugin.stat.p.9
                @Override // java.lang.Runnable
                public void run() {
                    p.this.f39728b.f();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.stat.p.10
            @Override // java.lang.Runnable
            public void run() {
                p.this.a(5);
            }
        });
    }

    public void b() {
        GDTLogger.d("call instance report");
        a(6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        a(this.f39728b, iVar);
    }

    private <T extends m> void a(final com.qq.e.comm.plugin.stat.a<T> aVar, final T t16) {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.plugin.stat.p.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    aVar.a((com.qq.e.comm.plugin.stat.a) t16);
                    if (f.c(t16.b())) {
                        p.this.a(6);
                    } else {
                        p.this.a(3);
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        });
    }

    synchronized void a(int i3) {
        switch (i3) {
            case 1:
            case 2:
            case 6:
                GdtSDKThreadManager.getSubThreadHandler().removeCallbacks(this.f39729d);
                GdtSDKThreadManager.getSubThreadHandler().postDelayed(this.f39729d, 500L);
                break;
            case 3:
            case 4:
            case 5:
                GdtSDKThreadManager.getSubThreadHandler().removeCallbacks(this.f39730e);
                GdtSDKThreadManager.getSubThreadHandler().postDelayed(this.f39730e, 500L);
                break;
        }
    }

    public void a(Context context) {
        try {
            context.getApplicationContext().registerReceiver(new BroadcastReceiver() { // from class: com.qq.e.comm.plugin.stat.p.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    p.this.g();
                }
            }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Throwable unused) {
        }
    }

    /* compiled from: P */
    @TargetApi(14)
    /* loaded from: classes3.dex */
    private static final class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        private p f39744a;

        public a(p pVar) {
            this.f39744a = pVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            this.f39744a.d();
            this.f39744a.c();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.stat.p.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f39744a.a(4);
                }
            });
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
