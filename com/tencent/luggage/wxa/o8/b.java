package com.tencent.luggage.wxa.o8;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseLongArray;
import com.tencent.luggage.wxa.w8.h;
import com.tencent.magicbrush.MBRuntime;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final MBRuntime f136206a;

    /* renamed from: d, reason: collision with root package name */
    public Handler f136209d;

    /* renamed from: f, reason: collision with root package name */
    public int f136211f;

    /* renamed from: g, reason: collision with root package name */
    public int f136212g;

    /* renamed from: h, reason: collision with root package name */
    public float f136213h;

    /* renamed from: j, reason: collision with root package name */
    public float f136215j;

    /* renamed from: l, reason: collision with root package name */
    public int f136217l;

    /* renamed from: m, reason: collision with root package name */
    public int f136218m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f136219n;

    /* renamed from: b, reason: collision with root package name */
    public SparseLongArray f136207b = new SparseLongArray();

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.o8.a f136208c = new com.tencent.luggage.wxa.o8.a();

    /* renamed from: e, reason: collision with root package name */
    public final c f136210e = new c();

    /* renamed from: i, reason: collision with root package name */
    public Queue f136214i = new LinkedList();

    /* renamed from: o, reason: collision with root package name */
    public C6537b f136220o = new C6537b();

    /* renamed from: p, reason: collision with root package name */
    public C6537b f136221p = new C6537b();

    /* renamed from: k, reason: collision with root package name */
    public boolean f136216k = false;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.o8.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6537b {

        /* renamed from: a, reason: collision with root package name */
        public int f136222a;

        /* renamed from: b, reason: collision with root package name */
        public int f136223b;

        /* renamed from: c, reason: collision with root package name */
        public int f136224c;

        /* renamed from: d, reason: collision with root package name */
        public int f136225d;

        /* renamed from: e, reason: collision with root package name */
        public float f136226e;

        /* renamed from: f, reason: collision with root package name */
        public int f136227f;

        /* renamed from: g, reason: collision with root package name */
        public int f136228g;

        public C6537b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b();
            Handler handler = b.this.f136209d;
            if (handler != null) {
                handler.postDelayed(b.this.f136210e, 1000L);
            }
        }
    }

    public b(MBRuntime mBRuntime) {
        this.f136206a = mBRuntime;
    }

    public C6537b c() {
        C6537b c6537b;
        synchronized (this.f136206a) {
            c6537b = this.f136221p;
            C6537b c6537b2 = this.f136220o;
            c6537b.f136223b = c6537b2.f136223b;
            c6537b.f136222a = c6537b2.f136222a;
            c6537b.f136224c = c6537b2.f136224c;
            c6537b.f136225d = c6537b2.f136225d;
            c6537b.f136226e = c6537b2.f136227f / c6537b2.f136228g;
            c6537b2.f136223b = 0;
            c6537b2.f136222a = 0;
            c6537b2.f136224c = 0;
            c6537b2.f136225d = 0;
            c6537b2.f136227f = 0;
            c6537b2.f136228g = 0;
        }
        return c6537b;
    }

    public com.tencent.luggage.wxa.o8.a d() {
        com.tencent.luggage.wxa.o8.a aVar;
        synchronized (this.f136206a) {
            aVar = this.f136208c;
        }
        return aVar;
    }

    public float e() {
        synchronized (this.f136206a) {
            if (this.f136206a.f147291a == 0) {
                return -1.0f;
            }
            MBRuntime mBRuntime = this.f136206a;
            return mBRuntime.nativeGetCurrentFpsVariance(mBRuntime.f147291a);
        }
    }

    public int f() {
        synchronized (this.f136206a) {
            if (this.f136206a.f147291a == 0) {
                return 0;
            }
            MBRuntime mBRuntime = this.f136206a;
            return mBRuntime.nativeGetDrawCalls(mBRuntime.f147291a);
        }
    }

    public int g() {
        synchronized (this.f136206a) {
            if (this.f136206a.f147291a == 0) {
                return -1;
            }
            MBRuntime mBRuntime = this.f136206a;
            return mBRuntime.nativeGetFrameCounter(mBRuntime.f147291a);
        }
    }

    public int h() {
        synchronized (this.f136206a) {
            if (this.f136206a.f147291a == 0) {
                return 0;
            }
            MBRuntime mBRuntime = this.f136206a;
            return mBRuntime.nativeGetTriangles(mBRuntime.f147291a);
        }
    }

    public int i() {
        synchronized (this.f136206a) {
            if (this.f136206a.f147291a == 0) {
                return 0;
            }
            MBRuntime mBRuntime = this.f136206a;
            return mBRuntime.nativeGetVertexes(mBRuntime.f147291a);
        }
    }

    public void j() {
        if (this.f136209d == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            this.f136209d = handler;
            handler.post(this.f136210e);
        }
    }

    public int k() {
        int g16 = g();
        this.f136207b.put(g16, h.a());
        return g16;
    }

    public void l() {
        Handler handler = this.f136209d;
        if (handler != null) {
            handler.removeCallbacks(this.f136210e);
            this.f136209d = null;
        }
    }

    public float a(int i3) {
        return ((g() - i3) * 1000.0f) / ((float) h.a(this.f136207b.get(i3)));
    }

    public void b() {
        a();
    }

    public final void a() {
        synchronized (this.f136206a) {
            if (this.f136206a.f147291a == 0) {
                return;
            }
            MBRuntime mBRuntime = this.f136206a;
            float[] nativeGetCurrentFps = mBRuntime.nativeGetCurrentFps(mBRuntime.f147291a);
            com.tencent.luggage.wxa.o8.a aVar = this.f136208c;
            float f16 = nativeGetCurrentFps[0];
            aVar.f136199a = f16;
            aVar.f136200b = nativeGetCurrentFps[1];
            int i3 = (int) nativeGetCurrentFps[2];
            aVar.f136201c = i3;
            int i16 = (int) nativeGetCurrentFps[3];
            aVar.f136202d = i16;
            aVar.f136203e = nativeGetCurrentFps[4];
            int i17 = (int) nativeGetCurrentFps[5];
            aVar.f136204f = i17;
            int i18 = (int) nativeGetCurrentFps[6];
            aVar.f136205g = i18;
            C6537b c6537b = this.f136220o;
            c6537b.f136224c += i3;
            c6537b.f136225d += i16;
            c6537b.f136227f += i17;
            c6537b.f136228g += i18;
            if (this.f136216k) {
                int i19 = this.f136217l + 1;
                this.f136217l = i19;
                if (i19 > this.f136218m) {
                    this.f136217l = 1;
                    if (this.f136219n) {
                        c6537b.f136223b = 0;
                        c6537b.f136222a = 0;
                    }
                }
                if (f16 < this.f136213h) {
                    c6537b.f136223b++;
                }
                int size = this.f136214i.size();
                int i26 = this.f136211f;
                if (size >= i26 && i26 > 0) {
                    float f17 = (this.f136208c.f136199a * i26) + this.f136212g;
                    float f18 = this.f136215j;
                    if (f17 < f18) {
                        this.f136220o.f136222a++;
                    }
                    this.f136215j = f18 - ((Float) this.f136214i.remove()).floatValue();
                }
                this.f136214i.add(Float.valueOf(this.f136208c.f136199a));
                this.f136215j += this.f136208c.f136199a;
            }
        }
    }
}
