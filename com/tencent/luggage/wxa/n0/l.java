package com.tencent.luggage.wxa.n0;

import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f135088a;

    /* renamed from: b, reason: collision with root package name */
    public int f135089b;

    /* renamed from: c, reason: collision with root package name */
    public int f135090c;

    public l() {
    }

    public l(int i3) {
        this.f135088a = new byte[i3];
        this.f135090c = i3;
    }

    public void a(byte[] bArr, int i3) {
        this.f135088a = bArr;
        this.f135090c = i3;
        this.f135089b = 0;
    }

    public int b() {
        byte[] bArr = this.f135088a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public void c(int i3) {
        a(b() < i3 ? new byte[i3] : this.f135088a, i3);
    }

    public int d() {
        return this.f135090c;
    }

    public void e(int i3) {
        if (i3 < 0 || i3 > this.f135090c) {
            com.tencent.luggage.wxa.y.a.b(ExoPlayerLibraryInfo.TAG, "position%d, limit:%d", Integer.valueOf(i3), Integer.valueOf(this.f135090c));
        }
        a.a(i3 >= 0 && i3 <= this.f135090c);
        this.f135089b = i3;
    }

    public void f(int i3) {
        e(this.f135089b + i3);
    }

    public String g() {
        if (a() == 0) {
            return null;
        }
        int i3 = this.f135089b;
        while (i3 < this.f135090c && !v.d(this.f135088a[i3])) {
            i3++;
        }
        int i16 = this.f135089b;
        if (i3 - i16 >= 3) {
            byte[] bArr = this.f135088a;
            if (bArr[i16] == -17 && bArr[i16 + 1] == -69 && bArr[i16 + 2] == -65) {
                this.f135089b = i16 + 3;
            }
        }
        byte[] bArr2 = this.f135088a;
        int i17 = this.f135089b;
        String str = new String(bArr2, i17, i3 - i17);
        this.f135089b = i3;
        int i18 = this.f135090c;
        if (i3 == i18) {
            return str;
        }
        byte[] bArr3 = this.f135088a;
        if (bArr3[i3] == 13) {
            int i19 = i3 + 1;
            this.f135089b = i19;
            if (i19 == i18) {
                return str;
            }
        }
        int i26 = this.f135089b;
        if (bArr3[i26] == 10) {
            this.f135089b = i26 + 1;
        }
        return str;
    }

    public int h() {
        byte[] bArr = this.f135088a;
        int i3 = this.f135089b;
        int i16 = i3 + 1;
        int i17 = i16 + 1;
        int i18 = (bArr[i3] & 255) | ((bArr[i16] & 255) << 8);
        int i19 = i17 + 1;
        int i26 = i18 | ((bArr[i17] & 255) << 16);
        this.f135089b = i19 + 1;
        return ((bArr[i19] & 255) << 24) | i26;
    }

    public long i() {
        byte[] bArr = this.f135088a;
        long j3 = bArr[r1] & 255;
        int i3 = this.f135089b + 1 + 1 + 1;
        long j16 = j3 | ((bArr[r2] & 255) << 8) | ((bArr[r1] & 255) << 16);
        long j17 = j16 | ((bArr[i3] & 255) << 24);
        long j18 = j17 | ((bArr[r3] & 255) << 32);
        long j19 = j18 | ((bArr[r4] & 255) << 40);
        long j26 = j19 | ((bArr[r3] & 255) << 48);
        this.f135089b = i3 + 1 + 1 + 1 + 1 + 1;
        return j26 | ((bArr[r4] & 255) << 56);
    }

    public long j() {
        byte[] bArr = this.f135088a;
        long j3 = bArr[r1] & 255;
        int i3 = this.f135089b + 1 + 1 + 1;
        long j16 = j3 | ((bArr[r2] & 255) << 8) | ((bArr[r1] & 255) << 16);
        this.f135089b = i3 + 1;
        return j16 | ((bArr[i3] & 255) << 24);
    }

    public int k() {
        int h16 = h();
        if (h16 >= 0) {
            return h16;
        }
        throw new IllegalStateException("Top bit not zero: " + h16);
    }

    public int l() {
        byte[] bArr = this.f135088a;
        int i3 = this.f135089b;
        int i16 = i3 + 1;
        int i17 = bArr[i3] & 255;
        this.f135089b = i16 + 1;
        return ((bArr[i16] & 255) << 8) | i17;
    }

    public long m() {
        byte[] bArr = this.f135088a;
        long j3 = (bArr[r1] & 255) << 56;
        int i3 = this.f135089b + 1 + 1 + 1;
        long j16 = j3 | ((bArr[r2] & 255) << 48) | ((bArr[r1] & 255) << 40);
        long j17 = j16 | ((bArr[i3] & 255) << 32);
        long j18 = j17 | ((bArr[r3] & 255) << 24);
        long j19 = j18 | ((bArr[r4] & 255) << 16);
        long j26 = j19 | ((bArr[r3] & 255) << 8);
        this.f135089b = i3 + 1 + 1 + 1 + 1 + 1;
        return j26 | (bArr[r4] & 255);
    }

    public String n() {
        if (a() == 0) {
            return null;
        }
        int i3 = this.f135089b;
        while (i3 < this.f135090c && this.f135088a[i3] != 0) {
            i3++;
        }
        byte[] bArr = this.f135088a;
        int i16 = this.f135089b;
        String str = new String(bArr, i16, i3 - i16);
        this.f135089b = i3;
        if (i3 < this.f135090c) {
            this.f135089b = i3 + 1;
        }
        return str;
    }

    public short o() {
        byte[] bArr = this.f135088a;
        int i3 = this.f135089b;
        int i16 = i3 + 1;
        int i17 = (bArr[i3] & 255) << 8;
        this.f135089b = i16 + 1;
        return (short) ((bArr[i16] & 255) | i17);
    }

    public int p() {
        return (q() << 21) | (q() << 14) | (q() << 7) | q();
    }

    public int q() {
        byte[] bArr = this.f135088a;
        int i3 = this.f135089b;
        this.f135089b = i3 + 1;
        return bArr[i3] & 255;
    }

    public int r() {
        byte[] bArr = this.f135088a;
        int i3 = this.f135089b;
        int i16 = i3 + 1;
        int i17 = (bArr[i16] & 255) | ((bArr[i3] & 255) << 8);
        this.f135089b = i16 + 1 + 2;
        return i17;
    }

    public long s() {
        byte[] bArr = this.f135088a;
        long j3 = (bArr[r1] & 255) << 24;
        int i3 = this.f135089b + 1 + 1 + 1;
        long j16 = j3 | ((bArr[r2] & 255) << 16) | ((bArr[r1] & 255) << 8);
        this.f135089b = i3 + 1;
        return j16 | (bArr[i3] & 255);
    }

    public int t() {
        byte[] bArr = this.f135088a;
        int i3 = this.f135089b;
        int i16 = i3 + 1;
        int i17 = i16 + 1;
        int i18 = ((bArr[i3] & 255) << 16) | ((bArr[i16] & 255) << 8);
        this.f135089b = i17 + 1;
        return (bArr[i17] & 255) | i18;
    }

    public int u() {
        int f16 = f();
        if (f16 >= 0) {
            return f16;
        }
        throw new IllegalStateException("Top bit not zero: " + f16);
    }

    public long v() {
        long m3 = m();
        if (m3 >= 0) {
            return m3;
        }
        throw new IllegalStateException("Top bit not zero: " + m3);
    }

    public int w() {
        byte[] bArr = this.f135088a;
        int i3 = this.f135089b;
        int i16 = i3 + 1;
        int i17 = (bArr[i3] & 255) << 8;
        this.f135089b = i16 + 1;
        return (bArr[i16] & 255) | i17;
    }

    public long x() {
        int i3;
        int i16;
        long j3 = this.f135088a[this.f135089b];
        int i17 = 7;
        while (true) {
            if (i17 < 0) {
                break;
            }
            if (((1 << i17) & j3) != 0) {
                i17--;
            } else if (i17 < 6) {
                j3 &= r6 - 1;
                i16 = 7 - i17;
            } else if (i17 == 7) {
                i16 = 1;
            }
        }
        i16 = 0;
        if (i16 != 0) {
            for (i3 = 1; i3 < i16; i3++) {
                if ((this.f135088a[this.f135089b + i3] & 192) == 128) {
                    j3 = (j3 << 6) | (r3 & 63);
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j3);
                }
            }
            this.f135089b += i16;
            return j3;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j3);
    }

    public void y() {
        this.f135089b = 0;
        this.f135090c = 0;
    }

    public String b(int i3) {
        return a(i3, Charset.forName("UTF-8"));
    }

    public int c() {
        return this.f135089b;
    }

    public void d(int i3) {
        a.a(i3 >= 0 && i3 <= this.f135088a.length);
        this.f135090c = i3;
    }

    public int f() {
        byte[] bArr = this.f135088a;
        int i3 = this.f135089b;
        int i16 = i3 + 1;
        int i17 = i16 + 1;
        int i18 = ((bArr[i3] & 255) << 24) | ((bArr[i16] & 255) << 16);
        int i19 = i17 + 1;
        int i26 = i18 | ((bArr[i17] & 255) << 8);
        this.f135089b = i19 + 1;
        return (bArr[i19] & 255) | i26;
    }

    public l(byte[] bArr) {
        this.f135088a = bArr;
        this.f135090c = bArr.length;
    }

    public int a() {
        return this.f135090c - this.f135089b;
    }

    public void a(k kVar, int i3) {
        a(kVar.f135084a, 0, i3);
        kVar.b(0);
    }

    public double e() {
        return Double.longBitsToDouble(m());
    }

    public l(byte[] bArr, int i3) {
        this.f135088a = bArr;
        this.f135090c = i3;
    }

    public void a(byte[] bArr, int i3, int i16) {
        System.arraycopy(this.f135088a, this.f135089b, bArr, i3, i16);
        this.f135089b += i16;
    }

    public String a(int i3, Charset charset) {
        String str = new String(this.f135088a, this.f135089b, i3, charset);
        this.f135089b += i3;
        return str;
    }

    public String a(int i3) {
        if (i3 == 0) {
            return "";
        }
        int i16 = this.f135089b;
        int i17 = (i16 + i3) - 1;
        String str = new String(this.f135088a, i16, (i17 >= this.f135090c || this.f135088a[i17] != 0) ? i3 : i3 - 1);
        this.f135089b += i3;
        return str;
    }
}
