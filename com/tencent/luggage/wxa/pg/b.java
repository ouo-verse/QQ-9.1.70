package com.tencent.luggage.wxa.pg;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements com.tencent.luggage.wxa.qg.d {

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.pg.a f137517b;

    /* renamed from: c, reason: collision with root package name */
    public final long f137518c;

    /* renamed from: d, reason: collision with root package name */
    public v f137519d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.qg.g f137520e;

    /* renamed from: f, reason: collision with root package name */
    public BufferedOutputStream f137521f;

    /* renamed from: g, reason: collision with root package name */
    public OutputStream f137522g;

    /* renamed from: h, reason: collision with root package name */
    public long f137523h;

    /* renamed from: i, reason: collision with root package name */
    public long f137524i;

    /* renamed from: a, reason: collision with root package name */
    public String f137516a = "CacheDataSink";

    /* renamed from: j, reason: collision with root package name */
    public long f137525j = -1;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.luggage.wxa.rg.b f137526k = com.tencent.luggage.wxa.rg.b.f139662c;

    /* renamed from: l, reason: collision with root package name */
    public String f137527l = "";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public b(com.tencent.luggage.wxa.pg.a aVar, long j3) {
        this.f137517b = aVar;
        this.f137518c = j3;
    }

    @Override // com.tencent.luggage.wxa.qg.d
    public com.tencent.luggage.wxa.qg.d a(com.tencent.luggage.wxa.qg.g gVar, long j3, com.tencent.luggage.wxa.rg.b bVar) {
        com.tencent.luggage.wxa.tg.a.b(gVar.f138706d != -1);
        this.f137525j = j3;
        this.f137526k = bVar;
        try {
            this.f137520e = gVar;
            this.f137524i = 0L;
            d();
            return this;
        } catch (IOException e16) {
            throw new a(e16);
        }
    }

    public void b() {
        this.f137517b.a(this.f137519d);
    }

    public String c() {
        return this.f137527l + this.f137516a;
    }

    @Override // com.tencent.luggage.wxa.qg.d
    public void close() {
        try {
            a();
            com.tencent.luggage.wxa.tg.h.a(4, c(), "close outputStream, " + String.format("total cached %d bytes", Long.valueOf(this.f137524i)));
        } catch (IOException e16) {
            throw new a(e16);
        }
    }

    public void d() {
        e();
        com.tencent.luggage.wxa.tg.h.a(4, c(), "start cache " + this.f137519d.g());
        this.f137522g = x.b(this.f137519d);
        this.f137521f = new BufferedOutputStream(this.f137522g);
        this.f137523h = 0L;
    }

    public void e() {
        com.tencent.luggage.wxa.pg.a aVar = this.f137517b;
        com.tencent.luggage.wxa.qg.g gVar = this.f137520e;
        String str = gVar.f138707e;
        long j3 = gVar.f138704b;
        long j16 = this.f137524i;
        this.f137519d = aVar.a(str, j3 + j16, this.f137525j, this.f137526k, Math.min(gVar.f138706d - j16, this.f137518c));
    }

    @Override // com.tencent.luggage.wxa.qg.d
    public void write(byte[] bArr, int i3, int i16) {
        int i17 = 0;
        while (i17 < i16) {
            try {
                if (this.f137523h == this.f137518c) {
                    a();
                    d();
                }
                int min = (int) Math.min(i16 - i17, this.f137518c - this.f137523h);
                this.f137521f.write(bArr, i3 + i17, min);
                i17 += min;
                long j3 = min;
                this.f137523h += j3;
                this.f137524i += j3;
            } catch (IOException e16) {
                throw new a(e16);
            }
        }
    }

    public final void a() {
        BufferedOutputStream bufferedOutputStream = this.f137521f;
        if (bufferedOutputStream == null) {
            com.tencent.luggage.wxa.tg.h.a(4, c(), "finish cache, outputStream is null");
            return;
        }
        try {
            bufferedOutputStream.flush();
            a(this.f137521f);
            b();
            com.tencent.luggage.wxa.tg.h.a(4, c(), "finish cache " + this.f137519d.g() + "  fileSize=" + this.f137519d.s());
            this.f137522g = null;
            this.f137521f = null;
            this.f137519d = null;
        } catch (Throwable th5) {
            a(this.f137521f);
            this.f137519d.d();
            com.tencent.luggage.wxa.tg.h.a(6, c(), "close outputStream failed: " + this.f137519d.g());
            this.f137522g = null;
            this.f137521f = null;
            this.f137519d = null;
            throw th5;
        }
    }

    public static void a(OutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException unused) {
        }
    }

    public void a(String str) {
        this.f137527l = str;
    }
}
