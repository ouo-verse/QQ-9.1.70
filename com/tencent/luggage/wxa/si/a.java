package com.tencent.luggage.wxa.si;

import com.tencent.luggage.wxa.ti.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.xweb.FileReaderHelper;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.si.b f140363b;

    /* renamed from: c, reason: collision with root package name */
    public int f140364c;

    /* renamed from: d, reason: collision with root package name */
    public int f140365d;

    /* renamed from: f, reason: collision with root package name */
    public b f140367f;

    /* renamed from: g, reason: collision with root package name */
    public int f140368g;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.ti.a f140362a = null;

    /* renamed from: e, reason: collision with root package name */
    public long f140366e = 0;

    /* renamed from: h, reason: collision with root package name */
    public a.b f140369h = new C6719a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(int i3, int i16);

        void a(byte[] bArr, int i3);
    }

    public a(com.tencent.luggage.wxa.si.b bVar) {
        this.f140364c = 0;
        this.f140365d = 0;
        this.f140368g = -1;
        bVar = bVar == null ? new com.tencent.luggage.wxa.si.b() : bVar;
        this.f140364c = bVar.f140372b;
        this.f140365d = bVar.f140373c;
        this.f140368g = bVar.f140377g;
        this.f140363b = bVar;
    }

    public int b() {
        com.tencent.luggage.wxa.ti.a aVar = this.f140362a;
        if (aVar != null) {
            return aVar.b();
        }
        return 0;
    }

    public boolean c() {
        w.d("MicroMsg.Record.AppBrandRecorder", "startRecord");
        com.tencent.luggage.wxa.ti.a aVar = this.f140362a;
        if (aVar != null) {
            aVar.g();
            this.f140362a = null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f140366e = currentTimeMillis;
        w.d("MicroMsg.Record.AppBrandRecorder", "start time ticket:%d", Long.valueOf(currentTimeMillis));
        this.f140362a = new com.tencent.luggage.wxa.ti.a(this.f140364c, this.f140365d, this.f140368g);
        if (FileReaderHelper.MP3_EXT.equalsIgnoreCase(this.f140363b.f140375e)) {
            this.f140362a.d(40);
        } else {
            this.f140362a.d(20);
        }
        this.f140362a.a(false);
        this.f140362a.a(this.f140369h);
        this.f140362a.c(this.f140363b.f140381k.f138827a);
        if (this.f140362a.e()) {
            return true;
        }
        return false;
    }

    public boolean d() {
        boolean z16;
        w.d("MicroMsg.Record.AppBrandRecorder", "stopRecord");
        com.tencent.luggage.wxa.ti.a aVar = this.f140362a;
        if (aVar != null) {
            z16 = aVar.g();
        } else {
            z16 = false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f140366e -= currentTimeMillis;
        w.d("MicroMsg.Record.AppBrandRecorder", "stop time ticket:%d, costTimeInMs:%d", Long.valueOf(currentTimeMillis), Long.valueOf(this.f140366e));
        return z16;
    }

    public void a(b bVar) {
        this.f140367f = bVar;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.si.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6719a implements a.b {
        public C6719a() {
        }

        @Override // com.tencent.luggage.wxa.ti.a.b
        public void a(byte[] bArr, int i3) {
            w.d("MicroMsg.Record.AppBrandRecorder", "onRecPcmDataReady()");
            if (a.this.f140367f != null) {
                a.this.f140367f.a(bArr, i3);
            }
        }

        @Override // com.tencent.luggage.wxa.ti.a.b
        public void a(int i3, int i16) {
            w.b("MicroMsg.Record.AppBrandRecorder", "state:%d, detailState:%d", Integer.valueOf(i3), Integer.valueOf(i16));
            if (a.this.f140367f != null) {
                a.this.f140367f.a(i3, i16);
            }
        }
    }

    public int a() {
        com.tencent.luggage.wxa.ti.a aVar = this.f140362a;
        if (aVar != null) {
            return aVar.a();
        }
        return 20;
    }
}
