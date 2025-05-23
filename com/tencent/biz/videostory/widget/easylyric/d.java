package com.tencent.biz.videostory.widget.easylyric;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    protected c f97211a;

    /* renamed from: c, reason: collision with root package name */
    private int f97213c = -1;

    /* renamed from: b, reason: collision with root package name */
    private b f97212b = new b(this, Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f97214a;

        public a(long j3) {
            this.f97214a = j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<d> f97215a;

        public b(d dVar, Looper looper) {
            super(looper);
            this.f97215a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            a aVar = null;
            if (this.f97215a.get() != null) {
                dVar = this.f97215a.get();
            } else {
                dVar = null;
            }
            Object obj = message.obj;
            if (obj != null && (obj instanceof a)) {
                aVar = (a) obj;
            }
            int i3 = message.what;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            if (i3 == 7 && dVar != null && aVar != null) {
                                this.f97215a.get().g(aVar.f97214a);
                            }
                        } else if (dVar != null && aVar != null) {
                            this.f97215a.get().e(aVar.f97214a);
                        }
                    } else if (dVar != null && aVar != null) {
                        this.f97215a.get().f();
                    }
                } else if (dVar != null && aVar != null) {
                    this.f97215a.get().c();
                }
            } else if (dVar != null && aVar != null) {
                this.f97215a.get().d();
            }
            super.handleMessage(message);
        }
    }

    public void a(c cVar) {
        this.f97211a = cVar;
    }

    public void b() {
        this.f97212b.removeCallbacks(null);
        this.f97211a = null;
    }

    protected void c() {
        i(4);
    }

    protected void d() {
        i(3);
    }

    protected void e(long j3) {
        i(3);
        c cVar = this.f97211a;
        if (cVar != null) {
            cVar.a(j3);
        }
    }

    protected void f() {
        i(5);
    }

    protected void g(long j3) {
        c cVar = this.f97211a;
        if (cVar != null) {
            cVar.a(j3);
        }
    }

    public void h() {
        Message obtain = Message.obtain(this.f97212b);
        obtain.what = 2;
        obtain.sendToTarget();
    }

    protected void i(int i3) {
        this.f97213c = i3;
    }

    public void j() {
        Message obtain = Message.obtain(this.f97212b);
        obtain.what = 4;
        obtain.sendToTarget();
    }

    public void k(long j3) {
        Message obtain = Message.obtain(this.f97212b);
        obtain.what = 7;
        obtain.obj = new a(j3);
        obtain.sendToTarget();
    }
}
