package com.tencent.luggage.wxa.o0;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.WindowManager;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final a f136008a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f136009b;

    /* renamed from: c, reason: collision with root package name */
    public final long f136010c;

    /* renamed from: d, reason: collision with root package name */
    public final long f136011d;

    /* renamed from: e, reason: collision with root package name */
    public long f136012e;

    /* renamed from: f, reason: collision with root package name */
    public long f136013f;

    /* renamed from: g, reason: collision with root package name */
    public long f136014g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f136015h;

    /* renamed from: i, reason: collision with root package name */
    public long f136016i;

    /* renamed from: j, reason: collision with root package name */
    public long f136017j;

    /* renamed from: k, reason: collision with root package name */
    public long f136018k;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Choreographer.FrameCallback, Handler.Callback {

        /* renamed from: f, reason: collision with root package name */
        public static final a f136019f = new a();

        /* renamed from: a, reason: collision with root package name */
        public volatile long f136020a;

        /* renamed from: b, reason: collision with root package name */
        public final Handler f136021b;

        /* renamed from: c, reason: collision with root package name */
        public final HandlerThread f136022c;

        /* renamed from: d, reason: collision with root package name */
        public Choreographer f136023d;

        /* renamed from: e, reason: collision with root package name */
        public int f136024e;

        public a() {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("ChoreographerOwner:Handler");
            this.f136022c = baseHandlerThread;
            baseHandlerThread.start();
            Handler handler = new Handler(baseHandlerThread.getLooper(), this);
            this.f136021b = handler;
            handler.sendEmptyMessage(0);
        }

        public static a d() {
            return f136019f;
        }

        public void a() {
            this.f136021b.sendEmptyMessage(1);
        }

        public final void b() {
            int i3 = this.f136024e + 1;
            this.f136024e = i3;
            if (i3 == 1) {
                this.f136023d.postFrameCallback(this);
            }
        }

        public final void c() {
            this.f136023d = Choreographer.getInstance();
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j3) {
            this.f136020a = j3;
            this.f136023d.postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.f136021b.sendEmptyMessage(2);
        }

        public final void f() {
            int i3 = this.f136024e - 1;
            this.f136024e = i3;
            if (i3 == 0) {
                this.f136023d.removeFrameCallback(this);
                this.f136020a = 0L;
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return false;
                    }
                    f();
                    return true;
                }
                b();
                return true;
            }
            c();
            return true;
        }
    }

    public f(Context context) {
        this(a(context));
    }

    public void a() {
        if (this.f136009b) {
            this.f136008a.e();
        }
    }

    public void b() {
        this.f136015h = false;
        if (this.f136009b) {
            this.f136008a.a();
        }
    }

    public f(double d16) {
        boolean z16 = d16 != -1.0d;
        this.f136009b = z16;
        if (z16) {
            this.f136008a = a.d();
            long j3 = (long) (1.0E9d / d16);
            this.f136010c = j3;
            this.f136011d = (j3 * 80) / 100;
            return;
        }
        this.f136008a = null;
        this.f136010c = -1L;
        this.f136011d = -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(long j3, long j16) {
        long j17;
        long j18;
        long j19 = 1000 * j3;
        if (this.f136015h) {
            if (j3 != this.f136012e) {
                this.f136018k++;
                this.f136013f = this.f136014g;
            }
            long j26 = this.f136018k;
            if (j26 >= 6) {
                j18 = this.f136013f + ((j19 - this.f136017j) / j26);
                if (b(j18, j16)) {
                    this.f136015h = false;
                } else {
                    j17 = (this.f136016i + j18) - this.f136017j;
                    if (!this.f136015h) {
                        this.f136017j = j19;
                        this.f136016i = j16;
                        this.f136018k = 0L;
                        this.f136015h = true;
                        c();
                    }
                    this.f136012e = j3;
                    this.f136014g = j18;
                    a aVar = this.f136008a;
                    return (aVar != null || aVar.f136020a == 0) ? j17 : a(j17, this.f136008a.f136020a, this.f136010c) - this.f136011d;
                }
            } else if (b(j19, j16)) {
                this.f136015h = false;
            }
        }
        j17 = j16;
        j18 = j19;
        if (!this.f136015h) {
        }
        this.f136012e = j3;
        this.f136014g = j18;
        a aVar2 = this.f136008a;
        if (aVar2 != null) {
        }
    }

    public final boolean b(long j3, long j16) {
        return Math.abs((j16 - this.f136016i) - (j3 - this.f136017j)) > 20000000;
    }

    public void c() {
    }

    public static long a(long j3, long j16, long j17) {
        long j18;
        long j19 = j16 + (((j3 - j16) / j17) * j17);
        if (j3 <= j19) {
            j18 = j19 - j17;
        } else {
            j19 = j17 + j19;
            j18 = j19;
        }
        return j19 - j3 < j3 - j18 ? j19 : j18;
    }

    public static double a(Context context) {
        if (((WindowManager) context.getSystemService("window")).getDefaultDisplay() != null) {
            return r2.getDefaultDisplay().getRefreshRate();
        }
        return -1.0d;
    }
}
