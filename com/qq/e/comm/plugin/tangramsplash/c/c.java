package com.qq.e.comm.plugin.tangramsplash.c;

import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.k.f;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f39826a;

    /* renamed from: b, reason: collision with root package name */
    private final LinkedBlockingQueue<a> f39827b = new LinkedBlockingQueue<>();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private Runnable f39828a;

        /* renamed from: b, reason: collision with root package name */
        private volatile int f39829b = 0;

        public boolean b() {
            if (this.f39829b == 1) {
                return true;
            }
            return false;
        }

        public int c() {
            return this.f39829b;
        }

        public void d() {
            GDTLogger.i("PreloadTaskWorker onTaskFinish :" + hashCode());
            this.f39829b = 2;
            c.a().b(this);
            c.a().b();
        }

        public void e() {
            GDTLogger.e("PreloadTaskWorker onTaskFinish :" + hashCode());
            this.f39829b = 3;
            c.a().b(this);
            c.a().b();
        }

        public void a(Runnable runnable) {
            this.f39828a = runnable;
        }

        public void a() {
            GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.c.c.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f39828a != null && !a.this.b()) {
                        f.a(a.this.f39828a, "PreloadTaskWorker ", "mRunnable run");
                        a.this.f39829b = 1;
                    }
                }
            });
        }
    }

    c() {
    }

    public static c a() {
        if (f39826a == null) {
            synchronized (c.class) {
                if (f39826a == null) {
                    f39826a = new c();
                }
            }
        }
        return f39826a;
    }

    void b() {
        a peek = this.f39827b.peek();
        if (peek != null && !peek.b()) {
            GDTLogger.i("PreloadTaskWorker begin run task:" + peek.hashCode());
            peek.a();
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("PreloadTaskWorker tryRunTask fail status :");
        sb5.append(peek != null ? peek.c() : -1);
        GDTLogger.e(sb5.toString());
    }

    void b(a aVar) {
        this.f39827b.remove(aVar);
    }

    public void a(a aVar) {
        this.f39827b.offer(aVar);
        GDTLogger.i("PreloadTaskWorker addTask :" + aVar.hashCode() + " status:" + aVar.c());
        b();
    }
}
