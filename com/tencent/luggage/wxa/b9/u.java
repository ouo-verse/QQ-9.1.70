package com.tencent.luggage.wxa.b9;

import com.eclipsesource.mmv8.MultiContextV8;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public final MultiContextV8 f122343a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b9.d f122344b;

    /* renamed from: c, reason: collision with root package name */
    public Future f122345c;

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f122346d = new d();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u.this.f122343a == null) {
                com.tencent.luggage.wxa.tn.w.f("V8DebuggerHelper", "V8DebuggerHelper v8 null\uff0cmultiThread problem!");
            } else {
                u.this.f122343a.debugDestroy();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f122348a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f122349b;

        public b(String str, boolean z16) {
            this.f122348a = str;
            this.f122349b = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u.this.f122343a != null) {
                u.this.f122343a.waitForDebugger(this.f122348a, this.f122349b);
                u.this.b();
                return;
            }
            throw new IllegalStateException("V8DebuggerHelper v8 null");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u.this.f122345c != null) {
                u.this.f122345c.cancel(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u.this.f122343a.debuggerMessageLoop();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u.this.f122344b.a(u.this.f122346d);
        }
    }

    public u(MultiContextV8 multiContextV8, com.tencent.luggage.wxa.b9.d dVar) {
        this.f122343a = multiContextV8;
        this.f122344b = dVar;
    }

    public void a() {
        this.f122344b.b(new a());
    }

    public final void b() {
        if (this.f122345c != null) {
            return;
        }
        this.f122345c = com.tencent.luggage.wxa.zp.h.f146825d.a(new e(), 2000L, 2000L);
    }

    public void a(String str, boolean z16) {
        this.f122344b.a(new b(str, z16));
        this.f122344b.c(new c());
    }
}
