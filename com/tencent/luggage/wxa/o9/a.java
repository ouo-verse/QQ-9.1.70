package com.tencent.luggage.wxa.o9;

import com.tencent.luggage.wxa.o9.b;
import com.tencent.luggage.wxa.qi.g;
import com.tencent.luggage.wxa.ri.d;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.o9.b f136234a;

    /* renamed from: b, reason: collision with root package name */
    public d f136235b;

    /* renamed from: c, reason: collision with root package name */
    public d.a f136236c = new C6538a();

    /* renamed from: d, reason: collision with root package name */
    public b.InterfaceC6539b f136237d = new b();

    /* renamed from: e, reason: collision with root package name */
    public Object f136238e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public final int f136239f;

    /* renamed from: g, reason: collision with root package name */
    public final int f136240g;

    /* renamed from: h, reason: collision with root package name */
    public final int f136241h;

    /* renamed from: i, reason: collision with root package name */
    public final double f136242i;

    /* renamed from: j, reason: collision with root package name */
    public String f136243j;

    /* renamed from: k, reason: collision with root package name */
    public String f136244k;

    /* renamed from: l, reason: collision with root package name */
    public c f136245l;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.o9.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6538a implements d.a {
        public C6538a() {
        }

        @Override // com.tencent.luggage.wxa.ri.d.a
        public void a(byte[] bArr, int i3, boolean z16) {
            if (a.this.f136245l != null) {
                a.this.f136245l.a(bArr, i3, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements b.InterfaceC6539b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.o9.b.InterfaceC6539b
        public void a(byte[] bArr, int i3) {
            a.this.a(bArr, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(byte[] bArr, int i3, boolean z16);
    }

    public a(int i3, int i16, int i17, int i18, int i19, double d16, String str, String str2) {
        this.f136239f = i16;
        this.f136240g = i17;
        this.f136241h = i19;
        this.f136242i = d16;
        this.f136234a = new com.tencent.luggage.wxa.o9.b(i3, i16, i17, i18);
        this.f136243j = str;
        this.f136244k = str2;
    }

    public final boolean b() {
        boolean z16 = false;
        w.d("MicroMsg.RecorderPcm", "initEncoder mFilePath:%s", this.f136243j);
        d dVar = this.f136235b;
        if (dVar != null) {
            dVar.close();
            this.f136235b = null;
        }
        d a16 = com.tencent.luggage.wxa.ri.b.a(this.f136244k);
        this.f136235b = a16;
        if (a16 == null) {
            w.b("MicroMsg.RecorderPcm", "mAudioEncoder init fail, return false");
            return false;
        }
        if (!g.e(this.f136243j)) {
            w.b("MicroMsg.RecorderPcm", "prepare cache file fail");
            return false;
        }
        try {
            z16 = this.f136235b.a(this.f136243j, this.f136239f, this.f136240g, this.f136241h);
        } catch (Exception e16) {
            w.a("MicroMsg.RecorderPcm", e16, "init encoder fail", new Object[0]);
        }
        this.f136235b.a(this.f136236c);
        this.f136235b.a(this.f136234a.b());
        this.f136235b.a(this.f136242i);
        return z16;
    }

    public synchronized void c() {
        this.f136234a.c();
    }

    public boolean d() {
        if (a("startRecord fail, recorder is null, return")) {
            return false;
        }
        if (!b()) {
            w.b("MicroMsg.RecorderPcm", "initEncoder fail");
            return false;
        }
        this.f136234a.a(this.f136237d);
        boolean d16 = this.f136234a.d();
        w.d("MicroMsg.RecorderPcm", "startRecord:%b", Boolean.valueOf(d16));
        return d16;
    }

    public boolean e() {
        if (a("stopRecord fail, recorder is null, return")) {
            return false;
        }
        boolean e16 = this.f136234a.e();
        a();
        c();
        w.d("MicroMsg.RecorderPcm", "stopRecord:%b", Boolean.valueOf(e16));
        return e16;
    }

    public final void a(byte[] bArr, int i3) {
        synchronized (this.f136238e) {
            d dVar = this.f136235b;
            if (dVar != null) {
                try {
                    if (!dVar.a(false, bArr, i3)) {
                        w.b("MicroMsg.RecorderPcm", "encode pcm fail!");
                    }
                } catch (Exception e16) {
                    w.f("MicroMsg.RecorderPcm", "", e16);
                }
            }
        }
    }

    public void a(c cVar) {
        this.f136245l = cVar;
    }

    public final void a() {
        synchronized (this.f136238e) {
            d dVar = this.f136235b;
            if (dVar != null) {
                dVar.flush();
                this.f136235b.close();
                this.f136235b = null;
            }
        }
    }

    public final boolean a(String str) {
        if (this.f136234a != null) {
            return false;
        }
        w.b("MicroMsg.RecorderPcm", str);
        return true;
    }
}
