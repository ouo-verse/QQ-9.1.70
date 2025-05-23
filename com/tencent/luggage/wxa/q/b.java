package com.tencent.luggage.wxa.q;

import com.tencent.luggage.wxa.n0.v;
import java.io.EOFException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements e {

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f137744g = new byte[4096];

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.l0.g f137745a;

    /* renamed from: b, reason: collision with root package name */
    public final long f137746b;

    /* renamed from: c, reason: collision with root package name */
    public long f137747c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f137748d = new byte[65536];

    /* renamed from: e, reason: collision with root package name */
    public int f137749e;

    /* renamed from: f, reason: collision with root package name */
    public int f137750f;

    public b(com.tencent.luggage.wxa.l0.g gVar, long j3, long j16) {
        this.f137745a = gVar;
        this.f137747c = j3;
        this.f137746b = j16;
    }

    @Override // com.tencent.luggage.wxa.q.e
    public void a(byte[] bArr, int i3, int i16) {
        b(bArr, i3, i16, false);
    }

    @Override // com.tencent.luggage.wxa.q.e
    public boolean b(byte[] bArr, int i3, int i16, boolean z16) {
        int c16 = c(bArr, i3, i16);
        while (c16 < i16 && c16 != -1) {
            c16 = a(bArr, i3, i16, c16, z16);
        }
        d(c16);
        return c16 != -1;
    }

    @Override // com.tencent.luggage.wxa.q.e
    public void c(int i3) {
        b(i3, false);
    }

    public final void d(int i3) {
        if (i3 != -1) {
            this.f137747c += i3;
        }
    }

    public final void e(int i3) {
        int i16 = this.f137749e + i3;
        byte[] bArr = this.f137748d;
        if (i16 > bArr.length) {
            this.f137748d = Arrays.copyOf(this.f137748d, v.a(bArr.length * 2, 65536 + i16, i16 + 524288));
        }
    }

    public final int f(int i3) {
        int min = Math.min(this.f137750f, i3);
        g(min);
        return min;
    }

    public final void g(int i3) {
        byte[] bArr;
        int i16 = this.f137750f - i3;
        this.f137750f = i16;
        this.f137749e = 0;
        byte[] bArr2 = this.f137748d;
        if (i16 < bArr2.length - 524288) {
            bArr = new byte[65536 + i16];
        } else {
            bArr = bArr2;
        }
        System.arraycopy(bArr2, i3, bArr, 0, i16);
        this.f137748d = bArr;
    }

    @Override // com.tencent.luggage.wxa.q.e
    public long getLength() {
        return this.f137746b;
    }

    @Override // com.tencent.luggage.wxa.q.e
    public long getPosition() {
        return this.f137747c;
    }

    @Override // com.tencent.luggage.wxa.q.e
    public int read(byte[] bArr, int i3, int i16) {
        int c16 = c(bArr, i3, i16);
        if (c16 == 0) {
            c16 = a(bArr, i3, i16, 0, true);
        }
        d(c16);
        return c16;
    }

    @Override // com.tencent.luggage.wxa.q.e
    public boolean a(byte[] bArr, int i3, int i16, boolean z16) {
        if (!a(i16, z16)) {
            return false;
        }
        System.arraycopy(this.f137748d, this.f137749e - i16, bArr, i3, i16);
        return true;
    }

    public final int c(byte[] bArr, int i3, int i16) {
        int i17 = this.f137750f;
        if (i17 == 0) {
            return 0;
        }
        int min = Math.min(i17, i16);
        System.arraycopy(this.f137748d, 0, bArr, i3, min);
        g(min);
        return min;
    }

    public boolean a(int i3, boolean z16) {
        e(i3);
        int min = Math.min(this.f137750f - this.f137749e, i3);
        while (min < i3) {
            min = a(this.f137748d, this.f137749e, i3, min, z16);
            if (min == -1) {
                return false;
            }
        }
        int i16 = this.f137749e + i3;
        this.f137749e = i16;
        this.f137750f = Math.max(this.f137750f, i16);
        return true;
    }

    @Override // com.tencent.luggage.wxa.q.e
    public int b(int i3) {
        int f16 = f(i3);
        if (f16 == 0) {
            byte[] bArr = f137744g;
            f16 = a(bArr, 0, Math.min(i3, bArr.length), 0, true);
        }
        d(f16);
        return f16;
    }

    public boolean b(int i3, boolean z16) {
        int f16 = f(i3);
        while (f16 < i3 && f16 != -1) {
            byte[] bArr = f137744g;
            f16 = a(bArr, -f16, Math.min(i3, bArr.length + f16), f16, z16);
        }
        d(f16);
        return f16 != -1;
    }

    @Override // com.tencent.luggage.wxa.q.e
    public void a(int i3) {
        a(i3, false);
    }

    @Override // com.tencent.luggage.wxa.q.e
    public void a() {
        this.f137749e = 0;
    }

    public final int a(byte[] bArr, int i3, int i16, int i17, boolean z16) {
        if (!Thread.interrupted()) {
            int read = this.f137745a.read(bArr, i3 + i17, i16 - i17);
            if (read != -1) {
                return i17 + read;
            }
            if (i17 == 0 && z16) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    @Override // com.tencent.luggage.wxa.q.e
    public void b(byte[] bArr, int i3, int i16) {
        a(bArr, i3, i16, false);
    }

    @Override // com.tencent.luggage.wxa.q.e
    public long b() {
        return this.f137747c + this.f137749e;
    }
}
