package com.tencent.luggage.wxa.l1;

import android.os.HandlerThread;
import com.tencent.luggage.wxa.k.u;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i {

    /* renamed from: c, reason: collision with root package name */
    public b0 f132953c;

    /* renamed from: f, reason: collision with root package name */
    public int f132956f;

    /* renamed from: g, reason: collision with root package name */
    public int f132957g;

    /* renamed from: h, reason: collision with root package name */
    public int f132958h;

    /* renamed from: a, reason: collision with root package name */
    public final String f132951a = "MicroMsg.YUVDateRenderToRBGBufferThread";

    /* renamed from: b, reason: collision with root package name */
    public HandlerThread f132952b = com.tencent.luggage.wxa.cq.d.d("YUVDateRenderToRBGBufferThread", 5);

    /* renamed from: d, reason: collision with root package name */
    public c f132954d = null;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f132955e = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    public boolean f132959i = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f132960a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f132961b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f132962c;

        public a(byte[] bArr, int i3, int i16) {
            this.f132960a = bArr;
            this.f132961b = i3;
            this.f132962c = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] a16;
            if (i.this.f132954d != null && !i.this.f132955e.get()) {
                i.this.f132955e.compareAndSet(false, true);
                long a17 = w0.a();
                byte[] a18 = u.a(this.f132960a, this.f132961b, this.f132962c, i.this.f132956f);
                if (i.this.f132956f != 90 && i.this.f132956f != 270) {
                    a16 = u.a(a18, this.f132961b, this.f132962c, i.this.f132957g, i.this.f132958h);
                } else {
                    a16 = u.a(a18, this.f132962c, this.f132961b, i.this.f132957g, i.this.f132958h);
                }
                if (a16 == null) {
                    i.this.f132955e.compareAndSet(true, false);
                    return;
                }
                ByteBuffer a19 = i.this.f132954d.a();
                a19.position(0);
                a19.put(a16);
                i.this.f132954d.b();
                w.d("MicroMsg.YUVDateRenderToRBGBufferThread", "cost time: %d ms", Long.valueOf(w0.e(a17)));
                i.this.f132955e.compareAndSet(true, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.f132953c.a((Object) null);
            i.this.f132952b.quitSafely();
            i.this.f132955e.compareAndSet(true, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        ByteBuffer a();

        void b();
    }

    public void a(byte[] bArr, int i3, int i16, int i17) {
        if (this.f132959i) {
            a(new a(bArr, i3, i16));
        }
    }

    public void b() {
        w.a("MicroMsg.YUVDateRenderToRBGBufferThread", "hasStart : " + this.f132959i);
        if (this.f132959i) {
            return;
        }
        this.f132959i = true;
        this.f132952b.start();
        this.f132953c = new b0(this.f132952b.getLooper());
    }

    public void a(c cVar) {
        this.f132954d = cVar;
    }

    public void a(int i3, int i16, int i17) {
        w.d("MicroMsg.YUVDateRenderToRBGBufferThread", "setFrameInfo rotate: %s ,targetWidth:%d ,targetHeight:%d , this: %s ", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), this);
        if (i3 != this.f132956f) {
            this.f132956f = i3;
        }
        this.f132957g = i16;
        this.f132958h = i17;
    }

    public final void a(Runnable runnable) {
        if (!this.f132952b.isAlive() || this.f132955e.get()) {
            return;
        }
        this.f132953c.a(runnable);
    }

    public void a() {
        a(new b());
    }
}
