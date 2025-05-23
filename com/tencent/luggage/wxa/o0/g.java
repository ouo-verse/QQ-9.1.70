package com.tencent.luggage.wxa.o0;

import android.os.Handler;
import android.view.Surface;
import com.tencent.luggage.wxa.m.j;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface g {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f136025a;

        /* renamed from: b, reason: collision with root package name */
        public final g f136026b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.o0.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6522a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.o.c f136027a;

            public RunnableC6522a(com.tencent.luggage.wxa.o.c cVar) {
                this.f136027a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f136026b.b(this.f136027a);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f136029a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f136030b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f136031c;

            public b(String str, long j3, long j16) {
                this.f136029a = str;
                this.f136030b = j3;
                this.f136031c = j16;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f136026b.a(this.f136029a, this.f136030b, this.f136031c);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f136033a;

            public c(j jVar) {
                this.f136033a = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f136026b.a(this.f136033a);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f136035a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f136036b;

            public d(int i3, long j3) {
                this.f136035a = i3;
                this.f136036b = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f136026b.a(this.f136035a, this.f136036b);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class e implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f136038a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f136039b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f136040c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ float f136041d;

            public e(int i3, int i16, int i17, float f16) {
                this.f136038a = i3;
                this.f136039b = i16;
                this.f136040c = i17;
                this.f136041d = f16;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f136026b.a(this.f136038a, this.f136039b, this.f136040c, this.f136041d);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class f implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Surface f136043a;

            public f(Surface surface) {
                this.f136043a = surface;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f136026b.a(this.f136043a);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.o0.g$a$g, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6523g implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.o.c f136045a;

            public RunnableC6523g(com.tencent.luggage.wxa.o.c cVar) {
                this.f136045a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f136045a.a();
                a.this.f136026b.d(this.f136045a);
            }
        }

        public a(Handler handler, g gVar) {
            Handler handler2;
            if (gVar != null) {
                handler2 = (Handler) com.tencent.luggage.wxa.n0.a.a(handler);
            } else {
                handler2 = null;
            }
            this.f136025a = handler2;
            this.f136026b = gVar;
        }

        public void b(com.tencent.luggage.wxa.o.c cVar) {
            if (this.f136026b != null) {
                this.f136025a.post(new RunnableC6522a(cVar));
            }
        }

        public void a(String str, long j3, long j16) {
            if (this.f136026b != null) {
                this.f136025a.post(new b(str, j3, j16));
            }
        }

        public void a(j jVar) {
            if (this.f136026b != null) {
                this.f136025a.post(new c(jVar));
            }
        }

        public void a(int i3, long j3) {
            if (this.f136026b != null) {
                this.f136025a.post(new d(i3, j3));
            }
        }

        public void a(int i3, int i16, int i17, float f16) {
            if (this.f136026b != null) {
                this.f136025a.post(new e(i3, i16, i17, f16));
            }
        }

        public void a(Surface surface) {
            if (this.f136026b != null) {
                this.f136025a.post(new f(surface));
            }
        }

        public void a(com.tencent.luggage.wxa.o.c cVar) {
            if (this.f136026b != null) {
                this.f136025a.post(new RunnableC6523g(cVar));
            }
        }
    }

    void a(int i3, int i16, int i17, float f16);

    void a(int i3, long j3);

    void a(Surface surface);

    void a(j jVar);

    void a(String str, long j3, long j16);

    void b(com.tencent.luggage.wxa.o.c cVar);

    void d(com.tencent.luggage.wxa.o.c cVar);
}
