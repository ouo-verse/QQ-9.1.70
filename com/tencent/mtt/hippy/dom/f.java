package com.tencent.mtt.hippy.dom;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mtt.hippy.dom.e;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    private final Object f337313c;

    /* renamed from: d, reason: collision with root package name */
    private final Looper f337314d;

    /* renamed from: e, reason: collision with root package name */
    private final d f337315e;

    /* renamed from: f, reason: collision with root package name */
    private final c f337316f;

    /* renamed from: g, reason: collision with root package name */
    private b f337317g;

    /* renamed from: h, reason: collision with root package name */
    private final a[] f337318h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f337319i;

    /* renamed from: j, reason: collision with root package name */
    private long f337320j;

    /* renamed from: k, reason: collision with root package name */
    private final long f337321k;

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<f> f337312b = new ThreadLocal<f>() { // from class: com.tencent.mtt.hippy.dom.f.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f initialValue() {
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                return new f(myLooper);
            }
            throw new IllegalStateException("The current thread must have a looper!");
        }
    };

    /* renamed from: a, reason: collision with root package name */
    static final Object f337311a = new Object() { // from class: com.tencent.mtt.hippy.dom.f.2
        public String toString() {
            return "FRAME_CALLBACK_TOKEN";
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public final class a {

        /* renamed from: b, reason: collision with root package name */
        private b f337323b;

        a() {
        }

        public void a(long j3, Object obj, Object obj2) {
            b a16 = f.this.a(j3, obj, obj2);
            b bVar = this.f337323b;
            if (bVar == null) {
                this.f337323b = a16;
                return;
            }
            if (j3 < bVar.f337325b) {
                a16.f337324a = bVar;
                this.f337323b = a16;
                return;
            }
            while (true) {
                b bVar2 = bVar.f337324a;
                if (bVar2 == null) {
                    break;
                }
                if (j3 < bVar2.f337325b) {
                    a16.f337324a = bVar2;
                    break;
                }
                bVar = bVar2;
            }
            bVar.f337324a = a16;
        }

        public b b(long j3) {
            b bVar = this.f337323b;
            if (bVar == null || bVar.f337325b > j3) {
                return null;
            }
            b bVar2 = bVar.f337324a;
            b bVar3 = bVar;
            while (true) {
                if (bVar2 == null) {
                    break;
                }
                if (bVar2.f337325b > j3) {
                    bVar3.f337324a = null;
                    break;
                }
                bVar3 = bVar2;
                bVar2 = bVar2.f337324a;
            }
            this.f337323b = bVar2;
            return bVar;
        }

        public void a(Object obj, Object obj2) {
            b bVar = this.f337323b;
            b bVar2 = null;
            while (bVar != null) {
                b bVar3 = bVar.f337324a;
                if ((obj == null || bVar.f337326c == obj) && (obj2 == null || bVar.f337327d == obj2)) {
                    if (bVar2 != null) {
                        bVar2.f337324a = bVar3;
                    } else {
                        this.f337323b = bVar3;
                    }
                    f.this.a(bVar);
                } else {
                    bVar2 = bVar;
                }
                bVar = bVar3;
            }
        }

        public boolean a(long j3) {
            b bVar = this.f337323b;
            return bVar != null && bVar.f337325b <= j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public b f337324a;

        /* renamed from: b, reason: collision with root package name */
        public long f337325b;

        /* renamed from: c, reason: collision with root package name */
        public Object f337326c;

        /* renamed from: d, reason: collision with root package name */
        public Object f337327d;

        b() {
        }

        public void a(long j3) {
            if (this.f337327d == f.f337311a) {
                ((e.a) this.f337326c).a(j3);
            } else {
                ((Runnable) this.f337326c).run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f337328a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f337329b;

        /* renamed from: c, reason: collision with root package name */
        private long f337330c;

        /* renamed from: d, reason: collision with root package name */
        private int f337331d;

        /* renamed from: e, reason: collision with root package name */
        private final Handler f337332e;

        public void a() {
            this.f337332e.postDelayed(this, 16L);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f337329b = false;
            this.f337328a.a(this.f337330c, this.f337331d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public final class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        f.this.a(message.arg1);
                        return;
                    }
                    return;
                }
                f.this.b();
                return;
            }
            f.this.a(System.nanoTime(), 0);
        }
    }

    f(Looper looper) {
        this.f337313c = new Object();
        this.f337314d = looper;
        this.f337315e = new d(looper);
        this.f337316f = null;
        this.f337320j = Long.MIN_VALUE;
        this.f337321k = 1.0E9f / c();
        this.f337318h = new a[3];
        for (int i3 = 0; i3 <= 2; i3++) {
            this.f337318h[i3] = new a();
        }
    }

    private static float c() {
        return 60.0f;
    }

    private void d() {
        this.f337316f.a();
    }

    b a(long j3, Object obj, Object obj2) {
        b bVar = this.f337317g;
        if (bVar == null) {
            bVar = new b();
        } else {
            this.f337317g = bVar.f337324a;
            bVar.f337324a = null;
        }
        bVar.f337325b = j3;
        bVar.f337326c = obj;
        bVar.f337327d = obj2;
        return bVar;
    }

    void b() {
        synchronized (this.f337313c) {
            if (this.f337319i) {
                d();
            }
        }
    }

    public static f a() {
        return f337312b.get();
    }

    public void b(e.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        a(1, (Object) aVar, f337311a);
    }

    void a(int i3) {
        synchronized (this.f337313c) {
            if (!this.f337319i) {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (this.f337318h[i3].a(uptimeMillis)) {
                    a(uptimeMillis);
                }
            }
        }
    }

    void a(int i3, long j3) {
        synchronized (this.f337313c) {
            b b16 = this.f337318h[i3].b(SystemClock.uptimeMillis());
            if (b16 == null) {
                return;
            }
            for (b bVar = b16; bVar != null; bVar = bVar.f337324a) {
                try {
                    bVar.a(j3);
                } catch (Throwable th5) {
                    synchronized (this.f337313c) {
                        while (true) {
                            b bVar2 = b16.f337324a;
                            a(b16);
                            if (bVar2 == null) {
                                break;
                            } else {
                                b16 = bVar2;
                            }
                        }
                        throw th5;
                    }
                }
            }
            synchronized (this.f337313c) {
                while (true) {
                    b bVar3 = b16.f337324a;
                    a(b16);
                    if (bVar3 != null) {
                        b16 = bVar3;
                    }
                }
            }
        }
    }

    private void a(int i3, Object obj, Object obj2) {
        synchronized (this.f337313c) {
            this.f337318h[i3].a(obj, obj2);
            if (obj != null && obj2 == null) {
                this.f337315e.removeMessages(2, obj);
            }
        }
    }

    private void a(int i3, Object obj, Object obj2, long j3) {
        synchronized (this.f337313c) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j16 = j3 + uptimeMillis;
            this.f337318h[i3].a(j16, obj, obj2);
            if (j16 <= uptimeMillis) {
                a(uptimeMillis);
            } else {
                Message obtainMessage = this.f337315e.obtainMessage(2, obj);
                obtainMessage.arg1 = i3;
                this.f337315e.sendMessageAtTime(obtainMessage, j16);
            }
        }
    }

    private void a(long j3) {
        if (this.f337319i) {
            return;
        }
        this.f337319i = true;
        long max = Math.max((this.f337320j / 1000000) + 10, j3);
        this.f337315e.sendMessageAtTime(this.f337315e.obtainMessage(0), max);
    }

    void a(long j3, int i3) {
        synchronized (this.f337313c) {
            if (this.f337319i) {
                long nanoTime = System.nanoTime();
                long j16 = nanoTime - j3;
                long j17 = this.f337321k;
                if (j16 >= j17) {
                    long j18 = j16 / j17;
                    if (j18 >= 30) {
                        Log.i("Choreographer", "Skipped " + j18 + " frames!  The application may be doing too much work on its main thread.");
                    }
                    j3 = nanoTime - (j16 % this.f337321k);
                }
                if (j3 < this.f337320j) {
                    d();
                    return;
                }
                this.f337319i = false;
                this.f337320j = j3;
                a(0, j3);
                a(1, j3);
                a(2, j3);
            }
        }
    }

    public void a(e.a aVar) {
        a(aVar, 0L);
    }

    public void a(e.a aVar, long j3) {
        if (aVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        a(1, aVar, f337311a, j3);
    }

    void a(b bVar) {
        bVar.f337326c = null;
        bVar.f337327d = null;
        bVar.f337324a = this.f337317g;
        this.f337317g = bVar;
    }
}
