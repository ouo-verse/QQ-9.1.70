package com.tencent.luggage.wxa.m0;

import com.tencent.luggage.wxa.m0.a;
import com.tencent.luggage.wxa.n0.p;
import com.tencent.luggage.wxa.n0.v;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements com.tencent.luggage.wxa.l0.f {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.m0.a f133947a;

    /* renamed from: b, reason: collision with root package name */
    public final long f133948b;

    /* renamed from: c, reason: collision with root package name */
    public final int f133949c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.l0.j f133950d;

    /* renamed from: e, reason: collision with root package name */
    public File f133951e;

    /* renamed from: f, reason: collision with root package name */
    public OutputStream f133952f;

    /* renamed from: g, reason: collision with root package name */
    public FileOutputStream f133953g;

    /* renamed from: h, reason: collision with root package name */
    public long f133954h;

    /* renamed from: i, reason: collision with root package name */
    public long f133955i;

    /* renamed from: j, reason: collision with root package name */
    public p f133956j;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends a.C6454a {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public b(com.tencent.luggage.wxa.m0.a aVar, long j3, int i3) {
        this.f133947a = (com.tencent.luggage.wxa.m0.a) com.tencent.luggage.wxa.n0.a.a(aVar);
        this.f133948b = j3;
        this.f133949c = i3;
    }

    @Override // com.tencent.luggage.wxa.l0.f
    public void a(com.tencent.luggage.wxa.l0.j jVar) {
        if (jVar.f132786e == -1 && !jVar.a(2)) {
            this.f133950d = null;
            return;
        }
        this.f133950d = jVar;
        this.f133955i = 0L;
        try {
            b();
        } catch (IOException e16) {
            throw new a(e16);
        }
    }

    public final void b() {
        long min;
        long j3 = this.f133950d.f132786e;
        if (j3 == -1) {
            min = this.f133948b;
        } else {
            min = Math.min(j3 - this.f133955i, this.f133948b);
        }
        long j16 = min;
        com.tencent.luggage.wxa.m0.a aVar = this.f133947a;
        com.tencent.luggage.wxa.l0.j jVar = this.f133950d;
        this.f133951e = aVar.b(jVar.f132787f, this.f133955i + jVar.f132784c, j16);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f133951e);
        this.f133953g = fileOutputStream;
        if (this.f133949c > 0) {
            p pVar = this.f133956j;
            if (pVar == null) {
                this.f133956j = new p(this.f133953g, this.f133949c);
            } else {
                pVar.a(fileOutputStream);
            }
            this.f133952f = this.f133956j;
        } else {
            this.f133952f = fileOutputStream;
        }
        this.f133954h = 0L;
    }

    @Override // com.tencent.luggage.wxa.l0.f
    public void close() {
        if (this.f133950d == null) {
            return;
        }
        try {
            a();
        } catch (IOException e16) {
            throw new a(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.l0.f
    public void write(byte[] bArr, int i3, int i16) {
        if (this.f133950d == null) {
            return;
        }
        int i17 = 0;
        while (i17 < i16) {
            try {
                if (this.f133954h == this.f133948b) {
                    a();
                    b();
                }
                int min = (int) Math.min(i16 - i17, this.f133948b - this.f133954h);
                this.f133952f.write(bArr, i3 + i17, min);
                i17 += min;
                long j3 = min;
                this.f133954h += j3;
                this.f133955i += j3;
            } catch (IOException e16) {
                throw new a(e16);
            }
        }
    }

    public final void a() {
        OutputStream outputStream = this.f133952f;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            this.f133953g.getFD().sync();
            v.a(this.f133952f);
            this.f133952f = null;
            File file = this.f133951e;
            this.f133951e = null;
            this.f133947a.a(file);
        } catch (Throwable th5) {
            v.a(this.f133952f);
            this.f133952f = null;
            File file2 = this.f133951e;
            this.f133951e = null;
            file2.delete();
            throw th5;
        }
    }
}
