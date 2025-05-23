package com.xiaomi.push.service;

import android.os.SystemClock;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class n {

    /* renamed from: c, reason: collision with root package name */
    private static long f389752c;

    /* renamed from: d, reason: collision with root package name */
    private static long f389753d;

    /* renamed from: a, reason: collision with root package name */
    private final c f389754a;

    /* renamed from: b, reason: collision with root package name */
    private final d f389755b;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class b implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        protected int f389756d;

        public b(int i3) {
            this.f389756d = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final c f389761a;

        d(c cVar) {
            this.f389761a = cVar;
        }

        protected void finalize() {
            try {
                synchronized (this.f389761a) {
                    this.f389761a.G = true;
                    this.f389761a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        final Object f389762a = new Object();

        /* renamed from: b, reason: collision with root package name */
        boolean f389763b;

        /* renamed from: c, reason: collision with root package name */
        long f389764c;

        /* renamed from: d, reason: collision with root package name */
        b f389765d;

        /* renamed from: e, reason: collision with root package name */
        int f389766e;

        /* renamed from: f, reason: collision with root package name */
        private long f389767f;

        e() {
        }

        void a(long j3) {
            synchronized (this.f389762a) {
                this.f389767f = j3;
            }
        }

        public boolean b() {
            boolean z16;
            synchronized (this.f389762a) {
                if (!this.f389763b && this.f389764c > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.f389763b = true;
            }
            return z16;
        }
    }

    static {
        long j3 = 0;
        if (SystemClock.elapsedRealtime() > 0) {
            j3 = SystemClock.elapsedRealtime();
        }
        f389752c = j3;
        f389753d = j3;
    }

    public n(String str, boolean z16) {
        if (str != null) {
            c cVar = new c(str, z16);
            this.f389754a = cVar;
            this.f389755b = new d(cVar);
            return;
        }
        throw new NullPointerException("name == null");
    }

    static synchronized long a() {
        long j3;
        synchronized (n.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j16 = f389753d;
            if (elapsedRealtime > j16) {
                f389752c += elapsedRealtime - j16;
            }
            f389753d = elapsedRealtime;
            j3 = f389752c;
        }
        return j3;
    }

    private void j(b bVar, long j3) {
        synchronized (this.f389754a) {
            if (!this.f389754a.F) {
                long a16 = j3 + a();
                if (a16 >= 0) {
                    e eVar = new e();
                    eVar.f389766e = bVar.f389756d;
                    eVar.f389765d = bVar;
                    eVar.f389764c = a16;
                    this.f389754a.e(eVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a16);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }

    public void b() {
        jz4.c.m("quit. finalizer:" + this.f389755b);
        this.f389754a.a();
    }

    public void c(int i3) {
        synchronized (this.f389754a) {
            this.f389754a.H.e(i3);
        }
    }

    public void d(int i3, b bVar) {
        synchronized (this.f389754a) {
            this.f389754a.H.f(i3, bVar);
        }
    }

    public void e(b bVar) {
        if (jz4.c.a() < 1 && Thread.currentThread() != this.f389754a) {
            jz4.c.B("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
        bVar.run();
    }

    public void f(b bVar, long j3) {
        if (j3 >= 0) {
            j(bVar, j3);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j3);
    }

    public boolean g() {
        return this.f389754a.m464a();
    }

    public boolean h(int i3) {
        boolean i16;
        synchronized (this.f389754a) {
            i16 = this.f389754a.H.i(i3);
        }
        return i16;
    }

    public void i() {
        synchronized (this.f389754a) {
            this.f389754a.H.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class c extends BaseThread {
        private boolean F;
        private boolean G;
        private volatile long C = 0;
        private volatile boolean D = false;
        private long E = 50;
        private a H = new a();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes28.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private int f389757a;

            /* renamed from: b, reason: collision with root package name */
            private e[] f389758b;

            /* renamed from: c, reason: collision with root package name */
            private int f389759c;

            /* renamed from: d, reason: collision with root package name */
            private int f389760d;

            a() {
                this.f389757a = 256;
                this.f389758b = new e[256];
                this.f389759c = 0;
                this.f389760d = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int b(e eVar) {
                int i3 = 0;
                while (true) {
                    e[] eVarArr = this.f389758b;
                    if (i3 < eVarArr.length) {
                        if (eVarArr[i3] == eVar) {
                            return i3;
                        }
                        i3++;
                    } else {
                        return -1;
                    }
                }
            }

            private void l() {
                int i3 = this.f389759c - 1;
                int i16 = (i3 - 1) / 2;
                while (true) {
                    e[] eVarArr = this.f389758b;
                    e eVar = eVarArr[i3];
                    long j3 = eVar.f389764c;
                    e eVar2 = eVarArr[i16];
                    if (j3 < eVar2.f389764c) {
                        eVarArr[i3] = eVar2;
                        eVarArr[i16] = eVar;
                        int i17 = i16;
                        i16 = (i16 - 1) / 2;
                        i3 = i17;
                    } else {
                        return;
                    }
                }
            }

            private void m(int i3) {
                int i16 = (i3 * 2) + 1;
                while (true) {
                    int i17 = this.f389759c;
                    if (i16 < i17 && i17 > 0) {
                        int i18 = i16 + 1;
                        if (i18 < i17) {
                            e[] eVarArr = this.f389758b;
                            if (eVarArr[i18].f389764c < eVarArr[i16].f389764c) {
                                i16 = i18;
                            }
                        }
                        e[] eVarArr2 = this.f389758b;
                        e eVar = eVarArr2[i3];
                        long j3 = eVar.f389764c;
                        e eVar2 = eVarArr2[i16];
                        if (j3 >= eVar2.f389764c) {
                            eVarArr2[i3] = eVar2;
                            eVarArr2[i16] = eVar;
                            int i19 = i16;
                            i16 = (i16 * 2) + 1;
                            i3 = i19;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            public e c() {
                return this.f389758b[0];
            }

            public void d() {
                this.f389758b = new e[this.f389757a];
                this.f389759c = 0;
            }

            public void e(int i3) {
                for (int i16 = 0; i16 < this.f389759c; i16++) {
                    e eVar = this.f389758b[i16];
                    if (eVar.f389766e == i3) {
                        eVar.b();
                    }
                }
                j();
            }

            public void f(int i3, b bVar) {
                for (int i16 = 0; i16 < this.f389759c; i16++) {
                    e eVar = this.f389758b[i16];
                    if (eVar.f389765d == bVar) {
                        eVar.b();
                    }
                }
                j();
            }

            public void g(e eVar) {
                e[] eVarArr = this.f389758b;
                int length = eVarArr.length;
                int i3 = this.f389759c;
                if (length == i3) {
                    e[] eVarArr2 = new e[i3 * 2];
                    System.arraycopy(eVarArr, 0, eVarArr2, 0, i3);
                    this.f389758b = eVarArr2;
                }
                e[] eVarArr3 = this.f389758b;
                int i16 = this.f389759c;
                this.f389759c = i16 + 1;
                eVarArr3[i16] = eVar;
                l();
            }

            public boolean h() {
                if (this.f389759c == 0) {
                    return true;
                }
                return false;
            }

            public boolean i(int i3) {
                for (int i16 = 0; i16 < this.f389759c; i16++) {
                    if (this.f389758b[i16].f389766e == i3) {
                        return true;
                    }
                }
                return false;
            }

            public void j() {
                int i3 = 0;
                while (i3 < this.f389759c) {
                    if (this.f389758b[i3].f389763b) {
                        this.f389760d++;
                        k(i3);
                        i3--;
                    }
                    i3++;
                }
            }

            public void k(int i3) {
                int i16;
                if (i3 >= 0 && i3 < (i16 = this.f389759c)) {
                    e[] eVarArr = this.f389758b;
                    int i17 = i16 - 1;
                    this.f389759c = i17;
                    eVarArr[i3] = eVarArr[i17];
                    eVarArr[i17] = null;
                    m(i3);
                }
            }
        }

        c(String str, boolean z16) {
            setName(str);
            setDaemon(z16);
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(e eVar) {
            this.H.g(eVar);
            notify();
        }

        public synchronized void a() {
            this.F = true;
            this.H.d();
            notify();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0092, code lost:
        
            r10.C = android.os.SystemClock.uptimeMillis();
            r10.D = true;
            r2.f389765d.run();
            r10.D = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a3, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00a4, code lost:
        
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00a5, code lost:
        
            r10.F = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00a8, code lost:
        
            throw r1;
         */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i3;
            while (true) {
                synchronized (this) {
                    if (this.F) {
                        return;
                    }
                    if (this.H.h()) {
                        if (this.G) {
                            return;
                        } else {
                            try {
                                LockMethodProxy.wait(this);
                            } catch (InterruptedException unused) {
                            }
                        }
                    } else {
                        long a16 = n.a();
                        e c16 = this.H.c();
                        synchronized (c16.f389762a) {
                            if (c16.f389763b) {
                                this.H.k(0);
                            } else {
                                long j3 = c16.f389764c - a16;
                                if (j3 > 0) {
                                    long j16 = this.E;
                                    if (j3 > j16) {
                                        j3 = j16;
                                    }
                                    long j17 = j16 + 50;
                                    this.E = j17;
                                    if (j17 > 500) {
                                        this.E = 500L;
                                    }
                                    try {
                                        wait(j3);
                                    } catch (InterruptedException unused2) {
                                    }
                                } else {
                                    this.E = 50L;
                                    synchronized (c16.f389762a) {
                                        if (this.H.c().f389764c != c16.f389764c) {
                                            i3 = this.H.b(c16);
                                        } else {
                                            i3 = 0;
                                        }
                                        if (c16.f389763b) {
                                            a aVar = this.H;
                                            aVar.k(aVar.b(c16));
                                        } else {
                                            c16.a(c16.f389764c);
                                            this.H.k(i3);
                                            c16.f389764c = 0L;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m464a() {
            return this.D && SystemClock.uptimeMillis() - this.C > 600000;
        }
    }

    public n(String str) {
        this(str, false);
    }
}
