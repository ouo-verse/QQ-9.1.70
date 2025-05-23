package com.tencent.luggage.wxa.vp;

import com.tencent.luggage.wxa.np.e;
import com.tencent.luggage.wxa.np.h;
import com.tencent.luggage.wxa.np.i;
import com.tencent.luggage.wxa.sp.c;
import com.tencent.luggage.wxa.xp.g;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f143718a;

    /* renamed from: b, reason: collision with root package name */
    public String f143719b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f143720c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f143721d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.vp.a f143722e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f143723f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c a16 = b.this.a();
            if (!a16.c()) {
                b.this.a(a16);
                return;
            }
            if (!com.tencent.luggage.wxa.jp.a.h()) {
                e.e("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
                b.this.a(new c(2));
                return;
            }
            if ((b.this.f143718a & 1) == 1) {
                e.a("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
                if (b.this.f143720c && com.tencent.luggage.wxa.jp.a.f()) {
                    e.a("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
                    h i3 = com.tencent.luggage.wxa.jp.a.i();
                    if (!i3.c()) {
                        e.e("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", i3.f135897b);
                        b.this.a(i3);
                        return;
                    }
                }
                h a17 = com.tencent.luggage.wxa.jp.a.a();
                if (!a17.c()) {
                    e.e("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", a17.f135897b);
                    com.tencent.luggage.wxa.jp.a.i();
                    b.this.a(a17);
                    return;
                }
                e.c("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
                b.this.a(a17);
            }
            if ((b.this.f143718a & 2) == 2) {
                e.a("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", b.this.f143719b);
                if (!com.tencent.luggage.wxa.jp.a.g()) {
                    e.e("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
                    b.this.a(new c(3, "ASK not exists when generate auth key"));
                    return;
                }
                if (b.this.f143721d && com.tencent.luggage.wxa.jp.a.d(b.this.f143719b)) {
                    e.a("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
                    h b16 = com.tencent.luggage.wxa.jp.a.b(b.this.f143719b, false);
                    if (!b16.c()) {
                        e.e("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", b.this.f143719b, b16.f135897b);
                        b.this.a(b16);
                        return;
                    }
                }
                h a18 = com.tencent.luggage.wxa.jp.a.a(b.this.f143719b);
                if (!a18.c()) {
                    e.e("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", b.this.f143719b, a18.f135897b);
                    com.tencent.luggage.wxa.jp.a.b(b.this.f143719b, true);
                    b.this.a(a18);
                } else {
                    e.c("Soter.SoterKeyGenerateEngine", "soter: generate auth key success!", new Object[0]);
                    b.this.a(a18);
                }
            }
        }
    }

    public /* synthetic */ b(int i3, String str, boolean z16, boolean z17, com.tencent.luggage.wxa.vp.a aVar, a aVar2) {
        this(i3, str, z16, z17, aVar);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.vp.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6856b {

        /* renamed from: a, reason: collision with root package name */
        public int f143725a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f143726b = "";

        /* renamed from: c, reason: collision with root package name */
        public boolean f143727c = false;

        /* renamed from: d, reason: collision with root package name */
        public boolean f143728d = false;

        /* renamed from: e, reason: collision with root package name */
        public com.tencent.luggage.wxa.vp.a f143729e = null;

        public C6856b a(boolean z16) {
            this.f143725a |= 1;
            this.f143727c = z16;
            return this;
        }

        public C6856b a(String str, boolean z16) {
            this.f143726b = str;
            this.f143728d = z16;
            this.f143725a |= 2;
            return this;
        }

        public C6856b a(com.tencent.luggage.wxa.vp.a aVar) {
            this.f143729e = aVar;
            return this;
        }

        public b a() {
            return new b(this.f143725a, this.f143726b, this.f143727c, this.f143728d, this.f143729e, null);
        }
    }

    public b(int i3, String str, boolean z16, boolean z17, com.tencent.luggage.wxa.vp.a aVar) {
        this.f143723f = false;
        this.f143718a = i3;
        this.f143719b = str;
        this.f143720c = z16;
        this.f143721d = z17;
        this.f143722e = aVar;
    }

    public void b() {
        g.a().b(new a());
    }

    public final c a() {
        int i3 = this.f143718a;
        if ((i3 & 1) != 1) {
            if ((i3 & 2) == 2) {
                if (i.a(this.f143719b)) {
                    e.b("Soter.SoterKeyGenerateEngine", "soter: not pass auth key name", new Object[0]);
                    return new c(1, "auth key name not specified");
                }
            } else {
                e.b("Soter.SoterKeyGenerateEngine", "soter: not specified purpose", new Object[0]);
                return new c(1001, "not specified purpose. did you for get to call markGenAppSecureKey or/and markGenAuthKey?");
            }
        }
        return new c(0);
    }

    public final void a(h hVar) {
        com.tencent.luggage.wxa.vp.a aVar = this.f143722e;
        if (aVar != null && !this.f143723f) {
            if (hVar != null) {
                if (hVar.c()) {
                    this.f143722e.onSuccess();
                } else {
                    this.f143722e.a(hVar.f135896a, hVar.f135897b);
                }
            } else {
                aVar.a(-1, "unknown");
            }
        }
        this.f143723f = true;
    }
}
