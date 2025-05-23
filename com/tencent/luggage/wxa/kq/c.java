package com.tencent.luggage.wxa.kq;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import com.tencent.luggage.wxa.kq.d;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c implements com.tencent.luggage.wxa.dq.a {

    /* renamed from: a, reason: collision with root package name */
    public final Handler.Callback f132709a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f132710b;

    /* renamed from: c, reason: collision with root package name */
    public AtomicBoolean f132711c;

    /* renamed from: d, reason: collision with root package name */
    public final String f132712d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.kq.a f132713e;

    /* renamed from: f, reason: collision with root package name */
    public final Handler f132714f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.mq.b f132715g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            c.this.c(message);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c.this.e(message);
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j3) {
            message.setTarget(c.this.f132714f);
            return c.this.b(message, j3);
        }

        @Override // android.os.Handler
        public String toString() {
            return c.this.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements d.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f132717a;

        public b(Runnable runnable) {
            this.f132717a = runnable;
        }

        @Override // com.tencent.luggage.wxa.kq.d.b
        public boolean a(com.tencent.luggage.wxa.kq.e eVar) {
            Object c16 = eVar.c();
            boolean z16 = false;
            if (c16 instanceof h) {
                h hVar = (h) c16;
                if (hVar.f132732d == c.this && hVar.f132730b.getCallback() == this.f132717a) {
                    z16 = true;
                }
                if (z16) {
                    hVar.b();
                }
            }
            return z16;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kq.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6408c implements d.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f132719a;

        public C6408c(int i3) {
            this.f132719a = i3;
        }

        @Override // com.tencent.luggage.wxa.kq.d.b
        public boolean a(com.tencent.luggage.wxa.kq.e eVar) {
            Object c16 = eVar.c();
            boolean z16 = false;
            if (c16 instanceof h) {
                h hVar = (h) c16;
                if (hVar.f132732d == c.this && hVar.f132730b.what == this.f132719a) {
                    z16 = true;
                }
                if (z16) {
                    hVar.b();
                }
            }
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements d.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f132721a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f132722b;

        public d(int i3, Object obj) {
            this.f132721a = i3;
            this.f132722b = obj;
        }

        @Override // com.tencent.luggage.wxa.kq.d.b
        public boolean a(com.tencent.luggage.wxa.kq.e eVar) {
            Object c16 = eVar.c();
            boolean z16 = false;
            if (c16 instanceof h) {
                h hVar = (h) c16;
                if (hVar.f132732d == c.this && hVar.f132730b.what == this.f132721a && hVar.f132730b.obj == this.f132722b) {
                    z16 = true;
                }
                if (z16) {
                    hVar.b();
                }
            }
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements d.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f132724a;

        public e(Object obj) {
            this.f132724a = obj;
        }

        @Override // com.tencent.luggage.wxa.kq.d.b
        public boolean a(com.tencent.luggage.wxa.kq.e eVar) {
            Object c16 = eVar.c();
            boolean z16 = false;
            if (c16 instanceof h) {
                h hVar = (h) c16;
                if (hVar.f132732d == c.this && (this.f132724a == null || hVar.f132730b.obj == this.f132724a)) {
                    z16 = true;
                }
                if (z16) {
                    hVar.b();
                }
            }
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements d.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f132726a;

        public f(int i3) {
            this.f132726a = i3;
        }

        @Override // com.tencent.luggage.wxa.kq.d.a
        public boolean a(com.tencent.luggage.wxa.kq.e eVar) {
            Object c16 = eVar.c();
            if (!(c16 instanceof h)) {
                return false;
            }
            h hVar = (h) c16;
            if (hVar.f132732d != c.this || hVar.f132730b.what != this.f132726a) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements d.b {
        public g() {
        }

        @Override // com.tencent.luggage.wxa.kq.d.b
        public boolean a(com.tencent.luggage.wxa.kq.e eVar) {
            Object c16 = eVar.c();
            boolean z16 = false;
            if (c16 instanceof h) {
                h hVar = (h) c16;
                if (hVar.f132732d == c.this) {
                    z16 = true;
                }
                if (z16) {
                    hVar.b();
                }
            }
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.e, com.tencent.luggage.wxa.jq.d {

        /* renamed from: a, reason: collision with root package name */
        public Future f132729a;

        /* renamed from: b, reason: collision with root package name */
        public Message f132730b;

        /* renamed from: c, reason: collision with root package name */
        public String f132731c;

        /* renamed from: d, reason: collision with root package name */
        public Object f132732d;

        public h(Message message) {
            if (message != null) {
                this.f132730b = message;
                this.f132731c = c.this.f132712d + "#" + c.this.d(message);
                this.f132732d = c.this;
                return;
            }
            throw new NullPointerException("msg is null");
        }

        public boolean b() {
            c.this.f(this.f132730b);
            return this.f132729a.cancel(false);
        }

        @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return this.f132731c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f132711c.get()) {
                this.f132729a.cancel(false);
                com.tencent.luggage.wxa.zp.d.f146814c.w("SerialHandler", String.format("this handler has quit! %s", this.f132731c), new Object[0]);
                return;
            }
            if (this.f132730b.getTarget() == null) {
                Message message = this.f132730b;
                if (message.obj == null && message.what == 0) {
                    this.f132729a.cancel(false);
                    com.tencent.luggage.wxa.zp.d.f146814c.w("SerialHandler", String.format("maybe it's removed before! %s", this.f132731c), new Object[0]);
                    return;
                }
            }
            Handler target = this.f132730b.getTarget();
            Objects.requireNonNull(target, "target is null!");
            target.dispatchMessage(this.f132730b);
            c.this.f(this.f132730b);
        }

        @Override // com.tencent.luggage.wxa.jq.d
        public void a(Future future) {
            this.f132729a = future;
        }

        @Override // com.tencent.luggage.wxa.jq.e
        public boolean a() {
            return c.this.f132710b;
        }
    }

    public c(com.tencent.luggage.wxa.kq.a aVar) {
        this(aVar, null);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public Looper a() {
        return null;
    }

    public void e(Message message) {
    }

    public final void f(Message message) {
        if (message == null) {
            return;
        }
        try {
            this.f132715g.a(message, new Object[0]);
        } catch (Exception e16) {
            throw new RuntimeException(e16);
        }
    }

    public String toString() {
        return String.format("SerialHandler(%s) %s", b(), getClass().getName());
    }

    public c(com.tencent.luggage.wxa.kq.a aVar, Handler.Callback callback) {
        this.f132710b = true;
        this.f132711c = new AtomicBoolean();
        a aVar2 = new a(Looper.getMainLooper());
        this.f132714f = aVar2;
        this.f132715g = new com.tencent.luggage.wxa.mq.b(Message.class, "recycleUnchecked", new Class[0]);
        Objects.requireNonNull(aVar);
        this.f132713e = aVar;
        this.f132712d = aVar.c();
        this.f132709a = callback;
        try {
            com.tencent.luggage.wxa.mq.c.a(Handler.class, "mLooper", aVar2, null);
        } catch (Exception e16) {
            throw new RuntimeException(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public String b() {
        return this.f132712d;
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean c(Runnable runnable) {
        Handler handler = this.f132714f;
        return handler.sendMessageAtTime(Message.obtain(handler, runnable), Long.MIN_VALUE);
    }

    public String d(Message message) {
        return this.f132714f.getMessageName(message);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean e() {
        if (!this.f132711c.compareAndSet(false, true)) {
            return false;
        }
        c();
        return true;
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean b(int i3) {
        return this.f132714f.sendEmptyMessage(i3);
    }

    public void c(Message message) {
        if (message.getCallback() != null) {
            message.getCallback().run();
            return;
        }
        Handler.Callback callback = this.f132709a;
        if (callback == null || !callback.handleMessage(message)) {
            e(message);
        }
    }

    public boolean d() {
        return this.f132711c.get();
    }

    public void a(boolean z16) {
        this.f132710b = z16;
    }

    public boolean b(Message message, long j3) {
        h b16 = b(message);
        if (d()) {
            com.tencent.luggage.wxa.zp.d.f146812a.a(b16.getKey(), 0, this.f132712d, true);
            return false;
        }
        if (com.tencent.luggage.wxa.zp.h.f146825d.isShutdown()) {
            com.tencent.luggage.wxa.zp.d.f146812a.a(b16.getKey(), 0, this.f132712d, true);
            return false;
        }
        if (j3 == Long.MIN_VALUE) {
            if (com.tencent.luggage.wxa.kq.a.a() == this.f132713e) {
                com.tencent.luggage.wxa.zp.h.f146825d.e(b16);
            } else {
                com.tencent.luggage.wxa.zp.h.f146825d.c(b16, this.f132712d);
            }
        } else {
            long uptimeMillis = j3 - SystemClock.uptimeMillis();
            if (com.tencent.luggage.wxa.kq.a.a() == this.f132713e) {
                com.tencent.luggage.wxa.zp.h.f146825d.c(b16, uptimeMillis);
            } else {
                com.tencent.luggage.wxa.zp.h.f146825d.a(b16, uptimeMillis, this.f132712d);
            }
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public Message a(int i3, Object obj) {
        return this.f132714f.obtainMessage(i3, obj);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public Message a(int i3, int i16, int i17, Object obj) {
        return this.f132714f.obtainMessage(i3, i16, i17, obj);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(Runnable runnable) {
        return this.f132714f.post(runnable);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(Runnable runnable, long j3) {
        return this.f132714f.postDelayed(runnable, j3);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void c(int i3) {
        this.f132713e.b().a(new C6408c(i3));
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(Message message) {
        return this.f132714f.sendMessage(message);
    }

    public final void c() {
        this.f132713e.b().a(new g());
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(int i3, long j3) {
        return this.f132714f.sendEmptyMessageDelayed(i3, j3);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(Message message, long j3) {
        return this.f132714f.sendMessageDelayed(message, j3);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void a(Object obj) {
        this.f132713e.b().a(new e(obj));
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(int i3) {
        return this.f132713e.b().a(new f(i3));
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void a(Printer printer, String str) {
        printer.println(str + this.f132713e.b().c().toString());
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void b(Runnable runnable) {
        this.f132713e.b().a(new b(runnable));
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void b(int i3, Object obj) {
        this.f132713e.b().a(new d(i3, obj));
    }

    public h b(Message message) {
        return new h(message);
    }
}
