package com.tencent.luggage.wxa.lp;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.luggage.wxa.lp.b;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static final e f133765b;

    /* renamed from: a, reason: collision with root package name */
    public Context f133766a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.lp.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6450a implements e {
        public static d b(b.d dVar) {
            if (dVar == null) {
                return null;
            }
            if (dVar.a() != null) {
                return new d(dVar.a());
            }
            if (dVar.c() != null) {
                return new d(dVar.c());
            }
            if (dVar.b() != null) {
                return new d(dVar.b());
            }
            return null;
        }

        @Override // com.tencent.luggage.wxa.lp.a.e
        public boolean a(Context context) {
            return com.tencent.luggage.wxa.lp.b.b(context);
        }

        @Override // com.tencent.luggage.wxa.lp.a.e
        public void a(Context context, d dVar, int i3, CancellationSignal cancellationSignal, b bVar, Handler handler) {
            com.tencent.luggage.wxa.lp.b.a(context, a(dVar), i3, cancellationSignal, a(context, bVar), handler);
        }

        public static boolean b(b.AbstractC6452b abstractC6452b, Context context) {
            if (com.tencent.luggage.wxa.lp.c.a()) {
                com.tencent.luggage.wxa.np.e.d("Soter.FingerprintManagerCompat", "soter: using system anti brute force strategy", new Object[0]);
                return false;
            }
            if (com.tencent.luggage.wxa.lp.c.h(context)) {
                if (!com.tencent.luggage.wxa.lp.c.g(context)) {
                    com.tencent.luggage.wxa.np.e.d("Soter.FingerprintManagerCompat", "soter: unfreeze former frozen status", new Object[0]);
                    com.tencent.luggage.wxa.lp.c.i(context);
                }
                return false;
            }
            if (com.tencent.luggage.wxa.lp.c.g(context)) {
                com.tencent.luggage.wxa.np.e.d("Soter.FingerprintManagerCompat", "soter: failure time available", new Object[0]);
                return false;
            }
            b(abstractC6452b);
            return true;
        }

        public static b.d a(d dVar) {
            if (dVar == null) {
                return null;
            }
            if (dVar.a() != null) {
                return new b.d(dVar.a());
            }
            if (dVar.c() != null) {
                return new b.d(dVar.c());
            }
            if (dVar.b() != null) {
                return new b.d(dVar.b());
            }
            return null;
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.lp.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6451a extends b.AbstractC6452b {

            /* renamed from: a, reason: collision with root package name */
            public boolean f133767a = false;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f133768b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Context f133769c;

            public C6451a(b bVar, Context context) {
                this.f133768b = bVar;
                this.f133769c = context;
            }

            @Override // com.tencent.luggage.wxa.lp.b.AbstractC6452b
            public void a(int i3, CharSequence charSequence) {
                com.tencent.luggage.wxa.np.e.a("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationError", new Object[0]);
                if (this.f133767a) {
                    return;
                }
                this.f133767a = true;
                if (i3 == 5) {
                    com.tencent.luggage.wxa.np.e.c("Soter.FingerprintManagerCompat", "soter: user cancelled fingerprint authen", new Object[0]);
                    this.f133768b.a();
                } else {
                    if (i3 == 7) {
                        com.tencent.luggage.wxa.np.e.c("Soter.FingerprintManagerCompat", "soter: system call too many trial.", new Object[0]);
                        if (!com.tencent.luggage.wxa.lp.c.g(this.f133769c) && !com.tencent.luggage.wxa.lp.c.h(this.f133769c) && !com.tencent.luggage.wxa.lp.c.a()) {
                            com.tencent.luggage.wxa.lp.c.b(this.f133769c);
                        }
                        this.f133767a = false;
                        a(10308, "Too many failed times");
                        return;
                    }
                    this.f133768b.a(i3, charSequence);
                }
            }

            @Override // com.tencent.luggage.wxa.lp.b.AbstractC6452b
            public void b(int i3, CharSequence charSequence) {
                com.tencent.luggage.wxa.np.e.a("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationHelp", new Object[0]);
                if (!this.f133767a && !C6450a.b(this, this.f133769c)) {
                    this.f133768b.b(i3, charSequence);
                }
            }

            @Override // com.tencent.luggage.wxa.lp.b.AbstractC6452b
            public void a(b.c cVar) {
                com.tencent.luggage.wxa.np.e.a("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationSucceeded", new Object[0]);
                if (this.f133767a || C6450a.b(this, this.f133769c)) {
                    return;
                }
                if (!com.tencent.luggage.wxa.lp.c.a()) {
                    com.tencent.luggage.wxa.lp.c.i(this.f133769c);
                }
                this.f133767a = true;
                this.f133768b.a(new c(C6450a.b(cVar.a())));
            }

            @Override // com.tencent.luggage.wxa.lp.b.AbstractC6452b
            public void a() {
                com.tencent.luggage.wxa.np.e.a("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationFailed", new Object[0]);
                if (this.f133767a || C6450a.b(this, this.f133769c)) {
                    return;
                }
                if (!com.tencent.luggage.wxa.lp.c.a()) {
                    com.tencent.luggage.wxa.lp.c.a(this.f133769c);
                    if (!com.tencent.luggage.wxa.lp.c.g(this.f133769c)) {
                        com.tencent.luggage.wxa.np.e.e("Soter.FingerprintManagerCompat", "soter: too many fail trials", new Object[0]);
                        com.tencent.luggage.wxa.lp.c.b(this.f133769c);
                        C6450a.b(this);
                        return;
                    }
                }
                this.f133768b.b();
            }
        }

        public static b.AbstractC6452b a(Context context, b bVar) {
            return new C6451a(bVar, context);
        }

        public static void b(b.AbstractC6452b abstractC6452b) {
            com.tencent.luggage.wxa.np.e.e("Soter.FingerprintManagerCompat", "soter: too many fail fingerprint callback. inform it.", new Object[0]);
            abstractC6452b.a(10308, "Too many failed times");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public d f133770a;

        public c(d dVar) {
            this.f133770a = dVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e {
        void a(Context context, d dVar, int i3, CancellationSignal cancellationSignal, b bVar, Handler handler);

        boolean a(Context context);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class f implements e {
        @Override // com.tencent.luggage.wxa.lp.a.e
        public void a(Context context, d dVar, int i3, CancellationSignal cancellationSignal, b bVar, Handler handler) {
        }

        @Override // com.tencent.luggage.wxa.lp.a.e
        public boolean a(Context context) {
            return false;
        }
    }

    static {
        if (com.tencent.luggage.wxa.jp.a.h()) {
            f133765b = new C6450a();
        } else {
            f133765b = new f();
        }
    }

    public a(Context context) {
        this.f133766a = context;
    }

    public static a a(Context context) {
        return new a(context);
    }

    public boolean a() {
        return f133765b.a(this.f133766a);
    }

    public void a(d dVar, int i3, CancellationSignal cancellationSignal, b bVar, Handler handler) {
        f133765b.a(this.f133766a, dVar, i3, cancellationSignal, bVar, handler);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final Signature f133771a;

        /* renamed from: b, reason: collision with root package name */
        public final Cipher f133772b;

        /* renamed from: c, reason: collision with root package name */
        public final Mac f133773c;

        public d(Signature signature) {
            this.f133771a = signature;
            this.f133772b = null;
            this.f133773c = null;
        }

        public Cipher a() {
            return this.f133772b;
        }

        public Mac b() {
            return this.f133773c;
        }

        public Signature c() {
            return this.f133771a;
        }

        public d(Cipher cipher) {
            this.f133772b = cipher;
            this.f133771a = null;
            this.f133773c = null;
        }

        public d(Mac mac) {
            this.f133773c = mac;
            this.f133772b = null;
            this.f133771a = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class b {
        public abstract void a(int i3, CharSequence charSequence);

        public abstract void a(c cVar);

        public abstract void b(int i3, CharSequence charSequence);

        public void a() {
        }

        public void b() {
        }
    }
}
