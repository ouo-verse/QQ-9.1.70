package com.tencent.hlyyb.downloader.e;

import android.os.SystemClock;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f114446a;

    /* renamed from: b, reason: collision with root package name */
    public h f114447b;

    /* renamed from: c, reason: collision with root package name */
    public long f114448c;

    /* renamed from: d, reason: collision with root package name */
    public long f114449d;

    /* renamed from: e, reason: collision with root package name */
    public int f114450e;

    /* renamed from: f, reason: collision with root package name */
    public C5818a f114451f;

    /* compiled from: P */
    /* renamed from: com.tencent.hlyyb.downloader.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C5818a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f114452a;

        /* renamed from: b, reason: collision with root package name */
        public long f114453b;

        /* renamed from: c, reason: collision with root package name */
        public int f114454c;

        /* renamed from: d, reason: collision with root package name */
        public List<C5819a> f114455d;

        /* compiled from: P */
        /* renamed from: com.tencent.hlyyb.downloader.e.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C5819a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public int f114456a;

            /* renamed from: b, reason: collision with root package name */
            public int f114457b;

            public C5819a(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3);
                } else {
                    this.f114457b = 0;
                    this.f114456a = i3;
                }
            }
        }

        public C5818a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f114452a = 0L;
            this.f114453b = 0L;
            this.f114454c = 0;
            this.f114455d = new LinkedList();
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.f114454c;
        }

        public final void b(int i3) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            boolean z17 = true;
            int i16 = 0;
            if (i3 <= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i17 = (int) (elapsedRealtime - this.f114452a);
            this.f114452a = elapsedRealtime;
            if (this.f114455d.size() == 0) {
                if (!z16) {
                    this.f114455d.add(new C5819a(i3));
                }
            } else {
                for (C5819a c5819a : this.f114455d) {
                    int i18 = c5819a.f114457b + i17;
                    c5819a.f114457b = i18;
                    if (!z16 && i18 > 2000) {
                        c5819a.f114457b = 0;
                        c5819a.f114456a = i3;
                        z16 = true;
                    }
                }
                if (!z16 && this.f114455d.size() <= (2000 / com.tencent.hlyyb.downloader.a.b.f114398f) + 1) {
                    this.f114455d.add(new C5819a(i3));
                }
                if (elapsedRealtime - this.f114453b <= 200) {
                    z17 = false;
                }
            }
            if (z17) {
                if (this.f114455d.size() != 0) {
                    Iterator<C5819a> it = this.f114455d.iterator();
                    long j3 = 0;
                    while (it.hasNext()) {
                        if (it.next().f114457b <= 2000) {
                            j3 += r2.f114456a;
                        }
                    }
                    i16 = (int) ((j3 * 1000) / 2000);
                }
                this.f114454c = i16;
                this.f114453b = elapsedRealtime;
            }
        }

        public /* synthetic */ C5818a(byte b16) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Byte.valueOf(b16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public final class c implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public f f114458d;

        /* renamed from: e, reason: collision with root package name */
        public volatile boolean f114459e;

        /* renamed from: f, reason: collision with root package name */
        public Object f114460f;

        /* renamed from: h, reason: collision with root package name */
        public Object f114461h;

        /* renamed from: i, reason: collision with root package name */
        public volatile boolean f114462i;

        public c(f fVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
                return;
            }
            this.f114459e = false;
            this.f114460f = new Object();
            this.f114461h = new Object();
            this.f114462i = false;
            this.f114458d = fVar;
            new BaseThread(this, "HalleyDownload-SaveThread").start();
        }

        public final void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            synchronized (this.f114460f) {
                if (!this.f114459e) {
                    this.f114459e = true;
                    this.f114460f.notify();
                }
            }
        }

        public final void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            synchronized (this.f114460f) {
                if (this.f114459e) {
                    this.f114459e = false;
                }
            }
        }

        public final void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            try {
                if (this.f114462i) {
                    synchronized (this.f114461h) {
                        this.f114461h.notify();
                    }
                }
            } catch (Exception unused) {
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            while (true) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    z16 = this.f114458d.a();
                } catch (Throwable unused) {
                    z16 = false;
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                if (!z16) {
                    int i3 = com.tencent.hlyyb.downloader.a.b.f114398f;
                    if (elapsedRealtime2 > 0) {
                        long j3 = i3;
                        if (elapsedRealtime2 < j3) {
                            int i16 = (int) (j3 - elapsedRealtime2);
                            try {
                                this.f114462i = true;
                                synchronized (this.f114461h) {
                                    this.f114461h.wait(i16);
                                }
                            } catch (Exception unused2) {
                            } catch (Throwable th5) {
                                this.f114462i = false;
                                throw th5;
                            }
                            this.f114462i = false;
                        }
                    }
                }
                synchronized (this.f114460f) {
                    if (!this.f114459e) {
                        try {
                            LockMethodProxy.wait(this.f114460f);
                        } catch (InterruptedException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public a(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hVar);
            return;
        }
        this.f114446a = 0L;
        this.f114448c = 0L;
        this.f114449d = 0L;
        this.f114450e = 0;
        this.f114451f = new C5818a((byte) 0);
        this.f114447b = hVar;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f114446a = SystemClock.elapsedRealtime();
        this.f114448c = 0L;
        this.f114449d = 0L;
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f114448c = System.currentTimeMillis();
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f114449d = System.currentTimeMillis();
        }
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.f114449d - this.f114448c;
    }

    public final void a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f114450e += i16;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = elapsedRealtime - this.f114446a;
        this.f114446a = elapsedRealtime;
        this.f114447b.f114611p += j3;
        this.f114451f.b(i3);
        this.f114447b.f114624w = this.f114451f.a();
    }
}
