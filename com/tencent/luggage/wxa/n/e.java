package com.tencent.luggage.wxa.n;

import android.os.Handler;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface e {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f134913a;

        /* renamed from: b, reason: collision with root package name */
        public final e f134914b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.n.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6490a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.o.c f134915a;

            public RunnableC6490a(com.tencent.luggage.wxa.o.c cVar) {
                this.f134915a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f134914b.a(this.f134915a);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f134917a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f134918b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f134919c;

            public b(String str, long j3, long j16) {
                this.f134917a = str;
                this.f134918b = j3;
                this.f134919c = j16;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f134914b.b(this.f134917a, this.f134918b, this.f134919c);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.m.j f134921a;

            public c(com.tencent.luggage.wxa.m.j jVar) {
                this.f134921a = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f134914b.b(this.f134921a);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f134923a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f134924b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f134925c;

            public d(int i3, long j3, long j16) {
                this.f134923a = i3;
                this.f134924b = j3;
                this.f134925c = j16;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f134914b.a(this.f134923a, this.f134924b, this.f134925c);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.n.e$a$e, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6491e implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.o.c f134927a;

            public RunnableC6491e(com.tencent.luggage.wxa.o.c cVar) {
                this.f134927a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f134927a.a();
                a.this.f134914b.c(this.f134927a);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class f implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f134929a;

            public f(int i3) {
                this.f134929a = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f134914b.a(this.f134929a);
            }
        }

        public a(Handler handler, e eVar) {
            Handler handler2;
            if (eVar != null) {
                handler2 = (Handler) com.tencent.luggage.wxa.n0.a.a(handler);
            } else {
                handler2 = null;
            }
            this.f134913a = handler2;
            this.f134914b = eVar;
        }

        public void b(com.tencent.luggage.wxa.o.c cVar) {
            if (this.f134914b != null) {
                this.f134913a.post(new RunnableC6490a(cVar));
            }
        }

        public void a(String str, long j3, long j16) {
            if (this.f134914b != null) {
                this.f134913a.post(new b(str, j3, j16));
            }
        }

        public void a(com.tencent.luggage.wxa.m.j jVar) {
            if (this.f134914b != null) {
                this.f134913a.post(new c(jVar));
            }
        }

        public void a(int i3, long j3, long j16) {
            if (this.f134914b != null) {
                this.f134913a.post(new d(i3, j3, j16));
            }
        }

        public void a(com.tencent.luggage.wxa.o.c cVar) {
            if (this.f134914b != null) {
                this.f134913a.post(new RunnableC6491e(cVar));
            }
        }

        public void a(int i3) {
            if (this.f134914b != null) {
                this.f134913a.post(new f(i3));
            }
        }
    }

    void a(int i3);

    void a(int i3, long j3, long j16);

    void a(com.tencent.luggage.wxa.o.c cVar);

    void b(com.tencent.luggage.wxa.m.j jVar);

    void b(String str, long j3, long j16);

    void c(com.tencent.luggage.wxa.o.c cVar);
}
