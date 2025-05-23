package com.tencent.luggage.wxa.mp;

import android.security.keystore.KeyGenParameterSpec;
import com.tencent.luggage.wxa.np.e;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.mp.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6487a extends a {
        public C6487a(String str, int i3) {
            super(str, i3);
        }

        @Override // com.tencent.luggage.wxa.mp.a
        public a a(boolean z16) {
            return null;
        }

        @Override // com.tencent.luggage.wxa.mp.a
        public a b(String... strArr) {
            return null;
        }

        @Override // com.tencent.luggage.wxa.mp.a
        public a c(String... strArr) {
            return null;
        }

        @Override // com.tencent.luggage.wxa.mp.a
        public AlgorithmParameterSpec a() {
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends a {

        /* renamed from: a, reason: collision with root package name */
        public KeyGenParameterSpec.Builder f134858a;

        public b(String str, int i3) {
            super(str, i3);
            this.f134858a = null;
            this.f134858a = new KeyGenParameterSpec.Builder(str, i3);
        }

        @Override // com.tencent.luggage.wxa.mp.a
        public AlgorithmParameterSpec a() {
            return this.f134858a.build();
        }

        @Override // com.tencent.luggage.wxa.mp.a
        public a b(String... strArr) {
            this.f134858a.setDigests(strArr);
            return this;
        }

        @Override // com.tencent.luggage.wxa.mp.a
        public a c(String... strArr) {
            this.f134858a.setSignaturePaddings(strArr);
            return this;
        }

        @Override // com.tencent.luggage.wxa.mp.a
        public a a(boolean z16) {
            this.f134858a.setUserAuthenticationRequired(z16);
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c extends a {

        /* renamed from: a, reason: collision with root package name */
        public final String f134859a;

        /* renamed from: b, reason: collision with root package name */
        public int f134860b;

        /* renamed from: c, reason: collision with root package name */
        public int f134861c;

        /* renamed from: d, reason: collision with root package name */
        public AlgorithmParameterSpec f134862d;

        /* renamed from: e, reason: collision with root package name */
        public X500Principal f134863e;

        /* renamed from: f, reason: collision with root package name */
        public BigInteger f134864f;

        /* renamed from: g, reason: collision with root package name */
        public Date f134865g;

        /* renamed from: h, reason: collision with root package name */
        public Date f134866h;

        /* renamed from: i, reason: collision with root package name */
        public Date f134867i;

        /* renamed from: j, reason: collision with root package name */
        public Date f134868j;

        /* renamed from: k, reason: collision with root package name */
        public Date f134869k;

        /* renamed from: l, reason: collision with root package name */
        public String[] f134870l;

        /* renamed from: m, reason: collision with root package name */
        public String[] f134871m;

        /* renamed from: n, reason: collision with root package name */
        public String[] f134872n;

        /* renamed from: o, reason: collision with root package name */
        public String[] f134873o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f134874p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f134875q;

        /* renamed from: r, reason: collision with root package name */
        public int f134876r;

        public c(String str, int i3) {
            super(str, i3);
            this.f134861c = -1;
            this.f134874p = true;
            this.f134876r = -1;
            if (str != null) {
                if (!str.isEmpty()) {
                    this.f134859a = str;
                    this.f134860b = i3;
                    return;
                }
                throw new IllegalArgumentException("keystoreAlias must not be empty");
            }
            throw new NullPointerException("keystoreAlias == null");
        }

        @Override // com.tencent.luggage.wxa.mp.a
        public a a(boolean z16) {
            this.f134875q = z16;
            return this;
        }

        @Override // com.tencent.luggage.wxa.mp.a
        public a b(String... strArr) {
            this.f134870l = a.a(strArr);
            return this;
        }

        @Override // com.tencent.luggage.wxa.mp.a
        public a c(String... strArr) {
            this.f134872n = a.a(strArr);
            return this;
        }

        @Override // com.tencent.luggage.wxa.mp.a
        public AlgorithmParameterSpec a() {
            Class<?> cls = Class.forName("android.security.keystore.KeyGenParameterSpec");
            Class<?> cls2 = Integer.TYPE;
            Class<?> cls3 = Boolean.TYPE;
            return (AlgorithmParameterSpec) cls.getConstructor(String.class, cls2, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, cls2, String[].class, String[].class, String[].class, String[].class, cls3, cls3, cls2).newInstance(this.f134859a, Integer.valueOf(this.f134861c), this.f134862d, this.f134863e, this.f134864f, this.f134865g, this.f134866h, this.f134867i, this.f134868j, this.f134869k, Integer.valueOf(this.f134860b), this.f134870l, this.f134871m, this.f134872n, this.f134873o, Boolean.valueOf(this.f134874p), Boolean.valueOf(this.f134875q), Integer.valueOf(this.f134876r));
        }
    }

    public a(String str, int i3) {
    }

    public static a a(String str, int i3) {
        if (com.tencent.luggage.wxa.jp.a.h()) {
            return new b(str, i3);
        }
        e.b("Soter.KeyGenParameterSpecCompatBuilder", "soter: not support soter. return dummy", new Object[0]);
        return new C6487a(str, i3);
    }

    public abstract a a(boolean z16);

    public abstract AlgorithmParameterSpec a();

    public abstract a b(String... strArr);

    public abstract a c(String... strArr);

    public static String[] a(String[] strArr) {
        return (strArr == null || strArr.length <= 0) ? strArr : (String[]) strArr.clone();
    }
}
