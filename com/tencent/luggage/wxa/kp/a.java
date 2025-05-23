package com.tencent.luggage.wxa.kp;

import android.content.Context;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.luggage.wxa.kp.c;
import com.tencent.luggage.wxa.kp.d;
import com.tencent.soter.core.biometric.FaceidManagerProxy;
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static final Map f132677c;

    /* renamed from: a, reason: collision with root package name */
    public Context f132678a;

    /* renamed from: b, reason: collision with root package name */
    public Integer f132679b;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kp.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static abstract class AbstractC6403a {
        public abstract void a();

        public abstract void a(int i3, CharSequence charSequence);

        public abstract void a(b bVar);

        public abstract void b();

        public abstract void b(int i3, CharSequence charSequence);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public c f132680a;

        public b(c cVar) {
            this.f132680a = cVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d implements f {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.kp.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6404a extends c.a {

            /* renamed from: a, reason: collision with root package name */
            public boolean f132684a = false;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AbstractC6403a f132685b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Context f132686c;

            public C6404a(AbstractC6403a abstractC6403a, Context context) {
                this.f132685b = abstractC6403a;
                this.f132686c = context;
            }
        }

        @Override // com.tencent.luggage.wxa.kp.a.f
        public boolean a(Context context) {
            return com.tencent.luggage.wxa.kp.c.c(context);
        }

        @Override // com.tencent.luggage.wxa.kp.a.f
        public boolean b(Context context) {
            return com.tencent.luggage.wxa.kp.c.b(context);
        }

        @Override // com.tencent.luggage.wxa.kp.a.f
        public void a(Context context, c cVar, int i3, CancellationSignal cancellationSignal, AbstractC6403a abstractC6403a, Handler handler, Bundle bundle) {
            com.tencent.luggage.wxa.kp.c.a(context, a(cVar), i3, cancellationSignal, a(context, abstractC6403a), handler);
        }

        public static c.b a(c cVar) {
            if (cVar == null) {
                return null;
            }
            if (cVar.a() != null) {
                return new c.b(cVar.a());
            }
            if (cVar.c() != null) {
                return new c.b(cVar.c());
            }
            if (cVar.b() != null) {
                return new c.b(cVar.b());
            }
            return null;
        }

        public static c.a a(Context context, AbstractC6403a abstractC6403a) {
            return new C6404a(abstractC6403a, context);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class e implements f {
        @Override // com.tencent.luggage.wxa.kp.a.f
        public boolean b(Context context) {
            return com.tencent.luggage.wxa.kp.d.b(context);
        }

        public static c b(d.f fVar) {
            if (fVar == null) {
                return null;
            }
            if (fVar.a() != null) {
                return new c(fVar.a());
            }
            if (fVar.c() != null) {
                return new c(fVar.c());
            }
            if (fVar.b() != null) {
                return new c(fVar.b());
            }
            return null;
        }

        @Override // com.tencent.luggage.wxa.kp.a.f
        public boolean a(Context context) {
            return com.tencent.luggage.wxa.kp.d.c(context);
        }

        @Override // com.tencent.luggage.wxa.kp.a.f
        public void a(Context context, c cVar, int i3, CancellationSignal cancellationSignal, AbstractC6403a abstractC6403a, Handler handler, Bundle bundle) {
            com.tencent.luggage.wxa.kp.d.a(context, a(cVar), i3, cancellationSignal, a(context, abstractC6403a), handler, bundle);
        }

        public static d.f a(c cVar) {
            if (cVar == null) {
                return null;
            }
            if (cVar.a() != null) {
                return new d.f(cVar.a());
            }
            if (cVar.c() != null) {
                return new d.f(cVar.c());
            }
            if (cVar.b() != null) {
                return new d.f(cVar.b());
            }
            return null;
        }

        public static boolean b(d.AbstractC6406d abstractC6406d, Context context) {
            if (com.tencent.luggage.wxa.kp.e.a()) {
                com.tencent.luggage.wxa.np.e.d("Soter.BiometricManagerCompat.Fingerprint", "soter: using system anti brute force strategy", new Object[0]);
                return false;
            }
            if (com.tencent.luggage.wxa.kp.e.h(context)) {
                if (!com.tencent.luggage.wxa.kp.e.g(context)) {
                    com.tencent.luggage.wxa.np.e.d("Soter.BiometricManagerCompat.Fingerprint", "soter: unfreeze former frozen status", new Object[0]);
                    com.tencent.luggage.wxa.kp.e.i(context);
                }
                return false;
            }
            if (com.tencent.luggage.wxa.kp.e.g(context)) {
                com.tencent.luggage.wxa.np.e.d("Soter.BiometricManagerCompat.Fingerprint", "soter: failure time available", new Object[0]);
                return false;
            }
            b(abstractC6406d);
            return true;
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.kp.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6405a extends d.AbstractC6406d {

            /* renamed from: a, reason: collision with root package name */
            public boolean f132687a = false;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AbstractC6403a f132688b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Context f132689c;

            public C6405a(AbstractC6403a abstractC6403a, Context context) {
                this.f132688b = abstractC6403a;
                this.f132689c = context;
            }

            @Override // com.tencent.luggage.wxa.kp.d.AbstractC6406d
            public void a(int i3, CharSequence charSequence) {
                com.tencent.luggage.wxa.np.e.a("Soter.BiometricManagerCompat.Fingerprint", "soter: basic onAuthenticationError", new Object[0]);
                if (this.f132687a) {
                    return;
                }
                this.f132687a = true;
                if (i3 == 5 || i3 == 10) {
                    com.tencent.luggage.wxa.np.e.c("Soter.BiometricManagerCompat.Fingerprint", "soter: user cancelled fingerprint authen", new Object[0]);
                    this.f132688b.a();
                    return;
                }
                if (i3 != 7 && i3 != 9) {
                    this.f132688b.a(i3, charSequence);
                    return;
                }
                com.tencent.luggage.wxa.np.e.c("Soter.BiometricManagerCompat.Fingerprint", "soter: system call too many trial.", new Object[0]);
                if (!com.tencent.luggage.wxa.kp.e.g(this.f132689c) && !com.tencent.luggage.wxa.kp.e.h(this.f132689c) && !com.tencent.luggage.wxa.kp.e.a()) {
                    com.tencent.luggage.wxa.kp.e.b(this.f132689c);
                }
                this.f132687a = false;
                if (i3 == 7) {
                    a(10308, "Too many failed times");
                } else {
                    a(10309, "Too many failed times");
                }
            }

            @Override // com.tencent.luggage.wxa.kp.d.AbstractC6406d
            public void b(int i3, CharSequence charSequence) {
                com.tencent.luggage.wxa.np.e.a("Soter.BiometricManagerCompat.Fingerprint", "soter: basic onAuthenticationHelp", new Object[0]);
                if (!this.f132687a && !e.b(this, this.f132689c)) {
                    this.f132688b.b(i3, charSequence);
                }
            }

            @Override // com.tencent.luggage.wxa.kp.d.AbstractC6406d
            public void a(d.e eVar) {
                com.tencent.luggage.wxa.np.e.a("Soter.BiometricManagerCompat.Fingerprint", "soter: basic onAuthenticationSucceeded", new Object[0]);
                if (this.f132687a || e.b(this, this.f132689c)) {
                    return;
                }
                if (!com.tencent.luggage.wxa.kp.e.a()) {
                    com.tencent.luggage.wxa.kp.e.i(this.f132689c);
                }
                this.f132687a = true;
                this.f132688b.a(new b(e.b(eVar.a())));
            }

            @Override // com.tencent.luggage.wxa.kp.d.AbstractC6406d
            public void a() {
                com.tencent.luggage.wxa.np.e.a("Soter.BiometricManagerCompat.Fingerprint", "soter: basic onAuthenticationFailed", new Object[0]);
                if (this.f132687a || e.b(this, this.f132689c)) {
                    return;
                }
                if (!com.tencent.luggage.wxa.kp.e.a()) {
                    com.tencent.luggage.wxa.kp.e.a(this.f132689c);
                    if (!com.tencent.luggage.wxa.kp.e.g(this.f132689c)) {
                        com.tencent.luggage.wxa.np.e.e("Soter.BiometricManagerCompat.Fingerprint", "soter: too many fail trials", new Object[0]);
                        com.tencent.luggage.wxa.kp.e.b(this.f132689c);
                        e.b(this);
                        return;
                    }
                }
                this.f132688b.b();
            }
        }

        public static d.AbstractC6406d a(Context context, AbstractC6403a abstractC6403a) {
            return new C6405a(abstractC6403a, context);
        }

        public static void b(d.AbstractC6406d abstractC6406d) {
            com.tencent.luggage.wxa.np.e.e("Soter.BiometricManagerCompat.Fingerprint", "soter: too many fail fingerprint callback. inform it.", new Object[0]);
            abstractC6406d.a(10308, "Too many failed times");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface f {
        void a(Context context, c cVar, int i3, CancellationSignal cancellationSignal, AbstractC6403a abstractC6403a, Handler handler, Bundle bundle);

        boolean a(Context context);

        boolean b(Context context);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class g implements f {
        @Override // com.tencent.luggage.wxa.kp.a.f
        public void a(Context context, c cVar, int i3, CancellationSignal cancellationSignal, AbstractC6403a abstractC6403a, Handler handler, Bundle bundle) {
        }

        @Override // com.tencent.luggage.wxa.kp.a.f
        public boolean b(Context context) {
            return false;
        }

        @Override // com.tencent.luggage.wxa.kp.a.f
        public boolean a(Context context) {
            com.tencent.luggage.wxa.np.f.a(200, "LegacyFingerprintManagerImpl.isHardwareDetected return false");
            return false;
        }
    }

    static {
        f gVar;
        HashMap hashMap = new HashMap();
        f132677c = hashMap;
        if (com.tencent.luggage.wxa.jp.a.h()) {
            gVar = new e();
        } else {
            gVar = new g();
        }
        hashMap.put(1, gVar);
        if (com.tencent.luggage.wxa.jp.a.h() && d()) {
            hashMap.put(2, new d());
        }
    }

    public a(Context context, Integer num) {
        this.f132678a = context;
        this.f132679b = num;
    }

    public static a a(Context context, Integer num) {
        return new a(context, num);
    }

    public static boolean d() {
        try {
            Class.forName(FaceidManagerProxy.FACEMANAGER_FACTORY_CLASS_NAME);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean b() {
        return com.tencent.luggage.wxa.kp.e.g(this.f132678a);
    }

    public boolean c() {
        f fVar = (f) f132677c.get(this.f132679b);
        if (fVar == null) {
            com.tencent.luggage.wxa.np.e.c("Soter.BiometricManagerCompat", "soter: Biometric provider not initialized type[" + this.f132679b + "]", new Object[0]);
            return false;
        }
        return fVar.a(this.f132678a);
    }

    public boolean a() {
        f fVar = (f) f132677c.get(this.f132679b);
        if (fVar == null) {
            com.tencent.luggage.wxa.np.e.c("Soter.BiometricManagerCompat", "soter: Biometric provider not initialized type[" + this.f132679b + "]", new Object[0]);
            return false;
        }
        return fVar.b(this.f132678a);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final Signature f132681a;

        /* renamed from: b, reason: collision with root package name */
        public final Cipher f132682b;

        /* renamed from: c, reason: collision with root package name */
        public final Mac f132683c;

        public c(Signature signature) {
            this.f132681a = signature;
            this.f132682b = null;
            this.f132683c = null;
        }

        public Cipher a() {
            return this.f132682b;
        }

        public Mac b() {
            return this.f132683c;
        }

        public Signature c() {
            return this.f132681a;
        }

        public c(Cipher cipher) {
            this.f132682b = cipher;
            this.f132681a = null;
            this.f132683c = null;
        }

        public c(Mac mac) {
            this.f132683c = mac;
            this.f132682b = null;
            this.f132681a = null;
        }
    }

    public boolean a(Context context) {
        return com.tencent.luggage.wxa.kp.e.h(this.f132678a);
    }

    public void a(c cVar, int i3, CancellationSignal cancellationSignal, AbstractC6403a abstractC6403a, Handler handler, Bundle bundle) {
        f fVar = (f) f132677c.get(this.f132679b);
        if (fVar == null) {
            com.tencent.luggage.wxa.np.e.c("Soter.BiometricManagerCompat", "soter: Biometric provider not initialized type[" + this.f132679b + "]", new Object[0]);
            abstractC6403a.a();
        }
        fVar.a(this.f132678a, cVar, i3, cancellationSignal, abstractC6403a, handler, bundle);
    }
}
