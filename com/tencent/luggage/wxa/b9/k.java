package com.tencent.luggage.wxa.b9;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.eclipsesource.mmv8.V8ScriptException;
import com.tencent.luggage.wxa.b9.e;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k implements e {

    /* renamed from: b, reason: collision with root package name */
    public final Looper f122238b;

    /* renamed from: c, reason: collision with root package name */
    public final a f122239c;

    /* renamed from: a, reason: collision with root package name */
    public e.a f122237a = null;

    /* renamed from: d, reason: collision with root package name */
    public r f122240d = new r();

    /* renamed from: e, reason: collision with root package name */
    public Runnable f122241e = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (V8ScriptException e16) {
                k.this.a(e16);
            }
            if (k.this.f122240d.f122273a) {
                k.this.f122240d.f122274b.pollFirst();
            }
        }
    }

    public k(Looper looper) {
        this.f122238b = looper;
        this.f122239c = new a(looper);
    }

    public static e g() {
        Looper.prepare();
        return new k(Looper.myLooper());
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void a() {
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void b() {
        com.tencent.luggage.wxa.tn.w.b("resumeLoopTasks", "should not to be here");
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public boolean c() {
        com.tencent.luggage.wxa.tn.w.b("doInnerLoopTask", "should not to be here");
        return true;
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public String d() {
        return (String) this.f122240d.f122274b.peek();
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void e() {
        this.f122238b.quitSafely();
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void f() {
        Looper.loop();
        Runnable runnable = this.f122241e;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public boolean i() {
        if (this.f122238b.getThread().getId() == Thread.currentThread().getId()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void a(Runnable runnable, boolean z16) {
        if (runnable == null) {
            return;
        }
        if (Thread.currentThread().getId() == this.f122238b.getThread().getId()) {
            try {
                runnable.run();
            } catch (V8ScriptException e16) {
                a(e16);
            }
            if (this.f122240d.f122273a) {
                this.f122240d.f122274b.remove(null);
                return;
            }
            return;
        }
        this.f122239c.post(runnable);
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void a(Runnable runnable, long j3, boolean z16) {
        this.f122239c.post(runnable);
    }

    public final void a(V8ScriptException v8ScriptException) {
        e.a aVar = this.f122237a;
        if (aVar != null) {
            aVar.a(v8ScriptException);
        }
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void a(e.a aVar) {
        this.f122237a = aVar;
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void a(Runnable runnable) {
        this.f122241e = runnable;
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void pause() {
    }
}
