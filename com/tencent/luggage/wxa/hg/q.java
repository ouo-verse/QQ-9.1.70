package com.tencent.luggage.wxa.hg;

import com.tencent.luggage.wxa.hg.b;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class q implements com.tencent.luggage.wxa.hg.b {

    /* renamed from: f, reason: collision with root package name */
    public static final a f127174f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final Object f127175g = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final String f127176a;

    /* renamed from: b, reason: collision with root package name */
    public final String f127177b;

    /* renamed from: c, reason: collision with root package name */
    public final String f127178c;

    /* renamed from: d, reason: collision with root package name */
    public final b.InterfaceC6263b f127179d;

    /* renamed from: e, reason: collision with root package name */
    public final b.a f127180e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public q a(String rootPath, String appId, String userId) {
            Intrinsics.checkNotNullParameter(rootPath, "rootPath");
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new q(rootPath, appId, userId, null);
        }
    }

    public /* synthetic */ q(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3);
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public void d(String desc, String pubKey, com.tencent.luggage.wxa.dr.g keyFormat) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(pubKey, "pubKey");
        Intrinsics.checkNotNullParameter(keyFormat, "keyFormat");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            com.tencent.luggage.wxa.dr.d.b(desc, pubKey, keyFormat);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public b.InterfaceC6263b e() {
        return this.f127179d;
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public void f(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            com.tencent.luggage.wxa.dr.d.f(desc);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public b.a g() {
        return this.f127180e;
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public void j(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            com.tencent.luggage.wxa.dr.d.e(desc);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public void k(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            com.tencent.luggage.wxa.dr.d.h(desc);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public byte[] l(String desc) {
        byte[] g16;
        Intrinsics.checkNotNullParameter(desc, "desc");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            g16 = com.tencent.luggage.wxa.dr.d.g(desc);
            if (g16 == null) {
                throw new com.tencent.luggage.wxa.dr.c(-60012);
            }
        }
        return g16;
    }

    public q(String str, String str2, String str3) {
        this.f127176a = str;
        this.f127177b = str2;
        this.f127178c = str3;
        this.f127179d = new c(this);
        this.f127180e = new b(this);
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public void b(String desc, byte[] key) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            com.tencent.luggage.wxa.dr.d.a(desc, key);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public boolean c(String desc) {
        boolean b16;
        Intrinsics.checkNotNullParameter(desc, "desc");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            b16 = com.tencent.luggage.wxa.dr.d.b(desc);
        }
        return b16;
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public boolean e(String desc) {
        boolean c16;
        Intrinsics.checkNotNullParameter(desc, "desc");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            c16 = com.tencent.luggage.wxa.dr.d.c(desc);
        }
        return c16;
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public void g(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            com.tencent.luggage.wxa.dr.d.d(desc);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public void a(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            com.tencent.luggage.wxa.dr.d.i(desc);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public void c(String desc, String priKey, com.tencent.luggage.wxa.dr.g keyFormat) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(priKey, "priKey");
        Intrinsics.checkNotNullParameter(keyFormat, "keyFormat");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            com.tencent.luggage.wxa.dr.d.c(desc, priKey, keyFormat);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public boolean d(String desc) {
        boolean a16;
        Intrinsics.checkNotNullParameter(desc, "desc");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            a16 = com.tencent.luggage.wxa.dr.d.a(desc);
        }
        return a16;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final q f127181a;

        public b(q smStorageImpl) {
            Intrinsics.checkNotNullParameter(smStorageImpl, "smStorageImpl");
            this.f127181a = smStorageImpl;
        }

        @Override // com.tencent.luggage.wxa.hg.b.a
        public byte[] a(String desc, byte[] cipher, com.tencent.luggage.wxa.dr.e cipherFormat) {
            byte[] a16;
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(cipher, "cipher");
            Intrinsics.checkNotNullParameter(cipherFormat, "cipherFormat");
            q qVar = this.f127181a;
            synchronized (q.f127175g) {
                com.tencent.luggage.wxa.dr.d.a(qVar.f127176a, qVar.f127177b, qVar.f127178c);
                a16 = com.tencent.luggage.wxa.dr.a.a(desc, cipher, cipherFormat);
            }
            Intrinsics.checkNotNullExpressionValue(a16, "smStorageImpl.invoke {\n \u2026, cipherFormat)\n        }");
            return a16;
        }

        @Override // com.tencent.luggage.wxa.hg.b.a
        public byte[] b(String desc, byte[] plain, com.tencent.luggage.wxa.dr.e cipherFormat) {
            byte[] b16;
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(plain, "plain");
            Intrinsics.checkNotNullParameter(cipherFormat, "cipherFormat");
            q qVar = this.f127181a;
            synchronized (q.f127175g) {
                com.tencent.luggage.wxa.dr.d.a(qVar.f127176a, qVar.f127177b, qVar.f127178c);
                b16 = com.tencent.luggage.wxa.dr.a.b(desc, plain, cipherFormat);
            }
            Intrinsics.checkNotNullExpressionValue(b16, "smStorageImpl.invoke {\n \u2026, cipherFormat)\n        }");
            return b16;
        }

        @Override // com.tencent.luggage.wxa.hg.b.a
        public byte[] a(String desc, byte[] msg2, String id5, com.tencent.luggage.wxa.dr.f signFormat) {
            byte[] a16;
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(signFormat, "signFormat");
            q qVar = this.f127181a;
            synchronized (q.f127175g) {
                com.tencent.luggage.wxa.dr.d.a(qVar.f127176a, qVar.f127177b, qVar.f127178c);
                a16 = com.tencent.luggage.wxa.dr.a.a(desc, msg2, id5, signFormat);
            }
            Intrinsics.checkNotNullExpressionValue(a16, "smStorageImpl.invoke {\n \u2026id, signFormat)\n        }");
            return a16;
        }

        @Override // com.tencent.luggage.wxa.hg.b.a
        public boolean a(String desc, byte[] msg2, String id5, byte[] sig, com.tencent.luggage.wxa.dr.f signFormat) {
            boolean a16;
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(sig, "sig");
            Intrinsics.checkNotNullParameter(signFormat, "signFormat");
            q qVar = this.f127181a;
            synchronized (q.f127175g) {
                com.tencent.luggage.wxa.dr.d.a(qVar.f127176a, qVar.f127177b, qVar.f127178c);
                a16 = com.tencent.luggage.wxa.dr.a.a(desc, msg2, id5, sig, signFormat);
            }
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements b.InterfaceC6263b {

        /* renamed from: a, reason: collision with root package name */
        public final q f127182a;

        public c(q smStorageImpl) {
            Intrinsics.checkNotNullParameter(smStorageImpl, "smStorageImpl");
            this.f127182a = smStorageImpl;
        }

        @Override // com.tencent.luggage.wxa.hg.b.InterfaceC6263b
        public byte[] a(String desc, byte[] plain) {
            byte[] b16;
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(plain, "plain");
            q qVar = this.f127182a;
            synchronized (q.f127175g) {
                com.tencent.luggage.wxa.dr.d.a(qVar.f127176a, qVar.f127177b, qVar.f127178c);
                b16 = com.tencent.luggage.wxa.dr.b.b(desc, plain);
            }
            Intrinsics.checkNotNullExpressionValue(b16, "smStorageImpl.invoke {\n \u2026pt(desc, plain)\n        }");
            return b16;
        }

        @Override // com.tencent.luggage.wxa.hg.b.InterfaceC6263b
        public byte[] b(String desc, byte[] cipher) {
            byte[] a16;
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(cipher, "cipher");
            q qVar = this.f127182a;
            synchronized (q.f127175g) {
                com.tencent.luggage.wxa.dr.d.a(qVar.f127176a, qVar.f127177b, qVar.f127178c);
                a16 = com.tencent.luggage.wxa.dr.b.a(desc, cipher);
            }
            Intrinsics.checkNotNullExpressionValue(a16, "smStorageImpl.invoke {\n \u2026t(desc, cipher)\n        }");
            return a16;
        }

        @Override // com.tencent.luggage.wxa.hg.b.InterfaceC6263b
        public byte[] c(String desc, byte[] cipher, byte[] iv5) {
            byte[] a16;
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(cipher, "cipher");
            Intrinsics.checkNotNullParameter(iv5, "iv");
            q qVar = this.f127182a;
            synchronized (q.f127175g) {
                com.tencent.luggage.wxa.dr.d.a(qVar.f127176a, qVar.f127177b, qVar.f127178c);
                a16 = com.tencent.luggage.wxa.dr.b.a(desc, cipher, iv5);
            }
            Intrinsics.checkNotNullExpressionValue(a16, "smStorageImpl.invoke {\n \u2026sc, cipher, iv)\n        }");
            return a16;
        }

        @Override // com.tencent.luggage.wxa.hg.b.InterfaceC6263b
        public byte[] d(String desc, byte[] plain, byte[] iv5) {
            byte[] b16;
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(plain, "plain");
            Intrinsics.checkNotNullParameter(iv5, "iv");
            q qVar = this.f127182a;
            synchronized (q.f127175g) {
                com.tencent.luggage.wxa.dr.d.a(qVar.f127176a, qVar.f127177b, qVar.f127178c);
                b16 = com.tencent.luggage.wxa.dr.b.b(desc, plain, iv5);
            }
            Intrinsics.checkNotNullExpressionValue(b16, "smStorageImpl.invoke {\n \u2026esc, plain, iv)\n        }");
            return b16;
        }

        @Override // com.tencent.luggage.wxa.hg.b.InterfaceC6263b
        public byte[] a(String desc, byte[] cipher, byte[] iv5) {
            byte[] c16;
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(cipher, "cipher");
            Intrinsics.checkNotNullParameter(iv5, "iv");
            q qVar = this.f127182a;
            synchronized (q.f127175g) {
                com.tencent.luggage.wxa.dr.d.a(qVar.f127176a, qVar.f127177b, qVar.f127178c);
                c16 = com.tencent.luggage.wxa.dr.b.c(desc, cipher, iv5);
            }
            Intrinsics.checkNotNullExpressionValue(c16, "smStorageImpl.invoke {\n \u2026sc, cipher, iv)\n        }");
            return c16;
        }

        @Override // com.tencent.luggage.wxa.hg.b.InterfaceC6263b
        public byte[] b(String desc, byte[] plain, byte[] iv5) {
            byte[] d16;
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(plain, "plain");
            Intrinsics.checkNotNullParameter(iv5, "iv");
            q qVar = this.f127182a;
            synchronized (q.f127175g) {
                com.tencent.luggage.wxa.dr.d.a(qVar.f127176a, qVar.f127177b, qVar.f127178c);
                d16 = com.tencent.luggage.wxa.dr.b.d(desc, plain, iv5);
            }
            Intrinsics.checkNotNullExpressionValue(d16, "smStorageImpl.invoke {\n \u2026esc, plain, iv)\n        }");
            return d16;
        }

        @Override // com.tencent.luggage.wxa.hg.b.InterfaceC6263b
        public byte[][] a(String desc, byte[] plain, byte[] iv5, byte[] aad) {
            byte[][] a16;
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(plain, "plain");
            Intrinsics.checkNotNullParameter(iv5, "iv");
            Intrinsics.checkNotNullParameter(aad, "aad");
            q qVar = this.f127182a;
            synchronized (q.f127175g) {
                com.tencent.luggage.wxa.dr.d.a(qVar.f127176a, qVar.f127177b, qVar.f127178c);
                a16 = com.tencent.luggage.wxa.dr.b.a(desc, plain, iv5, aad);
            }
            Intrinsics.checkNotNullExpressionValue(a16, "smStorageImpl.invoke {\n \u2026plain, iv, aad)\n        }");
            return a16;
        }

        @Override // com.tencent.luggage.wxa.hg.b.InterfaceC6263b
        public byte[] a(String desc, byte[] cipher, byte[] tag, byte[] iv5, byte[] aad) {
            byte[] a16;
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(cipher, "cipher");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(iv5, "iv");
            Intrinsics.checkNotNullParameter(aad, "aad");
            q qVar = this.f127182a;
            synchronized (q.f127175g) {
                com.tencent.luggage.wxa.dr.d.a(qVar.f127176a, qVar.f127177b, qVar.f127178c);
                a16 = com.tencent.luggage.wxa.dr.b.a(desc, cipher, tag, iv5, aad);
            }
            Intrinsics.checkNotNullExpressionValue(a16, "smStorageImpl.invoke {\n \u2026, tag, iv, aad)\n        }");
            return a16;
        }
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public String b(String desc, com.tencent.luggage.wxa.dr.g keyFormat) {
        String b16;
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(keyFormat, "keyFormat");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            b16 = com.tencent.luggage.wxa.dr.d.b(desc, keyFormat);
            if (b16 == null) {
                throw new com.tencent.luggage.wxa.dr.c(-60012);
            }
        }
        return b16;
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public void a(String desc, byte[] key) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            com.tencent.luggage.wxa.dr.d.b(desc, key);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public void a(String desc, String priKey, com.tencent.luggage.wxa.dr.g keyFormat) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(priKey, "priKey");
        Intrinsics.checkNotNullParameter(keyFormat, "keyFormat");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            com.tencent.luggage.wxa.dr.d.a(desc, priKey, keyFormat);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public void b(String desc, String pubKey, com.tencent.luggage.wxa.dr.g keyFormat) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(pubKey, "pubKey");
        Intrinsics.checkNotNullParameter(keyFormat, "keyFormat");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            com.tencent.luggage.wxa.dr.d.d(desc, pubKey, keyFormat);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.hg.b
    public String[] a(String desc, com.tencent.luggage.wxa.dr.g keyFormat) {
        String[] a16;
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(keyFormat, "keyFormat");
        synchronized (f127175g) {
            com.tencent.luggage.wxa.dr.d.a(this.f127176a, this.f127177b, this.f127178c);
            a16 = com.tencent.luggage.wxa.dr.d.a(desc, keyFormat);
            if (a16 == null) {
                throw new com.tencent.luggage.wxa.dr.c(-60012);
            }
        }
        return a16;
    }
}
