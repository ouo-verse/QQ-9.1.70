package com.xingin.xhssharesdk.a;

import com.xingin.xhssharesdk.a.b0;
import cooperation.qzone.ShareElfFile;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class g extends nz4.b {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f389913a = Logger.getLogger(g.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f389914b = nz4.a.f421642c;

    /* renamed from: c, reason: collision with root package name */
    public static final long f389915c = nz4.a.f421643d;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class a extends g {

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f389916d;

        /* renamed from: e, reason: collision with root package name */
        public final int f389917e;

        /* renamed from: f, reason: collision with root package name */
        public int f389918f;

        public a() {
            super(0);
            int max = Math.max(4096, 20);
            this.f389916d = new byte[max];
            this.f389917e = max;
        }

        public final void B(long j3) {
            if (g.f389914b) {
                long j16 = g.f389915c + this.f389918f;
                long j17 = j16;
                while ((j3 & (-128)) != 0) {
                    nz4.a.d(this.f389916d, j17, (byte) ((((int) j3) & 127) | 128));
                    j3 >>>= 7;
                    j17 = 1 + j17;
                }
                nz4.a.d(this.f389916d, j17, (byte) j3);
                this.f389918f += (int) ((1 + j17) - j16);
                return;
            }
            while ((j3 & (-128)) != 0) {
                byte[] bArr = this.f389916d;
                int i3 = this.f389918f;
                this.f389918f = i3 + 1;
                bArr[i3] = (byte) ((((int) j3) & 127) | 128);
                j3 >>>= 7;
            }
            byte[] bArr2 = this.f389916d;
            int i16 = this.f389918f;
            this.f389918f = i16 + 1;
            bArr2[i16] = (byte) j3;
        }

        public final void C(int i3) {
            if (g.f389914b) {
                long j3 = g.f389915c + this.f389918f;
                long j16 = j3;
                while ((i3 & (-128)) != 0) {
                    nz4.a.d(this.f389916d, j16, (byte) ((i3 & 127) | 128));
                    i3 >>>= 7;
                    j16 = 1 + j16;
                }
                nz4.a.d(this.f389916d, j16, (byte) i3);
                this.f389918f += (int) ((1 + j16) - j3);
                return;
            }
            while ((i3 & (-128)) != 0) {
                byte[] bArr = this.f389916d;
                int i16 = this.f389918f;
                this.f389918f = i16 + 1;
                bArr[i16] = (byte) ((i3 & 127) | 128);
                i3 >>>= 7;
            }
            byte[] bArr2 = this.f389916d;
            int i17 = this.f389918f;
            this.f389918f = i17 + 1;
            bArr2[i17] = (byte) i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class c extends IOException {
        public c(IndexOutOfBoundsException indexOutOfBoundsException) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
        }

        public c(String str, IndexOutOfBoundsException indexOutOfBoundsException) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, indexOutOfBoundsException);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class d extends a {

        /* renamed from: g, reason: collision with root package name */
        public final OutputStream f389922g;

        public d(ByteArrayOutputStream byteArrayOutputStream) {
            this.f389922g = byteArrayOutputStream;
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void A(int i3) {
            D(10);
            C(i3);
        }

        public final void D(int i3) {
            int i16 = this.f389917e;
            int i17 = this.f389918f;
            if (i16 - i17 < i3) {
                this.f389922g.write(this.f389916d, 0, i17);
                this.f389918f = 0;
            }
        }

        @Override // nz4.b
        public final void a(byte[] bArr, int i3, int i16) {
            u(bArr, i3, i16);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void h() {
            int i3 = this.f389918f;
            if (i3 > 0) {
                this.f389922g.write(this.f389916d, 0, i3);
                this.f389918f = 0;
            }
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void i(byte b16) {
            int i3 = this.f389918f;
            if (i3 == this.f389917e) {
                this.f389922g.write(this.f389916d, 0, i3);
                this.f389918f = 0;
            }
            byte[] bArr = this.f389916d;
            int i16 = this.f389918f;
            this.f389918f = i16 + 1;
            bArr[i16] = b16;
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void j(int i3, int i16) {
            D(20);
            C(c0.a(i3, 0));
            if (i16 >= 0) {
                C(i16);
            } else {
                B(i16);
            }
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void k(int i3, k kVar) {
            A(c0.a(i3, 2));
            A(kVar.b());
            kVar.a(this);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void m(byte[] bArr, int i3) {
            A(i3);
            u(bArr, 0, i3);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void o(int i3, int i16) {
            A(c0.a(i3, i16));
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void p(int i3, String str) {
            A(c0.a(i3, 2));
            t(str);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void q(long j3) {
            D(8);
            byte[] bArr = this.f389916d;
            int i3 = this.f389918f;
            int i16 = i3 + 1;
            bArr[i3] = (byte) (j3 & 255);
            int i17 = i16 + 1;
            bArr[i16] = (byte) ((j3 >> 8) & 255);
            int i18 = i17 + 1;
            bArr[i17] = (byte) ((j3 >> 16) & 255);
            int i19 = i18 + 1;
            bArr[i18] = (byte) ((j3 >> 24) & 255);
            int i26 = i19 + 1;
            bArr[i19] = (byte) (((int) (j3 >> 32)) & 255);
            int i27 = i26 + 1;
            bArr[i26] = (byte) (((int) (j3 >> 40)) & 255);
            int i28 = i27 + 1;
            bArr[i27] = (byte) (((int) (j3 >> 48)) & 255);
            this.f389918f = i28 + 1;
            bArr[i28] = (byte) (((int) (j3 >> 56)) & 255);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void r(e eVar) {
            A(eVar.size());
            eVar.a(this);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void s(l lVar) {
            A(lVar.b());
            lVar.a(this);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void t(String str) {
            try {
                int length = str.length() * 3;
                int v3 = g.v(length);
                int i3 = v3 + length;
                int i16 = this.f389917e;
                if (i3 > i16) {
                    byte[] bArr = new byte[length];
                    int a16 = b0.f389876a.a(str, bArr, 0, length);
                    A(a16);
                    u(bArr, 0, a16);
                    return;
                }
                int i17 = this.f389918f;
                if (i3 > i16 - i17) {
                    this.f389922g.write(this.f389916d, 0, i17);
                    this.f389918f = 0;
                }
                int v16 = g.v(str.length());
                int i18 = this.f389918f;
                try {
                    try {
                        if (v16 == v3) {
                            int i19 = i18 + v16;
                            this.f389918f = i19;
                            int a17 = b0.f389876a.a(str, this.f389916d, i19, this.f389917e - i19);
                            this.f389918f = i18;
                            C((a17 - i18) - v16);
                            this.f389918f = a17;
                        } else {
                            int c16 = b0.c(str);
                            C(c16);
                            this.f389918f = b0.f389876a.a(str, this.f389916d, this.f389918f, c16);
                        }
                    } catch (b0.c e16) {
                        this.f389918f = i18;
                        throw e16;
                    }
                } catch (ArrayIndexOutOfBoundsException e17) {
                    throw new c(e17);
                }
            } catch (b0.c e18) {
                l(str, e18);
            }
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void u(byte[] bArr, int i3, int i16) {
            int i17 = this.f389917e;
            int i18 = this.f389918f;
            int i19 = i17 - i18;
            if (i19 >= i16) {
                System.arraycopy(bArr, i3, this.f389916d, i18, i16);
                this.f389918f += i16;
                return;
            }
            System.arraycopy(bArr, i3, this.f389916d, i18, i19);
            int i26 = i3 + i19;
            int i27 = i16 - i19;
            int i28 = this.f389917e;
            this.f389918f = i28;
            this.f389922g.write(this.f389916d, 0, i28);
            this.f389918f = 0;
            if (i27 <= this.f389917e) {
                System.arraycopy(bArr, i26, this.f389916d, 0, i27);
                this.f389918f = i27;
            } else {
                this.f389922g.write(bArr, i26, i27);
            }
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void w(long j3) {
            D(20);
            C(c0.a(8, 0));
            B(j3);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void x(int i3) {
            D(4);
            byte[] bArr = this.f389916d;
            int i16 = this.f389918f;
            int i17 = i16 + 1;
            bArr[i16] = (byte) (i3 & 255);
            int i18 = i17 + 1;
            bArr[i17] = (byte) ((i3 >> 8) & 255);
            int i19 = i18 + 1;
            bArr[i18] = (byte) ((i3 >> 16) & 255);
            this.f389918f = i19 + 1;
            bArr[i19] = (byte) ((i3 >> 24) & 255);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void y(long j3) {
            D(10);
            B(j3);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void z(int i3) {
            if (i3 >= 0) {
                A(i3);
            } else {
                y(i3);
            }
        }
    }

    public g() {
    }

    public /* synthetic */ g(int i3) {
        this();
    }

    public static int b(int i3) {
        if (i3 >= 0) {
            return v(i3);
        }
        return 10;
    }

    public static int c(int i3, String str) {
        return g(str) + n(i3);
    }

    public static int d(long j3) {
        int i3;
        if (((-128) & j3) == 0) {
            return 1;
        }
        if (j3 < 0) {
            return 10;
        }
        if (((-34359738368L) & j3) != 0) {
            j3 >>>= 28;
            i3 = 6;
        } else {
            i3 = 2;
        }
        if (((-2097152) & j3) != 0) {
            i3 += 2;
            j3 >>>= 14;
        }
        if ((j3 & (-16384)) != 0) {
            return i3 + 1;
        }
        return i3;
    }

    public static int e(e eVar) {
        int size = eVar.size();
        return v(size) + size;
    }

    public static int f(l lVar) {
        int b16 = lVar.b();
        return v(b16) + b16;
    }

    public static int g(String str) {
        int length;
        try {
            length = b0.c(str);
        } catch (b0.c unused) {
            length = str.getBytes(f.f389911a).length;
        }
        return v(length) + length;
    }

    public static int n(int i3) {
        return v(c0.a(i3, 0));
    }

    public static int v(int i3) {
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

    public abstract void A(int i3);

    public abstract void h();

    public abstract void i(byte b16);

    public abstract void j(int i3, int i16);

    public abstract void k(int i3, k kVar);

    public final void l(String str, b0.c cVar) {
        f389913a.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) cVar);
        byte[] bytes = str.getBytes(f.f389911a);
        try {
            A(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (c e16) {
            throw e16;
        } catch (IndexOutOfBoundsException e17) {
            throw new c(e17);
        }
    }

    public abstract void m(byte[] bArr, int i3);

    public abstract void o(int i3, int i16);

    public abstract void p(int i3, String str);

    public abstract void q(long j3);

    public abstract void r(e eVar);

    public abstract void s(l lVar);

    public abstract void t(String str);

    public abstract void u(byte[] bArr, int i3, int i16);

    public abstract void w(long j3);

    public abstract void x(int i3);

    public abstract void y(long j3);

    public abstract void z(int i3);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class b extends g {

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f389919d;

        /* renamed from: e, reason: collision with root package name */
        public final int f389920e;

        /* renamed from: f, reason: collision with root package name */
        public int f389921f;

        public b(byte[] bArr, int i3) {
            super(0);
            int i16 = i3 + 0;
            if ((i3 | 0 | (bArr.length - i16)) >= 0) {
                this.f389919d = bArr;
                this.f389921f = 0;
                this.f389920e = i16;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i3)));
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void A(int i3) {
            if (g.f389914b) {
                int i16 = this.f389920e;
                int i17 = this.f389921f;
                if (i16 - i17 >= 10) {
                    long j3 = g.f389915c + i17;
                    while ((i3 & (-128)) != 0) {
                        nz4.a.d(this.f389919d, j3, (byte) ((i3 & 127) | 128));
                        this.f389921f++;
                        i3 >>>= 7;
                        j3 = 1 + j3;
                    }
                    nz4.a.d(this.f389919d, j3, (byte) i3);
                    this.f389921f++;
                    return;
                }
            }
            while ((i3 & (-128)) != 0) {
                try {
                    byte[] bArr = this.f389919d;
                    int i18 = this.f389921f;
                    this.f389921f = i18 + 1;
                    bArr[i18] = (byte) ((i3 & 127) | 128);
                    i3 >>>= 7;
                } catch (IndexOutOfBoundsException e16) {
                    throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f389921f), Integer.valueOf(this.f389920e), 1), e16);
                }
            }
            byte[] bArr2 = this.f389919d;
            int i19 = this.f389921f;
            this.f389921f = i19 + 1;
            bArr2[i19] = (byte) i3;
        }

        @Override // nz4.b
        public final void a(byte[] bArr, int i3, int i16) {
            u(bArr, i3, i16);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void i(byte b16) {
            try {
                byte[] bArr = this.f389919d;
                int i3 = this.f389921f;
                this.f389921f = i3 + 1;
                bArr[i3] = b16;
            } catch (IndexOutOfBoundsException e16) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f389921f), Integer.valueOf(this.f389920e), 1), e16);
            }
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void j(int i3, int i16) {
            A(c0.a(i3, 0));
            z(i16);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void k(int i3, k kVar) {
            A(c0.a(i3, 2));
            A(kVar.b());
            kVar.a(this);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void m(byte[] bArr, int i3) {
            A(i3);
            u(bArr, 0, i3);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void o(int i3, int i16) {
            A(c0.a(i3, i16));
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void p(int i3, String str) {
            A(c0.a(i3, 2));
            t(str);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void q(long j3) {
            try {
                byte[] bArr = this.f389919d;
                int i3 = this.f389921f;
                int i16 = i3 + 1;
                bArr[i3] = (byte) (((int) j3) & 255);
                int i17 = i16 + 1;
                bArr[i16] = (byte) (((int) (j3 >> 8)) & 255);
                int i18 = i17 + 1;
                bArr[i17] = (byte) (((int) (j3 >> 16)) & 255);
                int i19 = i18 + 1;
                bArr[i18] = (byte) (((int) (j3 >> 24)) & 255);
                int i26 = i19 + 1;
                bArr[i19] = (byte) (((int) (j3 >> 32)) & 255);
                int i27 = i26 + 1;
                bArr[i26] = (byte) (((int) (j3 >> 40)) & 255);
                int i28 = i27 + 1;
                bArr[i27] = (byte) (((int) (j3 >> 48)) & 255);
                this.f389921f = i28 + 1;
                bArr[i28] = (byte) (((int) (j3 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e16) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f389921f), Integer.valueOf(this.f389920e), 1), e16);
            }
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void r(e eVar) {
            A(eVar.size());
            eVar.a(this);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void s(l lVar) {
            A(lVar.b());
            lVar.a(this);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void t(String str) {
            int i3 = this.f389921f;
            try {
                int v3 = g.v(str.length() * 3);
                int v16 = g.v(str.length());
                if (v16 == v3) {
                    int i16 = i3 + v16;
                    this.f389921f = i16;
                    int a16 = b0.f389876a.a(str, this.f389919d, i16, this.f389920e - i16);
                    this.f389921f = i3;
                    A((a16 - i3) - v16);
                    this.f389921f = a16;
                } else {
                    A(b0.c(str));
                    byte[] bArr = this.f389919d;
                    int i17 = this.f389921f;
                    this.f389921f = b0.f389876a.a(str, bArr, i17, this.f389920e - i17);
                }
            } catch (b0.c e16) {
                this.f389921f = i3;
                l(str, e16);
            } catch (IndexOutOfBoundsException e17) {
                throw new c(e17);
            }
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void u(byte[] bArr, int i3, int i16) {
            try {
                System.arraycopy(bArr, i3, this.f389919d, this.f389921f, i16);
                this.f389921f += i16;
            } catch (IndexOutOfBoundsException e16) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f389921f), Integer.valueOf(this.f389920e), Integer.valueOf(i16)), e16);
            }
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void w(long j3) {
            A(c0.a(8, 0));
            y(j3);
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void x(int i3) {
            try {
                byte[] bArr = this.f389919d;
                int i16 = this.f389921f;
                int i17 = i16 + 1;
                bArr[i16] = (byte) (i3 & 255);
                int i18 = i17 + 1;
                bArr[i17] = (byte) ((i3 >> 8) & 255);
                int i19 = i18 + 1;
                bArr[i18] = (byte) ((i3 >> 16) & 255);
                this.f389921f = i19 + 1;
                bArr[i19] = (byte) ((i3 >> 24) & 255);
            } catch (IndexOutOfBoundsException e16) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f389921f), Integer.valueOf(this.f389920e), 1), e16);
            }
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void y(long j3) {
            if (g.f389914b) {
                int i3 = this.f389920e;
                int i16 = this.f389921f;
                if (i3 - i16 >= 10) {
                    long j16 = g.f389915c + i16;
                    while ((j3 & (-128)) != 0) {
                        nz4.a.d(this.f389919d, j16, (byte) ((((int) j3) & 127) | 128));
                        this.f389921f++;
                        j3 >>>= 7;
                        j16 = 1 + j16;
                    }
                    nz4.a.d(this.f389919d, j16, (byte) j3);
                    this.f389921f++;
                    return;
                }
            }
            while ((j3 & (-128)) != 0) {
                try {
                    byte[] bArr = this.f389919d;
                    int i17 = this.f389921f;
                    this.f389921f = i17 + 1;
                    bArr[i17] = (byte) ((((int) j3) & 127) | 128);
                    j3 >>>= 7;
                } catch (IndexOutOfBoundsException e16) {
                    throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f389921f), Integer.valueOf(this.f389920e), 1), e16);
                }
            }
            byte[] bArr2 = this.f389919d;
            int i18 = this.f389921f;
            this.f389921f = i18 + 1;
            bArr2[i18] = (byte) j3;
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void z(int i3) {
            if (i3 >= 0) {
                A(i3);
            } else {
                y(i3);
            }
        }

        @Override // com.xingin.xhssharesdk.a.g
        public final void h() {
        }
    }
}
