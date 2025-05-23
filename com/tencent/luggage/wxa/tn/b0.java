package com.tencent.luggage.wxa.tn;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b0 implements com.tencent.luggage.wxa.dq.a {

    /* renamed from: d, reason: collision with root package name */
    public static final Handler f141526d = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    public volatile Message f141527a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.dq.a f141528b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f141529c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f141531a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f141532b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, Handler.Callback callback, long j3, d dVar) {
            super(looper, callback);
            this.f141531a = j3;
            this.f141532b = dVar;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            b0.this.f141527a = message;
            b0.this.c(message);
            try {
                Runnable callback = message.getCallback();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("MMHandler.msg(what=");
                sb5.append(message.what);
                sb5.append(", cb=");
                if (callback != null) {
                    str = com.tencent.luggage.wxa.so.h.a(com.tencent.luggage.wxa.tn.a.a(), callback.getClass().getSimpleName());
                } else {
                    str = "null";
                }
                sb5.append(str);
                sb5.append(")");
                com.tencent.luggage.wxa.so.h.a(sb5.toString());
                super.dispatchMessage(message);
                com.tencent.luggage.wxa.so.h.a();
                b0.this.b(message);
                b0.this.f141527a = null;
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                Thread currentThread = Thread.currentThread();
                if (this.f141531a == currentThread.getId()) {
                    if (currentTimeMillis2 < 300) {
                        return;
                    }
                } else if (currentTimeMillis2 < 5000) {
                    return;
                }
                w.h("Handler#Monitor", "This msg handle so slow[%sms]! runnable=%s callback=%s thread=%s", Long.valueOf(currentTimeMillis2), message.getCallback(), this.f141532b, currentThread.getName());
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.so.h.a();
                throw th5;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b0.this.d(message);
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j3) {
            b0.this.b(message, j3);
            return super.sendMessageAtTime(message, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends com.tencent.luggage.wxa.kq.c {

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ long f141534h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ d f141535i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.tencent.luggage.wxa.kq.a aVar, Handler.Callback callback, long j3, d dVar) {
            super(aVar, callback);
            this.f141534h = j3;
            this.f141535i = dVar;
        }

        @Override // com.tencent.luggage.wxa.kq.c
        public void c(Message message) {
            long currentTimeMillis = System.currentTimeMillis();
            b0.this.f141527a = message;
            super.c(message);
            b0.this.f141527a = null;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            Thread currentThread = Thread.currentThread();
            if (this.f141534h == currentThread.getId()) {
                if (currentTimeMillis2 < 300) {
                    return;
                }
            } else if (currentTimeMillis2 < 5000) {
                return;
            }
            w.h("Handler#Monitor", "This msg handle so slow[%sms]! runnable=%s callback=%s thread=%s", Long.valueOf(currentTimeMillis2), message.getCallback(), this.f141535i, currentThread.getName());
        }

        @Override // com.tencent.luggage.wxa.kq.c
        public void e(Message message) {
            b0.this.d(message);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d extends Handler.Callback {
    }

    public b0() {
        this.f141529c = new Object();
        this.f141528b = a(Looper.myLooper(), com.tencent.luggage.wxa.kq.a.d(), null);
    }

    public void b(Message message) {
    }

    public void c(Message message) {
    }

    public void d(Message message) {
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean e() {
        boolean e16;
        synchronized (this.f141529c) {
            e16 = this.f141528b.e();
            this.f141529c.notifyAll();
        }
        return e16;
    }

    public String toString() {
        return this.f141528b.toString();
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public Message a(int i3, Object obj) {
        return this.f141528b.a(i3, obj);
    }

    public void b(Message message, long j3) {
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean c(Runnable runnable) {
        return this.f141528b.c(runnable);
    }

    public final boolean d(Runnable runnable) {
        return this.f141528b.a(runnable);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public Message a(int i3, int i16, int i17, Object obj) {
        return this.f141528b.a(i3, i16, i17, obj);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void b(Runnable runnable) {
        this.f141528b.b(runnable);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void c(int i3) {
        this.f141528b.c(i3);
    }

    public b0(Looper looper) {
        this.f141529c = new Object();
        Objects.requireNonNull(looper);
        this.f141528b = a(looper, null, null);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(Runnable runnable) {
        return this.f141528b.a(runnable);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean b(int i3) {
        return this.f141528b.b(i3);
    }

    public boolean c() {
        this.f141528b.a((Runnable) new a());
        return true;
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(Runnable runnable, long j3) {
        return this.f141528b.a(runnable, j3);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void b(int i3, Object obj) {
        this.f141528b.b(i3, obj);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(Message message) {
        return this.f141528b.a(message);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public String b() {
        return this.f141528b.b();
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(int i3, long j3) {
        return this.f141528b.a(i3, j3);
    }

    public b0(String str) {
        this.f141529c = new Object();
        this.f141528b = a(null, com.tencent.luggage.wxa.kq.a.a(str), null);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(Message message, long j3) {
        return this.f141528b.a(message, j3);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void a(Object obj) {
        this.f141528b.a(obj);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public boolean a(int i3) {
        return this.f141528b.a(i3);
    }

    public b0(com.tencent.luggage.wxa.kq.a aVar) {
        this.f141529c = new Object();
        Objects.requireNonNull(aVar);
        this.f141528b = a(null, aVar, null);
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public Looper a() {
        return this.f141528b.a();
    }

    @Override // com.tencent.luggage.wxa.dq.a
    public void a(Printer printer, String str) {
        this.f141528b.a(printer, str);
    }

    public void a(boolean z16) {
        com.tencent.luggage.wxa.dq.a aVar = this.f141528b;
        if (aVar instanceof com.tencent.luggage.wxa.kq.c) {
            ((com.tencent.luggage.wxa.kq.c) aVar).a(z16);
        }
    }

    public b0(com.tencent.luggage.wxa.kq.a aVar, d dVar) {
        this.f141529c = new Object();
        Objects.requireNonNull(aVar);
        this.f141528b = a(null, aVar, dVar);
    }

    public static Handler a(Looper looper) {
        return new Handler(looper);
    }

    public final com.tencent.luggage.wxa.dq.a a(Looper looper, com.tencent.luggage.wxa.kq.a aVar, d dVar) {
        if (looper == Looper.getMainLooper() || aVar == com.tencent.luggage.wxa.kq.a.a()) {
            return a(Looper.getMainLooper(), dVar);
        }
        if (aVar != null) {
            return a(aVar, dVar);
        }
        if (looper != null) {
            return a(looper, dVar);
        }
        throw new RuntimeException("looper and serial is null!");
    }

    public final com.tencent.luggage.wxa.dq.a a(Looper looper, d dVar) {
        return com.tencent.luggage.wxa.dq.b.a((Handler) new b(looper, dVar, Looper.getMainLooper().getThread().getId(), dVar));
    }

    public final com.tencent.luggage.wxa.dq.a a(com.tencent.luggage.wxa.kq.a aVar, d dVar) {
        return new c(aVar, dVar, Looper.getMainLooper().getThread().getId(), dVar);
    }
}
