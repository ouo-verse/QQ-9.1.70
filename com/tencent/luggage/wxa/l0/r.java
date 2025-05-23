package com.tencent.luggage.wxa.l0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f132838a;

    /* renamed from: b, reason: collision with root package name */
    public b f132839b;

    /* renamed from: c, reason: collision with root package name */
    public IOException f132840c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        int a(c cVar, long j3, long j16, IOException iOException);

        void a(c cVar, long j3, long j16);

        void a(c cVar, long j3, long j16, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        boolean a();

        void b();

        void c();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Handler implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final d f132850a;

        public e(d dVar) {
            this.f132850a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f132850a.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            sendEmptyMessage(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends IOException {
        public f(Throwable th5) {
            super("Unexpected " + th5.getClass().getSimpleName() + MsgSummary.STR_COLON + th5.getMessage(), th5);
        }
    }

    public r(String str) {
        this.f132838a = v.d(str);
    }

    public void c() {
        a(Integer.MIN_VALUE);
    }

    public void d() {
        a((d) null);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class b extends Handler implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final c f132841a;

        /* renamed from: b, reason: collision with root package name */
        public final a f132842b;

        /* renamed from: c, reason: collision with root package name */
        public final int f132843c;

        /* renamed from: d, reason: collision with root package name */
        public final long f132844d;

        /* renamed from: e, reason: collision with root package name */
        public IOException f132845e;

        /* renamed from: f, reason: collision with root package name */
        public int f132846f;

        /* renamed from: g, reason: collision with root package name */
        public volatile Thread f132847g;

        /* renamed from: h, reason: collision with root package name */
        public volatile boolean f132848h;

        public b(Looper looper, c cVar, a aVar, int i3, long j3) {
            super(looper);
            this.f132841a = cVar;
            this.f132842b = aVar;
            this.f132843c = i3;
            this.f132844d = j3;
        }

        public void a(int i3) {
            IOException iOException = this.f132845e;
            if (iOException != null && this.f132846f > i3) {
                throw iOException;
            }
        }

        public void b(boolean z16) {
            this.f132848h = z16;
            this.f132845e = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z16) {
                    sendEmptyMessage(1);
                }
            } else {
                this.f132841a.c();
                if (this.f132847g != null) {
                    this.f132847g.interrupt();
                }
            }
            if (z16) {
                b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f132842b.a(this.f132841a, elapsedRealtime, elapsedRealtime - this.f132844d, true);
            }
        }

        public final long c() {
            return Math.min((this.f132846f - 1) * 1000, 5000);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f132848h) {
                return;
            }
            int i3 = message.what;
            if (i3 == 0) {
                a();
                return;
            }
            if (i3 != 4) {
                b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j3 = elapsedRealtime - this.f132844d;
                if (this.f132841a.a()) {
                    this.f132842b.a(this.f132841a, elapsedRealtime, j3, false);
                    return;
                }
                int i16 = message.what;
                int i17 = 1;
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 == 3) {
                            IOException iOException = (IOException) message.obj;
                            this.f132845e = iOException;
                            int a16 = this.f132842b.a(this.f132841a, elapsedRealtime, j3, iOException);
                            if (a16 == 3) {
                                r.this.f132840c = this.f132845e;
                                return;
                            } else {
                                if (a16 != 2) {
                                    if (a16 != 1) {
                                        i17 = 1 + this.f132846f;
                                    }
                                    this.f132846f = i17;
                                    a(c());
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    this.f132842b.a(this.f132841a, elapsedRealtime, j3);
                    return;
                }
                this.f132842b.a(this.f132841a, elapsedRealtime, j3, false);
                return;
            }
            throw ((Error) message.obj);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f132847g = Thread.currentThread();
                if (!this.f132841a.a()) {
                    com.tencent.luggage.wxa.n0.t.a("load:" + this.f132841a.getClass().getSimpleName());
                    try {
                        this.f132841a.b();
                        com.tencent.luggage.wxa.n0.t.a();
                    } catch (Throwable th5) {
                        com.tencent.luggage.wxa.n0.t.a();
                        throw th5;
                    }
                }
                if (!this.f132848h) {
                    sendEmptyMessage(2);
                }
            } catch (IOException e16) {
                if (!this.f132848h) {
                    obtainMessage(3, e16).sendToTarget();
                }
            } catch (InterruptedException unused) {
                com.tencent.luggage.wxa.n0.a.b(this.f132841a.a());
                if (!this.f132848h) {
                    sendEmptyMessage(2);
                }
            } catch (Exception e17) {
                Log.e("LoadTask", "Unexpected exception loading stream", e17);
                if (!this.f132848h) {
                    obtainMessage(3, new f(e17)).sendToTarget();
                }
            } catch (OutOfMemoryError e18) {
                Log.e("LoadTask", "OutOfMemory error loading stream", e18);
                if (!this.f132848h) {
                    obtainMessage(3, new f(e18)).sendToTarget();
                }
            } catch (Error e19) {
                Log.e("LoadTask", "Unexpected error loading stream", e19);
                if (!this.f132848h) {
                    obtainMessage(4, e19).sendToTarget();
                }
                throw e19;
            }
        }

        public void a(long j3) {
            com.tencent.luggage.wxa.n0.a.b(r.this.f132839b == null);
            r.this.f132839b = this;
            if (j3 > 0) {
                sendEmptyMessageDelayed(0, j3);
            } else {
                a();
            }
        }

        public final void a() {
            this.f132845e = null;
            r.this.f132838a.execute(r.this.f132839b);
        }

        public final void b() {
            r.this.f132839b = null;
        }
    }

    public boolean b() {
        return this.f132839b != null;
    }

    public long a(c cVar, a aVar, int i3) {
        Looper myLooper = Looper.myLooper();
        com.tencent.luggage.wxa.n0.a.b(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(myLooper, cVar, aVar, i3, elapsedRealtime).a(0L);
        return elapsedRealtime;
    }

    public void a() {
        this.f132839b.b(false);
    }

    public boolean a(d dVar) {
        b bVar = this.f132839b;
        boolean z16 = true;
        if (bVar != null) {
            bVar.b(true);
            if (dVar != null) {
                this.f132838a.execute(new e(dVar));
            }
        } else if (dVar != null) {
            dVar.a();
            this.f132838a.shutdown();
            return z16;
        }
        z16 = false;
        this.f132838a.shutdown();
        return z16;
    }

    public void a(int i3) {
        IOException iOException = this.f132840c;
        if (iOException == null) {
            b bVar = this.f132839b;
            if (bVar != null) {
                if (i3 == Integer.MIN_VALUE) {
                    i3 = bVar.f132843c;
                }
                bVar.a(i3);
                return;
            }
            return;
        }
        throw iOException;
    }
}
