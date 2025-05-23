package com.xiaomi.push;

import cooperation.qzone.ShareElfFile;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f388342a;

    /* renamed from: b, reason: collision with root package name */
    private final int f388343b;

    /* renamed from: c, reason: collision with root package name */
    private int f388344c;

    /* renamed from: d, reason: collision with root package name */
    private final OutputStream f388345d;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    c(byte[] bArr, int i3, int i16) {
        this.f388345d = null;
        this.f388342a = bArr;
        this.f388344c = i3;
        this.f388343b = i3 + i16;
    }

    public static int G(int i3) {
        return V(i3);
    }

    public static int H(int i3, int i16) {
        return P(i3) + G(i16);
    }

    public static int I(int i3, long j3) {
        return P(i3) + J(j3);
    }

    public static int J(long j3) {
        return Q(j3);
    }

    public static int P(int i3) {
        return V(eo.b(i3, 0));
    }

    public static int Q(long j3) {
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
        if ((j3 & Long.MIN_VALUE) == 0) {
            return 9;
        }
        return 10;
    }

    private void R() {
        OutputStream outputStream = this.f388345d;
        if (outputStream != null) {
            outputStream.write(this.f388342a, 0, this.f388344c);
            this.f388344c = 0;
            return;
        }
        throw new a();
    }

    public static int V(int i3) {
        if ((i3 & (-128)) == 0) {
            return 1;
        }
        if ((i3 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i3) == 0) {
            return 3;
        }
        if ((i3 & ShareElfFile.SectionHeader.SHF_MASKPROC) == 0) {
            return 4;
        }
        return 5;
    }

    public static int b(int i3) {
        if (i3 >= 0) {
            return V(i3);
        }
        return 10;
    }

    public static int c(int i3, int i16) {
        return P(i3) + b(i16);
    }

    public static int d(int i3, long j3) {
        return P(i3) + i(j3);
    }

    public static int e(int i3, com.xiaomi.push.a aVar) {
        return P(i3) + j(aVar);
    }

    public static int f(int i3, dp dpVar) {
        return P(i3) + k(dpVar);
    }

    public static int g(int i3, String str) {
        return P(i3) + l(str);
    }

    public static int h(int i3, boolean z16) {
        return P(i3) + m(z16);
    }

    public static int i(long j3) {
        return Q(j3);
    }

    public static int j(com.xiaomi.push.a aVar) {
        return V(aVar.a()) + aVar.a();
    }

    public static int k(dp dpVar) {
        int i3 = dpVar.i();
        return V(i3) + i3;
    }

    public static int l(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return V(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int m(boolean z16) {
        return 1;
    }

    public static c n(OutputStream outputStream) {
        return o(outputStream, 4096);
    }

    public static c o(OutputStream outputStream, int i3) {
        return new c(outputStream, new byte[i3]);
    }

    public static c p(byte[] bArr, int i3, int i16) {
        return new c(bArr, i3, i16);
    }

    public void A(com.xiaomi.push.a aVar) {
        byte[] d16 = aVar.d();
        W(d16.length);
        E(d16);
    }

    public void B(dp dpVar) {
        W(dpVar.a());
        dpVar.e(this);
    }

    public void C(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        W(bytes.length);
        E(bytes);
    }

    public void D(boolean z16) {
        S(z16 ? 1 : 0);
    }

    public void E(byte[] bArr) {
        F(bArr, 0, bArr.length);
    }

    public void F(byte[] bArr, int i3, int i16) {
        int i17 = this.f388343b;
        int i18 = this.f388344c;
        if (i17 - i18 >= i16) {
            System.arraycopy(bArr, i3, this.f388342a, i18, i16);
            this.f388344c += i16;
            return;
        }
        int i19 = i17 - i18;
        System.arraycopy(bArr, i3, this.f388342a, i18, i19);
        int i26 = i3 + i19;
        int i27 = i16 - i19;
        this.f388344c = this.f388343b;
        R();
        if (i27 <= this.f388343b) {
            System.arraycopy(bArr, i26, this.f388342a, 0, i27);
            this.f388344c = i27;
        } else {
            this.f388345d.write(bArr, i26, i27);
        }
    }

    public void K() {
        if (a() == 0) {
        } else {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void L(int i3) {
        W(i3);
    }

    public void M(int i3, int i16) {
        T(i3, 0);
        L(i16);
    }

    public void N(int i3, long j3) {
        T(i3, 0);
        O(j3);
    }

    public void O(long j3) {
        U(j3);
    }

    public void S(int i3) {
        r((byte) i3);
    }

    public void T(int i3, int i16) {
        W(eo.b(i3, i16));
    }

    public void U(long j3) {
        while (((-128) & j3) != 0) {
            S((((int) j3) & 127) | 128);
            j3 >>>= 7;
        }
        S((int) j3);
    }

    public void W(int i3) {
        while ((i3 & (-128)) != 0) {
            S((i3 & 127) | 128);
            i3 >>>= 7;
        }
        S(i3);
    }

    public int a() {
        if (this.f388345d == null) {
            return this.f388343b - this.f388344c;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void q() {
        if (this.f388345d != null) {
            R();
        }
    }

    public void r(byte b16) {
        if (this.f388344c == this.f388343b) {
            R();
        }
        byte[] bArr = this.f388342a;
        int i3 = this.f388344c;
        this.f388344c = i3 + 1;
        bArr[i3] = b16;
    }

    public void s(int i3) {
        if (i3 >= 0) {
            W(i3);
        } else {
            U(i3);
        }
    }

    public void t(int i3, int i16) {
        T(i3, 0);
        s(i16);
    }

    public void u(int i3, long j3) {
        T(i3, 0);
        z(j3);
    }

    public void v(int i3, com.xiaomi.push.a aVar) {
        T(i3, 2);
        A(aVar);
    }

    public void w(int i3, dp dpVar) {
        T(i3, 2);
        B(dpVar);
    }

    public void x(int i3, String str) {
        T(i3, 2);
        C(str);
    }

    public void y(int i3, boolean z16) {
        T(i3, 0);
        D(z16);
    }

    public void z(long j3) {
        U(j3);
    }

    c(OutputStream outputStream, byte[] bArr) {
        this.f388345d = outputStream;
        this.f388342a = bArr;
        this.f388344c = 0;
        this.f388343b = bArr.length;
    }
}
