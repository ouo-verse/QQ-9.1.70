package com.tencent.luggage.wxa.lr;

import com.tencent.luggage.wxa.fn.c;
import cooperation.qzone.ShareElfFile;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f133794a;

    /* renamed from: b, reason: collision with root package name */
    public final int f133795b;

    /* renamed from: c, reason: collision with root package name */
    public int f133796c;

    public a(byte[] bArr, int i3, int i16) {
        this.f133794a = bArr;
        this.f133796c = i3;
        this.f133795b = i3 + i16;
    }

    public static int a(int i3) {
        if ((i3 & (-128)) == 0) {
            return 1;
        }
        if ((i3 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i3) == 0) {
            return 3;
        }
        return (i3 & ShareElfFile.SectionHeader.SHF_MASKPROC) == 0 ? 4 : 5;
    }

    public void b(int i3, double d16) {
        d(i3, 1);
        b(Double.doubleToLongBits(d16));
    }

    public void c(int i3, int i16) {
        d(i3, 2);
        e(i16);
    }

    public void d(int i3, int i16) {
        e(com.tencent.luggage.wxa.jr.a.a(i3, i16));
    }

    public void e(int i3) {
        while ((i3 & (-128)) != 0) {
            c((i3 & 127) | 128);
            i3 >>>= 7;
        }
        c(i3);
    }

    public static int a(long j3) {
        if (((-128) & j3) == 0) {
            return 1;
        }
        if (((-16384) & j3) == 0) {
            return 2;
        }
        if (((-2097152) & j3) == 0) {
            return 3;
        }
        if (((-268435456) & j3) == 0) {
            return 4;
        }
        if (((-34359738368L) & j3) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j3) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j3) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j3) == 0) {
            return 8;
        }
        return (j3 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public final void d(int i3) {
        c(i3 & 255);
        c((i3 >> 8) & 255);
        c((i3 >> 16) & 255);
        c((i3 >> 24) & 255);
    }

    public static a a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public void b(int i3, float f16) {
        d(i3, 5);
        d(Float.floatToIntBits(f16));
    }

    public final void c(int i3) {
        a((byte) i3);
    }

    public static a a(byte[] bArr, int i3, int i16) {
        return new a(bArr, i3, i16);
    }

    public void c(long j3) {
        while (((-128) & j3) != 0) {
            c((((int) j3) & 127) | 128);
            j3 >>>= 7;
        }
        c((int) j3);
    }

    public static int a(int i3, double d16) {
        return b(i3) + 8;
    }

    public void b(int i3, long j3) {
        d(i3, 0);
        c(j3);
    }

    public static int a(int i3, float f16) {
        return b(i3) + 4;
    }

    public static int a(int i3, long j3) {
        return b(i3) + a(j3);
    }

    public void b(int i3, int i16) {
        d(i3, 0);
        if (i16 >= 0) {
            e(i16);
        } else {
            c(i16);
        }
    }

    public static int a(int i3, int i16) {
        if (i16 >= 0) {
            return b(i3) + a(i16);
        }
        return b(i3) + 10;
    }

    public static int a(int i3, boolean z16) {
        return b(i3) + 1;
    }

    public void b(int i3, boolean z16) {
        d(i3, 0);
        if (z16) {
            c(1);
        } else {
            c(0);
        }
    }

    public static int a(int i3, String str) {
        if (str == null) {
            return 0;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return b(i3) + a(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new IllegalStateException("UTF-8 not supported.");
        }
    }

    public void b(int i3, String str) {
        if (str == null) {
            return;
        }
        d(i3, 2);
        byte[] bytes = str.getBytes("UTF-8");
        e(bytes.length);
        b(bytes);
    }

    public static int a(int i3, c cVar) {
        if (cVar == null) {
            return 0;
        }
        return b(i3) + a(cVar.b()) + cVar.b();
    }

    public final void a(byte b16) {
        byte[] bArr = this.f133794a;
        int i3 = this.f133796c;
        this.f133796c = i3 + 1;
        bArr[i3] = b16;
    }

    public int a() {
        return this.f133796c;
    }

    public void b(int i3, c cVar) {
        if (cVar == null) {
            return;
        }
        d(i3, 2);
        byte[] c16 = cVar.c();
        e(c16.length);
        b(c16);
    }

    public int b() {
        return this.f133795b - this.f133796c;
    }

    public final void b(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        b(bArr, 0, bArr.length);
    }

    public final void b(byte[] bArr, int i3, int i16) {
        if (bArr == null) {
            return;
        }
        int i17 = this.f133795b;
        int i18 = this.f133796c;
        int i19 = i17 - i18;
        if (i19 >= i16) {
            System.arraycopy(bArr, i3, this.f133794a, i18, i16);
            this.f133796c += i16;
            return;
        }
        System.arraycopy(bArr, i3, this.f133794a, i18, i19);
        int i26 = i3 + i19;
        int i27 = i16 - i19;
        int i28 = this.f133795b;
        this.f133796c = i28;
        if (i27 <= i28) {
            System.arraycopy(bArr, i26, this.f133794a, 0, i27);
            this.f133796c = i27;
        }
    }

    public static int b(int i3) {
        return a(com.tencent.luggage.wxa.jr.a.a(i3, 0));
    }

    public final void b(long j3) {
        c(((int) j3) & 255);
        c(((int) (j3 >> 8)) & 255);
        c(((int) (j3 >> 16)) & 255);
        c(((int) (j3 >> 24)) & 255);
        c(((int) (j3 >> 32)) & 255);
        c(((int) (j3 >> 40)) & 255);
        c(((int) (j3 >> 48)) & 255);
        c(((int) (j3 >> 56)) & 255);
    }
}
