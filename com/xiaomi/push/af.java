package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes28.dex */
public class af {

    /* renamed from: a, reason: collision with root package name */
    private a f388149a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f388150b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f388151c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f388152d;

    /* renamed from: e, reason: collision with root package name */
    private int f388153e;

    /* renamed from: f, reason: collision with root package name */
    private volatile c f388154f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a extends BaseThread {
        private final LinkedBlockingQueue<c> C;

        public a() {
            super("PackageProcessor");
            this.C = new LinkedBlockingQueue<>();
        }

        private void c(int i3, c cVar) {
            try {
                af.this.f388150b.sendMessage(af.this.f388150b.obtainMessage(i3, cVar));
            } catch (Exception e16) {
                jz4.c.q(e16);
            }
        }

        public void d(c cVar) {
            try {
                this.C.add(cVar);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            long j3;
            if (af.this.f388153e > 0) {
                j3 = af.this.f388153e;
            } else {
                j3 = Long.MAX_VALUE;
            }
            while (!af.this.f388151c) {
                try {
                    c poll = this.C.poll(j3, TimeUnit.SECONDS);
                    af.this.f388154f = poll;
                    if (poll != null) {
                        c(0, poll);
                        poll.b();
                        c(1, poll);
                    } else if (af.this.f388153e > 0) {
                        af.this.d();
                    }
                } catch (InterruptedException e16) {
                    jz4.c.q(e16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar = (c) message.obj;
            int i3 = message.what;
            if (i3 == 0) {
                cVar.a();
            } else if (i3 == 1) {
                cVar.c();
            }
            super.handleMessage(message);
        }
    }

    public af(boolean z16) {
        this(z16, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        this.f388149a = null;
        this.f388151c = true;
    }

    public synchronized void e(c cVar) {
        if (this.f388149a == null) {
            a aVar = new a();
            this.f388149a = aVar;
            aVar.setDaemon(this.f388152d);
            this.f388151c = false;
            this.f388149a.start();
        }
        this.f388149a.d(cVar);
    }

    public void f(final c cVar, long j3) {
        this.f388150b.postDelayed(new Runnable() { // from class: com.xiaomi.push.af.2
            @Override // java.lang.Runnable
            public void run() {
                af.this.e(cVar);
            }
        }, j3);
    }

    public af(boolean z16, int i3) {
        this.f388150b = null;
        this.f388151c = false;
        this.f388153e = 0;
        this.f388150b = new b(Looper.getMainLooper());
        this.f388152d = z16;
        this.f388153e = i3;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class c {
        public abstract void b();

        public void a() {
        }

        public void c() {
        }
    }
}
